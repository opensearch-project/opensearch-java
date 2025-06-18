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

package org.opensearch.client.opensearch.indices;

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

// typedef: indices.data_streams_stats.Request

/**
 * Provides statistics on operations happening in a data stream.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class DataStreamsStatsRequest extends RequestBase
    implements
        ToCopyableBuilder<DataStreamsStatsRequest.Builder, DataStreamsStatsRequest> {

    @Nonnull
    private final List<String> name;

    // ---------------------------------------------------------------------------------------------

    private DataStreamsStatsRequest(Builder builder) {
        super(builder);
        this.name = ApiTypeHelper.unmodifiable(builder.name);
    }

    public static DataStreamsStatsRequest of(Function<DataStreamsStatsRequest.Builder, ObjectBuilder<DataStreamsStatsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * A comma-separated list of data streams used to limit the request. Wildcard expressions (<code>*</code>) are supported. To target all
     * data streams in a cluster, omit this parameter or use <code>*</code>.
     * <p>
     * API name: {@code name}
     * </p>
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
     * Builder for {@link DataStreamsStatsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, DataStreamsStatsRequest> {
        @Nullable
        private List<String> name;

        public Builder() {}

        private Builder(DataStreamsStatsRequest o) {
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
         * A comma-separated list of data streams used to limit the request. Wildcard expressions (<code>*</code>) are supported. To target
         * all data streams in a cluster, omit this parameter or use <code>*</code>.
         * <p>
         * API name: {@code name}
         * </p>
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
         * A comma-separated list of data streams used to limit the request. Wildcard expressions (<code>*</code>) are supported. To target
         * all data streams in a cluster, omit this parameter or use <code>*</code>.
         * <p>
         * API name: {@code name}
         * </p>
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
         * Builds a {@link DataStreamsStatsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DataStreamsStatsRequest build() {
            _checkSingleUse();

            return new DataStreamsStatsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code indices.data_streams_stats}".
     */
    public static final Endpoint<DataStreamsStatsRequest, DataStreamsStatsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _name = 1 << 0;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.name())) propsSet |= _name;

            if (propsSet == 0) {
                return "/_data_stream/_stats";
            }
            if (propsSet == (_name)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_data_stream/");
                SimpleEndpoint.pathEncode(String.join(",", request.name), buf);
                buf.append("/_stats");
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
        DataStreamsStatsResponse._DESERIALIZER
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
        DataStreamsStatsRequest other = (DataStreamsStatsRequest) o;
        return Objects.equals(this.name, other.name);
    }
}
