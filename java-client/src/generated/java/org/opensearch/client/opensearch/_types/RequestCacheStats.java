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

// typedef: _types.RequestCacheStats

/**
 * The statistics about request cache operations.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RequestCacheStats implements PlainJsonSerializable, ToCopyableBuilder<RequestCacheStats.Builder, RequestCacheStats> {

    private final long evictions;

    private final long hitCount;

    @Nullable
    private final String memorySize;

    private final long memorySizeInBytes;

    private final long missCount;

    // ---------------------------------------------------------------------------------------------

    private RequestCacheStats(Builder builder) {
        this.evictions = ApiTypeHelper.requireNonNull(builder.evictions, this, "evictions");
        this.hitCount = ApiTypeHelper.requireNonNull(builder.hitCount, this, "hitCount");
        this.memorySize = builder.memorySize;
        this.memorySizeInBytes = ApiTypeHelper.requireNonNull(builder.memorySizeInBytes, this, "memorySizeInBytes");
        this.missCount = ApiTypeHelper.requireNonNull(builder.missCount, this, "missCount");
    }

    public static RequestCacheStats of(Function<RequestCacheStats.Builder, ObjectBuilder<RequestCacheStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The number of request cache evictions.
     * <p>
     * API name: {@code evictions}
     * </p>
     */
    public final long evictions() {
        return this.evictions;
    }

    /**
     * Required - The number of request cache hits.
     * <p>
     * API name: {@code hit_count}
     * </p>
     */
    public final long hitCount() {
        return this.hitCount;
    }

    /**
     * The size of the request cache in a human-readable format.
     * <p>
     * API name: {@code memory_size}
     * </p>
     */
    @Nullable
    public final String memorySize() {
        return this.memorySize;
    }

    /**
     * Required - The size of the request cache in bytes.
     * <p>
     * API name: {@code memory_size_in_bytes}
     * </p>
     */
    public final long memorySizeInBytes() {
        return this.memorySizeInBytes;
    }

    /**
     * Required - The number of request cache misses.
     * <p>
     * API name: {@code miss_count}
     * </p>
     */
    public final long missCount() {
        return this.missCount;
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
     * Builder for {@link RequestCacheStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RequestCacheStats> {
        private Long evictions;
        private Long hitCount;
        @Nullable
        private String memorySize;
        private Long memorySizeInBytes;
        private Long missCount;

        public Builder() {}

        private Builder(RequestCacheStats o) {
            this.evictions = o.evictions;
            this.hitCount = o.hitCount;
            this.memorySize = o.memorySize;
            this.memorySizeInBytes = o.memorySizeInBytes;
            this.missCount = o.missCount;
        }

        private Builder(Builder o) {
            this.evictions = o.evictions;
            this.hitCount = o.hitCount;
            this.memorySize = o.memorySize;
            this.memorySizeInBytes = o.memorySizeInBytes;
            this.missCount = o.missCount;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The number of request cache evictions.
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
         * Required - The number of request cache hits.
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
         * The size of the request cache in a human-readable format.
         * <p>
         * API name: {@code memory_size}
         * </p>
         */
        @Nonnull
        public final Builder memorySize(@Nullable String value) {
            this.memorySize = value;
            return this;
        }

        /**
         * Required - The size of the request cache in bytes.
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
         * Required - The number of request cache misses.
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
         * Builds a {@link RequestCacheStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RequestCacheStats build() {
            _checkSingleUse();

            return new RequestCacheStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RequestCacheStats}
     */
    public static final JsonpDeserializer<RequestCacheStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RequestCacheStats::setupRequestCacheStatsDeserializer
    );

    protected static void setupRequestCacheStatsDeserializer(ObjectDeserializer<RequestCacheStats.Builder> op) {
        op.add(Builder::evictions, JsonpDeserializer.longDeserializer(), "evictions");
        op.add(Builder::hitCount, JsonpDeserializer.longDeserializer(), "hit_count");
        op.add(Builder::memorySize, JsonpDeserializer.stringDeserializer(), "memory_size");
        op.add(Builder::memorySizeInBytes, JsonpDeserializer.longDeserializer(), "memory_size_in_bytes");
        op.add(Builder::missCount, JsonpDeserializer.longDeserializer(), "miss_count");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.evictions);
        result = 31 * result + Long.hashCode(this.hitCount);
        result = 31 * result + Objects.hashCode(this.memorySize);
        result = 31 * result + Long.hashCode(this.memorySizeInBytes);
        result = 31 * result + Long.hashCode(this.missCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RequestCacheStats other = (RequestCacheStats) o;
        return this.evictions == other.evictions
            && this.hitCount == other.hitCount
            && Objects.equals(this.memorySize, other.memorySize)
            && this.memorySizeInBytes == other.memorySizeInBytes
            && this.missCount == other.missCount;
    }
}
