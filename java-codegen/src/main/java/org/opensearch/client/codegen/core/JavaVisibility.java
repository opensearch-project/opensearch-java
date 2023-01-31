package org.opensearch.client.codegen.core;

public enum JavaVisibility {
    PUBLIC,
    PROTECTED,
    PRIVATE;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
