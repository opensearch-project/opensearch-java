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
import java.util.List;
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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.Buckets

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Buckets implements PlainJsonSerializable, ToCopyableBuilder<Buckets.Builder, Buckets> {

    @Nullable
    private final Long endTime;

    @Nonnull
    private final List<Entity> entities;

    @Nullable
    private final Double overallAggregateValue;

    @Nullable
    private final Long startTime;

    // ---------------------------------------------------------------------------------------------

    private Buckets(Builder builder) {
        this.endTime = builder.endTime;
        this.entities = ApiTypeHelper.unmodifiable(builder.entities);
        this.overallAggregateValue = builder.overallAggregateValue;
        this.startTime = builder.startTime;
    }

    public static Buckets of(Function<Buckets.Builder, ObjectBuilder<Buckets>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The end time.
     * <p>
     * API name: {@code end_time}
     * </p>
     */
    @Nullable
    public final Long endTime() {
        return this.endTime;
    }

    /**
     * API name: {@code entities}
     */
    @Nonnull
    public final List<Entity> entities() {
        return this.entities;
    }

    /**
     * The overall aggregate value.
     * <p>
     * API name: {@code overall_aggregate_value}
     * </p>
     */
    @Nullable
    public final Double overallAggregateValue() {
        return this.overallAggregateValue;
    }

    /**
     * The start time.
     * <p>
     * API name: {@code start_time}
     * </p>
     */
    @Nullable
    public final Long startTime() {
        return this.startTime;
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
        if (this.endTime != null) {
            generator.writeKey("end_time");
            generator.write(this.endTime);
        }

        if (ApiTypeHelper.isDefined(this.entities)) {
            generator.writeKey("entities");
            generator.writeStartArray();
            for (Entity item0 : this.entities) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.overallAggregateValue != null) {
            generator.writeKey("overall_aggregate_value");
            generator.write(this.overallAggregateValue);
        }

        if (this.startTime != null) {
            generator.writeKey("start_time");
            generator.write(this.startTime);
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
     * Builder for {@link Buckets}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Buckets> {
        @Nullable
        private Long endTime;
        @Nullable
        private List<Entity> entities;
        @Nullable
        private Double overallAggregateValue;
        @Nullable
        private Long startTime;

        public Builder() {}

        private Builder(Buckets o) {
            this.endTime = o.endTime;
            this.entities = _listCopy(o.entities);
            this.overallAggregateValue = o.overallAggregateValue;
            this.startTime = o.startTime;
        }

        private Builder(Builder o) {
            this.endTime = o.endTime;
            this.entities = _listCopy(o.entities);
            this.overallAggregateValue = o.overallAggregateValue;
            this.startTime = o.startTime;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The end time.
         * <p>
         * API name: {@code end_time}
         * </p>
         */
        @Nonnull
        public final Builder endTime(@Nullable Long value) {
            this.endTime = value;
            return this;
        }

        /**
         * API name: {@code entities}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>entities</code>.
         * </p>
         */
        @Nonnull
        public final Builder entities(List<Entity> list) {
            this.entities = _listAddAll(this.entities, list);
            return this;
        }

        /**
         * API name: {@code entities}
         *
         * <p>
         * Adds one or more values to <code>entities</code>.
         * </p>
         */
        @Nonnull
        public final Builder entities(Entity value, Entity... values) {
            this.entities = _listAdd(this.entities, value, values);
            return this;
        }

        /**
         * API name: {@code entities}
         *
         * <p>
         * Adds a value to <code>entities</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder entities(Function<Entity.Builder, ObjectBuilder<Entity>> fn) {
            return entities(fn.apply(new Entity.Builder()).build());
        }

        /**
         * The overall aggregate value.
         * <p>
         * API name: {@code overall_aggregate_value}
         * </p>
         */
        @Nonnull
        public final Builder overallAggregateValue(@Nullable Double value) {
            this.overallAggregateValue = value;
            return this;
        }

        /**
         * The start time.
         * <p>
         * API name: {@code start_time}
         * </p>
         */
        @Nonnull
        public final Builder startTime(@Nullable Long value) {
            this.startTime = value;
            return this;
        }

        /**
         * Builds a {@link Buckets}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Buckets build() {
            _checkSingleUse();

            return new Buckets(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Buckets}
     */
    public static final JsonpDeserializer<Buckets> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Buckets::setupBucketsDeserializer
    );

    protected static void setupBucketsDeserializer(ObjectDeserializer<Buckets.Builder> op) {
        op.add(Builder::endTime, JsonpDeserializer.longDeserializer(), "end_time");
        op.add(Builder::entities, JsonpDeserializer.arrayDeserializer(Entity._DESERIALIZER), "entities");
        op.add(Builder::overallAggregateValue, JsonpDeserializer.doubleDeserializer(), "overall_aggregate_value");
        op.add(Builder::startTime, JsonpDeserializer.longDeserializer(), "start_time");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.endTime);
        result = 31 * result + Objects.hashCode(this.entities);
        result = 31 * result + Objects.hashCode(this.overallAggregateValue);
        result = 31 * result + Objects.hashCode(this.startTime);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Buckets other = (Buckets) o;
        return Objects.equals(this.endTime, other.endTime)
            && Objects.equals(this.entities, other.entities)
            && Objects.equals(this.overallAggregateValue, other.overallAggregateValue)
            && Objects.equals(this.startTime, other.startTime);
    }
}
