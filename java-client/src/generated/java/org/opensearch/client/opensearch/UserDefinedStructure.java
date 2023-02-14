package org.opensearch.client.opensearch;

import org.opensearch.client.json.*;
import org.opensearch.client.util.*;
import jakarta.json.stream.JsonGenerator;
import java.util.*;
import java.util.function.Function;
import javax.annotation.*;

@JsonpDeserializable
public class UserDefinedStructure implements JsonpSerializable {
    @Nullable private final String alias;
    @Nullable private final List<String> aliases;
    @Nullable private final JsonData filter;
    @Nullable private final String index;
    @Nullable private final String indexRouting;
    @Nullable private final List<String> indices;
    @Nullable private final Boolean isHidden;
    @Nullable private final Boolean isWriteIndex;
    @Nullable private final String mustExist;
    @Nullable private final String routing;
    @Nullable private final String searchRouting;

    public UserDefinedStructure(Builder builder) {
        this.alias = builder.alias;
        this.aliases = ApiTypeHelper.unmodifiable(builder.aliases);
        this.filter = builder.filter;
        this.index = builder.index;
        this.indexRouting = builder.indexRouting;
        this.indices = ApiTypeHelper.unmodifiable(builder.indices);
        this.isHidden = builder.isHidden;
        this.isWriteIndex = builder.isWriteIndex;
        this.mustExist = builder.mustExist;
        this.routing = builder.routing;
        this.searchRouting = builder.searchRouting;
    }

    public static UserDefinedStructure of(
            Function<Builder, ObjectBuilder<UserDefinedStructure>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final String alias() {
        return this.alias;
    }

    public final List<String> aliases() {
        return this.aliases;
    }

    public final JsonData filter() {
        return this.filter;
    }

    public final String index() {
        return this.index;
    }

    public final String indexRouting() {
        return this.indexRouting;
    }

    public final List<String> indices() {
        return this.indices;
    }

    public final Boolean isHidden() {
        return this.isHidden;
    }

    public final Boolean isWriteIndex() {
        return this.isWriteIndex;
    }

    public final String mustExist() {
        return this.mustExist;
    }

    public final String routing() {
        return this.routing;
    }

    public final String searchRouting() {
        return this.searchRouting;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.alias != null) {
            generator.writeKey("alias");
            generator.write(this.alias);
        }

        if (ApiTypeHelper.isDefined(this.aliases)) {
            generator.writeKey("aliases");
            generator.writeStartArray();
            for (String item0 : this.aliases) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.filter != null) {
            generator.writeKey("filter");
            this.filter.serialize(generator, mapper);
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.indexRouting != null) {
            generator.writeKey("index_routing");
            generator.write(this.indexRouting);
        }

        if (ApiTypeHelper.isDefined(this.indices)) {
            generator.writeKey("indices");
            generator.writeStartArray();
            for (String item0 : this.indices) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.isHidden != null) {
            generator.writeKey("is_hidden");
            generator.write(this.isHidden);
        }

        if (this.isWriteIndex != null) {
            generator.writeKey("is_write_index");
            generator.write(this.isWriteIndex);
        }

        if (this.mustExist != null) {
            generator.writeKey("must_exist");
            generator.write(this.mustExist);
        }

        if (this.routing != null) {
            generator.writeKey("routing");
            generator.write(this.routing);
        }

        if (this.searchRouting != null) {
            generator.writeKey("search_routing");
            generator.write(this.searchRouting);
        }
    }

    /** Builder for {@link UserDefinedStructure}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<UserDefinedStructure> {
        private String alias;
        private List<String> aliases;
        private JsonData filter;
        private String index;
        private String indexRouting;
        private List<String> indices;
        private Boolean isHidden;
        private Boolean isWriteIndex;
        private String mustExist;
        private String routing;
        private String searchRouting;

        public final Builder alias(String value) {
            this.alias = value;
            return this;
        }

        public final Builder aliases(List<String> list) {
            this.aliases = _listAddAll(this.aliases, list);
            return this;
        }

        public final Builder aliases(String value, String... values) {
            this.aliases = _listAdd(this.aliases, value, values);
            return this;
        }

        public final Builder filter(JsonData value) {
            this.filter = value;
            return this;
        }

        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        public final Builder indexRouting(String value) {
            this.indexRouting = value;
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

        public final Builder isHidden(Boolean value) {
            this.isHidden = value;
            return this;
        }

        public final Builder isWriteIndex(Boolean value) {
            this.isWriteIndex = value;
            return this;
        }

        public final Builder mustExist(String value) {
            this.mustExist = value;
            return this;
        }

        public final Builder routing(String value) {
            this.routing = value;
            return this;
        }

        public final Builder searchRouting(String value) {
            this.searchRouting = value;
            return this;
        }

        /**
         * Builds a {@link UserDefinedStructure}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public UserDefinedStructure build() {
            _checkSingleUse();

            return new UserDefinedStructure(this);
        }
    }

    public static final JsonpDeserializer<UserDefinedStructure> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new, UserDefinedStructure::setupUserDefinedStructureDeserializer);

    protected static void setupUserDefinedStructureDeserializer(
            ObjectDeserializer<UserDefinedStructure.Builder> op) {
        op.add(Builder::alias, JsonpDeserializer.stringDeserializer(), "alias");
        op.add(
                Builder::aliases,
                JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
                "aliases");
        op.add(Builder::filter, JsonData._DESERIALIZER, "filter");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::indexRouting, JsonpDeserializer.stringDeserializer(), "index_routing");
        op.add(
                Builder::indices,
                JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
                "indices");
        op.add(Builder::isHidden, JsonpDeserializer.booleanDeserializer(), "is_hidden");
        op.add(Builder::isWriteIndex, JsonpDeserializer.booleanDeserializer(), "is_write_index");
        op.add(Builder::mustExist, JsonpDeserializer.stringDeserializer(), "must_exist");
        op.add(Builder::routing, JsonpDeserializer.stringDeserializer(), "routing");
        op.add(Builder::searchRouting, JsonpDeserializer.stringDeserializer(), "search_routing");
    }
}
