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
import org.opensearch.client.opensearch.indices.update_aliases.Action;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.update_aliases.Request

/**
 * Updates index aliases.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UpdateAliasesRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<UpdateAliasesRequest.Builder, UpdateAliasesRequest> {

    @Nonnull
    private final List<Action> actions;

    @Nullable
    private final Time clusterManagerTimeout;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nullable
    private final Time timeout;

    // ---------------------------------------------------------------------------------------------

    private UpdateAliasesRequest(Builder builder) {
        this.actions = ApiTypeHelper.unmodifiable(builder.actions);
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.masterTimeout = builder.masterTimeout;
        this.timeout = builder.timeout;
    }

    public static UpdateAliasesRequest of(Function<UpdateAliasesRequest.Builder, ObjectBuilder<UpdateAliasesRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Actions to perform.
     * <p>
     * API name: {@code actions}
     * </p>
     */
    @Nonnull
    public final List<Action> actions() {
        return this.actions;
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
        if (ApiTypeHelper.isDefined(this.actions)) {
            generator.writeKey("actions");
            generator.writeStartArray();
            for (Action item0 : this.actions) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link UpdateAliasesRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, UpdateAliasesRequest> {
        @Nullable
        private List<Action> actions;
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private Time masterTimeout;
        @Nullable
        private Time timeout;

        public Builder() {}

        private Builder(UpdateAliasesRequest o) {
            this.actions = _listCopy(o.actions);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.masterTimeout = o.masterTimeout;
            this.timeout = o.timeout;
        }

        private Builder(Builder o) {
            this.actions = _listCopy(o.actions);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.masterTimeout = o.masterTimeout;
            this.timeout = o.timeout;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Actions to perform.
         * <p>
         * API name: {@code actions}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>actions</code>.
         * </p>
         */
        @Nonnull
        public final Builder actions(List<Action> list) {
            this.actions = _listAddAll(this.actions, list);
            return this;
        }

        /**
         * Actions to perform.
         * <p>
         * API name: {@code actions}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>actions</code>.
         * </p>
         */
        @Nonnull
        public final Builder actions(Action value, Action... values) {
            this.actions = _listAdd(this.actions, value, values);
            return this;
        }

        /**
         * Actions to perform.
         * <p>
         * API name: {@code actions}
         * </p>
         *
         * <p>
         * Adds a value to <code>actions</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder actions(Function<Action.Builder, ObjectBuilder<Action>> fn) {
            return actions(fn.apply(new Action.Builder()).build());
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
         * Builds a {@link UpdateAliasesRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UpdateAliasesRequest build() {
            _checkSingleUse();

            return new UpdateAliasesRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UpdateAliasesRequest}
     */
    public static final JsonpDeserializer<UpdateAliasesRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UpdateAliasesRequest::setupUpdateAliasesRequestDeserializer
    );

    protected static void setupUpdateAliasesRequestDeserializer(ObjectDeserializer<UpdateAliasesRequest.Builder> op) {
        op.add(Builder::actions, JsonpDeserializer.arrayDeserializer(Action._DESERIALIZER), "actions");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code indices.update_aliases}".
     */
    public static final Endpoint<UpdateAliasesRequest, UpdateAliasesResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> "/_aliases",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            if (request.clusterManagerTimeout != null) {
                params.put("cluster_manager_timeout", request.clusterManagerTimeout._toJsonString());
            }
            if (request.masterTimeout != null) {
                params.put("master_timeout", request.masterTimeout._toJsonString());
            }
            if (request.timeout != null) {
                params.put("timeout", request.timeout._toJsonString());
            }
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        UpdateAliasesResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.actions);
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + Objects.hashCode(this.timeout);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UpdateAliasesRequest other = (UpdateAliasesRequest) o;
        return Objects.equals(this.actions, other.actions)
            && Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.timeout, other.timeout);
    }
}
