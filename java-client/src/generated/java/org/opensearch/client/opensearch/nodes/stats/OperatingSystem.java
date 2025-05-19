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

// typedef: nodes.stats.OperatingSystem

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OperatingSystem implements PlainJsonSerializable, ToCopyableBuilder<OperatingSystem.Builder, OperatingSystem> {

    @Nullable
    private final CgroupStats cgroup;

    @Nullable
    private final OperatingSystemCpuStats cpu;

    @Nullable
    private final ExtendedMemoryStats mem;

    @Nullable
    private final MemoryStats swap;

    @Nullable
    private final Long timestamp;

    // ---------------------------------------------------------------------------------------------

    private OperatingSystem(Builder builder) {
        this.cgroup = builder.cgroup;
        this.cpu = builder.cpu;
        this.mem = builder.mem;
        this.swap = builder.swap;
        this.timestamp = builder.timestamp;
    }

    public static OperatingSystem of(Function<OperatingSystem.Builder, ObjectBuilder<OperatingSystem>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code cgroup}
     */
    @Nullable
    public final CgroupStats cgroup() {
        return this.cgroup;
    }

    /**
     * API name: {@code cpu}
     */
    @Nullable
    public final OperatingSystemCpuStats cpu() {
        return this.cpu;
    }

    /**
     * API name: {@code mem}
     */
    @Nullable
    public final ExtendedMemoryStats mem() {
        return this.mem;
    }

    /**
     * API name: {@code swap}
     */
    @Nullable
    public final MemoryStats swap() {
        return this.swap;
    }

    /**
     * API name: {@code timestamp}
     */
    @Nullable
    public final Long timestamp() {
        return this.timestamp;
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
        if (this.cgroup != null) {
            generator.writeKey("cgroup");
            this.cgroup.serialize(generator, mapper);
        }

        if (this.cpu != null) {
            generator.writeKey("cpu");
            this.cpu.serialize(generator, mapper);
        }

        if (this.mem != null) {
            generator.writeKey("mem");
            this.mem.serialize(generator, mapper);
        }

        if (this.swap != null) {
            generator.writeKey("swap");
            this.swap.serialize(generator, mapper);
        }

        if (this.timestamp != null) {
            generator.writeKey("timestamp");
            generator.write(this.timestamp);
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
     * Builder for {@link OperatingSystem}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, OperatingSystem> {
        @Nullable
        private CgroupStats cgroup;
        @Nullable
        private OperatingSystemCpuStats cpu;
        @Nullable
        private ExtendedMemoryStats mem;
        @Nullable
        private MemoryStats swap;
        @Nullable
        private Long timestamp;

        public Builder() {}

        private Builder(OperatingSystem o) {
            this.cgroup = o.cgroup;
            this.cpu = o.cpu;
            this.mem = o.mem;
            this.swap = o.swap;
            this.timestamp = o.timestamp;
        }

        private Builder(Builder o) {
            this.cgroup = o.cgroup;
            this.cpu = o.cpu;
            this.mem = o.mem;
            this.swap = o.swap;
            this.timestamp = o.timestamp;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code cgroup}
         */
        @Nonnull
        public final Builder cgroup(@Nullable CgroupStats value) {
            this.cgroup = value;
            return this;
        }

        /**
         * API name: {@code cgroup}
         */
        @Nonnull
        public final Builder cgroup(Function<CgroupStats.Builder, ObjectBuilder<CgroupStats>> fn) {
            return cgroup(fn.apply(new CgroupStats.Builder()).build());
        }

        /**
         * API name: {@code cpu}
         */
        @Nonnull
        public final Builder cpu(@Nullable OperatingSystemCpuStats value) {
            this.cpu = value;
            return this;
        }

        /**
         * API name: {@code cpu}
         */
        @Nonnull
        public final Builder cpu(Function<OperatingSystemCpuStats.Builder, ObjectBuilder<OperatingSystemCpuStats>> fn) {
            return cpu(fn.apply(new OperatingSystemCpuStats.Builder()).build());
        }

        /**
         * API name: {@code mem}
         */
        @Nonnull
        public final Builder mem(@Nullable ExtendedMemoryStats value) {
            this.mem = value;
            return this;
        }

        /**
         * API name: {@code mem}
         */
        @Nonnull
        public final Builder mem(Function<ExtendedMemoryStats.Builder, ObjectBuilder<ExtendedMemoryStats>> fn) {
            return mem(fn.apply(new ExtendedMemoryStats.Builder()).build());
        }

        /**
         * API name: {@code swap}
         */
        @Nonnull
        public final Builder swap(@Nullable MemoryStats value) {
            this.swap = value;
            return this;
        }

        /**
         * API name: {@code swap}
         */
        @Nonnull
        public final Builder swap(Function<MemoryStats.Builder, ObjectBuilder<MemoryStats>> fn) {
            return swap(fn.apply(new MemoryStats.Builder()).build());
        }

        /**
         * API name: {@code timestamp}
         */
        @Nonnull
        public final Builder timestamp(@Nullable Long value) {
            this.timestamp = value;
            return this;
        }

        /**
         * Builds a {@link OperatingSystem}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public OperatingSystem build() {
            _checkSingleUse();

            return new OperatingSystem(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link OperatingSystem}
     */
    public static final JsonpDeserializer<OperatingSystem> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        OperatingSystem::setupOperatingSystemDeserializer
    );

    protected static void setupOperatingSystemDeserializer(ObjectDeserializer<OperatingSystem.Builder> op) {
        op.add(Builder::cgroup, CgroupStats._DESERIALIZER, "cgroup");
        op.add(Builder::cpu, OperatingSystemCpuStats._DESERIALIZER, "cpu");
        op.add(Builder::mem, ExtendedMemoryStats._DESERIALIZER, "mem");
        op.add(Builder::swap, MemoryStats._DESERIALIZER, "swap");
        op.add(Builder::timestamp, JsonpDeserializer.longDeserializer(), "timestamp");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.cgroup);
        result = 31 * result + Objects.hashCode(this.cpu);
        result = 31 * result + Objects.hashCode(this.mem);
        result = 31 * result + Objects.hashCode(this.swap);
        result = 31 * result + Objects.hashCode(this.timestamp);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        OperatingSystem other = (OperatingSystem) o;
        return Objects.equals(this.cgroup, other.cgroup)
            && Objects.equals(this.cpu, other.cpu)
            && Objects.equals(this.mem, other.mem)
            && Objects.equals(this.swap, other.swap)
            && Objects.equals(this.timestamp, other.timestamp);
    }
}
