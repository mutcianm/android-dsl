package ru.ifmo.rain.adsl

import org.objectweb.asm.*

class AdslVisitor(api: Int) : ClassVisitor {

    public var classInfo: ClassInfo? = null

    override fun visitAnnotation(p0: String?, p1: Boolean): AnnotationVisitor? {
        return null
    }

    override fun visitAttribute(p0: Attribute?) {
        return
    }

    override fun visitEnd() {
        return
    }

    override fun visitField(p0: Int, p1: String?, p2: String?, p3: String?, p4: Any?): FieldVisitor? {
        return null
    }

    override fun visitInnerClass(p0: String?, p1: String?, p2: String?, p3: Int) {
        return
    }

    override fun visitOuterClass(p0: String?, p1: String?, p2: String?) {
        return
    }

    override fun visitSource(p0: String?, p1: String?) {
        return
    }

    override fun visit(version: Int, access: Int, name: String?, signature: String?, supername: String?, exceptions: Array<out String>?) {
        assert(classInfo == null, "classInfo not null, visiting class more than once?")
        classInfo = ClassInfo(access, name!!, signature, supername, exceptions)


        //        className = cleanInternalName(name!!)
        //        if (isBlacklistedClass(className))
        //            throw IgnoredClassEx()
        //        if ((access and Opcodes.ACC_ABSTRACT) != 0)
        //            return
        //        if (!isInnerClass(name))
        //            genContainerFun(className)
    }

    override fun visitMethod(access: Int, name: String?, desc: String?, signature: String?, exceptions: Array<out String>?): MethodVisitor? {
        assert(classInfo != null, "Method visitor called before class visitor")
        //asserts should also count as null checks perhaps?
        classInfo!!.methods += MethodInfo(access, name!!, desc!!, signature, exceptions)

        //        if ((access and Opcodes.ACC_PROTECTED) != 0)
        //            return null
        //        if (name != null && name.startsWith("set") && Type.getArgumentTypes(desc)?.size == 1) {
        //            genSetter(className, name.substring(3), name, Type.getArgumentTypes(desc)!![0])
        //        } else if (name != null && name.startsWith("get") && Type.getArgumentTypes(desc)?.size == 0) {
        //            genGetter(className, name.substring(3), name, Type.getReturnType(desc))
        //        }
        return null
    }
}
