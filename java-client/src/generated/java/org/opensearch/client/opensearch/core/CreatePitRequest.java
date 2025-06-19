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

package org.opensearch.client.opensearch.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.ExpandWildcard;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.create_pit.Request

/**
 * Creates point in time context.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class CreatePitRequest extends RequestBase implements ToCopyableBuilder<CreatePitRequest.Builder, CreatePitRequest> {

    @Nullable
    private final Boolean allowPartialPitCreation;

    @Nonnull
    private final List<ExpandWildcard> expandWildcards;

    @Nonnull
    private final List<String> index;

    @Nullable
    private final Time keepAlive;

    @Nullable
    private final String preference;

    @Nonnull
    private final List<String> routing;

    // ---------------------------------------------------------------------------------------------

    private CreatePitRequest(Builder builder) {
        super(builder);
        this.allowPartialPitCreation = builder.allowPartialPitCreation;
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.index = ApiTypeHelper.unmodifiableRequired(builder.index, this, "index");
        this.keepAlive = builder.keepAlive;
        this.preference = builder.preference;
        this.routing = ApiTypeHelper.unmodifiable(builder.routing);
    }

    public static CreatePitRequest of(Function<CreatePitRequest.Builder, ObjectBuilder<CreatePitRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Allow if point in time can be created with partial failures.
     * <p>
     * API name: {@code allow_partial_pit_creation}
     * </p>
     */
    @Nullable
    public final Boolean allowPartialPitCreation() {
        return this.allowPartialPitCreation;
    }

    /**
     * Whether to expand wildcard expression to concrete indexes that are open, closed or both.
     * <p>
     * API name: {@code expand_wildcards}
     * </p>
     */
    @Nonnull
    public final List<ExpandWildcard> expandWildcards() {
        return this.expandWildcards;
    }

    /**
     * Required - A comma-separated list of indexes; use <code>_all</code> or empty string to perform the operation on all indexes.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final List<String> index() {
        return this.index;
    }

    /**
     * Specify the keep alive for point in time.
     * <p>
     * API name: {@code keep_alive}
     * </p>
     */
    @Nullable
    public final Time keepAlive() {
        return this.keepAlive;
    }

    /**
     * Specify the node or shard the operation should be performed on.
     * <p>
     * API name: {@code preference}
     * </p>
     */
    @Nullable
    public final String preference() {
        return this.preference;
    }

    /**
     * A comma-separated list of specific routing values.
     * <p>
     * API name: {@code routing}
     * </p>
     */
    @Nonnull
    public final List<String> routing() {
        return this.routing;
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
     * Builder for {@link CreatePitRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, CreatePitRequest> {
        @Nullable
        private Boolean allowPartialPitCreation;
        @Nullable
        private List<ExpandWildcard> expandWildcards;
        private List<String> index;
        @Nullable
        private Time keepAlive;
        @Nullable
        private String preference;
        @Nullable
        private List<String> routing;

        public Builder() {}

        private Builder(CreatePitRequest o) {
            super(o);
            this.allowPartialPitCreation = o.allowPartialPitCreation;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.index = _listCopy(o.index);
            this.keepAlive = o.keepAlive;
            this.preference = o.preference;
            this.routing = _listCopy(o.routing);
        }

        private Builder(Builder o) {
            super(o);
            this.allowPartialPitCreation = o.allowPartialPitCreation;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.index = _listCopy(o.index);
            this.keepAlive = o.keepAlive;
            this.preference = o.preference;
            this.routing = _listCopy(o.routing);
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
         * Allow if point in time can be created with partial failures.
         * <p>
         * API name: {@code allow_partial_pit_creation}
         * </p>
         */
        @Nonnull
        public final Builder allowPartialPitCreation(@Nullable Boolean value) {
            this.allowPartialPitCreation = value;
            return this;
        }

        /**
         * Whether to expand wildcard expression to concrete indexes that are open, closed or both.
         * <p>
         * API name: {@code expand_wildcards}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>expandWildcards</code>.
         * </p>
         */
        @Nonnull
        public final Builder expandWildcards(List<ExpandWildcard> list) {
            this.expandWildcards = _listAddAll(this.expandWildcards, list);
            return this;
        }

        /**
         * Whether to expand wildcard expression to concrete indexes that are open, closed or both.
         * <p>
         * API name: {@code expand_wildcards}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>expandWildcards</code>.
         * </p>
         */
        @Nonnull
        public final Builder expandWildcards(ExpandWildcard value, ExpandWildcard... values) {
            this.expandWildcards = _listAdd(this.expandWildcards, value, values);
            return this;
        }

        /**
         * Required - A comma-separated list of indexes; use <code>_all</code> or empty string to perform the operation on all indexes.
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
         * Required - A comma-separated list of indexes; use <code>_all</code> or empty string to perform the operation on all indexes.
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
         * Specify the keep alive for point in time.
         * <p>
         * API name: {@code keep_alive}
         * </p>
         */
        @Nonnull
        public final Builder keepAlive(@Nullable Time value) {
            this.keepAlive = value;
            return this;
        }

        /**
         * Specify the keep alive for point in time.
         * <p>
         * API name: {@code keep_alive}
         * </p>
         */
        @Nonnull
        public final Builder keepAlive(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return keepAlive(fn.apply(new Time.Builder()).build());
        }

        /**
         * Specify the node or shard the operation should be performed on.
         * <p>
         * API name: {@code preference}
         * </p>
         */
        @Nonnull
        public final Builder preference(@Nullable String value) {
            this.preference = value;
            return this;
        }

        /**
         * A comma-separated list of specific routing values.
         * <p>
         * API name: {@code routing}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>routing</code>.
         * </p>
         */
        @Nonnull
        public final Builder routing(List<String> list) {
            this.routing = _listAddAll(this.routing, list);
            return this;
        }

        /**
         * A comma-separated list of specific routing values.
         * <p>
         * API name: {@code routing}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>routing</code>.
         * </p>
         */
        @Nonnull
        public final Builder routing(String value, String... values) {
            this.routing = _listAdd(this.routing, value, values);
            return this;
        }

        /**
         * Builds a {@link CreatePitRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CreatePitRequest build() {
            _checkSingleUse();

            return new CreatePitRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.allowPartialPitCreation != null) {
            params.put("allow_partial_pit_creation", String.valueOf(this.allowPartialPitCreation));
        }
        if (ApiTypeHelper.isDefined(this.expandWildcards)) {
            params.put("expand_wildcards", this.expandWildcards.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")));
        }
        if (this.keepAlive != null) {
            params.put("keep_alive", this.keepAlive._toJsonString());
        }
        if (this.preference != null) {
            params.put("preference", this.preference);
        }
        if (ApiTypeHelper.isDefined(this.routing)) {
            params.put("routing", String.join(",", this.routing));
        }
    }

    /**
     * Endpoint "{@code create_pit}".
     */
    public static final Endpoint<CreatePitRequest, CreatePitResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/");
            SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
            buf.append("/_search/point_in_time");
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
        CreatePitResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allowPartialPitCreation);
        result = 31 * result + Objects.hashCode(this.expandWildcards);
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Objects.hashCode(this.keepAlive);
        result = 31 * result + Objects.hashCode(this.preference);
        result = 31 * result + Objects.hashCode(this.routing);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CreatePitRequest other = (CreatePitRequest) o;
        return Objects.equals(this.allowPartialPitCreation, other.allowPartialPitCreation)
            && Objects.equals(this.expandWildcards, other.expandWildcards)
            && this.index.equals(other.index)
            && Objects.equals(this.keepAlive, other.keepAlive)
            && Objects.equals(this.preference, other.preference)
            && Objects.equals(this.routing, other.routing);
    }
}
