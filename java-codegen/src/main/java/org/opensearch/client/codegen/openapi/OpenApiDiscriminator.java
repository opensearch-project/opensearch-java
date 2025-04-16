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
import org.opensearch.client.codegen.utils.Maps;
import org.opensearch.client.codegen.utils.builder.ToBuilder;

public class OpenApiDiscriminator extends OpenApiElement<OpenApiDiscriminator> implements ToBuilder<OpenApiDiscriminator.Builder> {
    @Nullable
    private final String propertyName;
    @Nullable
    private final String defaultValue;

    private OpenApiDiscriminator(@Nonnull Builder builder) {
        this.propertyName = builder.propertyName;
        this.defaultValue = builder.defaultValue;
    }

    OpenApiDiscriminator(@Nonnull Discriminator discriminator) {
        this.propertyName = discriminator.getPropertyName();
        var extensions = discriminator.getExtensions();
        this.defaultValue = (String) Maps.tryGet(extensions, "x-default").orElse(null);
    }

    @Nonnull
    public Optional<String> getPropertyName() {
        return Optional.ofNullable(propertyName);
    }

    @Nonnull
    public Optional<String> getDefaultValue() {
        return Optional.ofNullable(defaultValue);
    }

    @Override
    public @Nonnull OpenApiDiscriminator clone() {
        return toBuilder().build();
    }

    @Override
    public @Nonnull Builder toBuilder() {
        return new Builder().withPropertyName(propertyName).withDefaultValue(defaultValue);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends OpenApiElement.AbstractBuilder<OpenApiDiscriminator, Builder> {
        @Nullable
        private String propertyName;
        @Nullable
        private String defaultValue;

        private Builder() {}

        @Override
        @Nonnull
        public OpenApiDiscriminator construct() {
            return new OpenApiDiscriminator(this);
        }

        @Nonnull
        public Builder withPropertyName(@Nullable String propertyName) {
            this.propertyName = propertyName;
            return this;
        }

        @Nonnull
        public Builder withDefaultValue(@Nullable String defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }
    }
}
