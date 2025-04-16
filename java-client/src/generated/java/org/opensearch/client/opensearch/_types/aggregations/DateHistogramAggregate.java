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
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.DateHistogramAggregate

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DateHistogramAggregate extends MultiBucketAggregateBase<DateHistogramBucket>
    implements
        AggregateVariant,
        ToCopyableBuilder<DateHistogramAggregate.Builder, DateHistogramAggregate> {

    // ---------------------------------------------------------------------------------------------

    private DateHistogramAggregate(Builder builder) {
        super(builder);
    }

    public static DateHistogramAggregate of(Function<DateHistogramAggregate.Builder, ObjectBuilder<DateHistogramAggregate>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregate} variant kind.
     */
    @Override
    public Aggregate.Kind _aggregateKind() {
        return Aggregate.Kind.DateHistogram;
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
     * Builder for {@link DateHistogramAggregate}.
     */
    public static class Builder extends MultiBucketAggregateBase.AbstractBuilder<DateHistogramBucket, Builder>
        implements
            CopyableBuilder<Builder, DateHistogramAggregate> {

        public Builder() {}

        private Builder(DateHistogramAggregate o) {
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
         * Builds a {@link DateHistogramAggregate}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DateHistogramAggregate build() {
            _checkSingleUse();

            return new DateHistogramAggregate(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DateHistogramAggregate}
     */
    public static final JsonpDeserializer<DateHistogramAggregate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DateHistogramAggregate::setupDateHistogramAggregateDeserializer
    );

    protected static void setupDateHistogramAggregateDeserializer(ObjectDeserializer<DateHistogramAggregate.Builder> op) {
        setupMultiBucketAggregateBaseDeserializer(op, DateHistogramBucket._DESERIALIZER);
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
