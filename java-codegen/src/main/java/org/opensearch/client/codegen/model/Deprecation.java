package org.opensearch.client.codegen.model;

public class Deprecation {
    private final String description;
    private final String version;

    public Deprecation(String description, String version) {
        this.description = description;
        this.version = version;
    }
}
