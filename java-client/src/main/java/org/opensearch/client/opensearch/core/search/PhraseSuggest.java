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

import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch.core.search.Suggest.Kind;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;

import jakarta.json.stream.JsonGenerator;

@JsonpDeserializable
public class PhraseSuggest extends SuggestBase implements SuggestVariant {
    private final List<PhraseSuggestOption> options;


    private PhraseSuggest(Builder builder) {
        super(builder);

        this.options = ApiTypeHelper.unmodifiableRequired(builder.options, this, "options");

    }

    public static PhraseSuggest of(Function<Builder, ObjectBuilder<PhraseSuggest>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final List<PhraseSuggestOption> options() {
        return this.options;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

        super.serializeInternal(generator, mapper);
        if (ApiTypeHelper.isDefined(this.options)) {
            generator.writeKey("options");
            generator.writeStartArray();
            for (PhraseSuggestOption item0 : this.options) {
                item0.serialize(generator, mapper);

            }
            generator.writeEnd();

        }

    }

    public static class Builder extends SuggestBase.AbstractBuilder<Builder> implements ObjectBuilder<PhraseSuggest> {
        private List<PhraseSuggestOption> options;

        public final Builder options(List<PhraseSuggestOption> list) {
            this.options = _listAddAll(this.options, list);
            return this;
        }

        public final Builder options(PhraseSuggestOption value, PhraseSuggestOption... values) {
            this.options = _listAdd(this.options, value, values);
            return this;
        }

        public final Builder options(Function<PhraseSuggestOption.Builder, ObjectBuilder<PhraseSuggestOption>> fn) {
            return options(fn.apply(new PhraseSuggestOption.Builder()).build());
        }

        @Override
        protected Builder self() {
            return this;
        }

        public PhraseSuggest build() {
            _checkSingleUse();

            return new PhraseSuggest(this);
        }
    }

    public static final JsonpDeserializer<PhraseSuggest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
            PhraseSuggest::setupPhraseSuggestDeserializer);

    protected static void setupPhraseSuggestDeserializer(ObjectDeserializer<PhraseSuggest.Builder> op) {
        SuggestBase.setupSuggestBaseDeserializer(op);
        op.add(Builder::options, JsonpDeserializer.arrayDeserializer(PhraseSuggestOption._DESERIALIZER), "options");

    }

    @Override
    public Kind _suggestionKind() {
        return Suggest.Kind.Phrase;
    }
}
