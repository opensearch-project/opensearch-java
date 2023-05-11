/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core.search;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializer;
import org.opensearch.client.json.NamedDeserializer;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch.core.search.Suggest.Kind;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;

import jakarta.json.stream.JsonGenerator;

@JsonpDeserializable
public class CompletionSuggest<TDocument> extends SuggestBase implements SuggestVariant {
    private final List<CompletionSuggestOption<TDocument>> options;

    @Nullable
    private final JsonpSerializer<TDocument> tDocumentSerializer;

    private CompletionSuggest(Builder<TDocument> builder) {
        super(builder);

        this.options = ApiTypeHelper.unmodifiableRequired(builder.options, this, "options");
        this.tDocumentSerializer = builder.tDocumentSerializer;

    }

    public static <TDocument> CompletionSuggest<TDocument> of(
            Function<Builder<TDocument>, ObjectBuilder<CompletionSuggest<TDocument>>> fn) {
        return fn.apply(new Builder<>()).build();
    }

    public final List<CompletionSuggestOption<TDocument>> options() {
        return this.options;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

        super.serializeInternal(generator, mapper);
        if (ApiTypeHelper.isDefined(this.options)) {
            generator.writeKey("options");
            generator.writeStartArray();
            for (CompletionSuggestOption<TDocument> item0 : this.options) {
                item0.serialize(generator, mapper);

            }
            generator.writeEnd();

        }

    }

    public static class Builder<TDocument> extends SuggestBase.AbstractBuilder<Builder<TDocument>>
            implements
            ObjectBuilder<CompletionSuggest<TDocument>> {
        private List<CompletionSuggestOption<TDocument>> options;

        @Nullable
        private JsonpSerializer<TDocument> tDocumentSerializer;

        public final Builder<TDocument> options(List<CompletionSuggestOption<TDocument>> list) {
            this.options = _listAddAll(this.options, list);
            return this;
        }

        public final Builder<TDocument> options(CompletionSuggestOption<TDocument> value,
                CompletionSuggestOption<TDocument>... values) {
            this.options = _listAdd(this.options, value, values);
            return this;
        }

        public final Builder<TDocument> options(
                Function<CompletionSuggestOption.Builder<TDocument>, ObjectBuilder<CompletionSuggestOption<TDocument>>> fn) {
            return options(fn.apply(new CompletionSuggestOption.Builder<TDocument>()).build());
        }

        public final Builder<TDocument> tDocumentSerializer(@Nullable JsonpSerializer<TDocument> value) {
            this.tDocumentSerializer = value;
            return this;
        }

        @Override
        protected Builder<TDocument> self() {
            return this;
        }

        public CompletionSuggest<TDocument> build() {
            _checkSingleUse();

            return new CompletionSuggest<TDocument>(this);
        }
    }

    public static <TDocument> JsonpDeserializer<CompletionSuggest<TDocument>> createCompletionSuggestDeserializer(
            JsonpDeserializer<TDocument> tDocumentDeserializer) {
        return ObjectBuilderDeserializer.createForObject((Supplier<Builder<TDocument>>) Builder::new,
                op -> CompletionSuggest.setupCompletionSuggestDeserializer(op, tDocumentDeserializer));
    };

    public static final JsonpDeserializer<CompletionSuggest<Object>> _DESERIALIZER = JsonpDeserializer
            .lazy(() -> createCompletionSuggestDeserializer(
                    new NamedDeserializer<>("org.opensearch.client:Deserializer:_global.search._types.TDocument")));

    protected static <TDocument> void setupCompletionSuggestDeserializer(
            ObjectDeserializer<CompletionSuggest.Builder<TDocument>> op,
            JsonpDeserializer<TDocument> tDocumentDeserializer) {
        SuggestBase.setupSuggestBaseDeserializer(op);
        op.add(Builder::options,
                JsonpDeserializer.arrayDeserializer(
                        CompletionSuggestOption.createCompletionSuggestOptionDeserializer(tDocumentDeserializer)),
                "options");

    }

    @Override
    public Kind _suggestionKind() {
        return Suggest.Kind.Completion;
    }
    
}
