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

// typedef: _types.analysis.NGramTokenizer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NGramTokenizer extends TokenizerBase
    implements
        TokenizerDefinitionVariant,
        ToCopyableBuilder<NGramTokenizer.Builder, NGramTokenizer> {

    @Nullable
    private final String customTokenChars;

    private final int maxGram;

    private final int minGram;

    @Nonnull
    private final List<TokenChar> tokenChars;

    // ---------------------------------------------------------------------------------------------

    private NGramTokenizer(Builder builder) {
        super(builder);
        this.customTokenChars = builder.customTokenChars;
        this.maxGram = ApiTypeHelper.requireNonNull(builder.maxGram, this, "maxGram");
        this.minGram = ApiTypeHelper.requireNonNull(builder.minGram, this, "minGram");
        this.tokenChars = ApiTypeHelper.unmodifiableRequired(builder.tokenChars, this, "tokenChars");
    }

    public static NGramTokenizer of(Function<NGramTokenizer.Builder, ObjectBuilder<NGramTokenizer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenizerDefinition} variant kind.
     */
    @Override
    public TokenizerDefinition.Kind _tokenizerDefinitionKind() {
        return TokenizerDefinition.Kind.Ngram;
    }

    /**
     * API name: {@code custom_token_chars}
     */
    @Nullable
    public final String customTokenChars() {
        return this.customTokenChars;
    }

    /**
     * Required - API name: {@code max_gram}
     */
    public final int maxGram() {
        return this.maxGram;
    }

    /**
     * Required - API name: {@code min_gram}
     */
    public final int minGram() {
        return this.minGram;
    }

    /**
     * Required - API name: {@code token_chars}
     */
    @Nonnull
    public final List<TokenChar> tokenChars() {
        return this.tokenChars;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "ngram");
        super.serializeInternal(generator, mapper);
        if (this.customTokenChars != null) {
            generator.writeKey("custom_token_chars");
            generator.write(this.customTokenChars);
        }

        generator.writeKey("max_gram");
        generator.write(this.maxGram);

        generator.writeKey("min_gram");
        generator.write(this.minGram);

        generator.writeKey("token_chars");
        generator.writeStartArray();
        for (TokenChar item0 : this.tokenChars) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link NGramTokenizer}.
     */
    public static class Builder extends TokenizerBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, NGramTokenizer> {
        @Nullable
        private String customTokenChars;
        private Integer maxGram;
        private Integer minGram;
        private List<TokenChar> tokenChars;

        public Builder() {}

        private Builder(NGramTokenizer o) {
            super(o);
            this.customTokenChars = o.customTokenChars;
            this.maxGram = o.maxGram;
            this.minGram = o.minGram;
            this.tokenChars = _listCopy(o.tokenChars);
        }

        private Builder(Builder o) {
            super(o);
            this.customTokenChars = o.customTokenChars;
            this.maxGram = o.maxGram;
            this.minGram = o.minGram;
            this.tokenChars = _listCopy(o.tokenChars);
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
         * API name: {@code custom_token_chars}
         */
        @Nonnull
        public final Builder customTokenChars(@Nullable String value) {
            this.customTokenChars = value;
            return this;
        }

        /**
         * Required - API name: {@code max_gram}
         */
        @Nonnull
        public final Builder maxGram(int value) {
            this.maxGram = value;
            return this;
        }

        /**
         * Required - API name: {@code min_gram}
         */
        @Nonnull
        public final Builder minGram(int value) {
            this.minGram = value;
            return this;
        }

        /**
         * Required - API name: {@code token_chars}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>tokenChars</code>.
         * </p>
         */
        @Nonnull
        public final Builder tokenChars(List<TokenChar> list) {
            this.tokenChars = _listAddAll(this.tokenChars, list);
            return this;
        }

        /**
         * Required - API name: {@code token_chars}
         *
         * <p>
         * Adds one or more values to <code>tokenChars</code>.
         * </p>
         */
        @Nonnull
        public final Builder tokenChars(TokenChar value, TokenChar... values) {
            this.tokenChars = _listAdd(this.tokenChars, value, values);
            return this;
        }

        /**
         * Builds a {@link NGramTokenizer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NGramTokenizer build() {
            _checkSingleUse();

            return new NGramTokenizer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NGramTokenizer}
     */
    public static final JsonpDeserializer<NGramTokenizer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NGramTokenizer::setupNGramTokenizerDeserializer
    );

    protected static void setupNGramTokenizerDeserializer(ObjectDeserializer<NGramTokenizer.Builder> op) {
        setupTokenizerBaseDeserializer(op);
        op.add(Builder::customTokenChars, JsonpDeserializer.stringDeserializer(), "custom_token_chars");
        op.add(Builder::maxGram, JsonpDeserializer.integerDeserializer(), "max_gram");
        op.add(Builder::minGram, JsonpDeserializer.integerDeserializer(), "min_gram");
        op.add(Builder::tokenChars, JsonpDeserializer.arrayDeserializer(TokenChar._DESERIALIZER), "token_chars");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.customTokenChars);
        result = 31 * result + Integer.hashCode(this.maxGram);
        result = 31 * result + Integer.hashCode(this.minGram);
        result = 31 * result + this.tokenChars.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NGramTokenizer other = (NGramTokenizer) o;
        return Objects.equals(this.customTokenChars, other.customTokenChars)
            && this.maxGram == other.maxGram
            && this.minGram == other.minGram
            && this.tokenChars.equals(other.tokenChars);
    }
}
