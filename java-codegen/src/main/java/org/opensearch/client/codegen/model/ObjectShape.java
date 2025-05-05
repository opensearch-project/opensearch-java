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
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.Pair;
import org.opensearch.client.codegen.model.types.TypeRef;
import org.opensearch.client.codegen.model.types.Types;
import org.opensearch.client.codegen.transformer.overrides.ShouldGenerate;

public class ObjectShape extends ObjectShapeBase {
    public ObjectShape(Namespace parent, String className, String typedefName, String description, ShouldGenerate shouldGenerate) {
        super(parent, className, typedefName, description, shouldGenerate);
    }

    public Set<Pair<String, String>> getDistinctDiscriminatorFieldValues() {
        return getReferencingDiscriminatedUnions().stream()
            .filter(u -> u.getDiscriminatingField() != null)
            .map(u -> Pair.of(u.getDiscriminatingField(), u.getDiscriminatorValue()))
            .collect(Collectors.toSet());
    }

    public final boolean shouldImplementJsonSerializable() {
        return !superImplementsJsonSerializable() && shouldImplementJsonSerializableInner();
    }

    protected boolean shouldImplementJsonSerializableInner() {
        return hasFieldsToSerialize() || !extendedByOtherShape();
    }

    public boolean implementsJsonSerializable() {
        return shouldImplementJsonSerializableInner() || superImplementsJsonSerializable();
    }

    private boolean superImplementsJsonSerializable() {
        return extendsOtherShape()
            && getExtendsType().getTargetShape().map(s -> ((ObjectShape) s).implementsJsonSerializable()).orElse(false);
    }

    public Collection<TypeRef> getImplementsTypes() {
        var types = new ArrayList<>(super.getImplementsTypes());

        if (shouldImplementJsonSerializable()) {
            types.add(Types.Client.Json.PlainJsonSerializable);
        }

        if (!isAbstract()) {
            types.add(Types.Client.Util.ToCopyableBuilder(getSelfType().getBuilderType(), getSelfType()));
        }

        return types;
    }

    public Collection<TypeRef> getAnnotations() {
        return (hasFieldsToSerialize() || extendsOtherShape()) && !isAbstract() && !hasTypeParameters()
            ? List.of(Types.Client.Json.JsonpDeserializable)
            : null;
    }

    public boolean canBeSingleton() {
        if (!bodyFields.isEmpty()) {
            return false;
        }

        if (additionalProperties != null) {
            return false;
        }

        var extendsType = getExtendsType();

        if (extendsType == null) {
            return true;
        }

        return extendsType.getTargetShape().map(s -> ((ObjectShape) s).canBeSingleton()).orElse(false);
    }

    public boolean isEmptyObject() {
        return canBeSingleton() && !extendedByOtherShape();
    }

    public boolean shouldImplementPlainDeserializable() {
        return Set.of("IndexTemplateMapping", "SourceField", "TypeMapping").contains(getClassName());
    }
}
