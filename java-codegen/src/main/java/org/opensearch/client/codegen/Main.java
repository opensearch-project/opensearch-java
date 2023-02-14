package org.opensearch.client.codegen;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: Main.class {specFile} {outputDir}");
            System.exit(1);
            return;
        }

        try {
            File specFile = new File(args[0]);
            File outputDir = new File(args[1]);
            System.out.println("Spec File: " + specFile);
            System.out.println("Output Dir: " + outputDir);
            Generator generator = new Generator(specFile, outputDir);
            generator.generate();
        } catch (Throwable e) {
            e.printStackTrace(System.err);
        }
    }
}
