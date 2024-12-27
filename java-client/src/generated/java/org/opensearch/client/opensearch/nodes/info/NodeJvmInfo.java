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
import java.util.List;
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

// typedef: nodes.info.NodeJvmInfo

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeJvmInfo implements PlainJsonSerializable, ToCopyableBuilder<NodeJvmInfo.Builder, NodeJvmInfo> {

    private final boolean bundledJdk;

    @Nonnull
    private final List<String> gcCollectors;

    @Nonnull
    private final List<String> inputArguments;

    @Nonnull
    private final NodeInfoJvmMemory mem;

    @Nonnull
    private final List<String> memoryPools;

    private final int pid;

    private final long startTimeInMillis;

    @Nullable
    private final Boolean usingBundledJdk;

    @Nullable
    private final Boolean usingCompressedOrdinaryObjectPointers;

    @Nullable
    private final String version;

    @Nullable
    private final String vmName;

    @Nullable
    private final String vmVendor;

    @Nullable
    private final String vmVersion;

    // ---------------------------------------------------------------------------------------------

    private NodeJvmInfo(Builder builder) {
        this.bundledJdk = ApiTypeHelper.requireNonNull(builder.bundledJdk, this, "bundledJdk");
        this.gcCollectors = ApiTypeHelper.unmodifiable(builder.gcCollectors);
        this.inputArguments = ApiTypeHelper.unmodifiable(builder.inputArguments);
        this.mem = ApiTypeHelper.requireNonNull(builder.mem, this, "mem");
        this.memoryPools = ApiTypeHelper.unmodifiable(builder.memoryPools);
        this.pid = ApiTypeHelper.requireNonNull(builder.pid, this, "pid");
        this.startTimeInMillis = ApiTypeHelper.requireNonNull(builder.startTimeInMillis, this, "startTimeInMillis");
        this.usingBundledJdk = builder.usingBundledJdk;
        this.usingCompressedOrdinaryObjectPointers = builder.usingCompressedOrdinaryObjectPointers;
        this.version = builder.version;
        this.vmName = builder.vmName;
        this.vmVendor = builder.vmVendor;
        this.vmVersion = builder.vmVersion;
    }

    public static NodeJvmInfo of(Function<NodeJvmInfo.Builder, ObjectBuilder<NodeJvmInfo>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code bundled_jdk}
     */
    public final boolean bundledJdk() {
        return this.bundledJdk;
    }

    /**
     * API name: {@code gc_collectors}
     */
    @Nonnull
    public final List<String> gcCollectors() {
        return this.gcCollectors;
    }

    /**
     * API name: {@code input_arguments}
     */
    @Nonnull
    public final List<String> inputArguments() {
        return this.inputArguments;
    }

    /**
     * Required - API name: {@code mem}
     */
    @Nonnull
    public final NodeInfoJvmMemory mem() {
        return this.mem;
    }

    /**
     * API name: {@code memory_pools}
     */
    @Nonnull
    public final List<String> memoryPools() {
        return this.memoryPools;
    }

    /**
     * Required - API name: {@code pid}
     */
    public final int pid() {
        return this.pid;
    }

    /**
     * Required - API name: {@code start_time_in_millis}
     */
    public final long startTimeInMillis() {
        return this.startTimeInMillis;
    }

    /**
     * API name: {@code using_bundled_jdk}
     */
    @Nullable
    public final Boolean usingBundledJdk() {
        return this.usingBundledJdk;
    }

    /**
     * API name: {@code using_compressed_ordinary_object_pointers}
     */
    @Nullable
    public final Boolean usingCompressedOrdinaryObjectPointers() {
        return this.usingCompressedOrdinaryObjectPointers;
    }

    /**
     * API name: {@code version}
     */
    @Nullable
    public final String version() {
        return this.version;
    }

    /**
     * API name: {@code vm_name}
     */
    @Nullable
    public final String vmName() {
        return this.vmName;
    }

    /**
     * API name: {@code vm_vendor}
     */
    @Nullable
    public final String vmVendor() {
        return this.vmVendor;
    }

    /**
     * API name: {@code vm_version}
     */
    @Nullable
    public final String vmVersion() {
        return this.vmVersion;
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
        generator.writeKey("bundled_jdk");
        generator.write(this.bundledJdk);

        if (ApiTypeHelper.isDefined(this.gcCollectors)) {
            generator.writeKey("gc_collectors");
            generator.writeStartArray();
            for (String item0 : this.gcCollectors) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.inputArguments)) {
            generator.writeKey("input_arguments");
            generator.writeStartArray();
            for (String item0 : this.inputArguments) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        generator.writeKey("mem");
        this.mem.serialize(generator, mapper);

        if (ApiTypeHelper.isDefined(this.memoryPools)) {
            generator.writeKey("memory_pools");
            generator.writeStartArray();
            for (String item0 : this.memoryPools) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        generator.writeKey("pid");
        generator.write(this.pid);

        generator.writeKey("start_time_in_millis");
        generator.write(this.startTimeInMillis);

        if (this.usingBundledJdk != null) {
            generator.writeKey("using_bundled_jdk");
            generator.write(this.usingBundledJdk);
        }

        if (this.usingCompressedOrdinaryObjectPointers != null) {
            generator.writeKey("using_compressed_ordinary_object_pointers");
            generator.write(this.usingCompressedOrdinaryObjectPointers);
        }

        if (this.version != null) {
            generator.writeKey("version");
            generator.write(this.version);
        }

        if (this.vmName != null) {
            generator.writeKey("vm_name");
            generator.write(this.vmName);
        }

        if (this.vmVendor != null) {
            generator.writeKey("vm_vendor");
            generator.write(this.vmVendor);
        }

        if (this.vmVersion != null) {
            generator.writeKey("vm_version");
            generator.write(this.vmVersion);
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
     * Builder for {@link NodeJvmInfo}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeJvmInfo> {
        private Boolean bundledJdk;
        @Nullable
        private List<String> gcCollectors;
        @Nullable
        private List<String> inputArguments;
        private NodeInfoJvmMemory mem;
        @Nullable
        private List<String> memoryPools;
        private Integer pid;
        private Long startTimeInMillis;
        @Nullable
        private Boolean usingBundledJdk;
        @Nullable
        private Boolean usingCompressedOrdinaryObjectPointers;
        @Nullable
        private String version;
        @Nullable
        private String vmName;
        @Nullable
        private String vmVendor;
        @Nullable
        private String vmVersion;

        public Builder() {}

        private Builder(NodeJvmInfo o) {
            this.bundledJdk = o.bundledJdk;
            this.gcCollectors = _listCopy(o.gcCollectors);
            this.inputArguments = _listCopy(o.inputArguments);
            this.mem = o.mem;
            this.memoryPools = _listCopy(o.memoryPools);
            this.pid = o.pid;
            this.startTimeInMillis = o.startTimeInMillis;
            this.usingBundledJdk = o.usingBundledJdk;
            this.usingCompressedOrdinaryObjectPointers = o.usingCompressedOrdinaryObjectPointers;
            this.version = o.version;
            this.vmName = o.vmName;
            this.vmVendor = o.vmVendor;
            this.vmVersion = o.vmVersion;
        }

        private Builder(Builder o) {
            this.bundledJdk = o.bundledJdk;
            this.gcCollectors = _listCopy(o.gcCollectors);
            this.inputArguments = _listCopy(o.inputArguments);
            this.mem = o.mem;
            this.memoryPools = _listCopy(o.memoryPools);
            this.pid = o.pid;
            this.startTimeInMillis = o.startTimeInMillis;
            this.usingBundledJdk = o.usingBundledJdk;
            this.usingCompressedOrdinaryObjectPointers = o.usingCompressedOrdinaryObjectPointers;
            this.version = o.version;
            this.vmName = o.vmName;
            this.vmVendor = o.vmVendor;
            this.vmVersion = o.vmVersion;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code bundled_jdk}
         */
        @Nonnull
        public final Builder bundledJdk(boolean value) {
            this.bundledJdk = value;
            return this;
        }

        /**
         * API name: {@code gc_collectors}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>gcCollectors</code>.
         * </p>
         */
        @Nonnull
        public final Builder gcCollectors(List<String> list) {
            this.gcCollectors = _listAddAll(this.gcCollectors, list);
            return this;
        }

        /**
         * API name: {@code gc_collectors}
         *
         * <p>
         * Adds one or more values to <code>gcCollectors</code>.
         * </p>
         */
        @Nonnull
        public final Builder gcCollectors(String value, String... values) {
            this.gcCollectors = _listAdd(this.gcCollectors, value, values);
            return this;
        }

        /**
         * API name: {@code input_arguments}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>inputArguments</code>.
         * </p>
         */
        @Nonnull
        public final Builder inputArguments(List<String> list) {
            this.inputArguments = _listAddAll(this.inputArguments, list);
            return this;
        }

        /**
         * API name: {@code input_arguments}
         *
         * <p>
         * Adds one or more values to <code>inputArguments</code>.
         * </p>
         */
        @Nonnull
        public final Builder inputArguments(String value, String... values) {
            this.inputArguments = _listAdd(this.inputArguments, value, values);
            return this;
        }

        /**
         * Required - API name: {@code mem}
         */
        @Nonnull
        public final Builder mem(NodeInfoJvmMemory value) {
            this.mem = value;
            return this;
        }

        /**
         * Required - API name: {@code mem}
         */
        @Nonnull
        public final Builder mem(Function<NodeInfoJvmMemory.Builder, ObjectBuilder<NodeInfoJvmMemory>> fn) {
            return mem(fn.apply(new NodeInfoJvmMemory.Builder()).build());
        }

        /**
         * API name: {@code memory_pools}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>memoryPools</code>.
         * </p>
         */
        @Nonnull
        public final Builder memoryPools(List<String> list) {
            this.memoryPools = _listAddAll(this.memoryPools, list);
            return this;
        }

        /**
         * API name: {@code memory_pools}
         *
         * <p>
         * Adds one or more values to <code>memoryPools</code>.
         * </p>
         */
        @Nonnull
        public final Builder memoryPools(String value, String... values) {
            this.memoryPools = _listAdd(this.memoryPools, value, values);
            return this;
        }

        /**
         * Required - API name: {@code pid}
         */
        @Nonnull
        public final Builder pid(int value) {
            this.pid = value;
            return this;
        }

        /**
         * Required - API name: {@code start_time_in_millis}
         */
        @Nonnull
        public final Builder startTimeInMillis(long value) {
            this.startTimeInMillis = value;
            return this;
        }

        /**
         * API name: {@code using_bundled_jdk}
         */
        @Nonnull
        public final Builder usingBundledJdk(@Nullable Boolean value) {
            this.usingBundledJdk = value;
            return this;
        }

        /**
         * API name: {@code using_compressed_ordinary_object_pointers}
         */
        @Nonnull
        public final Builder usingCompressedOrdinaryObjectPointers(@Nullable Boolean value) {
            this.usingCompressedOrdinaryObjectPointers = value;
            return this;
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
         * API name: {@code vm_name}
         */
        @Nonnull
        public final Builder vmName(@Nullable String value) {
            this.vmName = value;
            return this;
        }

        /**
         * API name: {@code vm_vendor}
         */
        @Nonnull
        public final Builder vmVendor(@Nullable String value) {
            this.vmVendor = value;
            return this;
        }

        /**
         * API name: {@code vm_version}
         */
        @Nonnull
        public final Builder vmVersion(@Nullable String value) {
            this.vmVersion = value;
            return this;
        }

        /**
         * Builds a {@link NodeJvmInfo}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeJvmInfo build() {
            _checkSingleUse();

            return new NodeJvmInfo(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeJvmInfo}
     */
    public static final JsonpDeserializer<NodeJvmInfo> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeJvmInfo::setupNodeJvmInfoDeserializer
    );

    protected static void setupNodeJvmInfoDeserializer(ObjectDeserializer<NodeJvmInfo.Builder> op) {
        op.add(Builder::bundledJdk, JsonpDeserializer.booleanDeserializer(), "bundled_jdk");
        op.add(Builder::gcCollectors, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "gc_collectors");
        op.add(Builder::inputArguments, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "input_arguments");
        op.add(Builder::mem, NodeInfoJvmMemory._DESERIALIZER, "mem");
        op.add(Builder::memoryPools, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "memory_pools");
        op.add(Builder::pid, JsonpDeserializer.integerDeserializer(), "pid");
        op.add(Builder::startTimeInMillis, JsonpDeserializer.longDeserializer(), "start_time_in_millis");
        op.add(Builder::usingBundledJdk, JsonpDeserializer.booleanDeserializer(), "using_bundled_jdk");
        op.add(
            Builder::usingCompressedOrdinaryObjectPointers,
            JsonpDeserializer.booleanDeserializer(),
            "using_compressed_ordinary_object_pointers"
        );
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");
        op.add(Builder::vmName, JsonpDeserializer.stringDeserializer(), "vm_name");
        op.add(Builder::vmVendor, JsonpDeserializer.stringDeserializer(), "vm_vendor");
        op.add(Builder::vmVersion, JsonpDeserializer.stringDeserializer(), "vm_version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Boolean.hashCode(this.bundledJdk);
        result = 31 * result + Objects.hashCode(this.gcCollectors);
        result = 31 * result + Objects.hashCode(this.inputArguments);
        result = 31 * result + this.mem.hashCode();
        result = 31 * result + Objects.hashCode(this.memoryPools);
        result = 31 * result + Integer.hashCode(this.pid);
        result = 31 * result + Long.hashCode(this.startTimeInMillis);
        result = 31 * result + Objects.hashCode(this.usingBundledJdk);
        result = 31 * result + Objects.hashCode(this.usingCompressedOrdinaryObjectPointers);
        result = 31 * result + Objects.hashCode(this.version);
        result = 31 * result + Objects.hashCode(this.vmName);
        result = 31 * result + Objects.hashCode(this.vmVendor);
        result = 31 * result + Objects.hashCode(this.vmVersion);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeJvmInfo other = (NodeJvmInfo) o;
        return this.bundledJdk == other.bundledJdk
            && Objects.equals(this.gcCollectors, other.gcCollectors)
            && Objects.equals(this.inputArguments, other.inputArguments)
            && this.mem.equals(other.mem)
            && Objects.equals(this.memoryPools, other.memoryPools)
            && this.pid == other.pid
            && this.startTimeInMillis == other.startTimeInMillis
            && Objects.equals(this.usingBundledJdk, other.usingBundledJdk)
            && Objects.equals(this.usingCompressedOrdinaryObjectPointers, other.usingCompressedOrdinaryObjectPointers)
            && Objects.equals(this.version, other.version)
            && Objects.equals(this.vmName, other.vmName)
            && Objects.equals(this.vmVendor, other.vmVendor)
            && Objects.equals(this.vmVersion, other.vmVersion);
    }
}
