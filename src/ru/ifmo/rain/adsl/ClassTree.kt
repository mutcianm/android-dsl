package ru.ifmo.rain.adsl

import java.util.ArrayList
import org.objectweb.asm.tree.ClassNode
import java.util.Queue
import java.util.ArrayDeque

class NoSuchClassEx : Exception()

class ClassTreeNode(parent: ClassTreeNode?, data: ClassNode) {
    val parent: ClassTreeNode? = parent
    var children: ArrayList<ClassTreeNode> = ArrayList()
    var data: ClassNode = data
}

class ClassTree : Iterable<ClassNode>{
    val root = ClassTreeNode(null, ClassNode())

    override fun iterator(): ClassTreeIterator {
        return ClassTreeIterator(root)
    }
    public fun add(_class: ClassNode) {
        val node = findNode(root, _class.superName)
        if (node != null) {
            node.children.add(ClassTreeNode(node, _class))
        } else {
            root.children.add(ClassTreeNode(root, _class))
        }
    }

    public fun isSuccessorOf(_class: ClassNode, ancestorName: String): Boolean {
        val parent = findNode(root, ancestorName)
        if (parent == null) {
            throw NoSuchClassEx()
        } else {
            val child = findNode(parent, _class.name!!)
            if ((child == null) || (child == parent))
                return false
            else
                return true
        }
    }

    //performance: rewrite search as downtop-bfs
    private fun findNode(node: ClassTreeNode, name: String?): ClassTreeNode? {
        if (name == null) return null
        for (child in node.children) {
            if (child.data.name == name) {
                return child
            } else {
                val ret = findNode(child, name)
                if (ret != null)
                    return ret
            }
        }
        return null
    }
}

class ClassTreeIterator(var next: ClassTreeNode) : Iterator<ClassNode> {

    var nodeQueue: Queue<ClassTreeNode> = ArrayDeque(next.children)

    override fun next(): ClassNode {
        val node: ClassTreeNode = nodeQueue.element()
        nodeQueue.remove()
        for (child in node.children) {
            nodeQueue.add(child)
        }
        return node.data
    }

    override fun hasNext(): Boolean {
        return !nodeQueue.isEmpty()
    }

}