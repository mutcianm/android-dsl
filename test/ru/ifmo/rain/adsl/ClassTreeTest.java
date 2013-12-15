package ru.ifmo.rain.adsl;

import jet.runtime.typeinfo.KotlinSignature;
import org.objectweb.asm.tree.ClassNode;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: miha
 * Date: 12/13/13
 * Time: 8:16 PM
 */
public class ClassTreeTest extends Assert {

    private final ArrayList<ClassNode> classes = new ArrayList<>();

    @BeforeMethod
    public void setUp() throws Exception {
        for (int i = 0; i < 4; ++i) {
            classes.add(new ClassNode());
        }
        classes.get(0).name = "java.lang.Object";
        classes.get(0).superName = null;
        classes.get(1).name = "java.lang.Integer";
        classes.get(1).superName = "java.lang.Object";
        classes.get(2).name = "com.example.A";
        classes.get(2).superName = "java.lang.Object";
        classes.get(3).name = "com.example.B";
        classes.get(3).superName = "com.example.A";
    }

    private void doAdd(ClassTree target) {
        for (ClassNode aClass : classes) {
            target.add(aClass);
        }
    }

    @Test
    public void testAdd() throws Exception {
        ClassTree tree = new ClassTree();
        doAdd(tree);
    }

    @Test
    public void testIsChild() throws Exception {
        ClassTree tree = new ClassTree();
        doAdd(tree);
        assertTrue(tree.isChildOf(classes.get(1), "java.lang.Object"));
        assertTrue(tree.isChildOf(classes.get(2), "java.lang.Object"));
        assertFalse(tree.isChildOf(classes.get(3), "java.lang.Object"));
    }

    @Test
    public void testTree() throws Exception {
        ClassTree tree = new ClassTree();
        doAdd(tree);
        assertTrue(tree.isSuccessorOf(classes.get(1), "java.lang.Object"));
        assertTrue(tree.isSuccessorOf(classes.get(2), "java.lang.Object"));
        assertTrue(tree.isSuccessorOf(classes.get(3), "com.example.A"));
        assertTrue(tree.isSuccessorOf(classes.get(3), "java.lang.Object"));
        assertFalse(tree.isSuccessorOf(classes.get(3), "java.lang.Integer"));
        assertFalse(tree.isSuccessorOf(classes.get(2), "com.example.B"));
        assertFalse(tree.isSuccessorOf(classes.get(2), "java.lang.Integer"));
        assertFalse(tree.isSuccessorOf(classes.get(0), "java.lang.Object"));
    }

    @Test(expectedExceptions = NoSuchClassEx.class)
    public void testNoSuchClassException() throws Exception {
        ClassTree tree = new ClassTree();
        ClassNode cn = new ClassNode();
        cn.name = "java.lang.Integer";
        tree.isSuccessorOf(cn, "java.util.List");
    }

    @Test
    public void testTreeIterator() throws Exception {
        ClassTree tree = new ClassTree();
        doAdd(tree);
        int arrayElementCount = classes.size();
        int treeElementCount = 0;
        ClassTreeIterator it = tree.iterator();
        while (it.hasNext()) {
            ClassNode c = it.next();
            assertTrue(classes.contains(c));
            ++treeElementCount;
        }
        assertEquals(arrayElementCount, treeElementCount);
    }

}
