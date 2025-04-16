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

// typedef: _types.FielddataStats

/**
 * The statistics about field data memory usage.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FielddataStats implements PlainJsonSerializable, ToCopyableBuilder<FielddataStats.Builder, FielddataStats> {

    @Nullable
    private final Long evictions;

    @Nonnull
    private final Map<String, FieldMemoryUsage> fields;

    @Nullable
    private final String memorySize;

    private final long memorySizeInBytes;

    // ---------------------------------------------------------------------------------------------

    private FielddataStats(Builder builder) {
        this.evictions = builder.evictions;
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.memorySize = builder.memorySize;
        this.memorySizeInBytes = ApiTypeHelper.requireNonNull(builder.memorySizeInBytes, this, "memorySizeInBytes");
    }

    public static FielddataStats of(Function<FielddataStats.Builder, ObjectBuilder<FielddataStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The number of times field data was evicted from memory.
     * <p>
     * API name: {@code evictions}
     * </p>
     */
    @Nullable
    public final Long evictions() {
        return this.evictions;
    }

    /**
     * API name: {@code fields}
     */
    @Nonnull
    public final Map<String, FieldMemoryUsage> fields() {
        return this.fields;
    }

    /**
     * The human-readable amount of memory used for field data.
     * <p>
     * API name: {@code memory_size}
     * </p>
     */
    @Nullable
    public final String memorySize() {
        return this.memorySize;
    }

    /**
     * Required - The amount of memory used for field data in bytes.
     * <p>
     * API name: {@code memory_size_in_bytes}
     * </p>
     */
    public final long memorySizeInBytes() {
        return this.memorySizeInBytes;
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

        if (ApiTypeHelper.isDefined(this.fields)) {
            generator.writeKey("fields");
            generator.writeStartObject();
            for (Map.Entry<String, FieldMemoryUsage> item0 : this.fields.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.memorySize != null) {
            generator.writeKey("memory_size");
            generator.write(this.memorySize);
        }

        generator.writeKey("memory_size_in_bytes");
        generator.write(this.memorySizeInBytes);
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
     * Builder for {@link FielddataStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, FielddataStats> {
        @Nullable
        private Long evictions;
        @Nullable
        private Map<String, FieldMemoryUsage> fields;
        @Nullable
        private String memorySize;
        private Long memorySizeInBytes;

        public Builder() {}

        private Builder(FielddataStats o) {
            this.evictions = o.evictions;
            this.fields = _mapCopy(o.fields);
            this.memorySize = o.memorySize;
            this.memorySizeInBytes = o.memorySizeInBytes;
        }

        private Builder(Builder o) {
            this.evictions = o.evictions;
            this.fields = _mapCopy(o.fields);
            this.memorySize = o.memorySize;
            this.memorySizeInBytes = o.memorySizeInBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The number of times field data was evicted from memory.
         * <p>
         * API name: {@code evictions}
         * </p>
         */
        @Nonnull
        public final Builder evictions(@Nullable Long value) {
            this.evictions = value;
            return this;
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(Map<String, FieldMemoryUsage> map) {
            this.fields = _mapPutAll(this.fields, map);
            return this;
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds an entry to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(String key, FieldMemoryUsage value) {
            this.fields = _mapPut(this.fields, key, value);
            return this;
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds a value to <code>fields</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder fields(String key, Function<FieldMemoryUsage.Builder, ObjectBuilder<FieldMemoryUsage>> fn) {
            return fields(key, fn.apply(new FieldMemoryUsage.Builder()).build());
        }

        /**
         * The human-readable amount of memory used for field data.
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
         * Required - The amount of memory used for field data in bytes.
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
         * Builds a {@link FielddataStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FielddataStats build() {
            _checkSingleUse();

            return new FielddataStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FielddataStats}
     */
    public static final JsonpDeserializer<FielddataStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FielddataStats::setupFielddataStatsDeserializer
    );

    protected static void setupFielddataStatsDeserializer(ObjectDeserializer<FielddataStats.Builder> op) {
        op.add(Builder::evictions, JsonpDeserializer.longDeserializer(), "evictions");
        op.add(Builder::fields, JsonpDeserializer.stringMapDeserializer(FieldMemoryUsage._DESERIALIZER), "fields");
        op.add(Builder::memorySize, JsonpDeserializer.stringDeserializer(), "memory_size");
        op.add(Builder::memorySizeInBytes, JsonpDeserializer.longDeserializer(), "memory_size_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.evictions);
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Objects.hashCode(this.memorySize);
        result = 31 * result + Long.hashCode(this.memorySizeInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FielddataStats other = (FielddataStats) o;
        return Objects.equals(this.evictions, other.evictions)
            && Objects.equals(this.fields, other.fields)
            && Objects.equals(this.memorySize, other.memorySize)
            && this.memorySizeInBytes == other.memorySizeInBytes;
    }
}
