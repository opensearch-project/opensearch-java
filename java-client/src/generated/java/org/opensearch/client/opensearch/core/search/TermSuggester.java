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

package org.opensearch.client.opensearch.core.search;

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
import org.opensearch.client.opensearch._types.SuggestMode;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.search.TermSuggester

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TermSuggester extends SuggesterBase implements FieldSuggesterVariant, ToCopyableBuilder<TermSuggester.Builder, TermSuggester> {

    @Nullable
    private final Boolean lowercaseTerms;

    @Nullable
    private final Integer maxEdits;

    @Nullable
    private final Integer maxInspections;

    @Nullable
    private final Float maxTermFreq;

    @Nullable
    private final Float minDocFreq;

    @Nullable
    private final Integer minWordLength;

    @Nullable
    private final Integer prefixLength;

    @Nullable
    private final Integer shardSize;

    @Nullable
    private final SuggestSort sort;

    @Nullable
    private final StringDistance stringDistance;

    @Nullable
    private final SuggestMode suggestMode;

    @Nullable
    private final String text;

    // ---------------------------------------------------------------------------------------------

    private TermSuggester(Builder builder) {
        super(builder);
        this.lowercaseTerms = builder.lowercaseTerms;
        this.maxEdits = builder.maxEdits;
        this.maxInspections = builder.maxInspections;
        this.maxTermFreq = builder.maxTermFreq;
        this.minDocFreq = builder.minDocFreq;
        this.minWordLength = builder.minWordLength;
        this.prefixLength = builder.prefixLength;
        this.shardSize = builder.shardSize;
        this.sort = builder.sort;
        this.stringDistance = builder.stringDistance;
        this.suggestMode = builder.suggestMode;
        this.text = builder.text;
    }

    public static TermSuggester of(Function<TermSuggester.Builder, ObjectBuilder<TermSuggester>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link FieldSuggester} variant kind.
     */
    @Override
    public FieldSuggester.Kind _fieldSuggesterKind() {
        return FieldSuggester.Kind.Term;
    }

    /**
     * API name: {@code lowercase_terms}
     */
    @Nullable
    public final Boolean lowercaseTerms() {
        return this.lowercaseTerms;
    }

    /**
     * API name: {@code max_edits}
     */
    @Nullable
    public final Integer maxEdits() {
        return this.maxEdits;
    }

    /**
     * API name: {@code max_inspections}
     */
    @Nullable
    public final Integer maxInspections() {
        return this.maxInspections;
    }

    /**
     * API name: {@code max_term_freq}
     */
    @Nullable
    public final Float maxTermFreq() {
        return this.maxTermFreq;
    }

    /**
     * API name: {@code min_doc_freq}
     */
    @Nullable
    public final Float minDocFreq() {
        return this.minDocFreq;
    }

    /**
     * API name: {@code min_word_length}
     */
    @Nullable
    public final Integer minWordLength() {
        return this.minWordLength;
    }

    /**
     * API name: {@code prefix_length}
     */
    @Nullable
    public final Integer prefixLength() {
        return this.prefixLength;
    }

    /**
     * API name: {@code shard_size}
     */
    @Nullable
    public final Integer shardSize() {
        return this.shardSize;
    }

    /**
     * API name: {@code sort}
     */
    @Nullable
    public final SuggestSort sort() {
        return this.sort;
    }

    /**
     * API name: {@code string_distance}
     */
    @Nullable
    public final StringDistance stringDistance() {
        return this.stringDistance;
    }

    /**
     * API name: {@code suggest_mode}
     */
    @Nullable
    public final SuggestMode suggestMode() {
        return this.suggestMode;
    }

    /**
     * API name: {@code text}
     */
    @Nullable
    public final String text() {
        return this.text;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.lowercaseTerms != null) {
            generator.writeKey("lowercase_terms");
            generator.write(this.lowercaseTerms);
        }

        if (this.maxEdits != null) {
            generator.writeKey("max_edits");
            generator.write(this.maxEdits);
        }

        if (this.maxInspections != null) {
            generator.writeKey("max_inspections");
            generator.write(this.maxInspections);
        }

        if (this.maxTermFreq != null) {
            generator.writeKey("max_term_freq");
            generator.write(this.maxTermFreq);
        }

        if (this.minDocFreq != null) {
            generator.writeKey("min_doc_freq");
            generator.write(this.minDocFreq);
        }

        if (this.minWordLength != null) {
            generator.writeKey("min_word_length");
            generator.write(this.minWordLength);
        }

        if (this.prefixLength != null) {
            generator.writeKey("prefix_length");
            generator.write(this.prefixLength);
        }

        if (this.shardSize != null) {
            generator.writeKey("shard_size");
            generator.write(this.shardSize);
        }

        if (this.sort != null) {
            generator.writeKey("sort");
            this.sort.serialize(generator, mapper);
        }

        if (this.stringDistance != null) {
            generator.writeKey("string_distance");
            this.stringDistance.serialize(generator, mapper);
        }

        if (this.suggestMode != null) {
            generator.writeKey("suggest_mode");
            this.suggestMode.serialize(generator, mapper);
        }

        if (this.text != null) {
            generator.writeKey("text");
            generator.write(this.text);
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
     * Builder for {@link TermSuggester}.
     */
    public static class Builder extends SuggesterBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, TermSuggester> {
        @Nullable
        private Boolean lowercaseTerms;
        @Nullable
        private Integer maxEdits;
        @Nullable
        private Integer maxInspections;
        @Nullable
        private Float maxTermFreq;
        @Nullable
        private Float minDocFreq;
        @Nullable
        private Integer minWordLength;
        @Nullable
        private Integer prefixLength;
        @Nullable
        private Integer shardSize;
        @Nullable
        private SuggestSort sort;
        @Nullable
        private StringDistance stringDistance;
        @Nullable
        private SuggestMode suggestMode;
        @Nullable
        private String text;

        public Builder() {}

        private Builder(TermSuggester o) {
            super(o);
            this.lowercaseTerms = o.lowercaseTerms;
            this.maxEdits = o.maxEdits;
            this.maxInspections = o.maxInspections;
            this.maxTermFreq = o.maxTermFreq;
            this.minDocFreq = o.minDocFreq;
            this.minWordLength = o.minWordLength;
            this.prefixLength = o.prefixLength;
            this.shardSize = o.shardSize;
            this.sort = o.sort;
            this.stringDistance = o.stringDistance;
            this.suggestMode = o.suggestMode;
            this.text = o.text;
        }

        private Builder(Builder o) {
            super(o);
            this.lowercaseTerms = o.lowercaseTerms;
            this.maxEdits = o.maxEdits;
            this.maxInspections = o.maxInspections;
            this.maxTermFreq = o.maxTermFreq;
            this.minDocFreq = o.minDocFreq;
            this.minWordLength = o.minWordLength;
            this.prefixLength = o.prefixLength;
            this.shardSize = o.shardSize;
            this.sort = o.sort;
            this.stringDistance = o.stringDistance;
            this.suggestMode = o.suggestMode;
            this.text = o.text;
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
         * API name: {@code lowercase_terms}
         */
        @Nonnull
        public final Builder lowercaseTerms(@Nullable Boolean value) {
            this.lowercaseTerms = value;
            return this;
        }

        /**
         * API name: {@code max_edits}
         */
        @Nonnull
        public final Builder maxEdits(@Nullable Integer value) {
            this.maxEdits = value;
            return this;
        }

        /**
         * API name: {@code max_inspections}
         */
        @Nonnull
        public final Builder maxInspections(@Nullable Integer value) {
            this.maxInspections = value;
            return this;
        }

        /**
         * API name: {@code max_term_freq}
         */
        @Nonnull
        public final Builder maxTermFreq(@Nullable Float value) {
            this.maxTermFreq = value;
            return this;
        }

        /**
         * API name: {@code min_doc_freq}
         */
        @Nonnull
        public final Builder minDocFreq(@Nullable Float value) {
            this.minDocFreq = value;
            return this;
        }

        /**
         * API name: {@code min_word_length}
         */
        @Nonnull
        public final Builder minWordLength(@Nullable Integer value) {
            this.minWordLength = value;
            return this;
        }

        /**
         * API name: {@code prefix_length}
         */
        @Nonnull
        public final Builder prefixLength(@Nullable Integer value) {
            this.prefixLength = value;
            return this;
        }

        /**
         * API name: {@code shard_size}
         */
        @Nonnull
        public final Builder shardSize(@Nullable Integer value) {
            this.shardSize = value;
            return this;
        }

        /**
         * API name: {@code sort}
         */
        @Nonnull
        public final Builder sort(@Nullable SuggestSort value) {
            this.sort = value;
            return this;
        }

        /**
         * API name: {@code string_distance}
         */
        @Nonnull
        public final Builder stringDistance(@Nullable StringDistance value) {
            this.stringDistance = value;
            return this;
        }

        /**
         * API name: {@code suggest_mode}
         */
        @Nonnull
        public final Builder suggestMode(@Nullable SuggestMode value) {
            this.suggestMode = value;
            return this;
        }

        /**
         * API name: {@code text}
         */
        @Nonnull
        public final Builder text(@Nullable String value) {
            this.text = value;
            return this;
        }

        /**
         * Builds a {@link TermSuggester}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TermSuggester build() {
            _checkSingleUse();

            return new TermSuggester(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TermSuggester}
     */
    public static final JsonpDeserializer<TermSuggester> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TermSuggester::setupTermSuggesterDeserializer
    );

    protected static void setupTermSuggesterDeserializer(ObjectDeserializer<TermSuggester.Builder> op) {
        setupSuggesterBaseDeserializer(op);
        op.add(Builder::lowercaseTerms, JsonpDeserializer.booleanDeserializer(), "lowercase_terms");
        op.add(Builder::maxEdits, JsonpDeserializer.integerDeserializer(), "max_edits");
        op.add(Builder::maxInspections, JsonpDeserializer.integerDeserializer(), "max_inspections");
        op.add(Builder::maxTermFreq, JsonpDeserializer.floatDeserializer(), "max_term_freq");
        op.add(Builder::minDocFreq, JsonpDeserializer.floatDeserializer(), "min_doc_freq");
        op.add(Builder::minWordLength, JsonpDeserializer.integerDeserializer(), "min_word_length");
        op.add(Builder::prefixLength, JsonpDeserializer.integerDeserializer(), "prefix_length");
        op.add(Builder::shardSize, JsonpDeserializer.integerDeserializer(), "shard_size");
        op.add(Builder::sort, SuggestSort._DESERIALIZER, "sort");
        op.add(Builder::stringDistance, StringDistance._DESERIALIZER, "string_distance");
        op.add(Builder::suggestMode, SuggestMode._DESERIALIZER, "suggest_mode");
        op.add(Builder::text, JsonpDeserializer.stringDeserializer(), "text");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.lowercaseTerms);
        result = 31 * result + Objects.hashCode(this.maxEdits);
        result = 31 * result + Objects.hashCode(this.maxInspections);
        result = 31 * result + Objects.hashCode(this.maxTermFreq);
        result = 31 * result + Objects.hashCode(this.minDocFreq);
        result = 31 * result + Objects.hashCode(this.minWordLength);
        result = 31 * result + Objects.hashCode(this.prefixLength);
        result = 31 * result + Objects.hashCode(this.shardSize);
        result = 31 * result + Objects.hashCode(this.sort);
        result = 31 * result + Objects.hashCode(this.stringDistance);
        result = 31 * result + Objects.hashCode(this.suggestMode);
        result = 31 * result + Objects.hashCode(this.text);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TermSuggester other = (TermSuggester) o;
        return Objects.equals(this.lowercaseTerms, other.lowercaseTerms)
            && Objects.equals(this.maxEdits, other.maxEdits)
            && Objects.equals(this.maxInspections, other.maxInspections)
            && Objects.equals(this.maxTermFreq, other.maxTermFreq)
            && Objects.equals(this.minDocFreq, other.minDocFreq)
            && Objects.equals(this.minWordLength, other.minWordLength)
            && Objects.equals(this.prefixLength, other.prefixLength)
            && Objects.equals(this.shardSize, other.shardSize)
            && Objects.equals(this.sort, other.sort)
            && Objects.equals(this.stringDistance, other.stringDistance)
            && Objects.equals(this.suggestMode, other.suggestMode)
            && Objects.equals(this.text, other.text);
    }
}
