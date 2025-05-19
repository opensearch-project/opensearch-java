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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.ProcessCpuStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ProcessCpuStats implements PlainJsonSerializable, ToCopyableBuilder<ProcessCpuStats.Builder, ProcessCpuStats> {

    private final double percent;

    @Nullable
    private final Time total;

    private final long totalInMillis;

    // ---------------------------------------------------------------------------------------------

    private ProcessCpuStats(Builder builder) {
        this.percent = ApiTypeHelper.requireNonNull(builder.percent, this, "percent");
        this.total = builder.total;
        this.totalInMillis = ApiTypeHelper.requireNonNull(builder.totalInMillis, this, "totalInMillis");
    }

    public static ProcessCpuStats of(Function<ProcessCpuStats.Builder, ObjectBuilder<ProcessCpuStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code percent}
     */
    public final double percent() {
        return this.percent;
    }

    /**
     * API name: {@code total}
     */
    @Nullable
    public final Time total() {
        return this.total;
    }

    /**
     * Required - API name: {@code total_in_millis}
     */
    public final long totalInMillis() {
        return this.totalInMillis;
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
        generator.writeKey("percent");
        generator.write(this.percent);

        if (this.total != null) {
            generator.writeKey("total");
            this.total.serialize(generator, mapper);
        }

        generator.writeKey("total_in_millis");
        generator.write(this.totalInMillis);
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
     * Builder for {@link ProcessCpuStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ProcessCpuStats> {
        private Double percent;
        @Nullable
        private Time total;
        private Long totalInMillis;

        public Builder() {}

        private Builder(ProcessCpuStats o) {
            this.percent = o.percent;
            this.total = o.total;
            this.totalInMillis = o.totalInMillis;
        }

        private Builder(Builder o) {
            this.percent = o.percent;
            this.total = o.total;
            this.totalInMillis = o.totalInMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code percent}
         */
        @Nonnull
        public final Builder percent(double value) {
            this.percent = value;
            return this;
        }

        /**
         * API name: {@code total}
         */
        @Nonnull
        public final Builder total(@Nullable Time value) {
            this.total = value;
            return this;
        }

        /**
         * API name: {@code total}
         */
        @Nonnull
        public final Builder total(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return total(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code total_in_millis}
         */
        @Nonnull
        public final Builder totalInMillis(long value) {
            this.totalInMillis = value;
            return this;
        }

        /**
         * Builds a {@link ProcessCpuStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ProcessCpuStats build() {
            _checkSingleUse();

            return new ProcessCpuStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ProcessCpuStats}
     */
    public static final JsonpDeserializer<ProcessCpuStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ProcessCpuStats::setupProcessCpuStatsDeserializer
    );

    protected static void setupProcessCpuStatsDeserializer(ObjectDeserializer<ProcessCpuStats.Builder> op) {
        op.add(Builder::percent, JsonpDeserializer.doubleDeserializer(), "percent");
        op.add(Builder::total, Time._DESERIALIZER, "total");
        op.add(Builder::totalInMillis, JsonpDeserializer.longDeserializer(), "total_in_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(this.percent);
        result = 31 * result + Objects.hashCode(this.total);
        result = 31 * result + Long.hashCode(this.totalInMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ProcessCpuStats other = (ProcessCpuStats) o;
        return this.percent == other.percent && Objects.equals(this.total, other.total) && this.totalInMillis == other.totalInMillis;
    }
}
