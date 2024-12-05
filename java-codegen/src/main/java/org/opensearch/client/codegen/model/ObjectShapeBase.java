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
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import org.opensearch.client.codegen.model.overrides.ShouldGenerate;

public class ObjectShapeBase extends Shape {
    protected final Map<String, Field> bodyFields = new TreeMap<>();
    protected Field singleyKeyMapField;
    protected Field additionalPropertiesField;
    private String shortcutProperty;

    public ObjectShapeBase(Namespace parent, String className, String typedefName, String description, ShouldGenerate shouldGenerate) {
        super(parent, className, typedefName, description, shouldGenerate);
    }

    public void setSingleKeyMap(String fieldName, Type type) {
        singleyKeyMapField = Field.builder()
            .withName(fieldName)
            .withType(type)
            .withRequired(true)
            .withDescription("The target " + fieldName)
            .build();
        tryAddReference(ReferenceKind.Field, type);
    }

    public Field getSingleKeyMap() {
        return singleyKeyMapField;
    }

    public void addBodyField(Field field) {
        bodyFields.put(field.getName(), field);
        tryAddReference(ReferenceKind.Field, field.getType());
    }

    private Set<String> getDiscriminatingFieldNames() {
        return getReferencingDiscriminatedUnions().stream()
            .map(ReferencingDiscriminatedUnion::getDiscriminatingField)
            .filter(Objects::nonNull)
            .collect(Collectors.toSet());
    }

    public Collection<Field> getBodyFields() {
        var discriminatingFields = getDiscriminatingFieldNames();
        if (!discriminatingFields.isEmpty()) {
            return bodyFields.values().stream().filter(f -> !discriminatingFields.contains(f.getWireName())).collect(Collectors.toList());
        } else {
            return bodyFields.values();
        }
    }

    public Collection<Field> getFields() {
        return getFields(true);
    }

    public Collection<Field> getFields(boolean includeSingleKeyMap) {
        var fields = new ArrayList<>(getBodyFields());
        if (additionalPropertiesField != null) {
            fields.add(additionalPropertiesField);
        }
        if (includeSingleKeyMap && singleyKeyMapField != null) {
            fields.add(singleyKeyMapField);
        }
        fields.sort(Comparator.comparing(Field::getName));
        return fields;
    }

    public boolean hasFields() {
        return hasFields(true);
    }

    public boolean hasFields(boolean includeSingleKeyMap) {
        var discriminatingFields = getDiscriminatingFieldNames();
        return bodyFields.size() > discriminatingFields.size()
            || additionalPropertiesField != null
            || (includeSingleKeyMap && singleyKeyMapField != null);
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

    public String getShortcutProperty() {
        return shortcutProperty;
    }

    public void setShortcutProperty(String shortcutProperty) {
        this.shortcutProperty = shortcutProperty;
    }

    public Collection<Field> getFieldsToSerialize() {
        return getBodyFields();
    }

    public boolean hasFieldsToSerialize() {
        return !bodyFields.isEmpty() || additionalPropertiesField != null;
    }

    public Collection<Field> getFieldsToDeserialize() {
        return getBodyFields();
    }

    public Collection<BuilderSetter> getConcreteBuilderSetters() {
        var builderT = Type.builder().withName("Builder").build();
        return getFields().stream().map(f -> new BuilderSetter(builderT, f)).collect(Collectors.toList());
    }

    public Collection<BuilderSetter> getAbstractBuilderSetters() {
        var builderT = Type.builder().withName("BuilderT").build();
        return getFields().stream().map(f -> new BuilderSetter(builderT, f)).collect(Collectors.toList());
    }

    public static class BuilderSetter {
        private final Type builderType;
        private final String builderThis;
        private final Field field;

        public BuilderSetter(Type builderType, String builderThis, Field field) {
            this.builderType = builderType;
            this.builderThis = builderThis;
            this.field = field;
        }

        public BuilderSetter(Type builderType, Field field) {
            this(builderType, "this", field);
        }
    }
}
