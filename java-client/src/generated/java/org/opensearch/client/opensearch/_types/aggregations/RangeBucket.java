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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.RangeBucket

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RangeBucket extends MultiBucketBase implements ToCopyableBuilder<RangeBucket.Builder, RangeBucket> {

    @Nullable
    private final Double from;

    @Nullable
    private final String fromAsString;

    @Nullable
    private final String key;

    @Nullable
    private final Double to;

    @Nullable
    private final String toAsString;

    // ---------------------------------------------------------------------------------------------

    private RangeBucket(Builder builder) {
        super(builder);
        this.from = builder.from;
        this.fromAsString = builder.fromAsString;
        this.key = builder.key;
        this.to = builder.to;
        this.toAsString = builder.toAsString;
    }

    public static RangeBucket of(Function<RangeBucket.Builder, ObjectBuilder<RangeBucket>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code from}
     */
    @Nullable
    public final Double from() {
        return this.from;
    }

    /**
     * API name: {@code from_as_string}
     */
    @Nullable
    public final String fromAsString() {
        return this.fromAsString;
    }

    /**
     * The bucket key. Present if the aggregation is not keyed.
     * <p>
     * API name: {@code key}
     * </p>
     */
    @Nullable
    public final String key() {
        return this.key;
    }

    /**
     * API name: {@code to}
     */
    @Nullable
    public final Double to() {
        return this.to;
    }

    /**
     * API name: {@code to_as_string}
     */
    @Nullable
    public final String toAsString() {
        return this.toAsString;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.from != null) {
            generator.writeKey("from");
            generator.write(this.from);
        }

        if (this.fromAsString != null) {
            generator.writeKey("from_as_string");
            generator.write(this.fromAsString);
        }

        if (this.key != null) {
            generator.writeKey("key");
            generator.write(this.key);
        }

        if (this.to != null) {
            generator.writeKey("to");
            generator.write(this.to);
        }

        if (this.toAsString != null) {
            generator.writeKey("to_as_string");
            generator.write(this.toAsString);
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
     * Builder for {@link RangeBucket}.
     */
    public static class Builder extends MultiBucketBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, RangeBucket> {
        @Nullable
        private Double from;
        @Nullable
        private String fromAsString;
        @Nullable
        private String key;
        @Nullable
        private Double to;
        @Nullable
        private String toAsString;

        public Builder() {}

        private Builder(RangeBucket o) {
            super(o);
            this.from = o.from;
            this.fromAsString = o.fromAsString;
            this.key = o.key;
            this.to = o.to;
            this.toAsString = o.toAsString;
        }

        private Builder(Builder o) {
            super(o);
            this.from = o.from;
            this.fromAsString = o.fromAsString;
            this.key = o.key;
            this.to = o.to;
            this.toAsString = o.toAsString;
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
         * API name: {@code from}
         */
        @Nonnull
        public final Builder from(@Nullable Double value) {
            this.from = value;
            return this;
        }

        /**
         * API name: {@code from_as_string}
         */
        @Nonnull
        public final Builder fromAsString(@Nullable String value) {
            this.fromAsString = value;
            return this;
        }

        /**
         * The bucket key. Present if the aggregation is not keyed.
         * <p>
         * API name: {@code key}
         * </p>
         */
        @Nonnull
        public final Builder key(@Nullable String value) {
            this.key = value;
            return this;
        }

        /**
         * API name: {@code to}
         */
        @Nonnull
        public final Builder to(@Nullable Double value) {
            this.to = value;
            return this;
        }

        /**
         * API name: {@code to_as_string}
         */
        @Nonnull
        public final Builder toAsString(@Nullable String value) {
            this.toAsString = value;
            return this;
        }

        /**
         * Builds a {@link RangeBucket}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RangeBucket build() {
            _checkSingleUse();

            return new RangeBucket(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RangeBucket}
     */
    public static final JsonpDeserializer<RangeBucket> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RangeBucket::setupRangeBucketDeserializer
    );

    protected static void setupRangeBucketDeserializer(ObjectDeserializer<RangeBucket.Builder> op) {
        setupMultiBucketBaseDeserializer(op);
        op.add(Builder::from, JsonpDeserializer.doubleDeserializer(), "from");
        op.add(Builder::fromAsString, JsonpDeserializer.stringDeserializer(), "from_as_string");
        op.add(Builder::key, JsonpDeserializer.stringDeserializer(), "key");
        op.add(Builder::to, JsonpDeserializer.doubleDeserializer(), "to");
        op.add(Builder::toAsString, JsonpDeserializer.stringDeserializer(), "to_as_string");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.from);
        result = 31 * result + Objects.hashCode(this.fromAsString);
        result = 31 * result + Objects.hashCode(this.key);
        result = 31 * result + Objects.hashCode(this.to);
        result = 31 * result + Objects.hashCode(this.toAsString);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RangeBucket other = (RangeBucket) o;
        return Objects.equals(this.from, other.from)
            && Objects.equals(this.fromAsString, other.fromAsString)
            && Objects.equals(this.key, other.key)
            && Objects.equals(this.to, other.to)
            && Objects.equals(this.toAsString, other.toAsString);
    }
}
