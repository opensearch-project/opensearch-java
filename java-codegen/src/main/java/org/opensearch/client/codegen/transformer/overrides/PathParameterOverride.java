/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.transformer.overrides;

import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.utils.builder.ObjectBuilderBase;
import org.opensearch.client.codegen.utils.builder.ObjectMapBuilderBase;

public final class PathParameterOverride {
    @Nullable
    private final String name;

    private PathParameterOverride(Builder builder) {
        this.name = builder.name;
    }

    @Nonnull
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    @Nonnull
    public static MapBuilder mapBuilder() {
        return new MapBuilder();
    }

    public static final class Builder extends ObjectBuilderBase<PathParameterOverride, Builder> {
        @Nullable
        private String name;

        private Builder() {}

        @Nonnull
        @Override
        protected PathParameterOverride construct() {
            return new PathParameterOverride(this);
        }

        @Nonnull
        public Builder withName(@Nullable String value) {
            this.name = value;
            return this;
        }
    }

    public static final class MapBuilder extends ObjectMapBuilderBase<String, PathParameterOverride, Builder, MapBuilder> {
        private MapBuilder() {}

        @Nonnull
        @Override
        protected Builder valueBuilder() {
            return builder();
        }
    }
}
