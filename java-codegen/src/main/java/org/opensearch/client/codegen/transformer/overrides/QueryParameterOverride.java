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

public final class QueryParameterOverride {
    @Nullable
    private final String name;
    @Nullable
    private final Boolean ignore;

    private QueryParameterOverride(Builder builder) {
        this.name = builder.name;
        this.ignore = builder.ignore;
    }

    @Nonnull
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public boolean shouldIgnore() {
        return ignore != null && ignore;
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    @Nonnull
    public static MapBuilder mapBuilder() {
        return new MapBuilder();
    }

    public static final class Builder extends ObjectBuilderBase<QueryParameterOverride, Builder> {
        @Nullable
        private String name;
        @Nullable
        private Boolean ignore;

        private Builder() {}

        @Nonnull
        @Override
        protected QueryParameterOverride construct() {
            return new QueryParameterOverride(this);
        }

        @Nonnull
        public Builder withName(@Nullable String value) {
            this.name = value;
            return this;
        }

        @Nonnull
        public Builder withIgnore(@Nullable Boolean value) {
            this.ignore = value;
            return this;
        }
    }

    public static final class MapBuilder extends ObjectMapBuilderBase<String, QueryParameterOverride, Builder, MapBuilder> {
        private MapBuilder() {}

        @Nonnull
        @Override
        protected Builder valueBuilder() {
            return builder();
        }
    }
}
