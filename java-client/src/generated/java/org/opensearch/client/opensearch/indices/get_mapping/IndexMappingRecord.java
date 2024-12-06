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

package org.opensearch.client.opensearch.indices.get_mapping;

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
import org.opensearch.client.opensearch._types.mapping.TypeMapping;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.get_mapping.IndexMappingRecord

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexMappingRecord implements PlainJsonSerializable, ToCopyableBuilder<IndexMappingRecord.Builder, IndexMappingRecord> {

    @Nullable
    private final TypeMapping item;

    @Nonnull
    private final TypeMapping mappings;

    // ---------------------------------------------------------------------------------------------

    private IndexMappingRecord(Builder builder) {
        this.item = builder.item;
        this.mappings = ApiTypeHelper.requireNonNull(builder.mappings, this, "mappings");
    }

    public static IndexMappingRecord of(Function<IndexMappingRecord.Builder, ObjectBuilder<IndexMappingRecord>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code item}
     */
    @Nullable
    public final TypeMapping item() {
        return this.item;
    }

    /**
     * Required - API name: {@code mappings}
     */
    @Nonnull
    public final TypeMapping mappings() {
        return this.mappings;
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
        if (this.item != null) {
            generator.writeKey("item");
            this.item.serialize(generator, mapper);
        }

        generator.writeKey("mappings");
        this.mappings.serialize(generator, mapper);
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
     * Builder for {@link IndexMappingRecord}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexMappingRecord> {
        @Nullable
        private TypeMapping item;
        private TypeMapping mappings;

        public Builder() {}

        private Builder(IndexMappingRecord o) {
            this.item = o.item;
            this.mappings = o.mappings;
        }

        private Builder(Builder o) {
            this.item = o.item;
            this.mappings = o.mappings;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code item}
         */
        @Nonnull
        public final Builder item(@Nullable TypeMapping value) {
            this.item = value;
            return this;
        }

        /**
         * API name: {@code item}
         */
        @Nonnull
        public final Builder item(Function<TypeMapping.Builder, ObjectBuilder<TypeMapping>> fn) {
            return item(fn.apply(new TypeMapping.Builder()).build());
        }

        /**
         * Required - API name: {@code mappings}
         */
        @Nonnull
        public final Builder mappings(TypeMapping value) {
            this.mappings = value;
            return this;
        }

        /**
         * Required - API name: {@code mappings}
         */
        @Nonnull
        public final Builder mappings(Function<TypeMapping.Builder, ObjectBuilder<TypeMapping>> fn) {
            return mappings(fn.apply(new TypeMapping.Builder()).build());
        }

        /**
         * Builds a {@link IndexMappingRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexMappingRecord build() {
            _checkSingleUse();

            return new IndexMappingRecord(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexMappingRecord}
     */
    public static final JsonpDeserializer<IndexMappingRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexMappingRecord::setupIndexMappingRecordDeserializer
    );

    protected static void setupIndexMappingRecordDeserializer(ObjectDeserializer<IndexMappingRecord.Builder> op) {
        op.add(Builder::item, TypeMapping._DESERIALIZER, "item");
        op.add(Builder::mappings, TypeMapping._DESERIALIZER, "mappings");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.item);
        result = 31 * result + this.mappings.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexMappingRecord other = (IndexMappingRecord) o;
        return Objects.equals(this.item, other.item) && this.mappings.equals(other.mappings);
    }
}
