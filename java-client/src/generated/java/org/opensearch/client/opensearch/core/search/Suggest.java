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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.ExternallyTaggedUnion;
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

// typedef: core.search.Suggest

@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Suggest<TDocument> implements TaggedUnion<Suggest.Kind, SuggestVariant>, PlainJsonSerializable {
    /**
     * {@link Suggest} variant kinds.
     */
    public enum Kind implements JsonEnum {
        Completion("completion"),
        Phrase("phrase"),
        Term("term");

        private final String jsonValue;

        Kind(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        @Override
        public String jsonValue() {
            return jsonValue;
        }
    }

    private final Kind _kind;
    private final SuggestVariant _value;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final SuggestVariant _get() {
        return _value;
    }

    public Suggest(SuggestVariant value) {
        this._kind = ApiTypeHelper.requireNonNull(value._suggestKind(), this, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(value, this, "<variant value>");
    }

    private Suggest(Builder<TDocument> builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static <TDocument> Suggest<TDocument> of(Function<Suggest.Builder<TDocument>, ObjectBuilder<Suggest<TDocument>>> fn) {
        return fn.apply(new Builder<>()).build();
    }

    /**
     * Is this variant instance of kind {@code completion}?
     */
    public boolean isCompletion() {
        return _kind == Kind.Completion;
    }

    /**
     * Get the {@code completion} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code completion} kind.
     */
    public CompletionSuggest<TDocument> completion() {
        return TaggedUnionUtils.get(this, Kind.Completion);
    }

    /**
     * Is this variant instance of kind {@code phrase}?
     */
    public boolean isPhrase() {
        return _kind == Kind.Phrase;
    }

    /**
     * Get the {@code phrase} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code phrase} kind.
     */
    public PhraseSuggest phrase() {
        return TaggedUnionUtils.get(this, Kind.Phrase);
    }

    /**
     * Is this variant instance of kind {@code term}?
     */
    public boolean isTerm() {
        return _kind == Kind.Term;
    }

    /**
     * Get the {@code term} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code term} kind.
     */
    public TermSuggest term() {
        return TaggedUnionUtils.get(this, Kind.Term);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        mapper.serialize(_value, generator);
    }

    @Nonnull
    public Builder<TDocument> toBuilder() {
        return new Builder<>(this);
    }

    @Nonnull
    public static <TDocument> Builder builder() {
        return new Builder<>();
    }

    public static class Builder<TDocument> extends ObjectBuilderBase implements ObjectBuilder<Suggest<TDocument>> {
        private Kind _kind;
        private SuggestVariant _value;

        public Builder() {}

        private Builder(Suggest<TDocument> o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<Suggest<TDocument>> completion(CompletionSuggest<TDocument> v) {
            this._kind = Kind.Completion;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Suggest<TDocument>> completion(
            Function<CompletionSuggest.Builder<TDocument>, ObjectBuilder<CompletionSuggest<TDocument>>> fn
        ) {
            return this.completion(fn.apply(new CompletionSuggest.Builder<TDocument>()).build());
        }

        public ObjectBuilder<Suggest<TDocument>> phrase(PhraseSuggest v) {
            this._kind = Kind.Phrase;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Suggest<TDocument>> phrase(Function<PhraseSuggest.Builder, ObjectBuilder<PhraseSuggest>> fn) {
            return this.phrase(fn.apply(new PhraseSuggest.Builder()).build());
        }

        public ObjectBuilder<Suggest<TDocument>> term(TermSuggest v) {
            this._kind = Kind.Term;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Suggest<TDocument>> term(Function<TermSuggest.Builder, ObjectBuilder<TermSuggest>> fn) {
            return this.term(fn.apply(new TermSuggest.Builder()).build());
        }

        @Override
        public Suggest<TDocument> build() {
            _checkSingleUse();
            return new Suggest<>(this);
        }
    }

    public static <TDocument> ExternallyTaggedUnion.TypedKeysDeserializer<Suggest<TDocument>> createSuggestDeserializer(
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        Map<String, JsonpDeserializer<? extends SuggestVariant>> deserializers = new HashMap<>();
        deserializers.put("completion", CompletionSuggest.createCompletionSuggestDeserializer(tDocumentDeserializer));
        deserializers.put("phrase", PhraseSuggest._DESERIALIZER);
        deserializers.put("term", TermSuggest._DESERIALIZER);

        return new ExternallyTaggedUnion.Deserializer<>(deserializers, Suggest<TDocument>::new).typedKeys();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this._kind);
        result = 31 * result + Objects.hashCode(this._value);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Suggest<?> other = (Suggest<?>) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
