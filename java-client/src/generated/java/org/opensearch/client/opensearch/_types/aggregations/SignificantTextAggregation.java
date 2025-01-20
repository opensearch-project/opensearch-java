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
import java.util.List;
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
import org.opensearch.client.opensearch._types.EmptyObject;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.SignificantTextAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SignificantTextAggregation extends BucketAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<SignificantTextAggregation.Builder, SignificantTextAggregation> {

    @Nullable
    private final Query backgroundFilter;

    @Nullable
    private final ChiSquareHeuristic chiSquare;

    @Nullable
    private final TermsExclude exclude;

    @Nullable
    private final TermsAggregationExecutionHint executionHint;

    @Nullable
    private final String field;

    @Nullable
    private final Boolean filterDuplicateText;

    @Nullable
    private final GoogleNormalizedDistanceHeuristic gnd;

    @Nullable
    private final TermsInclude include;

    @Nullable
    private final EmptyObject jlh;

    @Nullable
    private final Long minDocCount;

    @Nullable
    private final MutualInformationHeuristic mutualInformation;

    @Nullable
    private final PercentageScoreHeuristic percentage;

    @Nullable
    private final ScriptedHeuristic scriptHeuristic;

    @Nullable
    private final Long shardMinDocCount;

    @Nullable
    private final Integer shardSize;

    @Nullable
    private final Integer size;

    @Nonnull
    private final List<String> sourceFields;

    // ---------------------------------------------------------------------------------------------

    private SignificantTextAggregation(Builder builder) {
        super(builder);
        this.backgroundFilter = builder.backgroundFilter;
        this.chiSquare = builder.chiSquare;
        this.exclude = builder.exclude;
        this.executionHint = builder.executionHint;
        this.field = builder.field;
        this.filterDuplicateText = builder.filterDuplicateText;
        this.gnd = builder.gnd;
        this.include = builder.include;
        this.jlh = builder.jlh;
        this.minDocCount = builder.minDocCount;
        this.mutualInformation = builder.mutualInformation;
        this.percentage = builder.percentage;
        this.scriptHeuristic = builder.scriptHeuristic;
        this.shardMinDocCount = builder.shardMinDocCount;
        this.shardSize = builder.shardSize;
        this.size = builder.size;
        this.sourceFields = ApiTypeHelper.unmodifiable(builder.sourceFields);
    }

    public static SignificantTextAggregation of(
        Function<SignificantTextAggregation.Builder, ObjectBuilder<SignificantTextAggregation>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.SignificantText;
    }

    /**
     * API name: {@code background_filter}
     */
    @Nullable
    public final Query backgroundFilter() {
        return this.backgroundFilter;
    }

    /**
     * API name: {@code chi_square}
     */
    @Nullable
    public final ChiSquareHeuristic chiSquare() {
        return this.chiSquare;
    }

    /**
     * API name: {@code exclude}
     */
    @Nullable
    public final TermsExclude exclude() {
        return this.exclude;
    }

    /**
     * API name: {@code execution_hint}
     */
    @Nullable
    public final TermsAggregationExecutionHint executionHint() {
        return this.executionHint;
    }

    /**
     * API name: {@code field}
     */
    @Nullable
    public final String field() {
        return this.field;
    }

    /**
     * Whether to out duplicate text to deal with noisy data.
     * <p>
     * API name: {@code filter_duplicate_text}
     * </p>
     */
    @Nullable
    public final Boolean filterDuplicateText() {
        return this.filterDuplicateText;
    }

    /**
     * API name: {@code gnd}
     */
    @Nullable
    public final GoogleNormalizedDistanceHeuristic gnd() {
        return this.gnd;
    }

    /**
     * API name: {@code include}
     */
    @Nullable
    public final TermsInclude include() {
        return this.include;
    }

    /**
     * API name: {@code jlh}
     */
    @Nullable
    public final EmptyObject jlh() {
        return this.jlh;
    }

    /**
     * Only return values that are found in more than <code>min_doc_count</code> hits.
     * <p>
     * API name: {@code min_doc_count}
     * </p>
     */
    @Nullable
    public final Long minDocCount() {
        return this.minDocCount;
    }

    /**
     * API name: {@code mutual_information}
     */
    @Nullable
    public final MutualInformationHeuristic mutualInformation() {
        return this.mutualInformation;
    }

    /**
     * API name: {@code percentage}
     */
    @Nullable
    public final PercentageScoreHeuristic percentage() {
        return this.percentage;
    }

    /**
     * API name: {@code script_heuristic}
     */
    @Nullable
    public final ScriptedHeuristic scriptHeuristic() {
        return this.scriptHeuristic;
    }

    /**
     * Regulates the certainty a shard has if the values should actually be added to the candidate list or not with respect to the
     * <code>min_doc_count</code>. Values will only be considered if their local shard frequency within the set is higher than the
     * <code>shard_min_doc_count</code>.
     * <p>
     * API name: {@code shard_min_doc_count}
     * </p>
     */
    @Nullable
    public final Long shardMinDocCount() {
        return this.shardMinDocCount;
    }

    /**
     * The number of candidate terms produced by each shard. By default, <code>shard_size</code> will be automatically estimated based on
     * the number of shards and the <code>size</code> parameter.
     * <p>
     * API name: {@code shard_size}
     * </p>
     */
    @Nullable
    public final Integer shardSize() {
        return this.shardSize;
    }

    /**
     * The number of buckets returned out of the overall terms list.
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * API name: {@code source_fields}
     */
    @Nonnull
    public final List<String> sourceFields() {
        return this.sourceFields;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.backgroundFilter != null) {
            generator.writeKey("background_filter");
            this.backgroundFilter.serialize(generator, mapper);
        }

        if (this.chiSquare != null) {
            generator.writeKey("chi_square");
            this.chiSquare.serialize(generator, mapper);
        }

        if (this.exclude != null) {
            generator.writeKey("exclude");
            this.exclude.serialize(generator, mapper);
        }

        if (this.executionHint != null) {
            generator.writeKey("execution_hint");
            this.executionHint.serialize(generator, mapper);
        }

        if (this.field != null) {
            generator.writeKey("field");
            generator.write(this.field);
        }

        if (this.filterDuplicateText != null) {
            generator.writeKey("filter_duplicate_text");
            generator.write(this.filterDuplicateText);
        }

        if (this.gnd != null) {
            generator.writeKey("gnd");
            this.gnd.serialize(generator, mapper);
        }

        if (this.include != null) {
            generator.writeKey("include");
            this.include.serialize(generator, mapper);
        }

        if (this.jlh != null) {
            generator.writeKey("jlh");
            this.jlh.serialize(generator, mapper);
        }

        if (this.minDocCount != null) {
            generator.writeKey("min_doc_count");
            generator.write(this.minDocCount);
        }

        if (this.mutualInformation != null) {
            generator.writeKey("mutual_information");
            this.mutualInformation.serialize(generator, mapper);
        }

        if (this.percentage != null) {
            generator.writeKey("percentage");
            this.percentage.serialize(generator, mapper);
        }

        if (this.scriptHeuristic != null) {
            generator.writeKey("script_heuristic");
            this.scriptHeuristic.serialize(generator, mapper);
        }

        if (this.shardMinDocCount != null) {
            generator.writeKey("shard_min_doc_count");
            generator.write(this.shardMinDocCount);
        }

        if (this.shardSize != null) {
            generator.writeKey("shard_size");
            generator.write(this.shardSize);
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        if (ApiTypeHelper.isDefined(this.sourceFields)) {
            generator.writeKey("source_fields");
            generator.writeStartArray();
            for (String item0 : this.sourceFields) {
                generator.write(item0);
            }
            generator.writeEnd();
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
     * Builder for {@link SignificantTextAggregation}.
     */
    public static class Builder extends BucketAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, SignificantTextAggregation> {
        @Nullable
        private Query backgroundFilter;
        @Nullable
        private ChiSquareHeuristic chiSquare;
        @Nullable
        private TermsExclude exclude;
        @Nullable
        private TermsAggregationExecutionHint executionHint;
        @Nullable
        private String field;
        @Nullable
        private Boolean filterDuplicateText;
        @Nullable
        private GoogleNormalizedDistanceHeuristic gnd;
        @Nullable
        private TermsInclude include;
        @Nullable
        private EmptyObject jlh;
        @Nullable
        private Long minDocCount;
        @Nullable
        private MutualInformationHeuristic mutualInformation;
        @Nullable
        private PercentageScoreHeuristic percentage;
        @Nullable
        private ScriptedHeuristic scriptHeuristic;
        @Nullable
        private Long shardMinDocCount;
        @Nullable
        private Integer shardSize;
        @Nullable
        private Integer size;
        @Nullable
        private List<String> sourceFields;

        public Builder() {}

        private Builder(SignificantTextAggregation o) {
            super(o);
            this.backgroundFilter = o.backgroundFilter;
            this.chiSquare = o.chiSquare;
            this.exclude = o.exclude;
            this.executionHint = o.executionHint;
            this.field = o.field;
            this.filterDuplicateText = o.filterDuplicateText;
            this.gnd = o.gnd;
            this.include = o.include;
            this.jlh = o.jlh;
            this.minDocCount = o.minDocCount;
            this.mutualInformation = o.mutualInformation;
            this.percentage = o.percentage;
            this.scriptHeuristic = o.scriptHeuristic;
            this.shardMinDocCount = o.shardMinDocCount;
            this.shardSize = o.shardSize;
            this.size = o.size;
            this.sourceFields = _listCopy(o.sourceFields);
        }

        private Builder(Builder o) {
            super(o);
            this.backgroundFilter = o.backgroundFilter;
            this.chiSquare = o.chiSquare;
            this.exclude = o.exclude;
            this.executionHint = o.executionHint;
            this.field = o.field;
            this.filterDuplicateText = o.filterDuplicateText;
            this.gnd = o.gnd;
            this.include = o.include;
            this.jlh = o.jlh;
            this.minDocCount = o.minDocCount;
            this.mutualInformation = o.mutualInformation;
            this.percentage = o.percentage;
            this.scriptHeuristic = o.scriptHeuristic;
            this.shardMinDocCount = o.shardMinDocCount;
            this.shardSize = o.shardSize;
            this.size = o.size;
            this.sourceFields = _listCopy(o.sourceFields);
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
         * API name: {@code background_filter}
         */
        @Nonnull
        public final Builder backgroundFilter(@Nullable Query value) {
            this.backgroundFilter = value;
            return this;
        }

        /**
         * API name: {@code background_filter}
         */
        @Nonnull
        public final Builder backgroundFilter(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return backgroundFilter(fn.apply(new Query.Builder()).build());
        }

        /**
         * API name: {@code chi_square}
         */
        @Nonnull
        public final Builder chiSquare(@Nullable ChiSquareHeuristic value) {
            this.chiSquare = value;
            return this;
        }

        /**
         * API name: {@code chi_square}
         */
        @Nonnull
        public final Builder chiSquare(Function<ChiSquareHeuristic.Builder, ObjectBuilder<ChiSquareHeuristic>> fn) {
            return chiSquare(fn.apply(new ChiSquareHeuristic.Builder()).build());
        }

        /**
         * API name: {@code exclude}
         */
        @Nonnull
        public final Builder exclude(@Nullable TermsExclude value) {
            this.exclude = value;
            return this;
        }

        /**
         * API name: {@code exclude}
         */
        @Nonnull
        public final Builder exclude(Function<TermsExclude.Builder, ObjectBuilder<TermsExclude>> fn) {
            return exclude(fn.apply(new TermsExclude.Builder()).build());
        }

        /**
         * API name: {@code execution_hint}
         */
        @Nonnull
        public final Builder executionHint(@Nullable TermsAggregationExecutionHint value) {
            this.executionHint = value;
            return this;
        }

        /**
         * API name: {@code field}
         */
        @Nonnull
        public final Builder field(@Nullable String value) {
            this.field = value;
            return this;
        }

        /**
         * Whether to out duplicate text to deal with noisy data.
         * <p>
         * API name: {@code filter_duplicate_text}
         * </p>
         */
        @Nonnull
        public final Builder filterDuplicateText(@Nullable Boolean value) {
            this.filterDuplicateText = value;
            return this;
        }

        /**
         * API name: {@code gnd}
         */
        @Nonnull
        public final Builder gnd(@Nullable GoogleNormalizedDistanceHeuristic value) {
            this.gnd = value;
            return this;
        }

        /**
         * API name: {@code gnd}
         */
        @Nonnull
        public final Builder gnd(Function<GoogleNormalizedDistanceHeuristic.Builder, ObjectBuilder<GoogleNormalizedDistanceHeuristic>> fn) {
            return gnd(fn.apply(new GoogleNormalizedDistanceHeuristic.Builder()).build());
        }

        /**
         * API name: {@code include}
         */
        @Nonnull
        public final Builder include(@Nullable TermsInclude value) {
            this.include = value;
            return this;
        }

        /**
         * API name: {@code include}
         */
        @Nonnull
        public final Builder include(Function<TermsInclude.Builder, ObjectBuilder<TermsInclude>> fn) {
            return include(fn.apply(new TermsInclude.Builder()).build());
        }

        /**
         * API name: {@code jlh}
         */
        @Nonnull
        public final Builder jlh(@Nullable EmptyObject value) {
            this.jlh = value;
            return this;
        }

        /**
         * API name: {@code jlh}
         */
        @Nonnull
        public final Builder jlh(Function<EmptyObject.Builder, ObjectBuilder<EmptyObject>> fn) {
            return jlh(fn.apply(new EmptyObject.Builder()).build());
        }

        /**
         * Only return values that are found in more than <code>min_doc_count</code> hits.
         * <p>
         * API name: {@code min_doc_count}
         * </p>
         */
        @Nonnull
        public final Builder minDocCount(@Nullable Long value) {
            this.minDocCount = value;
            return this;
        }

        /**
         * API name: {@code mutual_information}
         */
        @Nonnull
        public final Builder mutualInformation(@Nullable MutualInformationHeuristic value) {
            this.mutualInformation = value;
            return this;
        }

        /**
         * API name: {@code mutual_information}
         */
        @Nonnull
        public final Builder mutualInformation(Function<MutualInformationHeuristic.Builder, ObjectBuilder<MutualInformationHeuristic>> fn) {
            return mutualInformation(fn.apply(new MutualInformationHeuristic.Builder()).build());
        }

        /**
         * API name: {@code percentage}
         */
        @Nonnull
        public final Builder percentage(@Nullable PercentageScoreHeuristic value) {
            this.percentage = value;
            return this;
        }

        /**
         * API name: {@code percentage}
         */
        @Nonnull
        public final Builder percentage(Function<PercentageScoreHeuristic.Builder, ObjectBuilder<PercentageScoreHeuristic>> fn) {
            return percentage(fn.apply(new PercentageScoreHeuristic.Builder()).build());
        }

        /**
         * API name: {@code script_heuristic}
         */
        @Nonnull
        public final Builder scriptHeuristic(@Nullable ScriptedHeuristic value) {
            this.scriptHeuristic = value;
            return this;
        }

        /**
         * API name: {@code script_heuristic}
         */
        @Nonnull
        public final Builder scriptHeuristic(Function<ScriptedHeuristic.Builder, ObjectBuilder<ScriptedHeuristic>> fn) {
            return scriptHeuristic(fn.apply(new ScriptedHeuristic.Builder()).build());
        }

        /**
         * Regulates the certainty a shard has if the values should actually be added to the candidate list or not with respect to the
         * <code>min_doc_count</code>. Values will only be considered if their local shard frequency within the set is higher than the
         * <code>shard_min_doc_count</code>.
         * <p>
         * API name: {@code shard_min_doc_count}
         * </p>
         */
        @Nonnull
        public final Builder shardMinDocCount(@Nullable Long value) {
            this.shardMinDocCount = value;
            return this;
        }

        /**
         * The number of candidate terms produced by each shard. By default, <code>shard_size</code> will be automatically estimated based
         * on the number of shards and the <code>size</code> parameter.
         * <p>
         * API name: {@code shard_size}
         * </p>
         */
        @Nonnull
        public final Builder shardSize(@Nullable Integer value) {
            this.shardSize = value;
            return this;
        }

        /**
         * The number of buckets returned out of the overall terms list.
         * <p>
         * API name: {@code size}
         * </p>
         */
        @Nonnull
        public final Builder size(@Nullable Integer value) {
            this.size = value;
            return this;
        }

        /**
         * API name: {@code source_fields}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>sourceFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder sourceFields(List<String> list) {
            this.sourceFields = _listAddAll(this.sourceFields, list);
            return this;
        }

        /**
         * API name: {@code source_fields}
         *
         * <p>
         * Adds one or more values to <code>sourceFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder sourceFields(String value, String... values) {
            this.sourceFields = _listAdd(this.sourceFields, value, values);
            return this;
        }

        /**
         * Builds a {@link SignificantTextAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SignificantTextAggregation build() {
            _checkSingleUse();

            return new SignificantTextAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SignificantTextAggregation}
     */
    public static final JsonpDeserializer<SignificantTextAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SignificantTextAggregation::setupSignificantTextAggregationDeserializer
    );

    protected static void setupSignificantTextAggregationDeserializer(ObjectDeserializer<SignificantTextAggregation.Builder> op) {
        setupBucketAggregationBaseDeserializer(op);
        op.add(Builder::backgroundFilter, Query._DESERIALIZER, "background_filter");
        op.add(Builder::chiSquare, ChiSquareHeuristic._DESERIALIZER, "chi_square");
        op.add(Builder::exclude, TermsExclude._DESERIALIZER, "exclude");
        op.add(Builder::executionHint, TermsAggregationExecutionHint._DESERIALIZER, "execution_hint");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::filterDuplicateText, JsonpDeserializer.booleanDeserializer(), "filter_duplicate_text");
        op.add(Builder::gnd, GoogleNormalizedDistanceHeuristic._DESERIALIZER, "gnd");
        op.add(Builder::include, TermsInclude._DESERIALIZER, "include");
        op.add(Builder::jlh, EmptyObject._DESERIALIZER, "jlh");
        op.add(Builder::minDocCount, JsonpDeserializer.longDeserializer(), "min_doc_count");
        op.add(Builder::mutualInformation, MutualInformationHeuristic._DESERIALIZER, "mutual_information");
        op.add(Builder::percentage, PercentageScoreHeuristic._DESERIALIZER, "percentage");
        op.add(Builder::scriptHeuristic, ScriptedHeuristic._DESERIALIZER, "script_heuristic");
        op.add(Builder::shardMinDocCount, JsonpDeserializer.longDeserializer(), "shard_min_doc_count");
        op.add(Builder::shardSize, JsonpDeserializer.integerDeserializer(), "shard_size");
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
        op.add(Builder::sourceFields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "source_fields");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.backgroundFilter);
        result = 31 * result + Objects.hashCode(this.chiSquare);
        result = 31 * result + Objects.hashCode(this.exclude);
        result = 31 * result + Objects.hashCode(this.executionHint);
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.filterDuplicateText);
        result = 31 * result + Objects.hashCode(this.gnd);
        result = 31 * result + Objects.hashCode(this.include);
        result = 31 * result + Objects.hashCode(this.jlh);
        result = 31 * result + Objects.hashCode(this.minDocCount);
        result = 31 * result + Objects.hashCode(this.mutualInformation);
        result = 31 * result + Objects.hashCode(this.percentage);
        result = 31 * result + Objects.hashCode(this.scriptHeuristic);
        result = 31 * result + Objects.hashCode(this.shardMinDocCount);
        result = 31 * result + Objects.hashCode(this.shardSize);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.sourceFields);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SignificantTextAggregation other = (SignificantTextAggregation) o;
        return Objects.equals(this.backgroundFilter, other.backgroundFilter)
            && Objects.equals(this.chiSquare, other.chiSquare)
            && Objects.equals(this.exclude, other.exclude)
            && Objects.equals(this.executionHint, other.executionHint)
            && Objects.equals(this.field, other.field)
            && Objects.equals(this.filterDuplicateText, other.filterDuplicateText)
            && Objects.equals(this.gnd, other.gnd)
            && Objects.equals(this.include, other.include)
            && Objects.equals(this.jlh, other.jlh)
            && Objects.equals(this.minDocCount, other.minDocCount)
            && Objects.equals(this.mutualInformation, other.mutualInformation)
            && Objects.equals(this.percentage, other.percentage)
            && Objects.equals(this.scriptHeuristic, other.scriptHeuristic)
            && Objects.equals(this.shardMinDocCount, other.shardMinDocCount)
            && Objects.equals(this.shardSize, other.shardSize)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.sourceFields, other.sourceFields);
    }
}
