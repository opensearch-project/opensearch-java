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

// typedef: security.get_dashboards_info.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetDashboardsInfoResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetDashboardsInfoResponse.Builder, GetDashboardsInfoResponse> {

    @Nullable
    private final String defaultTenant;

    @Nullable
    private final Boolean multitenancyEnabled;

    @Nullable
    private final Boolean notFailOnForbiddenEnabled;

    @Nullable
    private final String opensearchDashboardsIndex;

    @Nullable
    private final Boolean opensearchDashboardsMtEnabled;

    @Nullable
    private final String opensearchDashboardsServerUser;

    @Nullable
    private final String passwordValidationErrorMessage;

    @Nullable
    private final String passwordValidationRegex;

    @Nullable
    private final Boolean privateTenantEnabled;

    @Nonnull
    private final List<String> signInOptions;

    @Nullable
    private final String userName;

    // ---------------------------------------------------------------------------------------------

    private GetDashboardsInfoResponse(Builder builder) {
        this.defaultTenant = builder.defaultTenant;
        this.multitenancyEnabled = builder.multitenancyEnabled;
        this.notFailOnForbiddenEnabled = builder.notFailOnForbiddenEnabled;
        this.opensearchDashboardsIndex = builder.opensearchDashboardsIndex;
        this.opensearchDashboardsMtEnabled = builder.opensearchDashboardsMtEnabled;
        this.opensearchDashboardsServerUser = builder.opensearchDashboardsServerUser;
        this.passwordValidationErrorMessage = builder.passwordValidationErrorMessage;
        this.passwordValidationRegex = builder.passwordValidationRegex;
        this.privateTenantEnabled = builder.privateTenantEnabled;
        this.signInOptions = ApiTypeHelper.unmodifiable(builder.signInOptions);
        this.userName = builder.userName;
    }

    public static GetDashboardsInfoResponse of(Function<GetDashboardsInfoResponse.Builder, ObjectBuilder<GetDashboardsInfoResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The default tenant setting for the dashboard.
     * <p>
     * API name: {@code default_tenant}
     * </p>
     */
    @Nullable
    public final String defaultTenant() {
        return this.defaultTenant;
    }

    /**
     * Indicates whether multi-tenancy is enabled.
     * <p>
     * API name: {@code multitenancy_enabled}
     * </p>
     */
    @Nullable
    public final Boolean multitenancyEnabled() {
        return this.multitenancyEnabled;
    }

    /**
     * Indicates whether <code>DNFOF</code> is enabled.
     * <p>
     * API name: {@code not_fail_on_forbidden_enabled}
     * </p>
     */
    @Nullable
    public final Boolean notFailOnForbiddenEnabled() {
        return this.notFailOnForbiddenEnabled;
    }

    /**
     * The name of the dashboard's index.
     * <p>
     * API name: {@code opensearch_dashboards_index}
     * </p>
     */
    @Nullable
    public final String opensearchDashboardsIndex() {
        return this.opensearchDashboardsIndex;
    }

    /**
     * Indicates whether multi-tenancy is enabled.
     * <p>
     * API name: {@code opensearch_dashboards_mt_enabled}
     * </p>
     */
    @Nullable
    public final Boolean opensearchDashboardsMtEnabled() {
        return this.opensearchDashboardsMtEnabled;
    }

    /**
     * The name of the user used to connect dashboard's to the server.
     * <p>
     * API name: {@code opensearch_dashboards_server_user}
     * </p>
     */
    @Nullable
    public final String opensearchDashboardsServerUser() {
        return this.opensearchDashboardsServerUser;
    }

    /**
     * The error message when a password validation fails.
     * <p>
     * API name: {@code password_validation_error_message}
     * </p>
     */
    @Nullable
    public final String passwordValidationErrorMessage() {
        return this.passwordValidationErrorMessage;
    }

    /**
     * The regular expression used perform password validation.
     * <p>
     * API name: {@code password_validation_regex}
     * </p>
     */
    @Nullable
    public final String passwordValidationRegex() {
        return this.passwordValidationRegex;
    }

    /**
     * Indicates whether a private tenant is enabled for all users.
     * <p>
     * API name: {@code private_tenant_enabled}
     * </p>
     */
    @Nullable
    public final Boolean privateTenantEnabled() {
        return this.privateTenantEnabled;
    }

    /**
     * A list of available sign-in options.
     * <p>
     * API name: {@code sign_in_options}
     * </p>
     */
    @Nonnull
    public final List<String> signInOptions() {
        return this.signInOptions;
    }

    /**
     * User's name
     * <p>
     * API name: {@code user_name}
     * </p>
     */
    @Nullable
    public final String userName() {
        return this.userName;
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

        if (this.notFailOnForbiddenEnabled != null) {
            generator.writeKey("not_fail_on_forbidden_enabled");
            generator.write(this.notFailOnForbiddenEnabled);
        }

        if (this.opensearchDashboardsIndex != null) {
            generator.writeKey("opensearch_dashboards_index");
            generator.write(this.opensearchDashboardsIndex);
        }

        if (this.opensearchDashboardsMtEnabled != null) {
            generator.writeKey("opensearch_dashboards_mt_enabled");
            generator.write(this.opensearchDashboardsMtEnabled);
        }

        if (this.opensearchDashboardsServerUser != null) {
            generator.writeKey("opensearch_dashboards_server_user");
            generator.write(this.opensearchDashboardsServerUser);
        }

        if (this.passwordValidationErrorMessage != null) {
            generator.writeKey("password_validation_error_message");
            generator.write(this.passwordValidationErrorMessage);
        }

        if (this.passwordValidationRegex != null) {
            generator.writeKey("password_validation_regex");
            generator.write(this.passwordValidationRegex);
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

        if (this.userName != null) {
            generator.writeKey("user_name");
            generator.write(this.userName);
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
     * Builder for {@link GetDashboardsInfoResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetDashboardsInfoResponse> {
        @Nullable
        private String defaultTenant;
        @Nullable
        private Boolean multitenancyEnabled;
        @Nullable
        private Boolean notFailOnForbiddenEnabled;
        @Nullable
        private String opensearchDashboardsIndex;
        @Nullable
        private Boolean opensearchDashboardsMtEnabled;
        @Nullable
        private String opensearchDashboardsServerUser;
        @Nullable
        private String passwordValidationErrorMessage;
        @Nullable
        private String passwordValidationRegex;
        @Nullable
        private Boolean privateTenantEnabled;
        @Nullable
        private List<String> signInOptions;
        @Nullable
        private String userName;

        public Builder() {}

        private Builder(GetDashboardsInfoResponse o) {
            this.defaultTenant = o.defaultTenant;
            this.multitenancyEnabled = o.multitenancyEnabled;
            this.notFailOnForbiddenEnabled = o.notFailOnForbiddenEnabled;
            this.opensearchDashboardsIndex = o.opensearchDashboardsIndex;
            this.opensearchDashboardsMtEnabled = o.opensearchDashboardsMtEnabled;
            this.opensearchDashboardsServerUser = o.opensearchDashboardsServerUser;
            this.passwordValidationErrorMessage = o.passwordValidationErrorMessage;
            this.passwordValidationRegex = o.passwordValidationRegex;
            this.privateTenantEnabled = o.privateTenantEnabled;
            this.signInOptions = _listCopy(o.signInOptions);
            this.userName = o.userName;
        }

        private Builder(Builder o) {
            this.defaultTenant = o.defaultTenant;
            this.multitenancyEnabled = o.multitenancyEnabled;
            this.notFailOnForbiddenEnabled = o.notFailOnForbiddenEnabled;
            this.opensearchDashboardsIndex = o.opensearchDashboardsIndex;
            this.opensearchDashboardsMtEnabled = o.opensearchDashboardsMtEnabled;
            this.opensearchDashboardsServerUser = o.opensearchDashboardsServerUser;
            this.passwordValidationErrorMessage = o.passwordValidationErrorMessage;
            this.passwordValidationRegex = o.passwordValidationRegex;
            this.privateTenantEnabled = o.privateTenantEnabled;
            this.signInOptions = _listCopy(o.signInOptions);
            this.userName = o.userName;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The default tenant setting for the dashboard.
         * <p>
         * API name: {@code default_tenant}
         * </p>
         */
        @Nonnull
        public final Builder defaultTenant(@Nullable String value) {
            this.defaultTenant = value;
            return this;
        }

        /**
         * Indicates whether multi-tenancy is enabled.
         * <p>
         * API name: {@code multitenancy_enabled}
         * </p>
         */
        @Nonnull
        public final Builder multitenancyEnabled(@Nullable Boolean value) {
            this.multitenancyEnabled = value;
            return this;
        }

        /**
         * Indicates whether <code>DNFOF</code> is enabled.
         * <p>
         * API name: {@code not_fail_on_forbidden_enabled}
         * </p>
         */
        @Nonnull
        public final Builder notFailOnForbiddenEnabled(@Nullable Boolean value) {
            this.notFailOnForbiddenEnabled = value;
            return this;
        }

        /**
         * The name of the dashboard's index.
         * <p>
         * API name: {@code opensearch_dashboards_index}
         * </p>
         */
        @Nonnull
        public final Builder opensearchDashboardsIndex(@Nullable String value) {
            this.opensearchDashboardsIndex = value;
            return this;
        }

        /**
         * Indicates whether multi-tenancy is enabled.
         * <p>
         * API name: {@code opensearch_dashboards_mt_enabled}
         * </p>
         */
        @Nonnull
        public final Builder opensearchDashboardsMtEnabled(@Nullable Boolean value) {
            this.opensearchDashboardsMtEnabled = value;
            return this;
        }

        /**
         * The name of the user used to connect dashboard's to the server.
         * <p>
         * API name: {@code opensearch_dashboards_server_user}
         * </p>
         */
        @Nonnull
        public final Builder opensearchDashboardsServerUser(@Nullable String value) {
            this.opensearchDashboardsServerUser = value;
            return this;
        }

        /**
         * The error message when a password validation fails.
         * <p>
         * API name: {@code password_validation_error_message}
         * </p>
         */
        @Nonnull
        public final Builder passwordValidationErrorMessage(@Nullable String value) {
            this.passwordValidationErrorMessage = value;
            return this;
        }

        /**
         * The regular expression used perform password validation.
         * <p>
         * API name: {@code password_validation_regex}
         * </p>
         */
        @Nonnull
        public final Builder passwordValidationRegex(@Nullable String value) {
            this.passwordValidationRegex = value;
            return this;
        }

        /**
         * Indicates whether a private tenant is enabled for all users.
         * <p>
         * API name: {@code private_tenant_enabled}
         * </p>
         */
        @Nonnull
        public final Builder privateTenantEnabled(@Nullable Boolean value) {
            this.privateTenantEnabled = value;
            return this;
        }

        /**
         * A list of available sign-in options.
         * <p>
         * API name: {@code sign_in_options}
         * </p>
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
         * A list of available sign-in options.
         * <p>
         * API name: {@code sign_in_options}
         * </p>
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
         * User's name
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
         * Builds a {@link GetDashboardsInfoResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetDashboardsInfoResponse build() {
            _checkSingleUse();

            return new GetDashboardsInfoResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetDashboardsInfoResponse}
     */
    public static final JsonpDeserializer<GetDashboardsInfoResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetDashboardsInfoResponse::setupGetDashboardsInfoResponseDeserializer
    );

    protected static void setupGetDashboardsInfoResponseDeserializer(ObjectDeserializer<GetDashboardsInfoResponse.Builder> op) {
        op.add(Builder::defaultTenant, JsonpDeserializer.stringDeserializer(), "default_tenant");
        op.add(Builder::multitenancyEnabled, JsonpDeserializer.booleanDeserializer(), "multitenancy_enabled");
        op.add(Builder::notFailOnForbiddenEnabled, JsonpDeserializer.booleanDeserializer(), "not_fail_on_forbidden_enabled");
        op.add(Builder::opensearchDashboardsIndex, JsonpDeserializer.stringDeserializer(), "opensearch_dashboards_index");
        op.add(Builder::opensearchDashboardsMtEnabled, JsonpDeserializer.booleanDeserializer(), "opensearch_dashboards_mt_enabled");
        op.add(Builder::opensearchDashboardsServerUser, JsonpDeserializer.stringDeserializer(), "opensearch_dashboards_server_user");
        op.add(Builder::passwordValidationErrorMessage, JsonpDeserializer.stringDeserializer(), "password_validation_error_message");
        op.add(Builder::passwordValidationRegex, JsonpDeserializer.stringDeserializer(), "password_validation_regex");
        op.add(Builder::privateTenantEnabled, JsonpDeserializer.booleanDeserializer(), "private_tenant_enabled");
        op.add(Builder::signInOptions, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "sign_in_options");
        op.add(Builder::userName, JsonpDeserializer.stringDeserializer(), "user_name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.defaultTenant);
        result = 31 * result + Objects.hashCode(this.multitenancyEnabled);
        result = 31 * result + Objects.hashCode(this.notFailOnForbiddenEnabled);
        result = 31 * result + Objects.hashCode(this.opensearchDashboardsIndex);
        result = 31 * result + Objects.hashCode(this.opensearchDashboardsMtEnabled);
        result = 31 * result + Objects.hashCode(this.opensearchDashboardsServerUser);
        result = 31 * result + Objects.hashCode(this.passwordValidationErrorMessage);
        result = 31 * result + Objects.hashCode(this.passwordValidationRegex);
        result = 31 * result + Objects.hashCode(this.privateTenantEnabled);
        result = 31 * result + Objects.hashCode(this.signInOptions);
        result = 31 * result + Objects.hashCode(this.userName);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetDashboardsInfoResponse other = (GetDashboardsInfoResponse) o;
        return Objects.equals(this.defaultTenant, other.defaultTenant)
            && Objects.equals(this.multitenancyEnabled, other.multitenancyEnabled)
            && Objects.equals(this.notFailOnForbiddenEnabled, other.notFailOnForbiddenEnabled)
            && Objects.equals(this.opensearchDashboardsIndex, other.opensearchDashboardsIndex)
            && Objects.equals(this.opensearchDashboardsMtEnabled, other.opensearchDashboardsMtEnabled)
            && Objects.equals(this.opensearchDashboardsServerUser, other.opensearchDashboardsServerUser)
            && Objects.equals(this.passwordValidationErrorMessage, other.passwordValidationErrorMessage)
            && Objects.equals(this.passwordValidationRegex, other.passwordValidationRegex)
            && Objects.equals(this.privateTenantEnabled, other.privateTenantEnabled)
            && Objects.equals(this.signInOptions, other.signInOptions)
            && Objects.equals(this.userName, other.userName);
    }
}
