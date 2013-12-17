package ru.ifmo.rain.adsl.tests.android;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaseCompileTest extends Assert {
    final String kotlincFilename = "lib/kotlinc/bin/kotlinc-jvm";
    final String inputJarFile = "android.jar";
    final String tmpJarFile = this.getClass() + "out.jar";

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

    protected int compile(String[] args) throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec(args);
        BufferedReader br1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        while ((br1.readLine() != null) && (br2.readLine() != null)) {
            continue;
        }
        p.waitFor();
        return p.exitValue();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        new File(tmpJarFile).delete();
    }
}
