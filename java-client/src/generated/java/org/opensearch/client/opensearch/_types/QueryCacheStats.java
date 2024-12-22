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

package org.opensearch.client.opensearch._types;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.QueryCacheStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class QueryCacheStats implements PlainJsonSerializable, ToCopyableBuilder<QueryCacheStats.Builder, QueryCacheStats> {

    private final long cacheCount;

    private final long cacheSize;

    private final long evictions;

    private final long hitCount;

    @Nullable
    private final String memorySize;

    private final long memorySizeInBytes;

    private final long missCount;

    private final long totalCount;

    // ---------------------------------------------------------------------------------------------

    private QueryCacheStats(Builder builder) {
        this.cacheCount = ApiTypeHelper.requireNonNull(builder.cacheCount, this, "cacheCount");
        this.cacheSize = ApiTypeHelper.requireNonNull(builder.cacheSize, this, "cacheSize");
        this.evictions = ApiTypeHelper.requireNonNull(builder.evictions, this, "evictions");
        this.hitCount = ApiTypeHelper.requireNonNull(builder.hitCount, this, "hitCount");
        this.memorySize = builder.memorySize;
        this.memorySizeInBytes = ApiTypeHelper.requireNonNull(builder.memorySizeInBytes, this, "memorySizeInBytes");
        this.missCount = ApiTypeHelper.requireNonNull(builder.missCount, this, "missCount");
        this.totalCount = ApiTypeHelper.requireNonNull(builder.totalCount, this, "totalCount");
    }

    public static QueryCacheStats of(Function<QueryCacheStats.Builder, ObjectBuilder<QueryCacheStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The total number of entries added to the query cache across all shards assigned to the selected nodes. This number
     * includes all current and evicted entries.
     * <p>
     * API name: {@code cache_count}
     * </p>
     */
    public final long cacheCount() {
        return this.cacheCount;
    }

    /**
     * Required - The total number of entries currently stored in the query cache across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code cache_size}
     * </p>
     */
    public final long cacheSize() {
        return this.cacheSize;
    }

    /**
     * Required - The total number of query cache evictions across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code evictions}
     * </p>
     */
    public final long evictions() {
        return this.evictions;
    }

    /**
     * Required - The total number of query cache hits across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code hit_count}
     * </p>
     */
    public final long hitCount() {
        return this.hitCount;
    }

    /**
     * API name: {@code memory_size}
     */
    @Nullable
    public final String memorySize() {
        return this.memorySize;
    }

    /**
     * Required - The total amount, in bytes, of memory used for the query cache across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code memory_size_in_bytes}
     * </p>
     */
    public final long memorySizeInBytes() {
        return this.memorySizeInBytes;
    }

    /**
     * Required - The total number of query cache misses across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code miss_count}
     * </p>
     */
    public final long missCount() {
        return this.missCount;
    }

    /**
     * Required - The total number of hits and misses stored in the query cache across all shards assigned to the selected nodes.
     * <p>
     * API name: {@code total_count}
     * </p>
     */
    public final long totalCount() {
        return this.totalCount;
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
        generator.writeKey("cache_count");
        generator.write(this.cacheCount);

        generator.writeKey("cache_size");
        generator.write(this.cacheSize);

        generator.writeKey("evictions");
        generator.write(this.evictions);

        generator.writeKey("hit_count");
        generator.write(this.hitCount);

        if (this.memorySize != null) {
            generator.writeKey("memory_size");
            generator.write(this.memorySize);
        }

        generator.writeKey("memory_size_in_bytes");
        generator.write(this.memorySizeInBytes);

        generator.writeKey("miss_count");
        generator.write(this.missCount);

        generator.writeKey("total_count");
        generator.write(this.totalCount);
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
     * Builder for {@link QueryCacheStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, QueryCacheStats> {
        private Long cacheCount;
        private Long cacheSize;
        private Long evictions;
        private Long hitCount;
        @Nullable
        private String memorySize;
        private Long memorySizeInBytes;
        private Long missCount;
        private Long totalCount;

        public Builder() {}

        private Builder(QueryCacheStats o) {
            this.cacheCount = o.cacheCount;
            this.cacheSize = o.cacheSize;
            this.evictions = o.evictions;
            this.hitCount = o.hitCount;
            this.memorySize = o.memorySize;
            this.memorySizeInBytes = o.memorySizeInBytes;
            this.missCount = o.missCount;
            this.totalCount = o.totalCount;
        }

        private Builder(Builder o) {
            this.cacheCount = o.cacheCount;
            this.cacheSize = o.cacheSize;
            this.evictions = o.evictions;
            this.hitCount = o.hitCount;
            this.memorySize = o.memorySize;
            this.memorySizeInBytes = o.memorySizeInBytes;
            this.missCount = o.missCount;
            this.totalCount = o.totalCount;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The total number of entries added to the query cache across all shards assigned to the selected nodes. This number
         * includes all current and evicted entries.
         * <p>
         * API name: {@code cache_count}
         * </p>
         */
        @Nonnull
        public final Builder cacheCount(long value) {
            this.cacheCount = value;
            return this;
        }

        /**
         * Required - The total number of entries currently stored in the query cache across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code cache_size}
         * </p>
         */
        @Nonnull
        public final Builder cacheSize(long value) {
            this.cacheSize = value;
            return this;
        }

        /**
         * Required - The total number of query cache evictions across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code evictions}
         * </p>
         */
        @Nonnull
        public final Builder evictions(long value) {
            this.evictions = value;
            return this;
        }

        /**
         * Required - The total number of query cache hits across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code hit_count}
         * </p>
         */
        @Nonnull
        public final Builder hitCount(long value) {
            this.hitCount = value;
            return this;
        }

        /**
         * API name: {@code memory_size}
         */
        @Nonnull
        public final Builder memorySize(@Nullable String value) {
            this.memorySize = value;
            return this;
        }

        /**
         * Required - The total amount, in bytes, of memory used for the query cache across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code memory_size_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder memorySizeInBytes(long value) {
            this.memorySizeInBytes = value;
            return this;
        }

        /**
         * Required - The total number of query cache misses across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code miss_count}
         * </p>
         */
        @Nonnull
        public final Builder missCount(long value) {
            this.missCount = value;
            return this;
        }

        /**
         * Required - The total number of hits and misses stored in the query cache across all shards assigned to the selected nodes.
         * <p>
         * API name: {@code total_count}
         * </p>
         */
        @Nonnull
        public final Builder totalCount(long value) {
            this.totalCount = value;
            return this;
        }

        /**
         * Builds a {@link QueryCacheStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public QueryCacheStats build() {
            _checkSingleUse();

            return new QueryCacheStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link QueryCacheStats}
     */
    public static final JsonpDeserializer<QueryCacheStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        QueryCacheStats::setupQueryCacheStatsDeserializer
    );

    protected static void setupQueryCacheStatsDeserializer(ObjectDeserializer<QueryCacheStats.Builder> op) {
        op.add(Builder::cacheCount, JsonpDeserializer.longDeserializer(), "cache_count");
        op.add(Builder::cacheSize, JsonpDeserializer.longDeserializer(), "cache_size");
        op.add(Builder::evictions, JsonpDeserializer.longDeserializer(), "evictions");
        op.add(Builder::hitCount, JsonpDeserializer.longDeserializer(), "hit_count");
        op.add(Builder::memorySize, JsonpDeserializer.stringDeserializer(), "memory_size");
        op.add(Builder::memorySizeInBytes, JsonpDeserializer.longDeserializer(), "memory_size_in_bytes");
        op.add(Builder::missCount, JsonpDeserializer.longDeserializer(), "miss_count");
        op.add(Builder::totalCount, JsonpDeserializer.longDeserializer(), "total_count");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.cacheCount);
        result = 31 * result + Long.hashCode(this.cacheSize);
        result = 31 * result + Long.hashCode(this.evictions);
        result = 31 * result + Long.hashCode(this.hitCount);
        result = 31 * result + Objects.hashCode(this.memorySize);
        result = 31 * result + Long.hashCode(this.memorySizeInBytes);
        result = 31 * result + Long.hashCode(this.missCount);
        result = 31 * result + Long.hashCode(this.totalCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        QueryCacheStats other = (QueryCacheStats) o;
        return this.cacheCount == other.cacheCount
            && this.cacheSize == other.cacheSize
            && this.evictions == other.evictions
            && this.hitCount == other.hitCount
            && Objects.equals(this.memorySize, other.memorySize)
            && this.memorySizeInBytes == other.memorySizeInBytes
            && this.missCount == other.missCount
            && this.totalCount == other.totalCount;
    }
}
