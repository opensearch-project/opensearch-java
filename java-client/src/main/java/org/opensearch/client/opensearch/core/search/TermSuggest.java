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

    public static final JsonpDeserializer<TermSuggest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TermSuggest::setupTermSuggestDeserializer
    );

    protected static void setupTermSuggestDeserializer(ObjectDeserializer<TermSuggest.Builder> op) {
        SuggestBase.setupSuggestBaseDeserializer(op);
        op.add(Builder::options, JsonpDeserializer.arrayDeserializer(TermSuggestOption._DESERIALIZER), "options");

    }

    @Override
    public Kind _suggestionKind() {
        return Suggest.Kind.Term;
    }
}
