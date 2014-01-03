package ru.ifmo.rain.adsl.tests.functional;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ifmo.rain.adsl.GeneratorSettings;

import java.io.File;

public class HelperConstructorTest extends BaseFunctionalTest {
    private final String classPath = "android.widget.";
    private final File testDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/functional/HelperConstructorTest.kt");

    @Override
    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
    }

    protected void initSettings() {
        GeneratorSettings settings = new GeneratorSettings();
        settings.setGeneratePackage(false);
        settings.setGenerateImports(false);
        settings.setGenerateContainerBaseClass(true);
        settings.setGenerateContainerClasses(false);
        settings.setGenerateGetters(true);
        settings.setGenerateSetters(true);
        settings.setGenerateProperties(true);
        settings.setGenerateUIClass(false);
        settings.setGenerateUIClassWrapper(false);
        settings.setGenerateHelperConstructors(true);
        generator.setSettings(settings);
    }

    @Test
    public void testHelperConstructors() throws Exception {
        runFunctionalTest(testDataFile, classPath);
    }
}
