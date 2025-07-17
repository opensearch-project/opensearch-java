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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: geospatial.get_ip2geo_datasource.Request

/**
 * Get one or more IP2Geo data sources, defaulting to returning all if no names specified.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetIp2geoDatasourceRequest extends RequestBase
    implements
        ToCopyableBuilder<GetIp2geoDatasourceRequest.Builder, GetIp2geoDatasourceRequest> {

    @Nonnull
    private final List<String> name;

    // ---------------------------------------------------------------------------------------------

    private GetIp2geoDatasourceRequest(Builder builder) {
        super(builder);
        this.name = ApiTypeHelper.unmodifiable(builder.name);
    }

    public static GetIp2geoDatasourceRequest of(
        Function<GetIp2geoDatasourceRequest.Builder, ObjectBuilder<GetIp2geoDatasourceRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code name}
     */
    @Nonnull
    public final List<String> name() {
        return this.name;
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
     * Builder for {@link GetIp2geoDatasourceRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, GetIp2geoDatasourceRequest> {
        @Nullable
        private List<String> name;

        public Builder() {}

        private Builder(GetIp2geoDatasourceRequest o) {
            super(o);
            this.name = _listCopy(o.name);
        }

        private Builder(Builder o) {
            super(o);
            this.name = _listCopy(o.name);
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
         * API name: {@code name}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>name</code>.
         * </p>
         */
        @Nonnull
        public final Builder name(List<String> list) {
            this.name = _listAddAll(this.name, list);
            return this;
        }

        /**
         * API name: {@code name}
         *
         * <p>
         * Adds one or more values to <code>name</code>.
         * </p>
         */
        @Nonnull
        public final Builder name(String value, String... values) {
            this.name = _listAdd(this.name, value, values);
            return this;
        }

        /**
         * Builds a {@link GetIp2geoDatasourceRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetIp2geoDatasourceRequest build() {
            _checkSingleUse();

            return new GetIp2geoDatasourceRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code geospatial.get_ip2geo_datasource}".
     */
    public static final Endpoint<GetIp2geoDatasourceRequest, GetIp2geoDatasourceResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _name = 1 << 0;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.name())) propsSet |= _name;

            if (propsSet == 0) {
                return "/_plugins/geospatial/ip2geo/datasource";
            }
            if (propsSet == (_name)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/geospatial/ip2geo/datasource/");
                SimpleEndpoint.pathEncode(String.join(",", request.name), buf);
                return buf.toString();
            }

            throw SimpleEndpoint.noPathTemplateFound("path");
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        GetIp2geoDatasourceResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.name);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetIp2geoDatasourceRequest other = (GetIp2geoDatasourceRequest) o;
        return Objects.equals(this.name, other.name);
    }
}
