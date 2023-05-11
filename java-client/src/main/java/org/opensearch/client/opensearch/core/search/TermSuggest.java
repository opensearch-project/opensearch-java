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
public class TermSuggest extends SuggestBase implements SuggestVariant {
    private final List<TermSuggestOption> options;

    private TermSuggest(Builder builder) {
        super(builder);

        this.options = ApiTypeHelper.unmodifiableRequired(builder.options, this, "options");

    }

    public static TermSuggest of(Function<Builder, ObjectBuilder<TermSuggest>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final List<TermSuggestOption> options() {
        return this.options;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

        super.serializeInternal(generator, mapper);
        if (ApiTypeHelper.isDefined(this.options)) {
            generator.writeKey("options");
            generator.writeStartArray();
            for (TermSuggestOption item0 : this.options) {
                item0.serialize(generator, mapper);

            }
            generator.writeEnd();

        }

    }

    public static class Builder extends SuggestBase.AbstractBuilder<Builder> implements ObjectBuilder<TermSuggest> {
        private List<TermSuggestOption> options;

        public final Builder options(List<TermSuggestOption> list) {
            this.options = _listAddAll(this.options, list);
            return this;
        }

        public final Builder options(TermSuggestOption value, TermSuggestOption... values) {
            this.options = _listAdd(this.options, value, values);
            return this;
        }

        public final Builder options(Function<TermSuggestOption.Builder, ObjectBuilder<TermSuggestOption>> fn) {
            return options(fn.apply(new TermSuggestOption.Builder()).build());
        }

        @Override
        protected Builder self() {
            return this;
        }

        public TermSuggest build() {
            _checkSingleUse();

            return new TermSuggest(this);
        }
    }

    public static final JsonpDeserializer<TermSuggest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
            TermSuggest::setupTermSuggestDeserializer);

    protected static void setupTermSuggestDeserializer(ObjectDeserializer<TermSuggest.Builder> op) {
        SuggestBase.setupSuggestBaseDeserializer(op);
        op.add(Builder::options, JsonpDeserializer.arrayDeserializer(TermSuggestOption._DESERIALIZER), "options");

    }

    @Override
    public Kind _suggestionKind() {
        return Suggest.Kind.Term;
    }
}
