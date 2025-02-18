/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model.overrides;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.model.Type;
import org.opensearch.client.codegen.openapi.JsonPointer;
import org.opensearch.client.codegen.utils.Maps;
import org.opensearch.client.codegen.utils.builder.ObjectBuilder;
import org.opensearch.client.codegen.utils.builder.ObjectBuilderBase;
import org.opensearch.client.codegen.utils.builder.ObjectMapBuilderBase;

public final class SchemaOverride {
    @Nonnull
    private final ShouldGenerate shouldGenerate;
    @Nonnull
    private final Map<String, PropertyOverride> properties;
    @Nullable
    private final Function<String, Set<String>> aliasProvider;
    @Nullable
    private final String className;
    @Nullable
    private final Type mappedType;

    private SchemaOverride(Builder builder) {
        this.shouldGenerate = builder.shouldGenerate;
        this.properties = builder.properties != null ? Collections.unmodifiableMap(builder.properties) : Collections.emptyMap();
        this.aliasProvider = builder.aliasProvider;
        this.className = builder.className;
        this.mappedType = builder.mappedType;
    }

    @Nonnull
    public PropertyOverride getProperty(@Nonnull String key) {
        var aliases = aliasProvider != null ? aliasProvider.apply(key) : null;

        if (aliases == null) {
            return properties.getOrDefault(key, PropertyOverride.EMPTY);
        }

        aliases = new HashSet<>(aliases);

        var orig = Maps.tryGet(properties, key);

        orig.flatMap(PropertyOverride::getAliases).ifPresent(aliases::addAll);

        return orig.map(PropertyOverride::toBuilder).orElseGet(PropertyOverride::builder).withAliases(aliases).build();
    }

    @Nonnull
    public ShouldGenerate shouldGenerate() {
        return shouldGenerate;
    }

    @Nonnull
    public Optional<String> getClassName() {
        return Optional.ofNullable(className);
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

    public static final class Builder extends ObjectBuilderBase<SchemaOverride, Builder> {
        @Nonnull
        private ShouldGenerate shouldGenerate = ShouldGenerate.IfNeeded;
        @Nullable
        private Map<String, PropertyOverride> properties;
        @Nullable
        private Function<String, Set<String>> aliasProvider;
        @Nullable
        private String className;
        @Nullable
        private Type mappedType;

        private Builder() {}

        @Nonnull
        @Override
        protected SchemaOverride construct() {
            return new SchemaOverride(this);
        }

        @Nonnull
        public Builder withShouldGenerate(@Nonnull ShouldGenerate shouldGenerate) {
            this.shouldGenerate = Objects.requireNonNull(shouldGenerate, "shouldGenerate must not be null");
            return this;
        }

        @Nonnull
        public Builder withProperties(@Nonnull Function<PropertyOverride.MapBuilder, ObjectBuilder<Map<String, PropertyOverride>>> fn) {
            this.properties = Objects.requireNonNull(fn, "fn must not be null").apply(PropertyOverride.mapBuilder()).build();
            return this;
        }

        @Nonnull
        public Builder withAliasProvider(@Nullable Function<String, Set<String>> aliasProvider) {
            this.aliasProvider = aliasProvider;
            return this;
        }

        @Nonnull
        public Builder withClassName(@Nullable String className) {
            this.className = className;
            return this;
        }

        @Nonnull
        public Builder withMappedType(@Nullable Type mappedType) {
            this.mappedType = mappedType;
            return this;
        }

        @Nonnull
        public Builder withMappedType(@Nonnull Function<Type.Builder, ObjectBuilder<Type>> fn) {
            this.mappedType = Objects.requireNonNull(fn, "fn must not be null").apply(Type.builder()).build();
            return this;
        }
    }

    public static final class MapBuilder extends ObjectMapBuilderBase<JsonPointer, SchemaOverride, Builder, MapBuilder> {
        private MapBuilder() {}

        @Nonnull
        @Override
        protected Builder valueBuilder() {
            return builder();
        }
    }
}
