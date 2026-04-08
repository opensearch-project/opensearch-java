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

package org.opensearch.client.opensearch._types.aggregations;

import jakarta.json.stream.JsonGenerator;
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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.AggregationContainer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Aggregation extends AggregationBase implements ToCopyableBuilder<Aggregation.Builder, Aggregation> {

    @Nullable
    private final AdjacencyMatrixAggregationFields adjacencyMatrix;

    @Nullable
    private final JsonData aggregations;

    @Nullable
    private final JsonData aggs;

    @Nullable
    private final AutoDateHistogramAggregationFields autoDateHistogram;

    @Nullable
    private final AverageAggregation avg;

    @Nullable
    private final AverageBucketAggregation avgBucket;

    @Nullable
    private final BoxplotAggregation boxplot;

    @Nullable
    private final BucketScriptAggregation bucketScript;

    @Nullable
    private final BucketSelectorAggregation bucketSelector;

    @Nullable
    private final BucketSortAggregation bucketSort;

    @Nullable
    private final CardinalityAggregation cardinality;

    @Nullable
    private final ChildrenAggregationFields children;

    @Nullable
    private final CompositeAggregationFields composite;

    @Nullable
    private final CumulativeCardinalityAggregation cumulativeCardinality;

    @Nullable
    private final CumulativeSumAggregation cumulativeSum;

    @Nullable
    private final DateHistogramAggregationFields dateHistogram;

    @Nullable
    private final DateRangeAggregationFields dateRange;

    @Nullable
    private final DerivativeAggregation derivative;

    @Nullable
    private final DiversifiedSamplerAggregationFields diversifiedSampler;

    @Nullable
    private final ExtendedStatsAggregation extendedStats;

    @Nullable
    private final ExtendedStatsBucketAggregation extendedStatsBucket;

    @Nullable
    private final FilterAggregationFields filter;

    @Nullable
    private final FiltersAggregationFields filters;

    @Nullable
    private final GeoBoundsAggregation geoBounds;

    @Nullable
    private final GeoCentroidAggregation geoCentroid;

    @Nullable
    private final GeoDistanceAggregationFields geoDistance;

    @Nullable
    private final GeoHashGridAggregationFields geohashGrid;

    @Nullable
    private final GeoTileGridAggregationFields geotileGrid;

    @Nullable
    private final GlobalAggregationFields global;

    @Nullable
    private final HistogramAggregationFields histogram;

    @Nullable
    private final IpRangeAggregationFields ipRange;

    @Nullable
    private final MatrixStatsAggregation matrixStats;

    @Nullable
    private final MaxAggregation max;

    @Nullable
    private final MaxBucketAggregation maxBucket;

    @Nullable
    private final MedianAbsoluteDeviationAggregation medianAbsoluteDeviation;

    @Nullable
    private final MinAggregation min;

    @Nullable
    private final MinBucketAggregation minBucket;

    @Nullable
    private final MissingAggregationFields missing;

    @Nullable
    private final MovingAverageAggregation movingAvg;

    @Nullable
    private final MovingFunctionAggregation movingFn;

    @Nullable
    private final MovingPercentilesAggregation movingPercentiles;

    @Nullable
    private final MultiTermsAggregationFields multiTerms;

    @Nullable
    private final NestedAggregationFields nested;

    @Nullable
    private final NormalizeAggregation normalize;

    @Nullable
    private final ParentAggregationFields parent;

    @Nullable
    private final PercentileRanksAggregation percentileRanks;

    @Nullable
    private final PercentilesAggregation percentiles;

    @Nullable
    private final PercentilesBucketAggregation percentilesBucket;

    @Nullable
    private final RangeAggregationFields range;

    @Nullable
    private final RareTermsAggregationFields rareTerms;

    @Nullable
    private final RateAggregation rate;

    @Nullable
    private final ReverseNestedAggregationFields reverseNested;

    @Nullable
    private final SamplerAggregationFields sampler;

    @Nullable
    private final ScriptedMetricAggregation scriptedMetric;

    @Nullable
    private final SerialDifferencingAggregation serialDiff;

    @Nullable
    private final SignificantTermsAggregationFields significantTerms;

    @Nullable
    private final SignificantTextAggregationFields significantText;

    @Nullable
    private final StatsAggregation stats;

    @Nullable
    private final StatsBucketAggregation statsBucket;

    @Nullable
    private final SumAggregation sum;

    @Nullable
    private final SumBucketAggregation sumBucket;

    @Nullable
    private final TTestAggregation tTest;

    @Nullable
    private final TermsAggregationFields terms;

    @Nullable
    private final TopHitsAggregation topHits;

    @Nullable
    private final ValueCountAggregation valueCount;

    @Nullable
    private final VariableWidthHistogramAggregation variableWidthHistogram;

    @Nullable
    private final WeightedAverageAggregation weightedAvg;

    // ---------------------------------------------------------------------------------------------

    private Aggregation(Builder builder) {
        super(builder);
        this.adjacencyMatrix = builder.adjacencyMatrix;
        this.aggregations = builder.aggregations;
        this.aggs = builder.aggs;
        this.autoDateHistogram = builder.autoDateHistogram;
        this.avg = builder.avg;
        this.avgBucket = builder.avgBucket;
        this.boxplot = builder.boxplot;
        this.bucketScript = builder.bucketScript;
        this.bucketSelector = builder.bucketSelector;
        this.bucketSort = builder.bucketSort;
        this.cardinality = builder.cardinality;
        this.children = builder.children;
        this.composite = builder.composite;
        this.cumulativeCardinality = builder.cumulativeCardinality;
        this.cumulativeSum = builder.cumulativeSum;
        this.dateHistogram = builder.dateHistogram;
        this.dateRange = builder.dateRange;
        this.derivative = builder.derivative;
        this.diversifiedSampler = builder.diversifiedSampler;
        this.extendedStats = builder.extendedStats;
        this.extendedStatsBucket = builder.extendedStatsBucket;
        this.filter = builder.filter;
        this.filters = builder.filters;
        this.geoBounds = builder.geoBounds;
        this.geoCentroid = builder.geoCentroid;
        this.geoDistance = builder.geoDistance;
        this.geohashGrid = builder.geohashGrid;
        this.geotileGrid = builder.geotileGrid;
        this.global = builder.global;
        this.histogram = builder.histogram;
        this.ipRange = builder.ipRange;
        this.matrixStats = builder.matrixStats;
        this.max = builder.max;
        this.maxBucket = builder.maxBucket;
        this.medianAbsoluteDeviation = builder.medianAbsoluteDeviation;
        this.min = builder.min;
        this.minBucket = builder.minBucket;
        this.missing = builder.missing;
        this.movingAvg = builder.movingAvg;
        this.movingFn = builder.movingFn;
        this.movingPercentiles = builder.movingPercentiles;
        this.multiTerms = builder.multiTerms;
        this.nested = builder.nested;
        this.normalize = builder.normalize;
        this.parent = builder.parent;
        this.percentileRanks = builder.percentileRanks;
        this.percentiles = builder.percentiles;
        this.percentilesBucket = builder.percentilesBucket;
        this.range = builder.range;
        this.rareTerms = builder.rareTerms;
        this.rate = builder.rate;
        this.reverseNested = builder.reverseNested;
        this.sampler = builder.sampler;
        this.scriptedMetric = builder.scriptedMetric;
        this.serialDiff = builder.serialDiff;
        this.significantTerms = builder.significantTerms;
        this.significantText = builder.significantText;
        this.stats = builder.stats;
        this.statsBucket = builder.statsBucket;
        this.sum = builder.sum;
        this.sumBucket = builder.sumBucket;
        this.tTest = builder.tTest;
        this.terms = builder.terms;
        this.topHits = builder.topHits;
        this.valueCount = builder.valueCount;
        this.variableWidthHistogram = builder.variableWidthHistogram;
        this.weightedAvg = builder.weightedAvg;
    }

    public static Aggregation of(Function<Aggregation.Builder, ObjectBuilder<Aggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code adjacency_matrix}
     */
    @Nullable
    public final AdjacencyMatrixAggregationFields adjacencyMatrix() {
        return this.adjacencyMatrix;
    }

    /**
     * API name: {@code aggregations}
     */
    @Nullable
    public final JsonData aggregations() {
        return this.aggregations;
    }

    /**
     * API name: {@code aggs}
     */
    @Nullable
    public final JsonData aggs() {
        return this.aggs;
    }

    /**
     * API name: {@code auto_date_histogram}
     */
    @Nullable
    public final AutoDateHistogramAggregationFields autoDateHistogram() {
        return this.autoDateHistogram;
    }

    /**
     * API name: {@code avg}
     */
    @Nullable
    public final AverageAggregation avg() {
        return this.avg;
    }

    /**
     * API name: {@code avg_bucket}
     */
    @Nullable
    public final AverageBucketAggregation avgBucket() {
        return this.avgBucket;
    }

    /**
     * API name: {@code boxplot}
     */
    @Nullable
    public final BoxplotAggregation boxplot() {
        return this.boxplot;
    }

    /**
     * API name: {@code bucket_script}
     */
    @Nullable
    public final BucketScriptAggregation bucketScript() {
        return this.bucketScript;
    }

    /**
     * API name: {@code bucket_selector}
     */
    @Nullable
    public final BucketSelectorAggregation bucketSelector() {
        return this.bucketSelector;
    }

    /**
     * API name: {@code bucket_sort}
     */
    @Nullable
    public final BucketSortAggregation bucketSort() {
        return this.bucketSort;
    }

    /**
     * API name: {@code cardinality}
     */
    @Nullable
    public final CardinalityAggregation cardinality() {
        return this.cardinality;
    }

    /**
     * API name: {@code children}
     */
    @Nullable
    public final ChildrenAggregationFields children() {
        return this.children;
    }

    /**
     * API name: {@code composite}
     */
    @Nullable
    public final CompositeAggregationFields composite() {
        return this.composite;
    }

    /**
     * API name: {@code cumulative_cardinality}
     */
    @Nullable
    public final CumulativeCardinalityAggregation cumulativeCardinality() {
        return this.cumulativeCardinality;
    }

    /**
     * API name: {@code cumulative_sum}
     */
    @Nullable
    public final CumulativeSumAggregation cumulativeSum() {
        return this.cumulativeSum;
    }

    /**
     * API name: {@code date_histogram}
     */
    @Nullable
    public final DateHistogramAggregationFields dateHistogram() {
        return this.dateHistogram;
    }

    /**
     * API name: {@code date_range}
     */
    @Nullable
    public final DateRangeAggregationFields dateRange() {
        return this.dateRange;
    }

    /**
     * API name: {@code derivative}
     */
    @Nullable
    public final DerivativeAggregation derivative() {
        return this.derivative;
    }

    /**
     * API name: {@code diversified_sampler}
     */
    @Nullable
    public final DiversifiedSamplerAggregationFields diversifiedSampler() {
        return this.diversifiedSampler;
    }

    /**
     * API name: {@code extended_stats}
     */
    @Nullable
    public final ExtendedStatsAggregation extendedStats() {
        return this.extendedStats;
    }

    /**
     * API name: {@code extended_stats_bucket}
     */
    @Nullable
    public final ExtendedStatsBucketAggregation extendedStatsBucket() {
        return this.extendedStatsBucket;
    }

    /**
     * API name: {@code filter}
     */
    @Nullable
    public final FilterAggregationFields filter() {
        return this.filter;
    }

    /**
     * API name: {@code filters}
     */
    @Nullable
    public final FiltersAggregationFields filters() {
        return this.filters;
    }

    /**
     * API name: {@code geo_bounds}
     */
    @Nullable
    public final GeoBoundsAggregation geoBounds() {
        return this.geoBounds;
    }

    /**
     * API name: {@code geo_centroid}
     */
    @Nullable
    public final GeoCentroidAggregation geoCentroid() {
        return this.geoCentroid;
    }

    /**
     * API name: {@code geo_distance}
     */
    @Nullable
    public final GeoDistanceAggregationFields geoDistance() {
        return this.geoDistance;
    }

    /**
     * API name: {@code geohash_grid}
     */
    @Nullable
    public final GeoHashGridAggregationFields geohashGrid() {
        return this.geohashGrid;
    }

    /**
     * API name: {@code geotile_grid}
     */
    @Nullable
    public final GeoTileGridAggregationFields geotileGrid() {
        return this.geotileGrid;
    }

    /**
     * API name: {@code global}
     */
    @Nullable
    public final GlobalAggregationFields global() {
        return this.global;
    }

    /**
     * API name: {@code histogram}
     */
    @Nullable
    public final HistogramAggregationFields histogram() {
        return this.histogram;
    }

    /**
     * API name: {@code ip_range}
     */
    @Nullable
    public final IpRangeAggregationFields ipRange() {
        return this.ipRange;
    }

    /**
     * API name: {@code matrix_stats}
     */
    @Nullable
    public final MatrixStatsAggregation matrixStats() {
        return this.matrixStats;
    }

    /**
     * API name: {@code max}
     */
    @Nullable
    public final MaxAggregation max() {
        return this.max;
    }

    /**
     * API name: {@code max_bucket}
     */
    @Nullable
    public final MaxBucketAggregation maxBucket() {
        return this.maxBucket;
    }

    /**
     * API name: {@code median_absolute_deviation}
     */
    @Nullable
    public final MedianAbsoluteDeviationAggregation medianAbsoluteDeviation() {
        return this.medianAbsoluteDeviation;
    }

    /**
     * API name: {@code min}
     */
    @Nullable
    public final MinAggregation min() {
        return this.min;
    }

    /**
     * API name: {@code min_bucket}
     */
    @Nullable
    public final MinBucketAggregation minBucket() {
        return this.minBucket;
    }

    /**
     * API name: {@code missing}
     */
    @Nullable
    public final MissingAggregationFields missing() {
        return this.missing;
    }

    /**
     * API name: {@code moving_avg}
     */
    @Nullable
    public final MovingAverageAggregation movingAvg() {
        return this.movingAvg;
    }

    /**
     * API name: {@code moving_fn}
     */
    @Nullable
    public final MovingFunctionAggregation movingFn() {
        return this.movingFn;
    }

    /**
     * API name: {@code moving_percentiles}
     */
    @Nullable
    public final MovingPercentilesAggregation movingPercentiles() {
        return this.movingPercentiles;
    }

    /**
     * API name: {@code multi_terms}
     */
    @Nullable
    public final MultiTermsAggregationFields multiTerms() {
        return this.multiTerms;
    }

    /**
     * API name: {@code nested}
     */
    @Nullable
    public final NestedAggregationFields nested() {
        return this.nested;
    }

    /**
     * API name: {@code normalize}
     */
    @Nullable
    public final NormalizeAggregation normalize() {
        return this.normalize;
    }

    /**
     * API name: {@code parent}
     */
    @Nullable
    public final ParentAggregationFields parent() {
        return this.parent;
    }

    /**
     * API name: {@code percentile_ranks}
     */
    @Nullable
    public final PercentileRanksAggregation percentileRanks() {
        return this.percentileRanks;
    }

    /**
     * API name: {@code percentiles}
     */
    @Nullable
    public final PercentilesAggregation percentiles() {
        return this.percentiles;
    }

    /**
     * API name: {@code percentiles_bucket}
     */
    @Nullable
    public final PercentilesBucketAggregation percentilesBucket() {
        return this.percentilesBucket;
    }

    /**
     * API name: {@code range}
     */
    @Nullable
    public final RangeAggregationFields range() {
        return this.range;
    }

    /**
     * API name: {@code rare_terms}
     */
    @Nullable
    public final RareTermsAggregationFields rareTerms() {
        return this.rareTerms;
    }

    /**
     * API name: {@code rate}
     */
    @Nullable
    public final RateAggregation rate() {
        return this.rate;
    }

    /**
     * API name: {@code reverse_nested}
     */
    @Nullable
    public final ReverseNestedAggregationFields reverseNested() {
        return this.reverseNested;
    }

    /**
     * API name: {@code sampler}
     */
    @Nullable
    public final SamplerAggregationFields sampler() {
        return this.sampler;
    }

    /**
     * API name: {@code scripted_metric}
     */
    @Nullable
    public final ScriptedMetricAggregation scriptedMetric() {
        return this.scriptedMetric;
    }

    /**
     * API name: {@code serial_diff}
     */
    @Nullable
    public final SerialDifferencingAggregation serialDiff() {
        return this.serialDiff;
    }

    /**
     * API name: {@code significant_terms}
     */
    @Nullable
    public final SignificantTermsAggregationFields significantTerms() {
        return this.significantTerms;
    }

    /**
     * API name: {@code significant_text}
     */
    @Nullable
    public final SignificantTextAggregationFields significantText() {
        return this.significantText;
    }

    /**
     * API name: {@code stats}
     */
    @Nullable
    public final StatsAggregation stats() {
        return this.stats;
    }

    /**
     * API name: {@code stats_bucket}
     */
    @Nullable
    public final StatsBucketAggregation statsBucket() {
        return this.statsBucket;
    }

    /**
     * API name: {@code sum}
     */
    @Nullable
    public final SumAggregation sum() {
        return this.sum;
    }

    /**
     * API name: {@code sum_bucket}
     */
    @Nullable
    public final SumBucketAggregation sumBucket() {
        return this.sumBucket;
    }

    /**
     * API name: {@code t_test}
     */
    @Nullable
    public final TTestAggregation tTest() {
        return this.tTest;
    }

    /**
     * API name: {@code terms}
     */
    @Nullable
    public final TermsAggregationFields terms() {
        return this.terms;
    }

    /**
     * API name: {@code top_hits}
     */
    @Nullable
    public final TopHitsAggregation topHits() {
        return this.topHits;
    }

    /**
     * API name: {@code value_count}
     */
    @Nullable
    public final ValueCountAggregation valueCount() {
        return this.valueCount;
    }

    /**
     * API name: {@code variable_width_histogram}
     */
    @Nullable
    public final VariableWidthHistogramAggregation variableWidthHistogram() {
        return this.variableWidthHistogram;
    }

    /**
     * API name: {@code weighted_avg}
     */
    @Nullable
    public final WeightedAverageAggregation weightedAvg() {
        return this.weightedAvg;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.adjacencyMatrix != null) {
            generator.writeKey("adjacency_matrix");
            this.adjacencyMatrix.serialize(generator, mapper);
        }

        if (this.aggregations != null) {
            generator.writeKey("aggregations");
            this.aggregations.serialize(generator, mapper);
        }

        if (this.aggs != null) {
            generator.writeKey("aggs");
            this.aggs.serialize(generator, mapper);
        }

        if (this.autoDateHistogram != null) {
            generator.writeKey("auto_date_histogram");
            this.autoDateHistogram.serialize(generator, mapper);
        }

        if (this.avg != null) {
            generator.writeKey("avg");
            this.avg.serialize(generator, mapper);
        }

        if (this.avgBucket != null) {
            generator.writeKey("avg_bucket");
            this.avgBucket.serialize(generator, mapper);
        }

        if (this.boxplot != null) {
            generator.writeKey("boxplot");
            this.boxplot.serialize(generator, mapper);
        }

        if (this.bucketScript != null) {
            generator.writeKey("bucket_script");
            this.bucketScript.serialize(generator, mapper);
        }

        if (this.bucketSelector != null) {
            generator.writeKey("bucket_selector");
            this.bucketSelector.serialize(generator, mapper);
        }

        if (this.bucketSort != null) {
            generator.writeKey("bucket_sort");
            this.bucketSort.serialize(generator, mapper);
        }

        if (this.cardinality != null) {
            generator.writeKey("cardinality");
            this.cardinality.serialize(generator, mapper);
        }

        if (this.children != null) {
            generator.writeKey("children");
            this.children.serialize(generator, mapper);
        }

        if (this.composite != null) {
            generator.writeKey("composite");
            this.composite.serialize(generator, mapper);
        }

        if (this.cumulativeCardinality != null) {
            generator.writeKey("cumulative_cardinality");
            this.cumulativeCardinality.serialize(generator, mapper);
        }

        if (this.cumulativeSum != null) {
            generator.writeKey("cumulative_sum");
            this.cumulativeSum.serialize(generator, mapper);
        }

        if (this.dateHistogram != null) {
            generator.writeKey("date_histogram");
            this.dateHistogram.serialize(generator, mapper);
        }

        if (this.dateRange != null) {
            generator.writeKey("date_range");
            this.dateRange.serialize(generator, mapper);
        }

        if (this.derivative != null) {
            generator.writeKey("derivative");
            this.derivative.serialize(generator, mapper);
        }

        if (this.diversifiedSampler != null) {
            generator.writeKey("diversified_sampler");
            this.diversifiedSampler.serialize(generator, mapper);
        }

        if (this.extendedStats != null) {
            generator.writeKey("extended_stats");
            this.extendedStats.serialize(generator, mapper);
        }

        if (this.extendedStatsBucket != null) {
            generator.writeKey("extended_stats_bucket");
            this.extendedStatsBucket.serialize(generator, mapper);
        }

        if (this.filter != null) {
            generator.writeKey("filter");
            this.filter.serialize(generator, mapper);
        }

        if (this.filters != null) {
            generator.writeKey("filters");
            this.filters.serialize(generator, mapper);
        }

        if (this.geoBounds != null) {
            generator.writeKey("geo_bounds");
            this.geoBounds.serialize(generator, mapper);
        }

        if (this.geoCentroid != null) {
            generator.writeKey("geo_centroid");
            this.geoCentroid.serialize(generator, mapper);
        }

        if (this.geoDistance != null) {
            generator.writeKey("geo_distance");
            this.geoDistance.serialize(generator, mapper);
        }

        if (this.geohashGrid != null) {
            generator.writeKey("geohash_grid");
            this.geohashGrid.serialize(generator, mapper);
        }

        if (this.geotileGrid != null) {
            generator.writeKey("geotile_grid");
            this.geotileGrid.serialize(generator, mapper);
        }

        if (this.global != null) {
            generator.writeKey("global");
            this.global.serialize(generator, mapper);
        }

        if (this.histogram != null) {
            generator.writeKey("histogram");
            this.histogram.serialize(generator, mapper);
        }

        if (this.ipRange != null) {
            generator.writeKey("ip_range");
            this.ipRange.serialize(generator, mapper);
        }

        if (this.matrixStats != null) {
            generator.writeKey("matrix_stats");
            this.matrixStats.serialize(generator, mapper);
        }

        if (this.max != null) {
            generator.writeKey("max");
            this.max.serialize(generator, mapper);
        }

        if (this.maxBucket != null) {
            generator.writeKey("max_bucket");
            this.maxBucket.serialize(generator, mapper);
        }

        if (this.medianAbsoluteDeviation != null) {
            generator.writeKey("median_absolute_deviation");
            this.medianAbsoluteDeviation.serialize(generator, mapper);
        }

        if (this.min != null) {
            generator.writeKey("min");
            this.min.serialize(generator, mapper);
        }

        if (this.minBucket != null) {
            generator.writeKey("min_bucket");
            this.minBucket.serialize(generator, mapper);
        }

        if (this.missing != null) {
            generator.writeKey("missing");
            this.missing.serialize(generator, mapper);
        }

        if (this.movingAvg != null) {
            generator.writeKey("moving_avg");
            this.movingAvg.serialize(generator, mapper);
        }

        if (this.movingFn != null) {
            generator.writeKey("moving_fn");
            this.movingFn.serialize(generator, mapper);
        }

        if (this.movingPercentiles != null) {
            generator.writeKey("moving_percentiles");
            this.movingPercentiles.serialize(generator, mapper);
        }

        if (this.multiTerms != null) {
            generator.writeKey("multi_terms");
            this.multiTerms.serialize(generator, mapper);
        }

        if (this.nested != null) {
            generator.writeKey("nested");
            this.nested.serialize(generator, mapper);
        }

        if (this.normalize != null) {
            generator.writeKey("normalize");
            this.normalize.serialize(generator, mapper);
        }

        if (this.parent != null) {
            generator.writeKey("parent");
            this.parent.serialize(generator, mapper);
        }

        if (this.percentileRanks != null) {
            generator.writeKey("percentile_ranks");
            this.percentileRanks.serialize(generator, mapper);
        }

        if (this.percentiles != null) {
            generator.writeKey("percentiles");
            this.percentiles.serialize(generator, mapper);
        }

        if (this.percentilesBucket != null) {
            generator.writeKey("percentiles_bucket");
            this.percentilesBucket.serialize(generator, mapper);
        }

        if (this.range != null) {
            generator.writeKey("range");
            this.range.serialize(generator, mapper);
        }

        if (this.rareTerms != null) {
            generator.writeKey("rare_terms");
            this.rareTerms.serialize(generator, mapper);
        }

        if (this.rate != null) {
            generator.writeKey("rate");
            this.rate.serialize(generator, mapper);
        }

        if (this.reverseNested != null) {
            generator.writeKey("reverse_nested");
            this.reverseNested.serialize(generator, mapper);
        }

        if (this.sampler != null) {
            generator.writeKey("sampler");
            this.sampler.serialize(generator, mapper);
        }

        if (this.scriptedMetric != null) {
            generator.writeKey("scripted_metric");
            this.scriptedMetric.serialize(generator, mapper);
        }

        if (this.serialDiff != null) {
            generator.writeKey("serial_diff");
            this.serialDiff.serialize(generator, mapper);
        }

        if (this.significantTerms != null) {
            generator.writeKey("significant_terms");
            this.significantTerms.serialize(generator, mapper);
        }

        if (this.significantText != null) {
            generator.writeKey("significant_text");
            this.significantText.serialize(generator, mapper);
        }

        if (this.stats != null) {
            generator.writeKey("stats");
            this.stats.serialize(generator, mapper);
        }

        if (this.statsBucket != null) {
            generator.writeKey("stats_bucket");
            this.statsBucket.serialize(generator, mapper);
        }

        if (this.sum != null) {
            generator.writeKey("sum");
            this.sum.serialize(generator, mapper);
        }

        if (this.sumBucket != null) {
            generator.writeKey("sum_bucket");
            this.sumBucket.serialize(generator, mapper);
        }

        if (this.tTest != null) {
            generator.writeKey("t_test");
            this.tTest.serialize(generator, mapper);
        }

        if (this.terms != null) {
            generator.writeKey("terms");
            this.terms.serialize(generator, mapper);
        }

        if (this.topHits != null) {
            generator.writeKey("top_hits");
            this.topHits.serialize(generator, mapper);
        }

        if (this.valueCount != null) {
            generator.writeKey("value_count");
            this.valueCount.serialize(generator, mapper);
        }

        if (this.variableWidthHistogram != null) {
            generator.writeKey("variable_width_histogram");
            this.variableWidthHistogram.serialize(generator, mapper);
        }

        if (this.weightedAvg != null) {
            generator.writeKey("weighted_avg");
            this.weightedAvg.serialize(generator, mapper);
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
     * Builder for {@link Aggregation}.
     */
    public static class Builder extends AggregationBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, Aggregation> {
        @Nullable
        private AdjacencyMatrixAggregationFields adjacencyMatrix;
        @Nullable
        private JsonData aggregations;
        @Nullable
        private JsonData aggs;
        @Nullable
        private AutoDateHistogramAggregationFields autoDateHistogram;
        @Nullable
        private AverageAggregation avg;
        @Nullable
        private AverageBucketAggregation avgBucket;
        @Nullable
        private BoxplotAggregation boxplot;
        @Nullable
        private BucketScriptAggregation bucketScript;
        @Nullable
        private BucketSelectorAggregation bucketSelector;
        @Nullable
        private BucketSortAggregation bucketSort;
        @Nullable
        private CardinalityAggregation cardinality;
        @Nullable
        private ChildrenAggregationFields children;
        @Nullable
        private CompositeAggregationFields composite;
        @Nullable
        private CumulativeCardinalityAggregation cumulativeCardinality;
        @Nullable
        private CumulativeSumAggregation cumulativeSum;
        @Nullable
        private DateHistogramAggregationFields dateHistogram;
        @Nullable
        private DateRangeAggregationFields dateRange;
        @Nullable
        private DerivativeAggregation derivative;
        @Nullable
        private DiversifiedSamplerAggregationFields diversifiedSampler;
        @Nullable
        private ExtendedStatsAggregation extendedStats;
        @Nullable
        private ExtendedStatsBucketAggregation extendedStatsBucket;
        @Nullable
        private FilterAggregationFields filter;
        @Nullable
        private FiltersAggregationFields filters;
        @Nullable
        private GeoBoundsAggregation geoBounds;
        @Nullable
        private GeoCentroidAggregation geoCentroid;
        @Nullable
        private GeoDistanceAggregationFields geoDistance;
        @Nullable
        private GeoHashGridAggregationFields geohashGrid;
        @Nullable
        private GeoTileGridAggregationFields geotileGrid;
        @Nullable
        private GlobalAggregationFields global;
        @Nullable
        private HistogramAggregationFields histogram;
        @Nullable
        private IpRangeAggregationFields ipRange;
        @Nullable
        private MatrixStatsAggregation matrixStats;
        @Nullable
        private MaxAggregation max;
        @Nullable
        private MaxBucketAggregation maxBucket;
        @Nullable
        private MedianAbsoluteDeviationAggregation medianAbsoluteDeviation;
        @Nullable
        private MinAggregation min;
        @Nullable
        private MinBucketAggregation minBucket;
        @Nullable
        private MissingAggregationFields missing;
        @Nullable
        private MovingAverageAggregation movingAvg;
        @Nullable
        private MovingFunctionAggregation movingFn;
        @Nullable
        private MovingPercentilesAggregation movingPercentiles;
        @Nullable
        private MultiTermsAggregationFields multiTerms;
        @Nullable
        private NestedAggregationFields nested;
        @Nullable
        private NormalizeAggregation normalize;
        @Nullable
        private ParentAggregationFields parent;
        @Nullable
        private PercentileRanksAggregation percentileRanks;
        @Nullable
        private PercentilesAggregation percentiles;
        @Nullable
        private PercentilesBucketAggregation percentilesBucket;
        @Nullable
        private RangeAggregationFields range;
        @Nullable
        private RareTermsAggregationFields rareTerms;
        @Nullable
        private RateAggregation rate;
        @Nullable
        private ReverseNestedAggregationFields reverseNested;
        @Nullable
        private SamplerAggregationFields sampler;
        @Nullable
        private ScriptedMetricAggregation scriptedMetric;
        @Nullable
        private SerialDifferencingAggregation serialDiff;
        @Nullable
        private SignificantTermsAggregationFields significantTerms;
        @Nullable
        private SignificantTextAggregationFields significantText;
        @Nullable
        private StatsAggregation stats;
        @Nullable
        private StatsBucketAggregation statsBucket;
        @Nullable
        private SumAggregation sum;
        @Nullable
        private SumBucketAggregation sumBucket;
        @Nullable
        private TTestAggregation tTest;
        @Nullable
        private TermsAggregationFields terms;
        @Nullable
        private TopHitsAggregation topHits;
        @Nullable
        private ValueCountAggregation valueCount;
        @Nullable
        private VariableWidthHistogramAggregation variableWidthHistogram;
        @Nullable
        private WeightedAverageAggregation weightedAvg;

        public Builder() {}

        private Builder(Aggregation o) {
            super(o);
            this.adjacencyMatrix = o.adjacencyMatrix;
            this.aggregations = o.aggregations;
            this.aggs = o.aggs;
            this.autoDateHistogram = o.autoDateHistogram;
            this.avg = o.avg;
            this.avgBucket = o.avgBucket;
            this.boxplot = o.boxplot;
            this.bucketScript = o.bucketScript;
            this.bucketSelector = o.bucketSelector;
            this.bucketSort = o.bucketSort;
            this.cardinality = o.cardinality;
            this.children = o.children;
            this.composite = o.composite;
            this.cumulativeCardinality = o.cumulativeCardinality;
            this.cumulativeSum = o.cumulativeSum;
            this.dateHistogram = o.dateHistogram;
            this.dateRange = o.dateRange;
            this.derivative = o.derivative;
            this.diversifiedSampler = o.diversifiedSampler;
            this.extendedStats = o.extendedStats;
            this.extendedStatsBucket = o.extendedStatsBucket;
            this.filter = o.filter;
            this.filters = o.filters;
            this.geoBounds = o.geoBounds;
            this.geoCentroid = o.geoCentroid;
            this.geoDistance = o.geoDistance;
            this.geohashGrid = o.geohashGrid;
            this.geotileGrid = o.geotileGrid;
            this.global = o.global;
            this.histogram = o.histogram;
            this.ipRange = o.ipRange;
            this.matrixStats = o.matrixStats;
            this.max = o.max;
            this.maxBucket = o.maxBucket;
            this.medianAbsoluteDeviation = o.medianAbsoluteDeviation;
            this.min = o.min;
            this.minBucket = o.minBucket;
            this.missing = o.missing;
            this.movingAvg = o.movingAvg;
            this.movingFn = o.movingFn;
            this.movingPercentiles = o.movingPercentiles;
            this.multiTerms = o.multiTerms;
            this.nested = o.nested;
            this.normalize = o.normalize;
            this.parent = o.parent;
            this.percentileRanks = o.percentileRanks;
            this.percentiles = o.percentiles;
            this.percentilesBucket = o.percentilesBucket;
            this.range = o.range;
            this.rareTerms = o.rareTerms;
            this.rate = o.rate;
            this.reverseNested = o.reverseNested;
            this.sampler = o.sampler;
            this.scriptedMetric = o.scriptedMetric;
            this.serialDiff = o.serialDiff;
            this.significantTerms = o.significantTerms;
            this.significantText = o.significantText;
            this.stats = o.stats;
            this.statsBucket = o.statsBucket;
            this.sum = o.sum;
            this.sumBucket = o.sumBucket;
            this.tTest = o.tTest;
            this.terms = o.terms;
            this.topHits = o.topHits;
            this.valueCount = o.valueCount;
            this.variableWidthHistogram = o.variableWidthHistogram;
            this.weightedAvg = o.weightedAvg;
        }

        private Builder(Builder o) {
            super(o);
            this.adjacencyMatrix = o.adjacencyMatrix;
            this.aggregations = o.aggregations;
            this.aggs = o.aggs;
            this.autoDateHistogram = o.autoDateHistogram;
            this.avg = o.avg;
            this.avgBucket = o.avgBucket;
            this.boxplot = o.boxplot;
            this.bucketScript = o.bucketScript;
            this.bucketSelector = o.bucketSelector;
            this.bucketSort = o.bucketSort;
            this.cardinality = o.cardinality;
            this.children = o.children;
            this.composite = o.composite;
            this.cumulativeCardinality = o.cumulativeCardinality;
            this.cumulativeSum = o.cumulativeSum;
            this.dateHistogram = o.dateHistogram;
            this.dateRange = o.dateRange;
            this.derivative = o.derivative;
            this.diversifiedSampler = o.diversifiedSampler;
            this.extendedStats = o.extendedStats;
            this.extendedStatsBucket = o.extendedStatsBucket;
            this.filter = o.filter;
            this.filters = o.filters;
            this.geoBounds = o.geoBounds;
            this.geoCentroid = o.geoCentroid;
            this.geoDistance = o.geoDistance;
            this.geohashGrid = o.geohashGrid;
            this.geotileGrid = o.geotileGrid;
            this.global = o.global;
            this.histogram = o.histogram;
            this.ipRange = o.ipRange;
            this.matrixStats = o.matrixStats;
            this.max = o.max;
            this.maxBucket = o.maxBucket;
            this.medianAbsoluteDeviation = o.medianAbsoluteDeviation;
            this.min = o.min;
            this.minBucket = o.minBucket;
            this.missing = o.missing;
            this.movingAvg = o.movingAvg;
            this.movingFn = o.movingFn;
            this.movingPercentiles = o.movingPercentiles;
            this.multiTerms = o.multiTerms;
            this.nested = o.nested;
            this.normalize = o.normalize;
            this.parent = o.parent;
            this.percentileRanks = o.percentileRanks;
            this.percentiles = o.percentiles;
            this.percentilesBucket = o.percentilesBucket;
            this.range = o.range;
            this.rareTerms = o.rareTerms;
            this.rate = o.rate;
            this.reverseNested = o.reverseNested;
            this.sampler = o.sampler;
            this.scriptedMetric = o.scriptedMetric;
            this.serialDiff = o.serialDiff;
            this.significantTerms = o.significantTerms;
            this.significantText = o.significantText;
            this.stats = o.stats;
            this.statsBucket = o.statsBucket;
            this.sum = o.sum;
            this.sumBucket = o.sumBucket;
            this.tTest = o.tTest;
            this.terms = o.terms;
            this.topHits = o.topHits;
            this.valueCount = o.valueCount;
            this.variableWidthHistogram = o.variableWidthHistogram;
            this.weightedAvg = o.weightedAvg;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * API name: {@code adjacency_matrix}
         */
        @Nonnull
        public final Builder adjacencyMatrix(@Nullable AdjacencyMatrixAggregationFields value) {
            this.adjacencyMatrix = value;
            return this;
        }

        /**
         * API name: {@code adjacency_matrix}
         */
        @Nonnull
        public final Builder adjacencyMatrix(
            Function<AdjacencyMatrixAggregationFields.Builder, ObjectBuilder<AdjacencyMatrixAggregationFields>> fn
        ) {
            return adjacencyMatrix(fn.apply(new AdjacencyMatrixAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code aggregations}
         */
        @Nonnull
        public final Builder aggregations(@Nullable JsonData value) {
            this.aggregations = value;
            return this;
        }

        /**
         * API name: {@code aggs}
         */
        @Nonnull
        public final Builder aggs(@Nullable JsonData value) {
            this.aggs = value;
            return this;
        }

        /**
         * API name: {@code auto_date_histogram}
         */
        @Nonnull
        public final Builder autoDateHistogram(@Nullable AutoDateHistogramAggregationFields value) {
            this.autoDateHistogram = value;
            return this;
        }

        /**
         * API name: {@code auto_date_histogram}
         */
        @Nonnull
        public final Builder autoDateHistogram(
            Function<AutoDateHistogramAggregationFields.Builder, ObjectBuilder<AutoDateHistogramAggregationFields>> fn
        ) {
            return autoDateHistogram(fn.apply(new AutoDateHistogramAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code avg}
         */
        @Nonnull
        public final Builder avg(@Nullable AverageAggregation value) {
            this.avg = value;
            return this;
        }

        /**
         * API name: {@code avg}
         */
        @Nonnull
        public final Builder avg(Function<AverageAggregation.Builder, ObjectBuilder<AverageAggregation>> fn) {
            return avg(fn.apply(new AverageAggregation.Builder()).build());
        }

        /**
         * API name: {@code avg_bucket}
         */
        @Nonnull
        public final Builder avgBucket(@Nullable AverageBucketAggregation value) {
            this.avgBucket = value;
            return this;
        }

        /**
         * API name: {@code avg_bucket}
         */
        @Nonnull
        public final Builder avgBucket(Function<AverageBucketAggregation.Builder, ObjectBuilder<AverageBucketAggregation>> fn) {
            return avgBucket(fn.apply(new AverageBucketAggregation.Builder()).build());
        }

        /**
         * API name: {@code boxplot}
         */
        @Nonnull
        public final Builder boxplot(@Nullable BoxplotAggregation value) {
            this.boxplot = value;
            return this;
        }

        /**
         * API name: {@code boxplot}
         */
        @Nonnull
        public final Builder boxplot(Function<BoxplotAggregation.Builder, ObjectBuilder<BoxplotAggregation>> fn) {
            return boxplot(fn.apply(new BoxplotAggregation.Builder()).build());
        }

        /**
         * API name: {@code bucket_script}
         */
        @Nonnull
        public final Builder bucketScript(@Nullable BucketScriptAggregation value) {
            this.bucketScript = value;
            return this;
        }

        /**
         * API name: {@code bucket_script}
         */
        @Nonnull
        public final Builder bucketScript(Function<BucketScriptAggregation.Builder, ObjectBuilder<BucketScriptAggregation>> fn) {
            return bucketScript(fn.apply(new BucketScriptAggregation.Builder()).build());
        }

        /**
         * API name: {@code bucket_selector}
         */
        @Nonnull
        public final Builder bucketSelector(@Nullable BucketSelectorAggregation value) {
            this.bucketSelector = value;
            return this;
        }

        /**
         * API name: {@code bucket_selector}
         */
        @Nonnull
        public final Builder bucketSelector(Function<BucketSelectorAggregation.Builder, ObjectBuilder<BucketSelectorAggregation>> fn) {
            return bucketSelector(fn.apply(new BucketSelectorAggregation.Builder()).build());
        }

        /**
         * API name: {@code bucket_sort}
         */
        @Nonnull
        public final Builder bucketSort(@Nullable BucketSortAggregation value) {
            this.bucketSort = value;
            return this;
        }

        /**
         * API name: {@code bucket_sort}
         */
        @Nonnull
        public final Builder bucketSort(Function<BucketSortAggregation.Builder, ObjectBuilder<BucketSortAggregation>> fn) {
            return bucketSort(fn.apply(new BucketSortAggregation.Builder()).build());
        }

        /**
         * API name: {@code cardinality}
         */
        @Nonnull
        public final Builder cardinality(@Nullable CardinalityAggregation value) {
            this.cardinality = value;
            return this;
        }

        /**
         * API name: {@code cardinality}
         */
        @Nonnull
        public final Builder cardinality(Function<CardinalityAggregation.Builder, ObjectBuilder<CardinalityAggregation>> fn) {
            return cardinality(fn.apply(new CardinalityAggregation.Builder()).build());
        }

        /**
         * API name: {@code children}
         */
        @Nonnull
        public final Builder children(@Nullable ChildrenAggregationFields value) {
            this.children = value;
            return this;
        }

        /**
         * API name: {@code children}
         */
        @Nonnull
        public final Builder children(Function<ChildrenAggregationFields.Builder, ObjectBuilder<ChildrenAggregationFields>> fn) {
            return children(fn.apply(new ChildrenAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code composite}
         */
        @Nonnull
        public final Builder composite(@Nullable CompositeAggregationFields value) {
            this.composite = value;
            return this;
        }

        /**
         * API name: {@code composite}
         */
        @Nonnull
        public final Builder composite(Function<CompositeAggregationFields.Builder, ObjectBuilder<CompositeAggregationFields>> fn) {
            return composite(fn.apply(new CompositeAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code cumulative_cardinality}
         */
        @Nonnull
        public final Builder cumulativeCardinality(@Nullable CumulativeCardinalityAggregation value) {
            this.cumulativeCardinality = value;
            return this;
        }

        /**
         * API name: {@code cumulative_cardinality}
         */
        @Nonnull
        public final Builder cumulativeCardinality(
            Function<CumulativeCardinalityAggregation.Builder, ObjectBuilder<CumulativeCardinalityAggregation>> fn
        ) {
            return cumulativeCardinality(fn.apply(new CumulativeCardinalityAggregation.Builder()).build());
        }

        /**
         * API name: {@code cumulative_sum}
         */
        @Nonnull
        public final Builder cumulativeSum(@Nullable CumulativeSumAggregation value) {
            this.cumulativeSum = value;
            return this;
        }

        /**
         * API name: {@code cumulative_sum}
         */
        @Nonnull
        public final Builder cumulativeSum(Function<CumulativeSumAggregation.Builder, ObjectBuilder<CumulativeSumAggregation>> fn) {
            return cumulativeSum(fn.apply(new CumulativeSumAggregation.Builder()).build());
        }

        /**
         * API name: {@code date_histogram}
         */
        @Nonnull
        public final Builder dateHistogram(@Nullable DateHistogramAggregationFields value) {
            this.dateHistogram = value;
            return this;
        }

        /**
         * API name: {@code date_histogram}
         */
        @Nonnull
        public final Builder dateHistogram(
            Function<DateHistogramAggregationFields.Builder, ObjectBuilder<DateHistogramAggregationFields>> fn
        ) {
            return dateHistogram(fn.apply(new DateHistogramAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code date_range}
         */
        @Nonnull
        public final Builder dateRange(@Nullable DateRangeAggregationFields value) {
            this.dateRange = value;
            return this;
        }

        /**
         * API name: {@code date_range}
         */
        @Nonnull
        public final Builder dateRange(Function<DateRangeAggregationFields.Builder, ObjectBuilder<DateRangeAggregationFields>> fn) {
            return dateRange(fn.apply(new DateRangeAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code derivative}
         */
        @Nonnull
        public final Builder derivative(@Nullable DerivativeAggregation value) {
            this.derivative = value;
            return this;
        }

        /**
         * API name: {@code derivative}
         */
        @Nonnull
        public final Builder derivative(Function<DerivativeAggregation.Builder, ObjectBuilder<DerivativeAggregation>> fn) {
            return derivative(fn.apply(new DerivativeAggregation.Builder()).build());
        }

        /**
         * API name: {@code diversified_sampler}
         */
        @Nonnull
        public final Builder diversifiedSampler(@Nullable DiversifiedSamplerAggregationFields value) {
            this.diversifiedSampler = value;
            return this;
        }

        /**
         * API name: {@code diversified_sampler}
         */
        @Nonnull
        public final Builder diversifiedSampler(
            Function<DiversifiedSamplerAggregationFields.Builder, ObjectBuilder<DiversifiedSamplerAggregationFields>> fn
        ) {
            return diversifiedSampler(fn.apply(new DiversifiedSamplerAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code extended_stats}
         */
        @Nonnull
        public final Builder extendedStats(@Nullable ExtendedStatsAggregation value) {
            this.extendedStats = value;
            return this;
        }

        /**
         * API name: {@code extended_stats}
         */
        @Nonnull
        public final Builder extendedStats(Function<ExtendedStatsAggregation.Builder, ObjectBuilder<ExtendedStatsAggregation>> fn) {
            return extendedStats(fn.apply(new ExtendedStatsAggregation.Builder()).build());
        }

        /**
         * API name: {@code extended_stats_bucket}
         */
        @Nonnull
        public final Builder extendedStatsBucket(@Nullable ExtendedStatsBucketAggregation value) {
            this.extendedStatsBucket = value;
            return this;
        }

        /**
         * API name: {@code extended_stats_bucket}
         */
        @Nonnull
        public final Builder extendedStatsBucket(
            Function<ExtendedStatsBucketAggregation.Builder, ObjectBuilder<ExtendedStatsBucketAggregation>> fn
        ) {
            return extendedStatsBucket(fn.apply(new ExtendedStatsBucketAggregation.Builder()).build());
        }

        /**
         * API name: {@code filter}
         */
        @Nonnull
        public final Builder filter(@Nullable FilterAggregationFields value) {
            this.filter = value;
            return this;
        }

        /**
         * API name: {@code filter}
         */
        @Nonnull
        public final Builder filter(Function<FilterAggregationFields.Builder, ObjectBuilder<FilterAggregationFields>> fn) {
            return filter(fn.apply(new FilterAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code filters}
         */
        @Nonnull
        public final Builder filters(@Nullable FiltersAggregationFields value) {
            this.filters = value;
            return this;
        }

        /**
         * API name: {@code filters}
         */
        @Nonnull
        public final Builder filters(Function<FiltersAggregationFields.Builder, ObjectBuilder<FiltersAggregationFields>> fn) {
            return filters(fn.apply(new FiltersAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code geo_bounds}
         */
        @Nonnull
        public final Builder geoBounds(@Nullable GeoBoundsAggregation value) {
            this.geoBounds = value;
            return this;
        }

        /**
         * API name: {@code geo_bounds}
         */
        @Nonnull
        public final Builder geoBounds(Function<GeoBoundsAggregation.Builder, ObjectBuilder<GeoBoundsAggregation>> fn) {
            return geoBounds(fn.apply(new GeoBoundsAggregation.Builder()).build());
        }

        /**
         * API name: {@code geo_centroid}
         */
        @Nonnull
        public final Builder geoCentroid(@Nullable GeoCentroidAggregation value) {
            this.geoCentroid = value;
            return this;
        }

        /**
         * API name: {@code geo_centroid}
         */
        @Nonnull
        public final Builder geoCentroid(Function<GeoCentroidAggregation.Builder, ObjectBuilder<GeoCentroidAggregation>> fn) {
            return geoCentroid(fn.apply(new GeoCentroidAggregation.Builder()).build());
        }

        /**
         * API name: {@code geo_distance}
         */
        @Nonnull
        public final Builder geoDistance(@Nullable GeoDistanceAggregationFields value) {
            this.geoDistance = value;
            return this;
        }

        /**
         * API name: {@code geo_distance}
         */
        @Nonnull
        public final Builder geoDistance(Function<GeoDistanceAggregationFields.Builder, ObjectBuilder<GeoDistanceAggregationFields>> fn) {
            return geoDistance(fn.apply(new GeoDistanceAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code geohash_grid}
         */
        @Nonnull
        public final Builder geohashGrid(@Nullable GeoHashGridAggregationFields value) {
            this.geohashGrid = value;
            return this;
        }

        /**
         * API name: {@code geohash_grid}
         */
        @Nonnull
        public final Builder geohashGrid(Function<GeoHashGridAggregationFields.Builder, ObjectBuilder<GeoHashGridAggregationFields>> fn) {
            return geohashGrid(fn.apply(new GeoHashGridAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code geotile_grid}
         */
        @Nonnull
        public final Builder geotileGrid(@Nullable GeoTileGridAggregationFields value) {
            this.geotileGrid = value;
            return this;
        }

        /**
         * API name: {@code geotile_grid}
         */
        @Nonnull
        public final Builder geotileGrid(Function<GeoTileGridAggregationFields.Builder, ObjectBuilder<GeoTileGridAggregationFields>> fn) {
            return geotileGrid(fn.apply(new GeoTileGridAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code global}
         */
        @Nonnull
        public final Builder global(@Nullable GlobalAggregationFields value) {
            this.global = value;
            return this;
        }

        /**
         * API name: {@code global}
         */
        @Nonnull
        public final Builder global(Function<GlobalAggregationFields.Builder, ObjectBuilder<GlobalAggregationFields>> fn) {
            return global(fn.apply(new GlobalAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code histogram}
         */
        @Nonnull
        public final Builder histogram(@Nullable HistogramAggregationFields value) {
            this.histogram = value;
            return this;
        }

        /**
         * API name: {@code histogram}
         */
        @Nonnull
        public final Builder histogram(Function<HistogramAggregationFields.Builder, ObjectBuilder<HistogramAggregationFields>> fn) {
            return histogram(fn.apply(new HistogramAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code ip_range}
         */
        @Nonnull
        public final Builder ipRange(@Nullable IpRangeAggregationFields value) {
            this.ipRange = value;
            return this;
        }

        /**
         * API name: {@code ip_range}
         */
        @Nonnull
        public final Builder ipRange(Function<IpRangeAggregationFields.Builder, ObjectBuilder<IpRangeAggregationFields>> fn) {
            return ipRange(fn.apply(new IpRangeAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code matrix_stats}
         */
        @Nonnull
        public final Builder matrixStats(@Nullable MatrixStatsAggregation value) {
            this.matrixStats = value;
            return this;
        }

        /**
         * API name: {@code matrix_stats}
         */
        @Nonnull
        public final Builder matrixStats(Function<MatrixStatsAggregation.Builder, ObjectBuilder<MatrixStatsAggregation>> fn) {
            return matrixStats(fn.apply(new MatrixStatsAggregation.Builder()).build());
        }

        /**
         * API name: {@code max}
         */
        @Nonnull
        public final Builder max(@Nullable MaxAggregation value) {
            this.max = value;
            return this;
        }

        /**
         * API name: {@code max}
         */
        @Nonnull
        public final Builder max(Function<MaxAggregation.Builder, ObjectBuilder<MaxAggregation>> fn) {
            return max(fn.apply(new MaxAggregation.Builder()).build());
        }

        /**
         * API name: {@code max_bucket}
         */
        @Nonnull
        public final Builder maxBucket(@Nullable MaxBucketAggregation value) {
            this.maxBucket = value;
            return this;
        }

        /**
         * API name: {@code max_bucket}
         */
        @Nonnull
        public final Builder maxBucket(Function<MaxBucketAggregation.Builder, ObjectBuilder<MaxBucketAggregation>> fn) {
            return maxBucket(fn.apply(new MaxBucketAggregation.Builder()).build());
        }

        /**
         * API name: {@code median_absolute_deviation}
         */
        @Nonnull
        public final Builder medianAbsoluteDeviation(@Nullable MedianAbsoluteDeviationAggregation value) {
            this.medianAbsoluteDeviation = value;
            return this;
        }

        /**
         * API name: {@code median_absolute_deviation}
         */
        @Nonnull
        public final Builder medianAbsoluteDeviation(
            Function<MedianAbsoluteDeviationAggregation.Builder, ObjectBuilder<MedianAbsoluteDeviationAggregation>> fn
        ) {
            return medianAbsoluteDeviation(fn.apply(new MedianAbsoluteDeviationAggregation.Builder()).build());
        }

        /**
         * API name: {@code min}
         */
        @Nonnull
        public final Builder min(@Nullable MinAggregation value) {
            this.min = value;
            return this;
        }

        /**
         * API name: {@code min}
         */
        @Nonnull
        public final Builder min(Function<MinAggregation.Builder, ObjectBuilder<MinAggregation>> fn) {
            return min(fn.apply(new MinAggregation.Builder()).build());
        }

        /**
         * API name: {@code min_bucket}
         */
        @Nonnull
        public final Builder minBucket(@Nullable MinBucketAggregation value) {
            this.minBucket = value;
            return this;
        }

        /**
         * API name: {@code min_bucket}
         */
        @Nonnull
        public final Builder minBucket(Function<MinBucketAggregation.Builder, ObjectBuilder<MinBucketAggregation>> fn) {
            return minBucket(fn.apply(new MinBucketAggregation.Builder()).build());
        }

        /**
         * API name: {@code missing}
         */
        @Nonnull
        public final Builder missing(@Nullable MissingAggregationFields value) {
            this.missing = value;
            return this;
        }

        /**
         * API name: {@code missing}
         */
        @Nonnull
        public final Builder missing(Function<MissingAggregationFields.Builder, ObjectBuilder<MissingAggregationFields>> fn) {
            return missing(fn.apply(new MissingAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code moving_avg}
         */
        @Nonnull
        public final Builder movingAvg(@Nullable MovingAverageAggregation value) {
            this.movingAvg = value;
            return this;
        }

        /**
         * API name: {@code moving_avg}
         */
        @Nonnull
        public final Builder movingAvg(Function<MovingAverageAggregation.Builder, ObjectBuilder<MovingAverageAggregation>> fn) {
            return movingAvg(fn.apply(new MovingAverageAggregation.Builder()).build());
        }

        /**
         * API name: {@code moving_fn}
         */
        @Nonnull
        public final Builder movingFn(@Nullable MovingFunctionAggregation value) {
            this.movingFn = value;
            return this;
        }

        /**
         * API name: {@code moving_fn}
         */
        @Nonnull
        public final Builder movingFn(Function<MovingFunctionAggregation.Builder, ObjectBuilder<MovingFunctionAggregation>> fn) {
            return movingFn(fn.apply(new MovingFunctionAggregation.Builder()).build());
        }

        /**
         * API name: {@code moving_percentiles}
         */
        @Nonnull
        public final Builder movingPercentiles(@Nullable MovingPercentilesAggregation value) {
            this.movingPercentiles = value;
            return this;
        }

        /**
         * API name: {@code moving_percentiles}
         */
        @Nonnull
        public final Builder movingPercentiles(
            Function<MovingPercentilesAggregation.Builder, ObjectBuilder<MovingPercentilesAggregation>> fn
        ) {
            return movingPercentiles(fn.apply(new MovingPercentilesAggregation.Builder()).build());
        }

        /**
         * API name: {@code multi_terms}
         */
        @Nonnull
        public final Builder multiTerms(@Nullable MultiTermsAggregationFields value) {
            this.multiTerms = value;
            return this;
        }

        /**
         * API name: {@code multi_terms}
         */
        @Nonnull
        public final Builder multiTerms(Function<MultiTermsAggregationFields.Builder, ObjectBuilder<MultiTermsAggregationFields>> fn) {
            return multiTerms(fn.apply(new MultiTermsAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code nested}
         */
        @Nonnull
        public final Builder nested(@Nullable NestedAggregationFields value) {
            this.nested = value;
            return this;
        }

        /**
         * API name: {@code nested}
         */
        @Nonnull
        public final Builder nested(Function<NestedAggregationFields.Builder, ObjectBuilder<NestedAggregationFields>> fn) {
            return nested(fn.apply(new NestedAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code normalize}
         */
        @Nonnull
        public final Builder normalize(@Nullable NormalizeAggregation value) {
            this.normalize = value;
            return this;
        }

        /**
         * API name: {@code normalize}
         */
        @Nonnull
        public final Builder normalize(Function<NormalizeAggregation.Builder, ObjectBuilder<NormalizeAggregation>> fn) {
            return normalize(fn.apply(new NormalizeAggregation.Builder()).build());
        }

        /**
         * API name: {@code parent}
         */
        @Nonnull
        public final Builder parent(@Nullable ParentAggregationFields value) {
            this.parent = value;
            return this;
        }

        /**
         * API name: {@code parent}
         */
        @Nonnull
        public final Builder parent(Function<ParentAggregationFields.Builder, ObjectBuilder<ParentAggregationFields>> fn) {
            return parent(fn.apply(new ParentAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code percentile_ranks}
         */
        @Nonnull
        public final Builder percentileRanks(@Nullable PercentileRanksAggregation value) {
            this.percentileRanks = value;
            return this;
        }

        /**
         * API name: {@code percentile_ranks}
         */
        @Nonnull
        public final Builder percentileRanks(Function<PercentileRanksAggregation.Builder, ObjectBuilder<PercentileRanksAggregation>> fn) {
            return percentileRanks(fn.apply(new PercentileRanksAggregation.Builder()).build());
        }

        /**
         * API name: {@code percentiles}
         */
        @Nonnull
        public final Builder percentiles(@Nullable PercentilesAggregation value) {
            this.percentiles = value;
            return this;
        }

        /**
         * API name: {@code percentiles}
         */
        @Nonnull
        public final Builder percentiles(Function<PercentilesAggregation.Builder, ObjectBuilder<PercentilesAggregation>> fn) {
            return percentiles(fn.apply(new PercentilesAggregation.Builder()).build());
        }

        /**
         * API name: {@code percentiles_bucket}
         */
        @Nonnull
        public final Builder percentilesBucket(@Nullable PercentilesBucketAggregation value) {
            this.percentilesBucket = value;
            return this;
        }

        /**
         * API name: {@code percentiles_bucket}
         */
        @Nonnull
        public final Builder percentilesBucket(
            Function<PercentilesBucketAggregation.Builder, ObjectBuilder<PercentilesBucketAggregation>> fn
        ) {
            return percentilesBucket(fn.apply(new PercentilesBucketAggregation.Builder()).build());
        }

        /**
         * API name: {@code range}
         */
        @Nonnull
        public final Builder range(@Nullable RangeAggregationFields value) {
            this.range = value;
            return this;
        }

        /**
         * API name: {@code range}
         */
        @Nonnull
        public final Builder range(Function<RangeAggregationFields.Builder, ObjectBuilder<RangeAggregationFields>> fn) {
            return range(fn.apply(new RangeAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code rare_terms}
         */
        @Nonnull
        public final Builder rareTerms(@Nullable RareTermsAggregationFields value) {
            this.rareTerms = value;
            return this;
        }

        /**
         * API name: {@code rare_terms}
         */
        @Nonnull
        public final Builder rareTerms(Function<RareTermsAggregationFields.Builder, ObjectBuilder<RareTermsAggregationFields>> fn) {
            return rareTerms(fn.apply(new RareTermsAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code rate}
         */
        @Nonnull
        public final Builder rate(@Nullable RateAggregation value) {
            this.rate = value;
            return this;
        }

        /**
         * API name: {@code rate}
         */
        @Nonnull
        public final Builder rate(Function<RateAggregation.Builder, ObjectBuilder<RateAggregation>> fn) {
            return rate(fn.apply(new RateAggregation.Builder()).build());
        }

        /**
         * API name: {@code reverse_nested}
         */
        @Nonnull
        public final Builder reverseNested(@Nullable ReverseNestedAggregationFields value) {
            this.reverseNested = value;
            return this;
        }

        /**
         * API name: {@code reverse_nested}
         */
        @Nonnull
        public final Builder reverseNested(
            Function<ReverseNestedAggregationFields.Builder, ObjectBuilder<ReverseNestedAggregationFields>> fn
        ) {
            return reverseNested(fn.apply(new ReverseNestedAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code sampler}
         */
        @Nonnull
        public final Builder sampler(@Nullable SamplerAggregationFields value) {
            this.sampler = value;
            return this;
        }

        /**
         * API name: {@code sampler}
         */
        @Nonnull
        public final Builder sampler(Function<SamplerAggregationFields.Builder, ObjectBuilder<SamplerAggregationFields>> fn) {
            return sampler(fn.apply(new SamplerAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code scripted_metric}
         */
        @Nonnull
        public final Builder scriptedMetric(@Nullable ScriptedMetricAggregation value) {
            this.scriptedMetric = value;
            return this;
        }

        /**
         * API name: {@code scripted_metric}
         */
        @Nonnull
        public final Builder scriptedMetric(Function<ScriptedMetricAggregation.Builder, ObjectBuilder<ScriptedMetricAggregation>> fn) {
            return scriptedMetric(fn.apply(new ScriptedMetricAggregation.Builder()).build());
        }

        /**
         * API name: {@code serial_diff}
         */
        @Nonnull
        public final Builder serialDiff(@Nullable SerialDifferencingAggregation value) {
            this.serialDiff = value;
            return this;
        }

        /**
         * API name: {@code serial_diff}
         */
        @Nonnull
        public final Builder serialDiff(Function<SerialDifferencingAggregation.Builder, ObjectBuilder<SerialDifferencingAggregation>> fn) {
            return serialDiff(fn.apply(new SerialDifferencingAggregation.Builder()).build());
        }

        /**
         * API name: {@code significant_terms}
         */
        @Nonnull
        public final Builder significantTerms(@Nullable SignificantTermsAggregationFields value) {
            this.significantTerms = value;
            return this;
        }

        /**
         * API name: {@code significant_terms}
         */
        @Nonnull
        public final Builder significantTerms(
            Function<SignificantTermsAggregationFields.Builder, ObjectBuilder<SignificantTermsAggregationFields>> fn
        ) {
            return significantTerms(fn.apply(new SignificantTermsAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code significant_text}
         */
        @Nonnull
        public final Builder significantText(@Nullable SignificantTextAggregationFields value) {
            this.significantText = value;
            return this;
        }

        /**
         * API name: {@code significant_text}
         */
        @Nonnull
        public final Builder significantText(
            Function<SignificantTextAggregationFields.Builder, ObjectBuilder<SignificantTextAggregationFields>> fn
        ) {
            return significantText(fn.apply(new SignificantTextAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code stats}
         */
        @Nonnull
        public final Builder stats(@Nullable StatsAggregation value) {
            this.stats = value;
            return this;
        }

        /**
         * API name: {@code stats}
         */
        @Nonnull
        public final Builder stats(Function<StatsAggregation.Builder, ObjectBuilder<StatsAggregation>> fn) {
            return stats(fn.apply(new StatsAggregation.Builder()).build());
        }

        /**
         * API name: {@code stats_bucket}
         */
        @Nonnull
        public final Builder statsBucket(@Nullable StatsBucketAggregation value) {
            this.statsBucket = value;
            return this;
        }

        /**
         * API name: {@code stats_bucket}
         */
        @Nonnull
        public final Builder statsBucket(Function<StatsBucketAggregation.Builder, ObjectBuilder<StatsBucketAggregation>> fn) {
            return statsBucket(fn.apply(new StatsBucketAggregation.Builder()).build());
        }

        /**
         * API name: {@code sum}
         */
        @Nonnull
        public final Builder sum(@Nullable SumAggregation value) {
            this.sum = value;
            return this;
        }

        /**
         * API name: {@code sum}
         */
        @Nonnull
        public final Builder sum(Function<SumAggregation.Builder, ObjectBuilder<SumAggregation>> fn) {
            return sum(fn.apply(new SumAggregation.Builder()).build());
        }

        /**
         * API name: {@code sum_bucket}
         */
        @Nonnull
        public final Builder sumBucket(@Nullable SumBucketAggregation value) {
            this.sumBucket = value;
            return this;
        }

        /**
         * API name: {@code sum_bucket}
         */
        @Nonnull
        public final Builder sumBucket(Function<SumBucketAggregation.Builder, ObjectBuilder<SumBucketAggregation>> fn) {
            return sumBucket(fn.apply(new SumBucketAggregation.Builder()).build());
        }

        /**
         * API name: {@code t_test}
         */
        @Nonnull
        public final Builder tTest(@Nullable TTestAggregation value) {
            this.tTest = value;
            return this;
        }

        /**
         * API name: {@code t_test}
         */
        @Nonnull
        public final Builder tTest(Function<TTestAggregation.Builder, ObjectBuilder<TTestAggregation>> fn) {
            return tTest(fn.apply(new TTestAggregation.Builder()).build());
        }

        /**
         * API name: {@code terms}
         */
        @Nonnull
        public final Builder terms(@Nullable TermsAggregationFields value) {
            this.terms = value;
            return this;
        }

        /**
         * API name: {@code terms}
         */
        @Nonnull
        public final Builder terms(Function<TermsAggregationFields.Builder, ObjectBuilder<TermsAggregationFields>> fn) {
            return terms(fn.apply(new TermsAggregationFields.Builder()).build());
        }

        /**
         * API name: {@code top_hits}
         */
        @Nonnull
        public final Builder topHits(@Nullable TopHitsAggregation value) {
            this.topHits = value;
            return this;
        }

        /**
         * API name: {@code top_hits}
         */
        @Nonnull
        public final Builder topHits(Function<TopHitsAggregation.Builder, ObjectBuilder<TopHitsAggregation>> fn) {
            return topHits(fn.apply(new TopHitsAggregation.Builder()).build());
        }

        /**
         * API name: {@code value_count}
         */
        @Nonnull
        public final Builder valueCount(@Nullable ValueCountAggregation value) {
            this.valueCount = value;
            return this;
        }

        /**
         * API name: {@code value_count}
         */
        @Nonnull
        public final Builder valueCount(Function<ValueCountAggregation.Builder, ObjectBuilder<ValueCountAggregation>> fn) {
            return valueCount(fn.apply(new ValueCountAggregation.Builder()).build());
        }

        /**
         * API name: {@code variable_width_histogram}
         */
        @Nonnull
        public final Builder variableWidthHistogram(@Nullable VariableWidthHistogramAggregation value) {
            this.variableWidthHistogram = value;
            return this;
        }

        /**
         * API name: {@code variable_width_histogram}
         */
        @Nonnull
        public final Builder variableWidthHistogram(
            Function<VariableWidthHistogramAggregation.Builder, ObjectBuilder<VariableWidthHistogramAggregation>> fn
        ) {
            return variableWidthHistogram(fn.apply(new VariableWidthHistogramAggregation.Builder()).build());
        }

        /**
         * API name: {@code weighted_avg}
         */
        @Nonnull
        public final Builder weightedAvg(@Nullable WeightedAverageAggregation value) {
            this.weightedAvg = value;
            return this;
        }

        /**
         * API name: {@code weighted_avg}
         */
        @Nonnull
        public final Builder weightedAvg(Function<WeightedAverageAggregation.Builder, ObjectBuilder<WeightedAverageAggregation>> fn) {
            return weightedAvg(fn.apply(new WeightedAverageAggregation.Builder()).build());
        }

        /**
         * Builds a {@link Aggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Aggregation build() {
            _checkSingleUse();

            return new Aggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Aggregation}
     */
    public static final JsonpDeserializer<Aggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Aggregation::setupAggregationDeserializer
    );

    protected static void setupAggregationDeserializer(ObjectDeserializer<Aggregation.Builder> op) {
        setupAggregationBaseDeserializer(op);
        op.add(Builder::adjacencyMatrix, AdjacencyMatrixAggregationFields._DESERIALIZER, "adjacency_matrix");
        op.add(Builder::aggregations, JsonData._DESERIALIZER, "aggregations");
        op.add(Builder::aggs, JsonData._DESERIALIZER, "aggs");
        op.add(Builder::autoDateHistogram, AutoDateHistogramAggregationFields._DESERIALIZER, "auto_date_histogram");
        op.add(Builder::avg, AverageAggregation._DESERIALIZER, "avg");
        op.add(Builder::avgBucket, AverageBucketAggregation._DESERIALIZER, "avg_bucket");
        op.add(Builder::boxplot, BoxplotAggregation._DESERIALIZER, "boxplot");
        op.add(Builder::bucketScript, BucketScriptAggregation._DESERIALIZER, "bucket_script");
        op.add(Builder::bucketSelector, BucketSelectorAggregation._DESERIALIZER, "bucket_selector");
        op.add(Builder::bucketSort, BucketSortAggregation._DESERIALIZER, "bucket_sort");
        op.add(Builder::cardinality, CardinalityAggregation._DESERIALIZER, "cardinality");
        op.add(Builder::children, ChildrenAggregationFields._DESERIALIZER, "children");
        op.add(Builder::composite, CompositeAggregationFields._DESERIALIZER, "composite");
        op.add(Builder::cumulativeCardinality, CumulativeCardinalityAggregation._DESERIALIZER, "cumulative_cardinality");
        op.add(Builder::cumulativeSum, CumulativeSumAggregation._DESERIALIZER, "cumulative_sum");
        op.add(Builder::dateHistogram, DateHistogramAggregationFields._DESERIALIZER, "date_histogram");
        op.add(Builder::dateRange, DateRangeAggregationFields._DESERIALIZER, "date_range");
        op.add(Builder::derivative, DerivativeAggregation._DESERIALIZER, "derivative");
        op.add(Builder::diversifiedSampler, DiversifiedSamplerAggregationFields._DESERIALIZER, "diversified_sampler");
        op.add(Builder::extendedStats, ExtendedStatsAggregation._DESERIALIZER, "extended_stats");
        op.add(Builder::extendedStatsBucket, ExtendedStatsBucketAggregation._DESERIALIZER, "extended_stats_bucket");
        op.add(Builder::filter, FilterAggregationFields._DESERIALIZER, "filter");
        op.add(Builder::filters, FiltersAggregationFields._DESERIALIZER, "filters");
        op.add(Builder::geoBounds, GeoBoundsAggregation._DESERIALIZER, "geo_bounds");
        op.add(Builder::geoCentroid, GeoCentroidAggregation._DESERIALIZER, "geo_centroid");
        op.add(Builder::geoDistance, GeoDistanceAggregationFields._DESERIALIZER, "geo_distance");
        op.add(Builder::geohashGrid, GeoHashGridAggregationFields._DESERIALIZER, "geohash_grid");
        op.add(Builder::geotileGrid, GeoTileGridAggregationFields._DESERIALIZER, "geotile_grid");
        op.add(Builder::global, GlobalAggregationFields._DESERIALIZER, "global");
        op.add(Builder::histogram, HistogramAggregationFields._DESERIALIZER, "histogram");
        op.add(Builder::ipRange, IpRangeAggregationFields._DESERIALIZER, "ip_range");
        op.add(Builder::matrixStats, MatrixStatsAggregation._DESERIALIZER, "matrix_stats");
        op.add(Builder::max, MaxAggregation._DESERIALIZER, "max");
        op.add(Builder::maxBucket, MaxBucketAggregation._DESERIALIZER, "max_bucket");
        op.add(Builder::medianAbsoluteDeviation, MedianAbsoluteDeviationAggregation._DESERIALIZER, "median_absolute_deviation");
        op.add(Builder::min, MinAggregation._DESERIALIZER, "min");
        op.add(Builder::minBucket, MinBucketAggregation._DESERIALIZER, "min_bucket");
        op.add(Builder::missing, MissingAggregationFields._DESERIALIZER, "missing");
        op.add(Builder::movingAvg, MovingAverageAggregation._DESERIALIZER, "moving_avg");
        op.add(Builder::movingFn, MovingFunctionAggregation._DESERIALIZER, "moving_fn");
        op.add(Builder::movingPercentiles, MovingPercentilesAggregation._DESERIALIZER, "moving_percentiles");
        op.add(Builder::multiTerms, MultiTermsAggregationFields._DESERIALIZER, "multi_terms");
        op.add(Builder::nested, NestedAggregationFields._DESERIALIZER, "nested");
        op.add(Builder::normalize, NormalizeAggregation._DESERIALIZER, "normalize");
        op.add(Builder::parent, ParentAggregationFields._DESERIALIZER, "parent");
        op.add(Builder::percentileRanks, PercentileRanksAggregation._DESERIALIZER, "percentile_ranks");
        op.add(Builder::percentiles, PercentilesAggregation._DESERIALIZER, "percentiles");
        op.add(Builder::percentilesBucket, PercentilesBucketAggregation._DESERIALIZER, "percentiles_bucket");
        op.add(Builder::range, RangeAggregationFields._DESERIALIZER, "range");
        op.add(Builder::rareTerms, RareTermsAggregationFields._DESERIALIZER, "rare_terms");
        op.add(Builder::rate, RateAggregation._DESERIALIZER, "rate");
        op.add(Builder::reverseNested, ReverseNestedAggregationFields._DESERIALIZER, "reverse_nested");
        op.add(Builder::sampler, SamplerAggregationFields._DESERIALIZER, "sampler");
        op.add(Builder::scriptedMetric, ScriptedMetricAggregation._DESERIALIZER, "scripted_metric");
        op.add(Builder::serialDiff, SerialDifferencingAggregation._DESERIALIZER, "serial_diff");
        op.add(Builder::significantTerms, SignificantTermsAggregationFields._DESERIALIZER, "significant_terms");
        op.add(Builder::significantText, SignificantTextAggregationFields._DESERIALIZER, "significant_text");
        op.add(Builder::stats, StatsAggregation._DESERIALIZER, "stats");
        op.add(Builder::statsBucket, StatsBucketAggregation._DESERIALIZER, "stats_bucket");
        op.add(Builder::sum, SumAggregation._DESERIALIZER, "sum");
        op.add(Builder::sumBucket, SumBucketAggregation._DESERIALIZER, "sum_bucket");
        op.add(Builder::tTest, TTestAggregation._DESERIALIZER, "t_test");
        op.add(Builder::terms, TermsAggregationFields._DESERIALIZER, "terms");
        op.add(Builder::topHits, TopHitsAggregation._DESERIALIZER, "top_hits");
        op.add(Builder::valueCount, ValueCountAggregation._DESERIALIZER, "value_count");
        op.add(Builder::variableWidthHistogram, VariableWidthHistogramAggregation._DESERIALIZER, "variable_width_histogram");
        op.add(Builder::weightedAvg, WeightedAverageAggregation._DESERIALIZER, "weighted_avg");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.adjacencyMatrix);
        result = 31 * result + Objects.hashCode(this.aggregations);
        result = 31 * result + Objects.hashCode(this.aggs);
        result = 31 * result + Objects.hashCode(this.autoDateHistogram);
        result = 31 * result + Objects.hashCode(this.avg);
        result = 31 * result + Objects.hashCode(this.avgBucket);
        result = 31 * result + Objects.hashCode(this.boxplot);
        result = 31 * result + Objects.hashCode(this.bucketScript);
        result = 31 * result + Objects.hashCode(this.bucketSelector);
        result = 31 * result + Objects.hashCode(this.bucketSort);
        result = 31 * result + Objects.hashCode(this.cardinality);
        result = 31 * result + Objects.hashCode(this.children);
        result = 31 * result + Objects.hashCode(this.composite);
        result = 31 * result + Objects.hashCode(this.cumulativeCardinality);
        result = 31 * result + Objects.hashCode(this.cumulativeSum);
        result = 31 * result + Objects.hashCode(this.dateHistogram);
        result = 31 * result + Objects.hashCode(this.dateRange);
        result = 31 * result + Objects.hashCode(this.derivative);
        result = 31 * result + Objects.hashCode(this.diversifiedSampler);
        result = 31 * result + Objects.hashCode(this.extendedStats);
        result = 31 * result + Objects.hashCode(this.extendedStatsBucket);
        result = 31 * result + Objects.hashCode(this.filter);
        result = 31 * result + Objects.hashCode(this.filters);
        result = 31 * result + Objects.hashCode(this.geoBounds);
        result = 31 * result + Objects.hashCode(this.geoCentroid);
        result = 31 * result + Objects.hashCode(this.geoDistance);
        result = 31 * result + Objects.hashCode(this.geohashGrid);
        result = 31 * result + Objects.hashCode(this.geotileGrid);
        result = 31 * result + Objects.hashCode(this.global);
        result = 31 * result + Objects.hashCode(this.histogram);
        result = 31 * result + Objects.hashCode(this.ipRange);
        result = 31 * result + Objects.hashCode(this.matrixStats);
        result = 31 * result + Objects.hashCode(this.max);
        result = 31 * result + Objects.hashCode(this.maxBucket);
        result = 31 * result + Objects.hashCode(this.medianAbsoluteDeviation);
        result = 31 * result + Objects.hashCode(this.min);
        result = 31 * result + Objects.hashCode(this.minBucket);
        result = 31 * result + Objects.hashCode(this.missing);
        result = 31 * result + Objects.hashCode(this.movingAvg);
        result = 31 * result + Objects.hashCode(this.movingFn);
        result = 31 * result + Objects.hashCode(this.movingPercentiles);
        result = 31 * result + Objects.hashCode(this.multiTerms);
        result = 31 * result + Objects.hashCode(this.nested);
        result = 31 * result + Objects.hashCode(this.normalize);
        result = 31 * result + Objects.hashCode(this.parent);
        result = 31 * result + Objects.hashCode(this.percentileRanks);
        result = 31 * result + Objects.hashCode(this.percentiles);
        result = 31 * result + Objects.hashCode(this.percentilesBucket);
        result = 31 * result + Objects.hashCode(this.range);
        result = 31 * result + Objects.hashCode(this.rareTerms);
        result = 31 * result + Objects.hashCode(this.rate);
        result = 31 * result + Objects.hashCode(this.reverseNested);
        result = 31 * result + Objects.hashCode(this.sampler);
        result = 31 * result + Objects.hashCode(this.scriptedMetric);
        result = 31 * result + Objects.hashCode(this.serialDiff);
        result = 31 * result + Objects.hashCode(this.significantTerms);
        result = 31 * result + Objects.hashCode(this.significantText);
        result = 31 * result + Objects.hashCode(this.stats);
        result = 31 * result + Objects.hashCode(this.statsBucket);
        result = 31 * result + Objects.hashCode(this.sum);
        result = 31 * result + Objects.hashCode(this.sumBucket);
        result = 31 * result + Objects.hashCode(this.tTest);
        result = 31 * result + Objects.hashCode(this.terms);
        result = 31 * result + Objects.hashCode(this.topHits);
        result = 31 * result + Objects.hashCode(this.valueCount);
        result = 31 * result + Objects.hashCode(this.variableWidthHistogram);
        result = 31 * result + Objects.hashCode(this.weightedAvg);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Aggregation other = (Aggregation) o;
        return Objects.equals(this.adjacencyMatrix, other.adjacencyMatrix)
            && Objects.equals(this.aggregations, other.aggregations)
            && Objects.equals(this.aggs, other.aggs)
            && Objects.equals(this.autoDateHistogram, other.autoDateHistogram)
            && Objects.equals(this.avg, other.avg)
            && Objects.equals(this.avgBucket, other.avgBucket)
            && Objects.equals(this.boxplot, other.boxplot)
            && Objects.equals(this.bucketScript, other.bucketScript)
            && Objects.equals(this.bucketSelector, other.bucketSelector)
            && Objects.equals(this.bucketSort, other.bucketSort)
            && Objects.equals(this.cardinality, other.cardinality)
            && Objects.equals(this.children, other.children)
            && Objects.equals(this.composite, other.composite)
            && Objects.equals(this.cumulativeCardinality, other.cumulativeCardinality)
            && Objects.equals(this.cumulativeSum, other.cumulativeSum)
            && Objects.equals(this.dateHistogram, other.dateHistogram)
            && Objects.equals(this.dateRange, other.dateRange)
            && Objects.equals(this.derivative, other.derivative)
            && Objects.equals(this.diversifiedSampler, other.diversifiedSampler)
            && Objects.equals(this.extendedStats, other.extendedStats)
            && Objects.equals(this.extendedStatsBucket, other.extendedStatsBucket)
            && Objects.equals(this.filter, other.filter)
            && Objects.equals(this.filters, other.filters)
            && Objects.equals(this.geoBounds, other.geoBounds)
            && Objects.equals(this.geoCentroid, other.geoCentroid)
            && Objects.equals(this.geoDistance, other.geoDistance)
            && Objects.equals(this.geohashGrid, other.geohashGrid)
            && Objects.equals(this.geotileGrid, other.geotileGrid)
            && Objects.equals(this.global, other.global)
            && Objects.equals(this.histogram, other.histogram)
            && Objects.equals(this.ipRange, other.ipRange)
            && Objects.equals(this.matrixStats, other.matrixStats)
            && Objects.equals(this.max, other.max)
            && Objects.equals(this.maxBucket, other.maxBucket)
            && Objects.equals(this.medianAbsoluteDeviation, other.medianAbsoluteDeviation)
            && Objects.equals(this.min, other.min)
            && Objects.equals(this.minBucket, other.minBucket)
            && Objects.equals(this.missing, other.missing)
            && Objects.equals(this.movingAvg, other.movingAvg)
            && Objects.equals(this.movingFn, other.movingFn)
            && Objects.equals(this.movingPercentiles, other.movingPercentiles)
            && Objects.equals(this.multiTerms, other.multiTerms)
            && Objects.equals(this.nested, other.nested)
            && Objects.equals(this.normalize, other.normalize)
            && Objects.equals(this.parent, other.parent)
            && Objects.equals(this.percentileRanks, other.percentileRanks)
            && Objects.equals(this.percentiles, other.percentiles)
            && Objects.equals(this.percentilesBucket, other.percentilesBucket)
            && Objects.equals(this.range, other.range)
            && Objects.equals(this.rareTerms, other.rareTerms)
            && Objects.equals(this.rate, other.rate)
            && Objects.equals(this.reverseNested, other.reverseNested)
            && Objects.equals(this.sampler, other.sampler)
            && Objects.equals(this.scriptedMetric, other.scriptedMetric)
            && Objects.equals(this.serialDiff, other.serialDiff)
            && Objects.equals(this.significantTerms, other.significantTerms)
            && Objects.equals(this.significantText, other.significantText)
            && Objects.equals(this.stats, other.stats)
            && Objects.equals(this.statsBucket, other.statsBucket)
            && Objects.equals(this.sum, other.sum)
            && Objects.equals(this.sumBucket, other.sumBucket)
            && Objects.equals(this.tTest, other.tTest)
            && Objects.equals(this.terms, other.terms)
            && Objects.equals(this.topHits, other.topHits)
            && Objects.equals(this.valueCount, other.valueCount)
            && Objects.equals(this.variableWidthHistogram, other.variableWidthHistogram)
            && Objects.equals(this.weightedAvg, other.weightedAvg);
    }
}
