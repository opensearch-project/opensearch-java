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
import org.opensearch.client.opensearch._types.StoredScript;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.put_script.Request

/**
 * Creates or updates a script.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PutScriptRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PutScriptRequest.Builder, PutScriptRequest> {

    @Nullable
    private final Time clusterManagerTimeout;

    @Nullable
    private final String context;

    @Nonnull
    private final String id;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nonnull
    private final StoredScript script;

    @Nullable
    private final Time timeout;

    // ---------------------------------------------------------------------------------------------

    private PutScriptRequest(Builder builder) {
        super(builder);
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.context = builder.context;
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.masterTimeout = builder.masterTimeout;
        this.script = ApiTypeHelper.requireNonNull(builder.script, this, "script");
        this.timeout = builder.timeout;
    }

    public static PutScriptRequest of(Function<PutScriptRequest.Builder, ObjectBuilder<PutScriptRequest>> fn) {
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
     * Context in which the script or search template should run. To prevent errors, the API immediately compiles the script or template in
     * this context.
     * <p>
     * API name: {@code context}
     * </p>
     */
    @Nullable
    public final String context() {
        return this.context;
    }

    /**
     * Required - Identifier for the stored script or search template. Must be unique within the cluster.
     * <p>
     * API name: {@code id}
     * </p>
     */
    @Nonnull
    public final String id() {
        return this.id;
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
     * Required - API name: {@code script}
     */
    @Nonnull
    public final StoredScript script() {
        return this.script;
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
        generator.writeKey("script");
        this.script.serialize(generator, mapper);
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
     * Builder for {@link PutScriptRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PutScriptRequest> {
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private String context;
        private String id;
        @Nullable
        private Time masterTimeout;
        private StoredScript script;
        @Nullable
        private Time timeout;

        public Builder() {}

        private Builder(PutScriptRequest o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.context = o.context;
            this.id = o.id;
            this.masterTimeout = o.masterTimeout;
            this.script = o.script;
            this.timeout = o.timeout;
        }

        private Builder(Builder o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.context = o.context;
            this.id = o.id;
            this.masterTimeout = o.masterTimeout;
            this.script = o.script;
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
         * Context in which the script or search template should run. To prevent errors, the API immediately compiles the script or template
         * in this context.
         * <p>
         * API name: {@code context}
         * </p>
         */
        @Nonnull
        public final Builder context(@Nullable String value) {
            this.context = value;
            return this;
        }

        /**
         * Required - Identifier for the stored script or search template. Must be unique within the cluster.
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
         * Required - API name: {@code script}
         */
        @Nonnull
        public final Builder script(StoredScript value) {
            this.script = value;
            return this;
        }

        /**
         * Required - API name: {@code script}
         */
        @Nonnull
        public final Builder script(Function<StoredScript.Builder, ObjectBuilder<StoredScript>> fn) {
            return script(fn.apply(new StoredScript.Builder()).build());
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
         * Builds a {@link PutScriptRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutScriptRequest build() {
            _checkSingleUse();

            return new PutScriptRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutScriptRequest}
     */
    public static final JsonpDeserializer<PutScriptRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutScriptRequest::setupPutScriptRequestDeserializer
    );

    protected static void setupPutScriptRequestDeserializer(ObjectDeserializer<PutScriptRequest.Builder> op) {
        op.add(Builder::script, StoredScript._DESERIALIZER, "script");
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
     * Endpoint "{@code put_script}".
     */
    public static final Endpoint<PutScriptRequest, PutScriptResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> {
            final int _context = 1 << 0;
            final int _id = 1 << 1;

            int propsSet = 0;

            if (request.context() != null) propsSet |= _context;
            propsSet |= _id;

            if (propsSet == (_id)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_scripts/");
                SimpleEndpoint.pathEncode(request.id, buf);
                return buf.toString();
            }
            if (propsSet == (_id | _context)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_scripts/");
                SimpleEndpoint.pathEncode(request.id, buf);
                buf.append("/");
                SimpleEndpoint.pathEncode(request.context, buf);
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
        PutScriptResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.context);
        result = 31 * result + this.id.hashCode();
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + this.script.hashCode();
        result = 31 * result + Objects.hashCode(this.timeout);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PutScriptRequest other = (PutScriptRequest) o;
        return Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.context, other.context)
            && this.id.equals(other.id)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && this.script.equals(other.script)
            && Objects.equals(this.timeout, other.timeout);
    }
}
