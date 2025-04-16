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

package org.opensearch.client.opensearch.nodes.stats;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.CacheStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CacheStats extends CacheStatsBase implements ToCopyableBuilder<CacheStats.Builder, CacheStats> {

    @Nonnull
    private final Map<String, CacheIndicesStats> indices;

    @Nonnull
    private final Map<String, CacheShardStats> shards;

    @Nullable
    private final String storeName;

    // ---------------------------------------------------------------------------------------------

    private CacheStats(Builder builder) {
        super(builder);
        this.indices = ApiTypeHelper.unmodifiable(builder.indices);
        this.shards = ApiTypeHelper.unmodifiable(builder.shards);
        this.storeName = builder.storeName;
    }

    public static CacheStats of(Function<CacheStats.Builder, ObjectBuilder<CacheStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code indices}
     */
    @Nonnull
    public final Map<String, CacheIndicesStats> indices() {
        return this.indices;
    }

    /**
     * API name: {@code shards}
     */
    @Nonnull
    public final Map<String, CacheShardStats> shards() {
        return this.shards;
    }

    /**
     * API name: {@code store_name}
     */
    @Nullable
    public final String storeName() {
        return this.storeName;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (ApiTypeHelper.isDefined(this.indices)) {
            generator.writeKey("indices");
            generator.writeStartObject();
            for (Map.Entry<String, CacheIndicesStats> item0 : this.indices.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.shards)) {
            generator.writeKey("shards");
            generator.writeStartObject();
            for (Map.Entry<String, CacheShardStats> item0 : this.shards.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.storeName != null) {
            generator.writeKey("store_name");
            generator.write(this.storeName);
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
    public static class Builder extends CacheStatsBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, CacheStats> {
        @Nullable
        private Map<String, CacheIndicesStats> indices;
        @Nullable
        private Map<String, CacheShardStats> shards;
        @Nullable
        private String storeName;

        public Builder() {}

        private Builder(CacheStats o) {
            super(o);
            this.indices = _mapCopy(o.indices);
            this.shards = _mapCopy(o.shards);
            this.storeName = o.storeName;
        }

        private Builder(Builder o) {
            super(o);
            this.indices = _mapCopy(o.indices);
            this.shards = _mapCopy(o.shards);
            this.storeName = o.storeName;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * API name: {@code indices}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(Map<String, CacheIndicesStats> map) {
            this.indices = _mapPutAll(this.indices, map);
            return this;
        }

        /**
         * API name: {@code indices}
         *
         * <p>
         * Adds an entry to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(String key, CacheIndicesStats value) {
            this.indices = _mapPut(this.indices, key, value);
            return this;
        }

        /**
         * API name: {@code indices}
         *
         * <p>
         * Adds a value to <code>indices</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder indices(String key, Function<CacheIndicesStats.Builder, ObjectBuilder<CacheIndicesStats>> fn) {
            return indices(key, fn.apply(new CacheIndicesStats.Builder()).build());
        }

        /**
         * API name: {@code shards}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(Map<String, CacheShardStats> map) {
            this.shards = _mapPutAll(this.shards, map);
            return this;
        }

        /**
         * API name: {@code shards}
         *
         * <p>
         * Adds an entry to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(String key, CacheShardStats value) {
            this.shards = _mapPut(this.shards, key, value);
            return this;
        }

        /**
         * API name: {@code shards}
         *
         * <p>
         * Adds a value to <code>shards</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder shards(String key, Function<CacheShardStats.Builder, ObjectBuilder<CacheShardStats>> fn) {
            return shards(key, fn.apply(new CacheShardStats.Builder()).build());
        }

        /**
         * API name: {@code store_name}
         */
        @Nonnull
        public final Builder storeName(@Nullable String value) {
            this.storeName = value;
            return this;
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
        setupCacheStatsBaseDeserializer(op);
        op.add(Builder::indices, JsonpDeserializer.stringMapDeserializer(CacheIndicesStats._DESERIALIZER), "indices");
        op.add(Builder::shards, JsonpDeserializer.stringMapDeserializer(CacheShardStats._DESERIALIZER), "shards");
        op.add(Builder::storeName, JsonpDeserializer.stringDeserializer(), "store_name");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.indices);
        result = 31 * result + Objects.hashCode(this.shards);
        result = 31 * result + Objects.hashCode(this.storeName);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CacheStats other = (CacheStats) o;
        return Objects.equals(this.indices, other.indices)
            && Objects.equals(this.shards, other.shards)
            && Objects.equals(this.storeName, other.storeName);
    }
}
