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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.DoubleTermsBucket

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DoubleTermsBucket extends TermsBucketBase implements ToCopyableBuilder<DoubleTermsBucket.Builder, DoubleTermsBucket> {

    private final double key;

    @Nullable
    private final String keyAsString;

    // ---------------------------------------------------------------------------------------------

    private DoubleTermsBucket(Builder builder) {
        super(builder);
        this.key = ApiTypeHelper.requireNonNull(builder.key, this, "key");
        this.keyAsString = builder.keyAsString;
    }

    public static DoubleTermsBucket of(Function<DoubleTermsBucket.Builder, ObjectBuilder<DoubleTermsBucket>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code key}
     */
    public final double key() {
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
        generator.writeKey("key");
        generator.write(this.key);

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
     * Builder for {@link DoubleTermsBucket}.
     */
    public static class Builder extends TermsBucketBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, DoubleTermsBucket> {
        private Double key;
        @Nullable
        private String keyAsString;

        public Builder() {}

        private Builder(DoubleTermsBucket o) {
            super(o);
            this.key = o.key;
            this.keyAsString = o.keyAsString;
        }

        private Builder(Builder o) {
            super(o);
            this.key = o.key;
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
         * Required - API name: {@code key}
         */
        @Nonnull
        public final Builder key(double value) {
            this.key = value;
            return this;
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
         * Builds a {@link DoubleTermsBucket}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DoubleTermsBucket build() {
            _checkSingleUse();

            return new DoubleTermsBucket(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DoubleTermsBucket}
     */
    public static final JsonpDeserializer<DoubleTermsBucket> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DoubleTermsBucket::setupDoubleTermsBucketDeserializer
    );

    protected static void setupDoubleTermsBucketDeserializer(ObjectDeserializer<DoubleTermsBucket.Builder> op) {
        setupTermsBucketBaseDeserializer(op);
        op.add(Builder::key, JsonpDeserializer.doubleDeserializer(), "key");
        op.add(Builder::keyAsString, JsonpDeserializer.stringDeserializer(), "key_as_string");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Double.hashCode(this.key);
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
        DoubleTermsBucket other = (DoubleTermsBucket) o;
        return this.key == other.key && Objects.equals(this.keyAsString, other.keyAsString);
    }
}
