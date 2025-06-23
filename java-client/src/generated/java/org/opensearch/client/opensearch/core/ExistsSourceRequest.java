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
import org.opensearch.client.opensearch._types.VersionType;
import org.opensearch.client.opensearch.core.search.SourceConfigParam;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.BooleanEndpoint;
import org.opensearch.client.transport.endpoints.BooleanResponse;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.exists_source.Request

/**
 * Returns information about whether a document source exists in an index.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class ExistsSourceRequest extends RequestBase implements ToCopyableBuilder<ExistsSourceRequest.Builder, ExistsSourceRequest> {

    @Nonnull
    private final String id;

    @Nonnull
    private final String index;

    @Nullable
    private final String preference;

    @Nullable
    private final Boolean realtime;

    @Nullable
    private final Refresh refresh;

    @Nonnull
    private final List<String> routing;

    @Nullable
    private final SourceConfigParam source;

    @Nonnull
    private final List<String> sourceExcludes;

    @Nonnull
    private final List<String> sourceIncludes;

    @Nullable
    private final Long version;

    @Nullable
    private final VersionType versionType;

    // ---------------------------------------------------------------------------------------------

    private ExistsSourceRequest(Builder builder) {
        super(builder);
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.preference = builder.preference;
        this.realtime = builder.realtime;
        this.refresh = builder.refresh;
        this.routing = ApiTypeHelper.unmodifiable(builder.routing);
        this.source = builder.source;
        this.sourceExcludes = ApiTypeHelper.unmodifiable(builder.sourceExcludes);
        this.sourceIncludes = ApiTypeHelper.unmodifiable(builder.sourceIncludes);
        this.version = builder.version;
        this.versionType = builder.versionType;
    }

    public static ExistsSourceRequest of(Function<ExistsSourceRequest.Builder, ObjectBuilder<ExistsSourceRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Identifier of the document.
     * <p>
     * API name: {@code id}
     * </p>
     */
    @Nonnull
    public final String id() {
        return this.id;
    }

    /**
     * Required - A comma-separated list of data streams, indexes, and aliases. Supports wildcards (<code>*</code>).
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final String index() {
        return this.index;
    }

    /**
     * Specifies the node or shard the operation should be performed on. Random by default.
     * <p>
     * API name: {@code preference}
     * </p>
     */
    @Nullable
    public final String preference() {
        return this.preference;
    }

    /**
     * If <code>true</code>, the request is real-time as opposed to near-real-time.
     * <p>
     * API name: {@code realtime}
     * </p>
     */
    @Nullable
    public final Boolean realtime() {
        return this.realtime;
    }

    /**
     * If <code>true</code>, OpenSearch refreshes all shards involved in the delete by query after the request completes.
     * <p>
     * API name: {@code refresh}
     * </p>
     */
    @Nullable
    public final Refresh refresh() {
        return this.refresh;
    }

    /**
     * Target the specified primary shard.
     * <p>
     * API name: {@code routing}
     * </p>
     */
    @Nonnull
    public final List<String> routing() {
        return this.routing;
    }

    /**
     * <code>true</code> or <code>false</code> to return the <code>_source</code> field or not, or a list of fields to return.
     * <p>
     * API name: {@code _source}
     * </p>
     */
    @Nullable
    public final SourceConfigParam source() {
        return this.source;
    }

    /**
     * A comma-separated list of source fields to exclude in the response.
     * <p>
     * API name: {@code _source_excludes}
     * </p>
     */
    @Nonnull
    public final List<String> sourceExcludes() {
        return this.sourceExcludes;
    }

    /**
     * A comma-separated list of source fields to include in the response.
     * <p>
     * API name: {@code _source_includes}
     * </p>
     */
    @Nonnull
    public final List<String> sourceIncludes() {
        return this.sourceIncludes;
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
     * Builder for {@link ExistsSourceRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ExistsSourceRequest> {
        private String id;
        private String index;
        @Nullable
        private String preference;
        @Nullable
        private Boolean realtime;
        @Nullable
        private Refresh refresh;
        @Nullable
        private List<String> routing;
        @Nullable
        private SourceConfigParam source;
        @Nullable
        private List<String> sourceExcludes;
        @Nullable
        private List<String> sourceIncludes;
        @Nullable
        private Long version;
        @Nullable
        private VersionType versionType;

        public Builder() {}

        private Builder(ExistsSourceRequest o) {
            super(o);
            this.id = o.id;
            this.index = o.index;
            this.preference = o.preference;
            this.realtime = o.realtime;
            this.refresh = o.refresh;
            this.routing = _listCopy(o.routing);
            this.source = o.source;
            this.sourceExcludes = _listCopy(o.sourceExcludes);
            this.sourceIncludes = _listCopy(o.sourceIncludes);
            this.version = o.version;
            this.versionType = o.versionType;
        }

        private Builder(Builder o) {
            super(o);
            this.id = o.id;
            this.index = o.index;
            this.preference = o.preference;
            this.realtime = o.realtime;
            this.refresh = o.refresh;
            this.routing = _listCopy(o.routing);
            this.source = o.source;
            this.sourceExcludes = _listCopy(o.sourceExcludes);
            this.sourceIncludes = _listCopy(o.sourceIncludes);
            this.version = o.version;
            this.versionType = o.versionType;
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
         * Required - Identifier of the document.
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
         * Required - A comma-separated list of data streams, indexes, and aliases. Supports wildcards (<code>*</code>).
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
         * Specifies the node or shard the operation should be performed on. Random by default.
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
         * If <code>true</code>, the request is real-time as opposed to near-real-time.
         * <p>
         * API name: {@code realtime}
         * </p>
         */
        @Nonnull
        public final Builder realtime(@Nullable Boolean value) {
            this.realtime = value;
            return this;
        }

        /**
         * If <code>true</code>, OpenSearch refreshes all shards involved in the delete by query after the request completes.
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
         * Target the specified primary shard.
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
         * Target the specified primary shard.
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
         * <code>true</code> or <code>false</code> to return the <code>_source</code> field or not, or a list of fields to return.
         * <p>
         * API name: {@code _source}
         * </p>
         */
        @Nonnull
        public final Builder source(@Nullable SourceConfigParam value) {
            this.source = value;
            return this;
        }

        /**
         * <code>true</code> or <code>false</code> to return the <code>_source</code> field or not, or a list of fields to return.
         * <p>
         * API name: {@code _source}
         * </p>
         */
        @Nonnull
        public final Builder source(Function<SourceConfigParam.Builder, ObjectBuilder<SourceConfigParam>> fn) {
            return source(fn.apply(new SourceConfigParam.Builder()).build());
        }

        /**
         * A comma-separated list of source fields to exclude in the response.
         * <p>
         * API name: {@code _source_excludes}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>sourceExcludes</code>.
         * </p>
         */
        @Nonnull
        public final Builder sourceExcludes(List<String> list) {
            this.sourceExcludes = _listAddAll(this.sourceExcludes, list);
            return this;
        }

        /**
         * A comma-separated list of source fields to exclude in the response.
         * <p>
         * API name: {@code _source_excludes}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>sourceExcludes</code>.
         * </p>
         */
        @Nonnull
        public final Builder sourceExcludes(String value, String... values) {
            this.sourceExcludes = _listAdd(this.sourceExcludes, value, values);
            return this;
        }

        /**
         * A comma-separated list of source fields to include in the response.
         * <p>
         * API name: {@code _source_includes}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>sourceIncludes</code>.
         * </p>
         */
        @Nonnull
        public final Builder sourceIncludes(List<String> list) {
            this.sourceIncludes = _listAddAll(this.sourceIncludes, list);
            return this;
        }

        /**
         * A comma-separated list of source fields to include in the response.
         * <p>
         * API name: {@code _source_includes}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>sourceIncludes</code>.
         * </p>
         */
        @Nonnull
        public final Builder sourceIncludes(String value, String... values) {
            this.sourceIncludes = _listAdd(this.sourceIncludes, value, values);
            return this;
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
         * Builds a {@link ExistsSourceRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExistsSourceRequest build() {
            _checkSingleUse();

            return new ExistsSourceRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.preference != null) {
            params.put("preference", this.preference);
        }
        if (this.realtime != null) {
            params.put("realtime", String.valueOf(this.realtime));
        }
        if (this.refresh != null) {
            params.put("refresh", this.refresh.jsonValue());
        }
        if (ApiTypeHelper.isDefined(this.routing)) {
            params.put("routing", String.join(",", this.routing));
        }
        if (this.source != null) {
            params.put("_source", this.source._toJsonString());
        }
        if (ApiTypeHelper.isDefined(this.sourceExcludes)) {
            params.put("_source_excludes", String.join(",", this.sourceExcludes));
        }
        if (ApiTypeHelper.isDefined(this.sourceIncludes)) {
            params.put("_source_includes", String.join(",", this.sourceIncludes));
        }
        if (this.version != null) {
            params.put("version", String.valueOf(this.version));
        }
        if (this.versionType != null) {
            params.put("version_type", this.versionType.jsonValue());
        }
    }

    /**
     * Endpoint "{@code exists_source}".
     */
    public static final Endpoint<ExistsSourceRequest, BooleanResponse, ErrorResponse> _ENDPOINT = new BooleanEndpoint<>(
        // Request method
        request -> "HEAD",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/");
            SimpleEndpoint.pathEncode(request.index, buf);
            buf.append("/_source/");
            SimpleEndpoint.pathEncode(request.id, buf);
            return buf.toString();
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap()
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.id.hashCode();
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Objects.hashCode(this.preference);
        result = 31 * result + Objects.hashCode(this.realtime);
        result = 31 * result + Objects.hashCode(this.refresh);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.source);
        result = 31 * result + Objects.hashCode(this.sourceExcludes);
        result = 31 * result + Objects.hashCode(this.sourceIncludes);
        result = 31 * result + Objects.hashCode(this.version);
        result = 31 * result + Objects.hashCode(this.versionType);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExistsSourceRequest other = (ExistsSourceRequest) o;
        return this.id.equals(other.id)
            && this.index.equals(other.index)
            && Objects.equals(this.preference, other.preference)
            && Objects.equals(this.realtime, other.realtime)
            && Objects.equals(this.refresh, other.refresh)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.source, other.source)
            && Objects.equals(this.sourceExcludes, other.sourceExcludes)
            && Objects.equals(this.sourceIncludes, other.sourceIncludes)
            && Objects.equals(this.version, other.version)
            && Objects.equals(this.versionType, other.versionType);
    }
}
