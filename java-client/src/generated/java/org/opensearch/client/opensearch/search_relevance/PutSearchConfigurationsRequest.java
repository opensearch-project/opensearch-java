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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_relevance.put_search_configurations.Request

/**
 * Creates a search configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PutSearchConfigurationsRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PutSearchConfigurationsRequest.Builder, PutSearchConfigurationsRequest> {

    @Nullable
    private final String index;

    @Nullable
    private final String name;

    @Nullable
    private final String query;

    @Nullable
    private final String searchPipeline;

    // ---------------------------------------------------------------------------------------------

    private PutSearchConfigurationsRequest(Builder builder) {
        super(builder);
        this.index = builder.index;
        this.name = builder.name;
        this.query = builder.query;
        this.searchPipeline = builder.searchPipeline;
    }

    public static PutSearchConfigurationsRequest of(
        Function<PutSearchConfigurationsRequest.Builder, ObjectBuilder<PutSearchConfigurationsRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * API name: {@code name}
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code query}
     */
    @Nullable
    public final String query() {
        return this.query;
    }

    /**
     * API name: {@code searchPipeline}
     */
    @Nullable
    public final String searchPipeline() {
        return this.searchPipeline;
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
        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (this.query != null) {
            generator.writeKey("query");
            generator.write(this.query);
        }

        if (this.searchPipeline != null) {
            generator.writeKey("searchPipeline");
            generator.write(this.searchPipeline);
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
     * Builder for {@link PutSearchConfigurationsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, PutSearchConfigurationsRequest> {
        @Nullable
        private String index;
        @Nullable
        private String name;
        @Nullable
        private String query;
        @Nullable
        private String searchPipeline;

        public Builder() {}

        private Builder(PutSearchConfigurationsRequest o) {
            super(o);
            this.index = o.index;
            this.name = o.name;
            this.query = o.query;
            this.searchPipeline = o.searchPipeline;
        }

        private Builder(Builder o) {
            super(o);
            this.index = o.index;
            this.name = o.name;
            this.query = o.query;
            this.searchPipeline = o.searchPipeline;
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
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(@Nullable String value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code name}
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * API name: {@code query}
         */
        @Nonnull
        public final Builder query(@Nullable String value) {
            this.query = value;
            return this;
        }

        /**
         * API name: {@code searchPipeline}
         */
        @Nonnull
        public final Builder searchPipeline(@Nullable String value) {
            this.searchPipeline = value;
            return this;
        }

        /**
         * Builds a {@link PutSearchConfigurationsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutSearchConfigurationsRequest build() {
            _checkSingleUse();

            return new PutSearchConfigurationsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutSearchConfigurationsRequest}
     */
    public static final JsonpDeserializer<PutSearchConfigurationsRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutSearchConfigurationsRequest::setupPutSearchConfigurationsRequestDeserializer
    );

    protected static void setupPutSearchConfigurationsRequestDeserializer(ObjectDeserializer<PutSearchConfigurationsRequest.Builder> op) {
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::query, JsonpDeserializer.stringDeserializer(), "query");
        op.add(Builder::searchPipeline, JsonpDeserializer.stringDeserializer(), "searchPipeline");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code search_relevance.put_search_configurations}".
     */
    public static final Endpoint<PutSearchConfigurationsRequest, PutSearchConfigurationsResponse, ErrorResponse> _ENDPOINT =
        new SimpleEndpoint<>(
            // Request method
            request -> "PUT",
            // Request path
            request -> "/_plugins/_search_relevance/search_configurations",
            // Request parameters
            request -> {
                Map<String, String> params = new HashMap<>();
                request.applyQueryParameters(params);
                return params;
            },
            SimpleEndpoint.emptyMap(),
            true,
            PutSearchConfigurationsResponse._DESERIALIZER
        );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.query);
        result = 31 * result + Objects.hashCode(this.searchPipeline);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PutSearchConfigurationsRequest other = (PutSearchConfigurationsRequest) o;
        return Objects.equals(this.index, other.index)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.query, other.query)
            && Objects.equals(this.searchPipeline, other.searchPipeline);
    }
}
