package org.opensearch.client.opensearch._types.query_dsl;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.*;
import org.opensearch.client.opensearch._types.GeoShapeRelation;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.query_dsl.XyShapeFieldQuery
public class XyShapeFieldQuery implements JsonpSerializable {
    @Nullable
    private final FieldLookup indexedShape;

    @Nullable
    private final GeoShapeRelation relation;

    @Nullable
    private final JsonData xyShape;

    // ---------------------------------------------------------------------------------------------

    private XyShapeFieldQuery(XyShapeFieldQuery.Builder builder) {

        this.indexedShape = builder.indexedShape;
        this.relation = builder.relation;
        this.xyShape = builder.xyShape;

    }

    public static XyShapeFieldQuery of(Function<XyShapeFieldQuery.Builder, ObjectBuilder<XyShapeFieldQuery>> fn) {
        return fn.apply(new XyShapeFieldQuery.Builder()).build();
    }

    /**
     * API name: {@code indexed_shape}
     */
    @Nullable
    public final FieldLookup indexedShape() {
        return this.indexedShape;
    }

    /**
     * API name: {@code relation}
     */
    @Nullable
    public final GeoShapeRelation relation() {
        return this.relation;
    }

    /**
     * API name: {@code shape}
     */
    @Nullable
    public final JsonData xyShape() {
        return this.xyShape;
    }

    /**
     * Serialize this object to JSON.
     */
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

        if (this.indexedShape != null) {
            generator.writeKey("indexed_shape");
            this.indexedShape.serialize(generator, mapper);

        }
        if (this.relation != null) {
            generator.writeKey("relation");
            this.relation.serialize(generator, mapper);
        }
        if (this.xyShape != null) {
            generator.writeKey("xy_shape");
            this.xyShape.serialize(generator, mapper);
        }
    }

    public XyShapeFieldQuery.Builder toBuilder() {
        return new XyShapeFieldQuery.Builder().indexedShape(indexedShape).relation(relation).xyShape(xyShape);
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link XyShapeFieldQuery}.
     */

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<XyShapeFieldQuery> {
        @Nullable
        private FieldLookup indexedShape;

        @Nullable
        private GeoShapeRelation relation;

        @Nullable
        private JsonData xyShape;

        /**
         * API name: {@code indexed_shape}
         */
        public final XyShapeFieldQuery.Builder indexedShape(@Nullable FieldLookup value) {
            this.indexedShape = value;
            return this;
        }

        /**
         * API name: {@code indexed_shape}
         */
        public final XyShapeFieldQuery.Builder indexedShape(Function<FieldLookup.Builder, ObjectBuilder<FieldLookup>> fn) {
            return this.indexedShape(fn.apply(new FieldLookup.Builder()).build());
        }

        /**
         * API name: {@code relation}
         */
        public final XyShapeFieldQuery.Builder relation(@Nullable GeoShapeRelation value) {
            this.relation = value;
            return this;
        }

        /**
         * API name: {@code shape}
         */
        public final XyShapeFieldQuery.Builder xyShape(@Nullable JsonData value) {
            this.xyShape = value;
            return this;
        }

        /**
         * Builds a {@link XyShapeFieldQuery}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public XyShapeFieldQuery build() {
            _checkSingleUse();

            return new XyShapeFieldQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link XyShapeFieldQuery}
     */
    public static final JsonpDeserializer<XyShapeFieldQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        XyShapeFieldQuery.Builder::new,
        XyShapeFieldQuery::setupXyShapeFieldQueryDeserializer
    );

    protected static void setupXyShapeFieldQueryDeserializer(ObjectDeserializer<XyShapeFieldQuery.Builder> op) {

        op.add(XyShapeFieldQuery.Builder::indexedShape, FieldLookup._DESERIALIZER, "indexed_shape");
        op.add(XyShapeFieldQuery.Builder::relation, GeoShapeRelation._DESERIALIZER, "relation");
        op.add(XyShapeFieldQuery.Builder::xyShape, JsonData._DESERIALIZER, "xy_shape");

    }

}
