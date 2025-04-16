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

// typedef: _types.CompletionStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CompletionStats implements PlainJsonSerializable, ToCopyableBuilder<CompletionStats.Builder, CompletionStats> {

    @Nonnull
    private final Map<String, FieldSizeUsage> fields;

    @Nullable
    private final String size;

    private final long sizeInBytes;

    // ---------------------------------------------------------------------------------------------

    private CompletionStats(Builder builder) {
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.size = builder.size;
        this.sizeInBytes = ApiTypeHelper.requireNonNull(builder.sizeInBytes, this, "sizeInBytes");
    }

    public static CompletionStats of(Function<CompletionStats.Builder, ObjectBuilder<CompletionStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The per-field completion statistics.
     * <p>
     * API name: {@code fields}
     * </p>
     */
    @Nonnull
    public final Map<String, FieldSizeUsage> fields() {
        return this.fields;
    }

    /**
     * The human-readable size of memory used for completion.
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final String size() {
        return this.size;
    }

    /**
     * Required - The total amount, in bytes, of memory used for completion across all shards assigned to the selected nodes.
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
        if (ApiTypeHelper.isDefined(this.fields)) {
            generator.writeKey("fields");
            generator.writeStartObject();
            for (Map.Entry<String, FieldSizeUsage> item0 : this.fields.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

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
     * Builder for {@link CompletionStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CompletionStats> {
        @Nullable
        private Map<String, FieldSizeUsage> fields;
        @Nullable
        private String size;
        private Long sizeInBytes;

        public Builder() {}

        private Builder(CompletionStats o) {
            this.fields = _mapCopy(o.fields);
            this.size = o.size;
            this.sizeInBytes = o.sizeInBytes;
        }

        private Builder(Builder o) {
            this.fields = _mapCopy(o.fields);
            this.size = o.size;
            this.sizeInBytes = o.sizeInBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The per-field completion statistics.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(Map<String, FieldSizeUsage> map) {
            this.fields = _mapPutAll(this.fields, map);
            return this;
        }

        /**
         * The per-field completion statistics.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds an entry to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(String key, FieldSizeUsage value) {
            this.fields = _mapPut(this.fields, key, value);
            return this;
        }

        /**
         * The per-field completion statistics.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds a value to <code>fields</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder fields(String key, Function<FieldSizeUsage.Builder, ObjectBuilder<FieldSizeUsage>> fn) {
            return fields(key, fn.apply(new FieldSizeUsage.Builder()).build());
        }

        /**
         * The human-readable size of memory used for completion.
         * <p>
         * API name: {@code size}
         * </p>
         */
        @Nonnull
        public final Builder size(@Nullable String value) {
            this.size = value;
            return this;
        }

        /**
         * Required - The total amount, in bytes, of memory used for completion across all shards assigned to the selected nodes.
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
         * Builds a {@link CompletionStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CompletionStats build() {
            _checkSingleUse();

            return new CompletionStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CompletionStats}
     */
    public static final JsonpDeserializer<CompletionStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CompletionStats::setupCompletionStatsDeserializer
    );

    protected static void setupCompletionStatsDeserializer(ObjectDeserializer<CompletionStats.Builder> op) {
        op.add(Builder::fields, JsonpDeserializer.stringMapDeserializer(FieldSizeUsage._DESERIALIZER), "fields");
        op.add(Builder::size, JsonpDeserializer.stringDeserializer(), "size");
        op.add(Builder::sizeInBytes, JsonpDeserializer.longDeserializer(), "size_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Long.hashCode(this.sizeInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CompletionStats other = (CompletionStats) o;
        return Objects.equals(this.fields, other.fields) && Objects.equals(this.size, other.size) && this.sizeInBytes == other.sizeInBytes;
    }
}
