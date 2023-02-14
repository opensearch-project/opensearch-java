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
public class GetCatIndicesResponse implements JsonpSerializable {

    public GetCatIndicesResponse(Builder builder) {}

    public static GetCatIndicesResponse of(
            Function<Builder, ObjectBuilder<GetCatIndicesResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {}

    /** Builder for {@link GetCatIndicesResponse}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<GetCatIndicesResponse> {

        /**
         * Builds a {@link GetCatIndicesResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public GetCatIndicesResponse build() {
            _checkSingleUse();

            return new GetCatIndicesResponse(this);
        }
    }

    public static final JsonpDeserializer<GetCatIndicesResponse> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new, GetCatIndicesResponse::setupGetCatIndicesResponseDeserializer);

    protected static void setupGetCatIndicesResponseDeserializer(
            ObjectDeserializer<GetCatIndicesResponse.Builder> op) {}
}
