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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.IpRangeAggregationRange

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IpRangeAggregationRange
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IpRangeAggregationRange.Builder, IpRangeAggregationRange> {

    @Nullable
    private final String from;

    @Nullable
    private final String mask;

    @Nullable
    private final String to;

    // ---------------------------------------------------------------------------------------------

    private IpRangeAggregationRange(Builder builder) {
        this.from = builder.from;
        this.mask = builder.mask;
        this.to = builder.to;
    }

    public static IpRangeAggregationRange of(Function<IpRangeAggregationRange.Builder, ObjectBuilder<IpRangeAggregationRange>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Start of the range.
     * <p>
     * API name: {@code from}
     * </p>
     */
    @Nullable
    public final String from() {
        return this.from;
    }

    /**
     * IP range defined as a CIDR mask.
     * <p>
     * API name: {@code mask}
     * </p>
     */
    @Nullable
    public final String mask() {
        return this.mask;
    }

    /**
     * End of the range.
     * <p>
     * API name: {@code to}
     * </p>
     */
    @Nullable
    public final String to() {
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
            generator.write(this.from);
        }

        if (this.mask != null) {
            generator.writeKey("mask");
            generator.write(this.mask);
        }

        if (this.to != null) {
            generator.writeKey("to");
            generator.write(this.to);
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
     * Builder for {@link IpRangeAggregationRange}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IpRangeAggregationRange> {
        @Nullable
        private String from;
        @Nullable
        private String mask;
        @Nullable
        private String to;

        public Builder() {}

        private Builder(IpRangeAggregationRange o) {
            this.from = o.from;
            this.mask = o.mask;
            this.to = o.to;
        }

        private Builder(Builder o) {
            this.from = o.from;
            this.mask = o.mask;
            this.to = o.to;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Start of the range.
         * <p>
         * API name: {@code from}
         * </p>
         */
        @Nonnull
        public final Builder from(@Nullable String value) {
            this.from = value;
            return this;
        }

        /**
         * IP range defined as a CIDR mask.
         * <p>
         * API name: {@code mask}
         * </p>
         */
        @Nonnull
        public final Builder mask(@Nullable String value) {
            this.mask = value;
            return this;
        }

        /**
         * End of the range.
         * <p>
         * API name: {@code to}
         * </p>
         */
        @Nonnull
        public final Builder to(@Nullable String value) {
            this.to = value;
            return this;
        }

        /**
         * Builds a {@link IpRangeAggregationRange}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IpRangeAggregationRange build() {
            _checkSingleUse();

            return new IpRangeAggregationRange(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IpRangeAggregationRange}
     */
    public static final JsonpDeserializer<IpRangeAggregationRange> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IpRangeAggregationRange::setupIpRangeAggregationRangeDeserializer
    );

    protected static void setupIpRangeAggregationRangeDeserializer(ObjectDeserializer<IpRangeAggregationRange.Builder> op) {
        op.add(Builder::from, JsonpDeserializer.stringDeserializer(), "from");
        op.add(Builder::mask, JsonpDeserializer.stringDeserializer(), "mask");
        op.add(Builder::to, JsonpDeserializer.stringDeserializer(), "to");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.from);
        result = 31 * result + Objects.hashCode(this.mask);
        result = 31 * result + Objects.hashCode(this.to);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IpRangeAggregationRange other = (IpRangeAggregationRange) o;
        return Objects.equals(this.from, other.from) && Objects.equals(this.mask, other.mask) && Objects.equals(this.to, other.to);
    }
}
