/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model.overrides;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.model.Type;
import org.opensearch.client.codegen.utils.builder.ObjectBuilder;
import org.opensearch.client.codegen.utils.builder.ObjectBuilderBase;
import org.opensearch.client.codegen.utils.builder.ObjectMapBuilderBase;
import org.opensearch.client.codegen.utils.builder.SetBuilder;

public final class PropertyOverride {
    public static final PropertyOverride EMPTY = builder().build();

    @Nullable
    private final String name;
    @Nullable
    private final Type mappedType;
    @Nullable
    private final Set<String> aliases;

    private PropertyOverride(Builder builder) {
        this.name = builder.name;
        this.mappedType = builder.mappedType;
        this.aliases = builder.aliases;
    }

    @Nonnull
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    @Nonnull
    public Optional<Type> getMappedType() {
        return Optional.ofNullable(mappedType);
    }

    @Nonnull
    public Optional<Set<String>> getAliases() {
        return Optional.ofNullable(aliases);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    @Nonnull
    public static MapBuilder mapBuilder() {
        return new MapBuilder();
    }

    @Nonnull
    public Builder toBuilder() {
        return new Builder().withName(name).withMappedType(mappedType).withAliases(aliases != null ? new HashSet<>(aliases) : null);
    }

    public static final class Builder extends ObjectBuilderBase<PropertyOverride, Builder> {
        @Nullable
        private String name;
        @Nullable
        private Type mappedType;
        @Nullable
        private Set<String> aliases;

        private Builder() {}

        @Nonnull
        @Override
        protected PropertyOverride construct() {
            return new PropertyOverride(this);
        }

        @Nonnull
        public Builder withName(@Nullable String name) {
            this.name = name;
            return this;
        }

        @Nonnull
        public Builder withMappedType(@Nullable Type mappedType) {
            this.mappedType = mappedType;
            return this;
        }

        @Nonnull
        public Builder withAliases(@Nullable Set<String> aliases) {
            this.aliases = aliases;
            return this;
        }

        @Nonnull
        public Builder withAliases(@Nonnull Function<SetBuilder<String>, ObjectBuilder<Set<String>>> fn) {
            this.aliases = Objects.requireNonNull(fn, "fn must not be null").apply(new SetBuilder<>()).build();
            return this;
        }
    }

    public static final class MapBuilder extends ObjectMapBuilderBase<String, PropertyOverride, Builder, MapBuilder> {
        private MapBuilder() {}

        @Nonnull
        @Override
        protected Builder valueBuilder() {
            return builder();
        }
    }
}
