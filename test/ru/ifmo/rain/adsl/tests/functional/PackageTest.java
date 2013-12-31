package ru.ifmo.rain.adsl.tests.functional;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ifmo.rain.adsl.GeneratorSettings;

import java.io.File;

public class PackageTest extends BaseFunctionalTest {

    private final String classPath = "android.widget.Button";
    private final File testDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/functional/PackageTest.kt");

    @Override
    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
    }

    protected void initSettings() {
        GeneratorSettings settings = new GeneratorSettings();
        settings.setGeneratePackage(true);
        settings.setGenerateImports(false);
        settings.setGenerateContainerBaseClass(false);
        settings.setGenerateContainerClasses(false);
        settings.setGenerateGetters(false);
        settings.setGenerateSetters(false);
        settings.setGenerateProperties(false);
        settings.setGenerateUIClass(false);
        settings.setGenerateUIClassWrapper(false);
        settings.setGenerateHelperConstructors(false);
        generator.setSettings(settings);
    }

    @Test
    public void testPackage() throws Exception {
        runFunctionalTest(testDataFile, classPath);
    }
}

