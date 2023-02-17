/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.remotestore;

import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Nullable;

@JsonpDeserializable
public class PostRemoteStoreRestoreResponse implements JsonpSerializable {

    @Nullable private final Boolean accepted;

    @Nullable private final RemoteStoreRestoreInfo remoteStore;

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

    public final RemoteStoreRestoreInfo remoteStore() {
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
            this.remoteStore.serialize(generator, mapper);
        }
    }

    /** Builder for {@link PostRemoteStoreRestoreResponse}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<PostRemoteStoreRestoreResponse> {
        private Boolean accepted;
        private RemoteStoreRestoreInfo remoteStore;

        public final Builder accepted(Boolean value) {
            this.accepted = value;
            return this;
        }

        public final Builder remoteStore(RemoteStoreRestoreInfo value) {
            this.remoteStore = value;
            return this;
        }

        public final Builder remoteStore(
                Function<RemoteStoreRestoreInfo.Builder, ObjectBuilder<RemoteStoreRestoreInfo>>
                        fn) {
            return remoteStore(fn.apply(new RemoteStoreRestoreInfo.Builder()).build());
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
        op.add(Builder::remoteStore, RemoteStoreRestoreInfo._DESERIALIZER, "remote_store");
    }
}
