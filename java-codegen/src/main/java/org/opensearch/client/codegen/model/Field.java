package org.opensearch.client.codegen.model;

import org.opensearch.client.codegen.NameSanitizer;

public class Field {
    public String wireName;
    public Type type;

    public Field(String wireName, Type type) {
        this.wireName = wireName;
        this.type = type;
    }

    public String name() {
        return NameSanitizer.wireNameToField(wireName);
    }
}
