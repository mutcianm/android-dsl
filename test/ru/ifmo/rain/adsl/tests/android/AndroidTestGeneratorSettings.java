package ru.ifmo.rain.adsl.tests.android;

import org.jetbrains.annotations.NotNull;
import ru.ifmo.rain.adsl.tests.TestGeneratorSettings;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class AndroidTestGeneratorSettings extends TestGeneratorSettings{
    public AndroidTestGeneratorSettings() throws IOException {
        super();
    }

    @NotNull
    @Override
    public Set<String> getExplicitlyProcessedClasses() {
        return new HashSet<String>(readLines("explicit_classes.txt"));
    }
}
