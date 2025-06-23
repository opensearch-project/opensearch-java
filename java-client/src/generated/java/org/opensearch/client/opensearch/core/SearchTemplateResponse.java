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
import org.opensearch.client.opensearch.core.search.SearchResult;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.search_template.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SearchTemplateResponse<TDocument> extends SearchResult<TDocument>
    implements
        ToCopyableBuilder<SearchTemplateResponse.Builder<TDocument>, SearchTemplateResponse<TDocument>> {

    @Nullable
    private final Integer status;

    // ---------------------------------------------------------------------------------------------

    private SearchTemplateResponse(Builder<TDocument> builder) {
        super(builder);
        this.status = builder.status;
    }

    public static <TDocument> SearchTemplateResponse<TDocument> of(
        Function<SearchTemplateResponse.Builder<TDocument>, ObjectBuilder<SearchTemplateResponse<TDocument>>> fn
    ) {
        return fn.apply(new Builder<>()).build();
    }

    /**
     * API name: {@code status}
     */
    @Nullable
    public final Integer status() {
        return this.status;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.status != null) {
            generator.writeKey("status");
            generator.write(this.status);
        }
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
     * Builder for {@link SearchTemplateResponse}.
     */
    public static class Builder<TDocument> extends SearchResult.AbstractBuilder<TDocument, Builder<TDocument>>
        implements
            CopyableBuilder<Builder<TDocument>, SearchTemplateResponse<TDocument>> {
        @Nullable
        private Integer status;

        public Builder() {}

        private Builder(SearchTemplateResponse<TDocument> o) {
            super(o);
            this.status = o.status;
        }

        private Builder(Builder<TDocument> o) {
            super(o);
            this.status = o.status;
        }

        @Override
        @Nonnull
        public Builder<TDocument> copy() {
            return new Builder<>(this);
        }

        @Override
        @Nonnull
        protected Builder<TDocument> self() {
            return this;
        }

        /**
         * API name: {@code status}
         */
        @Nonnull
        public final Builder<TDocument> status(@Nullable Integer value) {
            this.status = value;
            return this;
        }

        /**
         * Builds a {@link SearchTemplateResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SearchTemplateResponse<TDocument> build() {
            _checkSingleUse();

            return new SearchTemplateResponse<>(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Create a JSON deserializer for SearchTemplateResponse.
     */
    public static <TDocument> JsonpDeserializer<SearchTemplateResponse<TDocument>> createSearchTemplateResponseDeserializer(
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        return ObjectBuilderDeserializer.createForObject(
            Builder<TDocument>::new,
            op -> SearchTemplateResponse.setupSearchTemplateResponseDeserializer(op, tDocumentDeserializer)
        );
    }

    /**
     * Json deserializer for {@link SearchTemplateResponse} based on named deserializers provided by the calling {@code JsonMapper}.
     */
    public static final JsonpDeserializer<SearchTemplateResponse<Object>> _DESERIALIZER = createSearchTemplateResponseDeserializer(
        new NamedDeserializer<>("org.opensearch.client:Deserializer:_global.search_template.TDocument")
    );

    protected static <TDocument> void setupSearchTemplateResponseDeserializer(
        ObjectDeserializer<SearchTemplateResponse.Builder<TDocument>> op,
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        setupSearchResultDeserializer(op, tDocumentDeserializer);
        op.add(Builder::status, JsonpDeserializer.integerDeserializer(), "status");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.status);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SearchTemplateResponse<?> other = (SearchTemplateResponse<?>) o;
        return Objects.equals(this.status, other.status);
    }
}
