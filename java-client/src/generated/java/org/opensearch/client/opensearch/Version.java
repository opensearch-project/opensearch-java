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
public class Version implements JsonpSerializable {
    @Nullable private final String buildDate;
    @Nullable private final String buildHash;
    @Nullable private final Boolean buildSnapshot;
    @Nullable private final String buildType;
    @Nullable private final String distribution;
    @Nullable private final String luceneVersion;
    @Nullable private final String minimumIndexCompatibilityVersion;
    @Nullable private final String minimumWireCompatibilityVersion;
    @Nullable private final String number;

    public Version(Builder builder) {
        this.buildDate = builder.buildDate;
        this.buildHash = builder.buildHash;
        this.buildSnapshot = builder.buildSnapshot;
        this.buildType = builder.buildType;
        this.distribution = builder.distribution;
        this.luceneVersion = builder.luceneVersion;
        this.minimumIndexCompatibilityVersion = builder.minimumIndexCompatibilityVersion;
        this.minimumWireCompatibilityVersion = builder.minimumWireCompatibilityVersion;
        this.number = builder.number;
    }

    public static Version of(Function<Builder, ObjectBuilder<Version>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final String buildDate() {
        return this.buildDate;
    }

    public final String buildHash() {
        return this.buildHash;
    }

    public final Boolean buildSnapshot() {
        return this.buildSnapshot;
    }

    public final String buildType() {
        return this.buildType;
    }

    public final String distribution() {
        return this.distribution;
    }

    public final String luceneVersion() {
        return this.luceneVersion;
    }

    public final String minimumIndexCompatibilityVersion() {
        return this.minimumIndexCompatibilityVersion;
    }

    public final String minimumWireCompatibilityVersion() {
        return this.minimumWireCompatibilityVersion;
    }

    public final String number() {
        return this.number;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.buildDate != null) {
            generator.writeKey("build_date");
            generator.write(this.buildDate);
        }

        if (this.buildHash != null) {
            generator.writeKey("build_hash");
            generator.write(this.buildHash);
        }

        if (this.buildSnapshot != null) {
            generator.writeKey("build_snapshot");
            generator.write(this.buildSnapshot);
        }

        if (this.buildType != null) {
            generator.writeKey("build_type");
            generator.write(this.buildType);
        }

        if (this.distribution != null) {
            generator.writeKey("distribution");
            generator.write(this.distribution);
        }

        if (this.luceneVersion != null) {
            generator.writeKey("lucene_version");
            generator.write(this.luceneVersion);
        }

        if (this.minimumIndexCompatibilityVersion != null) {
            generator.writeKey("minimum_index_compatibility_version");
            generator.write(this.minimumIndexCompatibilityVersion);
        }

        if (this.minimumWireCompatibilityVersion != null) {
            generator.writeKey("minimum_wire_compatibility_version");
            generator.write(this.minimumWireCompatibilityVersion);
        }

        if (this.number != null) {
            generator.writeKey("number");
            generator.write(this.number);
        }
    }

    /** Builder for {@link Version}. */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Version> {
        private String buildDate;
        private String buildHash;
        private Boolean buildSnapshot;
        private String buildType;
        private String distribution;
        private String luceneVersion;
        private String minimumIndexCompatibilityVersion;
        private String minimumWireCompatibilityVersion;
        private String number;

        public final Builder buildDate(String value) {
            this.buildDate = value;
            return this;
        }

        public final Builder buildHash(String value) {
            this.buildHash = value;
            return this;
        }

        public final Builder buildSnapshot(Boolean value) {
            this.buildSnapshot = value;
            return this;
        }

        public final Builder buildType(String value) {
            this.buildType = value;
            return this;
        }

        public final Builder distribution(String value) {
            this.distribution = value;
            return this;
        }

        public final Builder luceneVersion(String value) {
            this.luceneVersion = value;
            return this;
        }

        public final Builder minimumIndexCompatibilityVersion(String value) {
            this.minimumIndexCompatibilityVersion = value;
            return this;
        }

        public final Builder minimumWireCompatibilityVersion(String value) {
            this.minimumWireCompatibilityVersion = value;
            return this;
        }

        public final Builder number(String value) {
            this.number = value;
            return this;
        }

        /**
         * Builds a {@link Version}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public Version build() {
            _checkSingleUse();

            return new Version(this);
        }
    }

    public static final JsonpDeserializer<Version> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(Builder::new, Version::setupVersionDeserializer);

    protected static void setupVersionDeserializer(ObjectDeserializer<Version.Builder> op) {
        op.add(Builder::buildDate, JsonpDeserializer.stringDeserializer(), "build_date");
        op.add(Builder::buildHash, JsonpDeserializer.stringDeserializer(), "build_hash");
        op.add(Builder::buildSnapshot, JsonpDeserializer.booleanDeserializer(), "build_snapshot");
        op.add(Builder::buildType, JsonpDeserializer.stringDeserializer(), "build_type");
        op.add(Builder::distribution, JsonpDeserializer.stringDeserializer(), "distribution");
        op.add(Builder::luceneVersion, JsonpDeserializer.stringDeserializer(), "lucene_version");
        op.add(
                Builder::minimumIndexCompatibilityVersion,
                JsonpDeserializer.stringDeserializer(),
                "minimum_index_compatibility_version");
        op.add(
                Builder::minimumWireCompatibilityVersion,
                JsonpDeserializer.stringDeserializer(),
                "minimum_wire_compatibility_version");
        op.add(Builder::number, JsonpDeserializer.stringDeserializer(), "number");
    }
}
