/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import static org.opensearch.client.codegen.utils.Functional.ifNonnull;

import io.swagger.v3.oas.models.media.MediaType;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.utils.Clone;
import org.opensearch.client.codegen.utils.builder.ToBuilder;
import org.opensearch.client.codegen.utils.json.JsonGenerator;

public final class OpenApiMediaType extends OpenApiElement<OpenApiMediaType> implements ToBuilder<OpenApiMediaType.Builder> {
    @Nullable
    private OpenApiSchema schema;

    private OpenApiMediaType(@Nonnull Builder builder) {
        super(builder);
        setSchema(builder.schema);
    }

    OpenApiMediaType(@Nonnull MediaType mediaType) {
        Objects.requireNonNull(mediaType, "mediaType must not be null");
        setSchema(ifNonnull(mediaType.getSchema(), OpenApiSchema::new));
    }

    @Override
    void initialize(@Nullable OpenApiElement<?> parent, @Nonnull JsonPointer pointer) {
        super.initialize(parent, pointer);
        initializeChild("schema", schema);
    }

    @Nonnull
    public Optional<OpenApiSchema> getSchema() {
        return Optional.ofNullable(schema);
    }

    public void setSchema(@Nullable OpenApiSchema schema) {
        this.schema = schema;
        initializeChild("schema", schema);
    }

    @Override
    public @Nonnull OpenApiMediaType clone() {
        return toBuilder().build();
    }

    @Override
    protected void toJsonInner(JsonGenerator generator) {
        if (schema != null) {
            generator.writeField("schema", schema);
        }
    }

    @Override
    public @Nonnull Builder toBuilder() {
        return super.toBuilder(builder()).withSchema(ifNonnull(schema, Clone::clone));
    }

    public static @Nonnull Builder builder() {
        return new Builder();
    }

    public static final class Builder extends OpenApiElement.AbstractBuilder<OpenApiMediaType, Builder> {
        @Nullable
        private OpenApiSchema schema;

        private Builder() {}

        @Nonnull
        @Override
        public OpenApiMediaType construct() {
            return new OpenApiMediaType(this);
        }

        @Nonnull
        public Builder withSchema(@Nullable OpenApiSchema schema) {
            this.schema = schema;
            return this;
        }
    }
}
