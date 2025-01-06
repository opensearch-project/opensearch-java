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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.CgroupCpuStat

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CgroupCpuStat implements PlainJsonSerializable, ToCopyableBuilder<CgroupCpuStat.Builder, CgroupCpuStat> {

    @Nullable
    private final Long numberOfElapsedPeriods;

    @Nullable
    private final Long numberOfTimesThrottled;

    @Nullable
    private final Long timeThrottledNanos;

    // ---------------------------------------------------------------------------------------------

    private CgroupCpuStat(Builder builder) {
        this.numberOfElapsedPeriods = builder.numberOfElapsedPeriods;
        this.numberOfTimesThrottled = builder.numberOfTimesThrottled;
        this.timeThrottledNanos = builder.timeThrottledNanos;
    }

    public static CgroupCpuStat of(Function<CgroupCpuStat.Builder, ObjectBuilder<CgroupCpuStat>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The number of reporting periods (as specified by <code>cfs_period_micros</code>) that have elapsed.
     * <p>
     * API name: {@code number_of_elapsed_periods}
     * </p>
     */
    @Nullable
    public final Long numberOfElapsedPeriods() {
        return this.numberOfElapsedPeriods;
    }

    /**
     * The number of times all tasks in the same cgroup as the OpenSearch process have been throttled.
     * <p>
     * API name: {@code number_of_times_throttled}
     * </p>
     */
    @Nullable
    public final Long numberOfTimesThrottled() {
        return this.numberOfTimesThrottled;
    }

    /**
     * API name: {@code time_throttled_nanos}
     */
    @Nullable
    public final Long timeThrottledNanos() {
        return this.timeThrottledNanos;
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
        if (this.numberOfElapsedPeriods != null) {
            generator.writeKey("number_of_elapsed_periods");
            generator.write(this.numberOfElapsedPeriods);
        }

        if (this.numberOfTimesThrottled != null) {
            generator.writeKey("number_of_times_throttled");
            generator.write(this.numberOfTimesThrottled);
        }

        if (this.timeThrottledNanos != null) {
            generator.writeKey("time_throttled_nanos");
            generator.write(this.timeThrottledNanos);
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
     * Builder for {@link CgroupCpuStat}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CgroupCpuStat> {
        @Nullable
        private Long numberOfElapsedPeriods;
        @Nullable
        private Long numberOfTimesThrottled;
        @Nullable
        private Long timeThrottledNanos;

        public Builder() {}

        private Builder(CgroupCpuStat o) {
            this.numberOfElapsedPeriods = o.numberOfElapsedPeriods;
            this.numberOfTimesThrottled = o.numberOfTimesThrottled;
            this.timeThrottledNanos = o.timeThrottledNanos;
        }

        private Builder(Builder o) {
            this.numberOfElapsedPeriods = o.numberOfElapsedPeriods;
            this.numberOfTimesThrottled = o.numberOfTimesThrottled;
            this.timeThrottledNanos = o.timeThrottledNanos;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The number of reporting periods (as specified by <code>cfs_period_micros</code>) that have elapsed.
         * <p>
         * API name: {@code number_of_elapsed_periods}
         * </p>
         */
        @Nonnull
        public final Builder numberOfElapsedPeriods(@Nullable Long value) {
            this.numberOfElapsedPeriods = value;
            return this;
        }

        /**
         * The number of times all tasks in the same cgroup as the OpenSearch process have been throttled.
         * <p>
         * API name: {@code number_of_times_throttled}
         * </p>
         */
        @Nonnull
        public final Builder numberOfTimesThrottled(@Nullable Long value) {
            this.numberOfTimesThrottled = value;
            return this;
        }

        /**
         * API name: {@code time_throttled_nanos}
         */
        @Nonnull
        public final Builder timeThrottledNanos(@Nullable Long value) {
            this.timeThrottledNanos = value;
            return this;
        }

        /**
         * Builds a {@link CgroupCpuStat}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CgroupCpuStat build() {
            _checkSingleUse();

            return new CgroupCpuStat(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CgroupCpuStat}
     */
    public static final JsonpDeserializer<CgroupCpuStat> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CgroupCpuStat::setupCgroupCpuStatDeserializer
    );

    protected static void setupCgroupCpuStatDeserializer(ObjectDeserializer<CgroupCpuStat.Builder> op) {
        op.add(Builder::numberOfElapsedPeriods, JsonpDeserializer.longDeserializer(), "number_of_elapsed_periods");
        op.add(Builder::numberOfTimesThrottled, JsonpDeserializer.longDeserializer(), "number_of_times_throttled");
        op.add(Builder::timeThrottledNanos, JsonpDeserializer.longDeserializer(), "time_throttled_nanos");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.numberOfElapsedPeriods);
        result = 31 * result + Objects.hashCode(this.numberOfTimesThrottled);
        result = 31 * result + Objects.hashCode(this.timeThrottledNanos);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CgroupCpuStat other = (CgroupCpuStat) o;
        return Objects.equals(this.numberOfElapsedPeriods, other.numberOfElapsedPeriods)
            && Objects.equals(this.numberOfTimesThrottled, other.numberOfTimesThrottled)
            && Objects.equals(this.timeThrottledNanos, other.timeThrottledNanos);
    }
}
