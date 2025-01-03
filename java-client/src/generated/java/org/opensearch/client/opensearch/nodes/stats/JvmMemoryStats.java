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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.JvmMemoryStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class JvmMemoryStats implements PlainJsonSerializable, ToCopyableBuilder<JvmMemoryStats.Builder, JvmMemoryStats> {

    @Nullable
    private final String heapCommitted;

    @Nullable
    private final Long heapCommittedInBytes;

    @Nullable
    private final String heapMax;

    @Nullable
    private final Long heapMaxInBytes;

    @Nullable
    private final String heapUsed;

    @Nullable
    private final Long heapUsedInBytes;

    @Nullable
    private final Double heapUsedPercent;

    @Nullable
    private final String nonHeapCommitted;

    @Nullable
    private final Long nonHeapCommittedInBytes;

    @Nullable
    private final String nonHeapUsed;

    @Nullable
    private final Long nonHeapUsedInBytes;

    @Nonnull
    private final Map<String, Pool> pools;

    // ---------------------------------------------------------------------------------------------

    private JvmMemoryStats(Builder builder) {
        this.heapCommitted = builder.heapCommitted;
        this.heapCommittedInBytes = builder.heapCommittedInBytes;
        this.heapMax = builder.heapMax;
        this.heapMaxInBytes = builder.heapMaxInBytes;
        this.heapUsed = builder.heapUsed;
        this.heapUsedInBytes = builder.heapUsedInBytes;
        this.heapUsedPercent = builder.heapUsedPercent;
        this.nonHeapCommitted = builder.nonHeapCommitted;
        this.nonHeapCommittedInBytes = builder.nonHeapCommittedInBytes;
        this.nonHeapUsed = builder.nonHeapUsed;
        this.nonHeapUsedInBytes = builder.nonHeapUsedInBytes;
        this.pools = ApiTypeHelper.unmodifiable(builder.pools);
    }

    public static JvmMemoryStats of(Function<JvmMemoryStats.Builder, ObjectBuilder<JvmMemoryStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Amount of memory available for use by the heap.
     * <p>
     * API name: {@code heap_committed}
     * </p>
     */
    @Nullable
    public final String heapCommitted() {
        return this.heapCommitted;
    }

    /**
     * Amount of memory, in bytes, available for use by the heap.
     * <p>
     * API name: {@code heap_committed_in_bytes}
     * </p>
     */
    @Nullable
    public final Long heapCommittedInBytes() {
        return this.heapCommittedInBytes;
    }

    /**
     * Maximum amount of memory available for use by the heap.
     * <p>
     * API name: {@code heap_max}
     * </p>
     */
    @Nullable
    public final String heapMax() {
        return this.heapMax;
    }

    /**
     * Maximum amount of memory, in bytes, available for use by the heap.
     * <p>
     * API name: {@code heap_max_in_bytes}
     * </p>
     */
    @Nullable
    public final Long heapMaxInBytes() {
        return this.heapMaxInBytes;
    }

    /**
     * Memory currently in use by the heap.
     * <p>
     * API name: {@code heap_used}
     * </p>
     */
    @Nullable
    public final String heapUsed() {
        return this.heapUsed;
    }

    /**
     * Memory, in bytes, currently in use by the heap.
     * <p>
     * API name: {@code heap_used_in_bytes}
     * </p>
     */
    @Nullable
    public final Long heapUsedInBytes() {
        return this.heapUsedInBytes;
    }

    /**
     * Percentage of memory currently in use by the heap.
     * <p>
     * API name: {@code heap_used_percent}
     * </p>
     */
    @Nullable
    public final Double heapUsedPercent() {
        return this.heapUsedPercent;
    }

    /**
     * Amount of non-heap memory available.
     * <p>
     * API name: {@code non_heap_committed}
     * </p>
     */
    @Nullable
    public final String nonHeapCommitted() {
        return this.nonHeapCommitted;
    }

    /**
     * Amount of non-heap memory available, in bytes.
     * <p>
     * API name: {@code non_heap_committed_in_bytes}
     * </p>
     */
    @Nullable
    public final Long nonHeapCommittedInBytes() {
        return this.nonHeapCommittedInBytes;
    }

    /**
     * Non-heap memory used.
     * <p>
     * API name: {@code non_heap_used}
     * </p>
     */
    @Nullable
    public final String nonHeapUsed() {
        return this.nonHeapUsed;
    }

    /**
     * Non-heap memory used, in bytes.
     * <p>
     * API name: {@code non_heap_used_in_bytes}
     * </p>
     */
    @Nullable
    public final Long nonHeapUsedInBytes() {
        return this.nonHeapUsedInBytes;
    }

    /**
     * Contains statistics about heap memory usage for the node.
     * <p>
     * API name: {@code pools}
     * </p>
     */
    @Nonnull
    public final Map<String, Pool> pools() {
        return this.pools;
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
        if (this.heapCommitted != null) {
            generator.writeKey("heap_committed");
            generator.write(this.heapCommitted);
        }

        if (this.heapCommittedInBytes != null) {
            generator.writeKey("heap_committed_in_bytes");
            generator.write(this.heapCommittedInBytes);
        }

        if (this.heapMax != null) {
            generator.writeKey("heap_max");
            generator.write(this.heapMax);
        }

        if (this.heapMaxInBytes != null) {
            generator.writeKey("heap_max_in_bytes");
            generator.write(this.heapMaxInBytes);
        }

        if (this.heapUsed != null) {
            generator.writeKey("heap_used");
            generator.write(this.heapUsed);
        }

        if (this.heapUsedInBytes != null) {
            generator.writeKey("heap_used_in_bytes");
            generator.write(this.heapUsedInBytes);
        }

        if (this.heapUsedPercent != null) {
            generator.writeKey("heap_used_percent");
            generator.write(this.heapUsedPercent);
        }

        if (this.nonHeapCommitted != null) {
            generator.writeKey("non_heap_committed");
            generator.write(this.nonHeapCommitted);
        }

        if (this.nonHeapCommittedInBytes != null) {
            generator.writeKey("non_heap_committed_in_bytes");
            generator.write(this.nonHeapCommittedInBytes);
        }

        if (this.nonHeapUsed != null) {
            generator.writeKey("non_heap_used");
            generator.write(this.nonHeapUsed);
        }

        if (this.nonHeapUsedInBytes != null) {
            generator.writeKey("non_heap_used_in_bytes");
            generator.write(this.nonHeapUsedInBytes);
        }

        if (ApiTypeHelper.isDefined(this.pools)) {
            generator.writeKey("pools");
            generator.writeStartObject();
            for (Map.Entry<String, Pool> item0 : this.pools.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link JvmMemoryStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, JvmMemoryStats> {
        @Nullable
        private String heapCommitted;
        @Nullable
        private Long heapCommittedInBytes;
        @Nullable
        private String heapMax;
        @Nullable
        private Long heapMaxInBytes;
        @Nullable
        private String heapUsed;
        @Nullable
        private Long heapUsedInBytes;
        @Nullable
        private Double heapUsedPercent;
        @Nullable
        private String nonHeapCommitted;
        @Nullable
        private Long nonHeapCommittedInBytes;
        @Nullable
        private String nonHeapUsed;
        @Nullable
        private Long nonHeapUsedInBytes;
        @Nullable
        private Map<String, Pool> pools;

        public Builder() {}

        private Builder(JvmMemoryStats o) {
            this.heapCommitted = o.heapCommitted;
            this.heapCommittedInBytes = o.heapCommittedInBytes;
            this.heapMax = o.heapMax;
            this.heapMaxInBytes = o.heapMaxInBytes;
            this.heapUsed = o.heapUsed;
            this.heapUsedInBytes = o.heapUsedInBytes;
            this.heapUsedPercent = o.heapUsedPercent;
            this.nonHeapCommitted = o.nonHeapCommitted;
            this.nonHeapCommittedInBytes = o.nonHeapCommittedInBytes;
            this.nonHeapUsed = o.nonHeapUsed;
            this.nonHeapUsedInBytes = o.nonHeapUsedInBytes;
            this.pools = _mapCopy(o.pools);
        }

        private Builder(Builder o) {
            this.heapCommitted = o.heapCommitted;
            this.heapCommittedInBytes = o.heapCommittedInBytes;
            this.heapMax = o.heapMax;
            this.heapMaxInBytes = o.heapMaxInBytes;
            this.heapUsed = o.heapUsed;
            this.heapUsedInBytes = o.heapUsedInBytes;
            this.heapUsedPercent = o.heapUsedPercent;
            this.nonHeapCommitted = o.nonHeapCommitted;
            this.nonHeapCommittedInBytes = o.nonHeapCommittedInBytes;
            this.nonHeapUsed = o.nonHeapUsed;
            this.nonHeapUsedInBytes = o.nonHeapUsedInBytes;
            this.pools = _mapCopy(o.pools);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Amount of memory available for use by the heap.
         * <p>
         * API name: {@code heap_committed}
         * </p>
         */
        @Nonnull
        public final Builder heapCommitted(@Nullable String value) {
            this.heapCommitted = value;
            return this;
        }

        /**
         * Amount of memory, in bytes, available for use by the heap.
         * <p>
         * API name: {@code heap_committed_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder heapCommittedInBytes(@Nullable Long value) {
            this.heapCommittedInBytes = value;
            return this;
        }

        /**
         * Maximum amount of memory available for use by the heap.
         * <p>
         * API name: {@code heap_max}
         * </p>
         */
        @Nonnull
        public final Builder heapMax(@Nullable String value) {
            this.heapMax = value;
            return this;
        }

        /**
         * Maximum amount of memory, in bytes, available for use by the heap.
         * <p>
         * API name: {@code heap_max_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder heapMaxInBytes(@Nullable Long value) {
            this.heapMaxInBytes = value;
            return this;
        }

        /**
         * Memory currently in use by the heap.
         * <p>
         * API name: {@code heap_used}
         * </p>
         */
        @Nonnull
        public final Builder heapUsed(@Nullable String value) {
            this.heapUsed = value;
            return this;
        }

        /**
         * Memory, in bytes, currently in use by the heap.
         * <p>
         * API name: {@code heap_used_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder heapUsedInBytes(@Nullable Long value) {
            this.heapUsedInBytes = value;
            return this;
        }

        /**
         * Percentage of memory currently in use by the heap.
         * <p>
         * API name: {@code heap_used_percent}
         * </p>
         */
        @Nonnull
        public final Builder heapUsedPercent(@Nullable Double value) {
            this.heapUsedPercent = value;
            return this;
        }

        /**
         * Amount of non-heap memory available.
         * <p>
         * API name: {@code non_heap_committed}
         * </p>
         */
        @Nonnull
        public final Builder nonHeapCommitted(@Nullable String value) {
            this.nonHeapCommitted = value;
            return this;
        }

        /**
         * Amount of non-heap memory available, in bytes.
         * <p>
         * API name: {@code non_heap_committed_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder nonHeapCommittedInBytes(@Nullable Long value) {
            this.nonHeapCommittedInBytes = value;
            return this;
        }

        /**
         * Non-heap memory used.
         * <p>
         * API name: {@code non_heap_used}
         * </p>
         */
        @Nonnull
        public final Builder nonHeapUsed(@Nullable String value) {
            this.nonHeapUsed = value;
            return this;
        }

        /**
         * Non-heap memory used, in bytes.
         * <p>
         * API name: {@code non_heap_used_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder nonHeapUsedInBytes(@Nullable Long value) {
            this.nonHeapUsedInBytes = value;
            return this;
        }

        /**
         * Contains statistics about heap memory usage for the node.
         * <p>
         * API name: {@code pools}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>pools</code>.
         * </p>
         */
        @Nonnull
        public final Builder pools(Map<String, Pool> map) {
            this.pools = _mapPutAll(this.pools, map);
            return this;
        }

        /**
         * Contains statistics about heap memory usage for the node.
         * <p>
         * API name: {@code pools}
         * </p>
         *
         * <p>
         * Adds an entry to <code>pools</code>.
         * </p>
         */
        @Nonnull
        public final Builder pools(String key, Pool value) {
            this.pools = _mapPut(this.pools, key, value);
            return this;
        }

        /**
         * Contains statistics about heap memory usage for the node.
         * <p>
         * API name: {@code pools}
         * </p>
         *
         * <p>
         * Adds a value to <code>pools</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder pools(String key, Function<Pool.Builder, ObjectBuilder<Pool>> fn) {
            return pools(key, fn.apply(new Pool.Builder()).build());
        }

        /**
         * Builds a {@link JvmMemoryStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public JvmMemoryStats build() {
            _checkSingleUse();

            return new JvmMemoryStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link JvmMemoryStats}
     */
    public static final JsonpDeserializer<JvmMemoryStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        JvmMemoryStats::setupJvmMemoryStatsDeserializer
    );

    protected static void setupJvmMemoryStatsDeserializer(ObjectDeserializer<JvmMemoryStats.Builder> op) {
        op.add(Builder::heapCommitted, JsonpDeserializer.stringDeserializer(), "heap_committed");
        op.add(Builder::heapCommittedInBytes, JsonpDeserializer.longDeserializer(), "heap_committed_in_bytes");
        op.add(Builder::heapMax, JsonpDeserializer.stringDeserializer(), "heap_max");
        op.add(Builder::heapMaxInBytes, JsonpDeserializer.longDeserializer(), "heap_max_in_bytes");
        op.add(Builder::heapUsed, JsonpDeserializer.stringDeserializer(), "heap_used");
        op.add(Builder::heapUsedInBytes, JsonpDeserializer.longDeserializer(), "heap_used_in_bytes");
        op.add(Builder::heapUsedPercent, JsonpDeserializer.doubleDeserializer(), "heap_used_percent");
        op.add(Builder::nonHeapCommitted, JsonpDeserializer.stringDeserializer(), "non_heap_committed");
        op.add(Builder::nonHeapCommittedInBytes, JsonpDeserializer.longDeserializer(), "non_heap_committed_in_bytes");
        op.add(Builder::nonHeapUsed, JsonpDeserializer.stringDeserializer(), "non_heap_used");
        op.add(Builder::nonHeapUsedInBytes, JsonpDeserializer.longDeserializer(), "non_heap_used_in_bytes");
        op.add(Builder::pools, JsonpDeserializer.stringMapDeserializer(Pool._DESERIALIZER), "pools");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.heapCommitted);
        result = 31 * result + Objects.hashCode(this.heapCommittedInBytes);
        result = 31 * result + Objects.hashCode(this.heapMax);
        result = 31 * result + Objects.hashCode(this.heapMaxInBytes);
        result = 31 * result + Objects.hashCode(this.heapUsed);
        result = 31 * result + Objects.hashCode(this.heapUsedInBytes);
        result = 31 * result + Objects.hashCode(this.heapUsedPercent);
        result = 31 * result + Objects.hashCode(this.nonHeapCommitted);
        result = 31 * result + Objects.hashCode(this.nonHeapCommittedInBytes);
        result = 31 * result + Objects.hashCode(this.nonHeapUsed);
        result = 31 * result + Objects.hashCode(this.nonHeapUsedInBytes);
        result = 31 * result + Objects.hashCode(this.pools);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        JvmMemoryStats other = (JvmMemoryStats) o;
        return Objects.equals(this.heapCommitted, other.heapCommitted)
            && Objects.equals(this.heapCommittedInBytes, other.heapCommittedInBytes)
            && Objects.equals(this.heapMax, other.heapMax)
            && Objects.equals(this.heapMaxInBytes, other.heapMaxInBytes)
            && Objects.equals(this.heapUsed, other.heapUsed)
            && Objects.equals(this.heapUsedInBytes, other.heapUsedInBytes)
            && Objects.equals(this.heapUsedPercent, other.heapUsedPercent)
            && Objects.equals(this.nonHeapCommitted, other.nonHeapCommitted)
            && Objects.equals(this.nonHeapCommittedInBytes, other.nonHeapCommittedInBytes)
            && Objects.equals(this.nonHeapUsed, other.nonHeapUsed)
            && Objects.equals(this.nonHeapUsedInBytes, other.nonHeapUsedInBytes)
            && Objects.equals(this.pools, other.pools);
    }
}
