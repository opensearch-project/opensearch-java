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
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.NestedSortValue

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NestedSortValue implements PlainJsonSerializable, ToCopyableBuilder<NestedSortValue.Builder, NestedSortValue> {

    @Nullable
    private final Query filter;

    @Nullable
    private final Integer maxChildren;

    @Nullable
    private final NestedSortValue nested;

    @Nonnull
    private final String path;

    // ---------------------------------------------------------------------------------------------

    private NestedSortValue(Builder builder) {
        this.filter = builder.filter;
        this.maxChildren = builder.maxChildren;
        this.nested = builder.nested;
        this.path = ApiTypeHelper.requireNonNull(builder.path, this, "path");
    }

    public static NestedSortValue of(Function<NestedSortValue.Builder, ObjectBuilder<NestedSortValue>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The filter to apply to nested objects.
     * <p>
     * API name: {@code filter}
     * </p>
     */
    @Nullable
    public final Query filter() {
        return this.filter;
    }

    /**
     * The maximum number of children to consider for sorting.
     * <p>
     * API name: {@code max_children}
     * </p>
     */
    @Nullable
    public final Integer maxChildren() {
        return this.maxChildren;
    }

    /**
     * How to sort hierarchical nested objects.
     * <p>
     * API name: {@code nested}
     * </p>
     */
    @Nullable
    public final NestedSortValue nested() {
        return this.nested;
    }

    /**
     * Required - The path to the nested objects.
     * <p>
     * API name: {@code path}
     * </p>
     */
    @Nonnull
    public final String path() {
        return this.path;
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
        if (this.filter != null) {
            generator.writeKey("filter");
            this.filter.serialize(generator, mapper);
        }

        if (this.maxChildren != null) {
            generator.writeKey("max_children");
            generator.write(this.maxChildren);
        }

        if (this.nested != null) {
            generator.writeKey("nested");
            this.nested.serialize(generator, mapper);
        }

        generator.writeKey("path");
        generator.write(this.path);
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
     * Builder for {@link NestedSortValue}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NestedSortValue> {
        @Nullable
        private Query filter;
        @Nullable
        private Integer maxChildren;
        @Nullable
        private NestedSortValue nested;
        private String path;

        public Builder() {}

        private Builder(NestedSortValue o) {
            this.filter = o.filter;
            this.maxChildren = o.maxChildren;
            this.nested = o.nested;
            this.path = o.path;
        }

        private Builder(Builder o) {
            this.filter = o.filter;
            this.maxChildren = o.maxChildren;
            this.nested = o.nested;
            this.path = o.path;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The filter to apply to nested objects.
         * <p>
         * API name: {@code filter}
         * </p>
         */
        @Nonnull
        public final Builder filter(@Nullable Query value) {
            this.filter = value;
            return this;
        }

        /**
         * The filter to apply to nested objects.
         * <p>
         * API name: {@code filter}
         * </p>
         */
        @Nonnull
        public final Builder filter(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return filter(fn.apply(new Query.Builder()).build());
        }

        /**
         * The maximum number of children to consider for sorting.
         * <p>
         * API name: {@code max_children}
         * </p>
         */
        @Nonnull
        public final Builder maxChildren(@Nullable Integer value) {
            this.maxChildren = value;
            return this;
        }

        /**
         * How to sort hierarchical nested objects.
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
         * How to sort hierarchical nested objects.
         * <p>
         * API name: {@code nested}
         * </p>
         */
        @Nonnull
        public final Builder nested(Function<NestedSortValue.Builder, ObjectBuilder<NestedSortValue>> fn) {
            return nested(fn.apply(new NestedSortValue.Builder()).build());
        }

        /**
         * Required - The path to the nested objects.
         * <p>
         * API name: {@code path}
         * </p>
         */
        @Nonnull
        public final Builder path(String value) {
            this.path = value;
            return this;
        }

        /**
         * Builds a {@link NestedSortValue}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NestedSortValue build() {
            _checkSingleUse();

            return new NestedSortValue(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NestedSortValue}
     */
    public static final JsonpDeserializer<NestedSortValue> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NestedSortValue::setupNestedSortValueDeserializer
    );

    protected static void setupNestedSortValueDeserializer(ObjectDeserializer<NestedSortValue.Builder> op) {
        op.add(Builder::filter, Query._DESERIALIZER, "filter");
        op.add(Builder::maxChildren, JsonpDeserializer.integerDeserializer(), "max_children");
        op.add(Builder::nested, NestedSortValue._DESERIALIZER, "nested");
        op.add(Builder::path, JsonpDeserializer.stringDeserializer(), "path");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.filter);
        result = 31 * result + Objects.hashCode(this.maxChildren);
        result = 31 * result + Objects.hashCode(this.nested);
        result = 31 * result + this.path.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NestedSortValue other = (NestedSortValue) o;
        return Objects.equals(this.filter, other.filter)
            && Objects.equals(this.maxChildren, other.maxChildren)
            && Objects.equals(this.nested, other.nested)
            && this.path.equals(other.path);
    }
}
