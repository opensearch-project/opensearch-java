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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_relevance.update_judgment_ratings.Request

/**
 * Adjusts one or more ratings on an existing LLM judgment in place. Only the listed (<code>query</code>, <code>docId</code>) pairs are
 * updated; all other ratings are left unchanged.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class UpdateJudgmentRatingsRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<UpdateJudgmentRatingsRequest.Builder, UpdateJudgmentRatingsRequest> {

    @Nonnull
    private final String judgmentId;

    @Nonnull
    private final List<JudgmentRatingUpdate> judgmentRatings;

    // ---------------------------------------------------------------------------------------------

    private UpdateJudgmentRatingsRequest(Builder builder) {
        super(builder);
        this.judgmentId = ApiTypeHelper.requireNonNull(builder.judgmentId, this, "judgmentId");
        this.judgmentRatings = ApiTypeHelper.unmodifiableRequired(builder.judgmentRatings, this, "judgmentRatings");
    }

    public static UpdateJudgmentRatingsRequest of(
        Function<UpdateJudgmentRatingsRequest.Builder, ObjectBuilder<UpdateJudgmentRatingsRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The judgment id
     * <p>
     * API name: {@code judgment_id}
     * </p>
     */
    @Nonnull
    public final String judgmentId() {
        return this.judgmentId;
    }

    /**
     * Required - The ratings to update, grouped by query. Only the listed (<code>query</code>, <code>docId</code>) pairs are updated.
     * <p>
     * API name: {@code judgmentRatings}
     * </p>
     */
    @Nonnull
    public final List<JudgmentRatingUpdate> judgmentRatings() {
        return this.judgmentRatings;
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
        generator.writeKey("judgmentRatings");
        generator.writeStartArray();
        for (JudgmentRatingUpdate item0 : this.judgmentRatings) {
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
     * Builder for {@link UpdateJudgmentRatingsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, UpdateJudgmentRatingsRequest> {
        private String judgmentId;
        private List<JudgmentRatingUpdate> judgmentRatings;

        public Builder() {}

        private Builder(UpdateJudgmentRatingsRequest o) {
            super(o);
            this.judgmentId = o.judgmentId;
            this.judgmentRatings = _listCopy(o.judgmentRatings);
        }

        private Builder(Builder o) {
            super(o);
            this.judgmentId = o.judgmentId;
            this.judgmentRatings = _listCopy(o.judgmentRatings);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * Required - The judgment id
         * <p>
         * API name: {@code judgment_id}
         * </p>
         */
        @Nonnull
        public final Builder judgmentId(String value) {
            this.judgmentId = value;
            return this;
        }

        /**
         * Required - The ratings to update, grouped by query. Only the listed (<code>query</code>, <code>docId</code>) pairs are updated.
         * <p>
         * API name: {@code judgmentRatings}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>judgmentRatings</code>.
         * </p>
         */
        @Nonnull
        public final Builder judgmentRatings(List<JudgmentRatingUpdate> list) {
            this.judgmentRatings = _listAddAll(this.judgmentRatings, list);
            return this;
        }

        /**
         * Required - The ratings to update, grouped by query. Only the listed (<code>query</code>, <code>docId</code>) pairs are updated.
         * <p>
         * API name: {@code judgmentRatings}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>judgmentRatings</code>.
         * </p>
         */
        @Nonnull
        public final Builder judgmentRatings(JudgmentRatingUpdate value, JudgmentRatingUpdate... values) {
            this.judgmentRatings = _listAdd(this.judgmentRatings, value, values);
            return this;
        }

        /**
         * Required - The ratings to update, grouped by query. Only the listed (<code>query</code>, <code>docId</code>) pairs are updated.
         * <p>
         * API name: {@code judgmentRatings}
         * </p>
         *
         * <p>
         * Adds a value to <code>judgmentRatings</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder judgmentRatings(Function<JudgmentRatingUpdate.Builder, ObjectBuilder<JudgmentRatingUpdate>> fn) {
            return judgmentRatings(fn.apply(new JudgmentRatingUpdate.Builder()).build());
        }

        /**
         * Builds a {@link UpdateJudgmentRatingsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UpdateJudgmentRatingsRequest build() {
            _checkSingleUse();

            return new UpdateJudgmentRatingsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UpdateJudgmentRatingsRequest}
     */
    public static final JsonpDeserializer<UpdateJudgmentRatingsRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UpdateJudgmentRatingsRequest::setupUpdateJudgmentRatingsRequestDeserializer
    );

    protected static void setupUpdateJudgmentRatingsRequestDeserializer(ObjectDeserializer<UpdateJudgmentRatingsRequest.Builder> op) {
        op.add(Builder::judgmentRatings, JsonpDeserializer.arrayDeserializer(JudgmentRatingUpdate._DESERIALIZER), "judgmentRatings");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code search_relevance.update_judgment_ratings}".
     */
    public static final Endpoint<UpdateJudgmentRatingsRequest, UpdateJudgmentRatingsResponse, ErrorResponse> _ENDPOINT =
        new SimpleEndpoint<>(
            // Request method
            request -> "PUT",
            // Request path
            request -> {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_search_relevance/judgments/");
                SimpleEndpoint.pathEncode(request.judgmentId, buf);
                return buf.toString();
            },
            // Request parameters
            request -> {
                Map<String, String> params = new HashMap<>();
                request.applyQueryParameters(params);
                return params;
            },
            SimpleEndpoint.emptyMap(),
            true,
            UpdateJudgmentRatingsResponse._DESERIALIZER
        );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.judgmentId.hashCode();
        result = 31 * result + this.judgmentRatings.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UpdateJudgmentRatingsRequest other = (UpdateJudgmentRatingsRequest) o;
        return this.judgmentId.equals(other.judgmentId) && this.judgmentRatings.equals(other.judgmentRatings);
    }
}
