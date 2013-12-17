package ru.ifmo.rain.adsl.tests.functional;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.ifmo.rain.adsl.Generator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BaseFunctionalTest extends Assert {
    protected final String outFile = this.getClass() + "out.kt";
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

    @AfterMethod
    public void tearDown() throws Exception {
        new File(outFile).delete();
    }
}
