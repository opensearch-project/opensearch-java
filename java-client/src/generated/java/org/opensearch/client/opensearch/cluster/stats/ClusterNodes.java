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

package org.opensearch.client.opensearch.cluster.stats;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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
import org.opensearch.client.opensearch._types.PluginStats;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.stats.ClusterNodes

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterNodes implements PlainJsonSerializable, ToCopyableBuilder<ClusterNodes.Builder, ClusterNodes> {

    @Nullable
    private final ClusterNodeCount count;

    @Nonnull
    private final Map<String, Integer> discoveryTypes;

    @Nullable
    private final ClusterFileSystem fs;

    @Nullable
    private final IndexingPressure indexingPressure;

    @Nullable
    private final ClusterIngest ingest;

    @Nullable
    private final ClusterJvm jvm;

    @Nullable
    private final ClusterNetworkTypes networkTypes;

    @Nullable
    private final ClusterOperatingSystem os;

    @Nonnull
    private final List<NodePackagingType> packagingTypes;

    @Nonnull
    private final List<PluginStats> plugins;

    @Nullable
    private final ClusterProcess process;

    @Nonnull
    private final List<String> versions;

    // ---------------------------------------------------------------------------------------------

    private ClusterNodes(Builder builder) {
        this.count = builder.count;
        this.discoveryTypes = ApiTypeHelper.unmodifiable(builder.discoveryTypes);
        this.fs = builder.fs;
        this.indexingPressure = builder.indexingPressure;
        this.ingest = builder.ingest;
        this.jvm = builder.jvm;
        this.networkTypes = builder.networkTypes;
        this.os = builder.os;
        this.packagingTypes = ApiTypeHelper.unmodifiable(builder.packagingTypes);
        this.plugins = ApiTypeHelper.unmodifiable(builder.plugins);
        this.process = builder.process;
        this.versions = ApiTypeHelper.unmodifiable(builder.versions);
    }

    public static ClusterNodes of(Function<ClusterNodes.Builder, ObjectBuilder<ClusterNodes>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Contains counts for nodes selected by the request's node filters.
     * <p>
     * API name: {@code count}
     * </p>
     */
    @Nullable
    public final ClusterNodeCount count() {
        return this.count;
    }

    /**
     * Contains statistics about the discovery types used by selected nodes.
     * <p>
     * API name: {@code discovery_types}
     * </p>
     */
    @Nonnull
    public final Map<String, Integer> discoveryTypes() {
        return this.discoveryTypes;
    }

    /**
     * Contains statistics about file stores by selected nodes.
     * <p>
     * API name: {@code fs}
     * </p>
     */
    @Nullable
    public final ClusterFileSystem fs() {
        return this.fs;
    }

    /**
     * API name: {@code indexing_pressure}
     */
    @Nullable
    public final IndexingPressure indexingPressure() {
        return this.indexingPressure;
    }

    /**
     * API name: {@code ingest}
     */
    @Nullable
    public final ClusterIngest ingest() {
        return this.ingest;
    }

    /**
     * Contains statistics about the Java Virtual Machines (JVMs) used by selected nodes.
     * <p>
     * API name: {@code jvm}
     * </p>
     */
    @Nullable
    public final ClusterJvm jvm() {
        return this.jvm;
    }

    /**
     * Contains statistics about the transport and HTTP networks used by selected nodes.
     * <p>
     * API name: {@code network_types}
     * </p>
     */
    @Nullable
    public final ClusterNetworkTypes networkTypes() {
        return this.networkTypes;
    }

    /**
     * Contains statistics about the operating systems used by selected nodes.
     * <p>
     * API name: {@code os}
     * </p>
     */
    @Nullable
    public final ClusterOperatingSystem os() {
        return this.os;
    }

    /**
     * Contains statistics about OpenSearch distributions installed on selected nodes.
     * <p>
     * API name: {@code packaging_types}
     * </p>
     */
    @Nonnull
    public final List<NodePackagingType> packagingTypes() {
        return this.packagingTypes;
    }

    /**
     * Contains statistics about installed plugins and modules by selected nodes. If no plugins or modules are installed, this array is
     * empty.
     * <p>
     * API name: {@code plugins}
     * </p>
     */
    @Nonnull
    public final List<PluginStats> plugins() {
        return this.plugins;
    }

    /**
     * Contains statistics about processes used by selected nodes.
     * <p>
     * API name: {@code process}
     * </p>
     */
    @Nullable
    public final ClusterProcess process() {
        return this.process;
    }

    /**
     * Array of OpenSearch versions used on selected nodes.
     * <p>
     * API name: {@code versions}
     * </p>
     */
    @Nonnull
    public final List<String> versions() {
        return this.versions;
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
        if (this.count != null) {
            generator.writeKey("count");
            this.count.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.discoveryTypes)) {
            generator.writeKey("discovery_types");
            generator.writeStartObject();
            for (Map.Entry<String, Integer> item0 : this.discoveryTypes.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        if (this.fs != null) {
            generator.writeKey("fs");
            this.fs.serialize(generator, mapper);
        }

        if (this.indexingPressure != null) {
            generator.writeKey("indexing_pressure");
            this.indexingPressure.serialize(generator, mapper);
        }

        if (this.ingest != null) {
            generator.writeKey("ingest");
            this.ingest.serialize(generator, mapper);
        }

        if (this.jvm != null) {
            generator.writeKey("jvm");
            this.jvm.serialize(generator, mapper);
        }

        if (this.networkTypes != null) {
            generator.writeKey("network_types");
            this.networkTypes.serialize(generator, mapper);
        }

        if (this.os != null) {
            generator.writeKey("os");
            this.os.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.packagingTypes)) {
            generator.writeKey("packaging_types");
            generator.writeStartArray();
            for (NodePackagingType item0 : this.packagingTypes) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.plugins)) {
            generator.writeKey("plugins");
            generator.writeStartArray();
            for (PluginStats item0 : this.plugins) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.process != null) {
            generator.writeKey("process");
            this.process.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.versions)) {
            generator.writeKey("versions");
            generator.writeStartArray();
            for (String item0 : this.versions) {
                generator.write(item0);
            }
            generator.writeEnd();
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
     * Builder for {@link ClusterNodes}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterNodes> {
        @Nullable
        private ClusterNodeCount count;
        @Nullable
        private Map<String, Integer> discoveryTypes;
        @Nullable
        private ClusterFileSystem fs;
        @Nullable
        private IndexingPressure indexingPressure;
        @Nullable
        private ClusterIngest ingest;
        @Nullable
        private ClusterJvm jvm;
        @Nullable
        private ClusterNetworkTypes networkTypes;
        @Nullable
        private ClusterOperatingSystem os;
        @Nullable
        private List<NodePackagingType> packagingTypes;
        @Nullable
        private List<PluginStats> plugins;
        @Nullable
        private ClusterProcess process;
        @Nullable
        private List<String> versions;

        public Builder() {}

        private Builder(ClusterNodes o) {
            this.count = o.count;
            this.discoveryTypes = _mapCopy(o.discoveryTypes);
            this.fs = o.fs;
            this.indexingPressure = o.indexingPressure;
            this.ingest = o.ingest;
            this.jvm = o.jvm;
            this.networkTypes = o.networkTypes;
            this.os = o.os;
            this.packagingTypes = _listCopy(o.packagingTypes);
            this.plugins = _listCopy(o.plugins);
            this.process = o.process;
            this.versions = _listCopy(o.versions);
        }

        private Builder(Builder o) {
            this.count = o.count;
            this.discoveryTypes = _mapCopy(o.discoveryTypes);
            this.fs = o.fs;
            this.indexingPressure = o.indexingPressure;
            this.ingest = o.ingest;
            this.jvm = o.jvm;
            this.networkTypes = o.networkTypes;
            this.os = o.os;
            this.packagingTypes = _listCopy(o.packagingTypes);
            this.plugins = _listCopy(o.plugins);
            this.process = o.process;
            this.versions = _listCopy(o.versions);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Contains counts for nodes selected by the request's node filters.
         * <p>
         * API name: {@code count}
         * </p>
         */
        @Nonnull
        public final Builder count(@Nullable ClusterNodeCount value) {
            this.count = value;
            return this;
        }

        /**
         * Contains counts for nodes selected by the request's node filters.
         * <p>
         * API name: {@code count}
         * </p>
         */
        @Nonnull
        public final Builder count(Function<ClusterNodeCount.Builder, ObjectBuilder<ClusterNodeCount>> fn) {
            return count(fn.apply(new ClusterNodeCount.Builder()).build());
        }

        /**
         * Contains statistics about the discovery types used by selected nodes.
         * <p>
         * API name: {@code discovery_types}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>discoveryTypes</code>.
         * </p>
         */
        @Nonnull
        public final Builder discoveryTypes(Map<String, Integer> map) {
            this.discoveryTypes = _mapPutAll(this.discoveryTypes, map);
            return this;
        }

        /**
         * Contains statistics about the discovery types used by selected nodes.
         * <p>
         * API name: {@code discovery_types}
         * </p>
         *
         * <p>
         * Adds an entry to <code>discoveryTypes</code>.
         * </p>
         */
        @Nonnull
        public final Builder discoveryTypes(String key, Integer value) {
            this.discoveryTypes = _mapPut(this.discoveryTypes, key, value);
            return this;
        }

        /**
         * Contains statistics about file stores by selected nodes.
         * <p>
         * API name: {@code fs}
         * </p>
         */
        @Nonnull
        public final Builder fs(@Nullable ClusterFileSystem value) {
            this.fs = value;
            return this;
        }

        /**
         * Contains statistics about file stores by selected nodes.
         * <p>
         * API name: {@code fs}
         * </p>
         */
        @Nonnull
        public final Builder fs(Function<ClusterFileSystem.Builder, ObjectBuilder<ClusterFileSystem>> fn) {
            return fs(fn.apply(new ClusterFileSystem.Builder()).build());
        }

        /**
         * API name: {@code indexing_pressure}
         */
        @Nonnull
        public final Builder indexingPressure(@Nullable IndexingPressure value) {
            this.indexingPressure = value;
            return this;
        }

        /**
         * API name: {@code indexing_pressure}
         */
        @Nonnull
        public final Builder indexingPressure(Function<IndexingPressure.Builder, ObjectBuilder<IndexingPressure>> fn) {
            return indexingPressure(fn.apply(new IndexingPressure.Builder()).build());
        }

        /**
         * API name: {@code ingest}
         */
        @Nonnull
        public final Builder ingest(@Nullable ClusterIngest value) {
            this.ingest = value;
            return this;
        }

        /**
         * API name: {@code ingest}
         */
        @Nonnull
        public final Builder ingest(Function<ClusterIngest.Builder, ObjectBuilder<ClusterIngest>> fn) {
            return ingest(fn.apply(new ClusterIngest.Builder()).build());
        }

        /**
         * Contains statistics about the Java Virtual Machines (JVMs) used by selected nodes.
         * <p>
         * API name: {@code jvm}
         * </p>
         */
        @Nonnull
        public final Builder jvm(@Nullable ClusterJvm value) {
            this.jvm = value;
            return this;
        }

        /**
         * Contains statistics about the Java Virtual Machines (JVMs) used by selected nodes.
         * <p>
         * API name: {@code jvm}
         * </p>
         */
        @Nonnull
        public final Builder jvm(Function<ClusterJvm.Builder, ObjectBuilder<ClusterJvm>> fn) {
            return jvm(fn.apply(new ClusterJvm.Builder()).build());
        }

        /**
         * Contains statistics about the transport and HTTP networks used by selected nodes.
         * <p>
         * API name: {@code network_types}
         * </p>
         */
        @Nonnull
        public final Builder networkTypes(@Nullable ClusterNetworkTypes value) {
            this.networkTypes = value;
            return this;
        }

        /**
         * Contains statistics about the transport and HTTP networks used by selected nodes.
         * <p>
         * API name: {@code network_types}
         * </p>
         */
        @Nonnull
        public final Builder networkTypes(Function<ClusterNetworkTypes.Builder, ObjectBuilder<ClusterNetworkTypes>> fn) {
            return networkTypes(fn.apply(new ClusterNetworkTypes.Builder()).build());
        }

        /**
         * Contains statistics about the operating systems used by selected nodes.
         * <p>
         * API name: {@code os}
         * </p>
         */
        @Nonnull
        public final Builder os(@Nullable ClusterOperatingSystem value) {
            this.os = value;
            return this;
        }

        /**
         * Contains statistics about the operating systems used by selected nodes.
         * <p>
         * API name: {@code os}
         * </p>
         */
        @Nonnull
        public final Builder os(Function<ClusterOperatingSystem.Builder, ObjectBuilder<ClusterOperatingSystem>> fn) {
            return os(fn.apply(new ClusterOperatingSystem.Builder()).build());
        }

        /**
         * Contains statistics about OpenSearch distributions installed on selected nodes.
         * <p>
         * API name: {@code packaging_types}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>packagingTypes</code>.
         * </p>
         */
        @Nonnull
        public final Builder packagingTypes(List<NodePackagingType> list) {
            this.packagingTypes = _listAddAll(this.packagingTypes, list);
            return this;
        }

        /**
         * Contains statistics about OpenSearch distributions installed on selected nodes.
         * <p>
         * API name: {@code packaging_types}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>packagingTypes</code>.
         * </p>
         */
        @Nonnull
        public final Builder packagingTypes(NodePackagingType value, NodePackagingType... values) {
            this.packagingTypes = _listAdd(this.packagingTypes, value, values);
            return this;
        }

        /**
         * Contains statistics about OpenSearch distributions installed on selected nodes.
         * <p>
         * API name: {@code packaging_types}
         * </p>
         *
         * <p>
         * Adds a value to <code>packagingTypes</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder packagingTypes(Function<NodePackagingType.Builder, ObjectBuilder<NodePackagingType>> fn) {
            return packagingTypes(fn.apply(new NodePackagingType.Builder()).build());
        }

        /**
         * Contains statistics about installed plugins and modules by selected nodes. If no plugins or modules are installed, this array is
         * empty.
         * <p>
         * API name: {@code plugins}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>plugins</code>.
         * </p>
         */
        @Nonnull
        public final Builder plugins(List<PluginStats> list) {
            this.plugins = _listAddAll(this.plugins, list);
            return this;
        }

        /**
         * Contains statistics about installed plugins and modules by selected nodes. If no plugins or modules are installed, this array is
         * empty.
         * <p>
         * API name: {@code plugins}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>plugins</code>.
         * </p>
         */
        @Nonnull
        public final Builder plugins(PluginStats value, PluginStats... values) {
            this.plugins = _listAdd(this.plugins, value, values);
            return this;
        }

        /**
         * Contains statistics about installed plugins and modules by selected nodes. If no plugins or modules are installed, this array is
         * empty.
         * <p>
         * API name: {@code plugins}
         * </p>
         *
         * <p>
         * Adds a value to <code>plugins</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder plugins(Function<PluginStats.Builder, ObjectBuilder<PluginStats>> fn) {
            return plugins(fn.apply(new PluginStats.Builder()).build());
        }

        /**
         * Contains statistics about processes used by selected nodes.
         * <p>
         * API name: {@code process}
         * </p>
         */
        @Nonnull
        public final Builder process(@Nullable ClusterProcess value) {
            this.process = value;
            return this;
        }

        /**
         * Contains statistics about processes used by selected nodes.
         * <p>
         * API name: {@code process}
         * </p>
         */
        @Nonnull
        public final Builder process(Function<ClusterProcess.Builder, ObjectBuilder<ClusterProcess>> fn) {
            return process(fn.apply(new ClusterProcess.Builder()).build());
        }

        /**
         * Array of OpenSearch versions used on selected nodes.
         * <p>
         * API name: {@code versions}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>versions</code>.
         * </p>
         */
        @Nonnull
        public final Builder versions(List<String> list) {
            this.versions = _listAddAll(this.versions, list);
            return this;
        }

        /**
         * Array of OpenSearch versions used on selected nodes.
         * <p>
         * API name: {@code versions}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>versions</code>.
         * </p>
         */
        @Nonnull
        public final Builder versions(String value, String... values) {
            this.versions = _listAdd(this.versions, value, values);
            return this;
        }

        /**
         * Builds a {@link ClusterNodes}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterNodes build() {
            _checkSingleUse();

            return new ClusterNodes(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterNodes}
     */
    public static final JsonpDeserializer<ClusterNodes> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterNodes::setupClusterNodesDeserializer
    );

    protected static void setupClusterNodesDeserializer(ObjectDeserializer<ClusterNodes.Builder> op) {
        op.add(Builder::count, ClusterNodeCount._DESERIALIZER, "count");
        op.add(
            Builder::discoveryTypes,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.integerDeserializer()),
            "discovery_types"
        );
        op.add(Builder::fs, ClusterFileSystem._DESERIALIZER, "fs");
        op.add(Builder::indexingPressure, IndexingPressure._DESERIALIZER, "indexing_pressure");
        op.add(Builder::ingest, ClusterIngest._DESERIALIZER, "ingest");
        op.add(Builder::jvm, ClusterJvm._DESERIALIZER, "jvm");
        op.add(Builder::networkTypes, ClusterNetworkTypes._DESERIALIZER, "network_types");
        op.add(Builder::os, ClusterOperatingSystem._DESERIALIZER, "os");
        op.add(Builder::packagingTypes, JsonpDeserializer.arrayDeserializer(NodePackagingType._DESERIALIZER), "packaging_types");
        op.add(Builder::plugins, JsonpDeserializer.arrayDeserializer(PluginStats._DESERIALIZER), "plugins");
        op.add(Builder::process, ClusterProcess._DESERIALIZER, "process");
        op.add(Builder::versions, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "versions");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.count);
        result = 31 * result + Objects.hashCode(this.discoveryTypes);
        result = 31 * result + Objects.hashCode(this.fs);
        result = 31 * result + Objects.hashCode(this.indexingPressure);
        result = 31 * result + Objects.hashCode(this.ingest);
        result = 31 * result + Objects.hashCode(this.jvm);
        result = 31 * result + Objects.hashCode(this.networkTypes);
        result = 31 * result + Objects.hashCode(this.os);
        result = 31 * result + Objects.hashCode(this.packagingTypes);
        result = 31 * result + Objects.hashCode(this.plugins);
        result = 31 * result + Objects.hashCode(this.process);
        result = 31 * result + Objects.hashCode(this.versions);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterNodes other = (ClusterNodes) o;
        return Objects.equals(this.count, other.count)
            && Objects.equals(this.discoveryTypes, other.discoveryTypes)
            && Objects.equals(this.fs, other.fs)
            && Objects.equals(this.indexingPressure, other.indexingPressure)
            && Objects.equals(this.ingest, other.ingest)
            && Objects.equals(this.jvm, other.jvm)
            && Objects.equals(this.networkTypes, other.networkTypes)
            && Objects.equals(this.os, other.os)
            && Objects.equals(this.packagingTypes, other.packagingTypes)
            && Objects.equals(this.plugins, other.plugins)
            && Objects.equals(this.process, other.process)
            && Objects.equals(this.versions, other.versions);
    }
}
