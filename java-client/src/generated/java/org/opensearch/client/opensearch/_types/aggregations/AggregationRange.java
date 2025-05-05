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
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.AggregationRange

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AggregationRange implements PlainJsonSerializable, ToCopyableBuilder<AggregationRange.Builder, AggregationRange> {

    @Nullable
    private final JsonData from;

    @Nullable
    private final String key;

    @Nullable
    private final JsonData to;

    // ---------------------------------------------------------------------------------------------

    private AggregationRange(Builder builder) {
        this.from = builder.from;
        this.key = builder.key;
        this.to = builder.to;
    }

    public static AggregationRange of(Function<AggregationRange.Builder, ObjectBuilder<AggregationRange>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Start of the range (inclusive).
     * <p>
     * API name: {@code from}
     * </p>
     */
    @Nullable
    public final JsonData from() {
        return this.from;
    }

    /**
     * Custom key to return the range with.
     * <p>
     * API name: {@code key}
     * </p>
     */
    @Nullable
    public final String key() {
        return this.key;
    }

    /**
     * End of the range (exclusive).
     * <p>
     * API name: {@code to}
     * </p>
     */
    @Nullable
    public final JsonData to() {
        return this.to;
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
        if (this.from != null) {
            generator.writeKey("from");
            this.from.serialize(generator, mapper);
        }

        if (this.key != null) {
            generator.writeKey("key");
            generator.write(this.key);
        }

        if (this.to != null) {
            generator.writeKey("to");
            this.to.serialize(generator, mapper);
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
     * Builder for {@link AggregationRange}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AggregationRange> {
        @Nullable
        private JsonData from;
        @Nullable
        private String key;
        @Nullable
        private JsonData to;

        public Builder() {}

        private Builder(AggregationRange o) {
            this.from = o.from;
            this.key = o.key;
            this.to = o.to;
        }

        private Builder(Builder o) {
            this.from = o.from;
            this.key = o.key;
            this.to = o.to;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Start of the range (inclusive).
         * <p>
         * API name: {@code from}
         * </p>
         */
        @Nonnull
        public final Builder from(@Nullable JsonData value) {
            this.from = value;
            return this;
        }

        /**
         * Custom key to return the range with.
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
         * End of the range (exclusive).
         * <p>
         * API name: {@code to}
         * </p>
         */
        @Nonnull
        public final Builder to(@Nullable JsonData value) {
            this.to = value;
            return this;
        }

        /**
         * Builds a {@link AggregationRange}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AggregationRange build() {
            _checkSingleUse();

            return new AggregationRange(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AggregationRange}
     */
    public static final JsonpDeserializer<AggregationRange> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AggregationRange::setupAggregationRangeDeserializer
    );

    protected static void setupAggregationRangeDeserializer(ObjectDeserializer<AggregationRange.Builder> op) {
        op.add(Builder::from, JsonData._DESERIALIZER, "from");
        op.add(Builder::key, JsonpDeserializer.stringDeserializer(), "key");
        op.add(Builder::to, JsonData._DESERIALIZER, "to");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.from);
        result = 31 * result + Objects.hashCode(this.key);
        result = 31 * result + Objects.hashCode(this.to);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AggregationRange other = (AggregationRange) o;
        return Objects.equals(this.from, other.from) && Objects.equals(this.key, other.key) && Objects.equals(this.to, other.to);
    }
}
