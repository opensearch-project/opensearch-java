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

package org.opensearch.client.opensearch.indices;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.IndexSettings

/**
 * The configuration settings for an index.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettings implements PlainJsonSerializable, ToCopyableBuilder<IndexSettings.Builder, IndexSettings> {

    @Nullable
    private final IndexSettingsAnalysis analysis;

    @Nullable
    private final IndexSettingsAnalyze analyze;

    @Nullable
    private final Integer analyzeMaxTokenCount;

    @Nullable
    private final String autoExpandReplicas;

    @Nullable
    private final IndexSettingBlocks blocks;

    @Nullable
    private final Boolean blocksMetadata;

    @Nullable
    private final Boolean blocksRead;

    @Nullable
    private final Boolean blocksReadOnly;

    @Nullable
    private final Boolean blocksReadOnlyAllowDelete;

    @Nullable
    private final Boolean blocksWrite;

    @Nullable
    private final IndexCheckOnStartup checkOnStartup;

    @Nullable
    private final String codec;

    @Nullable
    private final IndexSettingsStarTree compositeIndexStarTree;

    @Nullable
    private final Long creationDate;

    @Nullable
    private final String creationDateString;

    @Nonnull
    private final Map<String, JsonData> customSettings;

    @Nullable
    private final String defaultPipeline;

    @Nullable
    private final String finalPipeline;

    @Nullable
    private final Integer format;

    @Nullable
    private final Time gcDeletes;

    @Nullable
    private final Boolean hidden;

    @Nullable
    private final IndexSettingsHighlight highlight;

    @Nullable
    private final Integer highlightMaxAnalyzedOffset;

    @Nullable
    private final IndexSettings index;

    @Nullable
    private final IndexSettingsIndexing indexing;

    @Nullable
    private final IndexingPressure indexingPressure;

    @Nullable
    private final Boolean knn;

    @Nullable
    private final Integer knnAlgoParamEfSearch;

    @Nullable
    private final IndexSettingsLifecycle lifecycle;

    @Nullable
    private final String lifecycleName;

    @Nullable
    private final Boolean loadFixedBitsetFiltersEagerly;

    @Nullable
    private final IndexSettingsMapping mapping;

    @Nullable
    private final Integer maxDocvalueFieldsSearch;

    @Nullable
    private final Integer maxInnerResultWindow;

    @Nullable
    private final Integer maxNgramDiff;

    @Nullable
    private final Integer maxRefreshListeners;

    @Nullable
    private final Integer maxRegexLength;

    @Nullable
    private final Integer maxRescoreWindow;

    @Nullable
    private final Integer maxResultWindow;

    @Nullable
    private final Integer maxScriptFields;

    @Nullable
    private final Integer maxShingleDiff;

    @Nullable
    private final Integer maxSlicesPerScroll;

    @Nullable
    private final Integer maxTermsCount;

    @Nullable
    private final IndexSettingsMerge merge;

    @Nullable
    private final Integer mergeSchedulerMaxThreadCount;

    @Nullable
    private final String mode;

    @Nullable
    private final Integer numberOfReplicas;

    @Nullable
    private final Integer numberOfRoutingShards;

    @Nullable
    private final Integer numberOfShards;

    @Nullable
    private final Integer priority;

    @Nullable
    private final String providedName;

    @Nullable
    private final IndexSettingsQueries queries;

    @Nullable
    private final IndexSettingsQueryString queryString;

    @Nullable
    private final Boolean queryStringLenient;

    @Nullable
    private final Time refreshInterval;

    @Nullable
    private final IndexRouting routing;

    @Nullable
    private final Integer routingPartitionSize;

    @Nonnull
    private final List<String> routingPath;

    @Nullable
    private final IndexSettingsSearch search;

    @Nullable
    private final Time searchIdleAfter;

    @Nullable
    private final IndexSettings settings;

    @Nullable
    private final IndexSettingsSimilarity similarity;

    @Nullable
    private final SoftDeletes softDeletes;

    @Nullable
    private final Time softDeletesRetentionLeasePeriod;

    @Nullable
    private final IndexSegmentSort sort;

    @Nullable
    private final IndexSettingsStore store;

    @Nullable
    private final Integer topMetricsMaxSize;

    @Nullable
    private final Translog translog;

    @Nullable
    private final TranslogDurability translogDurability;

    @Nullable
    private final String translogFlushThresholdSize;

    @Nullable
    private final String uuid;

    @Nullable
    private final Boolean verifiedBeforeClose;

    @Nullable
    private final IndexVersioning version;

    // ---------------------------------------------------------------------------------------------

    private IndexSettings(Builder builder) {
        this.analysis = builder.analysis;
        this.analyze = builder.analyze;
        this.analyzeMaxTokenCount = builder.analyzeMaxTokenCount;
        this.autoExpandReplicas = builder.autoExpandReplicas;
        this.blocks = builder.blocks;
        this.blocksMetadata = builder.blocksMetadata;
        this.blocksRead = builder.blocksRead;
        this.blocksReadOnly = builder.blocksReadOnly;
        this.blocksReadOnlyAllowDelete = builder.blocksReadOnlyAllowDelete;
        this.blocksWrite = builder.blocksWrite;
        this.checkOnStartup = builder.checkOnStartup;
        this.codec = builder.codec;
        this.compositeIndexStarTree = builder.compositeIndexStarTree;
        this.creationDate = builder.creationDate;
        this.creationDateString = builder.creationDateString;
        this.customSettings = ApiTypeHelper.unmodifiable(builder.customSettings);
        this.defaultPipeline = builder.defaultPipeline;
        this.finalPipeline = builder.finalPipeline;
        this.format = builder.format;
        this.gcDeletes = builder.gcDeletes;
        this.hidden = builder.hidden;
        this.highlight = builder.highlight;
        this.highlightMaxAnalyzedOffset = builder.highlightMaxAnalyzedOffset;
        this.index = builder.index;
        this.indexing = builder.indexing;
        this.indexingPressure = builder.indexingPressure;
        this.knn = builder.knn;
        this.knnAlgoParamEfSearch = builder.knnAlgoParamEfSearch;
        this.lifecycle = builder.lifecycle;
        this.lifecycleName = builder.lifecycleName;
        this.loadFixedBitsetFiltersEagerly = builder.loadFixedBitsetFiltersEagerly;
        this.mapping = builder.mapping;
        this.maxDocvalueFieldsSearch = builder.maxDocvalueFieldsSearch;
        this.maxInnerResultWindow = builder.maxInnerResultWindow;
        this.maxNgramDiff = builder.maxNgramDiff;
        this.maxRefreshListeners = builder.maxRefreshListeners;
        this.maxRegexLength = builder.maxRegexLength;
        this.maxRescoreWindow = builder.maxRescoreWindow;
        this.maxResultWindow = builder.maxResultWindow;
        this.maxScriptFields = builder.maxScriptFields;
        this.maxShingleDiff = builder.maxShingleDiff;
        this.maxSlicesPerScroll = builder.maxSlicesPerScroll;
        this.maxTermsCount = builder.maxTermsCount;
        this.merge = builder.merge;
        this.mergeSchedulerMaxThreadCount = builder.mergeSchedulerMaxThreadCount;
        this.mode = builder.mode;
        this.numberOfReplicas = builder.numberOfReplicas;
        this.numberOfRoutingShards = builder.numberOfRoutingShards;
        this.numberOfShards = builder.numberOfShards;
        this.priority = builder.priority;
        this.providedName = builder.providedName;
        this.queries = builder.queries;
        this.queryString = builder.queryString;
        this.queryStringLenient = builder.queryStringLenient;
        this.refreshInterval = builder.refreshInterval;
        this.routing = builder.routing;
        this.routingPartitionSize = builder.routingPartitionSize;
        this.routingPath = ApiTypeHelper.unmodifiable(builder.routingPath);
        this.search = builder.search;
        this.searchIdleAfter = builder.searchIdleAfter;
        this.settings = builder.settings;
        this.similarity = builder.similarity;
        this.softDeletes = builder.softDeletes;
        this.softDeletesRetentionLeasePeriod = builder.softDeletesRetentionLeasePeriod;
        this.sort = builder.sort;
        this.store = builder.store;
        this.topMetricsMaxSize = builder.topMetricsMaxSize;
        this.translog = builder.translog;
        this.translogDurability = builder.translogDurability;
        this.translogFlushThresholdSize = builder.translogFlushThresholdSize;
        this.uuid = builder.uuid;
        this.verifiedBeforeClose = builder.verifiedBeforeClose;
        this.version = builder.version;
    }

    public static IndexSettings of(Function<IndexSettings.Builder, ObjectBuilder<IndexSettings>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code analysis}
     */
    @Nullable
    public final IndexSettingsAnalysis analysis() {
        return this.analysis;
    }

    /**
     * API name: {@code analyze}
     */
    @Nullable
    public final IndexSettingsAnalyze analyze() {
        return this.analyze;
    }

    /**
     * API name: {@code analyze.max_token_count}
     */
    @Nullable
    public final Integer analyzeMaxTokenCount() {
        return this.analyzeMaxTokenCount;
    }

    /**
     * The range of replicas to maintain.
     * <p>
     * API name: {@code auto_expand_replicas}
     * </p>
     */
    @Nullable
    public final String autoExpandReplicas() {
        return this.autoExpandReplicas;
    }

    /**
     * API name: {@code blocks}
     */
    @Nullable
    public final IndexSettingBlocks blocks() {
        return this.blocks;
    }

    /**
     * API name: {@code blocks.metadata}
     */
    @Nullable
    public final Boolean blocksMetadata() {
        return this.blocksMetadata;
    }

    /**
     * API name: {@code blocks.read}
     */
    @Nullable
    public final Boolean blocksRead() {
        return this.blocksRead;
    }

    /**
     * API name: {@code blocks.read_only}
     */
    @Nullable
    public final Boolean blocksReadOnly() {
        return this.blocksReadOnly;
    }

    /**
     * API name: {@code blocks.read_only_allow_delete}
     */
    @Nullable
    public final Boolean blocksReadOnlyAllowDelete() {
        return this.blocksReadOnlyAllowDelete;
    }

    /**
     * API name: {@code blocks.write}
     */
    @Nullable
    public final Boolean blocksWrite() {
        return this.blocksWrite;
    }

    /**
     * API name: {@code check_on_startup}
     */
    @Nullable
    public final IndexCheckOnStartup checkOnStartup() {
        return this.checkOnStartup;
    }

    /**
     * The compression type for stored data.
     * <p>
     * API name: {@code codec}
     * </p>
     */
    @Nullable
    public final String codec() {
        return this.codec;
    }

    /**
     * API name: {@code composite_index.star_tree}
     */
    @Nullable
    public final IndexSettingsStarTree compositeIndexStarTree() {
        return this.compositeIndexStarTree;
    }

    /**
     * API name: {@code creation_date}
     */
    @Nullable
    public final Long creationDate() {
        return this.creationDate;
    }

    /**
     * API name: {@code creation_date_string}
     */
    @Nullable
    public final String creationDateString() {
        return this.creationDateString;
    }

    @Nonnull
    public final Map<String, JsonData> customSettings() {
        return this.customSettings;
    }

    /**
     * API name: {@code default_pipeline}
     */
    @Nullable
    public final String defaultPipeline() {
        return this.defaultPipeline;
    }

    /**
     * API name: {@code final_pipeline}
     */
    @Nullable
    public final String finalPipeline() {
        return this.finalPipeline;
    }

    /**
     * API name: {@code format}
     */
    @Nullable
    public final Integer format() {
        return this.format;
    }

    /**
     * API name: {@code gc_deletes}
     */
    @Nullable
    public final Time gcDeletes() {
        return this.gcDeletes;
    }

    /**
     * API name: {@code hidden}
     */
    @Nullable
    public final Boolean hidden() {
        return this.hidden;
    }

    /**
     * API name: {@code highlight}
     */
    @Nullable
    public final IndexSettingsHighlight highlight() {
        return this.highlight;
    }

    /**
     * API name: {@code highlight.max_analyzed_offset}
     */
    @Nullable
    public final Integer highlightMaxAnalyzedOffset() {
        return this.highlightMaxAnalyzedOffset;
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final IndexSettings index() {
        return this.index;
    }

    /**
     * API name: {@code indexing}
     */
    @Nullable
    public final IndexSettingsIndexing indexing() {
        return this.indexing;
    }

    /**
     * API name: {@code indexing_pressure}
     */
    @Nullable
    public final IndexingPressure indexingPressure() {
        return this.indexingPressure;
    }

    /**
     * API name: {@code knn}
     */
    @Nullable
    public final Boolean knn() {
        return this.knn;
    }

    /**
     * API name: {@code knn.algo_param.ef_search}
     */
    @Nullable
    public final Integer knnAlgoParamEfSearch() {
        return this.knnAlgoParamEfSearch;
    }

    /**
     * API name: {@code lifecycle}
     */
    @Nullable
    public final IndexSettingsLifecycle lifecycle() {
        return this.lifecycle;
    }

    /**
     * API name: {@code lifecycle.name}
     */
    @Nullable
    public final String lifecycleName() {
        return this.lifecycleName;
    }

    /**
     * API name: {@code load_fixed_bitset_filters_eagerly}
     */
    @Nullable
    public final Boolean loadFixedBitsetFiltersEagerly() {
        return this.loadFixedBitsetFiltersEagerly;
    }

    /**
     * API name: {@code mapping}
     */
    @Nullable
    public final IndexSettingsMapping mapping() {
        return this.mapping;
    }

    /**
     * API name: {@code max_docvalue_fields_search}
     */
    @Nullable
    public final Integer maxDocvalueFieldsSearch() {
        return this.maxDocvalueFieldsSearch;
    }

    /**
     * API name: {@code max_inner_result_window}
     */
    @Nullable
    public final Integer maxInnerResultWindow() {
        return this.maxInnerResultWindow;
    }

    /**
     * API name: {@code max_ngram_diff}
     */
    @Nullable
    public final Integer maxNgramDiff() {
        return this.maxNgramDiff;
    }

    /**
     * API name: {@code max_refresh_listeners}
     */
    @Nullable
    public final Integer maxRefreshListeners() {
        return this.maxRefreshListeners;
    }

    /**
     * API name: {@code max_regex_length}
     */
    @Nullable
    public final Integer maxRegexLength() {
        return this.maxRegexLength;
    }

    /**
     * API name: {@code max_rescore_window}
     */
    @Nullable
    public final Integer maxRescoreWindow() {
        return this.maxRescoreWindow;
    }

    /**
     * API name: {@code max_result_window}
     */
    @Nullable
    public final Integer maxResultWindow() {
        return this.maxResultWindow;
    }

    /**
     * API name: {@code max_script_fields}
     */
    @Nullable
    public final Integer maxScriptFields() {
        return this.maxScriptFields;
    }

    /**
     * API name: {@code max_shingle_diff}
     */
    @Nullable
    public final Integer maxShingleDiff() {
        return this.maxShingleDiff;
    }

    /**
     * API name: {@code max_slices_per_scroll}
     */
    @Nullable
    public final Integer maxSlicesPerScroll() {
        return this.maxSlicesPerScroll;
    }

    /**
     * API name: {@code max_terms_count}
     */
    @Nullable
    public final Integer maxTermsCount() {
        return this.maxTermsCount;
    }

    /**
     * API name: {@code merge}
     */
    @Nullable
    public final IndexSettingsMerge merge() {
        return this.merge;
    }

    /**
     * API name: {@code merge.scheduler.max_thread_count}
     */
    @Nullable
    public final Integer mergeSchedulerMaxThreadCount() {
        return this.mergeSchedulerMaxThreadCount;
    }

    /**
     * API name: {@code mode}
     */
    @Nullable
    public final String mode() {
        return this.mode;
    }

    /**
     * API name: {@code number_of_replicas}
     */
    @Nullable
    public final Integer numberOfReplicas() {
        return this.numberOfReplicas;
    }

    /**
     * API name: {@code number_of_routing_shards}
     */
    @Nullable
    public final Integer numberOfRoutingShards() {
        return this.numberOfRoutingShards;
    }

    /**
     * API name: {@code number_of_shards}
     */
    @Nullable
    public final Integer numberOfShards() {
        return this.numberOfShards;
    }

    /**
     * API name: {@code priority}
     */
    @Nullable
    public final Integer priority() {
        return this.priority;
    }

    /**
     * API name: {@code provided_name}
     */
    @Nullable
    public final String providedName() {
        return this.providedName;
    }

    /**
     * API name: {@code queries}
     */
    @Nullable
    public final IndexSettingsQueries queries() {
        return this.queries;
    }

    /**
     * API name: {@code query_string}
     */
    @Nullable
    public final IndexSettingsQueryString queryString() {
        return this.queryString;
    }

    /**
     * API name: {@code query_string.lenient}
     */
    @Nullable
    public final Boolean queryStringLenient() {
        return this.queryStringLenient;
    }

    /**
     * API name: {@code refresh_interval}
     */
    @Nullable
    public final Time refreshInterval() {
        return this.refreshInterval;
    }

    /**
     * API name: {@code routing}
     */
    @Nullable
    public final IndexRouting routing() {
        return this.routing;
    }

    /**
     * API name: {@code routing_partition_size}
     */
    @Nullable
    public final Integer routingPartitionSize() {
        return this.routingPartitionSize;
    }

    /**
     * API name: {@code routing_path}
     */
    @Nonnull
    public final List<String> routingPath() {
        return this.routingPath;
    }

    /**
     * API name: {@code search}
     */
    @Nullable
    public final IndexSettingsSearch search() {
        return this.search;
    }

    /**
     * API name: {@code search.idle.after}
     */
    @Nullable
    public final Time searchIdleAfter() {
        return this.searchIdleAfter;
    }

    /**
     * API name: {@code settings}
     */
    @Nullable
    public final IndexSettings settings() {
        return this.settings;
    }

    /**
     * API name: {@code similarity}
     */
    @Nullable
    public final IndexSettingsSimilarity similarity() {
        return this.similarity;
    }

    /**
     * API name: {@code soft_deletes}
     */
    @Nullable
    public final SoftDeletes softDeletes() {
        return this.softDeletes;
    }

    /**
     * API name: {@code soft_deletes.retention_lease.period}
     */
    @Nullable
    public final Time softDeletesRetentionLeasePeriod() {
        return this.softDeletesRetentionLeasePeriod;
    }

    /**
     * API name: {@code sort}
     */
    @Nullable
    public final IndexSegmentSort sort() {
        return this.sort;
    }

    /**
     * API name: {@code store}
     */
    @Nullable
    public final IndexSettingsStore store() {
        return this.store;
    }

    /**
     * API name: {@code top_metrics_max_size}
     */
    @Nullable
    public final Integer topMetricsMaxSize() {
        return this.topMetricsMaxSize;
    }

    /**
     * API name: {@code translog}
     */
    @Nullable
    public final Translog translog() {
        return this.translog;
    }

    /**
     * API name: {@code translog.durability}
     */
    @Nullable
    public final TranslogDurability translogDurability() {
        return this.translogDurability;
    }

    /**
     * API name: {@code translog.flush_threshold_size}
     */
    @Nullable
    public final String translogFlushThresholdSize() {
        return this.translogFlushThresholdSize;
    }

    /**
     * API name: {@code uuid}
     */
    @Nullable
    public final String uuid() {
        return this.uuid;
    }

    /**
     * API name: {@code verified_before_close}
     */
    @Nullable
    public final Boolean verifiedBeforeClose() {
        return this.verifiedBeforeClose;
    }

    /**
     * API name: {@code version}
     */
    @Nullable
    public final IndexVersioning version() {
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
        for (Map.Entry<String, JsonData> item0 : this.customSettings.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        if (this.analysis != null) {
            generator.writeKey("analysis");
            this.analysis.serialize(generator, mapper);
        }

        if (this.analyze != null) {
            generator.writeKey("analyze");
            this.analyze.serialize(generator, mapper);
        }

        if (this.analyzeMaxTokenCount != null) {
            generator.writeKey("analyze.max_token_count");
            generator.write(this.analyzeMaxTokenCount);
        }

        if (this.autoExpandReplicas != null) {
            generator.writeKey("auto_expand_replicas");
            generator.write(this.autoExpandReplicas);
        }

        if (this.blocks != null) {
            generator.writeKey("blocks");
            this.blocks.serialize(generator, mapper);
        }

        if (this.blocksMetadata != null) {
            generator.writeKey("blocks.metadata");
            generator.write(this.blocksMetadata);
        }

        if (this.blocksRead != null) {
            generator.writeKey("blocks.read");
            generator.write(this.blocksRead);
        }

        if (this.blocksReadOnly != null) {
            generator.writeKey("blocks.read_only");
            generator.write(this.blocksReadOnly);
        }

        if (this.blocksReadOnlyAllowDelete != null) {
            generator.writeKey("blocks.read_only_allow_delete");
            generator.write(this.blocksReadOnlyAllowDelete);
        }

        if (this.blocksWrite != null) {
            generator.writeKey("blocks.write");
            generator.write(this.blocksWrite);
        }

        if (this.checkOnStartup != null) {
            generator.writeKey("check_on_startup");
            this.checkOnStartup.serialize(generator, mapper);
        }

        if (this.codec != null) {
            generator.writeKey("codec");
            generator.write(this.codec);
        }

        if (this.compositeIndexStarTree != null) {
            generator.writeKey("composite_index.star_tree");
            this.compositeIndexStarTree.serialize(generator, mapper);
        }

        if (this.creationDate != null) {
            generator.writeKey("creation_date");
            generator.write(this.creationDate);
        }

        if (this.creationDateString != null) {
            generator.writeKey("creation_date_string");
            generator.write(this.creationDateString);
        }

        if (this.defaultPipeline != null) {
            generator.writeKey("default_pipeline");
            generator.write(this.defaultPipeline);
        }

        if (this.finalPipeline != null) {
            generator.writeKey("final_pipeline");
            generator.write(this.finalPipeline);
        }

        if (this.format != null) {
            generator.writeKey("format");
            generator.write(this.format);
        }

        if (this.gcDeletes != null) {
            generator.writeKey("gc_deletes");
            this.gcDeletes.serialize(generator, mapper);
        }

        if (this.hidden != null) {
            generator.writeKey("hidden");
            generator.write(this.hidden);
        }

        if (this.highlight != null) {
            generator.writeKey("highlight");
            this.highlight.serialize(generator, mapper);
        }

        if (this.highlightMaxAnalyzedOffset != null) {
            generator.writeKey("highlight.max_analyzed_offset");
            generator.write(this.highlightMaxAnalyzedOffset);
        }

        if (this.index != null) {
            generator.writeKey("index");
            this.index.serialize(generator, mapper);
        }

        if (this.indexing != null) {
            generator.writeKey("indexing");
            this.indexing.serialize(generator, mapper);
        }

        if (this.indexingPressure != null) {
            generator.writeKey("indexing_pressure");
            this.indexingPressure.serialize(generator, mapper);
        }

        if (this.knn != null) {
            generator.writeKey("knn");
            generator.write(this.knn);
        }

        if (this.knnAlgoParamEfSearch != null) {
            generator.writeKey("knn.algo_param.ef_search");
            generator.write(this.knnAlgoParamEfSearch);
        }

        if (this.lifecycle != null) {
            generator.writeKey("lifecycle");
            this.lifecycle.serialize(generator, mapper);
        }

        if (this.lifecycleName != null) {
            generator.writeKey("lifecycle.name");
            generator.write(this.lifecycleName);
        }

        if (this.loadFixedBitsetFiltersEagerly != null) {
            generator.writeKey("load_fixed_bitset_filters_eagerly");
            generator.write(this.loadFixedBitsetFiltersEagerly);
        }

        if (this.mapping != null) {
            generator.writeKey("mapping");
            this.mapping.serialize(generator, mapper);
        }

        if (this.maxDocvalueFieldsSearch != null) {
            generator.writeKey("max_docvalue_fields_search");
            generator.write(this.maxDocvalueFieldsSearch);
        }

        if (this.maxInnerResultWindow != null) {
            generator.writeKey("max_inner_result_window");
            generator.write(this.maxInnerResultWindow);
        }

        if (this.maxNgramDiff != null) {
            generator.writeKey("max_ngram_diff");
            generator.write(this.maxNgramDiff);
        }

        if (this.maxRefreshListeners != null) {
            generator.writeKey("max_refresh_listeners");
            generator.write(this.maxRefreshListeners);
        }

        if (this.maxRegexLength != null) {
            generator.writeKey("max_regex_length");
            generator.write(this.maxRegexLength);
        }

        if (this.maxRescoreWindow != null) {
            generator.writeKey("max_rescore_window");
            generator.write(this.maxRescoreWindow);
        }

        if (this.maxResultWindow != null) {
            generator.writeKey("max_result_window");
            generator.write(this.maxResultWindow);
        }

        if (this.maxScriptFields != null) {
            generator.writeKey("max_script_fields");
            generator.write(this.maxScriptFields);
        }

        if (this.maxShingleDiff != null) {
            generator.writeKey("max_shingle_diff");
            generator.write(this.maxShingleDiff);
        }

        if (this.maxSlicesPerScroll != null) {
            generator.writeKey("max_slices_per_scroll");
            generator.write(this.maxSlicesPerScroll);
        }

        if (this.maxTermsCount != null) {
            generator.writeKey("max_terms_count");
            generator.write(this.maxTermsCount);
        }

        if (this.merge != null) {
            generator.writeKey("merge");
            this.merge.serialize(generator, mapper);
        }

        if (this.mergeSchedulerMaxThreadCount != null) {
            generator.writeKey("merge.scheduler.max_thread_count");
            generator.write(this.mergeSchedulerMaxThreadCount);
        }

        if (this.mode != null) {
            generator.writeKey("mode");
            generator.write(this.mode);
        }

        if (this.numberOfReplicas != null) {
            generator.writeKey("number_of_replicas");
            generator.write(this.numberOfReplicas);
        }

        if (this.numberOfRoutingShards != null) {
            generator.writeKey("number_of_routing_shards");
            generator.write(this.numberOfRoutingShards);
        }

        if (this.numberOfShards != null) {
            generator.writeKey("number_of_shards");
            generator.write(this.numberOfShards);
        }

        if (this.priority != null) {
            generator.writeKey("priority");
            generator.write(this.priority);
        }

        if (this.providedName != null) {
            generator.writeKey("provided_name");
            generator.write(this.providedName);
        }

        if (this.queries != null) {
            generator.writeKey("queries");
            this.queries.serialize(generator, mapper);
        }

        if (this.queryString != null) {
            generator.writeKey("query_string");
            this.queryString.serialize(generator, mapper);
        }

        if (this.queryStringLenient != null) {
            generator.writeKey("query_string.lenient");
            generator.write(this.queryStringLenient);
        }

        if (this.refreshInterval != null) {
            generator.writeKey("refresh_interval");
            this.refreshInterval.serialize(generator, mapper);
        }

        if (this.routing != null) {
            generator.writeKey("routing");
            this.routing.serialize(generator, mapper);
        }

        if (this.routingPartitionSize != null) {
            generator.writeKey("routing_partition_size");
            generator.write(this.routingPartitionSize);
        }

        if (ApiTypeHelper.isDefined(this.routingPath)) {
            generator.writeKey("routing_path");
            generator.writeStartArray();
            for (String item0 : this.routingPath) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.search != null) {
            generator.writeKey("search");
            this.search.serialize(generator, mapper);
        }

        if (this.searchIdleAfter != null) {
            generator.writeKey("search.idle.after");
            this.searchIdleAfter.serialize(generator, mapper);
        }

        if (this.settings != null) {
            generator.writeKey("settings");
            this.settings.serialize(generator, mapper);
        }

        if (this.similarity != null) {
            generator.writeKey("similarity");
            this.similarity.serialize(generator, mapper);
        }

        if (this.softDeletes != null) {
            generator.writeKey("soft_deletes");
            this.softDeletes.serialize(generator, mapper);
        }

        if (this.softDeletesRetentionLeasePeriod != null) {
            generator.writeKey("soft_deletes.retention_lease.period");
            this.softDeletesRetentionLeasePeriod.serialize(generator, mapper);
        }

        if (this.sort != null) {
            generator.writeKey("sort");
            this.sort.serialize(generator, mapper);
        }

        if (this.store != null) {
            generator.writeKey("store");
            this.store.serialize(generator, mapper);
        }

        if (this.topMetricsMaxSize != null) {
            generator.writeKey("top_metrics_max_size");
            generator.write(this.topMetricsMaxSize);
        }

        if (this.translog != null) {
            generator.writeKey("translog");
            this.translog.serialize(generator, mapper);
        }

        if (this.translogDurability != null) {
            generator.writeKey("translog.durability");
            this.translogDurability.serialize(generator, mapper);
        }

        if (this.translogFlushThresholdSize != null) {
            generator.writeKey("translog.flush_threshold_size");
            generator.write(this.translogFlushThresholdSize);
        }

        if (this.uuid != null) {
            generator.writeKey("uuid");
            generator.write(this.uuid);
        }

        if (this.verifiedBeforeClose != null) {
            generator.writeKey("verified_before_close");
            generator.write(this.verifiedBeforeClose);
        }

        if (this.version != null) {
            generator.writeKey("version");
            this.version.serialize(generator, mapper);
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
     * Builder for {@link IndexSettings}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettings> {
        @Nullable
        private IndexSettingsAnalysis analysis;
        @Nullable
        private IndexSettingsAnalyze analyze;
        @Nullable
        private Integer analyzeMaxTokenCount;
        @Nullable
        private String autoExpandReplicas;
        @Nullable
        private IndexSettingBlocks blocks;
        @Nullable
        private Boolean blocksMetadata;
        @Nullable
        private Boolean blocksRead;
        @Nullable
        private Boolean blocksReadOnly;
        @Nullable
        private Boolean blocksReadOnlyAllowDelete;
        @Nullable
        private Boolean blocksWrite;
        @Nullable
        private IndexCheckOnStartup checkOnStartup;
        @Nullable
        private String codec;
        @Nullable
        private IndexSettingsStarTree compositeIndexStarTree;
        @Nullable
        private Long creationDate;
        @Nullable
        private String creationDateString;
        @Nullable
        private Map<String, JsonData> customSettings;
        @Nullable
        private String defaultPipeline;
        @Nullable
        private String finalPipeline;
        @Nullable
        private Integer format;
        @Nullable
        private Time gcDeletes;
        @Nullable
        private Boolean hidden;
        @Nullable
        private IndexSettingsHighlight highlight;
        @Nullable
        private Integer highlightMaxAnalyzedOffset;
        @Nullable
        private IndexSettings index;
        @Nullable
        private IndexSettingsIndexing indexing;
        @Nullable
        private IndexingPressure indexingPressure;
        @Nullable
        private Boolean knn;
        @Nullable
        private Integer knnAlgoParamEfSearch;
        @Nullable
        private IndexSettingsLifecycle lifecycle;
        @Nullable
        private String lifecycleName;
        @Nullable
        private Boolean loadFixedBitsetFiltersEagerly;
        @Nullable
        private IndexSettingsMapping mapping;
        @Nullable
        private Integer maxDocvalueFieldsSearch;
        @Nullable
        private Integer maxInnerResultWindow;
        @Nullable
        private Integer maxNgramDiff;
        @Nullable
        private Integer maxRefreshListeners;
        @Nullable
        private Integer maxRegexLength;
        @Nullable
        private Integer maxRescoreWindow;
        @Nullable
        private Integer maxResultWindow;
        @Nullable
        private Integer maxScriptFields;
        @Nullable
        private Integer maxShingleDiff;
        @Nullable
        private Integer maxSlicesPerScroll;
        @Nullable
        private Integer maxTermsCount;
        @Nullable
        private IndexSettingsMerge merge;
        @Nullable
        private Integer mergeSchedulerMaxThreadCount;
        @Nullable
        private String mode;
        @Nullable
        private Integer numberOfReplicas;
        @Nullable
        private Integer numberOfRoutingShards;
        @Nullable
        private Integer numberOfShards;
        @Nullable
        private Integer priority;
        @Nullable
        private String providedName;
        @Nullable
        private IndexSettingsQueries queries;
        @Nullable
        private IndexSettingsQueryString queryString;
        @Nullable
        private Boolean queryStringLenient;
        @Nullable
        private Time refreshInterval;
        @Nullable
        private IndexRouting routing;
        @Nullable
        private Integer routingPartitionSize;
        @Nullable
        private List<String> routingPath;
        @Nullable
        private IndexSettingsSearch search;
        @Nullable
        private Time searchIdleAfter;
        @Nullable
        private IndexSettings settings;
        @Nullable
        private IndexSettingsSimilarity similarity;
        @Nullable
        private SoftDeletes softDeletes;
        @Nullable
        private Time softDeletesRetentionLeasePeriod;
        @Nullable
        private IndexSegmentSort sort;
        @Nullable
        private IndexSettingsStore store;
        @Nullable
        private Integer topMetricsMaxSize;
        @Nullable
        private Translog translog;
        @Nullable
        private TranslogDurability translogDurability;
        @Nullable
        private String translogFlushThresholdSize;
        @Nullable
        private String uuid;
        @Nullable
        private Boolean verifiedBeforeClose;
        @Nullable
        private IndexVersioning version;

        public Builder() {}

        private Builder(IndexSettings o) {
            this.analysis = o.analysis;
            this.analyze = o.analyze;
            this.analyzeMaxTokenCount = o.analyzeMaxTokenCount;
            this.autoExpandReplicas = o.autoExpandReplicas;
            this.blocks = o.blocks;
            this.blocksMetadata = o.blocksMetadata;
            this.blocksRead = o.blocksRead;
            this.blocksReadOnly = o.blocksReadOnly;
            this.blocksReadOnlyAllowDelete = o.blocksReadOnlyAllowDelete;
            this.blocksWrite = o.blocksWrite;
            this.checkOnStartup = o.checkOnStartup;
            this.codec = o.codec;
            this.compositeIndexStarTree = o.compositeIndexStarTree;
            this.creationDate = o.creationDate;
            this.creationDateString = o.creationDateString;
            this.customSettings = _mapCopy(o.customSettings);
            this.defaultPipeline = o.defaultPipeline;
            this.finalPipeline = o.finalPipeline;
            this.format = o.format;
            this.gcDeletes = o.gcDeletes;
            this.hidden = o.hidden;
            this.highlight = o.highlight;
            this.highlightMaxAnalyzedOffset = o.highlightMaxAnalyzedOffset;
            this.index = o.index;
            this.indexing = o.indexing;
            this.indexingPressure = o.indexingPressure;
            this.knn = o.knn;
            this.knnAlgoParamEfSearch = o.knnAlgoParamEfSearch;
            this.lifecycle = o.lifecycle;
            this.lifecycleName = o.lifecycleName;
            this.loadFixedBitsetFiltersEagerly = o.loadFixedBitsetFiltersEagerly;
            this.mapping = o.mapping;
            this.maxDocvalueFieldsSearch = o.maxDocvalueFieldsSearch;
            this.maxInnerResultWindow = o.maxInnerResultWindow;
            this.maxNgramDiff = o.maxNgramDiff;
            this.maxRefreshListeners = o.maxRefreshListeners;
            this.maxRegexLength = o.maxRegexLength;
            this.maxRescoreWindow = o.maxRescoreWindow;
            this.maxResultWindow = o.maxResultWindow;
            this.maxScriptFields = o.maxScriptFields;
            this.maxShingleDiff = o.maxShingleDiff;
            this.maxSlicesPerScroll = o.maxSlicesPerScroll;
            this.maxTermsCount = o.maxTermsCount;
            this.merge = o.merge;
            this.mergeSchedulerMaxThreadCount = o.mergeSchedulerMaxThreadCount;
            this.mode = o.mode;
            this.numberOfReplicas = o.numberOfReplicas;
            this.numberOfRoutingShards = o.numberOfRoutingShards;
            this.numberOfShards = o.numberOfShards;
            this.priority = o.priority;
            this.providedName = o.providedName;
            this.queries = o.queries;
            this.queryString = o.queryString;
            this.queryStringLenient = o.queryStringLenient;
            this.refreshInterval = o.refreshInterval;
            this.routing = o.routing;
            this.routingPartitionSize = o.routingPartitionSize;
            this.routingPath = _listCopy(o.routingPath);
            this.search = o.search;
            this.searchIdleAfter = o.searchIdleAfter;
            this.settings = o.settings;
            this.similarity = o.similarity;
            this.softDeletes = o.softDeletes;
            this.softDeletesRetentionLeasePeriod = o.softDeletesRetentionLeasePeriod;
            this.sort = o.sort;
            this.store = o.store;
            this.topMetricsMaxSize = o.topMetricsMaxSize;
            this.translog = o.translog;
            this.translogDurability = o.translogDurability;
            this.translogFlushThresholdSize = o.translogFlushThresholdSize;
            this.uuid = o.uuid;
            this.verifiedBeforeClose = o.verifiedBeforeClose;
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.analysis = o.analysis;
            this.analyze = o.analyze;
            this.analyzeMaxTokenCount = o.analyzeMaxTokenCount;
            this.autoExpandReplicas = o.autoExpandReplicas;
            this.blocks = o.blocks;
            this.blocksMetadata = o.blocksMetadata;
            this.blocksRead = o.blocksRead;
            this.blocksReadOnly = o.blocksReadOnly;
            this.blocksReadOnlyAllowDelete = o.blocksReadOnlyAllowDelete;
            this.blocksWrite = o.blocksWrite;
            this.checkOnStartup = o.checkOnStartup;
            this.codec = o.codec;
            this.compositeIndexStarTree = o.compositeIndexStarTree;
            this.creationDate = o.creationDate;
            this.creationDateString = o.creationDateString;
            this.customSettings = _mapCopy(o.customSettings);
            this.defaultPipeline = o.defaultPipeline;
            this.finalPipeline = o.finalPipeline;
            this.format = o.format;
            this.gcDeletes = o.gcDeletes;
            this.hidden = o.hidden;
            this.highlight = o.highlight;
            this.highlightMaxAnalyzedOffset = o.highlightMaxAnalyzedOffset;
            this.index = o.index;
            this.indexing = o.indexing;
            this.indexingPressure = o.indexingPressure;
            this.knn = o.knn;
            this.knnAlgoParamEfSearch = o.knnAlgoParamEfSearch;
            this.lifecycle = o.lifecycle;
            this.lifecycleName = o.lifecycleName;
            this.loadFixedBitsetFiltersEagerly = o.loadFixedBitsetFiltersEagerly;
            this.mapping = o.mapping;
            this.maxDocvalueFieldsSearch = o.maxDocvalueFieldsSearch;
            this.maxInnerResultWindow = o.maxInnerResultWindow;
            this.maxNgramDiff = o.maxNgramDiff;
            this.maxRefreshListeners = o.maxRefreshListeners;
            this.maxRegexLength = o.maxRegexLength;
            this.maxRescoreWindow = o.maxRescoreWindow;
            this.maxResultWindow = o.maxResultWindow;
            this.maxScriptFields = o.maxScriptFields;
            this.maxShingleDiff = o.maxShingleDiff;
            this.maxSlicesPerScroll = o.maxSlicesPerScroll;
            this.maxTermsCount = o.maxTermsCount;
            this.merge = o.merge;
            this.mergeSchedulerMaxThreadCount = o.mergeSchedulerMaxThreadCount;
            this.mode = o.mode;
            this.numberOfReplicas = o.numberOfReplicas;
            this.numberOfRoutingShards = o.numberOfRoutingShards;
            this.numberOfShards = o.numberOfShards;
            this.priority = o.priority;
            this.providedName = o.providedName;
            this.queries = o.queries;
            this.queryString = o.queryString;
            this.queryStringLenient = o.queryStringLenient;
            this.refreshInterval = o.refreshInterval;
            this.routing = o.routing;
            this.routingPartitionSize = o.routingPartitionSize;
            this.routingPath = _listCopy(o.routingPath);
            this.search = o.search;
            this.searchIdleAfter = o.searchIdleAfter;
            this.settings = o.settings;
            this.similarity = o.similarity;
            this.softDeletes = o.softDeletes;
            this.softDeletesRetentionLeasePeriod = o.softDeletesRetentionLeasePeriod;
            this.sort = o.sort;
            this.store = o.store;
            this.topMetricsMaxSize = o.topMetricsMaxSize;
            this.translog = o.translog;
            this.translogDurability = o.translogDurability;
            this.translogFlushThresholdSize = o.translogFlushThresholdSize;
            this.uuid = o.uuid;
            this.verifiedBeforeClose = o.verifiedBeforeClose;
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code analysis}
         */
        @Nonnull
        public final Builder analysis(@Nullable IndexSettingsAnalysis value) {
            this.analysis = value;
            return this;
        }

        /**
         * API name: {@code analysis}
         */
        @Nonnull
        public final Builder analysis(Function<IndexSettingsAnalysis.Builder, ObjectBuilder<IndexSettingsAnalysis>> fn) {
            return analysis(fn.apply(new IndexSettingsAnalysis.Builder()).build());
        }

        /**
         * API name: {@code analyze}
         */
        @Nonnull
        public final Builder analyze(@Nullable IndexSettingsAnalyze value) {
            this.analyze = value;
            return this;
        }

        /**
         * API name: {@code analyze}
         */
        @Nonnull
        public final Builder analyze(Function<IndexSettingsAnalyze.Builder, ObjectBuilder<IndexSettingsAnalyze>> fn) {
            return analyze(fn.apply(new IndexSettingsAnalyze.Builder()).build());
        }

        /**
         * API name: {@code analyze.max_token_count}
         */
        @Nonnull
        public final Builder analyzeMaxTokenCount(@Nullable Integer value) {
            this.analyzeMaxTokenCount = value;
            return this;
        }

        /**
         * The range of replicas to maintain.
         * <p>
         * API name: {@code auto_expand_replicas}
         * </p>
         */
        @Nonnull
        public final Builder autoExpandReplicas(@Nullable String value) {
            this.autoExpandReplicas = value;
            return this;
        }

        /**
         * API name: {@code blocks}
         */
        @Nonnull
        public final Builder blocks(@Nullable IndexSettingBlocks value) {
            this.blocks = value;
            return this;
        }

        /**
         * API name: {@code blocks}
         */
        @Nonnull
        public final Builder blocks(Function<IndexSettingBlocks.Builder, ObjectBuilder<IndexSettingBlocks>> fn) {
            return blocks(fn.apply(new IndexSettingBlocks.Builder()).build());
        }

        /**
         * API name: {@code blocks.metadata}
         */
        @Nonnull
        public final Builder blocksMetadata(@Nullable Boolean value) {
            this.blocksMetadata = value;
            return this;
        }

        /**
         * API name: {@code blocks.read}
         */
        @Nonnull
        public final Builder blocksRead(@Nullable Boolean value) {
            this.blocksRead = value;
            return this;
        }

        /**
         * API name: {@code blocks.read_only}
         */
        @Nonnull
        public final Builder blocksReadOnly(@Nullable Boolean value) {
            this.blocksReadOnly = value;
            return this;
        }

        /**
         * API name: {@code blocks.read_only_allow_delete}
         */
        @Nonnull
        public final Builder blocksReadOnlyAllowDelete(@Nullable Boolean value) {
            this.blocksReadOnlyAllowDelete = value;
            return this;
        }

        /**
         * API name: {@code blocks.write}
         */
        @Nonnull
        public final Builder blocksWrite(@Nullable Boolean value) {
            this.blocksWrite = value;
            return this;
        }

        /**
         * API name: {@code check_on_startup}
         */
        @Nonnull
        public final Builder checkOnStartup(@Nullable IndexCheckOnStartup value) {
            this.checkOnStartup = value;
            return this;
        }

        /**
         * The compression type for stored data.
         * <p>
         * API name: {@code codec}
         * </p>
         */
        @Nonnull
        public final Builder codec(@Nullable String value) {
            this.codec = value;
            return this;
        }

        /**
         * API name: {@code composite_index.star_tree}
         */
        @Nonnull
        public final Builder compositeIndexStarTree(@Nullable IndexSettingsStarTree value) {
            this.compositeIndexStarTree = value;
            return this;
        }

        /**
         * API name: {@code composite_index.star_tree}
         */
        @Nonnull
        public final Builder compositeIndexStarTree(Function<IndexSettingsStarTree.Builder, ObjectBuilder<IndexSettingsStarTree>> fn) {
            return compositeIndexStarTree(fn.apply(new IndexSettingsStarTree.Builder()).build());
        }

        /**
         * API name: {@code creation_date}
         */
        @Nonnull
        public final Builder creationDate(@Nullable Long value) {
            this.creationDate = value;
            return this;
        }

        /**
         * API name: {@code creation_date_string}
         */
        @Nonnull
        public final Builder creationDateString(@Nullable String value) {
            this.creationDateString = value;
            return this;
        }

        /**
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>customSettings</code>.
         * </p>
         */
        @Nonnull
        public final Builder customSettings(Map<String, JsonData> map) {
            this.customSettings = _mapPutAll(this.customSettings, map);
            return this;
        }

        /**
         *
         * <p>
         * Adds an entry to <code>customSettings</code>.
         * </p>
         */
        @Nonnull
        public final Builder customSettings(String key, JsonData value) {
            this.customSettings = _mapPut(this.customSettings, key, value);
            return this;
        }

        /**
         * API name: {@code default_pipeline}
         */
        @Nonnull
        public final Builder defaultPipeline(@Nullable String value) {
            this.defaultPipeline = value;
            return this;
        }

        /**
         * API name: {@code final_pipeline}
         */
        @Nonnull
        public final Builder finalPipeline(@Nullable String value) {
            this.finalPipeline = value;
            return this;
        }

        /**
         * API name: {@code format}
         */
        @Nonnull
        public final Builder format(@Nullable Integer value) {
            this.format = value;
            return this;
        }

        /**
         * API name: {@code gc_deletes}
         */
        @Nonnull
        public final Builder gcDeletes(@Nullable Time value) {
            this.gcDeletes = value;
            return this;
        }

        /**
         * API name: {@code gc_deletes}
         */
        @Nonnull
        public final Builder gcDeletes(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return gcDeletes(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code hidden}
         */
        @Nonnull
        public final Builder hidden(@Nullable Boolean value) {
            this.hidden = value;
            return this;
        }

        /**
         * API name: {@code highlight}
         */
        @Nonnull
        public final Builder highlight(@Nullable IndexSettingsHighlight value) {
            this.highlight = value;
            return this;
        }

        /**
         * API name: {@code highlight}
         */
        @Nonnull
        public final Builder highlight(Function<IndexSettingsHighlight.Builder, ObjectBuilder<IndexSettingsHighlight>> fn) {
            return highlight(fn.apply(new IndexSettingsHighlight.Builder()).build());
        }

        /**
         * API name: {@code highlight.max_analyzed_offset}
         */
        @Nonnull
        public final Builder highlightMaxAnalyzedOffset(@Nullable Integer value) {
            this.highlightMaxAnalyzedOffset = value;
            return this;
        }

        /**
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(@Nullable IndexSettings value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(Function<IndexSettings.Builder, ObjectBuilder<IndexSettings>> fn) {
            return index(fn.apply(new IndexSettings.Builder()).build());
        }

        /**
         * API name: {@code indexing}
         */
        @Nonnull
        public final Builder indexing(@Nullable IndexSettingsIndexing value) {
            this.indexing = value;
            return this;
        }

        /**
         * API name: {@code indexing}
         */
        @Nonnull
        public final Builder indexing(Function<IndexSettingsIndexing.Builder, ObjectBuilder<IndexSettingsIndexing>> fn) {
            return indexing(fn.apply(new IndexSettingsIndexing.Builder()).build());
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
         * API name: {@code knn}
         */
        @Nonnull
        public final Builder knn(@Nullable Boolean value) {
            this.knn = value;
            return this;
        }

        /**
         * API name: {@code knn.algo_param.ef_search}
         */
        @Nonnull
        public final Builder knnAlgoParamEfSearch(@Nullable Integer value) {
            this.knnAlgoParamEfSearch = value;
            return this;
        }

        /**
         * API name: {@code lifecycle}
         */
        @Nonnull
        public final Builder lifecycle(@Nullable IndexSettingsLifecycle value) {
            this.lifecycle = value;
            return this;
        }

        /**
         * API name: {@code lifecycle}
         */
        @Nonnull
        public final Builder lifecycle(Function<IndexSettingsLifecycle.Builder, ObjectBuilder<IndexSettingsLifecycle>> fn) {
            return lifecycle(fn.apply(new IndexSettingsLifecycle.Builder()).build());
        }

        /**
         * API name: {@code lifecycle.name}
         */
        @Nonnull
        public final Builder lifecycleName(@Nullable String value) {
            this.lifecycleName = value;
            return this;
        }

        /**
         * API name: {@code load_fixed_bitset_filters_eagerly}
         */
        @Nonnull
        public final Builder loadFixedBitsetFiltersEagerly(@Nullable Boolean value) {
            this.loadFixedBitsetFiltersEagerly = value;
            return this;
        }

        /**
         * API name: {@code mapping}
         */
        @Nonnull
        public final Builder mapping(@Nullable IndexSettingsMapping value) {
            this.mapping = value;
            return this;
        }

        /**
         * API name: {@code mapping}
         */
        @Nonnull
        public final Builder mapping(Function<IndexSettingsMapping.Builder, ObjectBuilder<IndexSettingsMapping>> fn) {
            return mapping(fn.apply(new IndexSettingsMapping.Builder()).build());
        }

        /**
         * API name: {@code max_docvalue_fields_search}
         */
        @Nonnull
        public final Builder maxDocvalueFieldsSearch(@Nullable Integer value) {
            this.maxDocvalueFieldsSearch = value;
            return this;
        }

        /**
         * API name: {@code max_inner_result_window}
         */
        @Nonnull
        public final Builder maxInnerResultWindow(@Nullable Integer value) {
            this.maxInnerResultWindow = value;
            return this;
        }

        /**
         * API name: {@code max_ngram_diff}
         */
        @Nonnull
        public final Builder maxNgramDiff(@Nullable Integer value) {
            this.maxNgramDiff = value;
            return this;
        }

        /**
         * API name: {@code max_refresh_listeners}
         */
        @Nonnull
        public final Builder maxRefreshListeners(@Nullable Integer value) {
            this.maxRefreshListeners = value;
            return this;
        }

        /**
         * API name: {@code max_regex_length}
         */
        @Nonnull
        public final Builder maxRegexLength(@Nullable Integer value) {
            this.maxRegexLength = value;
            return this;
        }

        /**
         * API name: {@code max_rescore_window}
         */
        @Nonnull
        public final Builder maxRescoreWindow(@Nullable Integer value) {
            this.maxRescoreWindow = value;
            return this;
        }

        /**
         * API name: {@code max_result_window}
         */
        @Nonnull
        public final Builder maxResultWindow(@Nullable Integer value) {
            this.maxResultWindow = value;
            return this;
        }

        /**
         * API name: {@code max_script_fields}
         */
        @Nonnull
        public final Builder maxScriptFields(@Nullable Integer value) {
            this.maxScriptFields = value;
            return this;
        }

        /**
         * API name: {@code max_shingle_diff}
         */
        @Nonnull
        public final Builder maxShingleDiff(@Nullable Integer value) {
            this.maxShingleDiff = value;
            return this;
        }

        /**
         * API name: {@code max_slices_per_scroll}
         */
        @Nonnull
        public final Builder maxSlicesPerScroll(@Nullable Integer value) {
            this.maxSlicesPerScroll = value;
            return this;
        }

        /**
         * API name: {@code max_terms_count}
         */
        @Nonnull
        public final Builder maxTermsCount(@Nullable Integer value) {
            this.maxTermsCount = value;
            return this;
        }

        /**
         * API name: {@code merge}
         */
        @Nonnull
        public final Builder merge(@Nullable IndexSettingsMerge value) {
            this.merge = value;
            return this;
        }

        /**
         * API name: {@code merge}
         */
        @Nonnull
        public final Builder merge(Function<IndexSettingsMerge.Builder, ObjectBuilder<IndexSettingsMerge>> fn) {
            return merge(fn.apply(new IndexSettingsMerge.Builder()).build());
        }

        /**
         * API name: {@code merge.scheduler.max_thread_count}
         */
        @Nonnull
        public final Builder mergeSchedulerMaxThreadCount(@Nullable Integer value) {
            this.mergeSchedulerMaxThreadCount = value;
            return this;
        }

        /**
         * API name: {@code mode}
         */
        @Nonnull
        public final Builder mode(@Nullable String value) {
            this.mode = value;
            return this;
        }

        /**
         * API name: {@code number_of_replicas}
         */
        @Nonnull
        public final Builder numberOfReplicas(@Nullable Integer value) {
            this.numberOfReplicas = value;
            return this;
        }

        /**
         * API name: {@code number_of_routing_shards}
         */
        @Nonnull
        public final Builder numberOfRoutingShards(@Nullable Integer value) {
            this.numberOfRoutingShards = value;
            return this;
        }

        /**
         * API name: {@code number_of_shards}
         */
        @Nonnull
        public final Builder numberOfShards(@Nullable Integer value) {
            this.numberOfShards = value;
            return this;
        }

        /**
         * API name: {@code priority}
         */
        @Nonnull
        public final Builder priority(@Nullable Integer value) {
            this.priority = value;
            return this;
        }

        /**
         * API name: {@code provided_name}
         */
        @Nonnull
        public final Builder providedName(@Nullable String value) {
            this.providedName = value;
            return this;
        }

        /**
         * API name: {@code queries}
         */
        @Nonnull
        public final Builder queries(@Nullable IndexSettingsQueries value) {
            this.queries = value;
            return this;
        }

        /**
         * API name: {@code queries}
         */
        @Nonnull
        public final Builder queries(Function<IndexSettingsQueries.Builder, ObjectBuilder<IndexSettingsQueries>> fn) {
            return queries(fn.apply(new IndexSettingsQueries.Builder()).build());
        }

        /**
         * API name: {@code query_string}
         */
        @Nonnull
        public final Builder queryString(@Nullable IndexSettingsQueryString value) {
            this.queryString = value;
            return this;
        }

        /**
         * API name: {@code query_string}
         */
        @Nonnull
        public final Builder queryString(Function<IndexSettingsQueryString.Builder, ObjectBuilder<IndexSettingsQueryString>> fn) {
            return queryString(fn.apply(new IndexSettingsQueryString.Builder()).build());
        }

        /**
         * API name: {@code query_string.lenient}
         */
        @Nonnull
        public final Builder queryStringLenient(@Nullable Boolean value) {
            this.queryStringLenient = value;
            return this;
        }

        /**
         * API name: {@code refresh_interval}
         */
        @Nonnull
        public final Builder refreshInterval(@Nullable Time value) {
            this.refreshInterval = value;
            return this;
        }

        /**
         * API name: {@code refresh_interval}
         */
        @Nonnull
        public final Builder refreshInterval(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return refreshInterval(fn.apply(new Time.Builder()).build());
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
         * API name: {@code routing_partition_size}
         */
        @Nonnull
        public final Builder routingPartitionSize(@Nullable Integer value) {
            this.routingPartitionSize = value;
            return this;
        }

        /**
         * API name: {@code routing_path}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>routingPath</code>.
         * </p>
         */
        @Nonnull
        public final Builder routingPath(List<String> list) {
            this.routingPath = _listAddAll(this.routingPath, list);
            return this;
        }

        /**
         * API name: {@code routing_path}
         *
         * <p>
         * Adds one or more values to <code>routingPath</code>.
         * </p>
         */
        @Nonnull
        public final Builder routingPath(String value, String... values) {
            this.routingPath = _listAdd(this.routingPath, value, values);
            return this;
        }

        /**
         * API name: {@code search}
         */
        @Nonnull
        public final Builder search(@Nullable IndexSettingsSearch value) {
            this.search = value;
            return this;
        }

        /**
         * API name: {@code search}
         */
        @Nonnull
        public final Builder search(Function<IndexSettingsSearch.Builder, ObjectBuilder<IndexSettingsSearch>> fn) {
            return search(fn.apply(new IndexSettingsSearch.Builder()).build());
        }

        /**
         * API name: {@code search.idle.after}
         */
        @Nonnull
        public final Builder searchIdleAfter(@Nullable Time value) {
            this.searchIdleAfter = value;
            return this;
        }

        /**
         * API name: {@code search.idle.after}
         */
        @Nonnull
        public final Builder searchIdleAfter(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return searchIdleAfter(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code settings}
         */
        @Nonnull
        public final Builder settings(@Nullable IndexSettings value) {
            this.settings = value;
            return this;
        }

        /**
         * API name: {@code settings}
         */
        @Nonnull
        public final Builder settings(Function<IndexSettings.Builder, ObjectBuilder<IndexSettings>> fn) {
            return settings(fn.apply(new IndexSettings.Builder()).build());
        }

        /**
         * API name: {@code similarity}
         */
        @Nonnull
        public final Builder similarity(@Nullable IndexSettingsSimilarity value) {
            this.similarity = value;
            return this;
        }

        /**
         * API name: {@code similarity}
         */
        @Nonnull
        public final Builder similarity(Function<IndexSettingsSimilarity.Builder, ObjectBuilder<IndexSettingsSimilarity>> fn) {
            return similarity(fn.apply(new IndexSettingsSimilarity.Builder()).build());
        }

        /**
         * API name: {@code soft_deletes}
         */
        @Nonnull
        public final Builder softDeletes(@Nullable SoftDeletes value) {
            this.softDeletes = value;
            return this;
        }

        /**
         * API name: {@code soft_deletes}
         */
        @Nonnull
        public final Builder softDeletes(Function<SoftDeletes.Builder, ObjectBuilder<SoftDeletes>> fn) {
            return softDeletes(fn.apply(new SoftDeletes.Builder()).build());
        }

        /**
         * API name: {@code soft_deletes.retention_lease.period}
         */
        @Nonnull
        public final Builder softDeletesRetentionLeasePeriod(@Nullable Time value) {
            this.softDeletesRetentionLeasePeriod = value;
            return this;
        }

        /**
         * API name: {@code soft_deletes.retention_lease.period}
         */
        @Nonnull
        public final Builder softDeletesRetentionLeasePeriod(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return softDeletesRetentionLeasePeriod(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code sort}
         */
        @Nonnull
        public final Builder sort(@Nullable IndexSegmentSort value) {
            this.sort = value;
            return this;
        }

        /**
         * API name: {@code sort}
         */
        @Nonnull
        public final Builder sort(Function<IndexSegmentSort.Builder, ObjectBuilder<IndexSegmentSort>> fn) {
            return sort(fn.apply(new IndexSegmentSort.Builder()).build());
        }

        /**
         * API name: {@code store}
         */
        @Nonnull
        public final Builder store(@Nullable IndexSettingsStore value) {
            this.store = value;
            return this;
        }

        /**
         * API name: {@code store}
         */
        @Nonnull
        public final Builder store(Function<IndexSettingsStore.Builder, ObjectBuilder<IndexSettingsStore>> fn) {
            return store(fn.apply(new IndexSettingsStore.Builder()).build());
        }

        /**
         * API name: {@code top_metrics_max_size}
         */
        @Nonnull
        public final Builder topMetricsMaxSize(@Nullable Integer value) {
            this.topMetricsMaxSize = value;
            return this;
        }

        /**
         * API name: {@code translog}
         */
        @Nonnull
        public final Builder translog(@Nullable Translog value) {
            this.translog = value;
            return this;
        }

        /**
         * API name: {@code translog}
         */
        @Nonnull
        public final Builder translog(Function<Translog.Builder, ObjectBuilder<Translog>> fn) {
            return translog(fn.apply(new Translog.Builder()).build());
        }

        /**
         * API name: {@code translog.durability}
         */
        @Nonnull
        public final Builder translogDurability(@Nullable TranslogDurability value) {
            this.translogDurability = value;
            return this;
        }

        /**
         * API name: {@code translog.flush_threshold_size}
         */
        @Nonnull
        public final Builder translogFlushThresholdSize(@Nullable String value) {
            this.translogFlushThresholdSize = value;
            return this;
        }

        /**
         * API name: {@code uuid}
         */
        @Nonnull
        public final Builder uuid(@Nullable String value) {
            this.uuid = value;
            return this;
        }

        /**
         * API name: {@code verified_before_close}
         */
        @Nonnull
        public final Builder verifiedBeforeClose(@Nullable Boolean value) {
            this.verifiedBeforeClose = value;
            return this;
        }

        /**
         * API name: {@code version}
         */
        @Nonnull
        public final Builder version(@Nullable IndexVersioning value) {
            this.version = value;
            return this;
        }

        /**
         * API name: {@code version}
         */
        @Nonnull
        public final Builder version(Function<IndexVersioning.Builder, ObjectBuilder<IndexVersioning>> fn) {
            return version(fn.apply(new IndexVersioning.Builder()).build());
        }

        /**
         * Builds a {@link IndexSettings}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettings build() {
            _checkSingleUse();

            return new IndexSettings(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettings}
     */
    public static final JsonpDeserializer<IndexSettings> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettings::setupIndexSettingsDeserializer
    );

    protected static void setupIndexSettingsDeserializer(ObjectDeserializer<IndexSettings.Builder> op) {
        op.add(Builder::analysis, IndexSettingsAnalysis._DESERIALIZER, "analysis", "index.analysis");
        op.add(Builder::analyze, IndexSettingsAnalyze._DESERIALIZER, "analyze", "index.analyze");
        op.add(
            Builder::analyzeMaxTokenCount,
            JsonpDeserializer.integerDeserializer(),
            "analyze.max_token_count",
            "index.analyze.max_token_count"
        );
        op.add(Builder::autoExpandReplicas, JsonpDeserializer.stringDeserializer(), "auto_expand_replicas", "index.auto_expand_replicas");
        op.add(Builder::blocks, IndexSettingBlocks._DESERIALIZER, "blocks", "index.blocks");
        op.add(Builder::blocksMetadata, JsonpDeserializer.booleanDeserializer(), "blocks.metadata", "index.blocks.metadata");
        op.add(Builder::blocksRead, JsonpDeserializer.booleanDeserializer(), "blocks.read", "index.blocks.read");
        op.add(Builder::blocksReadOnly, JsonpDeserializer.booleanDeserializer(), "blocks.read_only", "index.blocks.read_only");
        op.add(
            Builder::blocksReadOnlyAllowDelete,
            JsonpDeserializer.booleanDeserializer(),
            "blocks.read_only_allow_delete",
            "index.blocks.read_only_allow_delete"
        );
        op.add(Builder::blocksWrite, JsonpDeserializer.booleanDeserializer(), "blocks.write", "index.blocks.write");
        op.add(Builder::checkOnStartup, IndexCheckOnStartup._DESERIALIZER, "check_on_startup", "index.check_on_startup");
        op.add(Builder::codec, JsonpDeserializer.stringDeserializer(), "codec", "index.codec");
        op.add(
            Builder::compositeIndexStarTree,
            IndexSettingsStarTree._DESERIALIZER,
            "composite_index.star_tree",
            "index.composite_index.star_tree"
        );
        op.add(Builder::creationDate, JsonpDeserializer.longDeserializer(), "creation_date", "index.creation_date");
        op.add(Builder::creationDateString, JsonpDeserializer.stringDeserializer(), "creation_date_string", "index.creation_date_string");
        op.add(Builder::defaultPipeline, JsonpDeserializer.stringDeserializer(), "default_pipeline", "index.default_pipeline");
        op.add(Builder::finalPipeline, JsonpDeserializer.stringDeserializer(), "final_pipeline", "index.final_pipeline");
        op.add(Builder::format, JsonpDeserializer.integerDeserializer(), "format", "index.format");
        op.add(Builder::gcDeletes, Time._DESERIALIZER, "gc_deletes", "index.gc_deletes");
        op.add(Builder::hidden, JsonpDeserializer.booleanDeserializer(), "hidden", "index.hidden");
        op.add(Builder::highlight, IndexSettingsHighlight._DESERIALIZER, "highlight", "index.highlight");
        op.add(
            Builder::highlightMaxAnalyzedOffset,
            JsonpDeserializer.integerDeserializer(),
            "highlight.max_analyzed_offset",
            "index.highlight.max_analyzed_offset"
        );
        op.add(Builder::index, IndexSettings._DESERIALIZER, "index");
        op.add(Builder::indexing, IndexSettingsIndexing._DESERIALIZER, "indexing");
        op.add(Builder::indexingPressure, IndexingPressure._DESERIALIZER, "indexing_pressure", "index.indexing_pressure");
        op.add(Builder::knn, JsonpDeserializer.booleanDeserializer(), "knn", "index.knn");
        op.add(
            Builder::knnAlgoParamEfSearch,
            JsonpDeserializer.integerDeserializer(),
            "knn.algo_param.ef_search",
            "index.knn.algo_param.ef_search"
        );
        op.add(Builder::lifecycle, IndexSettingsLifecycle._DESERIALIZER, "lifecycle", "index.lifecycle");
        op.add(Builder::lifecycleName, JsonpDeserializer.stringDeserializer(), "lifecycle.name", "index.lifecycle.name");
        op.add(
            Builder::loadFixedBitsetFiltersEagerly,
            JsonpDeserializer.booleanDeserializer(),
            "load_fixed_bitset_filters_eagerly",
            "index.load_fixed_bitset_filters_eagerly"
        );
        op.add(Builder::mapping, IndexSettingsMapping._DESERIALIZER, "mapping");
        op.add(
            Builder::maxDocvalueFieldsSearch,
            JsonpDeserializer.integerDeserializer(),
            "max_docvalue_fields_search",
            "index.max_docvalue_fields_search"
        );
        op.add(
            Builder::maxInnerResultWindow,
            JsonpDeserializer.integerDeserializer(),
            "max_inner_result_window",
            "index.max_inner_result_window"
        );
        op.add(Builder::maxNgramDiff, JsonpDeserializer.integerDeserializer(), "max_ngram_diff", "index.max_ngram_diff");
        op.add(
            Builder::maxRefreshListeners,
            JsonpDeserializer.integerDeserializer(),
            "max_refresh_listeners",
            "index.max_refresh_listeners"
        );
        op.add(Builder::maxRegexLength, JsonpDeserializer.integerDeserializer(), "max_regex_length", "index.max_regex_length");
        op.add(Builder::maxRescoreWindow, JsonpDeserializer.integerDeserializer(), "max_rescore_window", "index.max_rescore_window");
        op.add(Builder::maxResultWindow, JsonpDeserializer.integerDeserializer(), "max_result_window", "index.max_result_window");
        op.add(Builder::maxScriptFields, JsonpDeserializer.integerDeserializer(), "max_script_fields", "index.max_script_fields");
        op.add(Builder::maxShingleDiff, JsonpDeserializer.integerDeserializer(), "max_shingle_diff", "index.max_shingle_diff");
        op.add(
            Builder::maxSlicesPerScroll,
            JsonpDeserializer.integerDeserializer(),
            "max_slices_per_scroll",
            "index.max_slices_per_scroll"
        );
        op.add(Builder::maxTermsCount, JsonpDeserializer.integerDeserializer(), "max_terms_count", "index.max_terms_count");
        op.add(Builder::merge, IndexSettingsMerge._DESERIALIZER, "merge", "index.merge");
        op.add(
            Builder::mergeSchedulerMaxThreadCount,
            JsonpDeserializer.integerDeserializer(),
            "merge.scheduler.max_thread_count",
            "index.merge.scheduler.max_thread_count"
        );
        op.add(Builder::mode, JsonpDeserializer.stringDeserializer(), "mode", "index.mode");
        op.add(Builder::numberOfReplicas, JsonpDeserializer.integerDeserializer(), "number_of_replicas", "index.number_of_replicas");
        op.add(
            Builder::numberOfRoutingShards,
            JsonpDeserializer.integerDeserializer(),
            "number_of_routing_shards",
            "index.number_of_routing_shards"
        );
        op.add(Builder::numberOfShards, JsonpDeserializer.integerDeserializer(), "number_of_shards", "index.number_of_shards");
        op.add(Builder::priority, JsonpDeserializer.integerDeserializer(), "priority", "index.priority");
        op.add(Builder::providedName, JsonpDeserializer.stringDeserializer(), "provided_name", "index.provided_name");
        op.add(Builder::queries, IndexSettingsQueries._DESERIALIZER, "queries", "index.queries");
        op.add(Builder::queryString, IndexSettingsQueryString._DESERIALIZER, "query_string", "index.query_string");
        op.add(Builder::queryStringLenient, JsonpDeserializer.booleanDeserializer(), "query_string.lenient", "index.query_string.lenient");
        op.add(Builder::refreshInterval, Time._DESERIALIZER, "refresh_interval", "index.refresh_interval");
        op.add(Builder::routing, IndexRouting._DESERIALIZER, "routing", "index.routing");
        op.add(
            Builder::routingPartitionSize,
            JsonpDeserializer.integerDeserializer(),
            "routing_partition_size",
            "index.routing_partition_size"
        );
        op.add(
            Builder::routingPath,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "routing_path",
            "index.routing_path"
        );
        op.add(Builder::search, IndexSettingsSearch._DESERIALIZER, "search");
        op.add(Builder::searchIdleAfter, Time._DESERIALIZER, "search.idle.after", "index.search.idle.after");
        op.add(Builder::settings, IndexSettings._DESERIALIZER, "settings");
        op.add(Builder::similarity, IndexSettingsSimilarity._DESERIALIZER, "similarity", "index.similarity");
        op.add(Builder::softDeletes, SoftDeletes._DESERIALIZER, "soft_deletes", "index.soft_deletes");
        op.add(
            Builder::softDeletesRetentionLeasePeriod,
            Time._DESERIALIZER,
            "soft_deletes.retention_lease.period",
            "index.soft_deletes.retention_lease.period"
        );
        op.add(Builder::sort, IndexSegmentSort._DESERIALIZER, "sort", "index.sort");
        op.add(Builder::store, IndexSettingsStore._DESERIALIZER, "store", "index.store");
        op.add(Builder::topMetricsMaxSize, JsonpDeserializer.integerDeserializer(), "top_metrics_max_size");
        op.add(Builder::translog, Translog._DESERIALIZER, "translog", "index.translog");
        op.add(Builder::translogDurability, TranslogDurability._DESERIALIZER, "translog.durability", "index.translog.durability");
        op.add(
            Builder::translogFlushThresholdSize,
            JsonpDeserializer.stringDeserializer(),
            "translog.flush_threshold_size",
            "index.translog.flush_threshold_size"
        );
        op.add(Builder::uuid, JsonpDeserializer.stringDeserializer(), "uuid", "index.uuid");
        op.add(
            Builder::verifiedBeforeClose,
            JsonpDeserializer.booleanDeserializer(),
            "verified_before_close",
            "index.verified_before_close"
        );
        op.add(Builder::version, IndexVersioning._DESERIALIZER, "version", "index.version");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            if (builder.customSettings == null) {
                builder.customSettings = new HashMap<>();
            }
            builder.customSettings.put(name, JsonData._DESERIALIZER.deserialize(parser, mapper));
        });
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.analysis);
        result = 31 * result + Objects.hashCode(this.analyze);
        result = 31 * result + Objects.hashCode(this.analyzeMaxTokenCount);
        result = 31 * result + Objects.hashCode(this.autoExpandReplicas);
        result = 31 * result + Objects.hashCode(this.blocks);
        result = 31 * result + Objects.hashCode(this.blocksMetadata);
        result = 31 * result + Objects.hashCode(this.blocksRead);
        result = 31 * result + Objects.hashCode(this.blocksReadOnly);
        result = 31 * result + Objects.hashCode(this.blocksReadOnlyAllowDelete);
        result = 31 * result + Objects.hashCode(this.blocksWrite);
        result = 31 * result + Objects.hashCode(this.checkOnStartup);
        result = 31 * result + Objects.hashCode(this.codec);
        result = 31 * result + Objects.hashCode(this.compositeIndexStarTree);
        result = 31 * result + Objects.hashCode(this.creationDate);
        result = 31 * result + Objects.hashCode(this.creationDateString);
        result = 31 * result + Objects.hashCode(this.customSettings);
        result = 31 * result + Objects.hashCode(this.defaultPipeline);
        result = 31 * result + Objects.hashCode(this.finalPipeline);
        result = 31 * result + Objects.hashCode(this.format);
        result = 31 * result + Objects.hashCode(this.gcDeletes);
        result = 31 * result + Objects.hashCode(this.hidden);
        result = 31 * result + Objects.hashCode(this.highlight);
        result = 31 * result + Objects.hashCode(this.highlightMaxAnalyzedOffset);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.indexing);
        result = 31 * result + Objects.hashCode(this.indexingPressure);
        result = 31 * result + Objects.hashCode(this.knn);
        result = 31 * result + Objects.hashCode(this.knnAlgoParamEfSearch);
        result = 31 * result + Objects.hashCode(this.lifecycle);
        result = 31 * result + Objects.hashCode(this.lifecycleName);
        result = 31 * result + Objects.hashCode(this.loadFixedBitsetFiltersEagerly);
        result = 31 * result + Objects.hashCode(this.mapping);
        result = 31 * result + Objects.hashCode(this.maxDocvalueFieldsSearch);
        result = 31 * result + Objects.hashCode(this.maxInnerResultWindow);
        result = 31 * result + Objects.hashCode(this.maxNgramDiff);
        result = 31 * result + Objects.hashCode(this.maxRefreshListeners);
        result = 31 * result + Objects.hashCode(this.maxRegexLength);
        result = 31 * result + Objects.hashCode(this.maxRescoreWindow);
        result = 31 * result + Objects.hashCode(this.maxResultWindow);
        result = 31 * result + Objects.hashCode(this.maxScriptFields);
        result = 31 * result + Objects.hashCode(this.maxShingleDiff);
        result = 31 * result + Objects.hashCode(this.maxSlicesPerScroll);
        result = 31 * result + Objects.hashCode(this.maxTermsCount);
        result = 31 * result + Objects.hashCode(this.merge);
        result = 31 * result + Objects.hashCode(this.mergeSchedulerMaxThreadCount);
        result = 31 * result + Objects.hashCode(this.mode);
        result = 31 * result + Objects.hashCode(this.numberOfReplicas);
        result = 31 * result + Objects.hashCode(this.numberOfRoutingShards);
        result = 31 * result + Objects.hashCode(this.numberOfShards);
        result = 31 * result + Objects.hashCode(this.priority);
        result = 31 * result + Objects.hashCode(this.providedName);
        result = 31 * result + Objects.hashCode(this.queries);
        result = 31 * result + Objects.hashCode(this.queryString);
        result = 31 * result + Objects.hashCode(this.queryStringLenient);
        result = 31 * result + Objects.hashCode(this.refreshInterval);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.routingPartitionSize);
        result = 31 * result + Objects.hashCode(this.routingPath);
        result = 31 * result + Objects.hashCode(this.search);
        result = 31 * result + Objects.hashCode(this.searchIdleAfter);
        result = 31 * result + Objects.hashCode(this.settings);
        result = 31 * result + Objects.hashCode(this.similarity);
        result = 31 * result + Objects.hashCode(this.softDeletes);
        result = 31 * result + Objects.hashCode(this.softDeletesRetentionLeasePeriod);
        result = 31 * result + Objects.hashCode(this.sort);
        result = 31 * result + Objects.hashCode(this.store);
        result = 31 * result + Objects.hashCode(this.topMetricsMaxSize);
        result = 31 * result + Objects.hashCode(this.translog);
        result = 31 * result + Objects.hashCode(this.translogDurability);
        result = 31 * result + Objects.hashCode(this.translogFlushThresholdSize);
        result = 31 * result + Objects.hashCode(this.uuid);
        result = 31 * result + Objects.hashCode(this.verifiedBeforeClose);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettings other = (IndexSettings) o;
        return Objects.equals(this.analysis, other.analysis)
            && Objects.equals(this.analyze, other.analyze)
            && Objects.equals(this.analyzeMaxTokenCount, other.analyzeMaxTokenCount)
            && Objects.equals(this.autoExpandReplicas, other.autoExpandReplicas)
            && Objects.equals(this.blocks, other.blocks)
            && Objects.equals(this.blocksMetadata, other.blocksMetadata)
            && Objects.equals(this.blocksRead, other.blocksRead)
            && Objects.equals(this.blocksReadOnly, other.blocksReadOnly)
            && Objects.equals(this.blocksReadOnlyAllowDelete, other.blocksReadOnlyAllowDelete)
            && Objects.equals(this.blocksWrite, other.blocksWrite)
            && Objects.equals(this.checkOnStartup, other.checkOnStartup)
            && Objects.equals(this.codec, other.codec)
            && Objects.equals(this.compositeIndexStarTree, other.compositeIndexStarTree)
            && Objects.equals(this.creationDate, other.creationDate)
            && Objects.equals(this.creationDateString, other.creationDateString)
            && Objects.equals(this.customSettings, other.customSettings)
            && Objects.equals(this.defaultPipeline, other.defaultPipeline)
            && Objects.equals(this.finalPipeline, other.finalPipeline)
            && Objects.equals(this.format, other.format)
            && Objects.equals(this.gcDeletes, other.gcDeletes)
            && Objects.equals(this.hidden, other.hidden)
            && Objects.equals(this.highlight, other.highlight)
            && Objects.equals(this.highlightMaxAnalyzedOffset, other.highlightMaxAnalyzedOffset)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.indexing, other.indexing)
            && Objects.equals(this.indexingPressure, other.indexingPressure)
            && Objects.equals(this.knn, other.knn)
            && Objects.equals(this.knnAlgoParamEfSearch, other.knnAlgoParamEfSearch)
            && Objects.equals(this.lifecycle, other.lifecycle)
            && Objects.equals(this.lifecycleName, other.lifecycleName)
            && Objects.equals(this.loadFixedBitsetFiltersEagerly, other.loadFixedBitsetFiltersEagerly)
            && Objects.equals(this.mapping, other.mapping)
            && Objects.equals(this.maxDocvalueFieldsSearch, other.maxDocvalueFieldsSearch)
            && Objects.equals(this.maxInnerResultWindow, other.maxInnerResultWindow)
            && Objects.equals(this.maxNgramDiff, other.maxNgramDiff)
            && Objects.equals(this.maxRefreshListeners, other.maxRefreshListeners)
            && Objects.equals(this.maxRegexLength, other.maxRegexLength)
            && Objects.equals(this.maxRescoreWindow, other.maxRescoreWindow)
            && Objects.equals(this.maxResultWindow, other.maxResultWindow)
            && Objects.equals(this.maxScriptFields, other.maxScriptFields)
            && Objects.equals(this.maxShingleDiff, other.maxShingleDiff)
            && Objects.equals(this.maxSlicesPerScroll, other.maxSlicesPerScroll)
            && Objects.equals(this.maxTermsCount, other.maxTermsCount)
            && Objects.equals(this.merge, other.merge)
            && Objects.equals(this.mergeSchedulerMaxThreadCount, other.mergeSchedulerMaxThreadCount)
            && Objects.equals(this.mode, other.mode)
            && Objects.equals(this.numberOfReplicas, other.numberOfReplicas)
            && Objects.equals(this.numberOfRoutingShards, other.numberOfRoutingShards)
            && Objects.equals(this.numberOfShards, other.numberOfShards)
            && Objects.equals(this.priority, other.priority)
            && Objects.equals(this.providedName, other.providedName)
            && Objects.equals(this.queries, other.queries)
            && Objects.equals(this.queryString, other.queryString)
            && Objects.equals(this.queryStringLenient, other.queryStringLenient)
            && Objects.equals(this.refreshInterval, other.refreshInterval)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.routingPartitionSize, other.routingPartitionSize)
            && Objects.equals(this.routingPath, other.routingPath)
            && Objects.equals(this.search, other.search)
            && Objects.equals(this.searchIdleAfter, other.searchIdleAfter)
            && Objects.equals(this.settings, other.settings)
            && Objects.equals(this.similarity, other.similarity)
            && Objects.equals(this.softDeletes, other.softDeletes)
            && Objects.equals(this.softDeletesRetentionLeasePeriod, other.softDeletesRetentionLeasePeriod)
            && Objects.equals(this.sort, other.sort)
            && Objects.equals(this.store, other.store)
            && Objects.equals(this.topMetricsMaxSize, other.topMetricsMaxSize)
            && Objects.equals(this.translog, other.translog)
            && Objects.equals(this.translogDurability, other.translogDurability)
            && Objects.equals(this.translogFlushThresholdSize, other.translogFlushThresholdSize)
            && Objects.equals(this.uuid, other.uuid)
            && Objects.equals(this.verifiedBeforeClose, other.verifiedBeforeClose)
            && Objects.equals(this.version, other.version);
    }
}
