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

package org.opensearch.client.opensearch.core;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.NamedDeserializer;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.InlineGet;
import org.opensearch.client.opensearch.core.explain.Explanation;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.explain.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ExplainResponse<TDocument>
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ExplainResponse.Builder<TDocument>, ExplainResponse<TDocument>> {

    @Nullable
    private final Explanation explanation;

    @Nullable
    private final InlineGet<TDocument> get;

    @Nonnull
    private final String id;

    @Nonnull
    private final String index;

    private final boolean matched;

    // ---------------------------------------------------------------------------------------------

    private ExplainResponse(Builder<TDocument> builder) {
        this.explanation = builder.explanation;
        this.get = builder.get;
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.matched = ApiTypeHelper.requireNonNull(builder.matched, this, "matched");
    }

    public static <TDocument> ExplainResponse<TDocument> of(
        Function<ExplainResponse.Builder<TDocument>, ObjectBuilder<ExplainResponse<TDocument>>> fn
    ) {
        return fn.apply(new Builder<>()).build();
    }

    /**
     * API name: {@code explanation}
     */
    @Nullable
    public final Explanation explanation() {
        return this.explanation;
    }

    /**
     * API name: {@code get}
     */
    @Nullable
    public final InlineGet<TDocument> get() {
        return this.get;
    }

    /**
     * Required - API name: {@code _id}
     */
    @Nonnull
    public final String id() {
        return this.id;
    }

    /**
     * Required - API name: {@code _index}
     */
    @Nonnull
    public final String index() {
        return this.index;
    }

    /**
     * Required - API name: {@code matched}
     */
    public final boolean matched() {
        return this.matched;
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
        if (this.explanation != null) {
            generator.writeKey("explanation");
            this.explanation.serialize(generator, mapper);
        }

        if (this.get != null) {
            generator.writeKey("get");
            this.get.serialize(generator, mapper);
        }

        generator.writeKey("_id");
        generator.write(this.id);

        generator.writeKey("_index");
        generator.write(this.index);

        generator.writeKey("matched");
        generator.write(this.matched);
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder<TDocument> toBuilder() {
        return new Builder<>(this);
    }

    @Nonnull
    public static <TDocument> Builder builder() {
        return new Builder<>();
    }

    /**
     * Builder for {@link ExplainResponse}.
     */
    public static class Builder<TDocument> extends ObjectBuilderBase
        implements
            CopyableBuilder<Builder<TDocument>, ExplainResponse<TDocument>> {
        @Nullable
        private Explanation explanation;
        @Nullable
        private InlineGet<TDocument> get;
        private String id;
        private String index;
        private Boolean matched;

        public Builder() {}

        private Builder(ExplainResponse<TDocument> o) {
            this.explanation = o.explanation;
            this.get = o.get;
            this.id = o.id;
            this.index = o.index;
            this.matched = o.matched;
        }

        private Builder(Builder<TDocument> o) {
            this.explanation = o.explanation;
            this.get = o.get;
            this.id = o.id;
            this.index = o.index;
            this.matched = o.matched;
        }

        @Override
        @Nonnull
        public Builder<TDocument> copy() {
            return new Builder<>(this);
        }

        /**
         * API name: {@code explanation}
         */
        @Nonnull
        public final Builder<TDocument> explanation(@Nullable Explanation value) {
            this.explanation = value;
            return this;
        }

        /**
         * API name: {@code explanation}
         */
        @Nonnull
        public final Builder<TDocument> explanation(Function<Explanation.Builder, ObjectBuilder<Explanation>> fn) {
            return explanation(fn.apply(new Explanation.Builder()).build());
        }

        /**
         * API name: {@code get}
         */
        @Nonnull
        public final Builder<TDocument> get(@Nullable InlineGet<TDocument> value) {
            this.get = value;
            return this;
        }

        /**
         * API name: {@code get}
         */
        @Nonnull
        public final Builder<TDocument> get(Function<InlineGet.Builder<TDocument>, ObjectBuilder<InlineGet<TDocument>>> fn) {
            return get(fn.apply(new InlineGet.Builder<TDocument>()).build());
        }

        /**
         * Required - API name: {@code _id}
         */
        @Nonnull
        public final Builder<TDocument> id(String value) {
            this.id = value;
            return this;
        }

        /**
         * Required - API name: {@code _index}
         */
        @Nonnull
        public final Builder<TDocument> index(String value) {
            this.index = value;
            return this;
        }

        /**
         * Required - API name: {@code matched}
         */
        @Nonnull
        public final Builder<TDocument> matched(boolean value) {
            this.matched = value;
            return this;
        }

        /**
         * Builds a {@link ExplainResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExplainResponse<TDocument> build() {
            _checkSingleUse();

            return new ExplainResponse<>(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Create a JSON deserializer for ExplainResponse.
     */
    public static <TDocument> JsonpDeserializer<ExplainResponse<TDocument>> createExplainResponseDeserializer(
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        return ObjectBuilderDeserializer.createForObject(
            Builder<TDocument>::new,
            op -> ExplainResponse.setupExplainResponseDeserializer(op, tDocumentDeserializer)
        );
    }

    /**
     * Json deserializer for {@link ExplainResponse} based on named deserializers provided by the calling {@code JsonMapper}.
     */
    public static final JsonpDeserializer<ExplainResponse<Object>> _DESERIALIZER = createExplainResponseDeserializer(
        new NamedDeserializer<>("org.opensearch.client:Deserializer:_global.explain.TDocument")
    );

    protected static <TDocument> void setupExplainResponseDeserializer(
        ObjectDeserializer<ExplainResponse.Builder<TDocument>> op,
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        op.add(Builder::explanation, Explanation._DESERIALIZER, "explanation");
        op.add(Builder::get, InlineGet.createInlineGetDeserializer(tDocumentDeserializer), "get");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "_id");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "_index");
        op.add(Builder::matched, JsonpDeserializer.booleanDeserializer(), "matched");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.explanation);
        result = 31 * result + Objects.hashCode(this.get);
        result = 31 * result + this.id.hashCode();
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Boolean.hashCode(this.matched);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExplainResponse<?> other = (ExplainResponse<?>) o;
        return Objects.equals(this.explanation, other.explanation)
            && Objects.equals(this.get, other.get)
            && this.id.equals(other.id)
            && this.index.equals(other.index)
            && this.matched == other.matched;
    }
}
