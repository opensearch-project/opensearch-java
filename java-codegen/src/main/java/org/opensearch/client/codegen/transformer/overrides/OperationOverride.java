/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.transformer.overrides;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.model.OperationGroup;
import org.opensearch.client.codegen.utils.Maps;
import org.opensearch.client.codegen.utils.builder.ObjectBuilder;
import org.opensearch.client.codegen.utils.builder.ObjectBuilderBase;
import org.opensearch.client.codegen.utils.builder.ObjectMapBuilderBase;

public final class OperationOverride {
    @Nullable
    private final Map<String, PathParameterOverride> pathParameters;
    @Nullable
    private final Map<String, QueryParameterOverride> queryParameters;

    private OperationOverride(Builder builder) {
        this.pathParameters = builder.pathParameters;
        this.queryParameters = builder.queryParameters;
    }

    @Nonnull
    public Optional<PathParameterOverride> getPathParameter(@Nonnull String key) {
        return Maps.tryGet(pathParameters, key);
    }

    @Nonnull
    public Optional<QueryParameterOverride> getQueryParameter(@Nonnull String key) {
        return Maps.tryGet(queryParameters, key);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    @Nonnull
    public static MapBuilder mapBuilder() {
        return new MapBuilder();
    }

    public static final class Builder extends ObjectBuilderBase<OperationOverride, Builder> {
        @Nullable
        private Map<String, PathParameterOverride> pathParameters;
        @Nullable
        private Map<String, QueryParameterOverride> queryParameters;

        private Builder() {}

        @Nonnull
        @Override
        protected OperationOverride construct() {
            return new OperationOverride(this);
        }

        @Nonnull
        public Builder withPathParameters(
            @Nonnull Function<PathParameterOverride.MapBuilder, ObjectBuilder<Map<String, PathParameterOverride>>> fn
        ) {
            this.pathParameters = Objects.requireNonNull(fn, "fn must not be null").apply(PathParameterOverride.mapBuilder()).build();
            return this;
        }

        @Nonnull
        public Builder withQueryParameters(
            @Nonnull Function<QueryParameterOverride.MapBuilder, ObjectBuilder<Map<String, QueryParameterOverride>>> fn
        ) {
            this.queryParameters = Objects.requireNonNull(fn, "fn must not be null").apply(QueryParameterOverride.mapBuilder()).build();
            return this;
        }
    }

    public static final class MapBuilder extends ObjectMapBuilderBase<OperationGroup, OperationOverride, Builder, MapBuilder> {
        private MapBuilder() {}

        @Nonnull
        @Override
        protected Builder valueBuilder() {
            return builder();
        }
    }
}
