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

package org.opensearch.client.opensearch.cluster.allocation_explain;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.allocation_explain.ClusterInfo

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterInfo implements PlainJsonSerializable, ToCopyableBuilder<ClusterInfo.Builder, ClusterInfo> {

    @Nonnull
    private final Map<String, NodeDiskUsage> nodes;

    @Nonnull
    private final List<ReservedSize> reservedSizes;

    @Nonnull
    private final Map<String, String> shardDataSetSizes;

    @Nonnull
    private final Map<String, String> shardPaths;

    @Nonnull
    private final Map<String, String> shardSizes;

    // ---------------------------------------------------------------------------------------------

    private ClusterInfo(Builder builder) {
        this.nodes = ApiTypeHelper.unmodifiableRequired(builder.nodes, this, "nodes");
        this.reservedSizes = ApiTypeHelper.unmodifiableRequired(builder.reservedSizes, this, "reservedSizes");
        this.shardDataSetSizes = ApiTypeHelper.unmodifiable(builder.shardDataSetSizes);
        this.shardPaths = ApiTypeHelper.unmodifiableRequired(builder.shardPaths, this, "shardPaths");
        this.shardSizes = ApiTypeHelper.unmodifiableRequired(builder.shardSizes, this, "shardSizes");
    }

    public static ClusterInfo of(Function<ClusterInfo.Builder, ObjectBuilder<ClusterInfo>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code nodes}
     */
    @Nonnull
    public final Map<String, NodeDiskUsage> nodes() {
        return this.nodes;
    }

    /**
     * Required - API name: {@code reserved_sizes}
     */
    @Nonnull
    public final List<ReservedSize> reservedSizes() {
        return this.reservedSizes;
    }

    /**
     * API name: {@code shard_data_set_sizes}
     */
    @Nonnull
    public final Map<String, String> shardDataSetSizes() {
        return this.shardDataSetSizes;
    }

    /**
     * Required - API name: {@code shard_paths}
     */
    @Nonnull
    public final Map<String, String> shardPaths() {
        return this.shardPaths;
    }

    /**
     * Required - API name: {@code shard_sizes}
     */
    @Nonnull
    public final Map<String, String> shardSizes() {
        return this.shardSizes;
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
        generator.writeKey("nodes");
        generator.writeStartObject();
        for (Map.Entry<String, NodeDiskUsage> item0 : this.nodes.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("reserved_sizes");
        generator.writeStartArray();
        for (ReservedSize item0 : this.reservedSizes) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        if (ApiTypeHelper.isDefined(this.shardDataSetSizes)) {
            generator.writeKey("shard_data_set_sizes");
            generator.writeStartObject();
            for (Map.Entry<String, String> item0 : this.shardDataSetSizes.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        generator.writeKey("shard_paths");
        generator.writeStartObject();
        for (Map.Entry<String, String> item0 : this.shardPaths.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.write(item0.getValue());
        }
        generator.writeEnd();

        generator.writeKey("shard_sizes");
        generator.writeStartObject();
        for (Map.Entry<String, String> item0 : this.shardSizes.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.write(item0.getValue());
        }
        generator.writeEnd();
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
     * Builder for {@link ClusterInfo}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterInfo> {
        private Map<String, NodeDiskUsage> nodes;
        private List<ReservedSize> reservedSizes;
        @Nullable
        private Map<String, String> shardDataSetSizes;
        private Map<String, String> shardPaths;
        private Map<String, String> shardSizes;

        public Builder() {}

        private Builder(ClusterInfo o) {
            this.nodes = _mapCopy(o.nodes);
            this.reservedSizes = _listCopy(o.reservedSizes);
            this.shardDataSetSizes = _mapCopy(o.shardDataSetSizes);
            this.shardPaths = _mapCopy(o.shardPaths);
            this.shardSizes = _mapCopy(o.shardSizes);
        }

        private Builder(Builder o) {
            this.nodes = _mapCopy(o.nodes);
            this.reservedSizes = _listCopy(o.reservedSizes);
            this.shardDataSetSizes = _mapCopy(o.shardDataSetSizes);
            this.shardPaths = _mapCopy(o.shardPaths);
            this.shardSizes = _mapCopy(o.shardSizes);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code nodes}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(Map<String, NodeDiskUsage> map) {
            this.nodes = _mapPutAll(this.nodes, map);
            return this;
        }

        /**
         * Required - API name: {@code nodes}
         *
         * <p>
         * Adds an entry to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(String key, NodeDiskUsage value) {
            this.nodes = _mapPut(this.nodes, key, value);
            return this;
        }

        /**
         * Required - API name: {@code nodes}
         *
         * <p>
         * Adds a value to <code>nodes</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder nodes(String key, Function<NodeDiskUsage.Builder, ObjectBuilder<NodeDiskUsage>> fn) {
            return nodes(key, fn.apply(new NodeDiskUsage.Builder()).build());
        }

        /**
         * Required - API name: {@code reserved_sizes}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>reservedSizes</code>.
         * </p>
         */
        @Nonnull
        public final Builder reservedSizes(List<ReservedSize> list) {
            this.reservedSizes = _listAddAll(this.reservedSizes, list);
            return this;
        }

        /**
         * Required - API name: {@code reserved_sizes}
         *
         * <p>
         * Adds one or more values to <code>reservedSizes</code>.
         * </p>
         */
        @Nonnull
        public final Builder reservedSizes(ReservedSize value, ReservedSize... values) {
            this.reservedSizes = _listAdd(this.reservedSizes, value, values);
            return this;
        }

        /**
         * Required - API name: {@code reserved_sizes}
         *
         * <p>
         * Adds a value to <code>reservedSizes</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder reservedSizes(Function<ReservedSize.Builder, ObjectBuilder<ReservedSize>> fn) {
            return reservedSizes(fn.apply(new ReservedSize.Builder()).build());
        }

        /**
         * API name: {@code shard_data_set_sizes}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>shardDataSetSizes</code>.
         * </p>
         */
        @Nonnull
        public final Builder shardDataSetSizes(Map<String, String> map) {
            this.shardDataSetSizes = _mapPutAll(this.shardDataSetSizes, map);
            return this;
        }

        /**
         * API name: {@code shard_data_set_sizes}
         *
         * <p>
         * Adds an entry to <code>shardDataSetSizes</code>.
         * </p>
         */
        @Nonnull
        public final Builder shardDataSetSizes(String key, String value) {
            this.shardDataSetSizes = _mapPut(this.shardDataSetSizes, key, value);
            return this;
        }

        /**
         * Required - API name: {@code shard_paths}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>shardPaths</code>.
         * </p>
         */
        @Nonnull
        public final Builder shardPaths(Map<String, String> map) {
            this.shardPaths = _mapPutAll(this.shardPaths, map);
            return this;
        }

        /**
         * Required - API name: {@code shard_paths}
         *
         * <p>
         * Adds an entry to <code>shardPaths</code>.
         * </p>
         */
        @Nonnull
        public final Builder shardPaths(String key, String value) {
            this.shardPaths = _mapPut(this.shardPaths, key, value);
            return this;
        }

        /**
         * Required - API name: {@code shard_sizes}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>shardSizes</code>.
         * </p>
         */
        @Nonnull
        public final Builder shardSizes(Map<String, String> map) {
            this.shardSizes = _mapPutAll(this.shardSizes, map);
            return this;
        }

        /**
         * Required - API name: {@code shard_sizes}
         *
         * <p>
         * Adds an entry to <code>shardSizes</code>.
         * </p>
         */
        @Nonnull
        public final Builder shardSizes(String key, String value) {
            this.shardSizes = _mapPut(this.shardSizes, key, value);
            return this;
        }

        /**
         * Builds a {@link ClusterInfo}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterInfo build() {
            _checkSingleUse();

            return new ClusterInfo(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterInfo}
     */
    public static final JsonpDeserializer<ClusterInfo> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterInfo::setupClusterInfoDeserializer
    );

    protected static void setupClusterInfoDeserializer(ObjectDeserializer<ClusterInfo.Builder> op) {
        op.add(Builder::nodes, JsonpDeserializer.stringMapDeserializer(NodeDiskUsage._DESERIALIZER), "nodes");
        op.add(Builder::reservedSizes, JsonpDeserializer.arrayDeserializer(ReservedSize._DESERIALIZER), "reserved_sizes");
        op.add(
            Builder::shardDataSetSizes,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()),
            "shard_data_set_sizes"
        );
        op.add(Builder::shardPaths, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "shard_paths");
        op.add(Builder::shardSizes, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "shard_sizes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.nodes.hashCode();
        result = 31 * result + this.reservedSizes.hashCode();
        result = 31 * result + Objects.hashCode(this.shardDataSetSizes);
        result = 31 * result + this.shardPaths.hashCode();
        result = 31 * result + this.shardSizes.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterInfo other = (ClusterInfo) o;
        return this.nodes.equals(other.nodes)
            && this.reservedSizes.equals(other.reservedSizes)
            && Objects.equals(this.shardDataSetSizes, other.shardDataSetSizes)
            && this.shardPaths.equals(other.shardPaths)
            && this.shardSizes.equals(other.shardSizes);
    }
}
