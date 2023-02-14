package org.opensearch.client.opensearch;

import org.opensearch.client.json.*;
import org.opensearch.client.util.*;
import jakarta.json.stream.JsonGenerator;
import java.util.*;
import java.util.function.Function;
import javax.annotation.*;

@JsonpDeserializable
public class GetClusterInfoResponse implements JsonpSerializable {
    @Nullable private final String clusterName;
    @Nullable private final String clusterUuid;
    @Nullable private final String name;
    @Nullable private final String tagline;
    @Nullable private final Version version;

    public GetClusterInfoResponse(Builder builder) {
        this.clusterName = builder.clusterName;
        this.clusterUuid = builder.clusterUuid;
        this.name = builder.name;
        this.tagline = builder.tagline;
        this.version = builder.version;
    }

    public static GetClusterInfoResponse of(
            Function<Builder, ObjectBuilder<GetClusterInfoResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final String clusterName() {
        return this.clusterName;
    }

    public final String clusterUuid() {
        return this.clusterUuid;
    }

    public final String name() {
        return this.name;
    }

    public final String tagline() {
        return this.tagline;
    }

    public final Version version() {
        return this.version;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.clusterName != null) {
            generator.writeKey("cluster_name");
            generator.write(this.clusterName);
        }

        if (this.clusterUuid != null) {
            generator.writeKey("cluster_uuid");
            generator.write(this.clusterUuid);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (this.tagline != null) {
            generator.writeKey("tagline");
            generator.write(this.tagline);
        }

        if (this.version != null) {
            generator.writeKey("version");
            this.version.serialize(generator, mapper);
        }
    }

    /** Builder for {@link GetClusterInfoResponse}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<GetClusterInfoResponse> {
        private String clusterName;
        private String clusterUuid;
        private String name;
        private String tagline;
        private Version version;

        public final Builder clusterName(String value) {
            this.clusterName = value;
            return this;
        }

        public final Builder clusterUuid(String value) {
            this.clusterUuid = value;
            return this;
        }

        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        public final Builder tagline(String value) {
            this.tagline = value;
            return this;
        }

        public final Builder version(Version value) {
            this.version = value;
            return this;
        }

        public final Builder version(Function<Version.Builder, ObjectBuilder<Version>> fn) {
            return version(fn.apply(new Version.Builder()).build());
        }

        /**
         * Builds a {@link GetClusterInfoResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public GetClusterInfoResponse build() {
            _checkSingleUse();

            return new GetClusterInfoResponse(this);
        }
    }

    public static final JsonpDeserializer<GetClusterInfoResponse> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new, GetClusterInfoResponse::setupGetClusterInfoResponseDeserializer);

    protected static void setupGetClusterInfoResponseDeserializer(
            ObjectDeserializer<GetClusterInfoResponse.Builder> op) {
        op.add(Builder::clusterName, JsonpDeserializer.stringDeserializer(), "cluster_name");
        op.add(Builder::clusterUuid, JsonpDeserializer.stringDeserializer(), "cluster_uuid");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::tagline, JsonpDeserializer.stringDeserializer(), "tagline");
        op.add(Builder::version, Version._DESERIALIZER, "version");
    }
}
