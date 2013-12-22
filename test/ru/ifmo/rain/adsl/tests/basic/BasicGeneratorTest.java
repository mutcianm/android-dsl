package ru.ifmo.rain.adsl.tests.basic;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ifmo.rain.adsl.Generator;

import java.io.*;

public class BasicGeneratorTest extends Assert {

    private final String kotlincFilename = "lib/kotlinc/bin/kotlinc-jvm";
    private final String inputJarFile = "android.jar";
    private final String tmpJarFile = this.getClass() + "out.jar";

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

    protected ProcResult compile(String[] args) throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec(args);
        BufferedReader br1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        StringBuilder errors = new StringBuilder();
        String str;
        while (((str = br1.readLine()) != null) && (br2.readLine() != null)) {
            if (str.startsWith("ERROR"))
                errors.append(str);
        }
        p.waitFor();
        return new ProcResult(errors.toString(), p.exitValue());
    }

    @Test
    public void testResultCompiles() throws Exception {
        File outFile = File.createTempFile("testResultCompiles", ".kt");
//        outFile.deleteOnExit();
        Generator gen = new Generator(new FileOutputStream(outFile), inputJarFile, "android.widget");
        gen.run();
        String kotlincArgs[] = {kotlincFilename,
                "-jar", tmpJarFile,
                "-classpath", inputJarFile,
                outFile.getAbsolutePath()
        };
        ProcResult res = compile(kotlincArgs);
        assertEquals(res.stderr, "");
//        assertEquals(res.exitCode, 0);
        outFile.delete();
    }

    @Test
    public void testResultExists() throws Exception {
        File outFile = File.createTempFile("testResultExists", ".kt");
//        outFile.deleteOnExit();
        Generator gen = new Generator(new FileOutputStream(outFile), inputJarFile, "android.widget");
        gen.run();
        assertTrue(outFile.length() > 0);
        outFile.delete();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        new File(tmpJarFile).delete();
    }

    class ProcResult {
        public String stderr;
        public int exitCode;

        ProcResult(String stderr, int exitCode) {
            this.stderr = stderr;
            this.exitCode = exitCode;
        }
    }
}
