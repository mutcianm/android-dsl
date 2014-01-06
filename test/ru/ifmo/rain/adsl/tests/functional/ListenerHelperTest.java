package ru.ifmo.rain.adsl.tests.functional;

import org.testng.annotations.Test;
import ru.ifmo.rain.adsl.BaseGeneratorSettings;
import ru.ifmo.rain.adsl.Subsystems;

import java.io.File;

public class ListenerHelperTest extends BaseFunctionalTest{
    private final String classPath = "android.widget.SearchView";
    private final File testDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/functional/ListenerHelperTest.kt");

    @Override
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
    public void testListenerHelpers() throws Exception {
        runFunctionalTest(testDataFile, classPath, Subsystems.LISTENER_HELPERS);
    }
}
