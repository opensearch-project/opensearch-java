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

package org.opensearch.client.opensearch.cat.nodes;

import jakarta.json.stream.JsonGenerator;
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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cat.nodes.NodesRecord

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodesRecord implements PlainJsonSerializable, ToCopyableBuilder<NodesRecord.Builder, NodesRecord> {

    @Nullable
    private final String build;

    @Nullable
    private final String bulkAvgSizeInBytes;

    @Nullable
    private final String bulkAvgTime;

    @Nullable
    private final String bulkTotalOperations;

    @Nullable
    private final String bulkTotalSizeInBytes;

    @Nullable
    private final String bulkTotalTime;

    @Nullable
    private final String clusterManager;

    @Nullable
    private final String completionSize;

    @Nullable
    private final String cpu;

    @Nullable
    private final String diskAvail;

    @Nullable
    private final String diskTotal;

    @Nullable
    private final String diskUsed;

    @Nullable
    private final String diskUsedPercent;

    @Nullable
    private final String fielddataEvictions;

    @Nullable
    private final String fielddataMemorySize;

    @Nullable
    private final String fileDescCurrent;

    @Nullable
    private final String fileDescMax;

    @Nullable
    private final String fileDescPercent;

    @Nullable
    private final String flavor;

    @Nullable
    private final String flushTotal;

    @Nullable
    private final String flushTotalTime;

    @Nullable
    private final String getCurrent;

    @Nullable
    private final String getExistsTime;

    @Nullable
    private final String getExistsTotal;

    @Nullable
    private final String getMissingTime;

    @Nullable
    private final String getMissingTotal;

    @Nullable
    private final String getTime;

    @Nullable
    private final String getTotal;

    @Nullable
    private final String heapCurrent;

    @Nullable
    private final String heapMax;

    @Nullable
    private final String heapPercent;

    @Nullable
    private final String httpAddress;

    @Nullable
    private final String id;

    @Nullable
    private final String indexingDeleteCurrent;

    @Nullable
    private final String indexingDeleteTime;

    @Nullable
    private final String indexingDeleteTotal;

    @Nullable
    private final String indexingIndexCurrent;

    @Nullable
    private final String indexingIndexFailed;

    @Nullable
    private final String indexingIndexTime;

    @Nullable
    private final String indexingIndexTotal;

    @Nullable
    private final String ip;

    @Nullable
    private final String jdk;

    @Nullable
    private final String load15m;

    @Nullable
    private final String load1m;

    @Nullable
    private final String load5m;

    @Nullable
    private final String master;

    @Nullable
    private final String mergesCurrent;

    @Nullable
    private final String mergesCurrentDocs;

    @Nullable
    private final String mergesCurrentSize;

    @Nullable
    private final String mergesTotal;

    @Nullable
    private final String mergesTotalDocs;

    @Nullable
    private final String mergesTotalSize;

    @Nullable
    private final String mergesTotalTime;

    @Nullable
    private final String name;

    @Nullable
    private final String nodeRole;

    @Nullable
    private final String nodeRoles;

    @Nullable
    private final String pid;

    @Nullable
    private final String port;

    @Nullable
    private final String queryCacheEvictions;

    @Nullable
    private final String queryCacheHitCount;

    @Nullable
    private final String queryCacheMemorySize;

    @Nullable
    private final String queryCacheMissCount;

    @Nullable
    private final String ramCurrent;

    @Nullable
    private final String ramMax;

    @Nullable
    private final String ramPercent;

    @Nullable
    private final String refreshExternalTime;

    @Nullable
    private final String refreshExternalTotal;

    @Nullable
    private final String refreshListeners;

    @Nullable
    private final String refreshTime;

    @Nullable
    private final String refreshTotal;

    @Nullable
    private final String requestCacheEvictions;

    @Nullable
    private final String requestCacheHitCount;

    @Nullable
    private final String requestCacheMemorySize;

    @Nullable
    private final String requestCacheMissCount;

    @Nullable
    private final String scriptCacheEvictions;

    @Nullable
    private final String scriptCompilationLimitTriggered;

    @Nullable
    private final String scriptCompilations;

    @Nullable
    private final String searchConcurrentAvgSliceCount;

    @Nullable
    private final String searchConcurrentQueryCurrent;

    @Nullable
    private final String searchConcurrentQueryTime;

    @Nullable
    private final String searchConcurrentQueryTotal;

    @Nullable
    private final String searchFetchCurrent;

    @Nullable
    private final String searchFetchTime;

    @Nullable
    private final String searchFetchTotal;

    @Nullable
    private final String searchOpenContexts;

    @Nullable
    private final String searchPointInTimeCurrent;

    @Nullable
    private final String searchPointInTimeTime;

    @Nullable
    private final String searchPointInTimeTotal;

    @Nullable
    private final String searchQueryCurrent;

    @Nullable
    private final String searchQueryTime;

    @Nullable
    private final String searchQueryTotal;

    @Nullable
    private final String searchScrollCurrent;

    @Nullable
    private final String searchScrollTime;

    @Nullable
    private final String searchScrollTotal;

    @Nullable
    private final String segmentsCount;

    @Nullable
    private final String segmentsFixedBitsetMemory;

    @Nullable
    private final String segmentsIndexWriterMemory;

    @Nullable
    private final String segmentsMemory;

    @Nullable
    private final String segmentsVersionMapMemory;

    @Nullable
    private final String suggestCurrent;

    @Nullable
    private final String suggestTime;

    @Nullable
    private final String suggestTotal;

    @Nullable
    private final String type;

    @Nullable
    private final String uptime;

    @Nullable
    private final String version;

    // ---------------------------------------------------------------------------------------------

    private NodesRecord(Builder builder) {
        this.build = builder.build;
        this.bulkAvgSizeInBytes = builder.bulkAvgSizeInBytes;
        this.bulkAvgTime = builder.bulkAvgTime;
        this.bulkTotalOperations = builder.bulkTotalOperations;
        this.bulkTotalSizeInBytes = builder.bulkTotalSizeInBytes;
        this.bulkTotalTime = builder.bulkTotalTime;
        this.clusterManager = builder.clusterManager;
        this.completionSize = builder.completionSize;
        this.cpu = builder.cpu;
        this.diskAvail = builder.diskAvail;
        this.diskTotal = builder.diskTotal;
        this.diskUsed = builder.diskUsed;
        this.diskUsedPercent = builder.diskUsedPercent;
        this.fielddataEvictions = builder.fielddataEvictions;
        this.fielddataMemorySize = builder.fielddataMemorySize;
        this.fileDescCurrent = builder.fileDescCurrent;
        this.fileDescMax = builder.fileDescMax;
        this.fileDescPercent = builder.fileDescPercent;
        this.flavor = builder.flavor;
        this.flushTotal = builder.flushTotal;
        this.flushTotalTime = builder.flushTotalTime;
        this.getCurrent = builder.getCurrent;
        this.getExistsTime = builder.getExistsTime;
        this.getExistsTotal = builder.getExistsTotal;
        this.getMissingTime = builder.getMissingTime;
        this.getMissingTotal = builder.getMissingTotal;
        this.getTime = builder.getTime;
        this.getTotal = builder.getTotal;
        this.heapCurrent = builder.heapCurrent;
        this.heapMax = builder.heapMax;
        this.heapPercent = builder.heapPercent;
        this.httpAddress = builder.httpAddress;
        this.id = builder.id;
        this.indexingDeleteCurrent = builder.indexingDeleteCurrent;
        this.indexingDeleteTime = builder.indexingDeleteTime;
        this.indexingDeleteTotal = builder.indexingDeleteTotal;
        this.indexingIndexCurrent = builder.indexingIndexCurrent;
        this.indexingIndexFailed = builder.indexingIndexFailed;
        this.indexingIndexTime = builder.indexingIndexTime;
        this.indexingIndexTotal = builder.indexingIndexTotal;
        this.ip = builder.ip;
        this.jdk = builder.jdk;
        this.load15m = builder.load15m;
        this.load1m = builder.load1m;
        this.load5m = builder.load5m;
        this.master = builder.master;
        this.mergesCurrent = builder.mergesCurrent;
        this.mergesCurrentDocs = builder.mergesCurrentDocs;
        this.mergesCurrentSize = builder.mergesCurrentSize;
        this.mergesTotal = builder.mergesTotal;
        this.mergesTotalDocs = builder.mergesTotalDocs;
        this.mergesTotalSize = builder.mergesTotalSize;
        this.mergesTotalTime = builder.mergesTotalTime;
        this.name = builder.name;
        this.nodeRole = builder.nodeRole;
        this.nodeRoles = builder.nodeRoles;
        this.pid = builder.pid;
        this.port = builder.port;
        this.queryCacheEvictions = builder.queryCacheEvictions;
        this.queryCacheHitCount = builder.queryCacheHitCount;
        this.queryCacheMemorySize = builder.queryCacheMemorySize;
        this.queryCacheMissCount = builder.queryCacheMissCount;
        this.ramCurrent = builder.ramCurrent;
        this.ramMax = builder.ramMax;
        this.ramPercent = builder.ramPercent;
        this.refreshExternalTime = builder.refreshExternalTime;
        this.refreshExternalTotal = builder.refreshExternalTotal;
        this.refreshListeners = builder.refreshListeners;
        this.refreshTime = builder.refreshTime;
        this.refreshTotal = builder.refreshTotal;
        this.requestCacheEvictions = builder.requestCacheEvictions;
        this.requestCacheHitCount = builder.requestCacheHitCount;
        this.requestCacheMemorySize = builder.requestCacheMemorySize;
        this.requestCacheMissCount = builder.requestCacheMissCount;
        this.scriptCacheEvictions = builder.scriptCacheEvictions;
        this.scriptCompilationLimitTriggered = builder.scriptCompilationLimitTriggered;
        this.scriptCompilations = builder.scriptCompilations;
        this.searchConcurrentAvgSliceCount = builder.searchConcurrentAvgSliceCount;
        this.searchConcurrentQueryCurrent = builder.searchConcurrentQueryCurrent;
        this.searchConcurrentQueryTime = builder.searchConcurrentQueryTime;
        this.searchConcurrentQueryTotal = builder.searchConcurrentQueryTotal;
        this.searchFetchCurrent = builder.searchFetchCurrent;
        this.searchFetchTime = builder.searchFetchTime;
        this.searchFetchTotal = builder.searchFetchTotal;
        this.searchOpenContexts = builder.searchOpenContexts;
        this.searchPointInTimeCurrent = builder.searchPointInTimeCurrent;
        this.searchPointInTimeTime = builder.searchPointInTimeTime;
        this.searchPointInTimeTotal = builder.searchPointInTimeTotal;
        this.searchQueryCurrent = builder.searchQueryCurrent;
        this.searchQueryTime = builder.searchQueryTime;
        this.searchQueryTotal = builder.searchQueryTotal;
        this.searchScrollCurrent = builder.searchScrollCurrent;
        this.searchScrollTime = builder.searchScrollTime;
        this.searchScrollTotal = builder.searchScrollTotal;
        this.segmentsCount = builder.segmentsCount;
        this.segmentsFixedBitsetMemory = builder.segmentsFixedBitsetMemory;
        this.segmentsIndexWriterMemory = builder.segmentsIndexWriterMemory;
        this.segmentsMemory = builder.segmentsMemory;
        this.segmentsVersionMapMemory = builder.segmentsVersionMapMemory;
        this.suggestCurrent = builder.suggestCurrent;
        this.suggestTime = builder.suggestTime;
        this.suggestTotal = builder.suggestTotal;
        this.type = builder.type;
        this.uptime = builder.uptime;
        this.version = builder.version;
    }

    public static NodesRecord of(Function<NodesRecord.Builder, ObjectBuilder<NodesRecord>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The OpenSearch build hash.
     * <p>
     * API name: {@code build}
     * </p>
     */
    @Nullable
    public final String build() {
        return this.build;
    }

    /**
     * The average size in bytes of shard bulk.
     * <p>
     * API name: {@code bulk.avg_size_in_bytes}
     * </p>
     */
    @Nullable
    public final String bulkAvgSizeInBytes() {
        return this.bulkAvgSizeInBytes;
    }

    /**
     * The average time spend in shard bulk.
     * <p>
     * API name: {@code bulk.avg_time}
     * </p>
     */
    @Nullable
    public final String bulkAvgTime() {
        return this.bulkAvgTime;
    }

    /**
     * The number of bulk shard operations.
     * <p>
     * API name: {@code bulk.total_operations}
     * </p>
     */
    @Nullable
    public final String bulkTotalOperations() {
        return this.bulkTotalOperations;
    }

    /**
     * The total size in bytes of shard bulk.
     * <p>
     * API name: {@code bulk.total_size_in_bytes}
     * </p>
     */
    @Nullable
    public final String bulkTotalSizeInBytes() {
        return this.bulkTotalSizeInBytes;
    }

    /**
     * The time spend in shard bulk.
     * <p>
     * API name: {@code bulk.total_time}
     * </p>
     */
    @Nullable
    public final String bulkTotalTime() {
        return this.bulkTotalTime;
    }

    /**
     * Indicates whether the node is the elected cluster-manager node. Returned values include <code>*</code>(elected cluster-manager) and
     * <code>-</code>(not elected cluster-manager).
     * <p>
     * API name: {@code cluster_manager}
     * </p>
     */
    @Nullable
    public final String clusterManager() {
        return this.clusterManager;
    }

    /**
     * The size of completion.
     * <p>
     * API name: {@code completion.size}
     * </p>
     */
    @Nullable
    public final String completionSize() {
        return this.completionSize;
    }

    /**
     * The recent system CPU usage as a percentage.
     * <p>
     * API name: {@code cpu}
     * </p>
     */
    @Nullable
    public final String cpu() {
        return this.cpu;
    }

    /**
     * API name: {@code disk.avail}
     */
    @Nullable
    public final String diskAvail() {
        return this.diskAvail;
    }

    /**
     * API name: {@code disk.total}
     */
    @Nullable
    public final String diskTotal() {
        return this.diskTotal;
    }

    /**
     * API name: {@code disk.used}
     */
    @Nullable
    public final String diskUsed() {
        return this.diskUsed;
    }

    /**
     * API name: {@code disk.used_percent}
     */
    @Nullable
    public final String diskUsedPercent() {
        return this.diskUsedPercent;
    }

    /**
     * The field data evictions.
     * <p>
     * API name: {@code fielddata.evictions}
     * </p>
     */
    @Nullable
    public final String fielddataEvictions() {
        return this.fielddataEvictions;
    }

    /**
     * The used field data cache.
     * <p>
     * API name: {@code fielddata.memory_size}
     * </p>
     */
    @Nullable
    public final String fielddataMemorySize() {
        return this.fielddataMemorySize;
    }

    /**
     * The used file descriptors.
     * <p>
     * API name: {@code file_desc.current}
     * </p>
     */
    @Nullable
    public final String fileDescCurrent() {
        return this.fileDescCurrent;
    }

    /**
     * The maximum number of file descriptors.
     * <p>
     * API name: {@code file_desc.max}
     * </p>
     */
    @Nullable
    public final String fileDescMax() {
        return this.fileDescMax;
    }

    /**
     * API name: {@code file_desc.percent}
     */
    @Nullable
    public final String fileDescPercent() {
        return this.fileDescPercent;
    }

    /**
     * The OpenSearch distribution flavor.
     * <p>
     * API name: {@code flavor}
     * </p>
     */
    @Nullable
    public final String flavor() {
        return this.flavor;
    }

    /**
     * The number of flushes.
     * <p>
     * API name: {@code flush.total}
     * </p>
     */
    @Nullable
    public final String flushTotal() {
        return this.flushTotal;
    }

    /**
     * The time spent in flush.
     * <p>
     * API name: {@code flush.total_time}
     * </p>
     */
    @Nullable
    public final String flushTotalTime() {
        return this.flushTotalTime;
    }

    /**
     * The number of current get ops.
     * <p>
     * API name: {@code get.current}
     * </p>
     */
    @Nullable
    public final String getCurrent() {
        return this.getCurrent;
    }

    /**
     * The time spent in successful gets.
     * <p>
     * API name: {@code get.exists_time}
     * </p>
     */
    @Nullable
    public final String getExistsTime() {
        return this.getExistsTime;
    }

    /**
     * The number of successful get operations.
     * <p>
     * API name: {@code get.exists_total}
     * </p>
     */
    @Nullable
    public final String getExistsTotal() {
        return this.getExistsTotal;
    }

    /**
     * The time spent in failed gets.
     * <p>
     * API name: {@code get.missing_time}
     * </p>
     */
    @Nullable
    public final String getMissingTime() {
        return this.getMissingTime;
    }

    /**
     * The number of failed gets.
     * <p>
     * API name: {@code get.missing_total}
     * </p>
     */
    @Nullable
    public final String getMissingTotal() {
        return this.getMissingTotal;
    }

    /**
     * The time spent in get.
     * <p>
     * API name: {@code get.time}
     * </p>
     */
    @Nullable
    public final String getTime() {
        return this.getTime;
    }

    /**
     * The number of get ops.
     * <p>
     * API name: {@code get.total}
     * </p>
     */
    @Nullable
    public final String getTotal() {
        return this.getTotal;
    }

    /**
     * The used heap.
     * <p>
     * API name: {@code heap.current}
     * </p>
     */
    @Nullable
    public final String heapCurrent() {
        return this.heapCurrent;
    }

    /**
     * The maximum configured heap.
     * <p>
     * API name: {@code heap.max}
     * </p>
     */
    @Nullable
    public final String heapMax() {
        return this.heapMax;
    }

    /**
     * API name: {@code heap.percent}
     */
    @Nullable
    public final String heapPercent() {
        return this.heapPercent;
    }

    /**
     * The bound HTTP address.
     * <p>
     * API name: {@code http_address}
     * </p>
     */
    @Nullable
    public final String httpAddress() {
        return this.httpAddress;
    }

    /**
     * API name: {@code id}
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * The number of current deletions.
     * <p>
     * API name: {@code indexing.delete_current}
     * </p>
     */
    @Nullable
    public final String indexingDeleteCurrent() {
        return this.indexingDeleteCurrent;
    }

    /**
     * The time spent in deletions.
     * <p>
     * API name: {@code indexing.delete_time}
     * </p>
     */
    @Nullable
    public final String indexingDeleteTime() {
        return this.indexingDeleteTime;
    }

    /**
     * The number of delete operations.
     * <p>
     * API name: {@code indexing.delete_total}
     * </p>
     */
    @Nullable
    public final String indexingDeleteTotal() {
        return this.indexingDeleteTotal;
    }

    /**
     * The number of current indexing operations.
     * <p>
     * API name: {@code indexing.index_current}
     * </p>
     */
    @Nullable
    public final String indexingIndexCurrent() {
        return this.indexingIndexCurrent;
    }

    /**
     * The number of failed indexing operations.
     * <p>
     * API name: {@code indexing.index_failed}
     * </p>
     */
    @Nullable
    public final String indexingIndexFailed() {
        return this.indexingIndexFailed;
    }

    /**
     * The time spent in indexing.
     * <p>
     * API name: {@code indexing.index_time}
     * </p>
     */
    @Nullable
    public final String indexingIndexTime() {
        return this.indexingIndexTime;
    }

    /**
     * The number of indexing operations.
     * <p>
     * API name: {@code indexing.index_total}
     * </p>
     */
    @Nullable
    public final String indexingIndexTotal() {
        return this.indexingIndexTotal;
    }

    /**
     * The IP address.
     * <p>
     * API name: {@code ip}
     * </p>
     */
    @Nullable
    public final String ip() {
        return this.ip;
    }

    /**
     * The Java version.
     * <p>
     * API name: {@code jdk}
     * </p>
     */
    @Nullable
    public final String jdk() {
        return this.jdk;
    }

    /**
     * The load average for the last fifteen minutes.
     * <p>
     * API name: {@code load_15m}
     * </p>
     */
    @Nullable
    public final String load15m() {
        return this.load15m;
    }

    /**
     * The load average for the most recent minute.
     * <p>
     * API name: {@code load_1m}
     * </p>
     */
    @Nullable
    public final String load1m() {
        return this.load1m;
    }

    /**
     * The load average for the last five minutes.
     * <p>
     * API name: {@code load_5m}
     * </p>
     */
    @Nullable
    public final String load5m() {
        return this.load5m;
    }

    /**
     * Indicates whether the node is the elected cluster-manager node. Returned values include <code>*</code>(elected cluster manager) and
     * <code>-</code>(not elected cluster manager).
     * <p>
     * API name: {@code master}
     * </p>
     */
    @Nullable
    public final String master() {
        return this.master;
    }

    /**
     * The number of current merges.
     * <p>
     * API name: {@code merges.current}
     * </p>
     */
    @Nullable
    public final String mergesCurrent() {
        return this.mergesCurrent;
    }

    /**
     * The number of current merging docs.
     * <p>
     * API name: {@code merges.current_docs}
     * </p>
     */
    @Nullable
    public final String mergesCurrentDocs() {
        return this.mergesCurrentDocs;
    }

    /**
     * The size of current merges.
     * <p>
     * API name: {@code merges.current_size}
     * </p>
     */
    @Nullable
    public final String mergesCurrentSize() {
        return this.mergesCurrentSize;
    }

    /**
     * The number of completed merge operations.
     * <p>
     * API name: {@code merges.total}
     * </p>
     */
    @Nullable
    public final String mergesTotal() {
        return this.mergesTotal;
    }

    /**
     * The docs merged.
     * <p>
     * API name: {@code merges.total_docs}
     * </p>
     */
    @Nullable
    public final String mergesTotalDocs() {
        return this.mergesTotalDocs;
    }

    /**
     * The size merged.
     * <p>
     * API name: {@code merges.total_size}
     * </p>
     */
    @Nullable
    public final String mergesTotalSize() {
        return this.mergesTotalSize;
    }

    /**
     * The time spent in merges.
     * <p>
     * API name: {@code merges.total_time}
     * </p>
     */
    @Nullable
    public final String mergesTotalTime() {
        return this.mergesTotalTime;
    }

    /**
     * API name: {@code name}
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * The roles of the node. Returned values include <code>c</code>(cold node), <code>d</code>(data node), <code>f</code>(frozen node),
     * <code>h</code>(hot node), <code>i</code>(ingest node), <code>l</code>(machine learning node), <code>m</code> (cluster-manager
     * eligible node), <code>r</code>(remote cluster client node), <code>s</code>(content node), <code>t</code>(transform node),
     * <code>v</code>(voting-only node), <code>w</code>(warm node),and <code>-</code>(coordinating node only).
     * <p>
     * API name: {@code node.role}
     * </p>
     */
    @Nullable
    public final String nodeRole() {
        return this.nodeRole;
    }

    /**
     * A comma-separated list of the roles of the node. Returned values may include but are not limited to: <code>data</code>,
     * <code>ingest</code>, <code>master</code>, <code>cluster_manager</code>, <code>remote_cluster_client</code>, <code>search</code>, and
     * <code>-</code>(coordinating node only).
     * <p>
     * API name: {@code node.roles}
     * </p>
     */
    @Nullable
    public final String nodeRoles() {
        return this.nodeRoles;
    }

    /**
     * The process identifier.
     * <p>
     * API name: {@code pid}
     * </p>
     */
    @Nullable
    public final String pid() {
        return this.pid;
    }

    /**
     * The bound transport port.
     * <p>
     * API name: {@code port}
     * </p>
     */
    @Nullable
    public final String port() {
        return this.port;
    }

    /**
     * The query cache evictions.
     * <p>
     * API name: {@code query_cache.evictions}
     * </p>
     */
    @Nullable
    public final String queryCacheEvictions() {
        return this.queryCacheEvictions;
    }

    /**
     * The query cache hit counts.
     * <p>
     * API name: {@code query_cache.hit_count}
     * </p>
     */
    @Nullable
    public final String queryCacheHitCount() {
        return this.queryCacheHitCount;
    }

    /**
     * The used query cache.
     * <p>
     * API name: {@code query_cache.memory_size}
     * </p>
     */
    @Nullable
    public final String queryCacheMemorySize() {
        return this.queryCacheMemorySize;
    }

    /**
     * The query cache miss counts.
     * <p>
     * API name: {@code query_cache.miss_count}
     * </p>
     */
    @Nullable
    public final String queryCacheMissCount() {
        return this.queryCacheMissCount;
    }

    /**
     * The used machine memory.
     * <p>
     * API name: {@code ram.current}
     * </p>
     */
    @Nullable
    public final String ramCurrent() {
        return this.ramCurrent;
    }

    /**
     * The total machine memory.
     * <p>
     * API name: {@code ram.max}
     * </p>
     */
    @Nullable
    public final String ramMax() {
        return this.ramMax;
    }

    /**
     * API name: {@code ram.percent}
     */
    @Nullable
    public final String ramPercent() {
        return this.ramPercent;
    }

    /**
     * The time spent in external refreshes.
     * <p>
     * API name: {@code refresh.external_time}
     * </p>
     */
    @Nullable
    public final String refreshExternalTime() {
        return this.refreshExternalTime;
    }

    /**
     * The total external refreshes.
     * <p>
     * API name: {@code refresh.external_total}
     * </p>
     */
    @Nullable
    public final String refreshExternalTotal() {
        return this.refreshExternalTotal;
    }

    /**
     * The number of pending refresh listeners.
     * <p>
     * API name: {@code refresh.listeners}
     * </p>
     */
    @Nullable
    public final String refreshListeners() {
        return this.refreshListeners;
    }

    /**
     * The time spent in refreshes.
     * <p>
     * API name: {@code refresh.time}
     * </p>
     */
    @Nullable
    public final String refreshTime() {
        return this.refreshTime;
    }

    /**
     * The total refreshes.
     * <p>
     * API name: {@code refresh.total}
     * </p>
     */
    @Nullable
    public final String refreshTotal() {
        return this.refreshTotal;
    }

    /**
     * The request cache evictions.
     * <p>
     * API name: {@code request_cache.evictions}
     * </p>
     */
    @Nullable
    public final String requestCacheEvictions() {
        return this.requestCacheEvictions;
    }

    /**
     * The request cache hit counts.
     * <p>
     * API name: {@code request_cache.hit_count}
     * </p>
     */
    @Nullable
    public final String requestCacheHitCount() {
        return this.requestCacheHitCount;
    }

    /**
     * The used request cache.
     * <p>
     * API name: {@code request_cache.memory_size}
     * </p>
     */
    @Nullable
    public final String requestCacheMemorySize() {
        return this.requestCacheMemorySize;
    }

    /**
     * The request cache miss counts.
     * <p>
     * API name: {@code request_cache.miss_count}
     * </p>
     */
    @Nullable
    public final String requestCacheMissCount() {
        return this.requestCacheMissCount;
    }

    /**
     * The total compiled scripts evicted from the cache.
     * <p>
     * API name: {@code script.cache_evictions}
     * </p>
     */
    @Nullable
    public final String scriptCacheEvictions() {
        return this.scriptCacheEvictions;
    }

    /**
     * The script cache compilation limit triggered.
     * <p>
     * API name: {@code script.compilation_limit_triggered}
     * </p>
     */
    @Nullable
    public final String scriptCompilationLimitTriggered() {
        return this.scriptCompilationLimitTriggered;
    }

    /**
     * The total script compilations.
     * <p>
     * API name: {@code script.compilations}
     * </p>
     */
    @Nullable
    public final String scriptCompilations() {
        return this.scriptCompilations;
    }

    /**
     * API name: {@code search.concurrent_avg_slice_count}
     */
    @Nullable
    public final String searchConcurrentAvgSliceCount() {
        return this.searchConcurrentAvgSliceCount;
    }

    /**
     * API name: {@code search.concurrent_query_current}
     */
    @Nullable
    public final String searchConcurrentQueryCurrent() {
        return this.searchConcurrentQueryCurrent;
    }

    /**
     * API name: {@code search.concurrent_query_time}
     */
    @Nullable
    public final String searchConcurrentQueryTime() {
        return this.searchConcurrentQueryTime;
    }

    /**
     * API name: {@code search.concurrent_query_total}
     */
    @Nullable
    public final String searchConcurrentQueryTotal() {
        return this.searchConcurrentQueryTotal;
    }

    /**
     * The current fetch phase operations.
     * <p>
     * API name: {@code search.fetch_current}
     * </p>
     */
    @Nullable
    public final String searchFetchCurrent() {
        return this.searchFetchCurrent;
    }

    /**
     * The time spent in fetch phase.
     * <p>
     * API name: {@code search.fetch_time}
     * </p>
     */
    @Nullable
    public final String searchFetchTime() {
        return this.searchFetchTime;
    }

    /**
     * The total fetch operations.
     * <p>
     * API name: {@code search.fetch_total}
     * </p>
     */
    @Nullable
    public final String searchFetchTotal() {
        return this.searchFetchTotal;
    }

    /**
     * The open search contexts.
     * <p>
     * API name: {@code search.open_contexts}
     * </p>
     */
    @Nullable
    public final String searchOpenContexts() {
        return this.searchOpenContexts;
    }

    /**
     * API name: {@code search.point_in_time_current}
     */
    @Nullable
    public final String searchPointInTimeCurrent() {
        return this.searchPointInTimeCurrent;
    }

    /**
     * API name: {@code search.point_in_time_time}
     */
    @Nullable
    public final String searchPointInTimeTime() {
        return this.searchPointInTimeTime;
    }

    /**
     * API name: {@code search.point_in_time_total}
     */
    @Nullable
    public final String searchPointInTimeTotal() {
        return this.searchPointInTimeTotal;
    }

    /**
     * The current query phase operations.
     * <p>
     * API name: {@code search.query_current}
     * </p>
     */
    @Nullable
    public final String searchQueryCurrent() {
        return this.searchQueryCurrent;
    }

    /**
     * The time spent in query phase.
     * <p>
     * API name: {@code search.query_time}
     * </p>
     */
    @Nullable
    public final String searchQueryTime() {
        return this.searchQueryTime;
    }

    /**
     * The total query phase operations.
     * <p>
     * API name: {@code search.query_total}
     * </p>
     */
    @Nullable
    public final String searchQueryTotal() {
        return this.searchQueryTotal;
    }

    /**
     * The open scroll contexts.
     * <p>
     * API name: {@code search.scroll_current}
     * </p>
     */
    @Nullable
    public final String searchScrollCurrent() {
        return this.searchScrollCurrent;
    }

    /**
     * The time scroll contexts held open.
     * <p>
     * API name: {@code search.scroll_time}
     * </p>
     */
    @Nullable
    public final String searchScrollTime() {
        return this.searchScrollTime;
    }

    /**
     * The completed scroll contexts.
     * <p>
     * API name: {@code search.scroll_total}
     * </p>
     */
    @Nullable
    public final String searchScrollTotal() {
        return this.searchScrollTotal;
    }

    /**
     * The number of segments.
     * <p>
     * API name: {@code segments.count}
     * </p>
     */
    @Nullable
    public final String segmentsCount() {
        return this.segmentsCount;
    }

    /**
     * The memory used by fixed bit sets for nested object field types and export type filters for types referred in <code>_parent</code>
     * fields.
     * <p>
     * API name: {@code segments.fixed_bitset_memory}
     * </p>
     */
    @Nullable
    public final String segmentsFixedBitsetMemory() {
        return this.segmentsFixedBitsetMemory;
    }

    /**
     * The memory used by the index writer.
     * <p>
     * API name: {@code segments.index_writer_memory}
     * </p>
     */
    @Nullable
    public final String segmentsIndexWriterMemory() {
        return this.segmentsIndexWriterMemory;
    }

    /**
     * The memory used by segments.
     * <p>
     * API name: {@code segments.memory}
     * </p>
     */
    @Nullable
    public final String segmentsMemory() {
        return this.segmentsMemory;
    }

    /**
     * The memory used by the version map.
     * <p>
     * API name: {@code segments.version_map_memory}
     * </p>
     */
    @Nullable
    public final String segmentsVersionMapMemory() {
        return this.segmentsVersionMapMemory;
    }

    /**
     * The number of current suggest operations.
     * <p>
     * API name: {@code suggest.current}
     * </p>
     */
    @Nullable
    public final String suggestCurrent() {
        return this.suggestCurrent;
    }

    /**
     * The time spend in suggest.
     * <p>
     * API name: {@code suggest.time}
     * </p>
     */
    @Nullable
    public final String suggestTime() {
        return this.suggestTime;
    }

    /**
     * The number of suggest operations.
     * <p>
     * API name: {@code suggest.total}
     * </p>
     */
    @Nullable
    public final String suggestTotal() {
        return this.suggestTotal;
    }

    /**
     * The OpenSearch distribution type.
     * <p>
     * API name: {@code type}
     * </p>
     */
    @Nullable
    public final String type() {
        return this.type;
    }

    /**
     * The node uptime.
     * <p>
     * API name: {@code uptime}
     * </p>
     */
    @Nullable
    public final String uptime() {
        return this.uptime;
    }

    /**
     * API name: {@code version}
     */
    @Nullable
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
        if (this.build != null) {
            generator.writeKey("build");
            generator.write(this.build);
        }

        if (this.bulkAvgSizeInBytes != null) {
            generator.writeKey("bulk.avg_size_in_bytes");
            generator.write(this.bulkAvgSizeInBytes);
        }

        if (this.bulkAvgTime != null) {
            generator.writeKey("bulk.avg_time");
            generator.write(this.bulkAvgTime);
        }

        if (this.bulkTotalOperations != null) {
            generator.writeKey("bulk.total_operations");
            generator.write(this.bulkTotalOperations);
        }

        if (this.bulkTotalSizeInBytes != null) {
            generator.writeKey("bulk.total_size_in_bytes");
            generator.write(this.bulkTotalSizeInBytes);
        }

        if (this.bulkTotalTime != null) {
            generator.writeKey("bulk.total_time");
            generator.write(this.bulkTotalTime);
        }

        if (this.clusterManager != null) {
            generator.writeKey("cluster_manager");
            generator.write(this.clusterManager);
        }

        if (this.completionSize != null) {
            generator.writeKey("completion.size");
            generator.write(this.completionSize);
        }

        if (this.cpu != null) {
            generator.writeKey("cpu");
            generator.write(this.cpu);
        }

        if (this.diskAvail != null) {
            generator.writeKey("disk.avail");
            generator.write(this.diskAvail);
        }

        if (this.diskTotal != null) {
            generator.writeKey("disk.total");
            generator.write(this.diskTotal);
        }

        if (this.diskUsed != null) {
            generator.writeKey("disk.used");
            generator.write(this.diskUsed);
        }

        if (this.diskUsedPercent != null) {
            generator.writeKey("disk.used_percent");
            generator.write(this.diskUsedPercent);
        }

        if (this.fielddataEvictions != null) {
            generator.writeKey("fielddata.evictions");
            generator.write(this.fielddataEvictions);
        }

        if (this.fielddataMemorySize != null) {
            generator.writeKey("fielddata.memory_size");
            generator.write(this.fielddataMemorySize);
        }

        if (this.fileDescCurrent != null) {
            generator.writeKey("file_desc.current");
            generator.write(this.fileDescCurrent);
        }

        if (this.fileDescMax != null) {
            generator.writeKey("file_desc.max");
            generator.write(this.fileDescMax);
        }

        if (this.fileDescPercent != null) {
            generator.writeKey("file_desc.percent");
            generator.write(this.fileDescPercent);
        }

        if (this.flavor != null) {
            generator.writeKey("flavor");
            generator.write(this.flavor);
        }

        if (this.flushTotal != null) {
            generator.writeKey("flush.total");
            generator.write(this.flushTotal);
        }

        if (this.flushTotalTime != null) {
            generator.writeKey("flush.total_time");
            generator.write(this.flushTotalTime);
        }

        if (this.getCurrent != null) {
            generator.writeKey("get.current");
            generator.write(this.getCurrent);
        }

        if (this.getExistsTime != null) {
            generator.writeKey("get.exists_time");
            generator.write(this.getExistsTime);
        }

        if (this.getExistsTotal != null) {
            generator.writeKey("get.exists_total");
            generator.write(this.getExistsTotal);
        }

        if (this.getMissingTime != null) {
            generator.writeKey("get.missing_time");
            generator.write(this.getMissingTime);
        }

        if (this.getMissingTotal != null) {
            generator.writeKey("get.missing_total");
            generator.write(this.getMissingTotal);
        }

        if (this.getTime != null) {
            generator.writeKey("get.time");
            generator.write(this.getTime);
        }

        if (this.getTotal != null) {
            generator.writeKey("get.total");
            generator.write(this.getTotal);
        }

        if (this.heapCurrent != null) {
            generator.writeKey("heap.current");
            generator.write(this.heapCurrent);
        }

        if (this.heapMax != null) {
            generator.writeKey("heap.max");
            generator.write(this.heapMax);
        }

        if (this.heapPercent != null) {
            generator.writeKey("heap.percent");
            generator.write(this.heapPercent);
        }

        if (this.httpAddress != null) {
            generator.writeKey("http_address");
            generator.write(this.httpAddress);
        }

        if (this.id != null) {
            generator.writeKey("id");
            generator.write(this.id);
        }

        if (this.indexingDeleteCurrent != null) {
            generator.writeKey("indexing.delete_current");
            generator.write(this.indexingDeleteCurrent);
        }

        if (this.indexingDeleteTime != null) {
            generator.writeKey("indexing.delete_time");
            generator.write(this.indexingDeleteTime);
        }

        if (this.indexingDeleteTotal != null) {
            generator.writeKey("indexing.delete_total");
            generator.write(this.indexingDeleteTotal);
        }

        if (this.indexingIndexCurrent != null) {
            generator.writeKey("indexing.index_current");
            generator.write(this.indexingIndexCurrent);
        }

        if (this.indexingIndexFailed != null) {
            generator.writeKey("indexing.index_failed");
            generator.write(this.indexingIndexFailed);
        }

        if (this.indexingIndexTime != null) {
            generator.writeKey("indexing.index_time");
            generator.write(this.indexingIndexTime);
        }

        if (this.indexingIndexTotal != null) {
            generator.writeKey("indexing.index_total");
            generator.write(this.indexingIndexTotal);
        }

        if (this.ip != null) {
            generator.writeKey("ip");
            generator.write(this.ip);
        }

        if (this.jdk != null) {
            generator.writeKey("jdk");
            generator.write(this.jdk);
        }

        if (this.load15m != null) {
            generator.writeKey("load_15m");
            generator.write(this.load15m);
        }

        if (this.load1m != null) {
            generator.writeKey("load_1m");
            generator.write(this.load1m);
        }

        if (this.load5m != null) {
            generator.writeKey("load_5m");
            generator.write(this.load5m);
        }

        if (this.master != null) {
            generator.writeKey("master");
            generator.write(this.master);
        }

        if (this.mergesCurrent != null) {
            generator.writeKey("merges.current");
            generator.write(this.mergesCurrent);
        }

        if (this.mergesCurrentDocs != null) {
            generator.writeKey("merges.current_docs");
            generator.write(this.mergesCurrentDocs);
        }

        if (this.mergesCurrentSize != null) {
            generator.writeKey("merges.current_size");
            generator.write(this.mergesCurrentSize);
        }

        if (this.mergesTotal != null) {
            generator.writeKey("merges.total");
            generator.write(this.mergesTotal);
        }

        if (this.mergesTotalDocs != null) {
            generator.writeKey("merges.total_docs");
            generator.write(this.mergesTotalDocs);
        }

        if (this.mergesTotalSize != null) {
            generator.writeKey("merges.total_size");
            generator.write(this.mergesTotalSize);
        }

        if (this.mergesTotalTime != null) {
            generator.writeKey("merges.total_time");
            generator.write(this.mergesTotalTime);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (this.nodeRole != null) {
            generator.writeKey("node.role");
            generator.write(this.nodeRole);
        }

        if (this.nodeRoles != null) {
            generator.writeKey("node.roles");
            generator.write(this.nodeRoles);
        }

        if (this.pid != null) {
            generator.writeKey("pid");
            generator.write(this.pid);
        }

        if (this.port != null) {
            generator.writeKey("port");
            generator.write(this.port);
        }

        if (this.queryCacheEvictions != null) {
            generator.writeKey("query_cache.evictions");
            generator.write(this.queryCacheEvictions);
        }

        if (this.queryCacheHitCount != null) {
            generator.writeKey("query_cache.hit_count");
            generator.write(this.queryCacheHitCount);
        }

        if (this.queryCacheMemorySize != null) {
            generator.writeKey("query_cache.memory_size");
            generator.write(this.queryCacheMemorySize);
        }

        if (this.queryCacheMissCount != null) {
            generator.writeKey("query_cache.miss_count");
            generator.write(this.queryCacheMissCount);
        }

        if (this.ramCurrent != null) {
            generator.writeKey("ram.current");
            generator.write(this.ramCurrent);
        }

        if (this.ramMax != null) {
            generator.writeKey("ram.max");
            generator.write(this.ramMax);
        }

        if (this.ramPercent != null) {
            generator.writeKey("ram.percent");
            generator.write(this.ramPercent);
        }

        if (this.refreshExternalTime != null) {
            generator.writeKey("refresh.external_time");
            generator.write(this.refreshExternalTime);
        }

        if (this.refreshExternalTotal != null) {
            generator.writeKey("refresh.external_total");
            generator.write(this.refreshExternalTotal);
        }

        if (this.refreshListeners != null) {
            generator.writeKey("refresh.listeners");
            generator.write(this.refreshListeners);
        }

        if (this.refreshTime != null) {
            generator.writeKey("refresh.time");
            generator.write(this.refreshTime);
        }

        if (this.refreshTotal != null) {
            generator.writeKey("refresh.total");
            generator.write(this.refreshTotal);
        }

        if (this.requestCacheEvictions != null) {
            generator.writeKey("request_cache.evictions");
            generator.write(this.requestCacheEvictions);
        }

        if (this.requestCacheHitCount != null) {
            generator.writeKey("request_cache.hit_count");
            generator.write(this.requestCacheHitCount);
        }

        if (this.requestCacheMemorySize != null) {
            generator.writeKey("request_cache.memory_size");
            generator.write(this.requestCacheMemorySize);
        }

        if (this.requestCacheMissCount != null) {
            generator.writeKey("request_cache.miss_count");
            generator.write(this.requestCacheMissCount);
        }

        if (this.scriptCacheEvictions != null) {
            generator.writeKey("script.cache_evictions");
            generator.write(this.scriptCacheEvictions);
        }

        if (this.scriptCompilationLimitTriggered != null) {
            generator.writeKey("script.compilation_limit_triggered");
            generator.write(this.scriptCompilationLimitTriggered);
        }

        if (this.scriptCompilations != null) {
            generator.writeKey("script.compilations");
            generator.write(this.scriptCompilations);
        }

        if (this.searchConcurrentAvgSliceCount != null) {
            generator.writeKey("search.concurrent_avg_slice_count");
            generator.write(this.searchConcurrentAvgSliceCount);
        }

        if (this.searchConcurrentQueryCurrent != null) {
            generator.writeKey("search.concurrent_query_current");
            generator.write(this.searchConcurrentQueryCurrent);
        }

        if (this.searchConcurrentQueryTime != null) {
            generator.writeKey("search.concurrent_query_time");
            generator.write(this.searchConcurrentQueryTime);
        }

        if (this.searchConcurrentQueryTotal != null) {
            generator.writeKey("search.concurrent_query_total");
            generator.write(this.searchConcurrentQueryTotal);
        }

        if (this.searchFetchCurrent != null) {
            generator.writeKey("search.fetch_current");
            generator.write(this.searchFetchCurrent);
        }

        if (this.searchFetchTime != null) {
            generator.writeKey("search.fetch_time");
            generator.write(this.searchFetchTime);
        }

        if (this.searchFetchTotal != null) {
            generator.writeKey("search.fetch_total");
            generator.write(this.searchFetchTotal);
        }

        if (this.searchOpenContexts != null) {
            generator.writeKey("search.open_contexts");
            generator.write(this.searchOpenContexts);
        }

        if (this.searchPointInTimeCurrent != null) {
            generator.writeKey("search.point_in_time_current");
            generator.write(this.searchPointInTimeCurrent);
        }

        if (this.searchPointInTimeTime != null) {
            generator.writeKey("search.point_in_time_time");
            generator.write(this.searchPointInTimeTime);
        }

        if (this.searchPointInTimeTotal != null) {
            generator.writeKey("search.point_in_time_total");
            generator.write(this.searchPointInTimeTotal);
        }

        if (this.searchQueryCurrent != null) {
            generator.writeKey("search.query_current");
            generator.write(this.searchQueryCurrent);
        }

        if (this.searchQueryTime != null) {
            generator.writeKey("search.query_time");
            generator.write(this.searchQueryTime);
        }

        if (this.searchQueryTotal != null) {
            generator.writeKey("search.query_total");
            generator.write(this.searchQueryTotal);
        }

        if (this.searchScrollCurrent != null) {
            generator.writeKey("search.scroll_current");
            generator.write(this.searchScrollCurrent);
        }

        if (this.searchScrollTime != null) {
            generator.writeKey("search.scroll_time");
            generator.write(this.searchScrollTime);
        }

        if (this.searchScrollTotal != null) {
            generator.writeKey("search.scroll_total");
            generator.write(this.searchScrollTotal);
        }

        if (this.segmentsCount != null) {
            generator.writeKey("segments.count");
            generator.write(this.segmentsCount);
        }

        if (this.segmentsFixedBitsetMemory != null) {
            generator.writeKey("segments.fixed_bitset_memory");
            generator.write(this.segmentsFixedBitsetMemory);
        }

        if (this.segmentsIndexWriterMemory != null) {
            generator.writeKey("segments.index_writer_memory");
            generator.write(this.segmentsIndexWriterMemory);
        }

        if (this.segmentsMemory != null) {
            generator.writeKey("segments.memory");
            generator.write(this.segmentsMemory);
        }

        if (this.segmentsVersionMapMemory != null) {
            generator.writeKey("segments.version_map_memory");
            generator.write(this.segmentsVersionMapMemory);
        }

        if (this.suggestCurrent != null) {
            generator.writeKey("suggest.current");
            generator.write(this.suggestCurrent);
        }

        if (this.suggestTime != null) {
            generator.writeKey("suggest.time");
            generator.write(this.suggestTime);
        }

        if (this.suggestTotal != null) {
            generator.writeKey("suggest.total");
            generator.write(this.suggestTotal);
        }

        if (this.type != null) {
            generator.writeKey("type");
            generator.write(this.type);
        }

        if (this.uptime != null) {
            generator.writeKey("uptime");
            generator.write(this.uptime);
        }

        if (this.version != null) {
            generator.writeKey("version");
            generator.write(this.version);
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
     * Builder for {@link NodesRecord}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodesRecord> {
        @Nullable
        private String build;
        @Nullable
        private String bulkAvgSizeInBytes;
        @Nullable
        private String bulkAvgTime;
        @Nullable
        private String bulkTotalOperations;
        @Nullable
        private String bulkTotalSizeInBytes;
        @Nullable
        private String bulkTotalTime;
        @Nullable
        private String clusterManager;
        @Nullable
        private String completionSize;
        @Nullable
        private String cpu;
        @Nullable
        private String diskAvail;
        @Nullable
        private String diskTotal;
        @Nullable
        private String diskUsed;
        @Nullable
        private String diskUsedPercent;
        @Nullable
        private String fielddataEvictions;
        @Nullable
        private String fielddataMemorySize;
        @Nullable
        private String fileDescCurrent;
        @Nullable
        private String fileDescMax;
        @Nullable
        private String fileDescPercent;
        @Nullable
        private String flavor;
        @Nullable
        private String flushTotal;
        @Nullable
        private String flushTotalTime;
        @Nullable
        private String getCurrent;
        @Nullable
        private String getExistsTime;
        @Nullable
        private String getExistsTotal;
        @Nullable
        private String getMissingTime;
        @Nullable
        private String getMissingTotal;
        @Nullable
        private String getTime;
        @Nullable
        private String getTotal;
        @Nullable
        private String heapCurrent;
        @Nullable
        private String heapMax;
        @Nullable
        private String heapPercent;
        @Nullable
        private String httpAddress;
        @Nullable
        private String id;
        @Nullable
        private String indexingDeleteCurrent;
        @Nullable
        private String indexingDeleteTime;
        @Nullable
        private String indexingDeleteTotal;
        @Nullable
        private String indexingIndexCurrent;
        @Nullable
        private String indexingIndexFailed;
        @Nullable
        private String indexingIndexTime;
        @Nullable
        private String indexingIndexTotal;
        @Nullable
        private String ip;
        @Nullable
        private String jdk;
        @Nullable
        private String load15m;
        @Nullable
        private String load1m;
        @Nullable
        private String load5m;
        @Nullable
        private String master;
        @Nullable
        private String mergesCurrent;
        @Nullable
        private String mergesCurrentDocs;
        @Nullable
        private String mergesCurrentSize;
        @Nullable
        private String mergesTotal;
        @Nullable
        private String mergesTotalDocs;
        @Nullable
        private String mergesTotalSize;
        @Nullable
        private String mergesTotalTime;
        @Nullable
        private String name;
        @Nullable
        private String nodeRole;
        @Nullable
        private String nodeRoles;
        @Nullable
        private String pid;
        @Nullable
        private String port;
        @Nullable
        private String queryCacheEvictions;
        @Nullable
        private String queryCacheHitCount;
        @Nullable
        private String queryCacheMemorySize;
        @Nullable
        private String queryCacheMissCount;
        @Nullable
        private String ramCurrent;
        @Nullable
        private String ramMax;
        @Nullable
        private String ramPercent;
        @Nullable
        private String refreshExternalTime;
        @Nullable
        private String refreshExternalTotal;
        @Nullable
        private String refreshListeners;
        @Nullable
        private String refreshTime;
        @Nullable
        private String refreshTotal;
        @Nullable
        private String requestCacheEvictions;
        @Nullable
        private String requestCacheHitCount;
        @Nullable
        private String requestCacheMemorySize;
        @Nullable
        private String requestCacheMissCount;
        @Nullable
        private String scriptCacheEvictions;
        @Nullable
        private String scriptCompilationLimitTriggered;
        @Nullable
        private String scriptCompilations;
        @Nullable
        private String searchConcurrentAvgSliceCount;
        @Nullable
        private String searchConcurrentQueryCurrent;
        @Nullable
        private String searchConcurrentQueryTime;
        @Nullable
        private String searchConcurrentQueryTotal;
        @Nullable
        private String searchFetchCurrent;
        @Nullable
        private String searchFetchTime;
        @Nullable
        private String searchFetchTotal;
        @Nullable
        private String searchOpenContexts;
        @Nullable
        private String searchPointInTimeCurrent;
        @Nullable
        private String searchPointInTimeTime;
        @Nullable
        private String searchPointInTimeTotal;
        @Nullable
        private String searchQueryCurrent;
        @Nullable
        private String searchQueryTime;
        @Nullable
        private String searchQueryTotal;
        @Nullable
        private String searchScrollCurrent;
        @Nullable
        private String searchScrollTime;
        @Nullable
        private String searchScrollTotal;
        @Nullable
        private String segmentsCount;
        @Nullable
        private String segmentsFixedBitsetMemory;
        @Nullable
        private String segmentsIndexWriterMemory;
        @Nullable
        private String segmentsMemory;
        @Nullable
        private String segmentsVersionMapMemory;
        @Nullable
        private String suggestCurrent;
        @Nullable
        private String suggestTime;
        @Nullable
        private String suggestTotal;
        @Nullable
        private String type;
        @Nullable
        private String uptime;
        @Nullable
        private String version;

        public Builder() {}

        private Builder(NodesRecord o) {
            this.build = o.build;
            this.bulkAvgSizeInBytes = o.bulkAvgSizeInBytes;
            this.bulkAvgTime = o.bulkAvgTime;
            this.bulkTotalOperations = o.bulkTotalOperations;
            this.bulkTotalSizeInBytes = o.bulkTotalSizeInBytes;
            this.bulkTotalTime = o.bulkTotalTime;
            this.clusterManager = o.clusterManager;
            this.completionSize = o.completionSize;
            this.cpu = o.cpu;
            this.diskAvail = o.diskAvail;
            this.diskTotal = o.diskTotal;
            this.diskUsed = o.diskUsed;
            this.diskUsedPercent = o.diskUsedPercent;
            this.fielddataEvictions = o.fielddataEvictions;
            this.fielddataMemorySize = o.fielddataMemorySize;
            this.fileDescCurrent = o.fileDescCurrent;
            this.fileDescMax = o.fileDescMax;
            this.fileDescPercent = o.fileDescPercent;
            this.flavor = o.flavor;
            this.flushTotal = o.flushTotal;
            this.flushTotalTime = o.flushTotalTime;
            this.getCurrent = o.getCurrent;
            this.getExistsTime = o.getExistsTime;
            this.getExistsTotal = o.getExistsTotal;
            this.getMissingTime = o.getMissingTime;
            this.getMissingTotal = o.getMissingTotal;
            this.getTime = o.getTime;
            this.getTotal = o.getTotal;
            this.heapCurrent = o.heapCurrent;
            this.heapMax = o.heapMax;
            this.heapPercent = o.heapPercent;
            this.httpAddress = o.httpAddress;
            this.id = o.id;
            this.indexingDeleteCurrent = o.indexingDeleteCurrent;
            this.indexingDeleteTime = o.indexingDeleteTime;
            this.indexingDeleteTotal = o.indexingDeleteTotal;
            this.indexingIndexCurrent = o.indexingIndexCurrent;
            this.indexingIndexFailed = o.indexingIndexFailed;
            this.indexingIndexTime = o.indexingIndexTime;
            this.indexingIndexTotal = o.indexingIndexTotal;
            this.ip = o.ip;
            this.jdk = o.jdk;
            this.load15m = o.load15m;
            this.load1m = o.load1m;
            this.load5m = o.load5m;
            this.master = o.master;
            this.mergesCurrent = o.mergesCurrent;
            this.mergesCurrentDocs = o.mergesCurrentDocs;
            this.mergesCurrentSize = o.mergesCurrentSize;
            this.mergesTotal = o.mergesTotal;
            this.mergesTotalDocs = o.mergesTotalDocs;
            this.mergesTotalSize = o.mergesTotalSize;
            this.mergesTotalTime = o.mergesTotalTime;
            this.name = o.name;
            this.nodeRole = o.nodeRole;
            this.nodeRoles = o.nodeRoles;
            this.pid = o.pid;
            this.port = o.port;
            this.queryCacheEvictions = o.queryCacheEvictions;
            this.queryCacheHitCount = o.queryCacheHitCount;
            this.queryCacheMemorySize = o.queryCacheMemorySize;
            this.queryCacheMissCount = o.queryCacheMissCount;
            this.ramCurrent = o.ramCurrent;
            this.ramMax = o.ramMax;
            this.ramPercent = o.ramPercent;
            this.refreshExternalTime = o.refreshExternalTime;
            this.refreshExternalTotal = o.refreshExternalTotal;
            this.refreshListeners = o.refreshListeners;
            this.refreshTime = o.refreshTime;
            this.refreshTotal = o.refreshTotal;
            this.requestCacheEvictions = o.requestCacheEvictions;
            this.requestCacheHitCount = o.requestCacheHitCount;
            this.requestCacheMemorySize = o.requestCacheMemorySize;
            this.requestCacheMissCount = o.requestCacheMissCount;
            this.scriptCacheEvictions = o.scriptCacheEvictions;
            this.scriptCompilationLimitTriggered = o.scriptCompilationLimitTriggered;
            this.scriptCompilations = o.scriptCompilations;
            this.searchConcurrentAvgSliceCount = o.searchConcurrentAvgSliceCount;
            this.searchConcurrentQueryCurrent = o.searchConcurrentQueryCurrent;
            this.searchConcurrentQueryTime = o.searchConcurrentQueryTime;
            this.searchConcurrentQueryTotal = o.searchConcurrentQueryTotal;
            this.searchFetchCurrent = o.searchFetchCurrent;
            this.searchFetchTime = o.searchFetchTime;
            this.searchFetchTotal = o.searchFetchTotal;
            this.searchOpenContexts = o.searchOpenContexts;
            this.searchPointInTimeCurrent = o.searchPointInTimeCurrent;
            this.searchPointInTimeTime = o.searchPointInTimeTime;
            this.searchPointInTimeTotal = o.searchPointInTimeTotal;
            this.searchQueryCurrent = o.searchQueryCurrent;
            this.searchQueryTime = o.searchQueryTime;
            this.searchQueryTotal = o.searchQueryTotal;
            this.searchScrollCurrent = o.searchScrollCurrent;
            this.searchScrollTime = o.searchScrollTime;
            this.searchScrollTotal = o.searchScrollTotal;
            this.segmentsCount = o.segmentsCount;
            this.segmentsFixedBitsetMemory = o.segmentsFixedBitsetMemory;
            this.segmentsIndexWriterMemory = o.segmentsIndexWriterMemory;
            this.segmentsMemory = o.segmentsMemory;
            this.segmentsVersionMapMemory = o.segmentsVersionMapMemory;
            this.suggestCurrent = o.suggestCurrent;
            this.suggestTime = o.suggestTime;
            this.suggestTotal = o.suggestTotal;
            this.type = o.type;
            this.uptime = o.uptime;
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.build = o.build;
            this.bulkAvgSizeInBytes = o.bulkAvgSizeInBytes;
            this.bulkAvgTime = o.bulkAvgTime;
            this.bulkTotalOperations = o.bulkTotalOperations;
            this.bulkTotalSizeInBytes = o.bulkTotalSizeInBytes;
            this.bulkTotalTime = o.bulkTotalTime;
            this.clusterManager = o.clusterManager;
            this.completionSize = o.completionSize;
            this.cpu = o.cpu;
            this.diskAvail = o.diskAvail;
            this.diskTotal = o.diskTotal;
            this.diskUsed = o.diskUsed;
            this.diskUsedPercent = o.diskUsedPercent;
            this.fielddataEvictions = o.fielddataEvictions;
            this.fielddataMemorySize = o.fielddataMemorySize;
            this.fileDescCurrent = o.fileDescCurrent;
            this.fileDescMax = o.fileDescMax;
            this.fileDescPercent = o.fileDescPercent;
            this.flavor = o.flavor;
            this.flushTotal = o.flushTotal;
            this.flushTotalTime = o.flushTotalTime;
            this.getCurrent = o.getCurrent;
            this.getExistsTime = o.getExistsTime;
            this.getExistsTotal = o.getExistsTotal;
            this.getMissingTime = o.getMissingTime;
            this.getMissingTotal = o.getMissingTotal;
            this.getTime = o.getTime;
            this.getTotal = o.getTotal;
            this.heapCurrent = o.heapCurrent;
            this.heapMax = o.heapMax;
            this.heapPercent = o.heapPercent;
            this.httpAddress = o.httpAddress;
            this.id = o.id;
            this.indexingDeleteCurrent = o.indexingDeleteCurrent;
            this.indexingDeleteTime = o.indexingDeleteTime;
            this.indexingDeleteTotal = o.indexingDeleteTotal;
            this.indexingIndexCurrent = o.indexingIndexCurrent;
            this.indexingIndexFailed = o.indexingIndexFailed;
            this.indexingIndexTime = o.indexingIndexTime;
            this.indexingIndexTotal = o.indexingIndexTotal;
            this.ip = o.ip;
            this.jdk = o.jdk;
            this.load15m = o.load15m;
            this.load1m = o.load1m;
            this.load5m = o.load5m;
            this.master = o.master;
            this.mergesCurrent = o.mergesCurrent;
            this.mergesCurrentDocs = o.mergesCurrentDocs;
            this.mergesCurrentSize = o.mergesCurrentSize;
            this.mergesTotal = o.mergesTotal;
            this.mergesTotalDocs = o.mergesTotalDocs;
            this.mergesTotalSize = o.mergesTotalSize;
            this.mergesTotalTime = o.mergesTotalTime;
            this.name = o.name;
            this.nodeRole = o.nodeRole;
            this.nodeRoles = o.nodeRoles;
            this.pid = o.pid;
            this.port = o.port;
            this.queryCacheEvictions = o.queryCacheEvictions;
            this.queryCacheHitCount = o.queryCacheHitCount;
            this.queryCacheMemorySize = o.queryCacheMemorySize;
            this.queryCacheMissCount = o.queryCacheMissCount;
            this.ramCurrent = o.ramCurrent;
            this.ramMax = o.ramMax;
            this.ramPercent = o.ramPercent;
            this.refreshExternalTime = o.refreshExternalTime;
            this.refreshExternalTotal = o.refreshExternalTotal;
            this.refreshListeners = o.refreshListeners;
            this.refreshTime = o.refreshTime;
            this.refreshTotal = o.refreshTotal;
            this.requestCacheEvictions = o.requestCacheEvictions;
            this.requestCacheHitCount = o.requestCacheHitCount;
            this.requestCacheMemorySize = o.requestCacheMemorySize;
            this.requestCacheMissCount = o.requestCacheMissCount;
            this.scriptCacheEvictions = o.scriptCacheEvictions;
            this.scriptCompilationLimitTriggered = o.scriptCompilationLimitTriggered;
            this.scriptCompilations = o.scriptCompilations;
            this.searchConcurrentAvgSliceCount = o.searchConcurrentAvgSliceCount;
            this.searchConcurrentQueryCurrent = o.searchConcurrentQueryCurrent;
            this.searchConcurrentQueryTime = o.searchConcurrentQueryTime;
            this.searchConcurrentQueryTotal = o.searchConcurrentQueryTotal;
            this.searchFetchCurrent = o.searchFetchCurrent;
            this.searchFetchTime = o.searchFetchTime;
            this.searchFetchTotal = o.searchFetchTotal;
            this.searchOpenContexts = o.searchOpenContexts;
            this.searchPointInTimeCurrent = o.searchPointInTimeCurrent;
            this.searchPointInTimeTime = o.searchPointInTimeTime;
            this.searchPointInTimeTotal = o.searchPointInTimeTotal;
            this.searchQueryCurrent = o.searchQueryCurrent;
            this.searchQueryTime = o.searchQueryTime;
            this.searchQueryTotal = o.searchQueryTotal;
            this.searchScrollCurrent = o.searchScrollCurrent;
            this.searchScrollTime = o.searchScrollTime;
            this.searchScrollTotal = o.searchScrollTotal;
            this.segmentsCount = o.segmentsCount;
            this.segmentsFixedBitsetMemory = o.segmentsFixedBitsetMemory;
            this.segmentsIndexWriterMemory = o.segmentsIndexWriterMemory;
            this.segmentsMemory = o.segmentsMemory;
            this.segmentsVersionMapMemory = o.segmentsVersionMapMemory;
            this.suggestCurrent = o.suggestCurrent;
            this.suggestTime = o.suggestTime;
            this.suggestTotal = o.suggestTotal;
            this.type = o.type;
            this.uptime = o.uptime;
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The OpenSearch build hash.
         * <p>
         * API name: {@code build}
         * </p>
         */
        @Nonnull
        public final Builder build(@Nullable String value) {
            this.build = value;
            return this;
        }

        /**
         * The average size in bytes of shard bulk.
         * <p>
         * API name: {@code bulk.avg_size_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder bulkAvgSizeInBytes(@Nullable String value) {
            this.bulkAvgSizeInBytes = value;
            return this;
        }

        /**
         * The average time spend in shard bulk.
         * <p>
         * API name: {@code bulk.avg_time}
         * </p>
         */
        @Nonnull
        public final Builder bulkAvgTime(@Nullable String value) {
            this.bulkAvgTime = value;
            return this;
        }

        /**
         * The number of bulk shard operations.
         * <p>
         * API name: {@code bulk.total_operations}
         * </p>
         */
        @Nonnull
        public final Builder bulkTotalOperations(@Nullable String value) {
            this.bulkTotalOperations = value;
            return this;
        }

        /**
         * The total size in bytes of shard bulk.
         * <p>
         * API name: {@code bulk.total_size_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder bulkTotalSizeInBytes(@Nullable String value) {
            this.bulkTotalSizeInBytes = value;
            return this;
        }

        /**
         * The time spend in shard bulk.
         * <p>
         * API name: {@code bulk.total_time}
         * </p>
         */
        @Nonnull
        public final Builder bulkTotalTime(@Nullable String value) {
            this.bulkTotalTime = value;
            return this;
        }

        /**
         * Indicates whether the node is the elected cluster-manager node. Returned values include <code>*</code>(elected cluster-manager)
         * and <code>-</code>(not elected cluster-manager).
         * <p>
         * API name: {@code cluster_manager}
         * </p>
         */
        @Nonnull
        public final Builder clusterManager(@Nullable String value) {
            this.clusterManager = value;
            return this;
        }

        /**
         * The size of completion.
         * <p>
         * API name: {@code completion.size}
         * </p>
         */
        @Nonnull
        public final Builder completionSize(@Nullable String value) {
            this.completionSize = value;
            return this;
        }

        /**
         * The recent system CPU usage as a percentage.
         * <p>
         * API name: {@code cpu}
         * </p>
         */
        @Nonnull
        public final Builder cpu(@Nullable String value) {
            this.cpu = value;
            return this;
        }

        /**
         * API name: {@code disk.avail}
         */
        @Nonnull
        public final Builder diskAvail(@Nullable String value) {
            this.diskAvail = value;
            return this;
        }

        /**
         * API name: {@code disk.total}
         */
        @Nonnull
        public final Builder diskTotal(@Nullable String value) {
            this.diskTotal = value;
            return this;
        }

        /**
         * API name: {@code disk.used}
         */
        @Nonnull
        public final Builder diskUsed(@Nullable String value) {
            this.diskUsed = value;
            return this;
        }

        /**
         * API name: {@code disk.used_percent}
         */
        @Nonnull
        public final Builder diskUsedPercent(@Nullable String value) {
            this.diskUsedPercent = value;
            return this;
        }

        /**
         * The field data evictions.
         * <p>
         * API name: {@code fielddata.evictions}
         * </p>
         */
        @Nonnull
        public final Builder fielddataEvictions(@Nullable String value) {
            this.fielddataEvictions = value;
            return this;
        }

        /**
         * The used field data cache.
         * <p>
         * API name: {@code fielddata.memory_size}
         * </p>
         */
        @Nonnull
        public final Builder fielddataMemorySize(@Nullable String value) {
            this.fielddataMemorySize = value;
            return this;
        }

        /**
         * The used file descriptors.
         * <p>
         * API name: {@code file_desc.current}
         * </p>
         */
        @Nonnull
        public final Builder fileDescCurrent(@Nullable String value) {
            this.fileDescCurrent = value;
            return this;
        }

        /**
         * The maximum number of file descriptors.
         * <p>
         * API name: {@code file_desc.max}
         * </p>
         */
        @Nonnull
        public final Builder fileDescMax(@Nullable String value) {
            this.fileDescMax = value;
            return this;
        }

        /**
         * API name: {@code file_desc.percent}
         */
        @Nonnull
        public final Builder fileDescPercent(@Nullable String value) {
            this.fileDescPercent = value;
            return this;
        }

        /**
         * The OpenSearch distribution flavor.
         * <p>
         * API name: {@code flavor}
         * </p>
         */
        @Nonnull
        public final Builder flavor(@Nullable String value) {
            this.flavor = value;
            return this;
        }

        /**
         * The number of flushes.
         * <p>
         * API name: {@code flush.total}
         * </p>
         */
        @Nonnull
        public final Builder flushTotal(@Nullable String value) {
            this.flushTotal = value;
            return this;
        }

        /**
         * The time spent in flush.
         * <p>
         * API name: {@code flush.total_time}
         * </p>
         */
        @Nonnull
        public final Builder flushTotalTime(@Nullable String value) {
            this.flushTotalTime = value;
            return this;
        }

        /**
         * The number of current get ops.
         * <p>
         * API name: {@code get.current}
         * </p>
         */
        @Nonnull
        public final Builder getCurrent(@Nullable String value) {
            this.getCurrent = value;
            return this;
        }

        /**
         * The time spent in successful gets.
         * <p>
         * API name: {@code get.exists_time}
         * </p>
         */
        @Nonnull
        public final Builder getExistsTime(@Nullable String value) {
            this.getExistsTime = value;
            return this;
        }

        /**
         * The number of successful get operations.
         * <p>
         * API name: {@code get.exists_total}
         * </p>
         */
        @Nonnull
        public final Builder getExistsTotal(@Nullable String value) {
            this.getExistsTotal = value;
            return this;
        }

        /**
         * The time spent in failed gets.
         * <p>
         * API name: {@code get.missing_time}
         * </p>
         */
        @Nonnull
        public final Builder getMissingTime(@Nullable String value) {
            this.getMissingTime = value;
            return this;
        }

        /**
         * The number of failed gets.
         * <p>
         * API name: {@code get.missing_total}
         * </p>
         */
        @Nonnull
        public final Builder getMissingTotal(@Nullable String value) {
            this.getMissingTotal = value;
            return this;
        }

        /**
         * The time spent in get.
         * <p>
         * API name: {@code get.time}
         * </p>
         */
        @Nonnull
        public final Builder getTime(@Nullable String value) {
            this.getTime = value;
            return this;
        }

        /**
         * The number of get ops.
         * <p>
         * API name: {@code get.total}
         * </p>
         */
        @Nonnull
        public final Builder getTotal(@Nullable String value) {
            this.getTotal = value;
            return this;
        }

        /**
         * The used heap.
         * <p>
         * API name: {@code heap.current}
         * </p>
         */
        @Nonnull
        public final Builder heapCurrent(@Nullable String value) {
            this.heapCurrent = value;
            return this;
        }

        /**
         * The maximum configured heap.
         * <p>
         * API name: {@code heap.max}
         * </p>
         */
        @Nonnull
        public final Builder heapMax(@Nullable String value) {
            this.heapMax = value;
            return this;
        }

        /**
         * API name: {@code heap.percent}
         */
        @Nonnull
        public final Builder heapPercent(@Nullable String value) {
            this.heapPercent = value;
            return this;
        }

        /**
         * The bound HTTP address.
         * <p>
         * API name: {@code http_address}
         * </p>
         */
        @Nonnull
        public final Builder httpAddress(@Nullable String value) {
            this.httpAddress = value;
            return this;
        }

        /**
         * API name: {@code id}
         */
        @Nonnull
        public final Builder id(@Nullable String value) {
            this.id = value;
            return this;
        }

        /**
         * The number of current deletions.
         * <p>
         * API name: {@code indexing.delete_current}
         * </p>
         */
        @Nonnull
        public final Builder indexingDeleteCurrent(@Nullable String value) {
            this.indexingDeleteCurrent = value;
            return this;
        }

        /**
         * The time spent in deletions.
         * <p>
         * API name: {@code indexing.delete_time}
         * </p>
         */
        @Nonnull
        public final Builder indexingDeleteTime(@Nullable String value) {
            this.indexingDeleteTime = value;
            return this;
        }

        /**
         * The number of delete operations.
         * <p>
         * API name: {@code indexing.delete_total}
         * </p>
         */
        @Nonnull
        public final Builder indexingDeleteTotal(@Nullable String value) {
            this.indexingDeleteTotal = value;
            return this;
        }

        /**
         * The number of current indexing operations.
         * <p>
         * API name: {@code indexing.index_current}
         * </p>
         */
        @Nonnull
        public final Builder indexingIndexCurrent(@Nullable String value) {
            this.indexingIndexCurrent = value;
            return this;
        }

        /**
         * The number of failed indexing operations.
         * <p>
         * API name: {@code indexing.index_failed}
         * </p>
         */
        @Nonnull
        public final Builder indexingIndexFailed(@Nullable String value) {
            this.indexingIndexFailed = value;
            return this;
        }

        /**
         * The time spent in indexing.
         * <p>
         * API name: {@code indexing.index_time}
         * </p>
         */
        @Nonnull
        public final Builder indexingIndexTime(@Nullable String value) {
            this.indexingIndexTime = value;
            return this;
        }

        /**
         * The number of indexing operations.
         * <p>
         * API name: {@code indexing.index_total}
         * </p>
         */
        @Nonnull
        public final Builder indexingIndexTotal(@Nullable String value) {
            this.indexingIndexTotal = value;
            return this;
        }

        /**
         * The IP address.
         * <p>
         * API name: {@code ip}
         * </p>
         */
        @Nonnull
        public final Builder ip(@Nullable String value) {
            this.ip = value;
            return this;
        }

        /**
         * The Java version.
         * <p>
         * API name: {@code jdk}
         * </p>
         */
        @Nonnull
        public final Builder jdk(@Nullable String value) {
            this.jdk = value;
            return this;
        }

        /**
         * The load average for the last fifteen minutes.
         * <p>
         * API name: {@code load_15m}
         * </p>
         */
        @Nonnull
        public final Builder load15m(@Nullable String value) {
            this.load15m = value;
            return this;
        }

        /**
         * The load average for the most recent minute.
         * <p>
         * API name: {@code load_1m}
         * </p>
         */
        @Nonnull
        public final Builder load1m(@Nullable String value) {
            this.load1m = value;
            return this;
        }

        /**
         * The load average for the last five minutes.
         * <p>
         * API name: {@code load_5m}
         * </p>
         */
        @Nonnull
        public final Builder load5m(@Nullable String value) {
            this.load5m = value;
            return this;
        }

        /**
         * Indicates whether the node is the elected cluster-manager node. Returned values include <code>*</code>(elected cluster manager)
         * and <code>-</code>(not elected cluster manager).
         * <p>
         * API name: {@code master}
         * </p>
         */
        @Nonnull
        public final Builder master(@Nullable String value) {
            this.master = value;
            return this;
        }

        /**
         * The number of current merges.
         * <p>
         * API name: {@code merges.current}
         * </p>
         */
        @Nonnull
        public final Builder mergesCurrent(@Nullable String value) {
            this.mergesCurrent = value;
            return this;
        }

        /**
         * The number of current merging docs.
         * <p>
         * API name: {@code merges.current_docs}
         * </p>
         */
        @Nonnull
        public final Builder mergesCurrentDocs(@Nullable String value) {
            this.mergesCurrentDocs = value;
            return this;
        }

        /**
         * The size of current merges.
         * <p>
         * API name: {@code merges.current_size}
         * </p>
         */
        @Nonnull
        public final Builder mergesCurrentSize(@Nullable String value) {
            this.mergesCurrentSize = value;
            return this;
        }

        /**
         * The number of completed merge operations.
         * <p>
         * API name: {@code merges.total}
         * </p>
         */
        @Nonnull
        public final Builder mergesTotal(@Nullable String value) {
            this.mergesTotal = value;
            return this;
        }

        /**
         * The docs merged.
         * <p>
         * API name: {@code merges.total_docs}
         * </p>
         */
        @Nonnull
        public final Builder mergesTotalDocs(@Nullable String value) {
            this.mergesTotalDocs = value;
            return this;
        }

        /**
         * The size merged.
         * <p>
         * API name: {@code merges.total_size}
         * </p>
         */
        @Nonnull
        public final Builder mergesTotalSize(@Nullable String value) {
            this.mergesTotalSize = value;
            return this;
        }

        /**
         * The time spent in merges.
         * <p>
         * API name: {@code merges.total_time}
         * </p>
         */
        @Nonnull
        public final Builder mergesTotalTime(@Nullable String value) {
            this.mergesTotalTime = value;
            return this;
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
         * The roles of the node. Returned values include <code>c</code>(cold node), <code>d</code>(data node), <code>f</code>(frozen node),
         * <code>h</code>(hot node), <code>i</code>(ingest node), <code>l</code>(machine learning node), <code>m</code> (cluster-manager
         * eligible node), <code>r</code>(remote cluster client node), <code>s</code>(content node), <code>t</code>(transform node),
         * <code>v</code>(voting-only node), <code>w</code>(warm node),and <code>-</code>(coordinating node only).
         * <p>
         * API name: {@code node.role}
         * </p>
         */
        @Nonnull
        public final Builder nodeRole(@Nullable String value) {
            this.nodeRole = value;
            return this;
        }

        /**
         * A comma-separated list of the roles of the node. Returned values may include but are not limited to: <code>data</code>,
         * <code>ingest</code>, <code>master</code>, <code>cluster_manager</code>, <code>remote_cluster_client</code>, <code>search</code>,
         * and <code>-</code>(coordinating node only).
         * <p>
         * API name: {@code node.roles}
         * </p>
         */
        @Nonnull
        public final Builder nodeRoles(@Nullable String value) {
            this.nodeRoles = value;
            return this;
        }

        /**
         * The process identifier.
         * <p>
         * API name: {@code pid}
         * </p>
         */
        @Nonnull
        public final Builder pid(@Nullable String value) {
            this.pid = value;
            return this;
        }

        /**
         * The bound transport port.
         * <p>
         * API name: {@code port}
         * </p>
         */
        @Nonnull
        public final Builder port(@Nullable String value) {
            this.port = value;
            return this;
        }

        /**
         * The query cache evictions.
         * <p>
         * API name: {@code query_cache.evictions}
         * </p>
         */
        @Nonnull
        public final Builder queryCacheEvictions(@Nullable String value) {
            this.queryCacheEvictions = value;
            return this;
        }

        /**
         * The query cache hit counts.
         * <p>
         * API name: {@code query_cache.hit_count}
         * </p>
         */
        @Nonnull
        public final Builder queryCacheHitCount(@Nullable String value) {
            this.queryCacheHitCount = value;
            return this;
        }

        /**
         * The used query cache.
         * <p>
         * API name: {@code query_cache.memory_size}
         * </p>
         */
        @Nonnull
        public final Builder queryCacheMemorySize(@Nullable String value) {
            this.queryCacheMemorySize = value;
            return this;
        }

        /**
         * The query cache miss counts.
         * <p>
         * API name: {@code query_cache.miss_count}
         * </p>
         */
        @Nonnull
        public final Builder queryCacheMissCount(@Nullable String value) {
            this.queryCacheMissCount = value;
            return this;
        }

        /**
         * The used machine memory.
         * <p>
         * API name: {@code ram.current}
         * </p>
         */
        @Nonnull
        public final Builder ramCurrent(@Nullable String value) {
            this.ramCurrent = value;
            return this;
        }

        /**
         * The total machine memory.
         * <p>
         * API name: {@code ram.max}
         * </p>
         */
        @Nonnull
        public final Builder ramMax(@Nullable String value) {
            this.ramMax = value;
            return this;
        }

        /**
         * API name: {@code ram.percent}
         */
        @Nonnull
        public final Builder ramPercent(@Nullable String value) {
            this.ramPercent = value;
            return this;
        }

        /**
         * The time spent in external refreshes.
         * <p>
         * API name: {@code refresh.external_time}
         * </p>
         */
        @Nonnull
        public final Builder refreshExternalTime(@Nullable String value) {
            this.refreshExternalTime = value;
            return this;
        }

        /**
         * The total external refreshes.
         * <p>
         * API name: {@code refresh.external_total}
         * </p>
         */
        @Nonnull
        public final Builder refreshExternalTotal(@Nullable String value) {
            this.refreshExternalTotal = value;
            return this;
        }

        /**
         * The number of pending refresh listeners.
         * <p>
         * API name: {@code refresh.listeners}
         * </p>
         */
        @Nonnull
        public final Builder refreshListeners(@Nullable String value) {
            this.refreshListeners = value;
            return this;
        }

        /**
         * The time spent in refreshes.
         * <p>
         * API name: {@code refresh.time}
         * </p>
         */
        @Nonnull
        public final Builder refreshTime(@Nullable String value) {
            this.refreshTime = value;
            return this;
        }

        /**
         * The total refreshes.
         * <p>
         * API name: {@code refresh.total}
         * </p>
         */
        @Nonnull
        public final Builder refreshTotal(@Nullable String value) {
            this.refreshTotal = value;
            return this;
        }

        /**
         * The request cache evictions.
         * <p>
         * API name: {@code request_cache.evictions}
         * </p>
         */
        @Nonnull
        public final Builder requestCacheEvictions(@Nullable String value) {
            this.requestCacheEvictions = value;
            return this;
        }

        /**
         * The request cache hit counts.
         * <p>
         * API name: {@code request_cache.hit_count}
         * </p>
         */
        @Nonnull
        public final Builder requestCacheHitCount(@Nullable String value) {
            this.requestCacheHitCount = value;
            return this;
        }

        /**
         * The used request cache.
         * <p>
         * API name: {@code request_cache.memory_size}
         * </p>
         */
        @Nonnull
        public final Builder requestCacheMemorySize(@Nullable String value) {
            this.requestCacheMemorySize = value;
            return this;
        }

        /**
         * The request cache miss counts.
         * <p>
         * API name: {@code request_cache.miss_count}
         * </p>
         */
        @Nonnull
        public final Builder requestCacheMissCount(@Nullable String value) {
            this.requestCacheMissCount = value;
            return this;
        }

        /**
         * The total compiled scripts evicted from the cache.
         * <p>
         * API name: {@code script.cache_evictions}
         * </p>
         */
        @Nonnull
        public final Builder scriptCacheEvictions(@Nullable String value) {
            this.scriptCacheEvictions = value;
            return this;
        }

        /**
         * The script cache compilation limit triggered.
         * <p>
         * API name: {@code script.compilation_limit_triggered}
         * </p>
         */
        @Nonnull
        public final Builder scriptCompilationLimitTriggered(@Nullable String value) {
            this.scriptCompilationLimitTriggered = value;
            return this;
        }

        /**
         * The total script compilations.
         * <p>
         * API name: {@code script.compilations}
         * </p>
         */
        @Nonnull
        public final Builder scriptCompilations(@Nullable String value) {
            this.scriptCompilations = value;
            return this;
        }

        /**
         * API name: {@code search.concurrent_avg_slice_count}
         */
        @Nonnull
        public final Builder searchConcurrentAvgSliceCount(@Nullable String value) {
            this.searchConcurrentAvgSliceCount = value;
            return this;
        }

        /**
         * API name: {@code search.concurrent_query_current}
         */
        @Nonnull
        public final Builder searchConcurrentQueryCurrent(@Nullable String value) {
            this.searchConcurrentQueryCurrent = value;
            return this;
        }

        /**
         * API name: {@code search.concurrent_query_time}
         */
        @Nonnull
        public final Builder searchConcurrentQueryTime(@Nullable String value) {
            this.searchConcurrentQueryTime = value;
            return this;
        }

        /**
         * API name: {@code search.concurrent_query_total}
         */
        @Nonnull
        public final Builder searchConcurrentQueryTotal(@Nullable String value) {
            this.searchConcurrentQueryTotal = value;
            return this;
        }

        /**
         * The current fetch phase operations.
         * <p>
         * API name: {@code search.fetch_current}
         * </p>
         */
        @Nonnull
        public final Builder searchFetchCurrent(@Nullable String value) {
            this.searchFetchCurrent = value;
            return this;
        }

        /**
         * The time spent in fetch phase.
         * <p>
         * API name: {@code search.fetch_time}
         * </p>
         */
        @Nonnull
        public final Builder searchFetchTime(@Nullable String value) {
            this.searchFetchTime = value;
            return this;
        }

        /**
         * The total fetch operations.
         * <p>
         * API name: {@code search.fetch_total}
         * </p>
         */
        @Nonnull
        public final Builder searchFetchTotal(@Nullable String value) {
            this.searchFetchTotal = value;
            return this;
        }

        /**
         * The open search contexts.
         * <p>
         * API name: {@code search.open_contexts}
         * </p>
         */
        @Nonnull
        public final Builder searchOpenContexts(@Nullable String value) {
            this.searchOpenContexts = value;
            return this;
        }

        /**
         * API name: {@code search.point_in_time_current}
         */
        @Nonnull
        public final Builder searchPointInTimeCurrent(@Nullable String value) {
            this.searchPointInTimeCurrent = value;
            return this;
        }

        /**
         * API name: {@code search.point_in_time_time}
         */
        @Nonnull
        public final Builder searchPointInTimeTime(@Nullable String value) {
            this.searchPointInTimeTime = value;
            return this;
        }

        /**
         * API name: {@code search.point_in_time_total}
         */
        @Nonnull
        public final Builder searchPointInTimeTotal(@Nullable String value) {
            this.searchPointInTimeTotal = value;
            return this;
        }

        /**
         * The current query phase operations.
         * <p>
         * API name: {@code search.query_current}
         * </p>
         */
        @Nonnull
        public final Builder searchQueryCurrent(@Nullable String value) {
            this.searchQueryCurrent = value;
            return this;
        }

        /**
         * The time spent in query phase.
         * <p>
         * API name: {@code search.query_time}
         * </p>
         */
        @Nonnull
        public final Builder searchQueryTime(@Nullable String value) {
            this.searchQueryTime = value;
            return this;
        }

        /**
         * The total query phase operations.
         * <p>
         * API name: {@code search.query_total}
         * </p>
         */
        @Nonnull
        public final Builder searchQueryTotal(@Nullable String value) {
            this.searchQueryTotal = value;
            return this;
        }

        /**
         * The open scroll contexts.
         * <p>
         * API name: {@code search.scroll_current}
         * </p>
         */
        @Nonnull
        public final Builder searchScrollCurrent(@Nullable String value) {
            this.searchScrollCurrent = value;
            return this;
        }

        /**
         * The time scroll contexts held open.
         * <p>
         * API name: {@code search.scroll_time}
         * </p>
         */
        @Nonnull
        public final Builder searchScrollTime(@Nullable String value) {
            this.searchScrollTime = value;
            return this;
        }

        /**
         * The completed scroll contexts.
         * <p>
         * API name: {@code search.scroll_total}
         * </p>
         */
        @Nonnull
        public final Builder searchScrollTotal(@Nullable String value) {
            this.searchScrollTotal = value;
            return this;
        }

        /**
         * The number of segments.
         * <p>
         * API name: {@code segments.count}
         * </p>
         */
        @Nonnull
        public final Builder segmentsCount(@Nullable String value) {
            this.segmentsCount = value;
            return this;
        }

        /**
         * The memory used by fixed bit sets for nested object field types and export type filters for types referred in
         * <code>_parent</code> fields.
         * <p>
         * API name: {@code segments.fixed_bitset_memory}
         * </p>
         */
        @Nonnull
        public final Builder segmentsFixedBitsetMemory(@Nullable String value) {
            this.segmentsFixedBitsetMemory = value;
            return this;
        }

        /**
         * The memory used by the index writer.
         * <p>
         * API name: {@code segments.index_writer_memory}
         * </p>
         */
        @Nonnull
        public final Builder segmentsIndexWriterMemory(@Nullable String value) {
            this.segmentsIndexWriterMemory = value;
            return this;
        }

        /**
         * The memory used by segments.
         * <p>
         * API name: {@code segments.memory}
         * </p>
         */
        @Nonnull
        public final Builder segmentsMemory(@Nullable String value) {
            this.segmentsMemory = value;
            return this;
        }

        /**
         * The memory used by the version map.
         * <p>
         * API name: {@code segments.version_map_memory}
         * </p>
         */
        @Nonnull
        public final Builder segmentsVersionMapMemory(@Nullable String value) {
            this.segmentsVersionMapMemory = value;
            return this;
        }

        /**
         * The number of current suggest operations.
         * <p>
         * API name: {@code suggest.current}
         * </p>
         */
        @Nonnull
        public final Builder suggestCurrent(@Nullable String value) {
            this.suggestCurrent = value;
            return this;
        }

        /**
         * The time spend in suggest.
         * <p>
         * API name: {@code suggest.time}
         * </p>
         */
        @Nonnull
        public final Builder suggestTime(@Nullable String value) {
            this.suggestTime = value;
            return this;
        }

        /**
         * The number of suggest operations.
         * <p>
         * API name: {@code suggest.total}
         * </p>
         */
        @Nonnull
        public final Builder suggestTotal(@Nullable String value) {
            this.suggestTotal = value;
            return this;
        }

        /**
         * The OpenSearch distribution type.
         * <p>
         * API name: {@code type}
         * </p>
         */
        @Nonnull
        public final Builder type(@Nullable String value) {
            this.type = value;
            return this;
        }

        /**
         * The node uptime.
         * <p>
         * API name: {@code uptime}
         * </p>
         */
        @Nonnull
        public final Builder uptime(@Nullable String value) {
            this.uptime = value;
            return this;
        }

        /**
         * API name: {@code version}
         */
        @Nonnull
        public final Builder version(@Nullable String value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link NodesRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodesRecord build() {
            _checkSingleUse();

            return new NodesRecord(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodesRecord}
     */
    public static final JsonpDeserializer<NodesRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodesRecord::setupNodesRecordDeserializer
    );

    protected static void setupNodesRecordDeserializer(ObjectDeserializer<NodesRecord.Builder> op) {
        op.add(Builder::build, JsonpDeserializer.stringDeserializer(), "build");
        op.add(Builder::bulkAvgSizeInBytes, JsonpDeserializer.stringDeserializer(), "bulk.avg_size_in_bytes");
        op.add(Builder::bulkAvgTime, JsonpDeserializer.stringDeserializer(), "bulk.avg_time");
        op.add(Builder::bulkTotalOperations, JsonpDeserializer.stringDeserializer(), "bulk.total_operations");
        op.add(Builder::bulkTotalSizeInBytes, JsonpDeserializer.stringDeserializer(), "bulk.total_size_in_bytes");
        op.add(Builder::bulkTotalTime, JsonpDeserializer.stringDeserializer(), "bulk.total_time");
        op.add(Builder::clusterManager, JsonpDeserializer.stringDeserializer(), "cluster_manager");
        op.add(Builder::completionSize, JsonpDeserializer.stringDeserializer(), "completion.size");
        op.add(Builder::cpu, JsonpDeserializer.stringDeserializer(), "cpu");
        op.add(Builder::diskAvail, JsonpDeserializer.stringDeserializer(), "disk.avail");
        op.add(Builder::diskTotal, JsonpDeserializer.stringDeserializer(), "disk.total");
        op.add(Builder::diskUsed, JsonpDeserializer.stringDeserializer(), "disk.used");
        op.add(Builder::diskUsedPercent, JsonpDeserializer.stringDeserializer(), "disk.used_percent");
        op.add(Builder::fielddataEvictions, JsonpDeserializer.stringDeserializer(), "fielddata.evictions");
        op.add(Builder::fielddataMemorySize, JsonpDeserializer.stringDeserializer(), "fielddata.memory_size");
        op.add(Builder::fileDescCurrent, JsonpDeserializer.stringDeserializer(), "file_desc.current");
        op.add(Builder::fileDescMax, JsonpDeserializer.stringDeserializer(), "file_desc.max");
        op.add(Builder::fileDescPercent, JsonpDeserializer.stringDeserializer(), "file_desc.percent");
        op.add(Builder::flavor, JsonpDeserializer.stringDeserializer(), "flavor");
        op.add(Builder::flushTotal, JsonpDeserializer.stringDeserializer(), "flush.total");
        op.add(Builder::flushTotalTime, JsonpDeserializer.stringDeserializer(), "flush.total_time");
        op.add(Builder::getCurrent, JsonpDeserializer.stringDeserializer(), "get.current");
        op.add(Builder::getExistsTime, JsonpDeserializer.stringDeserializer(), "get.exists_time");
        op.add(Builder::getExistsTotal, JsonpDeserializer.stringDeserializer(), "get.exists_total");
        op.add(Builder::getMissingTime, JsonpDeserializer.stringDeserializer(), "get.missing_time");
        op.add(Builder::getMissingTotal, JsonpDeserializer.stringDeserializer(), "get.missing_total");
        op.add(Builder::getTime, JsonpDeserializer.stringDeserializer(), "get.time");
        op.add(Builder::getTotal, JsonpDeserializer.stringDeserializer(), "get.total");
        op.add(Builder::heapCurrent, JsonpDeserializer.stringDeserializer(), "heap.current");
        op.add(Builder::heapMax, JsonpDeserializer.stringDeserializer(), "heap.max");
        op.add(Builder::heapPercent, JsonpDeserializer.stringDeserializer(), "heap.percent");
        op.add(Builder::httpAddress, JsonpDeserializer.stringDeserializer(), "http_address");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::indexingDeleteCurrent, JsonpDeserializer.stringDeserializer(), "indexing.delete_current");
        op.add(Builder::indexingDeleteTime, JsonpDeserializer.stringDeserializer(), "indexing.delete_time");
        op.add(Builder::indexingDeleteTotal, JsonpDeserializer.stringDeserializer(), "indexing.delete_total");
        op.add(Builder::indexingIndexCurrent, JsonpDeserializer.stringDeserializer(), "indexing.index_current");
        op.add(Builder::indexingIndexFailed, JsonpDeserializer.stringDeserializer(), "indexing.index_failed");
        op.add(Builder::indexingIndexTime, JsonpDeserializer.stringDeserializer(), "indexing.index_time");
        op.add(Builder::indexingIndexTotal, JsonpDeserializer.stringDeserializer(), "indexing.index_total");
        op.add(Builder::ip, JsonpDeserializer.stringDeserializer(), "ip");
        op.add(Builder::jdk, JsonpDeserializer.stringDeserializer(), "jdk");
        op.add(Builder::load15m, JsonpDeserializer.stringDeserializer(), "load_15m");
        op.add(Builder::load1m, JsonpDeserializer.stringDeserializer(), "load_1m");
        op.add(Builder::load5m, JsonpDeserializer.stringDeserializer(), "load_5m");
        op.add(Builder::master, JsonpDeserializer.stringDeserializer(), "master");
        op.add(Builder::mergesCurrent, JsonpDeserializer.stringDeserializer(), "merges.current");
        op.add(Builder::mergesCurrentDocs, JsonpDeserializer.stringDeserializer(), "merges.current_docs");
        op.add(Builder::mergesCurrentSize, JsonpDeserializer.stringDeserializer(), "merges.current_size");
        op.add(Builder::mergesTotal, JsonpDeserializer.stringDeserializer(), "merges.total");
        op.add(Builder::mergesTotalDocs, JsonpDeserializer.stringDeserializer(), "merges.total_docs");
        op.add(Builder::mergesTotalSize, JsonpDeserializer.stringDeserializer(), "merges.total_size");
        op.add(Builder::mergesTotalTime, JsonpDeserializer.stringDeserializer(), "merges.total_time");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::nodeRole, JsonpDeserializer.stringDeserializer(), "node.role");
        op.add(Builder::nodeRoles, JsonpDeserializer.stringDeserializer(), "node.roles");
        op.add(Builder::pid, JsonpDeserializer.stringDeserializer(), "pid");
        op.add(Builder::port, JsonpDeserializer.stringDeserializer(), "port");
        op.add(Builder::queryCacheEvictions, JsonpDeserializer.stringDeserializer(), "query_cache.evictions");
        op.add(Builder::queryCacheHitCount, JsonpDeserializer.stringDeserializer(), "query_cache.hit_count");
        op.add(Builder::queryCacheMemorySize, JsonpDeserializer.stringDeserializer(), "query_cache.memory_size");
        op.add(Builder::queryCacheMissCount, JsonpDeserializer.stringDeserializer(), "query_cache.miss_count");
        op.add(Builder::ramCurrent, JsonpDeserializer.stringDeserializer(), "ram.current");
        op.add(Builder::ramMax, JsonpDeserializer.stringDeserializer(), "ram.max");
        op.add(Builder::ramPercent, JsonpDeserializer.stringDeserializer(), "ram.percent");
        op.add(Builder::refreshExternalTime, JsonpDeserializer.stringDeserializer(), "refresh.external_time");
        op.add(Builder::refreshExternalTotal, JsonpDeserializer.stringDeserializer(), "refresh.external_total");
        op.add(Builder::refreshListeners, JsonpDeserializer.stringDeserializer(), "refresh.listeners");
        op.add(Builder::refreshTime, JsonpDeserializer.stringDeserializer(), "refresh.time");
        op.add(Builder::refreshTotal, JsonpDeserializer.stringDeserializer(), "refresh.total");
        op.add(Builder::requestCacheEvictions, JsonpDeserializer.stringDeserializer(), "request_cache.evictions");
        op.add(Builder::requestCacheHitCount, JsonpDeserializer.stringDeserializer(), "request_cache.hit_count");
        op.add(Builder::requestCacheMemorySize, JsonpDeserializer.stringDeserializer(), "request_cache.memory_size");
        op.add(Builder::requestCacheMissCount, JsonpDeserializer.stringDeserializer(), "request_cache.miss_count");
        op.add(Builder::scriptCacheEvictions, JsonpDeserializer.stringDeserializer(), "script.cache_evictions");
        op.add(Builder::scriptCompilationLimitTriggered, JsonpDeserializer.stringDeserializer(), "script.compilation_limit_triggered");
        op.add(Builder::scriptCompilations, JsonpDeserializer.stringDeserializer(), "script.compilations");
        op.add(Builder::searchConcurrentAvgSliceCount, JsonpDeserializer.stringDeserializer(), "search.concurrent_avg_slice_count");
        op.add(Builder::searchConcurrentQueryCurrent, JsonpDeserializer.stringDeserializer(), "search.concurrent_query_current");
        op.add(Builder::searchConcurrentQueryTime, JsonpDeserializer.stringDeserializer(), "search.concurrent_query_time");
        op.add(Builder::searchConcurrentQueryTotal, JsonpDeserializer.stringDeserializer(), "search.concurrent_query_total");
        op.add(Builder::searchFetchCurrent, JsonpDeserializer.stringDeserializer(), "search.fetch_current");
        op.add(Builder::searchFetchTime, JsonpDeserializer.stringDeserializer(), "search.fetch_time");
        op.add(Builder::searchFetchTotal, JsonpDeserializer.stringDeserializer(), "search.fetch_total");
        op.add(Builder::searchOpenContexts, JsonpDeserializer.stringDeserializer(), "search.open_contexts");
        op.add(Builder::searchPointInTimeCurrent, JsonpDeserializer.stringDeserializer(), "search.point_in_time_current");
        op.add(Builder::searchPointInTimeTime, JsonpDeserializer.stringDeserializer(), "search.point_in_time_time");
        op.add(Builder::searchPointInTimeTotal, JsonpDeserializer.stringDeserializer(), "search.point_in_time_total");
        op.add(Builder::searchQueryCurrent, JsonpDeserializer.stringDeserializer(), "search.query_current");
        op.add(Builder::searchQueryTime, JsonpDeserializer.stringDeserializer(), "search.query_time");
        op.add(Builder::searchQueryTotal, JsonpDeserializer.stringDeserializer(), "search.query_total");
        op.add(Builder::searchScrollCurrent, JsonpDeserializer.stringDeserializer(), "search.scroll_current");
        op.add(Builder::searchScrollTime, JsonpDeserializer.stringDeserializer(), "search.scroll_time");
        op.add(Builder::searchScrollTotal, JsonpDeserializer.stringDeserializer(), "search.scroll_total");
        op.add(Builder::segmentsCount, JsonpDeserializer.stringDeserializer(), "segments.count");
        op.add(Builder::segmentsFixedBitsetMemory, JsonpDeserializer.stringDeserializer(), "segments.fixed_bitset_memory");
        op.add(Builder::segmentsIndexWriterMemory, JsonpDeserializer.stringDeserializer(), "segments.index_writer_memory");
        op.add(Builder::segmentsMemory, JsonpDeserializer.stringDeserializer(), "segments.memory");
        op.add(Builder::segmentsVersionMapMemory, JsonpDeserializer.stringDeserializer(), "segments.version_map_memory");
        op.add(Builder::suggestCurrent, JsonpDeserializer.stringDeserializer(), "suggest.current");
        op.add(Builder::suggestTime, JsonpDeserializer.stringDeserializer(), "suggest.time");
        op.add(Builder::suggestTotal, JsonpDeserializer.stringDeserializer(), "suggest.total");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
        op.add(Builder::uptime, JsonpDeserializer.stringDeserializer(), "uptime");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.build);
        result = 31 * result + Objects.hashCode(this.bulkAvgSizeInBytes);
        result = 31 * result + Objects.hashCode(this.bulkAvgTime);
        result = 31 * result + Objects.hashCode(this.bulkTotalOperations);
        result = 31 * result + Objects.hashCode(this.bulkTotalSizeInBytes);
        result = 31 * result + Objects.hashCode(this.bulkTotalTime);
        result = 31 * result + Objects.hashCode(this.clusterManager);
        result = 31 * result + Objects.hashCode(this.completionSize);
        result = 31 * result + Objects.hashCode(this.cpu);
        result = 31 * result + Objects.hashCode(this.diskAvail);
        result = 31 * result + Objects.hashCode(this.diskTotal);
        result = 31 * result + Objects.hashCode(this.diskUsed);
        result = 31 * result + Objects.hashCode(this.diskUsedPercent);
        result = 31 * result + Objects.hashCode(this.fielddataEvictions);
        result = 31 * result + Objects.hashCode(this.fielddataMemorySize);
        result = 31 * result + Objects.hashCode(this.fileDescCurrent);
        result = 31 * result + Objects.hashCode(this.fileDescMax);
        result = 31 * result + Objects.hashCode(this.fileDescPercent);
        result = 31 * result + Objects.hashCode(this.flavor);
        result = 31 * result + Objects.hashCode(this.flushTotal);
        result = 31 * result + Objects.hashCode(this.flushTotalTime);
        result = 31 * result + Objects.hashCode(this.getCurrent);
        result = 31 * result + Objects.hashCode(this.getExistsTime);
        result = 31 * result + Objects.hashCode(this.getExistsTotal);
        result = 31 * result + Objects.hashCode(this.getMissingTime);
        result = 31 * result + Objects.hashCode(this.getMissingTotal);
        result = 31 * result + Objects.hashCode(this.getTime);
        result = 31 * result + Objects.hashCode(this.getTotal);
        result = 31 * result + Objects.hashCode(this.heapCurrent);
        result = 31 * result + Objects.hashCode(this.heapMax);
        result = 31 * result + Objects.hashCode(this.heapPercent);
        result = 31 * result + Objects.hashCode(this.httpAddress);
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.indexingDeleteCurrent);
        result = 31 * result + Objects.hashCode(this.indexingDeleteTime);
        result = 31 * result + Objects.hashCode(this.indexingDeleteTotal);
        result = 31 * result + Objects.hashCode(this.indexingIndexCurrent);
        result = 31 * result + Objects.hashCode(this.indexingIndexFailed);
        result = 31 * result + Objects.hashCode(this.indexingIndexTime);
        result = 31 * result + Objects.hashCode(this.indexingIndexTotal);
        result = 31 * result + Objects.hashCode(this.ip);
        result = 31 * result + Objects.hashCode(this.jdk);
        result = 31 * result + Objects.hashCode(this.load15m);
        result = 31 * result + Objects.hashCode(this.load1m);
        result = 31 * result + Objects.hashCode(this.load5m);
        result = 31 * result + Objects.hashCode(this.master);
        result = 31 * result + Objects.hashCode(this.mergesCurrent);
        result = 31 * result + Objects.hashCode(this.mergesCurrentDocs);
        result = 31 * result + Objects.hashCode(this.mergesCurrentSize);
        result = 31 * result + Objects.hashCode(this.mergesTotal);
        result = 31 * result + Objects.hashCode(this.mergesTotalDocs);
        result = 31 * result + Objects.hashCode(this.mergesTotalSize);
        result = 31 * result + Objects.hashCode(this.mergesTotalTime);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.nodeRole);
        result = 31 * result + Objects.hashCode(this.nodeRoles);
        result = 31 * result + Objects.hashCode(this.pid);
        result = 31 * result + Objects.hashCode(this.port);
        result = 31 * result + Objects.hashCode(this.queryCacheEvictions);
        result = 31 * result + Objects.hashCode(this.queryCacheHitCount);
        result = 31 * result + Objects.hashCode(this.queryCacheMemorySize);
        result = 31 * result + Objects.hashCode(this.queryCacheMissCount);
        result = 31 * result + Objects.hashCode(this.ramCurrent);
        result = 31 * result + Objects.hashCode(this.ramMax);
        result = 31 * result + Objects.hashCode(this.ramPercent);
        result = 31 * result + Objects.hashCode(this.refreshExternalTime);
        result = 31 * result + Objects.hashCode(this.refreshExternalTotal);
        result = 31 * result + Objects.hashCode(this.refreshListeners);
        result = 31 * result + Objects.hashCode(this.refreshTime);
        result = 31 * result + Objects.hashCode(this.refreshTotal);
        result = 31 * result + Objects.hashCode(this.requestCacheEvictions);
        result = 31 * result + Objects.hashCode(this.requestCacheHitCount);
        result = 31 * result + Objects.hashCode(this.requestCacheMemorySize);
        result = 31 * result + Objects.hashCode(this.requestCacheMissCount);
        result = 31 * result + Objects.hashCode(this.scriptCacheEvictions);
        result = 31 * result + Objects.hashCode(this.scriptCompilationLimitTriggered);
        result = 31 * result + Objects.hashCode(this.scriptCompilations);
        result = 31 * result + Objects.hashCode(this.searchConcurrentAvgSliceCount);
        result = 31 * result + Objects.hashCode(this.searchConcurrentQueryCurrent);
        result = 31 * result + Objects.hashCode(this.searchConcurrentQueryTime);
        result = 31 * result + Objects.hashCode(this.searchConcurrentQueryTotal);
        result = 31 * result + Objects.hashCode(this.searchFetchCurrent);
        result = 31 * result + Objects.hashCode(this.searchFetchTime);
        result = 31 * result + Objects.hashCode(this.searchFetchTotal);
        result = 31 * result + Objects.hashCode(this.searchOpenContexts);
        result = 31 * result + Objects.hashCode(this.searchPointInTimeCurrent);
        result = 31 * result + Objects.hashCode(this.searchPointInTimeTime);
        result = 31 * result + Objects.hashCode(this.searchPointInTimeTotal);
        result = 31 * result + Objects.hashCode(this.searchQueryCurrent);
        result = 31 * result + Objects.hashCode(this.searchQueryTime);
        result = 31 * result + Objects.hashCode(this.searchQueryTotal);
        result = 31 * result + Objects.hashCode(this.searchScrollCurrent);
        result = 31 * result + Objects.hashCode(this.searchScrollTime);
        result = 31 * result + Objects.hashCode(this.searchScrollTotal);
        result = 31 * result + Objects.hashCode(this.segmentsCount);
        result = 31 * result + Objects.hashCode(this.segmentsFixedBitsetMemory);
        result = 31 * result + Objects.hashCode(this.segmentsIndexWriterMemory);
        result = 31 * result + Objects.hashCode(this.segmentsMemory);
        result = 31 * result + Objects.hashCode(this.segmentsVersionMapMemory);
        result = 31 * result + Objects.hashCode(this.suggestCurrent);
        result = 31 * result + Objects.hashCode(this.suggestTime);
        result = 31 * result + Objects.hashCode(this.suggestTotal);
        result = 31 * result + Objects.hashCode(this.type);
        result = 31 * result + Objects.hashCode(this.uptime);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodesRecord other = (NodesRecord) o;
        return Objects.equals(this.build, other.build)
            && Objects.equals(this.bulkAvgSizeInBytes, other.bulkAvgSizeInBytes)
            && Objects.equals(this.bulkAvgTime, other.bulkAvgTime)
            && Objects.equals(this.bulkTotalOperations, other.bulkTotalOperations)
            && Objects.equals(this.bulkTotalSizeInBytes, other.bulkTotalSizeInBytes)
            && Objects.equals(this.bulkTotalTime, other.bulkTotalTime)
            && Objects.equals(this.clusterManager, other.clusterManager)
            && Objects.equals(this.completionSize, other.completionSize)
            && Objects.equals(this.cpu, other.cpu)
            && Objects.equals(this.diskAvail, other.diskAvail)
            && Objects.equals(this.diskTotal, other.diskTotal)
            && Objects.equals(this.diskUsed, other.diskUsed)
            && Objects.equals(this.diskUsedPercent, other.diskUsedPercent)
            && Objects.equals(this.fielddataEvictions, other.fielddataEvictions)
            && Objects.equals(this.fielddataMemorySize, other.fielddataMemorySize)
            && Objects.equals(this.fileDescCurrent, other.fileDescCurrent)
            && Objects.equals(this.fileDescMax, other.fileDescMax)
            && Objects.equals(this.fileDescPercent, other.fileDescPercent)
            && Objects.equals(this.flavor, other.flavor)
            && Objects.equals(this.flushTotal, other.flushTotal)
            && Objects.equals(this.flushTotalTime, other.flushTotalTime)
            && Objects.equals(this.getCurrent, other.getCurrent)
            && Objects.equals(this.getExistsTime, other.getExistsTime)
            && Objects.equals(this.getExistsTotal, other.getExistsTotal)
            && Objects.equals(this.getMissingTime, other.getMissingTime)
            && Objects.equals(this.getMissingTotal, other.getMissingTotal)
            && Objects.equals(this.getTime, other.getTime)
            && Objects.equals(this.getTotal, other.getTotal)
            && Objects.equals(this.heapCurrent, other.heapCurrent)
            && Objects.equals(this.heapMax, other.heapMax)
            && Objects.equals(this.heapPercent, other.heapPercent)
            && Objects.equals(this.httpAddress, other.httpAddress)
            && Objects.equals(this.id, other.id)
            && Objects.equals(this.indexingDeleteCurrent, other.indexingDeleteCurrent)
            && Objects.equals(this.indexingDeleteTime, other.indexingDeleteTime)
            && Objects.equals(this.indexingDeleteTotal, other.indexingDeleteTotal)
            && Objects.equals(this.indexingIndexCurrent, other.indexingIndexCurrent)
            && Objects.equals(this.indexingIndexFailed, other.indexingIndexFailed)
            && Objects.equals(this.indexingIndexTime, other.indexingIndexTime)
            && Objects.equals(this.indexingIndexTotal, other.indexingIndexTotal)
            && Objects.equals(this.ip, other.ip)
            && Objects.equals(this.jdk, other.jdk)
            && Objects.equals(this.load15m, other.load15m)
            && Objects.equals(this.load1m, other.load1m)
            && Objects.equals(this.load5m, other.load5m)
            && Objects.equals(this.master, other.master)
            && Objects.equals(this.mergesCurrent, other.mergesCurrent)
            && Objects.equals(this.mergesCurrentDocs, other.mergesCurrentDocs)
            && Objects.equals(this.mergesCurrentSize, other.mergesCurrentSize)
            && Objects.equals(this.mergesTotal, other.mergesTotal)
            && Objects.equals(this.mergesTotalDocs, other.mergesTotalDocs)
            && Objects.equals(this.mergesTotalSize, other.mergesTotalSize)
            && Objects.equals(this.mergesTotalTime, other.mergesTotalTime)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.nodeRole, other.nodeRole)
            && Objects.equals(this.nodeRoles, other.nodeRoles)
            && Objects.equals(this.pid, other.pid)
            && Objects.equals(this.port, other.port)
            && Objects.equals(this.queryCacheEvictions, other.queryCacheEvictions)
            && Objects.equals(this.queryCacheHitCount, other.queryCacheHitCount)
            && Objects.equals(this.queryCacheMemorySize, other.queryCacheMemorySize)
            && Objects.equals(this.queryCacheMissCount, other.queryCacheMissCount)
            && Objects.equals(this.ramCurrent, other.ramCurrent)
            && Objects.equals(this.ramMax, other.ramMax)
            && Objects.equals(this.ramPercent, other.ramPercent)
            && Objects.equals(this.refreshExternalTime, other.refreshExternalTime)
            && Objects.equals(this.refreshExternalTotal, other.refreshExternalTotal)
            && Objects.equals(this.refreshListeners, other.refreshListeners)
            && Objects.equals(this.refreshTime, other.refreshTime)
            && Objects.equals(this.refreshTotal, other.refreshTotal)
            && Objects.equals(this.requestCacheEvictions, other.requestCacheEvictions)
            && Objects.equals(this.requestCacheHitCount, other.requestCacheHitCount)
            && Objects.equals(this.requestCacheMemorySize, other.requestCacheMemorySize)
            && Objects.equals(this.requestCacheMissCount, other.requestCacheMissCount)
            && Objects.equals(this.scriptCacheEvictions, other.scriptCacheEvictions)
            && Objects.equals(this.scriptCompilationLimitTriggered, other.scriptCompilationLimitTriggered)
            && Objects.equals(this.scriptCompilations, other.scriptCompilations)
            && Objects.equals(this.searchConcurrentAvgSliceCount, other.searchConcurrentAvgSliceCount)
            && Objects.equals(this.searchConcurrentQueryCurrent, other.searchConcurrentQueryCurrent)
            && Objects.equals(this.searchConcurrentQueryTime, other.searchConcurrentQueryTime)
            && Objects.equals(this.searchConcurrentQueryTotal, other.searchConcurrentQueryTotal)
            && Objects.equals(this.searchFetchCurrent, other.searchFetchCurrent)
            && Objects.equals(this.searchFetchTime, other.searchFetchTime)
            && Objects.equals(this.searchFetchTotal, other.searchFetchTotal)
            && Objects.equals(this.searchOpenContexts, other.searchOpenContexts)
            && Objects.equals(this.searchPointInTimeCurrent, other.searchPointInTimeCurrent)
            && Objects.equals(this.searchPointInTimeTime, other.searchPointInTimeTime)
            && Objects.equals(this.searchPointInTimeTotal, other.searchPointInTimeTotal)
            && Objects.equals(this.searchQueryCurrent, other.searchQueryCurrent)
            && Objects.equals(this.searchQueryTime, other.searchQueryTime)
            && Objects.equals(this.searchQueryTotal, other.searchQueryTotal)
            && Objects.equals(this.searchScrollCurrent, other.searchScrollCurrent)
            && Objects.equals(this.searchScrollTime, other.searchScrollTime)
            && Objects.equals(this.searchScrollTotal, other.searchScrollTotal)
            && Objects.equals(this.segmentsCount, other.segmentsCount)
            && Objects.equals(this.segmentsFixedBitsetMemory, other.segmentsFixedBitsetMemory)
            && Objects.equals(this.segmentsIndexWriterMemory, other.segmentsIndexWriterMemory)
            && Objects.equals(this.segmentsMemory, other.segmentsMemory)
            && Objects.equals(this.segmentsVersionMapMemory, other.segmentsVersionMapMemory)
            && Objects.equals(this.suggestCurrent, other.suggestCurrent)
            && Objects.equals(this.suggestTime, other.suggestTime)
            && Objects.equals(this.suggestTotal, other.suggestTotal)
            && Objects.equals(this.type, other.type)
            && Objects.equals(this.uptime, other.uptime)
            && Objects.equals(this.version, other.version);
    }
}
