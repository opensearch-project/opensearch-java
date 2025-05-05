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

// typedef: _types.aggregations.VariableWidthHistogramBucket

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class VariableWidthHistogramBucket extends MultiBucketBase
    implements
        ToCopyableBuilder<VariableWidthHistogramBucket.Builder, VariableWidthHistogramBucket> {

    private final double key;

    @Nullable
    private final String keyAsString;

    private final double max;

    @Nullable
    private final String maxAsString;

    private final double min;

    @Nullable
    private final String minAsString;

    // ---------------------------------------------------------------------------------------------

    private VariableWidthHistogramBucket(Builder builder) {
        super(builder);
        this.key = ApiTypeHelper.requireNonNull(builder.key, this, "key");
        this.keyAsString = builder.keyAsString;
        this.max = ApiTypeHelper.requireNonNull(builder.max, this, "max");
        this.maxAsString = builder.maxAsString;
        this.min = ApiTypeHelper.requireNonNull(builder.min, this, "min");
        this.minAsString = builder.minAsString;
    }

    public static VariableWidthHistogramBucket of(
        Function<VariableWidthHistogramBucket.Builder, ObjectBuilder<VariableWidthHistogramBucket>> fn
    ) {
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

    /**
     * Required - API name: {@code max}
     */
    public final double max() {
        return this.max;
    }

    /**
     * API name: {@code max_as_string}
     */
    @Nullable
    public final String maxAsString() {
        return this.maxAsString;
    }

    /**
     * Required - API name: {@code min}
     */
    public final double min() {
        return this.min;
    }

    /**
     * API name: {@code min_as_string}
     */
    @Nullable
    public final String minAsString() {
        return this.minAsString;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("key");
        generator.write(this.key);

        if (this.keyAsString != null) {
            generator.writeKey("key_as_string");
            generator.write(this.keyAsString);
        }

        generator.writeKey("max");
        generator.write(this.max);

        if (this.maxAsString != null) {
            generator.writeKey("max_as_string");
            generator.write(this.maxAsString);
        }

        generator.writeKey("min");
        generator.write(this.min);

        if (this.minAsString != null) {
            generator.writeKey("min_as_string");
            generator.write(this.minAsString);
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
     * Builder for {@link VariableWidthHistogramBucket}.
     */
    public static class Builder extends MultiBucketBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, VariableWidthHistogramBucket> {
        private Double key;
        @Nullable
        private String keyAsString;
        private Double max;
        @Nullable
        private String maxAsString;
        private Double min;
        @Nullable
        private String minAsString;

        public Builder() {}

        private Builder(VariableWidthHistogramBucket o) {
            super(o);
            this.key = o.key;
            this.keyAsString = o.keyAsString;
            this.max = o.max;
            this.maxAsString = o.maxAsString;
            this.min = o.min;
            this.minAsString = o.minAsString;
        }

        private Builder(Builder o) {
            super(o);
            this.key = o.key;
            this.keyAsString = o.keyAsString;
            this.max = o.max;
            this.maxAsString = o.maxAsString;
            this.min = o.min;
            this.minAsString = o.minAsString;
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
         * Required - API name: {@code max}
         */
        @Nonnull
        public final Builder max(double value) {
            this.max = value;
            return this;
        }

        /**
         * API name: {@code max_as_string}
         */
        @Nonnull
        public final Builder maxAsString(@Nullable String value) {
            this.maxAsString = value;
            return this;
        }

        /**
         * Required - API name: {@code min}
         */
        @Nonnull
        public final Builder min(double value) {
            this.min = value;
            return this;
        }

        /**
         * API name: {@code min_as_string}
         */
        @Nonnull
        public final Builder minAsString(@Nullable String value) {
            this.minAsString = value;
            return this;
        }

        /**
         * Builds a {@link VariableWidthHistogramBucket}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public VariableWidthHistogramBucket build() {
            _checkSingleUse();

            return new VariableWidthHistogramBucket(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link VariableWidthHistogramBucket}
     */
    public static final JsonpDeserializer<VariableWidthHistogramBucket> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        VariableWidthHistogramBucket::setupVariableWidthHistogramBucketDeserializer
    );

    protected static void setupVariableWidthHistogramBucketDeserializer(ObjectDeserializer<VariableWidthHistogramBucket.Builder> op) {
        setupMultiBucketBaseDeserializer(op);
        op.add(Builder::key, JsonpDeserializer.doubleDeserializer(), "key");
        op.add(Builder::keyAsString, JsonpDeserializer.stringDeserializer(), "key_as_string");
        op.add(Builder::max, JsonpDeserializer.doubleDeserializer(), "max");
        op.add(Builder::maxAsString, JsonpDeserializer.stringDeserializer(), "max_as_string");
        op.add(Builder::min, JsonpDeserializer.doubleDeserializer(), "min");
        op.add(Builder::minAsString, JsonpDeserializer.stringDeserializer(), "min_as_string");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Double.hashCode(this.key);
        result = 31 * result + Objects.hashCode(this.keyAsString);
        result = 31 * result + Double.hashCode(this.max);
        result = 31 * result + Objects.hashCode(this.maxAsString);
        result = 31 * result + Double.hashCode(this.min);
        result = 31 * result + Objects.hashCode(this.minAsString);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        VariableWidthHistogramBucket other = (VariableWidthHistogramBucket) o;
        return this.key == other.key
            && Objects.equals(this.keyAsString, other.keyAsString)
            && this.max == other.max
            && Objects.equals(this.maxAsString, other.maxAsString)
            && this.min == other.min
            && Objects.equals(this.minAsString, other.minAsString);
    }
}
