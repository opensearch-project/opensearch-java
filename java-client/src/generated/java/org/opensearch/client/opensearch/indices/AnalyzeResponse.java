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

package org.opensearch.client.opensearch.indices;

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
import org.opensearch.client.opensearch.indices.analyze.AnalyzeDetail;
import org.opensearch.client.opensearch.indices.analyze.AnalyzeToken;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.analyze.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AnalyzeResponse implements PlainJsonSerializable, ToCopyableBuilder<AnalyzeResponse.Builder, AnalyzeResponse> {

    @Nullable
    private final AnalyzeDetail detail;

    @Nonnull
    private final List<AnalyzeToken> tokens;

    // ---------------------------------------------------------------------------------------------

    private AnalyzeResponse(Builder builder) {
        this.detail = builder.detail;
        this.tokens = ApiTypeHelper.unmodifiable(builder.tokens);
    }

    public static AnalyzeResponse of(Function<AnalyzeResponse.Builder, ObjectBuilder<AnalyzeResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code detail}
     */
    @Nullable
    public final AnalyzeDetail detail() {
        return this.detail;
    }

    /**
     * API name: {@code tokens}
     */
    @Nonnull
    public final List<AnalyzeToken> tokens() {
        return this.tokens;
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
        if (this.detail != null) {
            generator.writeKey("detail");
            this.detail.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.tokens)) {
            generator.writeKey("tokens");
            generator.writeStartArray();
            for (AnalyzeToken item0 : this.tokens) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link AnalyzeResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AnalyzeResponse> {
        @Nullable
        private AnalyzeDetail detail;
        @Nullable
        private List<AnalyzeToken> tokens;

        public Builder() {}

        private Builder(AnalyzeResponse o) {
            this.detail = o.detail;
            this.tokens = _listCopy(o.tokens);
        }

        private Builder(Builder o) {
            this.detail = o.detail;
            this.tokens = _listCopy(o.tokens);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code detail}
         */
        @Nonnull
        public final Builder detail(@Nullable AnalyzeDetail value) {
            this.detail = value;
            return this;
        }

        /**
         * API name: {@code detail}
         */
        @Nonnull
        public final Builder detail(Function<AnalyzeDetail.Builder, ObjectBuilder<AnalyzeDetail>> fn) {
            return detail(fn.apply(new AnalyzeDetail.Builder()).build());
        }

        /**
         * API name: {@code tokens}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>tokens</code>.
         * </p>
         */
        @Nonnull
        public final Builder tokens(List<AnalyzeToken> list) {
            this.tokens = _listAddAll(this.tokens, list);
            return this;
        }

        /**
         * API name: {@code tokens}
         *
         * <p>
         * Adds one or more values to <code>tokens</code>.
         * </p>
         */
        @Nonnull
        public final Builder tokens(AnalyzeToken value, AnalyzeToken... values) {
            this.tokens = _listAdd(this.tokens, value, values);
            return this;
        }

        /**
         * API name: {@code tokens}
         *
         * <p>
         * Adds a value to <code>tokens</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder tokens(Function<AnalyzeToken.Builder, ObjectBuilder<AnalyzeToken>> fn) {
            return tokens(fn.apply(new AnalyzeToken.Builder()).build());
        }

        /**
         * Builds a {@link AnalyzeResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AnalyzeResponse build() {
            _checkSingleUse();

            return new AnalyzeResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AnalyzeResponse}
     */
    public static final JsonpDeserializer<AnalyzeResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AnalyzeResponse::setupAnalyzeResponseDeserializer
    );

    protected static void setupAnalyzeResponseDeserializer(ObjectDeserializer<AnalyzeResponse.Builder> op) {
        op.add(Builder::detail, AnalyzeDetail._DESERIALIZER, "detail");
        op.add(Builder::tokens, JsonpDeserializer.arrayDeserializer(AnalyzeToken._DESERIALIZER), "tokens");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.detail);
        result = 31 * result + Objects.hashCode(this.tokens);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AnalyzeResponse other = (AnalyzeResponse) o;
        return Objects.equals(this.detail, other.detail) && Objects.equals(this.tokens, other.tokens);
    }
}
