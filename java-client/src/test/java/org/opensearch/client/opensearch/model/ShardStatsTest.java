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

package org.opensearch.client.opensearch.model;

import static java.util.Collections.emptyList;

import java.util.HashMap;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.opensearch._types.CompletionStats;
import org.opensearch.client.opensearch._types.DocStats;
import org.opensearch.client.opensearch._types.FielddataStats;
import org.opensearch.client.opensearch._types.FlushStats;
import org.opensearch.client.opensearch._types.GetStats;
import org.opensearch.client.opensearch._types.IndexingStats;
import org.opensearch.client.opensearch._types.MergesStats;
import org.opensearch.client.opensearch._types.QueryCacheStats;
import org.opensearch.client.opensearch._types.RecoveryStats;
import org.opensearch.client.opensearch._types.RefreshStats;
import org.opensearch.client.opensearch._types.RequestCacheStats;
import org.opensearch.client.opensearch._types.SearchStats;
import org.opensearch.client.opensearch._types.SegmentsStats;
import org.opensearch.client.opensearch._types.StoreStats;
import org.opensearch.client.opensearch._types.TranslogStats;
import org.opensearch.client.opensearch._types.WarmerStats;
import org.opensearch.client.opensearch.indices.stats.IndexShardStats;
import org.opensearch.client.opensearch.indices.stats.ShardCommit;
import org.opensearch.client.opensearch.indices.stats.ShardPath;
import org.opensearch.client.opensearch.indices.stats.ShardRetentionLeases;
import org.opensearch.client.opensearch.indices.stats.ShardRouting;
import org.opensearch.client.opensearch.indices.stats.ShardRoutingState;
import org.opensearch.client.opensearch.indices.stats.ShardSequenceNumber;
import org.opensearch.client.util.MissingRequiredPropertyException;

public class ShardStatsTest extends Assert {

    @Test
    public void testShardStatsBulkAndShardsPropertiesNotRequired() {

        IndexShardStats.Builder builder = createShardsStatsBuilderWithRequiredFields();

        try {
            builder.build();
        } catch (MissingRequiredPropertyException e) {
            fail(e.getClass().getSimpleName() + " was thrown: " + e.getMessage());
        }
    }

    private IndexShardStats.Builder createShardsStatsBuilderWithRequiredFields() {
        ShardCommit commit = new ShardCommit.Builder().id("").generation(0).numDocs(0).userData(new HashMap<>()).build();
        CompletionStats completion = new CompletionStats.Builder().sizeInBytes(0).build();
        DocStats docs = new DocStats.Builder().count(0).deleted(0L).build();
        FielddataStats fielddata = new FielddataStats.Builder().memorySizeInBytes(0).build();
        FlushStats flush = new FlushStats.Builder().periodic(0).total(0).totalTimeInMillis(0).build();
        GetStats get = new GetStats.Builder().current(0)
            .existsTimeInMillis(0)
            .existsTotal(0)
            .missingTimeInMillis(0)
            .missingTotal(0)
            .timeInMillis(0)
            .total(0)
            .build();
        IndexingStats indexing = new IndexingStats.Builder().indexCurrent(0)
            .deleteCurrent(0)
            .deleteTimeInMillis(0)
            .deleteTotal(0)
            .isThrottled(false)
            .noopUpdateTotal(0)
            .throttleTimeInMillis(0)
            .indexTimeInMillis(0)
            .indexTotal(0)
            .indexFailed(0)
            .build();
        MergesStats merges = new MergesStats.Builder().current(0)
            .currentDocs(0)
            .currentSizeInBytes(0)
            .total(0)
            .totalAutoThrottleInBytes(0)
            .totalDocs(0)
            .totalSizeInBytes(0)
            .totalStoppedTimeInMillis(0)
            .totalThrottledTimeInMillis(0)
            .totalTimeInMillis(0)
            .build();
        ShardPath shardPath = new ShardPath.Builder().dataPath("").isCustomDataPath(false).statePath("").build();
        QueryCacheStats queryCache = new QueryCacheStats.Builder().cacheCount(0)
            .cacheSize(0)
            .evictions(0)
            .hitCount(0)
            .memorySizeInBytes(0)
            .missCount(0)
            .totalCount(0)
            .build();
        RecoveryStats recovery = new RecoveryStats.Builder().currentAsSource(0).currentAsTarget(0).throttleTimeInMillis(0).build();
        RefreshStats refresh = new RefreshStats.Builder().externalTotal(0)
            .externalTotalTimeInMillis(0)
            .listeners(0)
            .total(0)
            .totalTimeInMillis(0)
            .build();
        RequestCacheStats requestCache = new RequestCacheStats.Builder().evictions(0).hitCount(0).memorySizeInBytes(0).missCount(0).build();
        ShardRetentionLeases retentionLeases = new ShardRetentionLeases.Builder().primaryTerm(0).version(0).leases(emptyList()).build();
        ShardRouting routing = new ShardRouting.Builder().node("").primary(false).state(ShardRoutingState.Unassigned).build();
        SearchStats search = new SearchStats.Builder().fetchCurrent(0)
            .fetchTimeInMillis(0)
            .fetchTotal(0)
            .queryCurrent(0)
            .queryTimeInMillis(0)
            .queryTotal(0)
            .scrollCurrent(0)
            .scrollTimeInMillis(0)
            .scrollTotal(0)
            .suggestCurrent(0)
            .suggestTimeInMillis(0)
            .suggestTotal(0)
            .build();
        SegmentsStats segments = new SegmentsStats.Builder().count(0)
            .docValuesMemoryInBytes(0)
            .fileSizes(new HashMap<>())
            .fixedBitSetMemoryInBytes(0)
            .indexWriterMemoryInBytes(0)
            .maxUnsafeAutoIdTimestamp(0)
            .memoryInBytes(0)
            .normsMemoryInBytes(0)
            .pointsMemoryInBytes(0)
            .storedFieldsMemoryInBytes(0)
            .termsMemoryInBytes(0)
            .termVectorsMemoryInBytes(0)
            .versionMapMemoryInBytes(0)
            .build();
        ShardSequenceNumber seqNo = new ShardSequenceNumber.Builder().globalCheckpoint(0).localCheckpoint(0).maxSeqNo(0).build();
        StoreStats store = new StoreStats.Builder().sizeInBytes(0).reservedInBytes(0).build();
        TranslogStats translog = new TranslogStats.Builder().earliestLastModifiedAge(0)
            .operations(0)
            .sizeInBytes(0)
            .uncommittedOperations(0)
            .uncommittedSizeInBytes(0)
            .build();
        WarmerStats warmer = new WarmerStats.Builder().current(0).total(0).totalTimeInMillis(0).build();

        IndexShardStats.Builder builder = new IndexShardStats.Builder();

        builder.commit(commit)
            .completion(completion)
            .docs(docs)
            .fielddata(fielddata)
            .flush(flush)
            .get(get)
            .indexing(indexing)
            .merges(merges)
            .shardPath(shardPath)
            .queryCache(queryCache)
            .recovery(recovery)
            .refresh(refresh)
            .requestCache(requestCache)
            .retentionLeases(retentionLeases)
            .routing(routing)
            .search(search)
            .segments(segments)
            .seqNo(seqNo)
            .store(store)
            .translog(translog)
            .warmer(warmer);

        return builder;
    }
}
