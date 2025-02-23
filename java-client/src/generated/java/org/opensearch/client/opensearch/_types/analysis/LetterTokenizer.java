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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.analysis.LetterTokenizer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class LetterTokenizer extends TokenizerBase
    implements
        TokenizerDefinitionVariant,
        ToCopyableBuilder<LetterTokenizer.Builder, LetterTokenizer> {

    // ---------------------------------------------------------------------------------------------

    private LetterTokenizer(Builder builder) {
        super(builder);
    }

    public static LetterTokenizer of(Function<LetterTokenizer.Builder, ObjectBuilder<LetterTokenizer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenizerDefinition} variant kind.
     */
    @Override
    public TokenizerDefinition.Kind _tokenizerDefinitionKind() {
        return TokenizerDefinition.Kind.Letter;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "letter");
        super.serializeInternal(generator, mapper);
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
     * Builder for {@link LetterTokenizer}.
     */
    public static class Builder extends TokenizerBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, LetterTokenizer> {

        public Builder() {}

        private Builder(LetterTokenizer o) {
            super(o);
        }

        private Builder(Builder o) {
            super(o);
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
         * Builds a {@link LetterTokenizer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public LetterTokenizer build() {
            _checkSingleUse();

            return new LetterTokenizer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link LetterTokenizer}
     */
    public static final JsonpDeserializer<LetterTokenizer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        LetterTokenizer::setupLetterTokenizerDeserializer
    );

    protected static void setupLetterTokenizerDeserializer(ObjectDeserializer<LetterTokenizer.Builder> op) {
        setupTokenizerBaseDeserializer(op);

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        return true;
    }
}
