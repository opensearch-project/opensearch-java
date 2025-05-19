/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.transformer.overrides;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.model.types.Type;
import org.opensearch.client.codegen.model.types.TypeRef;
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
    @Nullable
    private final Boolean ignore;
    @Nullable
    private final Boolean required;

    private PropertyOverride(Builder builder) {
        this.name = builder.name;
        this.mappedType = builder.mappedType;
        this.aliases = builder.aliases;
        this.ignore = builder.ignore;
        this.required = builder.required;
    }

    @Nonnull
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    @Nonnull
    public Optional<TypeRef> getMappedType() {
        return Optional.ofNullable(mappedType);
    }

    @Nonnull
    public Optional<Set<String>> getAliases() {
        return Optional.ofNullable(aliases);
    }

    public boolean shouldIgnore() {
        return ignore != null && ignore;
    }

    public Optional<Boolean> getRequired() {
        return Optional.ofNullable(required);
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
        @Nullable
        private Boolean ignore;
        @Nullable
        private Boolean required;

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

        @Nonnull
        public Builder withIgnore(@Nullable Boolean ignore) {
            this.ignore = ignore;
            return this;
        }

        @Nonnull
        public Builder withRequired(@Nullable Boolean required) {
            this.required = required;
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
