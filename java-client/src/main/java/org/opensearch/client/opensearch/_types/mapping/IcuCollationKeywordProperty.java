/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.mapping;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
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
import org.opensearch.client.util.ObjectBuilder;

// typedef: _types.mapping.ICUCollationKeywordProperty

@JsonpDeserializable
public class IcuCollationKeywordProperty extends DocValuesPropertyBase implements PropertyVariant {

    @Nullable
    private final Boolean index;

    @Nullable
    private final String nullValue;

    // Collation Options

    @Nullable
    private final IcuCollationAlternate alternate;

    @Nullable
    private final Boolean caseLevel;

    @Nullable
    private final IcuCollationCaseFirst caseFirst;

    @Nullable
    private final IcuCollationDecomposition decomposition;

    @Nullable
    private final Boolean hiraganaQuaternaryMode;

    @Nullable
    private final Boolean numeric;

    @Nullable
    private final IcuCollationStrength strength;

    @Nullable
    private final String variableTop;

    // ---------------------------------------------------------------------------------------------

    private IcuCollationKeywordProperty(Builder builder) {
        super(builder);
        this.index = builder.index;
        this.nullValue = builder.nullValue;
        this.alternate = builder.alternate;
        this.caseLevel = builder.caseLevel;
        this.caseFirst = builder.caseFirst;
        this.decomposition = builder.decomposition;
        this.hiraganaQuaternaryMode = builder.hiraganaQuaternaryMode;
        this.numeric = builder.numeric;
        this.strength = builder.strength;
        this.variableTop = builder.variableTop;
    }

    public static IcuCollationKeywordProperty of(Function<Builder, ObjectBuilder<IcuCollationKeywordProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.IcuCollationKeyword;
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final Boolean index() {
        return this.index;
    }

    /**
     * API name: {@code null_value}
     */
    @Nullable
    public final String nullValue() {
        return this.nullValue;
    }

    /**
     * API name: {@code alternate}
     */
    public final IcuCollationAlternate alternate() {
        return this.alternate;
    }

    /**
     * API name: {@code case_level}
     */
    public final Boolean caseLevel() {
        return this.caseLevel;
    }

    /**
     * API name: {@code case_first}
     */
    public final IcuCollationCaseFirst caseFirst() {
        return this.caseFirst;
    }

    /**
     * API name: {@code decomposition}
     */
    public final IcuCollationDecomposition decomposition() {
        return this.decomposition;
    }

    /**
     * API name: {@code hiragana_quaternary_mode}
     */
    public final Boolean hiraganaQuaternaryMode() {
        return this.hiraganaQuaternaryMode;
    }

    /**
     * API name: {@code numeric}
     */
    public final Boolean numeric() {
        return this.numeric;
    }

    /**
     * API name: {@code strength}
     */
    public final IcuCollationStrength strength() {
        return this.strength;
    }

    /**
     * API name: {@code variable_top}
     */
    public final String variableTop() {
        return this.variableTop;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "icu_collation_keyword");
        super.serializeInternal(generator, mapper);
        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }
        if (this.nullValue != null) {
            generator.writeKey("null_value");
            generator.write(this.nullValue);
        }
        if (this.alternate != null) {
            generator.writeKey("alternate");
            generator.write(this.alternate.jsonValue());
        }
        if (this.caseLevel != null) {
            generator.writeKey("case_level");
            generator.write(this.caseLevel);
        }
        if (this.caseFirst != null) {
            generator.writeKey("case_first");
            generator.write(this.caseFirst.jsonValue());
        }
        if (this.decomposition != null) {
            generator.writeKey("decomposition");
            generator.write(this.decomposition.jsonValue());
        }
        if (this.hiraganaQuaternaryMode != null) {
            generator.writeKey("hiragana_quaternary_mode");
            generator.write(this.hiraganaQuaternaryMode);
        }
        if (this.numeric != null) {
            generator.writeKey("numeric");
            generator.write(this.numeric);
        }
        if (this.strength != null) {
            generator.writeKey("strength");
            generator.write(this.strength.jsonValue());
        }
        if (this.variableTop != null) {
            generator.writeKey("variable_top");
            generator.write(this.variableTop);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link IcuCollationKeywordProperty}.
     */

    public static class Builder extends DocValuesPropertyBase.AbstractBuilder<Builder>
        implements
            ObjectBuilder<IcuCollationKeywordProperty> {
        @Nullable
        private Boolean index;

        @Nullable
        private String nullValue;

        @Nullable
        private IcuCollationAlternate alternate;

        @Nullable
        private Boolean caseLevel;

        @Nullable
        private IcuCollationCaseFirst caseFirst;

        @Nullable
        private IcuCollationDecomposition decomposition;

        @Nullable
        private Boolean hiraganaQuaternaryMode;

        @Nullable
        private Boolean numeric;

        @Nullable
        private IcuCollationStrength strength;

        @Nullable
        private String variableTop;

        /**
         * API name: {@code index}
         */
        public final Builder index(@Nullable Boolean value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code null_value}
         */
        public final Builder nullValue(@Nullable String value) {
            this.nullValue = value;
            return this;
        }

        /**
         * API name: {@code alternate}
         */
        public final Builder alternate(@Nullable IcuCollationAlternate value) {
            this.alternate = value;
            return this;
        }

        /**
         * API name: {@code case_level}
         */
        public final Builder caseLevel(@Nullable Boolean value) {
            this.caseLevel = value;
            return this;
        }

        /**
         * API name: {@code case_first}
         */
        public final Builder caseFirst(@Nullable IcuCollationCaseFirst value) {
            this.caseFirst = value;
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
         * API name: {@code hiragana_quaternary_mode}
         */
        public final Builder hiraganaQuaternaryMode(@Nullable Boolean value) {
            this.hiraganaQuaternaryMode = value;
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
         * API name: {@code strength}
         */
        public final Builder strength(@Nullable IcuCollationStrength value) {
            this.strength = value;
            return this;
        }

        /**
         * API name: {@code variable_top}
         */
        public final Builder variableTop(@Nullable String value) {
            this.variableTop = value;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link IcuCollationKeywordProperty}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
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
        DocValuesPropertyBase.setupDocValuesPropertyBaseDeserializer(op);
        op.add(Builder::index, JsonpDeserializer.booleanDeserializer(), "index");
        op.add(Builder::nullValue, JsonpDeserializer.stringDeserializer(), "null_value");
        op.add(Builder::alternate, IcuCollationAlternate._DESERIALIZER, "alternate");
        op.add(Builder::caseLevel, JsonpDeserializer.booleanDeserializer(), "case_level");
        op.add(Builder::caseFirst, IcuCollationCaseFirst._DESERIALIZER, "case_first");
        op.add(Builder::decomposition, IcuCollationDecomposition._DESERIALIZER, "decomposition");
        op.add(Builder::hiraganaQuaternaryMode, JsonpDeserializer.booleanDeserializer(), "hiragana_quaternary_mode");
        op.add(Builder::numeric, JsonpDeserializer.booleanDeserializer(), "numeric");
        op.add(Builder::strength, IcuCollationStrength._DESERIALIZER, "strength");
        op.add(Builder::variableTop, JsonpDeserializer.stringDeserializer(), "variable_top");
    }
}
