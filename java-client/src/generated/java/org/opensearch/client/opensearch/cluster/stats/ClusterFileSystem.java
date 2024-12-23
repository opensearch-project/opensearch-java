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

package org.opensearch.client.opensearch.cluster.stats;

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

// typedef: cluster.stats.ClusterFileSystem

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterFileSystem implements PlainJsonSerializable, ToCopyableBuilder<ClusterFileSystem.Builder, ClusterFileSystem> {

    @Nullable
    private final String available;

    private final long availableInBytes;

    @Nullable
    private final String cacheReserved;

    @Nullable
    private final Long cacheReservedInBytes;

    @Nullable
    private final String free;

    private final long freeInBytes;

    @Nullable
    private final String total;

    private final long totalInBytes;

    // ---------------------------------------------------------------------------------------------

    private ClusterFileSystem(Builder builder) {
        this.available = builder.available;
        this.availableInBytes = ApiTypeHelper.requireNonNull(builder.availableInBytes, this, "availableInBytes");
        this.cacheReserved = builder.cacheReserved;
        this.cacheReservedInBytes = builder.cacheReservedInBytes;
        this.free = builder.free;
        this.freeInBytes = ApiTypeHelper.requireNonNull(builder.freeInBytes, this, "freeInBytes");
        this.total = builder.total;
        this.totalInBytes = ApiTypeHelper.requireNonNull(builder.totalInBytes, this, "totalInBytes");
    }

    public static ClusterFileSystem of(Function<ClusterFileSystem.Builder, ObjectBuilder<ClusterFileSystem>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Total number of bytes available to JVM in file stores across all selected nodes. Depending on operating system or process-level
     * restrictions, this number may be less than <code>nodes.fs.free_in_byes</code>. This is the actual amount of free disk space the
     * selected OpenSearch nodes can use.
     * <p>
     * API name: {@code available}
     * </p>
     */
    @Nullable
    public final String available() {
        return this.available;
    }

    /**
     * Required - Total number of bytes available to JVM in file stores across all selected nodes. Depending on operating system or
     * process-level restrictions, this number may be less than <code>nodes.fs.free_in_byes</code>. This is the actual amount of free disk
     * space the selected OpenSearch nodes can use.
     * <p>
     * API name: {@code available_in_bytes}
     * </p>
     */
    public final long availableInBytes() {
        return this.availableInBytes;
    }

    /**
     * Total size, of all cache reserved across all selected nodes.
     * <p>
     * API name: {@code cache_reserved}
     * </p>
     */
    @Nullable
    public final String cacheReserved() {
        return this.cacheReserved;
    }

    /**
     * Total size, in bytes, of all cache reserved across all selected nodes.
     * <p>
     * API name: {@code cache_reserved_in_bytes}
     * </p>
     */
    @Nullable
    public final Long cacheReservedInBytes() {
        return this.cacheReservedInBytes;
    }

    /**
     * Total number of unallocated bytes in file stores across all selected nodes.
     * <p>
     * API name: {@code free}
     * </p>
     */
    @Nullable
    public final String free() {
        return this.free;
    }

    /**
     * Required - Total number of unallocated bytes in file stores across all selected nodes.
     * <p>
     * API name: {@code free_in_bytes}
     * </p>
     */
    public final long freeInBytes() {
        return this.freeInBytes;
    }

    /**
     * Total size, of all file stores across all selected nodes.
     * <p>
     * API name: {@code total}
     * </p>
     */
    @Nullable
    public final String total() {
        return this.total;
    }

    /**
     * Required - Total size, in bytes, of all file stores across all selected nodes.
     * <p>
     * API name: {@code total_in_bytes}
     * </p>
     */
    public final long totalInBytes() {
        return this.totalInBytes;
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

        generator.writeKey("available_in_bytes");
        generator.write(this.availableInBytes);

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

        generator.writeKey("free_in_bytes");
        generator.write(this.freeInBytes);

        if (this.total != null) {
            generator.writeKey("total");
            generator.write(this.total);
        }

        generator.writeKey("total_in_bytes");
        generator.write(this.totalInBytes);
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
     * Builder for {@link ClusterFileSystem}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterFileSystem> {
        @Nullable
        private String available;
        private Long availableInBytes;
        @Nullable
        private String cacheReserved;
        @Nullable
        private Long cacheReservedInBytes;
        @Nullable
        private String free;
        private Long freeInBytes;
        @Nullable
        private String total;
        private Long totalInBytes;

        public Builder() {}

        private Builder(ClusterFileSystem o) {
            this.available = o.available;
            this.availableInBytes = o.availableInBytes;
            this.cacheReserved = o.cacheReserved;
            this.cacheReservedInBytes = o.cacheReservedInBytes;
            this.free = o.free;
            this.freeInBytes = o.freeInBytes;
            this.total = o.total;
            this.totalInBytes = o.totalInBytes;
        }

        private Builder(Builder o) {
            this.available = o.available;
            this.availableInBytes = o.availableInBytes;
            this.cacheReserved = o.cacheReserved;
            this.cacheReservedInBytes = o.cacheReservedInBytes;
            this.free = o.free;
            this.freeInBytes = o.freeInBytes;
            this.total = o.total;
            this.totalInBytes = o.totalInBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Total number of bytes available to JVM in file stores across all selected nodes. Depending on operating system or process-level
         * restrictions, this number may be less than <code>nodes.fs.free_in_byes</code>. This is the actual amount of free disk space the
         * selected OpenSearch nodes can use.
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
         * Required - Total number of bytes available to JVM in file stores across all selected nodes. Depending on operating system or
         * process-level restrictions, this number may be less than <code>nodes.fs.free_in_byes</code>. This is the actual amount of free
         * disk space the selected OpenSearch nodes can use.
         * <p>
         * API name: {@code available_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder availableInBytes(long value) {
            this.availableInBytes = value;
            return this;
        }

        /**
         * Total size, of all cache reserved across all selected nodes.
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
         * Total size, in bytes, of all cache reserved across all selected nodes.
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
         * Total number of unallocated bytes in file stores across all selected nodes.
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
         * Required - Total number of unallocated bytes in file stores across all selected nodes.
         * <p>
         * API name: {@code free_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder freeInBytes(long value) {
            this.freeInBytes = value;
            return this;
        }

        /**
         * Total size, of all file stores across all selected nodes.
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
         * Required - Total size, in bytes, of all file stores across all selected nodes.
         * <p>
         * API name: {@code total_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder totalInBytes(long value) {
            this.totalInBytes = value;
            return this;
        }

        /**
         * Builds a {@link ClusterFileSystem}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterFileSystem build() {
            _checkSingleUse();

            return new ClusterFileSystem(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterFileSystem}
     */
    public static final JsonpDeserializer<ClusterFileSystem> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterFileSystem::setupClusterFileSystemDeserializer
    );

    protected static void setupClusterFileSystemDeserializer(ObjectDeserializer<ClusterFileSystem.Builder> op) {
        op.add(Builder::available, JsonpDeserializer.stringDeserializer(), "available");
        op.add(Builder::availableInBytes, JsonpDeserializer.longDeserializer(), "available_in_bytes");
        op.add(Builder::cacheReserved, JsonpDeserializer.stringDeserializer(), "cache_reserved");
        op.add(Builder::cacheReservedInBytes, JsonpDeserializer.longDeserializer(), "cache_reserved_in_bytes");
        op.add(Builder::free, JsonpDeserializer.stringDeserializer(), "free");
        op.add(Builder::freeInBytes, JsonpDeserializer.longDeserializer(), "free_in_bytes");
        op.add(Builder::total, JsonpDeserializer.stringDeserializer(), "total");
        op.add(Builder::totalInBytes, JsonpDeserializer.longDeserializer(), "total_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.available);
        result = 31 * result + Long.hashCode(this.availableInBytes);
        result = 31 * result + Objects.hashCode(this.cacheReserved);
        result = 31 * result + Objects.hashCode(this.cacheReservedInBytes);
        result = 31 * result + Objects.hashCode(this.free);
        result = 31 * result + Long.hashCode(this.freeInBytes);
        result = 31 * result + Objects.hashCode(this.total);
        result = 31 * result + Long.hashCode(this.totalInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterFileSystem other = (ClusterFileSystem) o;
        return Objects.equals(this.available, other.available)
            && this.availableInBytes == other.availableInBytes
            && Objects.equals(this.cacheReserved, other.cacheReserved)
            && Objects.equals(this.cacheReservedInBytes, other.cacheReservedInBytes)
            && Objects.equals(this.free, other.free)
            && this.freeInBytes == other.freeInBytes
            && Objects.equals(this.total, other.total)
            && this.totalInBytes == other.totalInBytes;
    }
}
