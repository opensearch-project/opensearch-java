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

// typedef: security.create_role_mapping.Request

/**
 * Creates or replaces the specified role mapping.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class CreateRoleMappingRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<CreateRoleMappingRequest.Builder, CreateRoleMappingRequest> {

    @Nonnull
    private final List<String> andBackendRoles;

    @Nonnull
    private final List<String> backendRoles;

    @Nullable
    private final String description;

    @Nullable
    private final Boolean hidden;

    @Nonnull
    private final List<String> hosts;

    @Nullable
    private final Boolean reserved;

    @Nonnull
    private final String role;

    @Nonnull
    private final List<String> users;

    // ---------------------------------------------------------------------------------------------

    private CreateRoleMappingRequest(Builder builder) {
        super(builder);
        this.andBackendRoles = ApiTypeHelper.unmodifiable(builder.andBackendRoles);
        this.backendRoles = ApiTypeHelper.unmodifiable(builder.backendRoles);
        this.description = builder.description;
        this.hidden = builder.hidden;
        this.hosts = ApiTypeHelper.unmodifiable(builder.hosts);
        this.reserved = builder.reserved;
        this.role = ApiTypeHelper.requireNonNull(builder.role, this, "role");
        this.users = ApiTypeHelper.unmodifiable(builder.users);
    }

    public static CreateRoleMappingRequest of(Function<CreateRoleMappingRequest.Builder, ObjectBuilder<CreateRoleMappingRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code and_backend_roles}
     */
    @Nonnull
    public final List<String> andBackendRoles() {
        return this.andBackendRoles;
    }

    /**
     * API name: {@code backend_roles}
     */
    @Nonnull
    public final List<String> backendRoles() {
        return this.backendRoles;
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * API name: {@code hidden}
     */
    @Nullable
    public final Boolean hidden() {
        return this.hidden;
    }

    /**
     * API name: {@code hosts}
     */
    @Nonnull
    public final List<String> hosts() {
        return this.hosts;
    }

    /**
     * API name: {@code reserved}
     */
    @Nullable
    public final Boolean reserved() {
        return this.reserved;
    }

    /**
     * Required - The name of the role for which to create a role mapping.
     * <p>
     * API name: {@code role}
     * </p>
     */
    @Nonnull
    public final String role() {
        return this.role;
    }

    /**
     * API name: {@code users}
     */
    @Nonnull
    public final List<String> users() {
        return this.users;
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
        if (ApiTypeHelper.isDefined(this.andBackendRoles)) {
            generator.writeKey("and_backend_roles");
            generator.writeStartArray();
            for (String item0 : this.andBackendRoles) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.backendRoles)) {
            generator.writeKey("backend_roles");
            generator.writeStartArray();
            for (String item0 : this.backendRoles) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.hidden != null) {
            generator.writeKey("hidden");
            generator.write(this.hidden);
        }

        if (ApiTypeHelper.isDefined(this.hosts)) {
            generator.writeKey("hosts");
            generator.writeStartArray();
            for (String item0 : this.hosts) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.reserved != null) {
            generator.writeKey("reserved");
            generator.write(this.reserved);
        }

        if (ApiTypeHelper.isDefined(this.users)) {
            generator.writeKey("users");
            generator.writeStartArray();
            for (String item0 : this.users) {
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
     * Builder for {@link CreateRoleMappingRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, CreateRoleMappingRequest> {
        @Nullable
        private List<String> andBackendRoles;
        @Nullable
        private List<String> backendRoles;
        @Nullable
        private String description;
        @Nullable
        private Boolean hidden;
        @Nullable
        private List<String> hosts;
        @Nullable
        private Boolean reserved;
        private String role;
        @Nullable
        private List<String> users;

        public Builder() {}

        private Builder(CreateRoleMappingRequest o) {
            super(o);
            this.andBackendRoles = _listCopy(o.andBackendRoles);
            this.backendRoles = _listCopy(o.backendRoles);
            this.description = o.description;
            this.hidden = o.hidden;
            this.hosts = _listCopy(o.hosts);
            this.reserved = o.reserved;
            this.role = o.role;
            this.users = _listCopy(o.users);
        }

        private Builder(Builder o) {
            super(o);
            this.andBackendRoles = _listCopy(o.andBackendRoles);
            this.backendRoles = _listCopy(o.backendRoles);
            this.description = o.description;
            this.hidden = o.hidden;
            this.hosts = _listCopy(o.hosts);
            this.reserved = o.reserved;
            this.role = o.role;
            this.users = _listCopy(o.users);
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
         * API name: {@code and_backend_roles}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>andBackendRoles</code>.
         * </p>
         */
        @Nonnull
        public final Builder andBackendRoles(List<String> list) {
            this.andBackendRoles = _listAddAll(this.andBackendRoles, list);
            return this;
        }

        /**
         * API name: {@code and_backend_roles}
         *
         * <p>
         * Adds one or more values to <code>andBackendRoles</code>.
         * </p>
         */
        @Nonnull
        public final Builder andBackendRoles(String value, String... values) {
            this.andBackendRoles = _listAdd(this.andBackendRoles, value, values);
            return this;
        }

        /**
         * API name: {@code backend_roles}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>backendRoles</code>.
         * </p>
         */
        @Nonnull
        public final Builder backendRoles(List<String> list) {
            this.backendRoles = _listAddAll(this.backendRoles, list);
            return this;
        }

        /**
         * API name: {@code backend_roles}
         *
         * <p>
         * Adds one or more values to <code>backendRoles</code>.
         * </p>
         */
        @Nonnull
        public final Builder backendRoles(String value, String... values) {
            this.backendRoles = _listAdd(this.backendRoles, value, values);
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
         * API name: {@code hidden}
         */
        @Nonnull
        public final Builder hidden(@Nullable Boolean value) {
            this.hidden = value;
            return this;
        }

        /**
         * API name: {@code hosts}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>hosts</code>.
         * </p>
         */
        @Nonnull
        public final Builder hosts(List<String> list) {
            this.hosts = _listAddAll(this.hosts, list);
            return this;
        }

        /**
         * API name: {@code hosts}
         *
         * <p>
         * Adds one or more values to <code>hosts</code>.
         * </p>
         */
        @Nonnull
        public final Builder hosts(String value, String... values) {
            this.hosts = _listAdd(this.hosts, value, values);
            return this;
        }

        /**
         * API name: {@code reserved}
         */
        @Nonnull
        public final Builder reserved(@Nullable Boolean value) {
            this.reserved = value;
            return this;
        }

        /**
         * Required - The name of the role for which to create a role mapping.
         * <p>
         * API name: {@code role}
         * </p>
         */
        @Nonnull
        public final Builder role(String value) {
            this.role = value;
            return this;
        }

        /**
         * API name: {@code users}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>users</code>.
         * </p>
         */
        @Nonnull
        public final Builder users(List<String> list) {
            this.users = _listAddAll(this.users, list);
            return this;
        }

        /**
         * API name: {@code users}
         *
         * <p>
         * Adds one or more values to <code>users</code>.
         * </p>
         */
        @Nonnull
        public final Builder users(String value, String... values) {
            this.users = _listAdd(this.users, value, values);
            return this;
        }

        /**
         * Builds a {@link CreateRoleMappingRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CreateRoleMappingRequest build() {
            _checkSingleUse();

            return new CreateRoleMappingRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CreateRoleMappingRequest}
     */
    public static final JsonpDeserializer<CreateRoleMappingRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CreateRoleMappingRequest::setupCreateRoleMappingRequestDeserializer
    );

    protected static void setupCreateRoleMappingRequestDeserializer(ObjectDeserializer<CreateRoleMappingRequest.Builder> op) {
        op.add(Builder::andBackendRoles, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "and_backend_roles");
        op.add(Builder::backendRoles, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "backend_roles");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::hidden, JsonpDeserializer.booleanDeserializer(), "hidden");
        op.add(Builder::hosts, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "hosts");
        op.add(Builder::reserved, JsonpDeserializer.booleanDeserializer(), "reserved");
        op.add(Builder::users, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "users");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code security.create_role_mapping}".
     */
    public static final Endpoint<CreateRoleMappingRequest, CreateRoleMappingResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_security/api/rolesmapping/");
            SimpleEndpoint.pathEncode(request.role, buf);
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
        CreateRoleMappingResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.andBackendRoles);
        result = 31 * result + Objects.hashCode(this.backendRoles);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.hidden);
        result = 31 * result + Objects.hashCode(this.hosts);
        result = 31 * result + Objects.hashCode(this.reserved);
        result = 31 * result + this.role.hashCode();
        result = 31 * result + Objects.hashCode(this.users);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CreateRoleMappingRequest other = (CreateRoleMappingRequest) o;
        return Objects.equals(this.andBackendRoles, other.andBackendRoles)
            && Objects.equals(this.backendRoles, other.backendRoles)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.hidden, other.hidden)
            && Objects.equals(this.hosts, other.hosts)
            && Objects.equals(this.reserved, other.reserved)
            && this.role.equals(other.role)
            && Objects.equals(this.users, other.users);
    }
}
