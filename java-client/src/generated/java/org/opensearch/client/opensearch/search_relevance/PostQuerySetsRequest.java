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
import java.util.Map;
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
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_relevance.post_query_sets.Request

/**
 * Creates a new query set by sampling queries from the user behavior data.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PostQuerySetsRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PostQuerySetsRequest.Builder, PostQuerySetsRequest> {

    @Nullable
    private final String description;

    @Nonnull
    private final String name;

    @Nullable
    private final Integer querySetSize;

    @Nullable
    private final String sampling;

    @Nullable
    private final String ubiQueriesIndex;

    // ---------------------------------------------------------------------------------------------

    private PostQuerySetsRequest(Builder builder) {
        super(builder);
        this.description = builder.description;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.querySetSize = builder.querySetSize;
        this.sampling = builder.sampling;
        this.ubiQueriesIndex = builder.ubiQueriesIndex;
    }

    public static PostQuerySetsRequest of(Function<PostQuerySetsRequest.Builder, ObjectBuilder<PostQuerySetsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code querySetSize}
     */
    @Nullable
    public final Integer querySetSize() {
        return this.querySetSize;
    }

    /**
     * API name: {@code sampling}
     */
    @Nullable
    public final String sampling() {
        return this.sampling;
    }

    /**
     * The name of the UBI queries index to sample from.
     * <p>
     * API name: {@code ubiQueriesIndex}
     * </p>
     */
    @Nullable
    public final String ubiQueriesIndex() {
        return this.ubiQueriesIndex;
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
        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        generator.writeKey("name");
        generator.write(this.name);

        if (this.querySetSize != null) {
            generator.writeKey("querySetSize");
            generator.write(this.querySetSize);
        }

        if (this.sampling != null) {
            generator.writeKey("sampling");
            generator.write(this.sampling);
        }

        if (this.ubiQueriesIndex != null) {
            generator.writeKey("ubiQueriesIndex");
            generator.write(this.ubiQueriesIndex);
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
     * Builder for {@link PostQuerySetsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PostQuerySetsRequest> {
        @Nullable
        private String description;
        private String name;
        @Nullable
        private Integer querySetSize;
        @Nullable
        private String sampling;
        @Nullable
        private String ubiQueriesIndex;

        public Builder() {}

        private Builder(PostQuerySetsRequest o) {
            super(o);
            this.description = o.description;
            this.name = o.name;
            this.querySetSize = o.querySetSize;
            this.sampling = o.sampling;
            this.ubiQueriesIndex = o.ubiQueriesIndex;
        }

        private Builder(Builder o) {
            super(o);
            this.description = o.description;
            this.name = o.name;
            this.querySetSize = o.querySetSize;
            this.sampling = o.sampling;
            this.ubiQueriesIndex = o.ubiQueriesIndex;
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
         * API name: {@code description}
         */
        @Nonnull
        public final Builder description(@Nullable String value) {
            this.description = value;
            return this;
        }

        /**
         * Required - API name: {@code name}
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * API name: {@code querySetSize}
         */
        @Nonnull
        public final Builder querySetSize(@Nullable Integer value) {
            this.querySetSize = value;
            return this;
        }

        /**
         * API name: {@code sampling}
         */
        @Nonnull
        public final Builder sampling(@Nullable String value) {
            this.sampling = value;
            return this;
        }

        /**
         * The name of the UBI queries index to sample from.
         * <p>
         * API name: {@code ubiQueriesIndex}
         * </p>
         */
        @Nonnull
        public final Builder ubiQueriesIndex(@Nullable String value) {
            this.ubiQueriesIndex = value;
            return this;
        }

        /**
         * Builds a {@link PostQuerySetsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PostQuerySetsRequest build() {
            _checkSingleUse();

            return new PostQuerySetsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PostQuerySetsRequest}
     */
    public static final JsonpDeserializer<PostQuerySetsRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PostQuerySetsRequest::setupPostQuerySetsRequestDeserializer
    );

    protected static void setupPostQuerySetsRequestDeserializer(ObjectDeserializer<PostQuerySetsRequest.Builder> op) {
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::querySetSize, JsonpDeserializer.integerDeserializer(), "querySetSize");
        op.add(Builder::sampling, JsonpDeserializer.stringDeserializer(), "sampling");
        op.add(Builder::ubiQueriesIndex, JsonpDeserializer.stringDeserializer(), "ubiQueriesIndex");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code search_relevance.post_query_sets}".
     */
    public static final Endpoint<PostQuerySetsRequest, PostQuerySetsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> "/_plugins/_search_relevance/query_sets",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        PostQuerySetsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Objects.hashCode(this.querySetSize);
        result = 31 * result + Objects.hashCode(this.sampling);
        result = 31 * result + Objects.hashCode(this.ubiQueriesIndex);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PostQuerySetsRequest other = (PostQuerySetsRequest) o;
        return Objects.equals(this.description, other.description)
            && this.name.equals(other.name)
            && Objects.equals(this.querySetSize, other.querySetSize)
            && Objects.equals(this.sampling, other.sampling)
            && Objects.equals(this.ubiQueriesIndex, other.ubiQueriesIndex);
    }
}
