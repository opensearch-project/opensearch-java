package org.opensearch.client.opensearch;

import org.opensearch.client.opensearch._types.*;

import org.opensearch.client.transport.*;
import org.opensearch.client.transport.endpoints.*;
import org.opensearch.client.util.*;

import java.util.*;
import java.util.function.Function;
import javax.annotation.*;

/** The get settings API operation returns all the settings in your index. */
public class GetSettingsIndexRequest extends RequestBase {
    private final boolean allowNoIndices;
    private final String clusterManagerTimeout;
    private final ExpandWildcards expandWildcards;
    private final boolean flatSettings;
    private final boolean ignoreUnavailable;
    private final String includeDefaults;
    private final boolean local;
    private final String masterTimeout;

    public GetSettingsIndexRequest(Builder builder) {
        this.allowNoIndices = builder.allowNoIndices;
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.expandWildcards = builder.expandWildcards;
        this.flatSettings = builder.flatSettings;
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.includeDefaults = builder.includeDefaults;
        this.local = builder.local;
        this.masterTimeout = builder.masterTimeout;
    }

    public static GetSettingsIndexRequest of(
            Function<Builder, ObjectBuilder<GetSettingsIndexRequest>> fn) {
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

    public final boolean flatSettings() {
        return this.flatSettings;
    }

    public final boolean ignoreUnavailable() {
        return this.ignoreUnavailable;
    }

    public final String includeDefaults() {
        return this.includeDefaults;
    }

    public final boolean local() {
        return this.local;
    }

    public final String masterTimeout() {
        return this.masterTimeout;
    }

    /** Builder for {@link GetSettingsIndexRequest}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<GetSettingsIndexRequest> {
        private boolean allowNoIndices;
        private String clusterManagerTimeout;
        private ExpandWildcards expandWildcards;
        private boolean flatSettings;
        private boolean ignoreUnavailable;
        private String includeDefaults;
        private boolean local;
        private String masterTimeout;

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

        public final Builder flatSettings(boolean value) {
            this.flatSettings = value;
            return this;
        }

        public final Builder ignoreUnavailable(boolean value) {
            this.ignoreUnavailable = value;
            return this;
        }

        public final Builder includeDefaults(String value) {
            this.includeDefaults = value;
            return this;
        }

        public final Builder local(boolean value) {
            this.local = value;
            return this;
        }

        public final Builder masterTimeout(String value) {
            this.masterTimeout = value;
            return this;
        }

        /**
         * Builds a {@link GetSettingsIndexRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public GetSettingsIndexRequest build() {
            _checkSingleUse();

            return new GetSettingsIndexRequest(this);
        }
    }

    public static final Endpoint<GetSettingsIndexRequest, GetSettingsIndexResponse, ErrorResponse>
            _ENDPOINT =
                    new SimpleEndpoint<>(
                            // Request method
                            request -> {
                                return "get";
                            },
                            // Request path
                            request -> {
                                return "/{index}/_settings";
                            },
                            // Request parameters
                            request -> {
                                Map<String, String> params = new HashMap<>();
                                if (request.allowNoIndices != null) {
                                    params.put(
                                            "allow_no_indices",
                                            String.valueOf(request.allowNoIndices));
                                }
                                if (request.clusterManagerTimeout != null) {
                                    params.put(
                                            "cluster_manager_timeout",
                                            request.clusterManagerTimeout);
                                }
                                if (request.expandWildcards != null) {
                                    params.put(
                                            "expand_wildcards",
                                            request.expandWildcards.jsonValue());
                                }
                                if (request.flatSettings != null) {
                                    params.put(
                                            "flat_settings", String.valueOf(request.flatSettings));
                                }
                                if (request.ignoreUnavailable != null) {
                                    params.put(
                                            "ignore_unavailable",
                                            String.valueOf(request.ignoreUnavailable));
                                }
                                if (request.includeDefaults != null) {
                                    params.put("include_defaults", request.includeDefaults);
                                }
                                if (request.local != null) {
                                    params.put("local", String.valueOf(request.local));
                                }
                                if (request.masterTimeout != null) {
                                    params.put("master_timeout", request.masterTimeout);
                                }
                                return params;
                            },
                            SimpleEndpoint.emptyMap(),
                            false,
                            GetSettingsIndexResponse._DESERIALIZER);
}
