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
public class Hits implements JsonpSerializable {
    @Nullable private final String id;
    @Nullable private final String index;
    @Nullable private final Float score;
    @Nullable private final JsonData source;
    @Nullable private final String type;
    @Nullable private final JsonData fields;

    public Hits(Builder builder) {
        this.id = builder.id;
        this.index = builder.index;
        this.score = builder.score;
        this.source = builder.source;
        this.type = builder.type;
        this.fields = builder.fields;
    }

    public static Hits of(Function<Builder, ObjectBuilder<Hits>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final String id() {
        return this.id;
    }

    public final String index() {
        return this.index;
    }

    public final Float score() {
        return this.score;
    }

    public final JsonData source() {
        return this.source;
    }

    public final String type() {
        return this.type;
    }

    public final JsonData fields() {
        return this.fields;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.id != null) {
            generator.writeKey("_id");
            generator.write(this.id);
        }

        if (this.index != null) {
            generator.writeKey("_index");
            generator.write(this.index);
        }

        if (this.score != null) {
            generator.writeKey("_score");
            generator.write(this.score);
        }

        if (this.source != null) {
            generator.writeKey("_source");
            this.source.serialize(generator, mapper);
        }

        if (this.type != null) {
            generator.writeKey("_type");
            generator.write(this.type);
        }

        if (this.fields != null) {
            generator.writeKey("fields");
            this.fields.serialize(generator, mapper);
        }
    }

    /** Builder for {@link Hits}. */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Hits> {
        private String id;
        private String index;
        private Float score;
        private JsonData source;
        private String type;
        private JsonData fields;

        public final Builder id(String value) {
            this.id = value;
            return this;
        }

        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        public final Builder score(Float value) {
            this.score = value;
            return this;
        }

        public final Builder source(JsonData value) {
            this.source = value;
            return this;
        }

        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        public final Builder fields(JsonData value) {
            this.fields = value;
            return this;
        }

        /**
         * Builds a {@link Hits}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public Hits build() {
            _checkSingleUse();

            return new Hits(this);
        }
    }

    public static final JsonpDeserializer<Hits> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(Builder::new, Hits::setupHitsDeserializer);

    protected static void setupHitsDeserializer(ObjectDeserializer<Hits.Builder> op) {
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "_id");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "_index");
        op.add(Builder::score, JsonpDeserializer.floatDeserializer(), "_score");
        op.add(Builder::source, JsonData._DESERIALIZER, "_source");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "_type");
        op.add(Builder::fields, JsonData._DESERIALIZER, "fields");
    }
}
