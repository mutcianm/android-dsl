package ru.ifmo.rain.adsl.tests;

import org.jetbrains.annotations.NotNull;
import ru.ifmo.rain.adsl.GeneratorSettings;
import ru.ifmo.rain.adsl.Subsystems;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TestGeneratorSettings extends GeneratorSettings {
    public TestGeneratorSettings() throws IOException {
        tmpFiles.put(Subsystems.CONTAINER_BASE_CLASS, File.createTempFile("containerBaseClass", ".kt"));
        tmpFiles.put(Subsystems.LAYOUTS , File.createTempFile("layouts", ".kt"));
        tmpFiles.put(Subsystems.PROPERTIES, File.createTempFile("properties", ".kt"));
        tmpFiles.put(Subsystems.UI_CLASS, File.createTempFile("uiClasses", ".kt"));
        tmpFiles.put(Subsystems.LISTENER_HELPERS, File.createTempFile("listenerHelpers", ".kt"));
    }

    public final HashMap<Subsystems, File> tmpFiles = new HashMap<>();

    @NotNull
    @Override
    public Set<String> getExplicitlyProcessedClasses() {
        return new HashSet<>();
    }

    @NotNull
    @Override
    public File getOutputFile(Subsystems subsystem) {
        return tmpFiles.get(subsystem);
    }
}
