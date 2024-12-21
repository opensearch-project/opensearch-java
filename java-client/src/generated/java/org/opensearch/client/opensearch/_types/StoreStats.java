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

// typedef: _types.StoreStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class StoreStats implements PlainJsonSerializable, ToCopyableBuilder<StoreStats.Builder, StoreStats> {

    @Nullable
    private final String reserved;

    private final long reservedInBytes;

    @Nullable
    private final String size;

    private final long sizeInBytes;

    // ---------------------------------------------------------------------------------------------

    private StoreStats(Builder builder) {
        this.reserved = builder.reserved;
        this.reservedInBytes = ApiTypeHelper.requireNonNull(builder.reservedInBytes, this, "reservedInBytes");
        this.size = builder.size;
        this.sizeInBytes = ApiTypeHelper.requireNonNull(builder.sizeInBytes, this, "sizeInBytes");
    }

    public static StoreStats of(Function<StoreStats.Builder, ObjectBuilder<StoreStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code reserved}
     */
    @Nullable
    public final String reserved() {
        return this.reserved;
    }

    /**
     * Required - A prediction, in bytes, of how much larger the shard stores will eventually grow due to ongoing peer recoveries, restoring
     * snapshots, and similar activities.
     * <p>
     * API name: {@code reserved_in_bytes}
     * </p>
     */
    public final long reservedInBytes() {
        return this.reservedInBytes;
    }

    /**
     * API name: {@code size}
     */
    @Nullable
    public final String size() {
        return this.size;
    }

    /**
     * Required - The total size, in bytes, of all shards assigned to the selected nodes.
     * <p>
     * API name: {@code size_in_bytes}
     * </p>
     */
    public final long sizeInBytes() {
        return this.sizeInBytes;
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
        if (this.reserved != null) {
            generator.writeKey("reserved");
            generator.write(this.reserved);
        }

        generator.writeKey("reserved_in_bytes");
        generator.write(this.reservedInBytes);

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        generator.writeKey("size_in_bytes");
        generator.write(this.sizeInBytes);
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
     * Builder for {@link StoreStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, StoreStats> {
        @Nullable
        private String reserved;
        private Long reservedInBytes;
        @Nullable
        private String size;
        private Long sizeInBytes;

        public Builder() {}

        private Builder(StoreStats o) {
            this.reserved = o.reserved;
            this.reservedInBytes = o.reservedInBytes;
            this.size = o.size;
            this.sizeInBytes = o.sizeInBytes;
        }

        private Builder(Builder o) {
            this.reserved = o.reserved;
            this.reservedInBytes = o.reservedInBytes;
            this.size = o.size;
            this.sizeInBytes = o.sizeInBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code reserved}
         */
        @Nonnull
        public final Builder reserved(@Nullable String value) {
            this.reserved = value;
            return this;
        }

        /**
         * Required - A prediction, in bytes, of how much larger the shard stores will eventually grow due to ongoing peer recoveries,
         * restoring snapshots, and similar activities.
         * <p>
         * API name: {@code reserved_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder reservedInBytes(long value) {
            this.reservedInBytes = value;
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
         * Required - The total size, in bytes, of all shards assigned to the selected nodes.
         * <p>
         * API name: {@code size_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder sizeInBytes(long value) {
            this.sizeInBytes = value;
            return this;
        }

        /**
         * Builds a {@link StoreStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public StoreStats build() {
            _checkSingleUse();

            return new StoreStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link StoreStats}
     */
    public static final JsonpDeserializer<StoreStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        StoreStats::setupStoreStatsDeserializer
    );

    protected static void setupStoreStatsDeserializer(ObjectDeserializer<StoreStats.Builder> op) {
        op.add(Builder::reserved, JsonpDeserializer.stringDeserializer(), "reserved");
        op.add(Builder::reservedInBytes, JsonpDeserializer.longDeserializer(), "reserved_in_bytes");
        op.add(Builder::size, JsonpDeserializer.stringDeserializer(), "size");
        op.add(Builder::sizeInBytes, JsonpDeserializer.longDeserializer(), "size_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.reserved);
        result = 31 * result + Long.hashCode(this.reservedInBytes);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Long.hashCode(this.sizeInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        StoreStats other = (StoreStats) o;
        return Objects.equals(this.reserved, other.reserved)
            && this.reservedInBytes == other.reservedInBytes
            && Objects.equals(this.size, other.size)
            && this.sizeInBytes == other.sizeInBytes;
    }
}
