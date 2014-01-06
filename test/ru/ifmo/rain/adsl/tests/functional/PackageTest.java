package ru.ifmo.rain.adsl.tests.functional;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ifmo.rain.adsl.BaseGeneratorSettings;

import java.io.File;

public class PackageTest extends BaseFunctionalTest {

    private final String classPath = "android.widget.Checkbox";
    private final File testDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/functional/PackageTest.kt");

    @Override
    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
    }

    protected void initSettings(BaseGeneratorSettings settings) {
        settings.setGeneratePackage(true);
        settings.setGenerateImports(false);
        settings.setGenerateContainerBaseClass(false);
        settings.setGenerateContainerClasses(false);
        settings.setGenerateGetters(false);
        settings.setGenerateSetters(false);
        settings.setGenerateProperties(true);
        settings.setGenerateUIClass(false);
        settings.setGenerateUIClassWrapper(false);
        settings.setGenerateHelperConstructors(false);
    }

    @Test
    public void testPackage() throws Exception {
        runFunctionalTest(testDataFile, classPath, "properties");
    }
}

