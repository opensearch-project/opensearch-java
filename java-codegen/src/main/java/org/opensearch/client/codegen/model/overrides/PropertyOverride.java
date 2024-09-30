/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model.overrides;

import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.model.Type;
import org.opensearch.client.codegen.utils.MapBuilderBase;
import org.opensearch.client.codegen.utils.ObjectBuilderBase;

public final class PropertyOverride {
    @Nullable
    private final Type mappedType;

    private PropertyOverride(Builder builder) {
        this.mappedType = builder.mappedType;
    }

    @Nonnull
    public Optional<Type> getMappedType() {
        return Optional.ofNullable(mappedType);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    @Nonnull
    public static MapBuilder mapBuilder() {
        return new MapBuilder();
    }

    public static final class Builder extends ObjectBuilderBase<PropertyOverride, Builder> {
        @Nullable
        private Type mappedType;

        private Builder() {}

        @Nonnull
        @Override
        protected PropertyOverride construct() {
            return new PropertyOverride(this);
        }

        @Nonnull
        public Builder withMappedType(@Nullable Type mappedType) {
            this.mappedType = mappedType;
            return this;
        }
    }

    public static final class MapBuilder extends MapBuilderBase<String, PropertyOverride, Builder, MapBuilder> {
        private MapBuilder() {}

        @Nonnull
        @Override
        protected Builder valueBuilder() {
            return builder();
        }
    }
}
