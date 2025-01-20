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

// typedef: _types.aggregations.PercentilesAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PercentilesAggregation extends FormatMetricAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<PercentilesAggregation.Builder, PercentilesAggregation> {

    @Nullable
    private final HdrMethod hdr;

    @Nullable
    private final Boolean keyed;

    @Nonnull
    private final List<Double> percents;

    @Nullable
    private final TDigest tdigest;

    // ---------------------------------------------------------------------------------------------

    private PercentilesAggregation(Builder builder) {
        super(builder);
        this.hdr = builder.hdr;
        this.keyed = builder.keyed;
        this.percents = ApiTypeHelper.unmodifiable(builder.percents);
        this.tdigest = builder.tdigest;
    }

    public static PercentilesAggregation of(Function<PercentilesAggregation.Builder, ObjectBuilder<PercentilesAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.Percentiles;
    }

    /**
     * API name: {@code hdr}
     */
    @Nullable
    public final HdrMethod hdr() {
        return this.hdr;
    }

    /**
     * By default, the aggregation associates a unique string key with each bucket and returns the ranges as a hash rather than an array.
     * Set to <code>false</code> to disable this behavior.
     * <p>
     * API name: {@code keyed}
     * </p>
     */
    @Nullable
    public final Boolean keyed() {
        return this.keyed;
    }

    /**
     * The percentiles to calculate.
     * <p>
     * API name: {@code percents}
     * </p>
     */
    @Nonnull
    public final List<Double> percents() {
        return this.percents;
    }

    /**
     * API name: {@code tdigest}
     */
    @Nullable
    public final TDigest tdigest() {
        return this.tdigest;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.hdr != null) {
            generator.writeKey("hdr");
            this.hdr.serialize(generator, mapper);
        }

        if (this.keyed != null) {
            generator.writeKey("keyed");
            generator.write(this.keyed);
        }

        if (ApiTypeHelper.isDefined(this.percents)) {
            generator.writeKey("percents");
            generator.writeStartArray();
            for (Double item0 : this.percents) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.tdigest != null) {
            generator.writeKey("tdigest");
            this.tdigest.serialize(generator, mapper);
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
     * Builder for {@link PercentilesAggregation}.
     */
    public static class Builder extends FormatMetricAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, PercentilesAggregation> {
        @Nullable
        private HdrMethod hdr;
        @Nullable
        private Boolean keyed;
        @Nullable
        private List<Double> percents;
        @Nullable
        private TDigest tdigest;

        public Builder() {}

        private Builder(PercentilesAggregation o) {
            super(o);
            this.hdr = o.hdr;
            this.keyed = o.keyed;
            this.percents = _listCopy(o.percents);
            this.tdigest = o.tdigest;
        }

        private Builder(Builder o) {
            super(o);
            this.hdr = o.hdr;
            this.keyed = o.keyed;
            this.percents = _listCopy(o.percents);
            this.tdigest = o.tdigest;
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
         * API name: {@code hdr}
         */
        @Nonnull
        public final Builder hdr(@Nullable HdrMethod value) {
            this.hdr = value;
            return this;
        }

        /**
         * API name: {@code hdr}
         */
        @Nonnull
        public final Builder hdr(Function<HdrMethod.Builder, ObjectBuilder<HdrMethod>> fn) {
            return hdr(fn.apply(new HdrMethod.Builder()).build());
        }

        /**
         * By default, the aggregation associates a unique string key with each bucket and returns the ranges as a hash rather than an
         * array. Set to <code>false</code> to disable this behavior.
         * <p>
         * API name: {@code keyed}
         * </p>
         */
        @Nonnull
        public final Builder keyed(@Nullable Boolean value) {
            this.keyed = value;
            return this;
        }

        /**
         * The percentiles to calculate.
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
         * The percentiles to calculate.
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
         * API name: {@code tdigest}
         */
        @Nonnull
        public final Builder tdigest(@Nullable TDigest value) {
            this.tdigest = value;
            return this;
        }

        /**
         * API name: {@code tdigest}
         */
        @Nonnull
        public final Builder tdigest(Function<TDigest.Builder, ObjectBuilder<TDigest>> fn) {
            return tdigest(fn.apply(new TDigest.Builder()).build());
        }

        /**
         * Builds a {@link PercentilesAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PercentilesAggregation build() {
            _checkSingleUse();

            return new PercentilesAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PercentilesAggregation}
     */
    public static final JsonpDeserializer<PercentilesAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PercentilesAggregation::setupPercentilesAggregationDeserializer
    );

    protected static void setupPercentilesAggregationDeserializer(ObjectDeserializer<PercentilesAggregation.Builder> op) {
        setupFormatMetricAggregationBaseDeserializer(op);
        op.add(Builder::hdr, HdrMethod._DESERIALIZER, "hdr");
        op.add(Builder::keyed, JsonpDeserializer.booleanDeserializer(), "keyed");
        op.add(Builder::percents, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.doubleDeserializer()), "percents");
        op.add(Builder::tdigest, TDigest._DESERIALIZER, "tdigest");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.hdr);
        result = 31 * result + Objects.hashCode(this.keyed);
        result = 31 * result + Objects.hashCode(this.percents);
        result = 31 * result + Objects.hashCode(this.tdigest);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PercentilesAggregation other = (PercentilesAggregation) o;
        return Objects.equals(this.hdr, other.hdr)
            && Objects.equals(this.keyed, other.keyed)
            && Objects.equals(this.percents, other.percents)
            && Objects.equals(this.tdigest, other.tdigest);
    }
}
