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

// typedef: _types.aggregations.MultiTermsBucket

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MultiTermsBucket extends MultiBucketBase implements ToCopyableBuilder<MultiTermsBucket.Builder, MultiTermsBucket> {

    @Nullable
    private final Long docCountErrorUpperBound;

    @Nonnull
    private final List<FieldValue> key;

    @Nullable
    private final String keyAsString;

    // ---------------------------------------------------------------------------------------------

    private MultiTermsBucket(Builder builder) {
        super(builder);
        this.docCountErrorUpperBound = builder.docCountErrorUpperBound;
        this.key = ApiTypeHelper.unmodifiableRequired(builder.key, this, "key");
        this.keyAsString = builder.keyAsString;
    }

    public static MultiTermsBucket of(Function<MultiTermsBucket.Builder, ObjectBuilder<MultiTermsBucket>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code doc_count_error_upper_bound}
     */
    @Nullable
    public final Long docCountErrorUpperBound() {
        return this.docCountErrorUpperBound;
    }

    /**
     * Required - API name: {@code key}
     */
    @Nonnull
    public final List<FieldValue> key() {
        return this.key;
    }

    /**
     * API name: {@code key_as_string}
     */
    @Nullable
    public final String keyAsString() {
        return this.keyAsString;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.docCountErrorUpperBound != null) {
            generator.writeKey("doc_count_error_upper_bound");
            generator.write(this.docCountErrorUpperBound);
        }

        generator.writeKey("key");
        generator.writeStartArray();
        for (FieldValue item0 : this.key) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        if (this.keyAsString != null) {
            generator.writeKey("key_as_string");
            generator.write(this.keyAsString);
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
     * Builder for {@link MultiTermsBucket}.
     */
    public static class Builder extends MultiBucketBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, MultiTermsBucket> {
        @Nullable
        private Long docCountErrorUpperBound;
        private List<FieldValue> key;
        @Nullable
        private String keyAsString;

        public Builder() {}

        private Builder(MultiTermsBucket o) {
            super(o);
            this.docCountErrorUpperBound = o.docCountErrorUpperBound;
            this.key = _listCopy(o.key);
            this.keyAsString = o.keyAsString;
        }

        private Builder(Builder o) {
            super(o);
            this.docCountErrorUpperBound = o.docCountErrorUpperBound;
            this.key = _listCopy(o.key);
            this.keyAsString = o.keyAsString;
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
         * API name: {@code doc_count_error_upper_bound}
         */
        @Nonnull
        public final Builder docCountErrorUpperBound(@Nullable Long value) {
            this.docCountErrorUpperBound = value;
            return this;
        }

        /**
         * Required - API name: {@code key}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>key</code>.
         * </p>
         */
        @Nonnull
        public final Builder key(List<FieldValue> list) {
            this.key = _listAddAll(this.key, list);
            return this;
        }

        /**
         * Required - API name: {@code key}
         *
         * <p>
         * Adds one or more values to <code>key</code>.
         * </p>
         */
        @Nonnull
        public final Builder key(FieldValue value, FieldValue... values) {
            this.key = _listAdd(this.key, value, values);
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
        public final Builder key(Function<FieldValue.Builder, ObjectBuilder<FieldValue>> fn) {
            return key(fn.apply(new FieldValue.Builder()).build());
        }

        /**
         * API name: {@code key_as_string}
         */
        @Nonnull
        public final Builder keyAsString(@Nullable String value) {
            this.keyAsString = value;
            return this;
        }

        /**
         * Builds a {@link MultiTermsBucket}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MultiTermsBucket build() {
            _checkSingleUse();

            return new MultiTermsBucket(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MultiTermsBucket}
     */
    public static final JsonpDeserializer<MultiTermsBucket> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MultiTermsBucket::setupMultiTermsBucketDeserializer
    );

    protected static void setupMultiTermsBucketDeserializer(ObjectDeserializer<MultiTermsBucket.Builder> op) {
        setupMultiBucketBaseDeserializer(op);
        op.add(Builder::docCountErrorUpperBound, JsonpDeserializer.longDeserializer(), "doc_count_error_upper_bound");
        op.add(Builder::key, JsonpDeserializer.arrayDeserializer(FieldValue._DESERIALIZER), "key");
        op.add(Builder::keyAsString, JsonpDeserializer.stringDeserializer(), "key_as_string");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.docCountErrorUpperBound);
        result = 31 * result + this.key.hashCode();
        result = 31 * result + Objects.hashCode(this.keyAsString);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MultiTermsBucket other = (MultiTermsBucket) o;
        return Objects.equals(this.docCountErrorUpperBound, other.docCountErrorUpperBound)
            && this.key.equals(other.key)
            && Objects.equals(this.keyAsString, other.keyAsString);
    }
}
