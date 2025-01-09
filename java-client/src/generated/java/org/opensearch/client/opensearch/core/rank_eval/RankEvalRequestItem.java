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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
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

// typedef: core.rank_eval.RankEvalRequestItem

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RankEvalRequestItem implements PlainJsonSerializable, ToCopyableBuilder<RankEvalRequestItem.Builder, RankEvalRequestItem> {

    @Nonnull
    private final String id;

    @Nonnull
    private final Map<String, JsonData> params;

    @Nonnull
    private final List<DocumentRating> ratings;

    @Nullable
    private final RankEvalQuery request;

    @Nullable
    private final String templateId;

    // ---------------------------------------------------------------------------------------------

    private RankEvalRequestItem(Builder builder) {
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.params = ApiTypeHelper.unmodifiable(builder.params);
        this.ratings = ApiTypeHelper.unmodifiableRequired(builder.ratings, this, "ratings");
        this.request = builder.request;
        this.templateId = builder.templateId;
    }

    public static RankEvalRequestItem of(Function<RankEvalRequestItem.Builder, ObjectBuilder<RankEvalRequestItem>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code id}
     */
    @Nonnull
    public final String id() {
        return this.id;
    }

    /**
     * The search template parameters.
     * <p>
     * API name: {@code params}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> params() {
        return this.params;
    }

    /**
     * Required - A list of document ratings.
     * <p>
     * API name: {@code ratings}
     * </p>
     */
    @Nonnull
    public final List<DocumentRating> ratings() {
        return this.ratings;
    }

    /**
     * API name: {@code request}
     */
    @Nullable
    public final RankEvalQuery request() {
        return this.request;
    }

    /**
     * API name: {@code template_id}
     */
    @Nullable
    public final String templateId() {
        return this.templateId;
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
        generator.writeKey("id");
        generator.write(this.id);

        if (ApiTypeHelper.isDefined(this.params)) {
            generator.writeKey("params");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.params.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("ratings");
        generator.writeStartArray();
        for (DocumentRating item0 : this.ratings) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        if (this.request != null) {
            generator.writeKey("request");
            this.request.serialize(generator, mapper);
        }

        if (this.templateId != null) {
            generator.writeKey("template_id");
            generator.write(this.templateId);
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
     * Builder for {@link RankEvalRequestItem}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RankEvalRequestItem> {
        private String id;
        @Nullable
        private Map<String, JsonData> params;
        private List<DocumentRating> ratings;
        @Nullable
        private RankEvalQuery request;
        @Nullable
        private String templateId;

        public Builder() {}

        private Builder(RankEvalRequestItem o) {
            this.id = o.id;
            this.params = _mapCopy(o.params);
            this.ratings = _listCopy(o.ratings);
            this.request = o.request;
            this.templateId = o.templateId;
        }

        private Builder(Builder o) {
            this.id = o.id;
            this.params = _mapCopy(o.params);
            this.ratings = _listCopy(o.ratings);
            this.request = o.request;
            this.templateId = o.templateId;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code id}
         */
        @Nonnull
        public final Builder id(String value) {
            this.id = value;
            return this;
        }

        /**
         * The search template parameters.
         * <p>
         * API name: {@code params}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>params</code>.
         * </p>
         */
        @Nonnull
        public final Builder params(Map<String, JsonData> map) {
            this.params = _mapPutAll(this.params, map);
            return this;
        }

        /**
         * The search template parameters.
         * <p>
         * API name: {@code params}
         * </p>
         *
         * <p>
         * Adds an entry to <code>params</code>.
         * </p>
         */
        @Nonnull
        public final Builder params(String key, JsonData value) {
            this.params = _mapPut(this.params, key, value);
            return this;
        }

        /**
         * Required - A list of document ratings.
         * <p>
         * API name: {@code ratings}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>ratings</code>.
         * </p>
         */
        @Nonnull
        public final Builder ratings(List<DocumentRating> list) {
            this.ratings = _listAddAll(this.ratings, list);
            return this;
        }

        /**
         * Required - A list of document ratings.
         * <p>
         * API name: {@code ratings}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>ratings</code>.
         * </p>
         */
        @Nonnull
        public final Builder ratings(DocumentRating value, DocumentRating... values) {
            this.ratings = _listAdd(this.ratings, value, values);
            return this;
        }

        /**
         * Required - A list of document ratings.
         * <p>
         * API name: {@code ratings}
         * </p>
         *
         * <p>
         * Adds a value to <code>ratings</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder ratings(Function<DocumentRating.Builder, ObjectBuilder<DocumentRating>> fn) {
            return ratings(fn.apply(new DocumentRating.Builder()).build());
        }

        /**
         * API name: {@code request}
         */
        @Nonnull
        public final Builder request(@Nullable RankEvalQuery value) {
            this.request = value;
            return this;
        }

        /**
         * API name: {@code request}
         */
        @Nonnull
        public final Builder request(Function<RankEvalQuery.Builder, ObjectBuilder<RankEvalQuery>> fn) {
            return request(fn.apply(new RankEvalQuery.Builder()).build());
        }

        /**
         * API name: {@code template_id}
         */
        @Nonnull
        public final Builder templateId(@Nullable String value) {
            this.templateId = value;
            return this;
        }

        /**
         * Builds a {@link RankEvalRequestItem}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RankEvalRequestItem build() {
            _checkSingleUse();

            return new RankEvalRequestItem(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RankEvalRequestItem}
     */
    public static final JsonpDeserializer<RankEvalRequestItem> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RankEvalRequestItem::setupRankEvalRequestItemDeserializer
    );

    protected static void setupRankEvalRequestItemDeserializer(ObjectDeserializer<RankEvalRequestItem.Builder> op) {
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::params, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "params");
        op.add(Builder::ratings, JsonpDeserializer.arrayDeserializer(DocumentRating._DESERIALIZER), "ratings");
        op.add(Builder::request, RankEvalQuery._DESERIALIZER, "request");
        op.add(Builder::templateId, JsonpDeserializer.stringDeserializer(), "template_id");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.id.hashCode();
        result = 31 * result + Objects.hashCode(this.params);
        result = 31 * result + this.ratings.hashCode();
        result = 31 * result + Objects.hashCode(this.request);
        result = 31 * result + Objects.hashCode(this.templateId);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RankEvalRequestItem other = (RankEvalRequestItem) o;
        return this.id.equals(other.id)
            && Objects.equals(this.params, other.params)
            && this.ratings.equals(other.ratings)
            && Objects.equals(this.request, other.request)
            && Objects.equals(this.templateId, other.templateId);
    }
}
