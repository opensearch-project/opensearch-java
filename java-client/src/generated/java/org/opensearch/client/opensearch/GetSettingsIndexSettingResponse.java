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
public class GetSettingsIndexSettingResponse implements JsonpSerializable {

    public GetSettingsIndexSettingResponse(Builder builder) {}

    public static GetSettingsIndexSettingResponse of(
            Function<Builder, ObjectBuilder<GetSettingsIndexSettingResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {}

    /** Builder for {@link GetSettingsIndexSettingResponse}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<GetSettingsIndexSettingResponse> {

        /**
         * Builds a {@link GetSettingsIndexSettingResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public GetSettingsIndexSettingResponse build() {
            _checkSingleUse();

            return new GetSettingsIndexSettingResponse(this);
        }
    }

    public static final JsonpDeserializer<GetSettingsIndexSettingResponse> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new,
                    GetSettingsIndexSettingResponse
                            ::setupGetSettingsIndexSettingResponseDeserializer);

    protected static void setupGetSettingsIndexSettingResponseDeserializer(
            ObjectDeserializer<GetSettingsIndexSettingResponse.Builder> op) {}
}
