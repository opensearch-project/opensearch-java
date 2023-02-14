package org.opensearch.client.opensearch;

import org.opensearch.client.opensearch._types.*;
import org.opensearch.client.json.*;
import org.opensearch.client.transport.*;
import org.opensearch.client.transport.endpoints.*;
import org.opensearch.client.util.*;
import jakarta.json.stream.JsonGenerator;
import java.util.*;
import java.util.function.Function;
import javax.annotation.*;

/** The put mapping API operation lets you add new mappings and fields to an index. */
@JsonpDeserializable
public class PutIndexMappingWithIndexRequest extends RequestBase implements JsonpSerializable {
    @Nullable private final Boolean allowNoIndices;
    @Nullable private final String clusterManagerTimeout;
    @Nullable private final ExpandWildcards expandWildcards;
    @Nullable private final Boolean ignoreUnavailable;
    @Nullable private final Boolean includeTypeName;
    @Nullable private final String masterTimeout;
    @Nullable private final JsonData properties;
    @Nullable private final String timeout;
    @Nullable private final Boolean writeIndexOnly;

    public PutIndexMappingWithIndexRequest(Builder builder) {
        this.allowNoIndices = builder.allowNoIndices;
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.expandWildcards = builder.expandWildcards;
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.includeTypeName = builder.includeTypeName;
        this.masterTimeout = builder.masterTimeout;
        this.properties = builder.properties;
        this.timeout = builder.timeout;
        this.writeIndexOnly = builder.writeIndexOnly;
    }

    public static PutIndexMappingWithIndexRequest of(
            Function<Builder, ObjectBuilder<PutIndexMappingWithIndexRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final Boolean allowNoIndices() {
        return this.allowNoIndices;
    }

    public final String clusterManagerTimeout() {
        return this.clusterManagerTimeout;
    }

    public final ExpandWildcards expandWildcards() {
        return this.expandWildcards;
    }

    public final Boolean ignoreUnavailable() {
        return this.ignoreUnavailable;
    }

    public final Boolean includeTypeName() {
        return this.includeTypeName;
    }

    public final String masterTimeout() {
        return this.masterTimeout;
    }

    public final JsonData properties() {
        return this.properties;
    }

    public final String timeout() {
        return this.timeout;
    }

    public final Boolean writeIndexOnly() {
        return this.writeIndexOnly;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.properties != null) {
            generator.writeKey("properties");
            this.properties.serialize(generator, mapper);
        }
    }

    /** Builder for {@link PutIndexMappingWithIndexRequest}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<PutIndexMappingWithIndexRequest> {
        private Boolean allowNoIndices;
        private String clusterManagerTimeout;
        private ExpandWildcards expandWildcards;
        private Boolean ignoreUnavailable;
        private Boolean includeTypeName;
        private String masterTimeout;
        private JsonData properties;
        private String timeout;
        private Boolean writeIndexOnly;

        public final Builder allowNoIndices(Boolean value) {
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

        public final Builder ignoreUnavailable(Boolean value) {
            this.ignoreUnavailable = value;
            return this;
        }

        public final Builder includeTypeName(Boolean value) {
            this.includeTypeName = value;
            return this;
        }

        public final Builder masterTimeout(String value) {
            this.masterTimeout = value;
            return this;
        }

        public final Builder properties(JsonData value) {
            this.properties = value;
            return this;
        }

        public final Builder timeout(String value) {
            this.timeout = value;
            return this;
        }

        public final Builder writeIndexOnly(Boolean value) {
            this.writeIndexOnly = value;
            return this;
        }

        /**
         * Builds a {@link PutIndexMappingWithIndexRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public PutIndexMappingWithIndexRequest build() {
            _checkSingleUse();

            return new PutIndexMappingWithIndexRequest(this);
        }
    }

    public static final JsonpDeserializer<PutIndexMappingWithIndexRequest> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new,
                    PutIndexMappingWithIndexRequest
                            ::setupPutIndexMappingWithIndexRequestDeserializer);

    protected static void setupPutIndexMappingWithIndexRequestDeserializer(
            ObjectDeserializer<PutIndexMappingWithIndexRequest.Builder> op) {
        op.add(Builder::properties, JsonData._DESERIALIZER, "properties");
    }

    public static final Endpoint<
                    PutIndexMappingWithIndexRequest,
                    PutIndexMappingWithIndexResponse,
                    ErrorResponse>
            _ENDPOINT =
                    new SimpleEndpoint<>(
                            // Request method
                            request -> {
                                return "put";
                            },
                            // Request path
                            request -> {
                                return "/{index}/_mapping";
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
                                if (request.ignoreUnavailable != null) {
                                    params.put(
                                            "ignore_unavailable",
                                            String.valueOf(request.ignoreUnavailable));
                                }
                                if (request.includeTypeName != null) {
                                    params.put(
                                            "include_type_name",
                                            String.valueOf(request.includeTypeName));
                                }
                                if (request.masterTimeout != null) {
                                    params.put("master_timeout", request.masterTimeout);
                                }
                                if (request.timeout != null) {
                                    params.put("timeout", request.timeout);
                                }
                                if (request.writeIndexOnly != null) {
                                    params.put(
                                            "write_index_only",
                                            String.valueOf(request.writeIndexOnly));
                                }
                                return params;
                            },
                            SimpleEndpoint.emptyMap(),
                            true,
                            PutIndexMappingWithIndexResponse._DESERIALIZER);
}
