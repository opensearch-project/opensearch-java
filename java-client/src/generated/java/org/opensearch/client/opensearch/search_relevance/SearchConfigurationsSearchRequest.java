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

package org.opensearch.client.opensearch.search_relevance;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.List;
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
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.SortOptions;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_relevance.search_configurations_search.Request

/**
 * Searches for search configurations.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class SearchConfigurationsSearchRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<SearchConfigurationsSearchRequest.Builder, SearchConfigurationsSearchRequest> {

    @Nullable
    private final Integer from;

    @Nullable
    private final Query query;

    @Nullable
    private final Integer size;

    @Nonnull
    private final List<SortOptions> sort;

    // ---------------------------------------------------------------------------------------------

    private SearchConfigurationsSearchRequest(Builder builder) {
        super(builder);
        this.from = builder.from;
        this.query = builder.query;
        this.size = builder.size;
        this.sort = ApiTypeHelper.unmodifiable(builder.sort);
    }

    public static SearchConfigurationsSearchRequest of(
        Function<SearchConfigurationsSearchRequest.Builder, ObjectBuilder<SearchConfigurationsSearchRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The starting offset for the results.
     * <p>
     * API name: {@code from}
     * </p>
     */
    @Nullable
    public final Integer from() {
        return this.from;
    }

    /**
     * API name: {@code query}
     */
    @Nullable
    public final Query query() {
        return this.query;
    }

    /**
     * The maximum number of results to return.
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * The sort order.
     * <p>
     * API name: {@code sort}
     * </p>
     */
    @Nonnull
    public final List<SortOptions> sort() {
        return this.sort;
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
        if (this.from != null) {
            generator.writeKey("from");
            generator.write(this.from);
        }

        if (this.query != null) {
            generator.writeKey("query");
            this.query.serialize(generator, mapper);
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        if (ApiTypeHelper.isDefined(this.sort)) {
            generator.writeKey("sort");
            generator.writeStartArray();
            for (SortOptions item0 : this.sort) {
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
     * Builder for {@link SearchConfigurationsSearchRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, SearchConfigurationsSearchRequest> {
        @Nullable
        private Integer from;
        @Nullable
        private Query query;
        @Nullable
        private Integer size;
        @Nullable
        private List<SortOptions> sort;

        public Builder() {}

        private Builder(SearchConfigurationsSearchRequest o) {
            super(o);
            this.from = o.from;
            this.query = o.query;
            this.size = o.size;
            this.sort = _listCopy(o.sort);
        }

        private Builder(Builder o) {
            super(o);
            this.from = o.from;
            this.query = o.query;
            this.size = o.size;
            this.sort = _listCopy(o.sort);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * The starting offset for the results.
         * <p>
         * API name: {@code from}
         * </p>
         */
        @Nonnull
        public final Builder from(@Nullable Integer value) {
            this.from = value;
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
         * The maximum number of results to return.
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
         * The sort order.
         * <p>
         * API name: {@code sort}
         * </p>
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
         * The sort order.
         * <p>
         * API name: {@code sort}
         * </p>
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
         * The sort order.
         * <p>
         * API name: {@code sort}
         * </p>
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
         * Builds a {@link SearchConfigurationsSearchRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SearchConfigurationsSearchRequest build() {
            _checkSingleUse();

            return new SearchConfigurationsSearchRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SearchConfigurationsSearchRequest}
     */
    public static final JsonpDeserializer<SearchConfigurationsSearchRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SearchConfigurationsSearchRequest::setupSearchConfigurationsSearchRequestDeserializer
    );

    protected static void setupSearchConfigurationsSearchRequestDeserializer(
        ObjectDeserializer<SearchConfigurationsSearchRequest.Builder> op
    ) {
        op.add(Builder::from, JsonpDeserializer.integerDeserializer(), "from");
        op.add(Builder::query, Query._DESERIALIZER, "query");
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
        op.add(Builder::sort, JsonpDeserializer.arrayDeserializer(SortOptions._DESERIALIZER), "sort");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code search_relevance.search_configurations_search}".
     */
    public static final SimpleEndpoint<SearchConfigurationsSearchRequest, ?> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> "/_plugins/_search_relevance/search_configurations/_search",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        SearchConfigurationsSearchResponse._DESERIALIZER
    );

    /**
     * Create an "{@code search_relevance.search_configurations_search}" endpoint.
     */
    public static <
        TDocument>
        Endpoint<SearchConfigurationsSearchRequest, SearchConfigurationsSearchResponse<TDocument>, ErrorResponse>
        createSearchRelevanceSearchConfigurationsSearchEndpoint(JsonpDeserializer<TDocument> tDocumentDeserializer) {
        return _ENDPOINT.withResponseDeserializer(
            SearchConfigurationsSearchResponse.createSearchConfigurationsSearchResponseDeserializer(tDocumentDeserializer)
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.from);
        result = 31 * result + Objects.hashCode(this.query);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.sort);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SearchConfigurationsSearchRequest other = (SearchConfigurationsSearchRequest) o;
        return Objects.equals(this.from, other.from)
            && Objects.equals(this.query, other.query)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.sort, other.sort);
    }
}
