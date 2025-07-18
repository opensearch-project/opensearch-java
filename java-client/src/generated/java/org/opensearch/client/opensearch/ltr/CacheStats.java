/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.ltr;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ltr.CacheStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CacheStats implements PlainJsonSerializable, ToCopyableBuilder<CacheStats.Builder, CacheStats> {

    @Nullable
    private final CacheStat feature;

    @Nullable
    private final CacheStat featureset;

    @Nullable
    private final CacheStat model;

    // ---------------------------------------------------------------------------------------------

    private CacheStats(Builder builder) {
        this.feature = builder.feature;
        this.featureset = builder.featureset;
        this.model = builder.model;
    }

    public static CacheStats of(Function<CacheStats.Builder, ObjectBuilder<CacheStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code feature}
     */
    @Nullable
    public final CacheStat feature() {
        return this.feature;
    }

    /**
     * API name: {@code featureset}
     */
    @Nullable
    public final CacheStat featureset() {
        return this.featureset;
    }

    /**
     * API name: {@code model}
     */
    @Nullable
    public final CacheStat model() {
        return this.model;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.feature != null) {
            generator.writeKey("feature");
            this.feature.serialize(generator, mapper);
        }

        if (this.featureset != null) {
            generator.writeKey("featureset");
            this.featureset.serialize(generator, mapper);
        }

        if (this.model != null) {
            generator.writeKey("model");
            this.model.serialize(generator, mapper);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link CacheStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CacheStats> {
        @Nullable
        private CacheStat feature;
        @Nullable
        private CacheStat featureset;
        @Nullable
        private CacheStat model;

        public Builder() {}

        private Builder(CacheStats o) {
            this.feature = o.feature;
            this.featureset = o.featureset;
            this.model = o.model;
        }

        private Builder(Builder o) {
            this.feature = o.feature;
            this.featureset = o.featureset;
            this.model = o.model;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code feature}
         */
        @Nonnull
        public final Builder feature(@Nullable CacheStat value) {
            this.feature = value;
            return this;
        }

        /**
         * API name: {@code feature}
         */
        @Nonnull
        public final Builder feature(Function<CacheStat.Builder, ObjectBuilder<CacheStat>> fn) {
            return feature(fn.apply(new CacheStat.Builder()).build());
        }

        /**
         * API name: {@code featureset}
         */
        @Nonnull
        public final Builder featureset(@Nullable CacheStat value) {
            this.featureset = value;
            return this;
        }

        /**
         * API name: {@code featureset}
         */
        @Nonnull
        public final Builder featureset(Function<CacheStat.Builder, ObjectBuilder<CacheStat>> fn) {
            return featureset(fn.apply(new CacheStat.Builder()).build());
        }

        /**
         * API name: {@code model}
         */
        @Nonnull
        public final Builder model(@Nullable CacheStat value) {
            this.model = value;
            return this;
        }

        /**
         * API name: {@code model}
         */
        @Nonnull
        public final Builder model(Function<CacheStat.Builder, ObjectBuilder<CacheStat>> fn) {
            return model(fn.apply(new CacheStat.Builder()).build());
        }

        /**
         * Builds a {@link CacheStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CacheStats build() {
            _checkSingleUse();

            return new CacheStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CacheStats}
     */
    public static final JsonpDeserializer<CacheStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CacheStats::setupCacheStatsDeserializer
    );

    protected static void setupCacheStatsDeserializer(ObjectDeserializer<CacheStats.Builder> op) {
        op.add(Builder::feature, CacheStat._DESERIALIZER, "feature");
        op.add(Builder::featureset, CacheStat._DESERIALIZER, "featureset");
        op.add(Builder::model, CacheStat._DESERIALIZER, "model");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.feature);
        result = 31 * result + Objects.hashCode(this.featureset);
        result = 31 * result + Objects.hashCode(this.model);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CacheStats other = (CacheStats) o;
        return Objects.equals(this.feature, other.feature)
            && Objects.equals(this.featureset, other.featureset)
            && Objects.equals(this.model, other.model);
    }
}
