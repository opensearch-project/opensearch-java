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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import org.opensearch.client.codegen.model.overrides.ShouldGenerate;
import org.opensearch.client.codegen.utils.NameSanitizer;

public class ObjectShapeBase extends Shape {
    protected final Map<String, Field> bodyFields = new TreeMap<>();
    private final Set<String> bodyFieldWireNames = new HashSet<>();
    protected Field singleyKeyMapField;
    protected AdditionalProperties additionalProperties;
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
        bodyFieldWireNames.add(field.getWireName());
        tryAddReference(ReferenceKind.Field, field.getType());
    }

    public boolean hasBodyFieldWithWireName(String wireName) {
        return bodyFieldWireNames.contains(wireName);
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
        if (additionalProperties != null) {
            fields.addAll(additionalProperties.getFields());
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
            || additionalProperties != null
            || (includeSingleKeyMap && singleyKeyMapField != null);
    }

    public boolean hasAnyRequiredFields() {
        return bodyFields.values().stream().anyMatch(Field::isRequired);
    }

    public void setAdditionalProperties(AdditionalProperties additionalProperties) {
        this.additionalProperties = additionalProperties;
        if (additionalProperties != null) {
            tryAddReference(ReferenceKind.Field, additionalProperties.keyType);
            tryAddReference(ReferenceKind.Field, additionalProperties.valueType);
        }
    }

    public AdditionalProperties getAdditionalProperties() {
        return additionalProperties;
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
        return !bodyFields.isEmpty() || additionalProperties != null;
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

    public static class AdditionalProperties {
        private final String keyName;
        private final Type keyType;
        private final String keyDescription;
        private final String valueName;
        private final Type valueType;
        private final String valueDescription;
        private final boolean singleton;

        public AdditionalProperties(
            String keyName,
            Type keyType,
            String keyDescription,
            String valueName,
            Type valueType,
            String valueDescription,
            boolean singleton
        ) {
            this.keyName = NameSanitizer.fieldName(keyName);
            this.keyType = keyType;
            this.keyDescription = keyDescription;
            this.valueName = NameSanitizer.fieldName(valueName);
            this.valueType = valueType;
            this.valueDescription = valueDescription;
            this.singleton = singleton;
        }

        public List<Field> getFields() {
            if (singleton) {
                return List.of(
                    Field.builder().withName(keyName).withType(keyType).withDescription(keyDescription).withRequired(true).build(),
                    Field.builder().withName(valueName).withType(valueType).withDescription(valueDescription).withRequired(true).build()
                );
            } else {
                return List.of(Field.builder().withName(valueName).withType(getMapType()).withDescription(valueDescription).build());
            }
        }

        public Type getMapType() {
            return Types.Java.Util.Map(keyType, valueType);
        }
    }
}
