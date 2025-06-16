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
import java.util.List;
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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: security.get_account_details.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetAccountDetailsResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetAccountDetailsResponse.Builder, GetAccountDetailsResponse> {

    @Nonnull
    private final List<String> backendRoles;

    @Nonnull
    private final List<String> customAttributeNames;

    @Nullable
    private final Boolean isHidden;

    @Nullable
    private final Boolean isInternalUser;

    @Nullable
    private final Boolean isReserved;

    @Nonnull
    private final List<String> roles;

    @Nullable
    private final UserTenants tenants;

    @Nullable
    private final String userName;

    @Nullable
    private final String userRequestedTenant;

    // ---------------------------------------------------------------------------------------------

    private GetAccountDetailsResponse(Builder builder) {
        this.backendRoles = ApiTypeHelper.unmodifiable(builder.backendRoles);
        this.customAttributeNames = ApiTypeHelper.unmodifiable(builder.customAttributeNames);
        this.isHidden = builder.isHidden;
        this.isInternalUser = builder.isInternalUser;
        this.isReserved = builder.isReserved;
        this.roles = ApiTypeHelper.unmodifiable(builder.roles);
        this.tenants = builder.tenants;
        this.userName = builder.userName;
        this.userRequestedTenant = builder.userRequestedTenant;
    }

    public static GetAccountDetailsResponse of(Function<GetAccountDetailsResponse.Builder, ObjectBuilder<GetAccountDetailsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code backend_roles}
     */
    @Nonnull
    public final List<String> backendRoles() {
        return this.backendRoles;
    }

    /**
     * API name: {@code custom_attribute_names}
     */
    @Nonnull
    public final List<String> customAttributeNames() {
        return this.customAttributeNames;
    }

    /**
     * API name: {@code is_hidden}
     */
    @Nullable
    public final Boolean isHidden() {
        return this.isHidden;
    }

    /**
     * API name: {@code is_internal_user}
     */
    @Nullable
    public final Boolean isInternalUser() {
        return this.isInternalUser;
    }

    /**
     * API name: {@code is_reserved}
     */
    @Nullable
    public final Boolean isReserved() {
        return this.isReserved;
    }

    /**
     * API name: {@code roles}
     */
    @Nonnull
    public final List<String> roles() {
        return this.roles;
    }

    /**
     * API name: {@code tenants}
     */
    @Nullable
    public final UserTenants tenants() {
        return this.tenants;
    }

    /**
     * API name: {@code user_name}
     */
    @Nullable
    public final String userName() {
        return this.userName;
    }

    /**
     * API name: {@code user_requested_tenant}
     */
    @Nullable
    public final String userRequestedTenant() {
        return this.userRequestedTenant;
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
        if (ApiTypeHelper.isDefined(this.backendRoles)) {
            generator.writeKey("backend_roles");
            generator.writeStartArray();
            for (String item0 : this.backendRoles) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.customAttributeNames)) {
            generator.writeKey("custom_attribute_names");
            generator.writeStartArray();
            for (String item0 : this.customAttributeNames) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.isHidden != null) {
            generator.writeKey("is_hidden");
            generator.write(this.isHidden);
        }

        if (this.isInternalUser != null) {
            generator.writeKey("is_internal_user");
            generator.write(this.isInternalUser);
        }

        if (this.isReserved != null) {
            generator.writeKey("is_reserved");
            generator.write(this.isReserved);
        }

        if (ApiTypeHelper.isDefined(this.roles)) {
            generator.writeKey("roles");
            generator.writeStartArray();
            for (String item0 : this.roles) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.tenants != null) {
            generator.writeKey("tenants");
            this.tenants.serialize(generator, mapper);
        }

        if (this.userName != null) {
            generator.writeKey("user_name");
            generator.write(this.userName);
        }

        if (this.userRequestedTenant != null) {
            generator.writeKey("user_requested_tenant");
            generator.write(this.userRequestedTenant);
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
     * Builder for {@link GetAccountDetailsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetAccountDetailsResponse> {
        @Nullable
        private List<String> backendRoles;
        @Nullable
        private List<String> customAttributeNames;
        @Nullable
        private Boolean isHidden;
        @Nullable
        private Boolean isInternalUser;
        @Nullable
        private Boolean isReserved;
        @Nullable
        private List<String> roles;
        @Nullable
        private UserTenants tenants;
        @Nullable
        private String userName;
        @Nullable
        private String userRequestedTenant;

        public Builder() {}

        private Builder(GetAccountDetailsResponse o) {
            this.backendRoles = _listCopy(o.backendRoles);
            this.customAttributeNames = _listCopy(o.customAttributeNames);
            this.isHidden = o.isHidden;
            this.isInternalUser = o.isInternalUser;
            this.isReserved = o.isReserved;
            this.roles = _listCopy(o.roles);
            this.tenants = o.tenants;
            this.userName = o.userName;
            this.userRequestedTenant = o.userRequestedTenant;
        }

        private Builder(Builder o) {
            this.backendRoles = _listCopy(o.backendRoles);
            this.customAttributeNames = _listCopy(o.customAttributeNames);
            this.isHidden = o.isHidden;
            this.isInternalUser = o.isInternalUser;
            this.isReserved = o.isReserved;
            this.roles = _listCopy(o.roles);
            this.tenants = o.tenants;
            this.userName = o.userName;
            this.userRequestedTenant = o.userRequestedTenant;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
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
         * API name: {@code custom_attribute_names}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>customAttributeNames</code>.
         * </p>
         */
        @Nonnull
        public final Builder customAttributeNames(List<String> list) {
            this.customAttributeNames = _listAddAll(this.customAttributeNames, list);
            return this;
        }

        /**
         * API name: {@code custom_attribute_names}
         *
         * <p>
         * Adds one or more values to <code>customAttributeNames</code>.
         * </p>
         */
        @Nonnull
        public final Builder customAttributeNames(String value, String... values) {
            this.customAttributeNames = _listAdd(this.customAttributeNames, value, values);
            return this;
        }

        /**
         * API name: {@code is_hidden}
         */
        @Nonnull
        public final Builder isHidden(@Nullable Boolean value) {
            this.isHidden = value;
            return this;
        }

        /**
         * API name: {@code is_internal_user}
         */
        @Nonnull
        public final Builder isInternalUser(@Nullable Boolean value) {
            this.isInternalUser = value;
            return this;
        }

        /**
         * API name: {@code is_reserved}
         */
        @Nonnull
        public final Builder isReserved(@Nullable Boolean value) {
            this.isReserved = value;
            return this;
        }

        /**
         * API name: {@code roles}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>roles</code>.
         * </p>
         */
        @Nonnull
        public final Builder roles(List<String> list) {
            this.roles = _listAddAll(this.roles, list);
            return this;
        }

        /**
         * API name: {@code roles}
         *
         * <p>
         * Adds one or more values to <code>roles</code>.
         * </p>
         */
        @Nonnull
        public final Builder roles(String value, String... values) {
            this.roles = _listAdd(this.roles, value, values);
            return this;
        }

        /**
         * API name: {@code tenants}
         */
        @Nonnull
        public final Builder tenants(@Nullable UserTenants value) {
            this.tenants = value;
            return this;
        }

        /**
         * API name: {@code tenants}
         */
        @Nonnull
        public final Builder tenants(Function<UserTenants.Builder, ObjectBuilder<UserTenants>> fn) {
            return tenants(fn.apply(new UserTenants.Builder()).build());
        }

        /**
         * API name: {@code user_name}
         */
        @Nonnull
        public final Builder userName(@Nullable String value) {
            this.userName = value;
            return this;
        }

        /**
         * API name: {@code user_requested_tenant}
         */
        @Nonnull
        public final Builder userRequestedTenant(@Nullable String value) {
            this.userRequestedTenant = value;
            return this;
        }

        /**
         * Builds a {@link GetAccountDetailsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetAccountDetailsResponse build() {
            _checkSingleUse();

            return new GetAccountDetailsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetAccountDetailsResponse}
     */
    public static final JsonpDeserializer<GetAccountDetailsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetAccountDetailsResponse::setupGetAccountDetailsResponseDeserializer
    );

    protected static void setupGetAccountDetailsResponseDeserializer(ObjectDeserializer<GetAccountDetailsResponse.Builder> op) {
        op.add(Builder::backendRoles, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "backend_roles");
        op.add(
            Builder::customAttributeNames,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "custom_attribute_names"
        );
        op.add(Builder::isHidden, JsonpDeserializer.booleanDeserializer(), "is_hidden");
        op.add(Builder::isInternalUser, JsonpDeserializer.booleanDeserializer(), "is_internal_user");
        op.add(Builder::isReserved, JsonpDeserializer.booleanDeserializer(), "is_reserved");
        op.add(Builder::roles, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "roles");
        op.add(Builder::tenants, UserTenants._DESERIALIZER, "tenants");
        op.add(Builder::userName, JsonpDeserializer.stringDeserializer(), "user_name");
        op.add(Builder::userRequestedTenant, JsonpDeserializer.stringDeserializer(), "user_requested_tenant");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.backendRoles);
        result = 31 * result + Objects.hashCode(this.customAttributeNames);
        result = 31 * result + Objects.hashCode(this.isHidden);
        result = 31 * result + Objects.hashCode(this.isInternalUser);
        result = 31 * result + Objects.hashCode(this.isReserved);
        result = 31 * result + Objects.hashCode(this.roles);
        result = 31 * result + Objects.hashCode(this.tenants);
        result = 31 * result + Objects.hashCode(this.userName);
        result = 31 * result + Objects.hashCode(this.userRequestedTenant);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetAccountDetailsResponse other = (GetAccountDetailsResponse) o;
        return Objects.equals(this.backendRoles, other.backendRoles)
            && Objects.equals(this.customAttributeNames, other.customAttributeNames)
            && Objects.equals(this.isHidden, other.isHidden)
            && Objects.equals(this.isInternalUser, other.isInternalUser)
            && Objects.equals(this.isReserved, other.isReserved)
            && Objects.equals(this.roles, other.roles)
            && Objects.equals(this.tenants, other.tenants)
            && Objects.equals(this.userName, other.userName)
            && Objects.equals(this.userRequestedTenant, other.userRequestedTenant);
    }
}
