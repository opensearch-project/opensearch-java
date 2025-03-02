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
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;

// typedef: core.rank_eval.RankEvalMetricRatingThreshold

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class RankEvalMetricRatingThreshold extends RankEvalMetricBase {

    @Nullable
    private final Integer relevantRatingThreshold;

    // ---------------------------------------------------------------------------------------------

    protected RankEvalMetricRatingThreshold(AbstractBuilder<?> builder) {
        super(builder);
        this.relevantRatingThreshold = builder.relevantRatingThreshold;
    }

    /**
     * Sets the rating threshold above which documents are considered to be relevant.
     * <p>
     * API name: {@code relevant_rating_threshold}
     * </p>
     */
    @Nullable
    public final Integer relevantRatingThreshold() {
        return this.relevantRatingThreshold;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.relevantRatingThreshold != null) {
            generator.writeKey("relevant_rating_threshold");
            generator.write(this.relevantRatingThreshold);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends RankEvalMetricBase.AbstractBuilder<
        BuilderT> {
        @Nullable
        private Integer relevantRatingThreshold;

        protected AbstractBuilder() {}

        protected AbstractBuilder(RankEvalMetricRatingThreshold o) {
            super(o);
            this.relevantRatingThreshold = o.relevantRatingThreshold;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            super(o);
            this.relevantRatingThreshold = o.relevantRatingThreshold;
        }

        /**
         * Sets the rating threshold above which documents are considered to be relevant.
         * <p>
         * API name: {@code relevant_rating_threshold}
         * </p>
         */
        @Nonnull
        public final BuilderT relevantRatingThreshold(@Nullable Integer value) {
            this.relevantRatingThreshold = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupRankEvalMetricRatingThresholdDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        setupRankEvalMetricBaseDeserializer(op);
        op.add(AbstractBuilder::relevantRatingThreshold, JsonpDeserializer.integerDeserializer(), "relevant_rating_threshold");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.relevantRatingThreshold);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RankEvalMetricRatingThreshold other = (RankEvalMetricRatingThreshold) o;
        return Objects.equals(this.relevantRatingThreshold, other.relevantRatingThreshold);
    }
}
