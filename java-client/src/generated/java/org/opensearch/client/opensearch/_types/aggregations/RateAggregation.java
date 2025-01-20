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

// typedef: _types.aggregations.RateAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RateAggregation extends FormatMetricAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<RateAggregation.Builder, RateAggregation> {

    @Nullable
    private final RateMode mode;

    @Nullable
    private final CalendarInterval unit;

    // ---------------------------------------------------------------------------------------------

    private RateAggregation(Builder builder) {
        super(builder);
        this.mode = builder.mode;
        this.unit = builder.unit;
    }

    public static RateAggregation of(Function<RateAggregation.Builder, ObjectBuilder<RateAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.Rate;
    }

    /**
     * API name: {@code mode}
     */
    @Nullable
    public final RateMode mode() {
        return this.mode;
    }

    /**
     * API name: {@code unit}
     */
    @Nullable
    public final CalendarInterval unit() {
        return this.unit;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.mode != null) {
            generator.writeKey("mode");
            this.mode.serialize(generator, mapper);
        }

        if (this.unit != null) {
            generator.writeKey("unit");
            this.unit.serialize(generator, mapper);
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
     * Builder for {@link RateAggregation}.
     */
    public static class Builder extends FormatMetricAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, RateAggregation> {
        @Nullable
        private RateMode mode;
        @Nullable
        private CalendarInterval unit;

        public Builder() {}

        private Builder(RateAggregation o) {
            super(o);
            this.mode = o.mode;
            this.unit = o.unit;
        }

        private Builder(Builder o) {
            super(o);
            this.mode = o.mode;
            this.unit = o.unit;
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
         * API name: {@code mode}
         */
        @Nonnull
        public final Builder mode(@Nullable RateMode value) {
            this.mode = value;
            return this;
        }

        /**
         * API name: {@code unit}
         */
        @Nonnull
        public final Builder unit(@Nullable CalendarInterval value) {
            this.unit = value;
            return this;
        }

        /**
         * Builds a {@link RateAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RateAggregation build() {
            _checkSingleUse();

            return new RateAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RateAggregation}
     */
    public static final JsonpDeserializer<RateAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RateAggregation::setupRateAggregationDeserializer
    );

    protected static void setupRateAggregationDeserializer(ObjectDeserializer<RateAggregation.Builder> op) {
        setupFormatMetricAggregationBaseDeserializer(op);
        op.add(Builder::mode, RateMode._DESERIALIZER, "mode");
        op.add(Builder::unit, CalendarInterval._DESERIALIZER, "unit");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.mode);
        result = 31 * result + Objects.hashCode(this.unit);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RateAggregation other = (RateAggregation) o;
        return Objects.equals(this.mode, other.mode) && Objects.equals(this.unit, other.unit);
    }
}
