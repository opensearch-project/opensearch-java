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
import org.opensearch.client.opensearch.indices.stats.IndexStats;
import org.opensearch.client.opensearch.indices.stats.IndexStatsBase;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.NodeIndicesStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeIndicesStats extends IndexStatsBase implements ToCopyableBuilder<NodeIndicesStats.Builder, NodeIndicesStats> {

    @Nonnull
    private final Map<String, IndexStats> indices;

    @Nonnull
    private final Map<String, List<NodeIndexShardStats>> shards;

    // ---------------------------------------------------------------------------------------------

    private NodeIndicesStats(Builder builder) {
        super(builder);
        this.indices = ApiTypeHelper.unmodifiable(builder.indices);
        this.shards = ApiTypeHelper.unmodifiable(builder.shards);
    }

    public static NodeIndicesStats of(Function<NodeIndicesStats.Builder, ObjectBuilder<NodeIndicesStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code indices}
     */
    @Nonnull
    public final Map<String, IndexStats> indices() {
        return this.indices;
    }

    /**
     * API name: {@code shards}
     */
    @Nonnull
    public final Map<String, List<NodeIndexShardStats>> shards() {
        return this.shards;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (ApiTypeHelper.isDefined(this.indices)) {
            generator.writeKey("indices");
            generator.writeStartObject();
            for (Map.Entry<String, IndexStats> item0 : this.indices.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.shards)) {
            generator.writeKey("shards");
            generator.writeStartObject();
            for (Map.Entry<String, List<NodeIndexShardStats>> item0 : this.shards.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.writeStartArray();
                if (item0.getValue() != null) {
                    for (NodeIndexShardStats item1 : item0.getValue()) {
                        item1.serialize(generator, mapper);
                    }
                }
                generator.writeEnd();
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
     * Builder for {@link NodeIndicesStats}.
     */
    public static class Builder extends IndexStatsBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, NodeIndicesStats> {
        @Nullable
        private Map<String, IndexStats> indices;
        @Nullable
        private Map<String, List<NodeIndexShardStats>> shards;

        public Builder() {}

        private Builder(NodeIndicesStats o) {
            super(o);
            this.indices = _mapCopy(o.indices);
            this.shards = _mapCopy(o.shards);
        }

        private Builder(Builder o) {
            super(o);
            this.indices = _mapCopy(o.indices);
            this.shards = _mapCopy(o.shards);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * API name: {@code indices}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(Map<String, IndexStats> map) {
            this.indices = _mapPutAll(this.indices, map);
            return this;
        }

        /**
         * API name: {@code indices}
         *
         * <p>
         * Adds an entry to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(String key, IndexStats value) {
            this.indices = _mapPut(this.indices, key, value);
            return this;
        }

        /**
         * API name: {@code indices}
         *
         * <p>
         * Adds a value to <code>indices</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder indices(String key, Function<IndexStats.Builder, ObjectBuilder<IndexStats>> fn) {
            return indices(key, fn.apply(new IndexStats.Builder()).build());
        }

        /**
         * API name: {@code shards}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(Map<String, List<NodeIndexShardStats>> map) {
            this.shards = _mapPutAll(this.shards, map);
            return this;
        }

        /**
         * API name: {@code shards}
         *
         * <p>
         * Adds an entry to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(String key, List<NodeIndexShardStats> value) {
            this.shards = _mapPut(this.shards, key, value);
            return this;
        }

        /**
         * Builds a {@link NodeIndicesStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeIndicesStats build() {
            _checkSingleUse();

            return new NodeIndicesStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeIndicesStats}
     */
    public static final JsonpDeserializer<NodeIndicesStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeIndicesStats::setupNodeIndicesStatsDeserializer
    );

    protected static void setupNodeIndicesStatsDeserializer(ObjectDeserializer<NodeIndicesStats.Builder> op) {
        setupIndexStatsBaseDeserializer(op);
        op.add(Builder::indices, JsonpDeserializer.stringMapDeserializer(IndexStats._DESERIALIZER), "indices");
        op.add(
            Builder::shards,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.arrayDeserializer(NodeIndexShardStats._DESERIALIZER)),
            "shards"
        );
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.indices);
        result = 31 * result + Objects.hashCode(this.shards);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeIndicesStats other = (NodeIndicesStats) o;
        return Objects.equals(this.indices, other.indices) && Objects.equals(this.shards, other.shards);
    }
}
