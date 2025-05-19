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

package org.opensearch.client.opensearch.indices.shard_stores;

import jakarta.json.stream.JsonGenerator;
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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.shard_stores.IndicesShardStores

/**
 * The shard store information for indices.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndicesShardStores implements PlainJsonSerializable, ToCopyableBuilder<IndicesShardStores.Builder, IndicesShardStores> {

    @Nonnull
    private final Map<String, ShardStoreWrapper> shards;

    // ---------------------------------------------------------------------------------------------

    private IndicesShardStores(Builder builder) {
        this.shards = ApiTypeHelper.unmodifiableRequired(builder.shards, this, "shards");
    }

    public static IndicesShardStores of(Function<IndicesShardStores.Builder, ObjectBuilder<IndicesShardStores>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The store information for each shard.
     * <p>
     * API name: {@code shards}
     * </p>
     */
    @Nonnull
    public final Map<String, ShardStoreWrapper> shards() {
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
        generator.writeKey("shards");
        generator.writeStartObject();
        for (Map.Entry<String, ShardStoreWrapper> item0 : this.shards.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
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
     * Builder for {@link IndicesShardStores}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndicesShardStores> {
        private Map<String, ShardStoreWrapper> shards;

        public Builder() {}

        private Builder(IndicesShardStores o) {
            this.shards = _mapCopy(o.shards);
        }

        private Builder(Builder o) {
            this.shards = _mapCopy(o.shards);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The store information for each shard.
         * <p>
         * API name: {@code shards}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(Map<String, ShardStoreWrapper> map) {
            this.shards = _mapPutAll(this.shards, map);
            return this;
        }

        /**
         * Required - The store information for each shard.
         * <p>
         * API name: {@code shards}
         * </p>
         *
         * <p>
         * Adds an entry to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(String key, ShardStoreWrapper value) {
            this.shards = _mapPut(this.shards, key, value);
            return this;
        }

        /**
         * Required - The store information for each shard.
         * <p>
         * API name: {@code shards}
         * </p>
         *
         * <p>
         * Adds a value to <code>shards</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder shards(String key, Function<ShardStoreWrapper.Builder, ObjectBuilder<ShardStoreWrapper>> fn) {
            return shards(key, fn.apply(new ShardStoreWrapper.Builder()).build());
        }

        /**
         * Builds a {@link IndicesShardStores}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndicesShardStores build() {
            _checkSingleUse();

            return new IndicesShardStores(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndicesShardStores}
     */
    public static final JsonpDeserializer<IndicesShardStores> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndicesShardStores::setupIndicesShardStoresDeserializer
    );

    protected static void setupIndicesShardStoresDeserializer(ObjectDeserializer<IndicesShardStores.Builder> op) {
        op.add(Builder::shards, JsonpDeserializer.stringMapDeserializer(ShardStoreWrapper._DESERIALIZER), "shards");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.shards.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndicesShardStores other = (IndicesShardStores) o;
        return this.shards.equals(other.shards);
    }
}
