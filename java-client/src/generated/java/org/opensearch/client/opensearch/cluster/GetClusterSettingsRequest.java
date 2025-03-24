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

// typedef: cluster.get_settings.Request

/**
 * Returns cluster settings.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetClusterSettingsRequest extends RequestBase
    implements
        ToCopyableBuilder<GetClusterSettingsRequest.Builder, GetClusterSettingsRequest> {

    @Nullable
    private final Time clusterManagerTimeout;

    @Nullable
    private final Boolean flatSettings;

    @Nullable
    private final Boolean includeDefaults;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nullable
    private final Time timeout;

    // ---------------------------------------------------------------------------------------------

    private GetClusterSettingsRequest(Builder builder) {
        super(builder);
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.flatSettings = builder.flatSettings;
        this.includeDefaults = builder.includeDefaults;
        this.masterTimeout = builder.masterTimeout;
        this.timeout = builder.timeout;
    }

    public static GetClusterSettingsRequest of(Function<GetClusterSettingsRequest.Builder, ObjectBuilder<GetClusterSettingsRequest>> fn) {
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
     * When <code>true</code>, returns default cluster settings from the local node.
     * <p>
     * API name: {@code include_defaults}
     * </p>
     */
    @Nullable
    public final Boolean includeDefaults() {
        return this.includeDefaults;
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
     * A duration. Units can be <code>nanos</code>, <code>micros</code>, <code>ms</code> (milliseconds), <code>s</code> (seconds),
     * <code>m</code> (minutes), <code>h</code> (hours) and <code>d</code> (days). Also accepts &quot;0&quot; without a unit and
     * &quot;-1&quot; to indicate an unspecified value.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final Time timeout() {
        return this.timeout;
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
     * Builder for {@link GetClusterSettingsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, GetClusterSettingsRequest> {
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private Boolean flatSettings;
        @Nullable
        private Boolean includeDefaults;
        @Nullable
        private Time masterTimeout;
        @Nullable
        private Time timeout;

        public Builder() {}

        private Builder(GetClusterSettingsRequest o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.flatSettings = o.flatSettings;
            this.includeDefaults = o.includeDefaults;
            this.masterTimeout = o.masterTimeout;
            this.timeout = o.timeout;
        }

        private Builder(Builder o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.flatSettings = o.flatSettings;
            this.includeDefaults = o.includeDefaults;
            this.masterTimeout = o.masterTimeout;
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
         * When <code>true</code>, returns default cluster settings from the local node.
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
         * A duration. Units can be <code>nanos</code>, <code>micros</code>, <code>ms</code> (milliseconds), <code>s</code> (seconds),
         * <code>m</code> (minutes), <code>h</code> (hours) and <code>d</code> (days). Also accepts &quot;0&quot; without a unit and
         * &quot;-1&quot; to indicate an unspecified value.
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
         * A duration. Units can be <code>nanos</code>, <code>micros</code>, <code>ms</code> (milliseconds), <code>s</code> (seconds),
         * <code>m</code> (minutes), <code>h</code> (hours) and <code>d</code> (days). Also accepts &quot;0&quot; without a unit and
         * &quot;-1&quot; to indicate an unspecified value.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link GetClusterSettingsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetClusterSettingsRequest build() {
            _checkSingleUse();

            return new GetClusterSettingsRequest(this);
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
        if (this.includeDefaults != null) {
            params.put("include_defaults", String.valueOf(this.includeDefaults));
        }
        if (this.masterTimeout != null) {
            params.put("master_timeout", this.masterTimeout._toJsonString());
        }
        if (this.timeout != null) {
            params.put("timeout", this.timeout._toJsonString());
        }
    }

    /**
     * Endpoint "{@code cluster.get_settings}".
     */
    public static final Endpoint<GetClusterSettingsRequest, GetClusterSettingsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> "/_cluster/settings",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        GetClusterSettingsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.flatSettings);
        result = 31 * result + Objects.hashCode(this.includeDefaults);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + Objects.hashCode(this.timeout);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetClusterSettingsRequest other = (GetClusterSettingsRequest) o;
        return Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.flatSettings, other.flatSettings)
            && Objects.equals(this.includeDefaults, other.includeDefaults)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.timeout, other.timeout);
    }
}
