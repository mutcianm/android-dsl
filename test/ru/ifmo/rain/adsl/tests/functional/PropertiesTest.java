package ru.ifmo.rain.adsl.tests.functional;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ifmo.rain.adsl.BaseGeneratorSettings;
import ru.ifmo.rain.adsl.Subsystems;

import java.io.File;

public class PropertiesTest extends BaseFunctionalTest {

    private final String classPath = "android.widget.TextView";
    private final File testDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/functional/PropertiesTest.kt");

    @Override
    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
    }

    protected void initSettings(BaseGeneratorSettings settings) {
        settings.setGeneratePackage(false);
        settings.setGenerateImports(false);
        settings.setGenerateContainerBaseClass(false);
        settings.setGenerateContainerClasses(true);
        settings.setGenerateGetters(true);
        settings.setGenerateSetters(true);
        settings.setGenerateProperties(true);
        settings.setGenerateUIClass(false);
        settings.setGenerateUIClassWrapper(false);
    }

    @Test
    public void testProperties() throws Exception {
        runFunctionalTest(testDataFile, classPath, Subsystems.PROPERTIES);
    }
}

