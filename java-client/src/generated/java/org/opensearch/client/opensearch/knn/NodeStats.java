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

// typedef: knn.NodeStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeStats implements PlainJsonSerializable, ToCopyableBuilder<NodeStats.Builder, NodeStats> {

    @Nullable
    private final Boolean cacheCapacityReached;

    @Nullable
    private final Long evictionCount;

    @Nullable
    private final Boolean faissInitialized;

    @Nullable
    private final Long graphIndexErrors;

    @Nullable
    private final Long graphIndexRequests;

    @Nullable
    private final Long graphMemoryUsage;

    @Nullable
    private final Double graphMemoryUsagePercentage;

    @Nullable
    private final Long graphQueryErrors;

    @Nullable
    private final Long graphQueryRequests;

    @Nullable
    private final GraphStats graphStats;

    @Nullable
    private final Long hitCount;

    @Nullable
    private final Boolean indexingFromModelDegraded;

    @Nonnull
    private final Map<String, JsonData> indicesInCache;

    @Nullable
    private final Long knnQueryRequests;

    @Nullable
    private final Long knnQueryWithFilterRequests;

    @Nullable
    private final Long loadExceptionCount;

    @Nullable
    private final Long loadSuccessCount;

    @Nullable
    private final Boolean luceneInitialized;

    @Nullable
    private final Long maxDistanceQueryRequests;

    @Nullable
    private final Long maxDistanceQueryWithFilterRequests;

    @Nullable
    private final Long minScoreQueryRequests;

    @Nullable
    private final Long minScoreQueryWithFilterRequests;

    @Nullable
    private final Long missCount;

    @Nullable
    private final Boolean nmslibInitialized;

    @Nullable
    private final RemoteVectorIndexBuildStats remoteVectorIndexBuildStats;

    @Nullable
    private final Long scriptCompilationErrors;

    @Nullable
    private final Long scriptCompilations;

    @Nullable
    private final Long scriptQueryErrors;

    @Nullable
    private final Long scriptQueryRequests;

    @Nullable
    private final Long totalLoadTime;

    @Nullable
    private final Long trainingErrors;

    @Nullable
    private final Long trainingMemoryUsage;

    @Nullable
    private final Double trainingMemoryUsagePercentage;

    @Nullable
    private final Long trainingRequests;

    // ---------------------------------------------------------------------------------------------

    private NodeStats(Builder builder) {
        this.cacheCapacityReached = builder.cacheCapacityReached;
        this.evictionCount = builder.evictionCount;
        this.faissInitialized = builder.faissInitialized;
        this.graphIndexErrors = builder.graphIndexErrors;
        this.graphIndexRequests = builder.graphIndexRequests;
        this.graphMemoryUsage = builder.graphMemoryUsage;
        this.graphMemoryUsagePercentage = builder.graphMemoryUsagePercentage;
        this.graphQueryErrors = builder.graphQueryErrors;
        this.graphQueryRequests = builder.graphQueryRequests;
        this.graphStats = builder.graphStats;
        this.hitCount = builder.hitCount;
        this.indexingFromModelDegraded = builder.indexingFromModelDegraded;
        this.indicesInCache = ApiTypeHelper.unmodifiable(builder.indicesInCache);
        this.knnQueryRequests = builder.knnQueryRequests;
        this.knnQueryWithFilterRequests = builder.knnQueryWithFilterRequests;
        this.loadExceptionCount = builder.loadExceptionCount;
        this.loadSuccessCount = builder.loadSuccessCount;
        this.luceneInitialized = builder.luceneInitialized;
        this.maxDistanceQueryRequests = builder.maxDistanceQueryRequests;
        this.maxDistanceQueryWithFilterRequests = builder.maxDistanceQueryWithFilterRequests;
        this.minScoreQueryRequests = builder.minScoreQueryRequests;
        this.minScoreQueryWithFilterRequests = builder.minScoreQueryWithFilterRequests;
        this.missCount = builder.missCount;
        this.nmslibInitialized = builder.nmslibInitialized;
        this.remoteVectorIndexBuildStats = builder.remoteVectorIndexBuildStats;
        this.scriptCompilationErrors = builder.scriptCompilationErrors;
        this.scriptCompilations = builder.scriptCompilations;
        this.scriptQueryErrors = builder.scriptQueryErrors;
        this.scriptQueryRequests = builder.scriptQueryRequests;
        this.totalLoadTime = builder.totalLoadTime;
        this.trainingErrors = builder.trainingErrors;
        this.trainingMemoryUsage = builder.trainingMemoryUsage;
        this.trainingMemoryUsagePercentage = builder.trainingMemoryUsagePercentage;
        this.trainingRequests = builder.trainingRequests;
    }

    public static NodeStats of(Function<NodeStats.Builder, ObjectBuilder<NodeStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code cache_capacity_reached}
     */
    @Nullable
    public final Boolean cacheCapacityReached() {
        return this.cacheCapacityReached;
    }

    /**
     * API name: {@code eviction_count}
     */
    @Nullable
    public final Long evictionCount() {
        return this.evictionCount;
    }

    /**
     * API name: {@code faiss_initialized}
     */
    @Nullable
    public final Boolean faissInitialized() {
        return this.faissInitialized;
    }

    /**
     * API name: {@code graph_index_errors}
     */
    @Nullable
    public final Long graphIndexErrors() {
        return this.graphIndexErrors;
    }

    /**
     * API name: {@code graph_index_requests}
     */
    @Nullable
    public final Long graphIndexRequests() {
        return this.graphIndexRequests;
    }

    /**
     * API name: {@code graph_memory_usage}
     */
    @Nullable
    public final Long graphMemoryUsage() {
        return this.graphMemoryUsage;
    }

    /**
     * API name: {@code graph_memory_usage_percentage}
     */
    @Nullable
    public final Double graphMemoryUsagePercentage() {
        return this.graphMemoryUsagePercentage;
    }

    /**
     * API name: {@code graph_query_errors}
     */
    @Nullable
    public final Long graphQueryErrors() {
        return this.graphQueryErrors;
    }

    /**
     * API name: {@code graph_query_requests}
     */
    @Nullable
    public final Long graphQueryRequests() {
        return this.graphQueryRequests;
    }

    /**
     * API name: {@code graph_stats}
     */
    @Nullable
    public final GraphStats graphStats() {
        return this.graphStats;
    }

    /**
     * API name: {@code hit_count}
     */
    @Nullable
    public final Long hitCount() {
        return this.hitCount;
    }

    /**
     * API name: {@code indexing_from_model_degraded}
     */
    @Nullable
    public final Boolean indexingFromModelDegraded() {
        return this.indexingFromModelDegraded;
    }

    /**
     * API name: {@code indices_in_cache}
     */
    @Nonnull
    public final Map<String, JsonData> indicesInCache() {
        return this.indicesInCache;
    }

    /**
     * API name: {@code knn_query_requests}
     */
    @Nullable
    public final Long knnQueryRequests() {
        return this.knnQueryRequests;
    }

    /**
     * API name: {@code knn_query_with_filter_requests}
     */
    @Nullable
    public final Long knnQueryWithFilterRequests() {
        return this.knnQueryWithFilterRequests;
    }

    /**
     * API name: {@code load_exception_count}
     */
    @Nullable
    public final Long loadExceptionCount() {
        return this.loadExceptionCount;
    }

    /**
     * API name: {@code load_success_count}
     */
    @Nullable
    public final Long loadSuccessCount() {
        return this.loadSuccessCount;
    }

    /**
     * API name: {@code lucene_initialized}
     */
    @Nullable
    public final Boolean luceneInitialized() {
        return this.luceneInitialized;
    }

    /**
     * API name: {@code max_distance_query_requests}
     */
    @Nullable
    public final Long maxDistanceQueryRequests() {
        return this.maxDistanceQueryRequests;
    }

    /**
     * API name: {@code max_distance_query_with_filter_requests}
     */
    @Nullable
    public final Long maxDistanceQueryWithFilterRequests() {
        return this.maxDistanceQueryWithFilterRequests;
    }

    /**
     * API name: {@code min_score_query_requests}
     */
    @Nullable
    public final Long minScoreQueryRequests() {
        return this.minScoreQueryRequests;
    }

    /**
     * API name: {@code min_score_query_with_filter_requests}
     */
    @Nullable
    public final Long minScoreQueryWithFilterRequests() {
        return this.minScoreQueryWithFilterRequests;
    }

    /**
     * API name: {@code miss_count}
     */
    @Nullable
    public final Long missCount() {
        return this.missCount;
    }

    /**
     * API name: {@code nmslib_initialized}
     */
    @Nullable
    public final Boolean nmslibInitialized() {
        return this.nmslibInitialized;
    }

    /**
     * API name: {@code remote_vector_index_build_stats}
     */
    @Nullable
    public final RemoteVectorIndexBuildStats remoteVectorIndexBuildStats() {
        return this.remoteVectorIndexBuildStats;
    }

    /**
     * API name: {@code script_compilation_errors}
     */
    @Nullable
    public final Long scriptCompilationErrors() {
        return this.scriptCompilationErrors;
    }

    /**
     * API name: {@code script_compilations}
     */
    @Nullable
    public final Long scriptCompilations() {
        return this.scriptCompilations;
    }

    /**
     * API name: {@code script_query_errors}
     */
    @Nullable
    public final Long scriptQueryErrors() {
        return this.scriptQueryErrors;
    }

    /**
     * API name: {@code script_query_requests}
     */
    @Nullable
    public final Long scriptQueryRequests() {
        return this.scriptQueryRequests;
    }

    /**
     * API name: {@code total_load_time}
     */
    @Nullable
    public final Long totalLoadTime() {
        return this.totalLoadTime;
    }

    /**
     * API name: {@code training_errors}
     */
    @Nullable
    public final Long trainingErrors() {
        return this.trainingErrors;
    }

    /**
     * API name: {@code training_memory_usage}
     */
    @Nullable
    public final Long trainingMemoryUsage() {
        return this.trainingMemoryUsage;
    }

    /**
     * API name: {@code training_memory_usage_percentage}
     */
    @Nullable
    public final Double trainingMemoryUsagePercentage() {
        return this.trainingMemoryUsagePercentage;
    }

    /**
     * API name: {@code training_requests}
     */
    @Nullable
    public final Long trainingRequests() {
        return this.trainingRequests;
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
        if (this.cacheCapacityReached != null) {
            generator.writeKey("cache_capacity_reached");
            generator.write(this.cacheCapacityReached);
        }

        if (this.evictionCount != null) {
            generator.writeKey("eviction_count");
            generator.write(this.evictionCount);
        }

        if (this.faissInitialized != null) {
            generator.writeKey("faiss_initialized");
            generator.write(this.faissInitialized);
        }

        if (this.graphIndexErrors != null) {
            generator.writeKey("graph_index_errors");
            generator.write(this.graphIndexErrors);
        }

        if (this.graphIndexRequests != null) {
            generator.writeKey("graph_index_requests");
            generator.write(this.graphIndexRequests);
        }

        if (this.graphMemoryUsage != null) {
            generator.writeKey("graph_memory_usage");
            generator.write(this.graphMemoryUsage);
        }

        if (this.graphMemoryUsagePercentage != null) {
            generator.writeKey("graph_memory_usage_percentage");
            generator.write(this.graphMemoryUsagePercentage);
        }

        if (this.graphQueryErrors != null) {
            generator.writeKey("graph_query_errors");
            generator.write(this.graphQueryErrors);
        }

        if (this.graphQueryRequests != null) {
            generator.writeKey("graph_query_requests");
            generator.write(this.graphQueryRequests);
        }

        if (this.graphStats != null) {
            generator.writeKey("graph_stats");
            this.graphStats.serialize(generator, mapper);
        }

        if (this.hitCount != null) {
            generator.writeKey("hit_count");
            generator.write(this.hitCount);
        }

        if (this.indexingFromModelDegraded != null) {
            generator.writeKey("indexing_from_model_degraded");
            generator.write(this.indexingFromModelDegraded);
        }

        if (ApiTypeHelper.isDefined(this.indicesInCache)) {
            generator.writeKey("indices_in_cache");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.indicesInCache.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.knnQueryRequests != null) {
            generator.writeKey("knn_query_requests");
            generator.write(this.knnQueryRequests);
        }

        if (this.knnQueryWithFilterRequests != null) {
            generator.writeKey("knn_query_with_filter_requests");
            generator.write(this.knnQueryWithFilterRequests);
        }

        if (this.loadExceptionCount != null) {
            generator.writeKey("load_exception_count");
            generator.write(this.loadExceptionCount);
        }

        if (this.loadSuccessCount != null) {
            generator.writeKey("load_success_count");
            generator.write(this.loadSuccessCount);
        }

        if (this.luceneInitialized != null) {
            generator.writeKey("lucene_initialized");
            generator.write(this.luceneInitialized);
        }

        if (this.maxDistanceQueryRequests != null) {
            generator.writeKey("max_distance_query_requests");
            generator.write(this.maxDistanceQueryRequests);
        }

        if (this.maxDistanceQueryWithFilterRequests != null) {
            generator.writeKey("max_distance_query_with_filter_requests");
            generator.write(this.maxDistanceQueryWithFilterRequests);
        }

        if (this.minScoreQueryRequests != null) {
            generator.writeKey("min_score_query_requests");
            generator.write(this.minScoreQueryRequests);
        }

        if (this.minScoreQueryWithFilterRequests != null) {
            generator.writeKey("min_score_query_with_filter_requests");
            generator.write(this.minScoreQueryWithFilterRequests);
        }

        if (this.missCount != null) {
            generator.writeKey("miss_count");
            generator.write(this.missCount);
        }

        if (this.nmslibInitialized != null) {
            generator.writeKey("nmslib_initialized");
            generator.write(this.nmslibInitialized);
        }

        if (this.remoteVectorIndexBuildStats != null) {
            generator.writeKey("remote_vector_index_build_stats");
            this.remoteVectorIndexBuildStats.serialize(generator, mapper);
        }

        if (this.scriptCompilationErrors != null) {
            generator.writeKey("script_compilation_errors");
            generator.write(this.scriptCompilationErrors);
        }

        if (this.scriptCompilations != null) {
            generator.writeKey("script_compilations");
            generator.write(this.scriptCompilations);
        }

        if (this.scriptQueryErrors != null) {
            generator.writeKey("script_query_errors");
            generator.write(this.scriptQueryErrors);
        }

        if (this.scriptQueryRequests != null) {
            generator.writeKey("script_query_requests");
            generator.write(this.scriptQueryRequests);
        }

        if (this.totalLoadTime != null) {
            generator.writeKey("total_load_time");
            generator.write(this.totalLoadTime);
        }

        if (this.trainingErrors != null) {
            generator.writeKey("training_errors");
            generator.write(this.trainingErrors);
        }

        if (this.trainingMemoryUsage != null) {
            generator.writeKey("training_memory_usage");
            generator.write(this.trainingMemoryUsage);
        }

        if (this.trainingMemoryUsagePercentage != null) {
            generator.writeKey("training_memory_usage_percentage");
            generator.write(this.trainingMemoryUsagePercentage);
        }

        if (this.trainingRequests != null) {
            generator.writeKey("training_requests");
            generator.write(this.trainingRequests);
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
     * Builder for {@link NodeStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeStats> {
        @Nullable
        private Boolean cacheCapacityReached;
        @Nullable
        private Long evictionCount;
        @Nullable
        private Boolean faissInitialized;
        @Nullable
        private Long graphIndexErrors;
        @Nullable
        private Long graphIndexRequests;
        @Nullable
        private Long graphMemoryUsage;
        @Nullable
        private Double graphMemoryUsagePercentage;
        @Nullable
        private Long graphQueryErrors;
        @Nullable
        private Long graphQueryRequests;
        @Nullable
        private GraphStats graphStats;
        @Nullable
        private Long hitCount;
        @Nullable
        private Boolean indexingFromModelDegraded;
        @Nullable
        private Map<String, JsonData> indicesInCache;
        @Nullable
        private Long knnQueryRequests;
        @Nullable
        private Long knnQueryWithFilterRequests;
        @Nullable
        private Long loadExceptionCount;
        @Nullable
        private Long loadSuccessCount;
        @Nullable
        private Boolean luceneInitialized;
        @Nullable
        private Long maxDistanceQueryRequests;
        @Nullable
        private Long maxDistanceQueryWithFilterRequests;
        @Nullable
        private Long minScoreQueryRequests;
        @Nullable
        private Long minScoreQueryWithFilterRequests;
        @Nullable
        private Long missCount;
        @Nullable
        private Boolean nmslibInitialized;
        @Nullable
        private RemoteVectorIndexBuildStats remoteVectorIndexBuildStats;
        @Nullable
        private Long scriptCompilationErrors;
        @Nullable
        private Long scriptCompilations;
        @Nullable
        private Long scriptQueryErrors;
        @Nullable
        private Long scriptQueryRequests;
        @Nullable
        private Long totalLoadTime;
        @Nullable
        private Long trainingErrors;
        @Nullable
        private Long trainingMemoryUsage;
        @Nullable
        private Double trainingMemoryUsagePercentage;
        @Nullable
        private Long trainingRequests;

        public Builder() {}

        private Builder(NodeStats o) {
            this.cacheCapacityReached = o.cacheCapacityReached;
            this.evictionCount = o.evictionCount;
            this.faissInitialized = o.faissInitialized;
            this.graphIndexErrors = o.graphIndexErrors;
            this.graphIndexRequests = o.graphIndexRequests;
            this.graphMemoryUsage = o.graphMemoryUsage;
            this.graphMemoryUsagePercentage = o.graphMemoryUsagePercentage;
            this.graphQueryErrors = o.graphQueryErrors;
            this.graphQueryRequests = o.graphQueryRequests;
            this.graphStats = o.graphStats;
            this.hitCount = o.hitCount;
            this.indexingFromModelDegraded = o.indexingFromModelDegraded;
            this.indicesInCache = _mapCopy(o.indicesInCache);
            this.knnQueryRequests = o.knnQueryRequests;
            this.knnQueryWithFilterRequests = o.knnQueryWithFilterRequests;
            this.loadExceptionCount = o.loadExceptionCount;
            this.loadSuccessCount = o.loadSuccessCount;
            this.luceneInitialized = o.luceneInitialized;
            this.maxDistanceQueryRequests = o.maxDistanceQueryRequests;
            this.maxDistanceQueryWithFilterRequests = o.maxDistanceQueryWithFilterRequests;
            this.minScoreQueryRequests = o.minScoreQueryRequests;
            this.minScoreQueryWithFilterRequests = o.minScoreQueryWithFilterRequests;
            this.missCount = o.missCount;
            this.nmslibInitialized = o.nmslibInitialized;
            this.remoteVectorIndexBuildStats = o.remoteVectorIndexBuildStats;
            this.scriptCompilationErrors = o.scriptCompilationErrors;
            this.scriptCompilations = o.scriptCompilations;
            this.scriptQueryErrors = o.scriptQueryErrors;
            this.scriptQueryRequests = o.scriptQueryRequests;
            this.totalLoadTime = o.totalLoadTime;
            this.trainingErrors = o.trainingErrors;
            this.trainingMemoryUsage = o.trainingMemoryUsage;
            this.trainingMemoryUsagePercentage = o.trainingMemoryUsagePercentage;
            this.trainingRequests = o.trainingRequests;
        }

        private Builder(Builder o) {
            this.cacheCapacityReached = o.cacheCapacityReached;
            this.evictionCount = o.evictionCount;
            this.faissInitialized = o.faissInitialized;
            this.graphIndexErrors = o.graphIndexErrors;
            this.graphIndexRequests = o.graphIndexRequests;
            this.graphMemoryUsage = o.graphMemoryUsage;
            this.graphMemoryUsagePercentage = o.graphMemoryUsagePercentage;
            this.graphQueryErrors = o.graphQueryErrors;
            this.graphQueryRequests = o.graphQueryRequests;
            this.graphStats = o.graphStats;
            this.hitCount = o.hitCount;
            this.indexingFromModelDegraded = o.indexingFromModelDegraded;
            this.indicesInCache = _mapCopy(o.indicesInCache);
            this.knnQueryRequests = o.knnQueryRequests;
            this.knnQueryWithFilterRequests = o.knnQueryWithFilterRequests;
            this.loadExceptionCount = o.loadExceptionCount;
            this.loadSuccessCount = o.loadSuccessCount;
            this.luceneInitialized = o.luceneInitialized;
            this.maxDistanceQueryRequests = o.maxDistanceQueryRequests;
            this.maxDistanceQueryWithFilterRequests = o.maxDistanceQueryWithFilterRequests;
            this.minScoreQueryRequests = o.minScoreQueryRequests;
            this.minScoreQueryWithFilterRequests = o.minScoreQueryWithFilterRequests;
            this.missCount = o.missCount;
            this.nmslibInitialized = o.nmslibInitialized;
            this.remoteVectorIndexBuildStats = o.remoteVectorIndexBuildStats;
            this.scriptCompilationErrors = o.scriptCompilationErrors;
            this.scriptCompilations = o.scriptCompilations;
            this.scriptQueryErrors = o.scriptQueryErrors;
            this.scriptQueryRequests = o.scriptQueryRequests;
            this.totalLoadTime = o.totalLoadTime;
            this.trainingErrors = o.trainingErrors;
            this.trainingMemoryUsage = o.trainingMemoryUsage;
            this.trainingMemoryUsagePercentage = o.trainingMemoryUsagePercentage;
            this.trainingRequests = o.trainingRequests;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code cache_capacity_reached}
         */
        @Nonnull
        public final Builder cacheCapacityReached(@Nullable Boolean value) {
            this.cacheCapacityReached = value;
            return this;
        }

        /**
         * API name: {@code eviction_count}
         */
        @Nonnull
        public final Builder evictionCount(@Nullable Long value) {
            this.evictionCount = value;
            return this;
        }

        /**
         * API name: {@code faiss_initialized}
         */
        @Nonnull
        public final Builder faissInitialized(@Nullable Boolean value) {
            this.faissInitialized = value;
            return this;
        }

        /**
         * API name: {@code graph_index_errors}
         */
        @Nonnull
        public final Builder graphIndexErrors(@Nullable Long value) {
            this.graphIndexErrors = value;
            return this;
        }

        /**
         * API name: {@code graph_index_requests}
         */
        @Nonnull
        public final Builder graphIndexRequests(@Nullable Long value) {
            this.graphIndexRequests = value;
            return this;
        }

        /**
         * API name: {@code graph_memory_usage}
         */
        @Nonnull
        public final Builder graphMemoryUsage(@Nullable Long value) {
            this.graphMemoryUsage = value;
            return this;
        }

        /**
         * API name: {@code graph_memory_usage_percentage}
         */
        @Nonnull
        public final Builder graphMemoryUsagePercentage(@Nullable Double value) {
            this.graphMemoryUsagePercentage = value;
            return this;
        }

        /**
         * API name: {@code graph_query_errors}
         */
        @Nonnull
        public final Builder graphQueryErrors(@Nullable Long value) {
            this.graphQueryErrors = value;
            return this;
        }

        /**
         * API name: {@code graph_query_requests}
         */
        @Nonnull
        public final Builder graphQueryRequests(@Nullable Long value) {
            this.graphQueryRequests = value;
            return this;
        }

        /**
         * API name: {@code graph_stats}
         */
        @Nonnull
        public final Builder graphStats(@Nullable GraphStats value) {
            this.graphStats = value;
            return this;
        }

        /**
         * API name: {@code graph_stats}
         */
        @Nonnull
        public final Builder graphStats(Function<GraphStats.Builder, ObjectBuilder<GraphStats>> fn) {
            return graphStats(fn.apply(new GraphStats.Builder()).build());
        }

        /**
         * API name: {@code hit_count}
         */
        @Nonnull
        public final Builder hitCount(@Nullable Long value) {
            this.hitCount = value;
            return this;
        }

        /**
         * API name: {@code indexing_from_model_degraded}
         */
        @Nonnull
        public final Builder indexingFromModelDegraded(@Nullable Boolean value) {
            this.indexingFromModelDegraded = value;
            return this;
        }

        /**
         * API name: {@code indices_in_cache}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>indicesInCache</code>.
         * </p>
         */
        @Nonnull
        public final Builder indicesInCache(Map<String, JsonData> map) {
            this.indicesInCache = _mapPutAll(this.indicesInCache, map);
            return this;
        }

        /**
         * API name: {@code indices_in_cache}
         *
         * <p>
         * Adds an entry to <code>indicesInCache</code>.
         * </p>
         */
        @Nonnull
        public final Builder indicesInCache(String key, JsonData value) {
            this.indicesInCache = _mapPut(this.indicesInCache, key, value);
            return this;
        }

        /**
         * API name: {@code knn_query_requests}
         */
        @Nonnull
        public final Builder knnQueryRequests(@Nullable Long value) {
            this.knnQueryRequests = value;
            return this;
        }

        /**
         * API name: {@code knn_query_with_filter_requests}
         */
        @Nonnull
        public final Builder knnQueryWithFilterRequests(@Nullable Long value) {
            this.knnQueryWithFilterRequests = value;
            return this;
        }

        /**
         * API name: {@code load_exception_count}
         */
        @Nonnull
        public final Builder loadExceptionCount(@Nullable Long value) {
            this.loadExceptionCount = value;
            return this;
        }

        /**
         * API name: {@code load_success_count}
         */
        @Nonnull
        public final Builder loadSuccessCount(@Nullable Long value) {
            this.loadSuccessCount = value;
            return this;
        }

        /**
         * API name: {@code lucene_initialized}
         */
        @Nonnull
        public final Builder luceneInitialized(@Nullable Boolean value) {
            this.luceneInitialized = value;
            return this;
        }

        /**
         * API name: {@code max_distance_query_requests}
         */
        @Nonnull
        public final Builder maxDistanceQueryRequests(@Nullable Long value) {
            this.maxDistanceQueryRequests = value;
            return this;
        }

        /**
         * API name: {@code max_distance_query_with_filter_requests}
         */
        @Nonnull
        public final Builder maxDistanceQueryWithFilterRequests(@Nullable Long value) {
            this.maxDistanceQueryWithFilterRequests = value;
            return this;
        }

        /**
         * API name: {@code min_score_query_requests}
         */
        @Nonnull
        public final Builder minScoreQueryRequests(@Nullable Long value) {
            this.minScoreQueryRequests = value;
            return this;
        }

        /**
         * API name: {@code min_score_query_with_filter_requests}
         */
        @Nonnull
        public final Builder minScoreQueryWithFilterRequests(@Nullable Long value) {
            this.minScoreQueryWithFilterRequests = value;
            return this;
        }

        /**
         * API name: {@code miss_count}
         */
        @Nonnull
        public final Builder missCount(@Nullable Long value) {
            this.missCount = value;
            return this;
        }

        /**
         * API name: {@code nmslib_initialized}
         */
        @Nonnull
        public final Builder nmslibInitialized(@Nullable Boolean value) {
            this.nmslibInitialized = value;
            return this;
        }

        /**
         * API name: {@code remote_vector_index_build_stats}
         */
        @Nonnull
        public final Builder remoteVectorIndexBuildStats(@Nullable RemoteVectorIndexBuildStats value) {
            this.remoteVectorIndexBuildStats = value;
            return this;
        }

        /**
         * API name: {@code remote_vector_index_build_stats}
         */
        @Nonnull
        public final Builder remoteVectorIndexBuildStats(
            Function<RemoteVectorIndexBuildStats.Builder, ObjectBuilder<RemoteVectorIndexBuildStats>> fn
        ) {
            return remoteVectorIndexBuildStats(fn.apply(new RemoteVectorIndexBuildStats.Builder()).build());
        }

        /**
         * API name: {@code script_compilation_errors}
         */
        @Nonnull
        public final Builder scriptCompilationErrors(@Nullable Long value) {
            this.scriptCompilationErrors = value;
            return this;
        }

        /**
         * API name: {@code script_compilations}
         */
        @Nonnull
        public final Builder scriptCompilations(@Nullable Long value) {
            this.scriptCompilations = value;
            return this;
        }

        /**
         * API name: {@code script_query_errors}
         */
        @Nonnull
        public final Builder scriptQueryErrors(@Nullable Long value) {
            this.scriptQueryErrors = value;
            return this;
        }

        /**
         * API name: {@code script_query_requests}
         */
        @Nonnull
        public final Builder scriptQueryRequests(@Nullable Long value) {
            this.scriptQueryRequests = value;
            return this;
        }

        /**
         * API name: {@code total_load_time}
         */
        @Nonnull
        public final Builder totalLoadTime(@Nullable Long value) {
            this.totalLoadTime = value;
            return this;
        }

        /**
         * API name: {@code training_errors}
         */
        @Nonnull
        public final Builder trainingErrors(@Nullable Long value) {
            this.trainingErrors = value;
            return this;
        }

        /**
         * API name: {@code training_memory_usage}
         */
        @Nonnull
        public final Builder trainingMemoryUsage(@Nullable Long value) {
            this.trainingMemoryUsage = value;
            return this;
        }

        /**
         * API name: {@code training_memory_usage_percentage}
         */
        @Nonnull
        public final Builder trainingMemoryUsagePercentage(@Nullable Double value) {
            this.trainingMemoryUsagePercentage = value;
            return this;
        }

        /**
         * API name: {@code training_requests}
         */
        @Nonnull
        public final Builder trainingRequests(@Nullable Long value) {
            this.trainingRequests = value;
            return this;
        }

        /**
         * Builds a {@link NodeStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeStats build() {
            _checkSingleUse();

            return new NodeStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeStats}
     */
    public static final JsonpDeserializer<NodeStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeStats::setupNodeStatsDeserializer
    );

    protected static void setupNodeStatsDeserializer(ObjectDeserializer<NodeStats.Builder> op) {
        op.add(Builder::cacheCapacityReached, JsonpDeserializer.booleanDeserializer(), "cache_capacity_reached");
        op.add(Builder::evictionCount, JsonpDeserializer.longDeserializer(), "eviction_count");
        op.add(Builder::faissInitialized, JsonpDeserializer.booleanDeserializer(), "faiss_initialized");
        op.add(Builder::graphIndexErrors, JsonpDeserializer.longDeserializer(), "graph_index_errors");
        op.add(Builder::graphIndexRequests, JsonpDeserializer.longDeserializer(), "graph_index_requests");
        op.add(Builder::graphMemoryUsage, JsonpDeserializer.longDeserializer(), "graph_memory_usage");
        op.add(Builder::graphMemoryUsagePercentage, JsonpDeserializer.doubleDeserializer(), "graph_memory_usage_percentage");
        op.add(Builder::graphQueryErrors, JsonpDeserializer.longDeserializer(), "graph_query_errors");
        op.add(Builder::graphQueryRequests, JsonpDeserializer.longDeserializer(), "graph_query_requests");
        op.add(Builder::graphStats, GraphStats._DESERIALIZER, "graph_stats");
        op.add(Builder::hitCount, JsonpDeserializer.longDeserializer(), "hit_count");
        op.add(Builder::indexingFromModelDegraded, JsonpDeserializer.booleanDeserializer(), "indexing_from_model_degraded");
        op.add(Builder::indicesInCache, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "indices_in_cache");
        op.add(Builder::knnQueryRequests, JsonpDeserializer.longDeserializer(), "knn_query_requests");
        op.add(Builder::knnQueryWithFilterRequests, JsonpDeserializer.longDeserializer(), "knn_query_with_filter_requests");
        op.add(Builder::loadExceptionCount, JsonpDeserializer.longDeserializer(), "load_exception_count");
        op.add(Builder::loadSuccessCount, JsonpDeserializer.longDeserializer(), "load_success_count");
        op.add(Builder::luceneInitialized, JsonpDeserializer.booleanDeserializer(), "lucene_initialized");
        op.add(Builder::maxDistanceQueryRequests, JsonpDeserializer.longDeserializer(), "max_distance_query_requests");
        op.add(
            Builder::maxDistanceQueryWithFilterRequests,
            JsonpDeserializer.longDeserializer(),
            "max_distance_query_with_filter_requests"
        );
        op.add(Builder::minScoreQueryRequests, JsonpDeserializer.longDeserializer(), "min_score_query_requests");
        op.add(Builder::minScoreQueryWithFilterRequests, JsonpDeserializer.longDeserializer(), "min_score_query_with_filter_requests");
        op.add(Builder::missCount, JsonpDeserializer.longDeserializer(), "miss_count");
        op.add(Builder::nmslibInitialized, JsonpDeserializer.booleanDeserializer(), "nmslib_initialized");
        op.add(Builder::remoteVectorIndexBuildStats, RemoteVectorIndexBuildStats._DESERIALIZER, "remote_vector_index_build_stats");
        op.add(Builder::scriptCompilationErrors, JsonpDeserializer.longDeserializer(), "script_compilation_errors");
        op.add(Builder::scriptCompilations, JsonpDeserializer.longDeserializer(), "script_compilations");
        op.add(Builder::scriptQueryErrors, JsonpDeserializer.longDeserializer(), "script_query_errors");
        op.add(Builder::scriptQueryRequests, JsonpDeserializer.longDeserializer(), "script_query_requests");
        op.add(Builder::totalLoadTime, JsonpDeserializer.longDeserializer(), "total_load_time");
        op.add(Builder::trainingErrors, JsonpDeserializer.longDeserializer(), "training_errors");
        op.add(Builder::trainingMemoryUsage, JsonpDeserializer.longDeserializer(), "training_memory_usage");
        op.add(Builder::trainingMemoryUsagePercentage, JsonpDeserializer.doubleDeserializer(), "training_memory_usage_percentage");
        op.add(Builder::trainingRequests, JsonpDeserializer.longDeserializer(), "training_requests");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.cacheCapacityReached);
        result = 31 * result + Objects.hashCode(this.evictionCount);
        result = 31 * result + Objects.hashCode(this.faissInitialized);
        result = 31 * result + Objects.hashCode(this.graphIndexErrors);
        result = 31 * result + Objects.hashCode(this.graphIndexRequests);
        result = 31 * result + Objects.hashCode(this.graphMemoryUsage);
        result = 31 * result + Objects.hashCode(this.graphMemoryUsagePercentage);
        result = 31 * result + Objects.hashCode(this.graphQueryErrors);
        result = 31 * result + Objects.hashCode(this.graphQueryRequests);
        result = 31 * result + Objects.hashCode(this.graphStats);
        result = 31 * result + Objects.hashCode(this.hitCount);
        result = 31 * result + Objects.hashCode(this.indexingFromModelDegraded);
        result = 31 * result + Objects.hashCode(this.indicesInCache);
        result = 31 * result + Objects.hashCode(this.knnQueryRequests);
        result = 31 * result + Objects.hashCode(this.knnQueryWithFilterRequests);
        result = 31 * result + Objects.hashCode(this.loadExceptionCount);
        result = 31 * result + Objects.hashCode(this.loadSuccessCount);
        result = 31 * result + Objects.hashCode(this.luceneInitialized);
        result = 31 * result + Objects.hashCode(this.maxDistanceQueryRequests);
        result = 31 * result + Objects.hashCode(this.maxDistanceQueryWithFilterRequests);
        result = 31 * result + Objects.hashCode(this.minScoreQueryRequests);
        result = 31 * result + Objects.hashCode(this.minScoreQueryWithFilterRequests);
        result = 31 * result + Objects.hashCode(this.missCount);
        result = 31 * result + Objects.hashCode(this.nmslibInitialized);
        result = 31 * result + Objects.hashCode(this.remoteVectorIndexBuildStats);
        result = 31 * result + Objects.hashCode(this.scriptCompilationErrors);
        result = 31 * result + Objects.hashCode(this.scriptCompilations);
        result = 31 * result + Objects.hashCode(this.scriptQueryErrors);
        result = 31 * result + Objects.hashCode(this.scriptQueryRequests);
        result = 31 * result + Objects.hashCode(this.totalLoadTime);
        result = 31 * result + Objects.hashCode(this.trainingErrors);
        result = 31 * result + Objects.hashCode(this.trainingMemoryUsage);
        result = 31 * result + Objects.hashCode(this.trainingMemoryUsagePercentage);
        result = 31 * result + Objects.hashCode(this.trainingRequests);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeStats other = (NodeStats) o;
        return Objects.equals(this.cacheCapacityReached, other.cacheCapacityReached)
            && Objects.equals(this.evictionCount, other.evictionCount)
            && Objects.equals(this.faissInitialized, other.faissInitialized)
            && Objects.equals(this.graphIndexErrors, other.graphIndexErrors)
            && Objects.equals(this.graphIndexRequests, other.graphIndexRequests)
            && Objects.equals(this.graphMemoryUsage, other.graphMemoryUsage)
            && Objects.equals(this.graphMemoryUsagePercentage, other.graphMemoryUsagePercentage)
            && Objects.equals(this.graphQueryErrors, other.graphQueryErrors)
            && Objects.equals(this.graphQueryRequests, other.graphQueryRequests)
            && Objects.equals(this.graphStats, other.graphStats)
            && Objects.equals(this.hitCount, other.hitCount)
            && Objects.equals(this.indexingFromModelDegraded, other.indexingFromModelDegraded)
            && Objects.equals(this.indicesInCache, other.indicesInCache)
            && Objects.equals(this.knnQueryRequests, other.knnQueryRequests)
            && Objects.equals(this.knnQueryWithFilterRequests, other.knnQueryWithFilterRequests)
            && Objects.equals(this.loadExceptionCount, other.loadExceptionCount)
            && Objects.equals(this.loadSuccessCount, other.loadSuccessCount)
            && Objects.equals(this.luceneInitialized, other.luceneInitialized)
            && Objects.equals(this.maxDistanceQueryRequests, other.maxDistanceQueryRequests)
            && Objects.equals(this.maxDistanceQueryWithFilterRequests, other.maxDistanceQueryWithFilterRequests)
            && Objects.equals(this.minScoreQueryRequests, other.minScoreQueryRequests)
            && Objects.equals(this.minScoreQueryWithFilterRequests, other.minScoreQueryWithFilterRequests)
            && Objects.equals(this.missCount, other.missCount)
            && Objects.equals(this.nmslibInitialized, other.nmslibInitialized)
            && Objects.equals(this.remoteVectorIndexBuildStats, other.remoteVectorIndexBuildStats)
            && Objects.equals(this.scriptCompilationErrors, other.scriptCompilationErrors)
            && Objects.equals(this.scriptCompilations, other.scriptCompilations)
            && Objects.equals(this.scriptQueryErrors, other.scriptQueryErrors)
            && Objects.equals(this.scriptQueryRequests, other.scriptQueryRequests)
            && Objects.equals(this.totalLoadTime, other.totalLoadTime)
            && Objects.equals(this.trainingErrors, other.trainingErrors)
            && Objects.equals(this.trainingMemoryUsage, other.trainingMemoryUsage)
            && Objects.equals(this.trainingMemoryUsagePercentage, other.trainingMemoryUsagePercentage)
            && Objects.equals(this.trainingRequests, other.trainingRequests);
    }
}
