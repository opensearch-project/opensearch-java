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

// typedef: nodes.stats.ShardCacheStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardCacheStats implements PlainJsonSerializable, ToCopyableBuilder<ShardCacheStats.Builder, ShardCacheStats> {

    @Nullable
    private final Long evictions;

    @Nullable
    private final Long hitCount;

    @Nullable
    private final Long itemCount;

    @Nullable
    private final Long missCount;

    @Nullable
    private final String size;

    @Nullable
    private final Long sizeInBytes;

    @Nullable
    private final String storeName;

    // ---------------------------------------------------------------------------------------------

    private ShardCacheStats(Builder builder) {
        this.evictions = builder.evictions;
        this.hitCount = builder.hitCount;
        this.itemCount = builder.itemCount;
        this.missCount = builder.missCount;
        this.size = builder.size;
        this.sizeInBytes = builder.sizeInBytes;
        this.storeName = builder.storeName;
    }

    public static ShardCacheStats of(Function<ShardCacheStats.Builder, ObjectBuilder<ShardCacheStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code evictions}
     */
    @Nullable
    public final Long evictions() {
        return this.evictions;
    }

    /**
     * API name: {@code hit_count}
     */
    @Nullable
    public final Long hitCount() {
        return this.hitCount;
    }

    /**
     * API name: {@code item_count}
     */
    @Nullable
    public final Long itemCount() {
        return this.itemCount;
    }

    /**
     * API name: {@code miss_count}
     */
    @Nullable
    public final Long missCount() {
        return this.missCount;
    }

    /**
     * API name: {@code size}
     */
    @Nullable
    public final String size() {
        return this.size;
    }

    /**
     * API name: {@code size_in_bytes}
     */
    @Nullable
    public final Long sizeInBytes() {
        return this.sizeInBytes;
    }

    /**
     * API name: {@code store_name}
     */
    @Nullable
    public final String storeName() {
        return this.storeName;
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
        if (this.evictions != null) {
            generator.writeKey("evictions");
            generator.write(this.evictions);
        }

        if (this.hitCount != null) {
            generator.writeKey("hit_count");
            generator.write(this.hitCount);
        }

        if (this.itemCount != null) {
            generator.writeKey("item_count");
            generator.write(this.itemCount);
        }

        if (this.missCount != null) {
            generator.writeKey("miss_count");
            generator.write(this.missCount);
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        if (this.sizeInBytes != null) {
            generator.writeKey("size_in_bytes");
            generator.write(this.sizeInBytes);
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
     * Builder for {@link ShardCacheStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardCacheStats> {
        @Nullable
        private Long evictions;
        @Nullable
        private Long hitCount;
        @Nullable
        private Long itemCount;
        @Nullable
        private Long missCount;
        @Nullable
        private String size;
        @Nullable
        private Long sizeInBytes;
        @Nullable
        private String storeName;

        public Builder() {}

        private Builder(ShardCacheStats o) {
            this.evictions = o.evictions;
            this.hitCount = o.hitCount;
            this.itemCount = o.itemCount;
            this.missCount = o.missCount;
            this.size = o.size;
            this.sizeInBytes = o.sizeInBytes;
            this.storeName = o.storeName;
        }

        private Builder(Builder o) {
            this.evictions = o.evictions;
            this.hitCount = o.hitCount;
            this.itemCount = o.itemCount;
            this.missCount = o.missCount;
            this.size = o.size;
            this.sizeInBytes = o.sizeInBytes;
            this.storeName = o.storeName;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code evictions}
         */
        @Nonnull
        public final Builder evictions(@Nullable Long value) {
            this.evictions = value;
            return this;
        }

        /**
         * API name: {@code hit_count}
         */
        @Nonnull
        public final Builder hitCount(@Nullable Long value) {
            this.hitCount = value;
            return this;
        }

        /**
         * API name: {@code item_count}
         */
        @Nonnull
        public final Builder itemCount(@Nullable Long value) {
            this.itemCount = value;
            return this;
        }

        /**
         * API name: {@code miss_count}
         */
        @Nonnull
        public final Builder missCount(@Nullable Long value) {
            this.missCount = value;
            return this;
        }

        /**
         * API name: {@code size}
         */
        @Nonnull
        public final Builder size(@Nullable String value) {
            this.size = value;
            return this;
        }

        /**
         * API name: {@code size_in_bytes}
         */
        @Nonnull
        public final Builder sizeInBytes(@Nullable Long value) {
            this.sizeInBytes = value;
            return this;
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
         * Builds a {@link ShardCacheStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardCacheStats build() {
            _checkSingleUse();

            return new ShardCacheStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardCacheStats}
     */
    public static final JsonpDeserializer<ShardCacheStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardCacheStats::setupShardCacheStatsDeserializer
    );

    protected static void setupShardCacheStatsDeserializer(ObjectDeserializer<ShardCacheStats.Builder> op) {
        op.add(Builder::evictions, JsonpDeserializer.longDeserializer(), "evictions");
        op.add(Builder::hitCount, JsonpDeserializer.longDeserializer(), "hit_count");
        op.add(Builder::itemCount, JsonpDeserializer.longDeserializer(), "item_count");
        op.add(Builder::missCount, JsonpDeserializer.longDeserializer(), "miss_count");
        op.add(Builder::size, JsonpDeserializer.stringDeserializer(), "size");
        op.add(Builder::sizeInBytes, JsonpDeserializer.longDeserializer(), "size_in_bytes");
        op.add(Builder::storeName, JsonpDeserializer.stringDeserializer(), "store_name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.evictions);
        result = 31 * result + Objects.hashCode(this.hitCount);
        result = 31 * result + Objects.hashCode(this.itemCount);
        result = 31 * result + Objects.hashCode(this.missCount);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.sizeInBytes);
        result = 31 * result + Objects.hashCode(this.storeName);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardCacheStats other = (ShardCacheStats) o;
        return Objects.equals(this.evictions, other.evictions)
            && Objects.equals(this.hitCount, other.hitCount)
            && Objects.equals(this.itemCount, other.itemCount)
            && Objects.equals(this.missCount, other.missCount)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.sizeInBytes, other.sizeInBytes)
            && Objects.equals(this.storeName, other.storeName);
    }
}
