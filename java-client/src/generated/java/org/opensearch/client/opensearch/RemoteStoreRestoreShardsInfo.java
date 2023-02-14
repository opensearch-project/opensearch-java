package org.opensearch.client.opensearch;

import org.opensearch.client.json.*;
import org.opensearch.client.util.*;
import jakarta.json.stream.JsonGenerator;
import java.util.*;
import java.util.function.Function;
import javax.annotation.*;

@JsonpDeserializable
public class RemoteStoreRestoreShardsInfo implements JsonpSerializable {
    @Nullable private final Integer failed;
    @Nullable private final Integer successful;
    @Nullable private final Integer total;

    public RemoteStoreRestoreShardsInfo(Builder builder) {
        this.failed = builder.failed;
        this.successful = builder.successful;
        this.total = builder.total;
    }

    public static RemoteStoreRestoreShardsInfo of(
            Function<Builder, ObjectBuilder<RemoteStoreRestoreShardsInfo>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final Integer failed() {
        return this.failed;
    }

    public final Integer successful() {
        return this.successful;
    }

    public final Integer total() {
        return this.total;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.failed != null) {
            generator.writeKey("failed");
            generator.write(this.failed);
        }

        if (this.successful != null) {
            generator.writeKey("successful");
            generator.write(this.successful);
        }

        if (this.total != null) {
            generator.writeKey("total");
            generator.write(this.total);
        }
    }

    /** Builder for {@link RemoteStoreRestoreShardsInfo}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<RemoteStoreRestoreShardsInfo> {
        private Integer failed;
        private Integer successful;
        private Integer total;

        public final Builder failed(Integer value) {
            this.failed = value;
            return this;
        }

        public final Builder successful(Integer value) {
            this.successful = value;
            return this;
        }

        public final Builder total(Integer value) {
            this.total = value;
            return this;
        }

        /**
         * Builds a {@link RemoteStoreRestoreShardsInfo}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public RemoteStoreRestoreShardsInfo build() {
            _checkSingleUse();

            return new RemoteStoreRestoreShardsInfo(this);
        }
    }

    public static final JsonpDeserializer<RemoteStoreRestoreShardsInfo> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new,
                    RemoteStoreRestoreShardsInfo::setupRemoteStoreRestoreShardsInfoDeserializer);

    protected static void setupRemoteStoreRestoreShardsInfoDeserializer(
            ObjectDeserializer<RemoteStoreRestoreShardsInfo.Builder> op) {
        op.add(Builder::failed, JsonpDeserializer.integerDeserializer(), "failed");
        op.add(Builder::successful, JsonpDeserializer.integerDeserializer(), "successful");
        op.add(Builder::total, JsonpDeserializer.integerDeserializer(), "total");
    }
}
