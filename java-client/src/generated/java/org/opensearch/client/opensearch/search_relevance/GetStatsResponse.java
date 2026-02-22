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

package org.opensearch.client.opensearch.search_relevance;

import jakarta.json.stream.JsonGenerator;
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
import org.opensearch.client.opensearch.nodes.NodesResponseBase;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_relevance.get_stats.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetStatsResponse extends NodesResponseBase implements ToCopyableBuilder<GetStatsResponse.Builder, GetStatsResponse> {

    @Nonnull
    private final Map<String, JsonData> allNodes;

    @Nullable
    private final String clusterName;

    @Nonnull
    private final Map<String, JsonData> info;

    @Nonnull
    private final Map<String, JsonData> nodes;

    // ---------------------------------------------------------------------------------------------

    private GetStatsResponse(Builder builder) {
        super(builder);
        this.allNodes = ApiTypeHelper.unmodifiable(builder.allNodes);
        this.clusterName = builder.clusterName;
        this.info = ApiTypeHelper.unmodifiable(builder.info);
        this.nodes = ApiTypeHelper.unmodifiableRequired(builder.nodes, this, "nodes");
    }

    public static GetStatsResponse of(Function<GetStatsResponse.Builder, ObjectBuilder<GetStatsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code all_nodes}
     */
    @Nonnull
    public final Map<String, JsonData> allNodes() {
        return this.allNodes;
    }

    /**
     * API name: {@code cluster_name}
     */
    @Nullable
    public final String clusterName() {
        return this.clusterName;
    }

    /**
     * API name: {@code info}
     */
    @Nonnull
    public final Map<String, JsonData> info() {
        return this.info;
    }

    /**
     * Required - API name: {@code nodes}
     */
    @Nonnull
    public final Map<String, JsonData> nodes() {
        return this.nodes;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (ApiTypeHelper.isDefined(this.allNodes)) {
            generator.writeKey("all_nodes");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.allNodes.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.clusterName != null) {
            generator.writeKey("cluster_name");
            generator.write(this.clusterName);
        }

        if (ApiTypeHelper.isDefined(this.info)) {
            generator.writeKey("info");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.info.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("nodes");
        generator.writeStartObject();
        for (Map.Entry<String, JsonData> item0 : this.nodes.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link GetStatsResponse}.
     */
    public static class Builder extends NodesResponseBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GetStatsResponse> {
        @Nullable
        private Map<String, JsonData> allNodes;
        @Nullable
        private String clusterName;
        @Nullable
        private Map<String, JsonData> info;
        private Map<String, JsonData> nodes;

        public Builder() {}

        private Builder(GetStatsResponse o) {
            super(o);
            this.allNodes = _mapCopy(o.allNodes);
            this.clusterName = o.clusterName;
            this.info = _mapCopy(o.info);
            this.nodes = _mapCopy(o.nodes);
        }

        private Builder(Builder o) {
            super(o);
            this.allNodes = _mapCopy(o.allNodes);
            this.clusterName = o.clusterName;
            this.info = _mapCopy(o.info);
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
         * API name: {@code all_nodes}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>allNodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder allNodes(Map<String, JsonData> map) {
            this.allNodes = _mapPutAll(this.allNodes, map);
            return this;
        }

        /**
         * API name: {@code all_nodes}
         *
         * <p>
         * Adds an entry to <code>allNodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder allNodes(String key, JsonData value) {
            this.allNodes = _mapPut(this.allNodes, key, value);
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
         * API name: {@code info}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>info</code>.
         * </p>
         */
        @Nonnull
        public final Builder info(Map<String, JsonData> map) {
            this.info = _mapPutAll(this.info, map);
            return this;
        }

        /**
         * API name: {@code info}
         *
         * <p>
         * Adds an entry to <code>info</code>.
         * </p>
         */
        @Nonnull
        public final Builder info(String key, JsonData value) {
            this.info = _mapPut(this.info, key, value);
            return this;
        }

        /**
         * Required - API name: {@code nodes}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(Map<String, JsonData> map) {
            this.nodes = _mapPutAll(this.nodes, map);
            return this;
        }

        /**
         * Required - API name: {@code nodes}
         *
         * <p>
         * Adds an entry to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(String key, JsonData value) {
            this.nodes = _mapPut(this.nodes, key, value);
            return this;
        }

        /**
         * Builds a {@link GetStatsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetStatsResponse build() {
            _checkSingleUse();

            return new GetStatsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetStatsResponse}
     */
    public static final JsonpDeserializer<GetStatsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetStatsResponse::setupGetStatsResponseDeserializer
    );

    protected static void setupGetStatsResponseDeserializer(ObjectDeserializer<GetStatsResponse.Builder> op) {
        setupNodesResponseBaseDeserializer(op);
        op.add(Builder::allNodes, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "all_nodes");
        op.add(Builder::clusterName, JsonpDeserializer.stringDeserializer(), "cluster_name");
        op.add(Builder::info, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "info");
        op.add(Builder::nodes, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "nodes");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.allNodes);
        result = 31 * result + Objects.hashCode(this.clusterName);
        result = 31 * result + Objects.hashCode(this.info);
        result = 31 * result + this.nodes.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetStatsResponse other = (GetStatsResponse) o;
        return Objects.equals(this.allNodes, other.allNodes)
            && Objects.equals(this.clusterName, other.clusterName)
            && Objects.equals(this.info, other.info)
            && this.nodes.equals(other.nodes);
    }
}
