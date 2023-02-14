package org.opensearch.client.opensearch;

import org.opensearch.client.opensearch._types.*;
import org.opensearch.client.transport.*;
import org.opensearch.client.transport.endpoints.*;
import org.opensearch.client.util.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import javax.annotation.*;

/** Returns cluster settings. */
public class GetClusterSettingsRequest extends RequestBase {

    @Nullable private final String clusterManagerTimeout;

    @Nullable private final Boolean flatSettings;

    @Nullable private final Boolean includeDefaults;

    @Nullable private final String masterTimeout;

    public GetClusterSettingsRequest(Builder builder) {
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.flatSettings = builder.flatSettings;
        this.includeDefaults = builder.includeDefaults;
        this.masterTimeout = builder.masterTimeout;
    }

    public static GetClusterSettingsRequest of(
            Function<Builder, ObjectBuilder<GetClusterSettingsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final String clusterManagerTimeout() {
        return this.clusterManagerTimeout;
    }

    public final Boolean flatSettings() {
        return this.flatSettings;
    }

    public final Boolean includeDefaults() {
        return this.includeDefaults;
    }

    public final String masterTimeout() {
        return this.masterTimeout;
    }

    /** Builder for {@link GetClusterSettingsRequest}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<GetClusterSettingsRequest> {
        private String clusterManagerTimeout;
        private Boolean flatSettings;
        private Boolean includeDefaults;
        private String masterTimeout;

        public final Builder clusterManagerTimeout(String value) {
            this.clusterManagerTimeout = value;
            return this;
        }

        public final Builder flatSettings(Boolean value) {
            this.flatSettings = value;
            return this;
        }

        public final Builder includeDefaults(Boolean value) {
            this.includeDefaults = value;
            return this;
        }

        public final Builder masterTimeout(String value) {
            this.masterTimeout = value;
            return this;
        }

        /**
         * Builds a {@link GetClusterSettingsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public GetClusterSettingsRequest build() {
            _checkSingleUse();

            return new GetClusterSettingsRequest(this);
        }
    }

    public static final Endpoint<
                    GetClusterSettingsRequest, GetClusterSettingsResponse, ErrorResponse>
            _ENDPOINT =
                    new SimpleEndpoint<>(
                            // Request method
                            request -> {
                                return "get";
                            },
                            // Request path
                            request -> {
                                return "/_cluster/settings";
                            },
                            // Request parameters
                            request -> {
                                Map<String, String> params = new HashMap<>();
                                if (request.clusterManagerTimeout != null) {
                                    params.put(
                                            "cluster_manager_timeout",
                                            request.clusterManagerTimeout);
                                }
                                if (request.flatSettings != null) {
                                    params.put(
                                            "flat_settings", String.valueOf(request.flatSettings));
                                }
                                if (request.includeDefaults != null) {
                                    params.put(
                                            "include_defaults",
                                            String.valueOf(request.includeDefaults));
                                }
                                if (request.masterTimeout != null) {
                                    params.put("master_timeout", request.masterTimeout);
                                }
                                return params;
                            },
                            SimpleEndpoint.emptyMap(),
                            false,
                            GetClusterSettingsResponse._DESERIALIZER);
}
