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

package org.opensearch.client.opensearch.core.rank_eval;

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

// typedef: core.rank_eval.RankEvalMetric

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RankEvalMetric implements PlainJsonSerializable, ToCopyableBuilder<RankEvalMetric.Builder, RankEvalMetric> {

    @Nullable
    private final RankEvalMetricDiscountedCumulativeGain dcg;

    @Nullable
    private final RankEvalMetricExpectedReciprocalRank expectedReciprocalRank;

    @Nullable
    private final RankEvalMetricMeanReciprocalRank meanReciprocalRank;

    @Nullable
    private final RankEvalMetricPrecision precision;

    @Nullable
    private final RankEvalMetricRecall recall;

    // ---------------------------------------------------------------------------------------------

    private RankEvalMetric(Builder builder) {
        this.dcg = builder.dcg;
        this.expectedReciprocalRank = builder.expectedReciprocalRank;
        this.meanReciprocalRank = builder.meanReciprocalRank;
        this.precision = builder.precision;
        this.recall = builder.recall;
    }

    public static RankEvalMetric of(Function<RankEvalMetric.Builder, ObjectBuilder<RankEvalMetric>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code dcg}
     */
    @Nullable
    public final RankEvalMetricDiscountedCumulativeGain dcg() {
        return this.dcg;
    }

    /**
     * API name: {@code expected_reciprocal_rank}
     */
    @Nullable
    public final RankEvalMetricExpectedReciprocalRank expectedReciprocalRank() {
        return this.expectedReciprocalRank;
    }

    /**
     * API name: {@code mean_reciprocal_rank}
     */
    @Nullable
    public final RankEvalMetricMeanReciprocalRank meanReciprocalRank() {
        return this.meanReciprocalRank;
    }

    /**
     * API name: {@code precision}
     */
    @Nullable
    public final RankEvalMetricPrecision precision() {
        return this.precision;
    }

    /**
     * API name: {@code recall}
     */
    @Nullable
    public final RankEvalMetricRecall recall() {
        return this.recall;
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
        if (this.dcg != null) {
            generator.writeKey("dcg");
            this.dcg.serialize(generator, mapper);
        }

        if (this.expectedReciprocalRank != null) {
            generator.writeKey("expected_reciprocal_rank");
            this.expectedReciprocalRank.serialize(generator, mapper);
        }

        if (this.meanReciprocalRank != null) {
            generator.writeKey("mean_reciprocal_rank");
            this.meanReciprocalRank.serialize(generator, mapper);
        }

        if (this.precision != null) {
            generator.writeKey("precision");
            this.precision.serialize(generator, mapper);
        }

        if (this.recall != null) {
            generator.writeKey("recall");
            this.recall.serialize(generator, mapper);
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
     * Builder for {@link RankEvalMetric}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RankEvalMetric> {
        @Nullable
        private RankEvalMetricDiscountedCumulativeGain dcg;
        @Nullable
        private RankEvalMetricExpectedReciprocalRank expectedReciprocalRank;
        @Nullable
        private RankEvalMetricMeanReciprocalRank meanReciprocalRank;
        @Nullable
        private RankEvalMetricPrecision precision;
        @Nullable
        private RankEvalMetricRecall recall;

        public Builder() {}

        private Builder(RankEvalMetric o) {
            this.dcg = o.dcg;
            this.expectedReciprocalRank = o.expectedReciprocalRank;
            this.meanReciprocalRank = o.meanReciprocalRank;
            this.precision = o.precision;
            this.recall = o.recall;
        }

        private Builder(Builder o) {
            this.dcg = o.dcg;
            this.expectedReciprocalRank = o.expectedReciprocalRank;
            this.meanReciprocalRank = o.meanReciprocalRank;
            this.precision = o.precision;
            this.recall = o.recall;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code dcg}
         */
        @Nonnull
        public final Builder dcg(@Nullable RankEvalMetricDiscountedCumulativeGain value) {
            this.dcg = value;
            return this;
        }

        /**
         * API name: {@code dcg}
         */
        @Nonnull
        public final Builder dcg(
            Function<RankEvalMetricDiscountedCumulativeGain.Builder, ObjectBuilder<RankEvalMetricDiscountedCumulativeGain>> fn
        ) {
            return dcg(fn.apply(new RankEvalMetricDiscountedCumulativeGain.Builder()).build());
        }

        /**
         * API name: {@code expected_reciprocal_rank}
         */
        @Nonnull
        public final Builder expectedReciprocalRank(@Nullable RankEvalMetricExpectedReciprocalRank value) {
            this.expectedReciprocalRank = value;
            return this;
        }

        /**
         * API name: {@code expected_reciprocal_rank}
         */
        @Nonnull
        public final Builder expectedReciprocalRank(
            Function<RankEvalMetricExpectedReciprocalRank.Builder, ObjectBuilder<RankEvalMetricExpectedReciprocalRank>> fn
        ) {
            return expectedReciprocalRank(fn.apply(new RankEvalMetricExpectedReciprocalRank.Builder()).build());
        }

        /**
         * API name: {@code mean_reciprocal_rank}
         */
        @Nonnull
        public final Builder meanReciprocalRank(@Nullable RankEvalMetricMeanReciprocalRank value) {
            this.meanReciprocalRank = value;
            return this;
        }

        /**
         * API name: {@code mean_reciprocal_rank}
         */
        @Nonnull
        public final Builder meanReciprocalRank(
            Function<RankEvalMetricMeanReciprocalRank.Builder, ObjectBuilder<RankEvalMetricMeanReciprocalRank>> fn
        ) {
            return meanReciprocalRank(fn.apply(new RankEvalMetricMeanReciprocalRank.Builder()).build());
        }

        /**
         * API name: {@code precision}
         */
        @Nonnull
        public final Builder precision(@Nullable RankEvalMetricPrecision value) {
            this.precision = value;
            return this;
        }

        /**
         * API name: {@code precision}
         */
        @Nonnull
        public final Builder precision(Function<RankEvalMetricPrecision.Builder, ObjectBuilder<RankEvalMetricPrecision>> fn) {
            return precision(fn.apply(new RankEvalMetricPrecision.Builder()).build());
        }

        /**
         * API name: {@code recall}
         */
        @Nonnull
        public final Builder recall(@Nullable RankEvalMetricRecall value) {
            this.recall = value;
            return this;
        }

        /**
         * API name: {@code recall}
         */
        @Nonnull
        public final Builder recall(Function<RankEvalMetricRecall.Builder, ObjectBuilder<RankEvalMetricRecall>> fn) {
            return recall(fn.apply(new RankEvalMetricRecall.Builder()).build());
        }

        /**
         * Builds a {@link RankEvalMetric}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RankEvalMetric build() {
            _checkSingleUse();

            return new RankEvalMetric(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RankEvalMetric}
     */
    public static final JsonpDeserializer<RankEvalMetric> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RankEvalMetric::setupRankEvalMetricDeserializer
    );

    protected static void setupRankEvalMetricDeserializer(ObjectDeserializer<RankEvalMetric.Builder> op) {
        op.add(Builder::dcg, RankEvalMetricDiscountedCumulativeGain._DESERIALIZER, "dcg");
        op.add(Builder::expectedReciprocalRank, RankEvalMetricExpectedReciprocalRank._DESERIALIZER, "expected_reciprocal_rank");
        op.add(Builder::meanReciprocalRank, RankEvalMetricMeanReciprocalRank._DESERIALIZER, "mean_reciprocal_rank");
        op.add(Builder::precision, RankEvalMetricPrecision._DESERIALIZER, "precision");
        op.add(Builder::recall, RankEvalMetricRecall._DESERIALIZER, "recall");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.dcg);
        result = 31 * result + Objects.hashCode(this.expectedReciprocalRank);
        result = 31 * result + Objects.hashCode(this.meanReciprocalRank);
        result = 31 * result + Objects.hashCode(this.precision);
        result = 31 * result + Objects.hashCode(this.recall);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RankEvalMetric other = (RankEvalMetric) o;
        return Objects.equals(this.dcg, other.dcg)
            && Objects.equals(this.expectedReciprocalRank, other.expectedReciprocalRank)
            && Objects.equals(this.meanReciprocalRank, other.meanReciprocalRank)
            && Objects.equals(this.precision, other.precision)
            && Objects.equals(this.recall, other.recall);
    }
}
