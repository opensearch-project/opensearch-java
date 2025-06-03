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
import org.opensearch.client.transport.endpoints.BooleanEndpoint;
import org.opensearch.client.transport.endpoints.BooleanResponse;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.exists_component_template.Request

/**
 * Returns information about whether a particular component template exist.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class ExistsComponentTemplateRequest extends RequestBase
    implements
        ToCopyableBuilder<ExistsComponentTemplateRequest.Builder, ExistsComponentTemplateRequest> {

    @Nullable
    private final Time clusterManagerTimeout;

    @Nullable
    private final Boolean local;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nonnull
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private ExistsComponentTemplateRequest(Builder builder) {
        super(builder);
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.local = builder.local;
        this.masterTimeout = builder.masterTimeout;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
    }

    public static ExistsComponentTemplateRequest of(
        Function<ExistsComponentTemplateRequest.Builder, ObjectBuilder<ExistsComponentTemplateRequest>> fn
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
     * <code>m</code> (minutes), <code>h</code> (hours) and <code>d</code> (days). Also accepts <code>0</code> without a unit and
     * <code>-1</code> to indicate an unspecified value.
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
     * Required - The name of the component template. Wildcard (*) expressions are supported.
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nonnull
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
     * Builder for {@link ExistsComponentTemplateRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, ExistsComponentTemplateRequest> {
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private Boolean local;
        @Nullable
        private Time masterTimeout;
        private String name;

        public Builder() {}

        private Builder(ExistsComponentTemplateRequest o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.local = o.local;
            this.masterTimeout = o.masterTimeout;
            this.name = o.name;
        }

        private Builder(Builder o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
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
         * <code>m</code> (minutes), <code>h</code> (hours) and <code>d</code> (days). Also accepts <code>0</code> without a unit and
         * <code>-1</code> to indicate an unspecified value.
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
         * <code>m</code> (minutes), <code>h</code> (hours) and <code>d</code> (days). Also accepts <code>0</code> without a unit and
         * <code>-1</code> to indicate an unspecified value.
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
         * Required - The name of the component template. Wildcard (*) expressions are supported.
         * <p>
         * API name: {@code name}
         * </p>
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Builds a {@link ExistsComponentTemplateRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExistsComponentTemplateRequest build() {
            _checkSingleUse();

            return new ExistsComponentTemplateRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.clusterManagerTimeout != null) {
            params.put("cluster_manager_timeout", this.clusterManagerTimeout._toJsonString());
        }
        if (this.local != null) {
            params.put("local", String.valueOf(this.local));
        }
        if (this.masterTimeout != null) {
            params.put("master_timeout", this.masterTimeout._toJsonString());
        }
    }

    /**
     * Endpoint "{@code cluster.exists_component_template}".
     */
    public static final Endpoint<ExistsComponentTemplateRequest, BooleanResponse, ErrorResponse> _ENDPOINT = new BooleanEndpoint<>(
        // Request method
        request -> "HEAD",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_component_template/");
            SimpleEndpoint.pathEncode(request.name, buf);
            return buf.toString();
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap()
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.local);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + this.name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExistsComponentTemplateRequest other = (ExistsComponentTemplateRequest) o;
        return Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.local, other.local)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && this.name.equals(other.name);
    }
}
