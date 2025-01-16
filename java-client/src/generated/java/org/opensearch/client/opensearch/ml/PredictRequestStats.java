/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.ml;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.PredictRequestStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PredictRequestStats implements PlainJsonSerializable, ToCopyableBuilder<PredictRequestStats.Builder, PredictRequestStats> {

    @Nullable
    private final Double average;

    @Nullable
    private final Long count;

    @Nullable
    private final Double max;

    @Nullable
    private final Double min;

    @Nullable
    private final Double p50;

    @Nullable
    private final Double p90;

    @Nullable
    private final Double p99;

    // ---------------------------------------------------------------------------------------------

    private PredictRequestStats(Builder builder) {
        this.average = builder.average;
        this.count = builder.count;
        this.max = builder.max;
        this.min = builder.min;
        this.p50 = builder.p50;
        this.p90 = builder.p90;
        this.p99 = builder.p99;
    }

    public static PredictRequestStats of(Function<PredictRequestStats.Builder, ObjectBuilder<PredictRequestStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The average latency in milliseconds.
     * <p>
     * API name: {@code average}
     * </p>
     */
    @Nullable
    public final Double average() {
        return this.average;
    }

    /**
     * The total predict requests on this node.
     * <p>
     * API name: {@code count}
     * </p>
     */
    @Nullable
    public final Long count() {
        return this.count;
    }

    /**
     * The maximum latency in milliseconds.
     * <p>
     * API name: {@code max}
     * </p>
     */
    @Nullable
    public final Double max() {
        return this.max;
    }

    /**
     * The minimum latency in milliseconds.
     * <p>
     * API name: {@code min}
     * </p>
     */
    @Nullable
    public final Double min() {
        return this.min;
    }

    /**
     * The 50th percentile latency in milliseconds.
     * <p>
     * API name: {@code p50}
     * </p>
     */
    @Nullable
    public final Double p50() {
        return this.p50;
    }

    /**
     * The 90th percentile latency in milliseconds.
     * <p>
     * API name: {@code p90}
     * </p>
     */
    @Nullable
    public final Double p90() {
        return this.p90;
    }

    /**
     * The 99th percentile latency in milliseconds.
     * <p>
     * API name: {@code p99}
     * </p>
     */
    @Nullable
    public final Double p99() {
        return this.p99;
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
        if (this.average != null) {
            generator.writeKey("average");
            generator.write(this.average);
        }

        if (this.count != null) {
            generator.writeKey("count");
            generator.write(this.count);
        }

        if (this.max != null) {
            generator.writeKey("max");
            generator.write(this.max);
        }

        if (this.min != null) {
            generator.writeKey("min");
            generator.write(this.min);
        }

        if (this.p50 != null) {
            generator.writeKey("p50");
            generator.write(this.p50);
        }

        if (this.p90 != null) {
            generator.writeKey("p90");
            generator.write(this.p90);
        }

        if (this.p99 != null) {
            generator.writeKey("p99");
            generator.write(this.p99);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link PredictRequestStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PredictRequestStats> {
        @Nullable
        private Double average;
        @Nullable
        private Long count;
        @Nullable
        private Double max;
        @Nullable
        private Double min;
        @Nullable
        private Double p50;
        @Nullable
        private Double p90;
        @Nullable
        private Double p99;

        public Builder() {}

        private Builder(PredictRequestStats o) {
            this.average = o.average;
            this.count = o.count;
            this.max = o.max;
            this.min = o.min;
            this.p50 = o.p50;
            this.p90 = o.p90;
            this.p99 = o.p99;
        }

        private Builder(Builder o) {
            this.average = o.average;
            this.count = o.count;
            this.max = o.max;
            this.min = o.min;
            this.p50 = o.p50;
            this.p90 = o.p90;
            this.p99 = o.p99;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The average latency in milliseconds.
         * <p>
         * API name: {@code average}
         * </p>
         */
        @Nonnull
        public final Builder average(@Nullable Double value) {
            this.average = value;
            return this;
        }

        /**
         * The total predict requests on this node.
         * <p>
         * API name: {@code count}
         * </p>
         */
        @Nonnull
        public final Builder count(@Nullable Long value) {
            this.count = value;
            return this;
        }

        /**
         * The maximum latency in milliseconds.
         * <p>
         * API name: {@code max}
         * </p>
         */
        @Nonnull
        public final Builder max(@Nullable Double value) {
            this.max = value;
            return this;
        }

        /**
         * The minimum latency in milliseconds.
         * <p>
         * API name: {@code min}
         * </p>
         */
        @Nonnull
        public final Builder min(@Nullable Double value) {
            this.min = value;
            return this;
        }

        /**
         * The 50th percentile latency in milliseconds.
         * <p>
         * API name: {@code p50}
         * </p>
         */
        @Nonnull
        public final Builder p50(@Nullable Double value) {
            this.p50 = value;
            return this;
        }

        /**
         * The 90th percentile latency in milliseconds.
         * <p>
         * API name: {@code p90}
         * </p>
         */
        @Nonnull
        public final Builder p90(@Nullable Double value) {
            this.p90 = value;
            return this;
        }

        /**
         * The 99th percentile latency in milliseconds.
         * <p>
         * API name: {@code p99}
         * </p>
         */
        @Nonnull
        public final Builder p99(@Nullable Double value) {
            this.p99 = value;
            return this;
        }

        /**
         * Builds a {@link PredictRequestStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PredictRequestStats build() {
            _checkSingleUse();

            return new PredictRequestStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PredictRequestStats}
     */
    public static final JsonpDeserializer<PredictRequestStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PredictRequestStats::setupPredictRequestStatsDeserializer
    );

    protected static void setupPredictRequestStatsDeserializer(ObjectDeserializer<PredictRequestStats.Builder> op) {
        op.add(Builder::average, JsonpDeserializer.doubleDeserializer(), "average");
        op.add(Builder::count, JsonpDeserializer.longDeserializer(), "count");
        op.add(Builder::max, JsonpDeserializer.doubleDeserializer(), "max");
        op.add(Builder::min, JsonpDeserializer.doubleDeserializer(), "min");
        op.add(Builder::p50, JsonpDeserializer.doubleDeserializer(), "p50");
        op.add(Builder::p90, JsonpDeserializer.doubleDeserializer(), "p90");
        op.add(Builder::p99, JsonpDeserializer.doubleDeserializer(), "p99");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.average);
        result = 31 * result + Objects.hashCode(this.count);
        result = 31 * result + Objects.hashCode(this.max);
        result = 31 * result + Objects.hashCode(this.min);
        result = 31 * result + Objects.hashCode(this.p50);
        result = 31 * result + Objects.hashCode(this.p90);
        result = 31 * result + Objects.hashCode(this.p99);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PredictRequestStats other = (PredictRequestStats) o;
        return Objects.equals(this.average, other.average)
            && Objects.equals(this.count, other.count)
            && Objects.equals(this.max, other.max)
            && Objects.equals(this.min, other.min)
            && Objects.equals(this.p50, other.p50)
            && Objects.equals(this.p90, other.p90)
            && Objects.equals(this.p99, other.p99);
    }
}
