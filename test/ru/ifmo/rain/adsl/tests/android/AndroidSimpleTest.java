package ru.ifmo.rain.adsl.tests.android;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ifmo.rain.adsl.Generator;

import java.io.File;
import java.io.FileOutputStream;

public class AndroidSimpleTest extends BaseCompileTest {

    private final File testDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/android/AndroidSimpleTest.kt");

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
        assertTrue(testDataFile.exists());
    }

    @Test(dependsOnMethods = {"testResultExists"})
    public void testResultCompiles() throws Exception {
        String kotlincArgs[] = {kotlincFilename,
                "-jar", tmpJarFile,
                "-classpath", inputJarFile,
                outFile, testDataFile.getPath()
        };
        assertEquals(compile(kotlincArgs), 0);
    }

    @Test
    public void testResultExists() throws Exception {
        Generator gen = new Generator(new FileOutputStream(outFile), inputJarFile, "android.widget");
        gen.run();
        assertTrue(new File(outFile).length() > 0);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
