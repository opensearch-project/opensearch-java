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

// typedef: _types.analysis.KuromojiTokenizer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class KuromojiTokenizer extends TokenizerBase
    implements
        TokenizerDefinitionVariant,
        ToCopyableBuilder<KuromojiTokenizer.Builder, KuromojiTokenizer> {

    @Nullable
    private final Boolean discardCompoundToken;

    @Nullable
    private final Boolean discardPunctuation;

    @Nonnull
    private final KuromojiTokenizationMode mode;

    @Nullable
    private final Integer nbestCost;

    @Nullable
    private final String nbestExamples;

    @Nullable
    private final String userDictionary;

    @Nonnull
    private final List<String> userDictionaryRules;

    // ---------------------------------------------------------------------------------------------

    private KuromojiTokenizer(Builder builder) {
        super(builder);
        this.discardCompoundToken = builder.discardCompoundToken;
        this.discardPunctuation = builder.discardPunctuation;
        this.mode = ApiTypeHelper.requireNonNull(builder.mode, this, "mode");
        this.nbestCost = builder.nbestCost;
        this.nbestExamples = builder.nbestExamples;
        this.userDictionary = builder.userDictionary;
        this.userDictionaryRules = ApiTypeHelper.unmodifiable(builder.userDictionaryRules);
    }

    public static KuromojiTokenizer of(Function<KuromojiTokenizer.Builder, ObjectBuilder<KuromojiTokenizer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenizerDefinition} variant kind.
     */
    @Override
    public TokenizerDefinition.Kind _tokenizerDefinitionKind() {
        return TokenizerDefinition.Kind.KuromojiTokenizer;
    }

    /**
     * API name: {@code discard_compound_token}
     */
    @Nullable
    public final Boolean discardCompoundToken() {
        return this.discardCompoundToken;
    }

    /**
     * API name: {@code discard_punctuation}
     */
    @Nullable
    public final Boolean discardPunctuation() {
        return this.discardPunctuation;
    }

    /**
     * Required - API name: {@code mode}
     */
    @Nonnull
    public final KuromojiTokenizationMode mode() {
        return this.mode;
    }

    /**
     * API name: {@code nbest_cost}
     */
    @Nullable
    public final Integer nbestCost() {
        return this.nbestCost;
    }

    /**
     * API name: {@code nbest_examples}
     */
    @Nullable
    public final String nbestExamples() {
        return this.nbestExamples;
    }

    /**
     * API name: {@code user_dictionary}
     */
    @Nullable
    public final String userDictionary() {
        return this.userDictionary;
    }

    /**
     * API name: {@code user_dictionary_rules}
     */
    @Nonnull
    public final List<String> userDictionaryRules() {
        return this.userDictionaryRules;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "kuromoji_tokenizer");
        super.serializeInternal(generator, mapper);
        if (this.discardCompoundToken != null) {
            generator.writeKey("discard_compound_token");
            generator.write(this.discardCompoundToken);
        }

        if (this.discardPunctuation != null) {
            generator.writeKey("discard_punctuation");
            generator.write(this.discardPunctuation);
        }

        generator.writeKey("mode");
        this.mode.serialize(generator, mapper);

        if (this.nbestCost != null) {
            generator.writeKey("nbest_cost");
            generator.write(this.nbestCost);
        }

        if (this.nbestExamples != null) {
            generator.writeKey("nbest_examples");
            generator.write(this.nbestExamples);
        }

        if (this.userDictionary != null) {
            generator.writeKey("user_dictionary");
            generator.write(this.userDictionary);
        }

        if (ApiTypeHelper.isDefined(this.userDictionaryRules)) {
            generator.writeKey("user_dictionary_rules");
            generator.writeStartArray();
            for (String item0 : this.userDictionaryRules) {
                generator.write(item0);
            }
            generator.writeEnd();
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
     * Builder for {@link KuromojiTokenizer}.
     */
    public static class Builder extends TokenizerBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, KuromojiTokenizer> {
        @Nullable
        private Boolean discardCompoundToken;
        @Nullable
        private Boolean discardPunctuation;
        private KuromojiTokenizationMode mode;
        @Nullable
        private Integer nbestCost;
        @Nullable
        private String nbestExamples;
        @Nullable
        private String userDictionary;
        @Nullable
        private List<String> userDictionaryRules;

        public Builder() {}

        private Builder(KuromojiTokenizer o) {
            super(o);
            this.discardCompoundToken = o.discardCompoundToken;
            this.discardPunctuation = o.discardPunctuation;
            this.mode = o.mode;
            this.nbestCost = o.nbestCost;
            this.nbestExamples = o.nbestExamples;
            this.userDictionary = o.userDictionary;
            this.userDictionaryRules = _listCopy(o.userDictionaryRules);
        }

        private Builder(Builder o) {
            super(o);
            this.discardCompoundToken = o.discardCompoundToken;
            this.discardPunctuation = o.discardPunctuation;
            this.mode = o.mode;
            this.nbestCost = o.nbestCost;
            this.nbestExamples = o.nbestExamples;
            this.userDictionary = o.userDictionary;
            this.userDictionaryRules = _listCopy(o.userDictionaryRules);
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
         * API name: {@code discard_compound_token}
         */
        @Nonnull
        public final Builder discardCompoundToken(@Nullable Boolean value) {
            this.discardCompoundToken = value;
            return this;
        }

        /**
         * API name: {@code discard_punctuation}
         */
        @Nonnull
        public final Builder discardPunctuation(@Nullable Boolean value) {
            this.discardPunctuation = value;
            return this;
        }

        /**
         * Required - API name: {@code mode}
         */
        @Nonnull
        public final Builder mode(KuromojiTokenizationMode value) {
            this.mode = value;
            return this;
        }

        /**
         * API name: {@code nbest_cost}
         */
        @Nonnull
        public final Builder nbestCost(@Nullable Integer value) {
            this.nbestCost = value;
            return this;
        }

        /**
         * API name: {@code nbest_examples}
         */
        @Nonnull
        public final Builder nbestExamples(@Nullable String value) {
            this.nbestExamples = value;
            return this;
        }

        /**
         * API name: {@code user_dictionary}
         */
        @Nonnull
        public final Builder userDictionary(@Nullable String value) {
            this.userDictionary = value;
            return this;
        }

        /**
         * API name: {@code user_dictionary_rules}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>userDictionaryRules</code>.
         * </p>
         */
        @Nonnull
        public final Builder userDictionaryRules(List<String> list) {
            this.userDictionaryRules = _listAddAll(this.userDictionaryRules, list);
            return this;
        }

        /**
         * API name: {@code user_dictionary_rules}
         *
         * <p>
         * Adds one or more values to <code>userDictionaryRules</code>.
         * </p>
         */
        @Nonnull
        public final Builder userDictionaryRules(String value, String... values) {
            this.userDictionaryRules = _listAdd(this.userDictionaryRules, value, values);
            return this;
        }

        /**
         * Builds a {@link KuromojiTokenizer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public KuromojiTokenizer build() {
            _checkSingleUse();

            return new KuromojiTokenizer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link KuromojiTokenizer}
     */
    public static final JsonpDeserializer<KuromojiTokenizer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        KuromojiTokenizer::setupKuromojiTokenizerDeserializer
    );

    protected static void setupKuromojiTokenizerDeserializer(ObjectDeserializer<KuromojiTokenizer.Builder> op) {
        setupTokenizerBaseDeserializer(op);
        op.add(Builder::discardCompoundToken, JsonpDeserializer.booleanDeserializer(), "discard_compound_token");
        op.add(Builder::discardPunctuation, JsonpDeserializer.booleanDeserializer(), "discard_punctuation");
        op.add(Builder::mode, KuromojiTokenizationMode._DESERIALIZER, "mode");
        op.add(Builder::nbestCost, JsonpDeserializer.integerDeserializer(), "nbest_cost");
        op.add(Builder::nbestExamples, JsonpDeserializer.stringDeserializer(), "nbest_examples");
        op.add(Builder::userDictionary, JsonpDeserializer.stringDeserializer(), "user_dictionary");
        op.add(
            Builder::userDictionaryRules,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "user_dictionary_rules"
        );

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.discardCompoundToken);
        result = 31 * result + Objects.hashCode(this.discardPunctuation);
        result = 31 * result + this.mode.hashCode();
        result = 31 * result + Objects.hashCode(this.nbestCost);
        result = 31 * result + Objects.hashCode(this.nbestExamples);
        result = 31 * result + Objects.hashCode(this.userDictionary);
        result = 31 * result + Objects.hashCode(this.userDictionaryRules);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        KuromojiTokenizer other = (KuromojiTokenizer) o;
        return Objects.equals(this.discardCompoundToken, other.discardCompoundToken)
            && Objects.equals(this.discardPunctuation, other.discardPunctuation)
            && this.mode.equals(other.mode)
            && Objects.equals(this.nbestCost, other.nbestCost)
            && Objects.equals(this.nbestExamples, other.nbestExamples)
            && Objects.equals(this.userDictionary, other.userDictionary)
            && Objects.equals(this.userDictionaryRules, other.userDictionaryRules);
    }
}
