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

// typedef: _types.aggregations.SumAggregate

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SumAggregate implements AggregateVariant, PlainJsonSerializable, ToCopyableBuilder<SumAggregate.Builder, SumAggregate> {

    @Nonnull
    private final Map<String, JsonData> meta;

    @Nullable
    private final Double value;

    @Nullable
    private final String valueAsString;

    // ---------------------------------------------------------------------------------------------

    private SumAggregate(Builder builder) {
        this.meta = ApiTypeHelper.unmodifiable(builder.meta);
        this.value = builder.value;
        this.valueAsString = builder.valueAsString;
    }

    public static SumAggregate of(Function<SumAggregate.Builder, ObjectBuilder<SumAggregate>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregate} variant kind.
     */
    @Override
    public Aggregate.Kind _aggregateKind() {
        return Aggregate.Kind.Sum;
    }

    /**
     * API name: {@code meta}
     */
    @Nonnull
    public final Map<String, JsonData> meta() {
        return this.meta;
    }

    /**
     * The metric value. A missing value generally means that there was no data to aggregate, unless specified otherwise.
     * <p>
     * API name: {@code value}
     * </p>
     */
    @Nullable
    public final Double value() {
        return this.value;
    }

    /**
     * API name: {@code value_as_string}
     */
    @Nullable
    public final String valueAsString() {
        return this.valueAsString;
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
        if (ApiTypeHelper.isDefined(this.meta)) {
            generator.writeKey("meta");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.meta.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.value != null) {
            generator.writeKey("value");
            generator.write(this.value);
        }

        if (this.valueAsString != null) {
            generator.writeKey("value_as_string");
            generator.write(this.valueAsString);
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
     * Builder for {@link SumAggregate}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SumAggregate> {
        @Nullable
        private Map<String, JsonData> meta;
        @Nullable
        private Double value;
        @Nullable
        private String valueAsString;

        public Builder() {}

        private Builder(SumAggregate o) {
            this.meta = _mapCopy(o.meta);
            this.value = o.value;
            this.valueAsString = o.valueAsString;
        }

        private Builder(Builder o) {
            this.meta = _mapCopy(o.meta);
            this.value = o.value;
            this.valueAsString = o.valueAsString;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
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
         * The metric value. A missing value generally means that there was no data to aggregate, unless specified otherwise.
         * <p>
         * API name: {@code value}
         * </p>
         */
        @Nonnull
        public final Builder value(@Nullable Double value) {
            this.value = value;
            return this;
        }

        /**
         * API name: {@code value_as_string}
         */
        @Nonnull
        public final Builder valueAsString(@Nullable String value) {
            this.valueAsString = value;
            return this;
        }

        /**
         * Builds a {@link SumAggregate}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SumAggregate build() {
            _checkSingleUse();

            return new SumAggregate(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SumAggregate}
     */
    public static final JsonpDeserializer<SumAggregate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SumAggregate::setupSumAggregateDeserializer
    );

    protected static void setupSumAggregateDeserializer(ObjectDeserializer<SumAggregate.Builder> op) {
        op.add(Builder::meta, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "meta");
        op.add(Builder::value, JsonpDeserializer.doubleDeserializer(), "value");
        op.add(Builder::valueAsString, JsonpDeserializer.stringDeserializer(), "value_as_string");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.meta);
        result = 31 * result + Objects.hashCode(this.value);
        result = 31 * result + Objects.hashCode(this.valueAsString);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SumAggregate other = (SumAggregate) o;
        return Objects.equals(this.meta, other.meta)
            && Objects.equals(this.value, other.value)
            && Objects.equals(this.valueAsString, other.valueAsString);
    }
}
