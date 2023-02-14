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
public class RemoteStoreRestoreInfo implements JsonpSerializable {
    @Nullable private final List<String> indices;
    @Nullable private final RemoteStoreRestoreShardsInfo shards;
    @Nullable private final String snapshot;

    public RemoteStoreRestoreInfo(Builder builder) {
        this.indices = ApiTypeHelper.unmodifiable(builder.indices);
        this.shards = builder.shards;
        this.snapshot = builder.snapshot;
    }

    public static RemoteStoreRestoreInfo of(
            Function<Builder, ObjectBuilder<RemoteStoreRestoreInfo>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final List<String> indices() {
        return this.indices;
    }

    public final RemoteStoreRestoreShardsInfo shards() {
        return this.shards;
    }

    public final String snapshot() {
        return this.snapshot;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (ApiTypeHelper.isDefined(this.indices)) {
            generator.writeKey("indices");
            generator.writeStartArray();
            for (String item0 : this.indices) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.shards != null) {
            generator.writeKey("shards");
            this.shards.serialize(generator, mapper);
        }

        if (this.snapshot != null) {
            generator.writeKey("snapshot");
            generator.write(this.snapshot);
        }
    }

    /** Builder for {@link RemoteStoreRestoreInfo}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<RemoteStoreRestoreInfo> {
        private List<String> indices;
        private RemoteStoreRestoreShardsInfo shards;
        private String snapshot;

        public final Builder indices(List<String> list) {
            this.indices = _listAddAll(this.indices, list);
            return this;
        }

        public final Builder indices(String value, String... values) {
            this.indices = _listAdd(this.indices, value, values);
            return this;
        }

        public final Builder shards(RemoteStoreRestoreShardsInfo value) {
            this.shards = value;
            return this;
        }

        public final Builder shards(
                Function<
                                RemoteStoreRestoreShardsInfo.Builder,
                                ObjectBuilder<RemoteStoreRestoreShardsInfo>>
                        fn) {
            return shards(fn.apply(new RemoteStoreRestoreShardsInfo.Builder()).build());
        }

        public final Builder snapshot(String value) {
            this.snapshot = value;
            return this;
        }

        /**
         * Builds a {@link RemoteStoreRestoreInfo}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public RemoteStoreRestoreInfo build() {
            _checkSingleUse();

            return new RemoteStoreRestoreInfo(this);
        }
    }

    public static final JsonpDeserializer<RemoteStoreRestoreInfo> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new, RemoteStoreRestoreInfo::setupRemoteStoreRestoreInfoDeserializer);

    protected static void setupRemoteStoreRestoreInfoDeserializer(
            ObjectDeserializer<RemoteStoreRestoreInfo.Builder> op) {
        op.add(
                Builder::indices,
                JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
                "indices");
        op.add(Builder::shards, RemoteStoreRestoreShardsInfo._DESERIALIZER, "shards");
        op.add(Builder::snapshot, JsonpDeserializer.stringDeserializer(), "snapshot");
    }
}
