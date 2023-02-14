package org.opensearch.client.opensearch;

import org.opensearch.client.json.*;
import org.opensearch.client.util.*;
import jakarta.json.stream.JsonGenerator;
import java.util.*;
import java.util.function.Function;
import javax.annotation.*;

@JsonpDeserializable
public class ActionObjectStructure implements JsonpSerializable {

    @Nullable private final UserDefinedStructure add;

    @Nullable private final UserDefinedStructure remove;

    @Nullable private final UserDefinedStructure removeIndex;

    public ActionObjectStructure(Builder builder) {
        this.add = builder.add;
        this.remove = builder.remove;
        this.removeIndex = builder.removeIndex;
    }

    public static ActionObjectStructure of(
            Function<Builder, ObjectBuilder<ActionObjectStructure>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final UserDefinedStructure add() {
        return this.add;
    }

    public final UserDefinedStructure remove() {
        return this.remove;
    }

    public final UserDefinedStructure removeIndex() {
        return this.removeIndex;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.add != null) {
            generator.writeKey("add");
            this.add.serialize(generator, mapper);
        }

        if (this.remove != null) {
            generator.writeKey("remove");
            this.remove.serialize(generator, mapper);
        }

        if (this.removeIndex != null) {
            generator.writeKey("remove_index");
            this.removeIndex.serialize(generator, mapper);
        }
    }

    /** Builder for {@link ActionObjectStructure}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<ActionObjectStructure> {
        private UserDefinedStructure add;
        private UserDefinedStructure remove;
        private UserDefinedStructure removeIndex;

        public final Builder add(UserDefinedStructure value) {
            this.add = value;
            return this;
        }

        public final Builder add(
                Function<UserDefinedStructure.Builder, ObjectBuilder<UserDefinedStructure>> fn) {
            return add(fn.apply(new UserDefinedStructure.Builder()).build());
        }

        public final Builder remove(UserDefinedStructure value) {
            this.remove = value;
            return this;
        }

        public final Builder remove(
                Function<UserDefinedStructure.Builder, ObjectBuilder<UserDefinedStructure>> fn) {
            return remove(fn.apply(new UserDefinedStructure.Builder()).build());
        }

        public final Builder removeIndex(UserDefinedStructure value) {
            this.removeIndex = value;
            return this;
        }

        public final Builder removeIndex(
                Function<UserDefinedStructure.Builder, ObjectBuilder<UserDefinedStructure>> fn) {
            return removeIndex(fn.apply(new UserDefinedStructure.Builder()).build());
        }

        /**
         * Builds a {@link ActionObjectStructure}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public ActionObjectStructure build() {
            _checkSingleUse();

            return new ActionObjectStructure(this);
        }
    }

    public static final JsonpDeserializer<ActionObjectStructure> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new, ActionObjectStructure::setupActionObjectStructureDeserializer);

    protected static void setupActionObjectStructureDeserializer(
            ObjectDeserializer<ActionObjectStructure.Builder> op) {
        op.add(Builder::add, UserDefinedStructure._DESERIALIZER, "add");
        op.add(Builder::remove, UserDefinedStructure._DESERIALIZER, "remove");
        op.add(Builder::removeIndex, UserDefinedStructure._DESERIALIZER, "remove_index");
    }
}
