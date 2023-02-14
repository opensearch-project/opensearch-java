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
public class GetDocumentSourceResponse implements JsonpSerializable {

    public GetDocumentSourceResponse(Builder builder) {}

    public static GetDocumentSourceResponse of(
            Function<Builder, ObjectBuilder<GetDocumentSourceResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {}

    /** Builder for {@link GetDocumentSourceResponse}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<GetDocumentSourceResponse> {

        /**
         * Builds a {@link GetDocumentSourceResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public GetDocumentSourceResponse build() {
            _checkSingleUse();

            return new GetDocumentSourceResponse(this);
        }
    }

    public static final JsonpDeserializer<GetDocumentSourceResponse> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new,
                    GetDocumentSourceResponse::setupGetDocumentSourceResponseDeserializer);

    protected static void setupGetDocumentSourceResponseDeserializer(
            ObjectDeserializer<GetDocumentSourceResponse.Builder> op) {}
}
