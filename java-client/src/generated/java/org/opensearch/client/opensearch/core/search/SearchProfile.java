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

package org.opensearch.client.opensearch.core.search;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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

// typedef: core.search.SearchProfile

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SearchProfile implements PlainJsonSerializable, ToCopyableBuilder<SearchProfile.Builder, SearchProfile> {

    @Nonnull
    private final List<Collector> collector;

    @Nonnull
    private final List<QueryProfile> query;

    private final long rewriteTime;

    // ---------------------------------------------------------------------------------------------

    private SearchProfile(Builder builder) {
        this.collector = ApiTypeHelper.unmodifiableRequired(builder.collector, this, "collector");
        this.query = ApiTypeHelper.unmodifiableRequired(builder.query, this, "query");
        this.rewriteTime = ApiTypeHelper.requireNonNull(builder.rewriteTime, this, "rewriteTime");
    }

    public static SearchProfile of(Function<SearchProfile.Builder, ObjectBuilder<SearchProfile>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code collector}
     */
    @Nonnull
    public final List<Collector> collector() {
        return this.collector;
    }

    /**
     * Required - API name: {@code query}
     */
    @Nonnull
    public final List<QueryProfile> query() {
        return this.query;
    }

    /**
     * Required - API name: {@code rewrite_time}
     */
    public final long rewriteTime() {
        return this.rewriteTime;
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
        generator.writeKey("collector");
        generator.writeStartArray();
        for (Collector item0 : this.collector) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("query");
        generator.writeStartArray();
        for (QueryProfile item0 : this.query) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("rewrite_time");
        generator.write(this.rewriteTime);
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
     * Builder for {@link SearchProfile}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SearchProfile> {
        private List<Collector> collector;
        private List<QueryProfile> query;
        private Long rewriteTime;

        public Builder() {}

        private Builder(SearchProfile o) {
            this.collector = _listCopy(o.collector);
            this.query = _listCopy(o.query);
            this.rewriteTime = o.rewriteTime;
        }

        private Builder(Builder o) {
            this.collector = _listCopy(o.collector);
            this.query = _listCopy(o.query);
            this.rewriteTime = o.rewriteTime;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code collector}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>collector</code>.
         * </p>
         */
        @Nonnull
        public final Builder collector(List<Collector> list) {
            this.collector = _listAddAll(this.collector, list);
            return this;
        }

        /**
         * Required - API name: {@code collector}
         *
         * <p>
         * Adds one or more values to <code>collector</code>.
         * </p>
         */
        @Nonnull
        public final Builder collector(Collector value, Collector... values) {
            this.collector = _listAdd(this.collector, value, values);
            return this;
        }

        /**
         * Required - API name: {@code collector}
         *
         * <p>
         * Adds a value to <code>collector</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder collector(Function<Collector.Builder, ObjectBuilder<Collector>> fn) {
            return collector(fn.apply(new Collector.Builder()).build());
        }

        /**
         * Required - API name: {@code query}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>query</code>.
         * </p>
         */
        @Nonnull
        public final Builder query(List<QueryProfile> list) {
            this.query = _listAddAll(this.query, list);
            return this;
        }

        /**
         * Required - API name: {@code query}
         *
         * <p>
         * Adds one or more values to <code>query</code>.
         * </p>
         */
        @Nonnull
        public final Builder query(QueryProfile value, QueryProfile... values) {
            this.query = _listAdd(this.query, value, values);
            return this;
        }

        /**
         * Required - API name: {@code query}
         *
         * <p>
         * Adds a value to <code>query</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder query(Function<QueryProfile.Builder, ObjectBuilder<QueryProfile>> fn) {
            return query(fn.apply(new QueryProfile.Builder()).build());
        }

        /**
         * Required - API name: {@code rewrite_time}
         */
        @Nonnull
        public final Builder rewriteTime(long value) {
            this.rewriteTime = value;
            return this;
        }

        /**
         * Builds a {@link SearchProfile}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SearchProfile build() {
            _checkSingleUse();

            return new SearchProfile(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SearchProfile}
     */
    public static final JsonpDeserializer<SearchProfile> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SearchProfile::setupSearchProfileDeserializer
    );

    protected static void setupSearchProfileDeserializer(ObjectDeserializer<SearchProfile.Builder> op) {
        op.add(Builder::collector, JsonpDeserializer.arrayDeserializer(Collector._DESERIALIZER), "collector");
        op.add(Builder::query, JsonpDeserializer.arrayDeserializer(QueryProfile._DESERIALIZER), "query");
        op.add(Builder::rewriteTime, JsonpDeserializer.longDeserializer(), "rewrite_time");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.collector.hashCode();
        result = 31 * result + this.query.hashCode();
        result = 31 * result + Long.hashCode(this.rewriteTime);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SearchProfile other = (SearchProfile) o;
        return this.collector.equals(other.collector) && this.query.equals(other.query) && this.rewriteTime == other.rewriteTime;
    }
}
