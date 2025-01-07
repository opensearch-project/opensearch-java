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
import org.opensearch.client.codegen.model.overrides.ShouldGenerate;

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

    public boolean shouldImplementJsonSerializable() {
        return hasFieldsToSerialize() && !extendsOtherShape();
    }

    public Collection<Type> getImplementsTypes() {
        var types = new ArrayList<>(super.getImplementsTypes());

        if (shouldImplementJsonSerializable()) {
            types.add(Types.Client.Json.PlainJsonSerializable);
        }

        if (!isAbstract() && !canBeSingleton()) {
            types.add(Types.Client.Util.ToCopyableBuilder(getType().getBuilderType(), getType()));
        }

        return types;
    }

    public Collection<Type> getAnnotations() {
        return (hasFieldsToSerialize() || extendsOtherShape()) && !isAbstract() ? List.of(Types.Client.Json.JsonpDeserializable) : null;
    }

    public boolean canBeSingleton() {
        if (!bodyFields.isEmpty()) {
            return false;
        }

        if (additionalPropertiesField != null) {
            return false;
        }

        var extendsType = getExtendsType();

        if (extendsType == null) {
            return true;
        }

        return extendsType.getTargetShape().map(s -> ((ObjectShape) s).canBeSingleton()).orElse(false);
    }

    public boolean shouldImplementPlainDeserializable() {
        return Set.of("IndexTemplateMapping", "SourceField", "TypeMapping").contains(getClassName());
    }
}
