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
import java.util.List;
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

// typedef: indices.IndexSegmentSort

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSegmentSort implements PlainJsonSerializable, ToCopyableBuilder<IndexSegmentSort.Builder, IndexSegmentSort> {

    @Nonnull
    private final List<String> field;

    @Nonnull
    private final List<SegmentSortMissing> missing;

    @Nonnull
    private final List<SegmentSortMode> mode;

    @Nonnull
    private final List<SegmentSortOrder> order;

    // ---------------------------------------------------------------------------------------------

    private IndexSegmentSort(Builder builder) {
        this.field = ApiTypeHelper.unmodifiable(builder.field);
        this.missing = ApiTypeHelper.unmodifiable(builder.missing);
        this.mode = ApiTypeHelper.unmodifiable(builder.mode);
        this.order = ApiTypeHelper.unmodifiable(builder.order);
    }

    public static IndexSegmentSort of(Function<IndexSegmentSort.Builder, ObjectBuilder<IndexSegmentSort>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code field}
     */
    @Nonnull
    public final List<String> field() {
        return this.field;
    }

    /**
     * API name: {@code missing}
     */
    @Nonnull
    public final List<SegmentSortMissing> missing() {
        return this.missing;
    }

    /**
     * API name: {@code mode}
     */
    @Nonnull
    public final List<SegmentSortMode> mode() {
        return this.mode;
    }

    /**
     * API name: {@code order}
     */
    @Nonnull
    public final List<SegmentSortOrder> order() {
        return this.order;
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
        if (ApiTypeHelper.isDefined(this.field)) {
            generator.writeKey("field");
            generator.writeStartArray();
            for (String item0 : this.field) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.missing)) {
            generator.writeKey("missing");
            generator.writeStartArray();
            for (SegmentSortMissing item0 : this.missing) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.mode)) {
            generator.writeKey("mode");
            generator.writeStartArray();
            for (SegmentSortMode item0 : this.mode) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.order)) {
            generator.writeKey("order");
            generator.writeStartArray();
            for (SegmentSortOrder item0 : this.order) {
                item0.serialize(generator, mapper);
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
     * Builder for {@link IndexSegmentSort}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSegmentSort> {
        @Nullable
        private List<String> field;
        @Nullable
        private List<SegmentSortMissing> missing;
        @Nullable
        private List<SegmentSortMode> mode;
        @Nullable
        private List<SegmentSortOrder> order;

        public Builder() {}

        private Builder(IndexSegmentSort o) {
            this.field = _listCopy(o.field);
            this.missing = _listCopy(o.missing);
            this.mode = _listCopy(o.mode);
            this.order = _listCopy(o.order);
        }

        private Builder(Builder o) {
            this.field = _listCopy(o.field);
            this.missing = _listCopy(o.missing);
            this.mode = _listCopy(o.mode);
            this.order = _listCopy(o.order);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code field}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>field</code>.
         * </p>
         */
        @Nonnull
        public final Builder field(List<String> list) {
            this.field = _listAddAll(this.field, list);
            return this;
        }

        /**
         * API name: {@code field}
         *
         * <p>
         * Adds one or more values to <code>field</code>.
         * </p>
         */
        @Nonnull
        public final Builder field(String value, String... values) {
            this.field = _listAdd(this.field, value, values);
            return this;
        }

        /**
         * API name: {@code missing}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>missing</code>.
         * </p>
         */
        @Nonnull
        public final Builder missing(List<SegmentSortMissing> list) {
            this.missing = _listAddAll(this.missing, list);
            return this;
        }

        /**
         * API name: {@code missing}
         *
         * <p>
         * Adds one or more values to <code>missing</code>.
         * </p>
         */
        @Nonnull
        public final Builder missing(SegmentSortMissing value, SegmentSortMissing... values) {
            this.missing = _listAdd(this.missing, value, values);
            return this;
        }

        /**
         * API name: {@code mode}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>mode</code>.
         * </p>
         */
        @Nonnull
        public final Builder mode(List<SegmentSortMode> list) {
            this.mode = _listAddAll(this.mode, list);
            return this;
        }

        /**
         * API name: {@code mode}
         *
         * <p>
         * Adds one or more values to <code>mode</code>.
         * </p>
         */
        @Nonnull
        public final Builder mode(SegmentSortMode value, SegmentSortMode... values) {
            this.mode = _listAdd(this.mode, value, values);
            return this;
        }

        /**
         * API name: {@code order}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>order</code>.
         * </p>
         */
        @Nonnull
        public final Builder order(List<SegmentSortOrder> list) {
            this.order = _listAddAll(this.order, list);
            return this;
        }

        /**
         * API name: {@code order}
         *
         * <p>
         * Adds one or more values to <code>order</code>.
         * </p>
         */
        @Nonnull
        public final Builder order(SegmentSortOrder value, SegmentSortOrder... values) {
            this.order = _listAdd(this.order, value, values);
            return this;
        }

        /**
         * Builds a {@link IndexSegmentSort}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSegmentSort build() {
            _checkSingleUse();

            return new IndexSegmentSort(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSegmentSort}
     */
    public static final JsonpDeserializer<IndexSegmentSort> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSegmentSort::setupIndexSegmentSortDeserializer
    );

    protected static void setupIndexSegmentSortDeserializer(ObjectDeserializer<IndexSegmentSort.Builder> op) {
        op.add(Builder::field, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "field");
        op.add(Builder::missing, JsonpDeserializer.arrayDeserializer(SegmentSortMissing._DESERIALIZER), "missing");
        op.add(Builder::mode, JsonpDeserializer.arrayDeserializer(SegmentSortMode._DESERIALIZER), "mode");
        op.add(Builder::order, JsonpDeserializer.arrayDeserializer(SegmentSortOrder._DESERIALIZER), "order");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.missing);
        result = 31 * result + Objects.hashCode(this.mode);
        result = 31 * result + Objects.hashCode(this.order);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSegmentSort other = (IndexSegmentSort) o;
        return Objects.equals(this.field, other.field)
            && Objects.equals(this.missing, other.missing)
            && Objects.equals(this.mode, other.mode)
            && Objects.equals(this.order, other.order);
    }
}
