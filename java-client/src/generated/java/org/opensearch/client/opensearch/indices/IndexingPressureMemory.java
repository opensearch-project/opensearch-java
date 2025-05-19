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

package org.opensearch.client.opensearch.indices;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
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

// typedef: indices.IndexingPressureMemory

/**
 * The memory-related settings for indexing backpressure.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexingPressureMemory
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexingPressureMemory.Builder, IndexingPressureMemory> {

    @Nullable
    private final JsonData limit;

    // ---------------------------------------------------------------------------------------------

    private IndexingPressureMemory(Builder builder) {
        this.limit = builder.limit;
    }

    public static IndexingPressureMemory of(Function<IndexingPressureMemory.Builder, ObjectBuilder<IndexingPressureMemory>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The number of outstanding bytes that may be consumed by indexing requests. When this limit is reached or exceeded, the node will
     * reject new coordinating and primary operations. When replica operations consume 1.5x this limit, the node will reject new replica
     * operations. Defaults to 10% of the heap.
     * <p>
     * API name: {@code limit}
     * </p>
     */
    @Nullable
    public final JsonData limit() {
        return this.limit;
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
        if (this.limit != null) {
            generator.writeKey("limit");
            this.limit.serialize(generator, mapper);
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
        private JsonData limit;

        public Builder() {}

        private Builder(IndexingPressureMemory o) {
            this.limit = o.limit;
        }

        private Builder(Builder o) {
            this.limit = o.limit;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The number of outstanding bytes that may be consumed by indexing requests. When this limit is reached or exceeded, the node will
         * reject new coordinating and primary operations. When replica operations consume 1.5x this limit, the node will reject new replica
         * operations. Defaults to 10% of the heap.
         * <p>
         * API name: {@code limit}
         * </p>
         */
        @Nonnull
        public final Builder limit(@Nullable JsonData value) {
            this.limit = value;
            return this;
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
        op.add(Builder::limit, JsonData._DESERIALIZER, "limit");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.limit);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexingPressureMemory other = (IndexingPressureMemory) o;
        return Objects.equals(this.limit, other.limit);
    }
}
