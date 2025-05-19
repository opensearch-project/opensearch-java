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
import java.util.List;
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

// typedef: _types.analysis.PhoneticTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PhoneticTokenFilter extends TokenFilterBase
    implements
        TokenFilterDefinitionVariant,
        ToCopyableBuilder<PhoneticTokenFilter.Builder, PhoneticTokenFilter> {

    @Nonnull
    private final PhoneticEncoder encoder;

    @Nonnull
    private final List<PhoneticLanguage> languageset;

    @Nullable
    private final Integer maxCodeLen;

    @Nonnull
    private final PhoneticNameType nameType;

    @Nullable
    private final Boolean replace;

    @Nonnull
    private final PhoneticRuleType ruleType;

    // ---------------------------------------------------------------------------------------------

    private PhoneticTokenFilter(Builder builder) {
        super(builder);
        this.encoder = ApiTypeHelper.requireNonNull(builder.encoder, this, "encoder");
        this.languageset = ApiTypeHelper.unmodifiableRequired(builder.languageset, this, "languageset");
        this.maxCodeLen = builder.maxCodeLen;
        this.nameType = ApiTypeHelper.requireNonNull(builder.nameType, this, "nameType");
        this.replace = builder.replace;
        this.ruleType = ApiTypeHelper.requireNonNull(builder.ruleType, this, "ruleType");
    }

    public static PhoneticTokenFilter of(Function<PhoneticTokenFilter.Builder, ObjectBuilder<PhoneticTokenFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.Phonetic;
    }

    /**
     * Required - API name: {@code encoder}
     */
    @Nonnull
    public final PhoneticEncoder encoder() {
        return this.encoder;
    }

    /**
     * Required - API name: {@code languageset}
     */
    @Nonnull
    public final List<PhoneticLanguage> languageset() {
        return this.languageset;
    }

    /**
     * API name: {@code max_code_len}
     */
    @Nullable
    public final Integer maxCodeLen() {
        return this.maxCodeLen;
    }

    /**
     * Required - API name: {@code name_type}
     */
    @Nonnull
    public final PhoneticNameType nameType() {
        return this.nameType;
    }

    /**
     * API name: {@code replace}
     */
    @Nullable
    public final Boolean replace() {
        return this.replace;
    }

    /**
     * Required - API name: {@code rule_type}
     */
    @Nonnull
    public final PhoneticRuleType ruleType() {
        return this.ruleType;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "phonetic");
        super.serializeInternal(generator, mapper);
        generator.writeKey("encoder");
        this.encoder.serialize(generator, mapper);

        generator.writeKey("languageset");
        generator.writeStartArray();
        for (PhoneticLanguage item0 : this.languageset) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        if (this.maxCodeLen != null) {
            generator.writeKey("max_code_len");
            generator.write(this.maxCodeLen);
        }

        generator.writeKey("name_type");
        this.nameType.serialize(generator, mapper);

        if (this.replace != null) {
            generator.writeKey("replace");
            generator.write(this.replace);
        }

        generator.writeKey("rule_type");
        this.ruleType.serialize(generator, mapper);
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
     * Builder for {@link PhoneticTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PhoneticTokenFilter> {
        private PhoneticEncoder encoder;
        private List<PhoneticLanguage> languageset;
        @Nullable
        private Integer maxCodeLen;
        private PhoneticNameType nameType;
        @Nullable
        private Boolean replace;
        private PhoneticRuleType ruleType;

        public Builder() {}

        private Builder(PhoneticTokenFilter o) {
            super(o);
            this.encoder = o.encoder;
            this.languageset = _listCopy(o.languageset);
            this.maxCodeLen = o.maxCodeLen;
            this.nameType = o.nameType;
            this.replace = o.replace;
            this.ruleType = o.ruleType;
        }

        private Builder(Builder o) {
            super(o);
            this.encoder = o.encoder;
            this.languageset = _listCopy(o.languageset);
            this.maxCodeLen = o.maxCodeLen;
            this.nameType = o.nameType;
            this.replace = o.replace;
            this.ruleType = o.ruleType;
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
         * Required - API name: {@code encoder}
         */
        @Nonnull
        public final Builder encoder(PhoneticEncoder value) {
            this.encoder = value;
            return this;
        }

        /**
         * Required - API name: {@code languageset}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>languageset</code>.
         * </p>
         */
        @Nonnull
        public final Builder languageset(List<PhoneticLanguage> list) {
            this.languageset = _listAddAll(this.languageset, list);
            return this;
        }

        /**
         * Required - API name: {@code languageset}
         *
         * <p>
         * Adds one or more values to <code>languageset</code>.
         * </p>
         */
        @Nonnull
        public final Builder languageset(PhoneticLanguage value, PhoneticLanguage... values) {
            this.languageset = _listAdd(this.languageset, value, values);
            return this;
        }

        /**
         * API name: {@code max_code_len}
         */
        @Nonnull
        public final Builder maxCodeLen(@Nullable Integer value) {
            this.maxCodeLen = value;
            return this;
        }

        /**
         * Required - API name: {@code name_type}
         */
        @Nonnull
        public final Builder nameType(PhoneticNameType value) {
            this.nameType = value;
            return this;
        }

        /**
         * API name: {@code replace}
         */
        @Nonnull
        public final Builder replace(@Nullable Boolean value) {
            this.replace = value;
            return this;
        }

        /**
         * Required - API name: {@code rule_type}
         */
        @Nonnull
        public final Builder ruleType(PhoneticRuleType value) {
            this.ruleType = value;
            return this;
        }

        /**
         * Builds a {@link PhoneticTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PhoneticTokenFilter build() {
            _checkSingleUse();

            return new PhoneticTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PhoneticTokenFilter}
     */
    public static final JsonpDeserializer<PhoneticTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PhoneticTokenFilter::setupPhoneticTokenFilterDeserializer
    );

    protected static void setupPhoneticTokenFilterDeserializer(ObjectDeserializer<PhoneticTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::encoder, PhoneticEncoder._DESERIALIZER, "encoder");
        op.add(Builder::languageset, JsonpDeserializer.arrayDeserializer(PhoneticLanguage._DESERIALIZER), "languageset");
        op.add(Builder::maxCodeLen, JsonpDeserializer.integerDeserializer(), "max_code_len");
        op.add(Builder::nameType, PhoneticNameType._DESERIALIZER, "name_type");
        op.add(Builder::replace, JsonpDeserializer.booleanDeserializer(), "replace");
        op.add(Builder::ruleType, PhoneticRuleType._DESERIALIZER, "rule_type");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.encoder.hashCode();
        result = 31 * result + this.languageset.hashCode();
        result = 31 * result + Objects.hashCode(this.maxCodeLen);
        result = 31 * result + this.nameType.hashCode();
        result = 31 * result + Objects.hashCode(this.replace);
        result = 31 * result + this.ruleType.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PhoneticTokenFilter other = (PhoneticTokenFilter) o;
        return this.encoder.equals(other.encoder)
            && this.languageset.equals(other.languageset)
            && Objects.equals(this.maxCodeLen, other.maxCodeLen)
            && this.nameType.equals(other.nameType)
            && Objects.equals(this.replace, other.replace)
            && this.ruleType.equals(other.ruleType);
    }
}
