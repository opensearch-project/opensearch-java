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
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: geospatial.delete_ip2geo_datasource.Request

/**
 * Delete a specific IP2Geo data source.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class DeleteIp2geoDatasourceRequest extends RequestBase
    implements
        ToCopyableBuilder<DeleteIp2geoDatasourceRequest.Builder, DeleteIp2geoDatasourceRequest> {

    @Nonnull
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private DeleteIp2geoDatasourceRequest(Builder builder) {
        super(builder);
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
    }

    public static DeleteIp2geoDatasourceRequest of(
        Function<DeleteIp2geoDatasourceRequest.Builder, ObjectBuilder<DeleteIp2geoDatasourceRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
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
     * Builder for {@link DeleteIp2geoDatasourceRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, DeleteIp2geoDatasourceRequest> {
        private String name;

        public Builder() {}

        private Builder(DeleteIp2geoDatasourceRequest o) {
            super(o);
            this.name = o.name;
        }

        private Builder(Builder o) {
            super(o);
            this.name = o.name;
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
         * Required - API name: {@code name}
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Builds a {@link DeleteIp2geoDatasourceRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteIp2geoDatasourceRequest build() {
            _checkSingleUse();

            return new DeleteIp2geoDatasourceRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code geospatial.delete_ip2geo_datasource}".
     */
    public static final Endpoint<DeleteIp2geoDatasourceRequest, DeleteIp2geoDatasourceResponse, ErrorResponse> _ENDPOINT =
        new SimpleEndpoint<>(
            // Request method
            request -> "DELETE",
            // Request path
            request -> {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/geospatial/ip2geo/datasource/");
                SimpleEndpoint.pathEncode(request.name, buf);
                return buf.toString();
            },
            // Request parameters
            request -> {
                Map<String, String> params = new HashMap<>();
                request.applyQueryParameters(params);
                return params;
            },
            SimpleEndpoint.emptyMap(),
            false,
            DeleteIp2geoDatasourceResponse._DESERIALIZER
        );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeleteIp2geoDatasourceRequest other = (DeleteIp2geoDatasourceRequest) o;
        return this.name.equals(other.name);
    }
}
