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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: security.change_password.Request

/**
 * Changes the password for the current user.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class ChangePasswordRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ChangePasswordRequest.Builder, ChangePasswordRequest> {

    @Nonnull
    private final String currentPassword;

    @Nonnull
    private final String password;

    // ---------------------------------------------------------------------------------------------

    private ChangePasswordRequest(Builder builder) {
        super(builder);
        this.currentPassword = ApiTypeHelper.requireNonNull(builder.currentPassword, this, "currentPassword");
        this.password = ApiTypeHelper.requireNonNull(builder.password, this, "password");
    }

    public static ChangePasswordRequest of(Function<ChangePasswordRequest.Builder, ObjectBuilder<ChangePasswordRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The current password.
     * <p>
     * API name: {@code current_password}
     * </p>
     */
    @Nonnull
    public final String currentPassword() {
        return this.currentPassword;
    }

    /**
     * Required - The new password to set.
     * <p>
     * API name: {@code password}
     * </p>
     */
    @Nonnull
    public final String password() {
        return this.password;
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
        generator.writeKey("current_password");
        generator.write(this.currentPassword);

        generator.writeKey("password");
        generator.write(this.password);
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
     * Builder for {@link ChangePasswordRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ChangePasswordRequest> {
        private String currentPassword;
        private String password;

        public Builder() {}

        private Builder(ChangePasswordRequest o) {
            super(o);
            this.currentPassword = o.currentPassword;
            this.password = o.password;
        }

        private Builder(Builder o) {
            super(o);
            this.currentPassword = o.currentPassword;
            this.password = o.password;
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
         * Required - The current password.
         * <p>
         * API name: {@code current_password}
         * </p>
         */
        @Nonnull
        public final Builder currentPassword(String value) {
            this.currentPassword = value;
            return this;
        }

        /**
         * Required - The new password to set.
         * <p>
         * API name: {@code password}
         * </p>
         */
        @Nonnull
        public final Builder password(String value) {
            this.password = value;
            return this;
        }

        /**
         * Builds a {@link ChangePasswordRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ChangePasswordRequest build() {
            _checkSingleUse();

            return new ChangePasswordRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ChangePasswordRequest}
     */
    public static final JsonpDeserializer<ChangePasswordRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ChangePasswordRequest::setupChangePasswordRequestDeserializer
    );

    protected static void setupChangePasswordRequestDeserializer(ObjectDeserializer<ChangePasswordRequest.Builder> op) {
        op.add(Builder::currentPassword, JsonpDeserializer.stringDeserializer(), "current_password");
        op.add(Builder::password, JsonpDeserializer.stringDeserializer(), "password");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code security.change_password}".
     */
    public static final Endpoint<ChangePasswordRequest, ChangePasswordResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> "/_plugins/_security/api/account",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        ChangePasswordResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.currentPassword.hashCode();
        result = 31 * result + this.password.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ChangePasswordRequest other = (ChangePasswordRequest) o;
        return this.currentPassword.equals(other.currentPassword) && this.password.equals(other.password);
    }
}
