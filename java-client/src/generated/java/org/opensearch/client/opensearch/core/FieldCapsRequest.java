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
import java.util.stream.Collectors;
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
import org.opensearch.client.opensearch._types.ExpandWildcard;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.field_caps.Request

/**
 * Returns the information about the capabilities of fields among multiple indexes.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class FieldCapsRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<FieldCapsRequest.Builder, FieldCapsRequest> {

    @Nullable
    private final Boolean allowNoIndices;

    @Nonnull
    private final List<ExpandWildcard> expandWildcards;

    @Nonnull
    private final List<String> fields;

    @Nullable
    private final Boolean ignoreUnavailable;

    @Nullable
    private final Boolean includeUnmapped;

    @Nonnull
    private final List<String> index;

    @Nullable
    private final Query indexFilter;

    // ---------------------------------------------------------------------------------------------

    private FieldCapsRequest(Builder builder) {
        super(builder);
        this.allowNoIndices = builder.allowNoIndices;
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.includeUnmapped = builder.includeUnmapped;
        this.index = ApiTypeHelper.unmodifiable(builder.index);
        this.indexFilter = builder.indexFilter;
    }

    public static FieldCapsRequest of(Function<FieldCapsRequest.Builder, ObjectBuilder<FieldCapsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * If <code>false</code>, the request returns an error if any wildcard expression, index alias, or <code>_all</code> value targets only
     * missing or closed indexes. This behavior applies even if the request targets other open indexes. For example, a request targeting
     * <code>foo*,bar*</code> returns an error if an index starts with foo but no index starts with bar.
     * <p>
     * API name: {@code allow_no_indices}
     * </p>
     */
    @Nullable
    public final Boolean allowNoIndices() {
        return this.allowNoIndices;
    }

    /**
     * The type of index that wildcard patterns can match. If the request can target data streams, this argument determines whether wildcard
     * expressions match hidden data streams. Supports comma-separated values, such as <code>open,hidden</code>.
     * <p>
     * API name: {@code expand_wildcards}
     * </p>
     */
    @Nonnull
    public final List<ExpandWildcard> expandWildcards() {
        return this.expandWildcards;
    }

    /**
     * API name: {@code fields}
     */
    @Nonnull
    public final List<String> fields() {
        return this.fields;
    }

    /**
     * If <code>true</code>, missing or closed indexes are not included in the response.
     * <p>
     * API name: {@code ignore_unavailable}
     * </p>
     */
    @Nullable
    public final Boolean ignoreUnavailable() {
        return this.ignoreUnavailable;
    }

    /**
     * If <code>true</code>, unmapped fields are included in the response.
     * <p>
     * API name: {@code include_unmapped}
     * </p>
     */
    @Nullable
    public final Boolean includeUnmapped() {
        return this.includeUnmapped;
    }

    /**
     * A comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards (*). To target all data
     * streams and indexes, omit this parameter or use * or <code>_all</code>.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final List<String> index() {
        return this.index;
    }

    /**
     * API name: {@code index_filter}
     */
    @Nullable
    public final Query indexFilter() {
        return this.indexFilter;
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
        if (ApiTypeHelper.isDefined(this.fields)) {
            generator.writeKey("fields");
            generator.writeStartArray();
            for (String item0 : this.fields) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.indexFilter != null) {
            generator.writeKey("index_filter");
            this.indexFilter.serialize(generator, mapper);
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
     * Builder for {@link FieldCapsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, FieldCapsRequest> {
        @Nullable
        private Boolean allowNoIndices;
        @Nullable
        private List<ExpandWildcard> expandWildcards;
        @Nullable
        private List<String> fields;
        @Nullable
        private Boolean ignoreUnavailable;
        @Nullable
        private Boolean includeUnmapped;
        @Nullable
        private List<String> index;
        @Nullable
        private Query indexFilter;

        public Builder() {}

        private Builder(FieldCapsRequest o) {
            super(o);
            this.allowNoIndices = o.allowNoIndices;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.fields = _listCopy(o.fields);
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.includeUnmapped = o.includeUnmapped;
            this.index = _listCopy(o.index);
            this.indexFilter = o.indexFilter;
        }

        private Builder(Builder o) {
            super(o);
            this.allowNoIndices = o.allowNoIndices;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.fields = _listCopy(o.fields);
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.includeUnmapped = o.includeUnmapped;
            this.index = _listCopy(o.index);
            this.indexFilter = o.indexFilter;
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
         * If <code>false</code>, the request returns an error if any wildcard expression, index alias, or <code>_all</code> value targets
         * only missing or closed indexes. This behavior applies even if the request targets other open indexes. For example, a request
         * targeting <code>foo*,bar*</code> returns an error if an index starts with foo but no index starts with bar.
         * <p>
         * API name: {@code allow_no_indices}
         * </p>
         */
        @Nonnull
        public final Builder allowNoIndices(@Nullable Boolean value) {
            this.allowNoIndices = value;
            return this;
        }

        /**
         * The type of index that wildcard patterns can match. If the request can target data streams, this argument determines whether
         * wildcard expressions match hidden data streams. Supports comma-separated values, such as <code>open,hidden</code>.
         * <p>
         * API name: {@code expand_wildcards}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>expandWildcards</code>.
         * </p>
         */
        @Nonnull
        public final Builder expandWildcards(List<ExpandWildcard> list) {
            this.expandWildcards = _listAddAll(this.expandWildcards, list);
            return this;
        }

        /**
         * The type of index that wildcard patterns can match. If the request can target data streams, this argument determines whether
         * wildcard expressions match hidden data streams. Supports comma-separated values, such as <code>open,hidden</code>.
         * <p>
         * API name: {@code expand_wildcards}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>expandWildcards</code>.
         * </p>
         */
        @Nonnull
        public final Builder expandWildcards(ExpandWildcard value, ExpandWildcard... values) {
            this.expandWildcards = _listAdd(this.expandWildcards, value, values);
            return this;
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(List<String> list) {
            this.fields = _listAddAll(this.fields, list);
            return this;
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds one or more values to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(String value, String... values) {
            this.fields = _listAdd(this.fields, value, values);
            return this;
        }

        /**
         * If <code>true</code>, missing or closed indexes are not included in the response.
         * <p>
         * API name: {@code ignore_unavailable}
         * </p>
         */
        @Nonnull
        public final Builder ignoreUnavailable(@Nullable Boolean value) {
            this.ignoreUnavailable = value;
            return this;
        }

        /**
         * If <code>true</code>, unmapped fields are included in the response.
         * <p>
         * API name: {@code include_unmapped}
         * </p>
         */
        @Nonnull
        public final Builder includeUnmapped(@Nullable Boolean value) {
            this.includeUnmapped = value;
            return this;
        }

        /**
         * A comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards (*). To target all
         * data streams and indexes, omit this parameter or use * or <code>_all</code>.
         * <p>
         * API name: {@code index}
         * </p>
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
         * A comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards (*). To target all
         * data streams and indexes, omit this parameter or use * or <code>_all</code>.
         * <p>
         * API name: {@code index}
         * </p>
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
         * API name: {@code index_filter}
         */
        @Nonnull
        public final Builder indexFilter(@Nullable Query value) {
            this.indexFilter = value;
            return this;
        }

        /**
         * API name: {@code index_filter}
         */
        @Nonnull
        public final Builder indexFilter(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return indexFilter(fn.apply(new Query.Builder()).build());
        }

        /**
         * Builds a {@link FieldCapsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FieldCapsRequest build() {
            _checkSingleUse();

            return new FieldCapsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FieldCapsRequest}
     */
    public static final JsonpDeserializer<FieldCapsRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FieldCapsRequest::setupFieldCapsRequestDeserializer
    );

    protected static void setupFieldCapsRequestDeserializer(ObjectDeserializer<FieldCapsRequest.Builder> op) {
        op.add(Builder::fields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "fields");
        op.add(Builder::indexFilter, Query._DESERIALIZER, "index_filter");
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.allowNoIndices != null) {
            params.put("allow_no_indices", String.valueOf(this.allowNoIndices));
        }
        if (ApiTypeHelper.isDefined(this.expandWildcards)) {
            params.put("expand_wildcards", this.expandWildcards.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")));
        }
        if (this.ignoreUnavailable != null) {
            params.put("ignore_unavailable", String.valueOf(this.ignoreUnavailable));
        }
        if (this.includeUnmapped != null) {
            params.put("include_unmapped", String.valueOf(this.includeUnmapped));
        }
    }

    /**
     * Endpoint "{@code field_caps}".
     */
    public static final Endpoint<FieldCapsRequest, FieldCapsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _index = 1 << 0;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.index())) propsSet |= _index;

            if (propsSet == 0) {
                return "/_field_caps";
            }
            if (propsSet == (_index)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/");
                SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
                buf.append("/_field_caps");
                return buf.toString();
            }

            throw SimpleEndpoint.noPathTemplateFound("path");
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        FieldCapsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allowNoIndices);
        result = 31 * result + Objects.hashCode(this.expandWildcards);
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Objects.hashCode(this.ignoreUnavailable);
        result = 31 * result + Objects.hashCode(this.includeUnmapped);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.indexFilter);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FieldCapsRequest other = (FieldCapsRequest) o;
        return Objects.equals(this.allowNoIndices, other.allowNoIndices)
            && Objects.equals(this.expandWildcards, other.expandWildcards)
            && Objects.equals(this.fields, other.fields)
            && Objects.equals(this.ignoreUnavailable, other.ignoreUnavailable)
            && Objects.equals(this.includeUnmapped, other.includeUnmapped)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.indexFilter, other.indexFilter);
    }
}
