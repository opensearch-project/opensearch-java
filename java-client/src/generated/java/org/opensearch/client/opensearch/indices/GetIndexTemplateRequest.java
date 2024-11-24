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
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.get_index_template.Request

/**
 * Returns an index template.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetIndexTemplateRequest extends RequestBase
    implements
        ToCopyableBuilder<GetIndexTemplateRequest.Builder, GetIndexTemplateRequest> {

    @Nullable
    private final Time clusterManagerTimeout;

    @Nullable
    private final Boolean flatSettings;

    @Nullable
    private final Boolean local;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nullable
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private GetIndexTemplateRequest(Builder builder) {
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.flatSettings = builder.flatSettings;
        this.local = builder.local;
        this.masterTimeout = builder.masterTimeout;
        this.name = builder.name;
    }

    public static GetIndexTemplateRequest of(Function<GetIndexTemplateRequest.Builder, ObjectBuilder<GetIndexTemplateRequest>> fn) {
        return fn.apply(new Builder()).build();
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
     * If <code>true</code>, the request retrieves information from the local node only. Defaults to false, which means information is
     * retrieved from the cluster-manager node.
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
     * Name of the index template to retrieve. Wildcard (*) expressions are supported.
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nullable
    public final String name() {
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
     * Builder for {@link GetIndexTemplateRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetIndexTemplateRequest> {
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private Boolean flatSettings;
        @Nullable
        private Boolean local;
        @Nullable
        private Time masterTimeout;
        @Nullable
        private String name;

        public Builder() {}

        private Builder(GetIndexTemplateRequest o) {
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.flatSettings = o.flatSettings;
            this.local = o.local;
            this.masterTimeout = o.masterTimeout;
            this.name = o.name;
        }

        private Builder(Builder o) {
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.flatSettings = o.flatSettings;
            this.local = o.local;
            this.masterTimeout = o.masterTimeout;
            this.name = o.name;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
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
         * If <code>true</code>, the request retrieves information from the local node only. Defaults to false, which means information is
         * retrieved from the cluster-manager node.
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
         * Name of the index template to retrieve. Wildcard (*) expressions are supported.
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
         * Builds a {@link GetIndexTemplateRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetIndexTemplateRequest build() {
            _checkSingleUse();

            return new GetIndexTemplateRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code indices.get_index_template}".
     */
    public static final Endpoint<GetIndexTemplateRequest, GetIndexTemplateResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _name = 1 << 0;

            int propsSet = 0;

            if (request.name() != null) propsSet |= _name;

            if (propsSet == 0) {
                return "/_index_template";
            }
            if (propsSet == (_name)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_index_template/");
                SimpleEndpoint.pathEncode(request.name, buf);
                return buf.toString();
            }

            throw SimpleEndpoint.noPathTemplateFound("path");
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            if (request.clusterManagerTimeout != null) {
                params.put("cluster_manager_timeout", request.clusterManagerTimeout._toJsonString());
            }
            if (request.flatSettings != null) {
                params.put("flat_settings", String.valueOf(request.flatSettings));
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
        GetIndexTemplateResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.flatSettings);
        result = 31 * result + Objects.hashCode(this.local);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + Objects.hashCode(this.name);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetIndexTemplateRequest other = (GetIndexTemplateRequest) o;
        return Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.flatSettings, other.flatSettings)
            && Objects.equals(this.local, other.local)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.name, other.name);
    }
}
