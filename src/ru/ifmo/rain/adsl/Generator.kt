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
import org.objectweb.asm.tree.MethodNode
import org.objectweb.asm.tree.InnerClassNode
import java.util.HashSet

class IgnoredClassException : Exception()


class Hook<T>(val predicate: ((_class: T) -> Boolean), val function: ((_class: T) -> Unit)) {
    public fun run(_class: T) {
        if (predicate(_class))
            function(_class)
    }

    public fun invoke(_class: T) {
        run(_class)
    }
}

class PropertyData(var className: String,
                   var propName: String,
                   var propType: Type?,
                   var getter: String?,
                   var setter: String?,
                   var valueType: Type?)

fun typeMap(str: String): String {
    return when (str) {
        "java.lang.CharSequence" -> "jet.CharSequence"
        "java.lang.String" -> "jet.String"
        "java.lang.Integer" -> "jet.Int"
        "java.lang.Object" -> "jet.Any"
        else -> str
    }
}

class Generator(val jarPath: String, val packageName: String,
                val settings: BaseGeneratorSettings) {

    private val dslWriter = DSLWriter(settings)

    private val propMap = TreeMap<String, PropertyData>()

    private val classBlackList = settings.blackListedClasses
    private val propBlackList = settings.blacklistedProperties
    private val helperConstructors = settings.helperConstructors
    private val explicitlyProcessedClasses = settings.explicitlyProcessedClasses

    private val classTree: ClassTree = ClassTree()

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
                (isWidget(it.parent) || isContainer(it.parent)) && it.child.isGetter() && !it.child.isProtected() && !it.parent.isGeneric() && !it.child.isGeneric()
            }, { genGetter(it) }),
            Hook({
                (isWidget(it.parent) || isContainer(it.parent))&& it.child.isSetter() && !it.child.isProtected() && !it.parent.isGeneric() && !it.child.isGeneric()
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
        val vg = ClassNode()
        vg.name = settings.containerBaseClass
        classTree.add(vg)
        for (classData in extractClasses(jarPath, packageName)) {
            classTree.add(processClassData(classData))
        }
        for (classInfo in classTree) {
            classInfo.methods!!.forEach { method ->
                methodHooks.forEach {
                    hook ->
                    hook(MethodNodeWithParent(classInfo, method as MethodNode))
                }
            }
            classHooks.forEach { hook -> hook(classInfo) }
        }

        produceProperties()
        dslWriter.write()
    }

    private fun produceProperties() {
        for (prop in propMap.values()) {
            if (!isBlacklistedProperty(prop.className + '.' + prop.propName))
                if (prop.getter != null && prop.propType?.getSort() != Type.VOID)
                    dslWriter.produceProperty(prop)
        }
    }


    private fun isWidget(classNode: ClassNode): Boolean {
        return classTree.isSuccessorOf(classNode, "android/view/View") ||
                classNode.name in explicitlyProcessedClasses
    }

    private fun genListenerHelper(methodInfo: MethodNodeWithParent) {
        val listenerType: Type = methodInfo.child.arguments!![0]
        val name = listenerType.getInternalName()
        val node = classTree.findNode(name)
        if (node == null)
            throw RuntimeException("Listener class $name not found")
        dslWriter.genListenerHelper(methodInfo, node.data)
    }

    private fun preProcessProperty(prop: PropertyData, context: MethodNodeWithParent): PropertyData {
        if (isContainer(context.parent)) {
            prop.className = "_" + context.parent.cleanName()
            if (prop.setter != null)
                prop.setter = "(vgInstance as " + context.parent.cleanInternalName() + ")." + prop.setter
            if (prop.getter != null)
                prop.getter = "(vgInstance as " + context.parent.cleanInternalName() + ")." + prop.getter
        }
        return prop
    }

    private fun genSetter(methodInfo: MethodNodeWithParent) {
        if (!settings.generateSetters) return
        val property = preProcessProperty(PropertyData(methodInfo.parent.cleanInternalName(), methodInfo.child.toProperty(), null, null,
                    methodInfo.child.name, methodInfo.child.arguments!![0]),
                methodInfo)
        updateProperty(property)
    }

    private fun genGetter(methodInfo: MethodNodeWithParent) {
        if (!settings.generateGetters) return
        val property = preProcessProperty(PropertyData(methodInfo.parent.cleanInternalName(), methodInfo.child.toProperty(),
                    methodInfo.child.getReturnType(), methodInfo.child.name, null, null),
                methodInfo)
        updateProperty(property)
    }

    private fun updateProperty(newProp: PropertyData) {
        val prop = propMap[newProp.className + newProp.propName]
        if (prop != null) {
            prop.setter = if (prop.setter == null) newProp.setter else prop.setter
            prop.getter = if (prop.getter == null) newProp.getter else prop.getter
            prop.valueType = if (prop.valueType == null) newProp.valueType else prop.valueType
            prop.propType = if (prop.propType == null) newProp.propType else prop.propType
        } else {
            propMap[newProp.className + newProp.propName] = newProp
        }
    }


    private fun getConstructors(classNode: ClassNode): List<List<PropertyData>> {
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
                        throw RuntimeException("Property $argument is not in $className hierarchy")
                    val property = propMap.get(_class.cleanInternalName() + argument)
                    if (property == null)
                        throw RuntimeException("Property $argument in not a member of $className")
                    if (property.valueType == null)
                        throw RuntimeException("Property $argument is read-only in $className")
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
        val constructors = getConstructors(classNode)
        for (constructor in constructors) {
            dslWriter.makeWidget(cleanNameDecap, cleanInternalName, constructor)
        }
    }

    private fun genContainer(classNode: ClassNode) {
        genContainerWidgetFun(classNode)
        dslWriter.genContainerClass(classNode, extractLayoutParams(classNode))
        dslWriter.genUIWidgetFun(classNode)
    }

    private fun extractLayoutParams(viewGroup: ClassNode): ClassNode? {
        if (viewGroup.innerClasses == null)
            throw RuntimeException("ViewGroup must have a LayoutParams inner class")
        val innerClasses = (viewGroup.innerClasses as List<InnerClassNode>)
        val lp = innerClasses.find { it.name!!.contains("LayoutParams") }
        if (lp == null) {
//            System.err.println("ViewGroup " + viewGroup.cleanInternalName() + " has no layoutParams")
            return null
        } else {
//            System.out.println(viewGroup.name + ":" + lp.name)
            return classTree.findNode(lp.name)!!.data
        }
    }

    private fun genContainerWidgetFun(classNode: ClassNode) {
        val cleanNameDecap = classNode.cleanNameDecap()
        val cleanName = classNode.cleanName()
        val cleanInternalName = classNode.cleanInternalName()
        dslWriter.makeContainerWidgetFun(cleanNameDecap, cleanName, cleanInternalName)
    }

    private fun processClassData(classData: InputStream?): ClassNode {
        val cn = ClassNode()
        try {
            val cr = ClassReader(classData)
            cr.accept(cn, 0)
        } catch (e: IgnoredClassException) {
            //optionally log something here
        } finally {
            classData?.close()
        }
        return cn
    }


    private fun extractClasses(jarPath: String, packageName: String): Iterator<InputStream> {
        val packageName = packageName.replace('.', '/')
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




