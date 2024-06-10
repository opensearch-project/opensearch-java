/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.media.MediaType;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class OpenApiMediaType extends OpenApiElement<OpenApiMediaType> {
    @Nullable
    private final OpenApiSchema schema;

    protected OpenApiMediaType(@Nonnull OpenApiContent parent, @Nonnull JsonPointer pointer, @Nonnull MediaType mediaType) {
        super(parent, pointer);
        Objects.requireNonNull(mediaType, "mediaType must not be null");
        this.schema = child("schema", mediaType.getSchema(), OpenApiSchema::new);
    }

    @Nonnull
    public Optional<OpenApiSchema> getSchema() {
        return Optional.ofNullable(schema);
    }
}
