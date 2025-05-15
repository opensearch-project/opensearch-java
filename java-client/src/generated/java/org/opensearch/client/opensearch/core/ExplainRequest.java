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

package org.opensearch.client.opensearch.core;

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
import org.opensearch.client.opensearch._types.query_dsl.Operator;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch.core.search.SourceConfigParam;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.explain.Request

/**
 * Returns information about why a specific document matches (or doesn't match) a query.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class ExplainRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ExplainRequest.Builder, ExplainRequest> {

    @Nullable
    private final Boolean analyzeWildcard;

    @Nullable
    private final String analyzer;

    @Nullable
    private final Operator defaultOperator;

    @Nullable
    private final String df;

    @Nonnull
    private final String id;

    @Nonnull
    private final String index;

    @Nullable
    private final Boolean lenient;

    @Nullable
    private final String preference;

    @Nullable
    private final String q;

    @Nullable
    private final Query query;

    @Nonnull
    private final List<String> routing;

    @Nullable
    private final SourceConfigParam source;

    @Nonnull
    private final List<String> sourceExcludes;

    @Nonnull
    private final List<String> sourceIncludes;

    @Nonnull
    private final List<String> storedFields;

    // ---------------------------------------------------------------------------------------------

    private ExplainRequest(Builder builder) {
        super(builder);
        this.analyzeWildcard = builder.analyzeWildcard;
        this.analyzer = builder.analyzer;
        this.defaultOperator = builder.defaultOperator;
        this.df = builder.df;
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.lenient = builder.lenient;
        this.preference = builder.preference;
        this.q = builder.q;
        this.query = builder.query;
        this.routing = ApiTypeHelper.unmodifiable(builder.routing);
        this.source = builder.source;
        this.sourceExcludes = ApiTypeHelper.unmodifiable(builder.sourceExcludes);
        this.sourceIncludes = ApiTypeHelper.unmodifiable(builder.sourceIncludes);
        this.storedFields = ApiTypeHelper.unmodifiable(builder.storedFields);
    }

    public static ExplainRequest of(Function<ExplainRequest.Builder, ObjectBuilder<ExplainRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * If <code>true</code>, wildcard and prefix queries are analyzed.
     * <p>
     * API name: {@code analyze_wildcard}
     * </p>
     */
    @Nullable
    public final Boolean analyzeWildcard() {
        return this.analyzeWildcard;
    }

    /**
     * Analyzer to use for the query string. This parameter can only be used when the <code>q</code> query string parameter is specified.
     * <p>
     * API name: {@code analyzer}
     * </p>
     */
    @Nullable
    public final String analyzer() {
        return this.analyzer;
    }

    /**
     * The default operator for query string query: <code>AND</code> or <code>OR</code>.
     * <p>
     * API name: {@code default_operator}
     * </p>
     */
    @Nullable
    public final Operator defaultOperator() {
        return this.defaultOperator;
    }

    /**
     * Field to use as default where no field prefix is given in the query string.
     * <p>
     * API name: {@code df}
     * </p>
     */
    @Nullable
    public final String df() {
        return this.df;
    }

    /**
     * Required - Defines the document ID.
     * <p>
     * API name: {@code id}
     * </p>
     */
    @Nonnull
    public final String id() {
        return this.id;
    }

    /**
     * Required - Index names used to limit the request. Only a single index name can be provided to this parameter.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final String index() {
        return this.index;
    }

    /**
     * If <code>true</code>, format-based query failures (such as providing text to a numeric field) in the query string will be ignored.
     * <p>
     * API name: {@code lenient}
     * </p>
     */
    @Nullable
    public final Boolean lenient() {
        return this.lenient;
    }

    /**
     * Specifies the node or shard the operation should be performed on. Random by default.
     * <p>
     * API name: {@code preference}
     * </p>
     */
    @Nullable
    public final String preference() {
        return this.preference;
    }

    /**
     * Query in the Lucene query string syntax.
     * <p>
     * API name: {@code q}
     * </p>
     */
    @Nullable
    public final String q() {
        return this.q;
    }

    /**
     * API name: {@code query}
     */
    @Nullable
    public final Query query() {
        return this.query;
    }

    /**
     * A custom value used to route operations to a specific shard.
     * <p>
     * API name: {@code routing}
     * </p>
     */
    @Nonnull
    public final List<String> routing() {
        return this.routing;
    }

    /**
     * Set to <code>true</code> or <code>false</code> to return the <code>_source</code> field or not, or a list of fields to return.
     * <p>
     * API name: {@code _source}
     * </p>
     */
    @Nullable
    public final SourceConfigParam source() {
        return this.source;
    }

    /**
     * A comma-separated list of source fields to exclude from the response.
     * <p>
     * API name: {@code _source_excludes}
     * </p>
     */
    @Nonnull
    public final List<String> sourceExcludes() {
        return this.sourceExcludes;
    }

    /**
     * A comma-separated list of source fields to include in the response.
     * <p>
     * API name: {@code _source_includes}
     * </p>
     */
    @Nonnull
    public final List<String> sourceIncludes() {
        return this.sourceIncludes;
    }

    /**
     * A comma-separated list of stored fields to return in the response.
     * <p>
     * API name: {@code stored_fields}
     * </p>
     */
    @Nonnull
    public final List<String> storedFields() {
        return this.storedFields;
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
        if (this.query != null) {
            generator.writeKey("query");
            this.query.serialize(generator, mapper);
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
     * Builder for {@link ExplainRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ExplainRequest> {
        @Nullable
        private Boolean analyzeWildcard;
        @Nullable
        private String analyzer;
        @Nullable
        private Operator defaultOperator;
        @Nullable
        private String df;
        private String id;
        private String index;
        @Nullable
        private Boolean lenient;
        @Nullable
        private String preference;
        @Nullable
        private String q;
        @Nullable
        private Query query;
        @Nullable
        private List<String> routing;
        @Nullable
        private SourceConfigParam source;
        @Nullable
        private List<String> sourceExcludes;
        @Nullable
        private List<String> sourceIncludes;
        @Nullable
        private List<String> storedFields;

        public Builder() {}

        private Builder(ExplainRequest o) {
            super(o);
            this.analyzeWildcard = o.analyzeWildcard;
            this.analyzer = o.analyzer;
            this.defaultOperator = o.defaultOperator;
            this.df = o.df;
            this.id = o.id;
            this.index = o.index;
            this.lenient = o.lenient;
            this.preference = o.preference;
            this.q = o.q;
            this.query = o.query;
            this.routing = _listCopy(o.routing);
            this.source = o.source;
            this.sourceExcludes = _listCopy(o.sourceExcludes);
            this.sourceIncludes = _listCopy(o.sourceIncludes);
            this.storedFields = _listCopy(o.storedFields);
        }

        private Builder(Builder o) {
            super(o);
            this.analyzeWildcard = o.analyzeWildcard;
            this.analyzer = o.analyzer;
            this.defaultOperator = o.defaultOperator;
            this.df = o.df;
            this.id = o.id;
            this.index = o.index;
            this.lenient = o.lenient;
            this.preference = o.preference;
            this.q = o.q;
            this.query = o.query;
            this.routing = _listCopy(o.routing);
            this.source = o.source;
            this.sourceExcludes = _listCopy(o.sourceExcludes);
            this.sourceIncludes = _listCopy(o.sourceIncludes);
            this.storedFields = _listCopy(o.storedFields);
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
         * If <code>true</code>, wildcard and prefix queries are analyzed.
         * <p>
         * API name: {@code analyze_wildcard}
         * </p>
         */
        @Nonnull
        public final Builder analyzeWildcard(@Nullable Boolean value) {
            this.analyzeWildcard = value;
            return this;
        }

        /**
         * Analyzer to use for the query string. This parameter can only be used when the <code>q</code> query string parameter is
         * specified.
         * <p>
         * API name: {@code analyzer}
         * </p>
         */
        @Nonnull
        public final Builder analyzer(@Nullable String value) {
            this.analyzer = value;
            return this;
        }

        /**
         * The default operator for query string query: <code>AND</code> or <code>OR</code>.
         * <p>
         * API name: {@code default_operator}
         * </p>
         */
        @Nonnull
        public final Builder defaultOperator(@Nullable Operator value) {
            this.defaultOperator = value;
            return this;
        }

        /**
         * Field to use as default where no field prefix is given in the query string.
         * <p>
         * API name: {@code df}
         * </p>
         */
        @Nonnull
        public final Builder df(@Nullable String value) {
            this.df = value;
            return this;
        }

        /**
         * Required - Defines the document ID.
         * <p>
         * API name: {@code id}
         * </p>
         */
        @Nonnull
        public final Builder id(String value) {
            this.id = value;
            return this;
        }

        /**
         * Required - Index names used to limit the request. Only a single index name can be provided to this parameter.
         * <p>
         * API name: {@code index}
         * </p>
         */
        @Nonnull
        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        /**
         * If <code>true</code>, format-based query failures (such as providing text to a numeric field) in the query string will be
         * ignored.
         * <p>
         * API name: {@code lenient}
         * </p>
         */
        @Nonnull
        public final Builder lenient(@Nullable Boolean value) {
            this.lenient = value;
            return this;
        }

        /**
         * Specifies the node or shard the operation should be performed on. Random by default.
         * <p>
         * API name: {@code preference}
         * </p>
         */
        @Nonnull
        public final Builder preference(@Nullable String value) {
            this.preference = value;
            return this;
        }

        /**
         * Query in the Lucene query string syntax.
         * <p>
         * API name: {@code q}
         * </p>
         */
        @Nonnull
        public final Builder q(@Nullable String value) {
            this.q = value;
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
         * A custom value used to route operations to a specific shard.
         * <p>
         * API name: {@code routing}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>routing</code>.
         * </p>
         */
        @Nonnull
        public final Builder routing(List<String> list) {
            this.routing = _listAddAll(this.routing, list);
            return this;
        }

        /**
         * A custom value used to route operations to a specific shard.
         * <p>
         * API name: {@code routing}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>routing</code>.
         * </p>
         */
        @Nonnull
        public final Builder routing(String value, String... values) {
            this.routing = _listAdd(this.routing, value, values);
            return this;
        }

        /**
         * Set to <code>true</code> or <code>false</code> to return the <code>_source</code> field or not, or a list of fields to return.
         * <p>
         * API name: {@code _source}
         * </p>
         */
        @Nonnull
        public final Builder source(@Nullable SourceConfigParam value) {
            this.source = value;
            return this;
        }

        /**
         * Set to <code>true</code> or <code>false</code> to return the <code>_source</code> field or not, or a list of fields to return.
         * <p>
         * API name: {@code _source}
         * </p>
         */
        @Nonnull
        public final Builder source(Function<SourceConfigParam.Builder, ObjectBuilder<SourceConfigParam>> fn) {
            return source(fn.apply(new SourceConfigParam.Builder()).build());
        }

        /**
         * A comma-separated list of source fields to exclude from the response.
         * <p>
         * API name: {@code _source_excludes}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>sourceExcludes</code>.
         * </p>
         */
        @Nonnull
        public final Builder sourceExcludes(List<String> list) {
            this.sourceExcludes = _listAddAll(this.sourceExcludes, list);
            return this;
        }

        /**
         * A comma-separated list of source fields to exclude from the response.
         * <p>
         * API name: {@code _source_excludes}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>sourceExcludes</code>.
         * </p>
         */
        @Nonnull
        public final Builder sourceExcludes(String value, String... values) {
            this.sourceExcludes = _listAdd(this.sourceExcludes, value, values);
            return this;
        }

        /**
         * A comma-separated list of source fields to include in the response.
         * <p>
         * API name: {@code _source_includes}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>sourceIncludes</code>.
         * </p>
         */
        @Nonnull
        public final Builder sourceIncludes(List<String> list) {
            this.sourceIncludes = _listAddAll(this.sourceIncludes, list);
            return this;
        }

        /**
         * A comma-separated list of source fields to include in the response.
         * <p>
         * API name: {@code _source_includes}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>sourceIncludes</code>.
         * </p>
         */
        @Nonnull
        public final Builder sourceIncludes(String value, String... values) {
            this.sourceIncludes = _listAdd(this.sourceIncludes, value, values);
            return this;
        }

        /**
         * A comma-separated list of stored fields to return in the response.
         * <p>
         * API name: {@code stored_fields}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>storedFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder storedFields(List<String> list) {
            this.storedFields = _listAddAll(this.storedFields, list);
            return this;
        }

        /**
         * A comma-separated list of stored fields to return in the response.
         * <p>
         * API name: {@code stored_fields}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>storedFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder storedFields(String value, String... values) {
            this.storedFields = _listAdd(this.storedFields, value, values);
            return this;
        }

        /**
         * Builds a {@link ExplainRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExplainRequest build() {
            _checkSingleUse();

            return new ExplainRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ExplainRequest}
     */
    public static final JsonpDeserializer<ExplainRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ExplainRequest::setupExplainRequestDeserializer
    );

    protected static void setupExplainRequestDeserializer(ObjectDeserializer<ExplainRequest.Builder> op) {
        op.add(Builder::query, Query._DESERIALIZER, "query");
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.analyzeWildcard != null) {
            params.put("analyze_wildcard", String.valueOf(this.analyzeWildcard));
        }
        if (this.analyzer != null) {
            params.put("analyzer", this.analyzer);
        }
        if (this.defaultOperator != null) {
            params.put("default_operator", this.defaultOperator.jsonValue());
        }
        if (this.df != null) {
            params.put("df", this.df);
        }
        if (this.lenient != null) {
            params.put("lenient", String.valueOf(this.lenient));
        }
        if (this.preference != null) {
            params.put("preference", this.preference);
        }
        if (this.q != null) {
            params.put("q", this.q);
        }
        if (ApiTypeHelper.isDefined(this.routing)) {
            params.put("routing", String.join(",", this.routing));
        }
        if (this.source != null) {
            params.put("_source", this.source._toJsonString());
        }
        if (ApiTypeHelper.isDefined(this.sourceExcludes)) {
            params.put("_source_excludes", String.join(",", this.sourceExcludes));
        }
        if (ApiTypeHelper.isDefined(this.sourceIncludes)) {
            params.put("_source_includes", String.join(",", this.sourceIncludes));
        }
        if (ApiTypeHelper.isDefined(this.storedFields)) {
            params.put("stored_fields", String.join(",", this.storedFields));
        }
    }

    /**
     * Endpoint "{@code explain}".
     */
    public static final SimpleEndpoint<ExplainRequest, ?> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/");
            SimpleEndpoint.pathEncode(request.index, buf);
            buf.append("/_explain/");
            SimpleEndpoint.pathEncode(request.id, buf);
            return buf.toString();
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        ExplainResponse._DESERIALIZER
    );

    /**
     * Create an "{@code explain}" endpoint.
     */
    public static <TDocument> Endpoint<ExplainRequest, ExplainResponse<TDocument>, ErrorResponse> createExplainEndpoint(
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        return _ENDPOINT.withResponseDeserializer(ExplainResponse.createExplainResponseDeserializer(tDocumentDeserializer));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.analyzeWildcard);
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + Objects.hashCode(this.defaultOperator);
        result = 31 * result + Objects.hashCode(this.df);
        result = 31 * result + this.id.hashCode();
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Objects.hashCode(this.lenient);
        result = 31 * result + Objects.hashCode(this.preference);
        result = 31 * result + Objects.hashCode(this.q);
        result = 31 * result + Objects.hashCode(this.query);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.source);
        result = 31 * result + Objects.hashCode(this.sourceExcludes);
        result = 31 * result + Objects.hashCode(this.sourceIncludes);
        result = 31 * result + Objects.hashCode(this.storedFields);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExplainRequest other = (ExplainRequest) o;
        return Objects.equals(this.analyzeWildcard, other.analyzeWildcard)
            && Objects.equals(this.analyzer, other.analyzer)
            && Objects.equals(this.defaultOperator, other.defaultOperator)
            && Objects.equals(this.df, other.df)
            && this.id.equals(other.id)
            && this.index.equals(other.index)
            && Objects.equals(this.lenient, other.lenient)
            && Objects.equals(this.preference, other.preference)
            && Objects.equals(this.q, other.q)
            && Objects.equals(this.query, other.query)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.source, other.source)
            && Objects.equals(this.sourceExcludes, other.sourceExcludes)
            && Objects.equals(this.sourceIncludes, other.sourceIncludes)
            && Objects.equals(this.storedFields, other.storedFields);
    }
}
