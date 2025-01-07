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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.put_alias.Request

/**
 * Creates or updates an alias.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PutAliasRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PutAliasRequest.Builder, PutAliasRequest> {

    @Nullable
    private final String alias;

    @Nullable
    private final Time clusterManagerTimeout;

    @Nullable
    private final Query filter;

    @Nonnull
    private final List<String> index;

    @Nullable
    private final String indexRouting;

    @Nullable
    private final Boolean isHidden;

    @Nullable
    private final Boolean isWriteIndex;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nullable
    private final String name;

    @Nullable
    private final String routing;

    @Nullable
    private final String searchRouting;

    @Nullable
    private final Time timeout;

    // ---------------------------------------------------------------------------------------------

    private PutAliasRequest(Builder builder) {
        super(builder);
        this.alias = builder.alias;
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.filter = builder.filter;
        this.index = ApiTypeHelper.unmodifiable(builder.index);
        this.indexRouting = builder.indexRouting;
        this.isHidden = builder.isHidden;
        this.isWriteIndex = builder.isWriteIndex;
        this.masterTimeout = builder.masterTimeout;
        this.name = builder.name;
        this.routing = builder.routing;
        this.searchRouting = builder.searchRouting;
        this.timeout = builder.timeout;
    }

    public static PutAliasRequest of(Function<PutAliasRequest.Builder, ObjectBuilder<PutAliasRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code alias}
     */
    @Nullable
    public final String alias() {
        return this.alias;
    }

    /**
     * Operation timeout for connection to cluster-manager node.
     * <p>
     * API name: {@code cluster_manager_timeout}
     * </p>
     */
    @Nullable
    public final Time clusterManagerTimeout() {
        return this.clusterManagerTimeout;
    }

    /**
     * API name: {@code filter}
     */
    @Nullable
    public final Query filter() {
        return this.filter;
    }

    /**
     * Comma-separated list of data streams or indexes to add. Supports wildcards (<code>*</code>). Wildcard patterns that match both data
     * streams and indexes return an error.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final List<String> index() {
        return this.index;
    }

    /**
     * API name: {@code index_routing}
     */
    @Nullable
    public final String indexRouting() {
        return this.indexRouting;
    }

    /**
     * If <code>true</code>, the alias will be hidden`.
     * <p>
     * API name: {@code is_hidden}
     * </p>
     */
    @Nullable
    public final Boolean isHidden() {
        return this.isHidden;
    }

    /**
     * If <code>true</code>, sets the write index or data stream for the alias. If an alias points to multiple indexes or data streams and
     * <code>is_write_index</code> isn't set, the alias rejects write requests. If an index alias points to one index and
     * <code>is_write_index</code> isn't set, the index automatically acts as the write index. Data stream aliases don't automatically set a
     * write data stream, even if the alias points to one data stream.
     * <p>
     * API name: {@code is_write_index}
     * </p>
     */
    @Nullable
    public final Boolean isWriteIndex() {
        return this.isWriteIndex;
    }

    /**
     * Period to wait for a connection to the cluster-manager node. If no response is received before the timeout expires, the request fails
     * and returns an error.
     * <p>
     * API name: {@code master_timeout}
     * </p>
     */
    @Deprecated
    @Nullable
    public final Time masterTimeout() {
        return this.masterTimeout;
    }

    /**
     * Alias to update. If the alias doesn't exist, the request creates it. Index alias names support date math.
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code routing}
     */
    @Nullable
    public final String routing() {
        return this.routing;
    }

    /**
     * API name: {@code search_routing}
     */
    @Nullable
    public final String searchRouting() {
        return this.searchRouting;
    }

    /**
     * Period to wait for a response. If no response is received before the timeout expires, the request fails and returns an error.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final Time timeout() {
        return this.timeout;
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
        if (this.alias != null) {
            generator.writeKey("alias");
            generator.write(this.alias);
        }

        if (this.filter != null) {
            generator.writeKey("filter");
            this.filter.serialize(generator, mapper);
        }

        if (this.indexRouting != null) {
            generator.writeKey("index_routing");
            generator.write(this.indexRouting);
        }

        if (this.isHidden != null) {
            generator.writeKey("is_hidden");
            generator.write(this.isHidden);
        }

        if (this.isWriteIndex != null) {
            generator.writeKey("is_write_index");
            generator.write(this.isWriteIndex);
        }

        if (this.routing != null) {
            generator.writeKey("routing");
            generator.write(this.routing);
        }

        if (this.searchRouting != null) {
            generator.writeKey("search_routing");
            generator.write(this.searchRouting);
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
     * Builder for {@link PutAliasRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PutAliasRequest> {
        @Nullable
        private String alias;
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private Query filter;
        @Nullable
        private List<String> index;
        @Nullable
        private String indexRouting;
        @Nullable
        private Boolean isHidden;
        @Nullable
        private Boolean isWriteIndex;
        @Nullable
        private Time masterTimeout;
        @Nullable
        private String name;
        @Nullable
        private String routing;
        @Nullable
        private String searchRouting;
        @Nullable
        private Time timeout;

        public Builder() {}

        private Builder(PutAliasRequest o) {
            super(o);
            this.alias = o.alias;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.filter = o.filter;
            this.index = _listCopy(o.index);
            this.indexRouting = o.indexRouting;
            this.isHidden = o.isHidden;
            this.isWriteIndex = o.isWriteIndex;
            this.masterTimeout = o.masterTimeout;
            this.name = o.name;
            this.routing = o.routing;
            this.searchRouting = o.searchRouting;
            this.timeout = o.timeout;
        }

        private Builder(Builder o) {
            super(o);
            this.alias = o.alias;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.filter = o.filter;
            this.index = _listCopy(o.index);
            this.indexRouting = o.indexRouting;
            this.isHidden = o.isHidden;
            this.isWriteIndex = o.isWriteIndex;
            this.masterTimeout = o.masterTimeout;
            this.name = o.name;
            this.routing = o.routing;
            this.searchRouting = o.searchRouting;
            this.timeout = o.timeout;
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
         * API name: {@code alias}
         */
        @Nonnull
        public final Builder alias(@Nullable String value) {
            this.alias = value;
            return this;
        }

        /**
         * Operation timeout for connection to cluster-manager node.
         * <p>
         * API name: {@code cluster_manager_timeout}
         * </p>
         */
        @Nonnull
        public final Builder clusterManagerTimeout(@Nullable Time value) {
            this.clusterManagerTimeout = value;
            return this;
        }

        /**
         * Operation timeout for connection to cluster-manager node.
         * <p>
         * API name: {@code cluster_manager_timeout}
         * </p>
         */
        @Nonnull
        public final Builder clusterManagerTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return clusterManagerTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code filter}
         */
        @Nonnull
        public final Builder filter(@Nullable Query value) {
            this.filter = value;
            return this;
        }

        /**
         * API name: {@code filter}
         */
        @Nonnull
        public final Builder filter(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return filter(fn.apply(new Query.Builder()).build());
        }

        /**
         * Comma-separated list of data streams or indexes to add. Supports wildcards (<code>*</code>). Wildcard patterns that match both
         * data streams and indexes return an error.
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
         * Comma-separated list of data streams or indexes to add. Supports wildcards (<code>*</code>). Wildcard patterns that match both
         * data streams and indexes return an error.
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
         * API name: {@code index_routing}
         */
        @Nonnull
        public final Builder indexRouting(@Nullable String value) {
            this.indexRouting = value;
            return this;
        }

        /**
         * If <code>true</code>, the alias will be hidden`.
         * <p>
         * API name: {@code is_hidden}
         * </p>
         */
        @Nonnull
        public final Builder isHidden(@Nullable Boolean value) {
            this.isHidden = value;
            return this;
        }

        /**
         * If <code>true</code>, sets the write index or data stream for the alias. If an alias points to multiple indexes or data streams
         * and <code>is_write_index</code> isn't set, the alias rejects write requests. If an index alias points to one index and
         * <code>is_write_index</code> isn't set, the index automatically acts as the write index. Data stream aliases don't automatically
         * set a write data stream, even if the alias points to one data stream.
         * <p>
         * API name: {@code is_write_index}
         * </p>
         */
        @Nonnull
        public final Builder isWriteIndex(@Nullable Boolean value) {
            this.isWriteIndex = value;
            return this;
        }

        /**
         * Period to wait for a connection to the cluster-manager node. If no response is received before the timeout expires, the request
         * fails and returns an error.
         * <p>
         * API name: {@code master_timeout}
         * </p>
         */
        @Deprecated
        @Nonnull
        public final Builder masterTimeout(@Nullable Time value) {
            this.masterTimeout = value;
            return this;
        }

        /**
         * Period to wait for a connection to the cluster-manager node. If no response is received before the timeout expires, the request
         * fails and returns an error.
         * <p>
         * API name: {@code master_timeout}
         * </p>
         */
        @Deprecated
        @Nonnull
        public final Builder masterTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return masterTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Alias to update. If the alias doesn't exist, the request creates it. Index alias names support date math.
         * <p>
         * API name: {@code name}
         * </p>
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * API name: {@code routing}
         */
        @Nonnull
        public final Builder routing(@Nullable String value) {
            this.routing = value;
            return this;
        }

        /**
         * API name: {@code search_routing}
         */
        @Nonnull
        public final Builder searchRouting(@Nullable String value) {
            this.searchRouting = value;
            return this;
        }

        /**
         * Period to wait for a response. If no response is received before the timeout expires, the request fails and returns an error.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(@Nullable Time value) {
            this.timeout = value;
            return this;
        }

        /**
         * Period to wait for a response. If no response is received before the timeout expires, the request fails and returns an error.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link PutAliasRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutAliasRequest build() {
            _checkSingleUse();

            return new PutAliasRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutAliasRequest}
     */
    public static final JsonpDeserializer<PutAliasRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutAliasRequest::setupPutAliasRequestDeserializer
    );

    protected static void setupPutAliasRequestDeserializer(ObjectDeserializer<PutAliasRequest.Builder> op) {
        op.add(Builder::alias, JsonpDeserializer.stringDeserializer(), "alias");
        op.add(Builder::filter, Query._DESERIALIZER, "filter");
        op.add(Builder::indexRouting, JsonpDeserializer.stringDeserializer(), "index_routing");
        op.add(Builder::isHidden, JsonpDeserializer.booleanDeserializer(), "is_hidden");
        op.add(Builder::isWriteIndex, JsonpDeserializer.booleanDeserializer(), "is_write_index");
        op.add(Builder::routing, JsonpDeserializer.stringDeserializer(), "routing");
        op.add(Builder::searchRouting, JsonpDeserializer.stringDeserializer(), "search_routing");
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.clusterManagerTimeout != null) {
            params.put("cluster_manager_timeout", this.clusterManagerTimeout._toJsonString());
        }
        if (this.masterTimeout != null) {
            params.put("master_timeout", this.masterTimeout._toJsonString());
        }
        if (this.timeout != null) {
            params.put("timeout", this.timeout._toJsonString());
        }
    }

    /**
     * Endpoint "{@code indices.put_alias}".
     */
    public static final Endpoint<PutAliasRequest, PutAliasResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> {
            final int _index = 1 << 0;
            final int _name = 1 << 1;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.index())) propsSet |= _index;
            if (request.name() != null) propsSet |= _name;

            if (propsSet == 0) {
                return "/_alias";
            }
            if (propsSet == (_index)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/");
                SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
                buf.append("/_alias");
                return buf.toString();
            }
            if (propsSet == (_index | _name)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/");
                SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
                buf.append("/_alias/");
                SimpleEndpoint.pathEncode(request.name, buf);
                return buf.toString();
            }
            if (propsSet == (_name)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_alias/");
                SimpleEndpoint.pathEncode(request.name, buf);
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
        PutAliasResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.alias);
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.filter);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.indexRouting);
        result = 31 * result + Objects.hashCode(this.isHidden);
        result = 31 * result + Objects.hashCode(this.isWriteIndex);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.searchRouting);
        result = 31 * result + Objects.hashCode(this.timeout);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PutAliasRequest other = (PutAliasRequest) o;
        return Objects.equals(this.alias, other.alias)
            && Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.filter, other.filter)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.indexRouting, other.indexRouting)
            && Objects.equals(this.isHidden, other.isHidden)
            && Objects.equals(this.isWriteIndex, other.isWriteIndex)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.searchRouting, other.searchRouting)
            && Objects.equals(this.timeout, other.timeout);
    }
}
