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

// typedef: core.rank_eval.RankEvalMetricPrecision

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RankEvalMetricPrecision extends RankEvalMetricRatingThreshold
    implements
        ToCopyableBuilder<RankEvalMetricPrecision.Builder, RankEvalMetricPrecision> {

    @Nullable
    private final Boolean ignoreUnlabeled;

    // ---------------------------------------------------------------------------------------------

    private RankEvalMetricPrecision(Builder builder) {
        super(builder);
        this.ignoreUnlabeled = builder.ignoreUnlabeled;
    }

    public static RankEvalMetricPrecision of(Function<RankEvalMetricPrecision.Builder, ObjectBuilder<RankEvalMetricPrecision>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Controls how unlabeled documents in the search results are counted. When <code>true</code>, unlabeled documents are ignored and are
     * not treated as relevant or irrelevant. When <code>false</code>, unlabeled documents are treated as irrelevant.
     * <p>
     * API name: {@code ignore_unlabeled}
     * </p>
     */
    @Nullable
    public final Boolean ignoreUnlabeled() {
        return this.ignoreUnlabeled;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.ignoreUnlabeled != null) {
            generator.writeKey("ignore_unlabeled");
            generator.write(this.ignoreUnlabeled);
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
     * Builder for {@link RankEvalMetricPrecision}.
     */
    public static class Builder extends RankEvalMetricRatingThreshold.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, RankEvalMetricPrecision> {
        @Nullable
        private Boolean ignoreUnlabeled;

        public Builder() {}

        private Builder(RankEvalMetricPrecision o) {
            super(o);
            this.ignoreUnlabeled = o.ignoreUnlabeled;
        }

        private Builder(Builder o) {
            super(o);
            this.ignoreUnlabeled = o.ignoreUnlabeled;
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
         * Controls how unlabeled documents in the search results are counted. When <code>true</code>, unlabeled documents are ignored and
         * are not treated as relevant or irrelevant. When <code>false</code>, unlabeled documents are treated as irrelevant.
         * <p>
         * API name: {@code ignore_unlabeled}
         * </p>
         */
        @Nonnull
        public final Builder ignoreUnlabeled(@Nullable Boolean value) {
            this.ignoreUnlabeled = value;
            return this;
        }

        /**
         * Builds a {@link RankEvalMetricPrecision}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RankEvalMetricPrecision build() {
            _checkSingleUse();

            return new RankEvalMetricPrecision(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RankEvalMetricPrecision}
     */
    public static final JsonpDeserializer<RankEvalMetricPrecision> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RankEvalMetricPrecision::setupRankEvalMetricPrecisionDeserializer
    );

    protected static void setupRankEvalMetricPrecisionDeserializer(ObjectDeserializer<RankEvalMetricPrecision.Builder> op) {
        setupRankEvalMetricRatingThresholdDeserializer(op);
        op.add(Builder::ignoreUnlabeled, JsonpDeserializer.booleanDeserializer(), "ignore_unlabeled");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreUnlabeled);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RankEvalMetricPrecision other = (RankEvalMetricPrecision) o;
        return Objects.equals(this.ignoreUnlabeled, other.ignoreUnlabeled);
    }
}
