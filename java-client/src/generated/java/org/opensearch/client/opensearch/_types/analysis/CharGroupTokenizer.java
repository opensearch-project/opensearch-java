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

// typedef: _types.analysis.CharGroupTokenizer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CharGroupTokenizer extends TokenizerBase
    implements
        TokenizerDefinitionVariant,
        ToCopyableBuilder<CharGroupTokenizer.Builder, CharGroupTokenizer> {

    @Nullable
    private final Integer maxTokenLength;

    @Nonnull
    private final List<String> tokenizeOnChars;

    // ---------------------------------------------------------------------------------------------

    private CharGroupTokenizer(Builder builder) {
        super(builder);
        this.maxTokenLength = builder.maxTokenLength;
        this.tokenizeOnChars = ApiTypeHelper.unmodifiableRequired(builder.tokenizeOnChars, this, "tokenizeOnChars");
    }

    public static CharGroupTokenizer of(Function<CharGroupTokenizer.Builder, ObjectBuilder<CharGroupTokenizer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenizerDefinition} variant kind.
     */
    @Override
    public TokenizerDefinition.Kind _tokenizerDefinitionKind() {
        return TokenizerDefinition.Kind.CharGroup;
    }

    /**
     * API name: {@code max_token_length}
     */
    @Nullable
    public final Integer maxTokenLength() {
        return this.maxTokenLength;
    }

    /**
     * Required - API name: {@code tokenize_on_chars}
     */
    @Nonnull
    public final List<String> tokenizeOnChars() {
        return this.tokenizeOnChars;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "char_group");
        super.serializeInternal(generator, mapper);
        if (this.maxTokenLength != null) {
            generator.writeKey("max_token_length");
            generator.write(this.maxTokenLength);
        }

        generator.writeKey("tokenize_on_chars");
        generator.writeStartArray();
        for (String item0 : this.tokenizeOnChars) {
            generator.write(item0);
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
     * Builder for {@link CharGroupTokenizer}.
     */
    public static class Builder extends TokenizerBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, CharGroupTokenizer> {
        @Nullable
        private Integer maxTokenLength;
        private List<String> tokenizeOnChars;

        public Builder() {}

        private Builder(CharGroupTokenizer o) {
            super(o);
            this.maxTokenLength = o.maxTokenLength;
            this.tokenizeOnChars = _listCopy(o.tokenizeOnChars);
        }

        private Builder(Builder o) {
            super(o);
            this.maxTokenLength = o.maxTokenLength;
            this.tokenizeOnChars = _listCopy(o.tokenizeOnChars);
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
         * API name: {@code max_token_length}
         */
        @Nonnull
        public final Builder maxTokenLength(@Nullable Integer value) {
            this.maxTokenLength = value;
            return this;
        }

        /**
         * Required - API name: {@code tokenize_on_chars}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>tokenizeOnChars</code>.
         * </p>
         */
        @Nonnull
        public final Builder tokenizeOnChars(List<String> list) {
            this.tokenizeOnChars = _listAddAll(this.tokenizeOnChars, list);
            return this;
        }

        /**
         * Required - API name: {@code tokenize_on_chars}
         *
         * <p>
         * Adds one or more values to <code>tokenizeOnChars</code>.
         * </p>
         */
        @Nonnull
        public final Builder tokenizeOnChars(String value, String... values) {
            this.tokenizeOnChars = _listAdd(this.tokenizeOnChars, value, values);
            return this;
        }

        /**
         * Builds a {@link CharGroupTokenizer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CharGroupTokenizer build() {
            _checkSingleUse();

            return new CharGroupTokenizer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CharGroupTokenizer}
     */
    public static final JsonpDeserializer<CharGroupTokenizer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CharGroupTokenizer::setupCharGroupTokenizerDeserializer
    );

    protected static void setupCharGroupTokenizerDeserializer(ObjectDeserializer<CharGroupTokenizer.Builder> op) {
        setupTokenizerBaseDeserializer(op);
        op.add(Builder::maxTokenLength, JsonpDeserializer.integerDeserializer(), "max_token_length");
        op.add(Builder::tokenizeOnChars, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "tokenize_on_chars");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.maxTokenLength);
        result = 31 * result + this.tokenizeOnChars.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CharGroupTokenizer other = (CharGroupTokenizer) o;
        return Objects.equals(this.maxTokenLength, other.maxTokenLength) && this.tokenizeOnChars.equals(other.tokenizeOnChars);
    }
}
