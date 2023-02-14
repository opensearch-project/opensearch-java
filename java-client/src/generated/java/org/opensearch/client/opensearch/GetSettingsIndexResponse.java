package org.opensearch.client.opensearch;

import org.opensearch.client.json.*;
import org.opensearch.client.util.*;
import jakarta.json.stream.JsonGenerator;
import java.util.*;
import java.util.function.Function;
import javax.annotation.*;

@JsonpDeserializable
public class GetSettingsIndexResponse implements JsonpSerializable {

    public GetSettingsIndexResponse(Builder builder) {}

    public static GetSettingsIndexResponse of(
            Function<Builder, ObjectBuilder<GetSettingsIndexResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {}

    /** Builder for {@link GetSettingsIndexResponse}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<GetSettingsIndexResponse> {

        /**
         * Builds a {@link GetSettingsIndexResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public GetSettingsIndexResponse build() {
            _checkSingleUse();

            return new GetSettingsIndexResponse(this);
        }
    }

    public static final JsonpDeserializer<GetSettingsIndexResponse> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new,
                    GetSettingsIndexResponse::setupGetSettingsIndexResponseDeserializer);

    protected static void setupGetSettingsIndexResponseDeserializer(
            ObjectDeserializer<GetSettingsIndexResponse.Builder> op) {}
}
