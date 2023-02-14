package org.opensearch.client.opensearch;

import org.opensearch.client.json.*;
import org.opensearch.client.util.*;
import jakarta.json.stream.JsonGenerator;
import java.util.*;
import java.util.function.Function;
import javax.annotation.*;

@JsonpDeserializable
public class DeleteIndexResponse implements JsonpSerializable {
    @Nullable private final Boolean acknowledged;

    public DeleteIndexResponse(Builder builder) {
        this.acknowledged = builder.acknowledged;
    }

    public static DeleteIndexResponse of(Function<Builder, ObjectBuilder<DeleteIndexResponse>> fn) {
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

    /** Builder for {@link DeleteIndexResponse}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<DeleteIndexResponse> {
        private Boolean acknowledged;

        public final Builder acknowledged(Boolean value) {
            this.acknowledged = value;
            return this;
        }

        /**
         * Builds a {@link DeleteIndexResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public DeleteIndexResponse build() {
            _checkSingleUse();

            return new DeleteIndexResponse(this);
        }
    }

    public static final JsonpDeserializer<DeleteIndexResponse> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new, DeleteIndexResponse::setupDeleteIndexResponseDeserializer);

    protected static void setupDeleteIndexResponseDeserializer(
            ObjectDeserializer<DeleteIndexResponse.Builder> op) {
        op.add(Builder::acknowledged, JsonpDeserializer.booleanDeserializer(), "acknowledged");
    }
}
