package ru.ifmo.rain.adsl.tests.functional;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ifmo.rain.adsl.AdslPackage;
import ru.ifmo.rain.adsl.Generator;
import ru.ifmo.rain.adsl.GeneratorSettings;

import java.io.File;
import java.io.FileOutputStream;

public class ImportsTest extends BaseFunctionalTest {

    private final String classPath = "android.widget.Button";
    private final File testDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/functional/ImportsTest.kt");

    @Override
    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
        generator = new Generator(new FileOutputStream(outFile), inputJarFile, classPath);
    }

    private void initSettings() {
        GeneratorSettings settings = new GeneratorSettings();
        settings.setGeneratePackage(false);
        settings.setGenerateImports(true);
        settings.setGenerateContainerBaseClass(false);
        settings.setGenerateContainerClasses(false);
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

        String actual = AdslPackage.readFile(outFile);
        String expected = loadOrCreate(testDataFile, actual);

        assertEquals(actual, expected);
    }
}

