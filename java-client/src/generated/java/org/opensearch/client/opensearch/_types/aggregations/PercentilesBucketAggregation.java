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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.PercentilesBucketAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PercentilesBucketAggregation extends PipelineAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<PercentilesBucketAggregation.Builder, PercentilesBucketAggregation> {

    @Nonnull
    private final List<Double> percents;

    // ---------------------------------------------------------------------------------------------

    private PercentilesBucketAggregation(Builder builder) {
        super(builder);
        this.percents = ApiTypeHelper.unmodifiable(builder.percents);
    }

    public static PercentilesBucketAggregation of(
        Function<PercentilesBucketAggregation.Builder, ObjectBuilder<PercentilesBucketAggregation>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.PercentilesBucket;
    }

    /**
     * The list of percentiles to calculate.
     * <p>
     * API name: {@code percents}
     * </p>
     */
    @Nonnull
    public final List<Double> percents() {
        return this.percents;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (ApiTypeHelper.isDefined(this.percents)) {
            generator.writeKey("percents");
            generator.writeStartArray();
            for (Double item0 : this.percents) {
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
     * Builder for {@link PercentilesBucketAggregation}.
     */
    public static class Builder extends PipelineAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, PercentilesBucketAggregation> {
        @Nullable
        private List<Double> percents;

        public Builder() {}

        private Builder(PercentilesBucketAggregation o) {
            super(o);
            this.percents = _listCopy(o.percents);
        }

        private Builder(Builder o) {
            super(o);
            this.percents = _listCopy(o.percents);
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
         * The list of percentiles to calculate.
         * <p>
         * API name: {@code percents}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>percents</code>.
         * </p>
         */
        @Nonnull
        public final Builder percents(List<Double> list) {
            this.percents = _listAddAll(this.percents, list);
            return this;
        }

        /**
         * The list of percentiles to calculate.
         * <p>
         * API name: {@code percents}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>percents</code>.
         * </p>
         */
        @Nonnull
        public final Builder percents(Double value, Double... values) {
            this.percents = _listAdd(this.percents, value, values);
            return this;
        }

        /**
         * Builds a {@link PercentilesBucketAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PercentilesBucketAggregation build() {
            _checkSingleUse();

            return new PercentilesBucketAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PercentilesBucketAggregation}
     */
    public static final JsonpDeserializer<PercentilesBucketAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PercentilesBucketAggregation::setupPercentilesBucketAggregationDeserializer
    );

    protected static void setupPercentilesBucketAggregationDeserializer(ObjectDeserializer<PercentilesBucketAggregation.Builder> op) {
        setupPipelineAggregationBaseDeserializer(op);
        op.add(Builder::percents, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.doubleDeserializer()), "percents");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.percents);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PercentilesBucketAggregation other = (PercentilesBucketAggregation) o;
        return Objects.equals(this.percents, other.percents);
    }
}
