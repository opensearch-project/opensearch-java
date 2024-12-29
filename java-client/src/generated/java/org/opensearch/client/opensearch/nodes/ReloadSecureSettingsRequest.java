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

package org.opensearch.client.opensearch.nodes;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
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
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.reload_secure_settings.Request

/**
 * Reloads secure settings.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ReloadSecureSettingsRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ReloadSecureSettingsRequest.Builder, ReloadSecureSettingsRequest> {

    @Nonnull
    private final List<String> nodeId;

    @Nullable
    private final String secureSettingsPassword;

    @Nullable
    private final Time timeout;

    // ---------------------------------------------------------------------------------------------

    private ReloadSecureSettingsRequest(Builder builder) {
        this.nodeId = ApiTypeHelper.unmodifiable(builder.nodeId);
        this.secureSettingsPassword = builder.secureSettingsPassword;
        this.timeout = builder.timeout;
    }

    public static ReloadSecureSettingsRequest of(
        Function<ReloadSecureSettingsRequest.Builder, ObjectBuilder<ReloadSecureSettingsRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The names of particular nodes in the cluster to target.
     * <p>
     * API name: {@code node_id}
     * </p>
     */
    @Nonnull
    public final List<String> nodeId() {
        return this.nodeId;
    }

    /**
     * API name: {@code secure_settings_password}
     */
    @Nullable
    public final String secureSettingsPassword() {
        return this.secureSettingsPassword;
    }

    /**
     * Period to wait for a response. If no response is received before the timeout expires, the request fails and returns an error.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final Time timeout() {
        return this.timeout;
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
        if (this.secureSettingsPassword != null) {
            generator.writeKey("secure_settings_password");
            generator.write(this.secureSettingsPassword);
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
     * Builder for {@link ReloadSecureSettingsRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ReloadSecureSettingsRequest> {
        @Nullable
        private List<String> nodeId;
        @Nullable
        private String secureSettingsPassword;
        @Nullable
        private Time timeout;

        public Builder() {}

        private Builder(ReloadSecureSettingsRequest o) {
            this.nodeId = _listCopy(o.nodeId);
            this.secureSettingsPassword = o.secureSettingsPassword;
            this.timeout = o.timeout;
        }

        private Builder(Builder o) {
            this.nodeId = _listCopy(o.nodeId);
            this.secureSettingsPassword = o.secureSettingsPassword;
            this.timeout = o.timeout;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The names of particular nodes in the cluster to target.
         * <p>
         * API name: {@code node_id}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>nodeId</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodeId(List<String> list) {
            this.nodeId = _listAddAll(this.nodeId, list);
            return this;
        }

        /**
         * The names of particular nodes in the cluster to target.
         * <p>
         * API name: {@code node_id}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>nodeId</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodeId(String value, String... values) {
            this.nodeId = _listAdd(this.nodeId, value, values);
            return this;
        }

        /**
         * API name: {@code secure_settings_password}
         */
        @Nonnull
        public final Builder secureSettingsPassword(@Nullable String value) {
            this.secureSettingsPassword = value;
            return this;
        }

        /**
         * Period to wait for a response. If no response is received before the timeout expires, the request fails and returns an error.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(@Nullable Time value) {
            this.timeout = value;
            return this;
        }

        /**
         * Period to wait for a response. If no response is received before the timeout expires, the request fails and returns an error.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link ReloadSecureSettingsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ReloadSecureSettingsRequest build() {
            _checkSingleUse();

            return new ReloadSecureSettingsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ReloadSecureSettingsRequest}
     */
    public static final JsonpDeserializer<ReloadSecureSettingsRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ReloadSecureSettingsRequest::setupReloadSecureSettingsRequestDeserializer
    );

    protected static void setupReloadSecureSettingsRequestDeserializer(ObjectDeserializer<ReloadSecureSettingsRequest.Builder> op) {
        op.add(Builder::secureSettingsPassword, JsonpDeserializer.stringDeserializer(), "secure_settings_password");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code nodes.reload_secure_settings}".
     */
    public static final Endpoint<ReloadSecureSettingsRequest, ReloadSecureSettingsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _nodeId = 1 << 0;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.nodeId())) propsSet |= _nodeId;

            if (propsSet == 0) {
                return "/_nodes/reload_secure_settings";
            }
            if (propsSet == (_nodeId)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_nodes/");
                SimpleEndpoint.pathEncode(String.join(",", request.nodeId), buf);
                buf.append("/reload_secure_settings");
                return buf.toString();
            }

            throw SimpleEndpoint.noPathTemplateFound("path");
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            if (request.timeout != null) {
                params.put("timeout", request.timeout._toJsonString());
            }
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        ReloadSecureSettingsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.nodeId);
        result = 31 * result + Objects.hashCode(this.secureSettingsPassword);
        result = 31 * result + Objects.hashCode(this.timeout);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ReloadSecureSettingsRequest other = (ReloadSecureSettingsRequest) o;
        return Objects.equals(this.nodeId, other.nodeId)
            && Objects.equals(this.secureSettingsPassword, other.secureSettingsPassword)
            && Objects.equals(this.timeout, other.timeout);
    }
}
