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

package org.opensearch.client.opensearch.nodes;

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
import org.opensearch.client.opensearch._types.Level;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch.nodes.stats.NodesStatsIndexMetric;
import org.opensearch.client.opensearch.nodes.stats.NodesStatsMetric;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.Request

/**
 * Returns statistical information about nodes in the cluster.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class NodesStatsRequest extends RequestBase implements ToCopyableBuilder<NodesStatsRequest.Builder, NodesStatsRequest> {

    @Nonnull
    private final List<String> completionFields;

    @Nonnull
    private final List<String> fielddataFields;

    @Nonnull
    private final List<String> fields;

    @Nonnull
    private final List<String> groups;

    @Nullable
    private final Boolean includeSegmentFileSizes;

    @Nonnull
    private final List<NodesStatsIndexMetric> indexMetric;

    @Nullable
    private final Level level;

    @Nonnull
    private final List<NodesStatsMetric> metric;

    @Nonnull
    private final List<String> nodeId;

    @Nullable
    private final Time timeout;

    @Nonnull
    private final List<String> types;

    // ---------------------------------------------------------------------------------------------

    private NodesStatsRequest(Builder builder) {
        super(builder);
        this.completionFields = ApiTypeHelper.unmodifiable(builder.completionFields);
        this.fielddataFields = ApiTypeHelper.unmodifiable(builder.fielddataFields);
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.groups = ApiTypeHelper.unmodifiable(builder.groups);
        this.includeSegmentFileSizes = builder.includeSegmentFileSizes;
        this.indexMetric = ApiTypeHelper.unmodifiable(builder.indexMetric);
        this.level = builder.level;
        this.metric = ApiTypeHelper.unmodifiable(builder.metric);
        this.nodeId = ApiTypeHelper.unmodifiable(builder.nodeId);
        this.timeout = builder.timeout;
        this.types = ApiTypeHelper.unmodifiable(builder.types);
    }

    public static NodesStatsRequest of(Function<NodesStatsRequest.Builder, ObjectBuilder<NodesStatsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * A comma-separated list or wildcard expressions of fields to include in field data and suggest statistics.
     * <p>
     * API name: {@code completion_fields}
     * </p>
     */
    @Nonnull
    public final List<String> completionFields() {
        return this.completionFields;
    }

    /**
     * A comma-separated list or wildcard expressions of fields to include in field data statistics.
     * <p>
     * API name: {@code fielddata_fields}
     * </p>
     */
    @Nonnull
    public final List<String> fielddataFields() {
        return this.fielddataFields;
    }

    /**
     * A comma-separated list or wildcard expressions of fields to include in the statistics.
     * <p>
     * API name: {@code fields}
     * </p>
     */
    @Nonnull
    public final List<String> fields() {
        return this.fields;
    }

    /**
     * A comma-separated list of search groups to include in the search statistics.
     * <p>
     * API name: {@code groups}
     * </p>
     */
    @Nonnull
    public final List<String> groups() {
        return this.groups;
    }

    /**
     * When <code>true</code>, reports the aggregated disk usage of each one of the Lucene index files (only applies if segment stats are
     * requested).
     * <p>
     * API name: {@code include_segment_file_sizes}
     * </p>
     */
    @Nullable
    public final Boolean includeSegmentFileSizes() {
        return this.includeSegmentFileSizes;
    }

    /**
     * Limit the information returned for indexes metric to the specified index metrics. It can be used only if indexes (or all) metric is
     * specified.
     * <p>
     * API name: {@code index_metric}
     * </p>
     */
    @Nonnull
    public final List<NodesStatsIndexMetric> indexMetric() {
        return this.indexMetric;
    }

    /**
     * Indicates whether statistics are aggregated at the cluster, index, or shard level.
     * <p>
     * API name: {@code level}
     * </p>
     */
    @Nullable
    public final Level level() {
        return this.level;
    }

    /**
     * Limit the information returned to the specified metrics.
     * <p>
     * API name: {@code metric}
     * </p>
     */
    @Nonnull
    public final List<NodesStatsMetric> metric() {
        return this.metric;
    }

    /**
     * A comma-separated list of node IDs or names used to limit returned information.
     * <p>
     * API name: {@code node_id}
     * </p>
     */
    @Nonnull
    public final List<String> nodeId() {
        return this.nodeId;
    }

    /**
     * The amount of time to wait for a response. If no response is received before the timeout expires, the request fails and returns an
     * error.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final Time timeout() {
        return this.timeout;
    }

    /**
     * A comma-separated list of document types for the indexing index metric.
     * <p>
     * API name: {@code types}
     * </p>
     */
    @Nonnull
    public final List<String> types() {
        return this.types;
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
     * Builder for {@link NodesStatsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, NodesStatsRequest> {
        @Nullable
        private List<String> completionFields;
        @Nullable
        private List<String> fielddataFields;
        @Nullable
        private List<String> fields;
        @Nullable
        private List<String> groups;
        @Nullable
        private Boolean includeSegmentFileSizes;
        @Nullable
        private List<NodesStatsIndexMetric> indexMetric;
        @Nullable
        private Level level;
        @Nullable
        private List<NodesStatsMetric> metric;
        @Nullable
        private List<String> nodeId;
        @Nullable
        private Time timeout;
        @Nullable
        private List<String> types;

        public Builder() {}

        private Builder(NodesStatsRequest o) {
            super(o);
            this.completionFields = _listCopy(o.completionFields);
            this.fielddataFields = _listCopy(o.fielddataFields);
            this.fields = _listCopy(o.fields);
            this.groups = _listCopy(o.groups);
            this.includeSegmentFileSizes = o.includeSegmentFileSizes;
            this.indexMetric = _listCopy(o.indexMetric);
            this.level = o.level;
            this.metric = _listCopy(o.metric);
            this.nodeId = _listCopy(o.nodeId);
            this.timeout = o.timeout;
            this.types = _listCopy(o.types);
        }

        private Builder(Builder o) {
            super(o);
            this.completionFields = _listCopy(o.completionFields);
            this.fielddataFields = _listCopy(o.fielddataFields);
            this.fields = _listCopy(o.fields);
            this.groups = _listCopy(o.groups);
            this.includeSegmentFileSizes = o.includeSegmentFileSizes;
            this.indexMetric = _listCopy(o.indexMetric);
            this.level = o.level;
            this.metric = _listCopy(o.metric);
            this.nodeId = _listCopy(o.nodeId);
            this.timeout = o.timeout;
            this.types = _listCopy(o.types);
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
         * A comma-separated list or wildcard expressions of fields to include in field data and suggest statistics.
         * <p>
         * API name: {@code completion_fields}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>completionFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder completionFields(List<String> list) {
            this.completionFields = _listAddAll(this.completionFields, list);
            return this;
        }

        /**
         * A comma-separated list or wildcard expressions of fields to include in field data and suggest statistics.
         * <p>
         * API name: {@code completion_fields}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>completionFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder completionFields(String value, String... values) {
            this.completionFields = _listAdd(this.completionFields, value, values);
            return this;
        }

        /**
         * A comma-separated list or wildcard expressions of fields to include in field data statistics.
         * <p>
         * API name: {@code fielddata_fields}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>fielddataFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fielddataFields(List<String> list) {
            this.fielddataFields = _listAddAll(this.fielddataFields, list);
            return this;
        }

        /**
         * A comma-separated list or wildcard expressions of fields to include in field data statistics.
         * <p>
         * API name: {@code fielddata_fields}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>fielddataFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fielddataFields(String value, String... values) {
            this.fielddataFields = _listAdd(this.fielddataFields, value, values);
            return this;
        }

        /**
         * A comma-separated list or wildcard expressions of fields to include in the statistics.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(List<String> list) {
            this.fields = _listAddAll(this.fields, list);
            return this;
        }

        /**
         * A comma-separated list or wildcard expressions of fields to include in the statistics.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(String value, String... values) {
            this.fields = _listAdd(this.fields, value, values);
            return this;
        }

        /**
         * A comma-separated list of search groups to include in the search statistics.
         * <p>
         * API name: {@code groups}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>groups</code>.
         * </p>
         */
        @Nonnull
        public final Builder groups(List<String> list) {
            this.groups = _listAddAll(this.groups, list);
            return this;
        }

        /**
         * A comma-separated list of search groups to include in the search statistics.
         * <p>
         * API name: {@code groups}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>groups</code>.
         * </p>
         */
        @Nonnull
        public final Builder groups(String value, String... values) {
            this.groups = _listAdd(this.groups, value, values);
            return this;
        }

        /**
         * When <code>true</code>, reports the aggregated disk usage of each one of the Lucene index files (only applies if segment stats
         * are requested).
         * <p>
         * API name: {@code include_segment_file_sizes}
         * </p>
         */
        @Nonnull
        public final Builder includeSegmentFileSizes(@Nullable Boolean value) {
            this.includeSegmentFileSizes = value;
            return this;
        }

        /**
         * Limit the information returned for indexes metric to the specified index metrics. It can be used only if indexes (or all) metric
         * is specified.
         * <p>
         * API name: {@code index_metric}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>indexMetric</code>.
         * </p>
         */
        @Nonnull
        public final Builder indexMetric(List<NodesStatsIndexMetric> list) {
            this.indexMetric = _listAddAll(this.indexMetric, list);
            return this;
        }

        /**
         * Limit the information returned for indexes metric to the specified index metrics. It can be used only if indexes (or all) metric
         * is specified.
         * <p>
         * API name: {@code index_metric}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>indexMetric</code>.
         * </p>
         */
        @Nonnull
        public final Builder indexMetric(NodesStatsIndexMetric value, NodesStatsIndexMetric... values) {
            this.indexMetric = _listAdd(this.indexMetric, value, values);
            return this;
        }

        /**
         * Indicates whether statistics are aggregated at the cluster, index, or shard level.
         * <p>
         * API name: {@code level}
         * </p>
         */
        @Nonnull
        public final Builder level(@Nullable Level value) {
            this.level = value;
            return this;
        }

        /**
         * Limit the information returned to the specified metrics.
         * <p>
         * API name: {@code metric}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>metric</code>.
         * </p>
         */
        @Nonnull
        public final Builder metric(List<NodesStatsMetric> list) {
            this.metric = _listAddAll(this.metric, list);
            return this;
        }

        /**
         * Limit the information returned to the specified metrics.
         * <p>
         * API name: {@code metric}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>metric</code>.
         * </p>
         */
        @Nonnull
        public final Builder metric(NodesStatsMetric value, NodesStatsMetric... values) {
            this.metric = _listAdd(this.metric, value, values);
            return this;
        }

        /**
         * A comma-separated list of node IDs or names used to limit returned information.
         * <p>
         * API name: {@code node_id}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>nodeId</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodeId(List<String> list) {
            this.nodeId = _listAddAll(this.nodeId, list);
            return this;
        }

        /**
         * A comma-separated list of node IDs or names used to limit returned information.
         * <p>
         * API name: {@code node_id}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>nodeId</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodeId(String value, String... values) {
            this.nodeId = _listAdd(this.nodeId, value, values);
            return this;
        }

        /**
         * The amount of time to wait for a response. If no response is received before the timeout expires, the request fails and returns
         * an error.
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
         * The amount of time to wait for a response. If no response is received before the timeout expires, the request fails and returns
         * an error.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * A comma-separated list of document types for the indexing index metric.
         * <p>
         * API name: {@code types}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>types</code>.
         * </p>
         */
        @Nonnull
        public final Builder types(List<String> list) {
            this.types = _listAddAll(this.types, list);
            return this;
        }

        /**
         * A comma-separated list of document types for the indexing index metric.
         * <p>
         * API name: {@code types}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>types</code>.
         * </p>
         */
        @Nonnull
        public final Builder types(String value, String... values) {
            this.types = _listAdd(this.types, value, values);
            return this;
        }

        /**
         * Builds a {@link NodesStatsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodesStatsRequest build() {
            _checkSingleUse();

            return new NodesStatsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (ApiTypeHelper.isDefined(this.completionFields)) {
            params.put("completion_fields", String.join(",", this.completionFields));
        }
        if (ApiTypeHelper.isDefined(this.fielddataFields)) {
            params.put("fielddata_fields", String.join(",", this.fielddataFields));
        }
        if (ApiTypeHelper.isDefined(this.fields)) {
            params.put("fields", String.join(",", this.fields));
        }
        if (ApiTypeHelper.isDefined(this.groups)) {
            params.put("groups", String.join(",", this.groups));
        }
        if (this.includeSegmentFileSizes != null) {
            params.put("include_segment_file_sizes", String.valueOf(this.includeSegmentFileSizes));
        }
        if (this.level != null) {
            params.put("level", this.level.jsonValue());
        }
        if (this.timeout != null) {
            params.put("timeout", this.timeout._toJsonString());
        }
        if (ApiTypeHelper.isDefined(this.types)) {
            params.put("types", String.join(",", this.types));
        }
    }

    /**
     * Endpoint "{@code nodes.stats}".
     */
    public static final Endpoint<NodesStatsRequest, NodesStatsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _indexMetric = 1 << 0;
            final int _metric = 1 << 1;
            final int _nodeId = 1 << 2;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.indexMetric())) propsSet |= _indexMetric;
            if (ApiTypeHelper.isDefined(request.metric())) propsSet |= _metric;
            if (ApiTypeHelper.isDefined(request.nodeId())) propsSet |= _nodeId;

            if (propsSet == 0) {
                return "/_nodes/stats";
            }
            if (propsSet == (_metric)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_nodes/stats/");
                SimpleEndpoint.pathEncode(request.metric.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")), buf);
                return buf.toString();
            }
            if (propsSet == (_metric | _indexMetric)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_nodes/stats/");
                SimpleEndpoint.pathEncode(request.metric.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")), buf);
                buf.append("/");
                SimpleEndpoint.pathEncode(request.indexMetric.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")), buf);
                return buf.toString();
            }
            if (propsSet == (_nodeId)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_nodes/");
                SimpleEndpoint.pathEncode(String.join(",", request.nodeId), buf);
                buf.append("/stats");
                return buf.toString();
            }
            if (propsSet == (_nodeId | _metric)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_nodes/");
                SimpleEndpoint.pathEncode(String.join(",", request.nodeId), buf);
                buf.append("/stats/");
                SimpleEndpoint.pathEncode(request.metric.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")), buf);
                return buf.toString();
            }
            if (propsSet == (_nodeId | _metric | _indexMetric)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_nodes/");
                SimpleEndpoint.pathEncode(String.join(",", request.nodeId), buf);
                buf.append("/stats/");
                SimpleEndpoint.pathEncode(request.metric.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")), buf);
                buf.append("/");
                SimpleEndpoint.pathEncode(request.indexMetric.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")), buf);
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
        NodesStatsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.completionFields);
        result = 31 * result + Objects.hashCode(this.fielddataFields);
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Objects.hashCode(this.groups);
        result = 31 * result + Objects.hashCode(this.includeSegmentFileSizes);
        result = 31 * result + Objects.hashCode(this.indexMetric);
        result = 31 * result + Objects.hashCode(this.level);
        result = 31 * result + Objects.hashCode(this.metric);
        result = 31 * result + Objects.hashCode(this.nodeId);
        result = 31 * result + Objects.hashCode(this.timeout);
        result = 31 * result + Objects.hashCode(this.types);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodesStatsRequest other = (NodesStatsRequest) o;
        return Objects.equals(this.completionFields, other.completionFields)
            && Objects.equals(this.fielddataFields, other.fielddataFields)
            && Objects.equals(this.fields, other.fields)
            && Objects.equals(this.groups, other.groups)
            && Objects.equals(this.includeSegmentFileSizes, other.includeSegmentFileSizes)
            && Objects.equals(this.indexMetric, other.indexMetric)
            && Objects.equals(this.level, other.level)
            && Objects.equals(this.metric, other.metric)
            && Objects.equals(this.nodeId, other.nodeId)
            && Objects.equals(this.timeout, other.timeout)
            && Objects.equals(this.types, other.types);
    }
}
