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

// typedef: _types.query_dsl.RankFeatureFunctionLogarithm

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RankFeatureFunctionLogarithm extends RankFeatureFunction
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RankFeatureFunctionLogarithm.Builder, RankFeatureFunctionLogarithm> {

    private final float scalingFactor;

    // ---------------------------------------------------------------------------------------------

    private RankFeatureFunctionLogarithm(Builder builder) {
        super(builder);
        this.scalingFactor = ApiTypeHelper.requireNonNull(builder.scalingFactor, this, "scalingFactor");
    }

    public static RankFeatureFunctionLogarithm of(
        Function<RankFeatureFunctionLogarithm.Builder, ObjectBuilder<RankFeatureFunctionLogarithm>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Configurable scaling factor.
     * <p>
     * API name: {@code scaling_factor}
     * </p>
     */
    public final float scalingFactor() {
        return this.scalingFactor;
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
        generator.writeKey("scaling_factor");
        generator.write(this.scalingFactor);
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
     * Builder for {@link RankFeatureFunctionLogarithm}.
     */
    public static class Builder extends RankFeatureFunction.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, RankFeatureFunctionLogarithm> {
        private Float scalingFactor;

        public Builder() {}

        private Builder(RankFeatureFunctionLogarithm o) {
            super(o);
            this.scalingFactor = o.scalingFactor;
        }

        private Builder(Builder o) {
            super(o);
            this.scalingFactor = o.scalingFactor;
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
         * Required - Configurable scaling factor.
         * <p>
         * API name: {@code scaling_factor}
         * </p>
         */
        @Nonnull
        public final Builder scalingFactor(float value) {
            this.scalingFactor = value;
            return this;
        }

        /**
         * Builds a {@link RankFeatureFunctionLogarithm}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RankFeatureFunctionLogarithm build() {
            _checkSingleUse();

            return new RankFeatureFunctionLogarithm(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RankFeatureFunctionLogarithm}
     */
    public static final JsonpDeserializer<RankFeatureFunctionLogarithm> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RankFeatureFunctionLogarithm::setupRankFeatureFunctionLogarithmDeserializer
    );

    protected static void setupRankFeatureFunctionLogarithmDeserializer(ObjectDeserializer<RankFeatureFunctionLogarithm.Builder> op) {
        setupRankFeatureFunctionDeserializer(op);
        op.add(Builder::scalingFactor, JsonpDeserializer.floatDeserializer(), "scaling_factor");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Float.hashCode(this.scalingFactor);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RankFeatureFunctionLogarithm other = (RankFeatureFunctionLogarithm) o;
        return this.scalingFactor == other.scalingFactor;
    }
}
