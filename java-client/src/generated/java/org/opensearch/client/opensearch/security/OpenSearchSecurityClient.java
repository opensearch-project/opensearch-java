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

import java.io.IOException;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.transport.endpoints.BooleanResponse;
import org.opensearch.client.util.ObjectBuilder;

/**
 * Client for the security namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenSearchSecurityClient extends ApiClient<OpenSearchTransport, OpenSearchSecurityClient> {
    public OpenSearchSecurityClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchSecurityClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchSecurityClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchSecurityClient(this.transport, transportOptions);
    }

    // ----- Endpoint: security.authinfo

    /**
     * Returns or updates authentication information for the currently authenticated user.
     */
    public AuthinfoResponse authinfo(AuthinfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, AuthinfoRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns or updates authentication information for the currently authenticated user.
     *
     * @param fn a function that initializes a builder to create the {@link AuthinfoRequest}
     */
    public final AuthinfoResponse authinfo(Function<AuthinfoRequest.Builder, ObjectBuilder<AuthinfoRequest>> fn) throws IOException,
        OpenSearchException {
        return authinfo(fn.apply(new AuthinfoRequest.Builder()).build());
    }

    /**
     * Returns or updates authentication information for the currently authenticated user.
     */
    public final AuthinfoResponse authinfo() throws IOException, OpenSearchException {
        return authinfo(new AuthinfoRequest.Builder().build());
    }

    // ----- Endpoint: security.authtoken

    /**
     * Returns the authorization token for the current user.
     */
    public AuthtokenResponse authtoken(AuthtokenRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, AuthtokenRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns the authorization token for the current user.
     *
     * @param fn a function that initializes a builder to create the {@link AuthtokenRequest}
     */
    public final AuthtokenResponse authtoken(Function<AuthtokenRequest.Builder, ObjectBuilder<AuthtokenRequest>> fn) throws IOException,
        OpenSearchException {
        return authtoken(fn.apply(new AuthtokenRequest.Builder()).build());
    }

    /**
     * Returns the authorization token for the current user.
     */
    public final AuthtokenResponse authtoken() throws IOException, OpenSearchException {
        return authtoken(new AuthtokenRequest.Builder().build());
    }

    // ----- Endpoint: security.change_password

    /**
     * Changes the password for the current user.
     */
    public ChangePasswordResponse changePassword(ChangePasswordRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ChangePasswordRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Changes the password for the current user.
     *
     * @param fn a function that initializes a builder to create the {@link ChangePasswordRequest}
     */
    public final ChangePasswordResponse changePassword(Function<ChangePasswordRequest.Builder, ObjectBuilder<ChangePasswordRequest>> fn)
        throws IOException, OpenSearchException {
        return changePassword(fn.apply(new ChangePasswordRequest.Builder()).build());
    }

    // ----- Endpoint: security.config_upgrade_check

    /**
     * Checks whether or not an upgrade can be performed and which security resources can be updated.
     */
    public ConfigUpgradeCheckResponse configUpgradeCheck(ConfigUpgradeCheckRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ConfigUpgradeCheckRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Checks whether or not an upgrade can be performed and which security resources can be updated.
     *
     * @param fn a function that initializes a builder to create the {@link ConfigUpgradeCheckRequest}
     */
    public final ConfigUpgradeCheckResponse configUpgradeCheck(
        Function<ConfigUpgradeCheckRequest.Builder, ObjectBuilder<ConfigUpgradeCheckRequest>> fn
    ) throws IOException, OpenSearchException {
        return configUpgradeCheck(fn.apply(new ConfigUpgradeCheckRequest.Builder()).build());
    }

    /**
     * Checks whether or not an upgrade can be performed and which security resources can be updated.
     */
    public final ConfigUpgradeCheckResponse configUpgradeCheck() throws IOException, OpenSearchException {
        return configUpgradeCheck(new ConfigUpgradeCheckRequest.Builder().build());
    }

    // ----- Endpoint: security.config_upgrade_perform

    /**
     * Assists the cluster operator with upgrading missing default values and stale default definitions.
     */
    public ConfigUpgradePerformResponse configUpgradePerform(ConfigUpgradePerformRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ConfigUpgradePerformRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Assists the cluster operator with upgrading missing default values and stale default definitions.
     *
     * @param fn a function that initializes a builder to create the {@link ConfigUpgradePerformRequest}
     */
    public final ConfigUpgradePerformResponse configUpgradePerform(
        Function<ConfigUpgradePerformRequest.Builder, ObjectBuilder<ConfigUpgradePerformRequest>> fn
    ) throws IOException, OpenSearchException {
        return configUpgradePerform(fn.apply(new ConfigUpgradePerformRequest.Builder()).build());
    }

    /**
     * Assists the cluster operator with upgrading missing default values and stale default definitions.
     */
    public final ConfigUpgradePerformResponse configUpgradePerform() throws IOException, OpenSearchException {
        return configUpgradePerform(new ConfigUpgradePerformRequest.Builder().build());
    }

    // ----- Endpoint: security.create_action_group

    /**
     * Creates or replaces the specified action group.
     */
    public CreateActionGroupResponse createActionGroup(CreateActionGroupRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateActionGroupRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or replaces the specified action group.
     *
     * @param fn a function that initializes a builder to create the {@link CreateActionGroupRequest}
     */
    public final CreateActionGroupResponse createActionGroup(
        Function<CreateActionGroupRequest.Builder, ObjectBuilder<CreateActionGroupRequest>> fn
    ) throws IOException, OpenSearchException {
        return createActionGroup(fn.apply(new CreateActionGroupRequest.Builder()).build());
    }

    // ----- Endpoint: security.create_allowlist

    /**
     * Creates or replaces APIs permitted for users on the allow list. Requires a super admin certificate or REST API permissions.
     */
    public CreateAllowlistResponse createAllowlist(CreateAllowlistRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateAllowlistRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or replaces APIs permitted for users on the allow list. Requires a super admin certificate or REST API permissions.
     *
     * @param fn a function that initializes a builder to create the {@link CreateAllowlistRequest}
     */
    public final CreateAllowlistResponse createAllowlist(Function<CreateAllowlistRequest.Builder, ObjectBuilder<CreateAllowlistRequest>> fn)
        throws IOException, OpenSearchException {
        return createAllowlist(fn.apply(new CreateAllowlistRequest.Builder()).build());
    }

    /**
     * Creates or replaces APIs permitted for users on the allow list. Requires a super admin certificate or REST API permissions.
     */
    public final CreateAllowlistResponse createAllowlist() throws IOException, OpenSearchException {
        return createAllowlist(new CreateAllowlistRequest.Builder().build());
    }

    // ----- Endpoint: security.create_role

    /**
     * Creates or replaces the specified role.
     */
    public CreateRoleResponse createRole(CreateRoleRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateRoleRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or replaces the specified role.
     *
     * @param fn a function that initializes a builder to create the {@link CreateRoleRequest}
     */
    public final CreateRoleResponse createRole(Function<CreateRoleRequest.Builder, ObjectBuilder<CreateRoleRequest>> fn) throws IOException,
        OpenSearchException {
        return createRole(fn.apply(new CreateRoleRequest.Builder()).build());
    }

    // ----- Endpoint: security.create_role_mapping

    /**
     * Creates or replaces the specified role mapping.
     */
    public CreateRoleMappingResponse createRoleMapping(CreateRoleMappingRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateRoleMappingRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or replaces the specified role mapping.
     *
     * @param fn a function that initializes a builder to create the {@link CreateRoleMappingRequest}
     */
    public final CreateRoleMappingResponse createRoleMapping(
        Function<CreateRoleMappingRequest.Builder, ObjectBuilder<CreateRoleMappingRequest>> fn
    ) throws IOException, OpenSearchException {
        return createRoleMapping(fn.apply(new CreateRoleMappingRequest.Builder()).build());
    }

    // ----- Endpoint: security.create_tenant

    /**
     * Creates or replaces the specified tenant.
     */
    public CreateTenantResponse createTenant(CreateTenantRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateTenantRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or replaces the specified tenant.
     *
     * @param fn a function that initializes a builder to create the {@link CreateTenantRequest}
     */
    public final CreateTenantResponse createTenant(Function<CreateTenantRequest.Builder, ObjectBuilder<CreateTenantRequest>> fn)
        throws IOException, OpenSearchException {
        return createTenant(fn.apply(new CreateTenantRequest.Builder()).build());
    }

    // ----- Endpoint: security.create_update_tenancy_config

    /**
     * Creates or replaces the multi-tenancy configuration. Requires super admin or REST API permissions.
     */
    public CreateUpdateTenancyConfigResponse createUpdateTenancyConfig(CreateUpdateTenancyConfigRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, CreateUpdateTenancyConfigRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or replaces the multi-tenancy configuration. Requires super admin or REST API permissions.
     *
     * @param fn a function that initializes a builder to create the {@link CreateUpdateTenancyConfigRequest}
     */
    public final CreateUpdateTenancyConfigResponse createUpdateTenancyConfig(
        Function<CreateUpdateTenancyConfigRequest.Builder, ObjectBuilder<CreateUpdateTenancyConfigRequest>> fn
    ) throws IOException, OpenSearchException {
        return createUpdateTenancyConfig(fn.apply(new CreateUpdateTenancyConfigRequest.Builder()).build());
    }

    /**
     * Creates or replaces the multi-tenancy configuration. Requires super admin or REST API permissions.
     */
    public final CreateUpdateTenancyConfigResponse createUpdateTenancyConfig() throws IOException, OpenSearchException {
        return createUpdateTenancyConfig(new CreateUpdateTenancyConfigRequest.Builder().build());
    }

    // ----- Endpoint: security.create_user

    /**
     * Creates or replaces the specified user.
     */
    public CreateUserResponse createUser(CreateUserRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateUserRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or replaces the specified user.
     *
     * @param fn a function that initializes a builder to create the {@link CreateUserRequest}
     */
    public final CreateUserResponse createUser(Function<CreateUserRequest.Builder, ObjectBuilder<CreateUserRequest>> fn) throws IOException,
        OpenSearchException {
        return createUser(fn.apply(new CreateUserRequest.Builder()).build());
    }

    // ----- Endpoint: security.create_user_legacy

    /**
     * Creates or replaces the specified user. Legacy API.
     */
    public CreateUserLegacyResponse createUserLegacy(CreateUserLegacyRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateUserLegacyRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or replaces the specified user. Legacy API.
     *
     * @param fn a function that initializes a builder to create the {@link CreateUserLegacyRequest}
     */
    public final CreateUserLegacyResponse createUserLegacy(
        Function<CreateUserLegacyRequest.Builder, ObjectBuilder<CreateUserLegacyRequest>> fn
    ) throws IOException, OpenSearchException {
        return createUserLegacy(fn.apply(new CreateUserLegacyRequest.Builder()).build());
    }

    // ----- Endpoint: security.delete_action_group

    /**
     * Deletes the specified action group.
     */
    public DeleteActionGroupResponse deleteActionGroup(DeleteActionGroupRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteActionGroupRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes the specified action group.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteActionGroupRequest}
     */
    public final DeleteActionGroupResponse deleteActionGroup(
        Function<DeleteActionGroupRequest.Builder, ObjectBuilder<DeleteActionGroupRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteActionGroup(fn.apply(new DeleteActionGroupRequest.Builder()).build());
    }

    // ----- Endpoint: security.delete_distinguished_name

    /**
     * Deletes all distinguished names in the specified cluster or node allowlist. Requires super admin or REST API permissions.
     */
    public DeleteDistinguishedNameResponse deleteDistinguishedName(DeleteDistinguishedNameRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, DeleteDistinguishedNameRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes all distinguished names in the specified cluster or node allowlist. Requires super admin or REST API permissions.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteDistinguishedNameRequest}
     */
    public final DeleteDistinguishedNameResponse deleteDistinguishedName(
        Function<DeleteDistinguishedNameRequest.Builder, ObjectBuilder<DeleteDistinguishedNameRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteDistinguishedName(fn.apply(new DeleteDistinguishedNameRequest.Builder()).build());
    }

    // ----- Endpoint: security.delete_role

    /**
     * Deletes the specified role.
     */
    public DeleteRoleResponse deleteRole(DeleteRoleRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteRoleRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes the specified role.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteRoleRequest}
     */
    public final DeleteRoleResponse deleteRole(Function<DeleteRoleRequest.Builder, ObjectBuilder<DeleteRoleRequest>> fn) throws IOException,
        OpenSearchException {
        return deleteRole(fn.apply(new DeleteRoleRequest.Builder()).build());
    }

    // ----- Endpoint: security.delete_role_mapping

    /**
     * Deletes the specified role mapping.
     */
    public DeleteRoleMappingResponse deleteRoleMapping(DeleteRoleMappingRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteRoleMappingRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes the specified role mapping.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteRoleMappingRequest}
     */
    public final DeleteRoleMappingResponse deleteRoleMapping(
        Function<DeleteRoleMappingRequest.Builder, ObjectBuilder<DeleteRoleMappingRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteRoleMapping(fn.apply(new DeleteRoleMappingRequest.Builder()).build());
    }

    // ----- Endpoint: security.delete_tenant

    /**
     * Deletes the specified tenant.
     */
    public DeleteTenantResponse deleteTenant(DeleteTenantRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteTenantRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes the specified tenant.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteTenantRequest}
     */
    public final DeleteTenantResponse deleteTenant(Function<DeleteTenantRequest.Builder, ObjectBuilder<DeleteTenantRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteTenant(fn.apply(new DeleteTenantRequest.Builder()).build());
    }

    // ----- Endpoint: security.delete_user

    /**
     * Deletes the specified internal user.
     */
    public DeleteUserResponse deleteUser(DeleteUserRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteUserRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes the specified internal user.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteUserRequest}
     */
    public final DeleteUserResponse deleteUser(Function<DeleteUserRequest.Builder, ObjectBuilder<DeleteUserRequest>> fn) throws IOException,
        OpenSearchException {
        return deleteUser(fn.apply(new DeleteUserRequest.Builder()).build());
    }

    // ----- Endpoint: security.delete_user_legacy

    /**
     * Delete the specified user. Legacy API.
     */
    public DeleteUserLegacyResponse deleteUserLegacy(DeleteUserLegacyRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteUserLegacyRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Delete the specified user. Legacy API.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteUserLegacyRequest}
     */
    public final DeleteUserLegacyResponse deleteUserLegacy(
        Function<DeleteUserLegacyRequest.Builder, ObjectBuilder<DeleteUserLegacyRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteUserLegacy(fn.apply(new DeleteUserLegacyRequest.Builder()).build());
    }

    // ----- Endpoint: security.flush_cache

    /**
     * Flushes the Security plugin's user, authentication, and authorization cache.
     */
    public FlushCacheResponse flushCache(FlushCacheRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, FlushCacheRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Flushes the Security plugin's user, authentication, and authorization cache.
     *
     * @param fn a function that initializes a builder to create the {@link FlushCacheRequest}
     */
    public final FlushCacheResponse flushCache(Function<FlushCacheRequest.Builder, ObjectBuilder<FlushCacheRequest>> fn) throws IOException,
        OpenSearchException {
        return flushCache(fn.apply(new FlushCacheRequest.Builder()).build());
    }

    /**
     * Flushes the Security plugin's user, authentication, and authorization cache.
     */
    public final FlushCacheResponse flushCache() throws IOException, OpenSearchException {
        return flushCache(new FlushCacheRequest.Builder().build());
    }

    // ----- Endpoint: security.generate_obo_token

    /**
     * Generates a <code>On-Behalf-Of</code> token for the current user.
     */
    public GenerateOboTokenResponse generateOboToken(GenerateOboTokenRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GenerateOboTokenRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Generates a <code>On-Behalf-Of</code> token for the current user.
     *
     * @param fn a function that initializes a builder to create the {@link GenerateOboTokenRequest}
     */
    public final GenerateOboTokenResponse generateOboToken(
        Function<GenerateOboTokenRequest.Builder, ObjectBuilder<GenerateOboTokenRequest>> fn
    ) throws IOException, OpenSearchException {
        return generateOboToken(fn.apply(new GenerateOboTokenRequest.Builder()).build());
    }

    // ----- Endpoint: security.generate_user_token

    /**
     * Generates an authorization token for the specified user.
     */
    public GenerateUserTokenResponse generateUserToken(GenerateUserTokenRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GenerateUserTokenRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Generates an authorization token for the specified user.
     *
     * @param fn a function that initializes a builder to create the {@link GenerateUserTokenRequest}
     */
    public final GenerateUserTokenResponse generateUserToken(
        Function<GenerateUserTokenRequest.Builder, ObjectBuilder<GenerateUserTokenRequest>> fn
    ) throws IOException, OpenSearchException {
        return generateUserToken(fn.apply(new GenerateUserTokenRequest.Builder()).build());
    }

    // ----- Endpoint: security.generate_user_token_legacy

    /**
     * Generates authorization token for the given user. Legacy API. Not Implemented.
     */
    public BooleanResponse generateUserTokenLegacy(GenerateUserTokenLegacyRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GenerateUserTokenLegacyRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Generates authorization token for the given user. Legacy API. Not Implemented.
     *
     * @param fn a function that initializes a builder to create the {@link GenerateUserTokenLegacyRequest}
     */
    public final BooleanResponse generateUserTokenLegacy(
        Function<GenerateUserTokenLegacyRequest.Builder, ObjectBuilder<GenerateUserTokenLegacyRequest>> fn
    ) throws IOException, OpenSearchException {
        return generateUserTokenLegacy(fn.apply(new GenerateUserTokenLegacyRequest.Builder()).build());
    }

    // ----- Endpoint: security.get_account_details

    /**
     * Returns account information for the current user.
     */
    public GetAccountDetailsResponse getAccountDetails(GetAccountDetailsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetAccountDetailsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns account information for the current user.
     *
     * @param fn a function that initializes a builder to create the {@link GetAccountDetailsRequest}
     */
    public final GetAccountDetailsResponse getAccountDetails(
        Function<GetAccountDetailsRequest.Builder, ObjectBuilder<GetAccountDetailsRequest>> fn
    ) throws IOException, OpenSearchException {
        return getAccountDetails(fn.apply(new GetAccountDetailsRequest.Builder()).build());
    }

    /**
     * Returns account information for the current user.
     */
    public final GetAccountDetailsResponse getAccountDetails() throws IOException, OpenSearchException {
        return getAccountDetails(new GetAccountDetailsRequest.Builder().build());
    }

    // ----- Endpoint: security.get_action_group

    /**
     * Retrieves one action group.
     */
    public GetActionGroupResponse getActionGroup(GetActionGroupRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetActionGroupRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves one action group.
     *
     * @param fn a function that initializes a builder to create the {@link GetActionGroupRequest}
     */
    public final GetActionGroupResponse getActionGroup(Function<GetActionGroupRequest.Builder, ObjectBuilder<GetActionGroupRequest>> fn)
        throws IOException, OpenSearchException {
        return getActionGroup(fn.apply(new GetActionGroupRequest.Builder()).build());
    }

    // ----- Endpoint: security.get_action_groups

    /**
     * Retrieves all action groups.
     */
    public GetActionGroupsResponse getActionGroups(GetActionGroupsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetActionGroupsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves all action groups.
     *
     * @param fn a function that initializes a builder to create the {@link GetActionGroupsRequest}
     */
    public final GetActionGroupsResponse getActionGroups(Function<GetActionGroupsRequest.Builder, ObjectBuilder<GetActionGroupsRequest>> fn)
        throws IOException, OpenSearchException {
        return getActionGroups(fn.apply(new GetActionGroupsRequest.Builder()).build());
    }

    /**
     * Retrieves all action groups.
     */
    public final GetActionGroupsResponse getActionGroups() throws IOException, OpenSearchException {
        return getActionGroups(new GetActionGroupsRequest.Builder().build());
    }

    // ----- Endpoint: security.get_all_certificates

    /**
     * Retrieves the cluster security certificates.
     */
    public GetAllCertificatesResponse getAllCertificates(GetAllCertificatesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetAllCertificatesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves the cluster security certificates.
     *
     * @param fn a function that initializes a builder to create the {@link GetAllCertificatesRequest}
     */
    public final GetAllCertificatesResponse getAllCertificates(
        Function<GetAllCertificatesRequest.Builder, ObjectBuilder<GetAllCertificatesRequest>> fn
    ) throws IOException, OpenSearchException {
        return getAllCertificates(fn.apply(new GetAllCertificatesRequest.Builder()).build());
    }

    /**
     * Retrieves the cluster security certificates.
     */
    public final GetAllCertificatesResponse getAllCertificates() throws IOException, OpenSearchException {
        return getAllCertificates(new GetAllCertificatesRequest.Builder().build());
    }

    // ----- Endpoint: security.get_allowlist

    /**
     * Retrieves the current list of allowed APIs accessible to a normal user.
     */
    public GetAllowlistResponse getAllowlist(GetAllowlistRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetAllowlistRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves the current list of allowed APIs accessible to a normal user.
     *
     * @param fn a function that initializes a builder to create the {@link GetAllowlistRequest}
     */
    public final GetAllowlistResponse getAllowlist(Function<GetAllowlistRequest.Builder, ObjectBuilder<GetAllowlistRequest>> fn)
        throws IOException, OpenSearchException {
        return getAllowlist(fn.apply(new GetAllowlistRequest.Builder()).build());
    }

    /**
     * Retrieves the current list of allowed APIs accessible to a normal user.
     */
    public final GetAllowlistResponse getAllowlist() throws IOException, OpenSearchException {
        return getAllowlist(new GetAllowlistRequest.Builder().build());
    }

    // ----- Endpoint: security.get_audit_configuration

    /**
     * Retrieves the audit configuration.
     */
    public GetAuditConfigurationResponse getAuditConfiguration(GetAuditConfigurationRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, GetAuditConfigurationRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves the audit configuration.
     *
     * @param fn a function that initializes a builder to create the {@link GetAuditConfigurationRequest}
     */
    public final GetAuditConfigurationResponse getAuditConfiguration(
        Function<GetAuditConfigurationRequest.Builder, ObjectBuilder<GetAuditConfigurationRequest>> fn
    ) throws IOException, OpenSearchException {
        return getAuditConfiguration(fn.apply(new GetAuditConfigurationRequest.Builder()).build());
    }

    /**
     * Retrieves the audit configuration.
     */
    public final GetAuditConfigurationResponse getAuditConfiguration() throws IOException, OpenSearchException {
        return getAuditConfiguration(new GetAuditConfigurationRequest.Builder().build());
    }

    // ----- Endpoint: security.get_certificates

    /**
     * Retrieves the cluster security certificates.
     */
    public GetCertificatesResponse getCertificates(GetCertificatesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetCertificatesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves the cluster security certificates.
     *
     * @param fn a function that initializes a builder to create the {@link GetCertificatesRequest}
     */
    public final GetCertificatesResponse getCertificates(Function<GetCertificatesRequest.Builder, ObjectBuilder<GetCertificatesRequest>> fn)
        throws IOException, OpenSearchException {
        return getCertificates(fn.apply(new GetCertificatesRequest.Builder()).build());
    }

    /**
     * Retrieves the cluster security certificates.
     */
    public final GetCertificatesResponse getCertificates() throws IOException, OpenSearchException {
        return getCertificates(new GetCertificatesRequest.Builder().build());
    }

    // ----- Endpoint: security.get_configuration

    /**
     * Returns the current Security plugin configuration in a JSON format.
     */
    public GetConfigurationResponse getConfiguration(GetConfigurationRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetConfigurationRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns the current Security plugin configuration in a JSON format.
     *
     * @param fn a function that initializes a builder to create the {@link GetConfigurationRequest}
     */
    public final GetConfigurationResponse getConfiguration(
        Function<GetConfigurationRequest.Builder, ObjectBuilder<GetConfigurationRequest>> fn
    ) throws IOException, OpenSearchException {
        return getConfiguration(fn.apply(new GetConfigurationRequest.Builder()).build());
    }

    /**
     * Returns the current Security plugin configuration in a JSON format.
     */
    public final GetConfigurationResponse getConfiguration() throws IOException, OpenSearchException {
        return getConfiguration(new GetConfigurationRequest.Builder().build());
    }

    // ----- Endpoint: security.get_dashboards_info

    /**
     * Retrieves the current values for dynamic security settings for OpenSearch Dashboards.
     */
    public GetDashboardsInfoResponse getDashboardsInfo(GetDashboardsInfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetDashboardsInfoRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves the current values for dynamic security settings for OpenSearch Dashboards.
     *
     * @param fn a function that initializes a builder to create the {@link GetDashboardsInfoRequest}
     */
    public final GetDashboardsInfoResponse getDashboardsInfo(
        Function<GetDashboardsInfoRequest.Builder, ObjectBuilder<GetDashboardsInfoRequest>> fn
    ) throws IOException, OpenSearchException {
        return getDashboardsInfo(fn.apply(new GetDashboardsInfoRequest.Builder()).build());
    }

    /**
     * Retrieves the current values for dynamic security settings for OpenSearch Dashboards.
     */
    public final GetDashboardsInfoResponse getDashboardsInfo() throws IOException, OpenSearchException {
        return getDashboardsInfo(new GetDashboardsInfoRequest.Builder().build());
    }

    // ----- Endpoint: security.get_distinguished_name

    /**
     * Retrieves all node distinguished names. Requires super admin or REST API permissions.
     */
    public GetDistinguishedNameResponse getDistinguishedName(GetDistinguishedNameRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetDistinguishedNameRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves all node distinguished names. Requires super admin or REST API permissions.
     *
     * @param fn a function that initializes a builder to create the {@link GetDistinguishedNameRequest}
     */
    public final GetDistinguishedNameResponse getDistinguishedName(
        Function<GetDistinguishedNameRequest.Builder, ObjectBuilder<GetDistinguishedNameRequest>> fn
    ) throws IOException, OpenSearchException {
        return getDistinguishedName(fn.apply(new GetDistinguishedNameRequest.Builder()).build());
    }

    // ----- Endpoint: security.get_distinguished_names

    /**
     * Retrieves all node distinguished names. Requires super admin or REST API permissions.
     */
    public GetDistinguishedNamesResponse getDistinguishedNames(GetDistinguishedNamesRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, GetDistinguishedNamesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves all node distinguished names. Requires super admin or REST API permissions.
     *
     * @param fn a function that initializes a builder to create the {@link GetDistinguishedNamesRequest}
     */
    public final GetDistinguishedNamesResponse getDistinguishedNames(
        Function<GetDistinguishedNamesRequest.Builder, ObjectBuilder<GetDistinguishedNamesRequest>> fn
    ) throws IOException, OpenSearchException {
        return getDistinguishedNames(fn.apply(new GetDistinguishedNamesRequest.Builder()).build());
    }

    /**
     * Retrieves all node distinguished names. Requires super admin or REST API permissions.
     */
    public final GetDistinguishedNamesResponse getDistinguishedNames() throws IOException, OpenSearchException {
        return getDistinguishedNames(new GetDistinguishedNamesRequest.Builder().build());
    }

    // ----- Endpoint: security.get_node_certificates

    /**
     * Retrieves the specified node's security certificates.
     */
    public GetNodeCertificatesResponse getNodeCertificates(GetNodeCertificatesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetNodeCertificatesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves the specified node's security certificates.
     *
     * @param fn a function that initializes a builder to create the {@link GetNodeCertificatesRequest}
     */
    public final GetNodeCertificatesResponse getNodeCertificates(
        Function<GetNodeCertificatesRequest.Builder, ObjectBuilder<GetNodeCertificatesRequest>> fn
    ) throws IOException, OpenSearchException {
        return getNodeCertificates(fn.apply(new GetNodeCertificatesRequest.Builder()).build());
    }

    // ----- Endpoint: security.get_permissions_info

    /**
     * Retrieves the evaluated REST API permissions for the currently logged in user.
     */
    public GetPermissionsInfoResponse getPermissionsInfo(GetPermissionsInfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetPermissionsInfoRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves the evaluated REST API permissions for the currently logged in user.
     *
     * @param fn a function that initializes a builder to create the {@link GetPermissionsInfoRequest}
     */
    public final GetPermissionsInfoResponse getPermissionsInfo(
        Function<GetPermissionsInfoRequest.Builder, ObjectBuilder<GetPermissionsInfoRequest>> fn
    ) throws IOException, OpenSearchException {
        return getPermissionsInfo(fn.apply(new GetPermissionsInfoRequest.Builder()).build());
    }

    /**
     * Retrieves the evaluated REST API permissions for the currently logged in user.
     */
    public final GetPermissionsInfoResponse getPermissionsInfo() throws IOException, OpenSearchException {
        return getPermissionsInfo(new GetPermissionsInfoRequest.Builder().build());
    }

    // ----- Endpoint: security.get_role

    /**
     * Retrieves one role.
     */
    public GetRoleResponse getRole(GetRoleRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetRoleRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves one role.
     *
     * @param fn a function that initializes a builder to create the {@link GetRoleRequest}
     */
    public final GetRoleResponse getRole(Function<GetRoleRequest.Builder, ObjectBuilder<GetRoleRequest>> fn) throws IOException,
        OpenSearchException {
        return getRole(fn.apply(new GetRoleRequest.Builder()).build());
    }

    // ----- Endpoint: security.get_role_mapping

    /**
     * Retrieves the specified role mapping.
     */
    public GetRoleMappingResponse getRoleMapping(GetRoleMappingRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetRoleMappingRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves the specified role mapping.
     *
     * @param fn a function that initializes a builder to create the {@link GetRoleMappingRequest}
     */
    public final GetRoleMappingResponse getRoleMapping(Function<GetRoleMappingRequest.Builder, ObjectBuilder<GetRoleMappingRequest>> fn)
        throws IOException, OpenSearchException {
        return getRoleMapping(fn.apply(new GetRoleMappingRequest.Builder()).build());
    }

    // ----- Endpoint: security.get_role_mappings

    /**
     * Retrieves all role mappings.
     */
    public GetRoleMappingsResponse getRoleMappings(GetRoleMappingsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetRoleMappingsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves all role mappings.
     *
     * @param fn a function that initializes a builder to create the {@link GetRoleMappingsRequest}
     */
    public final GetRoleMappingsResponse getRoleMappings(Function<GetRoleMappingsRequest.Builder, ObjectBuilder<GetRoleMappingsRequest>> fn)
        throws IOException, OpenSearchException {
        return getRoleMappings(fn.apply(new GetRoleMappingsRequest.Builder()).build());
    }

    /**
     * Retrieves all role mappings.
     */
    public final GetRoleMappingsResponse getRoleMappings() throws IOException, OpenSearchException {
        return getRoleMappings(new GetRoleMappingsRequest.Builder().build());
    }

    // ----- Endpoint: security.get_roles

    /**
     * Retrieves all roles.
     */
    public GetRolesResponse getRoles(GetRolesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetRolesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves all roles.
     *
     * @param fn a function that initializes a builder to create the {@link GetRolesRequest}
     */
    public final GetRolesResponse getRoles(Function<GetRolesRequest.Builder, ObjectBuilder<GetRolesRequest>> fn) throws IOException,
        OpenSearchException {
        return getRoles(fn.apply(new GetRolesRequest.Builder()).build());
    }

    /**
     * Retrieves all roles.
     */
    public final GetRolesResponse getRoles() throws IOException, OpenSearchException {
        return getRoles(new GetRolesRequest.Builder().build());
    }

    // ----- Endpoint: security.get_sslinfo

    /**
     * Retrieves information about the SSL configuration.
     */
    public GetSslinfoResponse getSslinfo(GetSslinfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetSslinfoRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves information about the SSL configuration.
     *
     * @param fn a function that initializes a builder to create the {@link GetSslinfoRequest}
     */
    public final GetSslinfoResponse getSslinfo(Function<GetSslinfoRequest.Builder, ObjectBuilder<GetSslinfoRequest>> fn) throws IOException,
        OpenSearchException {
        return getSslinfo(fn.apply(new GetSslinfoRequest.Builder()).build());
    }

    /**
     * Retrieves information about the SSL configuration.
     */
    public final GetSslinfoResponse getSslinfo() throws IOException, OpenSearchException {
        return getSslinfo(new GetSslinfoRequest.Builder().build());
    }

    // ----- Endpoint: security.get_tenancy_config

    /**
     * Retrieves the multi-tenancy configuration. Requires super admin or REST API permissions.
     */
    public GetTenancyConfigResponse getTenancyConfig(GetTenancyConfigRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetTenancyConfigRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves the multi-tenancy configuration. Requires super admin or REST API permissions.
     *
     * @param fn a function that initializes a builder to create the {@link GetTenancyConfigRequest}
     */
    public final GetTenancyConfigResponse getTenancyConfig(
        Function<GetTenancyConfigRequest.Builder, ObjectBuilder<GetTenancyConfigRequest>> fn
    ) throws IOException, OpenSearchException {
        return getTenancyConfig(fn.apply(new GetTenancyConfigRequest.Builder()).build());
    }

    /**
     * Retrieves the multi-tenancy configuration. Requires super admin or REST API permissions.
     */
    public final GetTenancyConfigResponse getTenancyConfig() throws IOException, OpenSearchException {
        return getTenancyConfig(new GetTenancyConfigRequest.Builder().build());
    }

    // ----- Endpoint: security.get_tenant

    /**
     * Retrieves the specified tenant.
     */
    public GetTenantResponse getTenant(GetTenantRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetTenantRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves the specified tenant.
     *
     * @param fn a function that initializes a builder to create the {@link GetTenantRequest}
     */
    public final GetTenantResponse getTenant(Function<GetTenantRequest.Builder, ObjectBuilder<GetTenantRequest>> fn) throws IOException,
        OpenSearchException {
        return getTenant(fn.apply(new GetTenantRequest.Builder()).build());
    }

    // ----- Endpoint: security.get_tenants

    /**
     * Retrieves all tenants.
     */
    public GetTenantsResponse getTenants(GetTenantsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetTenantsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves all tenants.
     *
     * @param fn a function that initializes a builder to create the {@link GetTenantsRequest}
     */
    public final GetTenantsResponse getTenants(Function<GetTenantsRequest.Builder, ObjectBuilder<GetTenantsRequest>> fn) throws IOException,
        OpenSearchException {
        return getTenants(fn.apply(new GetTenantsRequest.Builder()).build());
    }

    /**
     * Retrieves all tenants.
     */
    public final GetTenantsResponse getTenants() throws IOException, OpenSearchException {
        return getTenants(new GetTenantsRequest.Builder().build());
    }

    // ----- Endpoint: security.get_user

    /**
     * Retrieve information about the specified internal user.
     */
    public GetUserResponse getUser(GetUserRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetUserRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieve information about the specified internal user.
     *
     * @param fn a function that initializes a builder to create the {@link GetUserRequest}
     */
    public final GetUserResponse getUser(Function<GetUserRequest.Builder, ObjectBuilder<GetUserRequest>> fn) throws IOException,
        OpenSearchException {
        return getUser(fn.apply(new GetUserRequest.Builder()).build());
    }

    // ----- Endpoint: security.get_user_legacy

    /**
     * Retrieve one user. Legacy API.
     */
    public GetUserLegacyResponse getUserLegacy(GetUserLegacyRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetUserLegacyRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieve one user. Legacy API.
     *
     * @param fn a function that initializes a builder to create the {@link GetUserLegacyRequest}
     */
    public final GetUserLegacyResponse getUserLegacy(Function<GetUserLegacyRequest.Builder, ObjectBuilder<GetUserLegacyRequest>> fn)
        throws IOException, OpenSearchException {
        return getUserLegacy(fn.apply(new GetUserLegacyRequest.Builder()).build());
    }

    // ----- Endpoint: security.get_users

    /**
     * Retrieve all internal users.
     */
    public GetUsersResponse getUsers(GetUsersRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetUsersRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieve all internal users.
     *
     * @param fn a function that initializes a builder to create the {@link GetUsersRequest}
     */
    public final GetUsersResponse getUsers(Function<GetUsersRequest.Builder, ObjectBuilder<GetUsersRequest>> fn) throws IOException,
        OpenSearchException {
        return getUsers(fn.apply(new GetUsersRequest.Builder()).build());
    }

    /**
     * Retrieve all internal users.
     */
    public final GetUsersResponse getUsers() throws IOException, OpenSearchException {
        return getUsers(new GetUsersRequest.Builder().build());
    }

    // ----- Endpoint: security.get_users_legacy

    /**
     * Retrieve all internal users. Legacy API.
     */
    public GetUsersLegacyResponse getUsersLegacy(GetUsersLegacyRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetUsersLegacyRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieve all internal users. Legacy API.
     *
     * @param fn a function that initializes a builder to create the {@link GetUsersLegacyRequest}
     */
    public final GetUsersLegacyResponse getUsersLegacy(Function<GetUsersLegacyRequest.Builder, ObjectBuilder<GetUsersLegacyRequest>> fn)
        throws IOException, OpenSearchException {
        return getUsersLegacy(fn.apply(new GetUsersLegacyRequest.Builder()).build());
    }

    /**
     * Retrieve all internal users. Legacy API.
     */
    public final GetUsersLegacyResponse getUsersLegacy() throws IOException, OpenSearchException {
        return getUsersLegacy(new GetUsersLegacyRequest.Builder().build());
    }

    // ----- Endpoint: security.health

    /**
     * Checks to see if the Security plugin is running.
     */
    public HealthResponse health(HealthRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, HealthRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Checks to see if the Security plugin is running.
     *
     * @param fn a function that initializes a builder to create the {@link HealthRequest}
     */
    public final HealthResponse health(Function<HealthRequest.Builder, ObjectBuilder<HealthRequest>> fn) throws IOException,
        OpenSearchException {
        return health(fn.apply(new HealthRequest.Builder()).build());
    }

    /**
     * Checks to see if the Security plugin is running.
     */
    public final HealthResponse health() throws IOException, OpenSearchException {
        return health(new HealthRequest.Builder().build());
    }

    // ----- Endpoint: security.migrate

    /**
     * Migrates the security configuration from v6 to v7.
     */
    public MigrateResponse migrate(MigrateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, MigrateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Migrates the security configuration from v6 to v7.
     *
     * @param fn a function that initializes a builder to create the {@link MigrateRequest}
     */
    public final MigrateResponse migrate(Function<MigrateRequest.Builder, ObjectBuilder<MigrateRequest>> fn) throws IOException,
        OpenSearchException {
        return migrate(fn.apply(new MigrateRequest.Builder()).build());
    }

    /**
     * Migrates the security configuration from v6 to v7.
     */
    public final MigrateResponse migrate() throws IOException, OpenSearchException {
        return migrate(new MigrateRequest.Builder().build());
    }

    // ----- Endpoint: security.patch_action_group

    /**
     * Updates the individual attributes of an action group.
     */
    public PatchActionGroupResponse patchActionGroup(PatchActionGroupRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchActionGroupRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates the individual attributes of an action group.
     *
     * @param fn a function that initializes a builder to create the {@link PatchActionGroupRequest}
     */
    public final PatchActionGroupResponse patchActionGroup(
        Function<PatchActionGroupRequest.Builder, ObjectBuilder<PatchActionGroupRequest>> fn
    ) throws IOException, OpenSearchException {
        return patchActionGroup(fn.apply(new PatchActionGroupRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_action_groups

    /**
     * Creates, updates, or deletes multiple action groups in a single request.
     */
    public PatchActionGroupsResponse patchActionGroups(PatchActionGroupsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchActionGroupsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates, updates, or deletes multiple action groups in a single request.
     *
     * @param fn a function that initializes a builder to create the {@link PatchActionGroupsRequest}
     */
    public final PatchActionGroupsResponse patchActionGroups(
        Function<PatchActionGroupsRequest.Builder, ObjectBuilder<PatchActionGroupsRequest>> fn
    ) throws IOException, OpenSearchException {
        return patchActionGroups(fn.apply(new PatchActionGroupsRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_allowlist

    /**
     * Updates the current list of APIs accessible for users on the allow list.
     */
    public PatchAllowlistResponse patchAllowlist(PatchAllowlistRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchAllowlistRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates the current list of APIs accessible for users on the allow list.
     *
     * @param fn a function that initializes a builder to create the {@link PatchAllowlistRequest}
     */
    public final PatchAllowlistResponse patchAllowlist(Function<PatchAllowlistRequest.Builder, ObjectBuilder<PatchAllowlistRequest>> fn)
        throws IOException, OpenSearchException {
        return patchAllowlist(fn.apply(new PatchAllowlistRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_audit_configuration

    /**
     * Updates the specified fields in the audit configuration.
     */
    public PatchAuditConfigurationResponse patchAuditConfiguration(PatchAuditConfigurationRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, PatchAuditConfigurationRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates the specified fields in the audit configuration.
     *
     * @param fn a function that initializes a builder to create the {@link PatchAuditConfigurationRequest}
     */
    public final PatchAuditConfigurationResponse patchAuditConfiguration(
        Function<PatchAuditConfigurationRequest.Builder, ObjectBuilder<PatchAuditConfigurationRequest>> fn
    ) throws IOException, OpenSearchException {
        return patchAuditConfiguration(fn.apply(new PatchAuditConfigurationRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_configuration

    /**
     * Updates the existing security configuration using the REST API. Requires super admin or REST API permissions.
     */
    public PatchConfigurationResponse patchConfiguration(PatchConfigurationRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchConfigurationRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates the existing security configuration using the REST API. Requires super admin or REST API permissions.
     *
     * @param fn a function that initializes a builder to create the {@link PatchConfigurationRequest}
     */
    public final PatchConfigurationResponse patchConfiguration(
        Function<PatchConfigurationRequest.Builder, ObjectBuilder<PatchConfigurationRequest>> fn
    ) throws IOException, OpenSearchException {
        return patchConfiguration(fn.apply(new PatchConfigurationRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_distinguished_name

    /**
     * Updates the distinguished cluster name for the specified cluster. Requires super admin or REST API permissions.
     */
    public PatchDistinguishedNameResponse patchDistinguishedName(PatchDistinguishedNameRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, PatchDistinguishedNameRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates the distinguished cluster name for the specified cluster. Requires super admin or REST API permissions.
     *
     * @param fn a function that initializes a builder to create the {@link PatchDistinguishedNameRequest}
     */
    public final PatchDistinguishedNameResponse patchDistinguishedName(
        Function<PatchDistinguishedNameRequest.Builder, ObjectBuilder<PatchDistinguishedNameRequest>> fn
    ) throws IOException, OpenSearchException {
        return patchDistinguishedName(fn.apply(new PatchDistinguishedNameRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_distinguished_names

    /**
     * Bulk updates specified node distinguished names. Requires super admin or REST API permissions.
     */
    public PatchDistinguishedNamesResponse patchDistinguishedNames(PatchDistinguishedNamesRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, PatchDistinguishedNamesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Bulk updates specified node distinguished names. Requires super admin or REST API permissions.
     *
     * @param fn a function that initializes a builder to create the {@link PatchDistinguishedNamesRequest}
     */
    public final PatchDistinguishedNamesResponse patchDistinguishedNames(
        Function<PatchDistinguishedNamesRequest.Builder, ObjectBuilder<PatchDistinguishedNamesRequest>> fn
    ) throws IOException, OpenSearchException {
        return patchDistinguishedNames(fn.apply(new PatchDistinguishedNamesRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_role

    /**
     * Updates the individual attributes of a role.
     */
    public PatchRoleResponse patchRole(PatchRoleRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchRoleRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates the individual attributes of a role.
     *
     * @param fn a function that initializes a builder to create the {@link PatchRoleRequest}
     */
    public final PatchRoleResponse patchRole(Function<PatchRoleRequest.Builder, ObjectBuilder<PatchRoleRequest>> fn) throws IOException,
        OpenSearchException {
        return patchRole(fn.apply(new PatchRoleRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_role_mapping

    /**
     * Updates the individual attributes of a role mapping.
     */
    public PatchRoleMappingResponse patchRoleMapping(PatchRoleMappingRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchRoleMappingRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates the individual attributes of a role mapping.
     *
     * @param fn a function that initializes a builder to create the {@link PatchRoleMappingRequest}
     */
    public final PatchRoleMappingResponse patchRoleMapping(
        Function<PatchRoleMappingRequest.Builder, ObjectBuilder<PatchRoleMappingRequest>> fn
    ) throws IOException, OpenSearchException {
        return patchRoleMapping(fn.apply(new PatchRoleMappingRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_role_mappings

    /**
     * Creates or updates multiple role mappings in a single request.
     */
    public PatchRoleMappingsResponse patchRoleMappings(PatchRoleMappingsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchRoleMappingsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or updates multiple role mappings in a single request.
     *
     * @param fn a function that initializes a builder to create the {@link PatchRoleMappingsRequest}
     */
    public final PatchRoleMappingsResponse patchRoleMappings(
        Function<PatchRoleMappingsRequest.Builder, ObjectBuilder<PatchRoleMappingsRequest>> fn
    ) throws IOException, OpenSearchException {
        return patchRoleMappings(fn.apply(new PatchRoleMappingsRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_roles

    /**
     * Creates, updates, or deletes multiple roles in a single call.
     */
    public PatchRolesResponse patchRoles(PatchRolesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchRolesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates, updates, or deletes multiple roles in a single call.
     *
     * @param fn a function that initializes a builder to create the {@link PatchRolesRequest}
     */
    public final PatchRolesResponse patchRoles(Function<PatchRolesRequest.Builder, ObjectBuilder<PatchRolesRequest>> fn) throws IOException,
        OpenSearchException {
        return patchRoles(fn.apply(new PatchRolesRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_tenant

    /**
     * Adds, deletes, or modifies a single tenant.
     */
    public PatchTenantResponse patchTenant(PatchTenantRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchTenantRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Adds, deletes, or modifies a single tenant.
     *
     * @param fn a function that initializes a builder to create the {@link PatchTenantRequest}
     */
    public final PatchTenantResponse patchTenant(Function<PatchTenantRequest.Builder, ObjectBuilder<PatchTenantRequest>> fn)
        throws IOException, OpenSearchException {
        return patchTenant(fn.apply(new PatchTenantRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_tenants

    /**
     * Adds, deletes, or modifies multiple tenants in a single request.
     */
    public PatchTenantsResponse patchTenants(PatchTenantsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchTenantsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Adds, deletes, or modifies multiple tenants in a single request.
     *
     * @param fn a function that initializes a builder to create the {@link PatchTenantsRequest}
     */
    public final PatchTenantsResponse patchTenants(Function<PatchTenantsRequest.Builder, ObjectBuilder<PatchTenantsRequest>> fn)
        throws IOException, OpenSearchException {
        return patchTenants(fn.apply(new PatchTenantsRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_user

    /**
     * Updates individual attributes for an internal user.
     */
    public PatchUserResponse patchUser(PatchUserRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchUserRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates individual attributes for an internal user.
     *
     * @param fn a function that initializes a builder to create the {@link PatchUserRequest}
     */
    public final PatchUserResponse patchUser(Function<PatchUserRequest.Builder, ObjectBuilder<PatchUserRequest>> fn) throws IOException,
        OpenSearchException {
        return patchUser(fn.apply(new PatchUserRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_users

    /**
     * Creates, updates, or deletes multiple internal users in a single request.
     */
    public PatchUsersResponse patchUsers(PatchUsersRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchUsersRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates, updates, or deletes multiple internal users in a single request.
     *
     * @param fn a function that initializes a builder to create the {@link PatchUsersRequest}
     */
    public final PatchUsersResponse patchUsers(Function<PatchUsersRequest.Builder, ObjectBuilder<PatchUsersRequest>> fn) throws IOException,
        OpenSearchException {
        return patchUsers(fn.apply(new PatchUsersRequest.Builder()).build());
    }

    // ----- Endpoint: security.post_dashboards_info

    /**
     * Retrieves the current values for dynamic security settings for OpenSearch Dashboards.
     */
    public PostDashboardsInfoResponse postDashboardsInfo(PostDashboardsInfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PostDashboardsInfoRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves the current values for dynamic security settings for OpenSearch Dashboards.
     *
     * @param fn a function that initializes a builder to create the {@link PostDashboardsInfoRequest}
     */
    public final PostDashboardsInfoResponse postDashboardsInfo(
        Function<PostDashboardsInfoRequest.Builder, ObjectBuilder<PostDashboardsInfoRequest>> fn
    ) throws IOException, OpenSearchException {
        return postDashboardsInfo(fn.apply(new PostDashboardsInfoRequest.Builder()).build());
    }

    /**
     * Retrieves the current values for dynamic security settings for OpenSearch Dashboards.
     */
    public final PostDashboardsInfoResponse postDashboardsInfo() throws IOException, OpenSearchException {
        return postDashboardsInfo(new PostDashboardsInfoRequest.Builder().build());
    }

    // ----- Endpoint: security.reload_http_certificates

    /**
     * Reloads the HTTP communication certificates.
     */
    public ReloadHttpCertificatesResponse reloadHttpCertificates(ReloadHttpCertificatesRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, ReloadHttpCertificatesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Reloads the HTTP communication certificates.
     *
     * @param fn a function that initializes a builder to create the {@link ReloadHttpCertificatesRequest}
     */
    public final ReloadHttpCertificatesResponse reloadHttpCertificates(
        Function<ReloadHttpCertificatesRequest.Builder, ObjectBuilder<ReloadHttpCertificatesRequest>> fn
    ) throws IOException, OpenSearchException {
        return reloadHttpCertificates(fn.apply(new ReloadHttpCertificatesRequest.Builder()).build());
    }

    /**
     * Reloads the HTTP communication certificates.
     */
    public final ReloadHttpCertificatesResponse reloadHttpCertificates() throws IOException, OpenSearchException {
        return reloadHttpCertificates(new ReloadHttpCertificatesRequest.Builder().build());
    }

    // ----- Endpoint: security.reload_transport_certificates

    /**
     * Reloads the transport communication certificates.
     */
    public ReloadTransportCertificatesResponse reloadTransportCertificates(ReloadTransportCertificatesRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, ReloadTransportCertificatesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Reloads the transport communication certificates.
     *
     * @param fn a function that initializes a builder to create the {@link ReloadTransportCertificatesRequest}
     */
    public final ReloadTransportCertificatesResponse reloadTransportCertificates(
        Function<ReloadTransportCertificatesRequest.Builder, ObjectBuilder<ReloadTransportCertificatesRequest>> fn
    ) throws IOException, OpenSearchException {
        return reloadTransportCertificates(fn.apply(new ReloadTransportCertificatesRequest.Builder()).build());
    }

    /**
     * Reloads the transport communication certificates.
     */
    public final ReloadTransportCertificatesResponse reloadTransportCertificates() throws IOException, OpenSearchException {
        return reloadTransportCertificates(new ReloadTransportCertificatesRequest.Builder().build());
    }

    // ----- Endpoint: security.tenant_info

    /**
     * Retrieves the names of current tenants. Requires super admin or <code>kibanaserver</code> permissions.
     */
    public TenantInfoResponse tenantInfo(TenantInfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, TenantInfoRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves the names of current tenants. Requires super admin or <code>kibanaserver</code> permissions.
     *
     * @param fn a function that initializes a builder to create the {@link TenantInfoRequest}
     */
    public final TenantInfoResponse tenantInfo(Function<TenantInfoRequest.Builder, ObjectBuilder<TenantInfoRequest>> fn) throws IOException,
        OpenSearchException {
        return tenantInfo(fn.apply(new TenantInfoRequest.Builder()).build());
    }

    /**
     * Retrieves the names of current tenants. Requires super admin or <code>kibanaserver</code> permissions.
     */
    public final TenantInfoResponse tenantInfo() throws IOException, OpenSearchException {
        return tenantInfo(new TenantInfoRequest.Builder().build());
    }

    // ----- Endpoint: security.update_audit_configuration

    /**
     * Updates the audit configuration.
     */
    public UpdateAuditConfigurationResponse updateAuditConfiguration(UpdateAuditConfigurationRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, UpdateAuditConfigurationRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates the audit configuration.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateAuditConfigurationRequest}
     */
    public final UpdateAuditConfigurationResponse updateAuditConfiguration(
        Function<UpdateAuditConfigurationRequest.Builder, ObjectBuilder<UpdateAuditConfigurationRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateAuditConfiguration(fn.apply(new UpdateAuditConfigurationRequest.Builder()).build());
    }

    /**
     * Updates the audit configuration.
     */
    public final UpdateAuditConfigurationResponse updateAuditConfiguration() throws IOException, OpenSearchException {
        return updateAuditConfiguration(new UpdateAuditConfigurationRequest.Builder().build());
    }

    // ----- Endpoint: security.update_configuration

    /**
     * Updates the settings for an existing security configuration. Requires super admin or REST API permissions.
     */
    public UpdateConfigurationResponse updateConfiguration(UpdateConfigurationRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, UpdateConfigurationRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates the settings for an existing security configuration. Requires super admin or REST API permissions.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateConfigurationRequest}
     */
    public final UpdateConfigurationResponse updateConfiguration(
        Function<UpdateConfigurationRequest.Builder, ObjectBuilder<UpdateConfigurationRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateConfiguration(fn.apply(new UpdateConfigurationRequest.Builder()).build());
    }

    /**
     * Updates the settings for an existing security configuration. Requires super admin or REST API permissions.
     */
    public final UpdateConfigurationResponse updateConfiguration() throws IOException, OpenSearchException {
        return updateConfiguration(new UpdateConfigurationRequest.Builder().build());
    }

    // ----- Endpoint: security.update_distinguished_name

    /**
     * Adds or updates the specified distinguished names in the cluster or node allowlist. Requires super admin or REST API permissions.
     */
    public UpdateDistinguishedNameResponse updateDistinguishedName(UpdateDistinguishedNameRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, UpdateDistinguishedNameRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Adds or updates the specified distinguished names in the cluster or node allowlist. Requires super admin or REST API permissions.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateDistinguishedNameRequest}
     */
    public final UpdateDistinguishedNameResponse updateDistinguishedName(
        Function<UpdateDistinguishedNameRequest.Builder, ObjectBuilder<UpdateDistinguishedNameRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateDistinguishedName(fn.apply(new UpdateDistinguishedNameRequest.Builder()).build());
    }

    // ----- Endpoint: security.validate

    /**
     * Checks whether the v6 security configuration is valid and ready to be migrated to v7.
     */
    public ValidateResponse validate(ValidateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ValidateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Checks whether the v6 security configuration is valid and ready to be migrated to v7.
     *
     * @param fn a function that initializes a builder to create the {@link ValidateRequest}
     */
    public final ValidateResponse validate(Function<ValidateRequest.Builder, ObjectBuilder<ValidateRequest>> fn) throws IOException,
        OpenSearchException {
        return validate(fn.apply(new ValidateRequest.Builder()).build());
    }

    /**
     * Checks whether the v6 security configuration is valid and ready to be migrated to v7.
     */
    public final ValidateResponse validate() throws IOException, OpenSearchException {
        return validate(new ValidateRequest.Builder().build());
    }

    // ----- Endpoint: security.who_am_i

    /**
     * Gets the identity information for the user currently logged in.
     */
    public WhoAmIResponse whoAmI(WhoAmIRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, WhoAmIRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Gets the identity information for the user currently logged in.
     *
     * @param fn a function that initializes a builder to create the {@link WhoAmIRequest}
     */
    public final WhoAmIResponse whoAmI(Function<WhoAmIRequest.Builder, ObjectBuilder<WhoAmIRequest>> fn) throws IOException,
        OpenSearchException {
        return whoAmI(fn.apply(new WhoAmIRequest.Builder()).build());
    }

    /**
     * Gets the identity information for the user currently logged in.
     */
    public final WhoAmIResponse whoAmI() throws IOException, OpenSearchException {
        return whoAmI(new WhoAmIRequest.Builder().build());
    }

    // ----- Endpoint: security.who_am_i_protected

    /**
     * Gets the identity information for the user currently logged in. To use this operation, you must have access to this endpoint when
     * authorization at REST layer is enabled.
     */
    public WhoAmIProtectedResponse whoAmIProtected(WhoAmIProtectedRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, WhoAmIProtectedRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Gets the identity information for the user currently logged in. To use this operation, you must have access to this endpoint when
     * authorization at REST layer is enabled.
     *
     * @param fn a function that initializes a builder to create the {@link WhoAmIProtectedRequest}
     */
    public final WhoAmIProtectedResponse whoAmIProtected(Function<WhoAmIProtectedRequest.Builder, ObjectBuilder<WhoAmIProtectedRequest>> fn)
        throws IOException, OpenSearchException {
        return whoAmIProtected(fn.apply(new WhoAmIProtectedRequest.Builder()).build());
    }

    /**
     * Gets the identity information for the user currently logged in. To use this operation, you must have access to this endpoint when
     * authorization at REST layer is enabled.
     */
    public final WhoAmIProtectedResponse whoAmIProtected() throws IOException, OpenSearchException {
        return whoAmIProtected(new WhoAmIProtectedRequest.Builder().build());
    }
}
