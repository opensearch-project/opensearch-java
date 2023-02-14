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

/** Adds or removes index aliases. */
@JsonpDeserializable
public class PostAliasesRequest extends RequestBase implements JsonpSerializable {
    @Nullable private final ActionObjectStructure actions;
    @Nullable private final String clusterManagerTimeout;
    @Nullable private final String masterTimeout;
    @Nullable private final String timeout;

    public PostAliasesRequest(Builder builder) {
        this.actions = builder.actions;
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.masterTimeout = builder.masterTimeout;
        this.timeout = builder.timeout;
    }

    public static PostAliasesRequest of(Function<Builder, ObjectBuilder<PostAliasesRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final ActionObjectStructure actions() {
        return this.actions;
    }

    public final String clusterManagerTimeout() {
        return this.clusterManagerTimeout;
    }

    public final String masterTimeout() {
        return this.masterTimeout;
    }

    public final String timeout() {
        return this.timeout;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.actions != null) {
            generator.writeKey("actions");
            this.actions.serialize(generator, mapper);
        }
    }

    /** Builder for {@link PostAliasesRequest}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<PostAliasesRequest> {
        private ActionObjectStructure actions;
        private String clusterManagerTimeout;
        private String masterTimeout;
        private String timeout;

        public final Builder actions(ActionObjectStructure value) {
            this.actions = value;
            return this;
        }

        public final Builder actions(
                Function<ActionObjectStructure.Builder, ObjectBuilder<ActionObjectStructure>> fn) {
            return actions(fn.apply(new ActionObjectStructure.Builder()).build());
        }

        public final Builder clusterManagerTimeout(String value) {
            this.clusterManagerTimeout = value;
            return this;
        }

        public final Builder masterTimeout(String value) {
            this.masterTimeout = value;
            return this;
        }

        public final Builder timeout(String value) {
            this.timeout = value;
            return this;
        }

        /**
         * Builds a {@link PostAliasesRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public PostAliasesRequest build() {
            _checkSingleUse();

            return new PostAliasesRequest(this);
        }
    }

    public static final JsonpDeserializer<PostAliasesRequest> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new, PostAliasesRequest::setupPostAliasesRequestDeserializer);

    protected static void setupPostAliasesRequestDeserializer(
            ObjectDeserializer<PostAliasesRequest.Builder> op) {
        op.add(Builder::actions, ActionObjectStructure._DESERIALIZER, "actions");
    }

    public static final Endpoint<PostAliasesRequest, PostAliasesResponse, ErrorResponse> _ENDPOINT =
            new SimpleEndpoint<>(
                    // Request method
                    request -> {
                        return "post";
                    },
                    // Request path
                    request -> {
                        return "/_aliases";
                    },
                    // Request parameters
                    request -> {
                        Map<String, String> params = new HashMap<>();
                        if (request.clusterManagerTimeout != null) {
                            params.put("cluster_manager_timeout", request.clusterManagerTimeout);
                        }
                        if (request.masterTimeout != null) {
                            params.put("master_timeout", request.masterTimeout);
                        }
                        if (request.timeout != null) {
                            params.put("timeout", request.timeout);
                        }
                        return params;
                    },
                    SimpleEndpoint.emptyMap(),
                    true,
                    PostAliasesResponse._DESERIALIZER);
}
