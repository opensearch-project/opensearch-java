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
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.Pair;
import org.opensearch.client.codegen.model.overrides.ShouldGenerate;

public class ObjectShape extends Shape {
    protected final Map<String, Field> bodyFields = new TreeMap<>();
    protected Field additionalPropertiesField;
    private String shortcutProperty;

    public ObjectShape(Namespace parent, String className, String typedefName, String description, ShouldGenerate shouldGenerate) {
        super(parent, className, typedefName, description, shouldGenerate);
    }

    public void addBodyField(Field field) {
        bodyFields.put(field.getName(), field);
        tryAddReference(ReferenceKind.Field, field.getType());
    }

    public Collection<Field> getBodyFields() {
        var discriminatingFields = getReferencingDiscriminatedUnions().stream()
            .map(ReferencingDiscriminatedUnion::getDiscriminatingField)
            .collect(Collectors.toSet());
        if (!discriminatingFields.isEmpty()) {
            return bodyFields.values().stream().filter(f -> !discriminatingFields.contains(f.getWireName())).collect(Collectors.toList());
        } else {
            return bodyFields.values();
        }
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

    public Collection<ReferencingDiscriminatedUnion> getReferencingDiscriminatedUnions() {
        return getIncomingReference(ReferenceKind.UnionVariant).stream()
            .map(s -> (TaggedUnionShape) s)
            .filter(TaggedUnionShape::isDiscriminated)
            .sorted(Comparator.comparing(Shape::getClassName))
            .map(u -> {
                var discriminatorValue = u.getVariants()
                    .stream()
                    .filter(v -> v.getType().equals(getType()))
                    .findFirst()
                    .orElseThrow()
                    .getName();

                return new ReferencingDiscriminatedUnion(u, discriminatorValue);
            })
            .collect(Collectors.toList());
    }

    public Set<Pair<String, String>> getDistinctDiscriminatorFieldValues() {
        return getReferencingDiscriminatedUnions().stream()
            .map(u -> Pair.of(u.getDiscriminatingField(), u.getDiscriminatorValue()))
            .collect(Collectors.toSet());
    }

    public Collection<Type> getImplementsTypes() {
        var types = new ArrayList<Type>(2);

        for (var union : getReferencingDiscriminatedUnions()) {
            types.add(union.getUnion().getVariantBaseType());
        }

        if (hasFieldsToSerialize() && !extendsOtherShape()) {
            types.add(Types.Client.Json.PlainJsonSerializable);
        }

        return types;
    }

    public Collection<Type> getAnnotations() {
        return (hasFieldsToSerialize() || extendsOtherShape()) && !isAbstract() ? List.of(Types.Client.Json.JsonpDeserializable) : null;
    }

    public boolean shouldImplementPlainDeserializable() {
        return Set.of("IndexTemplateMapping", "SourceField", "TypeMapping").contains(getClassName());
    }

    public boolean canBeSingleton() {
        return bodyFields.isEmpty() && additionalPropertiesField == null && !extendsOtherShape();
    }

    public static class ReferencingDiscriminatedUnion {
        private final TaggedUnionShape union;
        private final String discriminatorValue;

        public ReferencingDiscriminatedUnion(TaggedUnionShape union, String discriminatorValue) {
            this.union = union;
            this.discriminatorValue = discriminatorValue;
        }

        public TaggedUnionShape getUnion() {
            return union;
        }

        public String getDiscriminatingField() {
            return union.getDiscriminatingField();
        }

        public String getDiscriminatorValue() {
            return discriminatorValue;
        }
    }
}
