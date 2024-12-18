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
import java.util.stream.Collectors;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.ExpandWildcard;
import org.opensearch.client.opensearch._types.Level;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch.indices.stats.IndicesStatsMetric;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.stats.Request

/**
 * Provides statistics on operations happening in an index.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndicesStatsRequest extends RequestBase implements ToCopyableBuilder<IndicesStatsRequest.Builder, IndicesStatsRequest> {

    @Nonnull
    private final List<String> completionFields;

    @Nonnull
    private final List<ExpandWildcard> expandWildcards;

    @Nonnull
    private final List<String> fielddataFields;

    @Nonnull
    private final List<String> fields;

    @Nullable
    private final Boolean forbidClosedIndices;

    @Nonnull
    private final List<String> groups;

    @Nullable
    private final Boolean includeSegmentFileSizes;

    @Nullable
    private final Boolean includeUnloadedSegments;

    @Nonnull
    private final List<String> index;

    @Nullable
    private final Level level;

    @Nonnull
    private final List<IndicesStatsMetric> metric;

    // ---------------------------------------------------------------------------------------------

    private IndicesStatsRequest(Builder builder) {
        this.completionFields = ApiTypeHelper.unmodifiable(builder.completionFields);
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.fielddataFields = ApiTypeHelper.unmodifiable(builder.fielddataFields);
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.forbidClosedIndices = builder.forbidClosedIndices;
        this.groups = ApiTypeHelper.unmodifiable(builder.groups);
        this.includeSegmentFileSizes = builder.includeSegmentFileSizes;
        this.includeUnloadedSegments = builder.includeUnloadedSegments;
        this.index = ApiTypeHelper.unmodifiable(builder.index);
        this.level = builder.level;
        this.metric = ApiTypeHelper.unmodifiable(builder.metric);
    }

    public static IndicesStatsRequest of(Function<IndicesStatsRequest.Builder, ObjectBuilder<IndicesStatsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Comma-separated list or wildcard expressions of fields to include in field data and suggest statistics.
     * <p>
     * API name: {@code completion_fields}
     * </p>
     */
    @Nonnull
    public final List<String> completionFields() {
        return this.completionFields;
    }

    /**
     * Type of index that wildcard patterns can match. If the request can target data streams, this argument determines whether wildcard
     * expressions match hidden data streams. Supports comma-separated values, such as <code>open,hidden</code>.
     * <p>
     * API name: {@code expand_wildcards}
     * </p>
     */
    @Nonnull
    public final List<ExpandWildcard> expandWildcards() {
        return this.expandWildcards;
    }

    /**
     * Comma-separated list or wildcard expressions of fields to include in field data statistics.
     * <p>
     * API name: {@code fielddata_fields}
     * </p>
     */
    @Nonnull
    public final List<String> fielddataFields() {
        return this.fielddataFields;
    }

    /**
     * Comma-separated list or wildcard expressions of fields to include in the statistics.
     * <p>
     * API name: {@code fields}
     * </p>
     */
    @Nonnull
    public final List<String> fields() {
        return this.fields;
    }

    /**
     * If <code>true</code>, statistics are not collected from closed indexes.
     * <p>
     * API name: {@code forbid_closed_indices}
     * </p>
     */
    @Nullable
    public final Boolean forbidClosedIndices() {
        return this.forbidClosedIndices;
    }

    /**
     * Comma-separated list of search groups to include in the search statistics.
     * <p>
     * API name: {@code groups}
     * </p>
     */
    @Nonnull
    public final List<String> groups() {
        return this.groups;
    }

    /**
     * If <code>true</code>, the call reports the aggregated disk usage of each one of the Lucene index files (only applies if segment stats
     * are requested).
     * <p>
     * API name: {@code include_segment_file_sizes}
     * </p>
     */
    @Nullable
    public final Boolean includeSegmentFileSizes() {
        return this.includeSegmentFileSizes;
    }

    /**
     * If <code>true</code>, the response includes information from segments that are not loaded into memory.
     * <p>
     * API name: {@code include_unloaded_segments}
     * </p>
     */
    @Nullable
    public final Boolean includeUnloadedSegments() {
        return this.includeUnloadedSegments;
    }

    /**
     * A comma-separated list of index names; use <code>_all</code> or empty string to perform the operation on all indexes
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final List<String> index() {
        return this.index;
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
     * Limit the information returned the specific metrics.
     * <p>
     * API name: {@code metric}
     * </p>
     */
    @Nonnull
    public final List<IndicesStatsMetric> metric() {
        return this.metric;
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
     * Builder for {@link IndicesStatsRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndicesStatsRequest> {
        @Nullable
        private List<String> completionFields;
        @Nullable
        private List<ExpandWildcard> expandWildcards;
        @Nullable
        private List<String> fielddataFields;
        @Nullable
        private List<String> fields;
        @Nullable
        private Boolean forbidClosedIndices;
        @Nullable
        private List<String> groups;
        @Nullable
        private Boolean includeSegmentFileSizes;
        @Nullable
        private Boolean includeUnloadedSegments;
        @Nullable
        private List<String> index;
        @Nullable
        private Level level;
        @Nullable
        private List<IndicesStatsMetric> metric;

        public Builder() {}

        private Builder(IndicesStatsRequest o) {
            this.completionFields = _listCopy(o.completionFields);
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.fielddataFields = _listCopy(o.fielddataFields);
            this.fields = _listCopy(o.fields);
            this.forbidClosedIndices = o.forbidClosedIndices;
            this.groups = _listCopy(o.groups);
            this.includeSegmentFileSizes = o.includeSegmentFileSizes;
            this.includeUnloadedSegments = o.includeUnloadedSegments;
            this.index = _listCopy(o.index);
            this.level = o.level;
            this.metric = _listCopy(o.metric);
        }

        private Builder(Builder o) {
            this.completionFields = _listCopy(o.completionFields);
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.fielddataFields = _listCopy(o.fielddataFields);
            this.fields = _listCopy(o.fields);
            this.forbidClosedIndices = o.forbidClosedIndices;
            this.groups = _listCopy(o.groups);
            this.includeSegmentFileSizes = o.includeSegmentFileSizes;
            this.includeUnloadedSegments = o.includeUnloadedSegments;
            this.index = _listCopy(o.index);
            this.level = o.level;
            this.metric = _listCopy(o.metric);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Comma-separated list or wildcard expressions of fields to include in field data and suggest statistics.
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
         * Comma-separated list or wildcard expressions of fields to include in field data and suggest statistics.
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
         * Type of index that wildcard patterns can match. If the request can target data streams, this argument determines whether wildcard
         * expressions match hidden data streams. Supports comma-separated values, such as <code>open,hidden</code>.
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
         * Type of index that wildcard patterns can match. If the request can target data streams, this argument determines whether wildcard
         * expressions match hidden data streams. Supports comma-separated values, such as <code>open,hidden</code>.
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
         * Comma-separated list or wildcard expressions of fields to include in field data statistics.
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
         * Comma-separated list or wildcard expressions of fields to include in field data statistics.
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
         * Comma-separated list or wildcard expressions of fields to include in the statistics.
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
         * Comma-separated list or wildcard expressions of fields to include in the statistics.
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
         * If <code>true</code>, statistics are not collected from closed indexes.
         * <p>
         * API name: {@code forbid_closed_indices}
         * </p>
         */
        @Nonnull
        public final Builder forbidClosedIndices(@Nullable Boolean value) {
            this.forbidClosedIndices = value;
            return this;
        }

        /**
         * Comma-separated list of search groups to include in the search statistics.
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
         * Comma-separated list of search groups to include in the search statistics.
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
         * If <code>true</code>, the call reports the aggregated disk usage of each one of the Lucene index files (only applies if segment
         * stats are requested).
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
         * If <code>true</code>, the response includes information from segments that are not loaded into memory.
         * <p>
         * API name: {@code include_unloaded_segments}
         * </p>
         */
        @Nonnull
        public final Builder includeUnloadedSegments(@Nullable Boolean value) {
            this.includeUnloadedSegments = value;
            return this;
        }

        /**
         * A comma-separated list of index names; use <code>_all</code> or empty string to perform the operation on all indexes
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
         * A comma-separated list of index names; use <code>_all</code> or empty string to perform the operation on all indexes
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
         * Limit the information returned the specific metrics.
         * <p>
         * API name: {@code metric}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>metric</code>.
         * </p>
         */
        @Nonnull
        public final Builder metric(List<IndicesStatsMetric> list) {
            this.metric = _listAddAll(this.metric, list);
            return this;
        }

        /**
         * Limit the information returned the specific metrics.
         * <p>
         * API name: {@code metric}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>metric</code>.
         * </p>
         */
        @Nonnull
        public final Builder metric(IndicesStatsMetric value, IndicesStatsMetric... values) {
            this.metric = _listAdd(this.metric, value, values);
            return this;
        }

        /**
         * Builds a {@link IndicesStatsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndicesStatsRequest build() {
            _checkSingleUse();

            return new IndicesStatsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code indices.stats}".
     */
    public static final Endpoint<IndicesStatsRequest, IndicesStatsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _index = 1 << 0;
            final int _metric = 1 << 1;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.index())) propsSet |= _index;
            if (ApiTypeHelper.isDefined(request.metric())) propsSet |= _metric;

            if (propsSet == 0) {
                return "/_stats";
            }
            if (propsSet == (_index)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/");
                SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
                buf.append("/_stats");
                return buf.toString();
            }
            if (propsSet == (_index | _metric)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/");
                SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
                buf.append("/_stats/");
                SimpleEndpoint.pathEncode(request.metric.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")), buf);
                return buf.toString();
            }
            if (propsSet == (_metric)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_stats/");
                SimpleEndpoint.pathEncode(request.metric.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")), buf);
                return buf.toString();
            }

            throw SimpleEndpoint.noPathTemplateFound("path");
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            if (ApiTypeHelper.isDefined(request.completionFields)) {
                params.put("completion_fields", String.join(",", request.completionFields));
            }
            if (ApiTypeHelper.isDefined(request.expandWildcards)) {
                params.put("expand_wildcards", request.expandWildcards.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")));
            }
            if (ApiTypeHelper.isDefined(request.fielddataFields)) {
                params.put("fielddata_fields", String.join(",", request.fielddataFields));
            }
            if (ApiTypeHelper.isDefined(request.fields)) {
                params.put("fields", String.join(",", request.fields));
            }
            if (request.forbidClosedIndices != null) {
                params.put("forbid_closed_indices", String.valueOf(request.forbidClosedIndices));
            }
            if (ApiTypeHelper.isDefined(request.groups)) {
                params.put("groups", String.join(",", request.groups));
            }
            if (request.includeSegmentFileSizes != null) {
                params.put("include_segment_file_sizes", String.valueOf(request.includeSegmentFileSizes));
            }
            if (request.includeUnloadedSegments != null) {
                params.put("include_unloaded_segments", String.valueOf(request.includeUnloadedSegments));
            }
            if (request.level != null) {
                params.put("level", request.level.jsonValue());
            }
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        IndicesStatsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.completionFields);
        result = 31 * result + Objects.hashCode(this.expandWildcards);
        result = 31 * result + Objects.hashCode(this.fielddataFields);
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Objects.hashCode(this.forbidClosedIndices);
        result = 31 * result + Objects.hashCode(this.groups);
        result = 31 * result + Objects.hashCode(this.includeSegmentFileSizes);
        result = 31 * result + Objects.hashCode(this.includeUnloadedSegments);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.level);
        result = 31 * result + Objects.hashCode(this.metric);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndicesStatsRequest other = (IndicesStatsRequest) o;
        return Objects.equals(this.completionFields, other.completionFields)
            && Objects.equals(this.expandWildcards, other.expandWildcards)
            && Objects.equals(this.fielddataFields, other.fielddataFields)
            && Objects.equals(this.fields, other.fields)
            && Objects.equals(this.forbidClosedIndices, other.forbidClosedIndices)
            && Objects.equals(this.groups, other.groups)
            && Objects.equals(this.includeSegmentFileSizes, other.includeSegmentFileSizes)
            && Objects.equals(this.includeUnloadedSegments, other.includeUnloadedSegments)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.level, other.level)
            && Objects.equals(this.metric, other.metric);
    }
}
