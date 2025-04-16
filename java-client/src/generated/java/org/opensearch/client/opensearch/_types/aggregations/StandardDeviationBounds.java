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

// typedef: _types.aggregations.StandardDeviationBounds

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class StandardDeviationBounds
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<StandardDeviationBounds.Builder, StandardDeviationBounds> {

    @Nullable
    private final Double lower;

    @Nullable
    private final Double lowerPopulation;

    @Nullable
    private final Double lowerSampling;

    @Nullable
    private final Double upper;

    @Nullable
    private final Double upperPopulation;

    @Nullable
    private final Double upperSampling;

    // ---------------------------------------------------------------------------------------------

    private StandardDeviationBounds(Builder builder) {
        this.lower = builder.lower;
        this.lowerPopulation = builder.lowerPopulation;
        this.lowerSampling = builder.lowerSampling;
        this.upper = builder.upper;
        this.upperPopulation = builder.upperPopulation;
        this.upperSampling = builder.upperSampling;
    }

    public static StandardDeviationBounds of(Function<StandardDeviationBounds.Builder, ObjectBuilder<StandardDeviationBounds>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code lower}
     */
    @Nullable
    public final Double lower() {
        return this.lower;
    }

    /**
     * API name: {@code lower_population}
     */
    @Nullable
    public final Double lowerPopulation() {
        return this.lowerPopulation;
    }

    /**
     * API name: {@code lower_sampling}
     */
    @Nullable
    public final Double lowerSampling() {
        return this.lowerSampling;
    }

    /**
     * API name: {@code upper}
     */
    @Nullable
    public final Double upper() {
        return this.upper;
    }

    /**
     * API name: {@code upper_population}
     */
    @Nullable
    public final Double upperPopulation() {
        return this.upperPopulation;
    }

    /**
     * API name: {@code upper_sampling}
     */
    @Nullable
    public final Double upperSampling() {
        return this.upperSampling;
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
        if (this.lower != null) {
            generator.writeKey("lower");
            generator.write(this.lower);
        }

        if (this.lowerPopulation != null) {
            generator.writeKey("lower_population");
            generator.write(this.lowerPopulation);
        }

        if (this.lowerSampling != null) {
            generator.writeKey("lower_sampling");
            generator.write(this.lowerSampling);
        }

        if (this.upper != null) {
            generator.writeKey("upper");
            generator.write(this.upper);
        }

        if (this.upperPopulation != null) {
            generator.writeKey("upper_population");
            generator.write(this.upperPopulation);
        }

        if (this.upperSampling != null) {
            generator.writeKey("upper_sampling");
            generator.write(this.upperSampling);
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
     * Builder for {@link StandardDeviationBounds}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, StandardDeviationBounds> {
        @Nullable
        private Double lower;
        @Nullable
        private Double lowerPopulation;
        @Nullable
        private Double lowerSampling;
        @Nullable
        private Double upper;
        @Nullable
        private Double upperPopulation;
        @Nullable
        private Double upperSampling;

        public Builder() {}

        private Builder(StandardDeviationBounds o) {
            this.lower = o.lower;
            this.lowerPopulation = o.lowerPopulation;
            this.lowerSampling = o.lowerSampling;
            this.upper = o.upper;
            this.upperPopulation = o.upperPopulation;
            this.upperSampling = o.upperSampling;
        }

        private Builder(Builder o) {
            this.lower = o.lower;
            this.lowerPopulation = o.lowerPopulation;
            this.lowerSampling = o.lowerSampling;
            this.upper = o.upper;
            this.upperPopulation = o.upperPopulation;
            this.upperSampling = o.upperSampling;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code lower}
         */
        @Nonnull
        public final Builder lower(@Nullable Double value) {
            this.lower = value;
            return this;
        }

        /**
         * API name: {@code lower_population}
         */
        @Nonnull
        public final Builder lowerPopulation(@Nullable Double value) {
            this.lowerPopulation = value;
            return this;
        }

        /**
         * API name: {@code lower_sampling}
         */
        @Nonnull
        public final Builder lowerSampling(@Nullable Double value) {
            this.lowerSampling = value;
            return this;
        }

        /**
         * API name: {@code upper}
         */
        @Nonnull
        public final Builder upper(@Nullable Double value) {
            this.upper = value;
            return this;
        }

        /**
         * API name: {@code upper_population}
         */
        @Nonnull
        public final Builder upperPopulation(@Nullable Double value) {
            this.upperPopulation = value;
            return this;
        }

        /**
         * API name: {@code upper_sampling}
         */
        @Nonnull
        public final Builder upperSampling(@Nullable Double value) {
            this.upperSampling = value;
            return this;
        }

        /**
         * Builds a {@link StandardDeviationBounds}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public StandardDeviationBounds build() {
            _checkSingleUse();

            return new StandardDeviationBounds(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link StandardDeviationBounds}
     */
    public static final JsonpDeserializer<StandardDeviationBounds> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        StandardDeviationBounds::setupStandardDeviationBoundsDeserializer
    );

    protected static void setupStandardDeviationBoundsDeserializer(ObjectDeserializer<StandardDeviationBounds.Builder> op) {
        op.add(Builder::lower, JsonpDeserializer.doubleDeserializer(), "lower");
        op.add(Builder::lowerPopulation, JsonpDeserializer.doubleDeserializer(), "lower_population");
        op.add(Builder::lowerSampling, JsonpDeserializer.doubleDeserializer(), "lower_sampling");
        op.add(Builder::upper, JsonpDeserializer.doubleDeserializer(), "upper");
        op.add(Builder::upperPopulation, JsonpDeserializer.doubleDeserializer(), "upper_population");
        op.add(Builder::upperSampling, JsonpDeserializer.doubleDeserializer(), "upper_sampling");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.lower);
        result = 31 * result + Objects.hashCode(this.lowerPopulation);
        result = 31 * result + Objects.hashCode(this.lowerSampling);
        result = 31 * result + Objects.hashCode(this.upper);
        result = 31 * result + Objects.hashCode(this.upperPopulation);
        result = 31 * result + Objects.hashCode(this.upperSampling);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        StandardDeviationBounds other = (StandardDeviationBounds) o;
        return Objects.equals(this.lower, other.lower)
            && Objects.equals(this.lowerPopulation, other.lowerPopulation)
            && Objects.equals(this.lowerSampling, other.lowerSampling)
            && Objects.equals(this.upper, other.upper)
            && Objects.equals(this.upperPopulation, other.upperPopulation)
            && Objects.equals(this.upperSampling, other.upperSampling);
    }
}
