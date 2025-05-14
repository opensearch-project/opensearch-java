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
import java.util.List;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.search.CompletionSuggest

@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CompletionSuggest<TDocument> extends SuggestBase
    implements
        SuggestVariant,
        ToCopyableBuilder<CompletionSuggest.Builder<TDocument>, CompletionSuggest<TDocument>> {

    @Nonnull
    private final List<CompletionSuggestOption<TDocument>> options;

    // ---------------------------------------------------------------------------------------------

    private CompletionSuggest(Builder<TDocument> builder) {
        super(builder);
        this.options = ApiTypeHelper.unmodifiableRequired(builder.options, this, "options");
    }

    public static <TDocument> CompletionSuggest<TDocument> of(
        Function<CompletionSuggest.Builder<TDocument>, ObjectBuilder<CompletionSuggest<TDocument>>> fn
    ) {
        return fn.apply(new Builder<>()).build();
    }

    /**
     * {@link Suggest} variant kind.
     */
    @Override
    public Suggest.Kind _suggestKind() {
        return Suggest.Kind.Completion;
    }

    /**
     * Required - API name: {@code options}
     */
    @Nonnull
    public final List<CompletionSuggestOption<TDocument>> options() {
        return this.options;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("options");
        generator.writeStartArray();
        for (CompletionSuggestOption<TDocument> item0 : this.options) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder<TDocument> toBuilder() {
        return new Builder<>(this);
    }

    @Nonnull
    public static <TDocument> Builder builder() {
        return new Builder<>();
    }

    /**
     * Builder for {@link CompletionSuggest}.
     */
    public static class Builder<TDocument> extends SuggestBase.AbstractBuilder<Builder<TDocument>>
        implements
            CopyableBuilder<Builder<TDocument>, CompletionSuggest<TDocument>> {
        private List<CompletionSuggestOption<TDocument>> options;

        public Builder() {}

        private Builder(CompletionSuggest<TDocument> o) {
            super(o);
            this.options = _listCopy(o.options);
        }

        private Builder(Builder<TDocument> o) {
            super(o);
            this.options = _listCopy(o.options);
        }

        @Override
        @Nonnull
        public Builder<TDocument> copy() {
            return new Builder<>(this);
        }

        @Override
        @Nonnull
        protected Builder<TDocument> self() {
            return this;
        }

        /**
         * Required - API name: {@code options}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>options</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> options(List<CompletionSuggestOption<TDocument>> list) {
            this.options = _listAddAll(this.options, list);
            return this;
        }

        /**
         * Required - API name: {@code options}
         *
         * <p>
         * Adds one or more values to <code>options</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> options(CompletionSuggestOption<TDocument> value, CompletionSuggestOption<TDocument>... values) {
            this.options = _listAdd(this.options, value, values);
            return this;
        }

        /**
         * Required - API name: {@code options}
         *
         * <p>
         * Adds a value to <code>options</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> options(
            Function<CompletionSuggestOption.Builder<TDocument>, ObjectBuilder<CompletionSuggestOption<TDocument>>> fn
        ) {
            return options(fn.apply(new CompletionSuggestOption.Builder<TDocument>()).build());
        }

        /**
         * Builds a {@link CompletionSuggest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CompletionSuggest<TDocument> build() {
            _checkSingleUse();

            return new CompletionSuggest<>(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Create a JSON deserializer for CompletionSuggest.
     */
    public static <TDocument> JsonpDeserializer<CompletionSuggest<TDocument>> createCompletionSuggestDeserializer(
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        return ObjectBuilderDeserializer.createForObject(
            Builder<TDocument>::new,
            op -> CompletionSuggest.setupCompletionSuggestDeserializer(op, tDocumentDeserializer)
        );
    }

    protected static <TDocument> void setupCompletionSuggestDeserializer(
        ObjectDeserializer<CompletionSuggest.Builder<TDocument>> op,
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        setupSuggestBaseDeserializer(op);
        op.add(
            Builder::options,
            JsonpDeserializer.arrayDeserializer(CompletionSuggestOption.createCompletionSuggestOptionDeserializer(tDocumentDeserializer)),
            "options"
        );
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.options.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CompletionSuggest<?> other = (CompletionSuggest<?>) o;
        return this.options.equals(other.options);
    }
}
