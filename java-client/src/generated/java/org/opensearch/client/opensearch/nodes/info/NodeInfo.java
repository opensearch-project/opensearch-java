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
import org.opensearch.client.opensearch._types.NodeRole;
import org.opensearch.client.opensearch._types.PluginStats;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.info.NodeInfo

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfo implements PlainJsonSerializable, ToCopyableBuilder<NodeInfo.Builder, NodeInfo> {

    @Nonnull
    private final Map<String, NodeInfoAggregation> aggregations;

    @Nonnull
    private final Map<String, String> attributes;

    @Nullable
    private final String buildFlavor;

    @Nonnull
    private final String buildHash;

    @Nonnull
    private final String buildType;

    @Nullable
    private final String host;

    @Nullable
    private final NodeInfoHttp http;

    @Nullable
    private final NodeInfoIngest ingest;

    @Nullable
    private final String ip;

    @Nullable
    private final NodeJvmInfo jvm;

    @Nonnull
    private final List<PluginStats> modules;

    @Nonnull
    private final String name;

    @Nullable
    private final NodeInfoNetwork network;

    @Nullable
    private final NodeOperatingSystemInfo os;

    @Nonnull
    private final List<PluginStats> plugins;

    @Nullable
    private final NodeProcessInfo process;

    @Nonnull
    private final List<NodeRole> roles;

    @Nullable
    private final NodeInfoSearchPipelines searchPipelines;

    @Nullable
    private final NodeInfoSettings settings;

    @Nonnull
    private final Map<String, NodeThreadPoolInfo> threadPool;

    @Nullable
    private final JsonData totalIndexingBuffer;

    @Nullable
    private final JsonData totalIndexingBufferInBytes;

    @Nullable
    private final NodeInfoTransport transport;

    @Nullable
    private final String transportAddress;

    @Nonnull
    private final String version;

    // ---------------------------------------------------------------------------------------------

    private NodeInfo(Builder builder) {
        this.aggregations = ApiTypeHelper.unmodifiable(builder.aggregations);
        this.attributes = ApiTypeHelper.unmodifiable(builder.attributes);
        this.buildFlavor = builder.buildFlavor;
        this.buildHash = ApiTypeHelper.requireNonNull(builder.buildHash, this, "buildHash");
        this.buildType = ApiTypeHelper.requireNonNull(builder.buildType, this, "buildType");
        this.host = builder.host;
        this.http = builder.http;
        this.ingest = builder.ingest;
        this.ip = builder.ip;
        this.jvm = builder.jvm;
        this.modules = ApiTypeHelper.unmodifiable(builder.modules);
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.network = builder.network;
        this.os = builder.os;
        this.plugins = ApiTypeHelper.unmodifiable(builder.plugins);
        this.process = builder.process;
        this.roles = ApiTypeHelper.unmodifiableRequired(builder.roles, this, "roles");
        this.searchPipelines = builder.searchPipelines;
        this.settings = builder.settings;
        this.threadPool = ApiTypeHelper.unmodifiable(builder.threadPool);
        this.totalIndexingBuffer = builder.totalIndexingBuffer;
        this.totalIndexingBufferInBytes = builder.totalIndexingBufferInBytes;
        this.transport = builder.transport;
        this.transportAddress = builder.transportAddress;
        this.version = ApiTypeHelper.requireNonNull(builder.version, this, "version");
    }

    public static NodeInfo of(Function<NodeInfo.Builder, ObjectBuilder<NodeInfo>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Information about available aggregation types.
     * <p>
     * API name: {@code aggregations}
     * </p>
     */
    @Nonnull
    public final Map<String, NodeInfoAggregation> aggregations() {
        return this.aggregations;
    }

    /**
     * The custom attributes of the node.
     * <p>
     * API name: {@code attributes}
     * </p>
     */
    @Nonnull
    public final Map<String, String> attributes() {
        return this.attributes;
    }

    /**
     * API name: {@code build_flavor}
     */
    @Nullable
    public final String buildFlavor() {
        return this.buildFlavor;
    }

    /**
     * Required - Short hash of the last git commit in this release.
     * <p>
     * API name: {@code build_hash}
     * </p>
     */
    @Nonnull
    public final String buildHash() {
        return this.buildHash;
    }

    /**
     * Required - The type of build, such as <code>tar</code>, <code>docker</code>, <code>rpm</code>.
     * <p>
     * API name: {@code build_type}
     * </p>
     */
    @Nonnull
    public final String buildType() {
        return this.buildType;
    }

    /**
     * API name: {@code host}
     */
    @Nullable
    public final String host() {
        return this.host;
    }

    /**
     * API name: {@code http}
     */
    @Nullable
    public final NodeInfoHttp http() {
        return this.http;
    }

    /**
     * API name: {@code ingest}
     */
    @Nullable
    public final NodeInfoIngest ingest() {
        return this.ingest;
    }

    /**
     * API name: {@code ip}
     */
    @Nullable
    public final String ip() {
        return this.ip;
    }

    /**
     * API name: {@code jvm}
     */
    @Nullable
    public final NodeJvmInfo jvm() {
        return this.jvm;
    }

    /**
     * The list of modules installed on the node.
     * <p>
     * API name: {@code modules}
     * </p>
     */
    @Nonnull
    public final List<PluginStats> modules() {
        return this.modules;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code network}
     */
    @Nullable
    public final NodeInfoNetwork network() {
        return this.network;
    }

    /**
     * API name: {@code os}
     */
    @Nullable
    public final NodeOperatingSystemInfo os() {
        return this.os;
    }

    /**
     * The list of plugins installed on the node.
     * <p>
     * API name: {@code plugins}
     * </p>
     */
    @Nonnull
    public final List<PluginStats> plugins() {
        return this.plugins;
    }

    /**
     * API name: {@code process}
     */
    @Nullable
    public final NodeProcessInfo process() {
        return this.process;
    }

    /**
     * Required - API name: {@code roles}
     */
    @Nonnull
    public final List<NodeRole> roles() {
        return this.roles;
    }

    /**
     * API name: {@code search_pipelines}
     */
    @Nullable
    public final NodeInfoSearchPipelines searchPipelines() {
        return this.searchPipelines;
    }

    /**
     * API name: {@code settings}
     */
    @Nullable
    public final NodeInfoSettings settings() {
        return this.settings;
    }

    /**
     * Information about thread pool configurations.
     * <p>
     * API name: {@code thread_pool}
     * </p>
     */
    @Nonnull
    public final Map<String, NodeThreadPoolInfo> threadPool() {
        return this.threadPool;
    }

    /**
     * Total heap allowed to be used to hold recently indexed documents before they must be written to disk. This size is a shared pool
     * across all shards on this node, and is controlled by Indexing Buffer settings.
     * <p>
     * API name: {@code total_indexing_buffer}
     * </p>
     */
    @Nullable
    public final JsonData totalIndexingBuffer() {
        return this.totalIndexingBuffer;
    }

    /**
     * API name: {@code total_indexing_buffer_in_bytes}
     */
    @Nullable
    public final JsonData totalIndexingBufferInBytes() {
        return this.totalIndexingBufferInBytes;
    }

    /**
     * API name: {@code transport}
     */
    @Nullable
    public final NodeInfoTransport transport() {
        return this.transport;
    }

    /**
     * API name: {@code transport_address}
     */
    @Nullable
    public final String transportAddress() {
        return this.transportAddress;
    }

    /**
     * Required - API name: {@code version}
     */
    @Nonnull
    public final String version() {
        return this.version;
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
        if (ApiTypeHelper.isDefined(this.aggregations)) {
            generator.writeKey("aggregations");
            generator.writeStartObject();
            for (Map.Entry<String, NodeInfoAggregation> item0 : this.aggregations.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.attributes)) {
            generator.writeKey("attributes");
            generator.writeStartObject();
            for (Map.Entry<String, String> item0 : this.attributes.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        if (this.buildFlavor != null) {
            generator.writeKey("build_flavor");
            generator.write(this.buildFlavor);
        }

        generator.writeKey("build_hash");
        generator.write(this.buildHash);

        generator.writeKey("build_type");
        generator.write(this.buildType);

        if (this.host != null) {
            generator.writeKey("host");
            generator.write(this.host);
        }

        if (this.http != null) {
            generator.writeKey("http");
            this.http.serialize(generator, mapper);
        }

        if (this.ingest != null) {
            generator.writeKey("ingest");
            this.ingest.serialize(generator, mapper);
        }

        if (this.ip != null) {
            generator.writeKey("ip");
            generator.write(this.ip);
        }

        if (this.jvm != null) {
            generator.writeKey("jvm");
            this.jvm.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.modules)) {
            generator.writeKey("modules");
            generator.writeStartArray();
            for (PluginStats item0 : this.modules) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("name");
        generator.write(this.name);

        if (this.network != null) {
            generator.writeKey("network");
            this.network.serialize(generator, mapper);
        }

        if (this.os != null) {
            generator.writeKey("os");
            this.os.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.plugins)) {
            generator.writeKey("plugins");
            generator.writeStartArray();
            for (PluginStats item0 : this.plugins) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.process != null) {
            generator.writeKey("process");
            this.process.serialize(generator, mapper);
        }

        generator.writeKey("roles");
        generator.writeStartArray();
        for (NodeRole item0 : this.roles) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        if (this.searchPipelines != null) {
            generator.writeKey("search_pipelines");
            this.searchPipelines.serialize(generator, mapper);
        }

        if (this.settings != null) {
            generator.writeKey("settings");
            this.settings.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.threadPool)) {
            generator.writeKey("thread_pool");
            generator.writeStartObject();
            for (Map.Entry<String, NodeThreadPoolInfo> item0 : this.threadPool.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.totalIndexingBuffer != null) {
            generator.writeKey("total_indexing_buffer");
            this.totalIndexingBuffer.serialize(generator, mapper);
        }

        if (this.totalIndexingBufferInBytes != null) {
            generator.writeKey("total_indexing_buffer_in_bytes");
            this.totalIndexingBufferInBytes.serialize(generator, mapper);
        }

        if (this.transport != null) {
            generator.writeKey("transport");
            this.transport.serialize(generator, mapper);
        }

        if (this.transportAddress != null) {
            generator.writeKey("transport_address");
            generator.write(this.transportAddress);
        }

        generator.writeKey("version");
        generator.write(this.version);
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
     * Builder for {@link NodeInfo}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfo> {
        @Nullable
        private Map<String, NodeInfoAggregation> aggregations;
        @Nullable
        private Map<String, String> attributes;
        @Nullable
        private String buildFlavor;
        private String buildHash;
        private String buildType;
        @Nullable
        private String host;
        @Nullable
        private NodeInfoHttp http;
        @Nullable
        private NodeInfoIngest ingest;
        @Nullable
        private String ip;
        @Nullable
        private NodeJvmInfo jvm;
        @Nullable
        private List<PluginStats> modules;
        private String name;
        @Nullable
        private NodeInfoNetwork network;
        @Nullable
        private NodeOperatingSystemInfo os;
        @Nullable
        private List<PluginStats> plugins;
        @Nullable
        private NodeProcessInfo process;
        private List<NodeRole> roles;
        @Nullable
        private NodeInfoSearchPipelines searchPipelines;
        @Nullable
        private NodeInfoSettings settings;
        @Nullable
        private Map<String, NodeThreadPoolInfo> threadPool;
        @Nullable
        private JsonData totalIndexingBuffer;
        @Nullable
        private JsonData totalIndexingBufferInBytes;
        @Nullable
        private NodeInfoTransport transport;
        @Nullable
        private String transportAddress;
        private String version;

        public Builder() {}

        private Builder(NodeInfo o) {
            this.aggregations = _mapCopy(o.aggregations);
            this.attributes = _mapCopy(o.attributes);
            this.buildFlavor = o.buildFlavor;
            this.buildHash = o.buildHash;
            this.buildType = o.buildType;
            this.host = o.host;
            this.http = o.http;
            this.ingest = o.ingest;
            this.ip = o.ip;
            this.jvm = o.jvm;
            this.modules = _listCopy(o.modules);
            this.name = o.name;
            this.network = o.network;
            this.os = o.os;
            this.plugins = _listCopy(o.plugins);
            this.process = o.process;
            this.roles = _listCopy(o.roles);
            this.searchPipelines = o.searchPipelines;
            this.settings = o.settings;
            this.threadPool = _mapCopy(o.threadPool);
            this.totalIndexingBuffer = o.totalIndexingBuffer;
            this.totalIndexingBufferInBytes = o.totalIndexingBufferInBytes;
            this.transport = o.transport;
            this.transportAddress = o.transportAddress;
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.aggregations = _mapCopy(o.aggregations);
            this.attributes = _mapCopy(o.attributes);
            this.buildFlavor = o.buildFlavor;
            this.buildHash = o.buildHash;
            this.buildType = o.buildType;
            this.host = o.host;
            this.http = o.http;
            this.ingest = o.ingest;
            this.ip = o.ip;
            this.jvm = o.jvm;
            this.modules = _listCopy(o.modules);
            this.name = o.name;
            this.network = o.network;
            this.os = o.os;
            this.plugins = _listCopy(o.plugins);
            this.process = o.process;
            this.roles = _listCopy(o.roles);
            this.searchPipelines = o.searchPipelines;
            this.settings = o.settings;
            this.threadPool = _mapCopy(o.threadPool);
            this.totalIndexingBuffer = o.totalIndexingBuffer;
            this.totalIndexingBufferInBytes = o.totalIndexingBufferInBytes;
            this.transport = o.transport;
            this.transportAddress = o.transportAddress;
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Information about available aggregation types.
         * <p>
         * API name: {@code aggregations}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>aggregations</code>.
         * </p>
         */
        @Nonnull
        public final Builder aggregations(Map<String, NodeInfoAggregation> map) {
            this.aggregations = _mapPutAll(this.aggregations, map);
            return this;
        }

        /**
         * Information about available aggregation types.
         * <p>
         * API name: {@code aggregations}
         * </p>
         *
         * <p>
         * Adds an entry to <code>aggregations</code>.
         * </p>
         */
        @Nonnull
        public final Builder aggregations(String key, NodeInfoAggregation value) {
            this.aggregations = _mapPut(this.aggregations, key, value);
            return this;
        }

        /**
         * Information about available aggregation types.
         * <p>
         * API name: {@code aggregations}
         * </p>
         *
         * <p>
         * Adds a value to <code>aggregations</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder aggregations(String key, Function<NodeInfoAggregation.Builder, ObjectBuilder<NodeInfoAggregation>> fn) {
            return aggregations(key, fn.apply(new NodeInfoAggregation.Builder()).build());
        }

        /**
         * The custom attributes of the node.
         * <p>
         * API name: {@code attributes}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>attributes</code>.
         * </p>
         */
        @Nonnull
        public final Builder attributes(Map<String, String> map) {
            this.attributes = _mapPutAll(this.attributes, map);
            return this;
        }

        /**
         * The custom attributes of the node.
         * <p>
         * API name: {@code attributes}
         * </p>
         *
         * <p>
         * Adds an entry to <code>attributes</code>.
         * </p>
         */
        @Nonnull
        public final Builder attributes(String key, String value) {
            this.attributes = _mapPut(this.attributes, key, value);
            return this;
        }

        /**
         * API name: {@code build_flavor}
         */
        @Nonnull
        public final Builder buildFlavor(@Nullable String value) {
            this.buildFlavor = value;
            return this;
        }

        /**
         * Required - Short hash of the last git commit in this release.
         * <p>
         * API name: {@code build_hash}
         * </p>
         */
        @Nonnull
        public final Builder buildHash(String value) {
            this.buildHash = value;
            return this;
        }

        /**
         * Required - The type of build, such as <code>tar</code>, <code>docker</code>, <code>rpm</code>.
         * <p>
         * API name: {@code build_type}
         * </p>
         */
        @Nonnull
        public final Builder buildType(String value) {
            this.buildType = value;
            return this;
        }

        /**
         * API name: {@code host}
         */
        @Nonnull
        public final Builder host(@Nullable String value) {
            this.host = value;
            return this;
        }

        /**
         * API name: {@code http}
         */
        @Nonnull
        public final Builder http(@Nullable NodeInfoHttp value) {
            this.http = value;
            return this;
        }

        /**
         * API name: {@code http}
         */
        @Nonnull
        public final Builder http(Function<NodeInfoHttp.Builder, ObjectBuilder<NodeInfoHttp>> fn) {
            return http(fn.apply(new NodeInfoHttp.Builder()).build());
        }

        /**
         * API name: {@code ingest}
         */
        @Nonnull
        public final Builder ingest(@Nullable NodeInfoIngest value) {
            this.ingest = value;
            return this;
        }

        /**
         * API name: {@code ingest}
         */
        @Nonnull
        public final Builder ingest(Function<NodeInfoIngest.Builder, ObjectBuilder<NodeInfoIngest>> fn) {
            return ingest(fn.apply(new NodeInfoIngest.Builder()).build());
        }

        /**
         * API name: {@code ip}
         */
        @Nonnull
        public final Builder ip(@Nullable String value) {
            this.ip = value;
            return this;
        }

        /**
         * API name: {@code jvm}
         */
        @Nonnull
        public final Builder jvm(@Nullable NodeJvmInfo value) {
            this.jvm = value;
            return this;
        }

        /**
         * API name: {@code jvm}
         */
        @Nonnull
        public final Builder jvm(Function<NodeJvmInfo.Builder, ObjectBuilder<NodeJvmInfo>> fn) {
            return jvm(fn.apply(new NodeJvmInfo.Builder()).build());
        }

        /**
         * The list of modules installed on the node.
         * <p>
         * API name: {@code modules}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>modules</code>.
         * </p>
         */
        @Nonnull
        public final Builder modules(List<PluginStats> list) {
            this.modules = _listAddAll(this.modules, list);
            return this;
        }

        /**
         * The list of modules installed on the node.
         * <p>
         * API name: {@code modules}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>modules</code>.
         * </p>
         */
        @Nonnull
        public final Builder modules(PluginStats value, PluginStats... values) {
            this.modules = _listAdd(this.modules, value, values);
            return this;
        }

        /**
         * The list of modules installed on the node.
         * <p>
         * API name: {@code modules}
         * </p>
         *
         * <p>
         * Adds a value to <code>modules</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder modules(Function<PluginStats.Builder, ObjectBuilder<PluginStats>> fn) {
            return modules(fn.apply(new PluginStats.Builder()).build());
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
         * API name: {@code network}
         */
        @Nonnull
        public final Builder network(@Nullable NodeInfoNetwork value) {
            this.network = value;
            return this;
        }

        /**
         * API name: {@code network}
         */
        @Nonnull
        public final Builder network(Function<NodeInfoNetwork.Builder, ObjectBuilder<NodeInfoNetwork>> fn) {
            return network(fn.apply(new NodeInfoNetwork.Builder()).build());
        }

        /**
         * API name: {@code os}
         */
        @Nonnull
        public final Builder os(@Nullable NodeOperatingSystemInfo value) {
            this.os = value;
            return this;
        }

        /**
         * API name: {@code os}
         */
        @Nonnull
        public final Builder os(Function<NodeOperatingSystemInfo.Builder, ObjectBuilder<NodeOperatingSystemInfo>> fn) {
            return os(fn.apply(new NodeOperatingSystemInfo.Builder()).build());
        }

        /**
         * The list of plugins installed on the node.
         * <p>
         * API name: {@code plugins}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>plugins</code>.
         * </p>
         */
        @Nonnull
        public final Builder plugins(List<PluginStats> list) {
            this.plugins = _listAddAll(this.plugins, list);
            return this;
        }

        /**
         * The list of plugins installed on the node.
         * <p>
         * API name: {@code plugins}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>plugins</code>.
         * </p>
         */
        @Nonnull
        public final Builder plugins(PluginStats value, PluginStats... values) {
            this.plugins = _listAdd(this.plugins, value, values);
            return this;
        }

        /**
         * The list of plugins installed on the node.
         * <p>
         * API name: {@code plugins}
         * </p>
         *
         * <p>
         * Adds a value to <code>plugins</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder plugins(Function<PluginStats.Builder, ObjectBuilder<PluginStats>> fn) {
            return plugins(fn.apply(new PluginStats.Builder()).build());
        }

        /**
         * API name: {@code process}
         */
        @Nonnull
        public final Builder process(@Nullable NodeProcessInfo value) {
            this.process = value;
            return this;
        }

        /**
         * API name: {@code process}
         */
        @Nonnull
        public final Builder process(Function<NodeProcessInfo.Builder, ObjectBuilder<NodeProcessInfo>> fn) {
            return process(fn.apply(new NodeProcessInfo.Builder()).build());
        }

        /**
         * Required - API name: {@code roles}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>roles</code>.
         * </p>
         */
        @Nonnull
        public final Builder roles(List<NodeRole> list) {
            this.roles = _listAddAll(this.roles, list);
            return this;
        }

        /**
         * Required - API name: {@code roles}
         *
         * <p>
         * Adds one or more values to <code>roles</code>.
         * </p>
         */
        @Nonnull
        public final Builder roles(NodeRole value, NodeRole... values) {
            this.roles = _listAdd(this.roles, value, values);
            return this;
        }

        /**
         * API name: {@code search_pipelines}
         */
        @Nonnull
        public final Builder searchPipelines(@Nullable NodeInfoSearchPipelines value) {
            this.searchPipelines = value;
            return this;
        }

        /**
         * API name: {@code search_pipelines}
         */
        @Nonnull
        public final Builder searchPipelines(Function<NodeInfoSearchPipelines.Builder, ObjectBuilder<NodeInfoSearchPipelines>> fn) {
            return searchPipelines(fn.apply(new NodeInfoSearchPipelines.Builder()).build());
        }

        /**
         * API name: {@code settings}
         */
        @Nonnull
        public final Builder settings(@Nullable NodeInfoSettings value) {
            this.settings = value;
            return this;
        }

        /**
         * API name: {@code settings}
         */
        @Nonnull
        public final Builder settings(Function<NodeInfoSettings.Builder, ObjectBuilder<NodeInfoSettings>> fn) {
            return settings(fn.apply(new NodeInfoSettings.Builder()).build());
        }

        /**
         * Information about thread pool configurations.
         * <p>
         * API name: {@code thread_pool}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>threadPool</code>.
         * </p>
         */
        @Nonnull
        public final Builder threadPool(Map<String, NodeThreadPoolInfo> map) {
            this.threadPool = _mapPutAll(this.threadPool, map);
            return this;
        }

        /**
         * Information about thread pool configurations.
         * <p>
         * API name: {@code thread_pool}
         * </p>
         *
         * <p>
         * Adds an entry to <code>threadPool</code>.
         * </p>
         */
        @Nonnull
        public final Builder threadPool(String key, NodeThreadPoolInfo value) {
            this.threadPool = _mapPut(this.threadPool, key, value);
            return this;
        }

        /**
         * Information about thread pool configurations.
         * <p>
         * API name: {@code thread_pool}
         * </p>
         *
         * <p>
         * Adds a value to <code>threadPool</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder threadPool(String key, Function<NodeThreadPoolInfo.Builder, ObjectBuilder<NodeThreadPoolInfo>> fn) {
            return threadPool(key, fn.apply(new NodeThreadPoolInfo.Builder()).build());
        }

        /**
         * Total heap allowed to be used to hold recently indexed documents before they must be written to disk. This size is a shared pool
         * across all shards on this node, and is controlled by Indexing Buffer settings.
         * <p>
         * API name: {@code total_indexing_buffer}
         * </p>
         */
        @Nonnull
        public final Builder totalIndexingBuffer(@Nullable JsonData value) {
            this.totalIndexingBuffer = value;
            return this;
        }

        /**
         * API name: {@code total_indexing_buffer_in_bytes}
         */
        @Nonnull
        public final Builder totalIndexingBufferInBytes(@Nullable JsonData value) {
            this.totalIndexingBufferInBytes = value;
            return this;
        }

        /**
         * API name: {@code transport}
         */
        @Nonnull
        public final Builder transport(@Nullable NodeInfoTransport value) {
            this.transport = value;
            return this;
        }

        /**
         * API name: {@code transport}
         */
        @Nonnull
        public final Builder transport(Function<NodeInfoTransport.Builder, ObjectBuilder<NodeInfoTransport>> fn) {
            return transport(fn.apply(new NodeInfoTransport.Builder()).build());
        }

        /**
         * API name: {@code transport_address}
         */
        @Nonnull
        public final Builder transportAddress(@Nullable String value) {
            this.transportAddress = value;
            return this;
        }

        /**
         * Required - API name: {@code version}
         */
        @Nonnull
        public final Builder version(String value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link NodeInfo}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfo build() {
            _checkSingleUse();

            return new NodeInfo(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfo}
     */
    public static final JsonpDeserializer<NodeInfo> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfo::setupNodeInfoDeserializer
    );

    protected static void setupNodeInfoDeserializer(ObjectDeserializer<NodeInfo.Builder> op) {
        op.add(Builder::aggregations, JsonpDeserializer.stringMapDeserializer(NodeInfoAggregation._DESERIALIZER), "aggregations");
        op.add(Builder::attributes, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "attributes");
        op.add(Builder::buildFlavor, JsonpDeserializer.stringDeserializer(), "build_flavor");
        op.add(Builder::buildHash, JsonpDeserializer.stringDeserializer(), "build_hash");
        op.add(Builder::buildType, JsonpDeserializer.stringDeserializer(), "build_type");
        op.add(Builder::host, JsonpDeserializer.stringDeserializer(), "host");
        op.add(Builder::http, NodeInfoHttp._DESERIALIZER, "http");
        op.add(Builder::ingest, NodeInfoIngest._DESERIALIZER, "ingest");
        op.add(Builder::ip, JsonpDeserializer.stringDeserializer(), "ip");
        op.add(Builder::jvm, NodeJvmInfo._DESERIALIZER, "jvm");
        op.add(Builder::modules, JsonpDeserializer.arrayDeserializer(PluginStats._DESERIALIZER), "modules");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::network, NodeInfoNetwork._DESERIALIZER, "network");
        op.add(Builder::os, NodeOperatingSystemInfo._DESERIALIZER, "os");
        op.add(Builder::plugins, JsonpDeserializer.arrayDeserializer(PluginStats._DESERIALIZER), "plugins");
        op.add(Builder::process, NodeProcessInfo._DESERIALIZER, "process");
        op.add(Builder::roles, JsonpDeserializer.arrayDeserializer(NodeRole._DESERIALIZER), "roles");
        op.add(Builder::searchPipelines, NodeInfoSearchPipelines._DESERIALIZER, "search_pipelines");
        op.add(Builder::settings, NodeInfoSettings._DESERIALIZER, "settings");
        op.add(Builder::threadPool, JsonpDeserializer.stringMapDeserializer(NodeThreadPoolInfo._DESERIALIZER), "thread_pool");
        op.add(Builder::totalIndexingBuffer, JsonData._DESERIALIZER, "total_indexing_buffer");
        op.add(Builder::totalIndexingBufferInBytes, JsonData._DESERIALIZER, "total_indexing_buffer_in_bytes");
        op.add(Builder::transport, NodeInfoTransport._DESERIALIZER, "transport");
        op.add(Builder::transportAddress, JsonpDeserializer.stringDeserializer(), "transport_address");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.aggregations);
        result = 31 * result + Objects.hashCode(this.attributes);
        result = 31 * result + Objects.hashCode(this.buildFlavor);
        result = 31 * result + this.buildHash.hashCode();
        result = 31 * result + this.buildType.hashCode();
        result = 31 * result + Objects.hashCode(this.host);
        result = 31 * result + Objects.hashCode(this.http);
        result = 31 * result + Objects.hashCode(this.ingest);
        result = 31 * result + Objects.hashCode(this.ip);
        result = 31 * result + Objects.hashCode(this.jvm);
        result = 31 * result + Objects.hashCode(this.modules);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Objects.hashCode(this.network);
        result = 31 * result + Objects.hashCode(this.os);
        result = 31 * result + Objects.hashCode(this.plugins);
        result = 31 * result + Objects.hashCode(this.process);
        result = 31 * result + this.roles.hashCode();
        result = 31 * result + Objects.hashCode(this.searchPipelines);
        result = 31 * result + Objects.hashCode(this.settings);
        result = 31 * result + Objects.hashCode(this.threadPool);
        result = 31 * result + Objects.hashCode(this.totalIndexingBuffer);
        result = 31 * result + Objects.hashCode(this.totalIndexingBufferInBytes);
        result = 31 * result + Objects.hashCode(this.transport);
        result = 31 * result + Objects.hashCode(this.transportAddress);
        result = 31 * result + this.version.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfo other = (NodeInfo) o;
        return Objects.equals(this.aggregations, other.aggregations)
            && Objects.equals(this.attributes, other.attributes)
            && Objects.equals(this.buildFlavor, other.buildFlavor)
            && this.buildHash.equals(other.buildHash)
            && this.buildType.equals(other.buildType)
            && Objects.equals(this.host, other.host)
            && Objects.equals(this.http, other.http)
            && Objects.equals(this.ingest, other.ingest)
            && Objects.equals(this.ip, other.ip)
            && Objects.equals(this.jvm, other.jvm)
            && Objects.equals(this.modules, other.modules)
            && this.name.equals(other.name)
            && Objects.equals(this.network, other.network)
            && Objects.equals(this.os, other.os)
            && Objects.equals(this.plugins, other.plugins)
            && Objects.equals(this.process, other.process)
            && this.roles.equals(other.roles)
            && Objects.equals(this.searchPipelines, other.searchPipelines)
            && Objects.equals(this.settings, other.settings)
            && Objects.equals(this.threadPool, other.threadPool)
            && Objects.equals(this.totalIndexingBuffer, other.totalIndexingBuffer)
            && Objects.equals(this.totalIndexingBufferInBytes, other.totalIndexingBufferInBytes)
            && Objects.equals(this.transport, other.transport)
            && Objects.equals(this.transportAddress, other.transportAddress)
            && this.version.equals(other.version);
    }
}
