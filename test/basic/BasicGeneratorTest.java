package basic;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ifmo.rain.adsl.Generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class BasicGeneratorTest extends Assert {
    final String outFile = "out.kt";
    final String kotlincFilename = "lib/kotlinc/bin/kotlinc-jvm";
    final String inputJarFile = "android.jar";
    final String tmpJarFile = "out.jar";

    @BeforeMethod
    public void setUp() throws Exception {
        assertTrue(new File(inputJarFile).exists());
        assertTrue(new File("imports.txt").exists());
        assertTrue(new File("cont_header.txt").exists());
        assertTrue(new File("class_blacklist.txt").exists());
        assertTrue(new File("prop_blacklist.txt").exists());
        assertTrue(new File("footer.txt").exists());
        assertTrue(new File(kotlincFilename).exists());
    }

    @Test(dependsOnMethods = {"testResultExists"})
    public void testResultCompiles() throws Exception {
        String kotlincArgs[] = {kotlincFilename,
                "-jar", tmpJarFile,
                "-classpath", inputJarFile,
                outFile
        };
        Process p = Runtime.getRuntime().exec(kotlincArgs);
        BufferedReader br1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        while ((br1.readLine() != null) && (br2.readLine() != null)) {
            continue;
        }
        p.waitFor();
        assertEquals(p.exitValue(), 0);
    }

    @Test
    public void testResultExists() throws Exception {
        Generator gen = new Generator(new FileOutputStream(outFile), inputJarFile, "android.widget");
        gen.run();
        assertTrue(new File(outFile).length() > 0);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        new File(tmpJarFile).delete();
    }
}
