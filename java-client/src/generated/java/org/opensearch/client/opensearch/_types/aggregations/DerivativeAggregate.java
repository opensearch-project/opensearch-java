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

// typedef: _types.aggregations.DerivativeAggregate

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DerivativeAggregate extends SingleMetricAggregateBase
    implements
        AggregateVariant,
        ToCopyableBuilder<DerivativeAggregate.Builder, DerivativeAggregate> {

    @Nullable
    private final Double normalizedValue;

    @Nullable
    private final String normalizedValueAsString;

    // ---------------------------------------------------------------------------------------------

    private DerivativeAggregate(Builder builder) {
        super(builder);
        this.normalizedValue = builder.normalizedValue;
        this.normalizedValueAsString = builder.normalizedValueAsString;
    }

    public static DerivativeAggregate of(Function<DerivativeAggregate.Builder, ObjectBuilder<DerivativeAggregate>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregate} variant kind.
     */
    @Override
    public Aggregate.Kind _aggregateKind() {
        return Aggregate.Kind.Derivative;
    }

    /**
     * API name: {@code normalized_value}
     */
    @Nullable
    public final Double normalizedValue() {
        return this.normalizedValue;
    }

    /**
     * API name: {@code normalized_value_as_string}
     */
    @Nullable
    public final String normalizedValueAsString() {
        return this.normalizedValueAsString;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.normalizedValue != null) {
            generator.writeKey("normalized_value");
            generator.write(this.normalizedValue);
        }

        if (this.normalizedValueAsString != null) {
            generator.writeKey("normalized_value_as_string");
            generator.write(this.normalizedValueAsString);
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
     * Builder for {@link DerivativeAggregate}.
     */
    public static class Builder extends SingleMetricAggregateBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, DerivativeAggregate> {
        @Nullable
        private Double normalizedValue;
        @Nullable
        private String normalizedValueAsString;

        public Builder() {}

        private Builder(DerivativeAggregate o) {
            super(o);
            this.normalizedValue = o.normalizedValue;
            this.normalizedValueAsString = o.normalizedValueAsString;
        }

        private Builder(Builder o) {
            super(o);
            this.normalizedValue = o.normalizedValue;
            this.normalizedValueAsString = o.normalizedValueAsString;
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
         * API name: {@code normalized_value}
         */
        @Nonnull
        public final Builder normalizedValue(@Nullable Double value) {
            this.normalizedValue = value;
            return this;
        }

        /**
         * API name: {@code normalized_value_as_string}
         */
        @Nonnull
        public final Builder normalizedValueAsString(@Nullable String value) {
            this.normalizedValueAsString = value;
            return this;
        }

        /**
         * Builds a {@link DerivativeAggregate}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DerivativeAggregate build() {
            _checkSingleUse();

            return new DerivativeAggregate(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DerivativeAggregate}
     */
    public static final JsonpDeserializer<DerivativeAggregate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DerivativeAggregate::setupDerivativeAggregateDeserializer
    );

    protected static void setupDerivativeAggregateDeserializer(ObjectDeserializer<DerivativeAggregate.Builder> op) {
        setupSingleMetricAggregateBaseDeserializer(op);
        op.add(Builder::normalizedValue, JsonpDeserializer.doubleDeserializer(), "normalized_value");
        op.add(Builder::normalizedValueAsString, JsonpDeserializer.stringDeserializer(), "normalized_value_as_string");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.normalizedValue);
        result = 31 * result + Objects.hashCode(this.normalizedValueAsString);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DerivativeAggregate other = (DerivativeAggregate) o;
        return Objects.equals(this.normalizedValue, other.normalizedValue)
            && Objects.equals(this.normalizedValueAsString, other.normalizedValueAsString);
    }
}
