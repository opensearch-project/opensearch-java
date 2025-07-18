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

package org.opensearch.client.opensearch.knn;

import javax.annotation.Generated;
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;

// typedef: knn.KnnStatName

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum KnnStatName implements JsonEnum {
    CacheCapacityReached("cache_capacity_reached"),

    CircuitBreakerTriggered("circuit_breaker_triggered"),

    EvictionCount("eviction_count"),

    FaissInitialized("faiss_initialized"),

    GraphIndexErrors("graph_index_errors"),

    GraphIndexRequests("graph_index_requests"),

    GraphMemoryUsage("graph_memory_usage"),

    GraphMemoryUsagePercentage("graph_memory_usage_percentage"),

    GraphQueryErrors("graph_query_errors"),

    GraphQueryRequests("graph_query_requests"),

    GraphStats("graph_stats"),

    HitCount("hit_count"),

    IndexingFromModelDegraded("indexing_from_model_degraded"),

    IndicesInCache("indices_in_cache"),

    KnnQueryRequests("knn_query_requests"),

    KnnQueryWithFilterRequests("knn_query_with_filter_requests"),

    LoadExceptionCount("load_exception_count"),

    LoadSuccessCount("load_success_count"),

    LuceneInitialized("lucene_initialized"),

    MaxDistanceQueryRequests("max_distance_query_requests"),

    MaxDistanceQueryWithFilterRequests("max_distance_query_with_filter_requests"),

    MinScoreQueryRequests("min_score_query_requests"),

    MinScoreQueryWithFilterRequests("min_score_query_with_filter_requests"),

    MissCount("miss_count"),

    ModelIndexStatus("model_index_status"),

    NmslibInitialized("nmslib_initialized"),

    ScriptCompilationErrors("script_compilation_errors"),

    ScriptCompilations("script_compilations"),

    ScriptQueryErrors("script_query_errors"),

    ScriptQueryRequests("script_query_requests"),

    TotalLoadTime("total_load_time"),

    TrainingErrors("training_errors"),

    TrainingMemoryUsage("training_memory_usage"),

    TrainingMemoryUsagePercentage("training_memory_usage_percentage"),

    TrainingRequests("training_requests");

    private final String jsonValue;

    KnnStatName(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<KnnStatName> _DESERIALIZER = new JsonEnum.Deserializer<>(KnnStatName.values());
}
