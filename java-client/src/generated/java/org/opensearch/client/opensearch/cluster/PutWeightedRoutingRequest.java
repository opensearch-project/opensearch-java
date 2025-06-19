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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.put_weighted_routing.Request

/**
 * Updates weighted shard routing weights.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PutWeightedRoutingRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PutWeightedRoutingRequest.Builder, PutWeightedRoutingRequest> {

    @Nonnull
    private final String attribute;

    @Nullable
    private final Long version;

    @Nonnull
    private final Map<String, String> weights;

    // ---------------------------------------------------------------------------------------------

    private PutWeightedRoutingRequest(Builder builder) {
        super(builder);
        this.attribute = ApiTypeHelper.requireNonNull(builder.attribute, this, "attribute");
        this.version = builder.version;
        this.weights = ApiTypeHelper.unmodifiable(builder.weights);
    }

    public static PutWeightedRoutingRequest of(Function<PutWeightedRoutingRequest.Builder, ObjectBuilder<PutWeightedRoutingRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The name of awareness attribute, usually <code>zone</code>.
     * <p>
     * API name: {@code attribute}
     * </p>
     */
    @Nonnull
    public final String attribute() {
        return this.attribute;
    }

    /**
     * API name: {@code _version}
     */
    @Nullable
    public final Long version() {
        return this.version;
    }

    /**
     * API name: {@code weights}
     */
    @Nonnull
    public final Map<String, String> weights() {
        return this.weights;
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

        if (ApiTypeHelper.isDefined(this.weights)) {
            generator.writeKey("weights");
            generator.writeStartObject();
            for (Map.Entry<String, String> item0 : this.weights.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
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
     * Builder for {@link PutWeightedRoutingRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, PutWeightedRoutingRequest> {
        private String attribute;
        @Nullable
        private Long version;
        @Nullable
        private Map<String, String> weights;

        public Builder() {}

        private Builder(PutWeightedRoutingRequest o) {
            super(o);
            this.attribute = o.attribute;
            this.version = o.version;
            this.weights = _mapCopy(o.weights);
        }

        private Builder(Builder o) {
            super(o);
            this.attribute = o.attribute;
            this.version = o.version;
            this.weights = _mapCopy(o.weights);
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
         * Required - The name of awareness attribute, usually <code>zone</code>.
         * <p>
         * API name: {@code attribute}
         * </p>
         */
        @Nonnull
        public final Builder attribute(String value) {
            this.attribute = value;
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
         * API name: {@code weights}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>weights</code>.
         * </p>
         */
        @Nonnull
        public final Builder weights(Map<String, String> map) {
            this.weights = _mapPutAll(this.weights, map);
            return this;
        }

        /**
         * API name: {@code weights}
         *
         * <p>
         * Adds an entry to <code>weights</code>.
         * </p>
         */
        @Nonnull
        public final Builder weights(String key, String value) {
            this.weights = _mapPut(this.weights, key, value);
            return this;
        }

        /**
         * Builds a {@link PutWeightedRoutingRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutWeightedRoutingRequest build() {
            _checkSingleUse();

            return new PutWeightedRoutingRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutWeightedRoutingRequest}
     */
    public static final JsonpDeserializer<PutWeightedRoutingRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutWeightedRoutingRequest::setupPutWeightedRoutingRequestDeserializer
    );

    protected static void setupPutWeightedRoutingRequestDeserializer(ObjectDeserializer<PutWeightedRoutingRequest.Builder> op) {
        op.add(Builder::version, JsonpDeserializer.longDeserializer(), "_version");
        op.add(Builder::weights, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "weights");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code cluster.put_weighted_routing}".
     */
    public static final Endpoint<PutWeightedRoutingRequest, PutWeightedRoutingResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_cluster/routing/awareness/");
            SimpleEndpoint.pathEncode(request.attribute, buf);
            buf.append("/weights");
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
        PutWeightedRoutingResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.attribute.hashCode();
        result = 31 * result + Objects.hashCode(this.version);
        result = 31 * result + Objects.hashCode(this.weights);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PutWeightedRoutingRequest other = (PutWeightedRoutingRequest) o;
        return this.attribute.equals(other.attribute)
            && Objects.equals(this.version, other.version)
            && Objects.equals(this.weights, other.weights);
    }
}
