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
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;

// typedef: _types.analysis.CompoundWordTokenFilterBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class CompoundWordTokenFilterBase extends TokenFilterBase {

    @Nullable
    private final String hyphenationPatternsPath;

    @Nullable
    private final Integer maxSubwordSize;

    @Nullable
    private final Integer minSubwordSize;

    @Nullable
    private final Integer minWordSize;

    @Nullable
    private final Boolean onlyLongestMatch;

    @Nonnull
    private final List<String> wordList;

    @Nullable
    private final String wordListPath;

    // ---------------------------------------------------------------------------------------------

    protected CompoundWordTokenFilterBase(AbstractBuilder<?> builder) {
        super(builder);
        this.hyphenationPatternsPath = builder.hyphenationPatternsPath;
        this.maxSubwordSize = builder.maxSubwordSize;
        this.minSubwordSize = builder.minSubwordSize;
        this.minWordSize = builder.minWordSize;
        this.onlyLongestMatch = builder.onlyLongestMatch;
        this.wordList = ApiTypeHelper.unmodifiable(builder.wordList);
        this.wordListPath = builder.wordListPath;
    }

    /**
     * API name: {@code hyphenation_patterns_path}
     */
    @Nullable
    public final String hyphenationPatternsPath() {
        return this.hyphenationPatternsPath;
    }

    /**
     * API name: {@code max_subword_size}
     */
    @Nullable
    public final Integer maxSubwordSize() {
        return this.maxSubwordSize;
    }

    /**
     * API name: {@code min_subword_size}
     */
    @Nullable
    public final Integer minSubwordSize() {
        return this.minSubwordSize;
    }

    /**
     * API name: {@code min_word_size}
     */
    @Nullable
    public final Integer minWordSize() {
        return this.minWordSize;
    }

    /**
     * API name: {@code only_longest_match}
     */
    @Nullable
    public final Boolean onlyLongestMatch() {
        return this.onlyLongestMatch;
    }

    /**
     * API name: {@code word_list}
     */
    @Nonnull
    public final List<String> wordList() {
        return this.wordList;
    }

    /**
     * API name: {@code word_list_path}
     */
    @Nullable
    public final String wordListPath() {
        return this.wordListPath;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.hyphenationPatternsPath != null) {
            generator.writeKey("hyphenation_patterns_path");
            generator.write(this.hyphenationPatternsPath);
        }

        if (this.maxSubwordSize != null) {
            generator.writeKey("max_subword_size");
            generator.write(this.maxSubwordSize);
        }

        if (this.minSubwordSize != null) {
            generator.writeKey("min_subword_size");
            generator.write(this.minSubwordSize);
        }

        if (this.minWordSize != null) {
            generator.writeKey("min_word_size");
            generator.write(this.minWordSize);
        }

        if (this.onlyLongestMatch != null) {
            generator.writeKey("only_longest_match");
            generator.write(this.onlyLongestMatch);
        }

        if (ApiTypeHelper.isDefined(this.wordList)) {
            generator.writeKey("word_list");
            generator.writeStartArray();
            for (String item0 : this.wordList) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.wordListPath != null) {
            generator.writeKey("word_list_path");
            generator.write(this.wordListPath);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends TokenFilterBase.AbstractBuilder<
        BuilderT> {
        @Nullable
        private String hyphenationPatternsPath;
        @Nullable
        private Integer maxSubwordSize;
        @Nullable
        private Integer minSubwordSize;
        @Nullable
        private Integer minWordSize;
        @Nullable
        private Boolean onlyLongestMatch;
        @Nullable
        private List<String> wordList;
        @Nullable
        private String wordListPath;

        protected AbstractBuilder() {}

        protected AbstractBuilder(CompoundWordTokenFilterBase o) {
            super(o);
            this.hyphenationPatternsPath = o.hyphenationPatternsPath;
            this.maxSubwordSize = o.maxSubwordSize;
            this.minSubwordSize = o.minSubwordSize;
            this.minWordSize = o.minWordSize;
            this.onlyLongestMatch = o.onlyLongestMatch;
            this.wordList = _listCopy(o.wordList);
            this.wordListPath = o.wordListPath;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            super(o);
            this.hyphenationPatternsPath = o.hyphenationPatternsPath;
            this.maxSubwordSize = o.maxSubwordSize;
            this.minSubwordSize = o.minSubwordSize;
            this.minWordSize = o.minWordSize;
            this.onlyLongestMatch = o.onlyLongestMatch;
            this.wordList = _listCopy(o.wordList);
            this.wordListPath = o.wordListPath;
        }

        /**
         * API name: {@code hyphenation_patterns_path}
         */
        @Nonnull
        public final BuilderT hyphenationPatternsPath(@Nullable String value) {
            this.hyphenationPatternsPath = value;
            return self();
        }

        /**
         * API name: {@code max_subword_size}
         */
        @Nonnull
        public final BuilderT maxSubwordSize(@Nullable Integer value) {
            this.maxSubwordSize = value;
            return self();
        }

        /**
         * API name: {@code min_subword_size}
         */
        @Nonnull
        public final BuilderT minSubwordSize(@Nullable Integer value) {
            this.minSubwordSize = value;
            return self();
        }

        /**
         * API name: {@code min_word_size}
         */
        @Nonnull
        public final BuilderT minWordSize(@Nullable Integer value) {
            this.minWordSize = value;
            return self();
        }

        /**
         * API name: {@code only_longest_match}
         */
        @Nonnull
        public final BuilderT onlyLongestMatch(@Nullable Boolean value) {
            this.onlyLongestMatch = value;
            return self();
        }

        /**
         * API name: {@code word_list}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>wordList</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT wordList(List<String> list) {
            this.wordList = _listAddAll(this.wordList, list);
            return self();
        }

        /**
         * API name: {@code word_list}
         *
         * <p>
         * Adds one or more values to <code>wordList</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT wordList(String value, String... values) {
            this.wordList = _listAdd(this.wordList, value, values);
            return self();
        }

        /**
         * API name: {@code word_list_path}
         */
        @Nonnull
        public final BuilderT wordListPath(@Nullable String value) {
            this.wordListPath = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupCompoundWordTokenFilterBaseDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        setupTokenFilterBaseDeserializer(op);
        op.add(AbstractBuilder::hyphenationPatternsPath, JsonpDeserializer.stringDeserializer(), "hyphenation_patterns_path");
        op.add(AbstractBuilder::maxSubwordSize, JsonpDeserializer.integerDeserializer(), "max_subword_size");
        op.add(AbstractBuilder::minSubwordSize, JsonpDeserializer.integerDeserializer(), "min_subword_size");
        op.add(AbstractBuilder::minWordSize, JsonpDeserializer.integerDeserializer(), "min_word_size");
        op.add(AbstractBuilder::onlyLongestMatch, JsonpDeserializer.booleanDeserializer(), "only_longest_match");
        op.add(AbstractBuilder::wordList, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "word_list");
        op.add(AbstractBuilder::wordListPath, JsonpDeserializer.stringDeserializer(), "word_list_path");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.hyphenationPatternsPath);
        result = 31 * result + Objects.hashCode(this.maxSubwordSize);
        result = 31 * result + Objects.hashCode(this.minSubwordSize);
        result = 31 * result + Objects.hashCode(this.minWordSize);
        result = 31 * result + Objects.hashCode(this.onlyLongestMatch);
        result = 31 * result + Objects.hashCode(this.wordList);
        result = 31 * result + Objects.hashCode(this.wordListPath);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CompoundWordTokenFilterBase other = (CompoundWordTokenFilterBase) o;
        return Objects.equals(this.hyphenationPatternsPath, other.hyphenationPatternsPath)
            && Objects.equals(this.maxSubwordSize, other.maxSubwordSize)
            && Objects.equals(this.minSubwordSize, other.minSubwordSize)
            && Objects.equals(this.minWordSize, other.minWordSize)
            && Objects.equals(this.onlyLongestMatch, other.onlyLongestMatch)
            && Objects.equals(this.wordList, other.wordList)
            && Objects.equals(this.wordListPath, other.wordListPath);
    }
}
