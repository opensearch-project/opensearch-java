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

package org.opensearch.client.opensearch.indices;

import jakarta.json.stream.JsonGenerator;
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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.IndexSettingsStoreHybrid

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsStoreHybrid
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexSettingsStoreHybrid.Builder, IndexSettingsStoreHybrid> {

    @Nullable
    private final IndexSettingsStoreHybridMmap mmap;

    @Nullable
    private final IndexSettingsStoreHybridNio nio;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsStoreHybrid(Builder builder) {
        this.mmap = builder.mmap;
        this.nio = builder.nio;
    }

    public static IndexSettingsStoreHybrid of(Function<IndexSettingsStoreHybrid.Builder, ObjectBuilder<IndexSettingsStoreHybrid>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code mmap}
     */
    @Nullable
    public final IndexSettingsStoreHybridMmap mmap() {
        return this.mmap;
    }

    /**
     * API name: {@code nio}
     */
    @Nullable
    public final IndexSettingsStoreHybridNio nio() {
        return this.nio;
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
        if (this.mmap != null) {
            generator.writeKey("mmap");
            this.mmap.serialize(generator, mapper);
        }

        if (this.nio != null) {
            generator.writeKey("nio");
            this.nio.serialize(generator, mapper);
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
     * Builder for {@link IndexSettingsStoreHybrid}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsStoreHybrid> {
        @Nullable
        private IndexSettingsStoreHybridMmap mmap;
        @Nullable
        private IndexSettingsStoreHybridNio nio;

        public Builder() {}

        private Builder(IndexSettingsStoreHybrid o) {
            this.mmap = o.mmap;
            this.nio = o.nio;
        }

        private Builder(Builder o) {
            this.mmap = o.mmap;
            this.nio = o.nio;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code mmap}
         */
        @Nonnull
        public final Builder mmap(@Nullable IndexSettingsStoreHybridMmap value) {
            this.mmap = value;
            return this;
        }

        /**
         * API name: {@code mmap}
         */
        @Nonnull
        public final Builder mmap(Function<IndexSettingsStoreHybridMmap.Builder, ObjectBuilder<IndexSettingsStoreHybridMmap>> fn) {
            return mmap(fn.apply(new IndexSettingsStoreHybridMmap.Builder()).build());
        }

        /**
         * API name: {@code nio}
         */
        @Nonnull
        public final Builder nio(@Nullable IndexSettingsStoreHybridNio value) {
            this.nio = value;
            return this;
        }

        /**
         * API name: {@code nio}
         */
        @Nonnull
        public final Builder nio(Function<IndexSettingsStoreHybridNio.Builder, ObjectBuilder<IndexSettingsStoreHybridNio>> fn) {
            return nio(fn.apply(new IndexSettingsStoreHybridNio.Builder()).build());
        }

        /**
         * Builds a {@link IndexSettingsStoreHybrid}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsStoreHybrid build() {
            _checkSingleUse();

            return new IndexSettingsStoreHybrid(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsStoreHybrid}
     */
    public static final JsonpDeserializer<IndexSettingsStoreHybrid> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsStoreHybrid::setupIndexSettingsStoreHybridDeserializer
    );

    protected static void setupIndexSettingsStoreHybridDeserializer(ObjectDeserializer<IndexSettingsStoreHybrid.Builder> op) {
        op.add(Builder::mmap, IndexSettingsStoreHybridMmap._DESERIALIZER, "mmap");
        op.add(Builder::nio, IndexSettingsStoreHybridNio._DESERIALIZER, "nio");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.mmap);
        result = 31 * result + Objects.hashCode(this.nio);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsStoreHybrid other = (IndexSettingsStoreHybrid) o;
        return Objects.equals(this.mmap, other.mmap) && Objects.equals(this.nio, other.nio);
    }
}
