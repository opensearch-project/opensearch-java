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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: security.who_am_i_protected.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class WhoAmIProtectedResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<WhoAmIProtectedResponse.Builder, WhoAmIProtectedResponse> {

    @Nullable
    private final String dn;

    @Nullable
    private final Boolean isAdmin;

    @Nullable
    private final Boolean isNodeCertificateRequest;

    // ---------------------------------------------------------------------------------------------

    private WhoAmIProtectedResponse(Builder builder) {
        this.dn = builder.dn;
        this.isAdmin = builder.isAdmin;
        this.isNodeCertificateRequest = builder.isNodeCertificateRequest;
    }

    public static WhoAmIProtectedResponse of(Function<WhoAmIProtectedResponse.Builder, ObjectBuilder<WhoAmIProtectedResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code dn}
     */
    @Nullable
    public final String dn() {
        return this.dn;
    }

    /**
     * API name: {@code is_admin}
     */
    @Nullable
    public final Boolean isAdmin() {
        return this.isAdmin;
    }

    /**
     * API name: {@code is_node_certificate_request}
     */
    @Nullable
    public final Boolean isNodeCertificateRequest() {
        return this.isNodeCertificateRequest;
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
        if (this.dn != null) {
            generator.writeKey("dn");
            generator.write(this.dn);
        }

        if (this.isAdmin != null) {
            generator.writeKey("is_admin");
            generator.write(this.isAdmin);
        }

        if (this.isNodeCertificateRequest != null) {
            generator.writeKey("is_node_certificate_request");
            generator.write(this.isNodeCertificateRequest);
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
     * Builder for {@link WhoAmIProtectedResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, WhoAmIProtectedResponse> {
        @Nullable
        private String dn;
        @Nullable
        private Boolean isAdmin;
        @Nullable
        private Boolean isNodeCertificateRequest;

        public Builder() {}

        private Builder(WhoAmIProtectedResponse o) {
            this.dn = o.dn;
            this.isAdmin = o.isAdmin;
            this.isNodeCertificateRequest = o.isNodeCertificateRequest;
        }

        private Builder(Builder o) {
            this.dn = o.dn;
            this.isAdmin = o.isAdmin;
            this.isNodeCertificateRequest = o.isNodeCertificateRequest;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code dn}
         */
        @Nonnull
        public final Builder dn(@Nullable String value) {
            this.dn = value;
            return this;
        }

        /**
         * API name: {@code is_admin}
         */
        @Nonnull
        public final Builder isAdmin(@Nullable Boolean value) {
            this.isAdmin = value;
            return this;
        }

        /**
         * API name: {@code is_node_certificate_request}
         */
        @Nonnull
        public final Builder isNodeCertificateRequest(@Nullable Boolean value) {
            this.isNodeCertificateRequest = value;
            return this;
        }

        /**
         * Builds a {@link WhoAmIProtectedResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public WhoAmIProtectedResponse build() {
            _checkSingleUse();

            return new WhoAmIProtectedResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link WhoAmIProtectedResponse}
     */
    public static final JsonpDeserializer<WhoAmIProtectedResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        WhoAmIProtectedResponse::setupWhoAmIProtectedResponseDeserializer
    );

    protected static void setupWhoAmIProtectedResponseDeserializer(ObjectDeserializer<WhoAmIProtectedResponse.Builder> op) {
        op.add(Builder::dn, JsonpDeserializer.stringDeserializer(), "dn");
        op.add(Builder::isAdmin, JsonpDeserializer.booleanDeserializer(), "is_admin");
        op.add(Builder::isNodeCertificateRequest, JsonpDeserializer.booleanDeserializer(), "is_node_certificate_request");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.dn);
        result = 31 * result + Objects.hashCode(this.isAdmin);
        result = 31 * result + Objects.hashCode(this.isNodeCertificateRequest);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        WhoAmIProtectedResponse other = (WhoAmIProtectedResponse) o;
        return Objects.equals(this.dn, other.dn)
            && Objects.equals(this.isAdmin, other.isAdmin)
            && Objects.equals(this.isNodeCertificateRequest, other.isNodeCertificateRequest);
    }
}
