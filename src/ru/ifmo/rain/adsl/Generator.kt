package ru.ifmo.rain.adsl;

import java.util.jar.JarEntry
import java.util.Enumeration
import java.util.jar.JarFile
import java.util.Collections
import org.objectweb.asm.*
import java.io.InputStream
import java.util.ArrayList
import java.util.TreeMap
import java.util.Arrays
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.InnerClassNode
import org.objectweb.asm.tree.MethodNode

open class DSLException(message: String = "") : Exception(message)
open class DSLGeneratorException(message: String = ""): DSLException(message)
class InvalidPropertyException(message: String = ""): DSLGeneratorException(message)
class NoListenerClassException(message: String = ""): DSLGeneratorException(message)


class Hook<T>(val predicate: ((_class: T) -> Boolean), val function: ((_class: T) -> Unit)) {
    public fun run(_class: T) {
        if (predicate(_class))
            function(_class)
    }

    public fun invoke(_class: T) {
        run(_class)
    }
}

class PropertyData(var parentClass: ClassNode,
                   var propName: String,
                   var propType: Type?,
                   var getter: MethodNode?,
                   var setter: MethodNode?,
                   var valueType: Type?,
                   val isContainer: Boolean)


class Generator(val jarPath: String, val packageName: String,
                val settings: BaseGeneratorSettings) {

    private val propMap = TreeMap<String, PropertyData>()

    private val classBlackList = settings.blackListedClasses
    private val propBlackList = settings.blacklistedProperties
    private val helperConstructors = settings.helperConstructors
    private val explicitlyProcessedClasses = settings.explicitlyProcessedClasses

    private val classTree: ClassTree = ClassTree()

    private val dslWriter = DSLWriter(settings, classTree)

    private val classHooks = Arrays.asList<Hook<ClassNode>>(
            Hook({
                isWidget(it) && !isBlacklistedClass(it) && !it.isAbstract() && !it.isInner() && !isContainer(it)
            }, { genWidget(it) }),
            Hook({
                !isBlacklistedClass(it) && !it.isAbstract() && !it.isInner() && isContainer(it)
            }, { genContainer(it) })
    )

    private val methodHooks = Arrays.asList<Hook<MethodNodeWithParent>>(
            Hook({
                isWidget(it.parent) && !isBlacklistedClass(it.parent) && it.child.isGetter() && !it.child.isProtected()
            }, { genGetter(it) }),
            Hook({
                isWidget(it.parent) && !isBlacklistedClass(it.parent) && it.child.isSetter() && !it.child.isProtected()
            }, { genSetter(it) }),
            Hook({
                it.child.name!!.startsWith("setOn") && it.child.name!!.endsWith("Listener") && !isBlacklistedClass(it.parent)
                }, { genListenerHelper(it) })
    )

    private fun isBlacklistedClass(classInfo: ClassNode): Boolean {
        return classInfo.cleanInternalName() in classBlackList
    }

    private fun isBlacklistedProperty(propertyName: String): Boolean {
        return propertyName in propBlackList
    }

    private fun isContainer(widget: ClassNode): Boolean {
        return classTree.isSuccessorOf(widget, settings.containerBaseClass)
    }

    public fun run() {
        for (classData in extractClasses(jarPath, packageName)) {
            classTree.add(processClassData(classData))
        }
        for (classInfo in classTree) {
            classInfo.methods!!.forEach { method ->
                methodHooks.forEach {
                    hook ->
                    hook(MethodNodeWithParent(classInfo, method))
                }
            }
            classHooks.forEach { hook -> hook(classInfo) }
        }

        produceProperties()
        dslWriter.write()
    }

    private fun produceProperties() {
        for (prop in propMap.values()) {
            if (!isBlacklistedProperty(prop.parentClass.cleanInternalName() + '.' + prop.propName))
                if (prop.getter != null && prop.propType?.getSort() != Type.VOID)
                    dslWriter.produceProperty(prop)
        }
    }


    private fun isWidget(classNode: ClassNode): Boolean {
        return classTree.isSuccessorOf(classNode, settings.widgetBaseClass) ||
                classNode.name in explicitlyProcessedClasses
    }

    private fun genListenerHelper(methodInfo: MethodNodeWithParent) {
        val listenerType = methodInfo.child.arguments!![0]
        val name = listenerType.getInternalName()
        val node = classTree.findNode(name)
        if (node == null)
            throw NoListenerClassException("Listener class $name not found")
        dslWriter.genListenerHelper(methodInfo, node.data)
    }

    private fun genSetter(methodInfo: MethodNodeWithParent) {
        if(methodInfo.parent.isAbstract() && isContainer(methodInfo.parent)) return
        if (!settings.generateSetters) return
        val property = PropertyData(methodInfo.parent, methodInfo.child.toProperty(), null, null,
                    methodInfo.child, methodInfo.child.arguments!![0],isContainer(methodInfo.parent))
        updateProperty(property)
    }

    private fun genGetter(methodInfo: MethodNodeWithParent) {
        if(methodInfo.parent.isAbstract() && isContainer(methodInfo.parent)) return
        if (!settings.generateGetters) return
        val property = PropertyData(methodInfo.parent, methodInfo.child.toProperty(),
                    methodInfo.child.getReturnType(), methodInfo.child, null, null, isContainer(methodInfo.parent))
        updateProperty(property)
    }

    private fun updateProperty(newProp: PropertyData) {
        val prop = propMap[newProp.parentClass.cleanInternalName()  + newProp.propName]
        if (prop != null) {
            with(prop) {
                setter = updateIfNotNull(setter, newProp.setter)
                getter = updateIfNotNull(getter, newProp.getter)
                valueType = updateIfNotNull(valueType, newProp.valueType)
                propType = updateIfNotNull(propType, newProp.propType)
            }
        } else {
            propMap[newProp.parentClass.cleanInternalName()  + newProp.propName] = newProp
        }
    }


    private fun getHelperConstructors(classNode: ClassNode): List<List<PropertyData>> {
        val constructors: List<List<String>>? = helperConstructors.get(classNode.cleanInternalName())
        val res = ArrayList<ArrayList<PropertyData>>()
        val defaultConstructor = ArrayList<PropertyData>()
        res.add(defaultConstructor)
        val className = classNode.cleanInternalName()
        if (constructors == null || !settings.generateHelperConstructors) {
            return res
        } else {
            for (constructor in constructors) {
                val cons = ArrayList<PropertyData>()
                for (argument in constructor) {
                    val _class = classTree.findParentWithProperty(classNode, argument)
                    if (_class == null)
                        throw InvalidPropertyException("Property $argument is not in $className hierarchy")
                    val property = propMap.get(_class.cleanInternalName() + argument)
                    if (property == null)
                        throw InvalidPropertyException("Property $argument in not a member of $className")
                    if (property.valueType == null)
                        throw InvalidPropertyException("Property $argument is read-only in $className")
                    cons.add(property)
                }
                res.add(cons)
            }
            return res
        }
    }

    private fun genWidget(classNode: ClassNode) {
        val cleanNameDecap = classNode.cleanNameDecap()
        val cleanInternalName = classNode.cleanInternalName()
        val constructors = getHelperConstructors(classNode)
        for (constructor in constructors) {
            dslWriter.makeWidget(classNode, cleanNameDecap, cleanInternalName, constructor)
        }
    }

    private fun genContainer(classNode: ClassNode) {
        if (classNode.signature != null)
            println("${classNode.name} : ${classNode.signature}")
        genContainerWidgetFun(classNode)
        dslWriter.genContainerClass(classNode, extractLayoutParams(classNode))
        dslWriter.genUIWidgetFun(classNode)
    }

    private fun extractLayoutParams(viewGroup: ClassNode): ClassNode? {
        if (viewGroup.innerClasses == null)
            return null
        val innerClasses = (viewGroup.innerClasses as List<InnerClassNode>)
        val lp = innerClasses.find { it.name!!.contains("LayoutParams") }
        return classTree.findNode(lp?.name)?.data
    }

    private fun genContainerWidgetFun(classNode: ClassNode) {
        val cleanNameDecap = classNode.cleanNameDecap()
        val cleanName = classNode.cleanName()
        val cleanInternalName = classNode.cleanInternalName()
        dslWriter.makeContainerWidgetFun(classNode, cleanNameDecap, cleanName, cleanInternalName)
    }

    private fun processClassData(classData: InputStream?): ClassNode {
        val cn = ClassNode()
        try {
            val cr = ClassReader(classData)
            cr.accept(cn, 0)
        } catch (e: Exception) {
            //optionally log something here
        } finally {
            classData?.close()
        }
        return cn
    }


    private fun extractClasses(jarPath: String, packageName: String): Iterator<InputStream> {
//        val packageName = packageName.replace('.', '/')
        val jarFile = JarFile(jarPath)
        return Collections.list(jarFile.entries() as Enumeration<JarEntry>)
                .iterator()
                .filter {
//            (it.getName().startsWith(packageName) || it.getName() in explicitlyProcessedClasses) &&
            it.getName().endsWith(".class")
        }.map {
            jarFile.getInputStream(it)!!
        }
    }

}




