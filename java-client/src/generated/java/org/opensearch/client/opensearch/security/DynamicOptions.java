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
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
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

// typedef: security.DynamicOptions

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DynamicOptions implements PlainJsonSerializable, ToCopyableBuilder<DynamicOptions.Builder, DynamicOptions> {

    @Nonnull
    private final Map<String, JsonData> authFailureListeners;

    @Nonnull
    private final Map<String, JsonData> authc;

    @Nonnull
    private final Map<String, JsonData> authz;

    @Nullable
    private final Boolean disableIntertransportAuth;

    @Nullable
    private final Boolean disableRestAuth;

    @Nullable
    private final Boolean doNotFailOnForbidden;

    @Nullable
    private final Boolean doNotFailOnForbiddenEmpty;

    @Nullable
    private final String filteredAliasMode;

    @Nullable
    private final String hostsResolverMode;

    @Nonnull
    private final Map<String, JsonData> http;

    @Nonnull
    private final Map<String, JsonData> kibana;

    @Nullable
    private final Boolean multiRolespanEnabled;

    @Nonnull
    private final Map<String, JsonData> onBehalfOf;

    @Nonnull
    private final Map<String, JsonData> opensearchDashboards;

    @Nullable
    private final Boolean respectRequestIndicesOptions;

    // ---------------------------------------------------------------------------------------------

    private DynamicOptions(Builder builder) {
        this.authFailureListeners = ApiTypeHelper.unmodifiable(builder.authFailureListeners);
        this.authc = ApiTypeHelper.unmodifiable(builder.authc);
        this.authz = ApiTypeHelper.unmodifiable(builder.authz);
        this.disableIntertransportAuth = builder.disableIntertransportAuth;
        this.disableRestAuth = builder.disableRestAuth;
        this.doNotFailOnForbidden = builder.doNotFailOnForbidden;
        this.doNotFailOnForbiddenEmpty = builder.doNotFailOnForbiddenEmpty;
        this.filteredAliasMode = builder.filteredAliasMode;
        this.hostsResolverMode = builder.hostsResolverMode;
        this.http = ApiTypeHelper.unmodifiable(builder.http);
        this.kibana = ApiTypeHelper.unmodifiable(builder.kibana);
        this.multiRolespanEnabled = builder.multiRolespanEnabled;
        this.onBehalfOf = ApiTypeHelper.unmodifiable(builder.onBehalfOf);
        this.opensearchDashboards = ApiTypeHelper.unmodifiable(builder.opensearchDashboards);
        this.respectRequestIndicesOptions = builder.respectRequestIndicesOptions;
    }

    public static DynamicOptions of(Function<DynamicOptions.Builder, ObjectBuilder<DynamicOptions>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code auth_failure_listeners}
     */
    @Nonnull
    public final Map<String, JsonData> authFailureListeners() {
        return this.authFailureListeners;
    }

    /**
     * API name: {@code authc}
     */
    @Nonnull
    public final Map<String, JsonData> authc() {
        return this.authc;
    }

    /**
     * API name: {@code authz}
     */
    @Nonnull
    public final Map<String, JsonData> authz() {
        return this.authz;
    }

    /**
     * API name: {@code disable_intertransport_auth}
     */
    @Nullable
    public final Boolean disableIntertransportAuth() {
        return this.disableIntertransportAuth;
    }

    /**
     * API name: {@code disable_rest_auth}
     */
    @Nullable
    public final Boolean disableRestAuth() {
        return this.disableRestAuth;
    }

    /**
     * API name: {@code do_not_fail_on_forbidden}
     */
    @Nullable
    public final Boolean doNotFailOnForbidden() {
        return this.doNotFailOnForbidden;
    }

    /**
     * API name: {@code do_not_fail_on_forbidden_empty}
     */
    @Nullable
    public final Boolean doNotFailOnForbiddenEmpty() {
        return this.doNotFailOnForbiddenEmpty;
    }

    /**
     * API name: {@code filtered_alias_mode}
     */
    @Nullable
    public final String filteredAliasMode() {
        return this.filteredAliasMode;
    }

    /**
     * API name: {@code hosts_resolver_mode}
     */
    @Nullable
    public final String hostsResolverMode() {
        return this.hostsResolverMode;
    }

    /**
     * API name: {@code http}
     */
    @Nonnull
    public final Map<String, JsonData> http() {
        return this.http;
    }

    /**
     * API name: {@code kibana}
     */
    @Nonnull
    public final Map<String, JsonData> kibana() {
        return this.kibana;
    }

    /**
     * API name: {@code multi_rolespan_enabled}
     */
    @Nullable
    public final Boolean multiRolespanEnabled() {
        return this.multiRolespanEnabled;
    }

    /**
     * API name: {@code on_behalf_of}
     */
    @Nonnull
    public final Map<String, JsonData> onBehalfOf() {
        return this.onBehalfOf;
    }

    /**
     * API name: {@code opensearch-dashboards}
     */
    @Nonnull
    public final Map<String, JsonData> opensearchDashboards() {
        return this.opensearchDashboards;
    }

    /**
     * API name: {@code respect_request_indices_options}
     */
    @Nullable
    public final Boolean respectRequestIndicesOptions() {
        return this.respectRequestIndicesOptions;
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
        if (ApiTypeHelper.isDefined(this.authFailureListeners)) {
            generator.writeKey("auth_failure_listeners");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.authFailureListeners.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.authc)) {
            generator.writeKey("authc");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.authc.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.authz)) {
            generator.writeKey("authz");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.authz.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.disableIntertransportAuth != null) {
            generator.writeKey("disable_intertransport_auth");
            generator.write(this.disableIntertransportAuth);
        }

        if (this.disableRestAuth != null) {
            generator.writeKey("disable_rest_auth");
            generator.write(this.disableRestAuth);
        }

        if (this.doNotFailOnForbidden != null) {
            generator.writeKey("do_not_fail_on_forbidden");
            generator.write(this.doNotFailOnForbidden);
        }

        if (this.doNotFailOnForbiddenEmpty != null) {
            generator.writeKey("do_not_fail_on_forbidden_empty");
            generator.write(this.doNotFailOnForbiddenEmpty);
        }

        if (this.filteredAliasMode != null) {
            generator.writeKey("filtered_alias_mode");
            generator.write(this.filteredAliasMode);
        }

        if (this.hostsResolverMode != null) {
            generator.writeKey("hosts_resolver_mode");
            generator.write(this.hostsResolverMode);
        }

        if (ApiTypeHelper.isDefined(this.http)) {
            generator.writeKey("http");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.http.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.kibana)) {
            generator.writeKey("kibana");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.kibana.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.multiRolespanEnabled != null) {
            generator.writeKey("multi_rolespan_enabled");
            generator.write(this.multiRolespanEnabled);
        }

        if (ApiTypeHelper.isDefined(this.onBehalfOf)) {
            generator.writeKey("on_behalf_of");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.onBehalfOf.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.opensearchDashboards)) {
            generator.writeKey("opensearch-dashboards");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.opensearchDashboards.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.respectRequestIndicesOptions != null) {
            generator.writeKey("respect_request_indices_options");
            generator.write(this.respectRequestIndicesOptions);
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
     * Builder for {@link DynamicOptions}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DynamicOptions> {
        @Nullable
        private Map<String, JsonData> authFailureListeners;
        @Nullable
        private Map<String, JsonData> authc;
        @Nullable
        private Map<String, JsonData> authz;
        @Nullable
        private Boolean disableIntertransportAuth;
        @Nullable
        private Boolean disableRestAuth;
        @Nullable
        private Boolean doNotFailOnForbidden;
        @Nullable
        private Boolean doNotFailOnForbiddenEmpty;
        @Nullable
        private String filteredAliasMode;
        @Nullable
        private String hostsResolverMode;
        @Nullable
        private Map<String, JsonData> http;
        @Nullable
        private Map<String, JsonData> kibana;
        @Nullable
        private Boolean multiRolespanEnabled;
        @Nullable
        private Map<String, JsonData> onBehalfOf;
        @Nullable
        private Map<String, JsonData> opensearchDashboards;
        @Nullable
        private Boolean respectRequestIndicesOptions;

        public Builder() {}

        private Builder(DynamicOptions o) {
            this.authFailureListeners = _mapCopy(o.authFailureListeners);
            this.authc = _mapCopy(o.authc);
            this.authz = _mapCopy(o.authz);
            this.disableIntertransportAuth = o.disableIntertransportAuth;
            this.disableRestAuth = o.disableRestAuth;
            this.doNotFailOnForbidden = o.doNotFailOnForbidden;
            this.doNotFailOnForbiddenEmpty = o.doNotFailOnForbiddenEmpty;
            this.filteredAliasMode = o.filteredAliasMode;
            this.hostsResolverMode = o.hostsResolverMode;
            this.http = _mapCopy(o.http);
            this.kibana = _mapCopy(o.kibana);
            this.multiRolespanEnabled = o.multiRolespanEnabled;
            this.onBehalfOf = _mapCopy(o.onBehalfOf);
            this.opensearchDashboards = _mapCopy(o.opensearchDashboards);
            this.respectRequestIndicesOptions = o.respectRequestIndicesOptions;
        }

        private Builder(Builder o) {
            this.authFailureListeners = _mapCopy(o.authFailureListeners);
            this.authc = _mapCopy(o.authc);
            this.authz = _mapCopy(o.authz);
            this.disableIntertransportAuth = o.disableIntertransportAuth;
            this.disableRestAuth = o.disableRestAuth;
            this.doNotFailOnForbidden = o.doNotFailOnForbidden;
            this.doNotFailOnForbiddenEmpty = o.doNotFailOnForbiddenEmpty;
            this.filteredAliasMode = o.filteredAliasMode;
            this.hostsResolverMode = o.hostsResolverMode;
            this.http = _mapCopy(o.http);
            this.kibana = _mapCopy(o.kibana);
            this.multiRolespanEnabled = o.multiRolespanEnabled;
            this.onBehalfOf = _mapCopy(o.onBehalfOf);
            this.opensearchDashboards = _mapCopy(o.opensearchDashboards);
            this.respectRequestIndicesOptions = o.respectRequestIndicesOptions;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code auth_failure_listeners}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>authFailureListeners</code>.
         * </p>
         */
        @Nonnull
        public final Builder authFailureListeners(Map<String, JsonData> map) {
            this.authFailureListeners = _mapPutAll(this.authFailureListeners, map);
            return this;
        }

        /**
         * API name: {@code auth_failure_listeners}
         *
         * <p>
         * Adds an entry to <code>authFailureListeners</code>.
         * </p>
         */
        @Nonnull
        public final Builder authFailureListeners(String key, JsonData value) {
            this.authFailureListeners = _mapPut(this.authFailureListeners, key, value);
            return this;
        }

        /**
         * API name: {@code authc}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>authc</code>.
         * </p>
         */
        @Nonnull
        public final Builder authc(Map<String, JsonData> map) {
            this.authc = _mapPutAll(this.authc, map);
            return this;
        }

        /**
         * API name: {@code authc}
         *
         * <p>
         * Adds an entry to <code>authc</code>.
         * </p>
         */
        @Nonnull
        public final Builder authc(String key, JsonData value) {
            this.authc = _mapPut(this.authc, key, value);
            return this;
        }

        /**
         * API name: {@code authz}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>authz</code>.
         * </p>
         */
        @Nonnull
        public final Builder authz(Map<String, JsonData> map) {
            this.authz = _mapPutAll(this.authz, map);
            return this;
        }

        /**
         * API name: {@code authz}
         *
         * <p>
         * Adds an entry to <code>authz</code>.
         * </p>
         */
        @Nonnull
        public final Builder authz(String key, JsonData value) {
            this.authz = _mapPut(this.authz, key, value);
            return this;
        }

        /**
         * API name: {@code disable_intertransport_auth}
         */
        @Nonnull
        public final Builder disableIntertransportAuth(@Nullable Boolean value) {
            this.disableIntertransportAuth = value;
            return this;
        }

        /**
         * API name: {@code disable_rest_auth}
         */
        @Nonnull
        public final Builder disableRestAuth(@Nullable Boolean value) {
            this.disableRestAuth = value;
            return this;
        }

        /**
         * API name: {@code do_not_fail_on_forbidden}
         */
        @Nonnull
        public final Builder doNotFailOnForbidden(@Nullable Boolean value) {
            this.doNotFailOnForbidden = value;
            return this;
        }

        /**
         * API name: {@code do_not_fail_on_forbidden_empty}
         */
        @Nonnull
        public final Builder doNotFailOnForbiddenEmpty(@Nullable Boolean value) {
            this.doNotFailOnForbiddenEmpty = value;
            return this;
        }

        /**
         * API name: {@code filtered_alias_mode}
         */
        @Nonnull
        public final Builder filteredAliasMode(@Nullable String value) {
            this.filteredAliasMode = value;
            return this;
        }

        /**
         * API name: {@code hosts_resolver_mode}
         */
        @Nonnull
        public final Builder hostsResolverMode(@Nullable String value) {
            this.hostsResolverMode = value;
            return this;
        }

        /**
         * API name: {@code http}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>http</code>.
         * </p>
         */
        @Nonnull
        public final Builder http(Map<String, JsonData> map) {
            this.http = _mapPutAll(this.http, map);
            return this;
        }

        /**
         * API name: {@code http}
         *
         * <p>
         * Adds an entry to <code>http</code>.
         * </p>
         */
        @Nonnull
        public final Builder http(String key, JsonData value) {
            this.http = _mapPut(this.http, key, value);
            return this;
        }

        /**
         * API name: {@code kibana}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>kibana</code>.
         * </p>
         */
        @Nonnull
        public final Builder kibana(Map<String, JsonData> map) {
            this.kibana = _mapPutAll(this.kibana, map);
            return this;
        }

        /**
         * API name: {@code kibana}
         *
         * <p>
         * Adds an entry to <code>kibana</code>.
         * </p>
         */
        @Nonnull
        public final Builder kibana(String key, JsonData value) {
            this.kibana = _mapPut(this.kibana, key, value);
            return this;
        }

        /**
         * API name: {@code multi_rolespan_enabled}
         */
        @Nonnull
        public final Builder multiRolespanEnabled(@Nullable Boolean value) {
            this.multiRolespanEnabled = value;
            return this;
        }

        /**
         * API name: {@code on_behalf_of}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>onBehalfOf</code>.
         * </p>
         */
        @Nonnull
        public final Builder onBehalfOf(Map<String, JsonData> map) {
            this.onBehalfOf = _mapPutAll(this.onBehalfOf, map);
            return this;
        }

        /**
         * API name: {@code on_behalf_of}
         *
         * <p>
         * Adds an entry to <code>onBehalfOf</code>.
         * </p>
         */
        @Nonnull
        public final Builder onBehalfOf(String key, JsonData value) {
            this.onBehalfOf = _mapPut(this.onBehalfOf, key, value);
            return this;
        }

        /**
         * API name: {@code opensearch-dashboards}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>opensearchDashboards</code>.
         * </p>
         */
        @Nonnull
        public final Builder opensearchDashboards(Map<String, JsonData> map) {
            this.opensearchDashboards = _mapPutAll(this.opensearchDashboards, map);
            return this;
        }

        /**
         * API name: {@code opensearch-dashboards}
         *
         * <p>
         * Adds an entry to <code>opensearchDashboards</code>.
         * </p>
         */
        @Nonnull
        public final Builder opensearchDashboards(String key, JsonData value) {
            this.opensearchDashboards = _mapPut(this.opensearchDashboards, key, value);
            return this;
        }

        /**
         * API name: {@code respect_request_indices_options}
         */
        @Nonnull
        public final Builder respectRequestIndicesOptions(@Nullable Boolean value) {
            this.respectRequestIndicesOptions = value;
            return this;
        }

        /**
         * Builds a {@link DynamicOptions}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DynamicOptions build() {
            _checkSingleUse();

            return new DynamicOptions(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DynamicOptions}
     */
    public static final JsonpDeserializer<DynamicOptions> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DynamicOptions::setupDynamicOptionsDeserializer
    );

    protected static void setupDynamicOptionsDeserializer(ObjectDeserializer<DynamicOptions.Builder> op) {
        op.add(Builder::authFailureListeners, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "auth_failure_listeners");
        op.add(Builder::authc, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "authc");
        op.add(Builder::authz, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "authz");
        op.add(Builder::disableIntertransportAuth, JsonpDeserializer.booleanDeserializer(), "disable_intertransport_auth");
        op.add(Builder::disableRestAuth, JsonpDeserializer.booleanDeserializer(), "disable_rest_auth");
        op.add(Builder::doNotFailOnForbidden, JsonpDeserializer.booleanDeserializer(), "do_not_fail_on_forbidden");
        op.add(Builder::doNotFailOnForbiddenEmpty, JsonpDeserializer.booleanDeserializer(), "do_not_fail_on_forbidden_empty");
        op.add(Builder::filteredAliasMode, JsonpDeserializer.stringDeserializer(), "filtered_alias_mode");
        op.add(Builder::hostsResolverMode, JsonpDeserializer.stringDeserializer(), "hosts_resolver_mode");
        op.add(Builder::http, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "http");
        op.add(Builder::kibana, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "kibana");
        op.add(Builder::multiRolespanEnabled, JsonpDeserializer.booleanDeserializer(), "multi_rolespan_enabled");
        op.add(Builder::onBehalfOf, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "on_behalf_of");
        op.add(Builder::opensearchDashboards, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "opensearch-dashboards");
        op.add(Builder::respectRequestIndicesOptions, JsonpDeserializer.booleanDeserializer(), "respect_request_indices_options");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.authFailureListeners);
        result = 31 * result + Objects.hashCode(this.authc);
        result = 31 * result + Objects.hashCode(this.authz);
        result = 31 * result + Objects.hashCode(this.disableIntertransportAuth);
        result = 31 * result + Objects.hashCode(this.disableRestAuth);
        result = 31 * result + Objects.hashCode(this.doNotFailOnForbidden);
        result = 31 * result + Objects.hashCode(this.doNotFailOnForbiddenEmpty);
        result = 31 * result + Objects.hashCode(this.filteredAliasMode);
        result = 31 * result + Objects.hashCode(this.hostsResolverMode);
        result = 31 * result + Objects.hashCode(this.http);
        result = 31 * result + Objects.hashCode(this.kibana);
        result = 31 * result + Objects.hashCode(this.multiRolespanEnabled);
        result = 31 * result + Objects.hashCode(this.onBehalfOf);
        result = 31 * result + Objects.hashCode(this.opensearchDashboards);
        result = 31 * result + Objects.hashCode(this.respectRequestIndicesOptions);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DynamicOptions other = (DynamicOptions) o;
        return Objects.equals(this.authFailureListeners, other.authFailureListeners)
            && Objects.equals(this.authc, other.authc)
            && Objects.equals(this.authz, other.authz)
            && Objects.equals(this.disableIntertransportAuth, other.disableIntertransportAuth)
            && Objects.equals(this.disableRestAuth, other.disableRestAuth)
            && Objects.equals(this.doNotFailOnForbidden, other.doNotFailOnForbidden)
            && Objects.equals(this.doNotFailOnForbiddenEmpty, other.doNotFailOnForbiddenEmpty)
            && Objects.equals(this.filteredAliasMode, other.filteredAliasMode)
            && Objects.equals(this.hostsResolverMode, other.hostsResolverMode)
            && Objects.equals(this.http, other.http)
            && Objects.equals(this.kibana, other.kibana)
            && Objects.equals(this.multiRolespanEnabled, other.multiRolespanEnabled)
            && Objects.equals(this.onBehalfOf, other.onBehalfOf)
            && Objects.equals(this.opensearchDashboards, other.opensearchDashboards)
            && Objects.equals(this.respectRequestIndicesOptions, other.respectRequestIndicesOptions);
    }
}
