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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.FieldValueFactorScoreFunction

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FieldValueFactorScoreFunction
    implements
        FunctionScoreVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<FieldValueFactorScoreFunction.Builder, FieldValueFactorScoreFunction> {

    @Nullable
    private final Float factor;

    @Nonnull
    private final String field;

    @Nullable
    private final Double missing;

    @Nullable
    private final FieldValueFactorModifier modifier;

    // ---------------------------------------------------------------------------------------------

    private FieldValueFactorScoreFunction(Builder builder) {
        this.factor = builder.factor;
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.missing = builder.missing;
        this.modifier = builder.modifier;
    }

    public static FieldValueFactorScoreFunction of(
        Function<FieldValueFactorScoreFunction.Builder, ObjectBuilder<FieldValueFactorScoreFunction>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link FunctionScore} variant kind.
     */
    @Override
    public FunctionScore.Kind _functionScoreKind() {
        return FunctionScore.Kind.FieldValueFactor;
    }

    /**
     * Optional factor to multiply the field value with.
     * <p>
     * API name: {@code factor}
     * </p>
     */
    @Nullable
    public final Float factor() {
        return this.factor;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * Value used if the document doesn't have that field. The modifier and factor are still applied to it as though it were read from the
     * document.
     * <p>
     * API name: {@code missing}
     * </p>
     */
    @Nullable
    public final Double missing() {
        return this.missing;
    }

    /**
     * API name: {@code modifier}
     */
    @Nullable
    public final FieldValueFactorModifier modifier() {
        return this.modifier;
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
        if (this.factor != null) {
            generator.writeKey("factor");
            generator.write(this.factor);
        }

        generator.writeKey("field");
        generator.write(this.field);

        if (this.missing != null) {
            generator.writeKey("missing");
            generator.write(this.missing);
        }

        if (this.modifier != null) {
            generator.writeKey("modifier");
            this.modifier.serialize(generator, mapper);
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
     * Builder for {@link FieldValueFactorScoreFunction}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, FieldValueFactorScoreFunction> {
        @Nullable
        private Float factor;
        private String field;
        @Nullable
        private Double missing;
        @Nullable
        private FieldValueFactorModifier modifier;

        public Builder() {}

        private Builder(FieldValueFactorScoreFunction o) {
            this.factor = o.factor;
            this.field = o.field;
            this.missing = o.missing;
            this.modifier = o.modifier;
        }

        private Builder(Builder o) {
            this.factor = o.factor;
            this.field = o.field;
            this.missing = o.missing;
            this.modifier = o.modifier;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Optional factor to multiply the field value with.
         * <p>
         * API name: {@code factor}
         * </p>
         */
        @Nonnull
        public final Builder factor(@Nullable Float value) {
            this.factor = value;
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
         * Value used if the document doesn't have that field. The modifier and factor are still applied to it as though it were read from
         * the document.
         * <p>
         * API name: {@code missing}
         * </p>
         */
        @Nonnull
        public final Builder missing(@Nullable Double value) {
            this.missing = value;
            return this;
        }

        /**
         * API name: {@code modifier}
         */
        @Nonnull
        public final Builder modifier(@Nullable FieldValueFactorModifier value) {
            this.modifier = value;
            return this;
        }

        /**
         * Builds a {@link FieldValueFactorScoreFunction}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FieldValueFactorScoreFunction build() {
            _checkSingleUse();

            return new FieldValueFactorScoreFunction(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FieldValueFactorScoreFunction}
     */
    public static final JsonpDeserializer<FieldValueFactorScoreFunction> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FieldValueFactorScoreFunction::setupFieldValueFactorScoreFunctionDeserializer
    );

    protected static void setupFieldValueFactorScoreFunctionDeserializer(ObjectDeserializer<FieldValueFactorScoreFunction.Builder> op) {
        op.add(Builder::factor, JsonpDeserializer.floatDeserializer(), "factor");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::missing, JsonpDeserializer.doubleDeserializer(), "missing");
        op.add(Builder::modifier, FieldValueFactorModifier._DESERIALIZER, "modifier");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.factor);
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.missing);
        result = 31 * result + Objects.hashCode(this.modifier);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FieldValueFactorScoreFunction other = (FieldValueFactorScoreFunction) o;
        return Objects.equals(this.factor, other.factor)
            && this.field.equals(other.field)
            && Objects.equals(this.missing, other.missing)
            && Objects.equals(this.modifier, other.modifier);
    }
}
