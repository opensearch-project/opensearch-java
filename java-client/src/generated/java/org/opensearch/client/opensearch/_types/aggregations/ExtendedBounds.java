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
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializer;
import org.opensearch.client.json.JsonpUtils;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.ExtendedBounds

@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ExtendedBounds<T> implements PlainJsonSerializable, ToCopyableBuilder<ExtendedBounds.Builder<T>, ExtendedBounds<T>> {

    @Nonnull
    private final T max;

    @Nonnull
    private final T min;

    @Nullable
    private final JsonpSerializer<T> tSerializer;

    // ---------------------------------------------------------------------------------------------

    private ExtendedBounds(Builder<T> builder) {
        this.max = ApiTypeHelper.requireNonNull(builder.max, this, "max");
        this.min = ApiTypeHelper.requireNonNull(builder.min, this, "min");
        this.tSerializer = builder.tSerializer;
    }

    public static <T> ExtendedBounds<T> of(Function<ExtendedBounds.Builder<T>, ObjectBuilder<ExtendedBounds<T>>> fn) {
        return fn.apply(new Builder<>()).build();
    }

    /**
     * Required - API name: {@code max}
     */
    @Nonnull
    public final T max() {
        return this.max;
    }

    /**
     * Required - API name: {@code min}
     */
    @Nonnull
    public final T min() {
        return this.min;
    }

    /**
     * Serializer for {@code T}. If not set, an attempt will be made to find a serializer from the JSON context.
     */
    @Nullable
    public final JsonpSerializer<T> tSerializer() {
        return this.tSerializer;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeKey("max");
        JsonpUtils.serialize(this.max, generator, tSerializer, mapper);

        generator.writeKey("min");
        JsonpUtils.serialize(this.min, generator, tSerializer, mapper);
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder<T> toBuilder() {
        return new Builder<>(this);
    }

    @Nonnull
    public static <T> Builder builder() {
        return new Builder<>();
    }

    /**
     * Builder for {@link ExtendedBounds}.
     */
    public static class Builder<T> extends ObjectBuilderBase implements CopyableBuilder<Builder<T>, ExtendedBounds<T>> {
        private T max;
        private T min;
        @Nullable
        private JsonpSerializer<T> tSerializer;

        public Builder() {}

        private Builder(ExtendedBounds<T> o) {
            this.max = o.max;
            this.min = o.min;
            this.tSerializer = o.tSerializer;
        }

        private Builder(Builder<T> o) {
            this.max = o.max;
            this.min = o.min;
            this.tSerializer = o.tSerializer;
        }

        @Override
        @Nonnull
        public Builder<T> copy() {
            return new Builder<>(this);
        }

        /**
         * Required - API name: {@code max}
         */
        @Nonnull
        public final Builder<T> max(T value) {
            this.max = value;
            return this;
        }

        /**
         * Required - API name: {@code min}
         */
        @Nonnull
        public final Builder<T> min(T value) {
            this.min = value;
            return this;
        }

        /**
         * Serializer for {@code T}. If not set, an attempt will be made to find a serializer from the JSON context.
         */
        @Nonnull
        public final Builder<T> tSerializer(@Nullable JsonpSerializer<T> value) {
            this.tSerializer = value;
            return this;
        }

        /**
         * Builds a {@link ExtendedBounds}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExtendedBounds<T> build() {
            _checkSingleUse();

            return new ExtendedBounds<>(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Create a JSON deserializer for ExtendedBounds.
     */
    public static <T> JsonpDeserializer<ExtendedBounds<T>> createExtendedBoundsDeserializer(JsonpDeserializer<T> tDeserializer) {
        return ObjectBuilderDeserializer.createForObject(
            Builder<T>::new,
            op -> ExtendedBounds.setupExtendedBoundsDeserializer(op, tDeserializer)
        );
    }

    protected static <T> void setupExtendedBoundsDeserializer(
        ObjectDeserializer<ExtendedBounds.Builder<T>> op,
        JsonpDeserializer<T> tDeserializer
    ) {
        op.add(Builder::max, tDeserializer, "max");
        op.add(Builder::min, tDeserializer, "min");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.max.hashCode();
        result = 31 * result + this.min.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExtendedBounds<?> other = (ExtendedBounds<?>) o;
        return this.max.equals(other.max) && this.min.equals(other.min);
    }
}
