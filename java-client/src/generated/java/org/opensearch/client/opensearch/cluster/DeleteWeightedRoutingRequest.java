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

package org.opensearch.client.opensearch.cluster;

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

// typedef: cluster.delete_weighted_routing.Request

/**
 * Delete weighted shard routing weights.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class DeleteWeightedRoutingRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<DeleteWeightedRoutingRequest.Builder, DeleteWeightedRoutingRequest> {

    @Nullable
    private final Long version;

    // ---------------------------------------------------------------------------------------------

    private DeleteWeightedRoutingRequest(Builder builder) {
        super(builder);
        this.version = builder.version;
    }

    public static DeleteWeightedRoutingRequest of(
        Function<DeleteWeightedRoutingRequest.Builder, ObjectBuilder<DeleteWeightedRoutingRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code _version}
     */
    @Nullable
    public final Long version() {
        return this.version;
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
        if (this.version != null) {
            generator.writeKey("_version");
            generator.write(this.version);
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
     * Builder for {@link DeleteWeightedRoutingRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, DeleteWeightedRoutingRequest> {
        @Nullable
        private Long version;

        public Builder() {}

        private Builder(DeleteWeightedRoutingRequest o) {
            super(o);
            this.version = o.version;
        }

        private Builder(Builder o) {
            super(o);
            this.version = o.version;
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
         * API name: {@code _version}
         */
        @Nonnull
        public final Builder version(@Nullable Long value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link DeleteWeightedRoutingRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteWeightedRoutingRequest build() {
            _checkSingleUse();

            return new DeleteWeightedRoutingRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DeleteWeightedRoutingRequest}
     */
    public static final JsonpDeserializer<DeleteWeightedRoutingRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DeleteWeightedRoutingRequest::setupDeleteWeightedRoutingRequestDeserializer
    );

    protected static void setupDeleteWeightedRoutingRequestDeserializer(ObjectDeserializer<DeleteWeightedRoutingRequest.Builder> op) {
        op.add(Builder::version, JsonpDeserializer.longDeserializer(), "_version");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code cluster.delete_weighted_routing}".
     */
    public static final Endpoint<DeleteWeightedRoutingRequest, DeleteWeightedRoutingResponse, ErrorResponse> _ENDPOINT =
        new SimpleEndpoint<>(
            // Request method
            request -> "DELETE",
            // Request path
            request -> "/_cluster/routing/awareness/weights",
            // Request parameters
            request -> {
                Map<String, String> params = new HashMap<>();
                request.applyQueryParameters(params);
                return params;
            },
            SimpleEndpoint.emptyMap(),
            true,
            DeleteWeightedRoutingResponse._DESERIALIZER
        );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeleteWeightedRoutingRequest other = (DeleteWeightedRoutingRequest) o;
        return Objects.equals(this.version, other.version);
    }
}
