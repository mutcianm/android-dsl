package ru.ifmo.rain.adsl.tests.functional;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ifmo.rain.adsl.Generator;
import ru.ifmo.rain.adsl.GeneratorSettings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class PropertiesTest extends BaseFunctionalTest {

    private final String classPath = "android.widget.TextView";
    private final File testDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/functional/PropertiesTest.kt");

    @Override
    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
        assertTrue(testDataFile.exists());
        generator = new Generator(new FileOutputStream(outFile), inputJarFile, classPath);
    }

    private void initSettings() {
        GeneratorSettings settings = new GeneratorSettings();
        settings.setGeneratePackage(false);
        settings.setGenerateImports(false);
        settings.setGenerateContainerBaseClass(false);
        settings.setGenerateContainerClasses(true);
        settings.setGenerateGetters(true);
        settings.setGenerateSetters(true);
        settings.setGenerateProperties(true);
        settings.setGenerateUIClass(false);
        settings.setGenerateUIClassWrapper(false);
        generator.setSettings(settings);
    }

    @Test
    public void testName() throws Exception {
        initSettings();
        generator.run();
        byte[] result = getMD5(new FileInputStream(outFile));
        byte[] pattern = getMD5(new FileInputStream(testDataFile));
        assertTrue(Arrays.equals(result, pattern));
    }
}

