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

// typedef: _types.aggregations.SerialDifferencingAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SerialDifferencingAggregation extends PipelineAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<SerialDifferencingAggregation.Builder, SerialDifferencingAggregation> {

    @Nullable
    private final Integer lag;

    // ---------------------------------------------------------------------------------------------

    private SerialDifferencingAggregation(Builder builder) {
        super(builder);
        this.lag = builder.lag;
    }

    public static SerialDifferencingAggregation of(
        Function<SerialDifferencingAggregation.Builder, ObjectBuilder<SerialDifferencingAggregation>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.SerialDiff;
    }

    /**
     * The historical bucket to subtract from the current value. Must be a positive, non-zero integer.
     * <p>
     * API name: {@code lag}
     * </p>
     */
    @Nullable
    public final Integer lag() {
        return this.lag;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.lag != null) {
            generator.writeKey("lag");
            generator.write(this.lag);
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
     * Builder for {@link SerialDifferencingAggregation}.
     */
    public static class Builder extends PipelineAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, SerialDifferencingAggregation> {
        @Nullable
        private Integer lag;

        public Builder() {}

        private Builder(SerialDifferencingAggregation o) {
            super(o);
            this.lag = o.lag;
        }

        private Builder(Builder o) {
            super(o);
            this.lag = o.lag;
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
         * The historical bucket to subtract from the current value. Must be a positive, non-zero integer.
         * <p>
         * API name: {@code lag}
         * </p>
         */
        @Nonnull
        public final Builder lag(@Nullable Integer value) {
            this.lag = value;
            return this;
        }

        /**
         * Builds a {@link SerialDifferencingAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SerialDifferencingAggregation build() {
            _checkSingleUse();

            return new SerialDifferencingAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SerialDifferencingAggregation}
     */
    public static final JsonpDeserializer<SerialDifferencingAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SerialDifferencingAggregation::setupSerialDifferencingAggregationDeserializer
    );

    protected static void setupSerialDifferencingAggregationDeserializer(ObjectDeserializer<SerialDifferencingAggregation.Builder> op) {
        setupPipelineAggregationBaseDeserializer(op);
        op.add(Builder::lag, JsonpDeserializer.integerDeserializer(), "lag");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.lag);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SerialDifferencingAggregation other = (SerialDifferencingAggregation) o;
        return Objects.equals(this.lag, other.lag);
    }
}
