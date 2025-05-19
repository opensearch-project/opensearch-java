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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.analysis.KeywordAnalyzer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class KeywordAnalyzer
    implements
        AnalyzerVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<KeywordAnalyzer.Builder, KeywordAnalyzer> {

    @Nullable
    private final String version;

    // ---------------------------------------------------------------------------------------------

    private KeywordAnalyzer(Builder builder) {
        this.version = builder.version;
    }

    public static KeywordAnalyzer of(Function<KeywordAnalyzer.Builder, ObjectBuilder<KeywordAnalyzer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Analyzer} variant kind.
     */
    @Override
    public Analyzer.Kind _analyzerKind() {
        return Analyzer.Kind.Keyword;
    }

    /**
     * API name: {@code version}
     */
    @Nullable
    public final String version() {
        return this.version;
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
        generator.write("type", "keyword");
        if (this.version != null) {
            generator.writeKey("version");
            generator.write(this.version);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link KeywordAnalyzer}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, KeywordAnalyzer> {
        @Nullable
        private String version;

        public Builder() {}

        private Builder(KeywordAnalyzer o) {
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code version}
         */
        @Nonnull
        public final Builder version(@Nullable String value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link KeywordAnalyzer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public KeywordAnalyzer build() {
            _checkSingleUse();

            return new KeywordAnalyzer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link KeywordAnalyzer}
     */
    public static final JsonpDeserializer<KeywordAnalyzer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        KeywordAnalyzer::setupKeywordAnalyzerDeserializer
    );

    protected static void setupKeywordAnalyzerDeserializer(ObjectDeserializer<KeywordAnalyzer.Builder> op) {
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        KeywordAnalyzer other = (KeywordAnalyzer) o;
        return Objects.equals(this.version, other.version);
    }
}
