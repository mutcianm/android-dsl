package ru.ifmo.rain.adsl.tests.functional;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ifmo.rain.adsl.BaseGeneratorSettings;

import java.io.File;

public class UIClassTest extends BaseFunctionalTest {

    private final String classPath = "android.widget.LinearLayout";
    private final File testDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/functional/UIClassTest.kt");

    @Override
    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
    }

    protected void initSettings(BaseGeneratorSettings settings) {
        settings.setGeneratePackage(false);
        settings.setGenerateImports(false);
        settings.setGenerateContainerBaseClass(false);
        settings.setGenerateContainerClasses(false);
        settings.setGenerateGetters(false);
        settings.setGenerateSetters(false);
        settings.setGenerateProperties(false);
        settings.setGenerateUIClass(true);
        settings.setGenerateUIClassWrapper(false);
    }

    @Test
    public void testUIClass() throws Exception {
        runFunctionalTest(testDataFile, classPath, "uiClasses");
    }
}

