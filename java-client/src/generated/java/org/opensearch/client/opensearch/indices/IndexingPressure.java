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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: indices.IndexingPressure

/**
 * The configuration for indexing backpressure.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexingPressure implements PlainJsonSerializable, ToCopyableBuilder<IndexingPressure.Builder, IndexingPressure> {

    @Nonnull
    private final IndexingPressureMemory memory;

    // ---------------------------------------------------------------------------------------------

    private IndexingPressure(Builder builder) {
        this.memory = ApiTypeHelper.requireNonNull(builder.memory, this, "memory");
    }

    public static IndexingPressure of(Function<IndexingPressure.Builder, ObjectBuilder<IndexingPressure>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code memory}
     */
    @Nonnull
    public final IndexingPressureMemory memory() {
        return this.memory;
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
        generator.writeKey("memory");
        this.memory.serialize(generator, mapper);
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
     * Builder for {@link IndexingPressure}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexingPressure> {
        private IndexingPressureMemory memory;

        public Builder() {}

        private Builder(IndexingPressure o) {
            this.memory = o.memory;
        }

        private Builder(Builder o) {
            this.memory = o.memory;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code memory}
         */
        @Nonnull
        public final Builder memory(IndexingPressureMemory value) {
            this.memory = value;
            return this;
        }

        /**
         * Required - API name: {@code memory}
         */
        @Nonnull
        public final Builder memory(Function<IndexingPressureMemory.Builder, ObjectBuilder<IndexingPressureMemory>> fn) {
            return memory(fn.apply(new IndexingPressureMemory.Builder()).build());
        }

        /**
         * Builds a {@link IndexingPressure}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexingPressure build() {
            _checkSingleUse();

            return new IndexingPressure(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexingPressure}
     */
    public static final JsonpDeserializer<IndexingPressure> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexingPressure::setupIndexingPressureDeserializer
    );

    protected static void setupIndexingPressureDeserializer(ObjectDeserializer<IndexingPressure.Builder> op) {
        op.add(Builder::memory, IndexingPressureMemory._DESERIALIZER, "memory");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.memory.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexingPressure other = (IndexingPressure) o;
        return this.memory.equals(other.memory);
    }
}
