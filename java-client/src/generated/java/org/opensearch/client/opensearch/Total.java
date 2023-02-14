package org.opensearch.client.opensearch;

import org.opensearch.client.json.*;
import org.opensearch.client.util.*;
import jakarta.json.stream.JsonGenerator;
import java.util.*;
import java.util.function.Function;
import javax.annotation.*;

@JsonpDeserializable
public class Total implements JsonpSerializable {
    @Nullable private final Relation relation;
    @Nullable private final Integer value;

    public Total(Builder builder) {
        this.relation = builder.relation;
        this.value = builder.value;
    }

    public static Total of(Function<Builder, ObjectBuilder<Total>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final Relation relation() {
        return this.relation;
    }

    public final Integer value() {
        return this.value;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.relation != null) {
            generator.writeKey("relation");
            this.relation.serialize(generator, mapper);
        }

        if (this.value != null) {
            generator.writeKey("value");
            generator.write(this.value);
        }
    }

    /** Builder for {@link Total}. */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Total> {
        private Relation relation;
        private Integer value;

        public final Builder relation(Relation value) {
            this.relation = value;
            return this;
        }

        public final Builder value(Integer value) {
            this.value = value;
            return this;
        }

        /**
         * Builds a {@link Total}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public Total build() {
            _checkSingleUse();

            return new Total(this);
        }
    }

    public static final JsonpDeserializer<Total> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(Builder::new, Total::setupTotalDeserializer);

    protected static void setupTotalDeserializer(ObjectDeserializer<Total.Builder> op) {
        op.add(Builder::relation, Relation._DESERIALIZER, "relation");
        op.add(Builder::value, JsonpDeserializer.integerDeserializer(), "value");
    }
}
