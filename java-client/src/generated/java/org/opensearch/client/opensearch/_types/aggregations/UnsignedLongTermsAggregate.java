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

import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.UnsignedLongTermsAggregate

/**
 * Result of a <code>terms</code> aggregation when the field is an <code>unsigned_long</code> (64-bit unsigned integer). OpenSearch stores
 * <code>unsigned_long</code> values as Long or BigInteger internally. In JSON responses, bucket keys are represented as numbers, which may
 * lose precision for values larger than 2^53--1 due to IEEE 754 double precision limitations. In protocol buffer representations, keys are
 * manually defined as uint64 to preserve the full 64-bit unsigned range. Use <code>key_as_string</code> in buckets for exact string
 * representation of large unsigned long values.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UnsignedLongTermsAggregate extends TermsAggregateBase<JsonData>
    implements
        AggregateVariant,
        ToCopyableBuilder<UnsignedLongTermsAggregate.Builder, UnsignedLongTermsAggregate> {

    // ---------------------------------------------------------------------------------------------

    private UnsignedLongTermsAggregate(Builder builder) {
        super(builder);
    }

    public static UnsignedLongTermsAggregate of(
        Function<UnsignedLongTermsAggregate.Builder, ObjectBuilder<UnsignedLongTermsAggregate>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregate} variant kind.
     */
    @Override
    public Aggregate.Kind _aggregateKind() {
        return Aggregate.Kind.Ulterms;
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
     * Builder for {@link UnsignedLongTermsAggregate}.
     */
    public static class Builder extends TermsAggregateBase.AbstractBuilder<JsonData, Builder>
        implements
            CopyableBuilder<Builder, UnsignedLongTermsAggregate> {

        public Builder() {}

        private Builder(UnsignedLongTermsAggregate o) {
            super(o);
        }

        private Builder(Builder o) {
            super(o);
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
         * Builds a {@link UnsignedLongTermsAggregate}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UnsignedLongTermsAggregate build() {
            _checkSingleUse();

            return new UnsignedLongTermsAggregate(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UnsignedLongTermsAggregate}
     */
    public static final JsonpDeserializer<UnsignedLongTermsAggregate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UnsignedLongTermsAggregate::setupUnsignedLongTermsAggregateDeserializer
    );

    protected static void setupUnsignedLongTermsAggregateDeserializer(ObjectDeserializer<UnsignedLongTermsAggregate.Builder> op) {
        setupTermsAggregateBaseDeserializer(op, JsonData._DESERIALIZER);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        return true;
    }
}
