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
import org.opensearch.client.opensearch.indices.FielddataFrequencyFilter;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.mapping.TextProperty

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TextProperty extends CorePropertyBase implements PropertyVariant, ToCopyableBuilder<TextProperty.Builder, TextProperty> {

    @Nullable
    private final String analyzer;

    @Nullable
    private final Double boost;

    @Nullable
    private final Boolean eagerGlobalOrdinals;

    @Nullable
    private final Boolean fielddata;

    @Nullable
    private final FielddataFrequencyFilter fielddataFrequencyFilter;

    @Nullable
    private final Boolean index;

    @Nullable
    private final IndexOptions indexOptions;

    @Nullable
    private final Boolean indexPhrases;

    @Nullable
    private final TextIndexPrefixes indexPrefixes;

    @Nullable
    private final Boolean norms;

    @Nullable
    private final Integer positionIncrementGap;

    @Nullable
    private final String searchAnalyzer;

    @Nullable
    private final String searchQuoteAnalyzer;

    @Nullable
    private final TermVectorOption termVector;

    // ---------------------------------------------------------------------------------------------

    private TextProperty(Builder builder) {
        super(builder);
        this.analyzer = builder.analyzer;
        this.boost = builder.boost;
        this.eagerGlobalOrdinals = builder.eagerGlobalOrdinals;
        this.fielddata = builder.fielddata;
        this.fielddataFrequencyFilter = builder.fielddataFrequencyFilter;
        this.index = builder.index;
        this.indexOptions = builder.indexOptions;
        this.indexPhrases = builder.indexPhrases;
        this.indexPrefixes = builder.indexPrefixes;
        this.norms = builder.norms;
        this.positionIncrementGap = builder.positionIncrementGap;
        this.searchAnalyzer = builder.searchAnalyzer;
        this.searchQuoteAnalyzer = builder.searchQuoteAnalyzer;
        this.termVector = builder.termVector;
    }

    public static TextProperty of(Function<TextProperty.Builder, ObjectBuilder<TextProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.Text;
    }

    /**
     * API name: {@code analyzer}
     */
    @Nullable
    public final String analyzer() {
        return this.analyzer;
    }

    /**
     * API name: {@code boost}
     */
    @Nullable
    public final Double boost() {
        return this.boost;
    }

    /**
     * API name: {@code eager_global_ordinals}
     */
    @Nullable
    public final Boolean eagerGlobalOrdinals() {
        return this.eagerGlobalOrdinals;
    }

    /**
     * API name: {@code fielddata}
     */
    @Nullable
    public final Boolean fielddata() {
        return this.fielddata;
    }

    /**
     * API name: {@code fielddata_frequency_filter}
     */
    @Nullable
    public final FielddataFrequencyFilter fielddataFrequencyFilter() {
        return this.fielddataFrequencyFilter;
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final Boolean index() {
        return this.index;
    }

    /**
     * API name: {@code index_options}
     */
    @Nullable
    public final IndexOptions indexOptions() {
        return this.indexOptions;
    }

    /**
     * API name: {@code index_phrases}
     */
    @Nullable
    public final Boolean indexPhrases() {
        return this.indexPhrases;
    }

    /**
     * API name: {@code index_prefixes}
     */
    @Nullable
    public final TextIndexPrefixes indexPrefixes() {
        return this.indexPrefixes;
    }

    /**
     * API name: {@code norms}
     */
    @Nullable
    public final Boolean norms() {
        return this.norms;
    }

    /**
     * API name: {@code position_increment_gap}
     */
    @Nullable
    public final Integer positionIncrementGap() {
        return this.positionIncrementGap;
    }

    /**
     * API name: {@code search_analyzer}
     */
    @Nullable
    public final String searchAnalyzer() {
        return this.searchAnalyzer;
    }

    /**
     * API name: {@code search_quote_analyzer}
     */
    @Nullable
    public final String searchQuoteAnalyzer() {
        return this.searchQuoteAnalyzer;
    }

    /**
     * API name: {@code term_vector}
     */
    @Nullable
    public final TermVectorOption termVector() {
        return this.termVector;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "text");
        super.serializeInternal(generator, mapper);
        if (this.analyzer != null) {
            generator.writeKey("analyzer");
            generator.write(this.analyzer);
        }

        if (this.boost != null) {
            generator.writeKey("boost");
            generator.write(this.boost);
        }

        if (this.eagerGlobalOrdinals != null) {
            generator.writeKey("eager_global_ordinals");
            generator.write(this.eagerGlobalOrdinals);
        }

        if (this.fielddata != null) {
            generator.writeKey("fielddata");
            generator.write(this.fielddata);
        }

        if (this.fielddataFrequencyFilter != null) {
            generator.writeKey("fielddata_frequency_filter");
            this.fielddataFrequencyFilter.serialize(generator, mapper);
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.indexOptions != null) {
            generator.writeKey("index_options");
            this.indexOptions.serialize(generator, mapper);
        }

        if (this.indexPhrases != null) {
            generator.writeKey("index_phrases");
            generator.write(this.indexPhrases);
        }

        if (this.indexPrefixes != null) {
            generator.writeKey("index_prefixes");
            this.indexPrefixes.serialize(generator, mapper);
        }

        if (this.norms != null) {
            generator.writeKey("norms");
            generator.write(this.norms);
        }

        if (this.positionIncrementGap != null) {
            generator.writeKey("position_increment_gap");
            generator.write(this.positionIncrementGap);
        }

        if (this.searchAnalyzer != null) {
            generator.writeKey("search_analyzer");
            generator.write(this.searchAnalyzer);
        }

        if (this.searchQuoteAnalyzer != null) {
            generator.writeKey("search_quote_analyzer");
            generator.write(this.searchQuoteAnalyzer);
        }

        if (this.termVector != null) {
            generator.writeKey("term_vector");
            this.termVector.serialize(generator, mapper);
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
     * Builder for {@link TextProperty}.
     */
    public static class Builder extends CorePropertyBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, TextProperty> {
        @Nullable
        private String analyzer;
        @Nullable
        private Double boost;
        @Nullable
        private Boolean eagerGlobalOrdinals;
        @Nullable
        private Boolean fielddata;
        @Nullable
        private FielddataFrequencyFilter fielddataFrequencyFilter;
        @Nullable
        private Boolean index;
        @Nullable
        private IndexOptions indexOptions;
        @Nullable
        private Boolean indexPhrases;
        @Nullable
        private TextIndexPrefixes indexPrefixes;
        @Nullable
        private Boolean norms;
        @Nullable
        private Integer positionIncrementGap;
        @Nullable
        private String searchAnalyzer;
        @Nullable
        private String searchQuoteAnalyzer;
        @Nullable
        private TermVectorOption termVector;

        public Builder() {}

        private Builder(TextProperty o) {
            super(o);
            this.analyzer = o.analyzer;
            this.boost = o.boost;
            this.eagerGlobalOrdinals = o.eagerGlobalOrdinals;
            this.fielddata = o.fielddata;
            this.fielddataFrequencyFilter = o.fielddataFrequencyFilter;
            this.index = o.index;
            this.indexOptions = o.indexOptions;
            this.indexPhrases = o.indexPhrases;
            this.indexPrefixes = o.indexPrefixes;
            this.norms = o.norms;
            this.positionIncrementGap = o.positionIncrementGap;
            this.searchAnalyzer = o.searchAnalyzer;
            this.searchQuoteAnalyzer = o.searchQuoteAnalyzer;
            this.termVector = o.termVector;
        }

        private Builder(Builder o) {
            super(o);
            this.analyzer = o.analyzer;
            this.boost = o.boost;
            this.eagerGlobalOrdinals = o.eagerGlobalOrdinals;
            this.fielddata = o.fielddata;
            this.fielddataFrequencyFilter = o.fielddataFrequencyFilter;
            this.index = o.index;
            this.indexOptions = o.indexOptions;
            this.indexPhrases = o.indexPhrases;
            this.indexPrefixes = o.indexPrefixes;
            this.norms = o.norms;
            this.positionIncrementGap = o.positionIncrementGap;
            this.searchAnalyzer = o.searchAnalyzer;
            this.searchQuoteAnalyzer = o.searchQuoteAnalyzer;
            this.termVector = o.termVector;
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
         * API name: {@code analyzer}
         */
        @Nonnull
        public final Builder analyzer(@Nullable String value) {
            this.analyzer = value;
            return this;
        }

        /**
         * API name: {@code boost}
         */
        @Nonnull
        public final Builder boost(@Nullable Double value) {
            this.boost = value;
            return this;
        }

        /**
         * API name: {@code eager_global_ordinals}
         */
        @Nonnull
        public final Builder eagerGlobalOrdinals(@Nullable Boolean value) {
            this.eagerGlobalOrdinals = value;
            return this;
        }

        /**
         * API name: {@code fielddata}
         */
        @Nonnull
        public final Builder fielddata(@Nullable Boolean value) {
            this.fielddata = value;
            return this;
        }

        /**
         * API name: {@code fielddata_frequency_filter}
         */
        @Nonnull
        public final Builder fielddataFrequencyFilter(@Nullable FielddataFrequencyFilter value) {
            this.fielddataFrequencyFilter = value;
            return this;
        }

        /**
         * API name: {@code fielddata_frequency_filter}
         */
        @Nonnull
        public final Builder fielddataFrequencyFilter(
            Function<FielddataFrequencyFilter.Builder, ObjectBuilder<FielddataFrequencyFilter>> fn
        ) {
            return fielddataFrequencyFilter(fn.apply(new FielddataFrequencyFilter.Builder()).build());
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
         * API name: {@code index_options}
         */
        @Nonnull
        public final Builder indexOptions(@Nullable IndexOptions value) {
            this.indexOptions = value;
            return this;
        }

        /**
         * API name: {@code index_phrases}
         */
        @Nonnull
        public final Builder indexPhrases(@Nullable Boolean value) {
            this.indexPhrases = value;
            return this;
        }

        /**
         * API name: {@code index_prefixes}
         */
        @Nonnull
        public final Builder indexPrefixes(@Nullable TextIndexPrefixes value) {
            this.indexPrefixes = value;
            return this;
        }

        /**
         * API name: {@code index_prefixes}
         */
        @Nonnull
        public final Builder indexPrefixes(Function<TextIndexPrefixes.Builder, ObjectBuilder<TextIndexPrefixes>> fn) {
            return indexPrefixes(fn.apply(new TextIndexPrefixes.Builder()).build());
        }

        /**
         * API name: {@code norms}
         */
        @Nonnull
        public final Builder norms(@Nullable Boolean value) {
            this.norms = value;
            return this;
        }

        /**
         * API name: {@code position_increment_gap}
         */
        @Nonnull
        public final Builder positionIncrementGap(@Nullable Integer value) {
            this.positionIncrementGap = value;
            return this;
        }

        /**
         * API name: {@code search_analyzer}
         */
        @Nonnull
        public final Builder searchAnalyzer(@Nullable String value) {
            this.searchAnalyzer = value;
            return this;
        }

        /**
         * API name: {@code search_quote_analyzer}
         */
        @Nonnull
        public final Builder searchQuoteAnalyzer(@Nullable String value) {
            this.searchQuoteAnalyzer = value;
            return this;
        }

        /**
         * API name: {@code term_vector}
         */
        @Nonnull
        public final Builder termVector(@Nullable TermVectorOption value) {
            this.termVector = value;
            return this;
        }

        /**
         * Builds a {@link TextProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TextProperty build() {
            _checkSingleUse();

            return new TextProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TextProperty}
     */
    public static final JsonpDeserializer<TextProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TextProperty::setupTextPropertyDeserializer
    );

    protected static void setupTextPropertyDeserializer(ObjectDeserializer<TextProperty.Builder> op) {
        setupCorePropertyBaseDeserializer(op);
        op.add(Builder::analyzer, JsonpDeserializer.stringDeserializer(), "analyzer");
        op.add(Builder::boost, JsonpDeserializer.doubleDeserializer(), "boost");
        op.add(Builder::eagerGlobalOrdinals, JsonpDeserializer.booleanDeserializer(), "eager_global_ordinals");
        op.add(Builder::fielddata, JsonpDeserializer.booleanDeserializer(), "fielddata");
        op.add(Builder::fielddataFrequencyFilter, FielddataFrequencyFilter._DESERIALIZER, "fielddata_frequency_filter");
        op.add(Builder::index, JsonpDeserializer.booleanDeserializer(), "index");
        op.add(Builder::indexOptions, IndexOptions._DESERIALIZER, "index_options");
        op.add(Builder::indexPhrases, JsonpDeserializer.booleanDeserializer(), "index_phrases");
        op.add(Builder::indexPrefixes, TextIndexPrefixes._DESERIALIZER, "index_prefixes");
        op.add(Builder::norms, JsonpDeserializer.booleanDeserializer(), "norms");
        op.add(Builder::positionIncrementGap, JsonpDeserializer.integerDeserializer(), "position_increment_gap");
        op.add(Builder::searchAnalyzer, JsonpDeserializer.stringDeserializer(), "search_analyzer");
        op.add(Builder::searchQuoteAnalyzer, JsonpDeserializer.stringDeserializer(), "search_quote_analyzer");
        op.add(Builder::termVector, TermVectorOption._DESERIALIZER, "term_vector");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + Objects.hashCode(this.boost);
        result = 31 * result + Objects.hashCode(this.eagerGlobalOrdinals);
        result = 31 * result + Objects.hashCode(this.fielddata);
        result = 31 * result + Objects.hashCode(this.fielddataFrequencyFilter);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.indexOptions);
        result = 31 * result + Objects.hashCode(this.indexPhrases);
        result = 31 * result + Objects.hashCode(this.indexPrefixes);
        result = 31 * result + Objects.hashCode(this.norms);
        result = 31 * result + Objects.hashCode(this.positionIncrementGap);
        result = 31 * result + Objects.hashCode(this.searchAnalyzer);
        result = 31 * result + Objects.hashCode(this.searchQuoteAnalyzer);
        result = 31 * result + Objects.hashCode(this.termVector);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TextProperty other = (TextProperty) o;
        return Objects.equals(this.analyzer, other.analyzer)
            && Objects.equals(this.boost, other.boost)
            && Objects.equals(this.eagerGlobalOrdinals, other.eagerGlobalOrdinals)
            && Objects.equals(this.fielddata, other.fielddata)
            && Objects.equals(this.fielddataFrequencyFilter, other.fielddataFrequencyFilter)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.indexOptions, other.indexOptions)
            && Objects.equals(this.indexPhrases, other.indexPhrases)
            && Objects.equals(this.indexPrefixes, other.indexPrefixes)
            && Objects.equals(this.norms, other.norms)
            && Objects.equals(this.positionIncrementGap, other.positionIncrementGap)
            && Objects.equals(this.searchAnalyzer, other.searchAnalyzer)
            && Objects.equals(this.searchQuoteAnalyzer, other.searchQuoteAnalyzer)
            && Objects.equals(this.termVector, other.termVector);
    }
}
