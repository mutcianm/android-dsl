package ru.ifmo.rain.adsl.tests.android;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ifmo.rain.adsl.Generator;

import java.io.File;
import java.io.FileOutputStream;

public class AndroidSimpleTest extends BaseCompileTest {

    final String outFile = this.getClass() + "out.kt";
    private final File testDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/android/AndroidSimpleTest.kt");

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
        assertTrue(testDataFile.exists());
    }

    @Test
    public void testResultCompiles() throws Exception {
        Generator gen = new Generator(new FileOutputStream(outFile), inputJarFile, "android.widget");
        gen.run();
        String kotlincArgs[] = {kotlincFilename,
                "-jar", tmpJarFile,
                "-classpath", inputJarFile,
                outFile, testDataFile.getPath()
        };
        assertEquals(compile(kotlincArgs), 0);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        super.tearDown();
        new File(outFile).delete();
    }
}
