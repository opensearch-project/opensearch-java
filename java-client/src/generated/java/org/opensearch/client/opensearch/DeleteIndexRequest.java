package org.opensearch.client.opensearch;

import org.opensearch.client.opensearch._types.*;

import org.opensearch.client.transport.*;
import org.opensearch.client.transport.endpoints.*;
import org.opensearch.client.util.*;

import java.util.*;
import java.util.function.Function;
import javax.annotation.*;

/** Removes a document from the index. */
public class DeleteIndexRequest extends RequestBase {
    private final boolean allowNoIndices;
    private final String clusterManagerTimeout;
    private final ExpandWildcards expandWildcards;
    private final boolean ignoreUnavailable;
    private final String masterTimeout;
    private final String timeout;

    public DeleteIndexRequest(Builder builder) {
        this.allowNoIndices = builder.allowNoIndices;
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.expandWildcards = builder.expandWildcards;
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.masterTimeout = builder.masterTimeout;
        this.timeout = builder.timeout;
    }

    public static DeleteIndexRequest of(Function<Builder, ObjectBuilder<DeleteIndexRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final boolean allowNoIndices() {
        return this.allowNoIndices;
    }

    public final String clusterManagerTimeout() {
        return this.clusterManagerTimeout;
    }

    public final ExpandWildcards expandWildcards() {
        return this.expandWildcards;
    }

    public final boolean ignoreUnavailable() {
        return this.ignoreUnavailable;
    }

    public final String masterTimeout() {
        return this.masterTimeout;
    }

    public final String timeout() {
        return this.timeout;
    }

    /** Builder for {@link DeleteIndexRequest}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<DeleteIndexRequest> {
        private boolean allowNoIndices;
        private String clusterManagerTimeout;
        private ExpandWildcards expandWildcards;
        private boolean ignoreUnavailable;
        private String masterTimeout;
        private String timeout;

        public final Builder allowNoIndices(boolean value) {
            this.allowNoIndices = value;
            return this;
        }

        public final Builder clusterManagerTimeout(String value) {
            this.clusterManagerTimeout = value;
            return this;
        }

        public final Builder expandWildcards(ExpandWildcards value) {
            this.expandWildcards = value;
            return this;
        }

        public final Builder expandWildcards(
                Function<ExpandWildcards.Builder, ObjectBuilder<ExpandWildcards>> fn) {
            return expandWildcards(fn.apply(new ExpandWildcards.Builder()).build());
        }

        public final Builder ignoreUnavailable(boolean value) {
            this.ignoreUnavailable = value;
            return this;
        }

        public final Builder masterTimeout(String value) {
            this.masterTimeout = value;
            return this;
        }

        public final Builder timeout(String value) {
            this.timeout = value;
            return this;
        }

        /**
         * Builds a {@link DeleteIndexRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public DeleteIndexRequest build() {
            _checkSingleUse();

            return new DeleteIndexRequest(this);
        }
    }

    public static final Endpoint<DeleteIndexRequest, DeleteIndexResponse, ErrorResponse> _ENDPOINT =
            new SimpleEndpoint<>(
                    // Request method
                    request -> {
                        return "delete";
                    },
                    // Request path
                    request -> {
                        return "/{index}";
                    },
                    // Request parameters
                    request -> {
                        Map<String, String> params = new HashMap<>();
                        if (request.allowNoIndices != null) {
                            params.put("allow_no_indices", String.valueOf(request.allowNoIndices));
                        }
                        if (request.clusterManagerTimeout != null) {
                            params.put("cluster_manager_timeout", request.clusterManagerTimeout);
                        }
                        if (request.expandWildcards != null) {
                            params.put("expand_wildcards", request.expandWildcards.jsonValue());
                        }
                        if (request.ignoreUnavailable != null) {
                            params.put(
                                    "ignore_unavailable",
                                    String.valueOf(request.ignoreUnavailable));
                        }
                        if (request.masterTimeout != null) {
                            params.put("master_timeout", request.masterTimeout);
                        }
                        if (request.timeout != null) {
                            params.put("timeout", request.timeout);
                        }
                        return params;
                    },
                    SimpleEndpoint.emptyMap(),
                    false,
                    DeleteIndexResponse._DESERIALIZER);
}
