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
import java.util.List;
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

// typedef: search_relevance.JudgmentRatingUpdate

/**
 * The ratings to update for a single query.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class JudgmentRatingUpdate implements PlainJsonSerializable, ToCopyableBuilder<JudgmentRatingUpdate.Builder, JudgmentRatingUpdate> {

    @Nonnull
    private final String query;

    @Nonnull
    private final List<DocumentRatingUpdate> ratings;

    // ---------------------------------------------------------------------------------------------

    private JudgmentRatingUpdate(Builder builder) {
        this.query = ApiTypeHelper.requireNonNull(builder.query, this, "query");
        this.ratings = ApiTypeHelper.unmodifiableRequired(builder.ratings, this, "ratings");
    }

    public static JudgmentRatingUpdate of(Function<JudgmentRatingUpdate.Builder, ObjectBuilder<JudgmentRatingUpdate>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The query text whose ratings are being updated.
     * <p>
     * API name: {@code query}
     * </p>
     */
    @Nonnull
    public final String query() {
        return this.query;
    }

    /**
     * Required - API name: {@code ratings}
     */
    @Nonnull
    public final List<DocumentRatingUpdate> ratings() {
        return this.ratings;
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
        generator.writeKey("query");
        generator.write(this.query);

        generator.writeKey("ratings");
        generator.writeStartArray();
        for (DocumentRatingUpdate item0 : this.ratings) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link JudgmentRatingUpdate}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, JudgmentRatingUpdate> {
        private String query;
        private List<DocumentRatingUpdate> ratings;

        public Builder() {}

        private Builder(JudgmentRatingUpdate o) {
            this.query = o.query;
            this.ratings = _listCopy(o.ratings);
        }

        private Builder(Builder o) {
            this.query = o.query;
            this.ratings = _listCopy(o.ratings);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The query text whose ratings are being updated.
         * <p>
         * API name: {@code query}
         * </p>
         */
        @Nonnull
        public final Builder query(String value) {
            this.query = value;
            return this;
        }

        /**
         * Required - API name: {@code ratings}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>ratings</code>.
         * </p>
         */
        @Nonnull
        public final Builder ratings(List<DocumentRatingUpdate> list) {
            this.ratings = _listAddAll(this.ratings, list);
            return this;
        }

        /**
         * Required - API name: {@code ratings}
         *
         * <p>
         * Adds one or more values to <code>ratings</code>.
         * </p>
         */
        @Nonnull
        public final Builder ratings(DocumentRatingUpdate value, DocumentRatingUpdate... values) {
            this.ratings = _listAdd(this.ratings, value, values);
            return this;
        }

        /**
         * Required - API name: {@code ratings}
         *
         * <p>
         * Adds a value to <code>ratings</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder ratings(Function<DocumentRatingUpdate.Builder, ObjectBuilder<DocumentRatingUpdate>> fn) {
            return ratings(fn.apply(new DocumentRatingUpdate.Builder()).build());
        }

        /**
         * Builds a {@link JudgmentRatingUpdate}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public JudgmentRatingUpdate build() {
            _checkSingleUse();

            return new JudgmentRatingUpdate(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link JudgmentRatingUpdate}
     */
    public static final JsonpDeserializer<JudgmentRatingUpdate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        JudgmentRatingUpdate::setupJudgmentRatingUpdateDeserializer
    );

    protected static void setupJudgmentRatingUpdateDeserializer(ObjectDeserializer<JudgmentRatingUpdate.Builder> op) {
        op.add(Builder::query, JsonpDeserializer.stringDeserializer(), "query");
        op.add(Builder::ratings, JsonpDeserializer.arrayDeserializer(DocumentRatingUpdate._DESERIALIZER), "ratings");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.query.hashCode();
        result = 31 * result + this.ratings.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        JudgmentRatingUpdate other = (JudgmentRatingUpdate) o;
        return this.query.equals(other.query) && this.ratings.equals(other.ratings);
    }
}
