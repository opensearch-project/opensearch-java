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
import java.util.stream.Collectors;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.Bytes;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.ExpandWildcard;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.TimeUnit;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cat.segment_replication.Request

/**
 * Returns information about active and last-completed segment replication events on each replica shard, including related shard-level
 * metrics. These metrics provide information about how far behind the primary shard the replicas are lagging.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class SegmentReplicationRequest extends CatRequestBase
    implements
        ToCopyableBuilder<SegmentReplicationRequest.Builder, SegmentReplicationRequest> {

    @Nullable
    private final Boolean activeOnly;

    @Nullable
    private final Boolean allowNoIndices;

    @Nullable
    private final Bytes bytes;

    @Nullable
    private final Boolean completedOnly;

    @Nullable
    private final Boolean detailed;

    @Nonnull
    private final List<ExpandWildcard> expandWildcards;

    @Nullable
    private final Boolean ignoreThrottled;

    @Nullable
    private final Boolean ignoreUnavailable;

    @Nonnull
    private final List<String> index;

    @Nonnull
    private final List<String> shards;

    @Nullable
    private final TimeUnit time;

    @Nullable
    private final Time timeout;

    // ---------------------------------------------------------------------------------------------

    private SegmentReplicationRequest(Builder builder) {
        super(builder);
        this.activeOnly = builder.activeOnly;
        this.allowNoIndices = builder.allowNoIndices;
        this.bytes = builder.bytes;
        this.completedOnly = builder.completedOnly;
        this.detailed = builder.detailed;
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.ignoreThrottled = builder.ignoreThrottled;
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.index = ApiTypeHelper.unmodifiable(builder.index);
        this.shards = ApiTypeHelper.unmodifiable(builder.shards);
        this.time = builder.time;
        this.timeout = builder.timeout;
    }

    public static SegmentReplicationRequest of(Function<SegmentReplicationRequest.Builder, ObjectBuilder<SegmentReplicationRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * When <code>true</code>, the response only includes ongoing segment replication events.
     * <p>
     * API name: {@code active_only}
     * </p>
     */
    @Nullable
    public final Boolean activeOnly() {
        return this.activeOnly;
    }

    /**
     * Whether to ignore the index if a wildcard index expression resolves to no concrete indexes. This includes the <code>_all</code>
     * string or when no indexes have been specified.
     * <p>
     * API name: {@code allow_no_indices}
     * </p>
     */
    @Nullable
    public final Boolean allowNoIndices() {
        return this.allowNoIndices;
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
     * When <code>true</code>, the response only includes the last-completed segment replication events.
     * <p>
     * API name: {@code completed_only}
     * </p>
     */
    @Nullable
    public final Boolean completedOnly() {
        return this.completedOnly;
    }

    /**
     * When <code>true</code>, the response includes additional metrics for each stage of a segment replication event.
     * <p>
     * API name: {@code detailed}
     * </p>
     */
    @Nullable
    public final Boolean detailed() {
        return this.detailed;
    }

    /**
     * Whether to expand the wildcard expression to include concrete indexes that are open, closed, or both.
     * <p>
     * API name: {@code expand_wildcards}
     * </p>
     */
    @Nonnull
    public final List<ExpandWildcard> expandWildcards() {
        return this.expandWildcards;
    }

    /**
     * Whether specified concrete, expanded, or aliased indexes should be ignored when throttled.
     * <p>
     * API name: {@code ignore_throttled}
     * </p>
     */
    @Nullable
    public final Boolean ignoreThrottled() {
        return this.ignoreThrottled;
    }

    /**
     * Whether the specified concrete indexes should be ignored when missing or closed.
     * <p>
     * API name: {@code ignore_unavailable}
     * </p>
     */
    @Nullable
    public final Boolean ignoreUnavailable() {
        return this.ignoreUnavailable;
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
     * A comma-separated list of shards to display.
     * <p>
     * API name: {@code shards}
     * </p>
     */
    @Nonnull
    public final List<String> shards() {
        return this.shards;
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

    /**
     * The operation timeout.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final Time timeout() {
        return this.timeout;
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
     * Builder for {@link SegmentReplicationRequest}.
     */
    public static class Builder extends CatRequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, SegmentReplicationRequest> {
        @Nullable
        private Boolean activeOnly;
        @Nullable
        private Boolean allowNoIndices;
        @Nullable
        private Bytes bytes;
        @Nullable
        private Boolean completedOnly;
        @Nullable
        private Boolean detailed;
        @Nullable
        private List<ExpandWildcard> expandWildcards;
        @Nullable
        private Boolean ignoreThrottled;
        @Nullable
        private Boolean ignoreUnavailable;
        @Nullable
        private List<String> index;
        @Nullable
        private List<String> shards;
        @Nullable
        private TimeUnit time;
        @Nullable
        private Time timeout;

        public Builder() {}

        private Builder(SegmentReplicationRequest o) {
            super(o);
            this.activeOnly = o.activeOnly;
            this.allowNoIndices = o.allowNoIndices;
            this.bytes = o.bytes;
            this.completedOnly = o.completedOnly;
            this.detailed = o.detailed;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.ignoreThrottled = o.ignoreThrottled;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.shards = _listCopy(o.shards);
            this.time = o.time;
            this.timeout = o.timeout;
        }

        private Builder(Builder o) {
            super(o);
            this.activeOnly = o.activeOnly;
            this.allowNoIndices = o.allowNoIndices;
            this.bytes = o.bytes;
            this.completedOnly = o.completedOnly;
            this.detailed = o.detailed;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.ignoreThrottled = o.ignoreThrottled;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.shards = _listCopy(o.shards);
            this.time = o.time;
            this.timeout = o.timeout;
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
         * When <code>true</code>, the response only includes ongoing segment replication events.
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
         * Whether to ignore the index if a wildcard index expression resolves to no concrete indexes. This includes the <code>_all</code>
         * string or when no indexes have been specified.
         * <p>
         * API name: {@code allow_no_indices}
         * </p>
         */
        @Nonnull
        public final Builder allowNoIndices(@Nullable Boolean value) {
            this.allowNoIndices = value;
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
         * When <code>true</code>, the response only includes the last-completed segment replication events.
         * <p>
         * API name: {@code completed_only}
         * </p>
         */
        @Nonnull
        public final Builder completedOnly(@Nullable Boolean value) {
            this.completedOnly = value;
            return this;
        }

        /**
         * When <code>true</code>, the response includes additional metrics for each stage of a segment replication event.
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
         * Whether to expand the wildcard expression to include concrete indexes that are open, closed, or both.
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
         * Whether to expand the wildcard expression to include concrete indexes that are open, closed, or both.
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
         * Whether specified concrete, expanded, or aliased indexes should be ignored when throttled.
         * <p>
         * API name: {@code ignore_throttled}
         * </p>
         */
        @Nonnull
        public final Builder ignoreThrottled(@Nullable Boolean value) {
            this.ignoreThrottled = value;
            return this;
        }

        /**
         * Whether the specified concrete indexes should be ignored when missing or closed.
         * <p>
         * API name: {@code ignore_unavailable}
         * </p>
         */
        @Nonnull
        public final Builder ignoreUnavailable(@Nullable Boolean value) {
            this.ignoreUnavailable = value;
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
         * A comma-separated list of shards to display.
         * <p>
         * API name: {@code shards}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(List<String> list) {
            this.shards = _listAddAll(this.shards, list);
            return this;
        }

        /**
         * A comma-separated list of shards to display.
         * <p>
         * API name: {@code shards}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(String value, String... values) {
            this.shards = _listAdd(this.shards, value, values);
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
         * The operation timeout.
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
         * The operation timeout.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link SegmentReplicationRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SegmentReplicationRequest build() {
            _checkSingleUse();

            return new SegmentReplicationRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.activeOnly != null) {
            params.put("active_only", String.valueOf(this.activeOnly));
        }
        if (this.allowNoIndices != null) {
            params.put("allow_no_indices", String.valueOf(this.allowNoIndices));
        }
        if (this.bytes != null) {
            params.put("bytes", this.bytes.jsonValue());
        }
        if (this.completedOnly != null) {
            params.put("completed_only", String.valueOf(this.completedOnly));
        }
        if (this.detailed != null) {
            params.put("detailed", String.valueOf(this.detailed));
        }
        if (ApiTypeHelper.isDefined(this.expandWildcards)) {
            params.put("expand_wildcards", this.expandWildcards.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")));
        }
        if (this.ignoreThrottled != null) {
            params.put("ignore_throttled", String.valueOf(this.ignoreThrottled));
        }
        if (this.ignoreUnavailable != null) {
            params.put("ignore_unavailable", String.valueOf(this.ignoreUnavailable));
        }
        if (ApiTypeHelper.isDefined(this.shards)) {
            params.put("shards", String.join(",", this.shards));
        }
        if (this.time != null) {
            params.put("time", this.time.jsonValue());
        }
        if (this.timeout != null) {
            params.put("timeout", this.timeout._toJsonString());
        }
    }

    /**
     * Endpoint "{@code cat.segment_replication}".
     */
    public static final Endpoint<SegmentReplicationRequest, SegmentReplicationResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _index = 1 << 0;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.index())) propsSet |= _index;

            if (propsSet == 0) {
                return "/_cat/segment_replication";
            }
            if (propsSet == (_index)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_cat/segment_replication/");
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
        SegmentReplicationResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.activeOnly);
        result = 31 * result + Objects.hashCode(this.allowNoIndices);
        result = 31 * result + Objects.hashCode(this.bytes);
        result = 31 * result + Objects.hashCode(this.completedOnly);
        result = 31 * result + Objects.hashCode(this.detailed);
        result = 31 * result + Objects.hashCode(this.expandWildcards);
        result = 31 * result + Objects.hashCode(this.ignoreThrottled);
        result = 31 * result + Objects.hashCode(this.ignoreUnavailable);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.shards);
        result = 31 * result + Objects.hashCode(this.time);
        result = 31 * result + Objects.hashCode(this.timeout);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SegmentReplicationRequest other = (SegmentReplicationRequest) o;
        return Objects.equals(this.activeOnly, other.activeOnly)
            && Objects.equals(this.allowNoIndices, other.allowNoIndices)
            && Objects.equals(this.bytes, other.bytes)
            && Objects.equals(this.completedOnly, other.completedOnly)
            && Objects.equals(this.detailed, other.detailed)
            && Objects.equals(this.expandWildcards, other.expandWildcards)
            && Objects.equals(this.ignoreThrottled, other.ignoreThrottled)
            && Objects.equals(this.ignoreUnavailable, other.ignoreUnavailable)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.shards, other.shards)
            && Objects.equals(this.time, other.time)
            && Objects.equals(this.timeout, other.timeout);
    }
}
