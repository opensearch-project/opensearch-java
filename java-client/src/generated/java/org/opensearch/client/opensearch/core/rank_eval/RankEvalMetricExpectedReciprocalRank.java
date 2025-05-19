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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.rank_eval.RankEvalMetricExpectedReciprocalRank

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RankEvalMetricExpectedReciprocalRank extends RankEvalMetricBase
    implements
        ToCopyableBuilder<RankEvalMetricExpectedReciprocalRank.Builder, RankEvalMetricExpectedReciprocalRank> {

    private final int maximumRelevance;

    // ---------------------------------------------------------------------------------------------

    private RankEvalMetricExpectedReciprocalRank(Builder builder) {
        super(builder);
        this.maximumRelevance = ApiTypeHelper.requireNonNull(builder.maximumRelevance, this, "maximumRelevance");
    }

    public static RankEvalMetricExpectedReciprocalRank of(
        Function<RankEvalMetricExpectedReciprocalRank.Builder, ObjectBuilder<RankEvalMetricExpectedReciprocalRank>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The highest relevance grade used in user-supplied relevance judgments.
     * <p>
     * API name: {@code maximum_relevance}
     * </p>
     */
    public final int maximumRelevance() {
        return this.maximumRelevance;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("maximum_relevance");
        generator.write(this.maximumRelevance);
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
     * Builder for {@link RankEvalMetricExpectedReciprocalRank}.
     */
    public static class Builder extends RankEvalMetricBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, RankEvalMetricExpectedReciprocalRank> {
        private Integer maximumRelevance;

        public Builder() {}

        private Builder(RankEvalMetricExpectedReciprocalRank o) {
            super(o);
            this.maximumRelevance = o.maximumRelevance;
        }

        private Builder(Builder o) {
            super(o);
            this.maximumRelevance = o.maximumRelevance;
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
         * Required - The highest relevance grade used in user-supplied relevance judgments.
         * <p>
         * API name: {@code maximum_relevance}
         * </p>
         */
        @Nonnull
        public final Builder maximumRelevance(int value) {
            this.maximumRelevance = value;
            return this;
        }

        /**
         * Builds a {@link RankEvalMetricExpectedReciprocalRank}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RankEvalMetricExpectedReciprocalRank build() {
            _checkSingleUse();

            return new RankEvalMetricExpectedReciprocalRank(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RankEvalMetricExpectedReciprocalRank}
     */
    public static final JsonpDeserializer<RankEvalMetricExpectedReciprocalRank> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RankEvalMetricExpectedReciprocalRank::setupRankEvalMetricExpectedReciprocalRankDeserializer
    );

    protected static void setupRankEvalMetricExpectedReciprocalRankDeserializer(
        ObjectDeserializer<RankEvalMetricExpectedReciprocalRank.Builder> op
    ) {
        setupRankEvalMetricBaseDeserializer(op);
        op.add(Builder::maximumRelevance, JsonpDeserializer.integerDeserializer(), "maximum_relevance");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Integer.hashCode(this.maximumRelevance);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RankEvalMetricExpectedReciprocalRank other = (RankEvalMetricExpectedReciprocalRank) o;
        return this.maximumRelevance == other.maximumRelevance;
    }
}
