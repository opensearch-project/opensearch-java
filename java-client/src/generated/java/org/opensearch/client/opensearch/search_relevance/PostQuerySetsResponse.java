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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_relevance.post_query_sets.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PostQuerySetsResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PostQuerySetsResponse.Builder, PostQuerySetsResponse> {

    @Nullable
    private final String querySetId;

    @Nullable
    private final String querySetResult;

    // ---------------------------------------------------------------------------------------------

    private PostQuerySetsResponse(Builder builder) {
        this.querySetId = builder.querySetId;
        this.querySetResult = builder.querySetResult;
    }

    public static PostQuerySetsResponse of(Function<PostQuerySetsResponse.Builder, ObjectBuilder<PostQuerySetsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code query_set_id}
     */
    @Nullable
    public final String querySetId() {
        return this.querySetId;
    }

    /**
     * API name: {@code query_set_result}
     */
    @Nullable
    public final String querySetResult() {
        return this.querySetResult;
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
        if (this.querySetId != null) {
            generator.writeKey("query_set_id");
            generator.write(this.querySetId);
        }

        if (this.querySetResult != null) {
            generator.writeKey("query_set_result");
            generator.write(this.querySetResult);
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
     * Builder for {@link PostQuerySetsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PostQuerySetsResponse> {
        @Nullable
        private String querySetId;
        @Nullable
        private String querySetResult;

        public Builder() {}

        private Builder(PostQuerySetsResponse o) {
            this.querySetId = o.querySetId;
            this.querySetResult = o.querySetResult;
        }

        private Builder(Builder o) {
            this.querySetId = o.querySetId;
            this.querySetResult = o.querySetResult;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code query_set_id}
         */
        @Nonnull
        public final Builder querySetId(@Nullable String value) {
            this.querySetId = value;
            return this;
        }

        /**
         * API name: {@code query_set_result}
         */
        @Nonnull
        public final Builder querySetResult(@Nullable String value) {
            this.querySetResult = value;
            return this;
        }

        /**
         * Builds a {@link PostQuerySetsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PostQuerySetsResponse build() {
            _checkSingleUse();

            return new PostQuerySetsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PostQuerySetsResponse}
     */
    public static final JsonpDeserializer<PostQuerySetsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PostQuerySetsResponse::setupPostQuerySetsResponseDeserializer
    );

    protected static void setupPostQuerySetsResponseDeserializer(ObjectDeserializer<PostQuerySetsResponse.Builder> op) {
        op.add(Builder::querySetId, JsonpDeserializer.stringDeserializer(), "query_set_id");
        op.add(Builder::querySetResult, JsonpDeserializer.stringDeserializer(), "query_set_result");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.querySetId);
        result = 31 * result + Objects.hashCode(this.querySetResult);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PostQuerySetsResponse other = (PostQuerySetsResponse) o;
        return Objects.equals(this.querySetId, other.querySetId) && Objects.equals(this.querySetResult, other.querySetResult);
    }
}
