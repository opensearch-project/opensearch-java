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

// typedef: nodes.stats.IndexingPressureMemory

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexingPressureMemory
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexingPressureMemory.Builder, IndexingPressureMemory> {

    @Nullable
    private final PressureMemory current;

    @Nullable
    private final String limit;

    @Nullable
    private final Long limitInBytes;

    @Nullable
    private final PressureMemory total;

    // ---------------------------------------------------------------------------------------------

    private IndexingPressureMemory(Builder builder) {
        this.current = builder.current;
        this.limit = builder.limit;
        this.limitInBytes = builder.limitInBytes;
        this.total = builder.total;
    }

    public static IndexingPressureMemory of(Function<IndexingPressureMemory.Builder, ObjectBuilder<IndexingPressureMemory>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code current}
     */
    @Nullable
    public final PressureMemory current() {
        return this.current;
    }

    /**
     * API name: {@code limit}
     */
    @Nullable
    public final String limit() {
        return this.limit;
    }

    /**
     * Configured memory limit, in bytes, for the indexing requests. Replica requests have an automatic limit that is 1.5x this value.
     * <p>
     * API name: {@code limit_in_bytes}
     * </p>
     */
    @Nullable
    public final Long limitInBytes() {
        return this.limitInBytes;
    }

    /**
     * API name: {@code total}
     */
    @Nullable
    public final PressureMemory total() {
        return this.total;
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
        if (this.current != null) {
            generator.writeKey("current");
            this.current.serialize(generator, mapper);
        }

        if (this.limit != null) {
            generator.writeKey("limit");
            generator.write(this.limit);
        }

        if (this.limitInBytes != null) {
            generator.writeKey("limit_in_bytes");
            generator.write(this.limitInBytes);
        }

        if (this.total != null) {
            generator.writeKey("total");
            this.total.serialize(generator, mapper);
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
     * Builder for {@link IndexingPressureMemory}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexingPressureMemory> {
        @Nullable
        private PressureMemory current;
        @Nullable
        private String limit;
        @Nullable
        private Long limitInBytes;
        @Nullable
        private PressureMemory total;

        public Builder() {}

        private Builder(IndexingPressureMemory o) {
            this.current = o.current;
            this.limit = o.limit;
            this.limitInBytes = o.limitInBytes;
            this.total = o.total;
        }

        private Builder(Builder o) {
            this.current = o.current;
            this.limit = o.limit;
            this.limitInBytes = o.limitInBytes;
            this.total = o.total;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code current}
         */
        @Nonnull
        public final Builder current(@Nullable PressureMemory value) {
            this.current = value;
            return this;
        }

        /**
         * API name: {@code current}
         */
        @Nonnull
        public final Builder current(Function<PressureMemory.Builder, ObjectBuilder<PressureMemory>> fn) {
            return current(fn.apply(new PressureMemory.Builder()).build());
        }

        /**
         * API name: {@code limit}
         */
        @Nonnull
        public final Builder limit(@Nullable String value) {
            this.limit = value;
            return this;
        }

        /**
         * Configured memory limit, in bytes, for the indexing requests. Replica requests have an automatic limit that is 1.5x this value.
         * <p>
         * API name: {@code limit_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder limitInBytes(@Nullable Long value) {
            this.limitInBytes = value;
            return this;
        }

        /**
         * API name: {@code total}
         */
        @Nonnull
        public final Builder total(@Nullable PressureMemory value) {
            this.total = value;
            return this;
        }

        /**
         * API name: {@code total}
         */
        @Nonnull
        public final Builder total(Function<PressureMemory.Builder, ObjectBuilder<PressureMemory>> fn) {
            return total(fn.apply(new PressureMemory.Builder()).build());
        }

        /**
         * Builds a {@link IndexingPressureMemory}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexingPressureMemory build() {
            _checkSingleUse();

            return new IndexingPressureMemory(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexingPressureMemory}
     */
    public static final JsonpDeserializer<IndexingPressureMemory> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexingPressureMemory::setupIndexingPressureMemoryDeserializer
    );

    protected static void setupIndexingPressureMemoryDeserializer(ObjectDeserializer<IndexingPressureMemory.Builder> op) {
        op.add(Builder::current, PressureMemory._DESERIALIZER, "current");
        op.add(Builder::limit, JsonpDeserializer.stringDeserializer(), "limit");
        op.add(Builder::limitInBytes, JsonpDeserializer.longDeserializer(), "limit_in_bytes");
        op.add(Builder::total, PressureMemory._DESERIALIZER, "total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.current);
        result = 31 * result + Objects.hashCode(this.limit);
        result = 31 * result + Objects.hashCode(this.limitInBytes);
        result = 31 * result + Objects.hashCode(this.total);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexingPressureMemory other = (IndexingPressureMemory) o;
        return Objects.equals(this.current, other.current)
            && Objects.equals(this.limit, other.limit)
            && Objects.equals(this.limitInBytes, other.limitInBytes)
            && Objects.equals(this.total, other.total);
    }
}
