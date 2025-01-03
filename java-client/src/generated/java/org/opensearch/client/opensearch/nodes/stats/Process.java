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

// typedef: nodes.stats.Process

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Process implements PlainJsonSerializable, ToCopyableBuilder<Process.Builder, Process> {

    @Nullable
    private final ProcessCpuStats cpu;

    @Nullable
    private final Long maxFileDescriptors;

    @Nullable
    private final ProcessMemoryStats mem;

    @Nullable
    private final Long openFileDescriptors;

    @Nullable
    private final Long timestamp;

    // ---------------------------------------------------------------------------------------------

    private Process(Builder builder) {
        this.cpu = builder.cpu;
        this.maxFileDescriptors = builder.maxFileDescriptors;
        this.mem = builder.mem;
        this.openFileDescriptors = builder.openFileDescriptors;
        this.timestamp = builder.timestamp;
    }

    public static Process of(Function<Process.Builder, ObjectBuilder<Process>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code cpu}
     */
    @Nullable
    public final ProcessCpuStats cpu() {
        return this.cpu;
    }

    /**
     * Maximum number of file descriptors allowed on the system, or <code>-1</code> if not supported.
     * <p>
     * API name: {@code max_file_descriptors}
     * </p>
     */
    @Nullable
    public final Long maxFileDescriptors() {
        return this.maxFileDescriptors;
    }

    /**
     * API name: {@code mem}
     */
    @Nullable
    public final ProcessMemoryStats mem() {
        return this.mem;
    }

    /**
     * Number of opened file descriptors associated with the current or <code>-1</code> if not supported.
     * <p>
     * API name: {@code open_file_descriptors}
     * </p>
     */
    @Nullable
    public final Long openFileDescriptors() {
        return this.openFileDescriptors;
    }

    /**
     * Last time the statistics were refreshed. Recorded in milliseconds since the Unix Epoch.
     * <p>
     * API name: {@code timestamp}
     * </p>
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
        if (this.cpu != null) {
            generator.writeKey("cpu");
            this.cpu.serialize(generator, mapper);
        }

        if (this.maxFileDescriptors != null) {
            generator.writeKey("max_file_descriptors");
            generator.write(this.maxFileDescriptors);
        }

        if (this.mem != null) {
            generator.writeKey("mem");
            this.mem.serialize(generator, mapper);
        }

        if (this.openFileDescriptors != null) {
            generator.writeKey("open_file_descriptors");
            generator.write(this.openFileDescriptors);
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
     * Builder for {@link Process}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Process> {
        @Nullable
        private ProcessCpuStats cpu;
        @Nullable
        private Long maxFileDescriptors;
        @Nullable
        private ProcessMemoryStats mem;
        @Nullable
        private Long openFileDescriptors;
        @Nullable
        private Long timestamp;

        public Builder() {}

        private Builder(Process o) {
            this.cpu = o.cpu;
            this.maxFileDescriptors = o.maxFileDescriptors;
            this.mem = o.mem;
            this.openFileDescriptors = o.openFileDescriptors;
            this.timestamp = o.timestamp;
        }

        private Builder(Builder o) {
            this.cpu = o.cpu;
            this.maxFileDescriptors = o.maxFileDescriptors;
            this.mem = o.mem;
            this.openFileDescriptors = o.openFileDescriptors;
            this.timestamp = o.timestamp;
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
        public final Builder cpu(@Nullable ProcessCpuStats value) {
            this.cpu = value;
            return this;
        }

        /**
         * API name: {@code cpu}
         */
        @Nonnull
        public final Builder cpu(Function<ProcessCpuStats.Builder, ObjectBuilder<ProcessCpuStats>> fn) {
            return cpu(fn.apply(new ProcessCpuStats.Builder()).build());
        }

        /**
         * Maximum number of file descriptors allowed on the system, or <code>-1</code> if not supported.
         * <p>
         * API name: {@code max_file_descriptors}
         * </p>
         */
        @Nonnull
        public final Builder maxFileDescriptors(@Nullable Long value) {
            this.maxFileDescriptors = value;
            return this;
        }

        /**
         * API name: {@code mem}
         */
        @Nonnull
        public final Builder mem(@Nullable ProcessMemoryStats value) {
            this.mem = value;
            return this;
        }

        /**
         * API name: {@code mem}
         */
        @Nonnull
        public final Builder mem(Function<ProcessMemoryStats.Builder, ObjectBuilder<ProcessMemoryStats>> fn) {
            return mem(fn.apply(new ProcessMemoryStats.Builder()).build());
        }

        /**
         * Number of opened file descriptors associated with the current or <code>-1</code> if not supported.
         * <p>
         * API name: {@code open_file_descriptors}
         * </p>
         */
        @Nonnull
        public final Builder openFileDescriptors(@Nullable Long value) {
            this.openFileDescriptors = value;
            return this;
        }

        /**
         * Last time the statistics were refreshed. Recorded in milliseconds since the Unix Epoch.
         * <p>
         * API name: {@code timestamp}
         * </p>
         */
        @Nonnull
        public final Builder timestamp(@Nullable Long value) {
            this.timestamp = value;
            return this;
        }

        /**
         * Builds a {@link Process}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Process build() {
            _checkSingleUse();

            return new Process(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Process}
     */
    public static final JsonpDeserializer<Process> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Process::setupProcessDeserializer
    );

    protected static void setupProcessDeserializer(ObjectDeserializer<Process.Builder> op) {
        op.add(Builder::cpu, ProcessCpuStats._DESERIALIZER, "cpu");
        op.add(Builder::maxFileDescriptors, JsonpDeserializer.longDeserializer(), "max_file_descriptors");
        op.add(Builder::mem, ProcessMemoryStats._DESERIALIZER, "mem");
        op.add(Builder::openFileDescriptors, JsonpDeserializer.longDeserializer(), "open_file_descriptors");
        op.add(Builder::timestamp, JsonpDeserializer.longDeserializer(), "timestamp");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.cpu);
        result = 31 * result + Objects.hashCode(this.maxFileDescriptors);
        result = 31 * result + Objects.hashCode(this.mem);
        result = 31 * result + Objects.hashCode(this.openFileDescriptors);
        result = 31 * result + Objects.hashCode(this.timestamp);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Process other = (Process) o;
        return Objects.equals(this.cpu, other.cpu)
            && Objects.equals(this.maxFileDescriptors, other.maxFileDescriptors)
            && Objects.equals(this.mem, other.mem)
            && Objects.equals(this.openFileDescriptors, other.openFileDescriptors)
            && Objects.equals(this.timestamp, other.timestamp);
    }
}
