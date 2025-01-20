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
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.StringStatsAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class StringStatsAggregation extends MetricAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<StringStatsAggregation.Builder, StringStatsAggregation> {

    @Nullable
    private final Boolean showDistribution;

    // ---------------------------------------------------------------------------------------------

    private StringStatsAggregation(Builder builder) {
        super(builder);
        this.showDistribution = builder.showDistribution;
    }

    public static StringStatsAggregation of(Function<StringStatsAggregation.Builder, ObjectBuilder<StringStatsAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.StringStats;
    }

    /**
     * Shows the probability distribution for all characters.
     * <p>
     * API name: {@code show_distribution}
     * </p>
     */
    @Nullable
    public final Boolean showDistribution() {
        return this.showDistribution;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.showDistribution != null) {
            generator.writeKey("show_distribution");
            generator.write(this.showDistribution);
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
     * Builder for {@link StringStatsAggregation}.
     */
    public static class Builder extends MetricAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, StringStatsAggregation> {
        @Nullable
        private Boolean showDistribution;

        public Builder() {}

        private Builder(StringStatsAggregation o) {
            super(o);
            this.showDistribution = o.showDistribution;
        }

        private Builder(Builder o) {
            super(o);
            this.showDistribution = o.showDistribution;
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
         * Shows the probability distribution for all characters.
         * <p>
         * API name: {@code show_distribution}
         * </p>
         */
        @Nonnull
        public final Builder showDistribution(@Nullable Boolean value) {
            this.showDistribution = value;
            return this;
        }

        /**
         * Builds a {@link StringStatsAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public StringStatsAggregation build() {
            _checkSingleUse();

            return new StringStatsAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link StringStatsAggregation}
     */
    public static final JsonpDeserializer<StringStatsAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        StringStatsAggregation::setupStringStatsAggregationDeserializer
    );

    protected static void setupStringStatsAggregationDeserializer(ObjectDeserializer<StringStatsAggregation.Builder> op) {
        setupMetricAggregationBaseDeserializer(op);
        op.add(Builder::showDistribution, JsonpDeserializer.booleanDeserializer(), "show_distribution");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.showDistribution);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        StringStatsAggregation other = (StringStatsAggregation) o;
        return Objects.equals(this.showDistribution, other.showDistribution);
    }
}
