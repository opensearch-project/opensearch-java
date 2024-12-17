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
import java.util.HashMap;
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
import org.opensearch.client.opensearch._types.NodeAttributes;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.shard_stores.ShardStore

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardStore implements PlainJsonSerializable, ToCopyableBuilder<ShardStore.Builder, ShardStore> {

    @Nonnull
    private final ShardStoreAllocation allocation;

    @Nullable
    private final String allocationId;

    @Nonnull
    private final Map<String, NodeAttributes> nodes;

    @Nullable
    private final ShardStoreException storeException;

    // ---------------------------------------------------------------------------------------------

    private ShardStore(Builder builder) {
        this.allocation = ApiTypeHelper.requireNonNull(builder.allocation, this, "allocation");
        this.allocationId = builder.allocationId;
        this.nodes = ApiTypeHelper.unmodifiable(builder.nodes);
        this.storeException = builder.storeException;
    }

    public static ShardStore of(Function<ShardStore.Builder, ObjectBuilder<ShardStore>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code allocation}
     */
    @Nonnull
    public final ShardStoreAllocation allocation() {
        return this.allocation;
    }

    /**
     * API name: {@code allocation_id}
     */
    @Nullable
    public final String allocationId() {
        return this.allocationId;
    }

    @Nonnull
    public final Map<String, NodeAttributes> nodes() {
        return this.nodes;
    }

    /**
     * API name: {@code store_exception}
     */
    @Nullable
    public final ShardStoreException storeException() {
        return this.storeException;
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
        for (Map.Entry<String, NodeAttributes> item0 : this.nodes.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeKey("allocation");
        this.allocation.serialize(generator, mapper);

        if (this.allocationId != null) {
            generator.writeKey("allocation_id");
            generator.write(this.allocationId);
        }

        if (this.storeException != null) {
            generator.writeKey("store_exception");
            this.storeException.serialize(generator, mapper);
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
     * Builder for {@link ShardStore}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardStore> {
        private ShardStoreAllocation allocation;
        @Nullable
        private String allocationId;
        @Nullable
        private Map<String, NodeAttributes> nodes;
        @Nullable
        private ShardStoreException storeException;

        public Builder() {}

        private Builder(ShardStore o) {
            this.allocation = o.allocation;
            this.allocationId = o.allocationId;
            this.nodes = _mapCopy(o.nodes);
            this.storeException = o.storeException;
        }

        private Builder(Builder o) {
            this.allocation = o.allocation;
            this.allocationId = o.allocationId;
            this.nodes = _mapCopy(o.nodes);
            this.storeException = o.storeException;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code allocation}
         */
        @Nonnull
        public final Builder allocation(ShardStoreAllocation value) {
            this.allocation = value;
            return this;
        }

        /**
         * API name: {@code allocation_id}
         */
        @Nonnull
        public final Builder allocationId(@Nullable String value) {
            this.allocationId = value;
            return this;
        }

        /**
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
         * API name: {@code store_exception}
         */
        @Nonnull
        public final Builder storeException(@Nullable ShardStoreException value) {
            this.storeException = value;
            return this;
        }

        /**
         * API name: {@code store_exception}
         */
        @Nonnull
        public final Builder storeException(Function<ShardStoreException.Builder, ObjectBuilder<ShardStoreException>> fn) {
            return storeException(fn.apply(new ShardStoreException.Builder()).build());
        }

        /**
         * Builds a {@link ShardStore}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardStore build() {
            _checkSingleUse();

            return new ShardStore(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardStore}
     */
    public static final JsonpDeserializer<ShardStore> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardStore::setupShardStoreDeserializer
    );

    protected static void setupShardStoreDeserializer(ObjectDeserializer<ShardStore.Builder> op) {
        op.add(Builder::allocation, ShardStoreAllocation._DESERIALIZER, "allocation");
        op.add(Builder::allocationId, JsonpDeserializer.stringDeserializer(), "allocation_id");
        op.add(Builder::storeException, ShardStoreException._DESERIALIZER, "store_exception");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            if (builder.nodes == null) {
                builder.nodes = new HashMap<>();
            }
            builder.nodes.put(name, NodeAttributes._DESERIALIZER.deserialize(parser, mapper));
        });
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.allocation.hashCode();
        result = 31 * result + Objects.hashCode(this.allocationId);
        result = 31 * result + Objects.hashCode(this.nodes);
        result = 31 * result + Objects.hashCode(this.storeException);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardStore other = (ShardStore) o;
        return this.allocation.equals(other.allocation)
            && Objects.equals(this.allocationId, other.allocationId)
            && Objects.equals(this.nodes, other.nodes)
            && Objects.equals(this.storeException, other.storeException);
    }
}
