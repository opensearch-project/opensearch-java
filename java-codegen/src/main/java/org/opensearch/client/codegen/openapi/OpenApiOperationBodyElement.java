/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.media.Content;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class OpenApiOperationBodyElement<TSelf extends OpenApiOperationBodyElement<TSelf>> extends OpenApiRefElement<TSelf> {
    @Nullable
    private final OpenApiContent content;

    protected OpenApiOperationBodyElement(
        @Nonnull OpenApiElement<?> parent,
        @Nonnull JsonPointer pointer,
        @Nullable String $ref,
        @Nullable Content content,
        @Nonnull Class<TSelf> clazz
    ) {
        super(parent, pointer, $ref, clazz);
        this.content = child("content", content, OpenApiContent::new);
    }

    @Nonnull
    public Optional<OpenApiContent> getContent() {
        return Optional.ofNullable(content);
    }
}
