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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: _types.aggregations.CompositeBucket

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CompositeBucket extends MultiBucketBase implements ToCopyableBuilder<CompositeBucket.Builder, CompositeBucket> {

    @Nonnull
    private final Map<String, FieldValue> key;

    // ---------------------------------------------------------------------------------------------

    private CompositeBucket(Builder builder) {
        super(builder);
        this.key = ApiTypeHelper.unmodifiableRequired(builder.key, this, "key");
    }

    public static CompositeBucket of(Function<CompositeBucket.Builder, ObjectBuilder<CompositeBucket>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code key}
     */
    @Nonnull
    public final Map<String, FieldValue> key() {
        return this.key;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("key");
        generator.writeStartObject();
        for (Map.Entry<String, FieldValue> item0 : this.key.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
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
     * Builder for {@link CompositeBucket}.
     */
    public static class Builder extends MultiBucketBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, CompositeBucket> {
        private Map<String, FieldValue> key;

        public Builder() {}

        private Builder(CompositeBucket o) {
            super(o);
            this.key = _mapCopy(o.key);
        }

        private Builder(Builder o) {
            super(o);
            this.key = _mapCopy(o.key);
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
         * Required - API name: {@code key}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>key</code>.
         * </p>
         */
        @Nonnull
        public final Builder key(Map<String, FieldValue> map) {
            this.key = _mapPutAll(this.key, map);
            return this;
        }

        /**
         * Required - API name: {@code key}
         *
         * <p>
         * Adds an entry to <code>key</code>.
         * </p>
         */
        @Nonnull
        public final Builder key(String key, FieldValue value) {
            this.key = _mapPut(this.key, key, value);
            return this;
        }

        /**
         * Required - API name: {@code key}
         *
         * <p>
         * Adds a value to <code>key</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder key(String key, Function<FieldValue.Builder, ObjectBuilder<FieldValue>> fn) {
            return key(key, fn.apply(new FieldValue.Builder()).build());
        }

        /**
         * Builds a {@link CompositeBucket}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CompositeBucket build() {
            _checkSingleUse();

            return new CompositeBucket(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CompositeBucket}
     */
    public static final JsonpDeserializer<CompositeBucket> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CompositeBucket::setupCompositeBucketDeserializer
    );

    protected static void setupCompositeBucketDeserializer(ObjectDeserializer<CompositeBucket.Builder> op) {
        setupMultiBucketBaseDeserializer(op);
        op.add(Builder::key, JsonpDeserializer.stringMapDeserializer(FieldValue._DESERIALIZER), "key");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.key.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CompositeBucket other = (CompositeBucket) o;
        return this.key.equals(other.key);
    }
}
