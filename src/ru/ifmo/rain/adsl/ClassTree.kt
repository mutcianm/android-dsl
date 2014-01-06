package ru.ifmo.rain.adsl

import java.util.ArrayList
import org.objectweb.asm.tree.ClassNode
import java.util.Queue
import java.util.ArrayDeque
import org.objectweb.asm.tree.MethodNode

class NoSuchClassException : Exception()

class ClassTreeNode(parent: ClassTreeNode?, data: ClassNode) {
    var parent: ClassTreeNode? = parent
    var children: MutableList<ClassTreeNode> = ArrayList()
    var data: ClassNode = data
}

class ClassTree : Iterable<ClassNode>{
    private val root = ClassTreeNode(null, ClassNode())
    private var lastQueryAncestor: ClassTreeNode = root
    private var cachedPropNode = root

    override fun iterator(): ClassTreeIterator {
        return ClassTreeIterator(root)
    }

    public fun add(_class: ClassNode) {
        val parent = findNode(root, _class.superName)
        val newNode: ClassTreeNode
        val orphans = getOrphansOf(_class.name!!)
        if (parent != null) {
            newNode = ClassTreeNode(parent, _class)
            parent.children.add(newNode)
        } else {
            newNode = ClassTreeNode(root, _class)
            root.children.add(newNode)
        }
        newNode.children.addAll(orphans)
        orphans.forEach { it.parent = newNode }
    }

    public fun isChildOf(_class: ClassNode, ancestorName: String): Boolean {
        val treeNode = findNode(root, _class)
        if (treeNode == null)
            throw NoSuchClassException()
        return treeNode.parent?.data?.name == ancestorName
    }

    public fun isSuccessorOf(_class: ClassNode, ancestorName: String): Boolean {
        val parent = findParent(ancestorName)
        val child = findNode(parent, _class.name!!)
        if ((child == null) || (child == parent))
            return false
        else
            return true
    }

    public fun findParentWithProperty(_class: ClassNode, property: String): ClassNode? {
        var node = if (cachedPropNode.data == _class) cachedPropNode
        else findNode(root, _class)
        if (node == null) {
            throw NoSuchClassException()
        } else {
            cachedPropNode = node!!
            while (node != root) {
                for (method in node!!.data.methods as List<MethodNode>) {
                    if (method.isProperty(property))
                        return node!!.data
                }
                node = node!!.parent
            }
        }
        return null
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

    private fun getOrphansOf(parentClassName: String): List<ClassTreeNode> {
        //hack? orphans seem to be present only in root node
        val res = root.children.partition { it.data.superName == parentClassName }
        root.children = res.second as MutableList<ClassTreeNode>
        return res.first
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

    public fun findNode(name: String?): ClassTreeNode? {
        return findNode(root, name)
    }

    private fun findNode(node: ClassTreeNode, _class: ClassNode): ClassTreeNode? {
        for (child in node.children) {
            if (child.data == _class) {
                return child
            } else {
                val ret = findNode(child, _class)
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
        nodeQueue.addAll(node.children);
        return node.data
    }

    override fun hasNext(): Boolean {
        return !nodeQueue.isEmpty()
    }

}