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
import org.opensearch.client.codegen.utils.builder.ObjectBuilder;
import org.opensearch.client.codegen.utils.builder.ObjectBuilderBase;
import org.opensearch.client.codegen.utils.builder.ObjectMapBuilderBase;

public final class SchemaOverride {
    private final boolean skipGeneration;
    @Nonnull
    private final Map<String, PropertyOverride> properties;
    @Nullable
    private final Function<String, Set<String>> aliasProvider;
    @Nullable
    private final String className;

    private SchemaOverride(Builder builder) {
        this.skipGeneration = builder.skipGeneration;
        this.properties = builder.properties != null ? Collections.unmodifiableMap(builder.properties) : Collections.emptyMap();
        this.aliasProvider = builder.aliasProvider;
        this.className = builder.className;
    }

    @Nonnull
    public PropertyOverride getProperty(@Nonnull String key) {
        var orig = properties.get(key);
        Type mappedType = null;
        Set<String> aliases = null;
        if (orig != null) {
            mappedType = orig.getMappedType().orElse(null);
            aliases = orig.getAliases().map(HashSet::new).orElse(null);
        }

        if (aliasProvider != null) {
            var providerAliases = aliasProvider.apply(key);
            if (providerAliases != null) {
                if (aliases == null) {
                    aliases = new HashSet<>(providerAliases);
                } else {
                    aliases.addAll(providerAliases);
                }
            }
        }

        return PropertyOverride.builder().withMappedType(mappedType).withAliases(aliases).build();
    }

    public boolean shouldSkipGeneration() {
        return skipGeneration;
    }

    @Nonnull
    public Optional<String> getClassName() {
        return Optional.ofNullable(className);
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
        private boolean skipGeneration;
        @Nullable
        private Map<String, PropertyOverride> properties;
        @Nullable
        private Function<String, Set<String>> aliasProvider;
        @Nullable
        private String className;

        private Builder() {}

        @Nonnull
        @Override
        protected SchemaOverride construct() {
            return new SchemaOverride(this);
        }

        @Nonnull
        public Builder withSkipGeneration(boolean skipGeneration) {
            this.skipGeneration = skipGeneration;
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
