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
public class PostAliasesResponse implements JsonpSerializable {

    private final boolean acknowledged;

    public PostAliasesResponse(Builder builder) {
        this.acknowledged = builder.acknowledged;
    }

    public static PostAliasesResponse of(Function<Builder, ObjectBuilder<PostAliasesResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final boolean acknowledged() {
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

    /** Builder for {@link PostAliasesResponse}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<PostAliasesResponse> {
        private boolean acknowledged;

        public final Builder acknowledged(boolean value) {
            this.acknowledged = value;
            return this;
        }

        /**
         * Builds a {@link PostAliasesResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public PostAliasesResponse build() {
            _checkSingleUse();

            return new PostAliasesResponse(this);
        }
    }

    public static final JsonpDeserializer<PostAliasesResponse> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new, PostAliasesResponse::setupPostAliasesResponseDeserializer);

    protected static void setupPostAliasesResponseDeserializer(
            ObjectDeserializer<PostAliasesResponse.Builder> op) {
        op.add(Builder::acknowledged, JsonpDeserializer.booleanDeserializer(), "acknowledged");
    }
}
