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
import org.opensearch.client.opensearch._types.ShardStatistics;
import org.opensearch.client.opensearch.indices.stats.AllIndicesStats;
import org.opensearch.client.opensearch.indices.stats.IndicesStats;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.stats.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndicesStatsResponse implements PlainJsonSerializable, ToCopyableBuilder<IndicesStatsResponse.Builder, IndicesStatsResponse> {

    @Nonnull
    private final AllIndicesStats all;

    @Nonnull
    private final Map<String, IndicesStats> indices;

    @Nonnull
    private final ShardStatistics shards;

    // ---------------------------------------------------------------------------------------------

    private IndicesStatsResponse(Builder builder) {
        this.all = ApiTypeHelper.requireNonNull(builder.all, this, "all");
        this.indices = ApiTypeHelper.unmodifiable(builder.indices);
        this.shards = ApiTypeHelper.requireNonNull(builder.shards, this, "shards");
    }

    public static IndicesStatsResponse of(Function<IndicesStatsResponse.Builder, ObjectBuilder<IndicesStatsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code _all}
     */
    @Nonnull
    public final AllIndicesStats all() {
        return this.all;
    }

    /**
     * API name: {@code indices}
     */
    @Nonnull
    public final Map<String, IndicesStats> indices() {
        return this.indices;
    }

    /**
     * Required - API name: {@code _shards}
     */
    @Nonnull
    public final ShardStatistics shards() {
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
        generator.writeKey("_all");
        this.all.serialize(generator, mapper);

        if (ApiTypeHelper.isDefined(this.indices)) {
            generator.writeKey("indices");
            generator.writeStartObject();
            for (Map.Entry<String, IndicesStats> item0 : this.indices.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("_shards");
        this.shards.serialize(generator, mapper);
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
     * Builder for {@link IndicesStatsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndicesStatsResponse> {
        private AllIndicesStats all;
        @Nullable
        private Map<String, IndicesStats> indices;
        private ShardStatistics shards;

        public Builder() {}

        private Builder(IndicesStatsResponse o) {
            this.all = o.all;
            this.indices = _mapCopy(o.indices);
            this.shards = o.shards;
        }

        private Builder(Builder o) {
            this.all = o.all;
            this.indices = _mapCopy(o.indices);
            this.shards = o.shards;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code _all}
         */
        @Nonnull
        public final Builder all(AllIndicesStats value) {
            this.all = value;
            return this;
        }

        /**
         * Required - API name: {@code _all}
         */
        @Nonnull
        public final Builder all(Function<AllIndicesStats.Builder, ObjectBuilder<AllIndicesStats>> fn) {
            return all(fn.apply(new AllIndicesStats.Builder()).build());
        }

        /**
         * API name: {@code indices}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(Map<String, IndicesStats> map) {
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
        public final Builder indices(String key, IndicesStats value) {
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
        public final Builder indices(String key, Function<IndicesStats.Builder, ObjectBuilder<IndicesStats>> fn) {
            return indices(key, fn.apply(new IndicesStats.Builder()).build());
        }

        /**
         * Required - API name: {@code _shards}
         */
        @Nonnull
        public final Builder shards(ShardStatistics value) {
            this.shards = value;
            return this;
        }

        /**
         * Required - API name: {@code _shards}
         */
        @Nonnull
        public final Builder shards(Function<ShardStatistics.Builder, ObjectBuilder<ShardStatistics>> fn) {
            return shards(fn.apply(new ShardStatistics.Builder()).build());
        }

        /**
         * Builds a {@link IndicesStatsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndicesStatsResponse build() {
            _checkSingleUse();

            return new IndicesStatsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndicesStatsResponse}
     */
    public static final JsonpDeserializer<IndicesStatsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndicesStatsResponse::setupIndicesStatsResponseDeserializer
    );

    protected static void setupIndicesStatsResponseDeserializer(ObjectDeserializer<IndicesStatsResponse.Builder> op) {
        op.add(Builder::all, AllIndicesStats._DESERIALIZER, "_all");
        op.add(Builder::indices, JsonpDeserializer.stringMapDeserializer(IndicesStats._DESERIALIZER), "indices");
        op.add(Builder::shards, ShardStatistics._DESERIALIZER, "_shards");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.all.hashCode();
        result = 31 * result + Objects.hashCode(this.indices);
        result = 31 * result + this.shards.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndicesStatsResponse other = (IndicesStatsResponse) o;
        return this.all.equals(other.all) && Objects.equals(this.indices, other.indices) && this.shards.equals(other.shards);
    }
}
