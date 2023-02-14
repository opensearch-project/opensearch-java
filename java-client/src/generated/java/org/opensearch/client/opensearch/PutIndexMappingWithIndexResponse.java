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
public class PutIndexMappingWithIndexResponse implements JsonpSerializable {
    @Nullable private final Boolean acknowledged;

    public PutIndexMappingWithIndexResponse(Builder builder) {
        this.acknowledged = builder.acknowledged;
    }

    public static PutIndexMappingWithIndexResponse of(
            Function<Builder, ObjectBuilder<PutIndexMappingWithIndexResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final Boolean acknowledged() {
        return this.acknowledged;
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
    }

    /** Builder for {@link PutIndexMappingWithIndexResponse}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<PutIndexMappingWithIndexResponse> {
        private Boolean acknowledged;

        public final Builder acknowledged(Boolean value) {
            this.acknowledged = value;
            return this;
        }

        /**
         * Builds a {@link PutIndexMappingWithIndexResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public PutIndexMappingWithIndexResponse build() {
            _checkSingleUse();

            return new PutIndexMappingWithIndexResponse(this);
        }
    }

    public static final JsonpDeserializer<PutIndexMappingWithIndexResponse> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new,
                    PutIndexMappingWithIndexResponse
                            ::setupPutIndexMappingWithIndexResponseDeserializer);

    protected static void setupPutIndexMappingWithIndexResponseDeserializer(
            ObjectDeserializer<PutIndexMappingWithIndexResponse.Builder> op) {
        op.add(Builder::acknowledged, JsonpDeserializer.booleanDeserializer(), "acknowledged");
    }
}
