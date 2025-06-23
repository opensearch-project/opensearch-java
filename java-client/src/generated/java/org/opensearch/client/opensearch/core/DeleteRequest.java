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
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.VersionType;
import org.opensearch.client.opensearch._types.WaitForActiveShards;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.delete.Request

/**
 * Removes a document from the index.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class DeleteRequest extends RequestBase implements ToCopyableBuilder<DeleteRequest.Builder, DeleteRequest> {

    @Nonnull
    private final String id;

    @Nullable
    private final Long ifPrimaryTerm;

    @Nullable
    private final Long ifSeqNo;

    @Nonnull
    private final String index;

    @Nullable
    private final Refresh refresh;

    @Nonnull
    private final List<String> routing;

    @Nullable
    private final Time timeout;

    @Nullable
    private final Long version;

    @Nullable
    private final VersionType versionType;

    @Nullable
    private final WaitForActiveShards waitForActiveShards;

    // ---------------------------------------------------------------------------------------------

    private DeleteRequest(Builder builder) {
        super(builder);
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.ifPrimaryTerm = builder.ifPrimaryTerm;
        this.ifSeqNo = builder.ifSeqNo;
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.refresh = builder.refresh;
        this.routing = ApiTypeHelper.unmodifiable(builder.routing);
        this.timeout = builder.timeout;
        this.version = builder.version;
        this.versionType = builder.versionType;
        this.waitForActiveShards = builder.waitForActiveShards;
    }

    public static DeleteRequest of(Function<DeleteRequest.Builder, ObjectBuilder<DeleteRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The unique identifier for the document.
     * <p>
     * API name: {@code id}
     * </p>
     */
    @Nonnull
    public final String id() {
        return this.id;
    }

    /**
     * Only perform the operation if the document has this primary term.
     * <p>
     * API name: {@code if_primary_term}
     * </p>
     */
    @Nullable
    public final Long ifPrimaryTerm() {
        return this.ifPrimaryTerm;
    }

    /**
     * Only perform the operation if the document has this sequence number.
     * <p>
     * API name: {@code if_seq_no}
     * </p>
     */
    @Nullable
    public final Long ifSeqNo() {
        return this.ifSeqNo;
    }

    /**
     * Required - Name of the target index.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final String index() {
        return this.index;
    }

    /**
     * If <code>true</code>, OpenSearch refreshes the affected shards to make this operation visible to search, if <code>wait_for</code>
     * then wait for a refresh to make this operation visible to search, if <code>false</code> do nothing with refreshes. Valid values:
     * <code>true</code>, <code>false</code>, <code>wait_for</code>.
     * <p>
     * API name: {@code refresh}
     * </p>
     */
    @Nullable
    public final Refresh refresh() {
        return this.refresh;
    }

    /**
     * A custom value used to route operations to a specific shard.
     * <p>
     * API name: {@code routing}
     * </p>
     */
    @Nonnull
    public final List<String> routing() {
        return this.routing;
    }

    /**
     * Period to wait for active shards.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final Time timeout() {
        return this.timeout;
    }

    /**
     * Explicit version number for concurrency control. The specified version must match the current version of the document for the request
     * to succeed.
     * <p>
     * API name: {@code version}
     * </p>
     */
    @Nullable
    public final Long version() {
        return this.version;
    }

    /**
     * The specific version type: <code>external</code>, <code>external_gte</code>.
     * <p>
     * API name: {@code version_type}
     * </p>
     */
    @Nullable
    public final VersionType versionType() {
        return this.versionType;
    }

    /**
     * The number of shard copies that must be active before proceeding with the operation. Set to <code>all</code> or any positive integer
     * up to the total number of shards in the index (<code>number_of_replicas+1</code>).
     * <p>
     * API name: {@code wait_for_active_shards}
     * </p>
     */
    @Nullable
    public final WaitForActiveShards waitForActiveShards() {
        return this.waitForActiveShards;
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
     * Builder for {@link DeleteRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, DeleteRequest> {
        private String id;
        @Nullable
        private Long ifPrimaryTerm;
        @Nullable
        private Long ifSeqNo;
        private String index;
        @Nullable
        private Refresh refresh;
        @Nullable
        private List<String> routing;
        @Nullable
        private Time timeout;
        @Nullable
        private Long version;
        @Nullable
        private VersionType versionType;
        @Nullable
        private WaitForActiveShards waitForActiveShards;

        public Builder() {}

        private Builder(DeleteRequest o) {
            super(o);
            this.id = o.id;
            this.ifPrimaryTerm = o.ifPrimaryTerm;
            this.ifSeqNo = o.ifSeqNo;
            this.index = o.index;
            this.refresh = o.refresh;
            this.routing = _listCopy(o.routing);
            this.timeout = o.timeout;
            this.version = o.version;
            this.versionType = o.versionType;
            this.waitForActiveShards = o.waitForActiveShards;
        }

        private Builder(Builder o) {
            super(o);
            this.id = o.id;
            this.ifPrimaryTerm = o.ifPrimaryTerm;
            this.ifSeqNo = o.ifSeqNo;
            this.index = o.index;
            this.refresh = o.refresh;
            this.routing = _listCopy(o.routing);
            this.timeout = o.timeout;
            this.version = o.version;
            this.versionType = o.versionType;
            this.waitForActiveShards = o.waitForActiveShards;
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
         * Required - The unique identifier for the document.
         * <p>
         * API name: {@code id}
         * </p>
         */
        @Nonnull
        public final Builder id(String value) {
            this.id = value;
            return this;
        }

        /**
         * Only perform the operation if the document has this primary term.
         * <p>
         * API name: {@code if_primary_term}
         * </p>
         */
        @Nonnull
        public final Builder ifPrimaryTerm(@Nullable Long value) {
            this.ifPrimaryTerm = value;
            return this;
        }

        /**
         * Only perform the operation if the document has this sequence number.
         * <p>
         * API name: {@code if_seq_no}
         * </p>
         */
        @Nonnull
        public final Builder ifSeqNo(@Nullable Long value) {
            this.ifSeqNo = value;
            return this;
        }

        /**
         * Required - Name of the target index.
         * <p>
         * API name: {@code index}
         * </p>
         */
        @Nonnull
        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        /**
         * If <code>true</code>, OpenSearch refreshes the affected shards to make this operation visible to search, if <code>wait_for</code>
         * then wait for a refresh to make this operation visible to search, if <code>false</code> do nothing with refreshes. Valid values:
         * <code>true</code>, <code>false</code>, <code>wait_for</code>.
         * <p>
         * API name: {@code refresh}
         * </p>
         */
        @Nonnull
        public final Builder refresh(@Nullable Refresh value) {
            this.refresh = value;
            return this;
        }

        /**
         * A custom value used to route operations to a specific shard.
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
         * A custom value used to route operations to a specific shard.
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
         * Period to wait for active shards.
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
         * Period to wait for active shards.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Explicit version number for concurrency control. The specified version must match the current version of the document for the
         * request to succeed.
         * <p>
         * API name: {@code version}
         * </p>
         */
        @Nonnull
        public final Builder version(@Nullable Long value) {
            this.version = value;
            return this;
        }

        /**
         * The specific version type: <code>external</code>, <code>external_gte</code>.
         * <p>
         * API name: {@code version_type}
         * </p>
         */
        @Nonnull
        public final Builder versionType(@Nullable VersionType value) {
            this.versionType = value;
            return this;
        }

        /**
         * The number of shard copies that must be active before proceeding with the operation. Set to <code>all</code> or any positive
         * integer up to the total number of shards in the index (<code>number_of_replicas+1</code>).
         * <p>
         * API name: {@code wait_for_active_shards}
         * </p>
         */
        @Nonnull
        public final Builder waitForActiveShards(@Nullable WaitForActiveShards value) {
            this.waitForActiveShards = value;
            return this;
        }

        /**
         * The number of shard copies that must be active before proceeding with the operation. Set to <code>all</code> or any positive
         * integer up to the total number of shards in the index (<code>number_of_replicas+1</code>).
         * <p>
         * API name: {@code wait_for_active_shards}
         * </p>
         */
        @Nonnull
        public final Builder waitForActiveShards(Function<WaitForActiveShards.Builder, ObjectBuilder<WaitForActiveShards>> fn) {
            return waitForActiveShards(fn.apply(new WaitForActiveShards.Builder()).build());
        }

        /**
         * Builds a {@link DeleteRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteRequest build() {
            _checkSingleUse();

            return new DeleteRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.ifPrimaryTerm != null) {
            params.put("if_primary_term", String.valueOf(this.ifPrimaryTerm));
        }
        if (this.ifSeqNo != null) {
            params.put("if_seq_no", String.valueOf(this.ifSeqNo));
        }
        if (this.refresh != null) {
            params.put("refresh", this.refresh.jsonValue());
        }
        if (ApiTypeHelper.isDefined(this.routing)) {
            params.put("routing", String.join(",", this.routing));
        }
        if (this.timeout != null) {
            params.put("timeout", this.timeout._toJsonString());
        }
        if (this.version != null) {
            params.put("version", String.valueOf(this.version));
        }
        if (this.versionType != null) {
            params.put("version_type", this.versionType.jsonValue());
        }
        if (this.waitForActiveShards != null) {
            params.put("wait_for_active_shards", this.waitForActiveShards._toJsonString());
        }
    }

    /**
     * Endpoint "{@code delete}".
     */
    public static final Endpoint<DeleteRequest, DeleteResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "DELETE",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/");
            SimpleEndpoint.pathEncode(request.index, buf);
            buf.append("/_doc/");
            SimpleEndpoint.pathEncode(request.id, buf);
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
        DeleteResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.id.hashCode();
        result = 31 * result + Objects.hashCode(this.ifPrimaryTerm);
        result = 31 * result + Objects.hashCode(this.ifSeqNo);
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Objects.hashCode(this.refresh);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.timeout);
        result = 31 * result + Objects.hashCode(this.version);
        result = 31 * result + Objects.hashCode(this.versionType);
        result = 31 * result + Objects.hashCode(this.waitForActiveShards);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeleteRequest other = (DeleteRequest) o;
        return this.id.equals(other.id)
            && Objects.equals(this.ifPrimaryTerm, other.ifPrimaryTerm)
            && Objects.equals(this.ifSeqNo, other.ifSeqNo)
            && this.index.equals(other.index)
            && Objects.equals(this.refresh, other.refresh)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.timeout, other.timeout)
            && Objects.equals(this.version, other.version)
            && Objects.equals(this.versionType, other.versionType)
            && Objects.equals(this.waitForActiveShards, other.waitForActiveShards);
    }
}
