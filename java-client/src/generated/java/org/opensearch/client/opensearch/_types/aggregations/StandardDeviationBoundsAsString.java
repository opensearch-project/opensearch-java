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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.StandardDeviationBoundsAsString

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class StandardDeviationBoundsAsString
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<StandardDeviationBoundsAsString.Builder, StandardDeviationBoundsAsString> {

    @Nonnull
    private final String lower;

    @Nonnull
    private final String lowerPopulation;

    @Nonnull
    private final String lowerSampling;

    @Nonnull
    private final String upper;

    @Nonnull
    private final String upperPopulation;

    @Nonnull
    private final String upperSampling;

    // ---------------------------------------------------------------------------------------------

    private StandardDeviationBoundsAsString(Builder builder) {
        this.lower = ApiTypeHelper.requireNonNull(builder.lower, this, "lower");
        this.lowerPopulation = ApiTypeHelper.requireNonNull(builder.lowerPopulation, this, "lowerPopulation");
        this.lowerSampling = ApiTypeHelper.requireNonNull(builder.lowerSampling, this, "lowerSampling");
        this.upper = ApiTypeHelper.requireNonNull(builder.upper, this, "upper");
        this.upperPopulation = ApiTypeHelper.requireNonNull(builder.upperPopulation, this, "upperPopulation");
        this.upperSampling = ApiTypeHelper.requireNonNull(builder.upperSampling, this, "upperSampling");
    }

    public static StandardDeviationBoundsAsString of(
        Function<StandardDeviationBoundsAsString.Builder, ObjectBuilder<StandardDeviationBoundsAsString>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code lower}
     */
    @Nonnull
    public final String lower() {
        return this.lower;
    }

    /**
     * Required - API name: {@code lower_population}
     */
    @Nonnull
    public final String lowerPopulation() {
        return this.lowerPopulation;
    }

    /**
     * Required - API name: {@code lower_sampling}
     */
    @Nonnull
    public final String lowerSampling() {
        return this.lowerSampling;
    }

    /**
     * Required - API name: {@code upper}
     */
    @Nonnull
    public final String upper() {
        return this.upper;
    }

    /**
     * Required - API name: {@code upper_population}
     */
    @Nonnull
    public final String upperPopulation() {
        return this.upperPopulation;
    }

    /**
     * Required - API name: {@code upper_sampling}
     */
    @Nonnull
    public final String upperSampling() {
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
        generator.writeKey("lower");
        generator.write(this.lower);

        generator.writeKey("lower_population");
        generator.write(this.lowerPopulation);

        generator.writeKey("lower_sampling");
        generator.write(this.lowerSampling);

        generator.writeKey("upper");
        generator.write(this.upper);

        generator.writeKey("upper_population");
        generator.write(this.upperPopulation);

        generator.writeKey("upper_sampling");
        generator.write(this.upperSampling);
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
     * Builder for {@link StandardDeviationBoundsAsString}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, StandardDeviationBoundsAsString> {
        private String lower;
        private String lowerPopulation;
        private String lowerSampling;
        private String upper;
        private String upperPopulation;
        private String upperSampling;

        public Builder() {}

        private Builder(StandardDeviationBoundsAsString o) {
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
         * Required - API name: {@code lower}
         */
        @Nonnull
        public final Builder lower(String value) {
            this.lower = value;
            return this;
        }

        /**
         * Required - API name: {@code lower_population}
         */
        @Nonnull
        public final Builder lowerPopulation(String value) {
            this.lowerPopulation = value;
            return this;
        }

        /**
         * Required - API name: {@code lower_sampling}
         */
        @Nonnull
        public final Builder lowerSampling(String value) {
            this.lowerSampling = value;
            return this;
        }

        /**
         * Required - API name: {@code upper}
         */
        @Nonnull
        public final Builder upper(String value) {
            this.upper = value;
            return this;
        }

        /**
         * Required - API name: {@code upper_population}
         */
        @Nonnull
        public final Builder upperPopulation(String value) {
            this.upperPopulation = value;
            return this;
        }

        /**
         * Required - API name: {@code upper_sampling}
         */
        @Nonnull
        public final Builder upperSampling(String value) {
            this.upperSampling = value;
            return this;
        }

        /**
         * Builds a {@link StandardDeviationBoundsAsString}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public StandardDeviationBoundsAsString build() {
            _checkSingleUse();

            return new StandardDeviationBoundsAsString(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link StandardDeviationBoundsAsString}
     */
    public static final JsonpDeserializer<StandardDeviationBoundsAsString> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        StandardDeviationBoundsAsString::setupStandardDeviationBoundsAsStringDeserializer
    );

    protected static void setupStandardDeviationBoundsAsStringDeserializer(ObjectDeserializer<StandardDeviationBoundsAsString.Builder> op) {
        op.add(Builder::lower, JsonpDeserializer.stringDeserializer(), "lower");
        op.add(Builder::lowerPopulation, JsonpDeserializer.stringDeserializer(), "lower_population");
        op.add(Builder::lowerSampling, JsonpDeserializer.stringDeserializer(), "lower_sampling");
        op.add(Builder::upper, JsonpDeserializer.stringDeserializer(), "upper");
        op.add(Builder::upperPopulation, JsonpDeserializer.stringDeserializer(), "upper_population");
        op.add(Builder::upperSampling, JsonpDeserializer.stringDeserializer(), "upper_sampling");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.lower.hashCode();
        result = 31 * result + this.lowerPopulation.hashCode();
        result = 31 * result + this.lowerSampling.hashCode();
        result = 31 * result + this.upper.hashCode();
        result = 31 * result + this.upperPopulation.hashCode();
        result = 31 * result + this.upperSampling.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        StandardDeviationBoundsAsString other = (StandardDeviationBoundsAsString) o;
        return this.lower.equals(other.lower)
            && this.lowerPopulation.equals(other.lowerPopulation)
            && this.lowerSampling.equals(other.lowerSampling)
            && this.upper.equals(other.upper)
            && this.upperPopulation.equals(other.upperPopulation)
            && this.upperSampling.equals(other.upperSampling);
    }
}
