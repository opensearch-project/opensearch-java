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

package org.opensearch.client.opensearch.cluster;

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
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.get_component_template.Request

/**
 * Returns one or more component templates.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetComponentTemplateRequest extends RequestBase
    implements
        ToCopyableBuilder<GetComponentTemplateRequest.Builder, GetComponentTemplateRequest> {

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

    private GetComponentTemplateRequest(Builder builder) {
        super(builder);
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.flatSettings = builder.flatSettings;
        this.local = builder.local;
        this.masterTimeout = builder.masterTimeout;
        this.name = builder.name;
    }

    public static GetComponentTemplateRequest of(
        Function<GetComponentTemplateRequest.Builder, ObjectBuilder<GetComponentTemplateRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The amount of time to wait for a response from the cluster manager node. For more information about supported time units, see
     * <a href="https://opensearch.org/docs/latest/api-reference/common-parameters/#time-units">Common parameters</a>.
     * <p>
     * API name: {@code cluster_manager_timeout}
     * </p>
     */
    @Nullable
    public final Time clusterManagerTimeout() {
        return this.clusterManagerTimeout;
    }

    /**
     * Whether to return settings in the flat form, which can improve readability, especially for heavily nested settings. For example, the
     * flat form of <code>&quot;cluster&quot;: { &quot;max_shards_per_node&quot;: 500 }</code> is
     * <code>&quot;cluster.max_shards_per_node&quot;: &quot;500&quot;</code>.
     * <p>
     * API name: {@code flat_settings}
     * </p>
     */
    @Nullable
    public final Boolean flatSettings() {
        return this.flatSettings;
    }

    /**
     * When <code>true</code>, the request retrieves information from the local node only. When <code>false</code>, information is retrieved
     * from the cluster manager node.
     * <p>
     * API name: {@code local}
     * </p>
     */
    @Nullable
    public final Boolean local() {
        return this.local;
    }

    /**
     * A duration. Units can be <code>nanos</code>, <code>micros</code>, <code>ms</code> (milliseconds), <code>s</code> (seconds),
     * <code>m</code> (minutes), <code>h</code> (hours) and <code>d</code> (days). Also accepts &quot;0&quot; without a unit and
     * &quot;-1&quot; to indicate an unspecified value.
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
     * The name of the component template to retrieve. Wildcard (<code>*</code>) expressions are supported.
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
     * Builder for {@link GetComponentTemplateRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, GetComponentTemplateRequest> {
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

        private Builder(GetComponentTemplateRequest o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.flatSettings = o.flatSettings;
            this.local = o.local;
            this.masterTimeout = o.masterTimeout;
            this.name = o.name;
        }

        private Builder(Builder o) {
            super(o);
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

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * The amount of time to wait for a response from the cluster manager node. For more information about supported time units, see
         * <a href="https://opensearch.org/docs/latest/api-reference/common-parameters/#time-units">Common parameters</a>.
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
         * The amount of time to wait for a response from the cluster manager node. For more information about supported time units, see
         * <a href="https://opensearch.org/docs/latest/api-reference/common-parameters/#time-units">Common parameters</a>.
         * <p>
         * API name: {@code cluster_manager_timeout}
         * </p>
         */
        @Nonnull
        public final Builder clusterManagerTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return clusterManagerTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Whether to return settings in the flat form, which can improve readability, especially for heavily nested settings. For example,
         * the flat form of <code>&quot;cluster&quot;: { &quot;max_shards_per_node&quot;: 500 }</code> is
         * <code>&quot;cluster.max_shards_per_node&quot;: &quot;500&quot;</code>.
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
         * When <code>true</code>, the request retrieves information from the local node only. When <code>false</code>, information is
         * retrieved from the cluster manager node.
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
         * A duration. Units can be <code>nanos</code>, <code>micros</code>, <code>ms</code> (milliseconds), <code>s</code> (seconds),
         * <code>m</code> (minutes), <code>h</code> (hours) and <code>d</code> (days). Also accepts &quot;0&quot; without a unit and
         * &quot;-1&quot; to indicate an unspecified value.
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
         * A duration. Units can be <code>nanos</code>, <code>micros</code>, <code>ms</code> (milliseconds), <code>s</code> (seconds),
         * <code>m</code> (minutes), <code>h</code> (hours) and <code>d</code> (days). Also accepts &quot;0&quot; without a unit and
         * &quot;-1&quot; to indicate an unspecified value.
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
         * The name of the component template to retrieve. Wildcard (<code>*</code>) expressions are supported.
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
         * Builds a {@link GetComponentTemplateRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetComponentTemplateRequest build() {
            _checkSingleUse();

            return new GetComponentTemplateRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.clusterManagerTimeout != null) {
            params.put("cluster_manager_timeout", this.clusterManagerTimeout._toJsonString());
        }
        if (this.flatSettings != null) {
            params.put("flat_settings", String.valueOf(this.flatSettings));
        }
        if (this.local != null) {
            params.put("local", String.valueOf(this.local));
        }
        if (this.masterTimeout != null) {
            params.put("master_timeout", this.masterTimeout._toJsonString());
        }
    }

    /**
     * Endpoint "{@code cluster.get_component_template}".
     */
    public static final Endpoint<GetComponentTemplateRequest, GetComponentTemplateResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _name = 1 << 0;

            int propsSet = 0;

            if (request.name() != null) propsSet |= _name;

            if (propsSet == 0) {
                return "/_component_template";
            }
            if (propsSet == (_name)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_component_template/");
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
        false,
        GetComponentTemplateResponse._DESERIALIZER
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
        GetComponentTemplateRequest other = (GetComponentTemplateRequest) o;
        return Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.flatSettings, other.flatSettings)
            && Objects.equals(this.local, other.local)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.name, other.name);
    }
}
