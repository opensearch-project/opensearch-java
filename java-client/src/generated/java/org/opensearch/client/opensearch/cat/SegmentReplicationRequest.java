/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

// ----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
// ----------------------------------------------------

package org.opensearch.client.opensearch.cat;

import org.opensearch.client.opensearch.*;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

/** Returns information about both on-going and latest completed Segment Replication events. */
public class SegmentReplicationRequest extends RequestBase {

    @Nullable private final Boolean activeOnly;

    @Nullable private final Boolean allowNoIndices;

    @Nullable private final Bytes bytes;

    @Nullable private final Boolean completedOnly;

    @Nullable private final Boolean detailed;

    @Nullable private final ExpandWildcards expandWildcards;

    @Nullable private final String format;

    @Nullable private final List<String> h;

    @Nullable private final Boolean help;

    @Nullable private final Boolean ignoreThrottled;

    @Nullable private final Boolean ignoreUnavailable;

    private final String index;

    @Nullable private final List<String> s;

    @Nullable private final List<String> shards;

    @Nullable private final Time time;

    @Nullable private final String timeout;

    @Nullable private final Boolean v;

    public SegmentReplicationRequest(Builder builder) {
        this.activeOnly = builder.activeOnly;
        this.allowNoIndices = builder.allowNoIndices;
        this.bytes = builder.bytes;
        this.completedOnly = builder.completedOnly;
        this.detailed = builder.detailed;
        this.expandWildcards = builder.expandWildcards;
        this.format = builder.format;
        this.h = ApiTypeHelper.unmodifiable(builder.h);
        this.help = builder.help;
        this.ignoreThrottled = builder.ignoreThrottled;
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.s = ApiTypeHelper.unmodifiable(builder.s);
        this.shards = ApiTypeHelper.unmodifiable(builder.shards);
        this.time = builder.time;
        this.timeout = builder.timeout;
        this.v = builder.v;
    }

    public static SegmentReplicationRequest of(
            Function<Builder, ObjectBuilder<SegmentReplicationRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final Boolean activeOnly() {
        return this.activeOnly;
    }

    public final Boolean allowNoIndices() {
        return this.allowNoIndices;
    }

    public final Bytes bytes() {
        return this.bytes;
    }

    public final Boolean completedOnly() {
        return this.completedOnly;
    }

    public final Boolean detailed() {
        return this.detailed;
    }

    public final ExpandWildcards expandWildcards() {
        return this.expandWildcards;
    }

    public final String format() {
        return this.format;
    }

    public final List<String> h() {
        return this.h;
    }

    public final Boolean help() {
        return this.help;
    }

    public final Boolean ignoreThrottled() {
        return this.ignoreThrottled;
    }

    public final Boolean ignoreUnavailable() {
        return this.ignoreUnavailable;
    }

    public final String index() {
        return this.index;
    }

    public final List<String> s() {
        return this.s;
    }

    public final List<String> shards() {
        return this.shards;
    }

    public final Time time() {
        return this.time;
    }

    public final String timeout() {
        return this.timeout;
    }

    public final Boolean v() {
        return this.v;
    }

    /** Builder for {@link SegmentReplicationRequest}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<SegmentReplicationRequest> {
        private Boolean activeOnly;
        private Boolean allowNoIndices;
        private Bytes bytes;
        private Boolean completedOnly;
        private Boolean detailed;
        private ExpandWildcards expandWildcards;
        private String format;
        private List<String> h;
        private Boolean help;
        private Boolean ignoreThrottled;
        private Boolean ignoreUnavailable;
        private String index;
        private List<String> s;
        private List<String> shards;
        private Time time;
        private String timeout;
        private Boolean v;

        public final Builder activeOnly(Boolean value) {
            this.activeOnly = value;
            return this;
        }

        public final Builder allowNoIndices(Boolean value) {
            this.allowNoIndices = value;
            return this;
        }

        public final Builder bytes(Bytes value) {
            this.bytes = value;
            return this;
        }

        public final Builder completedOnly(Boolean value) {
            this.completedOnly = value;
            return this;
        }

        public final Builder detailed(Boolean value) {
            this.detailed = value;
            return this;
        }

        public final Builder expandWildcards(ExpandWildcards value) {
            this.expandWildcards = value;
            return this;
        }

        public final Builder format(String value) {
            this.format = value;
            return this;
        }

        public final Builder h(List<String> list) {
            this.h = _listAddAll(this.h, list);
            return this;
        }

        public final Builder h(String value, String... values) {
            this.h = _listAdd(this.h, value, values);
            return this;
        }

        public final Builder help(Boolean value) {
            this.help = value;
            return this;
        }

        public final Builder ignoreThrottled(Boolean value) {
            this.ignoreThrottled = value;
            return this;
        }

        public final Builder ignoreUnavailable(Boolean value) {
            this.ignoreUnavailable = value;
            return this;
        }

        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        public final Builder s(List<String> list) {
            this.s = _listAddAll(this.s, list);
            return this;
        }

        public final Builder s(String value, String... values) {
            this.s = _listAdd(this.s, value, values);
            return this;
        }

        public final Builder shards(List<String> list) {
            this.shards = _listAddAll(this.shards, list);
            return this;
        }

        public final Builder shards(String value, String... values) {
            this.shards = _listAdd(this.shards, value, values);
            return this;
        }

        public final Builder time(Time value) {
            this.time = value;
            return this;
        }

        public final Builder timeout(String value) {
            this.timeout = value;
            return this;
        }

        public final Builder v(Boolean value) {
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

    public static final Endpoint<
                    SegmentReplicationRequest, SegmentReplicationResponse, ErrorResponse>
            _ENDPOINT =
                    new SimpleEndpoint<>(
                            // Request method
                            request -> "get",
                            // Request path
                            request -> {
                                StringBuilder buf = new StringBuilder();
                                buf.append("/_cat/segment_replication/");
                                SimpleEndpoint.pathEncode(request.index, buf);
                                return buf.toString();
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
                                if (request.expandWildcards != null) {
                                    params.put(
                                            "expand_wildcards",
                                            request.expandWildcards.jsonValue());
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
                                    params.put("timeout", request.timeout);
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
