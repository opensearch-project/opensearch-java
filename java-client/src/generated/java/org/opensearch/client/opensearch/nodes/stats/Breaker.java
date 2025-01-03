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

package org.opensearch.client.opensearch.nodes.stats;

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

// typedef: nodes.stats.Breaker

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Breaker implements PlainJsonSerializable, ToCopyableBuilder<Breaker.Builder, Breaker> {

    @Nullable
    private final String estimatedSize;

    @Nullable
    private final Long estimatedSizeInBytes;

    @Nullable
    private final String limitSize;

    @Nullable
    private final Long limitSizeInBytes;

    @Nullable
    private final Double overhead;

    @Nullable
    private final Long tripped;

    // ---------------------------------------------------------------------------------------------

    private Breaker(Builder builder) {
        this.estimatedSize = builder.estimatedSize;
        this.estimatedSizeInBytes = builder.estimatedSizeInBytes;
        this.limitSize = builder.limitSize;
        this.limitSizeInBytes = builder.limitSizeInBytes;
        this.overhead = builder.overhead;
        this.tripped = builder.tripped;
    }

    public static Breaker of(Function<Breaker.Builder, ObjectBuilder<Breaker>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Estimated memory used for the operation.
     * <p>
     * API name: {@code estimated_size}
     * </p>
     */
    @Nullable
    public final String estimatedSize() {
        return this.estimatedSize;
    }

    /**
     * Estimated memory used, in bytes, for the operation.
     * <p>
     * API name: {@code estimated_size_in_bytes}
     * </p>
     */
    @Nullable
    public final Long estimatedSizeInBytes() {
        return this.estimatedSizeInBytes;
    }

    /**
     * Memory limit for the circuit breaker.
     * <p>
     * API name: {@code limit_size}
     * </p>
     */
    @Nullable
    public final String limitSize() {
        return this.limitSize;
    }

    /**
     * Memory limit, in bytes, for the circuit breaker.
     * <p>
     * API name: {@code limit_size_in_bytes}
     * </p>
     */
    @Nullable
    public final Long limitSizeInBytes() {
        return this.limitSizeInBytes;
    }

    /**
     * A constant that all estimates for the circuit breaker are multiplied with to calculate a final estimate.
     * <p>
     * API name: {@code overhead}
     * </p>
     */
    @Nullable
    public final Double overhead() {
        return this.overhead;
    }

    /**
     * Total number of times the circuit breaker has been triggered and prevented an out of memory error.
     * <p>
     * API name: {@code tripped}
     * </p>
     */
    @Nullable
    public final Long tripped() {
        return this.tripped;
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
        if (this.estimatedSize != null) {
            generator.writeKey("estimated_size");
            generator.write(this.estimatedSize);
        }

        if (this.estimatedSizeInBytes != null) {
            generator.writeKey("estimated_size_in_bytes");
            generator.write(this.estimatedSizeInBytes);
        }

        if (this.limitSize != null) {
            generator.writeKey("limit_size");
            generator.write(this.limitSize);
        }

        if (this.limitSizeInBytes != null) {
            generator.writeKey("limit_size_in_bytes");
            generator.write(this.limitSizeInBytes);
        }

        if (this.overhead != null) {
            generator.writeKey("overhead");
            generator.write(this.overhead);
        }

        if (this.tripped != null) {
            generator.writeKey("tripped");
            generator.write(this.tripped);
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
     * Builder for {@link Breaker}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Breaker> {
        @Nullable
        private String estimatedSize;
        @Nullable
        private Long estimatedSizeInBytes;
        @Nullable
        private String limitSize;
        @Nullable
        private Long limitSizeInBytes;
        @Nullable
        private Double overhead;
        @Nullable
        private Long tripped;

        public Builder() {}

        private Builder(Breaker o) {
            this.estimatedSize = o.estimatedSize;
            this.estimatedSizeInBytes = o.estimatedSizeInBytes;
            this.limitSize = o.limitSize;
            this.limitSizeInBytes = o.limitSizeInBytes;
            this.overhead = o.overhead;
            this.tripped = o.tripped;
        }

        private Builder(Builder o) {
            this.estimatedSize = o.estimatedSize;
            this.estimatedSizeInBytes = o.estimatedSizeInBytes;
            this.limitSize = o.limitSize;
            this.limitSizeInBytes = o.limitSizeInBytes;
            this.overhead = o.overhead;
            this.tripped = o.tripped;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Estimated memory used for the operation.
         * <p>
         * API name: {@code estimated_size}
         * </p>
         */
        @Nonnull
        public final Builder estimatedSize(@Nullable String value) {
            this.estimatedSize = value;
            return this;
        }

        /**
         * Estimated memory used, in bytes, for the operation.
         * <p>
         * API name: {@code estimated_size_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder estimatedSizeInBytes(@Nullable Long value) {
            this.estimatedSizeInBytes = value;
            return this;
        }

        /**
         * Memory limit for the circuit breaker.
         * <p>
         * API name: {@code limit_size}
         * </p>
         */
        @Nonnull
        public final Builder limitSize(@Nullable String value) {
            this.limitSize = value;
            return this;
        }

        /**
         * Memory limit, in bytes, for the circuit breaker.
         * <p>
         * API name: {@code limit_size_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder limitSizeInBytes(@Nullable Long value) {
            this.limitSizeInBytes = value;
            return this;
        }

        /**
         * A constant that all estimates for the circuit breaker are multiplied with to calculate a final estimate.
         * <p>
         * API name: {@code overhead}
         * </p>
         */
        @Nonnull
        public final Builder overhead(@Nullable Double value) {
            this.overhead = value;
            return this;
        }

        /**
         * Total number of times the circuit breaker has been triggered and prevented an out of memory error.
         * <p>
         * API name: {@code tripped}
         * </p>
         */
        @Nonnull
        public final Builder tripped(@Nullable Long value) {
            this.tripped = value;
            return this;
        }

        /**
         * Builds a {@link Breaker}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Breaker build() {
            _checkSingleUse();

            return new Breaker(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Breaker}
     */
    public static final JsonpDeserializer<Breaker> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Breaker::setupBreakerDeserializer
    );

    protected static void setupBreakerDeserializer(ObjectDeserializer<Breaker.Builder> op) {
        op.add(Builder::estimatedSize, JsonpDeserializer.stringDeserializer(), "estimated_size");
        op.add(Builder::estimatedSizeInBytes, JsonpDeserializer.longDeserializer(), "estimated_size_in_bytes");
        op.add(Builder::limitSize, JsonpDeserializer.stringDeserializer(), "limit_size");
        op.add(Builder::limitSizeInBytes, JsonpDeserializer.longDeserializer(), "limit_size_in_bytes");
        op.add(Builder::overhead, JsonpDeserializer.doubleDeserializer(), "overhead");
        op.add(Builder::tripped, JsonpDeserializer.longDeserializer(), "tripped");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.estimatedSize);
        result = 31 * result + Objects.hashCode(this.estimatedSizeInBytes);
        result = 31 * result + Objects.hashCode(this.limitSize);
        result = 31 * result + Objects.hashCode(this.limitSizeInBytes);
        result = 31 * result + Objects.hashCode(this.overhead);
        result = 31 * result + Objects.hashCode(this.tripped);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Breaker other = (Breaker) o;
        return Objects.equals(this.estimatedSize, other.estimatedSize)
            && Objects.equals(this.estimatedSizeInBytes, other.estimatedSizeInBytes)
            && Objects.equals(this.limitSize, other.limitSize)
            && Objects.equals(this.limitSizeInBytes, other.limitSizeInBytes)
            && Objects.equals(this.overhead, other.overhead)
            && Objects.equals(this.tripped, other.tripped);
    }
}
