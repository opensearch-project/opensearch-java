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
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.simulate_template.Request

/**
 * Simulate resolving the given template name or body.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SimulateTemplateRequest extends RequestBase
    implements
        ToCopyableBuilder<SimulateTemplateRequest.Builder, SimulateTemplateRequest> {

    @Nullable
    private final String cause;

    @Nullable
    private final Time clusterManagerTimeout;

    @Nullable
    private final Boolean create;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nullable
    private final String name;

    @Nonnull
    private final IndexTemplate template;

    // ---------------------------------------------------------------------------------------------

    private SimulateTemplateRequest(Builder builder) {
        this.cause = builder.cause;
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.create = builder.create;
        this.masterTimeout = builder.masterTimeout;
        this.name = builder.name;
        this.template = ApiTypeHelper.requireNonNull(builder.template, this, "template");
    }

    public static SimulateTemplateRequest of(Function<SimulateTemplateRequest.Builder, ObjectBuilder<SimulateTemplateRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * User defined reason for dry-run creating the new template for simulation purposes.
     * <p>
     * API name: {@code cause}
     * </p>
     */
    @Nullable
    public final String cause() {
        return this.cause;
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
     * If <code>true</code>, the template passed in the body is only used if no existing templates match the same index patterns. If
     * <code>false</code>, the simulation uses the template with the highest priority. Note that the template is not permanently added or
     * updated in either case; it is only used for the simulation.
     * <p>
     * API name: {@code create}
     * </p>
     */
    @Nullable
    public final Boolean create() {
        return this.create;
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
     * Name of the index template to simulate. To test a template configuration before you add it to the cluster, omit this parameter and
     * specify the template configuration in the request body.
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * Required - Request body.
     */
    @Nonnull
    public final IndexTemplate template() {
        return this.template;
    }

    /**
     * Serialize this value to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        this.template.serialize(generator, mapper);
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
     * Builder for {@link SimulateTemplateRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SimulateTemplateRequest> {
        @Nullable
        private String cause;
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private Boolean create;
        @Nullable
        private Time masterTimeout;
        @Nullable
        private String name;
        private IndexTemplate template;

        public Builder() {}

        private Builder(SimulateTemplateRequest o) {
            this.cause = o.cause;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.create = o.create;
            this.masterTimeout = o.masterTimeout;
            this.name = o.name;
            this.template = o.template;
        }

        private Builder(Builder o) {
            this.cause = o.cause;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.create = o.create;
            this.masterTimeout = o.masterTimeout;
            this.name = o.name;
            this.template = o.template;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * User defined reason for dry-run creating the new template for simulation purposes.
         * <p>
         * API name: {@code cause}
         * </p>
         */
        @Nonnull
        public final Builder cause(@Nullable String value) {
            this.cause = value;
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
         * If <code>true</code>, the template passed in the body is only used if no existing templates match the same index patterns. If
         * <code>false</code>, the simulation uses the template with the highest priority. Note that the template is not permanently added
         * or updated in either case; it is only used for the simulation.
         * <p>
         * API name: {@code create}
         * </p>
         */
        @Nonnull
        public final Builder create(@Nullable Boolean value) {
            this.create = value;
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
         * Name of the index template to simulate. To test a template configuration before you add it to the cluster, omit this parameter
         * and specify the template configuration in the request body.
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
         * Required - Request body.
         */
        @Nonnull
        public final Builder template(IndexTemplate value) {
            this.template = value;
            return this;
        }

        /**
         * Required - Request body.
         */
        @Nonnull
        public final Builder template(Function<IndexTemplate.Builder, ObjectBuilder<IndexTemplate>> fn) {
            return template(fn.apply(new IndexTemplate.Builder()).build());
        }

        /**
         * Builds a {@link SimulateTemplateRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SimulateTemplateRequest build() {
            _checkSingleUse();

            return new SimulateTemplateRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public static final JsonpDeserializer<SimulateTemplateRequest> _DESERIALIZER = createSimulateTemplateRequestDeserializer();

    protected static JsonpDeserializer<SimulateTemplateRequest> createSimulateTemplateRequestDeserializer() {
        JsonpDeserializer<IndexTemplate> valueDeserializer = IndexTemplate._DESERIALIZER;
        return JsonpDeserializer.of(
            valueDeserializer.acceptedEvents(),
            (parser, mapper) -> new Builder().template(valueDeserializer.deserialize(parser, mapper)).build()
        );
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code indices.simulate_template}".
     */
    public static final Endpoint<SimulateTemplateRequest, SimulateTemplateResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _name = 1 << 0;

            int propsSet = 0;

            if (request.name() != null) propsSet |= _name;

            if (propsSet == 0) {
                return "/_index_template/_simulate";
            }
            if (propsSet == (_name)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_index_template/_simulate/");
                SimpleEndpoint.pathEncode(request.name, buf);
                return buf.toString();
            }

            throw SimpleEndpoint.noPathTemplateFound("path");
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            if (request.cause != null) {
                params.put("cause", request.cause);
            }
            if (request.clusterManagerTimeout != null) {
                params.put("cluster_manager_timeout", request.clusterManagerTimeout._toJsonString());
            }
            if (request.create != null) {
                params.put("create", String.valueOf(request.create));
            }
            if (request.masterTimeout != null) {
                params.put("master_timeout", request.masterTimeout._toJsonString());
            }
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        SimulateTemplateResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.cause);
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.create);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + this.template.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SimulateTemplateRequest other = (SimulateTemplateRequest) o;
        return Objects.equals(this.cause, other.cause)
            && Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.create, other.create)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.name, other.name)
            && this.template.equals(other.template);
    }
}
