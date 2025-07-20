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

package org.opensearch.client.opensearch.knn;

import jakarta.json.stream.JsonGenerator;
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
import org.opensearch.client.opensearch._types.HealthStatus;
import org.opensearch.client.opensearch.nodes.NodesResponseBase;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: knn.stats.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class KnnStatsResponse extends NodesResponseBase implements ToCopyableBuilder<KnnStatsResponse.Builder, KnnStatsResponse> {

    @Nullable
    private final Boolean circuitBreakerTriggered;

    @Nullable
    private final String clusterName;

    @Nullable
    private final HealthStatus modelIndexStatus;

    @Nonnull
    private final Map<String, NodeStats> nodes;

    // ---------------------------------------------------------------------------------------------

    private KnnStatsResponse(Builder builder) {
        super(builder);
        this.circuitBreakerTriggered = builder.circuitBreakerTriggered;
        this.clusterName = builder.clusterName;
        this.modelIndexStatus = builder.modelIndexStatus;
        this.nodes = ApiTypeHelper.unmodifiable(builder.nodes);
    }

    public static KnnStatsResponse of(Function<KnnStatsResponse.Builder, ObjectBuilder<KnnStatsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code circuit_breaker_triggered}
     */
    @Nullable
    public final Boolean circuitBreakerTriggered() {
        return this.circuitBreakerTriggered;
    }

    /**
     * API name: {@code cluster_name}
     */
    @Nullable
    public final String clusterName() {
        return this.clusterName;
    }

    /**
     * API name: {@code model_index_status}
     */
    @Nullable
    public final HealthStatus modelIndexStatus() {
        return this.modelIndexStatus;
    }

    /**
     * API name: {@code nodes}
     */
    @Nonnull
    public final Map<String, NodeStats> nodes() {
        return this.nodes;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.circuitBreakerTriggered != null) {
            generator.writeKey("circuit_breaker_triggered");
            generator.write(this.circuitBreakerTriggered);
        }

        if (this.clusterName != null) {
            generator.writeKey("cluster_name");
            generator.write(this.clusterName);
        }

        if (this.modelIndexStatus != null) {
            generator.writeKey("model_index_status");
            this.modelIndexStatus.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.nodes)) {
            generator.writeKey("nodes");
            generator.writeStartObject();
            for (Map.Entry<String, NodeStats> item0 : this.nodes.entrySet()) {
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
     * Builder for {@link KnnStatsResponse}.
     */
    public static class Builder extends NodesResponseBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, KnnStatsResponse> {
        @Nullable
        private Boolean circuitBreakerTriggered;
        @Nullable
        private String clusterName;
        @Nullable
        private HealthStatus modelIndexStatus;
        @Nullable
        private Map<String, NodeStats> nodes;

        public Builder() {}

        private Builder(KnnStatsResponse o) {
            super(o);
            this.circuitBreakerTriggered = o.circuitBreakerTriggered;
            this.clusterName = o.clusterName;
            this.modelIndexStatus = o.modelIndexStatus;
            this.nodes = _mapCopy(o.nodes);
        }

        private Builder(Builder o) {
            super(o);
            this.circuitBreakerTriggered = o.circuitBreakerTriggered;
            this.clusterName = o.clusterName;
            this.modelIndexStatus = o.modelIndexStatus;
            this.nodes = _mapCopy(o.nodes);
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
         * API name: {@code circuit_breaker_triggered}
         */
        @Nonnull
        public final Builder circuitBreakerTriggered(@Nullable Boolean value) {
            this.circuitBreakerTriggered = value;
            return this;
        }

        /**
         * API name: {@code cluster_name}
         */
        @Nonnull
        public final Builder clusterName(@Nullable String value) {
            this.clusterName = value;
            return this;
        }

        /**
         * API name: {@code model_index_status}
         */
        @Nonnull
        public final Builder modelIndexStatus(@Nullable HealthStatus value) {
            this.modelIndexStatus = value;
            return this;
        }

        /**
         * API name: {@code nodes}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(Map<String, NodeStats> map) {
            this.nodes = _mapPutAll(this.nodes, map);
            return this;
        }

        /**
         * API name: {@code nodes}
         *
         * <p>
         * Adds an entry to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(String key, NodeStats value) {
            this.nodes = _mapPut(this.nodes, key, value);
            return this;
        }

        /**
         * API name: {@code nodes}
         *
         * <p>
         * Adds a value to <code>nodes</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder nodes(String key, Function<NodeStats.Builder, ObjectBuilder<NodeStats>> fn) {
            return nodes(key, fn.apply(new NodeStats.Builder()).build());
        }

        /**
         * Builds a {@link KnnStatsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public KnnStatsResponse build() {
            _checkSingleUse();

            return new KnnStatsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link KnnStatsResponse}
     */
    public static final JsonpDeserializer<KnnStatsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        KnnStatsResponse::setupKnnStatsResponseDeserializer
    );

    protected static void setupKnnStatsResponseDeserializer(ObjectDeserializer<KnnStatsResponse.Builder> op) {
        setupNodesResponseBaseDeserializer(op);
        op.add(Builder::circuitBreakerTriggered, JsonpDeserializer.booleanDeserializer(), "circuit_breaker_triggered");
        op.add(Builder::clusterName, JsonpDeserializer.stringDeserializer(), "cluster_name");
        op.add(Builder::modelIndexStatus, HealthStatus._DESERIALIZER, "model_index_status");
        op.add(Builder::nodes, JsonpDeserializer.stringMapDeserializer(NodeStats._DESERIALIZER), "nodes");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.circuitBreakerTriggered);
        result = 31 * result + Objects.hashCode(this.clusterName);
        result = 31 * result + Objects.hashCode(this.modelIndexStatus);
        result = 31 * result + Objects.hashCode(this.nodes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        KnnStatsResponse other = (KnnStatsResponse) o;
        return Objects.equals(this.circuitBreakerTriggered, other.circuitBreakerTriggered)
            && Objects.equals(this.clusterName, other.clusterName)
            && Objects.equals(this.modelIndexStatus, other.modelIndexStatus)
            && Objects.equals(this.nodes, other.nodes);
    }
}
