package org.opensearch.client.opensearch;

import org.opensearch.client.json.*;
import org.opensearch.client.util.*;
import jakarta.json.stream.JsonGenerator;
import java.util.*;
import java.util.function.Function;
import javax.annotation.*;

@JsonpDeserializable
public class GetDocumentDocResponse implements JsonpSerializable {
    @Nullable private final Map<String, JsonData> fields;

    private final String id;

    private final String index;
    @Nullable private final String routing;
    @Nullable private final Map<String, JsonData> source;
    @Nullable private final String type;

    private final boolean found;
    @Nullable private final Long primaryTerm;
    @Nullable private final Long seqNo;
    @Nullable private final Integer version;

    public GetDocumentDocResponse(Builder builder) {
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.routing = builder.routing;
        this.source = ApiTypeHelper.unmodifiable(builder.source);
        this.type = builder.type;
        this.found = ApiTypeHelper.requireNonNull(builder.found, this, "found");
        this.primaryTerm = builder.primaryTerm;
        this.seqNo = builder.seqNo;
        this.version = builder.version;
    }

    public static GetDocumentDocResponse of(
            Function<Builder, ObjectBuilder<GetDocumentDocResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final Map<String, JsonData> fields() {
        return this.fields;
    }

    public final String id() {
        return this.id;
    }

    public final String index() {
        return this.index;
    }

    public final String routing() {
        return this.routing;
    }

    public final Map<String, JsonData> source() {
        return this.source;
    }

    public final String type() {
        return this.type;
    }

    public final boolean found() {
        return this.found;
    }

    public final Long primaryTerm() {
        return this.primaryTerm;
    }

    public final Long seqNo() {
        return this.seqNo;
    }

    public final Integer version() {
        return this.version;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (ApiTypeHelper.isDefined(this.fields)) {
            generator.writeKey("_fields");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.fields.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("_id");
        generator.write(this.id);

        generator.writeKey("_index");
        generator.write(this.index);

        if (this.routing != null) {
            generator.writeKey("_routing");
            generator.write(this.routing);
        }

        if (ApiTypeHelper.isDefined(this.source)) {
            generator.writeKey("_source");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.source.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.type != null) {
            generator.writeKey("_type");
            generator.write(this.type);
        }

        generator.writeKey("found");
        generator.write(this.found);

        if (this.primaryTerm != null) {
            generator.writeKey("primary_term");
            generator.write(this.primaryTerm);
        }

        if (this.seqNo != null) {
            generator.writeKey("seq_no");
            generator.write(this.seqNo);
        }

        if (this.version != null) {
            generator.writeKey("version");
            generator.write(this.version);
        }
    }

    /** Builder for {@link GetDocumentDocResponse}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<GetDocumentDocResponse> {
        private Map<String, JsonData> fields;
        private String id;
        private String index;
        private String routing;
        private Map<String, JsonData> source;
        private String type;
        private Boolean found;
        private Long primaryTerm;
        private Long seqNo;
        private Integer version;

        public final Builder fields(Map<String, JsonData> map) {
            this.fields = _mapPutAll(this.fields, map);
            return this;
        }

        public final Builder fields(String key, JsonData value) {
            this.fields = _mapPut(this.fields, key, value);
            return this;
        }

        public final Builder id(String value) {
            this.id = value;
            return this;
        }

        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        public final Builder routing(String value) {
            this.routing = value;
            return this;
        }

        public final Builder source(Map<String, JsonData> map) {
            this.source = _mapPutAll(this.source, map);
            return this;
        }

        public final Builder source(String key, JsonData value) {
            this.source = _mapPut(this.source, key, value);
            return this;
        }

        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        public final Builder found(boolean value) {
            this.found = value;
            return this;
        }

        public final Builder primaryTerm(Long value) {
            this.primaryTerm = value;
            return this;
        }

        public final Builder seqNo(Long value) {
            this.seqNo = value;
            return this;
        }

        public final Builder version(Integer value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link GetDocumentDocResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public GetDocumentDocResponse build() {
            _checkSingleUse();

            return new GetDocumentDocResponse(this);
        }
    }

    public static final JsonpDeserializer<GetDocumentDocResponse> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new, GetDocumentDocResponse::setupGetDocumentDocResponseDeserializer);

    protected static void setupGetDocumentDocResponseDeserializer(
            ObjectDeserializer<GetDocumentDocResponse.Builder> op) {
        op.add(
                Builder::fields,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "_fields");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "_id");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "_index");
        op.add(Builder::routing, JsonpDeserializer.stringDeserializer(), "_routing");
        op.add(
                Builder::source,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "_source");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "_type");
        op.add(Builder::found, JsonpDeserializer.booleanDeserializer(), "found");
        op.add(Builder::primaryTerm, JsonpDeserializer.longDeserializer(), "primary_term");
        op.add(Builder::seqNo, JsonpDeserializer.longDeserializer(), "seq_no");
        op.add(Builder::version, JsonpDeserializer.integerDeserializer(), "version");
    }
}
