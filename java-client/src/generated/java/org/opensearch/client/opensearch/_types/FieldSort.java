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
import org.opensearch.client.opensearch._types.mapping.FieldType;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.FieldSort

/**
 * The detailed field sort options.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FieldSort implements PlainJsonSerializable, ToCopyableBuilder<FieldSort.Builder, FieldSort> {

    @Nullable
    private final FieldValue missing;

    @Nullable
    private final SortMode mode;

    @Nullable
    private final NestedSortValue nested;

    @Nullable
    private final FieldSortNumericType numericType;

    @Nullable
    private final SortOrder order;

    @Nullable
    private final FieldType unmappedType;

    // ---------------------------------------------------------------------------------------------

    private FieldSort(Builder builder) {
        this.missing = builder.missing;
        this.mode = builder.mode;
        this.nested = builder.nested;
        this.numericType = builder.numericType;
        this.order = builder.order;
        this.unmappedType = builder.unmappedType;
    }

    public static FieldSort of(Function<FieldSort.Builder, ObjectBuilder<FieldSort>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The value to use when the field is missing.
     * <p>
     * API name: {@code missing}
     * </p>
     */
    @Nullable
    public final FieldValue missing() {
        return this.missing;
    }

    /**
     * The mode for sorting on array fields.
     * <p>
     * API name: {@code mode}
     * </p>
     */
    @Nullable
    public final SortMode mode() {
        return this.mode;
    }

    /**
     * The nested path sort options.
     * <p>
     * API name: {@code nested}
     * </p>
     */
    @Nullable
    public final NestedSortValue nested() {
        return this.nested;
    }

    /**
     * The numeric type to use for sorting.
     * <p>
     * API name: {@code numeric_type}
     * </p>
     */
    @Nullable
    public final FieldSortNumericType numericType() {
        return this.numericType;
    }

    /**
     * The sort order direction.
     * <p>
     * API name: {@code order}
     * </p>
     */
    @Nullable
    public final SortOrder order() {
        return this.order;
    }

    /**
     * The type to use for unmapped fields.
     * <p>
     * API name: {@code unmapped_type}
     * </p>
     */
    @Nullable
    public final FieldType unmappedType() {
        return this.unmappedType;
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
        if (this.missing != null) {
            generator.writeKey("missing");
            this.missing.serialize(generator, mapper);
        }

        if (this.mode != null) {
            generator.writeKey("mode");
            this.mode.serialize(generator, mapper);
        }

        if (this.nested != null) {
            generator.writeKey("nested");
            this.nested.serialize(generator, mapper);
        }

        if (this.numericType != null) {
            generator.writeKey("numeric_type");
            this.numericType.serialize(generator, mapper);
        }

        if (this.order != null) {
            generator.writeKey("order");
            this.order.serialize(generator, mapper);
        }

        if (this.unmappedType != null) {
            generator.writeKey("unmapped_type");
            this.unmappedType.serialize(generator, mapper);
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
     * Builder for {@link FieldSort}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, FieldSort> {
        @Nullable
        private FieldValue missing;
        @Nullable
        private SortMode mode;
        @Nullable
        private NestedSortValue nested;
        @Nullable
        private FieldSortNumericType numericType;
        @Nullable
        private SortOrder order;
        @Nullable
        private FieldType unmappedType;

        public Builder() {}

        private Builder(FieldSort o) {
            this.missing = o.missing;
            this.mode = o.mode;
            this.nested = o.nested;
            this.numericType = o.numericType;
            this.order = o.order;
            this.unmappedType = o.unmappedType;
        }

        private Builder(Builder o) {
            this.missing = o.missing;
            this.mode = o.mode;
            this.nested = o.nested;
            this.numericType = o.numericType;
            this.order = o.order;
            this.unmappedType = o.unmappedType;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The value to use when the field is missing.
         * <p>
         * API name: {@code missing}
         * </p>
         */
        @Nonnull
        public final Builder missing(@Nullable FieldValue value) {
            this.missing = value;
            return this;
        }

        /**
         * The value to use when the field is missing.
         * <p>
         * API name: {@code missing}
         * </p>
         */
        @Nonnull
        public final Builder missing(Function<FieldValue.Builder, ObjectBuilder<FieldValue>> fn) {
            return missing(fn.apply(new FieldValue.Builder()).build());
        }

        /**
         * The mode for sorting on array fields.
         * <p>
         * API name: {@code mode}
         * </p>
         */
        @Nonnull
        public final Builder mode(@Nullable SortMode value) {
            this.mode = value;
            return this;
        }

        /**
         * The nested path sort options.
         * <p>
         * API name: {@code nested}
         * </p>
         */
        @Nonnull
        public final Builder nested(@Nullable NestedSortValue value) {
            this.nested = value;
            return this;
        }

        /**
         * The nested path sort options.
         * <p>
         * API name: {@code nested}
         * </p>
         */
        @Nonnull
        public final Builder nested(Function<NestedSortValue.Builder, ObjectBuilder<NestedSortValue>> fn) {
            return nested(fn.apply(new NestedSortValue.Builder()).build());
        }

        /**
         * The numeric type to use for sorting.
         * <p>
         * API name: {@code numeric_type}
         * </p>
         */
        @Nonnull
        public final Builder numericType(@Nullable FieldSortNumericType value) {
            this.numericType = value;
            return this;
        }

        /**
         * The sort order direction.
         * <p>
         * API name: {@code order}
         * </p>
         */
        @Nonnull
        public final Builder order(@Nullable SortOrder value) {
            this.order = value;
            return this;
        }

        /**
         * The type to use for unmapped fields.
         * <p>
         * API name: {@code unmapped_type}
         * </p>
         */
        @Nonnull
        public final Builder unmappedType(@Nullable FieldType value) {
            this.unmappedType = value;
            return this;
        }

        /**
         * Builds a {@link FieldSort}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FieldSort build() {
            _checkSingleUse();

            return new FieldSort(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FieldSort}
     */
    public static final JsonpDeserializer<FieldSort> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FieldSort::setupFieldSortDeserializer
    );

    protected static void setupFieldSortDeserializer(ObjectDeserializer<FieldSort.Builder> op) {
        op.add(Builder::missing, FieldValue._DESERIALIZER, "missing");
        op.add(Builder::mode, SortMode._DESERIALIZER, "mode");
        op.add(Builder::nested, NestedSortValue._DESERIALIZER, "nested");
        op.add(Builder::numericType, FieldSortNumericType._DESERIALIZER, "numeric_type");
        op.add(Builder::order, SortOrder._DESERIALIZER, "order");
        op.add(Builder::unmappedType, FieldType._DESERIALIZER, "unmapped_type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.missing);
        result = 31 * result + Objects.hashCode(this.mode);
        result = 31 * result + Objects.hashCode(this.nested);
        result = 31 * result + Objects.hashCode(this.numericType);
        result = 31 * result + Objects.hashCode(this.order);
        result = 31 * result + Objects.hashCode(this.unmappedType);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FieldSort other = (FieldSort) o;
        return Objects.equals(this.missing, other.missing)
            && Objects.equals(this.mode, other.mode)
            && Objects.equals(this.nested, other.nested)
            && Objects.equals(this.numericType, other.numericType)
            && Objects.equals(this.order, other.order)
            && Objects.equals(this.unmappedType, other.unmappedType);
    }
}
