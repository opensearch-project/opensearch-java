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
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.json.UnionDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

// typedef: _types.aggregations.Aggregate

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Aggregate extends AggregateBase implements TaggedUnion<Aggregate.Kind, Object>, PlainJsonSerializable {
    /**
     * {@link Aggregate} variant kinds.
     */
    public enum Kind {
        AdjacencyMatrix,
        AutoDateHistogram,
        Avg,
        BoxPlot,
        BucketMetricValue,
        Cardinality,
        Children,
        Composite,
        DateHistogram,
        DateRange,
        Derivative,
        Dterms,
        ExtendedStats,
        ExtendedStatsBucket,
        Filter,
        Filters,
        GeoBounds,
        GeoCentroid,
        GeoDistance,
        GeohashGrid,
        GeotileGrid,
        Global,
        HdrPercentileRanks,
        HdrPercentiles,
        Histogram,
        IpRange,
        Lrareterms,
        Lterms,
        MatrixStats,
        Max,
        MedianAbsoluteDeviation,
        Min,
        Missing,
        MultiTerms,
        Nested,
        Parent,
        PercentilesBucket,
        Range,
        Rate,
        ReverseNested,
        Sampler,
        ScriptedMetric,
        Siglterms,
        Sigsterms,
        SimpleLongValue,
        SimpleValue,
        Srareterms,
        Stats,
        StatsBucket,
        Sterms,
        Sum,
        TTest,
        TdigestPercentileRanks,
        TdigestPercentiles,
        TopHits,
        Ulterms,
        Umrareterms,
        Umsigterms,
        Umterms,
        ValueCount,
        VariableWidthHistogram,
        WeightedAvg
    }

    private final Kind _kind;
    private final Object _value;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final Object _get() {
        return _value;
    }

    private Aggregate(Builder builder) {
        super(builder);
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static Aggregate of(Function<Aggregate.Builder, ObjectBuilder<Aggregate>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code adjacency_matrix}?
     */
    public boolean isAdjacencyMatrix() {
        return _kind == Kind.AdjacencyMatrix;
    }

    /**
     * Get the {@code adjacency_matrix} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code adjacency_matrix} kind.
     */
    public AdjacencyMatrixAggregate adjacencyMatrix() {
        return TaggedUnionUtils.get(this, Kind.AdjacencyMatrix);
    }

    /**
     * Is this variant instance of kind {@code auto_date_histogram}?
     */
    public boolean isAutoDateHistogram() {
        return _kind == Kind.AutoDateHistogram;
    }

    /**
     * Get the {@code auto_date_histogram} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code auto_date_histogram} kind.
     */
    public AutoDateHistogramAggregate autoDateHistogram() {
        return TaggedUnionUtils.get(this, Kind.AutoDateHistogram);
    }

    /**
     * Is this variant instance of kind {@code avg}?
     */
    public boolean isAvg() {
        return _kind == Kind.Avg;
    }

    /**
     * Get the {@code avg} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code avg} kind.
     */
    public AvgAggregate avg() {
        return TaggedUnionUtils.get(this, Kind.Avg);
    }

    /**
     * Is this variant instance of kind {@code box_plot}?
     */
    public boolean isBoxPlot() {
        return _kind == Kind.BoxPlot;
    }

    /**
     * Get the {@code box_plot} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code box_plot} kind.
     */
    public BoxPlotAggregate boxPlot() {
        return TaggedUnionUtils.get(this, Kind.BoxPlot);
    }

    /**
     * Is this variant instance of kind {@code bucket_metric_value}?
     */
    public boolean isBucketMetricValue() {
        return _kind == Kind.BucketMetricValue;
    }

    /**
     * Get the {@code bucket_metric_value} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code bucket_metric_value} kind.
     */
    public BucketMetricValueAggregate bucketMetricValue() {
        return TaggedUnionUtils.get(this, Kind.BucketMetricValue);
    }

    /**
     * Is this variant instance of kind {@code cardinality}?
     */
    public boolean isCardinality() {
        return _kind == Kind.Cardinality;
    }

    /**
     * Get the {@code cardinality} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code cardinality} kind.
     */
    public CardinalityAggregate cardinality() {
        return TaggedUnionUtils.get(this, Kind.Cardinality);
    }

    /**
     * Is this variant instance of kind {@code children}?
     */
    public boolean isChildren() {
        return _kind == Kind.Children;
    }

    /**
     * Get the {@code children} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code children} kind.
     */
    public ChildrenAggregate children() {
        return TaggedUnionUtils.get(this, Kind.Children);
    }

    /**
     * Is this variant instance of kind {@code composite}?
     */
    public boolean isComposite() {
        return _kind == Kind.Composite;
    }

    /**
     * Get the {@code composite} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code composite} kind.
     */
    public CompositeAggregate composite() {
        return TaggedUnionUtils.get(this, Kind.Composite);
    }

    /**
     * Is this variant instance of kind {@code date_histogram}?
     */
    public boolean isDateHistogram() {
        return _kind == Kind.DateHistogram;
    }

    /**
     * Get the {@code date_histogram} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code date_histogram} kind.
     */
    public DateHistogramAggregate dateHistogram() {
        return TaggedUnionUtils.get(this, Kind.DateHistogram);
    }

    /**
     * Is this variant instance of kind {@code date_range}?
     */
    public boolean isDateRange() {
        return _kind == Kind.DateRange;
    }

    /**
     * Get the {@code date_range} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code date_range} kind.
     */
    public DateRangeAggregate dateRange() {
        return TaggedUnionUtils.get(this, Kind.DateRange);
    }

    /**
     * Is this variant instance of kind {@code derivative}?
     */
    public boolean isDerivative() {
        return _kind == Kind.Derivative;
    }

    /**
     * Get the {@code derivative} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code derivative} kind.
     */
    public DerivativeAggregate derivative() {
        return TaggedUnionUtils.get(this, Kind.Derivative);
    }

    /**
     * Is this variant instance of kind {@code dterms}?
     */
    public boolean isDterms() {
        return _kind == Kind.Dterms;
    }

    /**
     * Get the {@code dterms} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code dterms} kind.
     */
    public DoubleTermsAggregate dterms() {
        return TaggedUnionUtils.get(this, Kind.Dterms);
    }

    /**
     * Is this variant instance of kind {@code extended_stats}?
     */
    public boolean isExtendedStats() {
        return _kind == Kind.ExtendedStats;
    }

    /**
     * Get the {@code extended_stats} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code extended_stats} kind.
     */
    public ExtendedStatsAggregate extendedStats() {
        return TaggedUnionUtils.get(this, Kind.ExtendedStats);
    }

    /**
     * Is this variant instance of kind {@code extended_stats_bucket}?
     */
    public boolean isExtendedStatsBucket() {
        return _kind == Kind.ExtendedStatsBucket;
    }

    /**
     * Get the {@code extended_stats_bucket} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code extended_stats_bucket} kind.
     */
    public ExtendedStatsBucketAggregate extendedStatsBucket() {
        return TaggedUnionUtils.get(this, Kind.ExtendedStatsBucket);
    }

    /**
     * Is this variant instance of kind {@code filter}?
     */
    public boolean isFilter() {
        return _kind == Kind.Filter;
    }

    /**
     * Get the {@code filter} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code filter} kind.
     */
    public FilterAggregate filter() {
        return TaggedUnionUtils.get(this, Kind.Filter);
    }

    /**
     * Is this variant instance of kind {@code filters}?
     */
    public boolean isFilters() {
        return _kind == Kind.Filters;
    }

    /**
     * Get the {@code filters} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code filters} kind.
     */
    public FiltersAggregate filters() {
        return TaggedUnionUtils.get(this, Kind.Filters);
    }

    /**
     * Is this variant instance of kind {@code geo_bounds}?
     */
    public boolean isGeoBounds() {
        return _kind == Kind.GeoBounds;
    }

    /**
     * Get the {@code geo_bounds} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code geo_bounds} kind.
     */
    public GeoBoundsAggregate geoBounds() {
        return TaggedUnionUtils.get(this, Kind.GeoBounds);
    }

    /**
     * Is this variant instance of kind {@code geo_centroid}?
     */
    public boolean isGeoCentroid() {
        return _kind == Kind.GeoCentroid;
    }

    /**
     * Get the {@code geo_centroid} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code geo_centroid} kind.
     */
    public GeoCentroidAggregate geoCentroid() {
        return TaggedUnionUtils.get(this, Kind.GeoCentroid);
    }

    /**
     * Is this variant instance of kind {@code geo_distance}?
     */
    public boolean isGeoDistance() {
        return _kind == Kind.GeoDistance;
    }

    /**
     * Get the {@code geo_distance} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code geo_distance} kind.
     */
    public GeoDistanceAggregate geoDistance() {
        return TaggedUnionUtils.get(this, Kind.GeoDistance);
    }

    /**
     * Is this variant instance of kind {@code geohash_grid}?
     */
    public boolean isGeohashGrid() {
        return _kind == Kind.GeohashGrid;
    }

    /**
     * Get the {@code geohash_grid} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code geohash_grid} kind.
     */
    public GeoHashGridAggregate geohashGrid() {
        return TaggedUnionUtils.get(this, Kind.GeohashGrid);
    }

    /**
     * Is this variant instance of kind {@code geotile_grid}?
     */
    public boolean isGeotileGrid() {
        return _kind == Kind.GeotileGrid;
    }

    /**
     * Get the {@code geotile_grid} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code geotile_grid} kind.
     */
    public GeoTileGridAggregate geotileGrid() {
        return TaggedUnionUtils.get(this, Kind.GeotileGrid);
    }

    /**
     * Is this variant instance of kind {@code global}?
     */
    public boolean isGlobal() {
        return _kind == Kind.Global;
    }

    /**
     * Get the {@code global} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code global} kind.
     */
    public GlobalAggregate global() {
        return TaggedUnionUtils.get(this, Kind.Global);
    }

    /**
     * Is this variant instance of kind {@code hdr_percentile_ranks}?
     */
    public boolean isHdrPercentileRanks() {
        return _kind == Kind.HdrPercentileRanks;
    }

    /**
     * Get the {@code hdr_percentile_ranks} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code hdr_percentile_ranks} kind.
     */
    public HdrPercentileRanksAggregate hdrPercentileRanks() {
        return TaggedUnionUtils.get(this, Kind.HdrPercentileRanks);
    }

    /**
     * Is this variant instance of kind {@code hdr_percentiles}?
     */
    public boolean isHdrPercentiles() {
        return _kind == Kind.HdrPercentiles;
    }

    /**
     * Get the {@code hdr_percentiles} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code hdr_percentiles} kind.
     */
    public HdrPercentilesAggregate hdrPercentiles() {
        return TaggedUnionUtils.get(this, Kind.HdrPercentiles);
    }

    /**
     * Is this variant instance of kind {@code histogram}?
     */
    public boolean isHistogram() {
        return _kind == Kind.Histogram;
    }

    /**
     * Get the {@code histogram} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code histogram} kind.
     */
    public HistogramAggregate histogram() {
        return TaggedUnionUtils.get(this, Kind.Histogram);
    }

    /**
     * Is this variant instance of kind {@code ip_range}?
     */
    public boolean isIpRange() {
        return _kind == Kind.IpRange;
    }

    /**
     * Get the {@code ip_range} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code ip_range} kind.
     */
    public IpRangeAggregate ipRange() {
        return TaggedUnionUtils.get(this, Kind.IpRange);
    }

    /**
     * Is this variant instance of kind {@code lrareterms}?
     */
    public boolean isLrareterms() {
        return _kind == Kind.Lrareterms;
    }

    /**
     * Get the {@code lrareterms} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code lrareterms} kind.
     */
    public LongRareTermsAggregate lrareterms() {
        return TaggedUnionUtils.get(this, Kind.Lrareterms);
    }

    /**
     * Is this variant instance of kind {@code lterms}?
     */
    public boolean isLterms() {
        return _kind == Kind.Lterms;
    }

    /**
     * Get the {@code lterms} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code lterms} kind.
     */
    public LongTermsAggregate lterms() {
        return TaggedUnionUtils.get(this, Kind.Lterms);
    }

    /**
     * Is this variant instance of kind {@code matrix_stats}?
     */
    public boolean isMatrixStats() {
        return _kind == Kind.MatrixStats;
    }

    /**
     * Get the {@code matrix_stats} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code matrix_stats} kind.
     */
    public MatrixStatsAggregate matrixStats() {
        return TaggedUnionUtils.get(this, Kind.MatrixStats);
    }

    /**
     * Is this variant instance of kind {@code max}?
     */
    public boolean isMax() {
        return _kind == Kind.Max;
    }

    /**
     * Get the {@code max} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code max} kind.
     */
    public MaxAggregate max() {
        return TaggedUnionUtils.get(this, Kind.Max);
    }

    /**
     * Is this variant instance of kind {@code median_absolute_deviation}?
     */
    public boolean isMedianAbsoluteDeviation() {
        return _kind == Kind.MedianAbsoluteDeviation;
    }

    /**
     * Get the {@code median_absolute_deviation} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code median_absolute_deviation} kind.
     */
    public MedianAbsoluteDeviationAggregate medianAbsoluteDeviation() {
        return TaggedUnionUtils.get(this, Kind.MedianAbsoluteDeviation);
    }

    /**
     * Is this variant instance of kind {@code min}?
     */
    public boolean isMin() {
        return _kind == Kind.Min;
    }

    /**
     * Get the {@code min} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code min} kind.
     */
    public MinAggregate min() {
        return TaggedUnionUtils.get(this, Kind.Min);
    }

    /**
     * Is this variant instance of kind {@code missing}?
     */
    public boolean isMissing() {
        return _kind == Kind.Missing;
    }

    /**
     * Get the {@code missing} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code missing} kind.
     */
    public MissingAggregate missing() {
        return TaggedUnionUtils.get(this, Kind.Missing);
    }

    /**
     * Is this variant instance of kind {@code multi_terms}?
     */
    public boolean isMultiTerms() {
        return _kind == Kind.MultiTerms;
    }

    /**
     * Get the {@code multi_terms} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code multi_terms} kind.
     */
    public MultiTermsAggregate multiTerms() {
        return TaggedUnionUtils.get(this, Kind.MultiTerms);
    }

    /**
     * Is this variant instance of kind {@code nested}?
     */
    public boolean isNested() {
        return _kind == Kind.Nested;
    }

    /**
     * Get the {@code nested} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code nested} kind.
     */
    public NestedAggregate nested() {
        return TaggedUnionUtils.get(this, Kind.Nested);
    }

    /**
     * Is this variant instance of kind {@code parent}?
     */
    public boolean isParent() {
        return _kind == Kind.Parent;
    }

    /**
     * Get the {@code parent} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code parent} kind.
     */
    public ParentAggregate parent() {
        return TaggedUnionUtils.get(this, Kind.Parent);
    }

    /**
     * Is this variant instance of kind {@code percentiles_bucket}?
     */
    public boolean isPercentilesBucket() {
        return _kind == Kind.PercentilesBucket;
    }

    /**
     * Get the {@code percentiles_bucket} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code percentiles_bucket} kind.
     */
    public PercentilesBucketAggregate percentilesBucket() {
        return TaggedUnionUtils.get(this, Kind.PercentilesBucket);
    }

    /**
     * Is this variant instance of kind {@code range}?
     */
    public boolean isRange() {
        return _kind == Kind.Range;
    }

    /**
     * Get the {@code range} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code range} kind.
     */
    public RangeAggregate range() {
        return TaggedUnionUtils.get(this, Kind.Range);
    }

    /**
     * Is this variant instance of kind {@code rate}?
     */
    public boolean isRate() {
        return _kind == Kind.Rate;
    }

    /**
     * Get the {@code rate} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code rate} kind.
     */
    public RateAggregate rate() {
        return TaggedUnionUtils.get(this, Kind.Rate);
    }

    /**
     * Is this variant instance of kind {@code reverse_nested}?
     */
    public boolean isReverseNested() {
        return _kind == Kind.ReverseNested;
    }

    /**
     * Get the {@code reverse_nested} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code reverse_nested} kind.
     */
    public ReverseNestedAggregate reverseNested() {
        return TaggedUnionUtils.get(this, Kind.ReverseNested);
    }

    /**
     * Is this variant instance of kind {@code sampler}?
     */
    public boolean isSampler() {
        return _kind == Kind.Sampler;
    }

    /**
     * Get the {@code sampler} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code sampler} kind.
     */
    public SamplerAggregate sampler() {
        return TaggedUnionUtils.get(this, Kind.Sampler);
    }

    /**
     * Is this variant instance of kind {@code scripted_metric}?
     */
    public boolean isScriptedMetric() {
        return _kind == Kind.ScriptedMetric;
    }

    /**
     * Get the {@code scripted_metric} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code scripted_metric} kind.
     */
    public ScriptedMetricAggregate scriptedMetric() {
        return TaggedUnionUtils.get(this, Kind.ScriptedMetric);
    }

    /**
     * Is this variant instance of kind {@code siglterms}?
     */
    public boolean isSiglterms() {
        return _kind == Kind.Siglterms;
    }

    /**
     * Get the {@code siglterms} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code siglterms} kind.
     */
    public SignificantLongTermsAggregate siglterms() {
        return TaggedUnionUtils.get(this, Kind.Siglterms);
    }

    /**
     * Is this variant instance of kind {@code sigsterms}?
     */
    public boolean isSigsterms() {
        return _kind == Kind.Sigsterms;
    }

    /**
     * Get the {@code sigsterms} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code sigsterms} kind.
     */
    public SignificantStringTermsAggregate sigsterms() {
        return TaggedUnionUtils.get(this, Kind.Sigsterms);
    }

    /**
     * Is this variant instance of kind {@code simple_long_value}?
     */
    public boolean isSimpleLongValue() {
        return _kind == Kind.SimpleLongValue;
    }

    /**
     * Get the {@code simple_long_value} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code simple_long_value} kind.
     */
    public CumulativeCardinalityAggregate simpleLongValue() {
        return TaggedUnionUtils.get(this, Kind.SimpleLongValue);
    }

    /**
     * Is this variant instance of kind {@code simple_value}?
     */
    public boolean isSimpleValue() {
        return _kind == Kind.SimpleValue;
    }

    /**
     * Get the {@code simple_value} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code simple_value} kind.
     */
    public SimpleValueAggregate simpleValue() {
        return TaggedUnionUtils.get(this, Kind.SimpleValue);
    }

    /**
     * Is this variant instance of kind {@code srareterms}?
     */
    public boolean isSrareterms() {
        return _kind == Kind.Srareterms;
    }

    /**
     * Get the {@code srareterms} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code srareterms} kind.
     */
    public StringRareTermsAggregate srareterms() {
        return TaggedUnionUtils.get(this, Kind.Srareterms);
    }

    /**
     * Is this variant instance of kind {@code stats}?
     */
    public boolean isStats() {
        return _kind == Kind.Stats;
    }

    /**
     * Get the {@code stats} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code stats} kind.
     */
    public StatsAggregate stats() {
        return TaggedUnionUtils.get(this, Kind.Stats);
    }

    /**
     * Is this variant instance of kind {@code stats_bucket}?
     */
    public boolean isStatsBucket() {
        return _kind == Kind.StatsBucket;
    }

    /**
     * Get the {@code stats_bucket} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code stats_bucket} kind.
     */
    public StatsBucketAggregate statsBucket() {
        return TaggedUnionUtils.get(this, Kind.StatsBucket);
    }

    /**
     * Is this variant instance of kind {@code sterms}?
     */
    public boolean isSterms() {
        return _kind == Kind.Sterms;
    }

    /**
     * Get the {@code sterms} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code sterms} kind.
     */
    public StringTermsAggregate sterms() {
        return TaggedUnionUtils.get(this, Kind.Sterms);
    }

    /**
     * Is this variant instance of kind {@code sum}?
     */
    public boolean isSum() {
        return _kind == Kind.Sum;
    }

    /**
     * Get the {@code sum} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code sum} kind.
     */
    public SumAggregate sum() {
        return TaggedUnionUtils.get(this, Kind.Sum);
    }

    /**
     * Is this variant instance of kind {@code t_test}?
     */
    public boolean isTTest() {
        return _kind == Kind.TTest;
    }

    /**
     * Get the {@code t_test} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code t_test} kind.
     */
    public TTestAggregate tTest() {
        return TaggedUnionUtils.get(this, Kind.TTest);
    }

    /**
     * Is this variant instance of kind {@code tdigest_percentile_ranks}?
     */
    public boolean isTdigestPercentileRanks() {
        return _kind == Kind.TdigestPercentileRanks;
    }

    /**
     * Get the {@code tdigest_percentile_ranks} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code tdigest_percentile_ranks} kind.
     */
    public TDigestPercentileRanksAggregate tdigestPercentileRanks() {
        return TaggedUnionUtils.get(this, Kind.TdigestPercentileRanks);
    }

    /**
     * Is this variant instance of kind {@code tdigest_percentiles}?
     */
    public boolean isTdigestPercentiles() {
        return _kind == Kind.TdigestPercentiles;
    }

    /**
     * Get the {@code tdigest_percentiles} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code tdigest_percentiles} kind.
     */
    public TDigestPercentilesAggregate tdigestPercentiles() {
        return TaggedUnionUtils.get(this, Kind.TdigestPercentiles);
    }

    /**
     * Is this variant instance of kind {@code top_hits}?
     */
    public boolean isTopHits() {
        return _kind == Kind.TopHits;
    }

    /**
     * Get the {@code top_hits} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code top_hits} kind.
     */
    public TopHitsAggregate topHits() {
        return TaggedUnionUtils.get(this, Kind.TopHits);
    }

    /**
     * Is this variant instance of kind {@code ulterms}?
     */
    public boolean isUlterms() {
        return _kind == Kind.Ulterms;
    }

    /**
     * Get the {@code ulterms} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code ulterms} kind.
     */
    public UnsignedLongTermsAggregate ulterms() {
        return TaggedUnionUtils.get(this, Kind.Ulterms);
    }

    /**
     * Is this variant instance of kind {@code umrareterms}?
     */
    public boolean isUmrareterms() {
        return _kind == Kind.Umrareterms;
    }

    /**
     * Get the {@code umrareterms} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code umrareterms} kind.
     */
    public UnmappedRareTermsAggregate umrareterms() {
        return TaggedUnionUtils.get(this, Kind.Umrareterms);
    }

    /**
     * Is this variant instance of kind {@code umsigterms}?
     */
    public boolean isUmsigterms() {
        return _kind == Kind.Umsigterms;
    }

    /**
     * Get the {@code umsigterms} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code umsigterms} kind.
     */
    public UnmappedSignificantTermsAggregate umsigterms() {
        return TaggedUnionUtils.get(this, Kind.Umsigterms);
    }

    /**
     * Is this variant instance of kind {@code umterms}?
     */
    public boolean isUmterms() {
        return _kind == Kind.Umterms;
    }

    /**
     * Get the {@code umterms} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code umterms} kind.
     */
    public UnmappedTermsAggregate umterms() {
        return TaggedUnionUtils.get(this, Kind.Umterms);
    }

    /**
     * Is this variant instance of kind {@code value_count}?
     */
    public boolean isValueCount() {
        return _kind == Kind.ValueCount;
    }

    /**
     * Get the {@code value_count} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code value_count} kind.
     */
    public ValueCountAggregate valueCount() {
        return TaggedUnionUtils.get(this, Kind.ValueCount);
    }

    /**
     * Is this variant instance of kind {@code variable_width_histogram}?
     */
    public boolean isVariableWidthHistogram() {
        return _kind == Kind.VariableWidthHistogram;
    }

    /**
     * Get the {@code variable_width_histogram} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code variable_width_histogram} kind.
     */
    public VariableWidthHistogramAggregate variableWidthHistogram() {
        return TaggedUnionUtils.get(this, Kind.VariableWidthHistogram);
    }

    /**
     * Is this variant instance of kind {@code weighted_avg}?
     */
    public boolean isWeightedAvg() {
        return _kind == Kind.WeightedAvg;
    }

    /**
     * Get the {@code weighted_avg} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code weighted_avg} kind.
     */
    public WeightedAvgAggregate weightedAvg() {
        return TaggedUnionUtils.get(this, Kind.WeightedAvg);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        }
    }

    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends AggregateBase.AbstractBuilder<Builder> implements ObjectBuilder<Aggregate> {
        private Kind _kind;
        private Object _value;

        public Builder() {}

        private Builder(Aggregate o) {
            super(o);
            this._kind = o._kind;
            this._value = o._value;
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        public ObjectBuilder<Aggregate> adjacencyMatrix(AdjacencyMatrixAggregate v) {
            this._kind = Kind.AdjacencyMatrix;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> adjacencyMatrix(
            Function<AdjacencyMatrixAggregate.Builder, ObjectBuilder<AdjacencyMatrixAggregate>> fn
        ) {
            return this.adjacencyMatrix(fn.apply(new AdjacencyMatrixAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> autoDateHistogram(AutoDateHistogramAggregate v) {
            this._kind = Kind.AutoDateHistogram;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> autoDateHistogram(
            Function<AutoDateHistogramAggregate.Builder, ObjectBuilder<AutoDateHistogramAggregate>> fn
        ) {
            return this.autoDateHistogram(fn.apply(new AutoDateHistogramAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> avg(AvgAggregate v) {
            this._kind = Kind.Avg;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> avg(Function<AvgAggregate.Builder, ObjectBuilder<AvgAggregate>> fn) {
            return this.avg(fn.apply(new AvgAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> boxPlot(BoxPlotAggregate v) {
            this._kind = Kind.BoxPlot;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> boxPlot(Function<BoxPlotAggregate.Builder, ObjectBuilder<BoxPlotAggregate>> fn) {
            return this.boxPlot(fn.apply(new BoxPlotAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> bucketMetricValue(BucketMetricValueAggregate v) {
            this._kind = Kind.BucketMetricValue;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> bucketMetricValue(
            Function<BucketMetricValueAggregate.Builder, ObjectBuilder<BucketMetricValueAggregate>> fn
        ) {
            return this.bucketMetricValue(fn.apply(new BucketMetricValueAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> cardinality(CardinalityAggregate v) {
            this._kind = Kind.Cardinality;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> cardinality(Function<CardinalityAggregate.Builder, ObjectBuilder<CardinalityAggregate>> fn) {
            return this.cardinality(fn.apply(new CardinalityAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> children(ChildrenAggregate v) {
            this._kind = Kind.Children;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> children(Function<ChildrenAggregate.Builder, ObjectBuilder<ChildrenAggregate>> fn) {
            return this.children(fn.apply(new ChildrenAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> composite(CompositeAggregate v) {
            this._kind = Kind.Composite;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> composite(Function<CompositeAggregate.Builder, ObjectBuilder<CompositeAggregate>> fn) {
            return this.composite(fn.apply(new CompositeAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> dateHistogram(DateHistogramAggregate v) {
            this._kind = Kind.DateHistogram;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> dateHistogram(Function<DateHistogramAggregate.Builder, ObjectBuilder<DateHistogramAggregate>> fn) {
            return this.dateHistogram(fn.apply(new DateHistogramAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> dateRange(DateRangeAggregate v) {
            this._kind = Kind.DateRange;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> dateRange(Function<DateRangeAggregate.Builder, ObjectBuilder<DateRangeAggregate>> fn) {
            return this.dateRange(fn.apply(new DateRangeAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> derivative(DerivativeAggregate v) {
            this._kind = Kind.Derivative;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> derivative(Function<DerivativeAggregate.Builder, ObjectBuilder<DerivativeAggregate>> fn) {
            return this.derivative(fn.apply(new DerivativeAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> dterms(DoubleTermsAggregate v) {
            this._kind = Kind.Dterms;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> dterms(Function<DoubleTermsAggregate.Builder, ObjectBuilder<DoubleTermsAggregate>> fn) {
            return this.dterms(fn.apply(new DoubleTermsAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> extendedStats(ExtendedStatsAggregate v) {
            this._kind = Kind.ExtendedStats;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> extendedStats(Function<ExtendedStatsAggregate.Builder, ObjectBuilder<ExtendedStatsAggregate>> fn) {
            return this.extendedStats(fn.apply(new ExtendedStatsAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> extendedStatsBucket(ExtendedStatsBucketAggregate v) {
            this._kind = Kind.ExtendedStatsBucket;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> extendedStatsBucket(
            Function<ExtendedStatsBucketAggregate.Builder, ObjectBuilder<ExtendedStatsBucketAggregate>> fn
        ) {
            return this.extendedStatsBucket(fn.apply(new ExtendedStatsBucketAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> filter(FilterAggregate v) {
            this._kind = Kind.Filter;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> filter(Function<FilterAggregate.Builder, ObjectBuilder<FilterAggregate>> fn) {
            return this.filter(fn.apply(new FilterAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> filters(FiltersAggregate v) {
            this._kind = Kind.Filters;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> filters(Function<FiltersAggregate.Builder, ObjectBuilder<FiltersAggregate>> fn) {
            return this.filters(fn.apply(new FiltersAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> geoBounds(GeoBoundsAggregate v) {
            this._kind = Kind.GeoBounds;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> geoBounds(Function<GeoBoundsAggregate.Builder, ObjectBuilder<GeoBoundsAggregate>> fn) {
            return this.geoBounds(fn.apply(new GeoBoundsAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> geoCentroid(GeoCentroidAggregate v) {
            this._kind = Kind.GeoCentroid;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> geoCentroid(Function<GeoCentroidAggregate.Builder, ObjectBuilder<GeoCentroidAggregate>> fn) {
            return this.geoCentroid(fn.apply(new GeoCentroidAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> geoDistance(GeoDistanceAggregate v) {
            this._kind = Kind.GeoDistance;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> geoDistance(Function<GeoDistanceAggregate.Builder, ObjectBuilder<GeoDistanceAggregate>> fn) {
            return this.geoDistance(fn.apply(new GeoDistanceAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> geohashGrid(GeoHashGridAggregate v) {
            this._kind = Kind.GeohashGrid;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> geohashGrid(Function<GeoHashGridAggregate.Builder, ObjectBuilder<GeoHashGridAggregate>> fn) {
            return this.geohashGrid(fn.apply(new GeoHashGridAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> geotileGrid(GeoTileGridAggregate v) {
            this._kind = Kind.GeotileGrid;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> geotileGrid(Function<GeoTileGridAggregate.Builder, ObjectBuilder<GeoTileGridAggregate>> fn) {
            return this.geotileGrid(fn.apply(new GeoTileGridAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> global(GlobalAggregate v) {
            this._kind = Kind.Global;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> global(Function<GlobalAggregate.Builder, ObjectBuilder<GlobalAggregate>> fn) {
            return this.global(fn.apply(new GlobalAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> hdrPercentileRanks(HdrPercentileRanksAggregate v) {
            this._kind = Kind.HdrPercentileRanks;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> hdrPercentileRanks(
            Function<HdrPercentileRanksAggregate.Builder, ObjectBuilder<HdrPercentileRanksAggregate>> fn
        ) {
            return this.hdrPercentileRanks(fn.apply(new HdrPercentileRanksAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> hdrPercentiles(HdrPercentilesAggregate v) {
            this._kind = Kind.HdrPercentiles;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> hdrPercentiles(
            Function<HdrPercentilesAggregate.Builder, ObjectBuilder<HdrPercentilesAggregate>> fn
        ) {
            return this.hdrPercentiles(fn.apply(new HdrPercentilesAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> histogram(HistogramAggregate v) {
            this._kind = Kind.Histogram;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> histogram(Function<HistogramAggregate.Builder, ObjectBuilder<HistogramAggregate>> fn) {
            return this.histogram(fn.apply(new HistogramAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> ipRange(IpRangeAggregate v) {
            this._kind = Kind.IpRange;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> ipRange(Function<IpRangeAggregate.Builder, ObjectBuilder<IpRangeAggregate>> fn) {
            return this.ipRange(fn.apply(new IpRangeAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> lrareterms(LongRareTermsAggregate v) {
            this._kind = Kind.Lrareterms;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> lrareterms(Function<LongRareTermsAggregate.Builder, ObjectBuilder<LongRareTermsAggregate>> fn) {
            return this.lrareterms(fn.apply(new LongRareTermsAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> lterms(LongTermsAggregate v) {
            this._kind = Kind.Lterms;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> lterms(Function<LongTermsAggregate.Builder, ObjectBuilder<LongTermsAggregate>> fn) {
            return this.lterms(fn.apply(new LongTermsAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> matrixStats(MatrixStatsAggregate v) {
            this._kind = Kind.MatrixStats;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> matrixStats(Function<MatrixStatsAggregate.Builder, ObjectBuilder<MatrixStatsAggregate>> fn) {
            return this.matrixStats(fn.apply(new MatrixStatsAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> max(MaxAggregate v) {
            this._kind = Kind.Max;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> max(Function<MaxAggregate.Builder, ObjectBuilder<MaxAggregate>> fn) {
            return this.max(fn.apply(new MaxAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> medianAbsoluteDeviation(MedianAbsoluteDeviationAggregate v) {
            this._kind = Kind.MedianAbsoluteDeviation;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> medianAbsoluteDeviation(
            Function<MedianAbsoluteDeviationAggregate.Builder, ObjectBuilder<MedianAbsoluteDeviationAggregate>> fn
        ) {
            return this.medianAbsoluteDeviation(fn.apply(new MedianAbsoluteDeviationAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> min(MinAggregate v) {
            this._kind = Kind.Min;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> min(Function<MinAggregate.Builder, ObjectBuilder<MinAggregate>> fn) {
            return this.min(fn.apply(new MinAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> missing(MissingAggregate v) {
            this._kind = Kind.Missing;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> missing(Function<MissingAggregate.Builder, ObjectBuilder<MissingAggregate>> fn) {
            return this.missing(fn.apply(new MissingAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> multiTerms(MultiTermsAggregate v) {
            this._kind = Kind.MultiTerms;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> multiTerms(Function<MultiTermsAggregate.Builder, ObjectBuilder<MultiTermsAggregate>> fn) {
            return this.multiTerms(fn.apply(new MultiTermsAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> nested(NestedAggregate v) {
            this._kind = Kind.Nested;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> nested(Function<NestedAggregate.Builder, ObjectBuilder<NestedAggregate>> fn) {
            return this.nested(fn.apply(new NestedAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> parent(ParentAggregate v) {
            this._kind = Kind.Parent;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> parent(Function<ParentAggregate.Builder, ObjectBuilder<ParentAggregate>> fn) {
            return this.parent(fn.apply(new ParentAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> percentilesBucket(PercentilesBucketAggregate v) {
            this._kind = Kind.PercentilesBucket;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> percentilesBucket(
            Function<PercentilesBucketAggregate.Builder, ObjectBuilder<PercentilesBucketAggregate>> fn
        ) {
            return this.percentilesBucket(fn.apply(new PercentilesBucketAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> range(RangeAggregate v) {
            this._kind = Kind.Range;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> range(Function<RangeAggregate.Builder, ObjectBuilder<RangeAggregate>> fn) {
            return this.range(fn.apply(new RangeAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> rate(RateAggregate v) {
            this._kind = Kind.Rate;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> rate(Function<RateAggregate.Builder, ObjectBuilder<RateAggregate>> fn) {
            return this.rate(fn.apply(new RateAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> reverseNested(ReverseNestedAggregate v) {
            this._kind = Kind.ReverseNested;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> reverseNested(Function<ReverseNestedAggregate.Builder, ObjectBuilder<ReverseNestedAggregate>> fn) {
            return this.reverseNested(fn.apply(new ReverseNestedAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> sampler(SamplerAggregate v) {
            this._kind = Kind.Sampler;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> sampler(Function<SamplerAggregate.Builder, ObjectBuilder<SamplerAggregate>> fn) {
            return this.sampler(fn.apply(new SamplerAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> scriptedMetric(ScriptedMetricAggregate v) {
            this._kind = Kind.ScriptedMetric;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> scriptedMetric(
            Function<ScriptedMetricAggregate.Builder, ObjectBuilder<ScriptedMetricAggregate>> fn
        ) {
            return this.scriptedMetric(fn.apply(new ScriptedMetricAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> siglterms(SignificantLongTermsAggregate v) {
            this._kind = Kind.Siglterms;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> siglterms(
            Function<SignificantLongTermsAggregate.Builder, ObjectBuilder<SignificantLongTermsAggregate>> fn
        ) {
            return this.siglterms(fn.apply(new SignificantLongTermsAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> sigsterms(SignificantStringTermsAggregate v) {
            this._kind = Kind.Sigsterms;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> sigsterms(
            Function<SignificantStringTermsAggregate.Builder, ObjectBuilder<SignificantStringTermsAggregate>> fn
        ) {
            return this.sigsterms(fn.apply(new SignificantStringTermsAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> simpleLongValue(CumulativeCardinalityAggregate v) {
            this._kind = Kind.SimpleLongValue;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> simpleLongValue(
            Function<CumulativeCardinalityAggregate.Builder, ObjectBuilder<CumulativeCardinalityAggregate>> fn
        ) {
            return this.simpleLongValue(fn.apply(new CumulativeCardinalityAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> simpleValue(SimpleValueAggregate v) {
            this._kind = Kind.SimpleValue;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> simpleValue(Function<SimpleValueAggregate.Builder, ObjectBuilder<SimpleValueAggregate>> fn) {
            return this.simpleValue(fn.apply(new SimpleValueAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> srareterms(StringRareTermsAggregate v) {
            this._kind = Kind.Srareterms;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> srareterms(Function<StringRareTermsAggregate.Builder, ObjectBuilder<StringRareTermsAggregate>> fn) {
            return this.srareterms(fn.apply(new StringRareTermsAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> stats(StatsAggregate v) {
            this._kind = Kind.Stats;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> stats(Function<StatsAggregate.Builder, ObjectBuilder<StatsAggregate>> fn) {
            return this.stats(fn.apply(new StatsAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> statsBucket(StatsBucketAggregate v) {
            this._kind = Kind.StatsBucket;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> statsBucket(Function<StatsBucketAggregate.Builder, ObjectBuilder<StatsBucketAggregate>> fn) {
            return this.statsBucket(fn.apply(new StatsBucketAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> sterms(StringTermsAggregate v) {
            this._kind = Kind.Sterms;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> sterms(Function<StringTermsAggregate.Builder, ObjectBuilder<StringTermsAggregate>> fn) {
            return this.sterms(fn.apply(new StringTermsAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> sum(SumAggregate v) {
            this._kind = Kind.Sum;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> sum(Function<SumAggregate.Builder, ObjectBuilder<SumAggregate>> fn) {
            return this.sum(fn.apply(new SumAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> tTest(TTestAggregate v) {
            this._kind = Kind.TTest;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> tTest(Function<TTestAggregate.Builder, ObjectBuilder<TTestAggregate>> fn) {
            return this.tTest(fn.apply(new TTestAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> tdigestPercentileRanks(TDigestPercentileRanksAggregate v) {
            this._kind = Kind.TdigestPercentileRanks;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> tdigestPercentileRanks(
            Function<TDigestPercentileRanksAggregate.Builder, ObjectBuilder<TDigestPercentileRanksAggregate>> fn
        ) {
            return this.tdigestPercentileRanks(fn.apply(new TDigestPercentileRanksAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> tdigestPercentiles(TDigestPercentilesAggregate v) {
            this._kind = Kind.TdigestPercentiles;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> tdigestPercentiles(
            Function<TDigestPercentilesAggregate.Builder, ObjectBuilder<TDigestPercentilesAggregate>> fn
        ) {
            return this.tdigestPercentiles(fn.apply(new TDigestPercentilesAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> topHits(TopHitsAggregate v) {
            this._kind = Kind.TopHits;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> topHits(Function<TopHitsAggregate.Builder, ObjectBuilder<TopHitsAggregate>> fn) {
            return this.topHits(fn.apply(new TopHitsAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> ulterms(UnsignedLongTermsAggregate v) {
            this._kind = Kind.Ulterms;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> ulterms(
            Function<UnsignedLongTermsAggregate.Builder, ObjectBuilder<UnsignedLongTermsAggregate>> fn
        ) {
            return this.ulterms(fn.apply(new UnsignedLongTermsAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> umrareterms(UnmappedRareTermsAggregate v) {
            this._kind = Kind.Umrareterms;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> umrareterms(
            Function<UnmappedRareTermsAggregate.Builder, ObjectBuilder<UnmappedRareTermsAggregate>> fn
        ) {
            return this.umrareterms(fn.apply(new UnmappedRareTermsAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> umsigterms(UnmappedSignificantTermsAggregate v) {
            this._kind = Kind.Umsigterms;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> umsigterms(
            Function<UnmappedSignificantTermsAggregate.Builder, ObjectBuilder<UnmappedSignificantTermsAggregate>> fn
        ) {
            return this.umsigterms(fn.apply(new UnmappedSignificantTermsAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> umterms(UnmappedTermsAggregate v) {
            this._kind = Kind.Umterms;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> umterms(Function<UnmappedTermsAggregate.Builder, ObjectBuilder<UnmappedTermsAggregate>> fn) {
            return this.umterms(fn.apply(new UnmappedTermsAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> valueCount(ValueCountAggregate v) {
            this._kind = Kind.ValueCount;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> valueCount(Function<ValueCountAggregate.Builder, ObjectBuilder<ValueCountAggregate>> fn) {
            return this.valueCount(fn.apply(new ValueCountAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> variableWidthHistogram(VariableWidthHistogramAggregate v) {
            this._kind = Kind.VariableWidthHistogram;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> variableWidthHistogram(
            Function<VariableWidthHistogramAggregate.Builder, ObjectBuilder<VariableWidthHistogramAggregate>> fn
        ) {
            return this.variableWidthHistogram(fn.apply(new VariableWidthHistogramAggregate.Builder()).build());
        }

        public ObjectBuilder<Aggregate> weightedAvg(WeightedAvgAggregate v) {
            this._kind = Kind.WeightedAvg;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Aggregate> weightedAvg(Function<WeightedAvgAggregate.Builder, ObjectBuilder<WeightedAvgAggregate>> fn) {
            return this.weightedAvg(fn.apply(new WeightedAvgAggregate.Builder()).build());
        }

        @Override
        public Aggregate build() {
            _checkSingleUse();
            return new Aggregate(this);
        }
    }

    private static JsonpDeserializer<Aggregate> buildAggregateDeserializer() {
        return new UnionDeserializer.Builder<Aggregate, Kind, Object>(Aggregate::new, false).addMember(
            Kind.AdjacencyMatrix,
            AdjacencyMatrixAggregate._DESERIALIZER
        )
            .addMember(Kind.AutoDateHistogram, AutoDateHistogramAggregate._DESERIALIZER)
            .addMember(Kind.Avg, AvgAggregate._DESERIALIZER)
            .addMember(Kind.BoxPlot, BoxPlotAggregate._DESERIALIZER)
            .addMember(Kind.BucketMetricValue, BucketMetricValueAggregate._DESERIALIZER)
            .addMember(Kind.Cardinality, CardinalityAggregate._DESERIALIZER)
            .addMember(Kind.Children, ChildrenAggregate._DESERIALIZER)
            .addMember(Kind.Composite, CompositeAggregate._DESERIALIZER)
            .addMember(Kind.DateHistogram, DateHistogramAggregate._DESERIALIZER)
            .addMember(Kind.DateRange, DateRangeAggregate._DESERIALIZER)
            .addMember(Kind.Derivative, DerivativeAggregate._DESERIALIZER)
            .addMember(Kind.Dterms, DoubleTermsAggregate._DESERIALIZER)
            .addMember(Kind.ExtendedStats, ExtendedStatsAggregate._DESERIALIZER)
            .addMember(Kind.ExtendedStatsBucket, ExtendedStatsBucketAggregate._DESERIALIZER)
            .addMember(Kind.Filter, FilterAggregate._DESERIALIZER)
            .addMember(Kind.Filters, FiltersAggregate._DESERIALIZER)
            .addMember(Kind.GeoBounds, GeoBoundsAggregate._DESERIALIZER)
            .addMember(Kind.GeoCentroid, GeoCentroidAggregate._DESERIALIZER)
            .addMember(Kind.GeoDistance, GeoDistanceAggregate._DESERIALIZER)
            .addMember(Kind.GeohashGrid, GeoHashGridAggregate._DESERIALIZER)
            .addMember(Kind.GeotileGrid, GeoTileGridAggregate._DESERIALIZER)
            .addMember(Kind.Global, GlobalAggregate._DESERIALIZER)
            .addMember(Kind.HdrPercentileRanks, HdrPercentileRanksAggregate._DESERIALIZER)
            .addMember(Kind.HdrPercentiles, HdrPercentilesAggregate._DESERIALIZER)
            .addMember(Kind.Histogram, HistogramAggregate._DESERIALIZER)
            .addMember(Kind.IpRange, IpRangeAggregate._DESERIALIZER)
            .addMember(Kind.Lrareterms, LongRareTermsAggregate._DESERIALIZER)
            .addMember(Kind.Lterms, LongTermsAggregate._DESERIALIZER)
            .addMember(Kind.MatrixStats, MatrixStatsAggregate._DESERIALIZER)
            .addMember(Kind.Max, MaxAggregate._DESERIALIZER)
            .addMember(Kind.MedianAbsoluteDeviation, MedianAbsoluteDeviationAggregate._DESERIALIZER)
            .addMember(Kind.Min, MinAggregate._DESERIALIZER)
            .addMember(Kind.Missing, MissingAggregate._DESERIALIZER)
            .addMember(Kind.MultiTerms, MultiTermsAggregate._DESERIALIZER)
            .addMember(Kind.Nested, NestedAggregate._DESERIALIZER)
            .addMember(Kind.Parent, ParentAggregate._DESERIALIZER)
            .addMember(Kind.PercentilesBucket, PercentilesBucketAggregate._DESERIALIZER)
            .addMember(Kind.Range, RangeAggregate._DESERIALIZER)
            .addMember(Kind.Rate, RateAggregate._DESERIALIZER)
            .addMember(Kind.ReverseNested, ReverseNestedAggregate._DESERIALIZER)
            .addMember(Kind.Sampler, SamplerAggregate._DESERIALIZER)
            .addMember(Kind.ScriptedMetric, ScriptedMetricAggregate._DESERIALIZER)
            .addMember(Kind.Siglterms, SignificantLongTermsAggregate._DESERIALIZER)
            .addMember(Kind.Sigsterms, SignificantStringTermsAggregate._DESERIALIZER)
            .addMember(Kind.SimpleLongValue, CumulativeCardinalityAggregate._DESERIALIZER)
            .addMember(Kind.SimpleValue, SimpleValueAggregate._DESERIALIZER)
            .addMember(Kind.Srareterms, StringRareTermsAggregate._DESERIALIZER)
            .addMember(Kind.Stats, StatsAggregate._DESERIALIZER)
            .addMember(Kind.StatsBucket, StatsBucketAggregate._DESERIALIZER)
            .addMember(Kind.Sterms, StringTermsAggregate._DESERIALIZER)
            .addMember(Kind.Sum, SumAggregate._DESERIALIZER)
            .addMember(Kind.TTest, TTestAggregate._DESERIALIZER)
            .addMember(Kind.TdigestPercentileRanks, TDigestPercentileRanksAggregate._DESERIALIZER)
            .addMember(Kind.TdigestPercentiles, TDigestPercentilesAggregate._DESERIALIZER)
            .addMember(Kind.TopHits, TopHitsAggregate._DESERIALIZER)
            .addMember(Kind.Ulterms, UnsignedLongTermsAggregate._DESERIALIZER)
            .addMember(Kind.Umrareterms, UnmappedRareTermsAggregate._DESERIALIZER)
            .addMember(Kind.Umsigterms, UnmappedSignificantTermsAggregate._DESERIALIZER)
            .addMember(Kind.Umterms, UnmappedTermsAggregate._DESERIALIZER)
            .addMember(Kind.ValueCount, ValueCountAggregate._DESERIALIZER)
            .addMember(Kind.VariableWidthHistogram, VariableWidthHistogramAggregate._DESERIALIZER)
            .addMember(Kind.WeightedAvg, WeightedAvgAggregate._DESERIALIZER)
            .build();
    }

    public static final JsonpDeserializer<Aggregate> _DESERIALIZER = JsonpDeserializer.lazy(Aggregate::buildAggregateDeserializer);

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this._kind);
        result = 31 * result + Objects.hashCode(this._value);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Aggregate other = (Aggregate) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
