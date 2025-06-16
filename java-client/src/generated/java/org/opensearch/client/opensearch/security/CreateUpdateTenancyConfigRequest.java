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

// typedef: security.create_update_tenancy_config.Request

/**
 * Creates or replaces the multi-tenancy configuration. Requires super admin or REST API permissions.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class CreateUpdateTenancyConfigRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<CreateUpdateTenancyConfigRequest.Builder, CreateUpdateTenancyConfigRequest> {

    @Nullable
    private final String defaultTenant;

    @Nullable
    private final Boolean multitenancyEnabled;

    @Nullable
    private final Boolean privateTenantEnabled;

    @Nonnull
    private final List<String> signInOptions;

    // ---------------------------------------------------------------------------------------------

    private CreateUpdateTenancyConfigRequest(Builder builder) {
        super(builder);
        this.defaultTenant = builder.defaultTenant;
        this.multitenancyEnabled = builder.multitenancyEnabled;
        this.privateTenantEnabled = builder.privateTenantEnabled;
        this.signInOptions = ApiTypeHelper.unmodifiable(builder.signInOptions);
    }

    public static CreateUpdateTenancyConfigRequest of(
        Function<CreateUpdateTenancyConfigRequest.Builder, ObjectBuilder<CreateUpdateTenancyConfigRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code default_tenant}
     */
    @Nullable
    public final String defaultTenant() {
        return this.defaultTenant;
    }

    /**
     * API name: {@code multitenancy_enabled}
     */
    @Nullable
    public final Boolean multitenancyEnabled() {
        return this.multitenancyEnabled;
    }

    /**
     * API name: {@code private_tenant_enabled}
     */
    @Nullable
    public final Boolean privateTenantEnabled() {
        return this.privateTenantEnabled;
    }

    /**
     * API name: {@code sign_in_options}
     */
    @Nonnull
    public final List<String> signInOptions() {
        return this.signInOptions;
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
        if (this.defaultTenant != null) {
            generator.writeKey("default_tenant");
            generator.write(this.defaultTenant);
        }

        if (this.multitenancyEnabled != null) {
            generator.writeKey("multitenancy_enabled");
            generator.write(this.multitenancyEnabled);
        }

        if (this.privateTenantEnabled != null) {
            generator.writeKey("private_tenant_enabled");
            generator.write(this.privateTenantEnabled);
        }

        if (ApiTypeHelper.isDefined(this.signInOptions)) {
            generator.writeKey("sign_in_options");
            generator.writeStartArray();
            for (String item0 : this.signInOptions) {
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
     * Builder for {@link CreateUpdateTenancyConfigRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, CreateUpdateTenancyConfigRequest> {
        @Nullable
        private String defaultTenant;
        @Nullable
        private Boolean multitenancyEnabled;
        @Nullable
        private Boolean privateTenantEnabled;
        @Nullable
        private List<String> signInOptions;

        public Builder() {}

        private Builder(CreateUpdateTenancyConfigRequest o) {
            super(o);
            this.defaultTenant = o.defaultTenant;
            this.multitenancyEnabled = o.multitenancyEnabled;
            this.privateTenantEnabled = o.privateTenantEnabled;
            this.signInOptions = _listCopy(o.signInOptions);
        }

        private Builder(Builder o) {
            super(o);
            this.defaultTenant = o.defaultTenant;
            this.multitenancyEnabled = o.multitenancyEnabled;
            this.privateTenantEnabled = o.privateTenantEnabled;
            this.signInOptions = _listCopy(o.signInOptions);
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
         * API name: {@code default_tenant}
         */
        @Nonnull
        public final Builder defaultTenant(@Nullable String value) {
            this.defaultTenant = value;
            return this;
        }

        /**
         * API name: {@code multitenancy_enabled}
         */
        @Nonnull
        public final Builder multitenancyEnabled(@Nullable Boolean value) {
            this.multitenancyEnabled = value;
            return this;
        }

        /**
         * API name: {@code private_tenant_enabled}
         */
        @Nonnull
        public final Builder privateTenantEnabled(@Nullable Boolean value) {
            this.privateTenantEnabled = value;
            return this;
        }

        /**
         * API name: {@code sign_in_options}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>signInOptions</code>.
         * </p>
         */
        @Nonnull
        public final Builder signInOptions(List<String> list) {
            this.signInOptions = _listAddAll(this.signInOptions, list);
            return this;
        }

        /**
         * API name: {@code sign_in_options}
         *
         * <p>
         * Adds one or more values to <code>signInOptions</code>.
         * </p>
         */
        @Nonnull
        public final Builder signInOptions(String value, String... values) {
            this.signInOptions = _listAdd(this.signInOptions, value, values);
            return this;
        }

        /**
         * Builds a {@link CreateUpdateTenancyConfigRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CreateUpdateTenancyConfigRequest build() {
            _checkSingleUse();

            return new CreateUpdateTenancyConfigRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CreateUpdateTenancyConfigRequest}
     */
    public static final JsonpDeserializer<CreateUpdateTenancyConfigRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CreateUpdateTenancyConfigRequest::setupCreateUpdateTenancyConfigRequestDeserializer
    );

    protected static void setupCreateUpdateTenancyConfigRequestDeserializer(
        ObjectDeserializer<CreateUpdateTenancyConfigRequest.Builder> op
    ) {
        op.add(Builder::defaultTenant, JsonpDeserializer.stringDeserializer(), "default_tenant");
        op.add(Builder::multitenancyEnabled, JsonpDeserializer.booleanDeserializer(), "multitenancy_enabled");
        op.add(Builder::privateTenantEnabled, JsonpDeserializer.booleanDeserializer(), "private_tenant_enabled");
        op.add(Builder::signInOptions, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "sign_in_options");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code security.create_update_tenancy_config}".
     */
    public static final Endpoint<CreateUpdateTenancyConfigRequest, CreateUpdateTenancyConfigResponse, ErrorResponse> _ENDPOINT =
        new SimpleEndpoint<>(
            // Request method
            request -> "PUT",
            // Request path
            request -> "/_plugins/_security/api/tenancy/config",
            // Request parameters
            request -> {
                Map<String, String> params = new HashMap<>();
                request.applyQueryParameters(params);
                return params;
            },
            SimpleEndpoint.emptyMap(),
            true,
            CreateUpdateTenancyConfigResponse._DESERIALIZER
        );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.defaultTenant);
        result = 31 * result + Objects.hashCode(this.multitenancyEnabled);
        result = 31 * result + Objects.hashCode(this.privateTenantEnabled);
        result = 31 * result + Objects.hashCode(this.signInOptions);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CreateUpdateTenancyConfigRequest other = (CreateUpdateTenancyConfigRequest) o;
        return Objects.equals(this.defaultTenant, other.defaultTenant)
            && Objects.equals(this.multitenancyEnabled, other.multitenancyEnabled)
            && Objects.equals(this.privateTenantEnabled, other.privateTenantEnabled)
            && Objects.equals(this.signInOptions, other.signInOptions);
    }
}
