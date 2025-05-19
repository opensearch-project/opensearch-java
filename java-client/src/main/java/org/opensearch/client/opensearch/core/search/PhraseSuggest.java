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

package org.opensearch.client.opensearch.core.search;

import jakarta.json.stream.JsonGenerator;
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

    public static final JsonpDeserializer<PhraseSuggest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PhraseSuggest::setupPhraseSuggestDeserializer
    );

    protected static void setupPhraseSuggestDeserializer(ObjectDeserializer<PhraseSuggest.Builder> op) {
        SuggestBase.setupSuggestBaseDeserializer(op);
        op.add(Builder::options, JsonpDeserializer.arrayDeserializer(PhraseSuggestOption._DESERIALIZER), "options");

    }

    @Override
    public Kind _suggestionKind() {
        return Suggest.Kind.Phrase;
    }
}
