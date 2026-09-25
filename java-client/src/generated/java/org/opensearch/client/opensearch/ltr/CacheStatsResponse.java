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

package org.opensearch.client.opensearch.ltr;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch.nodes.NodesResponseBase;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ltr.cache_stats.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CacheStatsResponse extends NodesResponseBase implements ToCopyableBuilder<CacheStatsResponse.Builder, CacheStatsResponse> {

    @Nullable
    private final CacheAllStats all;

    @Nullable
    private final String clusterName;

    @Nonnull
    private final Map<String, NodeDetails> nodes;

    @Nonnull
    private final Map<String, JsonData> stores;

    // ---------------------------------------------------------------------------------------------

    private CacheStatsResponse(Builder builder) {
        super(builder);
        this.all = builder.all;
        this.clusterName = builder.clusterName;
        this.nodes = ApiTypeHelper.unmodifiable(builder.nodes);
        this.stores = ApiTypeHelper.unmodifiable(builder.stores);
    }

    public static CacheStatsResponse of(Function<CacheStatsResponse.Builder, ObjectBuilder<CacheStatsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code all}
     */
    @Nullable
    public final CacheAllStats all() {
        return this.all;
    }

    /**
     * API name: {@code cluster_name}
     */
    @Nullable
    public final String clusterName() {
        return this.clusterName;
    }

    /**
     * Cache statistics per node.
     * <p>
     * API name: {@code nodes}
     * </p>
     */
    @Nonnull
    public final Map<String, NodeDetails> nodes() {
        return this.nodes;
    }

    /**
     * Cache statistics by store.
     * <p>
     * API name: {@code stores}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> stores() {
        return this.stores;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.all != null) {
            generator.writeKey("all");
            this.all.serialize(generator, mapper);
        }

        if (this.clusterName != null) {
            generator.writeKey("cluster_name");
            generator.write(this.clusterName);
        }

        if (ApiTypeHelper.isDefined(this.nodes)) {
            generator.writeKey("nodes");
            generator.writeStartObject();
            for (Map.Entry<String, NodeDetails> item0 : this.nodes.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.stores)) {
            generator.writeKey("stores");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.stores.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
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
     * Builder for {@link CacheStatsResponse}.
     */
    public static class Builder extends NodesResponseBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, CacheStatsResponse> {
        @Nullable
        private CacheAllStats all;
        @Nullable
        private String clusterName;
        @Nullable
        private Map<String, NodeDetails> nodes;
        @Nullable
        private Map<String, JsonData> stores;

        public Builder() {}

        private Builder(CacheStatsResponse o) {
            super(o);
            this.all = o.all;
            this.clusterName = o.clusterName;
            this.nodes = _mapCopy(o.nodes);
            this.stores = _mapCopy(o.stores);
        }

        private Builder(Builder o) {
            super(o);
            this.all = o.all;
            this.clusterName = o.clusterName;
            this.nodes = _mapCopy(o.nodes);
            this.stores = _mapCopy(o.stores);
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
         * API name: {@code all}
         */
        @Nonnull
        public final Builder all(@Nullable CacheAllStats value) {
            this.all = value;
            return this;
        }

        /**
         * API name: {@code all}
         */
        @Nonnull
        public final Builder all(Function<CacheAllStats.Builder, ObjectBuilder<CacheAllStats>> fn) {
            return all(fn.apply(new CacheAllStats.Builder()).build());
        }

        /**
         * API name: {@code cluster_name}
         */
        @Nonnull
        public final Builder clusterName(@Nullable String value) {
            this.clusterName = value;
            return this;
        }

        /**
         * Cache statistics per node.
         * <p>
         * API name: {@code nodes}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(Map<String, NodeDetails> map) {
            this.nodes = _mapPutAll(this.nodes, map);
            return this;
        }

        /**
         * Cache statistics per node.
         * <p>
         * API name: {@code nodes}
         * </p>
         *
         * <p>
         * Adds an entry to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(String key, NodeDetails value) {
            this.nodes = _mapPut(this.nodes, key, value);
            return this;
        }

        /**
         * Cache statistics per node.
         * <p>
         * API name: {@code nodes}
         * </p>
         *
         * <p>
         * Adds a value to <code>nodes</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder nodes(String key, Function<NodeDetails.Builder, ObjectBuilder<NodeDetails>> fn) {
            return nodes(key, fn.apply(new NodeDetails.Builder()).build());
        }

        /**
         * Cache statistics by store.
         * <p>
         * API name: {@code stores}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>stores</code>.
         * </p>
         */
        @Nonnull
        public final Builder stores(Map<String, JsonData> map) {
            this.stores = _mapPutAll(this.stores, map);
            return this;
        }

        /**
         * Cache statistics by store.
         * <p>
         * API name: {@code stores}
         * </p>
         *
         * <p>
         * Adds an entry to <code>stores</code>.
         * </p>
         */
        @Nonnull
        public final Builder stores(String key, JsonData value) {
            this.stores = _mapPut(this.stores, key, value);
            return this;
        }

        /**
         * Builds a {@link CacheStatsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CacheStatsResponse build() {
            _checkSingleUse();

            return new CacheStatsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CacheStatsResponse}
     */
    public static final JsonpDeserializer<CacheStatsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CacheStatsResponse::setupCacheStatsResponseDeserializer
    );

    protected static void setupCacheStatsResponseDeserializer(ObjectDeserializer<CacheStatsResponse.Builder> op) {
        setupNodesResponseBaseDeserializer(op);
        op.add(Builder::all, CacheAllStats._DESERIALIZER, "all");
        op.add(Builder::clusterName, JsonpDeserializer.stringDeserializer(), "cluster_name");
        op.add(Builder::nodes, JsonpDeserializer.stringMapDeserializer(NodeDetails._DESERIALIZER), "nodes");
        op.add(Builder::stores, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "stores");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.all);
        result = 31 * result + Objects.hashCode(this.clusterName);
        result = 31 * result + Objects.hashCode(this.nodes);
        result = 31 * result + Objects.hashCode(this.stores);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CacheStatsResponse other = (CacheStatsResponse) o;
        return Objects.equals(this.all, other.all)
            && Objects.equals(this.clusterName, other.clusterName)
            && Objects.equals(this.nodes, other.nodes)
            && Objects.equals(this.stores, other.stores);
    }
}
