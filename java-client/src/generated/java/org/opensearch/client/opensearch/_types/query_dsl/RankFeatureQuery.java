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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.RankFeatureQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RankFeatureQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<RankFeatureQuery.Builder, RankFeatureQuery> {

    @Nonnull
    private final String field;

    @Nullable
    private final RankFeatureFunctionLinear linear;

    @Nullable
    private final RankFeatureFunctionLogarithm log;

    @Nullable
    private final RankFeatureFunctionSaturation saturation;

    @Nullable
    private final RankFeatureFunctionSigmoid sigmoid;

    // ---------------------------------------------------------------------------------------------

    private RankFeatureQuery(Builder builder) {
        super(builder);
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.linear = builder.linear;
        this.log = builder.log;
        this.saturation = builder.saturation;
        this.sigmoid = builder.sigmoid;
    }

    public static RankFeatureQuery of(Function<RankFeatureQuery.Builder, ObjectBuilder<RankFeatureQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.RankFeature;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code linear}
     */
    @Nullable
    public final RankFeatureFunctionLinear linear() {
        return this.linear;
    }

    /**
     * API name: {@code log}
     */
    @Nullable
    public final RankFeatureFunctionLogarithm log() {
        return this.log;
    }

    /**
     * API name: {@code saturation}
     */
    @Nullable
    public final RankFeatureFunctionSaturation saturation() {
        return this.saturation;
    }

    /**
     * API name: {@code sigmoid}
     */
    @Nullable
    public final RankFeatureFunctionSigmoid sigmoid() {
        return this.sigmoid;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("field");
        generator.write(this.field);

        if (this.linear != null) {
            generator.writeKey("linear");
            this.linear.serialize(generator, mapper);
        }

        if (this.log != null) {
            generator.writeKey("log");
            this.log.serialize(generator, mapper);
        }

        if (this.saturation != null) {
            generator.writeKey("saturation");
            this.saturation.serialize(generator, mapper);
        }

        if (this.sigmoid != null) {
            generator.writeKey("sigmoid");
            this.sigmoid.serialize(generator, mapper);
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
     * Builder for {@link RankFeatureQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, RankFeatureQuery> {
        private String field;
        @Nullable
        private RankFeatureFunctionLinear linear;
        @Nullable
        private RankFeatureFunctionLogarithm log;
        @Nullable
        private RankFeatureFunctionSaturation saturation;
        @Nullable
        private RankFeatureFunctionSigmoid sigmoid;

        public Builder() {}

        private Builder(RankFeatureQuery o) {
            super(o);
            this.field = o.field;
            this.linear = o.linear;
            this.log = o.log;
            this.saturation = o.saturation;
            this.sigmoid = o.sigmoid;
        }

        private Builder(Builder o) {
            super(o);
            this.field = o.field;
            this.linear = o.linear;
            this.log = o.log;
            this.saturation = o.saturation;
            this.sigmoid = o.sigmoid;
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
         * Required - API name: {@code field}
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * API name: {@code linear}
         */
        @Nonnull
        public final Builder linear(@Nullable RankFeatureFunctionLinear value) {
            this.linear = value;
            return this;
        }

        /**
         * API name: {@code linear}
         */
        @Nonnull
        public final Builder linear(Function<RankFeatureFunctionLinear.Builder, ObjectBuilder<RankFeatureFunctionLinear>> fn) {
            return linear(fn.apply(new RankFeatureFunctionLinear.Builder()).build());
        }

        /**
         * API name: {@code log}
         */
        @Nonnull
        public final Builder log(@Nullable RankFeatureFunctionLogarithm value) {
            this.log = value;
            return this;
        }

        /**
         * API name: {@code log}
         */
        @Nonnull
        public final Builder log(Function<RankFeatureFunctionLogarithm.Builder, ObjectBuilder<RankFeatureFunctionLogarithm>> fn) {
            return log(fn.apply(new RankFeatureFunctionLogarithm.Builder()).build());
        }

        /**
         * API name: {@code saturation}
         */
        @Nonnull
        public final Builder saturation(@Nullable RankFeatureFunctionSaturation value) {
            this.saturation = value;
            return this;
        }

        /**
         * API name: {@code saturation}
         */
        @Nonnull
        public final Builder saturation(Function<RankFeatureFunctionSaturation.Builder, ObjectBuilder<RankFeatureFunctionSaturation>> fn) {
            return saturation(fn.apply(new RankFeatureFunctionSaturation.Builder()).build());
        }

        /**
         * API name: {@code sigmoid}
         */
        @Nonnull
        public final Builder sigmoid(@Nullable RankFeatureFunctionSigmoid value) {
            this.sigmoid = value;
            return this;
        }

        /**
         * API name: {@code sigmoid}
         */
        @Nonnull
        public final Builder sigmoid(Function<RankFeatureFunctionSigmoid.Builder, ObjectBuilder<RankFeatureFunctionSigmoid>> fn) {
            return sigmoid(fn.apply(new RankFeatureFunctionSigmoid.Builder()).build());
        }

        /**
         * Builds a {@link RankFeatureQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RankFeatureQuery build() {
            _checkSingleUse();

            return new RankFeatureQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RankFeatureQuery}
     */
    public static final JsonpDeserializer<RankFeatureQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RankFeatureQuery::setupRankFeatureQueryDeserializer
    );

    protected static void setupRankFeatureQueryDeserializer(ObjectDeserializer<RankFeatureQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::linear, RankFeatureFunctionLinear._DESERIALIZER, "linear");
        op.add(Builder::log, RankFeatureFunctionLogarithm._DESERIALIZER, "log");
        op.add(Builder::saturation, RankFeatureFunctionSaturation._DESERIALIZER, "saturation");
        op.add(Builder::sigmoid, RankFeatureFunctionSigmoid._DESERIALIZER, "sigmoid");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.linear);
        result = 31 * result + Objects.hashCode(this.log);
        result = 31 * result + Objects.hashCode(this.saturation);
        result = 31 * result + Objects.hashCode(this.sigmoid);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RankFeatureQuery other = (RankFeatureQuery) o;
        return this.field.equals(other.field)
            && Objects.equals(this.linear, other.linear)
            && Objects.equals(this.log, other.log)
            && Objects.equals(this.saturation, other.saturation)
            && Objects.equals(this.sigmoid, other.sigmoid);
    }
}
