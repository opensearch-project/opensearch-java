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

// typedef: _types.analysis.WordDelimiterTokenFilter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class WordDelimiterTokenFilter extends TokenFilterBase
    implements
        TokenFilterDefinitionVariant,
        ToCopyableBuilder<WordDelimiterTokenFilter.Builder, WordDelimiterTokenFilter> {

    @Nullable
    private final Boolean catenateAll;

    @Nullable
    private final Boolean catenateNumbers;

    @Nullable
    private final Boolean catenateWords;

    @Nullable
    private final Boolean generateNumberParts;

    @Nullable
    private final Boolean generateWordParts;

    @Nullable
    private final Boolean preserveOriginal;

    @Nonnull
    private final List<String> protectedWords;

    @Nullable
    private final String protectedWordsPath;

    @Nullable
    private final Boolean splitOnCaseChange;

    @Nullable
    private final Boolean splitOnNumerics;

    @Nullable
    private final Boolean stemEnglishPossessive;

    @Nonnull
    private final List<String> typeTable;

    @Nullable
    private final String typeTablePath;

    // ---------------------------------------------------------------------------------------------

    private WordDelimiterTokenFilter(Builder builder) {
        super(builder);
        this.catenateAll = builder.catenateAll;
        this.catenateNumbers = builder.catenateNumbers;
        this.catenateWords = builder.catenateWords;
        this.generateNumberParts = builder.generateNumberParts;
        this.generateWordParts = builder.generateWordParts;
        this.preserveOriginal = builder.preserveOriginal;
        this.protectedWords = ApiTypeHelper.unmodifiable(builder.protectedWords);
        this.protectedWordsPath = builder.protectedWordsPath;
        this.splitOnCaseChange = builder.splitOnCaseChange;
        this.splitOnNumerics = builder.splitOnNumerics;
        this.stemEnglishPossessive = builder.stemEnglishPossessive;
        this.typeTable = ApiTypeHelper.unmodifiable(builder.typeTable);
        this.typeTablePath = builder.typeTablePath;
    }

    public static WordDelimiterTokenFilter of(Function<WordDelimiterTokenFilter.Builder, ObjectBuilder<WordDelimiterTokenFilter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.WordDelimiter;
    }

    /**
     * API name: {@code catenate_all}
     */
    @Nullable
    public final Boolean catenateAll() {
        return this.catenateAll;
    }

    /**
     * API name: {@code catenate_numbers}
     */
    @Nullable
    public final Boolean catenateNumbers() {
        return this.catenateNumbers;
    }

    /**
     * API name: {@code catenate_words}
     */
    @Nullable
    public final Boolean catenateWords() {
        return this.catenateWords;
    }

    /**
     * API name: {@code generate_number_parts}
     */
    @Nullable
    public final Boolean generateNumberParts() {
        return this.generateNumberParts;
    }

    /**
     * API name: {@code generate_word_parts}
     */
    @Nullable
    public final Boolean generateWordParts() {
        return this.generateWordParts;
    }

    /**
     * API name: {@code preserve_original}
     */
    @Nullable
    public final Boolean preserveOriginal() {
        return this.preserveOriginal;
    }

    /**
     * API name: {@code protected_words}
     */
    @Nonnull
    public final List<String> protectedWords() {
        return this.protectedWords;
    }

    /**
     * API name: {@code protected_words_path}
     */
    @Nullable
    public final String protectedWordsPath() {
        return this.protectedWordsPath;
    }

    /**
     * API name: {@code split_on_case_change}
     */
    @Nullable
    public final Boolean splitOnCaseChange() {
        return this.splitOnCaseChange;
    }

    /**
     * API name: {@code split_on_numerics}
     */
    @Nullable
    public final Boolean splitOnNumerics() {
        return this.splitOnNumerics;
    }

    /**
     * API name: {@code stem_english_possessive}
     */
    @Nullable
    public final Boolean stemEnglishPossessive() {
        return this.stemEnglishPossessive;
    }

    /**
     * API name: {@code type_table}
     */
    @Nonnull
    public final List<String> typeTable() {
        return this.typeTable;
    }

    /**
     * API name: {@code type_table_path}
     */
    @Nullable
    public final String typeTablePath() {
        return this.typeTablePath;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "word_delimiter");
        super.serializeInternal(generator, mapper);
        if (this.catenateAll != null) {
            generator.writeKey("catenate_all");
            generator.write(this.catenateAll);
        }

        if (this.catenateNumbers != null) {
            generator.writeKey("catenate_numbers");
            generator.write(this.catenateNumbers);
        }

        if (this.catenateWords != null) {
            generator.writeKey("catenate_words");
            generator.write(this.catenateWords);
        }

        if (this.generateNumberParts != null) {
            generator.writeKey("generate_number_parts");
            generator.write(this.generateNumberParts);
        }

        if (this.generateWordParts != null) {
            generator.writeKey("generate_word_parts");
            generator.write(this.generateWordParts);
        }

        if (this.preserveOriginal != null) {
            generator.writeKey("preserve_original");
            generator.write(this.preserveOriginal);
        }

        if (ApiTypeHelper.isDefined(this.protectedWords)) {
            generator.writeKey("protected_words");
            generator.writeStartArray();
            for (String item0 : this.protectedWords) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.protectedWordsPath != null) {
            generator.writeKey("protected_words_path");
            generator.write(this.protectedWordsPath);
        }

        if (this.splitOnCaseChange != null) {
            generator.writeKey("split_on_case_change");
            generator.write(this.splitOnCaseChange);
        }

        if (this.splitOnNumerics != null) {
            generator.writeKey("split_on_numerics");
            generator.write(this.splitOnNumerics);
        }

        if (this.stemEnglishPossessive != null) {
            generator.writeKey("stem_english_possessive");
            generator.write(this.stemEnglishPossessive);
        }

        if (ApiTypeHelper.isDefined(this.typeTable)) {
            generator.writeKey("type_table");
            generator.writeStartArray();
            for (String item0 : this.typeTable) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.typeTablePath != null) {
            generator.writeKey("type_table_path");
            generator.write(this.typeTablePath);
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
     * Builder for {@link WordDelimiterTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, WordDelimiterTokenFilter> {
        @Nullable
        private Boolean catenateAll;
        @Nullable
        private Boolean catenateNumbers;
        @Nullable
        private Boolean catenateWords;
        @Nullable
        private Boolean generateNumberParts;
        @Nullable
        private Boolean generateWordParts;
        @Nullable
        private Boolean preserveOriginal;
        @Nullable
        private List<String> protectedWords;
        @Nullable
        private String protectedWordsPath;
        @Nullable
        private Boolean splitOnCaseChange;
        @Nullable
        private Boolean splitOnNumerics;
        @Nullable
        private Boolean stemEnglishPossessive;
        @Nullable
        private List<String> typeTable;
        @Nullable
        private String typeTablePath;

        public Builder() {}

        private Builder(WordDelimiterTokenFilter o) {
            super(o);
            this.catenateAll = o.catenateAll;
            this.catenateNumbers = o.catenateNumbers;
            this.catenateWords = o.catenateWords;
            this.generateNumberParts = o.generateNumberParts;
            this.generateWordParts = o.generateWordParts;
            this.preserveOriginal = o.preserveOriginal;
            this.protectedWords = _listCopy(o.protectedWords);
            this.protectedWordsPath = o.protectedWordsPath;
            this.splitOnCaseChange = o.splitOnCaseChange;
            this.splitOnNumerics = o.splitOnNumerics;
            this.stemEnglishPossessive = o.stemEnglishPossessive;
            this.typeTable = _listCopy(o.typeTable);
            this.typeTablePath = o.typeTablePath;
        }

        private Builder(Builder o) {
            super(o);
            this.catenateAll = o.catenateAll;
            this.catenateNumbers = o.catenateNumbers;
            this.catenateWords = o.catenateWords;
            this.generateNumberParts = o.generateNumberParts;
            this.generateWordParts = o.generateWordParts;
            this.preserveOriginal = o.preserveOriginal;
            this.protectedWords = _listCopy(o.protectedWords);
            this.protectedWordsPath = o.protectedWordsPath;
            this.splitOnCaseChange = o.splitOnCaseChange;
            this.splitOnNumerics = o.splitOnNumerics;
            this.stemEnglishPossessive = o.stemEnglishPossessive;
            this.typeTable = _listCopy(o.typeTable);
            this.typeTablePath = o.typeTablePath;
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
         * API name: {@code catenate_all}
         */
        @Nonnull
        public final Builder catenateAll(@Nullable Boolean value) {
            this.catenateAll = value;
            return this;
        }

        /**
         * API name: {@code catenate_numbers}
         */
        @Nonnull
        public final Builder catenateNumbers(@Nullable Boolean value) {
            this.catenateNumbers = value;
            return this;
        }

        /**
         * API name: {@code catenate_words}
         */
        @Nonnull
        public final Builder catenateWords(@Nullable Boolean value) {
            this.catenateWords = value;
            return this;
        }

        /**
         * API name: {@code generate_number_parts}
         */
        @Nonnull
        public final Builder generateNumberParts(@Nullable Boolean value) {
            this.generateNumberParts = value;
            return this;
        }

        /**
         * API name: {@code generate_word_parts}
         */
        @Nonnull
        public final Builder generateWordParts(@Nullable Boolean value) {
            this.generateWordParts = value;
            return this;
        }

        /**
         * API name: {@code preserve_original}
         */
        @Nonnull
        public final Builder preserveOriginal(@Nullable Boolean value) {
            this.preserveOriginal = value;
            return this;
        }

        /**
         * API name: {@code protected_words}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>protectedWords</code>.
         * </p>
         */
        @Nonnull
        public final Builder protectedWords(List<String> list) {
            this.protectedWords = _listAddAll(this.protectedWords, list);
            return this;
        }

        /**
         * API name: {@code protected_words}
         *
         * <p>
         * Adds one or more values to <code>protectedWords</code>.
         * </p>
         */
        @Nonnull
        public final Builder protectedWords(String value, String... values) {
            this.protectedWords = _listAdd(this.protectedWords, value, values);
            return this;
        }

        /**
         * API name: {@code protected_words_path}
         */
        @Nonnull
        public final Builder protectedWordsPath(@Nullable String value) {
            this.protectedWordsPath = value;
            return this;
        }

        /**
         * API name: {@code split_on_case_change}
         */
        @Nonnull
        public final Builder splitOnCaseChange(@Nullable Boolean value) {
            this.splitOnCaseChange = value;
            return this;
        }

        /**
         * API name: {@code split_on_numerics}
         */
        @Nonnull
        public final Builder splitOnNumerics(@Nullable Boolean value) {
            this.splitOnNumerics = value;
            return this;
        }

        /**
         * API name: {@code stem_english_possessive}
         */
        @Nonnull
        public final Builder stemEnglishPossessive(@Nullable Boolean value) {
            this.stemEnglishPossessive = value;
            return this;
        }

        /**
         * API name: {@code type_table}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>typeTable</code>.
         * </p>
         */
        @Nonnull
        public final Builder typeTable(List<String> list) {
            this.typeTable = _listAddAll(this.typeTable, list);
            return this;
        }

        /**
         * API name: {@code type_table}
         *
         * <p>
         * Adds one or more values to <code>typeTable</code>.
         * </p>
         */
        @Nonnull
        public final Builder typeTable(String value, String... values) {
            this.typeTable = _listAdd(this.typeTable, value, values);
            return this;
        }

        /**
         * API name: {@code type_table_path}
         */
        @Nonnull
        public final Builder typeTablePath(@Nullable String value) {
            this.typeTablePath = value;
            return this;
        }

        /**
         * Builds a {@link WordDelimiterTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public WordDelimiterTokenFilter build() {
            _checkSingleUse();

            return new WordDelimiterTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link WordDelimiterTokenFilter}
     */
    public static final JsonpDeserializer<WordDelimiterTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        WordDelimiterTokenFilter::setupWordDelimiterTokenFilterDeserializer
    );

    protected static void setupWordDelimiterTokenFilterDeserializer(ObjectDeserializer<WordDelimiterTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::catenateAll, JsonpDeserializer.booleanDeserializer(), "catenate_all");
        op.add(Builder::catenateNumbers, JsonpDeserializer.booleanDeserializer(), "catenate_numbers");
        op.add(Builder::catenateWords, JsonpDeserializer.booleanDeserializer(), "catenate_words");
        op.add(Builder::generateNumberParts, JsonpDeserializer.booleanDeserializer(), "generate_number_parts");
        op.add(Builder::generateWordParts, JsonpDeserializer.booleanDeserializer(), "generate_word_parts");
        op.add(Builder::preserveOriginal, JsonpDeserializer.booleanDeserializer(), "preserve_original");
        op.add(Builder::protectedWords, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "protected_words");
        op.add(Builder::protectedWordsPath, JsonpDeserializer.stringDeserializer(), "protected_words_path");
        op.add(Builder::splitOnCaseChange, JsonpDeserializer.booleanDeserializer(), "split_on_case_change");
        op.add(Builder::splitOnNumerics, JsonpDeserializer.booleanDeserializer(), "split_on_numerics");
        op.add(Builder::stemEnglishPossessive, JsonpDeserializer.booleanDeserializer(), "stem_english_possessive");
        op.add(Builder::typeTable, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "type_table");
        op.add(Builder::typeTablePath, JsonpDeserializer.stringDeserializer(), "type_table_path");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.catenateAll);
        result = 31 * result + Objects.hashCode(this.catenateNumbers);
        result = 31 * result + Objects.hashCode(this.catenateWords);
        result = 31 * result + Objects.hashCode(this.generateNumberParts);
        result = 31 * result + Objects.hashCode(this.generateWordParts);
        result = 31 * result + Objects.hashCode(this.preserveOriginal);
        result = 31 * result + Objects.hashCode(this.protectedWords);
        result = 31 * result + Objects.hashCode(this.protectedWordsPath);
        result = 31 * result + Objects.hashCode(this.splitOnCaseChange);
        result = 31 * result + Objects.hashCode(this.splitOnNumerics);
        result = 31 * result + Objects.hashCode(this.stemEnglishPossessive);
        result = 31 * result + Objects.hashCode(this.typeTable);
        result = 31 * result + Objects.hashCode(this.typeTablePath);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        WordDelimiterTokenFilter other = (WordDelimiterTokenFilter) o;
        return Objects.equals(this.catenateAll, other.catenateAll)
            && Objects.equals(this.catenateNumbers, other.catenateNumbers)
            && Objects.equals(this.catenateWords, other.catenateWords)
            && Objects.equals(this.generateNumberParts, other.generateNumberParts)
            && Objects.equals(this.generateWordParts, other.generateWordParts)
            && Objects.equals(this.preserveOriginal, other.preserveOriginal)
            && Objects.equals(this.protectedWords, other.protectedWords)
            && Objects.equals(this.protectedWordsPath, other.protectedWordsPath)
            && Objects.equals(this.splitOnCaseChange, other.splitOnCaseChange)
            && Objects.equals(this.splitOnNumerics, other.splitOnNumerics)
            && Objects.equals(this.stemEnglishPossessive, other.stemEnglishPossessive)
            && Objects.equals(this.typeTable, other.typeTable)
            && Objects.equals(this.typeTablePath, other.typeTablePath);
    }
}
