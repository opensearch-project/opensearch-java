package org.opensearch.client.opensearch.remotestore;

import org.opensearch.client.opensearch._types.*;
import org.opensearch.client.json.*;
import org.opensearch.client.transport.*;
import org.opensearch.client.transport.endpoints.*;
import org.opensearch.client.util.*;
import jakarta.json.stream.JsonGenerator;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import javax.annotation.*;

/** Restore one or more indices from a remote backup. */
@JsonpDeserializable
public class PostRemoteStoreRestoreRequest extends RequestBase implements JsonpSerializable {

    @Nullable private final String clusterManagerTimeout;

    private final List<String> indices;

    @Nullable private final Boolean waitForCompletion;

    public PostRemoteStoreRestoreRequest(Builder builder) {
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.indices = ApiTypeHelper.unmodifiableRequired(builder.indices, this, "indices");
        this.waitForCompletion = builder.waitForCompletion;
    }

    public static PostRemoteStoreRestoreRequest of(
            Function<Builder, ObjectBuilder<PostRemoteStoreRestoreRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final String clusterManagerTimeout() {
        return this.clusterManagerTimeout;
    }

    public final List<String> indices() {
        return this.indices;
    }

    public final Boolean waitForCompletion() {
        return this.waitForCompletion;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeKey("indices");
        generator.writeStartArray();
        for (String item0 : this.indices) {
            generator.write(item0);
        }
        generator.writeEnd();
    }

    /** Builder for {@link PostRemoteStoreRestoreRequest}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<PostRemoteStoreRestoreRequest> {
        private String clusterManagerTimeout;
        private List<String> indices;
        private Boolean waitForCompletion;

        public final Builder clusterManagerTimeout(String value) {
            this.clusterManagerTimeout = value;
            return this;
        }

        public final Builder indices(List<String> list) {
            this.indices = _listAddAll(this.indices, list);
            return this;
        }

        public final Builder indices(String value, String... values) {
            this.indices = _listAdd(this.indices, value, values);
            return this;
        }

        public final Builder waitForCompletion(Boolean value) {
            this.waitForCompletion = value;
            return this;
        }

        /**
         * Builds a {@link PostRemoteStoreRestoreRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public PostRemoteStoreRestoreRequest build() {
            _checkSingleUse();

            return new PostRemoteStoreRestoreRequest(this);
        }
    }

    public static final JsonpDeserializer<PostRemoteStoreRestoreRequest> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new,
                    PostRemoteStoreRestoreRequest::setupPostRemoteStoreRestoreRequestDeserializer);

    protected static void setupPostRemoteStoreRestoreRequestDeserializer(
            ObjectDeserializer<PostRemoteStoreRestoreRequest.Builder> op) {
        op.add(
                Builder::indices,
                JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
                "indices");
    }

    public static final Endpoint<
                    PostRemoteStoreRestoreRequest, PostRemoteStoreRestoreResponse, ErrorResponse>
            _ENDPOINT =
                    new SimpleEndpoint<>(
                            // Request method
                            request -> {
                                return "post";
                            },
                            // Request path
                            request -> {
                                return "/_remotestore/_restore";
                            },
                            // Request parameters
                            request -> {
                                Map<String, String> params = new HashMap<>();
                                if (request.clusterManagerTimeout != null) {
                                    params.put(
                                            "cluster_manager_timeout",
                                            request.clusterManagerTimeout);
                                }
                                if (request.waitForCompletion != null) {
                                    params.put(
                                            "wait_for_completion",
                                            String.valueOf(request.waitForCompletion));
                                }
                                return params;
                            },
                            SimpleEndpoint.emptyMap(),
                            true,
                            PostRemoteStoreRestoreResponse._DESERIALIZER);
}
