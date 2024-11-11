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

package org.opensearch.client.opensearch._types.analysis;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ObjectBuilder;

// typedef: _types.analysis.IcuCollationTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IcuCollationTokenFilter extends TokenFilterBase implements TokenFilterDefinitionVariant {

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
    private final String language;

    @Nullable
    private final Boolean numeric;

    @Nullable
    private final String rules;

    @Nullable
    private final IcuCollationStrength strength;

    @Nullable
    private final String variableTop;

    @Nullable
    private final String variant;

    // ---------------------------------------------------------------------------------------------

    private IcuCollationTokenFilter(Builder builder) {
        super(builder);
        this.alternate = builder.alternate;
        this.caseFirst = builder.caseFirst;
        this.caseLevel = builder.caseLevel;
        this.country = builder.country;
        this.decomposition = builder.decomposition;
        this.hiraganaQuaternaryMode = builder.hiraganaQuaternaryMode;
        this.language = builder.language;
        this.numeric = builder.numeric;
        this.rules = builder.rules;
        this.strength = builder.strength;
        this.variableTop = builder.variableTop;
        this.variant = builder.variant;
    }

    public static IcuCollationTokenFilter of(Function<IcuCollationTokenFilter.Builder, ObjectBuilder<IcuCollationTokenFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.IcuCollation;
    }

    /**
     * API name: {@code alternate}
     */
    @Nullable
    public final IcuCollationAlternate alternate() {
        return this.alternate;
    }

    /**
     * API name: {@code caseFirst}
     */
    @Nullable
    public final IcuCollationCaseFirst caseFirst() {
        return this.caseFirst;
    }

    /**
     * API name: {@code caseLevel}
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
     * API name: {@code hiraganaQuaternaryMode}
     */
    @Nullable
    public final Boolean hiraganaQuaternaryMode() {
        return this.hiraganaQuaternaryMode;
    }

    /**
     * API name: {@code language}
     */
    @Nullable
    public final String language() {
        return this.language;
    }

    /**
     * API name: {@code numeric}
     */
    @Nullable
    public final Boolean numeric() {
        return this.numeric;
    }

    /**
     * API name: {@code rules}
     */
    @Nullable
    public final String rules() {
        return this.rules;
    }

    /**
     * API name: {@code strength}
     */
    @Nullable
    public final IcuCollationStrength strength() {
        return this.strength;
    }

    /**
     * API name: {@code variableTop}
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
        generator.write("type", "icu_collation");
        super.serializeInternal(generator, mapper);
        if (this.alternate != null) {
            generator.writeKey("alternate");
            this.alternate.serialize(generator, mapper);
        }

        if (this.caseFirst != null) {
            generator.writeKey("caseFirst");
            this.caseFirst.serialize(generator, mapper);
        }

        if (this.caseLevel != null) {
            generator.writeKey("caseLevel");
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
            generator.writeKey("hiraganaQuaternaryMode");
            generator.write(this.hiraganaQuaternaryMode);
        }

        if (this.language != null) {
            generator.writeKey("language");
            generator.write(this.language);
        }

        if (this.numeric != null) {
            generator.writeKey("numeric");
            generator.write(this.numeric);
        }

        if (this.rules != null) {
            generator.writeKey("rules");
            generator.write(this.rules);
        }

        if (this.strength != null) {
            generator.writeKey("strength");
            this.strength.serialize(generator, mapper);
        }

        if (this.variableTop != null) {
            generator.writeKey("variableTop");
            generator.write(this.variableTop);
        }

        if (this.variant != null) {
            generator.writeKey("variant");
            generator.write(this.variant);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link IcuCollationTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder> implements ObjectBuilder<IcuCollationTokenFilter> {
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
        private String language;
        @Nullable
        private Boolean numeric;
        @Nullable
        private String rules;
        @Nullable
        private IcuCollationStrength strength;
        @Nullable
        private String variableTop;
        @Nullable
        private String variant;

        /**
         * API name: {@code alternate}
         */
        public final Builder alternate(@Nullable IcuCollationAlternate value) {
            this.alternate = value;
            return this;
        }

        /**
         * API name: {@code caseFirst}
         */
        public final Builder caseFirst(@Nullable IcuCollationCaseFirst value) {
            this.caseFirst = value;
            return this;
        }

        /**
         * API name: {@code caseLevel}
         */
        public final Builder caseLevel(@Nullable Boolean value) {
            this.caseLevel = value;
            return this;
        }

        /**
         * API name: {@code country}
         */
        public final Builder country(@Nullable String value) {
            this.country = value;
            return this;
        }

        /**
         * API name: {@code decomposition}
         */
        public final Builder decomposition(@Nullable IcuCollationDecomposition value) {
            this.decomposition = value;
            return this;
        }

        /**
         * API name: {@code hiraganaQuaternaryMode}
         */
        public final Builder hiraganaQuaternaryMode(@Nullable Boolean value) {
            this.hiraganaQuaternaryMode = value;
            return this;
        }

        /**
         * API name: {@code language}
         */
        public final Builder language(@Nullable String value) {
            this.language = value;
            return this;
        }

        /**
         * API name: {@code numeric}
         */
        public final Builder numeric(@Nullable Boolean value) {
            this.numeric = value;
            return this;
        }

        /**
         * API name: {@code rules}
         */
        public final Builder rules(@Nullable String value) {
            this.rules = value;
            return this;
        }

        /**
         * API name: {@code strength}
         */
        public final Builder strength(@Nullable IcuCollationStrength value) {
            this.strength = value;
            return this;
        }

        /**
         * API name: {@code variableTop}
         */
        public final Builder variableTop(@Nullable String value) {
            this.variableTop = value;
            return this;
        }

        /**
         * API name: {@code variant}
         */
        public final Builder variant(@Nullable String value) {
            this.variant = value;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link IcuCollationTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public IcuCollationTokenFilter build() {
            _checkSingleUse();

            return new IcuCollationTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IcuCollationTokenFilter}
     */
    public static final JsonpDeserializer<IcuCollationTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IcuCollationTokenFilter::setupIcuCollationTokenFilterDeserializer
    );

    protected static void setupIcuCollationTokenFilterDeserializer(ObjectDeserializer<IcuCollationTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::alternate, IcuCollationAlternate._DESERIALIZER, "alternate");
        op.add(Builder::caseFirst, IcuCollationCaseFirst._DESERIALIZER, "caseFirst");
        op.add(Builder::caseLevel, JsonpDeserializer.booleanDeserializer(), "caseLevel");
        op.add(Builder::country, JsonpDeserializer.stringDeserializer(), "country");
        op.add(Builder::decomposition, IcuCollationDecomposition._DESERIALIZER, "decomposition");
        op.add(Builder::hiraganaQuaternaryMode, JsonpDeserializer.booleanDeserializer(), "hiraganaQuaternaryMode");
        op.add(Builder::language, JsonpDeserializer.stringDeserializer(), "language");
        op.add(Builder::numeric, JsonpDeserializer.booleanDeserializer(), "numeric");
        op.add(Builder::rules, JsonpDeserializer.stringDeserializer(), "rules");
        op.add(Builder::strength, IcuCollationStrength._DESERIALIZER, "strength");
        op.add(Builder::variableTop, JsonpDeserializer.stringDeserializer(), "variableTop");
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
        result = 31 * result + Objects.hashCode(this.language);
        result = 31 * result + Objects.hashCode(this.numeric);
        result = 31 * result + Objects.hashCode(this.rules);
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
        IcuCollationTokenFilter other = (IcuCollationTokenFilter) o;
        return Objects.equals(this.alternate, other.alternate)
            && Objects.equals(this.caseFirst, other.caseFirst)
            && Objects.equals(this.caseLevel, other.caseLevel)
            && Objects.equals(this.country, other.country)
            && Objects.equals(this.decomposition, other.decomposition)
            && Objects.equals(this.hiraganaQuaternaryMode, other.hiraganaQuaternaryMode)
            && Objects.equals(this.language, other.language)
            && Objects.equals(this.numeric, other.numeric)
            && Objects.equals(this.rules, other.rules)
            && Objects.equals(this.strength, other.strength)
            && Objects.equals(this.variableTop, other.variableTop)
            && Objects.equals(this.variant, other.variant);
    }
}
