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

import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.NamedDeserializer;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch.core.search.SearchResult;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.search.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SearchResponse<TDocument> extends SearchResult<TDocument>
    implements
        ToCopyableBuilder<SearchResponse.Builder<TDocument>, SearchResponse<TDocument>> {

    // ---------------------------------------------------------------------------------------------

    private SearchResponse(Builder<TDocument> builder) {
        super(builder);
    }

    public static <TDocument> SearchResponse<TDocument> of(
        Function<SearchResponse.Builder<TDocument>, ObjectBuilder<SearchResponse<TDocument>>> fn
    ) {
        return fn.apply(new Builder<>()).build();
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
     * Builder for {@link SearchResponse}.
     */
    public static class Builder<TDocument> extends SearchResult.AbstractBuilder<TDocument, Builder<TDocument>>
        implements
            CopyableBuilder<Builder<TDocument>, SearchResponse<TDocument>> {

        public Builder() {}

        private Builder(SearchResponse<TDocument> o) {
            super(o);
        }

        private Builder(Builder<TDocument> o) {
            super(o);
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
         * Builds a {@link SearchResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SearchResponse<TDocument> build() {
            _checkSingleUse();

            return new SearchResponse<>(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Create a JSON deserializer for SearchResponse.
     */
    public static <TDocument> JsonpDeserializer<SearchResponse<TDocument>> createSearchResponseDeserializer(
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        return ObjectBuilderDeserializer.createForObject(
            Builder<TDocument>::new,
            op -> SearchResponse.setupSearchResponseDeserializer(op, tDocumentDeserializer)
        );
    }

    /**
     * Json deserializer for {@link SearchResponse} based on named deserializers provided by the calling {@code JsonMapper}.
     */
    public static final JsonpDeserializer<SearchResponse<Object>> _DESERIALIZER = createSearchResponseDeserializer(
        new NamedDeserializer<>("org.opensearch.client:Deserializer:_global.search.TDocument")
    );

    protected static <TDocument> void setupSearchResponseDeserializer(
        ObjectDeserializer<SearchResponse.Builder<TDocument>> op,
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        setupSearchResultDeserializer(op, tDocumentDeserializer);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        return true;
    }
}
