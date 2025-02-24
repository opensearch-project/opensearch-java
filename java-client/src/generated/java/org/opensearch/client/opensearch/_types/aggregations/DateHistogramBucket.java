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

// typedef: _types.aggregations.DateHistogramBucket

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DateHistogramBucket extends MultiBucketBase implements ToCopyableBuilder<DateHistogramBucket.Builder, DateHistogramBucket> {

    private final long key;

    @Nullable
    private final String keyAsString;

    // ---------------------------------------------------------------------------------------------

    private DateHistogramBucket(Builder builder) {
        super(builder);
        this.key = ApiTypeHelper.requireNonNull(builder.key, this, "key");
        this.keyAsString = builder.keyAsString;
    }

    public static DateHistogramBucket of(Function<DateHistogramBucket.Builder, ObjectBuilder<DateHistogramBucket>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code key}
     */
    public final long key() {
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
     * Builder for {@link DateHistogramBucket}.
     */
    public static class Builder extends MultiBucketBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, DateHistogramBucket> {
        private Long key;
        @Nullable
        private String keyAsString;

        public Builder() {}

        private Builder(DateHistogramBucket o) {
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
        public final Builder key(long value) {
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
         * Builds a {@link DateHistogramBucket}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DateHistogramBucket build() {
            _checkSingleUse();

            return new DateHistogramBucket(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DateHistogramBucket}
     */
    public static final JsonpDeserializer<DateHistogramBucket> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DateHistogramBucket::setupDateHistogramBucketDeserializer
    );

    protected static void setupDateHistogramBucketDeserializer(ObjectDeserializer<DateHistogramBucket.Builder> op) {
        setupMultiBucketBaseDeserializer(op);
        op.add(Builder::key, JsonpDeserializer.longDeserializer(), "key");
        op.add(Builder::keyAsString, JsonpDeserializer.stringDeserializer(), "key_as_string");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Long.hashCode(this.key);
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
        DateHistogramBucket other = (DateHistogramBucket) o;
        return this.key == other.key && Objects.equals(this.keyAsString, other.keyAsString);
    }
}
