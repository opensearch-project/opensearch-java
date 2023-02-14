package org.opensearch.client.opensearch;

import org.opensearch.client.json.*;
import org.opensearch.client.util.*;
import jakarta.json.stream.JsonGenerator;
import java.util.*;
import java.util.function.Function;
import javax.annotation.*;

@JsonpDeserializable
public class GetCatIndicesWithIndexResponse implements JsonpSerializable {

    public GetCatIndicesWithIndexResponse(Builder builder) {}

    public static GetCatIndicesWithIndexResponse of(
            Function<Builder, ObjectBuilder<GetCatIndicesWithIndexResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {}

    /** Builder for {@link GetCatIndicesWithIndexResponse}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<GetCatIndicesWithIndexResponse> {

        /**
         * Builds a {@link GetCatIndicesWithIndexResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public GetCatIndicesWithIndexResponse build() {
            _checkSingleUse();

            return new GetCatIndicesWithIndexResponse(this);
        }
    }

    public static final JsonpDeserializer<GetCatIndicesWithIndexResponse> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new,
                    GetCatIndicesWithIndexResponse
                            ::setupGetCatIndicesWithIndexResponseDeserializer);

    protected static void setupGetCatIndicesWithIndexResponseDeserializer(
            ObjectDeserializer<GetCatIndicesWithIndexResponse.Builder> op) {}
}
