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
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ObjectBuilder;

@JsonpDeserializable
public class CompositeTermsAggregationSource extends CompositeValuesSource {

    private CompositeTermsAggregationSource(Builder builder) {
        super(builder);
    }

    public static CompositeTermsAggregationSource of(Function<Builder, ObjectBuilder<CompositeTermsAggregationSource>> fn) {
        return fn.apply(new Builder()).build();
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
    }

    /**
     * Builder for {@link CompositeTermsAggregationSource}.
     */
    public static class Builder extends CompositeValuesSource.AbstractBuilder<Builder>
        implements
            ObjectBuilder<CompositeTermsAggregationSource> {

        /**
         * Builds a {@link CompositeTermsAggregationSource}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public CompositeTermsAggregationSource build() {
            _checkSingleUse();

            return new CompositeTermsAggregationSource(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    /**
     * Json deserializer for {@link CompositeTermsAggregationSource}
     */
    public static final JsonpDeserializer<CompositeTermsAggregationSource> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CompositeTermsAggregationSource::setupCompositeGeoTileGridAggregationSourceDeserializer
    );

    protected static void setupCompositeGeoTileGridAggregationSourceDeserializer(
        ObjectDeserializer<CompositeTermsAggregationSource.Builder> op
    ) {
        CompositeValuesSource.setupCompositeValuesSourceDeserializer(op);
    }

}
