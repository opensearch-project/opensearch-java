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

package org.opensearch.client.opensearch._types.mapping;

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
import org.opensearch.client.opensearch._types.analysis.IcuCollationAlternate;
import org.opensearch.client.opensearch._types.analysis.IcuCollationCaseFirst;
import org.opensearch.client.opensearch._types.analysis.IcuCollationDecomposition;
import org.opensearch.client.opensearch._types.analysis.IcuCollationStrength;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.mapping.IcuCollationKeywordProperty

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IcuCollationKeywordProperty extends DocValuesPropertyBase
    implements
        PropertyVariant,
        ToCopyableBuilder<IcuCollationKeywordProperty.Builder, IcuCollationKeywordProperty> {

    @Nullable
    private final IcuCollationAlternate alternate;

    @Nullable
    private final IcuCollationCaseFirst caseFirst;

    @Nullable
    private final Boolean caseLevel;

    @Nullable
    private final String country;

    @Nullable
    private final IcuCollationDecomposition decomposition;

    @Nullable
    private final Boolean hiraganaQuaternaryMode;

    @Nullable
    private final Boolean index;

    @Nullable
    private final String language;

    @Nullable
    private final String nullValue;

    @Nullable
    private final Boolean numeric;

    @Nullable
    private final IcuCollationStrength strength;

    @Nullable
    private final String variableTop;

    @Nullable
    private final String variant;

    // ---------------------------------------------------------------------------------------------

    private IcuCollationKeywordProperty(Builder builder) {
        super(builder);
        this.alternate = builder.alternate;
        this.caseFirst = builder.caseFirst;
        this.caseLevel = builder.caseLevel;
        this.country = builder.country;
        this.decomposition = builder.decomposition;
        this.hiraganaQuaternaryMode = builder.hiraganaQuaternaryMode;
        this.index = builder.index;
        this.language = builder.language;
        this.nullValue = builder.nullValue;
        this.numeric = builder.numeric;
        this.strength = builder.strength;
        this.variableTop = builder.variableTop;
        this.variant = builder.variant;
    }

    public static IcuCollationKeywordProperty of(
        Function<IcuCollationKeywordProperty.Builder, ObjectBuilder<IcuCollationKeywordProperty>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.IcuCollationKeyword;
    }

    /**
     * API name: {@code alternate}
     */
    @Nullable
    public final IcuCollationAlternate alternate() {
        return this.alternate;
    }

    /**
     * API name: {@code case_first}
     */
    @Nullable
    public final IcuCollationCaseFirst caseFirst() {
        return this.caseFirst;
    }

    /**
     * API name: {@code case_level}
     */
    @Nullable
    public final Boolean caseLevel() {
        return this.caseLevel;
    }

    /**
     * API name: {@code country}
     */
    @Nullable
    public final String country() {
        return this.country;
    }

    /**
     * API name: {@code decomposition}
     */
    @Nullable
    public final IcuCollationDecomposition decomposition() {
        return this.decomposition;
    }

    /**
     * API name: {@code hiragana_quaternary_mode}
     */
    @Nullable
    public final Boolean hiraganaQuaternaryMode() {
        return this.hiraganaQuaternaryMode;
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final Boolean index() {
        return this.index;
    }

    /**
     * API name: {@code language}
     */
    @Nullable
    public final String language() {
        return this.language;
    }

    /**
     * API name: {@code null_value}
     */
    @Nullable
    public final String nullValue() {
        return this.nullValue;
    }

    /**
     * API name: {@code numeric}
     */
    @Nullable
    public final Boolean numeric() {
        return this.numeric;
    }

    /**
     * API name: {@code strength}
     */
    @Nullable
    public final IcuCollationStrength strength() {
        return this.strength;
    }

    /**
     * API name: {@code variable_top}
     */
    @Nullable
    public final String variableTop() {
        return this.variableTop;
    }

    /**
     * API name: {@code variant}
     */
    @Nullable
    public final String variant() {
        return this.variant;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "icu_collation_keyword");
        super.serializeInternal(generator, mapper);
        if (this.alternate != null) {
            generator.writeKey("alternate");
            this.alternate.serialize(generator, mapper);
        }

        if (this.caseFirst != null) {
            generator.writeKey("case_first");
            this.caseFirst.serialize(generator, mapper);
        }

        if (this.caseLevel != null) {
            generator.writeKey("case_level");
            generator.write(this.caseLevel);
        }

        if (this.country != null) {
            generator.writeKey("country");
            generator.write(this.country);
        }

        if (this.decomposition != null) {
            generator.writeKey("decomposition");
            this.decomposition.serialize(generator, mapper);
        }

        if (this.hiraganaQuaternaryMode != null) {
            generator.writeKey("hiragana_quaternary_mode");
            generator.write(this.hiraganaQuaternaryMode);
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.language != null) {
            generator.writeKey("language");
            generator.write(this.language);
        }

        if (this.nullValue != null) {
            generator.writeKey("null_value");
            generator.write(this.nullValue);
        }

        if (this.numeric != null) {
            generator.writeKey("numeric");
            generator.write(this.numeric);
        }

        if (this.strength != null) {
            generator.writeKey("strength");
            this.strength.serialize(generator, mapper);
        }

        if (this.variableTop != null) {
            generator.writeKey("variable_top");
            generator.write(this.variableTop);
        }

        if (this.variant != null) {
            generator.writeKey("variant");
            generator.write(this.variant);
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
     * Builder for {@link IcuCollationKeywordProperty}.
     */
    public static class Builder extends DocValuesPropertyBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, IcuCollationKeywordProperty> {
        @Nullable
        private IcuCollationAlternate alternate;
        @Nullable
        private IcuCollationCaseFirst caseFirst;
        @Nullable
        private Boolean caseLevel;
        @Nullable
        private String country;
        @Nullable
        private IcuCollationDecomposition decomposition;
        @Nullable
        private Boolean hiraganaQuaternaryMode;
        @Nullable
        private Boolean index;
        @Nullable
        private String language;
        @Nullable
        private String nullValue;
        @Nullable
        private Boolean numeric;
        @Nullable
        private IcuCollationStrength strength;
        @Nullable
        private String variableTop;
        @Nullable
        private String variant;

        public Builder() {}

        private Builder(IcuCollationKeywordProperty o) {
            super(o);
            this.alternate = o.alternate;
            this.caseFirst = o.caseFirst;
            this.caseLevel = o.caseLevel;
            this.country = o.country;
            this.decomposition = o.decomposition;
            this.hiraganaQuaternaryMode = o.hiraganaQuaternaryMode;
            this.index = o.index;
            this.language = o.language;
            this.nullValue = o.nullValue;
            this.numeric = o.numeric;
            this.strength = o.strength;
            this.variableTop = o.variableTop;
            this.variant = o.variant;
        }

        private Builder(Builder o) {
            super(o);
            this.alternate = o.alternate;
            this.caseFirst = o.caseFirst;
            this.caseLevel = o.caseLevel;
            this.country = o.country;
            this.decomposition = o.decomposition;
            this.hiraganaQuaternaryMode = o.hiraganaQuaternaryMode;
            this.index = o.index;
            this.language = o.language;
            this.nullValue = o.nullValue;
            this.numeric = o.numeric;
            this.strength = o.strength;
            this.variableTop = o.variableTop;
            this.variant = o.variant;
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
         * API name: {@code alternate}
         */
        @Nonnull
        public final Builder alternate(@Nullable IcuCollationAlternate value) {
            this.alternate = value;
            return this;
        }

        /**
         * API name: {@code case_first}
         */
        @Nonnull
        public final Builder caseFirst(@Nullable IcuCollationCaseFirst value) {
            this.caseFirst = value;
            return this;
        }

        /**
         * API name: {@code case_level}
         */
        @Nonnull
        public final Builder caseLevel(@Nullable Boolean value) {
            this.caseLevel = value;
            return this;
        }

        /**
         * API name: {@code country}
         */
        @Nonnull
        public final Builder country(@Nullable String value) {
            this.country = value;
            return this;
        }

        /**
         * API name: {@code decomposition}
         */
        @Nonnull
        public final Builder decomposition(@Nullable IcuCollationDecomposition value) {
            this.decomposition = value;
            return this;
        }

        /**
         * API name: {@code hiragana_quaternary_mode}
         */
        @Nonnull
        public final Builder hiraganaQuaternaryMode(@Nullable Boolean value) {
            this.hiraganaQuaternaryMode = value;
            return this;
        }

        /**
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(@Nullable Boolean value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code language}
         */
        @Nonnull
        public final Builder language(@Nullable String value) {
            this.language = value;
            return this;
        }

        /**
         * API name: {@code null_value}
         */
        @Nonnull
        public final Builder nullValue(@Nullable String value) {
            this.nullValue = value;
            return this;
        }

        /**
         * API name: {@code numeric}
         */
        @Nonnull
        public final Builder numeric(@Nullable Boolean value) {
            this.numeric = value;
            return this;
        }

        /**
         * API name: {@code strength}
         */
        @Nonnull
        public final Builder strength(@Nullable IcuCollationStrength value) {
            this.strength = value;
            return this;
        }

        /**
         * API name: {@code variable_top}
         */
        @Nonnull
        public final Builder variableTop(@Nullable String value) {
            this.variableTop = value;
            return this;
        }

        /**
         * API name: {@code variant}
         */
        @Nonnull
        public final Builder variant(@Nullable String value) {
            this.variant = value;
            return this;
        }

        /**
         * Builds a {@link IcuCollationKeywordProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IcuCollationKeywordProperty build() {
            _checkSingleUse();

            return new IcuCollationKeywordProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IcuCollationKeywordProperty}
     */
    public static final JsonpDeserializer<IcuCollationKeywordProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IcuCollationKeywordProperty::setupIcuCollationKeywordPropertyDeserializer
    );

    protected static void setupIcuCollationKeywordPropertyDeserializer(ObjectDeserializer<IcuCollationKeywordProperty.Builder> op) {
        setupDocValuesPropertyBaseDeserializer(op);
        op.add(Builder::alternate, IcuCollationAlternate._DESERIALIZER, "alternate");
        op.add(Builder::caseFirst, IcuCollationCaseFirst._DESERIALIZER, "case_first");
        op.add(Builder::caseLevel, JsonpDeserializer.booleanDeserializer(), "case_level");
        op.add(Builder::country, JsonpDeserializer.stringDeserializer(), "country");
        op.add(Builder::decomposition, IcuCollationDecomposition._DESERIALIZER, "decomposition");
        op.add(Builder::hiraganaQuaternaryMode, JsonpDeserializer.booleanDeserializer(), "hiragana_quaternary_mode");
        op.add(Builder::index, JsonpDeserializer.booleanDeserializer(), "index");
        op.add(Builder::language, JsonpDeserializer.stringDeserializer(), "language");
        op.add(Builder::nullValue, JsonpDeserializer.stringDeserializer(), "null_value");
        op.add(Builder::numeric, JsonpDeserializer.booleanDeserializer(), "numeric");
        op.add(Builder::strength, IcuCollationStrength._DESERIALIZER, "strength");
        op.add(Builder::variableTop, JsonpDeserializer.stringDeserializer(), "variable_top");
        op.add(Builder::variant, JsonpDeserializer.stringDeserializer(), "variant");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.alternate);
        result = 31 * result + Objects.hashCode(this.caseFirst);
        result = 31 * result + Objects.hashCode(this.caseLevel);
        result = 31 * result + Objects.hashCode(this.country);
        result = 31 * result + Objects.hashCode(this.decomposition);
        result = 31 * result + Objects.hashCode(this.hiraganaQuaternaryMode);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.language);
        result = 31 * result + Objects.hashCode(this.nullValue);
        result = 31 * result + Objects.hashCode(this.numeric);
        result = 31 * result + Objects.hashCode(this.strength);
        result = 31 * result + Objects.hashCode(this.variableTop);
        result = 31 * result + Objects.hashCode(this.variant);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IcuCollationKeywordProperty other = (IcuCollationKeywordProperty) o;
        return Objects.equals(this.alternate, other.alternate)
            && Objects.equals(this.caseFirst, other.caseFirst)
            && Objects.equals(this.caseLevel, other.caseLevel)
            && Objects.equals(this.country, other.country)
            && Objects.equals(this.decomposition, other.decomposition)
            && Objects.equals(this.hiraganaQuaternaryMode, other.hiraganaQuaternaryMode)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.language, other.language)
            && Objects.equals(this.nullValue, other.nullValue)
            && Objects.equals(this.numeric, other.numeric)
            && Objects.equals(this.strength, other.strength)
            && Objects.equals(this.variableTop, other.variableTop)
            && Objects.equals(this.variant, other.variant);
    }
}
