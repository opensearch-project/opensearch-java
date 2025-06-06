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

// typedef: security.create_tenant.Request

/**
 * Creates or replaces the specified tenant.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class CreateTenantRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<CreateTenantRequest.Builder, CreateTenantRequest> {

    @Nullable
    private final String description;

    @Nonnull
    private final String tenant;

    // ---------------------------------------------------------------------------------------------

    private CreateTenantRequest(Builder builder) {
        super(builder);
        this.description = builder.description;
        this.tenant = ApiTypeHelper.requireNonNull(builder.tenant, this, "tenant");
    }

    public static CreateTenantRequest of(Function<CreateTenantRequest.Builder, ObjectBuilder<CreateTenantRequest>> fn) {
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
     * Required - The name of the tenant to create.
     * <p>
     * API name: {@code tenant}
     * </p>
     */
    @Nonnull
    public final String tenant() {
        return this.tenant;
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
     * Builder for {@link CreateTenantRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, CreateTenantRequest> {
        @Nullable
        private String description;
        private String tenant;

        public Builder() {}

        private Builder(CreateTenantRequest o) {
            super(o);
            this.description = o.description;
            this.tenant = o.tenant;
        }

        private Builder(Builder o) {
            super(o);
            this.description = o.description;
            this.tenant = o.tenant;
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
         * Required - The name of the tenant to create.
         * <p>
         * API name: {@code tenant}
         * </p>
         */
        @Nonnull
        public final Builder tenant(String value) {
            this.tenant = value;
            return this;
        }

        /**
         * Builds a {@link CreateTenantRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CreateTenantRequest build() {
            _checkSingleUse();

            return new CreateTenantRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CreateTenantRequest}
     */
    public static final JsonpDeserializer<CreateTenantRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CreateTenantRequest::setupCreateTenantRequestDeserializer
    );

    protected static void setupCreateTenantRequestDeserializer(ObjectDeserializer<CreateTenantRequest.Builder> op) {
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code security.create_tenant}".
     */
    public static final Endpoint<CreateTenantRequest, CreateTenantResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_security/api/tenants/");
            SimpleEndpoint.pathEncode(request.tenant, buf);
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
        CreateTenantResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + this.tenant.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CreateTenantRequest other = (CreateTenantRequest) o;
        return Objects.equals(this.description, other.description) && this.tenant.equals(other.tenant);
    }
}
