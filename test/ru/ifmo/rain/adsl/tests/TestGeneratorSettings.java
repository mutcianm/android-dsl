package ru.ifmo.rain.adsl.tests;

import org.jetbrains.annotations.NotNull;
import ru.ifmo.rain.adsl.GeneratorSettings;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TestGeneratorSettings extends GeneratorSettings {
    public TestGeneratorSettings() throws IOException {
        tmpFiles.put("containerBaseClass", File.createTempFile("containerBaseClass", ".kt"));
        tmpFiles.put("layouts", File.createTempFile("layouts", ".kt"));
        tmpFiles.put("properties", File.createTempFile("properties", ".kt"));
        tmpFiles.put("uiClasses", File.createTempFile("uiClasses", ".kt"));
    }

    public final HashMap<String, File> tmpFiles = new HashMap<>();

    @NotNull
    @Override
    public Set<String> getExplicitlyProcessedClasses() {
        return new HashSet<>();
    }

    @NotNull
    @Override
    public File getOutputFile(String subsystem) {
        return tmpFiles.get(subsystem);
    }
}
