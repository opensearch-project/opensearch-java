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
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_relevance.put_query_sets.Request

/**
 * Creates a new query set by uploading manually.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PutQuerySetsRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PutQuerySetsRequest.Builder, PutQuerySetsRequest> {

    @Nullable
    private final String description;

    @Nullable
    private final String name;

    @Nonnull
    private final List<Map<String, JsonData>> querySetQueries;

    @Nullable
    private final String sampling;

    // ---------------------------------------------------------------------------------------------

    private PutQuerySetsRequest(Builder builder) {
        super(builder);
        this.description = builder.description;
        this.name = builder.name;
        this.querySetQueries = ApiTypeHelper.unmodifiable(builder.querySetQueries);
        this.sampling = builder.sampling;
    }

    public static PutQuerySetsRequest of(Function<PutQuerySetsRequest.Builder, ObjectBuilder<PutQuerySetsRequest>> fn) {
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
     * API name: {@code name}
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code querySetQueries}
     */
    @Nonnull
    public final List<Map<String, JsonData>> querySetQueries() {
        return this.querySetQueries;
    }

    /**
     * API name: {@code sampling}
     */
    @Nullable
    public final String sampling() {
        return this.sampling;
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

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (ApiTypeHelper.isDefined(this.querySetQueries)) {
            generator.writeKey("querySetQueries");
            generator.writeStartArray();
            for (Map<String, JsonData> item0 : this.querySetQueries) {
                generator.writeStartObject();
                if (item0 != null) {
                    for (Map.Entry<String, JsonData> item1 : item0.entrySet()) {
                        generator.writeKey(item1.getKey());
                        item1.getValue().serialize(generator, mapper);
                    }
                }
                generator.writeEnd();
            }
            generator.writeEnd();
        }

        if (this.sampling != null) {
            generator.writeKey("sampling");
            generator.write(this.sampling);
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
     * Builder for {@link PutQuerySetsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PutQuerySetsRequest> {
        @Nullable
        private String description;
        @Nullable
        private String name;
        @Nullable
        private List<Map<String, JsonData>> querySetQueries;
        @Nullable
        private String sampling;

        public Builder() {}

        private Builder(PutQuerySetsRequest o) {
            super(o);
            this.description = o.description;
            this.name = o.name;
            this.querySetQueries = _listCopy(o.querySetQueries);
            this.sampling = o.sampling;
        }

        private Builder(Builder o) {
            super(o);
            this.description = o.description;
            this.name = o.name;
            this.querySetQueries = _listCopy(o.querySetQueries);
            this.sampling = o.sampling;
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
         * API name: {@code name}
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * API name: {@code querySetQueries}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>querySetQueries</code>.
         * </p>
         */
        @Nonnull
        public final Builder querySetQueries(List<Map<String, JsonData>> list) {
            this.querySetQueries = _listAddAll(this.querySetQueries, list);
            return this;
        }

        /**
         * API name: {@code querySetQueries}
         *
         * <p>
         * Adds one or more values to <code>querySetQueries</code>.
         * </p>
         */
        @Nonnull
        public final Builder querySetQueries(Map<String, JsonData> value, Map<String, JsonData>... values) {
            this.querySetQueries = _listAdd(this.querySetQueries, value, values);
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
         * Builds a {@link PutQuerySetsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutQuerySetsRequest build() {
            _checkSingleUse();

            return new PutQuerySetsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutQuerySetsRequest}
     */
    public static final JsonpDeserializer<PutQuerySetsRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutQuerySetsRequest::setupPutQuerySetsRequestDeserializer
    );

    protected static void setupPutQuerySetsRequestDeserializer(ObjectDeserializer<PutQuerySetsRequest.Builder> op) {
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(
            Builder::querySetQueries,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER)),
            "querySetQueries"
        );
        op.add(Builder::sampling, JsonpDeserializer.stringDeserializer(), "sampling");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code search_relevance.put_query_sets}".
     */
    public static final Endpoint<PutQuerySetsRequest, PutQuerySetsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
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
        PutQuerySetsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.querySetQueries);
        result = 31 * result + Objects.hashCode(this.sampling);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PutQuerySetsRequest other = (PutQuerySetsRequest) o;
        return Objects.equals(this.description, other.description)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.querySetQueries, other.querySetQueries)
            && Objects.equals(this.sampling, other.sampling);
    }
}
