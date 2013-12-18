package ru.ifmo.rain.adsl

import java.util.ArrayList
import org.objectweb.asm.tree.ClassNode
import java.util.Queue
import java.util.ArrayDeque

class NoSuchClassException : Exception()

class ClassTreeNode(val parent: ClassTreeNode?, val data: ClassNode) {
    val children = ArrayList<ClassTreeNode>()
}

class ClassTree : Iterable<ClassNode> {
    private val root = ClassTreeNode(null, ClassNode())
    private var lastQueryAncestor = root

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

    public fun isChildOf(_class: ClassNode, ancestorName: String): Boolean {
        val parent = findParent(ancestorName)
        return findChildByName(parent, _class.name!!)
    }

    public fun isSuccessorOf(_class: ClassNode, ancestorName: String): Boolean {
        val parent = findParent(ancestorName)
        val child = findNode(parent, _class.name!!)
        if ((child == null) || (child == parent))
            return false
        else
            return true
    }

    private fun findParent(name: String): ClassTreeNode {
        //use cached parent node from last call
        val parent = if (lastQueryAncestor.data.name == name) lastQueryAncestor
        else findNode(root, name)
        if (parent == null) {
            throw NoSuchClassException()
        } else {
            lastQueryAncestor = parent
            return parent
        }
    }

    private fun findChildByName(parent: ClassTreeNode, childName: String): Boolean {
        for (child in parent.children) {
            if (child.data.name == childName)
                return true
        }
        return false
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