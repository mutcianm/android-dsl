package ru.ifmo.rain.adsl.tests.functional;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.ifmo.rain.adsl.AdslPackage;
import ru.ifmo.rain.adsl.Generator;

import java.io.*;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class BaseFunctionalTest extends Assert {
    protected File outFile;
    protected final String inputJarFile = "android.jar";
    protected Generator generator;

    @BeforeMethod
    public void setUp() throws Exception {
        assertTrue(new File(inputJarFile).exists());
        assertTrue(new File("imports.txt").exists());
        assertTrue(new File("cont_header.txt").exists());
        assertTrue(new File("class_blacklist.txt").exists());
        assertTrue(new File("prop_blacklist.txt").exists());
        assertTrue(new File("footer.txt").exists());
    }

    protected byte[] getMD5(InputStream in) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        DigestInputStream dis = new DigestInputStream(in, md);
        while (dis.read() > 0) {
        }
        return md.digest();
    }

    protected String loadOrCreate(File file, String data) throws IOException {
        try {
            return AdslPackage.readFile(file.getAbsolutePath());
        } catch (Exception e) {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(data);
            fileWriter.close();
            fail("Empty expected data, creating from actual");
            return data;
        }
    }

    protected void runFunctionalTest(File testDataFile, String classPath) throws IOException {
        outFile = File.createTempFile(testDataFile.getName().substring(0,
                testDataFile.getName().lastIndexOf(".")), "kt");
        generator = new Generator(new FileOutputStream(outFile), inputJarFile, classPath);
        initSettings();
        generator.run();

        String actual = AdslPackage.readFile(outFile.getAbsolutePath());
        String expected = loadOrCreate(testDataFile, actual);

        assertEquals(actual, expected);
        outFile.delete();
    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    protected abstract void initSettings();
}
