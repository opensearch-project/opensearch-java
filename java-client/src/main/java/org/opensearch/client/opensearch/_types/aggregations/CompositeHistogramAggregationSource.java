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
public class CompositeHistogramAggregationSource extends CompositeValuesSource {

    private final double interval;

    private CompositeHistogramAggregationSource(Builder builder) {
        super(builder);
        this.interval = builder.interval;
    }

    public static CompositeHistogramAggregationSource of(Function<Builder, ObjectBuilder<CompositeHistogramAggregationSource>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code interval}
     */
    public final double interval() {
        return this.interval;
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
        generator.writeKey("interval");
        generator.write(this.interval);
    }

    /**
     * Builder for {@link CompositeHistogramAggregationSource}.
     */

    public static class Builder extends CompositeValuesSource.AbstractBuilder<Builder>
        implements
            ObjectBuilder<CompositeHistogramAggregationSource> {
        private double interval;

        /**
         * Required - API name: {@code interval}
         */
        public final Builder interval(double interval) {
            this.interval = interval;
            return this;
        }

        /**
         * Builds a {@link CompositeHistogramAggregationSource}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public CompositeHistogramAggregationSource build() {
            _checkSingleUse();

            return new CompositeHistogramAggregationSource(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    /**
     * Json deserializer for {@link CompositeHistogramAggregationSource}
     */
    public static final JsonpDeserializer<CompositeHistogramAggregationSource> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CompositeHistogramAggregationSource::setupCompositeHistogramAggregationSourceDeserializer
    );

    protected static void setupCompositeHistogramAggregationSourceDeserializer(
        ObjectDeserializer<CompositeHistogramAggregationSource.Builder> op
    ) {
        CompositeValuesSource.setupCompositeValuesSourceDeserializer(op);
        op.add(Builder::interval, JsonpDeserializer.doubleDeserializer(), "interval");
    }

}
