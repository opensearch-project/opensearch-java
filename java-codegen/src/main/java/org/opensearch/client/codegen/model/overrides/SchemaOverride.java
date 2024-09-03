/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model.overrides;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.openapi.JsonPointer;
import org.opensearch.client.codegen.utils.MapBuilderBase;
import org.opensearch.client.codegen.utils.ObjectBuilder;
import org.opensearch.client.codegen.utils.ObjectBuilderBase;

public final class SchemaOverride {
    @Nonnull
    private final Map<String, PropertyOverride> properties;

    private SchemaOverride(Builder builder) {
        this.properties = builder.properties != null ? Collections.unmodifiableMap(builder.properties) : Collections.emptyMap();
    }

    @Nonnull
    public Optional<PropertyOverride> getProperty(@Nonnull String key) {
        return Optional.ofNullable(properties.get(key));
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    @Nonnull
    public static MapBuilder mapBuilder() {
        return new MapBuilder();
    }

    public static final class Builder extends ObjectBuilderBase<SchemaOverride, Builder> {
        @Nullable
        private Map<String, PropertyOverride> properties;

        private Builder() {}

        @Nonnull
        @Override
        protected SchemaOverride construct() {
            return new SchemaOverride(this);
        }

        @Nonnull
        public Builder withProperties(@Nonnull Function<PropertyOverride.MapBuilder, ObjectBuilder<Map<String, PropertyOverride>>> fn) {
            this.properties = Objects.requireNonNull(fn, "fn must not be null").apply(PropertyOverride.mapBuilder()).build();
            return this;
        }
    }

    public static final class MapBuilder extends MapBuilderBase<JsonPointer, SchemaOverride, Builder, MapBuilder> {
        private MapBuilder() {}

        @Nonnull
        @Override
        protected Builder valueBuilder() {
            return builder();
        }
    }
}
