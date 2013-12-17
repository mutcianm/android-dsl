package ru.ifmo.rain.adsl.tests.functional;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ifmo.rain.adsl.Generator;
import ru.ifmo.rain.adsl.GeneratorSettings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class ContainerClassesTest extends BaseFunctionalTest {

    private final String classPath = "android.widget.GridLayout";
    private final File testDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/functional/ContainerClassesTest.kt");

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
        settings.setGenerateGetters(false);
        settings.setGenerateSetters(false);
        settings.setGenerateProperties(false);
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

