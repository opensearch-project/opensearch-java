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

package org.opensearch.client.opensearch.core;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.NodeAttributes;
import org.opensearch.client.opensearch._types.NodeShard;
import org.opensearch.client.opensearch.core.search_shards.ShardStoreIndex;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.search_shards.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SearchShardsResponse implements PlainJsonSerializable, ToCopyableBuilder<SearchShardsResponse.Builder, SearchShardsResponse> {

    @Nonnull
    private final Map<String, ShardStoreIndex> indices;

    @Nonnull
    private final Map<String, NodeAttributes> nodes;

    @Nonnull
    private final List<List<NodeShard>> shards;

    // ---------------------------------------------------------------------------------------------

    private SearchShardsResponse(Builder builder) {
        this.indices = ApiTypeHelper.unmodifiableRequired(builder.indices, this, "indices");
        this.nodes = ApiTypeHelper.unmodifiableRequired(builder.nodes, this, "nodes");
        this.shards = ApiTypeHelper.unmodifiableRequired(builder.shards, this, "shards");
    }

    public static SearchShardsResponse of(Function<SearchShardsResponse.Builder, ObjectBuilder<SearchShardsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code indices}
     */
    @Nonnull
    public final Map<String, ShardStoreIndex> indices() {
        return this.indices;
    }

    /**
     * Required - API name: {@code nodes}
     */
    @Nonnull
    public final Map<String, NodeAttributes> nodes() {
        return this.nodes;
    }

    /**
     * Required - API name: {@code shards}
     */
    @Nonnull
    public final List<List<NodeShard>> shards() {
        return this.shards;
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
        generator.writeKey("indices");
        generator.writeStartObject();
        for (Map.Entry<String, ShardStoreIndex> item0 : this.indices.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("nodes");
        generator.writeStartObject();
        for (Map.Entry<String, NodeAttributes> item0 : this.nodes.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("shards");
        generator.writeStartArray();
        for (List<NodeShard> item0 : this.shards) {
            generator.writeStartArray();
            for (NodeShard item1 : item0) {
                item1.serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link SearchShardsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SearchShardsResponse> {
        private Map<String, ShardStoreIndex> indices;
        private Map<String, NodeAttributes> nodes;
        private List<List<NodeShard>> shards;

        public Builder() {}

        private Builder(SearchShardsResponse o) {
            this.indices = _mapCopy(o.indices);
            this.nodes = _mapCopy(o.nodes);
            this.shards = _listCopy(o.shards);
        }

        private Builder(Builder o) {
            this.indices = _mapCopy(o.indices);
            this.nodes = _mapCopy(o.nodes);
            this.shards = _listCopy(o.shards);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code indices}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(Map<String, ShardStoreIndex> map) {
            this.indices = _mapPutAll(this.indices, map);
            return this;
        }

        /**
         * Required - API name: {@code indices}
         *
         * <p>
         * Adds an entry to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(String key, ShardStoreIndex value) {
            this.indices = _mapPut(this.indices, key, value);
            return this;
        }

        /**
         * Required - API name: {@code indices}
         *
         * <p>
         * Adds a value to <code>indices</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder indices(String key, Function<ShardStoreIndex.Builder, ObjectBuilder<ShardStoreIndex>> fn) {
            return indices(key, fn.apply(new ShardStoreIndex.Builder()).build());
        }

        /**
         * Required - API name: {@code nodes}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(Map<String, NodeAttributes> map) {
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
        public final Builder nodes(String key, NodeAttributes value) {
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
        public final Builder nodes(String key, Function<NodeAttributes.Builder, ObjectBuilder<NodeAttributes>> fn) {
            return nodes(key, fn.apply(new NodeAttributes.Builder()).build());
        }

        /**
         * Required - API name: {@code shards}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(List<List<NodeShard>> list) {
            this.shards = _listAddAll(this.shards, list);
            return this;
        }

        /**
         * Required - API name: {@code shards}
         *
         * <p>
         * Adds one or more values to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(List<NodeShard> value, List<NodeShard>... values) {
            this.shards = _listAdd(this.shards, value, values);
            return this;
        }

        /**
         * Builds a {@link SearchShardsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SearchShardsResponse build() {
            _checkSingleUse();

            return new SearchShardsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SearchShardsResponse}
     */
    public static final JsonpDeserializer<SearchShardsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SearchShardsResponse::setupSearchShardsResponseDeserializer
    );

    protected static void setupSearchShardsResponseDeserializer(ObjectDeserializer<SearchShardsResponse.Builder> op) {
        op.add(Builder::indices, JsonpDeserializer.stringMapDeserializer(ShardStoreIndex._DESERIALIZER), "indices");
        op.add(Builder::nodes, JsonpDeserializer.stringMapDeserializer(NodeAttributes._DESERIALIZER), "nodes");
        op.add(
            Builder::shards,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.arrayDeserializer(NodeShard._DESERIALIZER)),
            "shards"
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.indices.hashCode();
        result = 31 * result + this.nodes.hashCode();
        result = 31 * result + this.shards.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SearchShardsResponse other = (SearchShardsResponse) o;
        return this.indices.equals(other.indices) && this.nodes.equals(other.nodes) && this.shards.equals(other.shards);
    }
}
