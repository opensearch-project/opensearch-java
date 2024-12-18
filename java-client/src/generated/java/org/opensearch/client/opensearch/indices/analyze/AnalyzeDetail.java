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

package org.opensearch.client.opensearch.indices.analyze;

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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.analyze.AnalyzeDetail

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AnalyzeDetail implements PlainJsonSerializable, ToCopyableBuilder<AnalyzeDetail.Builder, AnalyzeDetail> {

    @Nullable
    private final AnalyzerDetail analyzer;

    @Nonnull
    private final List<CharFilterDetail> charfilters;

    private final boolean customAnalyzer;

    @Nonnull
    private final List<TokenDetail> tokenfilters;

    @Nullable
    private final TokenDetail tokenizer;

    // ---------------------------------------------------------------------------------------------

    private AnalyzeDetail(Builder builder) {
        this.analyzer = builder.analyzer;
        this.charfilters = ApiTypeHelper.unmodifiable(builder.charfilters);
        this.customAnalyzer = ApiTypeHelper.requireNonNull(builder.customAnalyzer, this, "customAnalyzer");
        this.tokenfilters = ApiTypeHelper.unmodifiable(builder.tokenfilters);
        this.tokenizer = builder.tokenizer;
    }

    public static AnalyzeDetail of(Function<AnalyzeDetail.Builder, ObjectBuilder<AnalyzeDetail>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code analyzer}
     */
    @Nullable
    public final AnalyzerDetail analyzer() {
        return this.analyzer;
    }

    /**
     * API name: {@code charfilters}
     */
    @Nonnull
    public final List<CharFilterDetail> charfilters() {
        return this.charfilters;
    }

    /**
     * Required - API name: {@code custom_analyzer}
     */
    public final boolean customAnalyzer() {
        return this.customAnalyzer;
    }

    /**
     * API name: {@code tokenfilters}
     */
    @Nonnull
    public final List<TokenDetail> tokenfilters() {
        return this.tokenfilters;
    }

    /**
     * API name: {@code tokenizer}
     */
    @Nullable
    public final TokenDetail tokenizer() {
        return this.tokenizer;
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
        if (this.analyzer != null) {
            generator.writeKey("analyzer");
            this.analyzer.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.charfilters)) {
            generator.writeKey("charfilters");
            generator.writeStartArray();
            for (CharFilterDetail item0 : this.charfilters) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("custom_analyzer");
        generator.write(this.customAnalyzer);

        if (ApiTypeHelper.isDefined(this.tokenfilters)) {
            generator.writeKey("tokenfilters");
            generator.writeStartArray();
            for (TokenDetail item0 : this.tokenfilters) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.tokenizer != null) {
            generator.writeKey("tokenizer");
            this.tokenizer.serialize(generator, mapper);
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
     * Builder for {@link AnalyzeDetail}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AnalyzeDetail> {
        @Nullable
        private AnalyzerDetail analyzer;
        @Nullable
        private List<CharFilterDetail> charfilters;
        private Boolean customAnalyzer;
        @Nullable
        private List<TokenDetail> tokenfilters;
        @Nullable
        private TokenDetail tokenizer;

        public Builder() {}

        private Builder(AnalyzeDetail o) {
            this.analyzer = o.analyzer;
            this.charfilters = _listCopy(o.charfilters);
            this.customAnalyzer = o.customAnalyzer;
            this.tokenfilters = _listCopy(o.tokenfilters);
            this.tokenizer = o.tokenizer;
        }

        private Builder(Builder o) {
            this.analyzer = o.analyzer;
            this.charfilters = _listCopy(o.charfilters);
            this.customAnalyzer = o.customAnalyzer;
            this.tokenfilters = _listCopy(o.tokenfilters);
            this.tokenizer = o.tokenizer;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code analyzer}
         */
        @Nonnull
        public final Builder analyzer(@Nullable AnalyzerDetail value) {
            this.analyzer = value;
            return this;
        }

        /**
         * API name: {@code analyzer}
         */
        @Nonnull
        public final Builder analyzer(Function<AnalyzerDetail.Builder, ObjectBuilder<AnalyzerDetail>> fn) {
            return analyzer(fn.apply(new AnalyzerDetail.Builder()).build());
        }

        /**
         * API name: {@code charfilters}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>charfilters</code>.
         * </p>
         */
        @Nonnull
        public final Builder charfilters(List<CharFilterDetail> list) {
            this.charfilters = _listAddAll(this.charfilters, list);
            return this;
        }

        /**
         * API name: {@code charfilters}
         *
         * <p>
         * Adds one or more values to <code>charfilters</code>.
         * </p>
         */
        @Nonnull
        public final Builder charfilters(CharFilterDetail value, CharFilterDetail... values) {
            this.charfilters = _listAdd(this.charfilters, value, values);
            return this;
        }

        /**
         * API name: {@code charfilters}
         *
         * <p>
         * Adds a value to <code>charfilters</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder charfilters(Function<CharFilterDetail.Builder, ObjectBuilder<CharFilterDetail>> fn) {
            return charfilters(fn.apply(new CharFilterDetail.Builder()).build());
        }

        /**
         * Required - API name: {@code custom_analyzer}
         */
        @Nonnull
        public final Builder customAnalyzer(boolean value) {
            this.customAnalyzer = value;
            return this;
        }

        /**
         * API name: {@code tokenfilters}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>tokenfilters</code>.
         * </p>
         */
        @Nonnull
        public final Builder tokenfilters(List<TokenDetail> list) {
            this.tokenfilters = _listAddAll(this.tokenfilters, list);
            return this;
        }

        /**
         * API name: {@code tokenfilters}
         *
         * <p>
         * Adds one or more values to <code>tokenfilters</code>.
         * </p>
         */
        @Nonnull
        public final Builder tokenfilters(TokenDetail value, TokenDetail... values) {
            this.tokenfilters = _listAdd(this.tokenfilters, value, values);
            return this;
        }

        /**
         * API name: {@code tokenfilters}
         *
         * <p>
         * Adds a value to <code>tokenfilters</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder tokenfilters(Function<TokenDetail.Builder, ObjectBuilder<TokenDetail>> fn) {
            return tokenfilters(fn.apply(new TokenDetail.Builder()).build());
        }

        /**
         * API name: {@code tokenizer}
         */
        @Nonnull
        public final Builder tokenizer(@Nullable TokenDetail value) {
            this.tokenizer = value;
            return this;
        }

        /**
         * API name: {@code tokenizer}
         */
        @Nonnull
        public final Builder tokenizer(Function<TokenDetail.Builder, ObjectBuilder<TokenDetail>> fn) {
            return tokenizer(fn.apply(new TokenDetail.Builder()).build());
        }

        /**
         * Builds a {@link AnalyzeDetail}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AnalyzeDetail build() {
            _checkSingleUse();

            return new AnalyzeDetail(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AnalyzeDetail}
     */
    public static final JsonpDeserializer<AnalyzeDetail> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AnalyzeDetail::setupAnalyzeDetailDeserializer
    );

    protected static void setupAnalyzeDetailDeserializer(ObjectDeserializer<AnalyzeDetail.Builder> op) {
        op.add(Builder::analyzer, AnalyzerDetail._DESERIALIZER, "analyzer");
        op.add(Builder::charfilters, JsonpDeserializer.arrayDeserializer(CharFilterDetail._DESERIALIZER), "charfilters");
        op.add(Builder::customAnalyzer, JsonpDeserializer.booleanDeserializer(), "custom_analyzer");
        op.add(Builder::tokenfilters, JsonpDeserializer.arrayDeserializer(TokenDetail._DESERIALIZER), "tokenfilters");
        op.add(Builder::tokenizer, TokenDetail._DESERIALIZER, "tokenizer");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + Objects.hashCode(this.charfilters);
        result = 31 * result + Boolean.hashCode(this.customAnalyzer);
        result = 31 * result + Objects.hashCode(this.tokenfilters);
        result = 31 * result + Objects.hashCode(this.tokenizer);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AnalyzeDetail other = (AnalyzeDetail) o;
        return Objects.equals(this.analyzer, other.analyzer)
            && Objects.equals(this.charfilters, other.charfilters)
            && this.customAnalyzer == other.customAnalyzer
            && Objects.equals(this.tokenfilters, other.tokenfilters)
            && Objects.equals(this.tokenizer, other.tokenizer);
    }
}
