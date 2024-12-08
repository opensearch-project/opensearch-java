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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.ExpandWildcard;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.get_settings.Request

/**
 * Returns settings for one or more indexes.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetIndicesSettingsRequest extends RequestBase
    implements
        ToCopyableBuilder<GetIndicesSettingsRequest.Builder, GetIndicesSettingsRequest> {

    @Nullable
    private final Boolean allowNoIndices;

    @Nullable
    private final Time clusterManagerTimeout;

    @Nonnull
    private final List<ExpandWildcard> expandWildcards;

    @Nullable
    private final Boolean flatSettings;

    @Nullable
    private final Boolean ignoreUnavailable;

    @Nullable
    private final Boolean includeDefaults;

    @Nonnull
    private final List<String> index;

    @Nullable
    private final Boolean local;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nonnull
    private final List<String> name;

    // ---------------------------------------------------------------------------------------------

    private GetIndicesSettingsRequest(Builder builder) {
        this.allowNoIndices = builder.allowNoIndices;
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.flatSettings = builder.flatSettings;
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.includeDefaults = builder.includeDefaults;
        this.index = ApiTypeHelper.unmodifiable(builder.index);
        this.local = builder.local;
        this.masterTimeout = builder.masterTimeout;
        this.name = ApiTypeHelper.unmodifiable(builder.name);
    }

    public static GetIndicesSettingsRequest of(Function<GetIndicesSettingsRequest.Builder, ObjectBuilder<GetIndicesSettingsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * If <code>false</code>, the request returns an error if any wildcard expression, index alias, or <code>_all</code> value targets only
     * missing or closed indexes. This behavior applies even if the request targets other open indexes. For example, a request targeting
     * <code>foo*,bar*</code> returns an error if an index starts with foo but no index starts with <code>bar</code>.
     * <p>
     * API name: {@code allow_no_indices}
     * </p>
     */
    @Nullable
    public final Boolean allowNoIndices() {
        return this.allowNoIndices;
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
     * Type of index that wildcard patterns can match. If the request can target data streams, this argument determines whether wildcard
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
     * If <code>true</code>, returns settings in flat format.
     * <p>
     * API name: {@code flat_settings}
     * </p>
     */
    @Nullable
    public final Boolean flatSettings() {
        return this.flatSettings;
    }

    /**
     * If <code>false</code>, the request returns an error if it targets a missing or closed index.
     * <p>
     * API name: {@code ignore_unavailable}
     * </p>
     */
    @Nullable
    public final Boolean ignoreUnavailable() {
        return this.ignoreUnavailable;
    }

    /**
     * If <code>true</code>, return all default settings in the response.
     * <p>
     * API name: {@code include_defaults}
     * </p>
     */
    @Nullable
    public final Boolean includeDefaults() {
        return this.includeDefaults;
    }

    /**
     * Comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards (<code>*</code>). To target
     * all data streams and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final List<String> index() {
        return this.index;
    }

    /**
     * If <code>true</code>, the request retrieves information from the local node only. If <code>false</code>, information is retrieved
     * from the cluster-manager node.
     * <p>
     * API name: {@code local}
     * </p>
     */
    @Nullable
    public final Boolean local() {
        return this.local;
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
     * Comma-separated list or wildcard expression of settings to retrieve.
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nonnull
    public final List<String> name() {
        return this.name;
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
     * Builder for {@link GetIndicesSettingsRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetIndicesSettingsRequest> {
        @Nullable
        private Boolean allowNoIndices;
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private List<ExpandWildcard> expandWildcards;
        @Nullable
        private Boolean flatSettings;
        @Nullable
        private Boolean ignoreUnavailable;
        @Nullable
        private Boolean includeDefaults;
        @Nullable
        private List<String> index;
        @Nullable
        private Boolean local;
        @Nullable
        private Time masterTimeout;
        @Nullable
        private List<String> name;

        public Builder() {}

        private Builder(GetIndicesSettingsRequest o) {
            this.allowNoIndices = o.allowNoIndices;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.flatSettings = o.flatSettings;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.includeDefaults = o.includeDefaults;
            this.index = _listCopy(o.index);
            this.local = o.local;
            this.masterTimeout = o.masterTimeout;
            this.name = _listCopy(o.name);
        }

        private Builder(Builder o) {
            this.allowNoIndices = o.allowNoIndices;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.flatSettings = o.flatSettings;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.includeDefaults = o.includeDefaults;
            this.index = _listCopy(o.index);
            this.local = o.local;
            this.masterTimeout = o.masterTimeout;
            this.name = _listCopy(o.name);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * If <code>false</code>, the request returns an error if any wildcard expression, index alias, or <code>_all</code> value targets
         * only missing or closed indexes. This behavior applies even if the request targets other open indexes. For example, a request
         * targeting <code>foo*,bar*</code> returns an error if an index starts with foo but no index starts with <code>bar</code>.
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
         * Type of index that wildcard patterns can match. If the request can target data streams, this argument determines whether wildcard
         * expressions match hidden data streams. Supports comma-separated values, such as <code>open,hidden</code>.
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
         * Type of index that wildcard patterns can match. If the request can target data streams, this argument determines whether wildcard
         * expressions match hidden data streams. Supports comma-separated values, such as <code>open,hidden</code>.
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
         * If <code>true</code>, returns settings in flat format.
         * <p>
         * API name: {@code flat_settings}
         * </p>
         */
        @Nonnull
        public final Builder flatSettings(@Nullable Boolean value) {
            this.flatSettings = value;
            return this;
        }

        /**
         * If <code>false</code>, the request returns an error if it targets a missing or closed index.
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
         * If <code>true</code>, return all default settings in the response.
         * <p>
         * API name: {@code include_defaults}
         * </p>
         */
        @Nonnull
        public final Builder includeDefaults(@Nullable Boolean value) {
            this.includeDefaults = value;
            return this;
        }

        /**
         * Comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards (<code>*</code>). To
         * target all data streams and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
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
         * Comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards (<code>*</code>). To
         * target all data streams and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
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
         * If <code>true</code>, the request retrieves information from the local node only. If <code>false</code>, information is retrieved
         * from the cluster-manager node.
         * <p>
         * API name: {@code local}
         * </p>
         */
        @Nonnull
        public final Builder local(@Nullable Boolean value) {
            this.local = value;
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
         * Comma-separated list or wildcard expression of settings to retrieve.
         * <p>
         * API name: {@code name}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>name</code>.
         * </p>
         */
        @Nonnull
        public final Builder name(List<String> list) {
            this.name = _listAddAll(this.name, list);
            return this;
        }

        /**
         * Comma-separated list or wildcard expression of settings to retrieve.
         * <p>
         * API name: {@code name}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>name</code>.
         * </p>
         */
        @Nonnull
        public final Builder name(String value, String... values) {
            this.name = _listAdd(this.name, value, values);
            return this;
        }

        /**
         * Builds a {@link GetIndicesSettingsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetIndicesSettingsRequest build() {
            _checkSingleUse();

            return new GetIndicesSettingsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code indices.get_settings}".
     */
    public static final Endpoint<GetIndicesSettingsRequest, GetIndicesSettingsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _index = 1 << 0;
            final int _name = 1 << 1;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.index())) propsSet |= _index;
            if (ApiTypeHelper.isDefined(request.name())) propsSet |= _name;

            if (propsSet == 0) {
                return "/_settings";
            }
            if (propsSet == (_index)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/");
                SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
                buf.append("/_settings");
                return buf.toString();
            }
            if (propsSet == (_index | _name)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/");
                SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
                buf.append("/_settings/");
                SimpleEndpoint.pathEncode(String.join(",", request.name), buf);
                return buf.toString();
            }
            if (propsSet == (_name)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_settings/");
                SimpleEndpoint.pathEncode(String.join(",", request.name), buf);
                return buf.toString();
            }

            throw SimpleEndpoint.noPathTemplateFound("path");
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            if (request.allowNoIndices != null) {
                params.put("allow_no_indices", String.valueOf(request.allowNoIndices));
            }
            if (request.clusterManagerTimeout != null) {
                params.put("cluster_manager_timeout", request.clusterManagerTimeout._toJsonString());
            }
            if (ApiTypeHelper.isDefined(request.expandWildcards)) {
                params.put("expand_wildcards", request.expandWildcards.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")));
            }
            if (request.flatSettings != null) {
                params.put("flat_settings", String.valueOf(request.flatSettings));
            }
            if (request.ignoreUnavailable != null) {
                params.put("ignore_unavailable", String.valueOf(request.ignoreUnavailable));
            }
            if (request.includeDefaults != null) {
                params.put("include_defaults", String.valueOf(request.includeDefaults));
            }
            if (request.local != null) {
                params.put("local", String.valueOf(request.local));
            }
            if (request.masterTimeout != null) {
                params.put("master_timeout", request.masterTimeout._toJsonString());
            }
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        GetIndicesSettingsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allowNoIndices);
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.expandWildcards);
        result = 31 * result + Objects.hashCode(this.flatSettings);
        result = 31 * result + Objects.hashCode(this.ignoreUnavailable);
        result = 31 * result + Objects.hashCode(this.includeDefaults);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.local);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + Objects.hashCode(this.name);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetIndicesSettingsRequest other = (GetIndicesSettingsRequest) o;
        return Objects.equals(this.allowNoIndices, other.allowNoIndices)
            && Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.expandWildcards, other.expandWildcards)
            && Objects.equals(this.flatSettings, other.flatSettings)
            && Objects.equals(this.ignoreUnavailable, other.ignoreUnavailable)
            && Objects.equals(this.includeDefaults, other.includeDefaults)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.local, other.local)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.name, other.name);
    }
}
