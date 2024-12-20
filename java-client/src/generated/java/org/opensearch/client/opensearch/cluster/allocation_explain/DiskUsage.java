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

package org.opensearch.client.opensearch.cluster.allocation_explain;

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

// typedef: cluster.allocation_explain.DiskUsage

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DiskUsage implements PlainJsonSerializable, ToCopyableBuilder<DiskUsage.Builder, DiskUsage> {

    @Nullable
    private final String free;

    private final long freeBytes;

    private final double freeDiskPercent;

    @Nonnull
    private final String path;

    @Nullable
    private final String total;

    private final long totalBytes;

    @Nullable
    private final String used;

    private final long usedBytes;

    private final double usedDiskPercent;

    // ---------------------------------------------------------------------------------------------

    private DiskUsage(Builder builder) {
        this.free = builder.free;
        this.freeBytes = ApiTypeHelper.requireNonNull(builder.freeBytes, this, "freeBytes");
        this.freeDiskPercent = ApiTypeHelper.requireNonNull(builder.freeDiskPercent, this, "freeDiskPercent");
        this.path = ApiTypeHelper.requireNonNull(builder.path, this, "path");
        this.total = builder.total;
        this.totalBytes = ApiTypeHelper.requireNonNull(builder.totalBytes, this, "totalBytes");
        this.used = builder.used;
        this.usedBytes = ApiTypeHelper.requireNonNull(builder.usedBytes, this, "usedBytes");
        this.usedDiskPercent = ApiTypeHelper.requireNonNull(builder.usedDiskPercent, this, "usedDiskPercent");
    }

    public static DiskUsage of(Function<DiskUsage.Builder, ObjectBuilder<DiskUsage>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code free}
     */
    @Nullable
    public final String free() {
        return this.free;
    }

    /**
     * Required - API name: {@code free_bytes}
     */
    public final long freeBytes() {
        return this.freeBytes;
    }

    /**
     * Required - API name: {@code free_disk_percent}
     */
    public final double freeDiskPercent() {
        return this.freeDiskPercent;
    }

    /**
     * Required - API name: {@code path}
     */
    @Nonnull
    public final String path() {
        return this.path;
    }

    /**
     * API name: {@code total}
     */
    @Nullable
    public final String total() {
        return this.total;
    }

    /**
     * Required - API name: {@code total_bytes}
     */
    public final long totalBytes() {
        return this.totalBytes;
    }

    /**
     * API name: {@code used}
     */
    @Nullable
    public final String used() {
        return this.used;
    }

    /**
     * Required - API name: {@code used_bytes}
     */
    public final long usedBytes() {
        return this.usedBytes;
    }

    /**
     * Required - API name: {@code used_disk_percent}
     */
    public final double usedDiskPercent() {
        return this.usedDiskPercent;
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
        if (this.free != null) {
            generator.writeKey("free");
            generator.write(this.free);
        }

        generator.writeKey("free_bytes");
        generator.write(this.freeBytes);

        generator.writeKey("free_disk_percent");
        generator.write(this.freeDiskPercent);

        generator.writeKey("path");
        generator.write(this.path);

        if (this.total != null) {
            generator.writeKey("total");
            generator.write(this.total);
        }

        generator.writeKey("total_bytes");
        generator.write(this.totalBytes);

        if (this.used != null) {
            generator.writeKey("used");
            generator.write(this.used);
        }

        generator.writeKey("used_bytes");
        generator.write(this.usedBytes);

        generator.writeKey("used_disk_percent");
        generator.write(this.usedDiskPercent);
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
     * Builder for {@link DiskUsage}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DiskUsage> {
        @Nullable
        private String free;
        private Long freeBytes;
        private Double freeDiskPercent;
        private String path;
        @Nullable
        private String total;
        private Long totalBytes;
        @Nullable
        private String used;
        private Long usedBytes;
        private Double usedDiskPercent;

        public Builder() {}

        private Builder(DiskUsage o) {
            this.free = o.free;
            this.freeBytes = o.freeBytes;
            this.freeDiskPercent = o.freeDiskPercent;
            this.path = o.path;
            this.total = o.total;
            this.totalBytes = o.totalBytes;
            this.used = o.used;
            this.usedBytes = o.usedBytes;
            this.usedDiskPercent = o.usedDiskPercent;
        }

        private Builder(Builder o) {
            this.free = o.free;
            this.freeBytes = o.freeBytes;
            this.freeDiskPercent = o.freeDiskPercent;
            this.path = o.path;
            this.total = o.total;
            this.totalBytes = o.totalBytes;
            this.used = o.used;
            this.usedBytes = o.usedBytes;
            this.usedDiskPercent = o.usedDiskPercent;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code free}
         */
        @Nonnull
        public final Builder free(@Nullable String value) {
            this.free = value;
            return this;
        }

        /**
         * Required - API name: {@code free_bytes}
         */
        @Nonnull
        public final Builder freeBytes(long value) {
            this.freeBytes = value;
            return this;
        }

        /**
         * Required - API name: {@code free_disk_percent}
         */
        @Nonnull
        public final Builder freeDiskPercent(double value) {
            this.freeDiskPercent = value;
            return this;
        }

        /**
         * Required - API name: {@code path}
         */
        @Nonnull
        public final Builder path(String value) {
            this.path = value;
            return this;
        }

        /**
         * API name: {@code total}
         */
        @Nonnull
        public final Builder total(@Nullable String value) {
            this.total = value;
            return this;
        }

        /**
         * Required - API name: {@code total_bytes}
         */
        @Nonnull
        public final Builder totalBytes(long value) {
            this.totalBytes = value;
            return this;
        }

        /**
         * API name: {@code used}
         */
        @Nonnull
        public final Builder used(@Nullable String value) {
            this.used = value;
            return this;
        }

        /**
         * Required - API name: {@code used_bytes}
         */
        @Nonnull
        public final Builder usedBytes(long value) {
            this.usedBytes = value;
            return this;
        }

        /**
         * Required - API name: {@code used_disk_percent}
         */
        @Nonnull
        public final Builder usedDiskPercent(double value) {
            this.usedDiskPercent = value;
            return this;
        }

        /**
         * Builds a {@link DiskUsage}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DiskUsage build() {
            _checkSingleUse();

            return new DiskUsage(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DiskUsage}
     */
    public static final JsonpDeserializer<DiskUsage> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DiskUsage::setupDiskUsageDeserializer
    );

    protected static void setupDiskUsageDeserializer(ObjectDeserializer<DiskUsage.Builder> op) {
        op.add(Builder::free, JsonpDeserializer.stringDeserializer(), "free");
        op.add(Builder::freeBytes, JsonpDeserializer.longDeserializer(), "free_bytes");
        op.add(Builder::freeDiskPercent, JsonpDeserializer.doubleDeserializer(), "free_disk_percent");
        op.add(Builder::path, JsonpDeserializer.stringDeserializer(), "path");
        op.add(Builder::total, JsonpDeserializer.stringDeserializer(), "total");
        op.add(Builder::totalBytes, JsonpDeserializer.longDeserializer(), "total_bytes");
        op.add(Builder::used, JsonpDeserializer.stringDeserializer(), "used");
        op.add(Builder::usedBytes, JsonpDeserializer.longDeserializer(), "used_bytes");
        op.add(Builder::usedDiskPercent, JsonpDeserializer.doubleDeserializer(), "used_disk_percent");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.free);
        result = 31 * result + Long.hashCode(this.freeBytes);
        result = 31 * result + Double.hashCode(this.freeDiskPercent);
        result = 31 * result + this.path.hashCode();
        result = 31 * result + Objects.hashCode(this.total);
        result = 31 * result + Long.hashCode(this.totalBytes);
        result = 31 * result + Objects.hashCode(this.used);
        result = 31 * result + Long.hashCode(this.usedBytes);
        result = 31 * result + Double.hashCode(this.usedDiskPercent);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DiskUsage other = (DiskUsage) o;
        return Objects.equals(this.free, other.free)
            && this.freeBytes == other.freeBytes
            && this.freeDiskPercent == other.freeDiskPercent
            && this.path.equals(other.path)
            && Objects.equals(this.total, other.total)
            && this.totalBytes == other.totalBytes
            && Objects.equals(this.used, other.used)
            && this.usedBytes == other.usedBytes
            && this.usedDiskPercent == other.usedDiskPercent;
    }
}
