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

package org.opensearch.client.opensearch.search_relevance;

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

// typedef: search_relevance.DocumentRatingUpdate

/**
 * A single document rating to update.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DocumentRatingUpdate implements PlainJsonSerializable, ToCopyableBuilder<DocumentRatingUpdate.Builder, DocumentRatingUpdate> {

    @Nonnull
    private final String docId;

    @Nonnull
    private final String rating;

    // ---------------------------------------------------------------------------------------------

    private DocumentRatingUpdate(Builder builder) {
        this.docId = ApiTypeHelper.requireNonNull(builder.docId, this, "docId");
        this.rating = ApiTypeHelper.requireNonNull(builder.rating, this, "rating");
    }

    public static DocumentRatingUpdate of(Function<DocumentRatingUpdate.Builder, ObjectBuilder<DocumentRatingUpdate>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The document id whose rating is being updated.
     * <p>
     * API name: {@code docId}
     * </p>
     */
    @Nonnull
    public final String docId() {
        return this.docId;
    }

    /**
     * Required - The new rating value.
     * <p>
     * API name: {@code rating}
     * </p>
     */
    @Nonnull
    public final String rating() {
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
        generator.writeKey("docId");
        generator.write(this.docId);

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
     * Builder for {@link DocumentRatingUpdate}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DocumentRatingUpdate> {
        private String docId;
        private String rating;

        public Builder() {}

        private Builder(DocumentRatingUpdate o) {
            this.docId = o.docId;
            this.rating = o.rating;
        }

        private Builder(Builder o) {
            this.docId = o.docId;
            this.rating = o.rating;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The document id whose rating is being updated.
         * <p>
         * API name: {@code docId}
         * </p>
         */
        @Nonnull
        public final Builder docId(String value) {
            this.docId = value;
            return this;
        }

        /**
         * Required - The new rating value.
         * <p>
         * API name: {@code rating}
         * </p>
         */
        @Nonnull
        public final Builder rating(String value) {
            this.rating = value;
            return this;
        }

        /**
         * Builds a {@link DocumentRatingUpdate}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DocumentRatingUpdate build() {
            _checkSingleUse();

            return new DocumentRatingUpdate(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DocumentRatingUpdate}
     */
    public static final JsonpDeserializer<DocumentRatingUpdate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DocumentRatingUpdate::setupDocumentRatingUpdateDeserializer
    );

    protected static void setupDocumentRatingUpdateDeserializer(ObjectDeserializer<DocumentRatingUpdate.Builder> op) {
        op.add(Builder::docId, JsonpDeserializer.stringDeserializer(), "docId");
        op.add(Builder::rating, JsonpDeserializer.stringDeserializer(), "rating");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.docId.hashCode();
        result = 31 * result + this.rating.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DocumentRatingUpdate other = (DocumentRatingUpdate) o;
        return this.docId.equals(other.docId) && this.rating.equals(other.rating);
    }
}
