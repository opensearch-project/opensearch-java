package org.opensearch.client.opensearch;

import org.opensearch.client.json.*;
import org.opensearch.client.util.*;
import jakarta.json.stream.JsonGenerator;
import java.util.*;
import java.util.function.Function;
import javax.annotation.*;

@JsonpDeserializable
public class PutUpdateClusterSettingsResponse implements JsonpSerializable {
    @Nullable private final Boolean acknowledged;
    @Nullable private final Map<String, JsonData> persistent;
    @Nullable private final Map<String, JsonData> transient_;

    public PutUpdateClusterSettingsResponse(Builder builder) {
        this.acknowledged = builder.acknowledged;
        this.persistent = ApiTypeHelper.unmodifiable(builder.persistent);
        this.transient_ = ApiTypeHelper.unmodifiable(builder.transient_);
    }

    public static PutUpdateClusterSettingsResponse of(
            Function<Builder, ObjectBuilder<PutUpdateClusterSettingsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final Boolean acknowledged() {
        return this.acknowledged;
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
        if (this.acknowledged != null) {
            generator.writeKey("acknowledged");
            generator.write(this.acknowledged);
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

    /** Builder for {@link PutUpdateClusterSettingsResponse}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<PutUpdateClusterSettingsResponse> {
        private Boolean acknowledged;
        private Map<String, JsonData> persistent;
        private Map<String, JsonData> transient_;

        public final Builder acknowledged(Boolean value) {
            this.acknowledged = value;
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
         * Builds a {@link PutUpdateClusterSettingsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public PutUpdateClusterSettingsResponse build() {
            _checkSingleUse();

            return new PutUpdateClusterSettingsResponse(this);
        }
    }

    public static final JsonpDeserializer<PutUpdateClusterSettingsResponse> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new,
                    PutUpdateClusterSettingsResponse
                            ::setupPutUpdateClusterSettingsResponseDeserializer);

    protected static void setupPutUpdateClusterSettingsResponseDeserializer(
            ObjectDeserializer<PutUpdateClusterSettingsResponse.Builder> op) {
        op.add(Builder::acknowledged, JsonpDeserializer.booleanDeserializer(), "acknowledged");
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
