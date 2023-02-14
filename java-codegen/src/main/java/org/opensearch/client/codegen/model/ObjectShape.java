package org.opensearch.client.codegen.model;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class ObjectShape {
    private final String className;
    private final Map<String, Field> bodyFields = new TreeMap<>();

    public ObjectShape(String className) {
        this.className = className;
    }

    public void addBodyField(Field field) {
        bodyFields.put(field.wireName, field);
    }

    public String className() {
        return className;
    }

    public Collection<Field> bodyFields() { return bodyFields.values(); }

    public Collection<Field> fields() {
        return bodyFields();
    }
}
