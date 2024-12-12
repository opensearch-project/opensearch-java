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
import org.opensearch.client.codegen.model.OperationGroup;
import org.opensearch.client.codegen.utils.builder.ObjectBuilder;
import org.opensearch.client.codegen.utils.builder.ObjectBuilderBase;
import org.opensearch.client.codegen.utils.builder.ObjectMapBuilderBase;

public final class OperationOverride {
    @Nonnull
    private final Map<String, PathParameterOverride> pathParameters;

    private OperationOverride(Builder builder) {
        this.pathParameters = builder.pathParameters != null ? builder.pathParameters : Collections.emptyMap();
    }

    @Nonnull
    public Optional<PathParameterOverride> getPathParameter(@Nonnull String key) {
        return Optional.ofNullable(pathParameters.get(key));
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
