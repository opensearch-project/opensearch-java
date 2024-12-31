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

// typedef: nodes.stats.CgroupStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CgroupStats implements PlainJsonSerializable, ToCopyableBuilder<CgroupStats.Builder, CgroupStats> {

    @Nullable
    private final CgroupCpuStats cpu;

    @Nullable
    private final CgroupCpuAcctStats cpuacct;

    @Nullable
    private final CgroupMemoryStats memory;

    // ---------------------------------------------------------------------------------------------

    private CgroupStats(Builder builder) {
        this.cpu = builder.cpu;
        this.cpuacct = builder.cpuacct;
        this.memory = builder.memory;
    }

    public static CgroupStats of(Function<CgroupStats.Builder, ObjectBuilder<CgroupStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code cpu}
     */
    @Nullable
    public final CgroupCpuStats cpu() {
        return this.cpu;
    }

    /**
     * API name: {@code cpuacct}
     */
    @Nullable
    public final CgroupCpuAcctStats cpuacct() {
        return this.cpuacct;
    }

    /**
     * API name: {@code memory}
     */
    @Nullable
    public final CgroupMemoryStats memory() {
        return this.memory;
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
        if (this.cpu != null) {
            generator.writeKey("cpu");
            this.cpu.serialize(generator, mapper);
        }

        if (this.cpuacct != null) {
            generator.writeKey("cpuacct");
            this.cpuacct.serialize(generator, mapper);
        }

        if (this.memory != null) {
            generator.writeKey("memory");
            this.memory.serialize(generator, mapper);
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
     * Builder for {@link CgroupStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CgroupStats> {
        @Nullable
        private CgroupCpuStats cpu;
        @Nullable
        private CgroupCpuAcctStats cpuacct;
        @Nullable
        private CgroupMemoryStats memory;

        public Builder() {}

        private Builder(CgroupStats o) {
            this.cpu = o.cpu;
            this.cpuacct = o.cpuacct;
            this.memory = o.memory;
        }

        private Builder(Builder o) {
            this.cpu = o.cpu;
            this.cpuacct = o.cpuacct;
            this.memory = o.memory;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code cpu}
         */
        @Nonnull
        public final Builder cpu(@Nullable CgroupCpuStats value) {
            this.cpu = value;
            return this;
        }

        /**
         * API name: {@code cpu}
         */
        @Nonnull
        public final Builder cpu(Function<CgroupCpuStats.Builder, ObjectBuilder<CgroupCpuStats>> fn) {
            return cpu(fn.apply(new CgroupCpuStats.Builder()).build());
        }

        /**
         * API name: {@code cpuacct}
         */
        @Nonnull
        public final Builder cpuacct(@Nullable CgroupCpuAcctStats value) {
            this.cpuacct = value;
            return this;
        }

        /**
         * API name: {@code cpuacct}
         */
        @Nonnull
        public final Builder cpuacct(Function<CgroupCpuAcctStats.Builder, ObjectBuilder<CgroupCpuAcctStats>> fn) {
            return cpuacct(fn.apply(new CgroupCpuAcctStats.Builder()).build());
        }

        /**
         * API name: {@code memory}
         */
        @Nonnull
        public final Builder memory(@Nullable CgroupMemoryStats value) {
            this.memory = value;
            return this;
        }

        /**
         * API name: {@code memory}
         */
        @Nonnull
        public final Builder memory(Function<CgroupMemoryStats.Builder, ObjectBuilder<CgroupMemoryStats>> fn) {
            return memory(fn.apply(new CgroupMemoryStats.Builder()).build());
        }

        /**
         * Builds a {@link CgroupStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CgroupStats build() {
            _checkSingleUse();

            return new CgroupStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CgroupStats}
     */
    public static final JsonpDeserializer<CgroupStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CgroupStats::setupCgroupStatsDeserializer
    );

    protected static void setupCgroupStatsDeserializer(ObjectDeserializer<CgroupStats.Builder> op) {
        op.add(Builder::cpu, CgroupCpuStats._DESERIALIZER, "cpu");
        op.add(Builder::cpuacct, CgroupCpuAcctStats._DESERIALIZER, "cpuacct");
        op.add(Builder::memory, CgroupMemoryStats._DESERIALIZER, "memory");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.cpu);
        result = 31 * result + Objects.hashCode(this.cpuacct);
        result = 31 * result + Objects.hashCode(this.memory);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CgroupStats other = (CgroupStats) o;
        return Objects.equals(this.cpu, other.cpu)
            && Objects.equals(this.cpuacct, other.cpuacct)
            && Objects.equals(this.memory, other.memory);
    }
}
