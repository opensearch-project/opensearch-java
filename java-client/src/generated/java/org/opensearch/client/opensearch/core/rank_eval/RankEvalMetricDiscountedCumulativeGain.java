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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.rank_eval.RankEvalMetricDiscountedCumulativeGain

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RankEvalMetricDiscountedCumulativeGain extends RankEvalMetricBase
    implements
        ToCopyableBuilder<RankEvalMetricDiscountedCumulativeGain.Builder, RankEvalMetricDiscountedCumulativeGain> {

    @Nullable
    private final Boolean normalize;

    // ---------------------------------------------------------------------------------------------

    private RankEvalMetricDiscountedCumulativeGain(Builder builder) {
        super(builder);
        this.normalize = builder.normalize;
    }

    public static RankEvalMetricDiscountedCumulativeGain of(
        Function<RankEvalMetricDiscountedCumulativeGain.Builder, ObjectBuilder<RankEvalMetricDiscountedCumulativeGain>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * When <code>true</code>, calculates the <a href="https://en.wikipedia.org/wiki/Discounted_cumulative_gain#Normalized_DCG">normalized
     * discounted cumulative gain (nDCG)</a>.
     * <p>
     * API name: {@code normalize}
     * </p>
     */
    @Nullable
    public final Boolean normalize() {
        return this.normalize;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.normalize != null) {
            generator.writeKey("normalize");
            generator.write(this.normalize);
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
     * Builder for {@link RankEvalMetricDiscountedCumulativeGain}.
     */
    public static class Builder extends RankEvalMetricBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, RankEvalMetricDiscountedCumulativeGain> {
        @Nullable
        private Boolean normalize;

        public Builder() {}

        private Builder(RankEvalMetricDiscountedCumulativeGain o) {
            super(o);
            this.normalize = o.normalize;
        }

        private Builder(Builder o) {
            super(o);
            this.normalize = o.normalize;
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
         * When <code>true</code>, calculates the
         * <a href="https://en.wikipedia.org/wiki/Discounted_cumulative_gain#Normalized_DCG">normalized discounted cumulative gain
         * (nDCG)</a>.
         * <p>
         * API name: {@code normalize}
         * </p>
         */
        @Nonnull
        public final Builder normalize(@Nullable Boolean value) {
            this.normalize = value;
            return this;
        }

        /**
         * Builds a {@link RankEvalMetricDiscountedCumulativeGain}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RankEvalMetricDiscountedCumulativeGain build() {
            _checkSingleUse();

            return new RankEvalMetricDiscountedCumulativeGain(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RankEvalMetricDiscountedCumulativeGain}
     */
    public static final JsonpDeserializer<RankEvalMetricDiscountedCumulativeGain> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RankEvalMetricDiscountedCumulativeGain::setupRankEvalMetricDiscountedCumulativeGainDeserializer
    );

    protected static void setupRankEvalMetricDiscountedCumulativeGainDeserializer(
        ObjectDeserializer<RankEvalMetricDiscountedCumulativeGain.Builder> op
    ) {
        setupRankEvalMetricBaseDeserializer(op);
        op.add(Builder::normalize, JsonpDeserializer.booleanDeserializer(), "normalize");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.normalize);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RankEvalMetricDiscountedCumulativeGain other = (RankEvalMetricDiscountedCumulativeGain) o;
        return Objects.equals(this.normalize, other.normalize);
    }
}
