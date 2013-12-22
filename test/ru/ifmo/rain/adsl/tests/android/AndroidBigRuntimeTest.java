package ru.ifmo.rain.adsl.tests.android;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ifmo.rain.adsl.Generator;

import java.io.File;
import java.io.FileOutputStream;

public class AndroidBigRuntimeTest extends BaseCompileTest {

    private final File testLayoutsDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/android/AndroidLayoutsTest.kt");
    private final File testPropertiesDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/android/AndroidPropertiesTest.kt");
    private final File testSimpleDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/android/AndroidSimpleTest.kt");
    private final File testWidgetsDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/android/AndroidWidgetTest.kt");

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
        assertTrue(testLayoutsDataFile.exists());
        assertTrue(testPropertiesDataFile.exists());
        assertTrue(testSimpleDataFile.exists());
        assertTrue(testWidgetsDataFile.exists());
    }

    @Test
    public void testProperties() throws Exception {
        File outFile = File.createTempFile("testProperties", ".kt");
//        outFile.deleteOnExit();
        Generator gen = new Generator(new FileOutputStream(outFile), inputJarFile, "android.widget");
        gen.run();
        String kotlincArgs[] = {kotlincFilename,
                "-jar", tmpJarFile,
                "-classpath", inputJarFile,
                outFile.getAbsolutePath(), testPropertiesDataFile.getPath()
        };
        ProcResult res = compile(kotlincArgs);
        assertEquals(res.stderr, "");
//        assertEquals(res.exitCode, 0);
        outFile.delete();
    }

    @Test
    public void testSimple() throws Exception {
        File outFile = File.createTempFile("testSimple", ".kt");
//        outFile.deleteOnExit();
        Generator gen = new Generator(new FileOutputStream(outFile), inputJarFile, "android.widget");
        gen.run();
        String kotlincArgs[] = {kotlincFilename,
                "-jar", tmpJarFile,
                "-classpath", inputJarFile,
                outFile.getAbsolutePath(), testSimpleDataFile.getPath()
        };
        ProcResult res = compile(kotlincArgs);
        assertEquals(res.stderr, "");
//        assertEquals(res.exitCode, 0);
        outFile.delete();
    }

    @Test
    public void testWidgets() throws Exception {
        File outFile = File.createTempFile("testWidgets", ".kt");
//        outFile.deleteOnExit();
        Generator gen = new Generator(new FileOutputStream(outFile), inputJarFile, "android.widget");
        gen.run();
        String kotlincArgs[] = {kotlincFilename,
                "-jar", tmpJarFile,
                "-classpath", inputJarFile,
                outFile.getAbsolutePath(), testWidgetsDataFile.getPath()
        };
        ProcResult res = compile(kotlincArgs);
        assertEquals(res.stderr, "");
//        assertEquals(res.exitCode, 0);
        outFile.delete();
    }

    @Test
    public void testLayouts() throws Exception {
        File outFile = File.createTempFile("testLayouts", ".kt");
//        outFile.deleteOnExit();
        Generator gen = new Generator(new FileOutputStream(outFile), inputJarFile, "android.widget");
        gen.run();
        String kotlincArgs[] = {kotlincFilename,
                "-jar", tmpJarFile,
                "-classpath", inputJarFile,
                outFile.getAbsolutePath(), testLayoutsDataFile.getPath()
        };
        ProcResult res = compile(kotlincArgs);
        assertEquals(res.stderr, "");
//        assertEquals(res.exitCode, 0);
        outFile.delete();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        super.tearDown();
//        new File(outFile).delete();
    }
}
