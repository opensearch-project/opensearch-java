package org.opensearch.client.opensearch.remotestore;

import org.opensearch.client.json.*;
import org.opensearch.client.util.*;
import jakarta.json.stream.JsonGenerator;
import java.util.*;
import java.util.function.Function;
import javax.annotation.*;

@JsonpDeserializable
public class PostRemoteStoreRestoreResponse implements JsonpSerializable {

    @Nullable private final Boolean accepted;

    @Nullable private final String remoteStore;

    public PostRemoteStoreRestoreResponse(Builder builder) {
        this.accepted = builder.accepted;
        this.remoteStore = builder.remoteStore;
    }

    public static PostRemoteStoreRestoreResponse of(
            Function<Builder, ObjectBuilder<PostRemoteStoreRestoreResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final Boolean accepted() {
        return this.accepted;
    }

    public final String remoteStore() {
        return this.remoteStore;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.accepted != null) {
            generator.writeKey("accepted");
            generator.write(this.accepted);
        }

        if (this.remoteStore != null) {
            generator.writeKey("remote_store");
            generator.write(this.remoteStore);
        }
    }

    /** Builder for {@link PostRemoteStoreRestoreResponse}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<PostRemoteStoreRestoreResponse> {
        private Boolean accepted;
        private String remoteStore;

        public final Builder accepted(Boolean value) {
            this.accepted = value;
            return this;
        }

        public final Builder remoteStore(String value) {
            this.remoteStore = value;
            return this;
        }

        /**
         * Builds a {@link PostRemoteStoreRestoreResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public PostRemoteStoreRestoreResponse build() {
            _checkSingleUse();

            return new PostRemoteStoreRestoreResponse(this);
        }
    }

    public static final JsonpDeserializer<PostRemoteStoreRestoreResponse> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new,
                    PostRemoteStoreRestoreResponse
                            ::setupPostRemoteStoreRestoreResponseDeserializer);

    protected static void setupPostRemoteStoreRestoreResponseDeserializer(
            ObjectDeserializer<PostRemoteStoreRestoreResponse.Builder> op) {
        op.add(Builder::accepted, JsonpDeserializer.booleanDeserializer(), "accepted");
        op.add(Builder::remoteStore, JsonpDeserializer.stringDeserializer(), "remote_store");
    }
}
