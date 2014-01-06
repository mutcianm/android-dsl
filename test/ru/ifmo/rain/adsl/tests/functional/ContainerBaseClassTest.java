package ru.ifmo.rain.adsl.tests.functional;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ifmo.rain.adsl.BaseGeneratorSettings;
import ru.ifmo.rain.adsl.Subsystems;

import java.io.File;

public class ContainerBaseClassTest extends BaseFunctionalTest {

    private final String classPath = "android.widget.Button";
    private final File testDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/functional/ContainerBaseClassTest.kt");

    @Override
    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
    }

    protected void initSettings(BaseGeneratorSettings settings) {
        settings.setGeneratePackage(false);
        settings.setGenerateImports(false);
        settings.setGenerateContainerBaseClass(true);
        settings.setGenerateContainerClasses(false);
        settings.setGenerateGetters(false);
        settings.setGenerateSetters(false);
        settings.setGenerateProperties(false);
        settings.setGenerateUIClass(false);
        settings.setGenerateUIClassWrapper(false);
        settings.setGenerateHelperConstructors(false);
    }

    @Test
    public void testContainerBaseClass() throws Exception {
        runFunctionalTest(testDataFile, classPath, Subsystems.CONTAINER_BASE_CLASS);
    }
}
