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

// typedef: nodes.stats.NativeMemoryAllocator

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NativeMemoryAllocator
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<NativeMemoryAllocator.Builder, NativeMemoryAllocator> {

    @Nonnull
    private final Map<String, NativeMemoryAllocatorPool> pools;

    @Nullable
    private final NativeMemoryAllocatorPool root;

    // ---------------------------------------------------------------------------------------------

    private NativeMemoryAllocator(Builder builder) {
        this.pools = ApiTypeHelper.unmodifiable(builder.pools);
        this.root = builder.root;
    }

    public static NativeMemoryAllocator of(Function<NativeMemoryAllocator.Builder, ObjectBuilder<NativeMemoryAllocator>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Statistics for each allocator pool, keyed by pool name.
     * <p>
     * API name: {@code pools}
     * </p>
     */
    @Nonnull
    public final Map<String, NativeMemoryAllocatorPool> pools() {
        return this.pools;
    }

    /**
     * Statistics for the root allocator.
     * <p>
     * API name: {@code root}
     * </p>
     */
    @Nullable
    public final NativeMemoryAllocatorPool root() {
        return this.root;
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
        if (ApiTypeHelper.isDefined(this.pools)) {
            generator.writeKey("pools");
            generator.writeStartObject();
            for (Map.Entry<String, NativeMemoryAllocatorPool> item0 : this.pools.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.root != null) {
            generator.writeKey("root");
            this.root.serialize(generator, mapper);
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
     * Builder for {@link NativeMemoryAllocator}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NativeMemoryAllocator> {
        @Nullable
        private Map<String, NativeMemoryAllocatorPool> pools;
        @Nullable
        private NativeMemoryAllocatorPool root;

        public Builder() {}

        private Builder(NativeMemoryAllocator o) {
            this.pools = _mapCopy(o.pools);
            this.root = o.root;
        }

        private Builder(Builder o) {
            this.pools = _mapCopy(o.pools);
            this.root = o.root;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Statistics for each allocator pool, keyed by pool name.
         * <p>
         * API name: {@code pools}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>pools</code>.
         * </p>
         */
        @Nonnull
        public final Builder pools(Map<String, NativeMemoryAllocatorPool> map) {
            this.pools = _mapPutAll(this.pools, map);
            return this;
        }

        /**
         * Statistics for each allocator pool, keyed by pool name.
         * <p>
         * API name: {@code pools}
         * </p>
         *
         * <p>
         * Adds an entry to <code>pools</code>.
         * </p>
         */
        @Nonnull
        public final Builder pools(String key, NativeMemoryAllocatorPool value) {
            this.pools = _mapPut(this.pools, key, value);
            return this;
        }

        /**
         * Statistics for each allocator pool, keyed by pool name.
         * <p>
         * API name: {@code pools}
         * </p>
         *
         * <p>
         * Adds a value to <code>pools</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder pools(String key, Function<NativeMemoryAllocatorPool.Builder, ObjectBuilder<NativeMemoryAllocatorPool>> fn) {
            return pools(key, fn.apply(new NativeMemoryAllocatorPool.Builder()).build());
        }

        /**
         * Statistics for the root allocator.
         * <p>
         * API name: {@code root}
         * </p>
         */
        @Nonnull
        public final Builder root(@Nullable NativeMemoryAllocatorPool value) {
            this.root = value;
            return this;
        }

        /**
         * Statistics for the root allocator.
         * <p>
         * API name: {@code root}
         * </p>
         */
        @Nonnull
        public final Builder root(Function<NativeMemoryAllocatorPool.Builder, ObjectBuilder<NativeMemoryAllocatorPool>> fn) {
            return root(fn.apply(new NativeMemoryAllocatorPool.Builder()).build());
        }

        /**
         * Builds a {@link NativeMemoryAllocator}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NativeMemoryAllocator build() {
            _checkSingleUse();

            return new NativeMemoryAllocator(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NativeMemoryAllocator}
     */
    public static final JsonpDeserializer<NativeMemoryAllocator> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NativeMemoryAllocator::setupNativeMemoryAllocatorDeserializer
    );

    protected static void setupNativeMemoryAllocatorDeserializer(ObjectDeserializer<NativeMemoryAllocator.Builder> op) {
        op.add(Builder::pools, JsonpDeserializer.stringMapDeserializer(NativeMemoryAllocatorPool._DESERIALIZER), "pools");
        op.add(Builder::root, NativeMemoryAllocatorPool._DESERIALIZER, "root");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.pools);
        result = 31 * result + Objects.hashCode(this.root);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NativeMemoryAllocator other = (NativeMemoryAllocator) o;
        return Objects.equals(this.pools, other.pools) && Objects.equals(this.root, other.root);
    }
}
