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

package org.opensearch.client.opensearch._types.analysis;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.analysis.LithuanianAnalyzer

@JsonpDeserializable
public class LithuanianAnalyzer implements AnalyzerVariant, JsonpSerializable {
    private final List<String> stopwords;

    // ---------------------------------------------------------------------------------------------

    private LithuanianAnalyzer(Builder builder) {

        this.stopwords = ApiTypeHelper.unmodifiable(builder.stopwords);

    }

    public static LithuanianAnalyzer of(Function<Builder, ObjectBuilder<LithuanianAnalyzer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Analyzer variant kind.
     */
    @Override
    public Analyzer.Kind _analyzerKind() {
        return Analyzer.Kind.Lithuanian;
    }

    /**
     * API name: {@code stopwords}
     */
    public final List<String> stopwords() {
        return this.stopwords;
    }

    /**
     * Serialize this object to JSON.
     */
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

        generator.write("type", "lithuanian");

        if (ApiTypeHelper.isDefined(this.stopwords)) {
            generator.writeKey("stopwords");
            generator.writeStartArray();
            for (String item0 : this.stopwords) {
                generator.write(item0);

            }
            generator.writeEnd();

        }

    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link LithuanianAnalyzer}.
     */

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<LithuanianAnalyzer> {
        @Nullable
        private List<String> stopwords;

        /**
         * API name: {@code stopwords}
         * <p>
         * Adds all elements of <code>list</code> to <code>stopwords</code>.
         */
        public final Builder stopwords(List<String> list) {
            this.stopwords = _listAddAll(this.stopwords, list);
            return this;
        }

        /**
         * API name: {@code stopwords}
         * <p>
         * Adds one or more values to <code>stopwords</code>.
         */
        public final Builder stopwords(String value, String... values) {
            this.stopwords = _listAdd(this.stopwords, value, values);
            return this;
        }

        /**
         * Builds a {@link LithuanianAnalyzer}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public LithuanianAnalyzer build() {
            _checkSingleUse();

            return new LithuanianAnalyzer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link LithuanianAnalyzer}
     */
    public static final JsonpDeserializer<LithuanianAnalyzer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        LithuanianAnalyzer::setupLithuanianAnalyzerDeserializer
    );

    protected static void setupLithuanianAnalyzerDeserializer(ObjectDeserializer<Builder> op) {

        op.add(Builder::stopwords, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "stopwords");

        op.ignore("type");
    }

}
