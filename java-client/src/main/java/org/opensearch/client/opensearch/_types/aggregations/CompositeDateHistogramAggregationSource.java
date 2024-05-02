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
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.ObjectBuilder;

public class CompositeDateHistogramAggregationSource extends CompositeValuesSource {

    @Nullable
    private final Time calendarInterval;

    @Nullable
    private final Time fixedInterval;

    private final long offset;

    private final String zoneId;

    private CompositeDateHistogramAggregationSource(Builder builder) {
        super(builder);
        this.calendarInterval = builder.calendarInterval;
        this.fixedInterval = builder.fixedInterval;
        this.offset = builder.offset;
        this.zoneId = builder.zoneId;
    }

    public static CompositeDateHistogramAggregationSource of(Function<Builder, ObjectBuilder<CompositeDateHistogramAggregationSource>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code calendar_interval}
     */
    @Nullable
    public final Time calendarInterval() {
        return this.calendarInterval;
    }

    /**
     * API name: {@code fixed_interval}
     */
    @Nullable
    public final Time fixedInterval() {
        return this.fixedInterval;
    }

    /**
     * Required - API name: {@code offset}
     */
    public final long offset() {
        return this.offset;

    }

    /**
     * Required - API name: {@code zone_id}
     */
    public final String zoneId() {
        return this.zoneId;
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
        if (this.calendarInterval != null) {
            generator.writeKey("calendar_interval");
            this.calendarInterval.serialize(generator, mapper);

        }
        if (this.fixedInterval != null) {
            generator.writeKey("fixed_interval");
            this.fixedInterval.serialize(generator, mapper);

        }
        generator.writeKey("offset");
        generator.write(this.offset);

        generator.writeKey("zone_id");
        generator.write(this.zoneId);
    }

    /**
     * Builder for {@link CompositeDateHistogramAggregationSource}.
     */

    public static class Builder extends CompositeValuesSource.AbstractBuilder<Builder>
        implements
            ObjectBuilder<CompositeDateHistogramAggregationSource> {

        @Nullable
        private Time calendarInterval;

        @Nullable
        private Time fixedInterval;

        private long offset;

        private String zoneId;

        /**
         * API name: {@code calendar_interval}
         */
        public final Builder calendarInterval(@Nullable Time value) {
            this.calendarInterval = value;
            return this;
        }

        /**
         * API name: {@code fixed_interval}
         */
        public final Builder fixedInterval(@Nullable Time value) {
            this.fixedInterval = value;
            return this;
        }

        /**
         * Required - API name: {@code offset}
         */
        public final Builder offset(long value) {
            this.offset = value;
            return this;
        }

        /**
         * Required - API name: {@code zone_id}
         */

        public final Builder zoneId(String value) {
            this.zoneId = value;
            return this;
        }

        /**
         * Builds a {@link CompositeDateHistogramAggregationSource}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public CompositeDateHistogramAggregationSource build() {
            _checkSingleUse();

            return new CompositeDateHistogramAggregationSource(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    /**
     * Json deserializer for {@link CompositeDateHistogramAggregationSource}
     */
    public static final JsonpDeserializer<CompositeDateHistogramAggregationSource> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CompositeDateHistogramAggregationSource::setupCompositeDateHistogramAggregationSourceDeserializer
    );

    protected static void setupCompositeDateHistogramAggregationSourceDeserializer(
        ObjectDeserializer<CompositeDateHistogramAggregationSource.Builder> op
    ) {
        CompositeValuesSource.setupCompositeValuesSourceDeserializer(op);
        op.add(Builder::calendarInterval, Time._DESERIALIZER, "calendar_interval");
        op.add(Builder::fixedInterval, Time._DESERIALIZER, "fixed_interval");
        op.add(Builder::offset, JsonpDeserializer.longDeserializer(), "offset");
        op.add(Builder::zoneId, JsonpDeserializer.stringDeserializer(), "time_zone");
    }

}
