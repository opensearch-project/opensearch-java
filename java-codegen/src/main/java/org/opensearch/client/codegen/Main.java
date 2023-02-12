package org.opensearch.client.codegen;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            Generator generator = new Generator(new File(args[0]));
            generator.generate();
        } catch (Throwable e) {
            e.printStackTrace(System.err);
        }
    }
}
