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

package org.opensearch.client.opensearch.indices.stats;

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

// typedef: indices.stats.IndicesStats

/**
 * The statistics for specific indexes.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndicesStats implements PlainJsonSerializable, ToCopyableBuilder<IndicesStats.Builder, IndicesStats> {

    @Nonnull
    private final IndexStats primaries;

    @Nonnull
    private final Map<String, List<IndexShardStats>> shards;

    @Nonnull
    private final IndexStats total;

    @Nonnull
    private final String uuid;

    // ---------------------------------------------------------------------------------------------

    private IndicesStats(Builder builder) {
        this.primaries = ApiTypeHelper.requireNonNull(builder.primaries, this, "primaries");
        this.shards = ApiTypeHelper.unmodifiable(builder.shards);
        this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total");
        this.uuid = ApiTypeHelper.requireNonNull(builder.uuid, this, "uuid");
    }

    public static IndicesStats of(Function<IndicesStats.Builder, ObjectBuilder<IndicesStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code primaries}
     */
    @Nonnull
    public final IndexStats primaries() {
        return this.primaries;
    }

    /**
     * The statistics for individual shards.
     * <p>
     * API name: {@code shards}
     * </p>
     */
    @Nonnull
    public final Map<String, List<IndexShardStats>> shards() {
        return this.shards;
    }

    /**
     * Required - API name: {@code total}
     */
    @Nonnull
    public final IndexStats total() {
        return this.total;
    }

    /**
     * Required - API name: {@code uuid}
     */
    @Nonnull
    public final String uuid() {
        return this.uuid;
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
        generator.writeKey("primaries");
        this.primaries.serialize(generator, mapper);

        if (ApiTypeHelper.isDefined(this.shards)) {
            generator.writeKey("shards");
            generator.writeStartObject();
            for (Map.Entry<String, List<IndexShardStats>> item0 : this.shards.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.writeStartArray();
                if (item0.getValue() != null) {
                    for (IndexShardStats item1 : item0.getValue()) {
                        item1.serialize(generator, mapper);
                    }
                }
                generator.writeEnd();
            }
            generator.writeEnd();
        }

        generator.writeKey("total");
        this.total.serialize(generator, mapper);

        generator.writeKey("uuid");
        generator.write(this.uuid);
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
     * Builder for {@link IndicesStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndicesStats> {
        private IndexStats primaries;
        @Nullable
        private Map<String, List<IndexShardStats>> shards;
        private IndexStats total;
        private String uuid;

        public Builder() {}

        private Builder(IndicesStats o) {
            this.primaries = o.primaries;
            this.shards = _mapCopy(o.shards);
            this.total = o.total;
            this.uuid = o.uuid;
        }

        private Builder(Builder o) {
            this.primaries = o.primaries;
            this.shards = _mapCopy(o.shards);
            this.total = o.total;
            this.uuid = o.uuid;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code primaries}
         */
        @Nonnull
        public final Builder primaries(IndexStats value) {
            this.primaries = value;
            return this;
        }

        /**
         * Required - API name: {@code primaries}
         */
        @Nonnull
        public final Builder primaries(Function<IndexStats.Builder, ObjectBuilder<IndexStats>> fn) {
            return primaries(fn.apply(new IndexStats.Builder()).build());
        }

        /**
         * The statistics for individual shards.
         * <p>
         * API name: {@code shards}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(Map<String, List<IndexShardStats>> map) {
            this.shards = _mapPutAll(this.shards, map);
            return this;
        }

        /**
         * The statistics for individual shards.
         * <p>
         * API name: {@code shards}
         * </p>
         *
         * <p>
         * Adds an entry to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(String key, List<IndexShardStats> value) {
            this.shards = _mapPut(this.shards, key, value);
            return this;
        }

        /**
         * Required - API name: {@code total}
         */
        @Nonnull
        public final Builder total(IndexStats value) {
            this.total = value;
            return this;
        }

        /**
         * Required - API name: {@code total}
         */
        @Nonnull
        public final Builder total(Function<IndexStats.Builder, ObjectBuilder<IndexStats>> fn) {
            return total(fn.apply(new IndexStats.Builder()).build());
        }

        /**
         * Required - API name: {@code uuid}
         */
        @Nonnull
        public final Builder uuid(String value) {
            this.uuid = value;
            return this;
        }

        /**
         * Builds a {@link IndicesStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndicesStats build() {
            _checkSingleUse();

            return new IndicesStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndicesStats}
     */
    public static final JsonpDeserializer<IndicesStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndicesStats::setupIndicesStatsDeserializer
    );

    protected static void setupIndicesStatsDeserializer(ObjectDeserializer<IndicesStats.Builder> op) {
        op.add(Builder::primaries, IndexStats._DESERIALIZER, "primaries");
        op.add(
            Builder::shards,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.arrayDeserializer(IndexShardStats._DESERIALIZER)),
            "shards"
        );
        op.add(Builder::total, IndexStats._DESERIALIZER, "total");
        op.add(Builder::uuid, JsonpDeserializer.stringDeserializer(), "uuid");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.primaries.hashCode();
        result = 31 * result + Objects.hashCode(this.shards);
        result = 31 * result + this.total.hashCode();
        result = 31 * result + this.uuid.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndicesStats other = (IndicesStats) o;
        return this.primaries.equals(other.primaries)
            && Objects.equals(this.shards, other.shards)
            && this.total.equals(other.total)
            && this.uuid.equals(other.uuid);
    }
}
