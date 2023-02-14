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

@JsonpDeserializable
public class GetClusterSettingsResponse implements JsonpSerializable {
    @Nullable private final Map<String, JsonData> defaults;
    @Nullable private final Map<String, JsonData> persistent;
    @Nullable private final Map<String, JsonData> transient_;

    public GetClusterSettingsResponse(Builder builder) {
        this.defaults = ApiTypeHelper.unmodifiable(builder.defaults);
        this.persistent = ApiTypeHelper.unmodifiable(builder.persistent);
        this.transient_ = ApiTypeHelper.unmodifiable(builder.transient_);
    }

    public static GetClusterSettingsResponse of(
            Function<Builder, ObjectBuilder<GetClusterSettingsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final Map<String, JsonData> defaults() {
        return this.defaults;
    }

    public final Map<String, JsonData> persistent() {
        return this.persistent;
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
        if (ApiTypeHelper.isDefined(this.defaults)) {
            generator.writeKey("defaults");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.defaults.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

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

    /** Builder for {@link GetClusterSettingsResponse}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<GetClusterSettingsResponse> {
        private Map<String, JsonData> defaults;
        private Map<String, JsonData> persistent;
        private Map<String, JsonData> transient_;

        public final Builder defaults(Map<String, JsonData> map) {
            this.defaults = _mapPutAll(this.defaults, map);
            return this;
        }

        public final Builder defaults(String key, JsonData value) {
            this.defaults = _mapPut(this.defaults, key, value);
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

        public final Builder transient_(Map<String, JsonData> map) {
            this.transient_ = _mapPutAll(this.transient_, map);
            return this;
        }

        public final Builder transient_(String key, JsonData value) {
            this.transient_ = _mapPut(this.transient_, key, value);
            return this;
        }

        /**
         * Builds a {@link GetClusterSettingsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public GetClusterSettingsResponse build() {
            _checkSingleUse();

            return new GetClusterSettingsResponse(this);
        }
    }

    public static final JsonpDeserializer<GetClusterSettingsResponse> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new,
                    GetClusterSettingsResponse::setupGetClusterSettingsResponseDeserializer);

    protected static void setupGetClusterSettingsResponseDeserializer(
            ObjectDeserializer<GetClusterSettingsResponse.Builder> op) {
        op.add(
                Builder::defaults,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "defaults");
        op.add(
                Builder::persistent,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "persistent");
        op.add(
                Builder::transient_,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "transient");
    }
}
