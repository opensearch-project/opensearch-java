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
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.RankFeatureFunctionSaturation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RankFeatureFunctionSaturation extends RankFeatureFunction
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RankFeatureFunctionSaturation.Builder, RankFeatureFunctionSaturation> {

    @Nullable
    private final Float pivot;

    // ---------------------------------------------------------------------------------------------

    private RankFeatureFunctionSaturation(Builder builder) {
        super(builder);
        this.pivot = builder.pivot;
    }

    public static RankFeatureFunctionSaturation of(
        Function<RankFeatureFunctionSaturation.Builder, ObjectBuilder<RankFeatureFunctionSaturation>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Configurable pivot value so that the result will be less than 0.5.
     * <p>
     * API name: {@code pivot}
     * </p>
     */
    @Nullable
    public final Float pivot() {
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
        if (this.pivot != null) {
            generator.writeKey("pivot");
            generator.write(this.pivot);
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
     * Builder for {@link RankFeatureFunctionSaturation}.
     */
    public static class Builder extends RankFeatureFunction.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, RankFeatureFunctionSaturation> {
        @Nullable
        private Float pivot;

        public Builder() {}

        private Builder(RankFeatureFunctionSaturation o) {
            super(o);
            this.pivot = o.pivot;
        }

        private Builder(Builder o) {
            super(o);
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
         * Configurable pivot value so that the result will be less than 0.5.
         * <p>
         * API name: {@code pivot}
         * </p>
         */
        @Nonnull
        public final Builder pivot(@Nullable Float value) {
            this.pivot = value;
            return this;
        }

        /**
         * Builds a {@link RankFeatureFunctionSaturation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RankFeatureFunctionSaturation build() {
            _checkSingleUse();

            return new RankFeatureFunctionSaturation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RankFeatureFunctionSaturation}
     */
    public static final JsonpDeserializer<RankFeatureFunctionSaturation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RankFeatureFunctionSaturation::setupRankFeatureFunctionSaturationDeserializer
    );

    protected static void setupRankFeatureFunctionSaturationDeserializer(ObjectDeserializer<RankFeatureFunctionSaturation.Builder> op) {
        setupRankFeatureFunctionDeserializer(op);
        op.add(Builder::pivot, JsonpDeserializer.floatDeserializer(), "pivot");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.pivot);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RankFeatureFunctionSaturation other = (RankFeatureFunctionSaturation) o;
        return Objects.equals(this.pivot, other.pivot);
    }
}
