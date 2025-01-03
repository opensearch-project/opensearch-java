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

package org.opensearch.client.opensearch.nodes;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch.nodes.usage.NodeUsage;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.usage.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodesUsageResponse extends NodesResponseBase implements ToCopyableBuilder<NodesUsageResponse.Builder, NodesUsageResponse> {

    @Nonnull
    private final String clusterName;

    @Nonnull
    private final Map<String, NodeUsage> nodes;

    // ---------------------------------------------------------------------------------------------

    private NodesUsageResponse(Builder builder) {
        super(builder);
        this.clusterName = ApiTypeHelper.requireNonNull(builder.clusterName, this, "clusterName");
        this.nodes = ApiTypeHelper.unmodifiableRequired(builder.nodes, this, "nodes");
    }

    public static NodesUsageResponse of(Function<NodesUsageResponse.Builder, ObjectBuilder<NodesUsageResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code cluster_name}
     */
    @Nonnull
    public final String clusterName() {
        return this.clusterName;
    }

    /**
     * Required - API name: {@code nodes}
     */
    @Nonnull
    public final Map<String, NodeUsage> nodes() {
        return this.nodes;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("cluster_name");
        generator.write(this.clusterName);

        generator.writeKey("nodes");
        generator.writeStartObject();
        for (Map.Entry<String, NodeUsage> item0 : this.nodes.entrySet()) {
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
     * Builder for {@link NodesUsageResponse}.
     */
    public static class Builder extends NodesResponseBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, NodesUsageResponse> {
        private String clusterName;
        private Map<String, NodeUsage> nodes;

        public Builder() {}

        private Builder(NodesUsageResponse o) {
            super(o);
            this.clusterName = o.clusterName;
            this.nodes = _mapCopy(o.nodes);
        }

        private Builder(Builder o) {
            super(o);
            this.clusterName = o.clusterName;
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
         * Required - API name: {@code cluster_name}
         */
        @Nonnull
        public final Builder clusterName(String value) {
            this.clusterName = value;
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
        public final Builder nodes(Map<String, NodeUsage> map) {
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
        public final Builder nodes(String key, NodeUsage value) {
            this.nodes = _mapPut(this.nodes, key, value);
            return this;
        }

        /**
         * Required - API name: {@code nodes}
         *
         * <p>
         * Adds a value to <code>nodes</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder nodes(String key, Function<NodeUsage.Builder, ObjectBuilder<NodeUsage>> fn) {
            return nodes(key, fn.apply(new NodeUsage.Builder()).build());
        }

        /**
         * Builds a {@link NodesUsageResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodesUsageResponse build() {
            _checkSingleUse();

            return new NodesUsageResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodesUsageResponse}
     */
    public static final JsonpDeserializer<NodesUsageResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodesUsageResponse::setupNodesUsageResponseDeserializer
    );

    protected static void setupNodesUsageResponseDeserializer(ObjectDeserializer<NodesUsageResponse.Builder> op) {
        setupNodesResponseBaseDeserializer(op);
        op.add(Builder::clusterName, JsonpDeserializer.stringDeserializer(), "cluster_name");
        op.add(Builder::nodes, JsonpDeserializer.stringMapDeserializer(NodeUsage._DESERIALIZER), "nodes");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.clusterName.hashCode();
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
        NodesUsageResponse other = (NodesUsageResponse) o;
        return this.clusterName.equals(other.clusterName) && this.nodes.equals(other.nodes);
    }
}