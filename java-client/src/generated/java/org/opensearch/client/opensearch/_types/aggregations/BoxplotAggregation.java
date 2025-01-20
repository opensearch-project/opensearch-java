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

// typedef: _types.aggregations.BoxplotAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class BoxplotAggregation extends MetricAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<BoxplotAggregation.Builder, BoxplotAggregation> {

    @Nullable
    private final Double compression;

    // ---------------------------------------------------------------------------------------------

    private BoxplotAggregation(Builder builder) {
        super(builder);
        this.compression = builder.compression;
    }

    public static BoxplotAggregation of(Function<BoxplotAggregation.Builder, ObjectBuilder<BoxplotAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.Boxplot;
    }

    /**
     * Limits the maximum number of nodes used by the underlying TDigest algorithm to <code>20 * compression</code>, enabling control of
     * memory usage and approximation error.
     * <p>
     * API name: {@code compression}
     * </p>
     */
    @Nullable
    public final Double compression() {
        return this.compression;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.compression != null) {
            generator.writeKey("compression");
            generator.write(this.compression);
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
     * Builder for {@link BoxplotAggregation}.
     */
    public static class Builder extends MetricAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, BoxplotAggregation> {
        @Nullable
        private Double compression;

        public Builder() {}

        private Builder(BoxplotAggregation o) {
            super(o);
            this.compression = o.compression;
        }

        private Builder(Builder o) {
            super(o);
            this.compression = o.compression;
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
         * Limits the maximum number of nodes used by the underlying TDigest algorithm to <code>20 * compression</code>, enabling control of
         * memory usage and approximation error.
         * <p>
         * API name: {@code compression}
         * </p>
         */
        @Nonnull
        public final Builder compression(@Nullable Double value) {
            this.compression = value;
            return this;
        }

        /**
         * Builds a {@link BoxplotAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public BoxplotAggregation build() {
            _checkSingleUse();

            return new BoxplotAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link BoxplotAggregation}
     */
    public static final JsonpDeserializer<BoxplotAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        BoxplotAggregation::setupBoxplotAggregationDeserializer
    );

    protected static void setupBoxplotAggregationDeserializer(ObjectDeserializer<BoxplotAggregation.Builder> op) {
        setupMetricAggregationBaseDeserializer(op);
        op.add(Builder::compression, JsonpDeserializer.doubleDeserializer(), "compression");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.compression);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        BoxplotAggregation other = (BoxplotAggregation) o;
        return Objects.equals(this.compression, other.compression);
    }
}
