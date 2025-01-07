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

package org.opensearch.client.opensearch.cat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.Bytes;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.TimeUnit;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cat.recovery.Request

/**
 * Returns all completed and ongoing index and shard recoveries.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class RecoveryRequest extends CatRequestBase implements ToCopyableBuilder<RecoveryRequest.Builder, RecoveryRequest> {

    @Nullable
    private final Boolean activeOnly;

    @Nullable
    private final Bytes bytes;

    @Nullable
    private final Boolean detailed;

    @Nonnull
    private final List<String> index;

    @Nullable
    private final TimeUnit time;

    // ---------------------------------------------------------------------------------------------

    private RecoveryRequest(Builder builder) {
        super(builder);
        this.activeOnly = builder.activeOnly;
        this.bytes = builder.bytes;
        this.detailed = builder.detailed;
        this.index = ApiTypeHelper.unmodifiable(builder.index);
        this.time = builder.time;
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
     * The units used to display byte values.
     * <p>
     * API name: {@code bytes}
     * </p>
     */
    @Nullable
    public final Bytes bytes() {
        return this.bytes;
    }

    /**
     * When <code>true</code>, includes detailed information about shard recoveries.
     * <p>
     * API name: {@code detailed}
     * </p>
     */
    @Nullable
    public final Boolean detailed() {
        return this.detailed;
    }

    /**
     * A comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards (<code>*</code>). To
     * target all data streams and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final List<String> index() {
        return this.index;
    }

    /**
     * Specifies the time units, for example, <code>5d</code> or <code>7h</code>. For more information, see
     * <a href="https://opensearch.org/docs/latest/api-reference/units/">Supported units</a>.
     * <p>
     * API name: {@code time}
     * </p>
     */
    @Nullable
    public final TimeUnit time() {
        return this.time;
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
    public static class Builder extends CatRequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, RecoveryRequest> {
        @Nullable
        private Boolean activeOnly;
        @Nullable
        private Bytes bytes;
        @Nullable
        private Boolean detailed;
        @Nullable
        private List<String> index;
        @Nullable
        private TimeUnit time;

        public Builder() {}

        private Builder(RecoveryRequest o) {
            super(o);
            this.activeOnly = o.activeOnly;
            this.bytes = o.bytes;
            this.detailed = o.detailed;
            this.index = _listCopy(o.index);
            this.time = o.time;
        }

        private Builder(Builder o) {
            super(o);
            this.activeOnly = o.activeOnly;
            this.bytes = o.bytes;
            this.detailed = o.detailed;
            this.index = _listCopy(o.index);
            this.time = o.time;
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
         * The units used to display byte values.
         * <p>
         * API name: {@code bytes}
         * </p>
         */
        @Nonnull
        public final Builder bytes(@Nullable Bytes value) {
            this.bytes = value;
            return this;
        }

        /**
         * When <code>true</code>, includes detailed information about shard recoveries.
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
         * A comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards (<code>*</code>). To
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
         * A comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards (<code>*</code>). To
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
         * Specifies the time units, for example, <code>5d</code> or <code>7h</code>. For more information, see
         * <a href="https://opensearch.org/docs/latest/api-reference/units/">Supported units</a>.
         * <p>
         * API name: {@code time}
         * </p>
         */
        @Nonnull
        public final Builder time(@Nullable TimeUnit value) {
            this.time = value;
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
        if (this.bytes != null) {
            params.put("bytes", this.bytes.jsonValue());
        }
        if (this.detailed != null) {
            params.put("detailed", String.valueOf(this.detailed));
        }
        if (this.time != null) {
            params.put("time", this.time.jsonValue());
        }
    }

    /**
     * Endpoint "{@code cat.recovery}".
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
                return "/_cat/recovery";
            }
            if (propsSet == (_index)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_cat/recovery/");
                SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
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
        result = 31 * result + Objects.hashCode(this.bytes);
        result = 31 * result + Objects.hashCode(this.detailed);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.time);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RecoveryRequest other = (RecoveryRequest) o;
        return Objects.equals(this.activeOnly, other.activeOnly)
            && Objects.equals(this.bytes, other.bytes)
            && Objects.equals(this.detailed, other.detailed)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.time, other.time);
    }
}
