package org.opensearch.client.opensearch._types.query_dsl;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;

// typedef: _types.query_dsl.XyShapeQuery
public class XyShapeQuery extends QueryBase implements QueryVariant {
    private final String field;

    private final XyShapeFieldQuery xyShape;

    @Nullable
    private final Boolean ignoreUnmapped;

    // ---------------------------------------------------------------------------------------------

    private XyShapeQuery(XyShapeQuery.Builder builder) {
        super(builder);
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.xyShape = ApiTypeHelper.requireNonNull(builder.xyShape, this, "xy_shape");

        this.ignoreUnmapped = builder.ignoreUnmapped;

    }

    public static XyShapeQuery of(Function<XyShapeQuery.Builder, ObjectBuilder<XyShapeQuery>> fn) {
        return fn.apply(new XyShapeQuery.Builder()).build();
    }

    /**
     * Query variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.XyShape;
    }

    /**
     * Required -
     */
    public final String field() {
        return this.field;
    }

    /**
     * Required -
     */
    public final XyShapeFieldQuery xyShape() {
        return this.xyShape;
    }

    /**
     * API name: {@code ignore_unmapped}
     */
    @Nullable
    public final Boolean ignoreUnmapped() {
        return this.ignoreUnmapped;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeKey(this.field);
        this.xyShape.serialize(generator, mapper);

        super.serializeInternal(generator, mapper);
        if (this.ignoreUnmapped != null) {
            generator.writeKey("ignore_unmapped");
            generator.write(this.ignoreUnmapped);

        }

    }

    public XyShapeQuery.Builder toBuilder() {
        return new XyShapeQuery.Builder().field(field).xyShape(xyShape);
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link ShapeQuery}.
     */

    public static class Builder extends QueryBase.AbstractBuilder<XyShapeQuery.Builder> implements ObjectBuilder<XyShapeQuery> {
        private String field;

        private XyShapeFieldQuery xyShape;

        /**
         * Required -
         */
        public final XyShapeQuery.Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * Required -
         */
        public final XyShapeQuery.Builder xyShape(XyShapeFieldQuery value) {
            this.xyShape = value;
            return this;
        }

        /**
         * Required -
         */
        public final XyShapeQuery.Builder xyShape(Function<XyShapeFieldQuery.Builder, ObjectBuilder<XyShapeFieldQuery>> fn) {
            return this.xyShape(fn.apply(new XyShapeFieldQuery.Builder()).build());
        }

        @Nullable
        private Boolean ignoreUnmapped;

        /**
         * API name: {@code ignore_unmapped}
         */
        public final XyShapeQuery.Builder ignoreUnmapped(@Nullable Boolean value) {
            this.ignoreUnmapped = value;
            return this;
        }

        @Override
        protected XyShapeQuery.Builder self() {
            return this;
        }

        /**
         * Builds a {@link ShapeQuery}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public XyShapeQuery build() {
            _checkSingleUse();

            return new XyShapeQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShapeQuery}
     */
    public static final JsonpDeserializer<XyShapeQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        XyShapeQuery.Builder::new,
        XyShapeQuery::setupXyShapeQueryDeserializer
    );

    protected static void setupXyShapeQueryDeserializer(ObjectDeserializer<XyShapeQuery.Builder> op) {
        QueryBase.setupQueryBaseDeserializer(op);
        op.add(XyShapeQuery.Builder::ignoreUnmapped, JsonpDeserializer.booleanDeserializer(), "ignore_unmapped");

        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            builder.field(name);
            builder.xyShape(XyShapeFieldQuery._DESERIALIZER.deserialize(parser, mapper));
        });

    }

}
