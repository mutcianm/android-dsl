import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ifmo.rain.adsl.Generator;

import java.io.File;
import java.io.FileOutputStream;

public class BasicGeneratorTest extends Assert {
    String outFile;
    String kotlincFilename;

    @BeforeMethod
    public void setUp() throws Exception {
        assertTrue(new File("android.jar").exists());
        assertTrue(new File("imports.txt").exists());
        assertTrue(new File("cont_header.txt").exists());
        assertTrue(new File("class_blacklist.txt").exists());
        assertTrue(new File("prop_blacklist.txt").exists());

        kotlincFilename = "lib/kotlinc/bin/kotlinc-jvm";
        assertTrue(new File(kotlincFilename).exists());
        outFile = "out.kt";
    }

    @Test(dependsOnMethods = {"testResultExists"})
    public void testResultCompiles() throws Exception {
        String kotlincArgs[] = {kotlincFilename,
                "-module",
                "out/production/adslGenerator/script.xml",
                outFile};
        Process p = Runtime.getRuntime().exec(kotlincArgs);
        p.waitFor();
        assertEquals(p.exitValue(), 0);
    }

    @Test
    public void testResultExists() throws Exception {
        Generator gen = new Generator(new FileOutputStream(outFile), "android.jar", "android.widget");
        gen.run();
        assertTrue(new File(outFile).length() > 0);
    }

    @AfterMethod
    public void tearDown() throws Exception {


    }
}
