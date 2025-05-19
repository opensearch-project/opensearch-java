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

// typedef: _types.aggregations.BucketMetricValueAggregate

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class BucketMetricValueAggregate extends SingleMetricAggregateBase
    implements
        AggregateVariant,
        ToCopyableBuilder<BucketMetricValueAggregate.Builder, BucketMetricValueAggregate> {

    @Nonnull
    private final List<String> keys;

    // ---------------------------------------------------------------------------------------------

    private BucketMetricValueAggregate(Builder builder) {
        super(builder);
        this.keys = ApiTypeHelper.unmodifiableRequired(builder.keys, this, "keys");
    }

    public static BucketMetricValueAggregate of(
        Function<BucketMetricValueAggregate.Builder, ObjectBuilder<BucketMetricValueAggregate>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregate} variant kind.
     */
    @Override
    public Aggregate.Kind _aggregateKind() {
        return Aggregate.Kind.BucketMetricValue;
    }

    /**
     * Required - API name: {@code keys}
     */
    @Nonnull
    public final List<String> keys() {
        return this.keys;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("keys");
        generator.writeStartArray();
        for (String item0 : this.keys) {
            generator.write(item0);
        }
        generator.writeEnd();
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
     * Builder for {@link BucketMetricValueAggregate}.
     */
    public static class Builder extends SingleMetricAggregateBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, BucketMetricValueAggregate> {
        private List<String> keys;

        public Builder() {}

        private Builder(BucketMetricValueAggregate o) {
            super(o);
            this.keys = _listCopy(o.keys);
        }

        private Builder(Builder o) {
            super(o);
            this.keys = _listCopy(o.keys);
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
         * Required - API name: {@code keys}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>keys</code>.
         * </p>
         */
        @Nonnull
        public final Builder keys(List<String> list) {
            this.keys = _listAddAll(this.keys, list);
            return this;
        }

        /**
         * Required - API name: {@code keys}
         *
         * <p>
         * Adds one or more values to <code>keys</code>.
         * </p>
         */
        @Nonnull
        public final Builder keys(String value, String... values) {
            this.keys = _listAdd(this.keys, value, values);
            return this;
        }

        /**
         * Builds a {@link BucketMetricValueAggregate}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public BucketMetricValueAggregate build() {
            _checkSingleUse();

            return new BucketMetricValueAggregate(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link BucketMetricValueAggregate}
     */
    public static final JsonpDeserializer<BucketMetricValueAggregate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        BucketMetricValueAggregate::setupBucketMetricValueAggregateDeserializer
    );

    protected static void setupBucketMetricValueAggregateDeserializer(ObjectDeserializer<BucketMetricValueAggregate.Builder> op) {
        setupSingleMetricAggregateBaseDeserializer(op);
        op.add(Builder::keys, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "keys");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.keys.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        BucketMetricValueAggregate other = (BucketMetricValueAggregate) o;
        return this.keys.equals(other.keys);
    }
}
