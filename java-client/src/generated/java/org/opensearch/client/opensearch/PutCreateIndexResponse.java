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
public class PutCreateIndexResponse implements JsonpSerializable {

    private final boolean acknowledged;

    private final String index;

    private final boolean shardsAcknowledged;

    public PutCreateIndexResponse(Builder builder) {
        this.acknowledged = builder.acknowledged;
        this.index = builder.index;
        this.shardsAcknowledged = builder.shardsAcknowledged;
    }

    public static PutCreateIndexResponse of(
            Function<Builder, ObjectBuilder<PutCreateIndexResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final boolean acknowledged() {
        return this.acknowledged;
    }

    public final String index() {
        return this.index;
    }

    public final boolean shardsAcknowledged() {
        return this.shardsAcknowledged;
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

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.shardsAcknowledged != null) {
            generator.writeKey("shards_acknowledged");
            generator.write(this.shardsAcknowledged);
        }
    }

    /** Builder for {@link PutCreateIndexResponse}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<PutCreateIndexResponse> {
        private boolean acknowledged;
        private String index;
        private boolean shardsAcknowledged;

        public final Builder acknowledged(boolean value) {
            this.acknowledged = value;
            return this;
        }

        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        public final Builder shardsAcknowledged(boolean value) {
            this.shardsAcknowledged = value;
            return this;
        }

        /**
         * Builds a {@link PutCreateIndexResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public PutCreateIndexResponse build() {
            _checkSingleUse();

            return new PutCreateIndexResponse(this);
        }
    }

    public static final JsonpDeserializer<PutCreateIndexResponse> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new, PutCreateIndexResponse::setupPutCreateIndexResponseDeserializer);

    protected static void setupPutCreateIndexResponseDeserializer(
            ObjectDeserializer<PutCreateIndexResponse.Builder> op) {
        op.add(Builder::acknowledged, JsonpDeserializer.booleanDeserializer(), "acknowledged");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(
                Builder::shardsAcknowledged,
                JsonpDeserializer.booleanDeserializer(),
                "shards_acknowledged");
    }
}
