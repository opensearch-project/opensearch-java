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
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import org.opensearch.client.codegen.model.overrides.ShouldGenerate;

public class DelegatedShape extends Shape {
    @Nonnull
    private final Type delegatedType;

    public DelegatedShape(
        Namespace parent,
        String className,
        String typedefName,
        String description,
        ShouldGenerate shouldGenerate,
        Type delegatedType
    ) {
        super(parent, className, typedefName, description, shouldGenerate);
        this.delegatedType = Objects.requireNonNull(delegatedType, "delegatedType cannot be null");
    }

    @Nonnull
    public Type getDelegatedType() {
        return delegatedType;
    }

    public Collection<Field> getFields() {
        return List.of(
            Field.builder().withName("valueBody").withType(delegatedType).withDescription("Response value.").withRequired(true).build()
        );
    }

    @Override
    public Collection<Type> getImplementsTypes() {
        var types = new ArrayList<>(super.getImplementsTypes());
        types.add(Types.Client.Json.PlainJsonSerializable);
        return types;
    }

    public Collection<ObjectShapeBase.BuilderSetter> getConcreteBuilderSetters() {
        var builderT = Type.builder().withName("Builder").build();
        return getFields().stream().map(f -> new ObjectShapeBase.BuilderSetter(builderT, f)).collect(Collectors.toList());
    }
}
