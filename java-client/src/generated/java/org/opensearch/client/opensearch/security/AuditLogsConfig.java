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

// typedef: security.AuditLogsConfig

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AuditLogsConfig implements PlainJsonSerializable, ToCopyableBuilder<AuditLogsConfig.Builder, AuditLogsConfig> {

    @Nonnull
    private final List<String> disabledRestCategories;

    @Nonnull
    private final List<String> disabledTransportCategories;

    @Nullable
    private final Boolean enableRest;

    @Nullable
    private final Boolean enableTransport;

    @Nullable
    private final Boolean excludeSensitiveHeaders;

    @Nonnull
    private final List<String> ignoreHeaders;

    @Nonnull
    private final List<String> ignoreRequests;

    @Nonnull
    private final List<String> ignoreUrlParams;

    @Nonnull
    private final List<String> ignoreUsers;

    @Nullable
    private final Boolean logRequestBody;

    @Nullable
    private final Boolean resolveBulkRequests;

    @Nullable
    private final Boolean resolveIndices;

    // ---------------------------------------------------------------------------------------------

    private AuditLogsConfig(Builder builder) {
        this.disabledRestCategories = ApiTypeHelper.unmodifiable(builder.disabledRestCategories);
        this.disabledTransportCategories = ApiTypeHelper.unmodifiable(builder.disabledTransportCategories);
        this.enableRest = builder.enableRest;
        this.enableTransport = builder.enableTransport;
        this.excludeSensitiveHeaders = builder.excludeSensitiveHeaders;
        this.ignoreHeaders = ApiTypeHelper.unmodifiable(builder.ignoreHeaders);
        this.ignoreRequests = ApiTypeHelper.unmodifiable(builder.ignoreRequests);
        this.ignoreUrlParams = ApiTypeHelper.unmodifiable(builder.ignoreUrlParams);
        this.ignoreUsers = ApiTypeHelper.unmodifiable(builder.ignoreUsers);
        this.logRequestBody = builder.logRequestBody;
        this.resolveBulkRequests = builder.resolveBulkRequests;
        this.resolveIndices = builder.resolveIndices;
    }

    public static AuditLogsConfig of(Function<AuditLogsConfig.Builder, ObjectBuilder<AuditLogsConfig>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code disabled_rest_categories}
     */
    @Nonnull
    public final List<String> disabledRestCategories() {
        return this.disabledRestCategories;
    }

    /**
     * API name: {@code disabled_transport_categories}
     */
    @Nonnull
    public final List<String> disabledTransportCategories() {
        return this.disabledTransportCategories;
    }

    /**
     * API name: {@code enable_rest}
     */
    @Nullable
    public final Boolean enableRest() {
        return this.enableRest;
    }

    /**
     * API name: {@code enable_transport}
     */
    @Nullable
    public final Boolean enableTransport() {
        return this.enableTransport;
    }

    /**
     * API name: {@code exclude_sensitive_headers}
     */
    @Nullable
    public final Boolean excludeSensitiveHeaders() {
        return this.excludeSensitiveHeaders;
    }

    /**
     * API name: {@code ignore_headers}
     */
    @Nonnull
    public final List<String> ignoreHeaders() {
        return this.ignoreHeaders;
    }

    /**
     * API name: {@code ignore_requests}
     */
    @Nonnull
    public final List<String> ignoreRequests() {
        return this.ignoreRequests;
    }

    /**
     * API name: {@code ignore_url_params}
     */
    @Nonnull
    public final List<String> ignoreUrlParams() {
        return this.ignoreUrlParams;
    }

    /**
     * API name: {@code ignore_users}
     */
    @Nonnull
    public final List<String> ignoreUsers() {
        return this.ignoreUsers;
    }

    /**
     * API name: {@code log_request_body}
     */
    @Nullable
    public final Boolean logRequestBody() {
        return this.logRequestBody;
    }

    /**
     * API name: {@code resolve_bulk_requests}
     */
    @Nullable
    public final Boolean resolveBulkRequests() {
        return this.resolveBulkRequests;
    }

    /**
     * API name: {@code resolve_indices}
     */
    @Nullable
    public final Boolean resolveIndices() {
        return this.resolveIndices;
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
        if (ApiTypeHelper.isDefined(this.disabledRestCategories)) {
            generator.writeKey("disabled_rest_categories");
            generator.writeStartArray();
            for (String item0 : this.disabledRestCategories) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.disabledTransportCategories)) {
            generator.writeKey("disabled_transport_categories");
            generator.writeStartArray();
            for (String item0 : this.disabledTransportCategories) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.enableRest != null) {
            generator.writeKey("enable_rest");
            generator.write(this.enableRest);
        }

        if (this.enableTransport != null) {
            generator.writeKey("enable_transport");
            generator.write(this.enableTransport);
        }

        if (this.excludeSensitiveHeaders != null) {
            generator.writeKey("exclude_sensitive_headers");
            generator.write(this.excludeSensitiveHeaders);
        }

        if (ApiTypeHelper.isDefined(this.ignoreHeaders)) {
            generator.writeKey("ignore_headers");
            generator.writeStartArray();
            for (String item0 : this.ignoreHeaders) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.ignoreRequests)) {
            generator.writeKey("ignore_requests");
            generator.writeStartArray();
            for (String item0 : this.ignoreRequests) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.ignoreUrlParams)) {
            generator.writeKey("ignore_url_params");
            generator.writeStartArray();
            for (String item0 : this.ignoreUrlParams) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.ignoreUsers)) {
            generator.writeKey("ignore_users");
            generator.writeStartArray();
            for (String item0 : this.ignoreUsers) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.logRequestBody != null) {
            generator.writeKey("log_request_body");
            generator.write(this.logRequestBody);
        }

        if (this.resolveBulkRequests != null) {
            generator.writeKey("resolve_bulk_requests");
            generator.write(this.resolveBulkRequests);
        }

        if (this.resolveIndices != null) {
            generator.writeKey("resolve_indices");
            generator.write(this.resolveIndices);
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
     * Builder for {@link AuditLogsConfig}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AuditLogsConfig> {
        @Nullable
        private List<String> disabledRestCategories;
        @Nullable
        private List<String> disabledTransportCategories;
        @Nullable
        private Boolean enableRest;
        @Nullable
        private Boolean enableTransport;
        @Nullable
        private Boolean excludeSensitiveHeaders;
        @Nullable
        private List<String> ignoreHeaders;
        @Nullable
        private List<String> ignoreRequests;
        @Nullable
        private List<String> ignoreUrlParams;
        @Nullable
        private List<String> ignoreUsers;
        @Nullable
        private Boolean logRequestBody;
        @Nullable
        private Boolean resolveBulkRequests;
        @Nullable
        private Boolean resolveIndices;

        public Builder() {}

        private Builder(AuditLogsConfig o) {
            this.disabledRestCategories = _listCopy(o.disabledRestCategories);
            this.disabledTransportCategories = _listCopy(o.disabledTransportCategories);
            this.enableRest = o.enableRest;
            this.enableTransport = o.enableTransport;
            this.excludeSensitiveHeaders = o.excludeSensitiveHeaders;
            this.ignoreHeaders = _listCopy(o.ignoreHeaders);
            this.ignoreRequests = _listCopy(o.ignoreRequests);
            this.ignoreUrlParams = _listCopy(o.ignoreUrlParams);
            this.ignoreUsers = _listCopy(o.ignoreUsers);
            this.logRequestBody = o.logRequestBody;
            this.resolveBulkRequests = o.resolveBulkRequests;
            this.resolveIndices = o.resolveIndices;
        }

        private Builder(Builder o) {
            this.disabledRestCategories = _listCopy(o.disabledRestCategories);
            this.disabledTransportCategories = _listCopy(o.disabledTransportCategories);
            this.enableRest = o.enableRest;
            this.enableTransport = o.enableTransport;
            this.excludeSensitiveHeaders = o.excludeSensitiveHeaders;
            this.ignoreHeaders = _listCopy(o.ignoreHeaders);
            this.ignoreRequests = _listCopy(o.ignoreRequests);
            this.ignoreUrlParams = _listCopy(o.ignoreUrlParams);
            this.ignoreUsers = _listCopy(o.ignoreUsers);
            this.logRequestBody = o.logRequestBody;
            this.resolveBulkRequests = o.resolveBulkRequests;
            this.resolveIndices = o.resolveIndices;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code disabled_rest_categories}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>disabledRestCategories</code>.
         * </p>
         */
        @Nonnull
        public final Builder disabledRestCategories(List<String> list) {
            this.disabledRestCategories = _listAddAll(this.disabledRestCategories, list);
            return this;
        }

        /**
         * API name: {@code disabled_rest_categories}
         *
         * <p>
         * Adds one or more values to <code>disabledRestCategories</code>.
         * </p>
         */
        @Nonnull
        public final Builder disabledRestCategories(String value, String... values) {
            this.disabledRestCategories = _listAdd(this.disabledRestCategories, value, values);
            return this;
        }

        /**
         * API name: {@code disabled_transport_categories}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>disabledTransportCategories</code>.
         * </p>
         */
        @Nonnull
        public final Builder disabledTransportCategories(List<String> list) {
            this.disabledTransportCategories = _listAddAll(this.disabledTransportCategories, list);
            return this;
        }

        /**
         * API name: {@code disabled_transport_categories}
         *
         * <p>
         * Adds one or more values to <code>disabledTransportCategories</code>.
         * </p>
         */
        @Nonnull
        public final Builder disabledTransportCategories(String value, String... values) {
            this.disabledTransportCategories = _listAdd(this.disabledTransportCategories, value, values);
            return this;
        }

        /**
         * API name: {@code enable_rest}
         */
        @Nonnull
        public final Builder enableRest(@Nullable Boolean value) {
            this.enableRest = value;
            return this;
        }

        /**
         * API name: {@code enable_transport}
         */
        @Nonnull
        public final Builder enableTransport(@Nullable Boolean value) {
            this.enableTransport = value;
            return this;
        }

        /**
         * API name: {@code exclude_sensitive_headers}
         */
        @Nonnull
        public final Builder excludeSensitiveHeaders(@Nullable Boolean value) {
            this.excludeSensitiveHeaders = value;
            return this;
        }

        /**
         * API name: {@code ignore_headers}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>ignoreHeaders</code>.
         * </p>
         */
        @Nonnull
        public final Builder ignoreHeaders(List<String> list) {
            this.ignoreHeaders = _listAddAll(this.ignoreHeaders, list);
            return this;
        }

        /**
         * API name: {@code ignore_headers}
         *
         * <p>
         * Adds one or more values to <code>ignoreHeaders</code>.
         * </p>
         */
        @Nonnull
        public final Builder ignoreHeaders(String value, String... values) {
            this.ignoreHeaders = _listAdd(this.ignoreHeaders, value, values);
            return this;
        }

        /**
         * API name: {@code ignore_requests}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>ignoreRequests</code>.
         * </p>
         */
        @Nonnull
        public final Builder ignoreRequests(List<String> list) {
            this.ignoreRequests = _listAddAll(this.ignoreRequests, list);
            return this;
        }

        /**
         * API name: {@code ignore_requests}
         *
         * <p>
         * Adds one or more values to <code>ignoreRequests</code>.
         * </p>
         */
        @Nonnull
        public final Builder ignoreRequests(String value, String... values) {
            this.ignoreRequests = _listAdd(this.ignoreRequests, value, values);
            return this;
        }

        /**
         * API name: {@code ignore_url_params}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>ignoreUrlParams</code>.
         * </p>
         */
        @Nonnull
        public final Builder ignoreUrlParams(List<String> list) {
            this.ignoreUrlParams = _listAddAll(this.ignoreUrlParams, list);
            return this;
        }

        /**
         * API name: {@code ignore_url_params}
         *
         * <p>
         * Adds one or more values to <code>ignoreUrlParams</code>.
         * </p>
         */
        @Nonnull
        public final Builder ignoreUrlParams(String value, String... values) {
            this.ignoreUrlParams = _listAdd(this.ignoreUrlParams, value, values);
            return this;
        }

        /**
         * API name: {@code ignore_users}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>ignoreUsers</code>.
         * </p>
         */
        @Nonnull
        public final Builder ignoreUsers(List<String> list) {
            this.ignoreUsers = _listAddAll(this.ignoreUsers, list);
            return this;
        }

        /**
         * API name: {@code ignore_users}
         *
         * <p>
         * Adds one or more values to <code>ignoreUsers</code>.
         * </p>
         */
        @Nonnull
        public final Builder ignoreUsers(String value, String... values) {
            this.ignoreUsers = _listAdd(this.ignoreUsers, value, values);
            return this;
        }

        /**
         * API name: {@code log_request_body}
         */
        @Nonnull
        public final Builder logRequestBody(@Nullable Boolean value) {
            this.logRequestBody = value;
            return this;
        }

        /**
         * API name: {@code resolve_bulk_requests}
         */
        @Nonnull
        public final Builder resolveBulkRequests(@Nullable Boolean value) {
            this.resolveBulkRequests = value;
            return this;
        }

        /**
         * API name: {@code resolve_indices}
         */
        @Nonnull
        public final Builder resolveIndices(@Nullable Boolean value) {
            this.resolveIndices = value;
            return this;
        }

        /**
         * Builds a {@link AuditLogsConfig}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AuditLogsConfig build() {
            _checkSingleUse();

            return new AuditLogsConfig(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AuditLogsConfig}
     */
    public static final JsonpDeserializer<AuditLogsConfig> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AuditLogsConfig::setupAuditLogsConfigDeserializer
    );

    protected static void setupAuditLogsConfigDeserializer(ObjectDeserializer<AuditLogsConfig.Builder> op) {
        op.add(
            Builder::disabledRestCategories,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "disabled_rest_categories"
        );
        op.add(
            Builder::disabledTransportCategories,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "disabled_transport_categories"
        );
        op.add(Builder::enableRest, JsonpDeserializer.booleanDeserializer(), "enable_rest");
        op.add(Builder::enableTransport, JsonpDeserializer.booleanDeserializer(), "enable_transport");
        op.add(Builder::excludeSensitiveHeaders, JsonpDeserializer.booleanDeserializer(), "exclude_sensitive_headers");
        op.add(Builder::ignoreHeaders, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "ignore_headers");
        op.add(Builder::ignoreRequests, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "ignore_requests");
        op.add(Builder::ignoreUrlParams, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "ignore_url_params");
        op.add(Builder::ignoreUsers, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "ignore_users");
        op.add(Builder::logRequestBody, JsonpDeserializer.booleanDeserializer(), "log_request_body");
        op.add(Builder::resolveBulkRequests, JsonpDeserializer.booleanDeserializer(), "resolve_bulk_requests");
        op.add(Builder::resolveIndices, JsonpDeserializer.booleanDeserializer(), "resolve_indices");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.disabledRestCategories);
        result = 31 * result + Objects.hashCode(this.disabledTransportCategories);
        result = 31 * result + Objects.hashCode(this.enableRest);
        result = 31 * result + Objects.hashCode(this.enableTransport);
        result = 31 * result + Objects.hashCode(this.excludeSensitiveHeaders);
        result = 31 * result + Objects.hashCode(this.ignoreHeaders);
        result = 31 * result + Objects.hashCode(this.ignoreRequests);
        result = 31 * result + Objects.hashCode(this.ignoreUrlParams);
        result = 31 * result + Objects.hashCode(this.ignoreUsers);
        result = 31 * result + Objects.hashCode(this.logRequestBody);
        result = 31 * result + Objects.hashCode(this.resolveBulkRequests);
        result = 31 * result + Objects.hashCode(this.resolveIndices);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AuditLogsConfig other = (AuditLogsConfig) o;
        return Objects.equals(this.disabledRestCategories, other.disabledRestCategories)
            && Objects.equals(this.disabledTransportCategories, other.disabledTransportCategories)
            && Objects.equals(this.enableRest, other.enableRest)
            && Objects.equals(this.enableTransport, other.enableTransport)
            && Objects.equals(this.excludeSensitiveHeaders, other.excludeSensitiveHeaders)
            && Objects.equals(this.ignoreHeaders, other.ignoreHeaders)
            && Objects.equals(this.ignoreRequests, other.ignoreRequests)
            && Objects.equals(this.ignoreUrlParams, other.ignoreUrlParams)
            && Objects.equals(this.ignoreUsers, other.ignoreUsers)
            && Objects.equals(this.logRequestBody, other.logRequestBody)
            && Objects.equals(this.resolveBulkRequests, other.resolveBulkRequests)
            && Objects.equals(this.resolveIndices, other.resolveIndices);
    }
}
