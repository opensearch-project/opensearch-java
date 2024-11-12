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

package org.opensearch.client.opensearch._types.analysis;

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
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.analysis.StandardAnalyzer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class StandardAnalyzer implements AnalyzerVariant, PlainJsonSerializable {

    @Nullable
    private final Integer maxTokenLength;

    @Nonnull
    private final List<String> stopwords;

    // ---------------------------------------------------------------------------------------------

    private StandardAnalyzer(Builder builder) {
        this.maxTokenLength = builder.maxTokenLength;
        this.stopwords = ApiTypeHelper.unmodifiable(builder.stopwords);
    }

    public static StandardAnalyzer of(Function<StandardAnalyzer.Builder, ObjectBuilder<StandardAnalyzer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Analyzer} variant kind.
     */
    @Override
    public Analyzer.Kind _analyzerKind() {
        return Analyzer.Kind.Standard;
    }

    /**
     * API name: {@code max_token_length}
     */
    @Nullable
    public final Integer maxTokenLength() {
        return this.maxTokenLength;
    }

    /**
     * API name: {@code stopwords}
     */
    @Nonnull
    public final List<String> stopwords() {
        return this.stopwords;
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
        generator.write("type", "standard");
        if (this.maxTokenLength != null) {
            generator.writeKey("max_token_length");
            generator.write(this.maxTokenLength);
        }

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
     * Builder for {@link StandardAnalyzer}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<StandardAnalyzer> {
        @Nullable
        private Integer maxTokenLength;
        @Nullable
        private List<String> stopwords;

        /**
         * API name: {@code max_token_length}
         */
        public final Builder maxTokenLength(@Nullable Integer value) {
            this.maxTokenLength = value;
            return this;
        }

        /**
         * API name: {@code stopwords}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>stopwords</code>.
         * </p>
         */
        public final Builder stopwords(List<String> list) {
            this.stopwords = _listAddAll(this.stopwords, list);
            return this;
        }

        /**
         * API name: {@code stopwords}
         *
         * <p>
         * Adds one or more values to <code>stopwords</code>.
         * </p>
         */
        public final Builder stopwords(String value, String... values) {
            this.stopwords = _listAdd(this.stopwords, value, values);
            return this;
        }

        /**
         * Builds a {@link StandardAnalyzer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public StandardAnalyzer build() {
            _checkSingleUse();

            return new StandardAnalyzer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link StandardAnalyzer}
     */
    public static final JsonpDeserializer<StandardAnalyzer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        StandardAnalyzer::setupStandardAnalyzerDeserializer
    );

    protected static void setupStandardAnalyzerDeserializer(ObjectDeserializer<StandardAnalyzer.Builder> op) {
        op.add(Builder::maxTokenLength, JsonpDeserializer.integerDeserializer(), "max_token_length");
        op.add(Builder::stopwords, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "stopwords");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.maxTokenLength);
        result = 31 * result + Objects.hashCode(this.stopwords);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        StandardAnalyzer other = (StandardAnalyzer) o;
        return Objects.equals(this.maxTokenLength, other.maxTokenLength) && Objects.equals(this.stopwords, other.stopwords);
    }
}
