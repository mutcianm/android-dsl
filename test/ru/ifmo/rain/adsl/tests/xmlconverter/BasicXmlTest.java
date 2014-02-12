package ru.ifmo.rain.adsl.tests.xmlconverter;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.ifmo.rain.adsl.AdslPackage;
import ru.ifmo.rain.adsl.xmlconverter.Converter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BasicXmlTest extends Assert {
    @Test
    public void testBasic() throws Exception {
        Converter c = new Converter();
        c.run("testdata/ru/ifmo/rain/adsl/tests/xmlconverter/BasicXml.in");
        String actual = c.toString();
        String expected = loadOrCreate(new File("testdata/ru/ifmo/rain/adsl/tests/xmlconverter/BasicXml.out"),
                actual);
        assertEquals(actual, expected);
    }

    protected String loadOrCreate(File file, String data) throws IOException {
        try {
            return AdslPackage.readFile(file.getAbsolutePath());
        } catch (Exception e) {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(data);
            fileWriter.close();
            fail("Empty expected data, creating from actual");
            return data;
        }
    }
}
