package org.opensearch.client.codegen.model;

import org.opensearch.client.codegen.NameSanitizer;

public class Field {
    public String wireName;
    public Type type;
    public boolean required;

    public Field(String wireName, Type type, boolean required) {
        this.wireName = wireName;
        this.type = required ? type : type.boxed();
        this.required = required;
    }

    public String name() {
        return NameSanitizer.wireNameToField(wireName);
    }
}
