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
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: security.config_upgrade_perform.Request

/**
 * Assists the cluster operator with upgrading missing default values and stale default definitions.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class ConfigUpgradePerformRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ConfigUpgradePerformRequest.Builder, ConfigUpgradePerformRequest> {

    @Nonnull
    private final List<String> config;

    // ---------------------------------------------------------------------------------------------

    private ConfigUpgradePerformRequest(Builder builder) {
        super(builder);
        this.config = ApiTypeHelper.unmodifiable(builder.config);
    }

    public static ConfigUpgradePerformRequest of(
        Function<ConfigUpgradePerformRequest.Builder, ObjectBuilder<ConfigUpgradePerformRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * A list of configurations to upgrade.
     * <p>
     * API name: {@code config}
     * </p>
     */
    @Nonnull
    public final List<String> config() {
        return this.config;
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
        if (ApiTypeHelper.isDefined(this.config)) {
            generator.writeKey("config");
            generator.writeStartArray();
            for (String item0 : this.config) {
                generator.write(item0);
            }
            generator.writeEnd();
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
     * Builder for {@link ConfigUpgradePerformRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, ConfigUpgradePerformRequest> {
        @Nullable
        private List<String> config;

        public Builder() {}

        private Builder(ConfigUpgradePerformRequest o) {
            super(o);
            this.config = _listCopy(o.config);
        }

        private Builder(Builder o) {
            super(o);
            this.config = _listCopy(o.config);
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
         * A list of configurations to upgrade.
         * <p>
         * API name: {@code config}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>config</code>.
         * </p>
         */
        @Nonnull
        public final Builder config(List<String> list) {
            this.config = _listAddAll(this.config, list);
            return this;
        }

        /**
         * A list of configurations to upgrade.
         * <p>
         * API name: {@code config}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>config</code>.
         * </p>
         */
        @Nonnull
        public final Builder config(String value, String... values) {
            this.config = _listAdd(this.config, value, values);
            return this;
        }

        /**
         * Builds a {@link ConfigUpgradePerformRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ConfigUpgradePerformRequest build() {
            _checkSingleUse();

            return new ConfigUpgradePerformRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ConfigUpgradePerformRequest}
     */
    public static final JsonpDeserializer<ConfigUpgradePerformRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ConfigUpgradePerformRequest::setupConfigUpgradePerformRequestDeserializer
    );

    protected static void setupConfigUpgradePerformRequestDeserializer(ObjectDeserializer<ConfigUpgradePerformRequest.Builder> op) {
        op.add(Builder::config, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "config");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code security.config_upgrade_perform}".
     */
    public static final Endpoint<ConfigUpgradePerformRequest, ConfigUpgradePerformResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> "/_plugins/_security/api/_upgrade_perform",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        ConfigUpgradePerformResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.config);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ConfigUpgradePerformRequest other = (ConfigUpgradePerformRequest) o;
        return Objects.equals(this.config, other.config);
    }
}
