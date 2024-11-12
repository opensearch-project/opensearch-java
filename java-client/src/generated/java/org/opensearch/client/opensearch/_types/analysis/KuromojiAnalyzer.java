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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.analysis.KuromojiAnalyzer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class KuromojiAnalyzer implements AnalyzerVariant, PlainJsonSerializable {

    @Nonnull
    private final KuromojiTokenizationMode mode;

    @Nullable
    private final String userDictionary;

    // ---------------------------------------------------------------------------------------------

    private KuromojiAnalyzer(Builder builder) {
        this.mode = ApiTypeHelper.requireNonNull(builder.mode, this, "mode");
        this.userDictionary = builder.userDictionary;
    }

    public static KuromojiAnalyzer of(Function<KuromojiAnalyzer.Builder, ObjectBuilder<KuromojiAnalyzer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Analyzer} variant kind.
     */
    @Override
    public Analyzer.Kind _analyzerKind() {
        return Analyzer.Kind.Kuromoji;
    }

    /**
     * Required - API name: {@code mode}
     */
    @Nonnull
    public final KuromojiTokenizationMode mode() {
        return this.mode;
    }

    /**
     * API name: {@code user_dictionary}
     */
    @Nullable
    public final String userDictionary() {
        return this.userDictionary;
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
        generator.write("type", "kuromoji");
        generator.writeKey("mode");
        this.mode.serialize(generator, mapper);

        if (this.userDictionary != null) {
            generator.writeKey("user_dictionary");
            generator.write(this.userDictionary);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link KuromojiAnalyzer}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<KuromojiAnalyzer> {
        private KuromojiTokenizationMode mode;
        @Nullable
        private String userDictionary;

        /**
         * Required - API name: {@code mode}
         */
        public final Builder mode(KuromojiTokenizationMode value) {
            this.mode = value;
            return this;
        }

        /**
         * API name: {@code user_dictionary}
         */
        public final Builder userDictionary(@Nullable String value) {
            this.userDictionary = value;
            return this;
        }

        /**
         * Builds a {@link KuromojiAnalyzer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public KuromojiAnalyzer build() {
            _checkSingleUse();

            return new KuromojiAnalyzer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link KuromojiAnalyzer}
     */
    public static final JsonpDeserializer<KuromojiAnalyzer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        KuromojiAnalyzer::setupKuromojiAnalyzerDeserializer
    );

    protected static void setupKuromojiAnalyzerDeserializer(ObjectDeserializer<KuromojiAnalyzer.Builder> op) {
        op.add(Builder::mode, KuromojiTokenizationMode._DESERIALIZER, "mode");
        op.add(Builder::userDictionary, JsonpDeserializer.stringDeserializer(), "user_dictionary");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.mode.hashCode();
        result = 31 * result + Objects.hashCode(this.userDictionary);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        KuromojiAnalyzer other = (KuromojiAnalyzer) o;
        return this.mode.equals(other.mode) && Objects.equals(this.userDictionary, other.userDictionary);
    }
}
