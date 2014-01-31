package ru.ifmo.rain.adsl.tests.android;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class AndroidBigRuntimeTest extends BaseCompileTest {

    private final File testLayoutsDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/android/AndroidLayoutsTest.kt");
    private final File testPropertiesDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/android/AndroidPropertiesTest.kt");
    private final File testSimpleDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/android/AndroidSimpleTest.kt");
    private final File testWidgetsDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/android/AndroidWidgetTest.kt");
    private final File testLayoutParamsDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/android/AndroidLayoutParamsTest.kt");
    private final File testListenerHelpersDataFile = new File("testdata/ru/ifmo/rain/adsl/tests/android/AndroidListenerHelpersTest.kt");
    private final File testMultiMethodListenersFile = new File("testdata/ru/ifmo/rain/adsl/tests/android/AndroidMultiMethodListeners.kt");

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testProperties() throws Exception {
        runCompileTest(testPropertiesDataFile);
    }

    @Test
    public void testSimple() throws Exception {
        runCompileTest(testSimpleDataFile);
    }

    @Test
    public void testWidgets() throws Exception {
        runCompileTest(testWidgetsDataFile);
    }

    @Test
    public void testLayouts() throws Exception {
        runCompileTest(testLayoutsDataFile);
    }

    @Test
    public void testLayoutParams() throws Exception {
        runCompileTest(testLayoutParamsDataFile);
    }

    @Test
    public void testListenerHelpers() throws Exception {
        runCompileTest(testListenerHelpersDataFile);
    }

    @Test
    public void testMultiMethodListeners() throws Exception {
        runCompileTest(testMultiMethodListenersFile);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
