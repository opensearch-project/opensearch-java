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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.termvectors.Term

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Term implements PlainJsonSerializable, ToCopyableBuilder<Term.Builder, Term> {

    @Nullable
    private final Integer docFreq;

    @Nullable
    private final Double score;

    private final int termFreq;

    @Nonnull
    private final List<Token> tokens;

    @Nullable
    private final Integer ttf;

    // ---------------------------------------------------------------------------------------------

    private Term(Builder builder) {
        this.docFreq = builder.docFreq;
        this.score = builder.score;
        this.termFreq = ApiTypeHelper.requireNonNull(builder.termFreq, this, "termFreq");
        this.tokens = ApiTypeHelper.unmodifiable(builder.tokens);
        this.ttf = builder.ttf;
    }

    public static Term of(Function<Term.Builder, ObjectBuilder<Term>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code doc_freq}
     */
    @Nullable
    public final Integer docFreq() {
        return this.docFreq;
    }

    /**
     * API name: {@code score}
     */
    @Nullable
    public final Double score() {
        return this.score;
    }

    /**
     * Required - API name: {@code term_freq}
     */
    public final int termFreq() {
        return this.termFreq;
    }

    /**
     * API name: {@code tokens}
     */
    @Nonnull
    public final List<Token> tokens() {
        return this.tokens;
    }

    /**
     * API name: {@code ttf}
     */
    @Nullable
    public final Integer ttf() {
        return this.ttf;
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
        if (this.docFreq != null) {
            generator.writeKey("doc_freq");
            generator.write(this.docFreq);
        }

        if (this.score != null) {
            generator.writeKey("score");
            generator.write(this.score);
        }

        generator.writeKey("term_freq");
        generator.write(this.termFreq);

        if (ApiTypeHelper.isDefined(this.tokens)) {
            generator.writeKey("tokens");
            generator.writeStartArray();
            for (Token item0 : this.tokens) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.ttf != null) {
            generator.writeKey("ttf");
            generator.write(this.ttf);
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
     * Builder for {@link Term}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Term> {
        @Nullable
        private Integer docFreq;
        @Nullable
        private Double score;
        private Integer termFreq;
        @Nullable
        private List<Token> tokens;
        @Nullable
        private Integer ttf;

        public Builder() {}

        private Builder(Term o) {
            this.docFreq = o.docFreq;
            this.score = o.score;
            this.termFreq = o.termFreq;
            this.tokens = _listCopy(o.tokens);
            this.ttf = o.ttf;
        }

        private Builder(Builder o) {
            this.docFreq = o.docFreq;
            this.score = o.score;
            this.termFreq = o.termFreq;
            this.tokens = _listCopy(o.tokens);
            this.ttf = o.ttf;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code doc_freq}
         */
        @Nonnull
        public final Builder docFreq(@Nullable Integer value) {
            this.docFreq = value;
            return this;
        }

        /**
         * API name: {@code score}
         */
        @Nonnull
        public final Builder score(@Nullable Double value) {
            this.score = value;
            return this;
        }

        /**
         * Required - API name: {@code term_freq}
         */
        @Nonnull
        public final Builder termFreq(int value) {
            this.termFreq = value;
            return this;
        }

        /**
         * API name: {@code tokens}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>tokens</code>.
         * </p>
         */
        @Nonnull
        public final Builder tokens(List<Token> list) {
            this.tokens = _listAddAll(this.tokens, list);
            return this;
        }

        /**
         * API name: {@code tokens}
         *
         * <p>
         * Adds one or more values to <code>tokens</code>.
         * </p>
         */
        @Nonnull
        public final Builder tokens(Token value, Token... values) {
            this.tokens = _listAdd(this.tokens, value, values);
            return this;
        }

        /**
         * API name: {@code tokens}
         *
         * <p>
         * Adds a value to <code>tokens</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder tokens(Function<Token.Builder, ObjectBuilder<Token>> fn) {
            return tokens(fn.apply(new Token.Builder()).build());
        }

        /**
         * API name: {@code ttf}
         */
        @Nonnull
        public final Builder ttf(@Nullable Integer value) {
            this.ttf = value;
            return this;
        }

        /**
         * Builds a {@link Term}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Term build() {
            _checkSingleUse();

            return new Term(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Term}
     */
    public static final JsonpDeserializer<Term> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new, Term::setupTermDeserializer);

    protected static void setupTermDeserializer(ObjectDeserializer<Term.Builder> op) {
        op.add(Builder::docFreq, JsonpDeserializer.integerDeserializer(), "doc_freq");
        op.add(Builder::score, JsonpDeserializer.doubleDeserializer(), "score");
        op.add(Builder::termFreq, JsonpDeserializer.integerDeserializer(), "term_freq");
        op.add(Builder::tokens, JsonpDeserializer.arrayDeserializer(Token._DESERIALIZER), "tokens");
        op.add(Builder::ttf, JsonpDeserializer.integerDeserializer(), "ttf");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.docFreq);
        result = 31 * result + Objects.hashCode(this.score);
        result = 31 * result + Integer.hashCode(this.termFreq);
        result = 31 * result + Objects.hashCode(this.tokens);
        result = 31 * result + Objects.hashCode(this.ttf);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Term other = (Term) o;
        return Objects.equals(this.docFreq, other.docFreq)
            && Objects.equals(this.score, other.score)
            && this.termFreq == other.termFreq
            && Objects.equals(this.tokens, other.tokens)
            && Objects.equals(this.ttf, other.ttf);
    }
}
