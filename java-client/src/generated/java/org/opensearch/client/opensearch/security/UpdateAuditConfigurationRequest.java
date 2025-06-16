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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: security.update_audit_configuration.Request

/**
 * Updates the audit configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class UpdateAuditConfigurationRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<UpdateAuditConfigurationRequest.Builder, UpdateAuditConfigurationRequest> {

    @Nullable
    private final AuditLogsConfig audit;

    @Nullable
    private final ComplianceConfig compliance;

    @Nullable
    private final Boolean enabled;

    // ---------------------------------------------------------------------------------------------

    private UpdateAuditConfigurationRequest(Builder builder) {
        super(builder);
        this.audit = builder.audit;
        this.compliance = builder.compliance;
        this.enabled = builder.enabled;
    }

    public static UpdateAuditConfigurationRequest of(
        Function<UpdateAuditConfigurationRequest.Builder, ObjectBuilder<UpdateAuditConfigurationRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code audit}
     */
    @Nullable
    public final AuditLogsConfig audit() {
        return this.audit;
    }

    /**
     * API name: {@code compliance}
     */
    @Nullable
    public final ComplianceConfig compliance() {
        return this.compliance;
    }

    /**
     * API name: {@code enabled}
     */
    @Nullable
    public final Boolean enabled() {
        return this.enabled;
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
        if (this.audit != null) {
            generator.writeKey("audit");
            this.audit.serialize(generator, mapper);
        }

        if (this.compliance != null) {
            generator.writeKey("compliance");
            this.compliance.serialize(generator, mapper);
        }

        if (this.enabled != null) {
            generator.writeKey("enabled");
            generator.write(this.enabled);
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
     * Builder for {@link UpdateAuditConfigurationRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, UpdateAuditConfigurationRequest> {
        @Nullable
        private AuditLogsConfig audit;
        @Nullable
        private ComplianceConfig compliance;
        @Nullable
        private Boolean enabled;

        public Builder() {}

        private Builder(UpdateAuditConfigurationRequest o) {
            super(o);
            this.audit = o.audit;
            this.compliance = o.compliance;
            this.enabled = o.enabled;
        }

        private Builder(Builder o) {
            super(o);
            this.audit = o.audit;
            this.compliance = o.compliance;
            this.enabled = o.enabled;
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
         * API name: {@code audit}
         */
        @Nonnull
        public final Builder audit(@Nullable AuditLogsConfig value) {
            this.audit = value;
            return this;
        }

        /**
         * API name: {@code audit}
         */
        @Nonnull
        public final Builder audit(Function<AuditLogsConfig.Builder, ObjectBuilder<AuditLogsConfig>> fn) {
            return audit(fn.apply(new AuditLogsConfig.Builder()).build());
        }

        /**
         * API name: {@code compliance}
         */
        @Nonnull
        public final Builder compliance(@Nullable ComplianceConfig value) {
            this.compliance = value;
            return this;
        }

        /**
         * API name: {@code compliance}
         */
        @Nonnull
        public final Builder compliance(Function<ComplianceConfig.Builder, ObjectBuilder<ComplianceConfig>> fn) {
            return compliance(fn.apply(new ComplianceConfig.Builder()).build());
        }

        /**
         * API name: {@code enabled}
         */
        @Nonnull
        public final Builder enabled(@Nullable Boolean value) {
            this.enabled = value;
            return this;
        }

        /**
         * Builds a {@link UpdateAuditConfigurationRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UpdateAuditConfigurationRequest build() {
            _checkSingleUse();

            return new UpdateAuditConfigurationRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UpdateAuditConfigurationRequest}
     */
    public static final JsonpDeserializer<UpdateAuditConfigurationRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UpdateAuditConfigurationRequest::setupUpdateAuditConfigurationRequestDeserializer
    );

    protected static void setupUpdateAuditConfigurationRequestDeserializer(ObjectDeserializer<UpdateAuditConfigurationRequest.Builder> op) {
        op.add(Builder::audit, AuditLogsConfig._DESERIALIZER, "audit");
        op.add(Builder::compliance, ComplianceConfig._DESERIALIZER, "compliance");
        op.add(Builder::enabled, JsonpDeserializer.booleanDeserializer(), "enabled");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code security.update_audit_configuration}".
     */
    public static final Endpoint<UpdateAuditConfigurationRequest, UpdateAuditConfigurationResponse, ErrorResponse> _ENDPOINT =
        new SimpleEndpoint<>(
            // Request method
            request -> "PUT",
            // Request path
            request -> "/_plugins/_security/api/audit/config",
            // Request parameters
            request -> {
                Map<String, String> params = new HashMap<>();
                request.applyQueryParameters(params);
                return params;
            },
            SimpleEndpoint.emptyMap(),
            true,
            UpdateAuditConfigurationResponse._DESERIALIZER
        );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.audit);
        result = 31 * result + Objects.hashCode(this.compliance);
        result = 31 * result + Objects.hashCode(this.enabled);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UpdateAuditConfigurationRequest other = (UpdateAuditConfigurationRequest) o;
        return Objects.equals(this.audit, other.audit)
            && Objects.equals(this.compliance, other.compliance)
            && Objects.equals(this.enabled, other.enabled);
    }
}
