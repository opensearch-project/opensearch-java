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

// typedef: ltr.stats.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class LtrStatsResponse extends NodesResponseBase implements ToCopyableBuilder<LtrStatsResponse.Builder, LtrStatsResponse> {

    @Nullable
    private final String clusterName;

    @Nonnull
    private final Map<String, NodeStats> nodes;

    @Nullable
    private final String status;

    @Nonnull
    private final Map<String, StoreStat> stores;

    // ---------------------------------------------------------------------------------------------

    private LtrStatsResponse(Builder builder) {
        super(builder);
        this.clusterName = builder.clusterName;
        this.nodes = ApiTypeHelper.unmodifiable(builder.nodes);
        this.status = builder.status;
        this.stores = ApiTypeHelper.unmodifiable(builder.stores);
    }

    public static LtrStatsResponse of(Function<LtrStatsResponse.Builder, ObjectBuilder<LtrStatsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code cluster_name}
     */
    @Nullable
    public final String clusterName() {
        return this.clusterName;
    }

    /**
     * API name: {@code nodes}
     */
    @Nonnull
    public final Map<String, NodeStats> nodes() {
        return this.nodes;
    }

    /**
     * API name: {@code status}
     */
    @Nullable
    public final String status() {
        return this.status;
    }

    /**
     * API name: {@code stores}
     */
    @Nonnull
    public final Map<String, StoreStat> stores() {
        return this.stores;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.clusterName != null) {
            generator.writeKey("cluster_name");
            generator.write(this.clusterName);
        }

        if (ApiTypeHelper.isDefined(this.nodes)) {
            generator.writeKey("nodes");
            generator.writeStartObject();
            for (Map.Entry<String, NodeStats> item0 : this.nodes.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.status != null) {
            generator.writeKey("status");
            generator.write(this.status);
        }

        if (ApiTypeHelper.isDefined(this.stores)) {
            generator.writeKey("stores");
            generator.writeStartObject();
            for (Map.Entry<String, StoreStat> item0 : this.stores.entrySet()) {
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
     * Builder for {@link LtrStatsResponse}.
     */
    public static class Builder extends NodesResponseBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, LtrStatsResponse> {
        @Nullable
        private String clusterName;
        @Nullable
        private Map<String, NodeStats> nodes;
        @Nullable
        private String status;
        @Nullable
        private Map<String, StoreStat> stores;

        public Builder() {}

        private Builder(LtrStatsResponse o) {
            super(o);
            this.clusterName = o.clusterName;
            this.nodes = _mapCopy(o.nodes);
            this.status = o.status;
            this.stores = _mapCopy(o.stores);
        }

        private Builder(Builder o) {
            super(o);
            this.clusterName = o.clusterName;
            this.nodes = _mapCopy(o.nodes);
            this.status = o.status;
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
         * API name: {@code cluster_name}
         */
        @Nonnull
        public final Builder clusterName(@Nullable String value) {
            this.clusterName = value;
            return this;
        }

        /**
         * API name: {@code nodes}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(Map<String, NodeStats> map) {
            this.nodes = _mapPutAll(this.nodes, map);
            return this;
        }

        /**
         * API name: {@code nodes}
         *
         * <p>
         * Adds an entry to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(String key, NodeStats value) {
            this.nodes = _mapPut(this.nodes, key, value);
            return this;
        }

        /**
         * API name: {@code nodes}
         *
         * <p>
         * Adds a value to <code>nodes</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder nodes(String key, Function<NodeStats.Builder, ObjectBuilder<NodeStats>> fn) {
            return nodes(key, fn.apply(new NodeStats.Builder()).build());
        }

        /**
         * API name: {@code status}
         */
        @Nonnull
        public final Builder status(@Nullable String value) {
            this.status = value;
            return this;
        }

        /**
         * API name: {@code stores}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>stores</code>.
         * </p>
         */
        @Nonnull
        public final Builder stores(Map<String, StoreStat> map) {
            this.stores = _mapPutAll(this.stores, map);
            return this;
        }

        /**
         * API name: {@code stores}
         *
         * <p>
         * Adds an entry to <code>stores</code>.
         * </p>
         */
        @Nonnull
        public final Builder stores(String key, StoreStat value) {
            this.stores = _mapPut(this.stores, key, value);
            return this;
        }

        /**
         * API name: {@code stores}
         *
         * <p>
         * Adds a value to <code>stores</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder stores(String key, Function<StoreStat.Builder, ObjectBuilder<StoreStat>> fn) {
            return stores(key, fn.apply(new StoreStat.Builder()).build());
        }

        /**
         * Builds a {@link LtrStatsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public LtrStatsResponse build() {
            _checkSingleUse();

            return new LtrStatsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link LtrStatsResponse}
     */
    public static final JsonpDeserializer<LtrStatsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        LtrStatsResponse::setupLtrStatsResponseDeserializer
    );

    protected static void setupLtrStatsResponseDeserializer(ObjectDeserializer<LtrStatsResponse.Builder> op) {
        setupNodesResponseBaseDeserializer(op);
        op.add(Builder::clusterName, JsonpDeserializer.stringDeserializer(), "cluster_name");
        op.add(Builder::nodes, JsonpDeserializer.stringMapDeserializer(NodeStats._DESERIALIZER), "nodes");
        op.add(Builder::status, JsonpDeserializer.stringDeserializer(), "status");
        op.add(Builder::stores, JsonpDeserializer.stringMapDeserializer(StoreStat._DESERIALIZER), "stores");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.clusterName);
        result = 31 * result + Objects.hashCode(this.nodes);
        result = 31 * result + Objects.hashCode(this.status);
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
        LtrStatsResponse other = (LtrStatsResponse) o;
        return Objects.equals(this.clusterName, other.clusterName)
            && Objects.equals(this.nodes, other.nodes)
            && Objects.equals(this.status, other.status)
            && Objects.equals(this.stores, other.stores);
    }
}
