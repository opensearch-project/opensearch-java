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

/** Updates the cluster settings. */
@JsonpDeserializable
public class PutUpdateClusterSettingsRequest extends RequestBase implements JsonpSerializable {
    private final String clusterManagerTimeout;
    private final boolean flatSettings;
    private final String masterTimeout;
    private final Map<String, JsonData> persistent;
    private final String timeout;
    private final Map<String, JsonData> transient_;

    public PutUpdateClusterSettingsRequest(Builder builder) {
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.flatSettings = builder.flatSettings;
        this.masterTimeout = builder.masterTimeout;
        this.persistent = ApiTypeHelper.unmodifiable(builder.persistent);
        this.timeout = builder.timeout;
        this.transient_ = ApiTypeHelper.unmodifiable(builder.transient_);
    }

    public static PutUpdateClusterSettingsRequest of(
            Function<Builder, ObjectBuilder<PutUpdateClusterSettingsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final String clusterManagerTimeout() {
        return this.clusterManagerTimeout;
    }

    public final boolean flatSettings() {
        return this.flatSettings;
    }

    public final String masterTimeout() {
        return this.masterTimeout;
    }

    public final Map<String, JsonData> persistent() {
        return this.persistent;
    }

    public final String timeout() {
        return this.timeout;
    }

    public final Map<String, JsonData> transient_() {
        return this.transient_;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (ApiTypeHelper.isDefined(this.persistent)) {
            generator.writeKey("persistent");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.persistent.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.transient_)) {
            generator.writeKey("transient");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.transient_.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }
    }

    /** Builder for {@link PutUpdateClusterSettingsRequest}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<PutUpdateClusterSettingsRequest> {
        private String clusterManagerTimeout;
        private boolean flatSettings;
        private String masterTimeout;
        private Map<String, JsonData> persistent;
        private String timeout;
        private Map<String, JsonData> transient_;

        public final Builder clusterManagerTimeout(String value) {
            this.clusterManagerTimeout = value;
            return this;
        }

        public final Builder flatSettings(boolean value) {
            this.flatSettings = value;
            return this;
        }

        public final Builder masterTimeout(String value) {
            this.masterTimeout = value;
            return this;
        }

        public final Builder persistent(Map<String, JsonData> map) {
            this.persistent = _mapPutAll(this.persistent, map);
            return this;
        }

        public final Builder persistent(String key, JsonData value) {
            this.persistent = _mapPut(this.persistent, key, value);
            return this;
        }

        public final Builder timeout(String value) {
            this.timeout = value;
            return this;
        }

        public final Builder transient_(Map<String, JsonData> map) {
            this.transient_ = _mapPutAll(this.transient_, map);
            return this;
        }

        public final Builder transient_(String key, JsonData value) {
            this.transient_ = _mapPut(this.transient_, key, value);
            return this;
        }

        /**
         * Builds a {@link PutUpdateClusterSettingsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public PutUpdateClusterSettingsRequest build() {
            _checkSingleUse();

            return new PutUpdateClusterSettingsRequest(this);
        }
    }

    public static final JsonpDeserializer<PutUpdateClusterSettingsRequest> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new,
                    PutUpdateClusterSettingsRequest
                            ::setupPutUpdateClusterSettingsRequestDeserializer);

    protected static void setupPutUpdateClusterSettingsRequestDeserializer(
            ObjectDeserializer<PutUpdateClusterSettingsRequest.Builder> op) {
        op.add(
                Builder::persistent,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "persistent");
        op.add(
                Builder::transient_,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "transient");
    }

    public static final Endpoint<
                    PutUpdateClusterSettingsRequest,
                    PutUpdateClusterSettingsResponse,
                    ErrorResponse>
            _ENDPOINT =
                    new SimpleEndpoint<>(
                            // Request method
                            request -> {
                                return "put";
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
                                if (request.masterTimeout != null) {
                                    params.put("master_timeout", request.masterTimeout);
                                }
                                if (request.timeout != null) {
                                    params.put("timeout", request.timeout);
                                }
                                return params;
                            },
                            SimpleEndpoint.emptyMap(),
                            true,
                            PutUpdateClusterSettingsResponse._DESERIALIZER);
}
