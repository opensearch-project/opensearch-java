/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.aggregations;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch._types.GeoBounds;
import org.opensearch.client.util.ObjectBuilder;

@JsonpDeserializable
public class CompositeGeoTileGridAggregationSource extends CompositeValuesSource {

    @Nullable
    private final Integer precision;

    @Nullable
    private final GeoBounds geoBounds;

    private CompositeGeoTileGridAggregationSource(Builder builder) {
        super(builder);
        this.precision = builder.precision;
        this.geoBounds = builder.geoBounds;
    }

    public static CompositeGeoTileGridAggregationSource of(Function<Builder, ObjectBuilder<CompositeGeoTileGridAggregationSource>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code precision}
     */
    @Nullable
    public final Integer precision() {
        return this.precision;
    }

    /**
     * API name: {@code geoBounds}
     */
    @Nullable
    public final GeoBounds geoBounds() {
        return this.geoBounds;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.precision != null) {
            generator.writeKey("precision");
            generator.write(this.precision);
        }
        if (this.geoBounds != null) {
            generator.writeKey("bounds");
            this.geoBounds.serialize(generator, mapper);

        }
    }

    /**
     * Builder for {@link CompositeGeoTileGridAggregationSource}.
     */

    public static class Builder extends CompositeValuesSource.AbstractBuilder<Builder>
        implements
            ObjectBuilder<CompositeGeoTileGridAggregationSource> {
        @Nullable
        private Integer precision;

        @Nullable
        private GeoBounds geoBounds;

        /**
         * API name: {@code precision}
         */
        public final Builder precision(@Nullable Integer precision) {
            this.precision = precision;
            return this;
        }

        /**
         * API name: {@code geoBounds}
         */
        public final Builder geoBounds(@Nullable GeoBounds geoBounds) {
            this.geoBounds = geoBounds;
            return this;
        }

        /**
         * API name: {@code geoBounds}
         */
        public final Builder geoBounds(Function<GeoBounds.Builder, ObjectBuilder<GeoBounds>> fn) {
            return this.geoBounds(fn.apply(new GeoBounds.Builder()).build());
        }

        /**
         * Builds a {@link CompositeGeoTileGridAggregationSource}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public CompositeGeoTileGridAggregationSource build() {
            _checkSingleUse();

            return new CompositeGeoTileGridAggregationSource(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    /**
     * Json deserializer for {@link CompositeGeoTileGridAggregationSource}
     */
    public static final JsonpDeserializer<CompositeGeoTileGridAggregationSource> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CompositeGeoTileGridAggregationSource::setupCompositeGeoTileGridAggregationSourceDeserializer
    );

    protected static void setupCompositeGeoTileGridAggregationSourceDeserializer(
        ObjectDeserializer<CompositeGeoTileGridAggregationSource.Builder> op
    ) {
        CompositeValuesSource.setupCompositeValuesSourceDeserializer(op);
        op.add(Builder::precision, JsonpDeserializer.integerDeserializer(), "precision");
        op.add(Builder::geoBounds, GeoBounds._DESERIALIZER, "bounds");
    }

}
