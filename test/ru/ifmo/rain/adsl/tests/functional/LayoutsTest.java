package ru.ifmo.rain.adsl.tests.functional;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ifmo.rain.adsl.BaseGeneratorSettings;
import ru.ifmo.rain.adsl.Subsystems;

import java.io.File;

public class LayoutsTest extends BaseFunctionalTest {

    private final String classPath = "android.widget.GridLayout";
    private final File testDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/functional/LayoutsTest.kt");

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
    public void testLayouts() throws Exception {
        runFunctionalTest(testDataFile, classPath, Subsystems.LAYOUTS);
    }
}

