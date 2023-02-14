package org.opensearch.client.opensearch;

import org.opensearch.client.opensearch._types.*;
import org.opensearch.client.json.*;
import org.opensearch.client.transport.*;
import org.opensearch.client.transport.endpoints.*;
import org.opensearch.client.util.*;
import jakarta.json.stream.JsonGenerator;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import javax.annotation.*;

/** Creates index mappings. */
@JsonpDeserializable
public class PutCreateIndexRequest extends RequestBase implements JsonpSerializable {
    @Nullable private final Map<String, JsonData> aliases;
    @Nullable private final String clusterManagerTimeout;
    @Nullable private final Boolean includeTypeName;
    @Nullable private final Map<String, JsonData> mapping;
    @Nullable private final String masterTimeout;
    @Nullable private final Map<String, JsonData> settings;
    @Nullable private final String timeout;
    @Nullable private final String waitForActiveShards;

    public PutCreateIndexRequest(Builder builder) {
        this.aliases = ApiTypeHelper.unmodifiable(builder.aliases);
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.includeTypeName = builder.includeTypeName;
        this.mapping = ApiTypeHelper.unmodifiable(builder.mapping);
        this.masterTimeout = builder.masterTimeout;
        this.settings = ApiTypeHelper.unmodifiable(builder.settings);
        this.timeout = builder.timeout;
        this.waitForActiveShards = builder.waitForActiveShards;
    }

    public static PutCreateIndexRequest of(
            Function<Builder, ObjectBuilder<PutCreateIndexRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final Map<String, JsonData> aliases() {
        return this.aliases;
    }

    public final String clusterManagerTimeout() {
        return this.clusterManagerTimeout;
    }

    public final Boolean includeTypeName() {
        return this.includeTypeName;
    }

    public final Map<String, JsonData> mapping() {
        return this.mapping;
    }

    public final String masterTimeout() {
        return this.masterTimeout;
    }

    public final Map<String, JsonData> settings() {
        return this.settings;
    }

    public final String timeout() {
        return this.timeout;
    }

    public final String waitForActiveShards() {
        return this.waitForActiveShards;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (ApiTypeHelper.isDefined(this.aliases)) {
            generator.writeKey("aliases");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.aliases.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.mapping)) {
            generator.writeKey("mapping");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.mapping.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.settings)) {
            generator.writeKey("settings");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.settings.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }
    }

    /** Builder for {@link PutCreateIndexRequest}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<PutCreateIndexRequest> {
        private Map<String, JsonData> aliases;
        private String clusterManagerTimeout;
        private Boolean includeTypeName;
        private Map<String, JsonData> mapping;
        private String masterTimeout;
        private Map<String, JsonData> settings;
        private String timeout;
        private String waitForActiveShards;

        public final Builder aliases(Map<String, JsonData> map) {
            this.aliases = _mapPutAll(this.aliases, map);
            return this;
        }

        public final Builder aliases(String key, JsonData value) {
            this.aliases = _mapPut(this.aliases, key, value);
            return this;
        }

        public final Builder clusterManagerTimeout(String value) {
            this.clusterManagerTimeout = value;
            return this;
        }

        public final Builder includeTypeName(Boolean value) {
            this.includeTypeName = value;
            return this;
        }

        public final Builder mapping(Map<String, JsonData> map) {
            this.mapping = _mapPutAll(this.mapping, map);
            return this;
        }

        public final Builder mapping(String key, JsonData value) {
            this.mapping = _mapPut(this.mapping, key, value);
            return this;
        }

        public final Builder masterTimeout(String value) {
            this.masterTimeout = value;
            return this;
        }

        public final Builder settings(Map<String, JsonData> map) {
            this.settings = _mapPutAll(this.settings, map);
            return this;
        }

        public final Builder settings(String key, JsonData value) {
            this.settings = _mapPut(this.settings, key, value);
            return this;
        }

        public final Builder timeout(String value) {
            this.timeout = value;
            return this;
        }

        public final Builder waitForActiveShards(String value) {
            this.waitForActiveShards = value;
            return this;
        }

        /**
         * Builds a {@link PutCreateIndexRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public PutCreateIndexRequest build() {
            _checkSingleUse();

            return new PutCreateIndexRequest(this);
        }
    }

    public static final JsonpDeserializer<PutCreateIndexRequest> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new, PutCreateIndexRequest::setupPutCreateIndexRequestDeserializer);

    protected static void setupPutCreateIndexRequestDeserializer(
            ObjectDeserializer<PutCreateIndexRequest.Builder> op) {
        op.add(
                Builder::aliases,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "aliases");
        op.add(
                Builder::mapping,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "mapping");
        op.add(
                Builder::settings,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "settings");
    }

    public static final Endpoint<PutCreateIndexRequest, PutCreateIndexResponse, ErrorResponse>
            _ENDPOINT =
                    new SimpleEndpoint<>(
                            // Request method
                            request -> {
                                return "put";
                            },
                            // Request path
                            request -> {
                                return "/{index}";
                            },
                            // Request parameters
                            request -> {
                                Map<String, String> params = new HashMap<>();
                                if (request.clusterManagerTimeout != null) {
                                    params.put(
                                            "cluster_manager_timeout",
                                            request.clusterManagerTimeout);
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
                                if (request.waitForActiveShards != null) {
                                    params.put(
                                            "wait_for_active_shards", request.waitForActiveShards);
                                }
                                return params;
                            },
                            SimpleEndpoint.emptyMap(),
                            true,
                            PutCreateIndexResponse._DESERIALIZER);
}
