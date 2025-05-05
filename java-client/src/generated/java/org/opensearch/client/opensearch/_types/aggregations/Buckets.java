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
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.JsonpSerializer;
import org.opensearch.client.json.JsonpUtils;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.json.UnionDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

// typedef: _types.aggregations.Buckets

/**
 * Aggregation buckets. By default they are returned as an array, but if the aggregation has keys configured for the different buckets, the
 * result is a dictionary.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Buckets<TBucket> implements TaggedUnion<Buckets.Kind, Object>, PlainJsonSerializable {
    /**
     * {@link Buckets} variant kinds.
     */
    public enum Kind {
        Array,
        Keyed
    }

    private final Kind _kind;
    private final Object _value;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final Object _get() {
        return _value;
    }

    @Nullable
    private final JsonpSerializer<TBucket> tBucketSerializer;

    private Buckets(Kind kind, Object value) {
        this._kind = kind;
        this._value = value;
        this.tBucketSerializer = null;
    }

    private Buckets(Builder<TBucket> builder) {
        this.tBucketSerializer = builder.tBucketSerializer;
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static <TBucket> Buckets<TBucket> of(Function<Buckets.Builder<TBucket>, ObjectBuilder<Buckets<TBucket>>> fn) {
        return fn.apply(new Builder<>()).build();
    }

    /**
     * Serializer for {@code TBucket}. If not set, an attempt will be made to find a serializer from the JSON context.
     */
    @Nullable
    public final JsonpSerializer<TBucket> tBucketSerializer() {
        return this.tBucketSerializer;
    }

    /**
     * Is this variant instance of kind {@code array}?
     */
    public boolean isArray() {
        return _kind == Kind.Array;
    }

    /**
     * Get the {@code array} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code array} kind.
     */
    public List<TBucket> array() {
        return TaggedUnionUtils.get(this, Kind.Array);
    }

    /**
     * Is this variant instance of kind {@code keyed}?
     */
    public boolean isKeyed() {
        return _kind == Kind.Keyed;
    }

    /**
     * Get the {@code keyed} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code keyed} kind.
     */
    public Map<String, TBucket> keyed() {
        return TaggedUnionUtils.get(this, Kind.Keyed);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        } else {
            switch (_kind) {
                case Array:
                    generator.writeStartArray();
                    for (TBucket item0 : ((List<TBucket>) this._value)) {
                        JsonpUtils.serialize(item0, generator, tBucketSerializer, mapper);
                    }
                    generator.writeEnd();
                    break;
                case Keyed:
                    generator.writeStartObject();
                    for (Map.Entry<String, TBucket> item0 : ((Map<String, TBucket>) this._value).entrySet()) {
                        generator.writeKey(item0.getKey());
                        JsonpUtils.serialize(item0.getValue(), generator, tBucketSerializer, mapper);
                    }
                    generator.writeEnd();
                    break;
            }
        }
    }

    @Nonnull
    public Builder<TBucket> toBuilder() {
        return new Builder<>(this);
    }

    @Nonnull
    public static <TBucket> Builder builder() {
        return new Builder<>();
    }

    public static class Builder<TBucket> extends ObjectBuilderBase {
        private Kind _kind;
        private Object _value;
        @Nullable
        private JsonpSerializer<TBucket> tBucketSerializer;

        public Builder() {}

        private Builder(Buckets<TBucket> o) {
            this.tBucketSerializer = o.tBucketSerializer;
            this._kind = o._kind;
            this._value = o._value;
        }

        /**
         * Serializer for {@code TBucket}. If not set, an attempt will be made to find a serializer from the JSON context.
         */
        @Nonnull
        public final Builder<TBucket> tBucketSerializer(@Nullable JsonpSerializer<TBucket> value) {
            this.tBucketSerializer = value;
            return this;
        }

        public ContainerBuilder array(List<TBucket> v) {
            this._kind = Kind.Array;
            this._value = v;
            return new ContainerBuilder();
        }

        public ContainerBuilder keyed(Map<String, TBucket> v) {
            this._kind = Kind.Keyed;
            this._value = v;
            return new ContainerBuilder();
        }

        protected Buckets<TBucket> build() {
            _checkSingleUse();
            return new Buckets<>(this);
        }

        public class ContainerBuilder implements ObjectBuilder<Buckets<TBucket>> {
            private ContainerBuilder() {}

            /**
             * Serializer for {@code TBucket}. If not set, an attempt will be made to find a serializer from the JSON context.
             */
            @Nonnull
            public final ContainerBuilder tBucketSerializer(@Nullable JsonpSerializer<TBucket> value) {
                Builder.this.tBucketSerializer = value;
                return this;
            }

            @Override
            public Buckets<TBucket> build() {
                return Builder.this.build();
            }
        }
    }

    public static <TBucket> JsonpDeserializer<Buckets<TBucket>> createBucketsDeserializer(JsonpDeserializer<TBucket> tBucketDeserializer) {
        return new UnionDeserializer.Builder<Buckets<TBucket>, Kind, Object>(Buckets<TBucket>::new, false).addMember(
            Kind.Array,
            JsonpDeserializer.arrayDeserializer(tBucketDeserializer)
        ).addMember(Kind.Keyed, JsonpDeserializer.stringMapDeserializer(tBucketDeserializer)).build();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this._kind);
        result = 31 * result + Objects.hashCode(this._value);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Buckets<?> other = (Buckets<?>) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
