/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch._types.aggregations;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
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

// typedef: _types.aggregations.StatsBucketAggregate

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class StatsBucketAggregate
    implements
        AggregateVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<StatsBucketAggregate.Builder, StatsBucketAggregate> {

    @Nullable
    private final Double avg;

    @Nullable
    private final String avgAsString;

    private final long count;

    @Nullable
    private final Double max;

    @Nullable
    private final String maxAsString;

    @Nonnull
    private final Map<String, JsonData> meta;

    @Nullable
    private final Double min;

    @Nullable
    private final String minAsString;

    private final double sum;

    @Nullable
    private final String sumAsString;

    // ---------------------------------------------------------------------------------------------

    private StatsBucketAggregate(Builder builder) {
        this.avg = builder.avg;
        this.avgAsString = builder.avgAsString;
        this.count = ApiTypeHelper.requireNonNull(builder.count, this, "count");
        this.max = builder.max;
        this.maxAsString = builder.maxAsString;
        this.meta = ApiTypeHelper.unmodifiable(builder.meta);
        this.min = builder.min;
        this.minAsString = builder.minAsString;
        this.sum = ApiTypeHelper.requireNonNull(builder.sum, this, "sum");
        this.sumAsString = builder.sumAsString;
    }

    public static StatsBucketAggregate of(Function<StatsBucketAggregate.Builder, ObjectBuilder<StatsBucketAggregate>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregate} variant kind.
     */
    @Override
    public Aggregate.Kind _aggregateKind() {
        return Aggregate.Kind.StatsBucket;
    }

    /**
     * API name: {@code avg}
     */
    @Nullable
    public final Double avg() {
        return this.avg;
    }

    /**
     * API name: {@code avg_as_string}
     */
    @Nullable
    public final String avgAsString() {
        return this.avgAsString;
    }

    /**
     * Required - API name: {@code count}
     */
    public final long count() {
        return this.count;
    }

    /**
     * API name: {@code max}
     */
    @Nullable
    public final Double max() {
        return this.max;
    }

    /**
     * API name: {@code max_as_string}
     */
    @Nullable
    public final String maxAsString() {
        return this.maxAsString;
    }

    /**
     * API name: {@code meta}
     */
    @Nonnull
    public final Map<String, JsonData> meta() {
        return this.meta;
    }

    /**
     * API name: {@code min}
     */
    @Nullable
    public final Double min() {
        return this.min;
    }

    /**
     * API name: {@code min_as_string}
     */
    @Nullable
    public final String minAsString() {
        return this.minAsString;
    }

    /**
     * Required - API name: {@code sum}
     */
    public final double sum() {
        return this.sum;
    }

    /**
     * API name: {@code sum_as_string}
     */
    @Nullable
    public final String sumAsString() {
        return this.sumAsString;
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
        if (this.avg != null) {
            generator.writeKey("avg");
            generator.write(this.avg);
        }

        if (this.avgAsString != null) {
            generator.writeKey("avg_as_string");
            generator.write(this.avgAsString);
        }

        generator.writeKey("count");
        generator.write(this.count);

        if (this.max != null) {
            generator.writeKey("max");
            generator.write(this.max);
        }

        if (this.maxAsString != null) {
            generator.writeKey("max_as_string");
            generator.write(this.maxAsString);
        }

        if (ApiTypeHelper.isDefined(this.meta)) {
            generator.writeKey("meta");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.meta.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.min != null) {
            generator.writeKey("min");
            generator.write(this.min);
        }

        if (this.minAsString != null) {
            generator.writeKey("min_as_string");
            generator.write(this.minAsString);
        }

        generator.writeKey("sum");
        generator.write(this.sum);

        if (this.sumAsString != null) {
            generator.writeKey("sum_as_string");
            generator.write(this.sumAsString);
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
     * Builder for {@link StatsBucketAggregate}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, StatsBucketAggregate> {
        @Nullable
        private Double avg;
        @Nullable
        private String avgAsString;
        private Long count;
        @Nullable
        private Double max;
        @Nullable
        private String maxAsString;
        @Nullable
        private Map<String, JsonData> meta;
        @Nullable
        private Double min;
        @Nullable
        private String minAsString;
        private Double sum;
        @Nullable
        private String sumAsString;

        public Builder() {}

        private Builder(StatsBucketAggregate o) {
            this.avg = o.avg;
            this.avgAsString = o.avgAsString;
            this.count = o.count;
            this.max = o.max;
            this.maxAsString = o.maxAsString;
            this.meta = _mapCopy(o.meta);
            this.min = o.min;
            this.minAsString = o.minAsString;
            this.sum = o.sum;
            this.sumAsString = o.sumAsString;
        }

        private Builder(Builder o) {
            this.avg = o.avg;
            this.avgAsString = o.avgAsString;
            this.count = o.count;
            this.max = o.max;
            this.maxAsString = o.maxAsString;
            this.meta = _mapCopy(o.meta);
            this.min = o.min;
            this.minAsString = o.minAsString;
            this.sum = o.sum;
            this.sumAsString = o.sumAsString;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code avg}
         */
        @Nonnull
        public final Builder avg(@Nullable Double value) {
            this.avg = value;
            return this;
        }

        /**
         * API name: {@code avg_as_string}
         */
        @Nonnull
        public final Builder avgAsString(@Nullable String value) {
            this.avgAsString = value;
            return this;
        }

        /**
         * Required - API name: {@code count}
         */
        @Nonnull
        public final Builder count(long value) {
            this.count = value;
            return this;
        }

        /**
         * API name: {@code max}
         */
        @Nonnull
        public final Builder max(@Nullable Double value) {
            this.max = value;
            return this;
        }

        /**
         * API name: {@code max_as_string}
         */
        @Nonnull
        public final Builder maxAsString(@Nullable String value) {
            this.maxAsString = value;
            return this;
        }

        /**
         * API name: {@code meta}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final Builder meta(Map<String, JsonData> map) {
            this.meta = _mapPutAll(this.meta, map);
            return this;
        }

        /**
         * API name: {@code meta}
         *
         * <p>
         * Adds an entry to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final Builder meta(String key, JsonData value) {
            this.meta = _mapPut(this.meta, key, value);
            return this;
        }

        /**
         * API name: {@code min}
         */
        @Nonnull
        public final Builder min(@Nullable Double value) {
            this.min = value;
            return this;
        }

        /**
         * API name: {@code min_as_string}
         */
        @Nonnull
        public final Builder minAsString(@Nullable String value) {
            this.minAsString = value;
            return this;
        }

        /**
         * Required - API name: {@code sum}
         */
        @Nonnull
        public final Builder sum(double value) {
            this.sum = value;
            return this;
        }

        /**
         * API name: {@code sum_as_string}
         */
        @Nonnull
        public final Builder sumAsString(@Nullable String value) {
            this.sumAsString = value;
            return this;
        }

        /**
         * Builds a {@link StatsBucketAggregate}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public StatsBucketAggregate build() {
            _checkSingleUse();

            return new StatsBucketAggregate(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link StatsBucketAggregate}
     */
    public static final JsonpDeserializer<StatsBucketAggregate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        StatsBucketAggregate::setupStatsBucketAggregateDeserializer
    );

    protected static void setupStatsBucketAggregateDeserializer(ObjectDeserializer<StatsBucketAggregate.Builder> op) {
        op.add(Builder::avg, JsonpDeserializer.doubleDeserializer(), "avg");
        op.add(Builder::avgAsString, JsonpDeserializer.stringDeserializer(), "avg_as_string");
        op.add(Builder::count, JsonpDeserializer.longDeserializer(), "count");
        op.add(Builder::max, JsonpDeserializer.doubleDeserializer(), "max");
        op.add(Builder::maxAsString, JsonpDeserializer.stringDeserializer(), "max_as_string");
        op.add(Builder::meta, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "meta");
        op.add(Builder::min, JsonpDeserializer.doubleDeserializer(), "min");
        op.add(Builder::minAsString, JsonpDeserializer.stringDeserializer(), "min_as_string");
        op.add(Builder::sum, JsonpDeserializer.doubleDeserializer(), "sum");
        op.add(Builder::sumAsString, JsonpDeserializer.stringDeserializer(), "sum_as_string");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.avg);
        result = 31 * result + Objects.hashCode(this.avgAsString);
        result = 31 * result + Long.hashCode(this.count);
        result = 31 * result + Objects.hashCode(this.max);
        result = 31 * result + Objects.hashCode(this.maxAsString);
        result = 31 * result + Objects.hashCode(this.meta);
        result = 31 * result + Objects.hashCode(this.min);
        result = 31 * result + Objects.hashCode(this.minAsString);
        result = 31 * result + Double.hashCode(this.sum);
        result = 31 * result + Objects.hashCode(this.sumAsString);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        StatsBucketAggregate other = (StatsBucketAggregate) o;
        return Objects.equals(this.avg, other.avg)
            && Objects.equals(this.avgAsString, other.avgAsString)
            && this.count == other.count
            && Objects.equals(this.max, other.max)
            && Objects.equals(this.maxAsString, other.maxAsString)
            && Objects.equals(this.meta, other.meta)
            && Objects.equals(this.min, other.min)
            && Objects.equals(this.minAsString, other.minAsString)
            && this.sum == other.sum
            && Objects.equals(this.sumAsString, other.sumAsString);
    }
}
