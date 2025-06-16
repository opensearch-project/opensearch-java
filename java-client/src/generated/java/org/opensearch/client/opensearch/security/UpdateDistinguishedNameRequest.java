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

package org.opensearch.client.opensearch.security;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.List;
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

// typedef: security.update_distinguished_name.Request

/**
 * Adds or updates the specified distinguished names in the cluster or node allowlist. Requires super admin or REST API permissions.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class UpdateDistinguishedNameRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<UpdateDistinguishedNameRequest.Builder, UpdateDistinguishedNameRequest> {

    @Nonnull
    private final String clusterName;

    @Nonnull
    private final List<String> nodesDn;

    // ---------------------------------------------------------------------------------------------

    private UpdateDistinguishedNameRequest(Builder builder) {
        super(builder);
        this.clusterName = ApiTypeHelper.requireNonNull(builder.clusterName, this, "clusterName");
        this.nodesDn = ApiTypeHelper.unmodifiable(builder.nodesDn);
    }

    public static UpdateDistinguishedNameRequest of(
        Function<UpdateDistinguishedNameRequest.Builder, ObjectBuilder<UpdateDistinguishedNameRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The name of the cluster containing the <code>nodesDn</code> value to create or update.
     * <p>
     * API name: {@code cluster_name}
     * </p>
     */
    @Nonnull
    public final String clusterName() {
        return this.clusterName;
    }

    /**
     * API name: {@code nodes_dn}
     */
    @Nonnull
    public final List<String> nodesDn() {
        return this.nodesDn;
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
        if (ApiTypeHelper.isDefined(this.nodesDn)) {
            generator.writeKey("nodes_dn");
            generator.writeStartArray();
            for (String item0 : this.nodesDn) {
                generator.write(item0);
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
     * Builder for {@link UpdateDistinguishedNameRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, UpdateDistinguishedNameRequest> {
        private String clusterName;
        @Nullable
        private List<String> nodesDn;

        public Builder() {}

        private Builder(UpdateDistinguishedNameRequest o) {
            super(o);
            this.clusterName = o.clusterName;
            this.nodesDn = _listCopy(o.nodesDn);
        }

        private Builder(Builder o) {
            super(o);
            this.clusterName = o.clusterName;
            this.nodesDn = _listCopy(o.nodesDn);
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
         * Required - The name of the cluster containing the <code>nodesDn</code> value to create or update.
         * <p>
         * API name: {@code cluster_name}
         * </p>
         */
        @Nonnull
        public final Builder clusterName(String value) {
            this.clusterName = value;
            return this;
        }

        /**
         * API name: {@code nodes_dn}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>nodesDn</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodesDn(List<String> list) {
            this.nodesDn = _listAddAll(this.nodesDn, list);
            return this;
        }

        /**
         * API name: {@code nodes_dn}
         *
         * <p>
         * Adds one or more values to <code>nodesDn</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodesDn(String value, String... values) {
            this.nodesDn = _listAdd(this.nodesDn, value, values);
            return this;
        }

        /**
         * Builds a {@link UpdateDistinguishedNameRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UpdateDistinguishedNameRequest build() {
            _checkSingleUse();

            return new UpdateDistinguishedNameRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UpdateDistinguishedNameRequest}
     */
    public static final JsonpDeserializer<UpdateDistinguishedNameRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UpdateDistinguishedNameRequest::setupUpdateDistinguishedNameRequestDeserializer
    );

    protected static void setupUpdateDistinguishedNameRequestDeserializer(ObjectDeserializer<UpdateDistinguishedNameRequest.Builder> op) {
        op.add(Builder::nodesDn, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "nodes_dn");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code security.update_distinguished_name}".
     */
    public static final Endpoint<UpdateDistinguishedNameRequest, UpdateDistinguishedNameResponse, ErrorResponse> _ENDPOINT =
        new SimpleEndpoint<>(
            // Request method
            request -> "PUT",
            // Request path
            request -> {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_security/api/nodesdn/");
                SimpleEndpoint.pathEncode(request.clusterName, buf);
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
            UpdateDistinguishedNameResponse._DESERIALIZER
        );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.clusterName.hashCode();
        result = 31 * result + Objects.hashCode(this.nodesDn);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UpdateDistinguishedNameRequest other = (UpdateDistinguishedNameRequest) o;
        return this.clusterName.equals(other.clusterName) && Objects.equals(this.nodesDn, other.nodesDn);
    }
}
