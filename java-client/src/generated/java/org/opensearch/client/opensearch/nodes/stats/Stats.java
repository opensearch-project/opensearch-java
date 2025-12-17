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

package org.opensearch.client.opensearch.nodes.stats;

import jakarta.json.stream.JsonGenerator;
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
import org.opensearch.client.opensearch._types.NodeRole;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.Stats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Stats implements PlainJsonSerializable, ToCopyableBuilder<Stats.Builder, Stats> {

    @Nonnull
    private final Map<String, AdaptiveSelection> adaptiveSelection;

    @Nullable
    private final ShardAdmissionControlStats admissionControl;

    @Nonnull
    private final Map<String, String> attributes;

    @Nonnull
    private final Map<String, Breaker> breakers;

    @Nonnull
    private final Map<String, CacheStats> caches;

    @Nullable
    private final ShardClusterManagerThrottlingStats clusterManagerThrottling;

    @Nullable
    private final Discovery discovery;

    @Nullable
    private final FileSystem fs;

    @Nullable
    private final String host;

    @Nullable
    private final Http http;

    @Nullable
    private final IndexingPressure indexingPressure;

    @Nullable
    private final NodeIndicesStats indices;

    @Nullable
    private final Ingest ingest;

    @Nonnull
    private final List<String> ip;

    @Nullable
    private final Jvm jvm;

    @Nullable
    private final String name;

    @Nullable
    private final OperatingSystem os;

    @Nullable
    private final Process process;

    @Nullable
    private final RemoteStoreStats remoteStore;

    @Nonnull
    private final List<RepositoryStatsSnapshot> repositories;

    @Nonnull
    private final Map<String, ShardResourceUsageStatsDetail> resourceUsageStats;

    @Nonnull
    private final List<NodeRole> roles;

    @Nullable
    private final ScriptStats script;

    @Nullable
    private final ScriptCacheStats scriptCache;

    @Nullable
    private final ShardSearchBackpressureStats searchBackpressure;

    @Nullable
    private final ShardSearchPipelineStats searchPipeline;

    @Nullable
    private final ShardSegmentReplicationBackpressureStats segmentReplicationBackpressure;

    @Nullable
    private final ShardIndexingPressureStats shardIndexingPressure;

    @Nullable
    private final ShardTaskCancellationStats taskCancellation;

    @Nonnull
    private final Map<String, ThreadCount> threadPool;

    @Nullable
    private final Long timestamp;

    @Nullable
    private final Transport transport;

    @Nullable
    private final String transportAddress;

    @Nullable
    private final ShardWeightedRoutingStats weightedRouting;

    // ---------------------------------------------------------------------------------------------

    private Stats(Builder builder) {
        this.adaptiveSelection = ApiTypeHelper.unmodifiable(builder.adaptiveSelection);
        this.admissionControl = builder.admissionControl;
        this.attributes = ApiTypeHelper.unmodifiable(builder.attributes);
        this.breakers = ApiTypeHelper.unmodifiable(builder.breakers);
        this.caches = ApiTypeHelper.unmodifiable(builder.caches);
        this.clusterManagerThrottling = builder.clusterManagerThrottling;
        this.discovery = builder.discovery;
        this.fs = builder.fs;
        this.host = builder.host;
        this.http = builder.http;
        this.indexingPressure = builder.indexingPressure;
        this.indices = builder.indices;
        this.ingest = builder.ingest;
        this.ip = ApiTypeHelper.unmodifiable(builder.ip);
        this.jvm = builder.jvm;
        this.name = builder.name;
        this.os = builder.os;
        this.process = builder.process;
        this.remoteStore = builder.remoteStore;
        this.repositories = ApiTypeHelper.unmodifiable(builder.repositories);
        this.resourceUsageStats = ApiTypeHelper.unmodifiable(builder.resourceUsageStats);
        this.roles = ApiTypeHelper.unmodifiable(builder.roles);
        this.script = builder.script;
        this.scriptCache = builder.scriptCache;
        this.searchBackpressure = builder.searchBackpressure;
        this.searchPipeline = builder.searchPipeline;
        this.segmentReplicationBackpressure = builder.segmentReplicationBackpressure;
        this.shardIndexingPressure = builder.shardIndexingPressure;
        this.taskCancellation = builder.taskCancellation;
        this.threadPool = ApiTypeHelper.unmodifiable(builder.threadPool);
        this.timestamp = builder.timestamp;
        this.transport = builder.transport;
        this.transportAddress = builder.transportAddress;
        this.weightedRouting = builder.weightedRouting;
    }

    public static Stats of(Function<Stats.Builder, ObjectBuilder<Stats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Statistics about adaptive replica selection.
     * <p>
     * API name: {@code adaptive_selection}
     * </p>
     */
    @Nonnull
    public final Map<String, AdaptiveSelection> adaptiveSelection() {
        return this.adaptiveSelection;
    }

    /**
     * API name: {@code admission_control}
     */
    @Nullable
    public final ShardAdmissionControlStats admissionControl() {
        return this.admissionControl;
    }

    /**
     * Contains a list of attributes for the node.
     * <p>
     * API name: {@code attributes}
     * </p>
     */
    @Nonnull
    public final Map<String, String> attributes() {
        return this.attributes;
    }

    /**
     * Statistics about the field data circuit breaker.
     * <p>
     * API name: {@code breakers}
     * </p>
     */
    @Nonnull
    public final Map<String, Breaker> breakers() {
        return this.breakers;
    }

    /**
     * API name: {@code caches}
     */
    @Nonnull
    public final Map<String, CacheStats> caches() {
        return this.caches;
    }

    /**
     * API name: {@code cluster_manager_throttling}
     */
    @Nullable
    public final ShardClusterManagerThrottlingStats clusterManagerThrottling() {
        return this.clusterManagerThrottling;
    }

    /**
     * API name: {@code discovery}
     */
    @Nullable
    public final Discovery discovery() {
        return this.discovery;
    }

    /**
     * API name: {@code fs}
     */
    @Nullable
    public final FileSystem fs() {
        return this.fs;
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
    public final Http http() {
        return this.http;
    }

    /**
     * API name: {@code indexing_pressure}
     */
    @Nullable
    public final IndexingPressure indexingPressure() {
        return this.indexingPressure;
    }

    /**
     * API name: {@code indices}
     */
    @Nullable
    public final NodeIndicesStats indices() {
        return this.indices;
    }

    /**
     * API name: {@code ingest}
     */
    @Nullable
    public final Ingest ingest() {
        return this.ingest;
    }

    /**
     * IP address and port for the node.
     * <p>
     * API name: {@code ip}
     * </p>
     */
    @Nonnull
    public final List<String> ip() {
        return this.ip;
    }

    /**
     * API name: {@code jvm}
     */
    @Nullable
    public final Jvm jvm() {
        return this.jvm;
    }

    /**
     * API name: {@code name}
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code os}
     */
    @Nullable
    public final OperatingSystem os() {
        return this.os;
    }

    /**
     * API name: {@code process}
     */
    @Nullable
    public final Process process() {
        return this.process;
    }

    /**
     * API name: {@code remote_store}
     */
    @Nullable
    public final RemoteStoreStats remoteStore() {
        return this.remoteStore;
    }

    /**
     * API name: {@code repositories}
     */
    @Nonnull
    public final List<RepositoryStatsSnapshot> repositories() {
        return this.repositories;
    }

    /**
     * API name: {@code resource_usage_stats}
     */
    @Nonnull
    public final Map<String, ShardResourceUsageStatsDetail> resourceUsageStats() {
        return this.resourceUsageStats;
    }

    /**
     * API name: {@code roles}
     */
    @Nonnull
    public final List<NodeRole> roles() {
        return this.roles;
    }

    /**
     * API name: {@code script}
     */
    @Nullable
    public final ScriptStats script() {
        return this.script;
    }

    /**
     * API name: {@code script_cache}
     */
    @Nullable
    public final ScriptCacheStats scriptCache() {
        return this.scriptCache;
    }

    /**
     * API name: {@code search_backpressure}
     */
    @Nullable
    public final ShardSearchBackpressureStats searchBackpressure() {
        return this.searchBackpressure;
    }

    /**
     * API name: {@code search_pipeline}
     */
    @Nullable
    public final ShardSearchPipelineStats searchPipeline() {
        return this.searchPipeline;
    }

    /**
     * API name: {@code segment_replication_backpressure}
     */
    @Nullable
    public final ShardSegmentReplicationBackpressureStats segmentReplicationBackpressure() {
        return this.segmentReplicationBackpressure;
    }

    /**
     * API name: {@code shard_indexing_pressure}
     */
    @Nullable
    public final ShardIndexingPressureStats shardIndexingPressure() {
        return this.shardIndexingPressure;
    }

    /**
     * API name: {@code task_cancellation}
     */
    @Nullable
    public final ShardTaskCancellationStats taskCancellation() {
        return this.taskCancellation;
    }

    /**
     * Statistics about each thread pool, including current size, queue and rejected tasks.
     * <p>
     * API name: {@code thread_pool}
     * </p>
     */
    @Nonnull
    public final Map<String, ThreadCount> threadPool() {
        return this.threadPool;
    }

    /**
     * API name: {@code timestamp}
     */
    @Nullable
    public final Long timestamp() {
        return this.timestamp;
    }

    /**
     * API name: {@code transport}
     */
    @Nullable
    public final Transport transport() {
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
     * API name: {@code weighted_routing}
     */
    @Nullable
    public final ShardWeightedRoutingStats weightedRouting() {
        return this.weightedRouting;
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
        if (ApiTypeHelper.isDefined(this.adaptiveSelection)) {
            generator.writeKey("adaptive_selection");
            generator.writeStartObject();
            for (Map.Entry<String, AdaptiveSelection> item0 : this.adaptiveSelection.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.admissionControl != null) {
            generator.writeKey("admission_control");
            this.admissionControl.serialize(generator, mapper);
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

        if (ApiTypeHelper.isDefined(this.breakers)) {
            generator.writeKey("breakers");
            generator.writeStartObject();
            for (Map.Entry<String, Breaker> item0 : this.breakers.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.caches)) {
            generator.writeKey("caches");
            generator.writeStartObject();
            for (Map.Entry<String, CacheStats> item0 : this.caches.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.clusterManagerThrottling != null) {
            generator.writeKey("cluster_manager_throttling");
            this.clusterManagerThrottling.serialize(generator, mapper);
        }

        if (this.discovery != null) {
            generator.writeKey("discovery");
            this.discovery.serialize(generator, mapper);
        }

        if (this.fs != null) {
            generator.writeKey("fs");
            this.fs.serialize(generator, mapper);
        }

        if (this.host != null) {
            generator.writeKey("host");
            generator.write(this.host);
        }

        if (this.http != null) {
            generator.writeKey("http");
            this.http.serialize(generator, mapper);
        }

        if (this.indexingPressure != null) {
            generator.writeKey("indexing_pressure");
            this.indexingPressure.serialize(generator, mapper);
        }

        if (this.indices != null) {
            generator.writeKey("indices");
            this.indices.serialize(generator, mapper);
        }

        if (this.ingest != null) {
            generator.writeKey("ingest");
            this.ingest.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.ip)) {
            generator.writeKey("ip");
            generator.writeStartArray();
            for (String item0 : this.ip) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.jvm != null) {
            generator.writeKey("jvm");
            this.jvm.serialize(generator, mapper);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (this.os != null) {
            generator.writeKey("os");
            this.os.serialize(generator, mapper);
        }

        if (this.process != null) {
            generator.writeKey("process");
            this.process.serialize(generator, mapper);
        }

        if (this.remoteStore != null) {
            generator.writeKey("remote_store");
            this.remoteStore.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.repositories)) {
            generator.writeKey("repositories");
            generator.writeStartArray();
            for (RepositoryStatsSnapshot item0 : this.repositories) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.resourceUsageStats)) {
            generator.writeKey("resource_usage_stats");
            generator.writeStartObject();
            for (Map.Entry<String, ShardResourceUsageStatsDetail> item0 : this.resourceUsageStats.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.roles)) {
            generator.writeKey("roles");
            generator.writeStartArray();
            for (NodeRole item0 : this.roles) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.script != null) {
            generator.writeKey("script");
            this.script.serialize(generator, mapper);
        }

        if (this.scriptCache != null) {
            generator.writeKey("script_cache");
            this.scriptCache.serialize(generator, mapper);
        }

        if (this.searchBackpressure != null) {
            generator.writeKey("search_backpressure");
            this.searchBackpressure.serialize(generator, mapper);
        }

        if (this.searchPipeline != null) {
            generator.writeKey("search_pipeline");
            this.searchPipeline.serialize(generator, mapper);
        }

        if (this.segmentReplicationBackpressure != null) {
            generator.writeKey("segment_replication_backpressure");
            this.segmentReplicationBackpressure.serialize(generator, mapper);
        }

        if (this.shardIndexingPressure != null) {
            generator.writeKey("shard_indexing_pressure");
            this.shardIndexingPressure.serialize(generator, mapper);
        }

        if (this.taskCancellation != null) {
            generator.writeKey("task_cancellation");
            this.taskCancellation.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.threadPool)) {
            generator.writeKey("thread_pool");
            generator.writeStartObject();
            for (Map.Entry<String, ThreadCount> item0 : this.threadPool.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.timestamp != null) {
            generator.writeKey("timestamp");
            generator.write(this.timestamp);
        }

        if (this.transport != null) {
            generator.writeKey("transport");
            this.transport.serialize(generator, mapper);
        }

        if (this.transportAddress != null) {
            generator.writeKey("transport_address");
            generator.write(this.transportAddress);
        }

        if (this.weightedRouting != null) {
            generator.writeKey("weighted_routing");
            this.weightedRouting.serialize(generator, mapper);
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
     * Builder for {@link Stats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Stats> {
        @Nullable
        private Map<String, AdaptiveSelection> adaptiveSelection;
        @Nullable
        private ShardAdmissionControlStats admissionControl;
        @Nullable
        private Map<String, String> attributes;
        @Nullable
        private Map<String, Breaker> breakers;
        @Nullable
        private Map<String, CacheStats> caches;
        @Nullable
        private ShardClusterManagerThrottlingStats clusterManagerThrottling;
        @Nullable
        private Discovery discovery;
        @Nullable
        private FileSystem fs;
        @Nullable
        private String host;
        @Nullable
        private Http http;
        @Nullable
        private IndexingPressure indexingPressure;
        @Nullable
        private NodeIndicesStats indices;
        @Nullable
        private Ingest ingest;
        @Nullable
        private List<String> ip;
        @Nullable
        private Jvm jvm;
        @Nullable
        private String name;
        @Nullable
        private OperatingSystem os;
        @Nullable
        private Process process;
        @Nullable
        private RemoteStoreStats remoteStore;
        @Nullable
        private List<RepositoryStatsSnapshot> repositories;
        @Nullable
        private Map<String, ShardResourceUsageStatsDetail> resourceUsageStats;
        @Nullable
        private List<NodeRole> roles;
        @Nullable
        private ScriptStats script;
        @Nullable
        private ScriptCacheStats scriptCache;
        @Nullable
        private ShardSearchBackpressureStats searchBackpressure;
        @Nullable
        private ShardSearchPipelineStats searchPipeline;
        @Nullable
        private ShardSegmentReplicationBackpressureStats segmentReplicationBackpressure;
        @Nullable
        private ShardIndexingPressureStats shardIndexingPressure;
        @Nullable
        private ShardTaskCancellationStats taskCancellation;
        @Nullable
        private Map<String, ThreadCount> threadPool;
        @Nullable
        private Long timestamp;
        @Nullable
        private Transport transport;
        @Nullable
        private String transportAddress;
        @Nullable
        private ShardWeightedRoutingStats weightedRouting;

        public Builder() {}

        private Builder(Stats o) {
            this.adaptiveSelection = _mapCopy(o.adaptiveSelection);
            this.admissionControl = o.admissionControl;
            this.attributes = _mapCopy(o.attributes);
            this.breakers = _mapCopy(o.breakers);
            this.caches = _mapCopy(o.caches);
            this.clusterManagerThrottling = o.clusterManagerThrottling;
            this.discovery = o.discovery;
            this.fs = o.fs;
            this.host = o.host;
            this.http = o.http;
            this.indexingPressure = o.indexingPressure;
            this.indices = o.indices;
            this.ingest = o.ingest;
            this.ip = _listCopy(o.ip);
            this.jvm = o.jvm;
            this.name = o.name;
            this.os = o.os;
            this.process = o.process;
            this.remoteStore = o.remoteStore;
            this.repositories = _listCopy(o.repositories);
            this.resourceUsageStats = _mapCopy(o.resourceUsageStats);
            this.roles = _listCopy(o.roles);
            this.script = o.script;
            this.scriptCache = o.scriptCache;
            this.searchBackpressure = o.searchBackpressure;
            this.searchPipeline = o.searchPipeline;
            this.segmentReplicationBackpressure = o.segmentReplicationBackpressure;
            this.shardIndexingPressure = o.shardIndexingPressure;
            this.taskCancellation = o.taskCancellation;
            this.threadPool = _mapCopy(o.threadPool);
            this.timestamp = o.timestamp;
            this.transport = o.transport;
            this.transportAddress = o.transportAddress;
            this.weightedRouting = o.weightedRouting;
        }

        private Builder(Builder o) {
            this.adaptiveSelection = _mapCopy(o.adaptiveSelection);
            this.admissionControl = o.admissionControl;
            this.attributes = _mapCopy(o.attributes);
            this.breakers = _mapCopy(o.breakers);
            this.caches = _mapCopy(o.caches);
            this.clusterManagerThrottling = o.clusterManagerThrottling;
            this.discovery = o.discovery;
            this.fs = o.fs;
            this.host = o.host;
            this.http = o.http;
            this.indexingPressure = o.indexingPressure;
            this.indices = o.indices;
            this.ingest = o.ingest;
            this.ip = _listCopy(o.ip);
            this.jvm = o.jvm;
            this.name = o.name;
            this.os = o.os;
            this.process = o.process;
            this.remoteStore = o.remoteStore;
            this.repositories = _listCopy(o.repositories);
            this.resourceUsageStats = _mapCopy(o.resourceUsageStats);
            this.roles = _listCopy(o.roles);
            this.script = o.script;
            this.scriptCache = o.scriptCache;
            this.searchBackpressure = o.searchBackpressure;
            this.searchPipeline = o.searchPipeline;
            this.segmentReplicationBackpressure = o.segmentReplicationBackpressure;
            this.shardIndexingPressure = o.shardIndexingPressure;
            this.taskCancellation = o.taskCancellation;
            this.threadPool = _mapCopy(o.threadPool);
            this.timestamp = o.timestamp;
            this.transport = o.transport;
            this.transportAddress = o.transportAddress;
            this.weightedRouting = o.weightedRouting;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Statistics about adaptive replica selection.
         * <p>
         * API name: {@code adaptive_selection}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>adaptiveSelection</code>.
         * </p>
         */
        @Nonnull
        public final Builder adaptiveSelection(Map<String, AdaptiveSelection> map) {
            this.adaptiveSelection = _mapPutAll(this.adaptiveSelection, map);
            return this;
        }

        /**
         * Statistics about adaptive replica selection.
         * <p>
         * API name: {@code adaptive_selection}
         * </p>
         *
         * <p>
         * Adds an entry to <code>adaptiveSelection</code>.
         * </p>
         */
        @Nonnull
        public final Builder adaptiveSelection(String key, AdaptiveSelection value) {
            this.adaptiveSelection = _mapPut(this.adaptiveSelection, key, value);
            return this;
        }

        /**
         * Statistics about adaptive replica selection.
         * <p>
         * API name: {@code adaptive_selection}
         * </p>
         *
         * <p>
         * Adds a value to <code>adaptiveSelection</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder adaptiveSelection(String key, Function<AdaptiveSelection.Builder, ObjectBuilder<AdaptiveSelection>> fn) {
            return adaptiveSelection(key, fn.apply(new AdaptiveSelection.Builder()).build());
        }

        /**
         * API name: {@code admission_control}
         */
        @Nonnull
        public final Builder admissionControl(@Nullable ShardAdmissionControlStats value) {
            this.admissionControl = value;
            return this;
        }

        /**
         * API name: {@code admission_control}
         */
        @Nonnull
        public final Builder admissionControl(Function<ShardAdmissionControlStats.Builder, ObjectBuilder<ShardAdmissionControlStats>> fn) {
            return admissionControl(fn.apply(new ShardAdmissionControlStats.Builder()).build());
        }

        /**
         * Contains a list of attributes for the node.
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
         * Contains a list of attributes for the node.
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
         * Statistics about the field data circuit breaker.
         * <p>
         * API name: {@code breakers}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>breakers</code>.
         * </p>
         */
        @Nonnull
        public final Builder breakers(Map<String, Breaker> map) {
            this.breakers = _mapPutAll(this.breakers, map);
            return this;
        }

        /**
         * Statistics about the field data circuit breaker.
         * <p>
         * API name: {@code breakers}
         * </p>
         *
         * <p>
         * Adds an entry to <code>breakers</code>.
         * </p>
         */
        @Nonnull
        public final Builder breakers(String key, Breaker value) {
            this.breakers = _mapPut(this.breakers, key, value);
            return this;
        }

        /**
         * Statistics about the field data circuit breaker.
         * <p>
         * API name: {@code breakers}
         * </p>
         *
         * <p>
         * Adds a value to <code>breakers</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder breakers(String key, Function<Breaker.Builder, ObjectBuilder<Breaker>> fn) {
            return breakers(key, fn.apply(new Breaker.Builder()).build());
        }

        /**
         * API name: {@code caches}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>caches</code>.
         * </p>
         */
        @Nonnull
        public final Builder caches(Map<String, CacheStats> map) {
            this.caches = _mapPutAll(this.caches, map);
            return this;
        }

        /**
         * API name: {@code caches}
         *
         * <p>
         * Adds an entry to <code>caches</code>.
         * </p>
         */
        @Nonnull
        public final Builder caches(String key, CacheStats value) {
            this.caches = _mapPut(this.caches, key, value);
            return this;
        }

        /**
         * API name: {@code caches}
         *
         * <p>
         * Adds a value to <code>caches</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder caches(String key, Function<CacheStats.Builder, ObjectBuilder<CacheStats>> fn) {
            return caches(key, fn.apply(new CacheStats.Builder()).build());
        }

        /**
         * API name: {@code cluster_manager_throttling}
         */
        @Nonnull
        public final Builder clusterManagerThrottling(@Nullable ShardClusterManagerThrottlingStats value) {
            this.clusterManagerThrottling = value;
            return this;
        }

        /**
         * API name: {@code cluster_manager_throttling}
         */
        @Nonnull
        public final Builder clusterManagerThrottling(
            Function<ShardClusterManagerThrottlingStats.Builder, ObjectBuilder<ShardClusterManagerThrottlingStats>> fn
        ) {
            return clusterManagerThrottling(fn.apply(new ShardClusterManagerThrottlingStats.Builder()).build());
        }

        /**
         * API name: {@code discovery}
         */
        @Nonnull
        public final Builder discovery(@Nullable Discovery value) {
            this.discovery = value;
            return this;
        }

        /**
         * API name: {@code discovery}
         */
        @Nonnull
        public final Builder discovery(Function<Discovery.Builder, ObjectBuilder<Discovery>> fn) {
            return discovery(fn.apply(new Discovery.Builder()).build());
        }

        /**
         * API name: {@code fs}
         */
        @Nonnull
        public final Builder fs(@Nullable FileSystem value) {
            this.fs = value;
            return this;
        }

        /**
         * API name: {@code fs}
         */
        @Nonnull
        public final Builder fs(Function<FileSystem.Builder, ObjectBuilder<FileSystem>> fn) {
            return fs(fn.apply(new FileSystem.Builder()).build());
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
        public final Builder http(@Nullable Http value) {
            this.http = value;
            return this;
        }

        /**
         * API name: {@code http}
         */
        @Nonnull
        public final Builder http(Function<Http.Builder, ObjectBuilder<Http>> fn) {
            return http(fn.apply(new Http.Builder()).build());
        }

        /**
         * API name: {@code indexing_pressure}
         */
        @Nonnull
        public final Builder indexingPressure(@Nullable IndexingPressure value) {
            this.indexingPressure = value;
            return this;
        }

        /**
         * API name: {@code indexing_pressure}
         */
        @Nonnull
        public final Builder indexingPressure(Function<IndexingPressure.Builder, ObjectBuilder<IndexingPressure>> fn) {
            return indexingPressure(fn.apply(new IndexingPressure.Builder()).build());
        }

        /**
         * API name: {@code indices}
         */
        @Nonnull
        public final Builder indices(@Nullable NodeIndicesStats value) {
            this.indices = value;
            return this;
        }

        /**
         * API name: {@code indices}
         */
        @Nonnull
        public final Builder indices(Function<NodeIndicesStats.Builder, ObjectBuilder<NodeIndicesStats>> fn) {
            return indices(fn.apply(new NodeIndicesStats.Builder()).build());
        }

        /**
         * API name: {@code ingest}
         */
        @Nonnull
        public final Builder ingest(@Nullable Ingest value) {
            this.ingest = value;
            return this;
        }

        /**
         * API name: {@code ingest}
         */
        @Nonnull
        public final Builder ingest(Function<Ingest.Builder, ObjectBuilder<Ingest>> fn) {
            return ingest(fn.apply(new Ingest.Builder()).build());
        }

        /**
         * IP address and port for the node.
         * <p>
         * API name: {@code ip}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>ip</code>.
         * </p>
         */
        @Nonnull
        public final Builder ip(List<String> list) {
            this.ip = _listAddAll(this.ip, list);
            return this;
        }

        /**
         * IP address and port for the node.
         * <p>
         * API name: {@code ip}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>ip</code>.
         * </p>
         */
        @Nonnull
        public final Builder ip(String value, String... values) {
            this.ip = _listAdd(this.ip, value, values);
            return this;
        }

        /**
         * API name: {@code jvm}
         */
        @Nonnull
        public final Builder jvm(@Nullable Jvm value) {
            this.jvm = value;
            return this;
        }

        /**
         * API name: {@code jvm}
         */
        @Nonnull
        public final Builder jvm(Function<Jvm.Builder, ObjectBuilder<Jvm>> fn) {
            return jvm(fn.apply(new Jvm.Builder()).build());
        }

        /**
         * API name: {@code name}
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * API name: {@code os}
         */
        @Nonnull
        public final Builder os(@Nullable OperatingSystem value) {
            this.os = value;
            return this;
        }

        /**
         * API name: {@code os}
         */
        @Nonnull
        public final Builder os(Function<OperatingSystem.Builder, ObjectBuilder<OperatingSystem>> fn) {
            return os(fn.apply(new OperatingSystem.Builder()).build());
        }

        /**
         * API name: {@code process}
         */
        @Nonnull
        public final Builder process(@Nullable Process value) {
            this.process = value;
            return this;
        }

        /**
         * API name: {@code process}
         */
        @Nonnull
        public final Builder process(Function<Process.Builder, ObjectBuilder<Process>> fn) {
            return process(fn.apply(new Process.Builder()).build());
        }

        /**
         * API name: {@code remote_store}
         */
        @Nonnull
        public final Builder remoteStore(@Nullable RemoteStoreStats value) {
            this.remoteStore = value;
            return this;
        }

        /**
         * API name: {@code remote_store}
         */
        @Nonnull
        public final Builder remoteStore(Function<RemoteStoreStats.Builder, ObjectBuilder<RemoteStoreStats>> fn) {
            return remoteStore(fn.apply(new RemoteStoreStats.Builder()).build());
        }

        /**
         * API name: {@code repositories}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>repositories</code>.
         * </p>
         */
        @Nonnull
        public final Builder repositories(List<RepositoryStatsSnapshot> list) {
            this.repositories = _listAddAll(this.repositories, list);
            return this;
        }

        /**
         * API name: {@code repositories}
         *
         * <p>
         * Adds one or more values to <code>repositories</code>.
         * </p>
         */
        @Nonnull
        public final Builder repositories(RepositoryStatsSnapshot value, RepositoryStatsSnapshot... values) {
            this.repositories = _listAdd(this.repositories, value, values);
            return this;
        }

        /**
         * API name: {@code repositories}
         *
         * <p>
         * Adds a value to <code>repositories</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder repositories(Function<RepositoryStatsSnapshot.Builder, ObjectBuilder<RepositoryStatsSnapshot>> fn) {
            return repositories(fn.apply(new RepositoryStatsSnapshot.Builder()).build());
        }

        /**
         * API name: {@code resource_usage_stats}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>resourceUsageStats</code>.
         * </p>
         */
        @Nonnull
        public final Builder resourceUsageStats(Map<String, ShardResourceUsageStatsDetail> map) {
            this.resourceUsageStats = _mapPutAll(this.resourceUsageStats, map);
            return this;
        }

        /**
         * API name: {@code resource_usage_stats}
         *
         * <p>
         * Adds an entry to <code>resourceUsageStats</code>.
         * </p>
         */
        @Nonnull
        public final Builder resourceUsageStats(String key, ShardResourceUsageStatsDetail value) {
            this.resourceUsageStats = _mapPut(this.resourceUsageStats, key, value);
            return this;
        }

        /**
         * API name: {@code resource_usage_stats}
         *
         * <p>
         * Adds a value to <code>resourceUsageStats</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder resourceUsageStats(
            String key,
            Function<ShardResourceUsageStatsDetail.Builder, ObjectBuilder<ShardResourceUsageStatsDetail>> fn
        ) {
            return resourceUsageStats(key, fn.apply(new ShardResourceUsageStatsDetail.Builder()).build());
        }

        /**
         * API name: {@code roles}
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
         * API name: {@code roles}
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
         * API name: {@code script}
         */
        @Nonnull
        public final Builder script(@Nullable ScriptStats value) {
            this.script = value;
            return this;
        }

        /**
         * API name: {@code script}
         */
        @Nonnull
        public final Builder script(Function<ScriptStats.Builder, ObjectBuilder<ScriptStats>> fn) {
            return script(fn.apply(new ScriptStats.Builder()).build());
        }

        /**
         * API name: {@code script_cache}
         */
        @Nonnull
        public final Builder scriptCache(@Nullable ScriptCacheStats value) {
            this.scriptCache = value;
            return this;
        }

        /**
         * API name: {@code script_cache}
         */
        @Nonnull
        public final Builder scriptCache(Function<ScriptCacheStats.Builder, ObjectBuilder<ScriptCacheStats>> fn) {
            return scriptCache(fn.apply(new ScriptCacheStats.Builder()).build());
        }

        /**
         * API name: {@code search_backpressure}
         */
        @Nonnull
        public final Builder searchBackpressure(@Nullable ShardSearchBackpressureStats value) {
            this.searchBackpressure = value;
            return this;
        }

        /**
         * API name: {@code search_backpressure}
         */
        @Nonnull
        public final Builder searchBackpressure(
            Function<ShardSearchBackpressureStats.Builder, ObjectBuilder<ShardSearchBackpressureStats>> fn
        ) {
            return searchBackpressure(fn.apply(new ShardSearchBackpressureStats.Builder()).build());
        }

        /**
         * API name: {@code search_pipeline}
         */
        @Nonnull
        public final Builder searchPipeline(@Nullable ShardSearchPipelineStats value) {
            this.searchPipeline = value;
            return this;
        }

        /**
         * API name: {@code search_pipeline}
         */
        @Nonnull
        public final Builder searchPipeline(Function<ShardSearchPipelineStats.Builder, ObjectBuilder<ShardSearchPipelineStats>> fn) {
            return searchPipeline(fn.apply(new ShardSearchPipelineStats.Builder()).build());
        }

        /**
         * API name: {@code segment_replication_backpressure}
         */
        @Nonnull
        public final Builder segmentReplicationBackpressure(@Nullable ShardSegmentReplicationBackpressureStats value) {
            this.segmentReplicationBackpressure = value;
            return this;
        }

        /**
         * API name: {@code segment_replication_backpressure}
         */
        @Nonnull
        public final Builder segmentReplicationBackpressure(
            Function<ShardSegmentReplicationBackpressureStats.Builder, ObjectBuilder<ShardSegmentReplicationBackpressureStats>> fn
        ) {
            return segmentReplicationBackpressure(fn.apply(new ShardSegmentReplicationBackpressureStats.Builder()).build());
        }

        /**
         * API name: {@code shard_indexing_pressure}
         */
        @Nonnull
        public final Builder shardIndexingPressure(@Nullable ShardIndexingPressureStats value) {
            this.shardIndexingPressure = value;
            return this;
        }

        /**
         * API name: {@code shard_indexing_pressure}
         */
        @Nonnull
        public final Builder shardIndexingPressure(
            Function<ShardIndexingPressureStats.Builder, ObjectBuilder<ShardIndexingPressureStats>> fn
        ) {
            return shardIndexingPressure(fn.apply(new ShardIndexingPressureStats.Builder()).build());
        }

        /**
         * API name: {@code task_cancellation}
         */
        @Nonnull
        public final Builder taskCancellation(@Nullable ShardTaskCancellationStats value) {
            this.taskCancellation = value;
            return this;
        }

        /**
         * API name: {@code task_cancellation}
         */
        @Nonnull
        public final Builder taskCancellation(Function<ShardTaskCancellationStats.Builder, ObjectBuilder<ShardTaskCancellationStats>> fn) {
            return taskCancellation(fn.apply(new ShardTaskCancellationStats.Builder()).build());
        }

        /**
         * Statistics about each thread pool, including current size, queue and rejected tasks.
         * <p>
         * API name: {@code thread_pool}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>threadPool</code>.
         * </p>
         */
        @Nonnull
        public final Builder threadPool(Map<String, ThreadCount> map) {
            this.threadPool = _mapPutAll(this.threadPool, map);
            return this;
        }

        /**
         * Statistics about each thread pool, including current size, queue and rejected tasks.
         * <p>
         * API name: {@code thread_pool}
         * </p>
         *
         * <p>
         * Adds an entry to <code>threadPool</code>.
         * </p>
         */
        @Nonnull
        public final Builder threadPool(String key, ThreadCount value) {
            this.threadPool = _mapPut(this.threadPool, key, value);
            return this;
        }

        /**
         * Statistics about each thread pool, including current size, queue and rejected tasks.
         * <p>
         * API name: {@code thread_pool}
         * </p>
         *
         * <p>
         * Adds a value to <code>threadPool</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder threadPool(String key, Function<ThreadCount.Builder, ObjectBuilder<ThreadCount>> fn) {
            return threadPool(key, fn.apply(new ThreadCount.Builder()).build());
        }

        /**
         * API name: {@code timestamp}
         */
        @Nonnull
        public final Builder timestamp(@Nullable Long value) {
            this.timestamp = value;
            return this;
        }

        /**
         * API name: {@code transport}
         */
        @Nonnull
        public final Builder transport(@Nullable Transport value) {
            this.transport = value;
            return this;
        }

        /**
         * API name: {@code transport}
         */
        @Nonnull
        public final Builder transport(Function<Transport.Builder, ObjectBuilder<Transport>> fn) {
            return transport(fn.apply(new Transport.Builder()).build());
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
         * API name: {@code weighted_routing}
         */
        @Nonnull
        public final Builder weightedRouting(@Nullable ShardWeightedRoutingStats value) {
            this.weightedRouting = value;
            return this;
        }

        /**
         * API name: {@code weighted_routing}
         */
        @Nonnull
        public final Builder weightedRouting(Function<ShardWeightedRoutingStats.Builder, ObjectBuilder<ShardWeightedRoutingStats>> fn) {
            return weightedRouting(fn.apply(new ShardWeightedRoutingStats.Builder()).build());
        }

        /**
         * Builds a {@link Stats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Stats build() {
            _checkSingleUse();

            return new Stats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Stats}
     */
    public static final JsonpDeserializer<Stats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Stats::setupStatsDeserializer
    );

    protected static void setupStatsDeserializer(ObjectDeserializer<Stats.Builder> op) {
        op.add(Builder::adaptiveSelection, JsonpDeserializer.stringMapDeserializer(AdaptiveSelection._DESERIALIZER), "adaptive_selection");
        op.add(Builder::admissionControl, ShardAdmissionControlStats._DESERIALIZER, "admission_control");
        op.add(Builder::attributes, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "attributes");
        op.add(Builder::breakers, JsonpDeserializer.stringMapDeserializer(Breaker._DESERIALIZER), "breakers");
        op.add(Builder::caches, JsonpDeserializer.stringMapDeserializer(CacheStats._DESERIALIZER), "caches");
        op.add(Builder::clusterManagerThrottling, ShardClusterManagerThrottlingStats._DESERIALIZER, "cluster_manager_throttling");
        op.add(Builder::discovery, Discovery._DESERIALIZER, "discovery");
        op.add(Builder::fs, FileSystem._DESERIALIZER, "fs");
        op.add(Builder::host, JsonpDeserializer.stringDeserializer(), "host");
        op.add(Builder::http, Http._DESERIALIZER, "http");
        op.add(Builder::indexingPressure, IndexingPressure._DESERIALIZER, "indexing_pressure");
        op.add(Builder::indices, NodeIndicesStats._DESERIALIZER, "indices");
        op.add(Builder::ingest, Ingest._DESERIALIZER, "ingest");
        op.add(Builder::ip, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "ip");
        op.add(Builder::jvm, Jvm._DESERIALIZER, "jvm");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::os, OperatingSystem._DESERIALIZER, "os");
        op.add(Builder::process, Process._DESERIALIZER, "process");
        op.add(Builder::remoteStore, RemoteStoreStats._DESERIALIZER, "remote_store");
        op.add(Builder::repositories, JsonpDeserializer.arrayDeserializer(RepositoryStatsSnapshot._DESERIALIZER), "repositories");
        op.add(
            Builder::resourceUsageStats,
            JsonpDeserializer.stringMapDeserializer(ShardResourceUsageStatsDetail._DESERIALIZER),
            "resource_usage_stats"
        );
        op.add(Builder::roles, JsonpDeserializer.arrayDeserializer(NodeRole._DESERIALIZER), "roles");
        op.add(Builder::script, ScriptStats._DESERIALIZER, "script");
        op.add(Builder::scriptCache, ScriptCacheStats._DESERIALIZER, "script_cache");
        op.add(Builder::searchBackpressure, ShardSearchBackpressureStats._DESERIALIZER, "search_backpressure");
        op.add(Builder::searchPipeline, ShardSearchPipelineStats._DESERIALIZER, "search_pipeline");
        op.add(
            Builder::segmentReplicationBackpressure,
            ShardSegmentReplicationBackpressureStats._DESERIALIZER,
            "segment_replication_backpressure"
        );
        op.add(Builder::shardIndexingPressure, ShardIndexingPressureStats._DESERIALIZER, "shard_indexing_pressure");
        op.add(Builder::taskCancellation, ShardTaskCancellationStats._DESERIALIZER, "task_cancellation");
        op.add(Builder::threadPool, JsonpDeserializer.stringMapDeserializer(ThreadCount._DESERIALIZER), "thread_pool");
        op.add(Builder::timestamp, JsonpDeserializer.longDeserializer(), "timestamp");
        op.add(Builder::transport, Transport._DESERIALIZER, "transport");
        op.add(Builder::transportAddress, JsonpDeserializer.stringDeserializer(), "transport_address");
        op.add(Builder::weightedRouting, ShardWeightedRoutingStats._DESERIALIZER, "weighted_routing");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.adaptiveSelection);
        result = 31 * result + Objects.hashCode(this.admissionControl);
        result = 31 * result + Objects.hashCode(this.attributes);
        result = 31 * result + Objects.hashCode(this.breakers);
        result = 31 * result + Objects.hashCode(this.caches);
        result = 31 * result + Objects.hashCode(this.clusterManagerThrottling);
        result = 31 * result + Objects.hashCode(this.discovery);
        result = 31 * result + Objects.hashCode(this.fs);
        result = 31 * result + Objects.hashCode(this.host);
        result = 31 * result + Objects.hashCode(this.http);
        result = 31 * result + Objects.hashCode(this.indexingPressure);
        result = 31 * result + Objects.hashCode(this.indices);
        result = 31 * result + Objects.hashCode(this.ingest);
        result = 31 * result + Objects.hashCode(this.ip);
        result = 31 * result + Objects.hashCode(this.jvm);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.os);
        result = 31 * result + Objects.hashCode(this.process);
        result = 31 * result + Objects.hashCode(this.remoteStore);
        result = 31 * result + Objects.hashCode(this.repositories);
        result = 31 * result + Objects.hashCode(this.resourceUsageStats);
        result = 31 * result + Objects.hashCode(this.roles);
        result = 31 * result + Objects.hashCode(this.script);
        result = 31 * result + Objects.hashCode(this.scriptCache);
        result = 31 * result + Objects.hashCode(this.searchBackpressure);
        result = 31 * result + Objects.hashCode(this.searchPipeline);
        result = 31 * result + Objects.hashCode(this.segmentReplicationBackpressure);
        result = 31 * result + Objects.hashCode(this.shardIndexingPressure);
        result = 31 * result + Objects.hashCode(this.taskCancellation);
        result = 31 * result + Objects.hashCode(this.threadPool);
        result = 31 * result + Objects.hashCode(this.timestamp);
        result = 31 * result + Objects.hashCode(this.transport);
        result = 31 * result + Objects.hashCode(this.transportAddress);
        result = 31 * result + Objects.hashCode(this.weightedRouting);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Stats other = (Stats) o;
        return Objects.equals(this.adaptiveSelection, other.adaptiveSelection)
            && Objects.equals(this.admissionControl, other.admissionControl)
            && Objects.equals(this.attributes, other.attributes)
            && Objects.equals(this.breakers, other.breakers)
            && Objects.equals(this.caches, other.caches)
            && Objects.equals(this.clusterManagerThrottling, other.clusterManagerThrottling)
            && Objects.equals(this.discovery, other.discovery)
            && Objects.equals(this.fs, other.fs)
            && Objects.equals(this.host, other.host)
            && Objects.equals(this.http, other.http)
            && Objects.equals(this.indexingPressure, other.indexingPressure)
            && Objects.equals(this.indices, other.indices)
            && Objects.equals(this.ingest, other.ingest)
            && Objects.equals(this.ip, other.ip)
            && Objects.equals(this.jvm, other.jvm)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.os, other.os)
            && Objects.equals(this.process, other.process)
            && Objects.equals(this.remoteStore, other.remoteStore)
            && Objects.equals(this.repositories, other.repositories)
            && Objects.equals(this.resourceUsageStats, other.resourceUsageStats)
            && Objects.equals(this.roles, other.roles)
            && Objects.equals(this.script, other.script)
            && Objects.equals(this.scriptCache, other.scriptCache)
            && Objects.equals(this.searchBackpressure, other.searchBackpressure)
            && Objects.equals(this.searchPipeline, other.searchPipeline)
            && Objects.equals(this.segmentReplicationBackpressure, other.segmentReplicationBackpressure)
            && Objects.equals(this.shardIndexingPressure, other.shardIndexingPressure)
            && Objects.equals(this.taskCancellation, other.taskCancellation)
            && Objects.equals(this.threadPool, other.threadPool)
            && Objects.equals(this.timestamp, other.timestamp)
            && Objects.equals(this.transport, other.transport)
            && Objects.equals(this.transportAddress, other.transportAddress)
            && Objects.equals(this.weightedRouting, other.weightedRouting);
    }
}
