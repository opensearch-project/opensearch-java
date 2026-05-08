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
import org.opensearch.client.opensearch._types.query_dsl.AgenticQuery;
import org.opensearch.client.opensearch._types.query_dsl.BoolQuery;
import org.opensearch.client.opensearch._types.query_dsl.BoostingQuery;
import org.opensearch.client.opensearch._types.query_dsl.CombinedFieldsQuery;
import org.opensearch.client.opensearch._types.query_dsl.CommonTermsQuery;
import org.opensearch.client.opensearch._types.query_dsl.ConstantScoreQuery;
import org.opensearch.client.opensearch._types.query_dsl.DisMaxQuery;
import org.opensearch.client.opensearch._types.query_dsl.DistanceFeatureQuery;
import org.opensearch.client.opensearch._types.query_dsl.ExistsQuery;
import org.opensearch.client.opensearch._types.query_dsl.FunctionScoreQuery;
import org.opensearch.client.opensearch._types.query_dsl.FuzzyQuery;
import org.opensearch.client.opensearch._types.query_dsl.GeoBoundingBoxQuery;
import org.opensearch.client.opensearch._types.query_dsl.GeoDistanceQuery;
import org.opensearch.client.opensearch._types.query_dsl.GeoPolygonQuery;
import org.opensearch.client.opensearch._types.query_dsl.GeoShapeQuery;
import org.opensearch.client.opensearch._types.query_dsl.HasChildQuery;
import org.opensearch.client.opensearch._types.query_dsl.HasParentQuery;
import org.opensearch.client.opensearch._types.query_dsl.HybridQuery;
import org.opensearch.client.opensearch._types.query_dsl.IdsQuery;
import org.opensearch.client.opensearch._types.query_dsl.IntervalsQuery;
import org.opensearch.client.opensearch._types.query_dsl.KnnQuery;
import org.opensearch.client.opensearch._types.query_dsl.MatchAllQuery;
import org.opensearch.client.opensearch._types.query_dsl.MatchBoolPrefixQuery;
import org.opensearch.client.opensearch._types.query_dsl.MatchNoneQuery;
import org.opensearch.client.opensearch._types.query_dsl.MatchPhrasePrefixQuery;
import org.opensearch.client.opensearch._types.query_dsl.MatchPhraseQuery;
import org.opensearch.client.opensearch._types.query_dsl.MatchQuery;
import org.opensearch.client.opensearch._types.query_dsl.MoreLikeThisQuery;
import org.opensearch.client.opensearch._types.query_dsl.MultiMatchQuery;
import org.opensearch.client.opensearch._types.query_dsl.NestedQuery;
import org.opensearch.client.opensearch._types.query_dsl.NeuralQuery;
import org.opensearch.client.opensearch._types.query_dsl.ParentIdQuery;
import org.opensearch.client.opensearch._types.query_dsl.PercolateQuery;
import org.opensearch.client.opensearch._types.query_dsl.PrefixQuery;
import org.opensearch.client.opensearch._types.query_dsl.QueryStringQuery;
import org.opensearch.client.opensearch._types.query_dsl.RangeQuery;
import org.opensearch.client.opensearch._types.query_dsl.RankFeatureQuery;
import org.opensearch.client.opensearch._types.query_dsl.RegexpQuery;
import org.opensearch.client.opensearch._types.query_dsl.ScriptQuery;
import org.opensearch.client.opensearch._types.query_dsl.ScriptScoreQuery;
import org.opensearch.client.opensearch._types.query_dsl.SimpleQueryStringQuery;
import org.opensearch.client.opensearch._types.query_dsl.SpanContainingQuery;
import org.opensearch.client.opensearch._types.query_dsl.SpanFieldMaskingQuery;
import org.opensearch.client.opensearch._types.query_dsl.SpanFirstQuery;
import org.opensearch.client.opensearch._types.query_dsl.SpanMultiTermQuery;
import org.opensearch.client.opensearch._types.query_dsl.SpanNearQuery;
import org.opensearch.client.opensearch._types.query_dsl.SpanNotQuery;
import org.opensearch.client.opensearch._types.query_dsl.SpanOrQuery;
import org.opensearch.client.opensearch._types.query_dsl.SpanTermQuery;
import org.opensearch.client.opensearch._types.query_dsl.SpanWithinQuery;
import org.opensearch.client.opensearch._types.query_dsl.TermQuery;
import org.opensearch.client.opensearch._types.query_dsl.TermsQuery;
import org.opensearch.client.opensearch._types.query_dsl.TermsSetQuery;
import org.opensearch.client.opensearch._types.query_dsl.TypeQuery;
import org.opensearch.client.opensearch._types.query_dsl.WildcardQuery;
import org.opensearch.client.opensearch._types.query_dsl.WrapperQuery;
import org.opensearch.client.opensearch._types.query_dsl.XyShapeQuery;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.FilterAggregationFields

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FilterAggregationFields
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<FilterAggregationFields.Builder, FilterAggregationFields> {

    @Nullable
    private final AgenticQuery agentic;

    @Nullable
    private final BoolQuery bool;

    @Nullable
    private final BoostingQuery boosting;

    @Nullable
    private final CombinedFieldsQuery combinedFields;

    @Nullable
    private final CommonTermsQuery common;

    @Nullable
    private final ConstantScoreQuery constantScore;

    @Nullable
    private final DisMaxQuery disMax;

    @Nullable
    private final DistanceFeatureQuery distanceFeature;

    @Nullable
    private final ExistsQuery exists;

    @Nullable
    private final SpanFieldMaskingQuery fieldMaskingSpan;

    @Nullable
    private final FunctionScoreQuery functionScore;

    @Nullable
    private final FuzzyQuery fuzzy;

    @Nullable
    private final GeoBoundingBoxQuery geoBoundingBox;

    @Nullable
    private final GeoDistanceQuery geoDistance;

    @Nullable
    private final GeoPolygonQuery geoPolygon;

    @Nullable
    private final GeoShapeQuery geoShape;

    @Nullable
    private final HasChildQuery hasChild;

    @Nullable
    private final HasParentQuery hasParent;

    @Nullable
    private final HybridQuery hybrid;

    @Nullable
    private final IdsQuery ids;

    @Nullable
    private final IntervalsQuery intervals;

    @Nullable
    private final KnnQuery knn;

    @Nullable
    private final MatchQuery match;

    @Nullable
    private final MatchAllQuery matchAll;

    @Nullable
    private final MatchBoolPrefixQuery matchBoolPrefix;

    @Nullable
    private final MatchNoneQuery matchNone;

    @Nullable
    private final MatchPhraseQuery matchPhrase;

    @Nullable
    private final MatchPhrasePrefixQuery matchPhrasePrefix;

    @Nullable
    private final MoreLikeThisQuery moreLikeThis;

    @Nullable
    private final MultiMatchQuery multiMatch;

    @Nullable
    private final NestedQuery nested;

    @Nullable
    private final NeuralQuery neural;

    @Nullable
    private final ParentIdQuery parentId;

    @Nullable
    private final PercolateQuery percolate;

    @Nullable
    private final PrefixQuery prefix;

    @Nullable
    private final QueryStringQuery queryString;

    @Nullable
    private final RangeQuery range;

    @Nullable
    private final RankFeatureQuery rankFeature;

    @Nullable
    private final RegexpQuery regexp;

    @Nullable
    private final ScriptQuery script;

    @Nullable
    private final ScriptScoreQuery scriptScore;

    @Nullable
    private final SimpleQueryStringQuery simpleQueryString;

    @Nullable
    private final SpanContainingQuery spanContaining;

    @Nullable
    private final SpanFirstQuery spanFirst;

    @Nullable
    private final SpanMultiTermQuery spanMulti;

    @Nullable
    private final SpanNearQuery spanNear;

    @Nullable
    private final SpanNotQuery spanNot;

    @Nullable
    private final SpanOrQuery spanOr;

    @Nullable
    private final SpanTermQuery spanTerm;

    @Nullable
    private final SpanWithinQuery spanWithin;

    @Nonnull
    private final Map<String, JsonData> template;

    @Nullable
    private final TermQuery term;

    @Nullable
    private final TermsQuery terms;

    @Nullable
    private final TermsSetQuery termsSet;

    @Nullable
    private final TypeQuery type;

    @Nullable
    private final WildcardQuery wildcard;

    @Nullable
    private final WrapperQuery wrapper;

    @Nullable
    private final XyShapeQuery xyShape;

    // ---------------------------------------------------------------------------------------------

    private FilterAggregationFields(Builder builder) {
        this.agentic = builder.agentic;
        this.bool = builder.bool;
        this.boosting = builder.boosting;
        this.combinedFields = builder.combinedFields;
        this.common = builder.common;
        this.constantScore = builder.constantScore;
        this.disMax = builder.disMax;
        this.distanceFeature = builder.distanceFeature;
        this.exists = builder.exists;
        this.fieldMaskingSpan = builder.fieldMaskingSpan;
        this.functionScore = builder.functionScore;
        this.fuzzy = builder.fuzzy;
        this.geoBoundingBox = builder.geoBoundingBox;
        this.geoDistance = builder.geoDistance;
        this.geoPolygon = builder.geoPolygon;
        this.geoShape = builder.geoShape;
        this.hasChild = builder.hasChild;
        this.hasParent = builder.hasParent;
        this.hybrid = builder.hybrid;
        this.ids = builder.ids;
        this.intervals = builder.intervals;
        this.knn = builder.knn;
        this.match = builder.match;
        this.matchAll = builder.matchAll;
        this.matchBoolPrefix = builder.matchBoolPrefix;
        this.matchNone = builder.matchNone;
        this.matchPhrase = builder.matchPhrase;
        this.matchPhrasePrefix = builder.matchPhrasePrefix;
        this.moreLikeThis = builder.moreLikeThis;
        this.multiMatch = builder.multiMatch;
        this.nested = builder.nested;
        this.neural = builder.neural;
        this.parentId = builder.parentId;
        this.percolate = builder.percolate;
        this.prefix = builder.prefix;
        this.queryString = builder.queryString;
        this.range = builder.range;
        this.rankFeature = builder.rankFeature;
        this.regexp = builder.regexp;
        this.script = builder.script;
        this.scriptScore = builder.scriptScore;
        this.simpleQueryString = builder.simpleQueryString;
        this.spanContaining = builder.spanContaining;
        this.spanFirst = builder.spanFirst;
        this.spanMulti = builder.spanMulti;
        this.spanNear = builder.spanNear;
        this.spanNot = builder.spanNot;
        this.spanOr = builder.spanOr;
        this.spanTerm = builder.spanTerm;
        this.spanWithin = builder.spanWithin;
        this.template = ApiTypeHelper.unmodifiable(builder.template);
        this.term = builder.term;
        this.terms = builder.terms;
        this.termsSet = builder.termsSet;
        this.type = builder.type;
        this.wildcard = builder.wildcard;
        this.wrapper = builder.wrapper;
        this.xyShape = builder.xyShape;
    }

    public static FilterAggregationFields of(Function<FilterAggregationFields.Builder, ObjectBuilder<FilterAggregationFields>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code agentic}
     */
    @Nullable
    public final AgenticQuery agentic() {
        return this.agentic;
    }

    /**
     * API name: {@code bool}
     */
    @Nullable
    public final BoolQuery bool() {
        return this.bool;
    }

    /**
     * API name: {@code boosting}
     */
    @Nullable
    public final BoostingQuery boosting() {
        return this.boosting;
    }

    /**
     * API name: {@code combined_fields}
     */
    @Nullable
    public final CombinedFieldsQuery combinedFields() {
        return this.combinedFields;
    }

    /**
     * API name: {@code common}
     */
    @Nullable
    public final CommonTermsQuery common() {
        return this.common;
    }

    /**
     * API name: {@code constant_score}
     */
    @Nullable
    public final ConstantScoreQuery constantScore() {
        return this.constantScore;
    }

    /**
     * API name: {@code dis_max}
     */
    @Nullable
    public final DisMaxQuery disMax() {
        return this.disMax;
    }

    /**
     * API name: {@code distance_feature}
     */
    @Nullable
    public final DistanceFeatureQuery distanceFeature() {
        return this.distanceFeature;
    }

    /**
     * API name: {@code exists}
     */
    @Nullable
    public final ExistsQuery exists() {
        return this.exists;
    }

    /**
     * API name: {@code field_masking_span}
     */
    @Nullable
    public final SpanFieldMaskingQuery fieldMaskingSpan() {
        return this.fieldMaskingSpan;
    }

    /**
     * API name: {@code function_score}
     */
    @Nullable
    public final FunctionScoreQuery functionScore() {
        return this.functionScore;
    }

    /**
     * Returns documents that contain terms similar to the search term, as measured by a Levenshtein edit distance.
     * <p>
     * API name: {@code fuzzy}
     * </p>
     */
    @Nullable
    public final FuzzyQuery fuzzy() {
        return this.fuzzy;
    }

    /**
     * API name: {@code geo_bounding_box}
     */
    @Nullable
    public final GeoBoundingBoxQuery geoBoundingBox() {
        return this.geoBoundingBox;
    }

    /**
     * API name: {@code geo_distance}
     */
    @Nullable
    public final GeoDistanceQuery geoDistance() {
        return this.geoDistance;
    }

    /**
     * API name: {@code geo_polygon}
     */
    @Nullable
    public final GeoPolygonQuery geoPolygon() {
        return this.geoPolygon;
    }

    /**
     * API name: {@code geo_shape}
     */
    @Nullable
    public final GeoShapeQuery geoShape() {
        return this.geoShape;
    }

    /**
     * API name: {@code has_child}
     */
    @Nullable
    public final HasChildQuery hasChild() {
        return this.hasChild;
    }

    /**
     * API name: {@code has_parent}
     */
    @Nullable
    public final HasParentQuery hasParent() {
        return this.hasParent;
    }

    /**
     * API name: {@code hybrid}
     */
    @Nullable
    public final HybridQuery hybrid() {
        return this.hybrid;
    }

    /**
     * API name: {@code ids}
     */
    @Nullable
    public final IdsQuery ids() {
        return this.ids;
    }

    /**
     * Returns documents based on the order and proximity of matching terms.
     * <p>
     * API name: {@code intervals}
     * </p>
     */
    @Nullable
    public final IntervalsQuery intervals() {
        return this.intervals;
    }

    /**
     * API name: {@code knn}
     */
    @Nullable
    public final KnnQuery knn() {
        return this.knn;
    }

    /**
     * Returns documents that match a provided text, number, date or Boolean value. The provided text is analyzed before matching.
     * <p>
     * API name: {@code match}
     * </p>
     */
    @Nullable
    public final MatchQuery match() {
        return this.match;
    }

    /**
     * API name: {@code match_all}
     */
    @Nullable
    public final MatchAllQuery matchAll() {
        return this.matchAll;
    }

    /**
     * Analyzes its input and constructs a <code>bool</code> query from the terms. Each term except the last is used in a <code>term</code>
     * query. The last term is used in a prefix query.
     * <p>
     * API name: {@code match_bool_prefix}
     * </p>
     */
    @Nullable
    public final MatchBoolPrefixQuery matchBoolPrefix() {
        return this.matchBoolPrefix;
    }

    /**
     * API name: {@code match_none}
     */
    @Nullable
    public final MatchNoneQuery matchNone() {
        return this.matchNone;
    }

    /**
     * Analyzes the text and creates a phrase query out of the analyzed text.
     * <p>
     * API name: {@code match_phrase}
     * </p>
     */
    @Nullable
    public final MatchPhraseQuery matchPhrase() {
        return this.matchPhrase;
    }

    /**
     * Returns documents that contain the words of a provided text, in the same order as provided. The last term of the provided text is
     * treated as a prefix, matching any words that begin with that term.
     * <p>
     * API name: {@code match_phrase_prefix}
     * </p>
     */
    @Nullable
    public final MatchPhrasePrefixQuery matchPhrasePrefix() {
        return this.matchPhrasePrefix;
    }

    /**
     * API name: {@code more_like_this}
     */
    @Nullable
    public final MoreLikeThisQuery moreLikeThis() {
        return this.moreLikeThis;
    }

    /**
     * API name: {@code multi_match}
     */
    @Nullable
    public final MultiMatchQuery multiMatch() {
        return this.multiMatch;
    }

    /**
     * API name: {@code nested}
     */
    @Nullable
    public final NestedQuery nested() {
        return this.nested;
    }

    /**
     * API name: {@code neural}
     */
    @Nullable
    public final NeuralQuery neural() {
        return this.neural;
    }

    /**
     * API name: {@code parent_id}
     */
    @Nullable
    public final ParentIdQuery parentId() {
        return this.parentId;
    }

    /**
     * API name: {@code percolate}
     */
    @Nullable
    public final PercolateQuery percolate() {
        return this.percolate;
    }

    /**
     * Returns documents that contain a specific prefix in a provided field.
     * <p>
     * API name: {@code prefix}
     * </p>
     */
    @Nullable
    public final PrefixQuery prefix() {
        return this.prefix;
    }

    /**
     * API name: {@code query_string}
     */
    @Nullable
    public final QueryStringQuery queryString() {
        return this.queryString;
    }

    /**
     * Returns documents that contain terms within a provided range.
     * <p>
     * API name: {@code range}
     * </p>
     */
    @Nullable
    public final RangeQuery range() {
        return this.range;
    }

    /**
     * API name: {@code rank_feature}
     */
    @Nullable
    public final RankFeatureQuery rankFeature() {
        return this.rankFeature;
    }

    /**
     * Returns documents that contain terms matching a regular expression.
     * <p>
     * API name: {@code regexp}
     * </p>
     */
    @Nullable
    public final RegexpQuery regexp() {
        return this.regexp;
    }

    /**
     * API name: {@code script}
     */
    @Nullable
    public final ScriptQuery script() {
        return this.script;
    }

    /**
     * API name: {@code script_score}
     */
    @Nullable
    public final ScriptScoreQuery scriptScore() {
        return this.scriptScore;
    }

    /**
     * API name: {@code simple_query_string}
     */
    @Nullable
    public final SimpleQueryStringQuery simpleQueryString() {
        return this.simpleQueryString;
    }

    /**
     * API name: {@code span_containing}
     */
    @Nullable
    public final SpanContainingQuery spanContaining() {
        return this.spanContaining;
    }

    /**
     * API name: {@code span_first}
     */
    @Nullable
    public final SpanFirstQuery spanFirst() {
        return this.spanFirst;
    }

    /**
     * API name: {@code span_multi}
     */
    @Nullable
    public final SpanMultiTermQuery spanMulti() {
        return this.spanMulti;
    }

    /**
     * API name: {@code span_near}
     */
    @Nullable
    public final SpanNearQuery spanNear() {
        return this.spanNear;
    }

    /**
     * API name: {@code span_not}
     */
    @Nullable
    public final SpanNotQuery spanNot() {
        return this.spanNot;
    }

    /**
     * API name: {@code span_or}
     */
    @Nullable
    public final SpanOrQuery spanOr() {
        return this.spanOr;
    }

    /**
     * Matches spans containing a term.
     * <p>
     * API name: {@code span_term}
     * </p>
     */
    @Nullable
    public final SpanTermQuery spanTerm() {
        return this.spanTerm;
    }

    /**
     * API name: {@code span_within}
     */
    @Nullable
    public final SpanWithinQuery spanWithin() {
        return this.spanWithin;
    }

    /**
     * Return documents using a template query contains placeholders that are resolved by search request processors during query execution.
     * <p>
     * API name: {@code template}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> template() {
        return this.template;
    }

    /**
     * Returns documents that contain an exact term in a provided field. To return a document, the query term must exactly match the queried
     * field's value, including white space and capitalization.
     * <p>
     * API name: {@code term}
     * </p>
     */
    @Nullable
    public final TermQuery term() {
        return this.term;
    }

    /**
     * Returns documents that contain one or more exact terms in a provided field.
     * <p>
     * API name: {@code terms}
     * </p>
     */
    @Nullable
    public final TermsQuery terms() {
        return this.terms;
    }

    /**
     * Returns documents that contain a minimum number of exact terms in a provided field. To return a document, a required number of terms
     * must exactly match the field values, including white space and capitalization.
     * <p>
     * API name: {@code terms_set}
     * </p>
     */
    @Nullable
    public final TermsSetQuery termsSet() {
        return this.termsSet;
    }

    /**
     * API name: {@code type}
     */
    @Nullable
    public final TypeQuery type() {
        return this.type;
    }

    /**
     * Returns documents that contain terms matching a wildcard pattern.
     * <p>
     * API name: {@code wildcard}
     * </p>
     */
    @Nullable
    public final WildcardQuery wildcard() {
        return this.wildcard;
    }

    /**
     * API name: {@code wrapper}
     */
    @Nullable
    public final WrapperQuery wrapper() {
        return this.wrapper;
    }

    /**
     * API name: {@code xy_shape}
     */
    @Nullable
    public final XyShapeQuery xyShape() {
        return this.xyShape;
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
        if (this.agentic != null) {
            generator.writeKey("agentic");
            this.agentic.serialize(generator, mapper);
        }

        if (this.bool != null) {
            generator.writeKey("bool");
            this.bool.serialize(generator, mapper);
        }

        if (this.boosting != null) {
            generator.writeKey("boosting");
            this.boosting.serialize(generator, mapper);
        }

        if (this.combinedFields != null) {
            generator.writeKey("combined_fields");
            this.combinedFields.serialize(generator, mapper);
        }

        if (this.common != null) {
            generator.writeKey("common");
            this.common.serialize(generator, mapper);
        }

        if (this.constantScore != null) {
            generator.writeKey("constant_score");
            this.constantScore.serialize(generator, mapper);
        }

        if (this.disMax != null) {
            generator.writeKey("dis_max");
            this.disMax.serialize(generator, mapper);
        }

        if (this.distanceFeature != null) {
            generator.writeKey("distance_feature");
            this.distanceFeature.serialize(generator, mapper);
        }

        if (this.exists != null) {
            generator.writeKey("exists");
            this.exists.serialize(generator, mapper);
        }

        if (this.fieldMaskingSpan != null) {
            generator.writeKey("field_masking_span");
            this.fieldMaskingSpan.serialize(generator, mapper);
        }

        if (this.functionScore != null) {
            generator.writeKey("function_score");
            this.functionScore.serialize(generator, mapper);
        }

        if (this.fuzzy != null) {
            generator.writeKey("fuzzy");
            this.fuzzy.serialize(generator, mapper);
        }

        if (this.geoBoundingBox != null) {
            generator.writeKey("geo_bounding_box");
            this.geoBoundingBox.serialize(generator, mapper);
        }

        if (this.geoDistance != null) {
            generator.writeKey("geo_distance");
            this.geoDistance.serialize(generator, mapper);
        }

        if (this.geoPolygon != null) {
            generator.writeKey("geo_polygon");
            this.geoPolygon.serialize(generator, mapper);
        }

        if (this.geoShape != null) {
            generator.writeKey("geo_shape");
            this.geoShape.serialize(generator, mapper);
        }

        if (this.hasChild != null) {
            generator.writeKey("has_child");
            this.hasChild.serialize(generator, mapper);
        }

        if (this.hasParent != null) {
            generator.writeKey("has_parent");
            this.hasParent.serialize(generator, mapper);
        }

        if (this.hybrid != null) {
            generator.writeKey("hybrid");
            this.hybrid.serialize(generator, mapper);
        }

        if (this.ids != null) {
            generator.writeKey("ids");
            this.ids.serialize(generator, mapper);
        }

        if (this.intervals != null) {
            generator.writeKey("intervals");
            this.intervals.serialize(generator, mapper);
        }

        if (this.knn != null) {
            generator.writeKey("knn");
            this.knn.serialize(generator, mapper);
        }

        if (this.match != null) {
            generator.writeKey("match");
            this.match.serialize(generator, mapper);
        }

        if (this.matchAll != null) {
            generator.writeKey("match_all");
            this.matchAll.serialize(generator, mapper);
        }

        if (this.matchBoolPrefix != null) {
            generator.writeKey("match_bool_prefix");
            this.matchBoolPrefix.serialize(generator, mapper);
        }

        if (this.matchNone != null) {
            generator.writeKey("match_none");
            this.matchNone.serialize(generator, mapper);
        }

        if (this.matchPhrase != null) {
            generator.writeKey("match_phrase");
            this.matchPhrase.serialize(generator, mapper);
        }

        if (this.matchPhrasePrefix != null) {
            generator.writeKey("match_phrase_prefix");
            this.matchPhrasePrefix.serialize(generator, mapper);
        }

        if (this.moreLikeThis != null) {
            generator.writeKey("more_like_this");
            this.moreLikeThis.serialize(generator, mapper);
        }

        if (this.multiMatch != null) {
            generator.writeKey("multi_match");
            this.multiMatch.serialize(generator, mapper);
        }

        if (this.nested != null) {
            generator.writeKey("nested");
            this.nested.serialize(generator, mapper);
        }

        if (this.neural != null) {
            generator.writeKey("neural");
            this.neural.serialize(generator, mapper);
        }

        if (this.parentId != null) {
            generator.writeKey("parent_id");
            this.parentId.serialize(generator, mapper);
        }

        if (this.percolate != null) {
            generator.writeKey("percolate");
            this.percolate.serialize(generator, mapper);
        }

        if (this.prefix != null) {
            generator.writeKey("prefix");
            this.prefix.serialize(generator, mapper);
        }

        if (this.queryString != null) {
            generator.writeKey("query_string");
            this.queryString.serialize(generator, mapper);
        }

        if (this.range != null) {
            generator.writeKey("range");
            this.range.serialize(generator, mapper);
        }

        if (this.rankFeature != null) {
            generator.writeKey("rank_feature");
            this.rankFeature.serialize(generator, mapper);
        }

        if (this.regexp != null) {
            generator.writeKey("regexp");
            this.regexp.serialize(generator, mapper);
        }

        if (this.script != null) {
            generator.writeKey("script");
            this.script.serialize(generator, mapper);
        }

        if (this.scriptScore != null) {
            generator.writeKey("script_score");
            this.scriptScore.serialize(generator, mapper);
        }

        if (this.simpleQueryString != null) {
            generator.writeKey("simple_query_string");
            this.simpleQueryString.serialize(generator, mapper);
        }

        if (this.spanContaining != null) {
            generator.writeKey("span_containing");
            this.spanContaining.serialize(generator, mapper);
        }

        if (this.spanFirst != null) {
            generator.writeKey("span_first");
            this.spanFirst.serialize(generator, mapper);
        }

        if (this.spanMulti != null) {
            generator.writeKey("span_multi");
            this.spanMulti.serialize(generator, mapper);
        }

        if (this.spanNear != null) {
            generator.writeKey("span_near");
            this.spanNear.serialize(generator, mapper);
        }

        if (this.spanNot != null) {
            generator.writeKey("span_not");
            this.spanNot.serialize(generator, mapper);
        }

        if (this.spanOr != null) {
            generator.writeKey("span_or");
            this.spanOr.serialize(generator, mapper);
        }

        if (this.spanTerm != null) {
            generator.writeKey("span_term");
            this.spanTerm.serialize(generator, mapper);
        }

        if (this.spanWithin != null) {
            generator.writeKey("span_within");
            this.spanWithin.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.template)) {
            generator.writeKey("template");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.template.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.term != null) {
            generator.writeKey("term");
            this.term.serialize(generator, mapper);
        }

        if (this.terms != null) {
            generator.writeKey("terms");
            this.terms.serialize(generator, mapper);
        }

        if (this.termsSet != null) {
            generator.writeKey("terms_set");
            this.termsSet.serialize(generator, mapper);
        }

        if (this.type != null) {
            generator.writeKey("type");
            this.type.serialize(generator, mapper);
        }

        if (this.wildcard != null) {
            generator.writeKey("wildcard");
            this.wildcard.serialize(generator, mapper);
        }

        if (this.wrapper != null) {
            generator.writeKey("wrapper");
            this.wrapper.serialize(generator, mapper);
        }

        if (this.xyShape != null) {
            generator.writeKey("xy_shape");
            this.xyShape.serialize(generator, mapper);
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
     * Builder for {@link FilterAggregationFields}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, FilterAggregationFields> {
        @Nullable
        private AgenticQuery agentic;
        @Nullable
        private BoolQuery bool;
        @Nullable
        private BoostingQuery boosting;
        @Nullable
        private CombinedFieldsQuery combinedFields;
        @Nullable
        private CommonTermsQuery common;
        @Nullable
        private ConstantScoreQuery constantScore;
        @Nullable
        private DisMaxQuery disMax;
        @Nullable
        private DistanceFeatureQuery distanceFeature;
        @Nullable
        private ExistsQuery exists;
        @Nullable
        private SpanFieldMaskingQuery fieldMaskingSpan;
        @Nullable
        private FunctionScoreQuery functionScore;
        @Nullable
        private FuzzyQuery fuzzy;
        @Nullable
        private GeoBoundingBoxQuery geoBoundingBox;
        @Nullable
        private GeoDistanceQuery geoDistance;
        @Nullable
        private GeoPolygonQuery geoPolygon;
        @Nullable
        private GeoShapeQuery geoShape;
        @Nullable
        private HasChildQuery hasChild;
        @Nullable
        private HasParentQuery hasParent;
        @Nullable
        private HybridQuery hybrid;
        @Nullable
        private IdsQuery ids;
        @Nullable
        private IntervalsQuery intervals;
        @Nullable
        private KnnQuery knn;
        @Nullable
        private MatchQuery match;
        @Nullable
        private MatchAllQuery matchAll;
        @Nullable
        private MatchBoolPrefixQuery matchBoolPrefix;
        @Nullable
        private MatchNoneQuery matchNone;
        @Nullable
        private MatchPhraseQuery matchPhrase;
        @Nullable
        private MatchPhrasePrefixQuery matchPhrasePrefix;
        @Nullable
        private MoreLikeThisQuery moreLikeThis;
        @Nullable
        private MultiMatchQuery multiMatch;
        @Nullable
        private NestedQuery nested;
        @Nullable
        private NeuralQuery neural;
        @Nullable
        private ParentIdQuery parentId;
        @Nullable
        private PercolateQuery percolate;
        @Nullable
        private PrefixQuery prefix;
        @Nullable
        private QueryStringQuery queryString;
        @Nullable
        private RangeQuery range;
        @Nullable
        private RankFeatureQuery rankFeature;
        @Nullable
        private RegexpQuery regexp;
        @Nullable
        private ScriptQuery script;
        @Nullable
        private ScriptScoreQuery scriptScore;
        @Nullable
        private SimpleQueryStringQuery simpleQueryString;
        @Nullable
        private SpanContainingQuery spanContaining;
        @Nullable
        private SpanFirstQuery spanFirst;
        @Nullable
        private SpanMultiTermQuery spanMulti;
        @Nullable
        private SpanNearQuery spanNear;
        @Nullable
        private SpanNotQuery spanNot;
        @Nullable
        private SpanOrQuery spanOr;
        @Nullable
        private SpanTermQuery spanTerm;
        @Nullable
        private SpanWithinQuery spanWithin;
        @Nullable
        private Map<String, JsonData> template;
        @Nullable
        private TermQuery term;
        @Nullable
        private TermsQuery terms;
        @Nullable
        private TermsSetQuery termsSet;
        @Nullable
        private TypeQuery type;
        @Nullable
        private WildcardQuery wildcard;
        @Nullable
        private WrapperQuery wrapper;
        @Nullable
        private XyShapeQuery xyShape;

        public Builder() {}

        private Builder(FilterAggregationFields o) {
            this.agentic = o.agentic;
            this.bool = o.bool;
            this.boosting = o.boosting;
            this.combinedFields = o.combinedFields;
            this.common = o.common;
            this.constantScore = o.constantScore;
            this.disMax = o.disMax;
            this.distanceFeature = o.distanceFeature;
            this.exists = o.exists;
            this.fieldMaskingSpan = o.fieldMaskingSpan;
            this.functionScore = o.functionScore;
            this.fuzzy = o.fuzzy;
            this.geoBoundingBox = o.geoBoundingBox;
            this.geoDistance = o.geoDistance;
            this.geoPolygon = o.geoPolygon;
            this.geoShape = o.geoShape;
            this.hasChild = o.hasChild;
            this.hasParent = o.hasParent;
            this.hybrid = o.hybrid;
            this.ids = o.ids;
            this.intervals = o.intervals;
            this.knn = o.knn;
            this.match = o.match;
            this.matchAll = o.matchAll;
            this.matchBoolPrefix = o.matchBoolPrefix;
            this.matchNone = o.matchNone;
            this.matchPhrase = o.matchPhrase;
            this.matchPhrasePrefix = o.matchPhrasePrefix;
            this.moreLikeThis = o.moreLikeThis;
            this.multiMatch = o.multiMatch;
            this.nested = o.nested;
            this.neural = o.neural;
            this.parentId = o.parentId;
            this.percolate = o.percolate;
            this.prefix = o.prefix;
            this.queryString = o.queryString;
            this.range = o.range;
            this.rankFeature = o.rankFeature;
            this.regexp = o.regexp;
            this.script = o.script;
            this.scriptScore = o.scriptScore;
            this.simpleQueryString = o.simpleQueryString;
            this.spanContaining = o.spanContaining;
            this.spanFirst = o.spanFirst;
            this.spanMulti = o.spanMulti;
            this.spanNear = o.spanNear;
            this.spanNot = o.spanNot;
            this.spanOr = o.spanOr;
            this.spanTerm = o.spanTerm;
            this.spanWithin = o.spanWithin;
            this.template = _mapCopy(o.template);
            this.term = o.term;
            this.terms = o.terms;
            this.termsSet = o.termsSet;
            this.type = o.type;
            this.wildcard = o.wildcard;
            this.wrapper = o.wrapper;
            this.xyShape = o.xyShape;
        }

        private Builder(Builder o) {
            this.agentic = o.agentic;
            this.bool = o.bool;
            this.boosting = o.boosting;
            this.combinedFields = o.combinedFields;
            this.common = o.common;
            this.constantScore = o.constantScore;
            this.disMax = o.disMax;
            this.distanceFeature = o.distanceFeature;
            this.exists = o.exists;
            this.fieldMaskingSpan = o.fieldMaskingSpan;
            this.functionScore = o.functionScore;
            this.fuzzy = o.fuzzy;
            this.geoBoundingBox = o.geoBoundingBox;
            this.geoDistance = o.geoDistance;
            this.geoPolygon = o.geoPolygon;
            this.geoShape = o.geoShape;
            this.hasChild = o.hasChild;
            this.hasParent = o.hasParent;
            this.hybrid = o.hybrid;
            this.ids = o.ids;
            this.intervals = o.intervals;
            this.knn = o.knn;
            this.match = o.match;
            this.matchAll = o.matchAll;
            this.matchBoolPrefix = o.matchBoolPrefix;
            this.matchNone = o.matchNone;
            this.matchPhrase = o.matchPhrase;
            this.matchPhrasePrefix = o.matchPhrasePrefix;
            this.moreLikeThis = o.moreLikeThis;
            this.multiMatch = o.multiMatch;
            this.nested = o.nested;
            this.neural = o.neural;
            this.parentId = o.parentId;
            this.percolate = o.percolate;
            this.prefix = o.prefix;
            this.queryString = o.queryString;
            this.range = o.range;
            this.rankFeature = o.rankFeature;
            this.regexp = o.regexp;
            this.script = o.script;
            this.scriptScore = o.scriptScore;
            this.simpleQueryString = o.simpleQueryString;
            this.spanContaining = o.spanContaining;
            this.spanFirst = o.spanFirst;
            this.spanMulti = o.spanMulti;
            this.spanNear = o.spanNear;
            this.spanNot = o.spanNot;
            this.spanOr = o.spanOr;
            this.spanTerm = o.spanTerm;
            this.spanWithin = o.spanWithin;
            this.template = _mapCopy(o.template);
            this.term = o.term;
            this.terms = o.terms;
            this.termsSet = o.termsSet;
            this.type = o.type;
            this.wildcard = o.wildcard;
            this.wrapper = o.wrapper;
            this.xyShape = o.xyShape;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code agentic}
         */
        @Nonnull
        public final Builder agentic(@Nullable AgenticQuery value) {
            this.agentic = value;
            return this;
        }

        /**
         * API name: {@code agentic}
         */
        @Nonnull
        public final Builder agentic(Function<AgenticQuery.Builder, ObjectBuilder<AgenticQuery>> fn) {
            return agentic(fn.apply(new AgenticQuery.Builder()).build());
        }

        /**
         * API name: {@code bool}
         */
        @Nonnull
        public final Builder bool(@Nullable BoolQuery value) {
            this.bool = value;
            return this;
        }

        /**
         * API name: {@code bool}
         */
        @Nonnull
        public final Builder bool(Function<BoolQuery.Builder, ObjectBuilder<BoolQuery>> fn) {
            return bool(fn.apply(new BoolQuery.Builder()).build());
        }

        /**
         * API name: {@code boosting}
         */
        @Nonnull
        public final Builder boosting(@Nullable BoostingQuery value) {
            this.boosting = value;
            return this;
        }

        /**
         * API name: {@code boosting}
         */
        @Nonnull
        public final Builder boosting(Function<BoostingQuery.Builder, ObjectBuilder<BoostingQuery>> fn) {
            return boosting(fn.apply(new BoostingQuery.Builder()).build());
        }

        /**
         * API name: {@code combined_fields}
         */
        @Nonnull
        public final Builder combinedFields(@Nullable CombinedFieldsQuery value) {
            this.combinedFields = value;
            return this;
        }

        /**
         * API name: {@code combined_fields}
         */
        @Nonnull
        public final Builder combinedFields(Function<CombinedFieldsQuery.Builder, ObjectBuilder<CombinedFieldsQuery>> fn) {
            return combinedFields(fn.apply(new CombinedFieldsQuery.Builder()).build());
        }

        /**
         * API name: {@code common}
         */
        @Nonnull
        public final Builder common(@Nullable CommonTermsQuery value) {
            this.common = value;
            return this;
        }

        /**
         * API name: {@code common}
         */
        @Nonnull
        public final Builder common(Function<CommonTermsQuery.Builder, ObjectBuilder<CommonTermsQuery>> fn) {
            return common(fn.apply(new CommonTermsQuery.Builder()).build());
        }

        /**
         * API name: {@code constant_score}
         */
        @Nonnull
        public final Builder constantScore(@Nullable ConstantScoreQuery value) {
            this.constantScore = value;
            return this;
        }

        /**
         * API name: {@code constant_score}
         */
        @Nonnull
        public final Builder constantScore(Function<ConstantScoreQuery.Builder, ObjectBuilder<ConstantScoreQuery>> fn) {
            return constantScore(fn.apply(new ConstantScoreQuery.Builder()).build());
        }

        /**
         * API name: {@code dis_max}
         */
        @Nonnull
        public final Builder disMax(@Nullable DisMaxQuery value) {
            this.disMax = value;
            return this;
        }

        /**
         * API name: {@code dis_max}
         */
        @Nonnull
        public final Builder disMax(Function<DisMaxQuery.Builder, ObjectBuilder<DisMaxQuery>> fn) {
            return disMax(fn.apply(new DisMaxQuery.Builder()).build());
        }

        /**
         * API name: {@code distance_feature}
         */
        @Nonnull
        public final Builder distanceFeature(@Nullable DistanceFeatureQuery value) {
            this.distanceFeature = value;
            return this;
        }

        /**
         * API name: {@code distance_feature}
         */
        @Nonnull
        public final Builder distanceFeature(Function<DistanceFeatureQuery.Builder, ObjectBuilder<DistanceFeatureQuery>> fn) {
            return distanceFeature(fn.apply(new DistanceFeatureQuery.Builder()).build());
        }

        /**
         * API name: {@code exists}
         */
        @Nonnull
        public final Builder exists(@Nullable ExistsQuery value) {
            this.exists = value;
            return this;
        }

        /**
         * API name: {@code exists}
         */
        @Nonnull
        public final Builder exists(Function<ExistsQuery.Builder, ObjectBuilder<ExistsQuery>> fn) {
            return exists(fn.apply(new ExistsQuery.Builder()).build());
        }

        /**
         * API name: {@code field_masking_span}
         */
        @Nonnull
        public final Builder fieldMaskingSpan(@Nullable SpanFieldMaskingQuery value) {
            this.fieldMaskingSpan = value;
            return this;
        }

        /**
         * API name: {@code field_masking_span}
         */
        @Nonnull
        public final Builder fieldMaskingSpan(Function<SpanFieldMaskingQuery.Builder, ObjectBuilder<SpanFieldMaskingQuery>> fn) {
            return fieldMaskingSpan(fn.apply(new SpanFieldMaskingQuery.Builder()).build());
        }

        /**
         * API name: {@code function_score}
         */
        @Nonnull
        public final Builder functionScore(@Nullable FunctionScoreQuery value) {
            this.functionScore = value;
            return this;
        }

        /**
         * API name: {@code function_score}
         */
        @Nonnull
        public final Builder functionScore(Function<FunctionScoreQuery.Builder, ObjectBuilder<FunctionScoreQuery>> fn) {
            return functionScore(fn.apply(new FunctionScoreQuery.Builder()).build());
        }

        /**
         * Returns documents that contain terms similar to the search term, as measured by a Levenshtein edit distance.
         * <p>
         * API name: {@code fuzzy}
         * </p>
         */
        @Nonnull
        public final Builder fuzzy(@Nullable FuzzyQuery value) {
            this.fuzzy = value;
            return this;
        }

        /**
         * Returns documents that contain terms similar to the search term, as measured by a Levenshtein edit distance.
         * <p>
         * API name: {@code fuzzy}
         * </p>
         */
        @Nonnull
        public final Builder fuzzy(Function<FuzzyQuery.Builder, ObjectBuilder<FuzzyQuery>> fn) {
            return fuzzy(fn.apply(new FuzzyQuery.Builder()).build());
        }

        /**
         * API name: {@code geo_bounding_box}
         */
        @Nonnull
        public final Builder geoBoundingBox(@Nullable GeoBoundingBoxQuery value) {
            this.geoBoundingBox = value;
            return this;
        }

        /**
         * API name: {@code geo_bounding_box}
         */
        @Nonnull
        public final Builder geoBoundingBox(Function<GeoBoundingBoxQuery.Builder, ObjectBuilder<GeoBoundingBoxQuery>> fn) {
            return geoBoundingBox(fn.apply(new GeoBoundingBoxQuery.Builder()).build());
        }

        /**
         * API name: {@code geo_distance}
         */
        @Nonnull
        public final Builder geoDistance(@Nullable GeoDistanceQuery value) {
            this.geoDistance = value;
            return this;
        }

        /**
         * API name: {@code geo_distance}
         */
        @Nonnull
        public final Builder geoDistance(Function<GeoDistanceQuery.Builder, ObjectBuilder<GeoDistanceQuery>> fn) {
            return geoDistance(fn.apply(new GeoDistanceQuery.Builder()).build());
        }

        /**
         * API name: {@code geo_polygon}
         */
        @Nonnull
        public final Builder geoPolygon(@Nullable GeoPolygonQuery value) {
            this.geoPolygon = value;
            return this;
        }

        /**
         * API name: {@code geo_polygon}
         */
        @Nonnull
        public final Builder geoPolygon(Function<GeoPolygonQuery.Builder, ObjectBuilder<GeoPolygonQuery>> fn) {
            return geoPolygon(fn.apply(new GeoPolygonQuery.Builder()).build());
        }

        /**
         * API name: {@code geo_shape}
         */
        @Nonnull
        public final Builder geoShape(@Nullable GeoShapeQuery value) {
            this.geoShape = value;
            return this;
        }

        /**
         * API name: {@code geo_shape}
         */
        @Nonnull
        public final Builder geoShape(Function<GeoShapeQuery.Builder, ObjectBuilder<GeoShapeQuery>> fn) {
            return geoShape(fn.apply(new GeoShapeQuery.Builder()).build());
        }

        /**
         * API name: {@code has_child}
         */
        @Nonnull
        public final Builder hasChild(@Nullable HasChildQuery value) {
            this.hasChild = value;
            return this;
        }

        /**
         * API name: {@code has_child}
         */
        @Nonnull
        public final Builder hasChild(Function<HasChildQuery.Builder, ObjectBuilder<HasChildQuery>> fn) {
            return hasChild(fn.apply(new HasChildQuery.Builder()).build());
        }

        /**
         * API name: {@code has_parent}
         */
        @Nonnull
        public final Builder hasParent(@Nullable HasParentQuery value) {
            this.hasParent = value;
            return this;
        }

        /**
         * API name: {@code has_parent}
         */
        @Nonnull
        public final Builder hasParent(Function<HasParentQuery.Builder, ObjectBuilder<HasParentQuery>> fn) {
            return hasParent(fn.apply(new HasParentQuery.Builder()).build());
        }

        /**
         * API name: {@code hybrid}
         */
        @Nonnull
        public final Builder hybrid(@Nullable HybridQuery value) {
            this.hybrid = value;
            return this;
        }

        /**
         * API name: {@code hybrid}
         */
        @Nonnull
        public final Builder hybrid(Function<HybridQuery.Builder, ObjectBuilder<HybridQuery>> fn) {
            return hybrid(fn.apply(new HybridQuery.Builder()).build());
        }

        /**
         * API name: {@code ids}
         */
        @Nonnull
        public final Builder ids(@Nullable IdsQuery value) {
            this.ids = value;
            return this;
        }

        /**
         * API name: {@code ids}
         */
        @Nonnull
        public final Builder ids(Function<IdsQuery.Builder, ObjectBuilder<IdsQuery>> fn) {
            return ids(fn.apply(new IdsQuery.Builder()).build());
        }

        /**
         * Returns documents based on the order and proximity of matching terms.
         * <p>
         * API name: {@code intervals}
         * </p>
         */
        @Nonnull
        public final Builder intervals(@Nullable IntervalsQuery value) {
            this.intervals = value;
            return this;
        }

        /**
         * Returns documents based on the order and proximity of matching terms.
         * <p>
         * API name: {@code intervals}
         * </p>
         */
        @Nonnull
        public final Builder intervals(Function<IntervalsQuery.Builder, ObjectBuilder<IntervalsQuery>> fn) {
            return intervals(fn.apply(new IntervalsQuery.Builder()).build());
        }

        /**
         * API name: {@code knn}
         */
        @Nonnull
        public final Builder knn(@Nullable KnnQuery value) {
            this.knn = value;
            return this;
        }

        /**
         * API name: {@code knn}
         */
        @Nonnull
        public final Builder knn(Function<KnnQuery.Builder, ObjectBuilder<KnnQuery>> fn) {
            return knn(fn.apply(new KnnQuery.Builder()).build());
        }

        /**
         * Returns documents that match a provided text, number, date or Boolean value. The provided text is analyzed before matching.
         * <p>
         * API name: {@code match}
         * </p>
         */
        @Nonnull
        public final Builder match(@Nullable MatchQuery value) {
            this.match = value;
            return this;
        }

        /**
         * Returns documents that match a provided text, number, date or Boolean value. The provided text is analyzed before matching.
         * <p>
         * API name: {@code match}
         * </p>
         */
        @Nonnull
        public final Builder match(Function<MatchQuery.Builder, ObjectBuilder<MatchQuery>> fn) {
            return match(fn.apply(new MatchQuery.Builder()).build());
        }

        /**
         * API name: {@code match_all}
         */
        @Nonnull
        public final Builder matchAll(@Nullable MatchAllQuery value) {
            this.matchAll = value;
            return this;
        }

        /**
         * API name: {@code match_all}
         */
        @Nonnull
        public final Builder matchAll(Function<MatchAllQuery.Builder, ObjectBuilder<MatchAllQuery>> fn) {
            return matchAll(fn.apply(new MatchAllQuery.Builder()).build());
        }

        /**
         * Analyzes its input and constructs a <code>bool</code> query from the terms. Each term except the last is used in a
         * <code>term</code> query. The last term is used in a prefix query.
         * <p>
         * API name: {@code match_bool_prefix}
         * </p>
         */
        @Nonnull
        public final Builder matchBoolPrefix(@Nullable MatchBoolPrefixQuery value) {
            this.matchBoolPrefix = value;
            return this;
        }

        /**
         * Analyzes its input and constructs a <code>bool</code> query from the terms. Each term except the last is used in a
         * <code>term</code> query. The last term is used in a prefix query.
         * <p>
         * API name: {@code match_bool_prefix}
         * </p>
         */
        @Nonnull
        public final Builder matchBoolPrefix(Function<MatchBoolPrefixQuery.Builder, ObjectBuilder<MatchBoolPrefixQuery>> fn) {
            return matchBoolPrefix(fn.apply(new MatchBoolPrefixQuery.Builder()).build());
        }

        /**
         * API name: {@code match_none}
         */
        @Nonnull
        public final Builder matchNone(@Nullable MatchNoneQuery value) {
            this.matchNone = value;
            return this;
        }

        /**
         * API name: {@code match_none}
         */
        @Nonnull
        public final Builder matchNone(Function<MatchNoneQuery.Builder, ObjectBuilder<MatchNoneQuery>> fn) {
            return matchNone(fn.apply(new MatchNoneQuery.Builder()).build());
        }

        /**
         * Analyzes the text and creates a phrase query out of the analyzed text.
         * <p>
         * API name: {@code match_phrase}
         * </p>
         */
        @Nonnull
        public final Builder matchPhrase(@Nullable MatchPhraseQuery value) {
            this.matchPhrase = value;
            return this;
        }

        /**
         * Analyzes the text and creates a phrase query out of the analyzed text.
         * <p>
         * API name: {@code match_phrase}
         * </p>
         */
        @Nonnull
        public final Builder matchPhrase(Function<MatchPhraseQuery.Builder, ObjectBuilder<MatchPhraseQuery>> fn) {
            return matchPhrase(fn.apply(new MatchPhraseQuery.Builder()).build());
        }

        /**
         * Returns documents that contain the words of a provided text, in the same order as provided. The last term of the provided text is
         * treated as a prefix, matching any words that begin with that term.
         * <p>
         * API name: {@code match_phrase_prefix}
         * </p>
         */
        @Nonnull
        public final Builder matchPhrasePrefix(@Nullable MatchPhrasePrefixQuery value) {
            this.matchPhrasePrefix = value;
            return this;
        }

        /**
         * Returns documents that contain the words of a provided text, in the same order as provided. The last term of the provided text is
         * treated as a prefix, matching any words that begin with that term.
         * <p>
         * API name: {@code match_phrase_prefix}
         * </p>
         */
        @Nonnull
        public final Builder matchPhrasePrefix(Function<MatchPhrasePrefixQuery.Builder, ObjectBuilder<MatchPhrasePrefixQuery>> fn) {
            return matchPhrasePrefix(fn.apply(new MatchPhrasePrefixQuery.Builder()).build());
        }

        /**
         * API name: {@code more_like_this}
         */
        @Nonnull
        public final Builder moreLikeThis(@Nullable MoreLikeThisQuery value) {
            this.moreLikeThis = value;
            return this;
        }

        /**
         * API name: {@code more_like_this}
         */
        @Nonnull
        public final Builder moreLikeThis(Function<MoreLikeThisQuery.Builder, ObjectBuilder<MoreLikeThisQuery>> fn) {
            return moreLikeThis(fn.apply(new MoreLikeThisQuery.Builder()).build());
        }

        /**
         * API name: {@code multi_match}
         */
        @Nonnull
        public final Builder multiMatch(@Nullable MultiMatchQuery value) {
            this.multiMatch = value;
            return this;
        }

        /**
         * API name: {@code multi_match}
         */
        @Nonnull
        public final Builder multiMatch(Function<MultiMatchQuery.Builder, ObjectBuilder<MultiMatchQuery>> fn) {
            return multiMatch(fn.apply(new MultiMatchQuery.Builder()).build());
        }

        /**
         * API name: {@code nested}
         */
        @Nonnull
        public final Builder nested(@Nullable NestedQuery value) {
            this.nested = value;
            return this;
        }

        /**
         * API name: {@code nested}
         */
        @Nonnull
        public final Builder nested(Function<NestedQuery.Builder, ObjectBuilder<NestedQuery>> fn) {
            return nested(fn.apply(new NestedQuery.Builder()).build());
        }

        /**
         * API name: {@code neural}
         */
        @Nonnull
        public final Builder neural(@Nullable NeuralQuery value) {
            this.neural = value;
            return this;
        }

        /**
         * API name: {@code neural}
         */
        @Nonnull
        public final Builder neural(Function<NeuralQuery.Builder, ObjectBuilder<NeuralQuery>> fn) {
            return neural(fn.apply(new NeuralQuery.Builder()).build());
        }

        /**
         * API name: {@code parent_id}
         */
        @Nonnull
        public final Builder parentId(@Nullable ParentIdQuery value) {
            this.parentId = value;
            return this;
        }

        /**
         * API name: {@code parent_id}
         */
        @Nonnull
        public final Builder parentId(Function<ParentIdQuery.Builder, ObjectBuilder<ParentIdQuery>> fn) {
            return parentId(fn.apply(new ParentIdQuery.Builder()).build());
        }

        /**
         * API name: {@code percolate}
         */
        @Nonnull
        public final Builder percolate(@Nullable PercolateQuery value) {
            this.percolate = value;
            return this;
        }

        /**
         * API name: {@code percolate}
         */
        @Nonnull
        public final Builder percolate(Function<PercolateQuery.Builder, ObjectBuilder<PercolateQuery>> fn) {
            return percolate(fn.apply(new PercolateQuery.Builder()).build());
        }

        /**
         * Returns documents that contain a specific prefix in a provided field.
         * <p>
         * API name: {@code prefix}
         * </p>
         */
        @Nonnull
        public final Builder prefix(@Nullable PrefixQuery value) {
            this.prefix = value;
            return this;
        }

        /**
         * Returns documents that contain a specific prefix in a provided field.
         * <p>
         * API name: {@code prefix}
         * </p>
         */
        @Nonnull
        public final Builder prefix(Function<PrefixQuery.Builder, ObjectBuilder<PrefixQuery>> fn) {
            return prefix(fn.apply(new PrefixQuery.Builder()).build());
        }

        /**
         * API name: {@code query_string}
         */
        @Nonnull
        public final Builder queryString(@Nullable QueryStringQuery value) {
            this.queryString = value;
            return this;
        }

        /**
         * API name: {@code query_string}
         */
        @Nonnull
        public final Builder queryString(Function<QueryStringQuery.Builder, ObjectBuilder<QueryStringQuery>> fn) {
            return queryString(fn.apply(new QueryStringQuery.Builder()).build());
        }

        /**
         * Returns documents that contain terms within a provided range.
         * <p>
         * API name: {@code range}
         * </p>
         */
        @Nonnull
        public final Builder range(@Nullable RangeQuery value) {
            this.range = value;
            return this;
        }

        /**
         * Returns documents that contain terms within a provided range.
         * <p>
         * API name: {@code range}
         * </p>
         */
        @Nonnull
        public final Builder range(Function<RangeQuery.Builder, ObjectBuilder<RangeQuery>> fn) {
            return range(fn.apply(new RangeQuery.Builder()).build());
        }

        /**
         * API name: {@code rank_feature}
         */
        @Nonnull
        public final Builder rankFeature(@Nullable RankFeatureQuery value) {
            this.rankFeature = value;
            return this;
        }

        /**
         * API name: {@code rank_feature}
         */
        @Nonnull
        public final Builder rankFeature(Function<RankFeatureQuery.Builder, ObjectBuilder<RankFeatureQuery>> fn) {
            return rankFeature(fn.apply(new RankFeatureQuery.Builder()).build());
        }

        /**
         * Returns documents that contain terms matching a regular expression.
         * <p>
         * API name: {@code regexp}
         * </p>
         */
        @Nonnull
        public final Builder regexp(@Nullable RegexpQuery value) {
            this.regexp = value;
            return this;
        }

        /**
         * Returns documents that contain terms matching a regular expression.
         * <p>
         * API name: {@code regexp}
         * </p>
         */
        @Nonnull
        public final Builder regexp(Function<RegexpQuery.Builder, ObjectBuilder<RegexpQuery>> fn) {
            return regexp(fn.apply(new RegexpQuery.Builder()).build());
        }

        /**
         * API name: {@code script}
         */
        @Nonnull
        public final Builder script(@Nullable ScriptQuery value) {
            this.script = value;
            return this;
        }

        /**
         * API name: {@code script}
         */
        @Nonnull
        public final Builder script(Function<ScriptQuery.Builder, ObjectBuilder<ScriptQuery>> fn) {
            return script(fn.apply(new ScriptQuery.Builder()).build());
        }

        /**
         * API name: {@code script_score}
         */
        @Nonnull
        public final Builder scriptScore(@Nullable ScriptScoreQuery value) {
            this.scriptScore = value;
            return this;
        }

        /**
         * API name: {@code script_score}
         */
        @Nonnull
        public final Builder scriptScore(Function<ScriptScoreQuery.Builder, ObjectBuilder<ScriptScoreQuery>> fn) {
            return scriptScore(fn.apply(new ScriptScoreQuery.Builder()).build());
        }

        /**
         * API name: {@code simple_query_string}
         */
        @Nonnull
        public final Builder simpleQueryString(@Nullable SimpleQueryStringQuery value) {
            this.simpleQueryString = value;
            return this;
        }

        /**
         * API name: {@code simple_query_string}
         */
        @Nonnull
        public final Builder simpleQueryString(Function<SimpleQueryStringQuery.Builder, ObjectBuilder<SimpleQueryStringQuery>> fn) {
            return simpleQueryString(fn.apply(new SimpleQueryStringQuery.Builder()).build());
        }

        /**
         * API name: {@code span_containing}
         */
        @Nonnull
        public final Builder spanContaining(@Nullable SpanContainingQuery value) {
            this.spanContaining = value;
            return this;
        }

        /**
         * API name: {@code span_containing}
         */
        @Nonnull
        public final Builder spanContaining(Function<SpanContainingQuery.Builder, ObjectBuilder<SpanContainingQuery>> fn) {
            return spanContaining(fn.apply(new SpanContainingQuery.Builder()).build());
        }

        /**
         * API name: {@code span_first}
         */
        @Nonnull
        public final Builder spanFirst(@Nullable SpanFirstQuery value) {
            this.spanFirst = value;
            return this;
        }

        /**
         * API name: {@code span_first}
         */
        @Nonnull
        public final Builder spanFirst(Function<SpanFirstQuery.Builder, ObjectBuilder<SpanFirstQuery>> fn) {
            return spanFirst(fn.apply(new SpanFirstQuery.Builder()).build());
        }

        /**
         * API name: {@code span_multi}
         */
        @Nonnull
        public final Builder spanMulti(@Nullable SpanMultiTermQuery value) {
            this.spanMulti = value;
            return this;
        }

        /**
         * API name: {@code span_multi}
         */
        @Nonnull
        public final Builder spanMulti(Function<SpanMultiTermQuery.Builder, ObjectBuilder<SpanMultiTermQuery>> fn) {
            return spanMulti(fn.apply(new SpanMultiTermQuery.Builder()).build());
        }

        /**
         * API name: {@code span_near}
         */
        @Nonnull
        public final Builder spanNear(@Nullable SpanNearQuery value) {
            this.spanNear = value;
            return this;
        }

        /**
         * API name: {@code span_near}
         */
        @Nonnull
        public final Builder spanNear(Function<SpanNearQuery.Builder, ObjectBuilder<SpanNearQuery>> fn) {
            return spanNear(fn.apply(new SpanNearQuery.Builder()).build());
        }

        /**
         * API name: {@code span_not}
         */
        @Nonnull
        public final Builder spanNot(@Nullable SpanNotQuery value) {
            this.spanNot = value;
            return this;
        }

        /**
         * API name: {@code span_not}
         */
        @Nonnull
        public final Builder spanNot(Function<SpanNotQuery.Builder, ObjectBuilder<SpanNotQuery>> fn) {
            return spanNot(fn.apply(new SpanNotQuery.Builder()).build());
        }

        /**
         * API name: {@code span_or}
         */
        @Nonnull
        public final Builder spanOr(@Nullable SpanOrQuery value) {
            this.spanOr = value;
            return this;
        }

        /**
         * API name: {@code span_or}
         */
        @Nonnull
        public final Builder spanOr(Function<SpanOrQuery.Builder, ObjectBuilder<SpanOrQuery>> fn) {
            return spanOr(fn.apply(new SpanOrQuery.Builder()).build());
        }

        /**
         * Matches spans containing a term.
         * <p>
         * API name: {@code span_term}
         * </p>
         */
        @Nonnull
        public final Builder spanTerm(@Nullable SpanTermQuery value) {
            this.spanTerm = value;
            return this;
        }

        /**
         * Matches spans containing a term.
         * <p>
         * API name: {@code span_term}
         * </p>
         */
        @Nonnull
        public final Builder spanTerm(Function<SpanTermQuery.Builder, ObjectBuilder<SpanTermQuery>> fn) {
            return spanTerm(fn.apply(new SpanTermQuery.Builder()).build());
        }

        /**
         * API name: {@code span_within}
         */
        @Nonnull
        public final Builder spanWithin(@Nullable SpanWithinQuery value) {
            this.spanWithin = value;
            return this;
        }

        /**
         * API name: {@code span_within}
         */
        @Nonnull
        public final Builder spanWithin(Function<SpanWithinQuery.Builder, ObjectBuilder<SpanWithinQuery>> fn) {
            return spanWithin(fn.apply(new SpanWithinQuery.Builder()).build());
        }

        /**
         * Return documents using a template query contains placeholders that are resolved by search request processors during query
         * execution.
         * <p>
         * API name: {@code template}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>template</code>.
         * </p>
         */
        @Nonnull
        public final Builder template(Map<String, JsonData> map) {
            this.template = _mapPutAll(this.template, map);
            return this;
        }

        /**
         * Return documents using a template query contains placeholders that are resolved by search request processors during query
         * execution.
         * <p>
         * API name: {@code template}
         * </p>
         *
         * <p>
         * Adds an entry to <code>template</code>.
         * </p>
         */
        @Nonnull
        public final Builder template(String key, JsonData value) {
            this.template = _mapPut(this.template, key, value);
            return this;
        }

        /**
         * Returns documents that contain an exact term in a provided field. To return a document, the query term must exactly match the
         * queried field's value, including white space and capitalization.
         * <p>
         * API name: {@code term}
         * </p>
         */
        @Nonnull
        public final Builder term(@Nullable TermQuery value) {
            this.term = value;
            return this;
        }

        /**
         * Returns documents that contain an exact term in a provided field. To return a document, the query term must exactly match the
         * queried field's value, including white space and capitalization.
         * <p>
         * API name: {@code term}
         * </p>
         */
        @Nonnull
        public final Builder term(Function<TermQuery.Builder, ObjectBuilder<TermQuery>> fn) {
            return term(fn.apply(new TermQuery.Builder()).build());
        }

        /**
         * Returns documents that contain one or more exact terms in a provided field.
         * <p>
         * API name: {@code terms}
         * </p>
         */
        @Nonnull
        public final Builder terms(@Nullable TermsQuery value) {
            this.terms = value;
            return this;
        }

        /**
         * Returns documents that contain one or more exact terms in a provided field.
         * <p>
         * API name: {@code terms}
         * </p>
         */
        @Nonnull
        public final Builder terms(Function<TermsQuery.Builder, ObjectBuilder<TermsQuery>> fn) {
            return terms(fn.apply(new TermsQuery.Builder()).build());
        }

        /**
         * Returns documents that contain a minimum number of exact terms in a provided field. To return a document, a required number of
         * terms must exactly match the field values, including white space and capitalization.
         * <p>
         * API name: {@code terms_set}
         * </p>
         */
        @Nonnull
        public final Builder termsSet(@Nullable TermsSetQuery value) {
            this.termsSet = value;
            return this;
        }

        /**
         * Returns documents that contain a minimum number of exact terms in a provided field. To return a document, a required number of
         * terms must exactly match the field values, including white space and capitalization.
         * <p>
         * API name: {@code terms_set}
         * </p>
         */
        @Nonnull
        public final Builder termsSet(Function<TermsSetQuery.Builder, ObjectBuilder<TermsSetQuery>> fn) {
            return termsSet(fn.apply(new TermsSetQuery.Builder()).build());
        }

        /**
         * API name: {@code type}
         */
        @Nonnull
        public final Builder type(@Nullable TypeQuery value) {
            this.type = value;
            return this;
        }

        /**
         * API name: {@code type}
         */
        @Nonnull
        public final Builder type(Function<TypeQuery.Builder, ObjectBuilder<TypeQuery>> fn) {
            return type(fn.apply(new TypeQuery.Builder()).build());
        }

        /**
         * Returns documents that contain terms matching a wildcard pattern.
         * <p>
         * API name: {@code wildcard}
         * </p>
         */
        @Nonnull
        public final Builder wildcard(@Nullable WildcardQuery value) {
            this.wildcard = value;
            return this;
        }

        /**
         * Returns documents that contain terms matching a wildcard pattern.
         * <p>
         * API name: {@code wildcard}
         * </p>
         */
        @Nonnull
        public final Builder wildcard(Function<WildcardQuery.Builder, ObjectBuilder<WildcardQuery>> fn) {
            return wildcard(fn.apply(new WildcardQuery.Builder()).build());
        }

        /**
         * API name: {@code wrapper}
         */
        @Nonnull
        public final Builder wrapper(@Nullable WrapperQuery value) {
            this.wrapper = value;
            return this;
        }

        /**
         * API name: {@code wrapper}
         */
        @Nonnull
        public final Builder wrapper(Function<WrapperQuery.Builder, ObjectBuilder<WrapperQuery>> fn) {
            return wrapper(fn.apply(new WrapperQuery.Builder()).build());
        }

        /**
         * API name: {@code xy_shape}
         */
        @Nonnull
        public final Builder xyShape(@Nullable XyShapeQuery value) {
            this.xyShape = value;
            return this;
        }

        /**
         * API name: {@code xy_shape}
         */
        @Nonnull
        public final Builder xyShape(Function<XyShapeQuery.Builder, ObjectBuilder<XyShapeQuery>> fn) {
            return xyShape(fn.apply(new XyShapeQuery.Builder()).build());
        }

        /**
         * Builds a {@link FilterAggregationFields}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FilterAggregationFields build() {
            _checkSingleUse();

            return new FilterAggregationFields(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FilterAggregationFields}
     */
    public static final JsonpDeserializer<FilterAggregationFields> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FilterAggregationFields::setupFilterAggregationFieldsDeserializer
    );

    protected static void setupFilterAggregationFieldsDeserializer(ObjectDeserializer<FilterAggregationFields.Builder> op) {
        op.add(Builder::agentic, AgenticQuery._DESERIALIZER, "agentic");
        op.add(Builder::bool, BoolQuery._DESERIALIZER, "bool");
        op.add(Builder::boosting, BoostingQuery._DESERIALIZER, "boosting");
        op.add(Builder::combinedFields, CombinedFieldsQuery._DESERIALIZER, "combined_fields");
        op.add(Builder::common, CommonTermsQuery._DESERIALIZER, "common");
        op.add(Builder::constantScore, ConstantScoreQuery._DESERIALIZER, "constant_score");
        op.add(Builder::disMax, DisMaxQuery._DESERIALIZER, "dis_max");
        op.add(Builder::distanceFeature, DistanceFeatureQuery._DESERIALIZER, "distance_feature");
        op.add(Builder::exists, ExistsQuery._DESERIALIZER, "exists");
        op.add(Builder::fieldMaskingSpan, SpanFieldMaskingQuery._DESERIALIZER, "field_masking_span");
        op.add(Builder::functionScore, FunctionScoreQuery._DESERIALIZER, "function_score");
        op.add(Builder::fuzzy, FuzzyQuery._DESERIALIZER, "fuzzy");
        op.add(Builder::geoBoundingBox, GeoBoundingBoxQuery._DESERIALIZER, "geo_bounding_box");
        op.add(Builder::geoDistance, GeoDistanceQuery._DESERIALIZER, "geo_distance");
        op.add(Builder::geoPolygon, GeoPolygonQuery._DESERIALIZER, "geo_polygon");
        op.add(Builder::geoShape, GeoShapeQuery._DESERIALIZER, "geo_shape");
        op.add(Builder::hasChild, HasChildQuery._DESERIALIZER, "has_child");
        op.add(Builder::hasParent, HasParentQuery._DESERIALIZER, "has_parent");
        op.add(Builder::hybrid, HybridQuery._DESERIALIZER, "hybrid");
        op.add(Builder::ids, IdsQuery._DESERIALIZER, "ids");
        op.add(Builder::intervals, IntervalsQuery._DESERIALIZER, "intervals");
        op.add(Builder::knn, KnnQuery._DESERIALIZER, "knn");
        op.add(Builder::match, MatchQuery._DESERIALIZER, "match");
        op.add(Builder::matchAll, MatchAllQuery._DESERIALIZER, "match_all");
        op.add(Builder::matchBoolPrefix, MatchBoolPrefixQuery._DESERIALIZER, "match_bool_prefix");
        op.add(Builder::matchNone, MatchNoneQuery._DESERIALIZER, "match_none");
        op.add(Builder::matchPhrase, MatchPhraseQuery._DESERIALIZER, "match_phrase");
        op.add(Builder::matchPhrasePrefix, MatchPhrasePrefixQuery._DESERIALIZER, "match_phrase_prefix");
        op.add(Builder::moreLikeThis, MoreLikeThisQuery._DESERIALIZER, "more_like_this");
        op.add(Builder::multiMatch, MultiMatchQuery._DESERIALIZER, "multi_match");
        op.add(Builder::nested, NestedQuery._DESERIALIZER, "nested");
        op.add(Builder::neural, NeuralQuery._DESERIALIZER, "neural");
        op.add(Builder::parentId, ParentIdQuery._DESERIALIZER, "parent_id");
        op.add(Builder::percolate, PercolateQuery._DESERIALIZER, "percolate");
        op.add(Builder::prefix, PrefixQuery._DESERIALIZER, "prefix");
        op.add(Builder::queryString, QueryStringQuery._DESERIALIZER, "query_string");
        op.add(Builder::range, RangeQuery._DESERIALIZER, "range");
        op.add(Builder::rankFeature, RankFeatureQuery._DESERIALIZER, "rank_feature");
        op.add(Builder::regexp, RegexpQuery._DESERIALIZER, "regexp");
        op.add(Builder::script, ScriptQuery._DESERIALIZER, "script");
        op.add(Builder::scriptScore, ScriptScoreQuery._DESERIALIZER, "script_score");
        op.add(Builder::simpleQueryString, SimpleQueryStringQuery._DESERIALIZER, "simple_query_string");
        op.add(Builder::spanContaining, SpanContainingQuery._DESERIALIZER, "span_containing");
        op.add(Builder::spanFirst, SpanFirstQuery._DESERIALIZER, "span_first");
        op.add(Builder::spanMulti, SpanMultiTermQuery._DESERIALIZER, "span_multi");
        op.add(Builder::spanNear, SpanNearQuery._DESERIALIZER, "span_near");
        op.add(Builder::spanNot, SpanNotQuery._DESERIALIZER, "span_not");
        op.add(Builder::spanOr, SpanOrQuery._DESERIALIZER, "span_or");
        op.add(Builder::spanTerm, SpanTermQuery._DESERIALIZER, "span_term");
        op.add(Builder::spanWithin, SpanWithinQuery._DESERIALIZER, "span_within");
        op.add(Builder::template, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "template");
        op.add(Builder::term, TermQuery._DESERIALIZER, "term");
        op.add(Builder::terms, TermsQuery._DESERIALIZER, "terms");
        op.add(Builder::termsSet, TermsSetQuery._DESERIALIZER, "terms_set");
        op.add(Builder::type, TypeQuery._DESERIALIZER, "type");
        op.add(Builder::wildcard, WildcardQuery._DESERIALIZER, "wildcard");
        op.add(Builder::wrapper, WrapperQuery._DESERIALIZER, "wrapper");
        op.add(Builder::xyShape, XyShapeQuery._DESERIALIZER, "xy_shape");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.agentic);
        result = 31 * result + Objects.hashCode(this.bool);
        result = 31 * result + Objects.hashCode(this.boosting);
        result = 31 * result + Objects.hashCode(this.combinedFields);
        result = 31 * result + Objects.hashCode(this.common);
        result = 31 * result + Objects.hashCode(this.constantScore);
        result = 31 * result + Objects.hashCode(this.disMax);
        result = 31 * result + Objects.hashCode(this.distanceFeature);
        result = 31 * result + Objects.hashCode(this.exists);
        result = 31 * result + Objects.hashCode(this.fieldMaskingSpan);
        result = 31 * result + Objects.hashCode(this.functionScore);
        result = 31 * result + Objects.hashCode(this.fuzzy);
        result = 31 * result + Objects.hashCode(this.geoBoundingBox);
        result = 31 * result + Objects.hashCode(this.geoDistance);
        result = 31 * result + Objects.hashCode(this.geoPolygon);
        result = 31 * result + Objects.hashCode(this.geoShape);
        result = 31 * result + Objects.hashCode(this.hasChild);
        result = 31 * result + Objects.hashCode(this.hasParent);
        result = 31 * result + Objects.hashCode(this.hybrid);
        result = 31 * result + Objects.hashCode(this.ids);
        result = 31 * result + Objects.hashCode(this.intervals);
        result = 31 * result + Objects.hashCode(this.knn);
        result = 31 * result + Objects.hashCode(this.match);
        result = 31 * result + Objects.hashCode(this.matchAll);
        result = 31 * result + Objects.hashCode(this.matchBoolPrefix);
        result = 31 * result + Objects.hashCode(this.matchNone);
        result = 31 * result + Objects.hashCode(this.matchPhrase);
        result = 31 * result + Objects.hashCode(this.matchPhrasePrefix);
        result = 31 * result + Objects.hashCode(this.moreLikeThis);
        result = 31 * result + Objects.hashCode(this.multiMatch);
        result = 31 * result + Objects.hashCode(this.nested);
        result = 31 * result + Objects.hashCode(this.neural);
        result = 31 * result + Objects.hashCode(this.parentId);
        result = 31 * result + Objects.hashCode(this.percolate);
        result = 31 * result + Objects.hashCode(this.prefix);
        result = 31 * result + Objects.hashCode(this.queryString);
        result = 31 * result + Objects.hashCode(this.range);
        result = 31 * result + Objects.hashCode(this.rankFeature);
        result = 31 * result + Objects.hashCode(this.regexp);
        result = 31 * result + Objects.hashCode(this.script);
        result = 31 * result + Objects.hashCode(this.scriptScore);
        result = 31 * result + Objects.hashCode(this.simpleQueryString);
        result = 31 * result + Objects.hashCode(this.spanContaining);
        result = 31 * result + Objects.hashCode(this.spanFirst);
        result = 31 * result + Objects.hashCode(this.spanMulti);
        result = 31 * result + Objects.hashCode(this.spanNear);
        result = 31 * result + Objects.hashCode(this.spanNot);
        result = 31 * result + Objects.hashCode(this.spanOr);
        result = 31 * result + Objects.hashCode(this.spanTerm);
        result = 31 * result + Objects.hashCode(this.spanWithin);
        result = 31 * result + Objects.hashCode(this.template);
        result = 31 * result + Objects.hashCode(this.term);
        result = 31 * result + Objects.hashCode(this.terms);
        result = 31 * result + Objects.hashCode(this.termsSet);
        result = 31 * result + Objects.hashCode(this.type);
        result = 31 * result + Objects.hashCode(this.wildcard);
        result = 31 * result + Objects.hashCode(this.wrapper);
        result = 31 * result + Objects.hashCode(this.xyShape);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FilterAggregationFields other = (FilterAggregationFields) o;
        return Objects.equals(this.agentic, other.agentic)
            && Objects.equals(this.bool, other.bool)
            && Objects.equals(this.boosting, other.boosting)
            && Objects.equals(this.combinedFields, other.combinedFields)
            && Objects.equals(this.common, other.common)
            && Objects.equals(this.constantScore, other.constantScore)
            && Objects.equals(this.disMax, other.disMax)
            && Objects.equals(this.distanceFeature, other.distanceFeature)
            && Objects.equals(this.exists, other.exists)
            && Objects.equals(this.fieldMaskingSpan, other.fieldMaskingSpan)
            && Objects.equals(this.functionScore, other.functionScore)
            && Objects.equals(this.fuzzy, other.fuzzy)
            && Objects.equals(this.geoBoundingBox, other.geoBoundingBox)
            && Objects.equals(this.geoDistance, other.geoDistance)
            && Objects.equals(this.geoPolygon, other.geoPolygon)
            && Objects.equals(this.geoShape, other.geoShape)
            && Objects.equals(this.hasChild, other.hasChild)
            && Objects.equals(this.hasParent, other.hasParent)
            && Objects.equals(this.hybrid, other.hybrid)
            && Objects.equals(this.ids, other.ids)
            && Objects.equals(this.intervals, other.intervals)
            && Objects.equals(this.knn, other.knn)
            && Objects.equals(this.match, other.match)
            && Objects.equals(this.matchAll, other.matchAll)
            && Objects.equals(this.matchBoolPrefix, other.matchBoolPrefix)
            && Objects.equals(this.matchNone, other.matchNone)
            && Objects.equals(this.matchPhrase, other.matchPhrase)
            && Objects.equals(this.matchPhrasePrefix, other.matchPhrasePrefix)
            && Objects.equals(this.moreLikeThis, other.moreLikeThis)
            && Objects.equals(this.multiMatch, other.multiMatch)
            && Objects.equals(this.nested, other.nested)
            && Objects.equals(this.neural, other.neural)
            && Objects.equals(this.parentId, other.parentId)
            && Objects.equals(this.percolate, other.percolate)
            && Objects.equals(this.prefix, other.prefix)
            && Objects.equals(this.queryString, other.queryString)
            && Objects.equals(this.range, other.range)
            && Objects.equals(this.rankFeature, other.rankFeature)
            && Objects.equals(this.regexp, other.regexp)
            && Objects.equals(this.script, other.script)
            && Objects.equals(this.scriptScore, other.scriptScore)
            && Objects.equals(this.simpleQueryString, other.simpleQueryString)
            && Objects.equals(this.spanContaining, other.spanContaining)
            && Objects.equals(this.spanFirst, other.spanFirst)
            && Objects.equals(this.spanMulti, other.spanMulti)
            && Objects.equals(this.spanNear, other.spanNear)
            && Objects.equals(this.spanNot, other.spanNot)
            && Objects.equals(this.spanOr, other.spanOr)
            && Objects.equals(this.spanTerm, other.spanTerm)
            && Objects.equals(this.spanWithin, other.spanWithin)
            && Objects.equals(this.template, other.template)
            && Objects.equals(this.term, other.term)
            && Objects.equals(this.terms, other.terms)
            && Objects.equals(this.termsSet, other.termsSet)
            && Objects.equals(this.type, other.type)
            && Objects.equals(this.wildcard, other.wildcard)
            && Objects.equals(this.wrapper, other.wrapper)
            && Objects.equals(this.xyShape, other.xyShape);
    }
}
