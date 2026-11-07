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
import java.util.List;
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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.describe_settings.Request

/**
 * Returns definition metadata for cluster settings, including whether each setting is dynamic. Does not return setting values or defaults.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class DescribeSettingsRequest extends RequestBase
    implements
        ToCopyableBuilder<DescribeSettingsRequest.Builder, DescribeSettingsRequest> {

    @Nullable
    private final Time clusterManagerTimeout;

    @Nonnull
    private final List<String> settings;

    // ---------------------------------------------------------------------------------------------

    private DescribeSettingsRequest(Builder builder) {
        super(builder);
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.settings = ApiTypeHelper.unmodifiableRequired(builder.settings, this, "settings");
    }

    public static DescribeSettingsRequest of(Function<DescribeSettingsRequest.Builder, ObjectBuilder<DescribeSettingsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The amount of time to wait for a response from the cluster manager node. For more information about supported time units, see
     * <a href="https://docs.opensearch.org/latest/api-reference/common-parameters/#time-units">Common parameters</a>.
     * <p>
     * API name: {@code cluster_manager_timeout}
     * </p>
     */
    @Nullable
    public final Time clusterManagerTimeout() {
        return this.clusterManagerTimeout;
    }

    /**
     * Required - A comma-separated list of exact setting names to describe. Wildcards are not supported; each name must be an exact, valid
     * setting key. At least one name is required.
     * <p>
     * API name: {@code settings}
     * </p>
     */
    @Nonnull
    public final List<String> settings() {
        return this.settings;
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
     * Builder for {@link DescribeSettingsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, DescribeSettingsRequest> {
        @Nullable
        private Time clusterManagerTimeout;
        private List<String> settings;

        public Builder() {}

        private Builder(DescribeSettingsRequest o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.settings = _listCopy(o.settings);
        }

        private Builder(Builder o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.settings = _listCopy(o.settings);
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
         * <a href="https://docs.opensearch.org/latest/api-reference/common-parameters/#time-units">Common parameters</a>.
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
         * <a href="https://docs.opensearch.org/latest/api-reference/common-parameters/#time-units">Common parameters</a>.
         * <p>
         * API name: {@code cluster_manager_timeout}
         * </p>
         */
        @Nonnull
        public final Builder clusterManagerTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return clusterManagerTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - A comma-separated list of exact setting names to describe. Wildcards are not supported; each name must be an exact,
         * valid setting key. At least one name is required.
         * <p>
         * API name: {@code settings}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>settings</code>.
         * </p>
         */
        @Nonnull
        public final Builder settings(List<String> list) {
            this.settings = _listAddAll(this.settings, list);
            return this;
        }

        /**
         * Required - A comma-separated list of exact setting names to describe. Wildcards are not supported; each name must be an exact,
         * valid setting key. At least one name is required.
         * <p>
         * API name: {@code settings}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>settings</code>.
         * </p>
         */
        @Nonnull
        public final Builder settings(String value, String... values) {
            this.settings = _listAdd(this.settings, value, values);
            return this;
        }

        /**
         * Builds a {@link DescribeSettingsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DescribeSettingsRequest build() {
            _checkSingleUse();

            return new DescribeSettingsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.clusterManagerTimeout != null) {
            params.put("cluster_manager_timeout", this.clusterManagerTimeout._toJsonString());
        }
        params.put("settings", String.join(",", this.settings));
    }

    /**
     * Endpoint "{@code cluster.describe_settings}".
     */
    public static final Endpoint<DescribeSettingsRequest, DescribeSettingsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> "/_cluster/settings/_describe",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        DescribeSettingsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + this.settings.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DescribeSettingsRequest other = (DescribeSettingsRequest) o;
        return Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout) && this.settings.equals(other.settings);
    }
}
