package org.opensearch.client.opensearch;

import org.opensearch.client.json.*;
import org.opensearch.client.util.*;
import jakarta.json.stream.JsonGenerator;
import java.util.*;
import java.util.function.Function;
import javax.annotation.*;

@JsonpDeserializable
public class GetCatNodesResponse implements JsonpSerializable {

    public GetCatNodesResponse(Builder builder) {}

    public static GetCatNodesResponse of(Function<Builder, ObjectBuilder<GetCatNodesResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {}

    /** Builder for {@link GetCatNodesResponse}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<GetCatNodesResponse> {

        /**
         * Builds a {@link GetCatNodesResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public GetCatNodesResponse build() {
            _checkSingleUse();

            return new GetCatNodesResponse(this);
        }
    }

    public static final JsonpDeserializer<GetCatNodesResponse> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new, GetCatNodesResponse::setupGetCatNodesResponseDeserializer);

    protected static void setupGetCatNodesResponseDeserializer(
            ObjectDeserializer<GetCatNodesResponse.Builder> op) {}
}
