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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.info.NodeInfoSettings

/**
 * The configuration settings for the node.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoSettings implements PlainJsonSerializable, ToCopyableBuilder<NodeInfoSettings.Builder, NodeInfoSettings> {

    @Nullable
    private final NodeInfoAction action;

    @Nullable
    private final NodeInfoBootstrap bootstrap;

    @Nonnull
    private final NodeInfoClient client;

    @Nonnull
    private final NodeInfoSettingsCluster cluster;

    @Nullable
    private final NodeInfoDiscovery discovery;

    @Nonnull
    private final NodeInfoSettingsHttp http;

    @Nullable
    private final NodeInfoSettingsIndex index;

    @Nullable
    private final NodeInfoSettingsIngest ingest;

    @Nullable
    private final NodeInfoSettingsNetwork network;

    @Nonnull
    private final NodeInfoSettingsNode node;

    @Nonnull
    private final NodeInfoPath path;

    @Nonnull
    private final Map<String, JsonData> plugins;

    @Nullable
    private final NodeInfoRepositories repositories;

    @Nullable
    private final NodeInfoScript script;

    @Nullable
    private final NodeInfoSearch search;

    @Nonnull
    private final NodeInfoSettingsTransport transport;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoSettings(Builder builder) {
        this.action = builder.action;
        this.bootstrap = builder.bootstrap;
        this.client = ApiTypeHelper.requireNonNull(builder.client, this, "client");
        this.cluster = ApiTypeHelper.requireNonNull(builder.cluster, this, "cluster");
        this.discovery = builder.discovery;
        this.http = ApiTypeHelper.requireNonNull(builder.http, this, "http");
        this.index = builder.index;
        this.ingest = builder.ingest;
        this.network = builder.network;
        this.node = ApiTypeHelper.requireNonNull(builder.node, this, "node");
        this.path = ApiTypeHelper.requireNonNull(builder.path, this, "path");
        this.plugins = ApiTypeHelper.unmodifiable(builder.plugins);
        this.repositories = builder.repositories;
        this.script = builder.script;
        this.search = builder.search;
        this.transport = ApiTypeHelper.requireNonNull(builder.transport, this, "transport");
    }

    public static NodeInfoSettings of(Function<NodeInfoSettings.Builder, ObjectBuilder<NodeInfoSettings>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code action}
     */
    @Nullable
    public final NodeInfoAction action() {
        return this.action;
    }

    /**
     * API name: {@code bootstrap}
     */
    @Nullable
    public final NodeInfoBootstrap bootstrap() {
        return this.bootstrap;
    }

    /**
     * Required - API name: {@code client}
     */
    @Nonnull
    public final NodeInfoClient client() {
        return this.client;
    }

    /**
     * Required - API name: {@code cluster}
     */
    @Nonnull
    public final NodeInfoSettingsCluster cluster() {
        return this.cluster;
    }

    /**
     * API name: {@code discovery}
     */
    @Nullable
    public final NodeInfoDiscovery discovery() {
        return this.discovery;
    }

    /**
     * Required - API name: {@code http}
     */
    @Nonnull
    public final NodeInfoSettingsHttp http() {
        return this.http;
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final NodeInfoSettingsIndex index() {
        return this.index;
    }

    /**
     * API name: {@code ingest}
     */
    @Nullable
    public final NodeInfoSettingsIngest ingest() {
        return this.ingest;
    }

    /**
     * API name: {@code network}
     */
    @Nullable
    public final NodeInfoSettingsNetwork network() {
        return this.network;
    }

    /**
     * Required - API name: {@code node}
     */
    @Nonnull
    public final NodeInfoSettingsNode node() {
        return this.node;
    }

    /**
     * Required - API name: {@code path}
     */
    @Nonnull
    public final NodeInfoPath path() {
        return this.path;
    }

    /**
     * API name: {@code plugins}
     */
    @Nonnull
    public final Map<String, JsonData> plugins() {
        return this.plugins;
    }

    /**
     * API name: {@code repositories}
     */
    @Nullable
    public final NodeInfoRepositories repositories() {
        return this.repositories;
    }

    /**
     * API name: {@code script}
     */
    @Nullable
    public final NodeInfoScript script() {
        return this.script;
    }

    /**
     * API name: {@code search}
     */
    @Nullable
    public final NodeInfoSearch search() {
        return this.search;
    }

    /**
     * Required - API name: {@code transport}
     */
    @Nonnull
    public final NodeInfoSettingsTransport transport() {
        return this.transport;
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
        if (this.action != null) {
            generator.writeKey("action");
            this.action.serialize(generator, mapper);
        }

        if (this.bootstrap != null) {
            generator.writeKey("bootstrap");
            this.bootstrap.serialize(generator, mapper);
        }

        generator.writeKey("client");
        this.client.serialize(generator, mapper);

        generator.writeKey("cluster");
        this.cluster.serialize(generator, mapper);

        if (this.discovery != null) {
            generator.writeKey("discovery");
            this.discovery.serialize(generator, mapper);
        }

        generator.writeKey("http");
        this.http.serialize(generator, mapper);

        if (this.index != null) {
            generator.writeKey("index");
            this.index.serialize(generator, mapper);
        }

        if (this.ingest != null) {
            generator.writeKey("ingest");
            this.ingest.serialize(generator, mapper);
        }

        if (this.network != null) {
            generator.writeKey("network");
            this.network.serialize(generator, mapper);
        }

        generator.writeKey("node");
        this.node.serialize(generator, mapper);

        generator.writeKey("path");
        this.path.serialize(generator, mapper);

        if (ApiTypeHelper.isDefined(this.plugins)) {
            generator.writeKey("plugins");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.plugins.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.repositories != null) {
            generator.writeKey("repositories");
            this.repositories.serialize(generator, mapper);
        }

        if (this.script != null) {
            generator.writeKey("script");
            this.script.serialize(generator, mapper);
        }

        if (this.search != null) {
            generator.writeKey("search");
            this.search.serialize(generator, mapper);
        }

        generator.writeKey("transport");
        this.transport.serialize(generator, mapper);
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
     * Builder for {@link NodeInfoSettings}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoSettings> {
        @Nullable
        private NodeInfoAction action;
        @Nullable
        private NodeInfoBootstrap bootstrap;
        private NodeInfoClient client;
        private NodeInfoSettingsCluster cluster;
        @Nullable
        private NodeInfoDiscovery discovery;
        private NodeInfoSettingsHttp http;
        @Nullable
        private NodeInfoSettingsIndex index;
        @Nullable
        private NodeInfoSettingsIngest ingest;
        @Nullable
        private NodeInfoSettingsNetwork network;
        private NodeInfoSettingsNode node;
        private NodeInfoPath path;
        @Nullable
        private Map<String, JsonData> plugins;
        @Nullable
        private NodeInfoRepositories repositories;
        @Nullable
        private NodeInfoScript script;
        @Nullable
        private NodeInfoSearch search;
        private NodeInfoSettingsTransport transport;

        public Builder() {}

        private Builder(NodeInfoSettings o) {
            this.action = o.action;
            this.bootstrap = o.bootstrap;
            this.client = o.client;
            this.cluster = o.cluster;
            this.discovery = o.discovery;
            this.http = o.http;
            this.index = o.index;
            this.ingest = o.ingest;
            this.network = o.network;
            this.node = o.node;
            this.path = o.path;
            this.plugins = _mapCopy(o.plugins);
            this.repositories = o.repositories;
            this.script = o.script;
            this.search = o.search;
            this.transport = o.transport;
        }

        private Builder(Builder o) {
            this.action = o.action;
            this.bootstrap = o.bootstrap;
            this.client = o.client;
            this.cluster = o.cluster;
            this.discovery = o.discovery;
            this.http = o.http;
            this.index = o.index;
            this.ingest = o.ingest;
            this.network = o.network;
            this.node = o.node;
            this.path = o.path;
            this.plugins = _mapCopy(o.plugins);
            this.repositories = o.repositories;
            this.script = o.script;
            this.search = o.search;
            this.transport = o.transport;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code action}
         */
        @Nonnull
        public final Builder action(@Nullable NodeInfoAction value) {
            this.action = value;
            return this;
        }

        /**
         * API name: {@code action}
         */
        @Nonnull
        public final Builder action(Function<NodeInfoAction.Builder, ObjectBuilder<NodeInfoAction>> fn) {
            return action(fn.apply(new NodeInfoAction.Builder()).build());
        }

        /**
         * API name: {@code bootstrap}
         */
        @Nonnull
        public final Builder bootstrap(@Nullable NodeInfoBootstrap value) {
            this.bootstrap = value;
            return this;
        }

        /**
         * API name: {@code bootstrap}
         */
        @Nonnull
        public final Builder bootstrap(Function<NodeInfoBootstrap.Builder, ObjectBuilder<NodeInfoBootstrap>> fn) {
            return bootstrap(fn.apply(new NodeInfoBootstrap.Builder()).build());
        }

        /**
         * Required - API name: {@code client}
         */
        @Nonnull
        public final Builder client(NodeInfoClient value) {
            this.client = value;
            return this;
        }

        /**
         * Required - API name: {@code client}
         */
        @Nonnull
        public final Builder client(Function<NodeInfoClient.Builder, ObjectBuilder<NodeInfoClient>> fn) {
            return client(fn.apply(new NodeInfoClient.Builder()).build());
        }

        /**
         * Required - API name: {@code cluster}
         */
        @Nonnull
        public final Builder cluster(NodeInfoSettingsCluster value) {
            this.cluster = value;
            return this;
        }

        /**
         * Required - API name: {@code cluster}
         */
        @Nonnull
        public final Builder cluster(Function<NodeInfoSettingsCluster.Builder, ObjectBuilder<NodeInfoSettingsCluster>> fn) {
            return cluster(fn.apply(new NodeInfoSettingsCluster.Builder()).build());
        }

        /**
         * API name: {@code discovery}
         */
        @Nonnull
        public final Builder discovery(@Nullable NodeInfoDiscovery value) {
            this.discovery = value;
            return this;
        }

        /**
         * API name: {@code discovery}
         */
        @Nonnull
        public final Builder discovery(Function<NodeInfoDiscovery.Builder, ObjectBuilder<NodeInfoDiscovery>> fn) {
            return discovery(fn.apply(new NodeInfoDiscovery.Builder()).build());
        }

        /**
         * Required - API name: {@code http}
         */
        @Nonnull
        public final Builder http(NodeInfoSettingsHttp value) {
            this.http = value;
            return this;
        }

        /**
         * Required - API name: {@code http}
         */
        @Nonnull
        public final Builder http(Function<NodeInfoSettingsHttp.Builder, ObjectBuilder<NodeInfoSettingsHttp>> fn) {
            return http(fn.apply(new NodeInfoSettingsHttp.Builder()).build());
        }

        /**
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(@Nullable NodeInfoSettingsIndex value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(Function<NodeInfoSettingsIndex.Builder, ObjectBuilder<NodeInfoSettingsIndex>> fn) {
            return index(fn.apply(new NodeInfoSettingsIndex.Builder()).build());
        }

        /**
         * API name: {@code ingest}
         */
        @Nonnull
        public final Builder ingest(@Nullable NodeInfoSettingsIngest value) {
            this.ingest = value;
            return this;
        }

        /**
         * API name: {@code ingest}
         */
        @Nonnull
        public final Builder ingest(Function<NodeInfoSettingsIngest.Builder, ObjectBuilder<NodeInfoSettingsIngest>> fn) {
            return ingest(fn.apply(new NodeInfoSettingsIngest.Builder()).build());
        }

        /**
         * API name: {@code network}
         */
        @Nonnull
        public final Builder network(@Nullable NodeInfoSettingsNetwork value) {
            this.network = value;
            return this;
        }

        /**
         * API name: {@code network}
         */
        @Nonnull
        public final Builder network(Function<NodeInfoSettingsNetwork.Builder, ObjectBuilder<NodeInfoSettingsNetwork>> fn) {
            return network(fn.apply(new NodeInfoSettingsNetwork.Builder()).build());
        }

        /**
         * Required - API name: {@code node}
         */
        @Nonnull
        public final Builder node(NodeInfoSettingsNode value) {
            this.node = value;
            return this;
        }

        /**
         * Required - API name: {@code node}
         */
        @Nonnull
        public final Builder node(Function<NodeInfoSettingsNode.Builder, ObjectBuilder<NodeInfoSettingsNode>> fn) {
            return node(fn.apply(new NodeInfoSettingsNode.Builder()).build());
        }

        /**
         * Required - API name: {@code path}
         */
        @Nonnull
        public final Builder path(NodeInfoPath value) {
            this.path = value;
            return this;
        }

        /**
         * Required - API name: {@code path}
         */
        @Nonnull
        public final Builder path(Function<NodeInfoPath.Builder, ObjectBuilder<NodeInfoPath>> fn) {
            return path(fn.apply(new NodeInfoPath.Builder()).build());
        }

        /**
         * API name: {@code plugins}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>plugins</code>.
         * </p>
         */
        @Nonnull
        public final Builder plugins(Map<String, JsonData> map) {
            this.plugins = _mapPutAll(this.plugins, map);
            return this;
        }

        /**
         * API name: {@code plugins}
         *
         * <p>
         * Adds an entry to <code>plugins</code>.
         * </p>
         */
        @Nonnull
        public final Builder plugins(String key, JsonData value) {
            this.plugins = _mapPut(this.plugins, key, value);
            return this;
        }

        /**
         * API name: {@code repositories}
         */
        @Nonnull
        public final Builder repositories(@Nullable NodeInfoRepositories value) {
            this.repositories = value;
            return this;
        }

        /**
         * API name: {@code repositories}
         */
        @Nonnull
        public final Builder repositories(Function<NodeInfoRepositories.Builder, ObjectBuilder<NodeInfoRepositories>> fn) {
            return repositories(fn.apply(new NodeInfoRepositories.Builder()).build());
        }

        /**
         * API name: {@code script}
         */
        @Nonnull
        public final Builder script(@Nullable NodeInfoScript value) {
            this.script = value;
            return this;
        }

        /**
         * API name: {@code script}
         */
        @Nonnull
        public final Builder script(Function<NodeInfoScript.Builder, ObjectBuilder<NodeInfoScript>> fn) {
            return script(fn.apply(new NodeInfoScript.Builder()).build());
        }

        /**
         * API name: {@code search}
         */
        @Nonnull
        public final Builder search(@Nullable NodeInfoSearch value) {
            this.search = value;
            return this;
        }

        /**
         * API name: {@code search}
         */
        @Nonnull
        public final Builder search(Function<NodeInfoSearch.Builder, ObjectBuilder<NodeInfoSearch>> fn) {
            return search(fn.apply(new NodeInfoSearch.Builder()).build());
        }

        /**
         * Required - API name: {@code transport}
         */
        @Nonnull
        public final Builder transport(NodeInfoSettingsTransport value) {
            this.transport = value;
            return this;
        }

        /**
         * Required - API name: {@code transport}
         */
        @Nonnull
        public final Builder transport(Function<NodeInfoSettingsTransport.Builder, ObjectBuilder<NodeInfoSettingsTransport>> fn) {
            return transport(fn.apply(new NodeInfoSettingsTransport.Builder()).build());
        }

        /**
         * Builds a {@link NodeInfoSettings}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoSettings build() {
            _checkSingleUse();

            return new NodeInfoSettings(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoSettings}
     */
    public static final JsonpDeserializer<NodeInfoSettings> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoSettings::setupNodeInfoSettingsDeserializer
    );

    protected static void setupNodeInfoSettingsDeserializer(ObjectDeserializer<NodeInfoSettings.Builder> op) {
        op.add(Builder::action, NodeInfoAction._DESERIALIZER, "action");
        op.add(Builder::bootstrap, NodeInfoBootstrap._DESERIALIZER, "bootstrap");
        op.add(Builder::client, NodeInfoClient._DESERIALIZER, "client");
        op.add(Builder::cluster, NodeInfoSettingsCluster._DESERIALIZER, "cluster");
        op.add(Builder::discovery, NodeInfoDiscovery._DESERIALIZER, "discovery");
        op.add(Builder::http, NodeInfoSettingsHttp._DESERIALIZER, "http");
        op.add(Builder::index, NodeInfoSettingsIndex._DESERIALIZER, "index");
        op.add(Builder::ingest, NodeInfoSettingsIngest._DESERIALIZER, "ingest");
        op.add(Builder::network, NodeInfoSettingsNetwork._DESERIALIZER, "network");
        op.add(Builder::node, NodeInfoSettingsNode._DESERIALIZER, "node");
        op.add(Builder::path, NodeInfoPath._DESERIALIZER, "path");
        op.add(Builder::plugins, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "plugins");
        op.add(Builder::repositories, NodeInfoRepositories._DESERIALIZER, "repositories");
        op.add(Builder::script, NodeInfoScript._DESERIALIZER, "script");
        op.add(Builder::search, NodeInfoSearch._DESERIALIZER, "search");
        op.add(Builder::transport, NodeInfoSettingsTransport._DESERIALIZER, "transport");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.action);
        result = 31 * result + Objects.hashCode(this.bootstrap);
        result = 31 * result + this.client.hashCode();
        result = 31 * result + this.cluster.hashCode();
        result = 31 * result + Objects.hashCode(this.discovery);
        result = 31 * result + this.http.hashCode();
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.ingest);
        result = 31 * result + Objects.hashCode(this.network);
        result = 31 * result + this.node.hashCode();
        result = 31 * result + this.path.hashCode();
        result = 31 * result + Objects.hashCode(this.plugins);
        result = 31 * result + Objects.hashCode(this.repositories);
        result = 31 * result + Objects.hashCode(this.script);
        result = 31 * result + Objects.hashCode(this.search);
        result = 31 * result + this.transport.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoSettings other = (NodeInfoSettings) o;
        return Objects.equals(this.action, other.action)
            && Objects.equals(this.bootstrap, other.bootstrap)
            && this.client.equals(other.client)
            && this.cluster.equals(other.cluster)
            && Objects.equals(this.discovery, other.discovery)
            && this.http.equals(other.http)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.ingest, other.ingest)
            && Objects.equals(this.network, other.network)
            && this.node.equals(other.node)
            && this.path.equals(other.path)
            && Objects.equals(this.plugins, other.plugins)
            && Objects.equals(this.repositories, other.repositories)
            && Objects.equals(this.script, other.script)
            && Objects.equals(this.search, other.search)
            && this.transport.equals(other.transport);
    }
}
