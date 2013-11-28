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
    }

    override fun visitMethod(access: Int, name: String?, desc: String?, signature: String?, exceptions: Array<out String>?): MethodVisitor? {
        assert(classInfo != null, "Method visitor called before class visitor")
        //asserts should also count as null checks perhaps?
        classInfo!!.methods += MethodInfo(classInfo!!, access, name!!, desc!!, signature, exceptions)
        return null
    }
}
