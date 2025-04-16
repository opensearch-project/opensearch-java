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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.CardinalityAggregate

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CardinalityAggregate extends AggregateBase
    implements
        AggregateVariant,
        ToCopyableBuilder<CardinalityAggregate.Builder, CardinalityAggregate> {

    private final long value;

    // ---------------------------------------------------------------------------------------------

    private CardinalityAggregate(Builder builder) {
        super(builder);
        this.value = ApiTypeHelper.requireNonNull(builder.value, this, "value");
    }

    public static CardinalityAggregate of(Function<CardinalityAggregate.Builder, ObjectBuilder<CardinalityAggregate>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregate} variant kind.
     */
    @Override
    public Aggregate.Kind _aggregateKind() {
        return Aggregate.Kind.Cardinality;
    }

    /**
     * Required - API name: {@code value}
     */
    public final long value() {
        return this.value;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("value");
        generator.write(this.value);
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
     * Builder for {@link CardinalityAggregate}.
     */
    public static class Builder extends AggregateBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, CardinalityAggregate> {
        private Long value;

        public Builder() {}

        private Builder(CardinalityAggregate o) {
            super(o);
            this.value = o.value;
        }

        private Builder(Builder o) {
            super(o);
            this.value = o.value;
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
         * Required - API name: {@code value}
         */
        @Nonnull
        public final Builder value(long value) {
            this.value = value;
            return this;
        }

        /**
         * Builds a {@link CardinalityAggregate}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CardinalityAggregate build() {
            _checkSingleUse();

            return new CardinalityAggregate(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CardinalityAggregate}
     */
    public static final JsonpDeserializer<CardinalityAggregate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CardinalityAggregate::setupCardinalityAggregateDeserializer
    );

    protected static void setupCardinalityAggregateDeserializer(ObjectDeserializer<CardinalityAggregate.Builder> op) {
        setupAggregateBaseDeserializer(op);
        op.add(Builder::value, JsonpDeserializer.longDeserializer(), "value");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Long.hashCode(this.value);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CardinalityAggregate other = (CardinalityAggregate) o;
        return this.value == other.value;
    }
}
