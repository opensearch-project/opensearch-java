/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import static org.opensearch.client.codegen.utils.Functional.ifNonnull;

import io.swagger.v3.oas.models.parameters.Parameter;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class OpenApiParameter extends OpenApiRefElement<OpenApiParameter> {
    @Nullable
    private final String name;
    @Nullable
    private final String description;
    @Nullable
    private final In in;
    @Nullable
    private final Boolean isRequired;
    @Nullable
    private final OpenApiSchema schema;

    protected OpenApiParameter(@Nullable OpenApiElement<?> parent, @Nonnull JsonPointer pointer, @Nonnull Parameter parameter) {
        super(parent, pointer, parameter.get$ref(), OpenApiParameter.class);
        this.name = parameter.getName();
        this.description = parameter.getDescription();
        this.in = ifNonnull(parameter.getIn(), In::from);
        this.isRequired = parameter.getRequired();
        this.schema = child("schema", parameter.getSchema(), OpenApiSchema::new);
    }

    @Nonnull
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    @Nonnull
    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    @Nonnull
    public Optional<In> getIn() {
        return Optional.ofNullable(in);
    }

    public boolean getRequired() {
        return isRequired != null && isRequired;
    }

    @Nonnull
    public Optional<OpenApiSchema> getSchema() {
        return Optional.ofNullable(schema);
    }
}
