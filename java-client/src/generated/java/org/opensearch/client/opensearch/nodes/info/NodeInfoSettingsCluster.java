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

package org.opensearch.client.opensearch.nodes.info;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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
import org.opensearch.client.opensearch.indices.IndexRouting;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.info.NodeInfoSettingsCluster

/**
 * Provides cluster-level settings information.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoSettingsCluster
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<NodeInfoSettingsCluster.Builder, NodeInfoSettingsCluster> {

    @Nullable
    private final NodeInfoSettingsDeprecationIndexing deprecationIndexing;

    @Nullable
    private final NodeInfoSettingsClusterElection election;

    @Nonnull
    private final List<String> initialClusterManagerNodes;

    @Nonnull
    private final List<String> initialMasterNodes;

    @Nonnull
    private final String name;

    @Nullable
    private final IndexRouting routing;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoSettingsCluster(Builder builder) {
        this.deprecationIndexing = builder.deprecationIndexing;
        this.election = builder.election;
        this.initialClusterManagerNodes = ApiTypeHelper.unmodifiable(builder.initialClusterManagerNodes);
        this.initialMasterNodes = ApiTypeHelper.unmodifiable(builder.initialMasterNodes);
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.routing = builder.routing;
    }

    public static NodeInfoSettingsCluster of(Function<NodeInfoSettingsCluster.Builder, ObjectBuilder<NodeInfoSettingsCluster>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code deprecation_indexing}
     */
    @Nullable
    public final NodeInfoSettingsDeprecationIndexing deprecationIndexing() {
        return this.deprecationIndexing;
    }

    /**
     * API name: {@code election}
     */
    @Nullable
    public final NodeInfoSettingsClusterElection election() {
        return this.election;
    }

    /**
     * API name: {@code initial_cluster_manager_nodes}
     */
    @Nonnull
    public final List<String> initialClusterManagerNodes() {
        return this.initialClusterManagerNodes;
    }

    /**
     * API name: {@code initial_master_nodes}
     */
    @Nonnull
    public final List<String> initialMasterNodes() {
        return this.initialMasterNodes;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code routing}
     */
    @Nullable
    public final IndexRouting routing() {
        return this.routing;
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
        if (this.deprecationIndexing != null) {
            generator.writeKey("deprecation_indexing");
            this.deprecationIndexing.serialize(generator, mapper);
        }

        if (this.election != null) {
            generator.writeKey("election");
            this.election.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.initialClusterManagerNodes)) {
            generator.writeKey("initial_cluster_manager_nodes");
            generator.writeStartArray();
            for (String item0 : this.initialClusterManagerNodes) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.initialMasterNodes)) {
            generator.writeKey("initial_master_nodes");
            generator.writeStartArray();
            for (String item0 : this.initialMasterNodes) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        generator.writeKey("name");
        generator.write(this.name);

        if (this.routing != null) {
            generator.writeKey("routing");
            this.routing.serialize(generator, mapper);
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
     * Builder for {@link NodeInfoSettingsCluster}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoSettingsCluster> {
        @Nullable
        private NodeInfoSettingsDeprecationIndexing deprecationIndexing;
        @Nullable
        private NodeInfoSettingsClusterElection election;
        @Nullable
        private List<String> initialClusterManagerNodes;
        @Nullable
        private List<String> initialMasterNodes;
        private String name;
        @Nullable
        private IndexRouting routing;

        public Builder() {}

        private Builder(NodeInfoSettingsCluster o) {
            this.deprecationIndexing = o.deprecationIndexing;
            this.election = o.election;
            this.initialClusterManagerNodes = _listCopy(o.initialClusterManagerNodes);
            this.initialMasterNodes = _listCopy(o.initialMasterNodes);
            this.name = o.name;
            this.routing = o.routing;
        }

        private Builder(Builder o) {
            this.deprecationIndexing = o.deprecationIndexing;
            this.election = o.election;
            this.initialClusterManagerNodes = _listCopy(o.initialClusterManagerNodes);
            this.initialMasterNodes = _listCopy(o.initialMasterNodes);
            this.name = o.name;
            this.routing = o.routing;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code deprecation_indexing}
         */
        @Nonnull
        public final Builder deprecationIndexing(@Nullable NodeInfoSettingsDeprecationIndexing value) {
            this.deprecationIndexing = value;
            return this;
        }

        /**
         * API name: {@code deprecation_indexing}
         */
        @Nonnull
        public final Builder deprecationIndexing(
            Function<NodeInfoSettingsDeprecationIndexing.Builder, ObjectBuilder<NodeInfoSettingsDeprecationIndexing>> fn
        ) {
            return deprecationIndexing(fn.apply(new NodeInfoSettingsDeprecationIndexing.Builder()).build());
        }

        /**
         * API name: {@code election}
         */
        @Nonnull
        public final Builder election(@Nullable NodeInfoSettingsClusterElection value) {
            this.election = value;
            return this;
        }

        /**
         * API name: {@code election}
         */
        @Nonnull
        public final Builder election(
            Function<NodeInfoSettingsClusterElection.Builder, ObjectBuilder<NodeInfoSettingsClusterElection>> fn
        ) {
            return election(fn.apply(new NodeInfoSettingsClusterElection.Builder()).build());
        }

        /**
         * API name: {@code initial_cluster_manager_nodes}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>initialClusterManagerNodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder initialClusterManagerNodes(List<String> list) {
            this.initialClusterManagerNodes = _listAddAll(this.initialClusterManagerNodes, list);
            return this;
        }

        /**
         * API name: {@code initial_cluster_manager_nodes}
         *
         * <p>
         * Adds one or more values to <code>initialClusterManagerNodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder initialClusterManagerNodes(String value, String... values) {
            this.initialClusterManagerNodes = _listAdd(this.initialClusterManagerNodes, value, values);
            return this;
        }

        /**
         * API name: {@code initial_master_nodes}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>initialMasterNodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder initialMasterNodes(List<String> list) {
            this.initialMasterNodes = _listAddAll(this.initialMasterNodes, list);
            return this;
        }

        /**
         * API name: {@code initial_master_nodes}
         *
         * <p>
         * Adds one or more values to <code>initialMasterNodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder initialMasterNodes(String value, String... values) {
            this.initialMasterNodes = _listAdd(this.initialMasterNodes, value, values);
            return this;
        }

        /**
         * Required - API name: {@code name}
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * API name: {@code routing}
         */
        @Nonnull
        public final Builder routing(@Nullable IndexRouting value) {
            this.routing = value;
            return this;
        }

        /**
         * API name: {@code routing}
         */
        @Nonnull
        public final Builder routing(Function<IndexRouting.Builder, ObjectBuilder<IndexRouting>> fn) {
            return routing(fn.apply(new IndexRouting.Builder()).build());
        }

        /**
         * Builds a {@link NodeInfoSettingsCluster}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoSettingsCluster build() {
            _checkSingleUse();

            return new NodeInfoSettingsCluster(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoSettingsCluster}
     */
    public static final JsonpDeserializer<NodeInfoSettingsCluster> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoSettingsCluster::setupNodeInfoSettingsClusterDeserializer
    );

    protected static void setupNodeInfoSettingsClusterDeserializer(ObjectDeserializer<NodeInfoSettingsCluster.Builder> op) {
        op.add(Builder::deprecationIndexing, NodeInfoSettingsDeprecationIndexing._DESERIALIZER, "deprecation_indexing");
        op.add(Builder::election, NodeInfoSettingsClusterElection._DESERIALIZER, "election");
        op.add(
            Builder::initialClusterManagerNodes,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "initial_cluster_manager_nodes"
        );
        op.add(
            Builder::initialMasterNodes,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "initial_master_nodes"
        );
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::routing, IndexRouting._DESERIALIZER, "routing");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.deprecationIndexing);
        result = 31 * result + Objects.hashCode(this.election);
        result = 31 * result + Objects.hashCode(this.initialClusterManagerNodes);
        result = 31 * result + Objects.hashCode(this.initialMasterNodes);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Objects.hashCode(this.routing);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoSettingsCluster other = (NodeInfoSettingsCluster) o;
        return Objects.equals(this.deprecationIndexing, other.deprecationIndexing)
            && Objects.equals(this.election, other.election)
            && Objects.equals(this.initialClusterManagerNodes, other.initialClusterManagerNodes)
            && Objects.equals(this.initialMasterNodes, other.initialMasterNodes)
            && this.name.equals(other.name)
            && Objects.equals(this.routing, other.routing);
    }
}
