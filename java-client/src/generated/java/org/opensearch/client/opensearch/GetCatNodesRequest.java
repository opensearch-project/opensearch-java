package org.opensearch.client.opensearch;

import org.opensearch.client.opensearch._types.*;
import org.opensearch.client.transport.*;
import org.opensearch.client.transport.endpoints.*;
import org.opensearch.client.util.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import javax.annotation.*;

/** Returns basic statistics about performance of cluster nodes. */
public class GetCatNodesRequest extends RequestBase {

    @Nullable private final Integer bytes;

    @Nullable private final String clusterManagerTimeout;

    @Nullable private final String format;

    @Nullable private final Boolean fullId;

    @Nullable private final Boolean includeUnloadedSegments;

    @Nullable private final Boolean local;

    @Nullable private final String masterTimeout;

    @Nullable private final String time;

    public GetCatNodesRequest(Builder builder) {
        this.bytes = builder.bytes;
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.format = builder.format;
        this.fullId = builder.fullId;
        this.includeUnloadedSegments = builder.includeUnloadedSegments;
        this.local = builder.local;
        this.masterTimeout = builder.masterTimeout;
        this.time = builder.time;
    }

    public static GetCatNodesRequest of(Function<Builder, ObjectBuilder<GetCatNodesRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final Integer bytes() {
        return this.bytes;
    }

    public final String clusterManagerTimeout() {
        return this.clusterManagerTimeout;
    }

    public final String format() {
        return this.format;
    }

    public final Boolean fullId() {
        return this.fullId;
    }

    public final Boolean includeUnloadedSegments() {
        return this.includeUnloadedSegments;
    }

    public final Boolean local() {
        return this.local;
    }

    public final String masterTimeout() {
        return this.masterTimeout;
    }

    public final String time() {
        return this.time;
    }

    /** Builder for {@link GetCatNodesRequest}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<GetCatNodesRequest> {
        private Integer bytes;
        private String clusterManagerTimeout;
        private String format;
        private Boolean fullId;
        private Boolean includeUnloadedSegments;
        private Boolean local;
        private String masterTimeout;
        private String time;

        public final Builder bytes(Integer value) {
            this.bytes = value;
            return this;
        }

        public final Builder clusterManagerTimeout(String value) {
            this.clusterManagerTimeout = value;
            return this;
        }

        public final Builder format(String value) {
            this.format = value;
            return this;
        }

        public final Builder fullId(Boolean value) {
            this.fullId = value;
            return this;
        }

        public final Builder includeUnloadedSegments(Boolean value) {
            this.includeUnloadedSegments = value;
            return this;
        }

        public final Builder local(Boolean value) {
            this.local = value;
            return this;
        }

        public final Builder masterTimeout(String value) {
            this.masterTimeout = value;
            return this;
        }

        public final Builder time(String value) {
            this.time = value;
            return this;
        }

        /**
         * Builds a {@link GetCatNodesRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public GetCatNodesRequest build() {
            _checkSingleUse();

            return new GetCatNodesRequest(this);
        }
    }

    public static final Endpoint<GetCatNodesRequest, GetCatNodesResponse, ErrorResponse> _ENDPOINT =
            new SimpleEndpoint<>(
                    // Request method
                    request -> {
                        return "get";
                    },
                    // Request path
                    request -> {
                        return "/_cat/nodes";
                    },
                    // Request parameters
                    request -> {
                        Map<String, String> params = new HashMap<>();
                        if (request.bytes != null) {
                            params.put("bytes", String.valueOf(request.bytes));
                        }
                        if (request.clusterManagerTimeout != null) {
                            params.put("cluster_manager_timeout", request.clusterManagerTimeout);
                        }
                        if (request.format != null) {
                            params.put("format", request.format);
                        }
                        if (request.fullId != null) {
                            params.put("full_id", String.valueOf(request.fullId));
                        }
                        if (request.includeUnloadedSegments != null) {
                            params.put(
                                    "include_unloaded_segments",
                                    String.valueOf(request.includeUnloadedSegments));
                        }
                        if (request.local != null) {
                            params.put("local", String.valueOf(request.local));
                        }
                        if (request.masterTimeout != null) {
                            params.put("master_timeout", request.masterTimeout);
                        }
                        if (request.time != null) {
                            params.put("time", request.time);
                        }
                        return params;
                    },
                    SimpleEndpoint.emptyMap(),
                    false,
                    GetCatNodesResponse._DESERIALIZER);
}
