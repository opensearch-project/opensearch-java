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

// typedef: nodes.stats.CgroupCpuStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CgroupCpuStats implements PlainJsonSerializable, ToCopyableBuilder<CgroupCpuStats.Builder, CgroupCpuStats> {

    @Nullable
    private final Long cfsPeriodMicros;

    @Nullable
    private final Long cfsQuotaMicros;

    @Nullable
    private final String controlGroup;

    @Nullable
    private final CgroupCpuStat stat;

    // ---------------------------------------------------------------------------------------------

    private CgroupCpuStats(Builder builder) {
        this.cfsPeriodMicros = builder.cfsPeriodMicros;
        this.cfsQuotaMicros = builder.cfsQuotaMicros;
        this.controlGroup = builder.controlGroup;
        this.stat = builder.stat;
    }

    public static CgroupCpuStats of(Function<CgroupCpuStats.Builder, ObjectBuilder<CgroupCpuStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The period of time, in microseconds, for how regularly all tasks in the same cgroup as the OpenSearch process should have their
     * access to CPU resources reallocated.
     * <p>
     * API name: {@code cfs_period_micros}
     * </p>
     */
    @Nullable
    public final Long cfsPeriodMicros() {
        return this.cfsPeriodMicros;
    }

    /**
     * The total amount of time, in microseconds, for which all tasks in the same cgroup as the OpenSearch process can run during one period
     * <code>cfs_period_micros</code>.
     * <p>
     * API name: {@code cfs_quota_micros}
     * </p>
     */
    @Nullable
    public final Long cfsQuotaMicros() {
        return this.cfsQuotaMicros;
    }

    /**
     * The <code>cpu</code> control group to which the OpenSearch process belongs.
     * <p>
     * API name: {@code control_group}
     * </p>
     */
    @Nullable
    public final String controlGroup() {
        return this.controlGroup;
    }

    /**
     * API name: {@code stat}
     */
    @Nullable
    public final CgroupCpuStat stat() {
        return this.stat;
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
        if (this.cfsPeriodMicros != null) {
            generator.writeKey("cfs_period_micros");
            generator.write(this.cfsPeriodMicros);
        }

        if (this.cfsQuotaMicros != null) {
            generator.writeKey("cfs_quota_micros");
            generator.write(this.cfsQuotaMicros);
        }

        if (this.controlGroup != null) {
            generator.writeKey("control_group");
            generator.write(this.controlGroup);
        }

        if (this.stat != null) {
            generator.writeKey("stat");
            this.stat.serialize(generator, mapper);
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
     * Builder for {@link CgroupCpuStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CgroupCpuStats> {
        @Nullable
        private Long cfsPeriodMicros;
        @Nullable
        private Long cfsQuotaMicros;
        @Nullable
        private String controlGroup;
        @Nullable
        private CgroupCpuStat stat;

        public Builder() {}

        private Builder(CgroupCpuStats o) {
            this.cfsPeriodMicros = o.cfsPeriodMicros;
            this.cfsQuotaMicros = o.cfsQuotaMicros;
            this.controlGroup = o.controlGroup;
            this.stat = o.stat;
        }

        private Builder(Builder o) {
            this.cfsPeriodMicros = o.cfsPeriodMicros;
            this.cfsQuotaMicros = o.cfsQuotaMicros;
            this.controlGroup = o.controlGroup;
            this.stat = o.stat;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The period of time, in microseconds, for how regularly all tasks in the same cgroup as the OpenSearch process should have their
         * access to CPU resources reallocated.
         * <p>
         * API name: {@code cfs_period_micros}
         * </p>
         */
        @Nonnull
        public final Builder cfsPeriodMicros(@Nullable Long value) {
            this.cfsPeriodMicros = value;
            return this;
        }

        /**
         * The total amount of time, in microseconds, for which all tasks in the same cgroup as the OpenSearch process can run during one
         * period <code>cfs_period_micros</code>.
         * <p>
         * API name: {@code cfs_quota_micros}
         * </p>
         */
        @Nonnull
        public final Builder cfsQuotaMicros(@Nullable Long value) {
            this.cfsQuotaMicros = value;
            return this;
        }

        /**
         * The <code>cpu</code> control group to which the OpenSearch process belongs.
         * <p>
         * API name: {@code control_group}
         * </p>
         */
        @Nonnull
        public final Builder controlGroup(@Nullable String value) {
            this.controlGroup = value;
            return this;
        }

        /**
         * API name: {@code stat}
         */
        @Nonnull
        public final Builder stat(@Nullable CgroupCpuStat value) {
            this.stat = value;
            return this;
        }

        /**
         * API name: {@code stat}
         */
        @Nonnull
        public final Builder stat(Function<CgroupCpuStat.Builder, ObjectBuilder<CgroupCpuStat>> fn) {
            return stat(fn.apply(new CgroupCpuStat.Builder()).build());
        }

        /**
         * Builds a {@link CgroupCpuStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CgroupCpuStats build() {
            _checkSingleUse();

            return new CgroupCpuStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CgroupCpuStats}
     */
    public static final JsonpDeserializer<CgroupCpuStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CgroupCpuStats::setupCgroupCpuStatsDeserializer
    );

    protected static void setupCgroupCpuStatsDeserializer(ObjectDeserializer<CgroupCpuStats.Builder> op) {
        op.add(Builder::cfsPeriodMicros, JsonpDeserializer.longDeserializer(), "cfs_period_micros");
        op.add(Builder::cfsQuotaMicros, JsonpDeserializer.longDeserializer(), "cfs_quota_micros");
        op.add(Builder::controlGroup, JsonpDeserializer.stringDeserializer(), "control_group");
        op.add(Builder::stat, CgroupCpuStat._DESERIALIZER, "stat");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.cfsPeriodMicros);
        result = 31 * result + Objects.hashCode(this.cfsQuotaMicros);
        result = 31 * result + Objects.hashCode(this.controlGroup);
        result = 31 * result + Objects.hashCode(this.stat);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CgroupCpuStats other = (CgroupCpuStats) o;
        return Objects.equals(this.cfsPeriodMicros, other.cfsPeriodMicros)
            && Objects.equals(this.cfsQuotaMicros, other.cfsQuotaMicros)
            && Objects.equals(this.controlGroup, other.controlGroup)
            && Objects.equals(this.stat, other.stat);
    }
}
