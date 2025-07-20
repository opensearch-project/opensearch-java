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

package org.opensearch.client.opensearch.geospatial;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: geospatial.put_ip2geo_datasource_settings.Request

/**
 * Update a specific IP2Geo data source.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PutIp2geoDatasourceSettingsRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PutIp2geoDatasourceSettingsRequest.Builder, PutIp2geoDatasourceSettingsRequest> {

    @Nullable
    private final String endpoint;

    @Nonnull
    private final String name;

    @Nullable
    private final Integer updateIntervalInDays;

    // ---------------------------------------------------------------------------------------------

    private PutIp2geoDatasourceSettingsRequest(Builder builder) {
        super(builder);
        this.endpoint = builder.endpoint;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.updateIntervalInDays = builder.updateIntervalInDays;
    }

    public static PutIp2geoDatasourceSettingsRequest of(
        Function<PutIp2geoDatasourceSettingsRequest.Builder, ObjectBuilder<PutIp2geoDatasourceSettingsRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * URL endpoint for the data source.
     * <p>
     * API name: {@code endpoint}
     * </p>
     */
    @Nullable
    public final String endpoint() {
        return this.endpoint;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * Update interval in days.
     * <p>
     * API name: {@code update_interval_in_days}
     * </p>
     */
    @Nullable
    public final Integer updateIntervalInDays() {
        return this.updateIntervalInDays;
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
        if (this.endpoint != null) {
            generator.writeKey("endpoint");
            generator.write(this.endpoint);
        }

        if (this.updateIntervalInDays != null) {
            generator.writeKey("update_interval_in_days");
            generator.write(this.updateIntervalInDays);
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
     * Builder for {@link PutIp2geoDatasourceSettingsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, PutIp2geoDatasourceSettingsRequest> {
        @Nullable
        private String endpoint;
        private String name;
        @Nullable
        private Integer updateIntervalInDays;

        public Builder() {}

        private Builder(PutIp2geoDatasourceSettingsRequest o) {
            super(o);
            this.endpoint = o.endpoint;
            this.name = o.name;
            this.updateIntervalInDays = o.updateIntervalInDays;
        }

        private Builder(Builder o) {
            super(o);
            this.endpoint = o.endpoint;
            this.name = o.name;
            this.updateIntervalInDays = o.updateIntervalInDays;
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
         * URL endpoint for the data source.
         * <p>
         * API name: {@code endpoint}
         * </p>
         */
        @Nonnull
        public final Builder endpoint(@Nullable String value) {
            this.endpoint = value;
            return this;
        }

        /**
         * Required - API name: {@code name}
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Update interval in days.
         * <p>
         * API name: {@code update_interval_in_days}
         * </p>
         */
        @Nonnull
        public final Builder updateIntervalInDays(@Nullable Integer value) {
            this.updateIntervalInDays = value;
            return this;
        }

        /**
         * Builds a {@link PutIp2geoDatasourceSettingsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutIp2geoDatasourceSettingsRequest build() {
            _checkSingleUse();

            return new PutIp2geoDatasourceSettingsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutIp2geoDatasourceSettingsRequest}
     */
    public static final JsonpDeserializer<PutIp2geoDatasourceSettingsRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutIp2geoDatasourceSettingsRequest::setupPutIp2geoDatasourceSettingsRequestDeserializer
    );

    protected static void setupPutIp2geoDatasourceSettingsRequestDeserializer(
        ObjectDeserializer<PutIp2geoDatasourceSettingsRequest.Builder> op
    ) {
        op.add(Builder::endpoint, JsonpDeserializer.stringDeserializer(), "endpoint");
        op.add(Builder::updateIntervalInDays, JsonpDeserializer.integerDeserializer(), "update_interval_in_days");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code geospatial.put_ip2geo_datasource_settings}".
     */
    public static final Endpoint<PutIp2geoDatasourceSettingsRequest, PutIp2geoDatasourceSettingsResponse, ErrorResponse> _ENDPOINT =
        new SimpleEndpoint<>(
            // Request method
            request -> "PUT",
            // Request path
            request -> {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/geospatial/ip2geo/datasource/");
                SimpleEndpoint.pathEncode(request.name, buf);
                buf.append("/_settings");
                return buf.toString();
            },
            // Request parameters
            request -> {
                Map<String, String> params = new HashMap<>();
                request.applyQueryParameters(params);
                return params;
            },
            SimpleEndpoint.emptyMap(),
            true,
            PutIp2geoDatasourceSettingsResponse._DESERIALIZER
        );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.endpoint);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Objects.hashCode(this.updateIntervalInDays);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PutIp2geoDatasourceSettingsRequest other = (PutIp2geoDatasourceSettingsRequest) o;
        return Objects.equals(this.endpoint, other.endpoint)
            && this.name.equals(other.name)
            && Objects.equals(this.updateIntervalInDays, other.updateIntervalInDays);
    }
}
