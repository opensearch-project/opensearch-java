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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: security.authinfo.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AuthinfoResponse implements PlainJsonSerializable, ToCopyableBuilder<AuthinfoResponse.Builder, AuthinfoResponse> {

    @Nonnull
    private final List<String> backendRoles;

    @Nonnull
    private final List<String> customAttributeNames;

    @Nullable
    private final String peerCertificates;

    @Nullable
    private final String principal;

    @Nullable
    private final String remoteAddress;

    @Nonnull
    private final List<String> roles;

    @Nullable
    private final String sizeOfBackendroles;

    @Nullable
    private final String sizeOfCustomAttributes;

    @Nullable
    private final String sizeOfUser;

    @Nullable
    private final String ssoLogoutUrl;

    @Nonnull
    private final Map<String, Boolean> tenants;

    @Nullable
    private final String user;

    @Nullable
    private final String userName;

    @Nullable
    private final String userRequestedTenant;

    // ---------------------------------------------------------------------------------------------

    private AuthinfoResponse(Builder builder) {
        this.backendRoles = ApiTypeHelper.unmodifiable(builder.backendRoles);
        this.customAttributeNames = ApiTypeHelper.unmodifiable(builder.customAttributeNames);
        this.peerCertificates = builder.peerCertificates;
        this.principal = builder.principal;
        this.remoteAddress = builder.remoteAddress;
        this.roles = ApiTypeHelper.unmodifiable(builder.roles);
        this.sizeOfBackendroles = builder.sizeOfBackendroles;
        this.sizeOfCustomAttributes = builder.sizeOfCustomAttributes;
        this.sizeOfUser = builder.sizeOfUser;
        this.ssoLogoutUrl = builder.ssoLogoutUrl;
        this.tenants = ApiTypeHelper.unmodifiable(builder.tenants);
        this.user = builder.user;
        this.userName = builder.userName;
        this.userRequestedTenant = builder.userRequestedTenant;
    }

    public static AuthinfoResponse of(Function<AuthinfoResponse.Builder, ObjectBuilder<AuthinfoResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The backend roles associated with the user.
     * <p>
     * API name: {@code backend_roles}
     * </p>
     */
    @Nonnull
    public final List<String> backendRoles() {
        return this.backendRoles;
    }

    /**
     * The name of the attributes associated with the user.
     * <p>
     * API name: {@code custom_attribute_names}
     * </p>
     */
    @Nonnull
    public final List<String> customAttributeNames() {
        return this.customAttributeNames;
    }

    /**
     * The number of peer certificates related to the user.
     * <p>
     * API name: {@code peer_certificates}
     * </p>
     */
    @Nullable
    public final String peerCertificates() {
        return this.peerCertificates;
    }

    /**
     * The user's principal.
     * <p>
     * API name: {@code principal}
     * </p>
     */
    @Nullable
    public final String principal() {
        return this.principal;
    }

    /**
     * The IP address of remote user.
     * <p>
     * API name: {@code remote_address}
     * </p>
     */
    @Nullable
    public final String remoteAddress() {
        return this.remoteAddress;
    }

    /**
     * The roles associated with the user.
     * <p>
     * API name: {@code roles}
     * </p>
     */
    @Nonnull
    public final List<String> roles() {
        return this.roles;
    }

    /**
     * The size of the user's backend roles in bytes.
     * <p>
     * API name: {@code size_of_backendroles}
     * </p>
     */
    @Nullable
    public final String sizeOfBackendroles() {
        return this.sizeOfBackendroles;
    }

    /**
     * The size of the user's custom attributes in bytes.
     * <p>
     * API name: {@code size_of_custom_attributes}
     * </p>
     */
    @Nullable
    public final String sizeOfCustomAttributes() {
        return this.sizeOfCustomAttributes;
    }

    /**
     * The size of user contained in memory.
     * <p>
     * API name: {@code size_of_user}
     * </p>
     */
    @Nullable
    public final String sizeOfUser() {
        return this.sizeOfUser;
    }

    /**
     * The logout URL.
     * <p>
     * API name: {@code sso_logout_url}
     * </p>
     */
    @Nullable
    public final String ssoLogoutUrl() {
        return this.ssoLogoutUrl;
    }

    /**
     * The tenants the user has access to with <code>read-write</code> or <code>read-only</code> access indicators.
     * <p>
     * API name: {@code tenants}
     * </p>
     */
    @Nonnull
    public final Map<String, Boolean> tenants() {
        return this.tenants;
    }

    /**
     * A user object as a string.
     * <p>
     * API name: {@code user}
     * </p>
     */
    @Nullable
    public final String user() {
        return this.user;
    }

    /**
     * The username.
     * <p>
     * API name: {@code user_name}
     * </p>
     */
    @Nullable
    public final String userName() {
        return this.userName;
    }

    /**
     * The name of the tenant the user would like to switch to.
     * <p>
     * API name: {@code user_requested_tenant}
     * </p>
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

        if (this.peerCertificates != null) {
            generator.writeKey("peer_certificates");
            generator.write(this.peerCertificates);
        }

        if (this.principal != null) {
            generator.writeKey("principal");
            generator.write(this.principal);
        }

        if (this.remoteAddress != null) {
            generator.writeKey("remote_address");
            generator.write(this.remoteAddress);
        }

        if (ApiTypeHelper.isDefined(this.roles)) {
            generator.writeKey("roles");
            generator.writeStartArray();
            for (String item0 : this.roles) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.sizeOfBackendroles != null) {
            generator.writeKey("size_of_backendroles");
            generator.write(this.sizeOfBackendroles);
        }

        if (this.sizeOfCustomAttributes != null) {
            generator.writeKey("size_of_custom_attributes");
            generator.write(this.sizeOfCustomAttributes);
        }

        if (this.sizeOfUser != null) {
            generator.writeKey("size_of_user");
            generator.write(this.sizeOfUser);
        }

        if (this.ssoLogoutUrl != null) {
            generator.writeKey("sso_logout_url");
            generator.write(this.ssoLogoutUrl);
        }

        if (ApiTypeHelper.isDefined(this.tenants)) {
            generator.writeKey("tenants");
            generator.writeStartObject();
            for (Map.Entry<String, Boolean> item0 : this.tenants.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        if (this.user != null) {
            generator.writeKey("user");
            generator.write(this.user);
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
     * Builder for {@link AuthinfoResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AuthinfoResponse> {
        @Nullable
        private List<String> backendRoles;
        @Nullable
        private List<String> customAttributeNames;
        @Nullable
        private String peerCertificates;
        @Nullable
        private String principal;
        @Nullable
        private String remoteAddress;
        @Nullable
        private List<String> roles;
        @Nullable
        private String sizeOfBackendroles;
        @Nullable
        private String sizeOfCustomAttributes;
        @Nullable
        private String sizeOfUser;
        @Nullable
        private String ssoLogoutUrl;
        @Nullable
        private Map<String, Boolean> tenants;
        @Nullable
        private String user;
        @Nullable
        private String userName;
        @Nullable
        private String userRequestedTenant;

        public Builder() {}

        private Builder(AuthinfoResponse o) {
            this.backendRoles = _listCopy(o.backendRoles);
            this.customAttributeNames = _listCopy(o.customAttributeNames);
            this.peerCertificates = o.peerCertificates;
            this.principal = o.principal;
            this.remoteAddress = o.remoteAddress;
            this.roles = _listCopy(o.roles);
            this.sizeOfBackendroles = o.sizeOfBackendroles;
            this.sizeOfCustomAttributes = o.sizeOfCustomAttributes;
            this.sizeOfUser = o.sizeOfUser;
            this.ssoLogoutUrl = o.ssoLogoutUrl;
            this.tenants = _mapCopy(o.tenants);
            this.user = o.user;
            this.userName = o.userName;
            this.userRequestedTenant = o.userRequestedTenant;
        }

        private Builder(Builder o) {
            this.backendRoles = _listCopy(o.backendRoles);
            this.customAttributeNames = _listCopy(o.customAttributeNames);
            this.peerCertificates = o.peerCertificates;
            this.principal = o.principal;
            this.remoteAddress = o.remoteAddress;
            this.roles = _listCopy(o.roles);
            this.sizeOfBackendroles = o.sizeOfBackendroles;
            this.sizeOfCustomAttributes = o.sizeOfCustomAttributes;
            this.sizeOfUser = o.sizeOfUser;
            this.ssoLogoutUrl = o.ssoLogoutUrl;
            this.tenants = _mapCopy(o.tenants);
            this.user = o.user;
            this.userName = o.userName;
            this.userRequestedTenant = o.userRequestedTenant;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The backend roles associated with the user.
         * <p>
         * API name: {@code backend_roles}
         * </p>
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
         * The backend roles associated with the user.
         * <p>
         * API name: {@code backend_roles}
         * </p>
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
         * The name of the attributes associated with the user.
         * <p>
         * API name: {@code custom_attribute_names}
         * </p>
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
         * The name of the attributes associated with the user.
         * <p>
         * API name: {@code custom_attribute_names}
         * </p>
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
         * The number of peer certificates related to the user.
         * <p>
         * API name: {@code peer_certificates}
         * </p>
         */
        @Nonnull
        public final Builder peerCertificates(@Nullable String value) {
            this.peerCertificates = value;
            return this;
        }

        /**
         * The user's principal.
         * <p>
         * API name: {@code principal}
         * </p>
         */
        @Nonnull
        public final Builder principal(@Nullable String value) {
            this.principal = value;
            return this;
        }

        /**
         * The IP address of remote user.
         * <p>
         * API name: {@code remote_address}
         * </p>
         */
        @Nonnull
        public final Builder remoteAddress(@Nullable String value) {
            this.remoteAddress = value;
            return this;
        }

        /**
         * The roles associated with the user.
         * <p>
         * API name: {@code roles}
         * </p>
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
         * The roles associated with the user.
         * <p>
         * API name: {@code roles}
         * </p>
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
         * The size of the user's backend roles in bytes.
         * <p>
         * API name: {@code size_of_backendroles}
         * </p>
         */
        @Nonnull
        public final Builder sizeOfBackendroles(@Nullable String value) {
            this.sizeOfBackendroles = value;
            return this;
        }

        /**
         * The size of the user's custom attributes in bytes.
         * <p>
         * API name: {@code size_of_custom_attributes}
         * </p>
         */
        @Nonnull
        public final Builder sizeOfCustomAttributes(@Nullable String value) {
            this.sizeOfCustomAttributes = value;
            return this;
        }

        /**
         * The size of user contained in memory.
         * <p>
         * API name: {@code size_of_user}
         * </p>
         */
        @Nonnull
        public final Builder sizeOfUser(@Nullable String value) {
            this.sizeOfUser = value;
            return this;
        }

        /**
         * The logout URL.
         * <p>
         * API name: {@code sso_logout_url}
         * </p>
         */
        @Nonnull
        public final Builder ssoLogoutUrl(@Nullable String value) {
            this.ssoLogoutUrl = value;
            return this;
        }

        /**
         * The tenants the user has access to with <code>read-write</code> or <code>read-only</code> access indicators.
         * <p>
         * API name: {@code tenants}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>tenants</code>.
         * </p>
         */
        @Nonnull
        public final Builder tenants(Map<String, Boolean> map) {
            this.tenants = _mapPutAll(this.tenants, map);
            return this;
        }

        /**
         * The tenants the user has access to with <code>read-write</code> or <code>read-only</code> access indicators.
         * <p>
         * API name: {@code tenants}
         * </p>
         *
         * <p>
         * Adds an entry to <code>tenants</code>.
         * </p>
         */
        @Nonnull
        public final Builder tenants(String key, Boolean value) {
            this.tenants = _mapPut(this.tenants, key, value);
            return this;
        }

        /**
         * A user object as a string.
         * <p>
         * API name: {@code user}
         * </p>
         */
        @Nonnull
        public final Builder user(@Nullable String value) {
            this.user = value;
            return this;
        }

        /**
         * The username.
         * <p>
         * API name: {@code user_name}
         * </p>
         */
        @Nonnull
        public final Builder userName(@Nullable String value) {
            this.userName = value;
            return this;
        }

        /**
         * The name of the tenant the user would like to switch to.
         * <p>
         * API name: {@code user_requested_tenant}
         * </p>
         */
        @Nonnull
        public final Builder userRequestedTenant(@Nullable String value) {
            this.userRequestedTenant = value;
            return this;
        }

        /**
         * Builds a {@link AuthinfoResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AuthinfoResponse build() {
            _checkSingleUse();

            return new AuthinfoResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AuthinfoResponse}
     */
    public static final JsonpDeserializer<AuthinfoResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AuthinfoResponse::setupAuthinfoResponseDeserializer
    );

    protected static void setupAuthinfoResponseDeserializer(ObjectDeserializer<AuthinfoResponse.Builder> op) {
        op.add(Builder::backendRoles, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "backend_roles");
        op.add(
            Builder::customAttributeNames,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "custom_attribute_names"
        );
        op.add(Builder::peerCertificates, JsonpDeserializer.stringDeserializer(), "peer_certificates");
        op.add(Builder::principal, JsonpDeserializer.stringDeserializer(), "principal");
        op.add(Builder::remoteAddress, JsonpDeserializer.stringDeserializer(), "remote_address");
        op.add(Builder::roles, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "roles");
        op.add(Builder::sizeOfBackendroles, JsonpDeserializer.stringDeserializer(), "size_of_backendroles");
        op.add(Builder::sizeOfCustomAttributes, JsonpDeserializer.stringDeserializer(), "size_of_custom_attributes");
        op.add(Builder::sizeOfUser, JsonpDeserializer.stringDeserializer(), "size_of_user");
        op.add(Builder::ssoLogoutUrl, JsonpDeserializer.stringDeserializer(), "sso_logout_url");
        op.add(Builder::tenants, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.booleanDeserializer()), "tenants");
        op.add(Builder::user, JsonpDeserializer.stringDeserializer(), "user");
        op.add(Builder::userName, JsonpDeserializer.stringDeserializer(), "user_name");
        op.add(Builder::userRequestedTenant, JsonpDeserializer.stringDeserializer(), "user_requested_tenant");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.backendRoles);
        result = 31 * result + Objects.hashCode(this.customAttributeNames);
        result = 31 * result + Objects.hashCode(this.peerCertificates);
        result = 31 * result + Objects.hashCode(this.principal);
        result = 31 * result + Objects.hashCode(this.remoteAddress);
        result = 31 * result + Objects.hashCode(this.roles);
        result = 31 * result + Objects.hashCode(this.sizeOfBackendroles);
        result = 31 * result + Objects.hashCode(this.sizeOfCustomAttributes);
        result = 31 * result + Objects.hashCode(this.sizeOfUser);
        result = 31 * result + Objects.hashCode(this.ssoLogoutUrl);
        result = 31 * result + Objects.hashCode(this.tenants);
        result = 31 * result + Objects.hashCode(this.user);
        result = 31 * result + Objects.hashCode(this.userName);
        result = 31 * result + Objects.hashCode(this.userRequestedTenant);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AuthinfoResponse other = (AuthinfoResponse) o;
        return Objects.equals(this.backendRoles, other.backendRoles)
            && Objects.equals(this.customAttributeNames, other.customAttributeNames)
            && Objects.equals(this.peerCertificates, other.peerCertificates)
            && Objects.equals(this.principal, other.principal)
            && Objects.equals(this.remoteAddress, other.remoteAddress)
            && Objects.equals(this.roles, other.roles)
            && Objects.equals(this.sizeOfBackendroles, other.sizeOfBackendroles)
            && Objects.equals(this.sizeOfCustomAttributes, other.sizeOfCustomAttributes)
            && Objects.equals(this.sizeOfUser, other.sizeOfUser)
            && Objects.equals(this.ssoLogoutUrl, other.ssoLogoutUrl)
            && Objects.equals(this.tenants, other.tenants)
            && Objects.equals(this.user, other.user)
            && Objects.equals(this.userName, other.userName)
            && Objects.equals(this.userRequestedTenant, other.userRequestedTenant);
    }
}
