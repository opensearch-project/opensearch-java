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

package org.opensearch.client.opensearch.cat.indices;

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

// typedef: cat.indices.IndicesRecord

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndicesRecord implements PlainJsonSerializable, ToCopyableBuilder<IndicesRecord.Builder, IndicesRecord> {

    @Nullable
    private final String completionSize;

    @Nullable
    private final String creationDate;

    @Nullable
    private final String creationDateString;

    @Nullable
    private final String docsCount;

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
    private final String health;

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
    private final String memoryTotal;

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
    private final String pri;

    @Nullable
    private final String priCompletionSize;

    @Nullable
    private final String priFielddataEvictions;

    @Nullable
    private final String priFielddataMemorySize;

    @Nullable
    private final String priFlushTotal;

    @Nullable
    private final String priFlushTotalTime;

    @Nullable
    private final String priGetCurrent;

    @Nullable
    private final String priGetExistsTime;

    @Nullable
    private final String priGetExistsTotal;

    @Nullable
    private final String priGetMissingTime;

    @Nullable
    private final String priGetMissingTotal;

    @Nullable
    private final String priGetTime;

    @Nullable
    private final String priGetTotal;

    @Nullable
    private final String priIndexingDeleteCurrent;

    @Nullable
    private final String priIndexingDeleteTime;

    @Nullable
    private final String priIndexingDeleteTotal;

    @Nullable
    private final String priIndexingIndexCurrent;

    @Nullable
    private final String priIndexingIndexFailed;

    @Nullable
    private final String priIndexingIndexTime;

    @Nullable
    private final String priIndexingIndexTotal;

    @Nullable
    private final String priMemoryTotal;

    @Nullable
    private final String priMergesCurrent;

    @Nullable
    private final String priMergesCurrentDocs;

    @Nullable
    private final String priMergesCurrentSize;

    @Nullable
    private final String priMergesTotal;

    @Nullable
    private final String priMergesTotalDocs;

    @Nullable
    private final String priMergesTotalSize;

    @Nullable
    private final String priMergesTotalTime;

    @Nullable
    private final String priQueryCacheEvictions;

    @Nullable
    private final String priQueryCacheMemorySize;

    @Nullable
    private final String priRefreshExternalTime;

    @Nullable
    private final String priRefreshExternalTotal;

    @Nullable
    private final String priRefreshListeners;

    @Nullable
    private final String priRefreshTime;

    @Nullable
    private final String priRefreshTotal;

    @Nullable
    private final String priRequestCacheEvictions;

    @Nullable
    private final String priRequestCacheHitCount;

    @Nullable
    private final String priRequestCacheMemorySize;

    @Nullable
    private final String priRequestCacheMissCount;

    @Nullable
    private final String priSearchConcurrentAvgSliceCount;

    @Nullable
    private final String priSearchConcurrentQueryCurrent;

    @Nullable
    private final String priSearchConcurrentQueryTime;

    @Nullable
    private final String priSearchConcurrentQueryTotal;

    @Nullable
    private final String priSearchFetchCurrent;

    @Nullable
    private final String priSearchFetchTime;

    @Nullable
    private final String priSearchFetchTotal;

    @Nullable
    private final String priSearchOpenContexts;

    @Nullable
    private final String priSearchPointInTimeCurrent;

    @Nullable
    private final String priSearchPointInTimeTime;

    @Nullable
    private final String priSearchPointInTimeTotal;

    @Nullable
    private final String priSearchQueryCurrent;

    @Nullable
    private final String priSearchQueryTime;

    @Nullable
    private final String priSearchQueryTotal;

    @Nullable
    private final String priSearchScrollCurrent;

    @Nullable
    private final String priSearchScrollTime;

    @Nullable
    private final String priSearchScrollTotal;

    @Nullable
    private final String priSegmentsCount;

    @Nullable
    private final String priSegmentsFixedBitsetMemory;

    @Nullable
    private final String priSegmentsIndexWriterMemory;

    @Nullable
    private final String priSegmentsMemory;

    @Nullable
    private final String priSegmentsVersionMapMemory;

    @Nullable
    private final String priStoreSize;

    @Nullable
    private final String priSuggestCurrent;

    @Nullable
    private final String priSuggestTime;

    @Nullable
    private final String priSuggestTotal;

    @Nullable
    private final String priWarmerCurrent;

    @Nullable
    private final String priWarmerTotal;

    @Nullable
    private final String priWarmerTotalTime;

    @Nullable
    private final String queryCacheEvictions;

    @Nullable
    private final String queryCacheMemorySize;

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
    private final String rep;

    @Nullable
    private final String requestCacheEvictions;

    @Nullable
    private final String requestCacheHitCount;

    @Nullable
    private final String requestCacheMemorySize;

    @Nullable
    private final String requestCacheMissCount;

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
    private final String searchThrottled;

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
    private final String status;

    @Nullable
    private final String storeSize;

    @Nullable
    private final String suggestCurrent;

    @Nullable
    private final String suggestTime;

    @Nullable
    private final String suggestTotal;

    @Nullable
    private final String uuid;

    @Nullable
    private final String warmerCurrent;

    @Nullable
    private final String warmerTotal;

    @Nullable
    private final String warmerTotalTime;

    // ---------------------------------------------------------------------------------------------

    private IndicesRecord(Builder builder) {
        this.completionSize = builder.completionSize;
        this.creationDate = builder.creationDate;
        this.creationDateString = builder.creationDateString;
        this.docsCount = builder.docsCount;
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
        this.health = builder.health;
        this.index = builder.index;
        this.indexingDeleteCurrent = builder.indexingDeleteCurrent;
        this.indexingDeleteTime = builder.indexingDeleteTime;
        this.indexingDeleteTotal = builder.indexingDeleteTotal;
        this.indexingIndexCurrent = builder.indexingIndexCurrent;
        this.indexingIndexFailed = builder.indexingIndexFailed;
        this.indexingIndexTime = builder.indexingIndexTime;
        this.indexingIndexTotal = builder.indexingIndexTotal;
        this.memoryTotal = builder.memoryTotal;
        this.mergesCurrent = builder.mergesCurrent;
        this.mergesCurrentDocs = builder.mergesCurrentDocs;
        this.mergesCurrentSize = builder.mergesCurrentSize;
        this.mergesTotal = builder.mergesTotal;
        this.mergesTotalDocs = builder.mergesTotalDocs;
        this.mergesTotalSize = builder.mergesTotalSize;
        this.mergesTotalTime = builder.mergesTotalTime;
        this.pri = builder.pri;
        this.priCompletionSize = builder.priCompletionSize;
        this.priFielddataEvictions = builder.priFielddataEvictions;
        this.priFielddataMemorySize = builder.priFielddataMemorySize;
        this.priFlushTotal = builder.priFlushTotal;
        this.priFlushTotalTime = builder.priFlushTotalTime;
        this.priGetCurrent = builder.priGetCurrent;
        this.priGetExistsTime = builder.priGetExistsTime;
        this.priGetExistsTotal = builder.priGetExistsTotal;
        this.priGetMissingTime = builder.priGetMissingTime;
        this.priGetMissingTotal = builder.priGetMissingTotal;
        this.priGetTime = builder.priGetTime;
        this.priGetTotal = builder.priGetTotal;
        this.priIndexingDeleteCurrent = builder.priIndexingDeleteCurrent;
        this.priIndexingDeleteTime = builder.priIndexingDeleteTime;
        this.priIndexingDeleteTotal = builder.priIndexingDeleteTotal;
        this.priIndexingIndexCurrent = builder.priIndexingIndexCurrent;
        this.priIndexingIndexFailed = builder.priIndexingIndexFailed;
        this.priIndexingIndexTime = builder.priIndexingIndexTime;
        this.priIndexingIndexTotal = builder.priIndexingIndexTotal;
        this.priMemoryTotal = builder.priMemoryTotal;
        this.priMergesCurrent = builder.priMergesCurrent;
        this.priMergesCurrentDocs = builder.priMergesCurrentDocs;
        this.priMergesCurrentSize = builder.priMergesCurrentSize;
        this.priMergesTotal = builder.priMergesTotal;
        this.priMergesTotalDocs = builder.priMergesTotalDocs;
        this.priMergesTotalSize = builder.priMergesTotalSize;
        this.priMergesTotalTime = builder.priMergesTotalTime;
        this.priQueryCacheEvictions = builder.priQueryCacheEvictions;
        this.priQueryCacheMemorySize = builder.priQueryCacheMemorySize;
        this.priRefreshExternalTime = builder.priRefreshExternalTime;
        this.priRefreshExternalTotal = builder.priRefreshExternalTotal;
        this.priRefreshListeners = builder.priRefreshListeners;
        this.priRefreshTime = builder.priRefreshTime;
        this.priRefreshTotal = builder.priRefreshTotal;
        this.priRequestCacheEvictions = builder.priRequestCacheEvictions;
        this.priRequestCacheHitCount = builder.priRequestCacheHitCount;
        this.priRequestCacheMemorySize = builder.priRequestCacheMemorySize;
        this.priRequestCacheMissCount = builder.priRequestCacheMissCount;
        this.priSearchConcurrentAvgSliceCount = builder.priSearchConcurrentAvgSliceCount;
        this.priSearchConcurrentQueryCurrent = builder.priSearchConcurrentQueryCurrent;
        this.priSearchConcurrentQueryTime = builder.priSearchConcurrentQueryTime;
        this.priSearchConcurrentQueryTotal = builder.priSearchConcurrentQueryTotal;
        this.priSearchFetchCurrent = builder.priSearchFetchCurrent;
        this.priSearchFetchTime = builder.priSearchFetchTime;
        this.priSearchFetchTotal = builder.priSearchFetchTotal;
        this.priSearchOpenContexts = builder.priSearchOpenContexts;
        this.priSearchPointInTimeCurrent = builder.priSearchPointInTimeCurrent;
        this.priSearchPointInTimeTime = builder.priSearchPointInTimeTime;
        this.priSearchPointInTimeTotal = builder.priSearchPointInTimeTotal;
        this.priSearchQueryCurrent = builder.priSearchQueryCurrent;
        this.priSearchQueryTime = builder.priSearchQueryTime;
        this.priSearchQueryTotal = builder.priSearchQueryTotal;
        this.priSearchScrollCurrent = builder.priSearchScrollCurrent;
        this.priSearchScrollTime = builder.priSearchScrollTime;
        this.priSearchScrollTotal = builder.priSearchScrollTotal;
        this.priSegmentsCount = builder.priSegmentsCount;
        this.priSegmentsFixedBitsetMemory = builder.priSegmentsFixedBitsetMemory;
        this.priSegmentsIndexWriterMemory = builder.priSegmentsIndexWriterMemory;
        this.priSegmentsMemory = builder.priSegmentsMemory;
        this.priSegmentsVersionMapMemory = builder.priSegmentsVersionMapMemory;
        this.priStoreSize = builder.priStoreSize;
        this.priSuggestCurrent = builder.priSuggestCurrent;
        this.priSuggestTime = builder.priSuggestTime;
        this.priSuggestTotal = builder.priSuggestTotal;
        this.priWarmerCurrent = builder.priWarmerCurrent;
        this.priWarmerTotal = builder.priWarmerTotal;
        this.priWarmerTotalTime = builder.priWarmerTotalTime;
        this.queryCacheEvictions = builder.queryCacheEvictions;
        this.queryCacheMemorySize = builder.queryCacheMemorySize;
        this.refreshExternalTime = builder.refreshExternalTime;
        this.refreshExternalTotal = builder.refreshExternalTotal;
        this.refreshListeners = builder.refreshListeners;
        this.refreshTime = builder.refreshTime;
        this.refreshTotal = builder.refreshTotal;
        this.rep = builder.rep;
        this.requestCacheEvictions = builder.requestCacheEvictions;
        this.requestCacheHitCount = builder.requestCacheHitCount;
        this.requestCacheMemorySize = builder.requestCacheMemorySize;
        this.requestCacheMissCount = builder.requestCacheMissCount;
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
        this.searchThrottled = builder.searchThrottled;
        this.segmentsCount = builder.segmentsCount;
        this.segmentsFixedBitsetMemory = builder.segmentsFixedBitsetMemory;
        this.segmentsIndexWriterMemory = builder.segmentsIndexWriterMemory;
        this.segmentsMemory = builder.segmentsMemory;
        this.segmentsVersionMapMemory = builder.segmentsVersionMapMemory;
        this.status = builder.status;
        this.storeSize = builder.storeSize;
        this.suggestCurrent = builder.suggestCurrent;
        this.suggestTime = builder.suggestTime;
        this.suggestTotal = builder.suggestTotal;
        this.uuid = builder.uuid;
        this.warmerCurrent = builder.warmerCurrent;
        this.warmerTotal = builder.warmerTotal;
        this.warmerTotalTime = builder.warmerTotalTime;
    }

    public static IndicesRecord of(Function<IndicesRecord.Builder, ObjectBuilder<IndicesRecord>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * size of completion
     * <p>
     * API name: {@code completion.size}
     * </p>
     */
    @Nullable
    public final String completionSize() {
        return this.completionSize;
    }

    /**
     * index creation date (millisecond value)
     * <p>
     * API name: {@code creation.date}
     * </p>
     */
    @Nullable
    public final String creationDate() {
        return this.creationDate;
    }

    /**
     * index creation date (as string)
     * <p>
     * API name: {@code creation.date.string}
     * </p>
     */
    @Nullable
    public final String creationDateString() {
        return this.creationDateString;
    }

    /**
     * available docs
     * <p>
     * API name: {@code docs.count}
     * </p>
     */
    @Nullable
    public final String docsCount() {
        return this.docsCount;
    }

    /**
     * deleted docs
     * <p>
     * API name: {@code docs.deleted}
     * </p>
     */
    @Nullable
    public final String docsDeleted() {
        return this.docsDeleted;
    }

    /**
     * field data evictions
     * <p>
     * API name: {@code fielddata.evictions}
     * </p>
     */
    @Nullable
    public final String fielddataEvictions() {
        return this.fielddataEvictions;
    }

    /**
     * used field data cache
     * <p>
     * API name: {@code fielddata.memory_size}
     * </p>
     */
    @Nullable
    public final String fielddataMemorySize() {
        return this.fielddataMemorySize;
    }

    /**
     * number of flushes
     * <p>
     * API name: {@code flush.total}
     * </p>
     */
    @Nullable
    public final String flushTotal() {
        return this.flushTotal;
    }

    /**
     * time spent in flush
     * <p>
     * API name: {@code flush.total_time}
     * </p>
     */
    @Nullable
    public final String flushTotalTime() {
        return this.flushTotalTime;
    }

    /**
     * number of current get ops
     * <p>
     * API name: {@code get.current}
     * </p>
     */
    @Nullable
    public final String getCurrent() {
        return this.getCurrent;
    }

    /**
     * time spent in successful gets
     * <p>
     * API name: {@code get.exists_time}
     * </p>
     */
    @Nullable
    public final String getExistsTime() {
        return this.getExistsTime;
    }

    /**
     * number of successful gets
     * <p>
     * API name: {@code get.exists_total}
     * </p>
     */
    @Nullable
    public final String getExistsTotal() {
        return this.getExistsTotal;
    }

    /**
     * time spent in failed gets
     * <p>
     * API name: {@code get.missing_time}
     * </p>
     */
    @Nullable
    public final String getMissingTime() {
        return this.getMissingTime;
    }

    /**
     * number of failed gets
     * <p>
     * API name: {@code get.missing_total}
     * </p>
     */
    @Nullable
    public final String getMissingTotal() {
        return this.getMissingTotal;
    }

    /**
     * time spent in get
     * <p>
     * API name: {@code get.time}
     * </p>
     */
    @Nullable
    public final String getTime() {
        return this.getTime;
    }

    /**
     * number of get ops
     * <p>
     * API name: {@code get.total}
     * </p>
     */
    @Nullable
    public final String getTotal() {
        return this.getTotal;
    }

    /**
     * current health status
     * <p>
     * API name: {@code health}
     * </p>
     */
    @Nullable
    public final String health() {
        return this.health;
    }

    /**
     * index name
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * number of current deletions
     * <p>
     * API name: {@code indexing.delete_current}
     * </p>
     */
    @Nullable
    public final String indexingDeleteCurrent() {
        return this.indexingDeleteCurrent;
    }

    /**
     * time spent in deletions
     * <p>
     * API name: {@code indexing.delete_time}
     * </p>
     */
    @Nullable
    public final String indexingDeleteTime() {
        return this.indexingDeleteTime;
    }

    /**
     * number of delete ops
     * <p>
     * API name: {@code indexing.delete_total}
     * </p>
     */
    @Nullable
    public final String indexingDeleteTotal() {
        return this.indexingDeleteTotal;
    }

    /**
     * number of current indexing ops
     * <p>
     * API name: {@code indexing.index_current}
     * </p>
     */
    @Nullable
    public final String indexingIndexCurrent() {
        return this.indexingIndexCurrent;
    }

    /**
     * number of failed indexing ops
     * <p>
     * API name: {@code indexing.index_failed}
     * </p>
     */
    @Nullable
    public final String indexingIndexFailed() {
        return this.indexingIndexFailed;
    }

    /**
     * time spent in indexing
     * <p>
     * API name: {@code indexing.index_time}
     * </p>
     */
    @Nullable
    public final String indexingIndexTime() {
        return this.indexingIndexTime;
    }

    /**
     * number of indexing ops
     * <p>
     * API name: {@code indexing.index_total}
     * </p>
     */
    @Nullable
    public final String indexingIndexTotal() {
        return this.indexingIndexTotal;
    }

    /**
     * total used memory
     * <p>
     * API name: {@code memory.total}
     * </p>
     */
    @Nullable
    public final String memoryTotal() {
        return this.memoryTotal;
    }

    /**
     * number of current merges
     * <p>
     * API name: {@code merges.current}
     * </p>
     */
    @Nullable
    public final String mergesCurrent() {
        return this.mergesCurrent;
    }

    /**
     * number of current merging docs
     * <p>
     * API name: {@code merges.current_docs}
     * </p>
     */
    @Nullable
    public final String mergesCurrentDocs() {
        return this.mergesCurrentDocs;
    }

    /**
     * size of current merges
     * <p>
     * API name: {@code merges.current_size}
     * </p>
     */
    @Nullable
    public final String mergesCurrentSize() {
        return this.mergesCurrentSize;
    }

    /**
     * number of completed merge ops
     * <p>
     * API name: {@code merges.total}
     * </p>
     */
    @Nullable
    public final String mergesTotal() {
        return this.mergesTotal;
    }

    /**
     * docs merged
     * <p>
     * API name: {@code merges.total_docs}
     * </p>
     */
    @Nullable
    public final String mergesTotalDocs() {
        return this.mergesTotalDocs;
    }

    /**
     * size merged
     * <p>
     * API name: {@code merges.total_size}
     * </p>
     */
    @Nullable
    public final String mergesTotalSize() {
        return this.mergesTotalSize;
    }

    /**
     * time spent in merges
     * <p>
     * API name: {@code merges.total_time}
     * </p>
     */
    @Nullable
    public final String mergesTotalTime() {
        return this.mergesTotalTime;
    }

    /**
     * number of primary shards
     * <p>
     * API name: {@code pri}
     * </p>
     */
    @Nullable
    public final String pri() {
        return this.pri;
    }

    /**
     * size of completion
     * <p>
     * API name: {@code pri.completion.size}
     * </p>
     */
    @Nullable
    public final String priCompletionSize() {
        return this.priCompletionSize;
    }

    /**
     * field data evictions
     * <p>
     * API name: {@code pri.fielddata.evictions}
     * </p>
     */
    @Nullable
    public final String priFielddataEvictions() {
        return this.priFielddataEvictions;
    }

    /**
     * used field data cache
     * <p>
     * API name: {@code pri.fielddata.memory_size}
     * </p>
     */
    @Nullable
    public final String priFielddataMemorySize() {
        return this.priFielddataMemorySize;
    }

    /**
     * number of flushes
     * <p>
     * API name: {@code pri.flush.total}
     * </p>
     */
    @Nullable
    public final String priFlushTotal() {
        return this.priFlushTotal;
    }

    /**
     * time spent in flush
     * <p>
     * API name: {@code pri.flush.total_time}
     * </p>
     */
    @Nullable
    public final String priFlushTotalTime() {
        return this.priFlushTotalTime;
    }

    /**
     * number of current get ops
     * <p>
     * API name: {@code pri.get.current}
     * </p>
     */
    @Nullable
    public final String priGetCurrent() {
        return this.priGetCurrent;
    }

    /**
     * time spent in successful gets
     * <p>
     * API name: {@code pri.get.exists_time}
     * </p>
     */
    @Nullable
    public final String priGetExistsTime() {
        return this.priGetExistsTime;
    }

    /**
     * number of successful gets
     * <p>
     * API name: {@code pri.get.exists_total}
     * </p>
     */
    @Nullable
    public final String priGetExistsTotal() {
        return this.priGetExistsTotal;
    }

    /**
     * time spent in failed gets
     * <p>
     * API name: {@code pri.get.missing_time}
     * </p>
     */
    @Nullable
    public final String priGetMissingTime() {
        return this.priGetMissingTime;
    }

    /**
     * number of failed gets
     * <p>
     * API name: {@code pri.get.missing_total}
     * </p>
     */
    @Nullable
    public final String priGetMissingTotal() {
        return this.priGetMissingTotal;
    }

    /**
     * time spent in get
     * <p>
     * API name: {@code pri.get.time}
     * </p>
     */
    @Nullable
    public final String priGetTime() {
        return this.priGetTime;
    }

    /**
     * number of get ops
     * <p>
     * API name: {@code pri.get.total}
     * </p>
     */
    @Nullable
    public final String priGetTotal() {
        return this.priGetTotal;
    }

    /**
     * number of current deletions
     * <p>
     * API name: {@code pri.indexing.delete_current}
     * </p>
     */
    @Nullable
    public final String priIndexingDeleteCurrent() {
        return this.priIndexingDeleteCurrent;
    }

    /**
     * time spent in deletions
     * <p>
     * API name: {@code pri.indexing.delete_time}
     * </p>
     */
    @Nullable
    public final String priIndexingDeleteTime() {
        return this.priIndexingDeleteTime;
    }

    /**
     * number of delete ops
     * <p>
     * API name: {@code pri.indexing.delete_total}
     * </p>
     */
    @Nullable
    public final String priIndexingDeleteTotal() {
        return this.priIndexingDeleteTotal;
    }

    /**
     * number of current indexing ops
     * <p>
     * API name: {@code pri.indexing.index_current}
     * </p>
     */
    @Nullable
    public final String priIndexingIndexCurrent() {
        return this.priIndexingIndexCurrent;
    }

    /**
     * number of failed indexing ops
     * <p>
     * API name: {@code pri.indexing.index_failed}
     * </p>
     */
    @Nullable
    public final String priIndexingIndexFailed() {
        return this.priIndexingIndexFailed;
    }

    /**
     * time spent in indexing
     * <p>
     * API name: {@code pri.indexing.index_time}
     * </p>
     */
    @Nullable
    public final String priIndexingIndexTime() {
        return this.priIndexingIndexTime;
    }

    /**
     * number of indexing ops
     * <p>
     * API name: {@code pri.indexing.index_total}
     * </p>
     */
    @Nullable
    public final String priIndexingIndexTotal() {
        return this.priIndexingIndexTotal;
    }

    /**
     * total user memory
     * <p>
     * API name: {@code pri.memory.total}
     * </p>
     */
    @Nullable
    public final String priMemoryTotal() {
        return this.priMemoryTotal;
    }

    /**
     * number of current merges
     * <p>
     * API name: {@code pri.merges.current}
     * </p>
     */
    @Nullable
    public final String priMergesCurrent() {
        return this.priMergesCurrent;
    }

    /**
     * number of current merging docs
     * <p>
     * API name: {@code pri.merges.current_docs}
     * </p>
     */
    @Nullable
    public final String priMergesCurrentDocs() {
        return this.priMergesCurrentDocs;
    }

    /**
     * size of current merges
     * <p>
     * API name: {@code pri.merges.current_size}
     * </p>
     */
    @Nullable
    public final String priMergesCurrentSize() {
        return this.priMergesCurrentSize;
    }

    /**
     * number of completed merge ops
     * <p>
     * API name: {@code pri.merges.total}
     * </p>
     */
    @Nullable
    public final String priMergesTotal() {
        return this.priMergesTotal;
    }

    /**
     * docs merged
     * <p>
     * API name: {@code pri.merges.total_docs}
     * </p>
     */
    @Nullable
    public final String priMergesTotalDocs() {
        return this.priMergesTotalDocs;
    }

    /**
     * size merged
     * <p>
     * API name: {@code pri.merges.total_size}
     * </p>
     */
    @Nullable
    public final String priMergesTotalSize() {
        return this.priMergesTotalSize;
    }

    /**
     * time spent in merges
     * <p>
     * API name: {@code pri.merges.total_time}
     * </p>
     */
    @Nullable
    public final String priMergesTotalTime() {
        return this.priMergesTotalTime;
    }

    /**
     * query cache evictions
     * <p>
     * API name: {@code pri.query_cache.evictions}
     * </p>
     */
    @Nullable
    public final String priQueryCacheEvictions() {
        return this.priQueryCacheEvictions;
    }

    /**
     * used query cache
     * <p>
     * API name: {@code pri.query_cache.memory_size}
     * </p>
     */
    @Nullable
    public final String priQueryCacheMemorySize() {
        return this.priQueryCacheMemorySize;
    }

    /**
     * time spent in external refreshes
     * <p>
     * API name: {@code pri.refresh.external_time}
     * </p>
     */
    @Nullable
    public final String priRefreshExternalTime() {
        return this.priRefreshExternalTime;
    }

    /**
     * total external refreshes
     * <p>
     * API name: {@code pri.refresh.external_total}
     * </p>
     */
    @Nullable
    public final String priRefreshExternalTotal() {
        return this.priRefreshExternalTotal;
    }

    /**
     * number of pending refresh listeners
     * <p>
     * API name: {@code pri.refresh.listeners}
     * </p>
     */
    @Nullable
    public final String priRefreshListeners() {
        return this.priRefreshListeners;
    }

    /**
     * time spent in refreshes
     * <p>
     * API name: {@code pri.refresh.time}
     * </p>
     */
    @Nullable
    public final String priRefreshTime() {
        return this.priRefreshTime;
    }

    /**
     * total refreshes
     * <p>
     * API name: {@code pri.refresh.total}
     * </p>
     */
    @Nullable
    public final String priRefreshTotal() {
        return this.priRefreshTotal;
    }

    /**
     * request cache evictions
     * <p>
     * API name: {@code pri.request_cache.evictions}
     * </p>
     */
    @Nullable
    public final String priRequestCacheEvictions() {
        return this.priRequestCacheEvictions;
    }

    /**
     * request cache hit count
     * <p>
     * API name: {@code pri.request_cache.hit_count}
     * </p>
     */
    @Nullable
    public final String priRequestCacheHitCount() {
        return this.priRequestCacheHitCount;
    }

    /**
     * used request cache
     * <p>
     * API name: {@code pri.request_cache.memory_size}
     * </p>
     */
    @Nullable
    public final String priRequestCacheMemorySize() {
        return this.priRequestCacheMemorySize;
    }

    /**
     * request cache miss count
     * <p>
     * API name: {@code pri.request_cache.miss_count}
     * </p>
     */
    @Nullable
    public final String priRequestCacheMissCount() {
        return this.priRequestCacheMissCount;
    }

    /**
     * API name: {@code pri.search.concurrent_avg_slice_count}
     */
    @Nullable
    public final String priSearchConcurrentAvgSliceCount() {
        return this.priSearchConcurrentAvgSliceCount;
    }

    /**
     * API name: {@code pri.search.concurrent_query_current}
     */
    @Nullable
    public final String priSearchConcurrentQueryCurrent() {
        return this.priSearchConcurrentQueryCurrent;
    }

    /**
     * API name: {@code pri.search.concurrent_query_time}
     */
    @Nullable
    public final String priSearchConcurrentQueryTime() {
        return this.priSearchConcurrentQueryTime;
    }

    /**
     * API name: {@code pri.search.concurrent_query_total}
     */
    @Nullable
    public final String priSearchConcurrentQueryTotal() {
        return this.priSearchConcurrentQueryTotal;
    }

    /**
     * current fetch phase ops
     * <p>
     * API name: {@code pri.search.fetch_current}
     * </p>
     */
    @Nullable
    public final String priSearchFetchCurrent() {
        return this.priSearchFetchCurrent;
    }

    /**
     * time spent in fetch phase
     * <p>
     * API name: {@code pri.search.fetch_time}
     * </p>
     */
    @Nullable
    public final String priSearchFetchTime() {
        return this.priSearchFetchTime;
    }

    /**
     * total fetch ops
     * <p>
     * API name: {@code pri.search.fetch_total}
     * </p>
     */
    @Nullable
    public final String priSearchFetchTotal() {
        return this.priSearchFetchTotal;
    }

    /**
     * open search contexts
     * <p>
     * API name: {@code pri.search.open_contexts}
     * </p>
     */
    @Nullable
    public final String priSearchOpenContexts() {
        return this.priSearchOpenContexts;
    }

    /**
     * API name: {@code pri.search.point_in_time_current}
     */
    @Nullable
    public final String priSearchPointInTimeCurrent() {
        return this.priSearchPointInTimeCurrent;
    }

    /**
     * API name: {@code pri.search.point_in_time_time}
     */
    @Nullable
    public final String priSearchPointInTimeTime() {
        return this.priSearchPointInTimeTime;
    }

    /**
     * API name: {@code pri.search.point_in_time_total}
     */
    @Nullable
    public final String priSearchPointInTimeTotal() {
        return this.priSearchPointInTimeTotal;
    }

    /**
     * current query phase ops
     * <p>
     * API name: {@code pri.search.query_current}
     * </p>
     */
    @Nullable
    public final String priSearchQueryCurrent() {
        return this.priSearchQueryCurrent;
    }

    /**
     * time spent in query phase
     * <p>
     * API name: {@code pri.search.query_time}
     * </p>
     */
    @Nullable
    public final String priSearchQueryTime() {
        return this.priSearchQueryTime;
    }

    /**
     * total query phase ops
     * <p>
     * API name: {@code pri.search.query_total}
     * </p>
     */
    @Nullable
    public final String priSearchQueryTotal() {
        return this.priSearchQueryTotal;
    }

    /**
     * open scroll contexts
     * <p>
     * API name: {@code pri.search.scroll_current}
     * </p>
     */
    @Nullable
    public final String priSearchScrollCurrent() {
        return this.priSearchScrollCurrent;
    }

    /**
     * time scroll contexts held open
     * <p>
     * API name: {@code pri.search.scroll_time}
     * </p>
     */
    @Nullable
    public final String priSearchScrollTime() {
        return this.priSearchScrollTime;
    }

    /**
     * completed scroll contexts
     * <p>
     * API name: {@code pri.search.scroll_total}
     * </p>
     */
    @Nullable
    public final String priSearchScrollTotal() {
        return this.priSearchScrollTotal;
    }

    /**
     * number of segments
     * <p>
     * API name: {@code pri.segments.count}
     * </p>
     */
    @Nullable
    public final String priSegmentsCount() {
        return this.priSegmentsCount;
    }

    /**
     * memory used by fixed bit sets for nested object field types and export type filters for types referred in <code>_parent</code> fields
     * <p>
     * API name: {@code pri.segments.fixed_bitset_memory}
     * </p>
     */
    @Nullable
    public final String priSegmentsFixedBitsetMemory() {
        return this.priSegmentsFixedBitsetMemory;
    }

    /**
     * memory used by index writer
     * <p>
     * API name: {@code pri.segments.index_writer_memory}
     * </p>
     */
    @Nullable
    public final String priSegmentsIndexWriterMemory() {
        return this.priSegmentsIndexWriterMemory;
    }

    /**
     * memory used by segments
     * <p>
     * API name: {@code pri.segments.memory}
     * </p>
     */
    @Nullable
    public final String priSegmentsMemory() {
        return this.priSegmentsMemory;
    }

    /**
     * memory used by version map
     * <p>
     * API name: {@code pri.segments.version_map_memory}
     * </p>
     */
    @Nullable
    public final String priSegmentsVersionMapMemory() {
        return this.priSegmentsVersionMapMemory;
    }

    /**
     * store size of primaries
     * <p>
     * API name: {@code pri.store.size}
     * </p>
     */
    @Nullable
    public final String priStoreSize() {
        return this.priStoreSize;
    }

    /**
     * number of current suggest ops
     * <p>
     * API name: {@code pri.suggest.current}
     * </p>
     */
    @Nullable
    public final String priSuggestCurrent() {
        return this.priSuggestCurrent;
    }

    /**
     * time spend in suggest
     * <p>
     * API name: {@code pri.suggest.time}
     * </p>
     */
    @Nullable
    public final String priSuggestTime() {
        return this.priSuggestTime;
    }

    /**
     * number of suggest ops
     * <p>
     * API name: {@code pri.suggest.total}
     * </p>
     */
    @Nullable
    public final String priSuggestTotal() {
        return this.priSuggestTotal;
    }

    /**
     * current warmer ops
     * <p>
     * API name: {@code pri.warmer.current}
     * </p>
     */
    @Nullable
    public final String priWarmerCurrent() {
        return this.priWarmerCurrent;
    }

    /**
     * total warmer ops
     * <p>
     * API name: {@code pri.warmer.total}
     * </p>
     */
    @Nullable
    public final String priWarmerTotal() {
        return this.priWarmerTotal;
    }

    /**
     * time spent in warmers
     * <p>
     * API name: {@code pri.warmer.total_time}
     * </p>
     */
    @Nullable
    public final String priWarmerTotalTime() {
        return this.priWarmerTotalTime;
    }

    /**
     * query cache evictions
     * <p>
     * API name: {@code query_cache.evictions}
     * </p>
     */
    @Nullable
    public final String queryCacheEvictions() {
        return this.queryCacheEvictions;
    }

    /**
     * used query cache
     * <p>
     * API name: {@code query_cache.memory_size}
     * </p>
     */
    @Nullable
    public final String queryCacheMemorySize() {
        return this.queryCacheMemorySize;
    }

    /**
     * time spent in external refreshes
     * <p>
     * API name: {@code refresh.external_time}
     * </p>
     */
    @Nullable
    public final String refreshExternalTime() {
        return this.refreshExternalTime;
    }

    /**
     * total external refreshes
     * <p>
     * API name: {@code refresh.external_total}
     * </p>
     */
    @Nullable
    public final String refreshExternalTotal() {
        return this.refreshExternalTotal;
    }

    /**
     * number of pending refresh listeners
     * <p>
     * API name: {@code refresh.listeners}
     * </p>
     */
    @Nullable
    public final String refreshListeners() {
        return this.refreshListeners;
    }

    /**
     * time spent in refreshes
     * <p>
     * API name: {@code refresh.time}
     * </p>
     */
    @Nullable
    public final String refreshTime() {
        return this.refreshTime;
    }

    /**
     * total refreshes
     * <p>
     * API name: {@code refresh.total}
     * </p>
     */
    @Nullable
    public final String refreshTotal() {
        return this.refreshTotal;
    }

    /**
     * number of replica shards
     * <p>
     * API name: {@code rep}
     * </p>
     */
    @Nullable
    public final String rep() {
        return this.rep;
    }

    /**
     * request cache evictions
     * <p>
     * API name: {@code request_cache.evictions}
     * </p>
     */
    @Nullable
    public final String requestCacheEvictions() {
        return this.requestCacheEvictions;
    }

    /**
     * request cache hit count
     * <p>
     * API name: {@code request_cache.hit_count}
     * </p>
     */
    @Nullable
    public final String requestCacheHitCount() {
        return this.requestCacheHitCount;
    }

    /**
     * used request cache
     * <p>
     * API name: {@code request_cache.memory_size}
     * </p>
     */
    @Nullable
    public final String requestCacheMemorySize() {
        return this.requestCacheMemorySize;
    }

    /**
     * request cache miss count
     * <p>
     * API name: {@code request_cache.miss_count}
     * </p>
     */
    @Nullable
    public final String requestCacheMissCount() {
        return this.requestCacheMissCount;
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
     * current fetch phase ops
     * <p>
     * API name: {@code search.fetch_current}
     * </p>
     */
    @Nullable
    public final String searchFetchCurrent() {
        return this.searchFetchCurrent;
    }

    /**
     * time spent in fetch phase
     * <p>
     * API name: {@code search.fetch_time}
     * </p>
     */
    @Nullable
    public final String searchFetchTime() {
        return this.searchFetchTime;
    }

    /**
     * total fetch ops
     * <p>
     * API name: {@code search.fetch_total}
     * </p>
     */
    @Nullable
    public final String searchFetchTotal() {
        return this.searchFetchTotal;
    }

    /**
     * open search contexts
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
     * current query phase ops
     * <p>
     * API name: {@code search.query_current}
     * </p>
     */
    @Nullable
    public final String searchQueryCurrent() {
        return this.searchQueryCurrent;
    }

    /**
     * time spent in query phase
     * <p>
     * API name: {@code search.query_time}
     * </p>
     */
    @Nullable
    public final String searchQueryTime() {
        return this.searchQueryTime;
    }

    /**
     * total query phase ops
     * <p>
     * API name: {@code search.query_total}
     * </p>
     */
    @Nullable
    public final String searchQueryTotal() {
        return this.searchQueryTotal;
    }

    /**
     * open scroll contexts
     * <p>
     * API name: {@code search.scroll_current}
     * </p>
     */
    @Nullable
    public final String searchScrollCurrent() {
        return this.searchScrollCurrent;
    }

    /**
     * time scroll contexts held open
     * <p>
     * API name: {@code search.scroll_time}
     * </p>
     */
    @Nullable
    public final String searchScrollTime() {
        return this.searchScrollTime;
    }

    /**
     * completed scroll contexts
     * <p>
     * API name: {@code search.scroll_total}
     * </p>
     */
    @Nullable
    public final String searchScrollTotal() {
        return this.searchScrollTotal;
    }

    /**
     * indicates if the index is search throttled
     * <p>
     * API name: {@code search.throttled}
     * </p>
     */
    @Nullable
    public final String searchThrottled() {
        return this.searchThrottled;
    }

    /**
     * number of segments
     * <p>
     * API name: {@code segments.count}
     * </p>
     */
    @Nullable
    public final String segmentsCount() {
        return this.segmentsCount;
    }

    /**
     * memory used by fixed bit sets for nested object field types and export type filters for types referred in <code>_parent</code> fields
     * <p>
     * API name: {@code segments.fixed_bitset_memory}
     * </p>
     */
    @Nullable
    public final String segmentsFixedBitsetMemory() {
        return this.segmentsFixedBitsetMemory;
    }

    /**
     * memory used by index writer
     * <p>
     * API name: {@code segments.index_writer_memory}
     * </p>
     */
    @Nullable
    public final String segmentsIndexWriterMemory() {
        return this.segmentsIndexWriterMemory;
    }

    /**
     * memory used by segments
     * <p>
     * API name: {@code segments.memory}
     * </p>
     */
    @Nullable
    public final String segmentsMemory() {
        return this.segmentsMemory;
    }

    /**
     * memory used by version map
     * <p>
     * API name: {@code segments.version_map_memory}
     * </p>
     */
    @Nullable
    public final String segmentsVersionMapMemory() {
        return this.segmentsVersionMapMemory;
    }

    /**
     * open/close status
     * <p>
     * API name: {@code status}
     * </p>
     */
    @Nullable
    public final String status() {
        return this.status;
    }

    /**
     * store size of primaries and replicas
     * <p>
     * API name: {@code store.size}
     * </p>
     */
    @Nullable
    public final String storeSize() {
        return this.storeSize;
    }

    /**
     * number of current suggest ops
     * <p>
     * API name: {@code suggest.current}
     * </p>
     */
    @Nullable
    public final String suggestCurrent() {
        return this.suggestCurrent;
    }

    /**
     * time spend in suggest
     * <p>
     * API name: {@code suggest.time}
     * </p>
     */
    @Nullable
    public final String suggestTime() {
        return this.suggestTime;
    }

    /**
     * number of suggest ops
     * <p>
     * API name: {@code suggest.total}
     * </p>
     */
    @Nullable
    public final String suggestTotal() {
        return this.suggestTotal;
    }

    /**
     * index UUID
     * <p>
     * API name: {@code uuid}
     * </p>
     */
    @Nullable
    public final String uuid() {
        return this.uuid;
    }

    /**
     * current warmer ops
     * <p>
     * API name: {@code warmer.current}
     * </p>
     */
    @Nullable
    public final String warmerCurrent() {
        return this.warmerCurrent;
    }

    /**
     * total warmer ops
     * <p>
     * API name: {@code warmer.total}
     * </p>
     */
    @Nullable
    public final String warmerTotal() {
        return this.warmerTotal;
    }

    /**
     * time spent in warmers
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
        if (this.completionSize != null) {
            generator.writeKey("completion.size");
            generator.write(this.completionSize);
        }

        if (this.creationDate != null) {
            generator.writeKey("creation.date");
            generator.write(this.creationDate);
        }

        if (this.creationDateString != null) {
            generator.writeKey("creation.date.string");
            generator.write(this.creationDateString);
        }

        if (this.docsCount != null) {
            generator.writeKey("docs.count");
            generator.write(this.docsCount);
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

        if (this.health != null) {
            generator.writeKey("health");
            generator.write(this.health);
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

        if (this.memoryTotal != null) {
            generator.writeKey("memory.total");
            generator.write(this.memoryTotal);
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

        if (this.pri != null) {
            generator.writeKey("pri");
            generator.write(this.pri);
        }

        if (this.priCompletionSize != null) {
            generator.writeKey("pri.completion.size");
            generator.write(this.priCompletionSize);
        }

        if (this.priFielddataEvictions != null) {
            generator.writeKey("pri.fielddata.evictions");
            generator.write(this.priFielddataEvictions);
        }

        if (this.priFielddataMemorySize != null) {
            generator.writeKey("pri.fielddata.memory_size");
            generator.write(this.priFielddataMemorySize);
        }

        if (this.priFlushTotal != null) {
            generator.writeKey("pri.flush.total");
            generator.write(this.priFlushTotal);
        }

        if (this.priFlushTotalTime != null) {
            generator.writeKey("pri.flush.total_time");
            generator.write(this.priFlushTotalTime);
        }

        if (this.priGetCurrent != null) {
            generator.writeKey("pri.get.current");
            generator.write(this.priGetCurrent);
        }

        if (this.priGetExistsTime != null) {
            generator.writeKey("pri.get.exists_time");
            generator.write(this.priGetExistsTime);
        }

        if (this.priGetExistsTotal != null) {
            generator.writeKey("pri.get.exists_total");
            generator.write(this.priGetExistsTotal);
        }

        if (this.priGetMissingTime != null) {
            generator.writeKey("pri.get.missing_time");
            generator.write(this.priGetMissingTime);
        }

        if (this.priGetMissingTotal != null) {
            generator.writeKey("pri.get.missing_total");
            generator.write(this.priGetMissingTotal);
        }

        if (this.priGetTime != null) {
            generator.writeKey("pri.get.time");
            generator.write(this.priGetTime);
        }

        if (this.priGetTotal != null) {
            generator.writeKey("pri.get.total");
            generator.write(this.priGetTotal);
        }

        if (this.priIndexingDeleteCurrent != null) {
            generator.writeKey("pri.indexing.delete_current");
            generator.write(this.priIndexingDeleteCurrent);
        }

        if (this.priIndexingDeleteTime != null) {
            generator.writeKey("pri.indexing.delete_time");
            generator.write(this.priIndexingDeleteTime);
        }

        if (this.priIndexingDeleteTotal != null) {
            generator.writeKey("pri.indexing.delete_total");
            generator.write(this.priIndexingDeleteTotal);
        }

        if (this.priIndexingIndexCurrent != null) {
            generator.writeKey("pri.indexing.index_current");
            generator.write(this.priIndexingIndexCurrent);
        }

        if (this.priIndexingIndexFailed != null) {
            generator.writeKey("pri.indexing.index_failed");
            generator.write(this.priIndexingIndexFailed);
        }

        if (this.priIndexingIndexTime != null) {
            generator.writeKey("pri.indexing.index_time");
            generator.write(this.priIndexingIndexTime);
        }

        if (this.priIndexingIndexTotal != null) {
            generator.writeKey("pri.indexing.index_total");
            generator.write(this.priIndexingIndexTotal);
        }

        if (this.priMemoryTotal != null) {
            generator.writeKey("pri.memory.total");
            generator.write(this.priMemoryTotal);
        }

        if (this.priMergesCurrent != null) {
            generator.writeKey("pri.merges.current");
            generator.write(this.priMergesCurrent);
        }

        if (this.priMergesCurrentDocs != null) {
            generator.writeKey("pri.merges.current_docs");
            generator.write(this.priMergesCurrentDocs);
        }

        if (this.priMergesCurrentSize != null) {
            generator.writeKey("pri.merges.current_size");
            generator.write(this.priMergesCurrentSize);
        }

        if (this.priMergesTotal != null) {
            generator.writeKey("pri.merges.total");
            generator.write(this.priMergesTotal);
        }

        if (this.priMergesTotalDocs != null) {
            generator.writeKey("pri.merges.total_docs");
            generator.write(this.priMergesTotalDocs);
        }

        if (this.priMergesTotalSize != null) {
            generator.writeKey("pri.merges.total_size");
            generator.write(this.priMergesTotalSize);
        }

        if (this.priMergesTotalTime != null) {
            generator.writeKey("pri.merges.total_time");
            generator.write(this.priMergesTotalTime);
        }

        if (this.priQueryCacheEvictions != null) {
            generator.writeKey("pri.query_cache.evictions");
            generator.write(this.priQueryCacheEvictions);
        }

        if (this.priQueryCacheMemorySize != null) {
            generator.writeKey("pri.query_cache.memory_size");
            generator.write(this.priQueryCacheMemorySize);
        }

        if (this.priRefreshExternalTime != null) {
            generator.writeKey("pri.refresh.external_time");
            generator.write(this.priRefreshExternalTime);
        }

        if (this.priRefreshExternalTotal != null) {
            generator.writeKey("pri.refresh.external_total");
            generator.write(this.priRefreshExternalTotal);
        }

        if (this.priRefreshListeners != null) {
            generator.writeKey("pri.refresh.listeners");
            generator.write(this.priRefreshListeners);
        }

        if (this.priRefreshTime != null) {
            generator.writeKey("pri.refresh.time");
            generator.write(this.priRefreshTime);
        }

        if (this.priRefreshTotal != null) {
            generator.writeKey("pri.refresh.total");
            generator.write(this.priRefreshTotal);
        }

        if (this.priRequestCacheEvictions != null) {
            generator.writeKey("pri.request_cache.evictions");
            generator.write(this.priRequestCacheEvictions);
        }

        if (this.priRequestCacheHitCount != null) {
            generator.writeKey("pri.request_cache.hit_count");
            generator.write(this.priRequestCacheHitCount);
        }

        if (this.priRequestCacheMemorySize != null) {
            generator.writeKey("pri.request_cache.memory_size");
            generator.write(this.priRequestCacheMemorySize);
        }

        if (this.priRequestCacheMissCount != null) {
            generator.writeKey("pri.request_cache.miss_count");
            generator.write(this.priRequestCacheMissCount);
        }

        if (this.priSearchConcurrentAvgSliceCount != null) {
            generator.writeKey("pri.search.concurrent_avg_slice_count");
            generator.write(this.priSearchConcurrentAvgSliceCount);
        }

        if (this.priSearchConcurrentQueryCurrent != null) {
            generator.writeKey("pri.search.concurrent_query_current");
            generator.write(this.priSearchConcurrentQueryCurrent);
        }

        if (this.priSearchConcurrentQueryTime != null) {
            generator.writeKey("pri.search.concurrent_query_time");
            generator.write(this.priSearchConcurrentQueryTime);
        }

        if (this.priSearchConcurrentQueryTotal != null) {
            generator.writeKey("pri.search.concurrent_query_total");
            generator.write(this.priSearchConcurrentQueryTotal);
        }

        if (this.priSearchFetchCurrent != null) {
            generator.writeKey("pri.search.fetch_current");
            generator.write(this.priSearchFetchCurrent);
        }

        if (this.priSearchFetchTime != null) {
            generator.writeKey("pri.search.fetch_time");
            generator.write(this.priSearchFetchTime);
        }

        if (this.priSearchFetchTotal != null) {
            generator.writeKey("pri.search.fetch_total");
            generator.write(this.priSearchFetchTotal);
        }

        if (this.priSearchOpenContexts != null) {
            generator.writeKey("pri.search.open_contexts");
            generator.write(this.priSearchOpenContexts);
        }

        if (this.priSearchPointInTimeCurrent != null) {
            generator.writeKey("pri.search.point_in_time_current");
            generator.write(this.priSearchPointInTimeCurrent);
        }

        if (this.priSearchPointInTimeTime != null) {
            generator.writeKey("pri.search.point_in_time_time");
            generator.write(this.priSearchPointInTimeTime);
        }

        if (this.priSearchPointInTimeTotal != null) {
            generator.writeKey("pri.search.point_in_time_total");
            generator.write(this.priSearchPointInTimeTotal);
        }

        if (this.priSearchQueryCurrent != null) {
            generator.writeKey("pri.search.query_current");
            generator.write(this.priSearchQueryCurrent);
        }

        if (this.priSearchQueryTime != null) {
            generator.writeKey("pri.search.query_time");
            generator.write(this.priSearchQueryTime);
        }

        if (this.priSearchQueryTotal != null) {
            generator.writeKey("pri.search.query_total");
            generator.write(this.priSearchQueryTotal);
        }

        if (this.priSearchScrollCurrent != null) {
            generator.writeKey("pri.search.scroll_current");
            generator.write(this.priSearchScrollCurrent);
        }

        if (this.priSearchScrollTime != null) {
            generator.writeKey("pri.search.scroll_time");
            generator.write(this.priSearchScrollTime);
        }

        if (this.priSearchScrollTotal != null) {
            generator.writeKey("pri.search.scroll_total");
            generator.write(this.priSearchScrollTotal);
        }

        if (this.priSegmentsCount != null) {
            generator.writeKey("pri.segments.count");
            generator.write(this.priSegmentsCount);
        }

        if (this.priSegmentsFixedBitsetMemory != null) {
            generator.writeKey("pri.segments.fixed_bitset_memory");
            generator.write(this.priSegmentsFixedBitsetMemory);
        }

        if (this.priSegmentsIndexWriterMemory != null) {
            generator.writeKey("pri.segments.index_writer_memory");
            generator.write(this.priSegmentsIndexWriterMemory);
        }

        if (this.priSegmentsMemory != null) {
            generator.writeKey("pri.segments.memory");
            generator.write(this.priSegmentsMemory);
        }

        if (this.priSegmentsVersionMapMemory != null) {
            generator.writeKey("pri.segments.version_map_memory");
            generator.write(this.priSegmentsVersionMapMemory);
        }

        if (this.priStoreSize != null) {
            generator.writeKey("pri.store.size");
            generator.write(this.priStoreSize);
        }

        if (this.priSuggestCurrent != null) {
            generator.writeKey("pri.suggest.current");
            generator.write(this.priSuggestCurrent);
        }

        if (this.priSuggestTime != null) {
            generator.writeKey("pri.suggest.time");
            generator.write(this.priSuggestTime);
        }

        if (this.priSuggestTotal != null) {
            generator.writeKey("pri.suggest.total");
            generator.write(this.priSuggestTotal);
        }

        if (this.priWarmerCurrent != null) {
            generator.writeKey("pri.warmer.current");
            generator.write(this.priWarmerCurrent);
        }

        if (this.priWarmerTotal != null) {
            generator.writeKey("pri.warmer.total");
            generator.write(this.priWarmerTotal);
        }

        if (this.priWarmerTotalTime != null) {
            generator.writeKey("pri.warmer.total_time");
            generator.write(this.priWarmerTotalTime);
        }

        if (this.queryCacheEvictions != null) {
            generator.writeKey("query_cache.evictions");
            generator.write(this.queryCacheEvictions);
        }

        if (this.queryCacheMemorySize != null) {
            generator.writeKey("query_cache.memory_size");
            generator.write(this.queryCacheMemorySize);
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

        if (this.rep != null) {
            generator.writeKey("rep");
            generator.write(this.rep);
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

        if (this.searchThrottled != null) {
            generator.writeKey("search.throttled");
            generator.write(this.searchThrottled);
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

        if (this.status != null) {
            generator.writeKey("status");
            generator.write(this.status);
        }

        if (this.storeSize != null) {
            generator.writeKey("store.size");
            generator.write(this.storeSize);
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

        if (this.uuid != null) {
            generator.writeKey("uuid");
            generator.write(this.uuid);
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
     * Builder for {@link IndicesRecord}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndicesRecord> {
        @Nullable
        private String completionSize;
        @Nullable
        private String creationDate;
        @Nullable
        private String creationDateString;
        @Nullable
        private String docsCount;
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
        private String health;
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
        private String memoryTotal;
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
        private String pri;
        @Nullable
        private String priCompletionSize;
        @Nullable
        private String priFielddataEvictions;
        @Nullable
        private String priFielddataMemorySize;
        @Nullable
        private String priFlushTotal;
        @Nullable
        private String priFlushTotalTime;
        @Nullable
        private String priGetCurrent;
        @Nullable
        private String priGetExistsTime;
        @Nullable
        private String priGetExistsTotal;
        @Nullable
        private String priGetMissingTime;
        @Nullable
        private String priGetMissingTotal;
        @Nullable
        private String priGetTime;
        @Nullable
        private String priGetTotal;
        @Nullable
        private String priIndexingDeleteCurrent;
        @Nullable
        private String priIndexingDeleteTime;
        @Nullable
        private String priIndexingDeleteTotal;
        @Nullable
        private String priIndexingIndexCurrent;
        @Nullable
        private String priIndexingIndexFailed;
        @Nullable
        private String priIndexingIndexTime;
        @Nullable
        private String priIndexingIndexTotal;
        @Nullable
        private String priMemoryTotal;
        @Nullable
        private String priMergesCurrent;
        @Nullable
        private String priMergesCurrentDocs;
        @Nullable
        private String priMergesCurrentSize;
        @Nullable
        private String priMergesTotal;
        @Nullable
        private String priMergesTotalDocs;
        @Nullable
        private String priMergesTotalSize;
        @Nullable
        private String priMergesTotalTime;
        @Nullable
        private String priQueryCacheEvictions;
        @Nullable
        private String priQueryCacheMemorySize;
        @Nullable
        private String priRefreshExternalTime;
        @Nullable
        private String priRefreshExternalTotal;
        @Nullable
        private String priRefreshListeners;
        @Nullable
        private String priRefreshTime;
        @Nullable
        private String priRefreshTotal;
        @Nullable
        private String priRequestCacheEvictions;
        @Nullable
        private String priRequestCacheHitCount;
        @Nullable
        private String priRequestCacheMemorySize;
        @Nullable
        private String priRequestCacheMissCount;
        @Nullable
        private String priSearchConcurrentAvgSliceCount;
        @Nullable
        private String priSearchConcurrentQueryCurrent;
        @Nullable
        private String priSearchConcurrentQueryTime;
        @Nullable
        private String priSearchConcurrentQueryTotal;
        @Nullable
        private String priSearchFetchCurrent;
        @Nullable
        private String priSearchFetchTime;
        @Nullable
        private String priSearchFetchTotal;
        @Nullable
        private String priSearchOpenContexts;
        @Nullable
        private String priSearchPointInTimeCurrent;
        @Nullable
        private String priSearchPointInTimeTime;
        @Nullable
        private String priSearchPointInTimeTotal;
        @Nullable
        private String priSearchQueryCurrent;
        @Nullable
        private String priSearchQueryTime;
        @Nullable
        private String priSearchQueryTotal;
        @Nullable
        private String priSearchScrollCurrent;
        @Nullable
        private String priSearchScrollTime;
        @Nullable
        private String priSearchScrollTotal;
        @Nullable
        private String priSegmentsCount;
        @Nullable
        private String priSegmentsFixedBitsetMemory;
        @Nullable
        private String priSegmentsIndexWriterMemory;
        @Nullable
        private String priSegmentsMemory;
        @Nullable
        private String priSegmentsVersionMapMemory;
        @Nullable
        private String priStoreSize;
        @Nullable
        private String priSuggestCurrent;
        @Nullable
        private String priSuggestTime;
        @Nullable
        private String priSuggestTotal;
        @Nullable
        private String priWarmerCurrent;
        @Nullable
        private String priWarmerTotal;
        @Nullable
        private String priWarmerTotalTime;
        @Nullable
        private String queryCacheEvictions;
        @Nullable
        private String queryCacheMemorySize;
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
        private String rep;
        @Nullable
        private String requestCacheEvictions;
        @Nullable
        private String requestCacheHitCount;
        @Nullable
        private String requestCacheMemorySize;
        @Nullable
        private String requestCacheMissCount;
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
        private String searchThrottled;
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
        private String status;
        @Nullable
        private String storeSize;
        @Nullable
        private String suggestCurrent;
        @Nullable
        private String suggestTime;
        @Nullable
        private String suggestTotal;
        @Nullable
        private String uuid;
        @Nullable
        private String warmerCurrent;
        @Nullable
        private String warmerTotal;
        @Nullable
        private String warmerTotalTime;

        public Builder() {}

        private Builder(IndicesRecord o) {
            this.completionSize = o.completionSize;
            this.creationDate = o.creationDate;
            this.creationDateString = o.creationDateString;
            this.docsCount = o.docsCount;
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
            this.health = o.health;
            this.index = o.index;
            this.indexingDeleteCurrent = o.indexingDeleteCurrent;
            this.indexingDeleteTime = o.indexingDeleteTime;
            this.indexingDeleteTotal = o.indexingDeleteTotal;
            this.indexingIndexCurrent = o.indexingIndexCurrent;
            this.indexingIndexFailed = o.indexingIndexFailed;
            this.indexingIndexTime = o.indexingIndexTime;
            this.indexingIndexTotal = o.indexingIndexTotal;
            this.memoryTotal = o.memoryTotal;
            this.mergesCurrent = o.mergesCurrent;
            this.mergesCurrentDocs = o.mergesCurrentDocs;
            this.mergesCurrentSize = o.mergesCurrentSize;
            this.mergesTotal = o.mergesTotal;
            this.mergesTotalDocs = o.mergesTotalDocs;
            this.mergesTotalSize = o.mergesTotalSize;
            this.mergesTotalTime = o.mergesTotalTime;
            this.pri = o.pri;
            this.priCompletionSize = o.priCompletionSize;
            this.priFielddataEvictions = o.priFielddataEvictions;
            this.priFielddataMemorySize = o.priFielddataMemorySize;
            this.priFlushTotal = o.priFlushTotal;
            this.priFlushTotalTime = o.priFlushTotalTime;
            this.priGetCurrent = o.priGetCurrent;
            this.priGetExistsTime = o.priGetExistsTime;
            this.priGetExistsTotal = o.priGetExistsTotal;
            this.priGetMissingTime = o.priGetMissingTime;
            this.priGetMissingTotal = o.priGetMissingTotal;
            this.priGetTime = o.priGetTime;
            this.priGetTotal = o.priGetTotal;
            this.priIndexingDeleteCurrent = o.priIndexingDeleteCurrent;
            this.priIndexingDeleteTime = o.priIndexingDeleteTime;
            this.priIndexingDeleteTotal = o.priIndexingDeleteTotal;
            this.priIndexingIndexCurrent = o.priIndexingIndexCurrent;
            this.priIndexingIndexFailed = o.priIndexingIndexFailed;
            this.priIndexingIndexTime = o.priIndexingIndexTime;
            this.priIndexingIndexTotal = o.priIndexingIndexTotal;
            this.priMemoryTotal = o.priMemoryTotal;
            this.priMergesCurrent = o.priMergesCurrent;
            this.priMergesCurrentDocs = o.priMergesCurrentDocs;
            this.priMergesCurrentSize = o.priMergesCurrentSize;
            this.priMergesTotal = o.priMergesTotal;
            this.priMergesTotalDocs = o.priMergesTotalDocs;
            this.priMergesTotalSize = o.priMergesTotalSize;
            this.priMergesTotalTime = o.priMergesTotalTime;
            this.priQueryCacheEvictions = o.priQueryCacheEvictions;
            this.priQueryCacheMemorySize = o.priQueryCacheMemorySize;
            this.priRefreshExternalTime = o.priRefreshExternalTime;
            this.priRefreshExternalTotal = o.priRefreshExternalTotal;
            this.priRefreshListeners = o.priRefreshListeners;
            this.priRefreshTime = o.priRefreshTime;
            this.priRefreshTotal = o.priRefreshTotal;
            this.priRequestCacheEvictions = o.priRequestCacheEvictions;
            this.priRequestCacheHitCount = o.priRequestCacheHitCount;
            this.priRequestCacheMemorySize = o.priRequestCacheMemorySize;
            this.priRequestCacheMissCount = o.priRequestCacheMissCount;
            this.priSearchConcurrentAvgSliceCount = o.priSearchConcurrentAvgSliceCount;
            this.priSearchConcurrentQueryCurrent = o.priSearchConcurrentQueryCurrent;
            this.priSearchConcurrentQueryTime = o.priSearchConcurrentQueryTime;
            this.priSearchConcurrentQueryTotal = o.priSearchConcurrentQueryTotal;
            this.priSearchFetchCurrent = o.priSearchFetchCurrent;
            this.priSearchFetchTime = o.priSearchFetchTime;
            this.priSearchFetchTotal = o.priSearchFetchTotal;
            this.priSearchOpenContexts = o.priSearchOpenContexts;
            this.priSearchPointInTimeCurrent = o.priSearchPointInTimeCurrent;
            this.priSearchPointInTimeTime = o.priSearchPointInTimeTime;
            this.priSearchPointInTimeTotal = o.priSearchPointInTimeTotal;
            this.priSearchQueryCurrent = o.priSearchQueryCurrent;
            this.priSearchQueryTime = o.priSearchQueryTime;
            this.priSearchQueryTotal = o.priSearchQueryTotal;
            this.priSearchScrollCurrent = o.priSearchScrollCurrent;
            this.priSearchScrollTime = o.priSearchScrollTime;
            this.priSearchScrollTotal = o.priSearchScrollTotal;
            this.priSegmentsCount = o.priSegmentsCount;
            this.priSegmentsFixedBitsetMemory = o.priSegmentsFixedBitsetMemory;
            this.priSegmentsIndexWriterMemory = o.priSegmentsIndexWriterMemory;
            this.priSegmentsMemory = o.priSegmentsMemory;
            this.priSegmentsVersionMapMemory = o.priSegmentsVersionMapMemory;
            this.priStoreSize = o.priStoreSize;
            this.priSuggestCurrent = o.priSuggestCurrent;
            this.priSuggestTime = o.priSuggestTime;
            this.priSuggestTotal = o.priSuggestTotal;
            this.priWarmerCurrent = o.priWarmerCurrent;
            this.priWarmerTotal = o.priWarmerTotal;
            this.priWarmerTotalTime = o.priWarmerTotalTime;
            this.queryCacheEvictions = o.queryCacheEvictions;
            this.queryCacheMemorySize = o.queryCacheMemorySize;
            this.refreshExternalTime = o.refreshExternalTime;
            this.refreshExternalTotal = o.refreshExternalTotal;
            this.refreshListeners = o.refreshListeners;
            this.refreshTime = o.refreshTime;
            this.refreshTotal = o.refreshTotal;
            this.rep = o.rep;
            this.requestCacheEvictions = o.requestCacheEvictions;
            this.requestCacheHitCount = o.requestCacheHitCount;
            this.requestCacheMemorySize = o.requestCacheMemorySize;
            this.requestCacheMissCount = o.requestCacheMissCount;
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
            this.searchThrottled = o.searchThrottled;
            this.segmentsCount = o.segmentsCount;
            this.segmentsFixedBitsetMemory = o.segmentsFixedBitsetMemory;
            this.segmentsIndexWriterMemory = o.segmentsIndexWriterMemory;
            this.segmentsMemory = o.segmentsMemory;
            this.segmentsVersionMapMemory = o.segmentsVersionMapMemory;
            this.status = o.status;
            this.storeSize = o.storeSize;
            this.suggestCurrent = o.suggestCurrent;
            this.suggestTime = o.suggestTime;
            this.suggestTotal = o.suggestTotal;
            this.uuid = o.uuid;
            this.warmerCurrent = o.warmerCurrent;
            this.warmerTotal = o.warmerTotal;
            this.warmerTotalTime = o.warmerTotalTime;
        }

        private Builder(Builder o) {
            this.completionSize = o.completionSize;
            this.creationDate = o.creationDate;
            this.creationDateString = o.creationDateString;
            this.docsCount = o.docsCount;
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
            this.health = o.health;
            this.index = o.index;
            this.indexingDeleteCurrent = o.indexingDeleteCurrent;
            this.indexingDeleteTime = o.indexingDeleteTime;
            this.indexingDeleteTotal = o.indexingDeleteTotal;
            this.indexingIndexCurrent = o.indexingIndexCurrent;
            this.indexingIndexFailed = o.indexingIndexFailed;
            this.indexingIndexTime = o.indexingIndexTime;
            this.indexingIndexTotal = o.indexingIndexTotal;
            this.memoryTotal = o.memoryTotal;
            this.mergesCurrent = o.mergesCurrent;
            this.mergesCurrentDocs = o.mergesCurrentDocs;
            this.mergesCurrentSize = o.mergesCurrentSize;
            this.mergesTotal = o.mergesTotal;
            this.mergesTotalDocs = o.mergesTotalDocs;
            this.mergesTotalSize = o.mergesTotalSize;
            this.mergesTotalTime = o.mergesTotalTime;
            this.pri = o.pri;
            this.priCompletionSize = o.priCompletionSize;
            this.priFielddataEvictions = o.priFielddataEvictions;
            this.priFielddataMemorySize = o.priFielddataMemorySize;
            this.priFlushTotal = o.priFlushTotal;
            this.priFlushTotalTime = o.priFlushTotalTime;
            this.priGetCurrent = o.priGetCurrent;
            this.priGetExistsTime = o.priGetExistsTime;
            this.priGetExistsTotal = o.priGetExistsTotal;
            this.priGetMissingTime = o.priGetMissingTime;
            this.priGetMissingTotal = o.priGetMissingTotal;
            this.priGetTime = o.priGetTime;
            this.priGetTotal = o.priGetTotal;
            this.priIndexingDeleteCurrent = o.priIndexingDeleteCurrent;
            this.priIndexingDeleteTime = o.priIndexingDeleteTime;
            this.priIndexingDeleteTotal = o.priIndexingDeleteTotal;
            this.priIndexingIndexCurrent = o.priIndexingIndexCurrent;
            this.priIndexingIndexFailed = o.priIndexingIndexFailed;
            this.priIndexingIndexTime = o.priIndexingIndexTime;
            this.priIndexingIndexTotal = o.priIndexingIndexTotal;
            this.priMemoryTotal = o.priMemoryTotal;
            this.priMergesCurrent = o.priMergesCurrent;
            this.priMergesCurrentDocs = o.priMergesCurrentDocs;
            this.priMergesCurrentSize = o.priMergesCurrentSize;
            this.priMergesTotal = o.priMergesTotal;
            this.priMergesTotalDocs = o.priMergesTotalDocs;
            this.priMergesTotalSize = o.priMergesTotalSize;
            this.priMergesTotalTime = o.priMergesTotalTime;
            this.priQueryCacheEvictions = o.priQueryCacheEvictions;
            this.priQueryCacheMemorySize = o.priQueryCacheMemorySize;
            this.priRefreshExternalTime = o.priRefreshExternalTime;
            this.priRefreshExternalTotal = o.priRefreshExternalTotal;
            this.priRefreshListeners = o.priRefreshListeners;
            this.priRefreshTime = o.priRefreshTime;
            this.priRefreshTotal = o.priRefreshTotal;
            this.priRequestCacheEvictions = o.priRequestCacheEvictions;
            this.priRequestCacheHitCount = o.priRequestCacheHitCount;
            this.priRequestCacheMemorySize = o.priRequestCacheMemorySize;
            this.priRequestCacheMissCount = o.priRequestCacheMissCount;
            this.priSearchConcurrentAvgSliceCount = o.priSearchConcurrentAvgSliceCount;
            this.priSearchConcurrentQueryCurrent = o.priSearchConcurrentQueryCurrent;
            this.priSearchConcurrentQueryTime = o.priSearchConcurrentQueryTime;
            this.priSearchConcurrentQueryTotal = o.priSearchConcurrentQueryTotal;
            this.priSearchFetchCurrent = o.priSearchFetchCurrent;
            this.priSearchFetchTime = o.priSearchFetchTime;
            this.priSearchFetchTotal = o.priSearchFetchTotal;
            this.priSearchOpenContexts = o.priSearchOpenContexts;
            this.priSearchPointInTimeCurrent = o.priSearchPointInTimeCurrent;
            this.priSearchPointInTimeTime = o.priSearchPointInTimeTime;
            this.priSearchPointInTimeTotal = o.priSearchPointInTimeTotal;
            this.priSearchQueryCurrent = o.priSearchQueryCurrent;
            this.priSearchQueryTime = o.priSearchQueryTime;
            this.priSearchQueryTotal = o.priSearchQueryTotal;
            this.priSearchScrollCurrent = o.priSearchScrollCurrent;
            this.priSearchScrollTime = o.priSearchScrollTime;
            this.priSearchScrollTotal = o.priSearchScrollTotal;
            this.priSegmentsCount = o.priSegmentsCount;
            this.priSegmentsFixedBitsetMemory = o.priSegmentsFixedBitsetMemory;
            this.priSegmentsIndexWriterMemory = o.priSegmentsIndexWriterMemory;
            this.priSegmentsMemory = o.priSegmentsMemory;
            this.priSegmentsVersionMapMemory = o.priSegmentsVersionMapMemory;
            this.priStoreSize = o.priStoreSize;
            this.priSuggestCurrent = o.priSuggestCurrent;
            this.priSuggestTime = o.priSuggestTime;
            this.priSuggestTotal = o.priSuggestTotal;
            this.priWarmerCurrent = o.priWarmerCurrent;
            this.priWarmerTotal = o.priWarmerTotal;
            this.priWarmerTotalTime = o.priWarmerTotalTime;
            this.queryCacheEvictions = o.queryCacheEvictions;
            this.queryCacheMemorySize = o.queryCacheMemorySize;
            this.refreshExternalTime = o.refreshExternalTime;
            this.refreshExternalTotal = o.refreshExternalTotal;
            this.refreshListeners = o.refreshListeners;
            this.refreshTime = o.refreshTime;
            this.refreshTotal = o.refreshTotal;
            this.rep = o.rep;
            this.requestCacheEvictions = o.requestCacheEvictions;
            this.requestCacheHitCount = o.requestCacheHitCount;
            this.requestCacheMemorySize = o.requestCacheMemorySize;
            this.requestCacheMissCount = o.requestCacheMissCount;
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
            this.searchThrottled = o.searchThrottled;
            this.segmentsCount = o.segmentsCount;
            this.segmentsFixedBitsetMemory = o.segmentsFixedBitsetMemory;
            this.segmentsIndexWriterMemory = o.segmentsIndexWriterMemory;
            this.segmentsMemory = o.segmentsMemory;
            this.segmentsVersionMapMemory = o.segmentsVersionMapMemory;
            this.status = o.status;
            this.storeSize = o.storeSize;
            this.suggestCurrent = o.suggestCurrent;
            this.suggestTime = o.suggestTime;
            this.suggestTotal = o.suggestTotal;
            this.uuid = o.uuid;
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
         * size of completion
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
         * index creation date (millisecond value)
         * <p>
         * API name: {@code creation.date}
         * </p>
         */
        @Nonnull
        public final Builder creationDate(@Nullable String value) {
            this.creationDate = value;
            return this;
        }

        /**
         * index creation date (as string)
         * <p>
         * API name: {@code creation.date.string}
         * </p>
         */
        @Nonnull
        public final Builder creationDateString(@Nullable String value) {
            this.creationDateString = value;
            return this;
        }

        /**
         * available docs
         * <p>
         * API name: {@code docs.count}
         * </p>
         */
        @Nonnull
        public final Builder docsCount(@Nullable String value) {
            this.docsCount = value;
            return this;
        }

        /**
         * deleted docs
         * <p>
         * API name: {@code docs.deleted}
         * </p>
         */
        @Nonnull
        public final Builder docsDeleted(@Nullable String value) {
            this.docsDeleted = value;
            return this;
        }

        /**
         * field data evictions
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
         * used field data cache
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
         * number of flushes
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
         * time spent in flush
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
         * number of current get ops
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
         * time spent in successful gets
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
         * number of successful gets
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
         * time spent in failed gets
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
         * number of failed gets
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
         * time spent in get
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
         * number of get ops
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
         * current health status
         * <p>
         * API name: {@code health}
         * </p>
         */
        @Nonnull
        public final Builder health(@Nullable String value) {
            this.health = value;
            return this;
        }

        /**
         * index name
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
         * number of current deletions
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
         * time spent in deletions
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
         * number of delete ops
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
         * number of current indexing ops
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
         * number of failed indexing ops
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
         * time spent in indexing
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
         * number of indexing ops
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
         * total used memory
         * <p>
         * API name: {@code memory.total}
         * </p>
         */
        @Nonnull
        public final Builder memoryTotal(@Nullable String value) {
            this.memoryTotal = value;
            return this;
        }

        /**
         * number of current merges
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
         * number of current merging docs
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
         * size of current merges
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
         * number of completed merge ops
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
         * docs merged
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
         * size merged
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
         * time spent in merges
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
         * number of primary shards
         * <p>
         * API name: {@code pri}
         * </p>
         */
        @Nonnull
        public final Builder pri(@Nullable String value) {
            this.pri = value;
            return this;
        }

        /**
         * size of completion
         * <p>
         * API name: {@code pri.completion.size}
         * </p>
         */
        @Nonnull
        public final Builder priCompletionSize(@Nullable String value) {
            this.priCompletionSize = value;
            return this;
        }

        /**
         * field data evictions
         * <p>
         * API name: {@code pri.fielddata.evictions}
         * </p>
         */
        @Nonnull
        public final Builder priFielddataEvictions(@Nullable String value) {
            this.priFielddataEvictions = value;
            return this;
        }

        /**
         * used field data cache
         * <p>
         * API name: {@code pri.fielddata.memory_size}
         * </p>
         */
        @Nonnull
        public final Builder priFielddataMemorySize(@Nullable String value) {
            this.priFielddataMemorySize = value;
            return this;
        }

        /**
         * number of flushes
         * <p>
         * API name: {@code pri.flush.total}
         * </p>
         */
        @Nonnull
        public final Builder priFlushTotal(@Nullable String value) {
            this.priFlushTotal = value;
            return this;
        }

        /**
         * time spent in flush
         * <p>
         * API name: {@code pri.flush.total_time}
         * </p>
         */
        @Nonnull
        public final Builder priFlushTotalTime(@Nullable String value) {
            this.priFlushTotalTime = value;
            return this;
        }

        /**
         * number of current get ops
         * <p>
         * API name: {@code pri.get.current}
         * </p>
         */
        @Nonnull
        public final Builder priGetCurrent(@Nullable String value) {
            this.priGetCurrent = value;
            return this;
        }

        /**
         * time spent in successful gets
         * <p>
         * API name: {@code pri.get.exists_time}
         * </p>
         */
        @Nonnull
        public final Builder priGetExistsTime(@Nullable String value) {
            this.priGetExistsTime = value;
            return this;
        }

        /**
         * number of successful gets
         * <p>
         * API name: {@code pri.get.exists_total}
         * </p>
         */
        @Nonnull
        public final Builder priGetExistsTotal(@Nullable String value) {
            this.priGetExistsTotal = value;
            return this;
        }

        /**
         * time spent in failed gets
         * <p>
         * API name: {@code pri.get.missing_time}
         * </p>
         */
        @Nonnull
        public final Builder priGetMissingTime(@Nullable String value) {
            this.priGetMissingTime = value;
            return this;
        }

        /**
         * number of failed gets
         * <p>
         * API name: {@code pri.get.missing_total}
         * </p>
         */
        @Nonnull
        public final Builder priGetMissingTotal(@Nullable String value) {
            this.priGetMissingTotal = value;
            return this;
        }

        /**
         * time spent in get
         * <p>
         * API name: {@code pri.get.time}
         * </p>
         */
        @Nonnull
        public final Builder priGetTime(@Nullable String value) {
            this.priGetTime = value;
            return this;
        }

        /**
         * number of get ops
         * <p>
         * API name: {@code pri.get.total}
         * </p>
         */
        @Nonnull
        public final Builder priGetTotal(@Nullable String value) {
            this.priGetTotal = value;
            return this;
        }

        /**
         * number of current deletions
         * <p>
         * API name: {@code pri.indexing.delete_current}
         * </p>
         */
        @Nonnull
        public final Builder priIndexingDeleteCurrent(@Nullable String value) {
            this.priIndexingDeleteCurrent = value;
            return this;
        }

        /**
         * time spent in deletions
         * <p>
         * API name: {@code pri.indexing.delete_time}
         * </p>
         */
        @Nonnull
        public final Builder priIndexingDeleteTime(@Nullable String value) {
            this.priIndexingDeleteTime = value;
            return this;
        }

        /**
         * number of delete ops
         * <p>
         * API name: {@code pri.indexing.delete_total}
         * </p>
         */
        @Nonnull
        public final Builder priIndexingDeleteTotal(@Nullable String value) {
            this.priIndexingDeleteTotal = value;
            return this;
        }

        /**
         * number of current indexing ops
         * <p>
         * API name: {@code pri.indexing.index_current}
         * </p>
         */
        @Nonnull
        public final Builder priIndexingIndexCurrent(@Nullable String value) {
            this.priIndexingIndexCurrent = value;
            return this;
        }

        /**
         * number of failed indexing ops
         * <p>
         * API name: {@code pri.indexing.index_failed}
         * </p>
         */
        @Nonnull
        public final Builder priIndexingIndexFailed(@Nullable String value) {
            this.priIndexingIndexFailed = value;
            return this;
        }

        /**
         * time spent in indexing
         * <p>
         * API name: {@code pri.indexing.index_time}
         * </p>
         */
        @Nonnull
        public final Builder priIndexingIndexTime(@Nullable String value) {
            this.priIndexingIndexTime = value;
            return this;
        }

        /**
         * number of indexing ops
         * <p>
         * API name: {@code pri.indexing.index_total}
         * </p>
         */
        @Nonnull
        public final Builder priIndexingIndexTotal(@Nullable String value) {
            this.priIndexingIndexTotal = value;
            return this;
        }

        /**
         * total user memory
         * <p>
         * API name: {@code pri.memory.total}
         * </p>
         */
        @Nonnull
        public final Builder priMemoryTotal(@Nullable String value) {
            this.priMemoryTotal = value;
            return this;
        }

        /**
         * number of current merges
         * <p>
         * API name: {@code pri.merges.current}
         * </p>
         */
        @Nonnull
        public final Builder priMergesCurrent(@Nullable String value) {
            this.priMergesCurrent = value;
            return this;
        }

        /**
         * number of current merging docs
         * <p>
         * API name: {@code pri.merges.current_docs}
         * </p>
         */
        @Nonnull
        public final Builder priMergesCurrentDocs(@Nullable String value) {
            this.priMergesCurrentDocs = value;
            return this;
        }

        /**
         * size of current merges
         * <p>
         * API name: {@code pri.merges.current_size}
         * </p>
         */
        @Nonnull
        public final Builder priMergesCurrentSize(@Nullable String value) {
            this.priMergesCurrentSize = value;
            return this;
        }

        /**
         * number of completed merge ops
         * <p>
         * API name: {@code pri.merges.total}
         * </p>
         */
        @Nonnull
        public final Builder priMergesTotal(@Nullable String value) {
            this.priMergesTotal = value;
            return this;
        }

        /**
         * docs merged
         * <p>
         * API name: {@code pri.merges.total_docs}
         * </p>
         */
        @Nonnull
        public final Builder priMergesTotalDocs(@Nullable String value) {
            this.priMergesTotalDocs = value;
            return this;
        }

        /**
         * size merged
         * <p>
         * API name: {@code pri.merges.total_size}
         * </p>
         */
        @Nonnull
        public final Builder priMergesTotalSize(@Nullable String value) {
            this.priMergesTotalSize = value;
            return this;
        }

        /**
         * time spent in merges
         * <p>
         * API name: {@code pri.merges.total_time}
         * </p>
         */
        @Nonnull
        public final Builder priMergesTotalTime(@Nullable String value) {
            this.priMergesTotalTime = value;
            return this;
        }

        /**
         * query cache evictions
         * <p>
         * API name: {@code pri.query_cache.evictions}
         * </p>
         */
        @Nonnull
        public final Builder priQueryCacheEvictions(@Nullable String value) {
            this.priQueryCacheEvictions = value;
            return this;
        }

        /**
         * used query cache
         * <p>
         * API name: {@code pri.query_cache.memory_size}
         * </p>
         */
        @Nonnull
        public final Builder priQueryCacheMemorySize(@Nullable String value) {
            this.priQueryCacheMemorySize = value;
            return this;
        }

        /**
         * time spent in external refreshes
         * <p>
         * API name: {@code pri.refresh.external_time}
         * </p>
         */
        @Nonnull
        public final Builder priRefreshExternalTime(@Nullable String value) {
            this.priRefreshExternalTime = value;
            return this;
        }

        /**
         * total external refreshes
         * <p>
         * API name: {@code pri.refresh.external_total}
         * </p>
         */
        @Nonnull
        public final Builder priRefreshExternalTotal(@Nullable String value) {
            this.priRefreshExternalTotal = value;
            return this;
        }

        /**
         * number of pending refresh listeners
         * <p>
         * API name: {@code pri.refresh.listeners}
         * </p>
         */
        @Nonnull
        public final Builder priRefreshListeners(@Nullable String value) {
            this.priRefreshListeners = value;
            return this;
        }

        /**
         * time spent in refreshes
         * <p>
         * API name: {@code pri.refresh.time}
         * </p>
         */
        @Nonnull
        public final Builder priRefreshTime(@Nullable String value) {
            this.priRefreshTime = value;
            return this;
        }

        /**
         * total refreshes
         * <p>
         * API name: {@code pri.refresh.total}
         * </p>
         */
        @Nonnull
        public final Builder priRefreshTotal(@Nullable String value) {
            this.priRefreshTotal = value;
            return this;
        }

        /**
         * request cache evictions
         * <p>
         * API name: {@code pri.request_cache.evictions}
         * </p>
         */
        @Nonnull
        public final Builder priRequestCacheEvictions(@Nullable String value) {
            this.priRequestCacheEvictions = value;
            return this;
        }

        /**
         * request cache hit count
         * <p>
         * API name: {@code pri.request_cache.hit_count}
         * </p>
         */
        @Nonnull
        public final Builder priRequestCacheHitCount(@Nullable String value) {
            this.priRequestCacheHitCount = value;
            return this;
        }

        /**
         * used request cache
         * <p>
         * API name: {@code pri.request_cache.memory_size}
         * </p>
         */
        @Nonnull
        public final Builder priRequestCacheMemorySize(@Nullable String value) {
            this.priRequestCacheMemorySize = value;
            return this;
        }

        /**
         * request cache miss count
         * <p>
         * API name: {@code pri.request_cache.miss_count}
         * </p>
         */
        @Nonnull
        public final Builder priRequestCacheMissCount(@Nullable String value) {
            this.priRequestCacheMissCount = value;
            return this;
        }

        /**
         * API name: {@code pri.search.concurrent_avg_slice_count}
         */
        @Nonnull
        public final Builder priSearchConcurrentAvgSliceCount(@Nullable String value) {
            this.priSearchConcurrentAvgSliceCount = value;
            return this;
        }

        /**
         * API name: {@code pri.search.concurrent_query_current}
         */
        @Nonnull
        public final Builder priSearchConcurrentQueryCurrent(@Nullable String value) {
            this.priSearchConcurrentQueryCurrent = value;
            return this;
        }

        /**
         * API name: {@code pri.search.concurrent_query_time}
         */
        @Nonnull
        public final Builder priSearchConcurrentQueryTime(@Nullable String value) {
            this.priSearchConcurrentQueryTime = value;
            return this;
        }

        /**
         * API name: {@code pri.search.concurrent_query_total}
         */
        @Nonnull
        public final Builder priSearchConcurrentQueryTotal(@Nullable String value) {
            this.priSearchConcurrentQueryTotal = value;
            return this;
        }

        /**
         * current fetch phase ops
         * <p>
         * API name: {@code pri.search.fetch_current}
         * </p>
         */
        @Nonnull
        public final Builder priSearchFetchCurrent(@Nullable String value) {
            this.priSearchFetchCurrent = value;
            return this;
        }

        /**
         * time spent in fetch phase
         * <p>
         * API name: {@code pri.search.fetch_time}
         * </p>
         */
        @Nonnull
        public final Builder priSearchFetchTime(@Nullable String value) {
            this.priSearchFetchTime = value;
            return this;
        }

        /**
         * total fetch ops
         * <p>
         * API name: {@code pri.search.fetch_total}
         * </p>
         */
        @Nonnull
        public final Builder priSearchFetchTotal(@Nullable String value) {
            this.priSearchFetchTotal = value;
            return this;
        }

        /**
         * open search contexts
         * <p>
         * API name: {@code pri.search.open_contexts}
         * </p>
         */
        @Nonnull
        public final Builder priSearchOpenContexts(@Nullable String value) {
            this.priSearchOpenContexts = value;
            return this;
        }

        /**
         * API name: {@code pri.search.point_in_time_current}
         */
        @Nonnull
        public final Builder priSearchPointInTimeCurrent(@Nullable String value) {
            this.priSearchPointInTimeCurrent = value;
            return this;
        }

        /**
         * API name: {@code pri.search.point_in_time_time}
         */
        @Nonnull
        public final Builder priSearchPointInTimeTime(@Nullable String value) {
            this.priSearchPointInTimeTime = value;
            return this;
        }

        /**
         * API name: {@code pri.search.point_in_time_total}
         */
        @Nonnull
        public final Builder priSearchPointInTimeTotal(@Nullable String value) {
            this.priSearchPointInTimeTotal = value;
            return this;
        }

        /**
         * current query phase ops
         * <p>
         * API name: {@code pri.search.query_current}
         * </p>
         */
        @Nonnull
        public final Builder priSearchQueryCurrent(@Nullable String value) {
            this.priSearchQueryCurrent = value;
            return this;
        }

        /**
         * time spent in query phase
         * <p>
         * API name: {@code pri.search.query_time}
         * </p>
         */
        @Nonnull
        public final Builder priSearchQueryTime(@Nullable String value) {
            this.priSearchQueryTime = value;
            return this;
        }

        /**
         * total query phase ops
         * <p>
         * API name: {@code pri.search.query_total}
         * </p>
         */
        @Nonnull
        public final Builder priSearchQueryTotal(@Nullable String value) {
            this.priSearchQueryTotal = value;
            return this;
        }

        /**
         * open scroll contexts
         * <p>
         * API name: {@code pri.search.scroll_current}
         * </p>
         */
        @Nonnull
        public final Builder priSearchScrollCurrent(@Nullable String value) {
            this.priSearchScrollCurrent = value;
            return this;
        }

        /**
         * time scroll contexts held open
         * <p>
         * API name: {@code pri.search.scroll_time}
         * </p>
         */
        @Nonnull
        public final Builder priSearchScrollTime(@Nullable String value) {
            this.priSearchScrollTime = value;
            return this;
        }

        /**
         * completed scroll contexts
         * <p>
         * API name: {@code pri.search.scroll_total}
         * </p>
         */
        @Nonnull
        public final Builder priSearchScrollTotal(@Nullable String value) {
            this.priSearchScrollTotal = value;
            return this;
        }

        /**
         * number of segments
         * <p>
         * API name: {@code pri.segments.count}
         * </p>
         */
        @Nonnull
        public final Builder priSegmentsCount(@Nullable String value) {
            this.priSegmentsCount = value;
            return this;
        }

        /**
         * memory used by fixed bit sets for nested object field types and export type filters for types referred in <code>_parent</code>
         * fields
         * <p>
         * API name: {@code pri.segments.fixed_bitset_memory}
         * </p>
         */
        @Nonnull
        public final Builder priSegmentsFixedBitsetMemory(@Nullable String value) {
            this.priSegmentsFixedBitsetMemory = value;
            return this;
        }

        /**
         * memory used by index writer
         * <p>
         * API name: {@code pri.segments.index_writer_memory}
         * </p>
         */
        @Nonnull
        public final Builder priSegmentsIndexWriterMemory(@Nullable String value) {
            this.priSegmentsIndexWriterMemory = value;
            return this;
        }

        /**
         * memory used by segments
         * <p>
         * API name: {@code pri.segments.memory}
         * </p>
         */
        @Nonnull
        public final Builder priSegmentsMemory(@Nullable String value) {
            this.priSegmentsMemory = value;
            return this;
        }

        /**
         * memory used by version map
         * <p>
         * API name: {@code pri.segments.version_map_memory}
         * </p>
         */
        @Nonnull
        public final Builder priSegmentsVersionMapMemory(@Nullable String value) {
            this.priSegmentsVersionMapMemory = value;
            return this;
        }

        /**
         * store size of primaries
         * <p>
         * API name: {@code pri.store.size}
         * </p>
         */
        @Nonnull
        public final Builder priStoreSize(@Nullable String value) {
            this.priStoreSize = value;
            return this;
        }

        /**
         * number of current suggest ops
         * <p>
         * API name: {@code pri.suggest.current}
         * </p>
         */
        @Nonnull
        public final Builder priSuggestCurrent(@Nullable String value) {
            this.priSuggestCurrent = value;
            return this;
        }

        /**
         * time spend in suggest
         * <p>
         * API name: {@code pri.suggest.time}
         * </p>
         */
        @Nonnull
        public final Builder priSuggestTime(@Nullable String value) {
            this.priSuggestTime = value;
            return this;
        }

        /**
         * number of suggest ops
         * <p>
         * API name: {@code pri.suggest.total}
         * </p>
         */
        @Nonnull
        public final Builder priSuggestTotal(@Nullable String value) {
            this.priSuggestTotal = value;
            return this;
        }

        /**
         * current warmer ops
         * <p>
         * API name: {@code pri.warmer.current}
         * </p>
         */
        @Nonnull
        public final Builder priWarmerCurrent(@Nullable String value) {
            this.priWarmerCurrent = value;
            return this;
        }

        /**
         * total warmer ops
         * <p>
         * API name: {@code pri.warmer.total}
         * </p>
         */
        @Nonnull
        public final Builder priWarmerTotal(@Nullable String value) {
            this.priWarmerTotal = value;
            return this;
        }

        /**
         * time spent in warmers
         * <p>
         * API name: {@code pri.warmer.total_time}
         * </p>
         */
        @Nonnull
        public final Builder priWarmerTotalTime(@Nullable String value) {
            this.priWarmerTotalTime = value;
            return this;
        }

        /**
         * query cache evictions
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
         * used query cache
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
         * time spent in external refreshes
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
         * total external refreshes
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
         * number of pending refresh listeners
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
         * time spent in refreshes
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
         * total refreshes
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
         * number of replica shards
         * <p>
         * API name: {@code rep}
         * </p>
         */
        @Nonnull
        public final Builder rep(@Nullable String value) {
            this.rep = value;
            return this;
        }

        /**
         * request cache evictions
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
         * request cache hit count
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
         * used request cache
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
         * request cache miss count
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
         * current fetch phase ops
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
         * time spent in fetch phase
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
         * total fetch ops
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
         * open search contexts
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
         * current query phase ops
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
         * time spent in query phase
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
         * total query phase ops
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
         * open scroll contexts
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
         * time scroll contexts held open
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
         * completed scroll contexts
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
         * indicates if the index is search throttled
         * <p>
         * API name: {@code search.throttled}
         * </p>
         */
        @Nonnull
        public final Builder searchThrottled(@Nullable String value) {
            this.searchThrottled = value;
            return this;
        }

        /**
         * number of segments
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
         * memory used by fixed bit sets for nested object field types and export type filters for types referred in <code>_parent</code>
         * fields
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
         * memory used by index writer
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
         * memory used by segments
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
         * memory used by version map
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
         * open/close status
         * <p>
         * API name: {@code status}
         * </p>
         */
        @Nonnull
        public final Builder status(@Nullable String value) {
            this.status = value;
            return this;
        }

        /**
         * store size of primaries and replicas
         * <p>
         * API name: {@code store.size}
         * </p>
         */
        @Nonnull
        public final Builder storeSize(@Nullable String value) {
            this.storeSize = value;
            return this;
        }

        /**
         * number of current suggest ops
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
         * time spend in suggest
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
         * number of suggest ops
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
         * index UUID
         * <p>
         * API name: {@code uuid}
         * </p>
         */
        @Nonnull
        public final Builder uuid(@Nullable String value) {
            this.uuid = value;
            return this;
        }

        /**
         * current warmer ops
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
         * total warmer ops
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
         * time spent in warmers
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
         * Builds a {@link IndicesRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndicesRecord build() {
            _checkSingleUse();

            return new IndicesRecord(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndicesRecord}
     */
    public static final JsonpDeserializer<IndicesRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndicesRecord::setupIndicesRecordDeserializer
    );

    protected static void setupIndicesRecordDeserializer(ObjectDeserializer<IndicesRecord.Builder> op) {
        op.add(Builder::completionSize, JsonpDeserializer.stringDeserializer(), "completion.size");
        op.add(Builder::creationDate, JsonpDeserializer.stringDeserializer(), "creation.date");
        op.add(Builder::creationDateString, JsonpDeserializer.stringDeserializer(), "creation.date.string");
        op.add(Builder::docsCount, JsonpDeserializer.stringDeserializer(), "docs.count");
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
        op.add(Builder::health, JsonpDeserializer.stringDeserializer(), "health");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::indexingDeleteCurrent, JsonpDeserializer.stringDeserializer(), "indexing.delete_current");
        op.add(Builder::indexingDeleteTime, JsonpDeserializer.stringDeserializer(), "indexing.delete_time");
        op.add(Builder::indexingDeleteTotal, JsonpDeserializer.stringDeserializer(), "indexing.delete_total");
        op.add(Builder::indexingIndexCurrent, JsonpDeserializer.stringDeserializer(), "indexing.index_current");
        op.add(Builder::indexingIndexFailed, JsonpDeserializer.stringDeserializer(), "indexing.index_failed");
        op.add(Builder::indexingIndexTime, JsonpDeserializer.stringDeserializer(), "indexing.index_time");
        op.add(Builder::indexingIndexTotal, JsonpDeserializer.stringDeserializer(), "indexing.index_total");
        op.add(Builder::memoryTotal, JsonpDeserializer.stringDeserializer(), "memory.total");
        op.add(Builder::mergesCurrent, JsonpDeserializer.stringDeserializer(), "merges.current");
        op.add(Builder::mergesCurrentDocs, JsonpDeserializer.stringDeserializer(), "merges.current_docs");
        op.add(Builder::mergesCurrentSize, JsonpDeserializer.stringDeserializer(), "merges.current_size");
        op.add(Builder::mergesTotal, JsonpDeserializer.stringDeserializer(), "merges.total");
        op.add(Builder::mergesTotalDocs, JsonpDeserializer.stringDeserializer(), "merges.total_docs");
        op.add(Builder::mergesTotalSize, JsonpDeserializer.stringDeserializer(), "merges.total_size");
        op.add(Builder::mergesTotalTime, JsonpDeserializer.stringDeserializer(), "merges.total_time");
        op.add(Builder::pri, JsonpDeserializer.stringDeserializer(), "pri");
        op.add(Builder::priCompletionSize, JsonpDeserializer.stringDeserializer(), "pri.completion.size");
        op.add(Builder::priFielddataEvictions, JsonpDeserializer.stringDeserializer(), "pri.fielddata.evictions");
        op.add(Builder::priFielddataMemorySize, JsonpDeserializer.stringDeserializer(), "pri.fielddata.memory_size");
        op.add(Builder::priFlushTotal, JsonpDeserializer.stringDeserializer(), "pri.flush.total");
        op.add(Builder::priFlushTotalTime, JsonpDeserializer.stringDeserializer(), "pri.flush.total_time");
        op.add(Builder::priGetCurrent, JsonpDeserializer.stringDeserializer(), "pri.get.current");
        op.add(Builder::priGetExistsTime, JsonpDeserializer.stringDeserializer(), "pri.get.exists_time");
        op.add(Builder::priGetExistsTotal, JsonpDeserializer.stringDeserializer(), "pri.get.exists_total");
        op.add(Builder::priGetMissingTime, JsonpDeserializer.stringDeserializer(), "pri.get.missing_time");
        op.add(Builder::priGetMissingTotal, JsonpDeserializer.stringDeserializer(), "pri.get.missing_total");
        op.add(Builder::priGetTime, JsonpDeserializer.stringDeserializer(), "pri.get.time");
        op.add(Builder::priGetTotal, JsonpDeserializer.stringDeserializer(), "pri.get.total");
        op.add(Builder::priIndexingDeleteCurrent, JsonpDeserializer.stringDeserializer(), "pri.indexing.delete_current");
        op.add(Builder::priIndexingDeleteTime, JsonpDeserializer.stringDeserializer(), "pri.indexing.delete_time");
        op.add(Builder::priIndexingDeleteTotal, JsonpDeserializer.stringDeserializer(), "pri.indexing.delete_total");
        op.add(Builder::priIndexingIndexCurrent, JsonpDeserializer.stringDeserializer(), "pri.indexing.index_current");
        op.add(Builder::priIndexingIndexFailed, JsonpDeserializer.stringDeserializer(), "pri.indexing.index_failed");
        op.add(Builder::priIndexingIndexTime, JsonpDeserializer.stringDeserializer(), "pri.indexing.index_time");
        op.add(Builder::priIndexingIndexTotal, JsonpDeserializer.stringDeserializer(), "pri.indexing.index_total");
        op.add(Builder::priMemoryTotal, JsonpDeserializer.stringDeserializer(), "pri.memory.total");
        op.add(Builder::priMergesCurrent, JsonpDeserializer.stringDeserializer(), "pri.merges.current");
        op.add(Builder::priMergesCurrentDocs, JsonpDeserializer.stringDeserializer(), "pri.merges.current_docs");
        op.add(Builder::priMergesCurrentSize, JsonpDeserializer.stringDeserializer(), "pri.merges.current_size");
        op.add(Builder::priMergesTotal, JsonpDeserializer.stringDeserializer(), "pri.merges.total");
        op.add(Builder::priMergesTotalDocs, JsonpDeserializer.stringDeserializer(), "pri.merges.total_docs");
        op.add(Builder::priMergesTotalSize, JsonpDeserializer.stringDeserializer(), "pri.merges.total_size");
        op.add(Builder::priMergesTotalTime, JsonpDeserializer.stringDeserializer(), "pri.merges.total_time");
        op.add(Builder::priQueryCacheEvictions, JsonpDeserializer.stringDeserializer(), "pri.query_cache.evictions");
        op.add(Builder::priQueryCacheMemorySize, JsonpDeserializer.stringDeserializer(), "pri.query_cache.memory_size");
        op.add(Builder::priRefreshExternalTime, JsonpDeserializer.stringDeserializer(), "pri.refresh.external_time");
        op.add(Builder::priRefreshExternalTotal, JsonpDeserializer.stringDeserializer(), "pri.refresh.external_total");
        op.add(Builder::priRefreshListeners, JsonpDeserializer.stringDeserializer(), "pri.refresh.listeners");
        op.add(Builder::priRefreshTime, JsonpDeserializer.stringDeserializer(), "pri.refresh.time");
        op.add(Builder::priRefreshTotal, JsonpDeserializer.stringDeserializer(), "pri.refresh.total");
        op.add(Builder::priRequestCacheEvictions, JsonpDeserializer.stringDeserializer(), "pri.request_cache.evictions");
        op.add(Builder::priRequestCacheHitCount, JsonpDeserializer.stringDeserializer(), "pri.request_cache.hit_count");
        op.add(Builder::priRequestCacheMemorySize, JsonpDeserializer.stringDeserializer(), "pri.request_cache.memory_size");
        op.add(Builder::priRequestCacheMissCount, JsonpDeserializer.stringDeserializer(), "pri.request_cache.miss_count");
        op.add(Builder::priSearchConcurrentAvgSliceCount, JsonpDeserializer.stringDeserializer(), "pri.search.concurrent_avg_slice_count");
        op.add(Builder::priSearchConcurrentQueryCurrent, JsonpDeserializer.stringDeserializer(), "pri.search.concurrent_query_current");
        op.add(Builder::priSearchConcurrentQueryTime, JsonpDeserializer.stringDeserializer(), "pri.search.concurrent_query_time");
        op.add(Builder::priSearchConcurrentQueryTotal, JsonpDeserializer.stringDeserializer(), "pri.search.concurrent_query_total");
        op.add(Builder::priSearchFetchCurrent, JsonpDeserializer.stringDeserializer(), "pri.search.fetch_current");
        op.add(Builder::priSearchFetchTime, JsonpDeserializer.stringDeserializer(), "pri.search.fetch_time");
        op.add(Builder::priSearchFetchTotal, JsonpDeserializer.stringDeserializer(), "pri.search.fetch_total");
        op.add(Builder::priSearchOpenContexts, JsonpDeserializer.stringDeserializer(), "pri.search.open_contexts");
        op.add(Builder::priSearchPointInTimeCurrent, JsonpDeserializer.stringDeserializer(), "pri.search.point_in_time_current");
        op.add(Builder::priSearchPointInTimeTime, JsonpDeserializer.stringDeserializer(), "pri.search.point_in_time_time");
        op.add(Builder::priSearchPointInTimeTotal, JsonpDeserializer.stringDeserializer(), "pri.search.point_in_time_total");
        op.add(Builder::priSearchQueryCurrent, JsonpDeserializer.stringDeserializer(), "pri.search.query_current");
        op.add(Builder::priSearchQueryTime, JsonpDeserializer.stringDeserializer(), "pri.search.query_time");
        op.add(Builder::priSearchQueryTotal, JsonpDeserializer.stringDeserializer(), "pri.search.query_total");
        op.add(Builder::priSearchScrollCurrent, JsonpDeserializer.stringDeserializer(), "pri.search.scroll_current");
        op.add(Builder::priSearchScrollTime, JsonpDeserializer.stringDeserializer(), "pri.search.scroll_time");
        op.add(Builder::priSearchScrollTotal, JsonpDeserializer.stringDeserializer(), "pri.search.scroll_total");
        op.add(Builder::priSegmentsCount, JsonpDeserializer.stringDeserializer(), "pri.segments.count");
        op.add(Builder::priSegmentsFixedBitsetMemory, JsonpDeserializer.stringDeserializer(), "pri.segments.fixed_bitset_memory");
        op.add(Builder::priSegmentsIndexWriterMemory, JsonpDeserializer.stringDeserializer(), "pri.segments.index_writer_memory");
        op.add(Builder::priSegmentsMemory, JsonpDeserializer.stringDeserializer(), "pri.segments.memory");
        op.add(Builder::priSegmentsVersionMapMemory, JsonpDeserializer.stringDeserializer(), "pri.segments.version_map_memory");
        op.add(Builder::priStoreSize, JsonpDeserializer.stringDeserializer(), "pri.store.size");
        op.add(Builder::priSuggestCurrent, JsonpDeserializer.stringDeserializer(), "pri.suggest.current");
        op.add(Builder::priSuggestTime, JsonpDeserializer.stringDeserializer(), "pri.suggest.time");
        op.add(Builder::priSuggestTotal, JsonpDeserializer.stringDeserializer(), "pri.suggest.total");
        op.add(Builder::priWarmerCurrent, JsonpDeserializer.stringDeserializer(), "pri.warmer.current");
        op.add(Builder::priWarmerTotal, JsonpDeserializer.stringDeserializer(), "pri.warmer.total");
        op.add(Builder::priWarmerTotalTime, JsonpDeserializer.stringDeserializer(), "pri.warmer.total_time");
        op.add(Builder::queryCacheEvictions, JsonpDeserializer.stringDeserializer(), "query_cache.evictions");
        op.add(Builder::queryCacheMemorySize, JsonpDeserializer.stringDeserializer(), "query_cache.memory_size");
        op.add(Builder::refreshExternalTime, JsonpDeserializer.stringDeserializer(), "refresh.external_time");
        op.add(Builder::refreshExternalTotal, JsonpDeserializer.stringDeserializer(), "refresh.external_total");
        op.add(Builder::refreshListeners, JsonpDeserializer.stringDeserializer(), "refresh.listeners");
        op.add(Builder::refreshTime, JsonpDeserializer.stringDeserializer(), "refresh.time");
        op.add(Builder::refreshTotal, JsonpDeserializer.stringDeserializer(), "refresh.total");
        op.add(Builder::rep, JsonpDeserializer.stringDeserializer(), "rep");
        op.add(Builder::requestCacheEvictions, JsonpDeserializer.stringDeserializer(), "request_cache.evictions");
        op.add(Builder::requestCacheHitCount, JsonpDeserializer.stringDeserializer(), "request_cache.hit_count");
        op.add(Builder::requestCacheMemorySize, JsonpDeserializer.stringDeserializer(), "request_cache.memory_size");
        op.add(Builder::requestCacheMissCount, JsonpDeserializer.stringDeserializer(), "request_cache.miss_count");
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
        op.add(Builder::searchThrottled, JsonpDeserializer.stringDeserializer(), "search.throttled");
        op.add(Builder::segmentsCount, JsonpDeserializer.stringDeserializer(), "segments.count");
        op.add(Builder::segmentsFixedBitsetMemory, JsonpDeserializer.stringDeserializer(), "segments.fixed_bitset_memory");
        op.add(Builder::segmentsIndexWriterMemory, JsonpDeserializer.stringDeserializer(), "segments.index_writer_memory");
        op.add(Builder::segmentsMemory, JsonpDeserializer.stringDeserializer(), "segments.memory");
        op.add(Builder::segmentsVersionMapMemory, JsonpDeserializer.stringDeserializer(), "segments.version_map_memory");
        op.add(Builder::status, JsonpDeserializer.stringDeserializer(), "status");
        op.add(Builder::storeSize, JsonpDeserializer.stringDeserializer(), "store.size");
        op.add(Builder::suggestCurrent, JsonpDeserializer.stringDeserializer(), "suggest.current");
        op.add(Builder::suggestTime, JsonpDeserializer.stringDeserializer(), "suggest.time");
        op.add(Builder::suggestTotal, JsonpDeserializer.stringDeserializer(), "suggest.total");
        op.add(Builder::uuid, JsonpDeserializer.stringDeserializer(), "uuid");
        op.add(Builder::warmerCurrent, JsonpDeserializer.stringDeserializer(), "warmer.current");
        op.add(Builder::warmerTotal, JsonpDeserializer.stringDeserializer(), "warmer.total");
        op.add(Builder::warmerTotalTime, JsonpDeserializer.stringDeserializer(), "warmer.total_time");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.completionSize);
        result = 31 * result + Objects.hashCode(this.creationDate);
        result = 31 * result + Objects.hashCode(this.creationDateString);
        result = 31 * result + Objects.hashCode(this.docsCount);
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
        result = 31 * result + Objects.hashCode(this.health);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.indexingDeleteCurrent);
        result = 31 * result + Objects.hashCode(this.indexingDeleteTime);
        result = 31 * result + Objects.hashCode(this.indexingDeleteTotal);
        result = 31 * result + Objects.hashCode(this.indexingIndexCurrent);
        result = 31 * result + Objects.hashCode(this.indexingIndexFailed);
        result = 31 * result + Objects.hashCode(this.indexingIndexTime);
        result = 31 * result + Objects.hashCode(this.indexingIndexTotal);
        result = 31 * result + Objects.hashCode(this.memoryTotal);
        result = 31 * result + Objects.hashCode(this.mergesCurrent);
        result = 31 * result + Objects.hashCode(this.mergesCurrentDocs);
        result = 31 * result + Objects.hashCode(this.mergesCurrentSize);
        result = 31 * result + Objects.hashCode(this.mergesTotal);
        result = 31 * result + Objects.hashCode(this.mergesTotalDocs);
        result = 31 * result + Objects.hashCode(this.mergesTotalSize);
        result = 31 * result + Objects.hashCode(this.mergesTotalTime);
        result = 31 * result + Objects.hashCode(this.pri);
        result = 31 * result + Objects.hashCode(this.priCompletionSize);
        result = 31 * result + Objects.hashCode(this.priFielddataEvictions);
        result = 31 * result + Objects.hashCode(this.priFielddataMemorySize);
        result = 31 * result + Objects.hashCode(this.priFlushTotal);
        result = 31 * result + Objects.hashCode(this.priFlushTotalTime);
        result = 31 * result + Objects.hashCode(this.priGetCurrent);
        result = 31 * result + Objects.hashCode(this.priGetExistsTime);
        result = 31 * result + Objects.hashCode(this.priGetExistsTotal);
        result = 31 * result + Objects.hashCode(this.priGetMissingTime);
        result = 31 * result + Objects.hashCode(this.priGetMissingTotal);
        result = 31 * result + Objects.hashCode(this.priGetTime);
        result = 31 * result + Objects.hashCode(this.priGetTotal);
        result = 31 * result + Objects.hashCode(this.priIndexingDeleteCurrent);
        result = 31 * result + Objects.hashCode(this.priIndexingDeleteTime);
        result = 31 * result + Objects.hashCode(this.priIndexingDeleteTotal);
        result = 31 * result + Objects.hashCode(this.priIndexingIndexCurrent);
        result = 31 * result + Objects.hashCode(this.priIndexingIndexFailed);
        result = 31 * result + Objects.hashCode(this.priIndexingIndexTime);
        result = 31 * result + Objects.hashCode(this.priIndexingIndexTotal);
        result = 31 * result + Objects.hashCode(this.priMemoryTotal);
        result = 31 * result + Objects.hashCode(this.priMergesCurrent);
        result = 31 * result + Objects.hashCode(this.priMergesCurrentDocs);
        result = 31 * result + Objects.hashCode(this.priMergesCurrentSize);
        result = 31 * result + Objects.hashCode(this.priMergesTotal);
        result = 31 * result + Objects.hashCode(this.priMergesTotalDocs);
        result = 31 * result + Objects.hashCode(this.priMergesTotalSize);
        result = 31 * result + Objects.hashCode(this.priMergesTotalTime);
        result = 31 * result + Objects.hashCode(this.priQueryCacheEvictions);
        result = 31 * result + Objects.hashCode(this.priQueryCacheMemorySize);
        result = 31 * result + Objects.hashCode(this.priRefreshExternalTime);
        result = 31 * result + Objects.hashCode(this.priRefreshExternalTotal);
        result = 31 * result + Objects.hashCode(this.priRefreshListeners);
        result = 31 * result + Objects.hashCode(this.priRefreshTime);
        result = 31 * result + Objects.hashCode(this.priRefreshTotal);
        result = 31 * result + Objects.hashCode(this.priRequestCacheEvictions);
        result = 31 * result + Objects.hashCode(this.priRequestCacheHitCount);
        result = 31 * result + Objects.hashCode(this.priRequestCacheMemorySize);
        result = 31 * result + Objects.hashCode(this.priRequestCacheMissCount);
        result = 31 * result + Objects.hashCode(this.priSearchConcurrentAvgSliceCount);
        result = 31 * result + Objects.hashCode(this.priSearchConcurrentQueryCurrent);
        result = 31 * result + Objects.hashCode(this.priSearchConcurrentQueryTime);
        result = 31 * result + Objects.hashCode(this.priSearchConcurrentQueryTotal);
        result = 31 * result + Objects.hashCode(this.priSearchFetchCurrent);
        result = 31 * result + Objects.hashCode(this.priSearchFetchTime);
        result = 31 * result + Objects.hashCode(this.priSearchFetchTotal);
        result = 31 * result + Objects.hashCode(this.priSearchOpenContexts);
        result = 31 * result + Objects.hashCode(this.priSearchPointInTimeCurrent);
        result = 31 * result + Objects.hashCode(this.priSearchPointInTimeTime);
        result = 31 * result + Objects.hashCode(this.priSearchPointInTimeTotal);
        result = 31 * result + Objects.hashCode(this.priSearchQueryCurrent);
        result = 31 * result + Objects.hashCode(this.priSearchQueryTime);
        result = 31 * result + Objects.hashCode(this.priSearchQueryTotal);
        result = 31 * result + Objects.hashCode(this.priSearchScrollCurrent);
        result = 31 * result + Objects.hashCode(this.priSearchScrollTime);
        result = 31 * result + Objects.hashCode(this.priSearchScrollTotal);
        result = 31 * result + Objects.hashCode(this.priSegmentsCount);
        result = 31 * result + Objects.hashCode(this.priSegmentsFixedBitsetMemory);
        result = 31 * result + Objects.hashCode(this.priSegmentsIndexWriterMemory);
        result = 31 * result + Objects.hashCode(this.priSegmentsMemory);
        result = 31 * result + Objects.hashCode(this.priSegmentsVersionMapMemory);
        result = 31 * result + Objects.hashCode(this.priStoreSize);
        result = 31 * result + Objects.hashCode(this.priSuggestCurrent);
        result = 31 * result + Objects.hashCode(this.priSuggestTime);
        result = 31 * result + Objects.hashCode(this.priSuggestTotal);
        result = 31 * result + Objects.hashCode(this.priWarmerCurrent);
        result = 31 * result + Objects.hashCode(this.priWarmerTotal);
        result = 31 * result + Objects.hashCode(this.priWarmerTotalTime);
        result = 31 * result + Objects.hashCode(this.queryCacheEvictions);
        result = 31 * result + Objects.hashCode(this.queryCacheMemorySize);
        result = 31 * result + Objects.hashCode(this.refreshExternalTime);
        result = 31 * result + Objects.hashCode(this.refreshExternalTotal);
        result = 31 * result + Objects.hashCode(this.refreshListeners);
        result = 31 * result + Objects.hashCode(this.refreshTime);
        result = 31 * result + Objects.hashCode(this.refreshTotal);
        result = 31 * result + Objects.hashCode(this.rep);
        result = 31 * result + Objects.hashCode(this.requestCacheEvictions);
        result = 31 * result + Objects.hashCode(this.requestCacheHitCount);
        result = 31 * result + Objects.hashCode(this.requestCacheMemorySize);
        result = 31 * result + Objects.hashCode(this.requestCacheMissCount);
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
        result = 31 * result + Objects.hashCode(this.searchThrottled);
        result = 31 * result + Objects.hashCode(this.segmentsCount);
        result = 31 * result + Objects.hashCode(this.segmentsFixedBitsetMemory);
        result = 31 * result + Objects.hashCode(this.segmentsIndexWriterMemory);
        result = 31 * result + Objects.hashCode(this.segmentsMemory);
        result = 31 * result + Objects.hashCode(this.segmentsVersionMapMemory);
        result = 31 * result + Objects.hashCode(this.status);
        result = 31 * result + Objects.hashCode(this.storeSize);
        result = 31 * result + Objects.hashCode(this.suggestCurrent);
        result = 31 * result + Objects.hashCode(this.suggestTime);
        result = 31 * result + Objects.hashCode(this.suggestTotal);
        result = 31 * result + Objects.hashCode(this.uuid);
        result = 31 * result + Objects.hashCode(this.warmerCurrent);
        result = 31 * result + Objects.hashCode(this.warmerTotal);
        result = 31 * result + Objects.hashCode(this.warmerTotalTime);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndicesRecord other = (IndicesRecord) o;
        return Objects.equals(this.completionSize, other.completionSize)
            && Objects.equals(this.creationDate, other.creationDate)
            && Objects.equals(this.creationDateString, other.creationDateString)
            && Objects.equals(this.docsCount, other.docsCount)
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
            && Objects.equals(this.health, other.health)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.indexingDeleteCurrent, other.indexingDeleteCurrent)
            && Objects.equals(this.indexingDeleteTime, other.indexingDeleteTime)
            && Objects.equals(this.indexingDeleteTotal, other.indexingDeleteTotal)
            && Objects.equals(this.indexingIndexCurrent, other.indexingIndexCurrent)
            && Objects.equals(this.indexingIndexFailed, other.indexingIndexFailed)
            && Objects.equals(this.indexingIndexTime, other.indexingIndexTime)
            && Objects.equals(this.indexingIndexTotal, other.indexingIndexTotal)
            && Objects.equals(this.memoryTotal, other.memoryTotal)
            && Objects.equals(this.mergesCurrent, other.mergesCurrent)
            && Objects.equals(this.mergesCurrentDocs, other.mergesCurrentDocs)
            && Objects.equals(this.mergesCurrentSize, other.mergesCurrentSize)
            && Objects.equals(this.mergesTotal, other.mergesTotal)
            && Objects.equals(this.mergesTotalDocs, other.mergesTotalDocs)
            && Objects.equals(this.mergesTotalSize, other.mergesTotalSize)
            && Objects.equals(this.mergesTotalTime, other.mergesTotalTime)
            && Objects.equals(this.pri, other.pri)
            && Objects.equals(this.priCompletionSize, other.priCompletionSize)
            && Objects.equals(this.priFielddataEvictions, other.priFielddataEvictions)
            && Objects.equals(this.priFielddataMemorySize, other.priFielddataMemorySize)
            && Objects.equals(this.priFlushTotal, other.priFlushTotal)
            && Objects.equals(this.priFlushTotalTime, other.priFlushTotalTime)
            && Objects.equals(this.priGetCurrent, other.priGetCurrent)
            && Objects.equals(this.priGetExistsTime, other.priGetExistsTime)
            && Objects.equals(this.priGetExistsTotal, other.priGetExistsTotal)
            && Objects.equals(this.priGetMissingTime, other.priGetMissingTime)
            && Objects.equals(this.priGetMissingTotal, other.priGetMissingTotal)
            && Objects.equals(this.priGetTime, other.priGetTime)
            && Objects.equals(this.priGetTotal, other.priGetTotal)
            && Objects.equals(this.priIndexingDeleteCurrent, other.priIndexingDeleteCurrent)
            && Objects.equals(this.priIndexingDeleteTime, other.priIndexingDeleteTime)
            && Objects.equals(this.priIndexingDeleteTotal, other.priIndexingDeleteTotal)
            && Objects.equals(this.priIndexingIndexCurrent, other.priIndexingIndexCurrent)
            && Objects.equals(this.priIndexingIndexFailed, other.priIndexingIndexFailed)
            && Objects.equals(this.priIndexingIndexTime, other.priIndexingIndexTime)
            && Objects.equals(this.priIndexingIndexTotal, other.priIndexingIndexTotal)
            && Objects.equals(this.priMemoryTotal, other.priMemoryTotal)
            && Objects.equals(this.priMergesCurrent, other.priMergesCurrent)
            && Objects.equals(this.priMergesCurrentDocs, other.priMergesCurrentDocs)
            && Objects.equals(this.priMergesCurrentSize, other.priMergesCurrentSize)
            && Objects.equals(this.priMergesTotal, other.priMergesTotal)
            && Objects.equals(this.priMergesTotalDocs, other.priMergesTotalDocs)
            && Objects.equals(this.priMergesTotalSize, other.priMergesTotalSize)
            && Objects.equals(this.priMergesTotalTime, other.priMergesTotalTime)
            && Objects.equals(this.priQueryCacheEvictions, other.priQueryCacheEvictions)
            && Objects.equals(this.priQueryCacheMemorySize, other.priQueryCacheMemorySize)
            && Objects.equals(this.priRefreshExternalTime, other.priRefreshExternalTime)
            && Objects.equals(this.priRefreshExternalTotal, other.priRefreshExternalTotal)
            && Objects.equals(this.priRefreshListeners, other.priRefreshListeners)
            && Objects.equals(this.priRefreshTime, other.priRefreshTime)
            && Objects.equals(this.priRefreshTotal, other.priRefreshTotal)
            && Objects.equals(this.priRequestCacheEvictions, other.priRequestCacheEvictions)
            && Objects.equals(this.priRequestCacheHitCount, other.priRequestCacheHitCount)
            && Objects.equals(this.priRequestCacheMemorySize, other.priRequestCacheMemorySize)
            && Objects.equals(this.priRequestCacheMissCount, other.priRequestCacheMissCount)
            && Objects.equals(this.priSearchConcurrentAvgSliceCount, other.priSearchConcurrentAvgSliceCount)
            && Objects.equals(this.priSearchConcurrentQueryCurrent, other.priSearchConcurrentQueryCurrent)
            && Objects.equals(this.priSearchConcurrentQueryTime, other.priSearchConcurrentQueryTime)
            && Objects.equals(this.priSearchConcurrentQueryTotal, other.priSearchConcurrentQueryTotal)
            && Objects.equals(this.priSearchFetchCurrent, other.priSearchFetchCurrent)
            && Objects.equals(this.priSearchFetchTime, other.priSearchFetchTime)
            && Objects.equals(this.priSearchFetchTotal, other.priSearchFetchTotal)
            && Objects.equals(this.priSearchOpenContexts, other.priSearchOpenContexts)
            && Objects.equals(this.priSearchPointInTimeCurrent, other.priSearchPointInTimeCurrent)
            && Objects.equals(this.priSearchPointInTimeTime, other.priSearchPointInTimeTime)
            && Objects.equals(this.priSearchPointInTimeTotal, other.priSearchPointInTimeTotal)
            && Objects.equals(this.priSearchQueryCurrent, other.priSearchQueryCurrent)
            && Objects.equals(this.priSearchQueryTime, other.priSearchQueryTime)
            && Objects.equals(this.priSearchQueryTotal, other.priSearchQueryTotal)
            && Objects.equals(this.priSearchScrollCurrent, other.priSearchScrollCurrent)
            && Objects.equals(this.priSearchScrollTime, other.priSearchScrollTime)
            && Objects.equals(this.priSearchScrollTotal, other.priSearchScrollTotal)
            && Objects.equals(this.priSegmentsCount, other.priSegmentsCount)
            && Objects.equals(this.priSegmentsFixedBitsetMemory, other.priSegmentsFixedBitsetMemory)
            && Objects.equals(this.priSegmentsIndexWriterMemory, other.priSegmentsIndexWriterMemory)
            && Objects.equals(this.priSegmentsMemory, other.priSegmentsMemory)
            && Objects.equals(this.priSegmentsVersionMapMemory, other.priSegmentsVersionMapMemory)
            && Objects.equals(this.priStoreSize, other.priStoreSize)
            && Objects.equals(this.priSuggestCurrent, other.priSuggestCurrent)
            && Objects.equals(this.priSuggestTime, other.priSuggestTime)
            && Objects.equals(this.priSuggestTotal, other.priSuggestTotal)
            && Objects.equals(this.priWarmerCurrent, other.priWarmerCurrent)
            && Objects.equals(this.priWarmerTotal, other.priWarmerTotal)
            && Objects.equals(this.priWarmerTotalTime, other.priWarmerTotalTime)
            && Objects.equals(this.queryCacheEvictions, other.queryCacheEvictions)
            && Objects.equals(this.queryCacheMemorySize, other.queryCacheMemorySize)
            && Objects.equals(this.refreshExternalTime, other.refreshExternalTime)
            && Objects.equals(this.refreshExternalTotal, other.refreshExternalTotal)
            && Objects.equals(this.refreshListeners, other.refreshListeners)
            && Objects.equals(this.refreshTime, other.refreshTime)
            && Objects.equals(this.refreshTotal, other.refreshTotal)
            && Objects.equals(this.rep, other.rep)
            && Objects.equals(this.requestCacheEvictions, other.requestCacheEvictions)
            && Objects.equals(this.requestCacheHitCount, other.requestCacheHitCount)
            && Objects.equals(this.requestCacheMemorySize, other.requestCacheMemorySize)
            && Objects.equals(this.requestCacheMissCount, other.requestCacheMissCount)
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
            && Objects.equals(this.searchThrottled, other.searchThrottled)
            && Objects.equals(this.segmentsCount, other.segmentsCount)
            && Objects.equals(this.segmentsFixedBitsetMemory, other.segmentsFixedBitsetMemory)
            && Objects.equals(this.segmentsIndexWriterMemory, other.segmentsIndexWriterMemory)
            && Objects.equals(this.segmentsMemory, other.segmentsMemory)
            && Objects.equals(this.segmentsVersionMapMemory, other.segmentsVersionMapMemory)
            && Objects.equals(this.status, other.status)
            && Objects.equals(this.storeSize, other.storeSize)
            && Objects.equals(this.suggestCurrent, other.suggestCurrent)
            && Objects.equals(this.suggestTime, other.suggestTime)
            && Objects.equals(this.suggestTotal, other.suggestTotal)
            && Objects.equals(this.uuid, other.uuid)
            && Objects.equals(this.warmerCurrent, other.warmerCurrent)
            && Objects.equals(this.warmerTotal, other.warmerTotal)
            && Objects.equals(this.warmerTotalTime, other.warmerTotalTime);
    }
}
