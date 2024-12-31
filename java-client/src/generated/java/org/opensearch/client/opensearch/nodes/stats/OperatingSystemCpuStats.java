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

package org.opensearch.client.opensearch.nodes.stats;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
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

// typedef: nodes.stats.OperatingSystemCpuStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OperatingSystemCpuStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<OperatingSystemCpuStats.Builder, OperatingSystemCpuStats> {

    @Nonnull
    private final Map<String, Double> loadAverage;

    @Nullable
    private final Double percent;

    // ---------------------------------------------------------------------------------------------

    private OperatingSystemCpuStats(Builder builder) {
        this.loadAverage = ApiTypeHelper.unmodifiable(builder.loadAverage);
        this.percent = builder.percent;
    }

    public static OperatingSystemCpuStats of(Function<OperatingSystemCpuStats.Builder, ObjectBuilder<OperatingSystemCpuStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code load_average}
     */
    @Nonnull
    public final Map<String, Double> loadAverage() {
        return this.loadAverage;
    }

    /**
     * API name: {@code percent}
     */
    @Nullable
    public final Double percent() {
        return this.percent;
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
        if (ApiTypeHelper.isDefined(this.loadAverage)) {
            generator.writeKey("load_average");
            generator.writeStartObject();
            for (Map.Entry<String, Double> item0 : this.loadAverage.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        if (this.percent != null) {
            generator.writeKey("percent");
            generator.write(this.percent);
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
     * Builder for {@link OperatingSystemCpuStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, OperatingSystemCpuStats> {
        @Nullable
        private Map<String, Double> loadAverage;
        @Nullable
        private Double percent;

        public Builder() {}

        private Builder(OperatingSystemCpuStats o) {
            this.loadAverage = _mapCopy(o.loadAverage);
            this.percent = o.percent;
        }

        private Builder(Builder o) {
            this.loadAverage = _mapCopy(o.loadAverage);
            this.percent = o.percent;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code load_average}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>loadAverage</code>.
         * </p>
         */
        @Nonnull
        public final Builder loadAverage(Map<String, Double> map) {
            this.loadAverage = _mapPutAll(this.loadAverage, map);
            return this;
        }

        /**
         * API name: {@code load_average}
         *
         * <p>
         * Adds an entry to <code>loadAverage</code>.
         * </p>
         */
        @Nonnull
        public final Builder loadAverage(String key, Double value) {
            this.loadAverage = _mapPut(this.loadAverage, key, value);
            return this;
        }

        /**
         * API name: {@code percent}
         */
        @Nonnull
        public final Builder percent(@Nullable Double value) {
            this.percent = value;
            return this;
        }

        /**
         * Builds a {@link OperatingSystemCpuStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public OperatingSystemCpuStats build() {
            _checkSingleUse();

            return new OperatingSystemCpuStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link OperatingSystemCpuStats}
     */
    public static final JsonpDeserializer<OperatingSystemCpuStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        OperatingSystemCpuStats::setupOperatingSystemCpuStatsDeserializer
    );

    protected static void setupOperatingSystemCpuStatsDeserializer(ObjectDeserializer<OperatingSystemCpuStats.Builder> op) {
        op.add(Builder::loadAverage, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.doubleDeserializer()), "load_average");
        op.add(Builder::percent, JsonpDeserializer.doubleDeserializer(), "percent");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.loadAverage);
        result = 31 * result + Objects.hashCode(this.percent);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        OperatingSystemCpuStats other = (OperatingSystemCpuStats) o;
        return Objects.equals(this.loadAverage, other.loadAverage) && Objects.equals(this.percent, other.percent);
    }
}
