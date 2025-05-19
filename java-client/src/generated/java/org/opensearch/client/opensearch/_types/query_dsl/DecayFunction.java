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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.DecayFunction

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DecayFunction extends DecayFunctionBase
    implements
        FunctionScoreVariant,
        ToCopyableBuilder<DecayFunction.Builder, DecayFunction> {

    @Nonnull
    private final String field;

    @Nonnull
    private final DecayPlacement placement;

    // ---------------------------------------------------------------------------------------------

    private DecayFunction(Builder builder) {
        super(builder);
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.placement = ApiTypeHelper.requireNonNull(builder.placement, this, "placement");
    }

    public static DecayFunction of(Function<DecayFunction.Builder, ObjectBuilder<DecayFunction>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link FunctionScore} variant kind.
     */
    @Override
    public FunctionScore.Kind _functionScoreKind() {
        return FunctionScore.Kind.Linear;
    }

    /**
     * Required -
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * Required -
     */
    @Nonnull
    public final DecayPlacement placement() {
        return this.placement;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey(this.field);
        this.placement.serialize(generator, mapper);
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
     * Builder for {@link DecayFunction}.
     */
    public static class Builder extends DecayFunctionBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, DecayFunction> {
        private String field;
        private DecayPlacement placement;

        public Builder() {}

        private Builder(DecayFunction o) {
            super(o);
            this.field = o.field;
            this.placement = o.placement;
        }

        private Builder(Builder o) {
            super(o);
            this.field = o.field;
            this.placement = o.placement;
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
         * Required -
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * Required -
         */
        @Nonnull
        public final Builder placement(DecayPlacement value) {
            this.placement = value;
            return this;
        }

        /**
         * Required -
         */
        @Nonnull
        public final Builder placement(Function<DecayPlacement.Builder, ObjectBuilder<DecayPlacement>> fn) {
            return placement(fn.apply(new DecayPlacement.Builder()).build());
        }

        /**
         * Builds a {@link DecayFunction}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DecayFunction build() {
            _checkSingleUse();

            return new DecayFunction(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DecayFunction}
     */
    public static final JsonpDeserializer<DecayFunction> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DecayFunction::setupDecayFunctionDeserializer
    );

    protected static void setupDecayFunctionDeserializer(ObjectDeserializer<DecayFunction.Builder> op) {
        setupDecayFunctionBaseDeserializer(op);
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            builder.field(name);
            builder.placement(DecayPlacement._DESERIALIZER.deserialize(parser, mapper));
        });
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.field.hashCode();
        result = 31 * result + this.placement.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DecayFunction other = (DecayFunction) o;
        return this.field.equals(other.field) && this.placement.equals(other.placement);
    }
}
