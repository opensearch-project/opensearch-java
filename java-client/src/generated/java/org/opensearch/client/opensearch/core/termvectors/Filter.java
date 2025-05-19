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

package org.opensearch.client.opensearch.core.termvectors;

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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.termvectors.Filter

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Filter implements PlainJsonSerializable, ToCopyableBuilder<Filter.Builder, Filter> {

    @Nullable
    private final Integer maxDocFreq;

    @Nullable
    private final Integer maxNumTerms;

    @Nullable
    private final Integer maxTermFreq;

    @Nullable
    private final Integer maxWordLength;

    @Nullable
    private final Integer minDocFreq;

    @Nullable
    private final Integer minTermFreq;

    @Nullable
    private final Integer minWordLength;

    // ---------------------------------------------------------------------------------------------

    private Filter(Builder builder) {
        this.maxDocFreq = builder.maxDocFreq;
        this.maxNumTerms = builder.maxNumTerms;
        this.maxTermFreq = builder.maxTermFreq;
        this.maxWordLength = builder.maxWordLength;
        this.minDocFreq = builder.minDocFreq;
        this.minTermFreq = builder.minTermFreq;
        this.minWordLength = builder.minWordLength;
    }

    public static Filter of(Function<Filter.Builder, ObjectBuilder<Filter>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Ignores words that appear in more than the specified number of documents. Default is <code>unbounded</code>.
     * <p>
     * API name: {@code max_doc_freq}
     * </p>
     */
    @Nullable
    public final Integer maxDocFreq() {
        return this.maxDocFreq;
    }

    /**
     * The maximum number of terms that should be returned per field.
     * <p>
     * API name: {@code max_num_terms}
     * </p>
     */
    @Nullable
    public final Integer maxNumTerms() {
        return this.maxNumTerms;
    }

    /**
     * Ignore words with more than this frequency in the source doc. Default is <code>unbounded</code>.
     * <p>
     * API name: {@code max_term_freq}
     * </p>
     */
    @Nullable
    public final Integer maxTermFreq() {
        return this.maxTermFreq;
    }

    /**
     * The maximum word length. Words longer than this value will be ignored. Default is <code>unbounded</code>.
     * <p>
     * API name: {@code max_word_length}
     * </p>
     */
    @Nullable
    public final Integer maxWordLength() {
        return this.maxWordLength;
    }

    /**
     * Ignore terms which do not occur in at least this many docs.
     * <p>
     * API name: {@code min_doc_freq}
     * </p>
     */
    @Nullable
    public final Integer minDocFreq() {
        return this.minDocFreq;
    }

    /**
     * Ignore words with less than this frequency in the source doc.
     * <p>
     * API name: {@code min_term_freq}
     * </p>
     */
    @Nullable
    public final Integer minTermFreq() {
        return this.minTermFreq;
    }

    /**
     * The minimum word length. Words shorter than this value will be ignored. Default is 0.
     * <p>
     * API name: {@code min_word_length}
     * </p>
     */
    @Nullable
    public final Integer minWordLength() {
        return this.minWordLength;
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
        if (this.maxDocFreq != null) {
            generator.writeKey("max_doc_freq");
            generator.write(this.maxDocFreq);
        }

        if (this.maxNumTerms != null) {
            generator.writeKey("max_num_terms");
            generator.write(this.maxNumTerms);
        }

        if (this.maxTermFreq != null) {
            generator.writeKey("max_term_freq");
            generator.write(this.maxTermFreq);
        }

        if (this.maxWordLength != null) {
            generator.writeKey("max_word_length");
            generator.write(this.maxWordLength);
        }

        if (this.minDocFreq != null) {
            generator.writeKey("min_doc_freq");
            generator.write(this.minDocFreq);
        }

        if (this.minTermFreq != null) {
            generator.writeKey("min_term_freq");
            generator.write(this.minTermFreq);
        }

        if (this.minWordLength != null) {
            generator.writeKey("min_word_length");
            generator.write(this.minWordLength);
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
     * Builder for {@link Filter}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Filter> {
        @Nullable
        private Integer maxDocFreq;
        @Nullable
        private Integer maxNumTerms;
        @Nullable
        private Integer maxTermFreq;
        @Nullable
        private Integer maxWordLength;
        @Nullable
        private Integer minDocFreq;
        @Nullable
        private Integer minTermFreq;
        @Nullable
        private Integer minWordLength;

        public Builder() {}

        private Builder(Filter o) {
            this.maxDocFreq = o.maxDocFreq;
            this.maxNumTerms = o.maxNumTerms;
            this.maxTermFreq = o.maxTermFreq;
            this.maxWordLength = o.maxWordLength;
            this.minDocFreq = o.minDocFreq;
            this.minTermFreq = o.minTermFreq;
            this.minWordLength = o.minWordLength;
        }

        private Builder(Builder o) {
            this.maxDocFreq = o.maxDocFreq;
            this.maxNumTerms = o.maxNumTerms;
            this.maxTermFreq = o.maxTermFreq;
            this.maxWordLength = o.maxWordLength;
            this.minDocFreq = o.minDocFreq;
            this.minTermFreq = o.minTermFreq;
            this.minWordLength = o.minWordLength;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Ignores words that appear in more than the specified number of documents. Default is <code>unbounded</code>.
         * <p>
         * API name: {@code max_doc_freq}
         * </p>
         */
        @Nonnull
        public final Builder maxDocFreq(@Nullable Integer value) {
            this.maxDocFreq = value;
            return this;
        }

        /**
         * The maximum number of terms that should be returned per field.
         * <p>
         * API name: {@code max_num_terms}
         * </p>
         */
        @Nonnull
        public final Builder maxNumTerms(@Nullable Integer value) {
            this.maxNumTerms = value;
            return this;
        }

        /**
         * Ignore words with more than this frequency in the source doc. Default is <code>unbounded</code>.
         * <p>
         * API name: {@code max_term_freq}
         * </p>
         */
        @Nonnull
        public final Builder maxTermFreq(@Nullable Integer value) {
            this.maxTermFreq = value;
            return this;
        }

        /**
         * The maximum word length. Words longer than this value will be ignored. Default is <code>unbounded</code>.
         * <p>
         * API name: {@code max_word_length}
         * </p>
         */
        @Nonnull
        public final Builder maxWordLength(@Nullable Integer value) {
            this.maxWordLength = value;
            return this;
        }

        /**
         * Ignore terms which do not occur in at least this many docs.
         * <p>
         * API name: {@code min_doc_freq}
         * </p>
         */
        @Nonnull
        public final Builder minDocFreq(@Nullable Integer value) {
            this.minDocFreq = value;
            return this;
        }

        /**
         * Ignore words with less than this frequency in the source doc.
         * <p>
         * API name: {@code min_term_freq}
         * </p>
         */
        @Nonnull
        public final Builder minTermFreq(@Nullable Integer value) {
            this.minTermFreq = value;
            return this;
        }

        /**
         * The minimum word length. Words shorter than this value will be ignored. Default is 0.
         * <p>
         * API name: {@code min_word_length}
         * </p>
         */
        @Nonnull
        public final Builder minWordLength(@Nullable Integer value) {
            this.minWordLength = value;
            return this;
        }

        /**
         * Builds a {@link Filter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Filter build() {
            _checkSingleUse();

            return new Filter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Filter}
     */
    public static final JsonpDeserializer<Filter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Filter::setupFilterDeserializer
    );

    protected static void setupFilterDeserializer(ObjectDeserializer<Filter.Builder> op) {
        op.add(Builder::maxDocFreq, JsonpDeserializer.integerDeserializer(), "max_doc_freq");
        op.add(Builder::maxNumTerms, JsonpDeserializer.integerDeserializer(), "max_num_terms");
        op.add(Builder::maxTermFreq, JsonpDeserializer.integerDeserializer(), "max_term_freq");
        op.add(Builder::maxWordLength, JsonpDeserializer.integerDeserializer(), "max_word_length");
        op.add(Builder::minDocFreq, JsonpDeserializer.integerDeserializer(), "min_doc_freq");
        op.add(Builder::minTermFreq, JsonpDeserializer.integerDeserializer(), "min_term_freq");
        op.add(Builder::minWordLength, JsonpDeserializer.integerDeserializer(), "min_word_length");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.maxDocFreq);
        result = 31 * result + Objects.hashCode(this.maxNumTerms);
        result = 31 * result + Objects.hashCode(this.maxTermFreq);
        result = 31 * result + Objects.hashCode(this.maxWordLength);
        result = 31 * result + Objects.hashCode(this.minDocFreq);
        result = 31 * result + Objects.hashCode(this.minTermFreq);
        result = 31 * result + Objects.hashCode(this.minWordLength);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Filter other = (Filter) o;
        return Objects.equals(this.maxDocFreq, other.maxDocFreq)
            && Objects.equals(this.maxNumTerms, other.maxNumTerms)
            && Objects.equals(this.maxTermFreq, other.maxTermFreq)
            && Objects.equals(this.maxWordLength, other.maxWordLength)
            && Objects.equals(this.minDocFreq, other.minDocFreq)
            && Objects.equals(this.minTermFreq, other.minTermFreq)
            && Objects.equals(this.minWordLength, other.minWordLength);
    }
}
