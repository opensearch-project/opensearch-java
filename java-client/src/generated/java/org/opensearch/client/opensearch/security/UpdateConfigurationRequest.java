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

// typedef: security.update_configuration.Request

/**
 * Updates the settings for an existing security configuration. Requires super admin or REST API permissions.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class UpdateConfigurationRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<UpdateConfigurationRequest.Builder, UpdateConfigurationRequest> {

    @Nullable
    private final DynamicOptions dynamic;

    // ---------------------------------------------------------------------------------------------

    private UpdateConfigurationRequest(Builder builder) {
        super(builder);
        this.dynamic = builder.dynamic;
    }

    public static UpdateConfigurationRequest of(
        Function<UpdateConfigurationRequest.Builder, ObjectBuilder<UpdateConfigurationRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code dynamic}
     */
    @Nullable
    public final DynamicOptions dynamic() {
        return this.dynamic;
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
        if (this.dynamic != null) {
            generator.writeKey("dynamic");
            this.dynamic.serialize(generator, mapper);
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
     * Builder for {@link UpdateConfigurationRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, UpdateConfigurationRequest> {
        @Nullable
        private DynamicOptions dynamic;

        public Builder() {}

        private Builder(UpdateConfigurationRequest o) {
            super(o);
            this.dynamic = o.dynamic;
        }

        private Builder(Builder o) {
            super(o);
            this.dynamic = o.dynamic;
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
         * API name: {@code dynamic}
         */
        @Nonnull
        public final Builder dynamic(@Nullable DynamicOptions value) {
            this.dynamic = value;
            return this;
        }

        /**
         * API name: {@code dynamic}
         */
        @Nonnull
        public final Builder dynamic(Function<DynamicOptions.Builder, ObjectBuilder<DynamicOptions>> fn) {
            return dynamic(fn.apply(new DynamicOptions.Builder()).build());
        }

        /**
         * Builds a {@link UpdateConfigurationRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UpdateConfigurationRequest build() {
            _checkSingleUse();

            return new UpdateConfigurationRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UpdateConfigurationRequest}
     */
    public static final JsonpDeserializer<UpdateConfigurationRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UpdateConfigurationRequest::setupUpdateConfigurationRequestDeserializer
    );

    protected static void setupUpdateConfigurationRequestDeserializer(ObjectDeserializer<UpdateConfigurationRequest.Builder> op) {
        op.add(Builder::dynamic, DynamicOptions._DESERIALIZER, "dynamic");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code security.update_configuration}".
     */
    public static final Endpoint<UpdateConfigurationRequest, UpdateConfigurationResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> "/_plugins/_security/api/securityconfig/config",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        UpdateConfigurationResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.dynamic);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UpdateConfigurationRequest other = (UpdateConfigurationRequest) o;
        return Objects.equals(this.dynamic, other.dynamic);
    }
}
