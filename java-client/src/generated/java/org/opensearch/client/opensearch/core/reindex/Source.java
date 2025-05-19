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

package org.opensearch.client.opensearch.core.reindex;

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
import org.opensearch.client.opensearch._types.SlicedScroll;
import org.opensearch.client.opensearch._types.SortOptions;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.reindex.Source

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Source implements PlainJsonSerializable, ToCopyableBuilder<Source.Builder, Source> {

    @Nonnull
    private final List<String> index;

    @Nullable
    private final Query query;

    @Nullable
    private final RemoteSource remote;

    @Nullable
    private final Integer size;

    @Nullable
    private final SlicedScroll slice;

    @Nonnull
    private final List<SortOptions> sort;

    @Nonnull
    private final List<String> sourceFields;

    // ---------------------------------------------------------------------------------------------

    private Source(Builder builder) {
        this.index = ApiTypeHelper.unmodifiableRequired(builder.index, this, "index");
        this.query = builder.query;
        this.remote = builder.remote;
        this.size = builder.size;
        this.slice = builder.slice;
        this.sort = ApiTypeHelper.unmodifiable(builder.sort);
        this.sourceFields = ApiTypeHelper.unmodifiable(builder.sourceFields);
    }

    public static Source of(Function<Source.Builder, ObjectBuilder<Source>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code index}
     */
    @Nonnull
    public final List<String> index() {
        return this.index;
    }

    /**
     * API name: {@code query}
     */
    @Nullable
    public final Query query() {
        return this.query;
    }

    /**
     * API name: {@code remote}
     */
    @Nullable
    public final RemoteSource remote() {
        return this.remote;
    }

    /**
     * The number of documents to index per batch. Use the <code>size</code> setting when indexing from a remote cluster. This ensures that
     * batches fit in the on-heap buffer. The buffer defaults to a maximum size of <code>100MB</code>.
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * API name: {@code slice}
     */
    @Nullable
    public final SlicedScroll slice() {
        return this.slice;
    }

    /**
     * API name: {@code sort}
     */
    @Nonnull
    public final List<SortOptions> sort() {
        return this.sort;
    }

    /**
     * API name: {@code _source}
     */
    @Nonnull
    public final List<String> sourceFields() {
        return this.sourceFields;
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
        generator.writeKey("index");
        generator.writeStartArray();
        for (String item0 : this.index) {
            generator.write(item0);
        }
        generator.writeEnd();

        if (this.query != null) {
            generator.writeKey("query");
            this.query.serialize(generator, mapper);
        }

        if (this.remote != null) {
            generator.writeKey("remote");
            this.remote.serialize(generator, mapper);
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        if (this.slice != null) {
            generator.writeKey("slice");
            this.slice.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.sort)) {
            generator.writeKey("sort");
            generator.writeStartArray();
            for (SortOptions item0 : this.sort) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.sourceFields)) {
            generator.writeKey("_source");
            generator.writeStartArray();
            for (String item0 : this.sourceFields) {
                generator.write(item0);
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
     * Builder for {@link Source}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Source> {
        private List<String> index;
        @Nullable
        private Query query;
        @Nullable
        private RemoteSource remote;
        @Nullable
        private Integer size;
        @Nullable
        private SlicedScroll slice;
        @Nullable
        private List<SortOptions> sort;
        @Nullable
        private List<String> sourceFields;

        public Builder() {}

        private Builder(Source o) {
            this.index = _listCopy(o.index);
            this.query = o.query;
            this.remote = o.remote;
            this.size = o.size;
            this.slice = o.slice;
            this.sort = _listCopy(o.sort);
            this.sourceFields = _listCopy(o.sourceFields);
        }

        private Builder(Builder o) {
            this.index = _listCopy(o.index);
            this.query = o.query;
            this.remote = o.remote;
            this.size = o.size;
            this.slice = o.slice;
            this.sort = _listCopy(o.sort);
            this.sourceFields = _listCopy(o.sourceFields);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code index}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>index</code>.
         * </p>
         */
        @Nonnull
        public final Builder index(List<String> list) {
            this.index = _listAddAll(this.index, list);
            return this;
        }

        /**
         * Required - API name: {@code index}
         *
         * <p>
         * Adds one or more values to <code>index</code>.
         * </p>
         */
        @Nonnull
        public final Builder index(String value, String... values) {
            this.index = _listAdd(this.index, value, values);
            return this;
        }

        /**
         * API name: {@code query}
         */
        @Nonnull
        public final Builder query(@Nullable Query value) {
            this.query = value;
            return this;
        }

        /**
         * API name: {@code query}
         */
        @Nonnull
        public final Builder query(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return query(fn.apply(new Query.Builder()).build());
        }

        /**
         * API name: {@code remote}
         */
        @Nonnull
        public final Builder remote(@Nullable RemoteSource value) {
            this.remote = value;
            return this;
        }

        /**
         * API name: {@code remote}
         */
        @Nonnull
        public final Builder remote(Function<RemoteSource.Builder, ObjectBuilder<RemoteSource>> fn) {
            return remote(fn.apply(new RemoteSource.Builder()).build());
        }

        /**
         * The number of documents to index per batch. Use the <code>size</code> setting when indexing from a remote cluster. This ensures
         * that batches fit in the on-heap buffer. The buffer defaults to a maximum size of <code>100MB</code>.
         * <p>
         * API name: {@code size}
         * </p>
         */
        @Nonnull
        public final Builder size(@Nullable Integer value) {
            this.size = value;
            return this;
        }

        /**
         * API name: {@code slice}
         */
        @Nonnull
        public final Builder slice(@Nullable SlicedScroll value) {
            this.slice = value;
            return this;
        }

        /**
         * API name: {@code slice}
         */
        @Nonnull
        public final Builder slice(Function<SlicedScroll.Builder, ObjectBuilder<SlicedScroll>> fn) {
            return slice(fn.apply(new SlicedScroll.Builder()).build());
        }

        /**
         * API name: {@code sort}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>sort</code>.
         * </p>
         */
        @Nonnull
        public final Builder sort(List<SortOptions> list) {
            this.sort = _listAddAll(this.sort, list);
            return this;
        }

        /**
         * API name: {@code sort}
         *
         * <p>
         * Adds one or more values to <code>sort</code>.
         * </p>
         */
        @Nonnull
        public final Builder sort(SortOptions value, SortOptions... values) {
            this.sort = _listAdd(this.sort, value, values);
            return this;
        }

        /**
         * API name: {@code sort}
         *
         * <p>
         * Adds a value to <code>sort</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder sort(Function<SortOptions.Builder, ObjectBuilder<SortOptions>> fn) {
            return sort(fn.apply(new SortOptions.Builder()).build());
        }

        /**
         * API name: {@code _source}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>sourceFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder sourceFields(List<String> list) {
            this.sourceFields = _listAddAll(this.sourceFields, list);
            return this;
        }

        /**
         * API name: {@code _source}
         *
         * <p>
         * Adds one or more values to <code>sourceFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder sourceFields(String value, String... values) {
            this.sourceFields = _listAdd(this.sourceFields, value, values);
            return this;
        }

        /**
         * Builds a {@link Source}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Source build() {
            _checkSingleUse();

            return new Source(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Source}
     */
    public static final JsonpDeserializer<Source> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Source::setupSourceDeserializer
    );

    protected static void setupSourceDeserializer(ObjectDeserializer<Source.Builder> op) {
        op.add(Builder::index, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "index");
        op.add(Builder::query, Query._DESERIALIZER, "query");
        op.add(Builder::remote, RemoteSource._DESERIALIZER, "remote");
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
        op.add(Builder::slice, SlicedScroll._DESERIALIZER, "slice");
        op.add(Builder::sort, JsonpDeserializer.arrayDeserializer(SortOptions._DESERIALIZER), "sort");
        op.add(Builder::sourceFields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "_source");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Objects.hashCode(this.query);
        result = 31 * result + Objects.hashCode(this.remote);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.slice);
        result = 31 * result + Objects.hashCode(this.sort);
        result = 31 * result + Objects.hashCode(this.sourceFields);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Source other = (Source) o;
        return this.index.equals(other.index)
            && Objects.equals(this.query, other.query)
            && Objects.equals(this.remote, other.remote)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.slice, other.slice)
            && Objects.equals(this.sort, other.sort)
            && Objects.equals(this.sourceFields, other.sourceFields);
    }
}
