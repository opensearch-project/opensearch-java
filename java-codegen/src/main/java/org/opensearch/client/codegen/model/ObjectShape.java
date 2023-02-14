package org.opensearch.client.codegen.model;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class ObjectShape {
    public String name;
    private final Map<String, Field> fields = new TreeMap<>();

    public void addField(Field field) {
        fields.put(field.wireName, field);
    }

    public String className() {
        return name;
    }

    public Collection<Field> fields() {
        return fields.values();
    }
}
