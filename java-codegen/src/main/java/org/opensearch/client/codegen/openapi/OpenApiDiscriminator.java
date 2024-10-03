/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.media.Discriminator;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class OpenApiDiscriminator extends OpenApiElement<OpenApiDiscriminator> {
    @Nullable
    private final String propertyName;

    protected OpenApiDiscriminator(@Nullable OpenApiElement<?> parent, @Nonnull JsonPointer pointer, @Nonnull Discriminator discriminator) {
        super(parent, pointer);
        this.propertyName = discriminator.getPropertyName();
    }

    @Nonnull
    public Optional<String> getPropertyName() {
        return Optional.ofNullable(propertyName);
    }
}
