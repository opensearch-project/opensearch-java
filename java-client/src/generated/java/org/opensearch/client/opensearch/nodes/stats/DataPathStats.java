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

// typedef: nodes.stats.DataPathStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DataPathStats implements PlainJsonSerializable, ToCopyableBuilder<DataPathStats.Builder, DataPathStats> {

    @Nullable
    private final String available;

    @Nullable
    private final Long availableInBytes;

    @Nullable
    private final String cacheReserved;

    @Nullable
    private final Long cacheReservedInBytes;

    @Nullable
    private final String free;

    @Nullable
    private final Long freeInBytes;

    @Nullable
    private final String mount;

    @Nullable
    private final String path;

    @Nullable
    private final String total;

    @Nullable
    private final Long totalInBytes;

    @Nullable
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private DataPathStats(Builder builder) {
        this.available = builder.available;
        this.availableInBytes = builder.availableInBytes;
        this.cacheReserved = builder.cacheReserved;
        this.cacheReservedInBytes = builder.cacheReservedInBytes;
        this.free = builder.free;
        this.freeInBytes = builder.freeInBytes;
        this.mount = builder.mount;
        this.path = builder.path;
        this.total = builder.total;
        this.totalInBytes = builder.totalInBytes;
        this.type = builder.type;
    }

    public static DataPathStats of(Function<DataPathStats.Builder, ObjectBuilder<DataPathStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Total amount of disk space available to this Java virtual machine on this file store.
     * <p>
     * API name: {@code available}
     * </p>
     */
    @Nullable
    public final String available() {
        return this.available;
    }

    /**
     * Total number of bytes available to this Java virtual machine on this file store.
     * <p>
     * API name: {@code available_in_bytes}
     * </p>
     */
    @Nullable
    public final Long availableInBytes() {
        return this.availableInBytes;
    }

    /**
     * Total number of cache bytes reserved available to this Java virtual machine on this file store.
     * <p>
     * API name: {@code cache_reserved}
     * </p>
     */
    @Nullable
    public final String cacheReserved() {
        return this.cacheReserved;
    }

    /**
     * Total number of cache bytes reserved available to this Java virtual machine on this file store.
     * <p>
     * API name: {@code cache_reserved_in_bytes}
     * </p>
     */
    @Nullable
    public final Long cacheReservedInBytes() {
        return this.cacheReservedInBytes;
    }

    /**
     * Total amount of unallocated disk space in the file store.
     * <p>
     * API name: {@code free}
     * </p>
     */
    @Nullable
    public final String free() {
        return this.free;
    }

    /**
     * Total number of unallocated bytes in the file store.
     * <p>
     * API name: {@code free_in_bytes}
     * </p>
     */
    @Nullable
    public final Long freeInBytes() {
        return this.freeInBytes;
    }

    /**
     * Mount point of the file store (for example: <code>/dev/sda2</code>).
     * <p>
     * API name: {@code mount}
     * </p>
     */
    @Nullable
    public final String mount() {
        return this.mount;
    }

    /**
     * Path to the file store.
     * <p>
     * API name: {@code path}
     * </p>
     */
    @Nullable
    public final String path() {
        return this.path;
    }

    /**
     * Total size of the file store.
     * <p>
     * API name: {@code total}
     * </p>
     */
    @Nullable
    public final String total() {
        return this.total;
    }

    /**
     * Total size of the file store in bytes.
     * <p>
     * API name: {@code total_in_bytes}
     * </p>
     */
    @Nullable
    public final Long totalInBytes() {
        return this.totalInBytes;
    }

    /**
     * Type of the file store (ex: ext4).
     * <p>
     * API name: {@code type}
     * </p>
     */
    @Nullable
    public final String type() {
        return this.type;
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
        if (this.available != null) {
            generator.writeKey("available");
            generator.write(this.available);
        }

        if (this.availableInBytes != null) {
            generator.writeKey("available_in_bytes");
            generator.write(this.availableInBytes);
        }

        if (this.cacheReserved != null) {
            generator.writeKey("cache_reserved");
            generator.write(this.cacheReserved);
        }

        if (this.cacheReservedInBytes != null) {
            generator.writeKey("cache_reserved_in_bytes");
            generator.write(this.cacheReservedInBytes);
        }

        if (this.free != null) {
            generator.writeKey("free");
            generator.write(this.free);
        }

        if (this.freeInBytes != null) {
            generator.writeKey("free_in_bytes");
            generator.write(this.freeInBytes);
        }

        if (this.mount != null) {
            generator.writeKey("mount");
            generator.write(this.mount);
        }

        if (this.path != null) {
            generator.writeKey("path");
            generator.write(this.path);
        }

        if (this.total != null) {
            generator.writeKey("total");
            generator.write(this.total);
        }

        if (this.totalInBytes != null) {
            generator.writeKey("total_in_bytes");
            generator.write(this.totalInBytes);
        }

        if (this.type != null) {
            generator.writeKey("type");
            generator.write(this.type);
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
     * Builder for {@link DataPathStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DataPathStats> {
        @Nullable
        private String available;
        @Nullable
        private Long availableInBytes;
        @Nullable
        private String cacheReserved;
        @Nullable
        private Long cacheReservedInBytes;
        @Nullable
        private String free;
        @Nullable
        private Long freeInBytes;
        @Nullable
        private String mount;
        @Nullable
        private String path;
        @Nullable
        private String total;
        @Nullable
        private Long totalInBytes;
        @Nullable
        private String type;

        public Builder() {}

        private Builder(DataPathStats o) {
            this.available = o.available;
            this.availableInBytes = o.availableInBytes;
            this.cacheReserved = o.cacheReserved;
            this.cacheReservedInBytes = o.cacheReservedInBytes;
            this.free = o.free;
            this.freeInBytes = o.freeInBytes;
            this.mount = o.mount;
            this.path = o.path;
            this.total = o.total;
            this.totalInBytes = o.totalInBytes;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.available = o.available;
            this.availableInBytes = o.availableInBytes;
            this.cacheReserved = o.cacheReserved;
            this.cacheReservedInBytes = o.cacheReservedInBytes;
            this.free = o.free;
            this.freeInBytes = o.freeInBytes;
            this.mount = o.mount;
            this.path = o.path;
            this.total = o.total;
            this.totalInBytes = o.totalInBytes;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Total amount of disk space available to this Java virtual machine on this file store.
         * <p>
         * API name: {@code available}
         * </p>
         */
        @Nonnull
        public final Builder available(@Nullable String value) {
            this.available = value;
            return this;
        }

        /**
         * Total number of bytes available to this Java virtual machine on this file store.
         * <p>
         * API name: {@code available_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder availableInBytes(@Nullable Long value) {
            this.availableInBytes = value;
            return this;
        }

        /**
         * Total number of cache bytes reserved available to this Java virtual machine on this file store.
         * <p>
         * API name: {@code cache_reserved}
         * </p>
         */
        @Nonnull
        public final Builder cacheReserved(@Nullable String value) {
            this.cacheReserved = value;
            return this;
        }

        /**
         * Total number of cache bytes reserved available to this Java virtual machine on this file store.
         * <p>
         * API name: {@code cache_reserved_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder cacheReservedInBytes(@Nullable Long value) {
            this.cacheReservedInBytes = value;
            return this;
        }

        /**
         * Total amount of unallocated disk space in the file store.
         * <p>
         * API name: {@code free}
         * </p>
         */
        @Nonnull
        public final Builder free(@Nullable String value) {
            this.free = value;
            return this;
        }

        /**
         * Total number of unallocated bytes in the file store.
         * <p>
         * API name: {@code free_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder freeInBytes(@Nullable Long value) {
            this.freeInBytes = value;
            return this;
        }

        /**
         * Mount point of the file store (for example: <code>/dev/sda2</code>).
         * <p>
         * API name: {@code mount}
         * </p>
         */
        @Nonnull
        public final Builder mount(@Nullable String value) {
            this.mount = value;
            return this;
        }

        /**
         * Path to the file store.
         * <p>
         * API name: {@code path}
         * </p>
         */
        @Nonnull
        public final Builder path(@Nullable String value) {
            this.path = value;
            return this;
        }

        /**
         * Total size of the file store.
         * <p>
         * API name: {@code total}
         * </p>
         */
        @Nonnull
        public final Builder total(@Nullable String value) {
            this.total = value;
            return this;
        }

        /**
         * Total size of the file store in bytes.
         * <p>
         * API name: {@code total_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder totalInBytes(@Nullable Long value) {
            this.totalInBytes = value;
            return this;
        }

        /**
         * Type of the file store (ex: ext4).
         * <p>
         * API name: {@code type}
         * </p>
         */
        @Nonnull
        public final Builder type(@Nullable String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link DataPathStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DataPathStats build() {
            _checkSingleUse();

            return new DataPathStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DataPathStats}
     */
    public static final JsonpDeserializer<DataPathStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DataPathStats::setupDataPathStatsDeserializer
    );

    protected static void setupDataPathStatsDeserializer(ObjectDeserializer<DataPathStats.Builder> op) {
        op.add(Builder::available, JsonpDeserializer.stringDeserializer(), "available");
        op.add(Builder::availableInBytes, JsonpDeserializer.longDeserializer(), "available_in_bytes");
        op.add(Builder::cacheReserved, JsonpDeserializer.stringDeserializer(), "cache_reserved");
        op.add(Builder::cacheReservedInBytes, JsonpDeserializer.longDeserializer(), "cache_reserved_in_bytes");
        op.add(Builder::free, JsonpDeserializer.stringDeserializer(), "free");
        op.add(Builder::freeInBytes, JsonpDeserializer.longDeserializer(), "free_in_bytes");
        op.add(Builder::mount, JsonpDeserializer.stringDeserializer(), "mount");
        op.add(Builder::path, JsonpDeserializer.stringDeserializer(), "path");
        op.add(Builder::total, JsonpDeserializer.stringDeserializer(), "total");
        op.add(Builder::totalInBytes, JsonpDeserializer.longDeserializer(), "total_in_bytes");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.available);
        result = 31 * result + Objects.hashCode(this.availableInBytes);
        result = 31 * result + Objects.hashCode(this.cacheReserved);
        result = 31 * result + Objects.hashCode(this.cacheReservedInBytes);
        result = 31 * result + Objects.hashCode(this.free);
        result = 31 * result + Objects.hashCode(this.freeInBytes);
        result = 31 * result + Objects.hashCode(this.mount);
        result = 31 * result + Objects.hashCode(this.path);
        result = 31 * result + Objects.hashCode(this.total);
        result = 31 * result + Objects.hashCode(this.totalInBytes);
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DataPathStats other = (DataPathStats) o;
        return Objects.equals(this.available, other.available)
            && Objects.equals(this.availableInBytes, other.availableInBytes)
            && Objects.equals(this.cacheReserved, other.cacheReserved)
            && Objects.equals(this.cacheReservedInBytes, other.cacheReservedInBytes)
            && Objects.equals(this.free, other.free)
            && Objects.equals(this.freeInBytes, other.freeInBytes)
            && Objects.equals(this.mount, other.mount)
            && Objects.equals(this.path, other.path)
            && Objects.equals(this.total, other.total)
            && Objects.equals(this.totalInBytes, other.totalInBytes)
            && Objects.equals(this.type, other.type);
    }
}
