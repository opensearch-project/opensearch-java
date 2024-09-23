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
    protected final Map<String, Field> bodyFields = new TreeMap<>();
    protected Field additionalPropertiesField;

    public ObjectShape(Namespace parent, String className, String typedefName, String description) {
        super(parent, className, typedefName, description);
    }

    public void addBodyField(Field field) {
        bodyFields.put(field.getName(), field);
        tryAddReference(ReferenceKind.Field, field.getType());
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
        if (field != null) {
            tryAddReference(ReferenceKind.Field, field.getType());
        }
    }

    public Field getAdditionalPropertiesField() {
        return additionalPropertiesField;
    }

    public boolean hasFieldsToSerialize() {
        return !bodyFields.isEmpty() || additionalPropertiesField != null;
    }

    public Collection<Type> getImplementsTypes() {
        return hasFieldsToSerialize() && !extendsOtherShape() ? List.of(Types.Client.Json.PlainJsonSerializable) : null;
    }

    public Collection<Type> getAnnotations() {
        return (hasFieldsToSerialize() || extendsOtherShape()) && !isAbstract() ? List.of(Types.Client.Json.JsonpDeserializable) : null;
    }

    public static class BuilderModel {

    }
}
