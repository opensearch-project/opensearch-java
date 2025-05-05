/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi.rewriter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import org.opensearch.client.codegen.openapi.OpenApiSchema;
import org.opensearch.client.codegen.openapi.OpenApiSchemaType;
import org.opensearch.client.codegen.openapi.walker.OpenApiVisitorBase;
import org.opensearch.client.codegen.openapi.walker.OpenApiWalker;

public final class TypeDeterminingVisitor extends OpenApiVisitorBase {
    @Nonnull
    private final OpenApiWalker walker;

    public TypeDeterminingVisitor(@Nonnull OpenApiWalker walker) {
        this.walker = Objects.requireNonNull(walker, "walker cannot be null");
    }

    @Override
    @Nonnull
    public OpenApiSchema visitSchemaEnd(@Nonnull OpenApiSchema schema) {
        if (schema.getTypes().isEmpty()) {
            schema.setTypes(determineTypes(schema).orElse(null));
        }
        return schema;
    }

    private Optional<Set<OpenApiSchemaType>> determineTypes(OpenApiSchema schema) {
        if (schema.has$ref()) {
            return walker.walkSchema(schema.resolve(), this).getTypes();
        } else if (schema.hasAllOf()) {
            Set<OpenApiSchemaType> types = null;
            for (var subSchema : schema.getAllOf().orElseThrow()) {
                if (types == null) {
                    types = new HashSet<>(subSchema.getTypes().orElseThrow());
                } else {
                    types.retainAll(subSchema.getTypes().orElseThrow());
                }
            }
            return Optional.ofNullable(types);
        } else if (schema.hasAnyOf() || schema.hasOneOf()) {
            return Optional.of(
                schema.getAnyOf()
                    .or(schema::getOneOf)
                    .orElseThrow()
                    .stream()
                    .flatMap(s -> s.getTypes().orElseThrow().stream())
                    .collect(Collectors.toSet())
            );
        } else {
            return Optional.of(OpenApiSchemaType.ALL_TYPES);
        }
    }
}
