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

// typedef: _types.analysis.SwedishAnalyzer

@JsonpDeserializable
public class SwedishAnalyzer implements AnalyzerVariant, JsonpSerializable {
    private final List<String> stopwords;

    // ---------------------------------------------------------------------------------------------

    private SwedishAnalyzer(Builder builder) {

        this.stopwords = ApiTypeHelper.unmodifiable(builder.stopwords);

    }

    public static SwedishAnalyzer of(Function<Builder, ObjectBuilder<SwedishAnalyzer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Analyzer variant kind.
     */
    @Override
    public Analyzer.Kind _analyzerKind() {
        return Analyzer.Kind.Swedish;
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

        generator.write("type", "swedish");

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
     * Builder for {@link SwedishAnalyzer}.
     */

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<SwedishAnalyzer> {
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
         * Builds a {@link SwedishAnalyzer}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public SwedishAnalyzer build() {
            _checkSingleUse();

            return new SwedishAnalyzer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SwedishAnalyzer}
     */
    public static final JsonpDeserializer<SwedishAnalyzer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SwedishAnalyzer::setupSwedishAnalyzerDeserializer
    );

    protected static void setupSwedishAnalyzerDeserializer(ObjectDeserializer<Builder> op) {

        op.add(Builder::stopwords, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "stopwords");

        op.ignore("type");
    }

}
