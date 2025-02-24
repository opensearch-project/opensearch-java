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
import java.util.Map;
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
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.CompositeAggregate

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CompositeAggregate extends MultiBucketAggregateBase<CompositeBucket>
    implements
        AggregateVariant,
        ToCopyableBuilder<CompositeAggregate.Builder, CompositeAggregate> {

    @Nonnull
    private final Map<String, FieldValue> afterKey;

    // ---------------------------------------------------------------------------------------------

    private CompositeAggregate(Builder builder) {
        super(builder);
        this.afterKey = ApiTypeHelper.unmodifiable(builder.afterKey);
    }

    public static CompositeAggregate of(Function<CompositeAggregate.Builder, ObjectBuilder<CompositeAggregate>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregate} variant kind.
     */
    @Override
    public Aggregate.Kind _aggregateKind() {
        return Aggregate.Kind.Composite;
    }

    /**
     * API name: {@code after_key}
     */
    @Nonnull
    public final Map<String, FieldValue> afterKey() {
        return this.afterKey;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (ApiTypeHelper.isDefined(this.afterKey)) {
            generator.writeKey("after_key");
            generator.writeStartObject();
            for (Map.Entry<String, FieldValue> item0 : this.afterKey.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link CompositeAggregate}.
     */
    public static class Builder extends MultiBucketAggregateBase.AbstractBuilder<CompositeBucket, Builder>
        implements
            CopyableBuilder<Builder, CompositeAggregate> {
        @Nullable
        private Map<String, FieldValue> afterKey;

        public Builder() {}

        private Builder(CompositeAggregate o) {
            super(o);
            this.afterKey = _mapCopy(o.afterKey);
        }

        private Builder(Builder o) {
            super(o);
            this.afterKey = _mapCopy(o.afterKey);
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
         * API name: {@code after_key}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>afterKey</code>.
         * </p>
         */
        @Nonnull
        public final Builder afterKey(Map<String, FieldValue> map) {
            this.afterKey = _mapPutAll(this.afterKey, map);
            return this;
        }

        /**
         * API name: {@code after_key}
         *
         * <p>
         * Adds an entry to <code>afterKey</code>.
         * </p>
         */
        @Nonnull
        public final Builder afterKey(String key, FieldValue value) {
            this.afterKey = _mapPut(this.afterKey, key, value);
            return this;
        }

        /**
         * API name: {@code after_key}
         *
         * <p>
         * Adds a value to <code>afterKey</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder afterKey(String key, Function<FieldValue.Builder, ObjectBuilder<FieldValue>> fn) {
            return afterKey(key, fn.apply(new FieldValue.Builder()).build());
        }

        /**
         * Builds a {@link CompositeAggregate}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CompositeAggregate build() {
            _checkSingleUse();

            return new CompositeAggregate(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CompositeAggregate}
     */
    public static final JsonpDeserializer<CompositeAggregate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CompositeAggregate::setupCompositeAggregateDeserializer
    );

    protected static void setupCompositeAggregateDeserializer(ObjectDeserializer<CompositeAggregate.Builder> op) {
        setupMultiBucketAggregateBaseDeserializer(op, CompositeBucket._DESERIALIZER);
        op.add(Builder::afterKey, JsonpDeserializer.stringMapDeserializer(FieldValue._DESERIALIZER), "after_key");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.afterKey);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CompositeAggregate other = (CompositeAggregate) o;
        return Objects.equals(this.afterKey, other.afterKey);
    }
}
