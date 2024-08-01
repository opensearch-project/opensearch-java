/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ObjectShape extends Shape {
    protected Type extendsType;
    protected final Map<String, Field> bodyFields = new TreeMap<>();
    protected Field additionalPropertiesField;

    public ObjectShape(Namespace parent, String className, String typedefName, String description) {
        super(parent, className, typedefName, description);
    }

    public void addBodyField(Field field) {
        bodyFields.put(field.getName(), field);
    }

    public Collection<Field> getBodyFields() {
        return bodyFields.values();
    }

    public Collection<Field> getFields() {
        if (additionalPropertiesField != null) {
            var fields = new ArrayList<>(getBodyFields());
            fields.add(additionalPropertiesField);
            return fields;
        }
        return getBodyFields();
    }

    public void setAdditionalPropertiesField(Field field) {
        additionalPropertiesField = field;
    }

    public Field getAdditionalPropertiesField() {
        return additionalPropertiesField;
    }

    public void setExtendsType(Type extendsType) {
        this.extendsType = extendsType;
    }

    public Type getExtendsType() {
        return extendsType;
    }

    public Collection<Type> getImplementsTypes() {
        return !bodyFields.isEmpty() ? List.of(Types.Client.Json.PlainJsonSerializable) : null;
    }

    public Collection<Type> getAnnotations() {
        return !bodyFields.isEmpty() && !isAbstract() ? List.of(Types.Client.Json.JsonpDeserializable) : null;
    }
}
