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

// typedef: nodes.stats.Pool

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Pool implements PlainJsonSerializable, ToCopyableBuilder<Pool.Builder, Pool> {

    @Nullable
    private final LastGcStats lastGcStats;

    @Nullable
    private final String max;

    @Nullable
    private final Long maxInBytes;

    @Nullable
    private final String peakMax;

    @Nullable
    private final Long peakMaxInBytes;

    @Nullable
    private final String peakUsed;

    @Nullable
    private final Long peakUsedInBytes;

    @Nullable
    private final String used;

    @Nullable
    private final Long usedInBytes;

    // ---------------------------------------------------------------------------------------------

    private Pool(Builder builder) {
        this.lastGcStats = builder.lastGcStats;
        this.max = builder.max;
        this.maxInBytes = builder.maxInBytes;
        this.peakMax = builder.peakMax;
        this.peakMaxInBytes = builder.peakMaxInBytes;
        this.peakUsed = builder.peakUsed;
        this.peakUsedInBytes = builder.peakUsedInBytes;
        this.used = builder.used;
        this.usedInBytes = builder.usedInBytes;
    }

    public static Pool of(Function<Pool.Builder, ObjectBuilder<Pool>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Most recent GC cycle stats for a particular memory pool.
     * <p>
     * API name: {@code last_gc_stats}
     * </p>
     */
    @Nullable
    public final LastGcStats lastGcStats() {
        return this.lastGcStats;
    }

    /**
     * Maximum amount of memory available for use by the heap.
     * <p>
     * API name: {@code max}
     * </p>
     */
    @Nullable
    public final String max() {
        return this.max;
    }

    /**
     * Maximum amount of memory, in bytes, available for use by the heap.
     * <p>
     * API name: {@code max_in_bytes}
     * </p>
     */
    @Nullable
    public final Long maxInBytes() {
        return this.maxInBytes;
    }

    /**
     * Largest amount of memory historically used by the heap.
     * <p>
     * API name: {@code peak_max}
     * </p>
     */
    @Nullable
    public final String peakMax() {
        return this.peakMax;
    }

    /**
     * Largest amount of memory, in bytes, historically used by the heap.
     * <p>
     * API name: {@code peak_max_in_bytes}
     * </p>
     */
    @Nullable
    public final Long peakMaxInBytes() {
        return this.peakMaxInBytes;
    }

    /**
     * Largest amount of memory historically used by the heap.
     * <p>
     * API name: {@code peak_used}
     * </p>
     */
    @Nullable
    public final String peakUsed() {
        return this.peakUsed;
    }

    /**
     * Largest amount of memory, in bytes, historically used by the heap.
     * <p>
     * API name: {@code peak_used_in_bytes}
     * </p>
     */
    @Nullable
    public final Long peakUsedInBytes() {
        return this.peakUsedInBytes;
    }

    /**
     * Memory used by the heap.
     * <p>
     * API name: {@code used}
     * </p>
     */
    @Nullable
    public final String used() {
        return this.used;
    }

    /**
     * Memory, in bytes, used by the heap.
     * <p>
     * API name: {@code used_in_bytes}
     * </p>
     */
    @Nullable
    public final Long usedInBytes() {
        return this.usedInBytes;
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
        if (this.lastGcStats != null) {
            generator.writeKey("last_gc_stats");
            this.lastGcStats.serialize(generator, mapper);
        }

        if (this.max != null) {
            generator.writeKey("max");
            generator.write(this.max);
        }

        if (this.maxInBytes != null) {
            generator.writeKey("max_in_bytes");
            generator.write(this.maxInBytes);
        }

        if (this.peakMax != null) {
            generator.writeKey("peak_max");
            generator.write(this.peakMax);
        }

        if (this.peakMaxInBytes != null) {
            generator.writeKey("peak_max_in_bytes");
            generator.write(this.peakMaxInBytes);
        }

        if (this.peakUsed != null) {
            generator.writeKey("peak_used");
            generator.write(this.peakUsed);
        }

        if (this.peakUsedInBytes != null) {
            generator.writeKey("peak_used_in_bytes");
            generator.write(this.peakUsedInBytes);
        }

        if (this.used != null) {
            generator.writeKey("used");
            generator.write(this.used);
        }

        if (this.usedInBytes != null) {
            generator.writeKey("used_in_bytes");
            generator.write(this.usedInBytes);
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
     * Builder for {@link Pool}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Pool> {
        @Nullable
        private LastGcStats lastGcStats;
        @Nullable
        private String max;
        @Nullable
        private Long maxInBytes;
        @Nullable
        private String peakMax;
        @Nullable
        private Long peakMaxInBytes;
        @Nullable
        private String peakUsed;
        @Nullable
        private Long peakUsedInBytes;
        @Nullable
        private String used;
        @Nullable
        private Long usedInBytes;

        public Builder() {}

        private Builder(Pool o) {
            this.lastGcStats = o.lastGcStats;
            this.max = o.max;
            this.maxInBytes = o.maxInBytes;
            this.peakMax = o.peakMax;
            this.peakMaxInBytes = o.peakMaxInBytes;
            this.peakUsed = o.peakUsed;
            this.peakUsedInBytes = o.peakUsedInBytes;
            this.used = o.used;
            this.usedInBytes = o.usedInBytes;
        }

        private Builder(Builder o) {
            this.lastGcStats = o.lastGcStats;
            this.max = o.max;
            this.maxInBytes = o.maxInBytes;
            this.peakMax = o.peakMax;
            this.peakMaxInBytes = o.peakMaxInBytes;
            this.peakUsed = o.peakUsed;
            this.peakUsedInBytes = o.peakUsedInBytes;
            this.used = o.used;
            this.usedInBytes = o.usedInBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Most recent GC cycle stats for a particular memory pool.
         * <p>
         * API name: {@code last_gc_stats}
         * </p>
         */
        @Nonnull
        public final Builder lastGcStats(@Nullable LastGcStats value) {
            this.lastGcStats = value;
            return this;
        }

        /**
         * Most recent GC cycle stats for a particular memory pool.
         * <p>
         * API name: {@code last_gc_stats}
         * </p>
         */
        @Nonnull
        public final Builder lastGcStats(Function<LastGcStats.Builder, ObjectBuilder<LastGcStats>> fn) {
            return lastGcStats(fn.apply(new LastGcStats.Builder()).build());
        }

        /**
         * Maximum amount of memory available for use by the heap.
         * <p>
         * API name: {@code max}
         * </p>
         */
        @Nonnull
        public final Builder max(@Nullable String value) {
            this.max = value;
            return this;
        }

        /**
         * Maximum amount of memory, in bytes, available for use by the heap.
         * <p>
         * API name: {@code max_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder maxInBytes(@Nullable Long value) {
            this.maxInBytes = value;
            return this;
        }

        /**
         * Largest amount of memory historically used by the heap.
         * <p>
         * API name: {@code peak_max}
         * </p>
         */
        @Nonnull
        public final Builder peakMax(@Nullable String value) {
            this.peakMax = value;
            return this;
        }

        /**
         * Largest amount of memory, in bytes, historically used by the heap.
         * <p>
         * API name: {@code peak_max_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder peakMaxInBytes(@Nullable Long value) {
            this.peakMaxInBytes = value;
            return this;
        }

        /**
         * Largest amount of memory historically used by the heap.
         * <p>
         * API name: {@code peak_used}
         * </p>
         */
        @Nonnull
        public final Builder peakUsed(@Nullable String value) {
            this.peakUsed = value;
            return this;
        }

        /**
         * Largest amount of memory, in bytes, historically used by the heap.
         * <p>
         * API name: {@code peak_used_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder peakUsedInBytes(@Nullable Long value) {
            this.peakUsedInBytes = value;
            return this;
        }

        /**
         * Memory used by the heap.
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
         * Memory, in bytes, used by the heap.
         * <p>
         * API name: {@code used_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder usedInBytes(@Nullable Long value) {
            this.usedInBytes = value;
            return this;
        }

        /**
         * Builds a {@link Pool}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Pool build() {
            _checkSingleUse();

            return new Pool(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Pool}
     */
    public static final JsonpDeserializer<Pool> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new, Pool::setupPoolDeserializer);

    protected static void setupPoolDeserializer(ObjectDeserializer<Pool.Builder> op) {
        op.add(Builder::lastGcStats, LastGcStats._DESERIALIZER, "last_gc_stats");
        op.add(Builder::max, JsonpDeserializer.stringDeserializer(), "max");
        op.add(Builder::maxInBytes, JsonpDeserializer.longDeserializer(), "max_in_bytes");
        op.add(Builder::peakMax, JsonpDeserializer.stringDeserializer(), "peak_max");
        op.add(Builder::peakMaxInBytes, JsonpDeserializer.longDeserializer(), "peak_max_in_bytes");
        op.add(Builder::peakUsed, JsonpDeserializer.stringDeserializer(), "peak_used");
        op.add(Builder::peakUsedInBytes, JsonpDeserializer.longDeserializer(), "peak_used_in_bytes");
        op.add(Builder::used, JsonpDeserializer.stringDeserializer(), "used");
        op.add(Builder::usedInBytes, JsonpDeserializer.longDeserializer(), "used_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.lastGcStats);
        result = 31 * result + Objects.hashCode(this.max);
        result = 31 * result + Objects.hashCode(this.maxInBytes);
        result = 31 * result + Objects.hashCode(this.peakMax);
        result = 31 * result + Objects.hashCode(this.peakMaxInBytes);
        result = 31 * result + Objects.hashCode(this.peakUsed);
        result = 31 * result + Objects.hashCode(this.peakUsedInBytes);
        result = 31 * result + Objects.hashCode(this.used);
        result = 31 * result + Objects.hashCode(this.usedInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Pool other = (Pool) o;
        return Objects.equals(this.lastGcStats, other.lastGcStats)
            && Objects.equals(this.max, other.max)
            && Objects.equals(this.maxInBytes, other.maxInBytes)
            && Objects.equals(this.peakMax, other.peakMax)
            && Objects.equals(this.peakMaxInBytes, other.peakMaxInBytes)
            && Objects.equals(this.peakUsed, other.peakUsed)
            && Objects.equals(this.peakUsedInBytes, other.peakUsedInBytes)
            && Objects.equals(this.used, other.used)
            && Objects.equals(this.usedInBytes, other.usedInBytes);
    }
}
