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

package org.opensearch.client.opensearch.nodes.info;

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

// typedef: nodes.info.NodeOperatingSystemInfo

/**
 * Provides operating system information for the node.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeOperatingSystemInfo
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<NodeOperatingSystemInfo.Builder, NodeOperatingSystemInfo> {

    @Nullable
    private final Integer allocatedProcessors;

    @Nullable
    private final String arch;

    private final int availableProcessors;

    @Nullable
    private final NodeInfoOSCPU cpu;

    @Nullable
    private final NodeInfoMemory mem;

    @Nullable
    private final String name;

    @Nullable
    private final String prettyName;

    @Nullable
    private final Time refreshInterval;

    private final long refreshIntervalInMillis;

    @Nullable
    private final NodeInfoMemory swap;

    @Nullable
    private final String version;

    // ---------------------------------------------------------------------------------------------

    private NodeOperatingSystemInfo(Builder builder) {
        this.allocatedProcessors = builder.allocatedProcessors;
        this.arch = builder.arch;
        this.availableProcessors = ApiTypeHelper.requireNonNull(builder.availableProcessors, this, "availableProcessors");
        this.cpu = builder.cpu;
        this.mem = builder.mem;
        this.name = builder.name;
        this.prettyName = builder.prettyName;
        this.refreshInterval = builder.refreshInterval;
        this.refreshIntervalInMillis = ApiTypeHelper.requireNonNull(builder.refreshIntervalInMillis, this, "refreshIntervalInMillis");
        this.swap = builder.swap;
        this.version = builder.version;
    }

    public static NodeOperatingSystemInfo of(Function<NodeOperatingSystemInfo.Builder, ObjectBuilder<NodeOperatingSystemInfo>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The number of processors actually used to calculate thread pool size. This number can be set with the <code>node.processors</code>
     * setting of a node and defaults to the number of processors reported by the OS.
     * <p>
     * API name: {@code allocated_processors}
     * </p>
     */
    @Nullable
    public final Integer allocatedProcessors() {
        return this.allocatedProcessors;
    }

    /**
     * Name of the JVM architecture, for example <code>amd64</code> or <code>x86</code>.
     * <p>
     * API name: {@code arch}
     * </p>
     */
    @Nullable
    public final String arch() {
        return this.arch;
    }

    /**
     * Required - The number of processors available to the Java virtual machine.
     * <p>
     * API name: {@code available_processors}
     * </p>
     */
    public final int availableProcessors() {
        return this.availableProcessors;
    }

    /**
     * API name: {@code cpu}
     */
    @Nullable
    public final NodeInfoOSCPU cpu() {
        return this.cpu;
    }

    /**
     * API name: {@code mem}
     */
    @Nullable
    public final NodeInfoMemory mem() {
        return this.mem;
    }

    /**
     * API name: {@code name}
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code pretty_name}
     */
    @Nullable
    public final String prettyName() {
        return this.prettyName;
    }

    /**
     * API name: {@code refresh_interval}
     */
    @Nullable
    public final Time refreshInterval() {
        return this.refreshInterval;
    }

    /**
     * Required - API name: {@code refresh_interval_in_millis}
     */
    public final long refreshIntervalInMillis() {
        return this.refreshIntervalInMillis;
    }

    /**
     * API name: {@code swap}
     */
    @Nullable
    public final NodeInfoMemory swap() {
        return this.swap;
    }

    /**
     * API name: {@code version}
     */
    @Nullable
    public final String version() {
        return this.version;
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
        if (this.allocatedProcessors != null) {
            generator.writeKey("allocated_processors");
            generator.write(this.allocatedProcessors);
        }

        if (this.arch != null) {
            generator.writeKey("arch");
            generator.write(this.arch);
        }

        generator.writeKey("available_processors");
        generator.write(this.availableProcessors);

        if (this.cpu != null) {
            generator.writeKey("cpu");
            this.cpu.serialize(generator, mapper);
        }

        if (this.mem != null) {
            generator.writeKey("mem");
            this.mem.serialize(generator, mapper);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (this.prettyName != null) {
            generator.writeKey("pretty_name");
            generator.write(this.prettyName);
        }

        if (this.refreshInterval != null) {
            generator.writeKey("refresh_interval");
            this.refreshInterval.serialize(generator, mapper);
        }

        generator.writeKey("refresh_interval_in_millis");
        generator.write(this.refreshIntervalInMillis);

        if (this.swap != null) {
            generator.writeKey("swap");
            this.swap.serialize(generator, mapper);
        }

        if (this.version != null) {
            generator.writeKey("version");
            generator.write(this.version);
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
     * Builder for {@link NodeOperatingSystemInfo}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeOperatingSystemInfo> {
        @Nullable
        private Integer allocatedProcessors;
        @Nullable
        private String arch;
        private Integer availableProcessors;
        @Nullable
        private NodeInfoOSCPU cpu;
        @Nullable
        private NodeInfoMemory mem;
        @Nullable
        private String name;
        @Nullable
        private String prettyName;
        @Nullable
        private Time refreshInterval;
        private Long refreshIntervalInMillis;
        @Nullable
        private NodeInfoMemory swap;
        @Nullable
        private String version;

        public Builder() {}

        private Builder(NodeOperatingSystemInfo o) {
            this.allocatedProcessors = o.allocatedProcessors;
            this.arch = o.arch;
            this.availableProcessors = o.availableProcessors;
            this.cpu = o.cpu;
            this.mem = o.mem;
            this.name = o.name;
            this.prettyName = o.prettyName;
            this.refreshInterval = o.refreshInterval;
            this.refreshIntervalInMillis = o.refreshIntervalInMillis;
            this.swap = o.swap;
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.allocatedProcessors = o.allocatedProcessors;
            this.arch = o.arch;
            this.availableProcessors = o.availableProcessors;
            this.cpu = o.cpu;
            this.mem = o.mem;
            this.name = o.name;
            this.prettyName = o.prettyName;
            this.refreshInterval = o.refreshInterval;
            this.refreshIntervalInMillis = o.refreshIntervalInMillis;
            this.swap = o.swap;
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The number of processors actually used to calculate thread pool size. This number can be set with the
         * <code>node.processors</code> setting of a node and defaults to the number of processors reported by the OS.
         * <p>
         * API name: {@code allocated_processors}
         * </p>
         */
        @Nonnull
        public final Builder allocatedProcessors(@Nullable Integer value) {
            this.allocatedProcessors = value;
            return this;
        }

        /**
         * Name of the JVM architecture, for example <code>amd64</code> or <code>x86</code>.
         * <p>
         * API name: {@code arch}
         * </p>
         */
        @Nonnull
        public final Builder arch(@Nullable String value) {
            this.arch = value;
            return this;
        }

        /**
         * Required - The number of processors available to the Java virtual machine.
         * <p>
         * API name: {@code available_processors}
         * </p>
         */
        @Nonnull
        public final Builder availableProcessors(int value) {
            this.availableProcessors = value;
            return this;
        }

        /**
         * API name: {@code cpu}
         */
        @Nonnull
        public final Builder cpu(@Nullable NodeInfoOSCPU value) {
            this.cpu = value;
            return this;
        }

        /**
         * API name: {@code cpu}
         */
        @Nonnull
        public final Builder cpu(Function<NodeInfoOSCPU.Builder, ObjectBuilder<NodeInfoOSCPU>> fn) {
            return cpu(fn.apply(new NodeInfoOSCPU.Builder()).build());
        }

        /**
         * API name: {@code mem}
         */
        @Nonnull
        public final Builder mem(@Nullable NodeInfoMemory value) {
            this.mem = value;
            return this;
        }

        /**
         * API name: {@code mem}
         */
        @Nonnull
        public final Builder mem(Function<NodeInfoMemory.Builder, ObjectBuilder<NodeInfoMemory>> fn) {
            return mem(fn.apply(new NodeInfoMemory.Builder()).build());
        }

        /**
         * API name: {@code name}
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * API name: {@code pretty_name}
         */
        @Nonnull
        public final Builder prettyName(@Nullable String value) {
            this.prettyName = value;
            return this;
        }

        /**
         * API name: {@code refresh_interval}
         */
        @Nonnull
        public final Builder refreshInterval(@Nullable Time value) {
            this.refreshInterval = value;
            return this;
        }

        /**
         * API name: {@code refresh_interval}
         */
        @Nonnull
        public final Builder refreshInterval(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return refreshInterval(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code refresh_interval_in_millis}
         */
        @Nonnull
        public final Builder refreshIntervalInMillis(long value) {
            this.refreshIntervalInMillis = value;
            return this;
        }

        /**
         * API name: {@code swap}
         */
        @Nonnull
        public final Builder swap(@Nullable NodeInfoMemory value) {
            this.swap = value;
            return this;
        }

        /**
         * API name: {@code swap}
         */
        @Nonnull
        public final Builder swap(Function<NodeInfoMemory.Builder, ObjectBuilder<NodeInfoMemory>> fn) {
            return swap(fn.apply(new NodeInfoMemory.Builder()).build());
        }

        /**
         * API name: {@code version}
         */
        @Nonnull
        public final Builder version(@Nullable String value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link NodeOperatingSystemInfo}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeOperatingSystemInfo build() {
            _checkSingleUse();

            return new NodeOperatingSystemInfo(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeOperatingSystemInfo}
     */
    public static final JsonpDeserializer<NodeOperatingSystemInfo> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeOperatingSystemInfo::setupNodeOperatingSystemInfoDeserializer
    );

    protected static void setupNodeOperatingSystemInfoDeserializer(ObjectDeserializer<NodeOperatingSystemInfo.Builder> op) {
        op.add(Builder::allocatedProcessors, JsonpDeserializer.integerDeserializer(), "allocated_processors");
        op.add(Builder::arch, JsonpDeserializer.stringDeserializer(), "arch");
        op.add(Builder::availableProcessors, JsonpDeserializer.integerDeserializer(), "available_processors");
        op.add(Builder::cpu, NodeInfoOSCPU._DESERIALIZER, "cpu");
        op.add(Builder::mem, NodeInfoMemory._DESERIALIZER, "mem");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::prettyName, JsonpDeserializer.stringDeserializer(), "pretty_name");
        op.add(Builder::refreshInterval, Time._DESERIALIZER, "refresh_interval");
        op.add(Builder::refreshIntervalInMillis, JsonpDeserializer.longDeserializer(), "refresh_interval_in_millis");
        op.add(Builder::swap, NodeInfoMemory._DESERIALIZER, "swap");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allocatedProcessors);
        result = 31 * result + Objects.hashCode(this.arch);
        result = 31 * result + Integer.hashCode(this.availableProcessors);
        result = 31 * result + Objects.hashCode(this.cpu);
        result = 31 * result + Objects.hashCode(this.mem);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.prettyName);
        result = 31 * result + Objects.hashCode(this.refreshInterval);
        result = 31 * result + Long.hashCode(this.refreshIntervalInMillis);
        result = 31 * result + Objects.hashCode(this.swap);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeOperatingSystemInfo other = (NodeOperatingSystemInfo) o;
        return Objects.equals(this.allocatedProcessors, other.allocatedProcessors)
            && Objects.equals(this.arch, other.arch)
            && this.availableProcessors == other.availableProcessors
            && Objects.equals(this.cpu, other.cpu)
            && Objects.equals(this.mem, other.mem)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.prettyName, other.prettyName)
            && Objects.equals(this.refreshInterval, other.refreshInterval)
            && this.refreshIntervalInMillis == other.refreshIntervalInMillis
            && Objects.equals(this.swap, other.swap)
            && Objects.equals(this.version, other.version);
    }
}
