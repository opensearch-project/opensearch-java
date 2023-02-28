/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

// ----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
// ----------------------------------------------------

package org.opensearch.client.opensearch.remotestore;

import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

/** Restore one or more indices from a remote backup. */
@JsonpDeserializable
public class RestoreRequest extends RequestBase implements JsonpSerializable {

    @Nullable private final String clusterManagerTimeout;

    private final List<String> indices;

    @Nullable private final Boolean waitForCompletion;

    public RestoreRequest(Builder builder) {
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.indices = ApiTypeHelper.unmodifiableRequired(builder.indices, this, "indices");
        this.waitForCompletion = builder.waitForCompletion;
    }

    public static RestoreRequest of(Function<Builder, ObjectBuilder<RestoreRequest>> fn) {
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

    /** Builder for {@link RestoreRequest}. */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<RestoreRequest> {
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
         * Builds a {@link RestoreRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public RestoreRequest build() {
            _checkSingleUse();

            return new RestoreRequest(this);
        }
    }

    public static final JsonpDeserializer<RestoreRequest> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new, RestoreRequest::setupRestoreRequestDeserializer);

    protected static void setupRestoreRequestDeserializer(
            ObjectDeserializer<RestoreRequest.Builder> op) {
        op.add(
                Builder::indices,
                JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
                "indices");
    }

    public static final Endpoint<RestoreRequest, RestoreResponse, ErrorResponse> _ENDPOINT =
            new SimpleEndpoint<>(
                    // Request method
                    request -> {
                        return "post";
                    },
                    // Request path
                    request -> {
                        StringBuilder buf = new StringBuilder();
                        buf.append("/_remotestore/_restore");
                        return buf.toString();
                    },
                    // Request parameters
                    request -> {
                        Map<String, String> params = new HashMap<>();
                        if (request.clusterManagerTimeout != null) {
                            params.put("cluster_manager_timeout", request.clusterManagerTimeout);
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
                    RestoreResponse._DESERIALIZER);
}
