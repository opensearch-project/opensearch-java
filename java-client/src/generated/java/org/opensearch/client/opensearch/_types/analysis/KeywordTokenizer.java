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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.analysis.KeywordTokenizer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class KeywordTokenizer extends TokenizerBase
    implements
        TokenizerDefinitionVariant,
        ToCopyableBuilder<KeywordTokenizer.Builder, KeywordTokenizer> {

    private final int bufferSize;

    // ---------------------------------------------------------------------------------------------

    private KeywordTokenizer(Builder builder) {
        super(builder);
        this.bufferSize = ApiTypeHelper.requireNonNull(builder.bufferSize, this, "bufferSize");
    }

    public static KeywordTokenizer of(Function<KeywordTokenizer.Builder, ObjectBuilder<KeywordTokenizer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenizerDefinition} variant kind.
     */
    @Override
    public TokenizerDefinition.Kind _tokenizerDefinitionKind() {
        return TokenizerDefinition.Kind.Keyword;
    }

    /**
     * Required - API name: {@code buffer_size}
     */
    public final int bufferSize() {
        return this.bufferSize;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "keyword");
        super.serializeInternal(generator, mapper);
        generator.writeKey("buffer_size");
        generator.write(this.bufferSize);
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
     * Builder for {@link KeywordTokenizer}.
     */
    public static class Builder extends TokenizerBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, KeywordTokenizer> {
        private Integer bufferSize;

        public Builder() {}

        private Builder(KeywordTokenizer o) {
            super(o);
            this.bufferSize = o.bufferSize;
        }

        private Builder(Builder o) {
            super(o);
            this.bufferSize = o.bufferSize;
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
         * Required - API name: {@code buffer_size}
         */
        @Nonnull
        public final Builder bufferSize(int value) {
            this.bufferSize = value;
            return this;
        }

        /**
         * Builds a {@link KeywordTokenizer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public KeywordTokenizer build() {
            _checkSingleUse();

            return new KeywordTokenizer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link KeywordTokenizer}
     */
    public static final JsonpDeserializer<KeywordTokenizer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        KeywordTokenizer::setupKeywordTokenizerDeserializer
    );

    protected static void setupKeywordTokenizerDeserializer(ObjectDeserializer<KeywordTokenizer.Builder> op) {
        setupTokenizerBaseDeserializer(op);
        op.add(Builder::bufferSize, JsonpDeserializer.integerDeserializer(), "buffer_size");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Integer.hashCode(this.bufferSize);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        KeywordTokenizer other = (KeywordTokenizer) o;
        return this.bufferSize == other.bufferSize;
    }
}
