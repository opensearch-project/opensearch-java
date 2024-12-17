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
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.WaitForActiveShards;
import org.opensearch.client.opensearch._types.mapping.TypeMapping;
import org.opensearch.client.opensearch.indices.rollover.RolloverConditions;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.rollover.Request

/**
 * Updates an alias to point to a new index when the existing index is considered to be too large or too old.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RolloverRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RolloverRequest.Builder, RolloverRequest> {

    @Nonnull
    private final String alias;

    @Nonnull
    private final Map<String, Alias> aliases;

    @Nullable
    private final Time clusterManagerTimeout;

    @Nullable
    private final RolloverConditions conditions;

    @Nullable
    private final Boolean dryRun;

    @Nullable
    private final TypeMapping mappings;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nullable
    private final String newIndex;

    @Nonnull
    private final Map<String, JsonData> settings;

    @Nullable
    private final Time timeout;

    @Nullable
    private final WaitForActiveShards waitForActiveShards;

    // ---------------------------------------------------------------------------------------------

    private RolloverRequest(Builder builder) {
        this.alias = ApiTypeHelper.requireNonNull(builder.alias, this, "alias");
        this.aliases = ApiTypeHelper.unmodifiable(builder.aliases);
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.conditions = builder.conditions;
        this.dryRun = builder.dryRun;
        this.mappings = builder.mappings;
        this.masterTimeout = builder.masterTimeout;
        this.newIndex = builder.newIndex;
        this.settings = ApiTypeHelper.unmodifiable(builder.settings);
        this.timeout = builder.timeout;
        this.waitForActiveShards = builder.waitForActiveShards;
    }

    public static RolloverRequest of(Function<RolloverRequest.Builder, ObjectBuilder<RolloverRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Name of the data stream or index alias to roll over.
     * <p>
     * API name: {@code alias}
     * </p>
     */
    @Nonnull
    public final String alias() {
        return this.alias;
    }

    /**
     * Aliases for the target index. Data streams do not support this parameter.
     * <p>
     * API name: {@code aliases}
     * </p>
     */
    @Nonnull
    public final Map<String, Alias> aliases() {
        return this.aliases;
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
     * API name: {@code conditions}
     */
    @Nullable
    public final RolloverConditions conditions() {
        return this.conditions;
    }

    /**
     * If <code>true</code>, checks whether the current index satisfies the specified conditions but does not perform a rollover.
     * <p>
     * API name: {@code dry_run}
     * </p>
     */
    @Nullable
    public final Boolean dryRun() {
        return this.dryRun;
    }

    /**
     * API name: {@code mappings}
     */
    @Nullable
    public final TypeMapping mappings() {
        return this.mappings;
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
     * Name of the index to create. Supports date math. Data streams do not support this parameter.
     * <p>
     * API name: {@code new_index}
     * </p>
     */
    @Nullable
    public final String newIndex() {
        return this.newIndex;
    }

    /**
     * Configuration options for the index. Data streams do not support this parameter.
     * <p>
     * API name: {@code settings}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> settings() {
        return this.settings;
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
     * The number of shard copies that must be active before proceeding with the operation. Set to all or any positive integer up to the
     * total number of shards in the index (<code>number_of_replicas+1</code>).
     * <p>
     * API name: {@code wait_for_active_shards}
     * </p>
     */
    @Nullable
    public final WaitForActiveShards waitForActiveShards() {
        return this.waitForActiveShards;
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
        if (ApiTypeHelper.isDefined(this.aliases)) {
            generator.writeKey("aliases");
            generator.writeStartObject();
            for (Map.Entry<String, Alias> item0 : this.aliases.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.conditions != null) {
            generator.writeKey("conditions");
            this.conditions.serialize(generator, mapper);
        }

        if (this.mappings != null) {
            generator.writeKey("mappings");
            this.mappings.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.settings)) {
            generator.writeKey("settings");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.settings.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
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
     * Builder for {@link RolloverRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RolloverRequest> {
        private String alias;
        @Nullable
        private Map<String, Alias> aliases;
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private RolloverConditions conditions;
        @Nullable
        private Boolean dryRun;
        @Nullable
        private TypeMapping mappings;
        @Nullable
        private Time masterTimeout;
        @Nullable
        private String newIndex;
        @Nullable
        private Map<String, JsonData> settings;
        @Nullable
        private Time timeout;
        @Nullable
        private WaitForActiveShards waitForActiveShards;

        public Builder() {}

        private Builder(RolloverRequest o) {
            this.alias = o.alias;
            this.aliases = _mapCopy(o.aliases);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.conditions = o.conditions;
            this.dryRun = o.dryRun;
            this.mappings = o.mappings;
            this.masterTimeout = o.masterTimeout;
            this.newIndex = o.newIndex;
            this.settings = _mapCopy(o.settings);
            this.timeout = o.timeout;
            this.waitForActiveShards = o.waitForActiveShards;
        }

        private Builder(Builder o) {
            this.alias = o.alias;
            this.aliases = _mapCopy(o.aliases);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.conditions = o.conditions;
            this.dryRun = o.dryRun;
            this.mappings = o.mappings;
            this.masterTimeout = o.masterTimeout;
            this.newIndex = o.newIndex;
            this.settings = _mapCopy(o.settings);
            this.timeout = o.timeout;
            this.waitForActiveShards = o.waitForActiveShards;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Name of the data stream or index alias to roll over.
         * <p>
         * API name: {@code alias}
         * </p>
         */
        @Nonnull
        public final Builder alias(String value) {
            this.alias = value;
            return this;
        }

        /**
         * Aliases for the target index. Data streams do not support this parameter.
         * <p>
         * API name: {@code aliases}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>aliases</code>.
         * </p>
         */
        @Nonnull
        public final Builder aliases(Map<String, Alias> map) {
            this.aliases = _mapPutAll(this.aliases, map);
            return this;
        }

        /**
         * Aliases for the target index. Data streams do not support this parameter.
         * <p>
         * API name: {@code aliases}
         * </p>
         *
         * <p>
         * Adds an entry to <code>aliases</code>.
         * </p>
         */
        @Nonnull
        public final Builder aliases(String key, Alias value) {
            this.aliases = _mapPut(this.aliases, key, value);
            return this;
        }

        /**
         * Aliases for the target index. Data streams do not support this parameter.
         * <p>
         * API name: {@code aliases}
         * </p>
         *
         * <p>
         * Adds a value to <code>aliases</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder aliases(String key, Function<Alias.Builder, ObjectBuilder<Alias>> fn) {
            return aliases(key, fn.apply(new Alias.Builder()).build());
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
         * API name: {@code conditions}
         */
        @Nonnull
        public final Builder conditions(@Nullable RolloverConditions value) {
            this.conditions = value;
            return this;
        }

        /**
         * API name: {@code conditions}
         */
        @Nonnull
        public final Builder conditions(Function<RolloverConditions.Builder, ObjectBuilder<RolloverConditions>> fn) {
            return conditions(fn.apply(new RolloverConditions.Builder()).build());
        }

        /**
         * If <code>true</code>, checks whether the current index satisfies the specified conditions but does not perform a rollover.
         * <p>
         * API name: {@code dry_run}
         * </p>
         */
        @Nonnull
        public final Builder dryRun(@Nullable Boolean value) {
            this.dryRun = value;
            return this;
        }

        /**
         * API name: {@code mappings}
         */
        @Nonnull
        public final Builder mappings(@Nullable TypeMapping value) {
            this.mappings = value;
            return this;
        }

        /**
         * API name: {@code mappings}
         */
        @Nonnull
        public final Builder mappings(Function<TypeMapping.Builder, ObjectBuilder<TypeMapping>> fn) {
            return mappings(fn.apply(new TypeMapping.Builder()).build());
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
         * Name of the index to create. Supports date math. Data streams do not support this parameter.
         * <p>
         * API name: {@code new_index}
         * </p>
         */
        @Nonnull
        public final Builder newIndex(@Nullable String value) {
            this.newIndex = value;
            return this;
        }

        /**
         * Configuration options for the index. Data streams do not support this parameter.
         * <p>
         * API name: {@code settings}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>settings</code>.
         * </p>
         */
        @Nonnull
        public final Builder settings(Map<String, JsonData> map) {
            this.settings = _mapPutAll(this.settings, map);
            return this;
        }

        /**
         * Configuration options for the index. Data streams do not support this parameter.
         * <p>
         * API name: {@code settings}
         * </p>
         *
         * <p>
         * Adds an entry to <code>settings</code>.
         * </p>
         */
        @Nonnull
        public final Builder settings(String key, JsonData value) {
            this.settings = _mapPut(this.settings, key, value);
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
         * The number of shard copies that must be active before proceeding with the operation. Set to all or any positive integer up to the
         * total number of shards in the index (<code>number_of_replicas+1</code>).
         * <p>
         * API name: {@code wait_for_active_shards}
         * </p>
         */
        @Nonnull
        public final Builder waitForActiveShards(@Nullable WaitForActiveShards value) {
            this.waitForActiveShards = value;
            return this;
        }

        /**
         * The number of shard copies that must be active before proceeding with the operation. Set to all or any positive integer up to the
         * total number of shards in the index (<code>number_of_replicas+1</code>).
         * <p>
         * API name: {@code wait_for_active_shards}
         * </p>
         */
        @Nonnull
        public final Builder waitForActiveShards(Function<WaitForActiveShards.Builder, ObjectBuilder<WaitForActiveShards>> fn) {
            return waitForActiveShards(fn.apply(new WaitForActiveShards.Builder()).build());
        }

        /**
         * Builds a {@link RolloverRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RolloverRequest build() {
            _checkSingleUse();

            return new RolloverRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RolloverRequest}
     */
    public static final JsonpDeserializer<RolloverRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RolloverRequest::setupRolloverRequestDeserializer
    );

    protected static void setupRolloverRequestDeserializer(ObjectDeserializer<RolloverRequest.Builder> op) {
        op.add(Builder::alias, JsonpDeserializer.stringDeserializer(), "alias");
        op.add(Builder::aliases, JsonpDeserializer.stringMapDeserializer(Alias._DESERIALIZER), "aliases");
        op.add(Builder::conditions, RolloverConditions._DESERIALIZER, "conditions");
        op.add(Builder::mappings, TypeMapping._DESERIALIZER, "mappings");
        op.add(Builder::newIndex, JsonpDeserializer.stringDeserializer(), "new_index");
        op.add(Builder::settings, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "settings");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code indices.rollover}".
     */
    public static final Endpoint<RolloverRequest, RolloverResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _alias = 1 << 0;
            final int _newIndex = 1 << 1;

            int propsSet = 0;

            propsSet |= _alias;
            if (request.newIndex() != null) propsSet |= _newIndex;

            if (propsSet == (_alias)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/");
                SimpleEndpoint.pathEncode(request.alias, buf);
                buf.append("/_rollover");
                return buf.toString();
            }
            if (propsSet == (_alias | _newIndex)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/");
                SimpleEndpoint.pathEncode(request.alias, buf);
                buf.append("/_rollover/");
                SimpleEndpoint.pathEncode(request.newIndex, buf);
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
            if (request.dryRun != null) {
                params.put("dry_run", String.valueOf(request.dryRun));
            }
            if (request.masterTimeout != null) {
                params.put("master_timeout", request.masterTimeout._toJsonString());
            }
            if (request.timeout != null) {
                params.put("timeout", request.timeout._toJsonString());
            }
            if (request.waitForActiveShards != null) {
                params.put("wait_for_active_shards", request.waitForActiveShards._toJsonString());
            }
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        RolloverResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.alias.hashCode();
        result = 31 * result + Objects.hashCode(this.aliases);
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.conditions);
        result = 31 * result + Objects.hashCode(this.dryRun);
        result = 31 * result + Objects.hashCode(this.mappings);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + Objects.hashCode(this.newIndex);
        result = 31 * result + Objects.hashCode(this.settings);
        result = 31 * result + Objects.hashCode(this.timeout);
        result = 31 * result + Objects.hashCode(this.waitForActiveShards);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RolloverRequest other = (RolloverRequest) o;
        return this.alias.equals(other.alias)
            && Objects.equals(this.aliases, other.aliases)
            && Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.conditions, other.conditions)
            && Objects.equals(this.dryRun, other.dryRun)
            && Objects.equals(this.mappings, other.mappings)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.newIndex, other.newIndex)
            && Objects.equals(this.settings, other.settings)
            && Objects.equals(this.timeout, other.timeout)
            && Objects.equals(this.waitForActiveShards, other.waitForActiveShards);
    }
}
