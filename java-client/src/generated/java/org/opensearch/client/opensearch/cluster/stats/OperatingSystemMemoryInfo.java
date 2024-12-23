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

// typedef: cluster.stats.OperatingSystemMemoryInfo

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OperatingSystemMemoryInfo
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<OperatingSystemMemoryInfo.Builder, OperatingSystemMemoryInfo> {

    @Nullable
    private final Long adjustedTotalInBytes;

    @Nullable
    private final String free;

    private final long freeInBytes;

    private final double freePercent;

    @Nullable
    private final String total;

    private final long totalInBytes;

    @Nullable
    private final String used;

    private final long usedInBytes;

    private final double usedPercent;

    // ---------------------------------------------------------------------------------------------

    private OperatingSystemMemoryInfo(Builder builder) {
        this.adjustedTotalInBytes = builder.adjustedTotalInBytes;
        this.free = builder.free;
        this.freeInBytes = ApiTypeHelper.requireNonNull(builder.freeInBytes, this, "freeInBytes");
        this.freePercent = ApiTypeHelper.requireNonNull(builder.freePercent, this, "freePercent");
        this.total = builder.total;
        this.totalInBytes = ApiTypeHelper.requireNonNull(builder.totalInBytes, this, "totalInBytes");
        this.used = builder.used;
        this.usedInBytes = ApiTypeHelper.requireNonNull(builder.usedInBytes, this, "usedInBytes");
        this.usedPercent = ApiTypeHelper.requireNonNull(builder.usedPercent, this, "usedPercent");
    }

    public static OperatingSystemMemoryInfo of(Function<OperatingSystemMemoryInfo.Builder, ObjectBuilder<OperatingSystemMemoryInfo>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Total amount, in bytes, of memory across all selected nodes, but using the value specified using the
     * <code>es.total_memory_bytes</code> system property instead of measured total memory for those nodes where that system property was
     * set.
     * <p>
     * API name: {@code adjusted_total_in_bytes}
     * </p>
     */
    @Nullable
    public final Long adjustedTotalInBytes() {
        return this.adjustedTotalInBytes;
    }

    /**
     * Amount, in bytes, of free physical memory across all selected nodes.
     * <p>
     * API name: {@code free}
     * </p>
     */
    @Nullable
    public final String free() {
        return this.free;
    }

    /**
     * Required - Amount, in bytes, of free physical memory across all selected nodes.
     * <p>
     * API name: {@code free_in_bytes}
     * </p>
     */
    public final long freeInBytes() {
        return this.freeInBytes;
    }

    /**
     * Required - Percentage of free physical memory across all selected nodes.
     * <p>
     * API name: {@code free_percent}
     * </p>
     */
    public final double freePercent() {
        return this.freePercent;
    }

    /**
     * Total amount of physical memory across all selected nodes.
     * <p>
     * API name: {@code total}
     * </p>
     */
    @Nullable
    public final String total() {
        return this.total;
    }

    /**
     * Required - Total amount, in bytes, of physical memory across all selected nodes.
     * <p>
     * API name: {@code total_in_bytes}
     * </p>
     */
    public final long totalInBytes() {
        return this.totalInBytes;
    }

    /**
     * Amount of physical memory in use across all selected nodes.
     * <p>
     * API name: {@code used}
     * </p>
     */
    @Nullable
    public final String used() {
        return this.used;
    }

    /**
     * Required - Amount, in bytes, of physical memory in use across all selected nodes.
     * <p>
     * API name: {@code used_in_bytes}
     * </p>
     */
    public final long usedInBytes() {
        return this.usedInBytes;
    }

    /**
     * Required - Percentage of physical memory in use across all selected nodes.
     * <p>
     * API name: {@code used_percent}
     * </p>
     */
    public final double usedPercent() {
        return this.usedPercent;
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
        if (this.adjustedTotalInBytes != null) {
            generator.writeKey("adjusted_total_in_bytes");
            generator.write(this.adjustedTotalInBytes);
        }

        if (this.free != null) {
            generator.writeKey("free");
            generator.write(this.free);
        }

        generator.writeKey("free_in_bytes");
        generator.write(this.freeInBytes);

        generator.writeKey("free_percent");
        generator.write(this.freePercent);

        if (this.total != null) {
            generator.writeKey("total");
            generator.write(this.total);
        }

        generator.writeKey("total_in_bytes");
        generator.write(this.totalInBytes);

        if (this.used != null) {
            generator.writeKey("used");
            generator.write(this.used);
        }

        generator.writeKey("used_in_bytes");
        generator.write(this.usedInBytes);

        generator.writeKey("used_percent");
        generator.write(this.usedPercent);
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
     * Builder for {@link OperatingSystemMemoryInfo}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, OperatingSystemMemoryInfo> {
        @Nullable
        private Long adjustedTotalInBytes;
        @Nullable
        private String free;
        private Long freeInBytes;
        private Double freePercent;
        @Nullable
        private String total;
        private Long totalInBytes;
        @Nullable
        private String used;
        private Long usedInBytes;
        private Double usedPercent;

        public Builder() {}

        private Builder(OperatingSystemMemoryInfo o) {
            this.adjustedTotalInBytes = o.adjustedTotalInBytes;
            this.free = o.free;
            this.freeInBytes = o.freeInBytes;
            this.freePercent = o.freePercent;
            this.total = o.total;
            this.totalInBytes = o.totalInBytes;
            this.used = o.used;
            this.usedInBytes = o.usedInBytes;
            this.usedPercent = o.usedPercent;
        }

        private Builder(Builder o) {
            this.adjustedTotalInBytes = o.adjustedTotalInBytes;
            this.free = o.free;
            this.freeInBytes = o.freeInBytes;
            this.freePercent = o.freePercent;
            this.total = o.total;
            this.totalInBytes = o.totalInBytes;
            this.used = o.used;
            this.usedInBytes = o.usedInBytes;
            this.usedPercent = o.usedPercent;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Total amount, in bytes, of memory across all selected nodes, but using the value specified using the
         * <code>es.total_memory_bytes</code> system property instead of measured total memory for those nodes where that system property
         * was set.
         * <p>
         * API name: {@code adjusted_total_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder adjustedTotalInBytes(@Nullable Long value) {
            this.adjustedTotalInBytes = value;
            return this;
        }

        /**
         * Amount, in bytes, of free physical memory across all selected nodes.
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
         * Required - Amount, in bytes, of free physical memory across all selected nodes.
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
         * Required - Percentage of free physical memory across all selected nodes.
         * <p>
         * API name: {@code free_percent}
         * </p>
         */
        @Nonnull
        public final Builder freePercent(double value) {
            this.freePercent = value;
            return this;
        }

        /**
         * Total amount of physical memory across all selected nodes.
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
         * Required - Total amount, in bytes, of physical memory across all selected nodes.
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
         * Amount of physical memory in use across all selected nodes.
         * <p>
         * API name: {@code used}
         * </p>
         */
        @Nonnull
        public final Builder used(@Nullable String value) {
            this.used = value;
            return this;
        }

        /**
         * Required - Amount, in bytes, of physical memory in use across all selected nodes.
         * <p>
         * API name: {@code used_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder usedInBytes(long value) {
            this.usedInBytes = value;
            return this;
        }

        /**
         * Required - Percentage of physical memory in use across all selected nodes.
         * <p>
         * API name: {@code used_percent}
         * </p>
         */
        @Nonnull
        public final Builder usedPercent(double value) {
            this.usedPercent = value;
            return this;
        }

        /**
         * Builds a {@link OperatingSystemMemoryInfo}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public OperatingSystemMemoryInfo build() {
            _checkSingleUse();

            return new OperatingSystemMemoryInfo(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link OperatingSystemMemoryInfo}
     */
    public static final JsonpDeserializer<OperatingSystemMemoryInfo> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        OperatingSystemMemoryInfo::setupOperatingSystemMemoryInfoDeserializer
    );

    protected static void setupOperatingSystemMemoryInfoDeserializer(ObjectDeserializer<OperatingSystemMemoryInfo.Builder> op) {
        op.add(Builder::adjustedTotalInBytes, JsonpDeserializer.longDeserializer(), "adjusted_total_in_bytes");
        op.add(Builder::free, JsonpDeserializer.stringDeserializer(), "free");
        op.add(Builder::freeInBytes, JsonpDeserializer.longDeserializer(), "free_in_bytes");
        op.add(Builder::freePercent, JsonpDeserializer.doubleDeserializer(), "free_percent");
        op.add(Builder::total, JsonpDeserializer.stringDeserializer(), "total");
        op.add(Builder::totalInBytes, JsonpDeserializer.longDeserializer(), "total_in_bytes");
        op.add(Builder::used, JsonpDeserializer.stringDeserializer(), "used");
        op.add(Builder::usedInBytes, JsonpDeserializer.longDeserializer(), "used_in_bytes");
        op.add(Builder::usedPercent, JsonpDeserializer.doubleDeserializer(), "used_percent");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.adjustedTotalInBytes);
        result = 31 * result + Objects.hashCode(this.free);
        result = 31 * result + Long.hashCode(this.freeInBytes);
        result = 31 * result + Double.hashCode(this.freePercent);
        result = 31 * result + Objects.hashCode(this.total);
        result = 31 * result + Long.hashCode(this.totalInBytes);
        result = 31 * result + Objects.hashCode(this.used);
        result = 31 * result + Long.hashCode(this.usedInBytes);
        result = 31 * result + Double.hashCode(this.usedPercent);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        OperatingSystemMemoryInfo other = (OperatingSystemMemoryInfo) o;
        return Objects.equals(this.adjustedTotalInBytes, other.adjustedTotalInBytes)
            && Objects.equals(this.free, other.free)
            && this.freeInBytes == other.freeInBytes
            && this.freePercent == other.freePercent
            && Objects.equals(this.total, other.total)
            && this.totalInBytes == other.totalInBytes
            && Objects.equals(this.used, other.used)
            && this.usedInBytes == other.usedInBytes
            && this.usedPercent == other.usedPercent;
    }
}
