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

package org.opensearch.client.opensearch.nodes.info;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: nodes.info.NodeJvmInfo

@JsonpDeserializable
public class NodeJvmInfo implements PlainJsonSerializable {
    private final List<String> gcCollectors;

    private final NodeInfoJvmMemory mem;

    private final List<String> memoryPools;

    private final int pid;

    private final long startTimeInMillis;

    @Nullable
    private final String version;

    @Nullable
    private final String vmName;

    @Nullable
    private final String vmVendor;

    @Nullable
    private final String vmVersion;

    private final boolean bundledJdk;

    @Nullable
    private final Boolean usingBundledJdk;

    @Nullable
    private final Boolean usingCompressedOrdinaryObjectPointers;

    private final List<String> inputArguments;

    // ---------------------------------------------------------------------------------------------

    private NodeJvmInfo(Builder builder) {

        this.gcCollectors = ApiTypeHelper.unmodifiable(builder.gcCollectors);
        this.mem = ApiTypeHelper.requireNonNull(builder.mem, this, "mem");
        this.memoryPools = ApiTypeHelper.unmodifiable(builder.memoryPools);
        this.pid = ApiTypeHelper.requireNonNull(builder.pid, this, "pid");
        this.startTimeInMillis = ApiTypeHelper.requireNonNull(builder.startTimeInMillis, this, "startTimeInMillis");
        this.version = builder.version;
        this.vmName = builder.vmName;
        this.vmVendor = builder.vmVendor;
        this.vmVersion = builder.vmVersion;
        this.bundledJdk = ApiTypeHelper.requireNonNull(builder.bundledJdk, this, "bundledJdk");
        this.usingBundledJdk = builder.usingBundledJdk;
        this.usingCompressedOrdinaryObjectPointers = builder.usingCompressedOrdinaryObjectPointers;
        this.inputArguments = ApiTypeHelper.unmodifiable(builder.inputArguments);

    }

    public static NodeJvmInfo of(Function<Builder, ObjectBuilder<NodeJvmInfo>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code gc_collectors}
     */
    public final List<String> gcCollectors() {
        return this.gcCollectors;
    }

    /**
     * Required - API name: {@code mem}
     */
    public final NodeInfoJvmMemory mem() {
        return this.mem;
    }

    /**
     * API name: {@code memory_pools}
     */
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
     * Required - API name: {@code bundled_jdk}
     */
    public final boolean bundledJdk() {
        return this.bundledJdk;
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
     * API name: {@code input_arguments}
     */
    public final List<String> inputArguments() {
        return this.inputArguments;
    }

    /**
     * Serialize this object to JSON.
     */
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

        if (ApiTypeHelper.isDefined(this.gcCollectors)) {
            generator.writeKey("gc_collectors");
            generator.writeStartArray();
            for (String item0 : this.gcCollectors) {
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

        generator.writeKey("bundled_jdk");
        generator.write(this.bundledJdk);

        if (this.usingBundledJdk != null) {
            generator.writeKey("using_bundled_jdk");
            generator.write(this.usingBundledJdk);

        }

        if (this.usingCompressedOrdinaryObjectPointers != null) {
            generator.writeKey("using_compressed_ordinary_object_pointers");
            generator.write(this.usingCompressedOrdinaryObjectPointers);

        }
        if (ApiTypeHelper.isDefined(this.inputArguments)) {
            generator.writeKey("input_arguments");
            generator.writeStartArray();
            for (String item0 : this.inputArguments) {
                generator.write(item0);

            }
            generator.writeEnd();

        }

    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link NodeJvmInfo}.
     */

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<NodeJvmInfo> {
        @Nullable
        private List<String> gcCollectors;

        private NodeInfoJvmMemory mem;

        @Nullable
        private List<String> memoryPools;

        private Integer pid;

        private Long startTimeInMillis;

        @Nullable
        private String version;

        @Nullable
        private String vmName;

        @Nullable
        private String vmVendor;

        @Nullable
        private String vmVersion;

        private Boolean bundledJdk;

        @Nullable
        private Boolean usingBundledJdk;

        @Nullable
        private Boolean usingCompressedOrdinaryObjectPointers;

        @Nullable
        private List<String> inputArguments;

        /**
         * API name: {@code gc_collectors}
         * <p>
         * Adds all elements of <code>list</code> to <code>gcCollectors</code>.
         */
        public final Builder gcCollectors(List<String> list) {
            this.gcCollectors = _listAddAll(this.gcCollectors, list);
            return this;
        }

        /**
         * API name: {@code gc_collectors}
         * <p>
         * Adds one or more values to <code>gcCollectors</code>.
         */
        public final Builder gcCollectors(String value, String... values) {
            this.gcCollectors = _listAdd(this.gcCollectors, value, values);
            return this;
        }

        /**
         * Required - API name: {@code mem}
         */
        public final Builder mem(NodeInfoJvmMemory value) {
            this.mem = value;
            return this;
        }

        /**
         * Required - API name: {@code mem}
         */
        public final Builder mem(Function<NodeInfoJvmMemory.Builder, ObjectBuilder<NodeInfoJvmMemory>> fn) {
            return this.mem(fn.apply(new NodeInfoJvmMemory.Builder()).build());
        }

        /**
         * API name: {@code memory_pools}
         * <p>
         * Adds all elements of <code>list</code> to <code>memoryPools</code>.
         */
        public final Builder memoryPools(List<String> list) {
            this.memoryPools = _listAddAll(this.memoryPools, list);
            return this;
        }

        /**
         * API name: {@code memory_pools}
         * <p>
         * Adds one or more values to <code>memoryPools</code>.
         */
        public final Builder memoryPools(String value, String... values) {
            this.memoryPools = _listAdd(this.memoryPools, value, values);
            return this;
        }

        /**
         * Required - API name: {@code pid}
         */
        public final Builder pid(int value) {
            this.pid = value;
            return this;
        }

        /**
         * Required - API name: {@code start_time_in_millis}
         */
        public final Builder startTimeInMillis(long value) {
            this.startTimeInMillis = value;
            return this;
        }

        /**
         * API name: {@code version}
         */
        public final Builder version(@Nullable String value) {
            this.version = value;
            return this;
        }

        /**
         * API name: {@code vm_name}
         */
        public final Builder vmName(@Nullable String value) {
            this.vmName = value;
            return this;
        }

        /**
         * API name: {@code vm_vendor}
         */
        public final Builder vmVendor(@Nullable String value) {
            this.vmVendor = value;
            return this;
        }

        /**
         * API name: {@code vm_version}
         */
        public final Builder vmVersion(@Nullable String value) {
            this.vmVersion = value;
            return this;
        }

        /**
         * Required - API name: {@code bundled_jdk}
         */
        public final Builder bundledJdk(boolean value) {
            this.bundledJdk = value;
            return this;
        }

        /**
         * API name: {@code using_bundled_jdk}
         */
        public final Builder usingBundledJdk(@Nullable Boolean value) {
            this.usingBundledJdk = value;
            return this;
        }

        /**
         * API name: {@code using_compressed_ordinary_object_pointers}
         */
        public final Builder usingCompressedOrdinaryObjectPointers(@Nullable Boolean value) {
            this.usingCompressedOrdinaryObjectPointers = value;
            return this;
        }

        /**
         * API name: {@code input_arguments}
         * <p>
         * Adds all elements of <code>list</code> to <code>inputArguments</code>.
         */
        public final Builder inputArguments(List<String> list) {
            this.inputArguments = _listAddAll(this.inputArguments, list);
            return this;
        }

        /**
         * API name: {@code input_arguments}
         * <p>
         * Adds one or more values to <code>inputArguments</code>.
         */
        public final Builder inputArguments(String value, String... values) {
            this.inputArguments = _listAdd(this.inputArguments, value, values);
            return this;
        }

        /**
         * Builds a {@link NodeJvmInfo}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
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

        op.add(Builder::gcCollectors, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "gc_collectors");
        op.add(Builder::mem, NodeInfoJvmMemory._DESERIALIZER, "mem");
        op.add(Builder::memoryPools, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "memory_pools");
        op.add(Builder::pid, JsonpDeserializer.integerDeserializer(), "pid");
        op.add(Builder::startTimeInMillis, JsonpDeserializer.longDeserializer(), "start_time_in_millis");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");
        op.add(Builder::vmName, JsonpDeserializer.stringDeserializer(), "vm_name");
        op.add(Builder::vmVendor, JsonpDeserializer.stringDeserializer(), "vm_vendor");
        op.add(Builder::vmVersion, JsonpDeserializer.stringDeserializer(), "vm_version");
        op.add(Builder::bundledJdk, JsonpDeserializer.booleanDeserializer(), "bundled_jdk");
        op.add(Builder::usingBundledJdk, JsonpDeserializer.booleanDeserializer(), "using_bundled_jdk");
        op.add(
            Builder::usingCompressedOrdinaryObjectPointers,
            JsonpDeserializer.booleanDeserializer(),
            "using_compressed_ordinary_object_pointers"
        );
        op.add(Builder::inputArguments, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "input_arguments");

    }

}
