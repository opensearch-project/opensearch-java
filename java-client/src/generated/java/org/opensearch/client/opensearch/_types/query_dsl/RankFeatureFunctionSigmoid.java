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

package org.opensearch.client.opensearch._types.query_dsl;

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
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.RankFeatureFunctionSigmoid

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RankFeatureFunctionSigmoid extends RankFeatureFunction
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RankFeatureFunctionSigmoid.Builder, RankFeatureFunctionSigmoid> {

    private final float exponent;

    private final float pivot;

    // ---------------------------------------------------------------------------------------------

    private RankFeatureFunctionSigmoid(Builder builder) {
        super(builder);
        this.exponent = ApiTypeHelper.requireNonNull(builder.exponent, this, "exponent");
        this.pivot = ApiTypeHelper.requireNonNull(builder.pivot, this, "pivot");
    }

    public static RankFeatureFunctionSigmoid of(
        Function<RankFeatureFunctionSigmoid.Builder, ObjectBuilder<RankFeatureFunctionSigmoid>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Configurable Exponent.
     * <p>
     * API name: {@code exponent}
     * </p>
     */
    public final float exponent() {
        return this.exponent;
    }

    /**
     * Required - Configurable pivot value so that the result will be less than 0.5.
     * <p>
     * API name: {@code pivot}
     * </p>
     */
    public final float pivot() {
        return this.pivot;
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
        super.serializeInternal(generator, mapper);
        generator.writeKey("exponent");
        generator.write(this.exponent);

        generator.writeKey("pivot");
        generator.write(this.pivot);
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
     * Builder for {@link RankFeatureFunctionSigmoid}.
     */
    public static class Builder extends RankFeatureFunction.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, RankFeatureFunctionSigmoid> {
        private Float exponent;
        private Float pivot;

        public Builder() {}

        private Builder(RankFeatureFunctionSigmoid o) {
            super(o);
            this.exponent = o.exponent;
            this.pivot = o.pivot;
        }

        private Builder(Builder o) {
            super(o);
            this.exponent = o.exponent;
            this.pivot = o.pivot;
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
         * Required - Configurable Exponent.
         * <p>
         * API name: {@code exponent}
         * </p>
         */
        @Nonnull
        public final Builder exponent(float value) {
            this.exponent = value;
            return this;
        }

        /**
         * Required - Configurable pivot value so that the result will be less than 0.5.
         * <p>
         * API name: {@code pivot}
         * </p>
         */
        @Nonnull
        public final Builder pivot(float value) {
            this.pivot = value;
            return this;
        }

        /**
         * Builds a {@link RankFeatureFunctionSigmoid}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RankFeatureFunctionSigmoid build() {
            _checkSingleUse();

            return new RankFeatureFunctionSigmoid(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RankFeatureFunctionSigmoid}
     */
    public static final JsonpDeserializer<RankFeatureFunctionSigmoid> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RankFeatureFunctionSigmoid::setupRankFeatureFunctionSigmoidDeserializer
    );

    protected static void setupRankFeatureFunctionSigmoidDeserializer(ObjectDeserializer<RankFeatureFunctionSigmoid.Builder> op) {
        setupRankFeatureFunctionDeserializer(op);
        op.add(Builder::exponent, JsonpDeserializer.floatDeserializer(), "exponent");
        op.add(Builder::pivot, JsonpDeserializer.floatDeserializer(), "pivot");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Float.hashCode(this.exponent);
        result = 31 * result + Float.hashCode(this.pivot);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RankFeatureFunctionSigmoid other = (RankFeatureFunctionSigmoid) o;
        return this.exponent == other.exponent && this.pivot == other.pivot;
    }
}
