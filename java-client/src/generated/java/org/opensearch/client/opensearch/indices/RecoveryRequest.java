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

// typedef: indices.recovery.Request

/**
 * Returns information about ongoing index shard recoveries.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class RecoveryRequest extends RequestBase implements ToCopyableBuilder<RecoveryRequest.Builder, RecoveryRequest> {

    @Nullable
    private final Boolean activeOnly;

    @Nullable
    private final Boolean detailed;

    @Nonnull
    private final List<String> index;

    // ---------------------------------------------------------------------------------------------

    private RecoveryRequest(Builder builder) {
        super(builder);
        this.activeOnly = builder.activeOnly;
        this.detailed = builder.detailed;
        this.index = ApiTypeHelper.unmodifiable(builder.index);
    }

    public static RecoveryRequest of(Function<RecoveryRequest.Builder, ObjectBuilder<RecoveryRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * If <code>true</code>, the response only includes ongoing shard recoveries.
     * <p>
     * API name: {@code active_only}
     * </p>
     */
    @Nullable
    public final Boolean activeOnly() {
        return this.activeOnly;
    }

    /**
     * If <code>true</code>, the response includes detailed information about shard recoveries.
     * <p>
     * API name: {@code detailed}
     * </p>
     */
    @Nullable
    public final Boolean detailed() {
        return this.detailed;
    }

    /**
     * Comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards (<code>*</code>). To target
     * all data streams and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final List<String> index() {
        return this.index;
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
     * Builder for {@link RecoveryRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, RecoveryRequest> {
        @Nullable
        private Boolean activeOnly;
        @Nullable
        private Boolean detailed;
        @Nullable
        private List<String> index;

        public Builder() {}

        private Builder(RecoveryRequest o) {
            super(o);
            this.activeOnly = o.activeOnly;
            this.detailed = o.detailed;
            this.index = _listCopy(o.index);
        }

        private Builder(Builder o) {
            super(o);
            this.activeOnly = o.activeOnly;
            this.detailed = o.detailed;
            this.index = _listCopy(o.index);
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
         * If <code>true</code>, the response only includes ongoing shard recoveries.
         * <p>
         * API name: {@code active_only}
         * </p>
         */
        @Nonnull
        public final Builder activeOnly(@Nullable Boolean value) {
            this.activeOnly = value;
            return this;
        }

        /**
         * If <code>true</code>, the response includes detailed information about shard recoveries.
         * <p>
         * API name: {@code detailed}
         * </p>
         */
        @Nonnull
        public final Builder detailed(@Nullable Boolean value) {
            this.detailed = value;
            return this;
        }

        /**
         * Comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards (<code>*</code>). To
         * target all data streams and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
         * <p>
         * API name: {@code index}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>index</code>.
         * </p>
         */
        @Nonnull
        public final Builder index(List<String> list) {
            this.index = _listAddAll(this.index, list);
            return this;
        }

        /**
         * Comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards (<code>*</code>). To
         * target all data streams and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
         * <p>
         * API name: {@code index}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>index</code>.
         * </p>
         */
        @Nonnull
        public final Builder index(String value, String... values) {
            this.index = _listAdd(this.index, value, values);
            return this;
        }

        /**
         * Builds a {@link RecoveryRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RecoveryRequest build() {
            _checkSingleUse();

            return new RecoveryRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.activeOnly != null) {
            params.put("active_only", String.valueOf(this.activeOnly));
        }
        if (this.detailed != null) {
            params.put("detailed", String.valueOf(this.detailed));
        }
    }

    /**
     * Endpoint "{@code indices.recovery}".
     */
    public static final Endpoint<RecoveryRequest, RecoveryResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _index = 1 << 0;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.index())) propsSet |= _index;

            if (propsSet == 0) {
                return "/_recovery";
            }
            if (propsSet == (_index)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/");
                SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
                buf.append("/_recovery");
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
        RecoveryResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.activeOnly);
        result = 31 * result + Objects.hashCode(this.detailed);
        result = 31 * result + Objects.hashCode(this.index);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RecoveryRequest other = (RecoveryRequest) o;
        return Objects.equals(this.activeOnly, other.activeOnly)
            && Objects.equals(this.detailed, other.detailed)
            && Objects.equals(this.index, other.index);
    }
}
