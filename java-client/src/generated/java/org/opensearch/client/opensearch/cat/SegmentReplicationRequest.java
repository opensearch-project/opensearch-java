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

// ----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
// ----------------------------------------------------

package org.opensearch.client.opensearch.cat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.Bytes;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.ExpandWildcard;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.TimeUnit;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

/** Returns information about both on-going and latest completed Segment Replication events. */
public class SegmentReplicationRequest extends RequestBase {

    @Nullable private final Boolean activeOnly;

    @Nullable private final Boolean allowNoIndices;

    @Nullable private final Bytes bytes;

    @Nullable private final Boolean completedOnly;

    @Nullable private final Boolean detailed;

    private final List<ExpandWildcard> expandWildcards;

    @Nullable private final String format;

    private final List<String> h;

    @Nullable private final Boolean help;

    @Nullable private final Boolean ignoreThrottled;

    @Nullable private final Boolean ignoreUnavailable;

    private final List<String> index;

    private final List<String> s;

    private final List<String> shards;

    @Nullable private final TimeUnit time;

    @Nullable private final Time timeout;

    @Nullable private final Boolean v;

    // ---------------------------------------------------------------------------------------------

    private SegmentReplicationRequest(Builder builder) {
        this.activeOnly = builder.activeOnly;
        this.allowNoIndices = builder.allowNoIndices;
        this.bytes = builder.bytes;
        this.completedOnly = builder.completedOnly;
        this.detailed = builder.detailed;
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.format = builder.format;
        this.h = ApiTypeHelper.unmodifiable(builder.h);
        this.help = builder.help;
        this.ignoreThrottled = builder.ignoreThrottled;
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.index = ApiTypeHelper.unmodifiable(builder.index);
        this.s = ApiTypeHelper.unmodifiable(builder.s);
        this.shards = ApiTypeHelper.unmodifiable(builder.shards);
        this.time = builder.time;
        this.timeout = builder.timeout;
        this.v = builder.v;
    }

    public static SegmentReplicationRequest of(
            Function<SegmentReplicationRequest.Builder, ObjectBuilder<SegmentReplicationRequest>>
                    fn) {
        return fn.apply(new Builder()).build();
    }
    /**
     * If `true`, the response only includes ongoing segment replication events.
     *
     * <p>API name: {@code active_only}
     */
    @Nullable
    public final Boolean activeOnly() {
        return this.activeOnly;
    }

    /**
     * Whether to ignore if a wildcard indices expression resolves into no concrete indices. (This
     * includes `_all` string or when no indices have been specified).
     *
     * <p>API name: {@code allow_no_indices}
     */
    @Nullable
    public final Boolean allowNoIndices() {
        return this.allowNoIndices;
    }

    /**
     * The unit in which to display byte values.
     *
     * <p>API name: {@code bytes}
     */
    @Nullable
    public final Bytes bytes() {
        return this.bytes;
    }

    /**
     * If `true`, the response only includes latest completed segment replication events.
     *
     * <p>API name: {@code completed_only}
     */
    @Nullable
    public final Boolean completedOnly() {
        return this.completedOnly;
    }

    /**
     * If `true`, the response includes detailed information about segment replications.
     *
     * <p>API name: {@code detailed}
     */
    @Nullable
    public final Boolean detailed() {
        return this.detailed;
    }

    /**
     * Whether to expand wildcard expression to concrete indices that are open, closed or both.
     *
     * <p>API name: {@code expand_wildcards}
     */
    public final List<ExpandWildcard> expandWildcards() {
        return this.expandWildcards;
    }

    /**
     * A short version of the Accept header, e.g. json, yaml.
     *
     * <p>API name: {@code format}
     */
    @Nullable
    public final String format() {
        return this.format;
    }

    /**
     * Comma-separated list of column names to display.
     *
     * <p>API name: {@code h}
     */
    public final List<String> h() {
        return this.h;
    }

    /**
     * Return help information.
     *
     * <p>API name: {@code help}
     */
    @Nullable
    public final Boolean help() {
        return this.help;
    }

    /**
     * Whether specified concrete, expanded or aliased indices should be ignored when throttled.
     *
     * <p>API name: {@code ignore_throttled}
     */
    @Nullable
    public final Boolean ignoreThrottled() {
        return this.ignoreThrottled;
    }

    /**
     * Whether specified concrete indices should be ignored when unavailable (missing or closed).
     *
     * <p>API name: {@code ignore_unavailable}
     */
    @Nullable
    public final Boolean ignoreUnavailable() {
        return this.ignoreUnavailable;
    }

    /**
     * Comma-separated list or wildcard expression of index names to limit the returned information.
     *
     * <p>API name: {@code index}
     */
    public final List<String> index() {
        return this.index;
    }

    /**
     * Comma-separated list of column names or column aliases to sort by.
     *
     * <p>API name: {@code s}
     */
    public final List<String> s() {
        return this.s;
    }

    /**
     * Comma-separated list of shards to display.
     *
     * <p>API name: {@code shards}
     */
    public final List<String> shards() {
        return this.shards;
    }

    /**
     * The unit in which to display time values.
     *
     * <p>API name: {@code time}
     */
    @Nullable
    public final TimeUnit time() {
        return this.time;
    }

    /**
     * Operation timeout.
     *
     * <p>API name: {@code timeout}
     */
    @Nullable
    public final Time timeout() {
        return this.timeout;
    }

    /**
     * Verbose mode. Display column headers.
     *
     * <p>API name: {@code v}
     */
    @Nullable
    public final Boolean v() {
        return this.v;
    }

    // ---------------------------------------------------------------------------------------------

    /** Builder for {@link SegmentReplicationRequest}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<SegmentReplicationRequest> {
        @Nullable private Boolean activeOnly;
        @Nullable private Boolean allowNoIndices;
        @Nullable private Bytes bytes;
        @Nullable private Boolean completedOnly;
        @Nullable private Boolean detailed;
        @Nullable private List<ExpandWildcard> expandWildcards;
        @Nullable private String format;
        @Nullable private List<String> h;
        @Nullable private Boolean help;
        @Nullable private Boolean ignoreThrottled;
        @Nullable private Boolean ignoreUnavailable;
        @Nullable private List<String> index;
        @Nullable private List<String> s;
        @Nullable private List<String> shards;
        @Nullable private TimeUnit time;
        @Nullable private Time timeout;
        @Nullable private Boolean v;

        /**
         * If `true`, the response only includes ongoing segment replication events.
         *
         * <p>API name: {@code active_only}
         */
        public final Builder activeOnly(@Nullable Boolean value) {
            this.activeOnly = value;
            return this;
        }

        /**
         * Whether to ignore if a wildcard indices expression resolves into no concrete indices.
         * (This includes `_all` string or when no indices have been specified).
         *
         * <p>API name: {@code allow_no_indices}
         */
        public final Builder allowNoIndices(@Nullable Boolean value) {
            this.allowNoIndices = value;
            return this;
        }

        /**
         * The unit in which to display byte values.
         *
         * <p>API name: {@code bytes}
         */
        public final Builder bytes(@Nullable Bytes value) {
            this.bytes = value;
            return this;
        }

        /**
         * If `true`, the response only includes latest completed segment replication events.
         *
         * <p>API name: {@code completed_only}
         */
        public final Builder completedOnly(@Nullable Boolean value) {
            this.completedOnly = value;
            return this;
        }

        /**
         * If `true`, the response includes detailed information about segment replications.
         *
         * <p>API name: {@code detailed}
         */
        public final Builder detailed(@Nullable Boolean value) {
            this.detailed = value;
            return this;
        }

        /**
         * Whether to expand wildcard expression to concrete indices that are open, closed or both.
         *
         * <p>API name: {@code expand_wildcards}
         *
         * <p>Adds all elements of <code>list</code> to <code>expandWildcards</code>.
         */
        public final Builder expandWildcards(List<ExpandWildcard> list) {
            this.expandWildcards = _listAddAll(this.expandWildcards, list);
            return this;
        }

        /**
         * Whether to expand wildcard expression to concrete indices that are open, closed or both.
         *
         * <p>API name: {@code expand_wildcards}
         *
         * <p>Adds one or more values to <code>expandWildcards</code>.
         */
        public final Builder expandWildcards(ExpandWildcard value, ExpandWildcard... values) {
            this.expandWildcards = _listAdd(this.expandWildcards, value, values);
            return this;
        }

        /**
         * A short version of the Accept header, e.g. json, yaml.
         *
         * <p>API name: {@code format}
         */
        public final Builder format(@Nullable String value) {
            this.format = value;
            return this;
        }

        /**
         * Comma-separated list of column names to display.
         *
         * <p>API name: {@code h}
         *
         * <p>Adds all elements of <code>list</code> to <code>h</code>.
         */
        public final Builder h(List<String> list) {
            this.h = _listAddAll(this.h, list);
            return this;
        }

        /**
         * Comma-separated list of column names to display.
         *
         * <p>API name: {@code h}
         *
         * <p>Adds one or more values to <code>h</code>.
         */
        public final Builder h(String value, String... values) {
            this.h = _listAdd(this.h, value, values);
            return this;
        }

        /**
         * Return help information.
         *
         * <p>API name: {@code help}
         */
        public final Builder help(@Nullable Boolean value) {
            this.help = value;
            return this;
        }

        /**
         * Whether specified concrete, expanded or aliased indices should be ignored when throttled.
         *
         * <p>API name: {@code ignore_throttled}
         */
        public final Builder ignoreThrottled(@Nullable Boolean value) {
            this.ignoreThrottled = value;
            return this;
        }

        /**
         * Whether specified concrete indices should be ignored when unavailable (missing or
         * closed).
         *
         * <p>API name: {@code ignore_unavailable}
         */
        public final Builder ignoreUnavailable(@Nullable Boolean value) {
            this.ignoreUnavailable = value;
            return this;
        }

        /**
         * Comma-separated list or wildcard expression of index names to limit the returned
         * information.
         *
         * <p>API name: {@code index}
         *
         * <p>Adds all elements of <code>list</code> to <code>index</code>.
         */
        public final Builder index(List<String> list) {
            this.index = _listAddAll(this.index, list);
            return this;
        }

        /**
         * Comma-separated list or wildcard expression of index names to limit the returned
         * information.
         *
         * <p>API name: {@code index}
         *
         * <p>Adds one or more values to <code>index</code>.
         */
        public final Builder index(String value, String... values) {
            this.index = _listAdd(this.index, value, values);
            return this;
        }

        /**
         * Comma-separated list of column names or column aliases to sort by.
         *
         * <p>API name: {@code s}
         *
         * <p>Adds all elements of <code>list</code> to <code>s</code>.
         */
        public final Builder s(List<String> list) {
            this.s = _listAddAll(this.s, list);
            return this;
        }

        /**
         * Comma-separated list of column names or column aliases to sort by.
         *
         * <p>API name: {@code s}
         *
         * <p>Adds one or more values to <code>s</code>.
         */
        public final Builder s(String value, String... values) {
            this.s = _listAdd(this.s, value, values);
            return this;
        }

        /**
         * Comma-separated list of shards to display.
         *
         * <p>API name: {@code shards}
         *
         * <p>Adds all elements of <code>list</code> to <code>shards</code>.
         */
        public final Builder shards(List<String> list) {
            this.shards = _listAddAll(this.shards, list);
            return this;
        }

        /**
         * Comma-separated list of shards to display.
         *
         * <p>API name: {@code shards}
         *
         * <p>Adds one or more values to <code>shards</code>.
         */
        public final Builder shards(String value, String... values) {
            this.shards = _listAdd(this.shards, value, values);
            return this;
        }

        /**
         * The unit in which to display time values.
         *
         * <p>API name: {@code time}
         */
        public final Builder time(@Nullable TimeUnit value) {
            this.time = value;
            return this;
        }

        /**
         * Operation timeout.
         *
         * <p>API name: {@code timeout}
         */
        public final Builder timeout(@Nullable Time value) {
            this.timeout = value;
            return this;
        }

        /**
         * Operation timeout.
         *
         * <p>API name: {@code timeout}
         */
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return this.timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Verbose mode. Display column headers.
         *
         * <p>API name: {@code v}
         */
        public final Builder v(@Nullable Boolean value) {
            this.v = value;
            return this;
        }

        /**
         * Builds a {@link SegmentReplicationRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public SegmentReplicationRequest build() {
            _checkSingleUse();

            return new SegmentReplicationRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /** Endpoint "{@code cat.segment_replication}". */
    public static final Endpoint<
                    SegmentReplicationRequest, SegmentReplicationResponse, ErrorResponse>
            _ENDPOINT =
                    new SimpleEndpoint<>(
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
                                if (request.activeOnly != null) {
                                    params.put("active_only", String.valueOf(request.activeOnly));
                                }
                                if (request.allowNoIndices != null) {
                                    params.put(
                                            "allow_no_indices",
                                            String.valueOf(request.allowNoIndices));
                                }
                                if (request.bytes != null) {
                                    params.put("bytes", request.bytes.jsonValue());
                                }
                                if (request.completedOnly != null) {
                                    params.put(
                                            "completed_only",
                                            String.valueOf(request.completedOnly));
                                }
                                if (request.detailed != null) {
                                    params.put("detailed", String.valueOf(request.detailed));
                                }
                                if (ApiTypeHelper.isDefined(request.expandWildcards)) {
                                    params.put(
                                            "expand_wildcards",
                                            request.expandWildcards.stream()
                                                    .map(v -> v.jsonValue())
                                                    .collect(Collectors.joining(",")));
                                }
                                if (request.format != null) {
                                    params.put("format", request.format);
                                }
                                if (ApiTypeHelper.isDefined(request.h)) {
                                    params.put("h", String.join(",", request.h));
                                }
                                if (request.help != null) {
                                    params.put("help", String.valueOf(request.help));
                                }
                                if (request.ignoreThrottled != null) {
                                    params.put(
                                            "ignore_throttled",
                                            String.valueOf(request.ignoreThrottled));
                                }
                                if (request.ignoreUnavailable != null) {
                                    params.put(
                                            "ignore_unavailable",
                                            String.valueOf(request.ignoreUnavailable));
                                }
                                if (ApiTypeHelper.isDefined(request.index)) {
                                    params.put("index", String.join(",", request.index));
                                }
                                if (ApiTypeHelper.isDefined(request.s)) {
                                    params.put("s", String.join(",", request.s));
                                }
                                if (ApiTypeHelper.isDefined(request.shards)) {
                                    params.put("shards", String.join(",", request.shards));
                                }
                                if (request.time != null) {
                                    params.put("time", request.time.jsonValue());
                                }
                                if (request.timeout != null) {
                                    params.put("timeout", request.timeout._toJsonString());
                                }
                                if (request.v != null) {
                                    params.put("v", String.valueOf(request.v));
                                }
                                return params;
                            },
                            SimpleEndpoint.emptyMap(),
                            false,
                            SegmentReplicationResponse._DESERIALIZER);
}
