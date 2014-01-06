package ru.ifmo.rain.adsl.tests.functional;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ifmo.rain.adsl.BaseGeneratorSettings;

import java.io.File;

public class ContainerClassesTest extends BaseFunctionalTest {

    private final String classPath = "android.widget.GridLayout";
    private final File testDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/functional/ContainerClassesTest.kt");

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
        settings.setGenerateGetters(false);
        settings.setGenerateSetters(false);
        settings.setGenerateProperties(false);
        settings.setGenerateUIClass(false);
        settings.setGenerateUIClassWrapper(false);
    }

    @Test
    public void testContainerClass() throws Exception {
        runFunctionalTest(testDataFile, classPath, "layouts");
    }
}

