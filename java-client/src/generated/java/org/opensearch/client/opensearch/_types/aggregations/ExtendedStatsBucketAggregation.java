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

// typedef: _types.aggregations.ExtendedStatsBucketAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ExtendedStatsBucketAggregation extends PipelineAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<ExtendedStatsBucketAggregation.Builder, ExtendedStatsBucketAggregation> {

    @Nullable
    private final Double sigma;

    // ---------------------------------------------------------------------------------------------

    private ExtendedStatsBucketAggregation(Builder builder) {
        super(builder);
        this.sigma = builder.sigma;
    }

    public static ExtendedStatsBucketAggregation of(
        Function<ExtendedStatsBucketAggregation.Builder, ObjectBuilder<ExtendedStatsBucketAggregation>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.ExtendedStatsBucket;
    }

    /**
     * The number of standard deviations above/below the mean to display.
     * <p>
     * API name: {@code sigma}
     * </p>
     */
    @Nullable
    public final Double sigma() {
        return this.sigma;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.sigma != null) {
            generator.writeKey("sigma");
            generator.write(this.sigma);
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
     * Builder for {@link ExtendedStatsBucketAggregation}.
     */
    public static class Builder extends PipelineAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, ExtendedStatsBucketAggregation> {
        @Nullable
        private Double sigma;

        public Builder() {}

        private Builder(ExtendedStatsBucketAggregation o) {
            super(o);
            this.sigma = o.sigma;
        }

        private Builder(Builder o) {
            super(o);
            this.sigma = o.sigma;
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
         * The number of standard deviations above/below the mean to display.
         * <p>
         * API name: {@code sigma}
         * </p>
         */
        @Nonnull
        public final Builder sigma(@Nullable Double value) {
            this.sigma = value;
            return this;
        }

        /**
         * Builds a {@link ExtendedStatsBucketAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExtendedStatsBucketAggregation build() {
            _checkSingleUse();

            return new ExtendedStatsBucketAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ExtendedStatsBucketAggregation}
     */
    public static final JsonpDeserializer<ExtendedStatsBucketAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ExtendedStatsBucketAggregation::setupExtendedStatsBucketAggregationDeserializer
    );

    protected static void setupExtendedStatsBucketAggregationDeserializer(ObjectDeserializer<ExtendedStatsBucketAggregation.Builder> op) {
        setupPipelineAggregationBaseDeserializer(op);
        op.add(Builder::sigma, JsonpDeserializer.doubleDeserializer(), "sigma");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.sigma);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExtendedStatsBucketAggregation other = (ExtendedStatsBucketAggregation) o;
        return Objects.equals(this.sigma, other.sigma);
    }
}
