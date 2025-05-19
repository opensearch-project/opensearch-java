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

package org.opensearch.client.opensearch.core.rank_eval;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: core.rank_eval.DocumentRating

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DocumentRating implements PlainJsonSerializable, ToCopyableBuilder<DocumentRating.Builder, DocumentRating> {

    @Nonnull
    private final String id;

    @Nonnull
    private final String index;

    private final int rating;

    // ---------------------------------------------------------------------------------------------

    private DocumentRating(Builder builder) {
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.rating = ApiTypeHelper.requireNonNull(builder.rating, this, "rating");
    }

    public static DocumentRating of(Function<DocumentRating.Builder, ObjectBuilder<DocumentRating>> fn) {
        return fn.apply(new Builder()).build();
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
     * Required - The document's relevance with regard to the specified search request.
     * <p>
     * API name: {@code rating}
     * </p>
     */
    public final int rating() {
        return this.rating;
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
        generator.writeKey("_id");
        generator.write(this.id);

        generator.writeKey("_index");
        generator.write(this.index);

        generator.writeKey("rating");
        generator.write(this.rating);
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
     * Builder for {@link DocumentRating}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DocumentRating> {
        private String id;
        private String index;
        private Integer rating;

        public Builder() {}

        private Builder(DocumentRating o) {
            this.id = o.id;
            this.index = o.index;
            this.rating = o.rating;
        }

        private Builder(Builder o) {
            this.id = o.id;
            this.index = o.index;
            this.rating = o.rating;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code _id}
         */
        @Nonnull
        public final Builder id(String value) {
            this.id = value;
            return this;
        }

        /**
         * Required - API name: {@code _index}
         */
        @Nonnull
        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        /**
         * Required - The document's relevance with regard to the specified search request.
         * <p>
         * API name: {@code rating}
         * </p>
         */
        @Nonnull
        public final Builder rating(int value) {
            this.rating = value;
            return this;
        }

        /**
         * Builds a {@link DocumentRating}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DocumentRating build() {
            _checkSingleUse();

            return new DocumentRating(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DocumentRating}
     */
    public static final JsonpDeserializer<DocumentRating> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DocumentRating::setupDocumentRatingDeserializer
    );

    protected static void setupDocumentRatingDeserializer(ObjectDeserializer<DocumentRating.Builder> op) {
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "_id");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "_index");
        op.add(Builder::rating, JsonpDeserializer.integerDeserializer(), "rating");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.id.hashCode();
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Integer.hashCode(this.rating);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DocumentRating other = (DocumentRating) o;
        return this.id.equals(other.id) && this.index.equals(other.index) && this.rating == other.rating;
    }
}
