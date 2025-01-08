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

package org.opensearch.client.opensearch.cat.shards;

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

// typedef: cat.shards.ShardsRecord

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardsRecord implements PlainJsonSerializable, ToCopyableBuilder<ShardsRecord.Builder, ShardsRecord> {

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
    private final String completionSize;

    @Nullable
    private final String docs;

    @Nullable
    private final String docsDeleted;

    @Nullable
    private final String fielddataEvictions;

    @Nullable
    private final String fielddataMemorySize;

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
    private final String id;

    @Nullable
    private final String index;

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
    private final String node;

    @Nullable
    private final String pathData;

    @Nullable
    private final String pathState;

    @Nullable
    private final String prirep;

    @Nullable
    private final String queryCacheEvictions;

    @Nullable
    private final String queryCacheMemorySize;

    @Nullable
    private final String recoverysourceType;

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
    private final String searchSearchIdleReactivateCountTotal;

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
    private final String seqNoGlobalCheckpoint;

    @Nullable
    private final String seqNoLocalCheckpoint;

    @Nullable
    private final String seqNoMax;

    @Nullable
    private final String shard;

    @Nullable
    private final String state;

    @Nullable
    private final String store;

    @Nullable
    private final String syncId;

    @Nullable
    private final String unassignedAt;

    @Nullable
    private final String unassignedDetails;

    @Nullable
    private final String unassignedFor;

    @Nullable
    private final String unassignedReason;

    @Nullable
    private final String warmerCurrent;

    @Nullable
    private final String warmerTotal;

    @Nullable
    private final String warmerTotalTime;

    // ---------------------------------------------------------------------------------------------

    private ShardsRecord(Builder builder) {
        this.bulkAvgSizeInBytes = builder.bulkAvgSizeInBytes;
        this.bulkAvgTime = builder.bulkAvgTime;
        this.bulkTotalOperations = builder.bulkTotalOperations;
        this.bulkTotalSizeInBytes = builder.bulkTotalSizeInBytes;
        this.bulkTotalTime = builder.bulkTotalTime;
        this.completionSize = builder.completionSize;
        this.docs = builder.docs;
        this.docsDeleted = builder.docsDeleted;
        this.fielddataEvictions = builder.fielddataEvictions;
        this.fielddataMemorySize = builder.fielddataMemorySize;
        this.flushTotal = builder.flushTotal;
        this.flushTotalTime = builder.flushTotalTime;
        this.getCurrent = builder.getCurrent;
        this.getExistsTime = builder.getExistsTime;
        this.getExistsTotal = builder.getExistsTotal;
        this.getMissingTime = builder.getMissingTime;
        this.getMissingTotal = builder.getMissingTotal;
        this.getTime = builder.getTime;
        this.getTotal = builder.getTotal;
        this.id = builder.id;
        this.index = builder.index;
        this.indexingDeleteCurrent = builder.indexingDeleteCurrent;
        this.indexingDeleteTime = builder.indexingDeleteTime;
        this.indexingDeleteTotal = builder.indexingDeleteTotal;
        this.indexingIndexCurrent = builder.indexingIndexCurrent;
        this.indexingIndexFailed = builder.indexingIndexFailed;
        this.indexingIndexTime = builder.indexingIndexTime;
        this.indexingIndexTotal = builder.indexingIndexTotal;
        this.ip = builder.ip;
        this.mergesCurrent = builder.mergesCurrent;
        this.mergesCurrentDocs = builder.mergesCurrentDocs;
        this.mergesCurrentSize = builder.mergesCurrentSize;
        this.mergesTotal = builder.mergesTotal;
        this.mergesTotalDocs = builder.mergesTotalDocs;
        this.mergesTotalSize = builder.mergesTotalSize;
        this.mergesTotalTime = builder.mergesTotalTime;
        this.node = builder.node;
        this.pathData = builder.pathData;
        this.pathState = builder.pathState;
        this.prirep = builder.prirep;
        this.queryCacheEvictions = builder.queryCacheEvictions;
        this.queryCacheMemorySize = builder.queryCacheMemorySize;
        this.recoverysourceType = builder.recoverysourceType;
        this.refreshExternalTime = builder.refreshExternalTime;
        this.refreshExternalTotal = builder.refreshExternalTotal;
        this.refreshListeners = builder.refreshListeners;
        this.refreshTime = builder.refreshTime;
        this.refreshTotal = builder.refreshTotal;
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
        this.searchSearchIdleReactivateCountTotal = builder.searchSearchIdleReactivateCountTotal;
        this.segmentsCount = builder.segmentsCount;
        this.segmentsFixedBitsetMemory = builder.segmentsFixedBitsetMemory;
        this.segmentsIndexWriterMemory = builder.segmentsIndexWriterMemory;
        this.segmentsMemory = builder.segmentsMemory;
        this.segmentsVersionMapMemory = builder.segmentsVersionMapMemory;
        this.seqNoGlobalCheckpoint = builder.seqNoGlobalCheckpoint;
        this.seqNoLocalCheckpoint = builder.seqNoLocalCheckpoint;
        this.seqNoMax = builder.seqNoMax;
        this.shard = builder.shard;
        this.state = builder.state;
        this.store = builder.store;
        this.syncId = builder.syncId;
        this.unassignedAt = builder.unassignedAt;
        this.unassignedDetails = builder.unassignedDetails;
        this.unassignedFor = builder.unassignedFor;
        this.unassignedReason = builder.unassignedReason;
        this.warmerCurrent = builder.warmerCurrent;
        this.warmerTotal = builder.warmerTotal;
        this.warmerTotalTime = builder.warmerTotalTime;
    }

    public static ShardsRecord of(Function<ShardsRecord.Builder, ObjectBuilder<ShardsRecord>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The average size in bytes of shard bulk operations.
     * <p>
     * API name: {@code bulk.avg_size_in_bytes}
     * </p>
     */
    @Nullable
    public final String bulkAvgSizeInBytes() {
        return this.bulkAvgSizeInBytes;
    }

    /**
     * The average time spent in shard bulk operations.
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
     * The total size in bytes of shard bulk operations.
     * <p>
     * API name: {@code bulk.total_size_in_bytes}
     * </p>
     */
    @Nullable
    public final String bulkTotalSizeInBytes() {
        return this.bulkTotalSizeInBytes;
    }

    /**
     * The time spent in shard bulk operations.
     * <p>
     * API name: {@code bulk.total_time}
     * </p>
     */
    @Nullable
    public final String bulkTotalTime() {
        return this.bulkTotalTime;
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
     * The number of documents in the shard.
     * <p>
     * API name: {@code docs}
     * </p>
     */
    @Nullable
    public final String docs() {
        return this.docs;
    }

    /**
     * API name: {@code docs.deleted}
     */
    @Nullable
    public final String docsDeleted() {
        return this.docsDeleted;
    }

    /**
     * The field data cache evictions.
     * <p>
     * API name: {@code fielddata.evictions}
     * </p>
     */
    @Nullable
    public final String fielddataEvictions() {
        return this.fielddataEvictions;
    }

    /**
     * The used field data cache memory.
     * <p>
     * API name: {@code fielddata.memory_size}
     * </p>
     */
    @Nullable
    public final String fielddataMemorySize() {
        return this.fielddataMemorySize;
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
     * The number of current get operations.
     * <p>
     * API name: {@code get.current}
     * </p>
     */
    @Nullable
    public final String getCurrent() {
        return this.getCurrent;
    }

    /**
     * The time spent in successful get operations.
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
     * The time spent in failed get operations.
     * <p>
     * API name: {@code get.missing_time}
     * </p>
     */
    @Nullable
    public final String getMissingTime() {
        return this.getMissingTime;
    }

    /**
     * The number of failed get operations.
     * <p>
     * API name: {@code get.missing_total}
     * </p>
     */
    @Nullable
    public final String getMissingTotal() {
        return this.getMissingTotal;
    }

    /**
     * The time spent in get operations.
     * <p>
     * API name: {@code get.time}
     * </p>
     */
    @Nullable
    public final String getTime() {
        return this.getTime;
    }

    /**
     * The number of get operations.
     * <p>
     * API name: {@code get.total}
     * </p>
     */
    @Nullable
    public final String getTotal() {
        return this.getTotal;
    }

    /**
     * The unique identifier for the node.
     * <p>
     * API name: {@code id}
     * </p>
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * The index name.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * The number of current deletion operations.
     * <p>
     * API name: {@code indexing.delete_current}
     * </p>
     */
    @Nullable
    public final String indexingDeleteCurrent() {
        return this.indexingDeleteCurrent;
    }

    /**
     * The time spent in deletion operations.
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
     * The time spent in indexing operations.
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
     * The IP address of the node.
     * <p>
     * API name: {@code ip}
     * </p>
     */
    @Nullable
    public final String ip() {
        return this.ip;
    }

    /**
     * The number of current merge operations.
     * <p>
     * API name: {@code merges.current}
     * </p>
     */
    @Nullable
    public final String mergesCurrent() {
        return this.mergesCurrent;
    }

    /**
     * The number of current merging documents.
     * <p>
     * API name: {@code merges.current_docs}
     * </p>
     */
    @Nullable
    public final String mergesCurrentDocs() {
        return this.mergesCurrentDocs;
    }

    /**
     * The size of current merge operations.
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
     * The number of merged documents.
     * <p>
     * API name: {@code merges.total_docs}
     * </p>
     */
    @Nullable
    public final String mergesTotalDocs() {
        return this.mergesTotalDocs;
    }

    /**
     * The size of current merges.
     * <p>
     * API name: {@code merges.total_size}
     * </p>
     */
    @Nullable
    public final String mergesTotalSize() {
        return this.mergesTotalSize;
    }

    /**
     * The time spent merging documents.
     * <p>
     * API name: {@code merges.total_time}
     * </p>
     */
    @Nullable
    public final String mergesTotalTime() {
        return this.mergesTotalTime;
    }

    /**
     * The name of node.
     * <p>
     * API name: {@code node}
     * </p>
     */
    @Nullable
    public final String node() {
        return this.node;
    }

    /**
     * The shard data path.
     * <p>
     * API name: {@code path.data}
     * </p>
     */
    @Nullable
    public final String pathData() {
        return this.pathData;
    }

    /**
     * The shard state path.
     * <p>
     * API name: {@code path.state}
     * </p>
     */
    @Nullable
    public final String pathState() {
        return this.pathState;
    }

    /**
     * The shard type: <code>primary</code> or <code>replica</code>.
     * <p>
     * API name: {@code prirep}
     * </p>
     */
    @Nullable
    public final String prirep() {
        return this.prirep;
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
     * The used query cache memory.
     * <p>
     * API name: {@code query_cache.memory_size}
     * </p>
     */
    @Nullable
    public final String queryCacheMemorySize() {
        return this.queryCacheMemorySize;
    }

    /**
     * The type of recovery source.
     * <p>
     * API name: {@code recoverysource.type}
     * </p>
     */
    @Nullable
    public final String recoverysourceType() {
        return this.recoverysourceType;
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
     * The total number of external refreshes.
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
     * The total number of refreshes.
     * <p>
     * API name: {@code refresh.total}
     * </p>
     */
    @Nullable
    public final String refreshTotal() {
        return this.refreshTotal;
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
     * The total number of fetch operations.
     * <p>
     * API name: {@code search.fetch_total}
     * </p>
     */
    @Nullable
    public final String searchFetchTotal() {
        return this.searchFetchTotal;
    }

    /**
     * The number of open search contexts.
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
     * The total number of query phase operations.
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
     * The time scroll contexts were held open.
     * <p>
     * API name: {@code search.scroll_time}
     * </p>
     */
    @Nullable
    public final String searchScrollTime() {
        return this.searchScrollTime;
    }

    /**
     * The number of completed scroll contexts.
     * <p>
     * API name: {@code search.scroll_total}
     * </p>
     */
    @Nullable
    public final String searchScrollTotal() {
        return this.searchScrollTotal;
    }

    /**
     * API name: {@code search.search_idle_reactivate_count_total}
     */
    @Nullable
    public final String searchSearchIdleReactivateCountTotal() {
        return this.searchSearchIdleReactivateCountTotal;
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
     * The global checkpoint.
     * <p>
     * API name: {@code seq_no.global_checkpoint}
     * </p>
     */
    @Nullable
    public final String seqNoGlobalCheckpoint() {
        return this.seqNoGlobalCheckpoint;
    }

    /**
     * The local checkpoint.
     * <p>
     * API name: {@code seq_no.local_checkpoint}
     * </p>
     */
    @Nullable
    public final String seqNoLocalCheckpoint() {
        return this.seqNoLocalCheckpoint;
    }

    /**
     * The maximum sequence number.
     * <p>
     * API name: {@code seq_no.max}
     * </p>
     */
    @Nullable
    public final String seqNoMax() {
        return this.seqNoMax;
    }

    /**
     * The shard name.
     * <p>
     * API name: {@code shard}
     * </p>
     */
    @Nullable
    public final String shard() {
        return this.shard;
    }

    /**
     * The shard state. Returned values include: <code>INITIALIZING</code>: The shard is recovering from a peer shard or gateway.
     * <code>RELOCATING</code>: The shard is relocating. <code>STARTED</code>: The shard has started. <code>UNASSIGNED</code>: The shard is
     * not assigned to any node.
     * <p>
     * API name: {@code state}
     * </p>
     */
    @Nullable
    public final String state() {
        return this.state;
    }

    /**
     * The disk space used by the shard.
     * <p>
     * API name: {@code store}
     * </p>
     */
    @Nullable
    public final String store() {
        return this.store;
    }

    /**
     * The sync identifier.
     * <p>
     * API name: {@code sync_id}
     * </p>
     */
    @Nullable
    public final String syncId() {
        return this.syncId;
    }

    /**
     * The time at which the shard became unassigned in Coordinated Universal Time (UTC).
     * <p>
     * API name: {@code unassigned.at}
     * </p>
     */
    @Nullable
    public final String unassignedAt() {
        return this.unassignedAt;
    }

    /**
     * Additional details as to why the shard became unassigned. It does not explain why the shard is not assigned; use the cluster
     * allocation explain API for that information.
     * <p>
     * API name: {@code unassigned.details}
     * </p>
     */
    @Nullable
    public final String unassignedDetails() {
        return this.unassignedDetails;
    }

    /**
     * The time at which the shard was requested to be unassigned in Coordinated Universal Time (UTC).
     * <p>
     * API name: {@code unassigned.for}
     * </p>
     */
    @Nullable
    public final String unassignedFor() {
        return this.unassignedFor;
    }

    /**
     * The reason for the last change to the state of an unassigned shard. It does not explain why the shard is currently unassigned; use
     * the cluster allocation explain API for that information. Returned values include: <code>ALLOCATION_FAILED</code>: Unassigned as a
     * result of a failed allocation of the shard. <code>CLUSTER_RECOVERED</code>: Unassigned as a result of a full cluster recovery.
     * <code>DANGLING_INDEX_IMPORTED</code>: Unassigned as a result of importing a dangling index. <code>EXISTING_INDEX_RESTORED</code>:
     * Unassigned as a result of restoring into a closed index. <code>FORCED_EMPTY_PRIMARY</code>: The shard's allocation was last modified
     * by forcing an empty primary using the cluster reroute API. <code>INDEX_CLOSED</code>: Unassigned because the index was closed.
     * <code>INDEX_CREATED</code>: Unassigned as a result of an API creation of an index. <code>INDEX_REOPENED</code>: Unassigned as a
     * result of opening a closed index. <code>MANUAL_ALLOCATION</code>: The shard's allocation was last modified by the cluster reroute
     * API. <code>NEW_INDEX_RESTORED</code>: Unassigned as a result of restoring into a new index. <code>NODE_LEFT</code>: Unassigned as a
     * result of the node hosting it leaving the cluster. <code>NODE_RESTARTING</code>: Similar to <code>NODE_LEFT</code>, except that the
     * node was registered as restarting using the node shutdown API. <code>PRIMARY_FAILED</code>: The shard was initializing as a replica,
     * but the primary shard failed before the initialization completed. <code>REALLOCATED_REPLICA</code>: A better replica location is
     * identified and causes the existing replica allocation to be cancelled. <code>REINITIALIZED</code>: When a shard moves from started
     * back to initializing. <code>REPLICA_ADDED</code>: Unassigned as a result of explicit addition of a replica.
     * <code>REROUTE_CANCELLED</code>: Unassigned as a result of explicit cancel reroute command.
     * <p>
     * API name: {@code unassigned.reason}
     * </p>
     */
    @Nullable
    public final String unassignedReason() {
        return this.unassignedReason;
    }

    /**
     * The number of current warmer operations.
     * <p>
     * API name: {@code warmer.current}
     * </p>
     */
    @Nullable
    public final String warmerCurrent() {
        return this.warmerCurrent;
    }

    /**
     * The total number of warmer operations.
     * <p>
     * API name: {@code warmer.total}
     * </p>
     */
    @Nullable
    public final String warmerTotal() {
        return this.warmerTotal;
    }

    /**
     * The time spent in warmer operations.
     * <p>
     * API name: {@code warmer.total_time}
     * </p>
     */
    @Nullable
    public final String warmerTotalTime() {
        return this.warmerTotalTime;
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

        if (this.completionSize != null) {
            generator.writeKey("completion.size");
            generator.write(this.completionSize);
        }

        if (this.docs != null) {
            generator.writeKey("docs");
            generator.write(this.docs);
        }

        if (this.docsDeleted != null) {
            generator.writeKey("docs.deleted");
            generator.write(this.docsDeleted);
        }

        if (this.fielddataEvictions != null) {
            generator.writeKey("fielddata.evictions");
            generator.write(this.fielddataEvictions);
        }

        if (this.fielddataMemorySize != null) {
            generator.writeKey("fielddata.memory_size");
            generator.write(this.fielddataMemorySize);
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

        if (this.id != null) {
            generator.writeKey("id");
            generator.write(this.id);
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
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

        if (this.node != null) {
            generator.writeKey("node");
            generator.write(this.node);
        }

        if (this.pathData != null) {
            generator.writeKey("path.data");
            generator.write(this.pathData);
        }

        if (this.pathState != null) {
            generator.writeKey("path.state");
            generator.write(this.pathState);
        }

        if (this.prirep != null) {
            generator.writeKey("prirep");
            generator.write(this.prirep);
        }

        if (this.queryCacheEvictions != null) {
            generator.writeKey("query_cache.evictions");
            generator.write(this.queryCacheEvictions);
        }

        if (this.queryCacheMemorySize != null) {
            generator.writeKey("query_cache.memory_size");
            generator.write(this.queryCacheMemorySize);
        }

        if (this.recoverysourceType != null) {
            generator.writeKey("recoverysource.type");
            generator.write(this.recoverysourceType);
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

        if (this.searchSearchIdleReactivateCountTotal != null) {
            generator.writeKey("search.search_idle_reactivate_count_total");
            generator.write(this.searchSearchIdleReactivateCountTotal);
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

        if (this.seqNoGlobalCheckpoint != null) {
            generator.writeKey("seq_no.global_checkpoint");
            generator.write(this.seqNoGlobalCheckpoint);
        }

        if (this.seqNoLocalCheckpoint != null) {
            generator.writeKey("seq_no.local_checkpoint");
            generator.write(this.seqNoLocalCheckpoint);
        }

        if (this.seqNoMax != null) {
            generator.writeKey("seq_no.max");
            generator.write(this.seqNoMax);
        }

        if (this.shard != null) {
            generator.writeKey("shard");
            generator.write(this.shard);
        }

        if (this.state != null) {
            generator.writeKey("state");
            generator.write(this.state);
        }

        if (this.store != null) {
            generator.writeKey("store");
            generator.write(this.store);
        }

        if (this.syncId != null) {
            generator.writeKey("sync_id");
            generator.write(this.syncId);
        }

        if (this.unassignedAt != null) {
            generator.writeKey("unassigned.at");
            generator.write(this.unassignedAt);
        }

        if (this.unassignedDetails != null) {
            generator.writeKey("unassigned.details");
            generator.write(this.unassignedDetails);
        }

        if (this.unassignedFor != null) {
            generator.writeKey("unassigned.for");
            generator.write(this.unassignedFor);
        }

        if (this.unassignedReason != null) {
            generator.writeKey("unassigned.reason");
            generator.write(this.unassignedReason);
        }

        if (this.warmerCurrent != null) {
            generator.writeKey("warmer.current");
            generator.write(this.warmerCurrent);
        }

        if (this.warmerTotal != null) {
            generator.writeKey("warmer.total");
            generator.write(this.warmerTotal);
        }

        if (this.warmerTotalTime != null) {
            generator.writeKey("warmer.total_time");
            generator.write(this.warmerTotalTime);
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
     * Builder for {@link ShardsRecord}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardsRecord> {
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
        private String completionSize;
        @Nullable
        private String docs;
        @Nullable
        private String docsDeleted;
        @Nullable
        private String fielddataEvictions;
        @Nullable
        private String fielddataMemorySize;
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
        private String id;
        @Nullable
        private String index;
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
        private String node;
        @Nullable
        private String pathData;
        @Nullable
        private String pathState;
        @Nullable
        private String prirep;
        @Nullable
        private String queryCacheEvictions;
        @Nullable
        private String queryCacheMemorySize;
        @Nullable
        private String recoverysourceType;
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
        private String searchSearchIdleReactivateCountTotal;
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
        private String seqNoGlobalCheckpoint;
        @Nullable
        private String seqNoLocalCheckpoint;
        @Nullable
        private String seqNoMax;
        @Nullable
        private String shard;
        @Nullable
        private String state;
        @Nullable
        private String store;
        @Nullable
        private String syncId;
        @Nullable
        private String unassignedAt;
        @Nullable
        private String unassignedDetails;
        @Nullable
        private String unassignedFor;
        @Nullable
        private String unassignedReason;
        @Nullable
        private String warmerCurrent;
        @Nullable
        private String warmerTotal;
        @Nullable
        private String warmerTotalTime;

        public Builder() {}

        private Builder(ShardsRecord o) {
            this.bulkAvgSizeInBytes = o.bulkAvgSizeInBytes;
            this.bulkAvgTime = o.bulkAvgTime;
            this.bulkTotalOperations = o.bulkTotalOperations;
            this.bulkTotalSizeInBytes = o.bulkTotalSizeInBytes;
            this.bulkTotalTime = o.bulkTotalTime;
            this.completionSize = o.completionSize;
            this.docs = o.docs;
            this.docsDeleted = o.docsDeleted;
            this.fielddataEvictions = o.fielddataEvictions;
            this.fielddataMemorySize = o.fielddataMemorySize;
            this.flushTotal = o.flushTotal;
            this.flushTotalTime = o.flushTotalTime;
            this.getCurrent = o.getCurrent;
            this.getExistsTime = o.getExistsTime;
            this.getExistsTotal = o.getExistsTotal;
            this.getMissingTime = o.getMissingTime;
            this.getMissingTotal = o.getMissingTotal;
            this.getTime = o.getTime;
            this.getTotal = o.getTotal;
            this.id = o.id;
            this.index = o.index;
            this.indexingDeleteCurrent = o.indexingDeleteCurrent;
            this.indexingDeleteTime = o.indexingDeleteTime;
            this.indexingDeleteTotal = o.indexingDeleteTotal;
            this.indexingIndexCurrent = o.indexingIndexCurrent;
            this.indexingIndexFailed = o.indexingIndexFailed;
            this.indexingIndexTime = o.indexingIndexTime;
            this.indexingIndexTotal = o.indexingIndexTotal;
            this.ip = o.ip;
            this.mergesCurrent = o.mergesCurrent;
            this.mergesCurrentDocs = o.mergesCurrentDocs;
            this.mergesCurrentSize = o.mergesCurrentSize;
            this.mergesTotal = o.mergesTotal;
            this.mergesTotalDocs = o.mergesTotalDocs;
            this.mergesTotalSize = o.mergesTotalSize;
            this.mergesTotalTime = o.mergesTotalTime;
            this.node = o.node;
            this.pathData = o.pathData;
            this.pathState = o.pathState;
            this.prirep = o.prirep;
            this.queryCacheEvictions = o.queryCacheEvictions;
            this.queryCacheMemorySize = o.queryCacheMemorySize;
            this.recoverysourceType = o.recoverysourceType;
            this.refreshExternalTime = o.refreshExternalTime;
            this.refreshExternalTotal = o.refreshExternalTotal;
            this.refreshListeners = o.refreshListeners;
            this.refreshTime = o.refreshTime;
            this.refreshTotal = o.refreshTotal;
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
            this.searchSearchIdleReactivateCountTotal = o.searchSearchIdleReactivateCountTotal;
            this.segmentsCount = o.segmentsCount;
            this.segmentsFixedBitsetMemory = o.segmentsFixedBitsetMemory;
            this.segmentsIndexWriterMemory = o.segmentsIndexWriterMemory;
            this.segmentsMemory = o.segmentsMemory;
            this.segmentsVersionMapMemory = o.segmentsVersionMapMemory;
            this.seqNoGlobalCheckpoint = o.seqNoGlobalCheckpoint;
            this.seqNoLocalCheckpoint = o.seqNoLocalCheckpoint;
            this.seqNoMax = o.seqNoMax;
            this.shard = o.shard;
            this.state = o.state;
            this.store = o.store;
            this.syncId = o.syncId;
            this.unassignedAt = o.unassignedAt;
            this.unassignedDetails = o.unassignedDetails;
            this.unassignedFor = o.unassignedFor;
            this.unassignedReason = o.unassignedReason;
            this.warmerCurrent = o.warmerCurrent;
            this.warmerTotal = o.warmerTotal;
            this.warmerTotalTime = o.warmerTotalTime;
        }

        private Builder(Builder o) {
            this.bulkAvgSizeInBytes = o.bulkAvgSizeInBytes;
            this.bulkAvgTime = o.bulkAvgTime;
            this.bulkTotalOperations = o.bulkTotalOperations;
            this.bulkTotalSizeInBytes = o.bulkTotalSizeInBytes;
            this.bulkTotalTime = o.bulkTotalTime;
            this.completionSize = o.completionSize;
            this.docs = o.docs;
            this.docsDeleted = o.docsDeleted;
            this.fielddataEvictions = o.fielddataEvictions;
            this.fielddataMemorySize = o.fielddataMemorySize;
            this.flushTotal = o.flushTotal;
            this.flushTotalTime = o.flushTotalTime;
            this.getCurrent = o.getCurrent;
            this.getExistsTime = o.getExistsTime;
            this.getExistsTotal = o.getExistsTotal;
            this.getMissingTime = o.getMissingTime;
            this.getMissingTotal = o.getMissingTotal;
            this.getTime = o.getTime;
            this.getTotal = o.getTotal;
            this.id = o.id;
            this.index = o.index;
            this.indexingDeleteCurrent = o.indexingDeleteCurrent;
            this.indexingDeleteTime = o.indexingDeleteTime;
            this.indexingDeleteTotal = o.indexingDeleteTotal;
            this.indexingIndexCurrent = o.indexingIndexCurrent;
            this.indexingIndexFailed = o.indexingIndexFailed;
            this.indexingIndexTime = o.indexingIndexTime;
            this.indexingIndexTotal = o.indexingIndexTotal;
            this.ip = o.ip;
            this.mergesCurrent = o.mergesCurrent;
            this.mergesCurrentDocs = o.mergesCurrentDocs;
            this.mergesCurrentSize = o.mergesCurrentSize;
            this.mergesTotal = o.mergesTotal;
            this.mergesTotalDocs = o.mergesTotalDocs;
            this.mergesTotalSize = o.mergesTotalSize;
            this.mergesTotalTime = o.mergesTotalTime;
            this.node = o.node;
            this.pathData = o.pathData;
            this.pathState = o.pathState;
            this.prirep = o.prirep;
            this.queryCacheEvictions = o.queryCacheEvictions;
            this.queryCacheMemorySize = o.queryCacheMemorySize;
            this.recoverysourceType = o.recoverysourceType;
            this.refreshExternalTime = o.refreshExternalTime;
            this.refreshExternalTotal = o.refreshExternalTotal;
            this.refreshListeners = o.refreshListeners;
            this.refreshTime = o.refreshTime;
            this.refreshTotal = o.refreshTotal;
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
            this.searchSearchIdleReactivateCountTotal = o.searchSearchIdleReactivateCountTotal;
            this.segmentsCount = o.segmentsCount;
            this.segmentsFixedBitsetMemory = o.segmentsFixedBitsetMemory;
            this.segmentsIndexWriterMemory = o.segmentsIndexWriterMemory;
            this.segmentsMemory = o.segmentsMemory;
            this.segmentsVersionMapMemory = o.segmentsVersionMapMemory;
            this.seqNoGlobalCheckpoint = o.seqNoGlobalCheckpoint;
            this.seqNoLocalCheckpoint = o.seqNoLocalCheckpoint;
            this.seqNoMax = o.seqNoMax;
            this.shard = o.shard;
            this.state = o.state;
            this.store = o.store;
            this.syncId = o.syncId;
            this.unassignedAt = o.unassignedAt;
            this.unassignedDetails = o.unassignedDetails;
            this.unassignedFor = o.unassignedFor;
            this.unassignedReason = o.unassignedReason;
            this.warmerCurrent = o.warmerCurrent;
            this.warmerTotal = o.warmerTotal;
            this.warmerTotalTime = o.warmerTotalTime;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The average size in bytes of shard bulk operations.
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
         * The average time spent in shard bulk operations.
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
         * The total size in bytes of shard bulk operations.
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
         * The time spent in shard bulk operations.
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
         * The number of documents in the shard.
         * <p>
         * API name: {@code docs}
         * </p>
         */
        @Nonnull
        public final Builder docs(@Nullable String value) {
            this.docs = value;
            return this;
        }

        /**
         * API name: {@code docs.deleted}
         */
        @Nonnull
        public final Builder docsDeleted(@Nullable String value) {
            this.docsDeleted = value;
            return this;
        }

        /**
         * The field data cache evictions.
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
         * The used field data cache memory.
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
         * The number of current get operations.
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
         * The time spent in successful get operations.
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
         * The time spent in failed get operations.
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
         * The number of failed get operations.
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
         * The time spent in get operations.
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
         * The number of get operations.
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
         * The unique identifier for the node.
         * <p>
         * API name: {@code id}
         * </p>
         */
        @Nonnull
        public final Builder id(@Nullable String value) {
            this.id = value;
            return this;
        }

        /**
         * The index name.
         * <p>
         * API name: {@code index}
         * </p>
         */
        @Nonnull
        public final Builder index(@Nullable String value) {
            this.index = value;
            return this;
        }

        /**
         * The number of current deletion operations.
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
         * The time spent in deletion operations.
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
         * The time spent in indexing operations.
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
         * The IP address of the node.
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
         * The number of current merge operations.
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
         * The number of current merging documents.
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
         * The size of current merge operations.
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
         * The number of merged documents.
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
         * The size of current merges.
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
         * The time spent merging documents.
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
         * The name of node.
         * <p>
         * API name: {@code node}
         * </p>
         */
        @Nonnull
        public final Builder node(@Nullable String value) {
            this.node = value;
            return this;
        }

        /**
         * The shard data path.
         * <p>
         * API name: {@code path.data}
         * </p>
         */
        @Nonnull
        public final Builder pathData(@Nullable String value) {
            this.pathData = value;
            return this;
        }

        /**
         * The shard state path.
         * <p>
         * API name: {@code path.state}
         * </p>
         */
        @Nonnull
        public final Builder pathState(@Nullable String value) {
            this.pathState = value;
            return this;
        }

        /**
         * The shard type: <code>primary</code> or <code>replica</code>.
         * <p>
         * API name: {@code prirep}
         * </p>
         */
        @Nonnull
        public final Builder prirep(@Nullable String value) {
            this.prirep = value;
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
         * The used query cache memory.
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
         * The type of recovery source.
         * <p>
         * API name: {@code recoverysource.type}
         * </p>
         */
        @Nonnull
        public final Builder recoverysourceType(@Nullable String value) {
            this.recoverysourceType = value;
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
         * The total number of external refreshes.
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
         * The total number of refreshes.
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
         * The total number of fetch operations.
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
         * The number of open search contexts.
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
         * The total number of query phase operations.
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
         * The time scroll contexts were held open.
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
         * The number of completed scroll contexts.
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
         * API name: {@code search.search_idle_reactivate_count_total}
         */
        @Nonnull
        public final Builder searchSearchIdleReactivateCountTotal(@Nullable String value) {
            this.searchSearchIdleReactivateCountTotal = value;
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
         * The global checkpoint.
         * <p>
         * API name: {@code seq_no.global_checkpoint}
         * </p>
         */
        @Nonnull
        public final Builder seqNoGlobalCheckpoint(@Nullable String value) {
            this.seqNoGlobalCheckpoint = value;
            return this;
        }

        /**
         * The local checkpoint.
         * <p>
         * API name: {@code seq_no.local_checkpoint}
         * </p>
         */
        @Nonnull
        public final Builder seqNoLocalCheckpoint(@Nullable String value) {
            this.seqNoLocalCheckpoint = value;
            return this;
        }

        /**
         * The maximum sequence number.
         * <p>
         * API name: {@code seq_no.max}
         * </p>
         */
        @Nonnull
        public final Builder seqNoMax(@Nullable String value) {
            this.seqNoMax = value;
            return this;
        }

        /**
         * The shard name.
         * <p>
         * API name: {@code shard}
         * </p>
         */
        @Nonnull
        public final Builder shard(@Nullable String value) {
            this.shard = value;
            return this;
        }

        /**
         * The shard state. Returned values include: <code>INITIALIZING</code>: The shard is recovering from a peer shard or gateway.
         * <code>RELOCATING</code>: The shard is relocating. <code>STARTED</code>: The shard has started. <code>UNASSIGNED</code>: The shard
         * is not assigned to any node.
         * <p>
         * API name: {@code state}
         * </p>
         */
        @Nonnull
        public final Builder state(@Nullable String value) {
            this.state = value;
            return this;
        }

        /**
         * The disk space used by the shard.
         * <p>
         * API name: {@code store}
         * </p>
         */
        @Nonnull
        public final Builder store(@Nullable String value) {
            this.store = value;
            return this;
        }

        /**
         * The sync identifier.
         * <p>
         * API name: {@code sync_id}
         * </p>
         */
        @Nonnull
        public final Builder syncId(@Nullable String value) {
            this.syncId = value;
            return this;
        }

        /**
         * The time at which the shard became unassigned in Coordinated Universal Time (UTC).
         * <p>
         * API name: {@code unassigned.at}
         * </p>
         */
        @Nonnull
        public final Builder unassignedAt(@Nullable String value) {
            this.unassignedAt = value;
            return this;
        }

        /**
         * Additional details as to why the shard became unassigned. It does not explain why the shard is not assigned; use the cluster
         * allocation explain API for that information.
         * <p>
         * API name: {@code unassigned.details}
         * </p>
         */
        @Nonnull
        public final Builder unassignedDetails(@Nullable String value) {
            this.unassignedDetails = value;
            return this;
        }

        /**
         * The time at which the shard was requested to be unassigned in Coordinated Universal Time (UTC).
         * <p>
         * API name: {@code unassigned.for}
         * </p>
         */
        @Nonnull
        public final Builder unassignedFor(@Nullable String value) {
            this.unassignedFor = value;
            return this;
        }

        /**
         * The reason for the last change to the state of an unassigned shard. It does not explain why the shard is currently unassigned;
         * use the cluster allocation explain API for that information. Returned values include: <code>ALLOCATION_FAILED</code>: Unassigned
         * as a result of a failed allocation of the shard. <code>CLUSTER_RECOVERED</code>: Unassigned as a result of a full cluster
         * recovery. <code>DANGLING_INDEX_IMPORTED</code>: Unassigned as a result of importing a dangling index.
         * <code>EXISTING_INDEX_RESTORED</code>: Unassigned as a result of restoring into a closed index. <code>FORCED_EMPTY_PRIMARY</code>:
         * The shard's allocation was last modified by forcing an empty primary using the cluster reroute API. <code>INDEX_CLOSED</code>:
         * Unassigned because the index was closed. <code>INDEX_CREATED</code>: Unassigned as a result of an API creation of an index.
         * <code>INDEX_REOPENED</code>: Unassigned as a result of opening a closed index. <code>MANUAL_ALLOCATION</code>: The shard's
         * allocation was last modified by the cluster reroute API. <code>NEW_INDEX_RESTORED</code>: Unassigned as a result of restoring
         * into a new index. <code>NODE_LEFT</code>: Unassigned as a result of the node hosting it leaving the cluster.
         * <code>NODE_RESTARTING</code>: Similar to <code>NODE_LEFT</code>, except that the node was registered as restarting using the node
         * shutdown API. <code>PRIMARY_FAILED</code>: The shard was initializing as a replica, but the primary shard failed before the
         * initialization completed. <code>REALLOCATED_REPLICA</code>: A better replica location is identified and causes the existing
         * replica allocation to be cancelled. <code>REINITIALIZED</code>: When a shard moves from started back to initializing.
         * <code>REPLICA_ADDED</code>: Unassigned as a result of explicit addition of a replica. <code>REROUTE_CANCELLED</code>: Unassigned
         * as a result of explicit cancel reroute command.
         * <p>
         * API name: {@code unassigned.reason}
         * </p>
         */
        @Nonnull
        public final Builder unassignedReason(@Nullable String value) {
            this.unassignedReason = value;
            return this;
        }

        /**
         * The number of current warmer operations.
         * <p>
         * API name: {@code warmer.current}
         * </p>
         */
        @Nonnull
        public final Builder warmerCurrent(@Nullable String value) {
            this.warmerCurrent = value;
            return this;
        }

        /**
         * The total number of warmer operations.
         * <p>
         * API name: {@code warmer.total}
         * </p>
         */
        @Nonnull
        public final Builder warmerTotal(@Nullable String value) {
            this.warmerTotal = value;
            return this;
        }

        /**
         * The time spent in warmer operations.
         * <p>
         * API name: {@code warmer.total_time}
         * </p>
         */
        @Nonnull
        public final Builder warmerTotalTime(@Nullable String value) {
            this.warmerTotalTime = value;
            return this;
        }

        /**
         * Builds a {@link ShardsRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardsRecord build() {
            _checkSingleUse();

            return new ShardsRecord(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardsRecord}
     */
    public static final JsonpDeserializer<ShardsRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardsRecord::setupShardsRecordDeserializer
    );

    protected static void setupShardsRecordDeserializer(ObjectDeserializer<ShardsRecord.Builder> op) {
        op.add(Builder::bulkAvgSizeInBytes, JsonpDeserializer.stringDeserializer(), "bulk.avg_size_in_bytes");
        op.add(Builder::bulkAvgTime, JsonpDeserializer.stringDeserializer(), "bulk.avg_time");
        op.add(Builder::bulkTotalOperations, JsonpDeserializer.stringDeserializer(), "bulk.total_operations");
        op.add(Builder::bulkTotalSizeInBytes, JsonpDeserializer.stringDeserializer(), "bulk.total_size_in_bytes");
        op.add(Builder::bulkTotalTime, JsonpDeserializer.stringDeserializer(), "bulk.total_time");
        op.add(Builder::completionSize, JsonpDeserializer.stringDeserializer(), "completion.size");
        op.add(Builder::docs, JsonpDeserializer.stringDeserializer(), "docs");
        op.add(Builder::docsDeleted, JsonpDeserializer.stringDeserializer(), "docs.deleted");
        op.add(Builder::fielddataEvictions, JsonpDeserializer.stringDeserializer(), "fielddata.evictions");
        op.add(Builder::fielddataMemorySize, JsonpDeserializer.stringDeserializer(), "fielddata.memory_size");
        op.add(Builder::flushTotal, JsonpDeserializer.stringDeserializer(), "flush.total");
        op.add(Builder::flushTotalTime, JsonpDeserializer.stringDeserializer(), "flush.total_time");
        op.add(Builder::getCurrent, JsonpDeserializer.stringDeserializer(), "get.current");
        op.add(Builder::getExistsTime, JsonpDeserializer.stringDeserializer(), "get.exists_time");
        op.add(Builder::getExistsTotal, JsonpDeserializer.stringDeserializer(), "get.exists_total");
        op.add(Builder::getMissingTime, JsonpDeserializer.stringDeserializer(), "get.missing_time");
        op.add(Builder::getMissingTotal, JsonpDeserializer.stringDeserializer(), "get.missing_total");
        op.add(Builder::getTime, JsonpDeserializer.stringDeserializer(), "get.time");
        op.add(Builder::getTotal, JsonpDeserializer.stringDeserializer(), "get.total");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::indexingDeleteCurrent, JsonpDeserializer.stringDeserializer(), "indexing.delete_current");
        op.add(Builder::indexingDeleteTime, JsonpDeserializer.stringDeserializer(), "indexing.delete_time");
        op.add(Builder::indexingDeleteTotal, JsonpDeserializer.stringDeserializer(), "indexing.delete_total");
        op.add(Builder::indexingIndexCurrent, JsonpDeserializer.stringDeserializer(), "indexing.index_current");
        op.add(Builder::indexingIndexFailed, JsonpDeserializer.stringDeserializer(), "indexing.index_failed");
        op.add(Builder::indexingIndexTime, JsonpDeserializer.stringDeserializer(), "indexing.index_time");
        op.add(Builder::indexingIndexTotal, JsonpDeserializer.stringDeserializer(), "indexing.index_total");
        op.add(Builder::ip, JsonpDeserializer.stringDeserializer(), "ip");
        op.add(Builder::mergesCurrent, JsonpDeserializer.stringDeserializer(), "merges.current");
        op.add(Builder::mergesCurrentDocs, JsonpDeserializer.stringDeserializer(), "merges.current_docs");
        op.add(Builder::mergesCurrentSize, JsonpDeserializer.stringDeserializer(), "merges.current_size");
        op.add(Builder::mergesTotal, JsonpDeserializer.stringDeserializer(), "merges.total");
        op.add(Builder::mergesTotalDocs, JsonpDeserializer.stringDeserializer(), "merges.total_docs");
        op.add(Builder::mergesTotalSize, JsonpDeserializer.stringDeserializer(), "merges.total_size");
        op.add(Builder::mergesTotalTime, JsonpDeserializer.stringDeserializer(), "merges.total_time");
        op.add(Builder::node, JsonpDeserializer.stringDeserializer(), "node");
        op.add(Builder::pathData, JsonpDeserializer.stringDeserializer(), "path.data");
        op.add(Builder::pathState, JsonpDeserializer.stringDeserializer(), "path.state");
        op.add(Builder::prirep, JsonpDeserializer.stringDeserializer(), "prirep");
        op.add(Builder::queryCacheEvictions, JsonpDeserializer.stringDeserializer(), "query_cache.evictions");
        op.add(Builder::queryCacheMemorySize, JsonpDeserializer.stringDeserializer(), "query_cache.memory_size");
        op.add(Builder::recoverysourceType, JsonpDeserializer.stringDeserializer(), "recoverysource.type");
        op.add(Builder::refreshExternalTime, JsonpDeserializer.stringDeserializer(), "refresh.external_time");
        op.add(Builder::refreshExternalTotal, JsonpDeserializer.stringDeserializer(), "refresh.external_total");
        op.add(Builder::refreshListeners, JsonpDeserializer.stringDeserializer(), "refresh.listeners");
        op.add(Builder::refreshTime, JsonpDeserializer.stringDeserializer(), "refresh.time");
        op.add(Builder::refreshTotal, JsonpDeserializer.stringDeserializer(), "refresh.total");
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
        op.add(
            Builder::searchSearchIdleReactivateCountTotal,
            JsonpDeserializer.stringDeserializer(),
            "search.search_idle_reactivate_count_total"
        );
        op.add(Builder::segmentsCount, JsonpDeserializer.stringDeserializer(), "segments.count");
        op.add(Builder::segmentsFixedBitsetMemory, JsonpDeserializer.stringDeserializer(), "segments.fixed_bitset_memory");
        op.add(Builder::segmentsIndexWriterMemory, JsonpDeserializer.stringDeserializer(), "segments.index_writer_memory");
        op.add(Builder::segmentsMemory, JsonpDeserializer.stringDeserializer(), "segments.memory");
        op.add(Builder::segmentsVersionMapMemory, JsonpDeserializer.stringDeserializer(), "segments.version_map_memory");
        op.add(Builder::seqNoGlobalCheckpoint, JsonpDeserializer.stringDeserializer(), "seq_no.global_checkpoint");
        op.add(Builder::seqNoLocalCheckpoint, JsonpDeserializer.stringDeserializer(), "seq_no.local_checkpoint");
        op.add(Builder::seqNoMax, JsonpDeserializer.stringDeserializer(), "seq_no.max");
        op.add(Builder::shard, JsonpDeserializer.stringDeserializer(), "shard");
        op.add(Builder::state, JsonpDeserializer.stringDeserializer(), "state");
        op.add(Builder::store, JsonpDeserializer.stringDeserializer(), "store");
        op.add(Builder::syncId, JsonpDeserializer.stringDeserializer(), "sync_id");
        op.add(Builder::unassignedAt, JsonpDeserializer.stringDeserializer(), "unassigned.at");
        op.add(Builder::unassignedDetails, JsonpDeserializer.stringDeserializer(), "unassigned.details");
        op.add(Builder::unassignedFor, JsonpDeserializer.stringDeserializer(), "unassigned.for");
        op.add(Builder::unassignedReason, JsonpDeserializer.stringDeserializer(), "unassigned.reason");
        op.add(Builder::warmerCurrent, JsonpDeserializer.stringDeserializer(), "warmer.current");
        op.add(Builder::warmerTotal, JsonpDeserializer.stringDeserializer(), "warmer.total");
        op.add(Builder::warmerTotalTime, JsonpDeserializer.stringDeserializer(), "warmer.total_time");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.bulkAvgSizeInBytes);
        result = 31 * result + Objects.hashCode(this.bulkAvgTime);
        result = 31 * result + Objects.hashCode(this.bulkTotalOperations);
        result = 31 * result + Objects.hashCode(this.bulkTotalSizeInBytes);
        result = 31 * result + Objects.hashCode(this.bulkTotalTime);
        result = 31 * result + Objects.hashCode(this.completionSize);
        result = 31 * result + Objects.hashCode(this.docs);
        result = 31 * result + Objects.hashCode(this.docsDeleted);
        result = 31 * result + Objects.hashCode(this.fielddataEvictions);
        result = 31 * result + Objects.hashCode(this.fielddataMemorySize);
        result = 31 * result + Objects.hashCode(this.flushTotal);
        result = 31 * result + Objects.hashCode(this.flushTotalTime);
        result = 31 * result + Objects.hashCode(this.getCurrent);
        result = 31 * result + Objects.hashCode(this.getExistsTime);
        result = 31 * result + Objects.hashCode(this.getExistsTotal);
        result = 31 * result + Objects.hashCode(this.getMissingTime);
        result = 31 * result + Objects.hashCode(this.getMissingTotal);
        result = 31 * result + Objects.hashCode(this.getTime);
        result = 31 * result + Objects.hashCode(this.getTotal);
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.indexingDeleteCurrent);
        result = 31 * result + Objects.hashCode(this.indexingDeleteTime);
        result = 31 * result + Objects.hashCode(this.indexingDeleteTotal);
        result = 31 * result + Objects.hashCode(this.indexingIndexCurrent);
        result = 31 * result + Objects.hashCode(this.indexingIndexFailed);
        result = 31 * result + Objects.hashCode(this.indexingIndexTime);
        result = 31 * result + Objects.hashCode(this.indexingIndexTotal);
        result = 31 * result + Objects.hashCode(this.ip);
        result = 31 * result + Objects.hashCode(this.mergesCurrent);
        result = 31 * result + Objects.hashCode(this.mergesCurrentDocs);
        result = 31 * result + Objects.hashCode(this.mergesCurrentSize);
        result = 31 * result + Objects.hashCode(this.mergesTotal);
        result = 31 * result + Objects.hashCode(this.mergesTotalDocs);
        result = 31 * result + Objects.hashCode(this.mergesTotalSize);
        result = 31 * result + Objects.hashCode(this.mergesTotalTime);
        result = 31 * result + Objects.hashCode(this.node);
        result = 31 * result + Objects.hashCode(this.pathData);
        result = 31 * result + Objects.hashCode(this.pathState);
        result = 31 * result + Objects.hashCode(this.prirep);
        result = 31 * result + Objects.hashCode(this.queryCacheEvictions);
        result = 31 * result + Objects.hashCode(this.queryCacheMemorySize);
        result = 31 * result + Objects.hashCode(this.recoverysourceType);
        result = 31 * result + Objects.hashCode(this.refreshExternalTime);
        result = 31 * result + Objects.hashCode(this.refreshExternalTotal);
        result = 31 * result + Objects.hashCode(this.refreshListeners);
        result = 31 * result + Objects.hashCode(this.refreshTime);
        result = 31 * result + Objects.hashCode(this.refreshTotal);
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
        result = 31 * result + Objects.hashCode(this.searchSearchIdleReactivateCountTotal);
        result = 31 * result + Objects.hashCode(this.segmentsCount);
        result = 31 * result + Objects.hashCode(this.segmentsFixedBitsetMemory);
        result = 31 * result + Objects.hashCode(this.segmentsIndexWriterMemory);
        result = 31 * result + Objects.hashCode(this.segmentsMemory);
        result = 31 * result + Objects.hashCode(this.segmentsVersionMapMemory);
        result = 31 * result + Objects.hashCode(this.seqNoGlobalCheckpoint);
        result = 31 * result + Objects.hashCode(this.seqNoLocalCheckpoint);
        result = 31 * result + Objects.hashCode(this.seqNoMax);
        result = 31 * result + Objects.hashCode(this.shard);
        result = 31 * result + Objects.hashCode(this.state);
        result = 31 * result + Objects.hashCode(this.store);
        result = 31 * result + Objects.hashCode(this.syncId);
        result = 31 * result + Objects.hashCode(this.unassignedAt);
        result = 31 * result + Objects.hashCode(this.unassignedDetails);
        result = 31 * result + Objects.hashCode(this.unassignedFor);
        result = 31 * result + Objects.hashCode(this.unassignedReason);
        result = 31 * result + Objects.hashCode(this.warmerCurrent);
        result = 31 * result + Objects.hashCode(this.warmerTotal);
        result = 31 * result + Objects.hashCode(this.warmerTotalTime);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardsRecord other = (ShardsRecord) o;
        return Objects.equals(this.bulkAvgSizeInBytes, other.bulkAvgSizeInBytes)
            && Objects.equals(this.bulkAvgTime, other.bulkAvgTime)
            && Objects.equals(this.bulkTotalOperations, other.bulkTotalOperations)
            && Objects.equals(this.bulkTotalSizeInBytes, other.bulkTotalSizeInBytes)
            && Objects.equals(this.bulkTotalTime, other.bulkTotalTime)
            && Objects.equals(this.completionSize, other.completionSize)
            && Objects.equals(this.docs, other.docs)
            && Objects.equals(this.docsDeleted, other.docsDeleted)
            && Objects.equals(this.fielddataEvictions, other.fielddataEvictions)
            && Objects.equals(this.fielddataMemorySize, other.fielddataMemorySize)
            && Objects.equals(this.flushTotal, other.flushTotal)
            && Objects.equals(this.flushTotalTime, other.flushTotalTime)
            && Objects.equals(this.getCurrent, other.getCurrent)
            && Objects.equals(this.getExistsTime, other.getExistsTime)
            && Objects.equals(this.getExistsTotal, other.getExistsTotal)
            && Objects.equals(this.getMissingTime, other.getMissingTime)
            && Objects.equals(this.getMissingTotal, other.getMissingTotal)
            && Objects.equals(this.getTime, other.getTime)
            && Objects.equals(this.getTotal, other.getTotal)
            && Objects.equals(this.id, other.id)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.indexingDeleteCurrent, other.indexingDeleteCurrent)
            && Objects.equals(this.indexingDeleteTime, other.indexingDeleteTime)
            && Objects.equals(this.indexingDeleteTotal, other.indexingDeleteTotal)
            && Objects.equals(this.indexingIndexCurrent, other.indexingIndexCurrent)
            && Objects.equals(this.indexingIndexFailed, other.indexingIndexFailed)
            && Objects.equals(this.indexingIndexTime, other.indexingIndexTime)
            && Objects.equals(this.indexingIndexTotal, other.indexingIndexTotal)
            && Objects.equals(this.ip, other.ip)
            && Objects.equals(this.mergesCurrent, other.mergesCurrent)
            && Objects.equals(this.mergesCurrentDocs, other.mergesCurrentDocs)
            && Objects.equals(this.mergesCurrentSize, other.mergesCurrentSize)
            && Objects.equals(this.mergesTotal, other.mergesTotal)
            && Objects.equals(this.mergesTotalDocs, other.mergesTotalDocs)
            && Objects.equals(this.mergesTotalSize, other.mergesTotalSize)
            && Objects.equals(this.mergesTotalTime, other.mergesTotalTime)
            && Objects.equals(this.node, other.node)
            && Objects.equals(this.pathData, other.pathData)
            && Objects.equals(this.pathState, other.pathState)
            && Objects.equals(this.prirep, other.prirep)
            && Objects.equals(this.queryCacheEvictions, other.queryCacheEvictions)
            && Objects.equals(this.queryCacheMemorySize, other.queryCacheMemorySize)
            && Objects.equals(this.recoverysourceType, other.recoverysourceType)
            && Objects.equals(this.refreshExternalTime, other.refreshExternalTime)
            && Objects.equals(this.refreshExternalTotal, other.refreshExternalTotal)
            && Objects.equals(this.refreshListeners, other.refreshListeners)
            && Objects.equals(this.refreshTime, other.refreshTime)
            && Objects.equals(this.refreshTotal, other.refreshTotal)
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
            && Objects.equals(this.searchSearchIdleReactivateCountTotal, other.searchSearchIdleReactivateCountTotal)
            && Objects.equals(this.segmentsCount, other.segmentsCount)
            && Objects.equals(this.segmentsFixedBitsetMemory, other.segmentsFixedBitsetMemory)
            && Objects.equals(this.segmentsIndexWriterMemory, other.segmentsIndexWriterMemory)
            && Objects.equals(this.segmentsMemory, other.segmentsMemory)
            && Objects.equals(this.segmentsVersionMapMemory, other.segmentsVersionMapMemory)
            && Objects.equals(this.seqNoGlobalCheckpoint, other.seqNoGlobalCheckpoint)
            && Objects.equals(this.seqNoLocalCheckpoint, other.seqNoLocalCheckpoint)
            && Objects.equals(this.seqNoMax, other.seqNoMax)
            && Objects.equals(this.shard, other.shard)
            && Objects.equals(this.state, other.state)
            && Objects.equals(this.store, other.store)
            && Objects.equals(this.syncId, other.syncId)
            && Objects.equals(this.unassignedAt, other.unassignedAt)
            && Objects.equals(this.unassignedDetails, other.unassignedDetails)
            && Objects.equals(this.unassignedFor, other.unassignedFor)
            && Objects.equals(this.unassignedReason, other.unassignedReason)
            && Objects.equals(this.warmerCurrent, other.warmerCurrent)
            && Objects.equals(this.warmerTotal, other.warmerTotal)
            && Objects.equals(this.warmerTotalTime, other.warmerTotalTime);
    }
}
