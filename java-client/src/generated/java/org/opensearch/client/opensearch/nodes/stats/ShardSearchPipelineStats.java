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

// typedef: nodes.stats.ShardSearchPipelineStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardSearchPipelineStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardSearchPipelineStats.Builder, ShardSearchPipelineStats> {

    @Nonnull
    private final Map<String, ShardSearchPipelinePerPipelineStats> pipelines;

    @Nullable
    private final ShardSearchPipelineOperationStats totalRequest;

    @Nullable
    private final ShardSearchPipelineOperationStats totalResponse;

    // ---------------------------------------------------------------------------------------------

    private ShardSearchPipelineStats(Builder builder) {
        this.pipelines = ApiTypeHelper.unmodifiable(builder.pipelines);
        this.totalRequest = builder.totalRequest;
        this.totalResponse = builder.totalResponse;
    }

    public static ShardSearchPipelineStats of(Function<ShardSearchPipelineStats.Builder, ObjectBuilder<ShardSearchPipelineStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code pipelines}
     */
    @Nonnull
    public final Map<String, ShardSearchPipelinePerPipelineStats> pipelines() {
        return this.pipelines;
    }

    /**
     * API name: {@code total_request}
     */
    @Nullable
    public final ShardSearchPipelineOperationStats totalRequest() {
        return this.totalRequest;
    }

    /**
     * API name: {@code total_response}
     */
    @Nullable
    public final ShardSearchPipelineOperationStats totalResponse() {
        return this.totalResponse;
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
        if (ApiTypeHelper.isDefined(this.pipelines)) {
            generator.writeKey("pipelines");
            generator.writeStartObject();
            for (Map.Entry<String, ShardSearchPipelinePerPipelineStats> item0 : this.pipelines.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.totalRequest != null) {
            generator.writeKey("total_request");
            this.totalRequest.serialize(generator, mapper);
        }

        if (this.totalResponse != null) {
            generator.writeKey("total_response");
            this.totalResponse.serialize(generator, mapper);
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
     * Builder for {@link ShardSearchPipelineStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardSearchPipelineStats> {
        @Nullable
        private Map<String, ShardSearchPipelinePerPipelineStats> pipelines;
        @Nullable
        private ShardSearchPipelineOperationStats totalRequest;
        @Nullable
        private ShardSearchPipelineOperationStats totalResponse;

        public Builder() {}

        private Builder(ShardSearchPipelineStats o) {
            this.pipelines = _mapCopy(o.pipelines);
            this.totalRequest = o.totalRequest;
            this.totalResponse = o.totalResponse;
        }

        private Builder(Builder o) {
            this.pipelines = _mapCopy(o.pipelines);
            this.totalRequest = o.totalRequest;
            this.totalResponse = o.totalResponse;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code pipelines}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>pipelines</code>.
         * </p>
         */
        @Nonnull
        public final Builder pipelines(Map<String, ShardSearchPipelinePerPipelineStats> map) {
            this.pipelines = _mapPutAll(this.pipelines, map);
            return this;
        }

        /**
         * API name: {@code pipelines}
         *
         * <p>
         * Adds an entry to <code>pipelines</code>.
         * </p>
         */
        @Nonnull
        public final Builder pipelines(String key, ShardSearchPipelinePerPipelineStats value) {
            this.pipelines = _mapPut(this.pipelines, key, value);
            return this;
        }

        /**
         * API name: {@code pipelines}
         *
         * <p>
         * Adds a value to <code>pipelines</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder pipelines(
            String key,
            Function<ShardSearchPipelinePerPipelineStats.Builder, ObjectBuilder<ShardSearchPipelinePerPipelineStats>> fn
        ) {
            return pipelines(key, fn.apply(new ShardSearchPipelinePerPipelineStats.Builder()).build());
        }

        /**
         * API name: {@code total_request}
         */
        @Nonnull
        public final Builder totalRequest(@Nullable ShardSearchPipelineOperationStats value) {
            this.totalRequest = value;
            return this;
        }

        /**
         * API name: {@code total_request}
         */
        @Nonnull
        public final Builder totalRequest(
            Function<ShardSearchPipelineOperationStats.Builder, ObjectBuilder<ShardSearchPipelineOperationStats>> fn
        ) {
            return totalRequest(fn.apply(new ShardSearchPipelineOperationStats.Builder()).build());
        }

        /**
         * API name: {@code total_response}
         */
        @Nonnull
        public final Builder totalResponse(@Nullable ShardSearchPipelineOperationStats value) {
            this.totalResponse = value;
            return this;
        }

        /**
         * API name: {@code total_response}
         */
        @Nonnull
        public final Builder totalResponse(
            Function<ShardSearchPipelineOperationStats.Builder, ObjectBuilder<ShardSearchPipelineOperationStats>> fn
        ) {
            return totalResponse(fn.apply(new ShardSearchPipelineOperationStats.Builder()).build());
        }

        /**
         * Builds a {@link ShardSearchPipelineStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardSearchPipelineStats build() {
            _checkSingleUse();

            return new ShardSearchPipelineStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardSearchPipelineStats}
     */
    public static final JsonpDeserializer<ShardSearchPipelineStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardSearchPipelineStats::setupShardSearchPipelineStatsDeserializer
    );

    protected static void setupShardSearchPipelineStatsDeserializer(ObjectDeserializer<ShardSearchPipelineStats.Builder> op) {
        op.add(Builder::pipelines, JsonpDeserializer.stringMapDeserializer(ShardSearchPipelinePerPipelineStats._DESERIALIZER), "pipelines");
        op.add(Builder::totalRequest, ShardSearchPipelineOperationStats._DESERIALIZER, "total_request");
        op.add(Builder::totalResponse, ShardSearchPipelineOperationStats._DESERIALIZER, "total_response");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.pipelines);
        result = 31 * result + Objects.hashCode(this.totalRequest);
        result = 31 * result + Objects.hashCode(this.totalResponse);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardSearchPipelineStats other = (ShardSearchPipelineStats) o;
        return Objects.equals(this.pipelines, other.pipelines)
            && Objects.equals(this.totalRequest, other.totalRequest)
            && Objects.equals(this.totalResponse, other.totalResponse);
    }
}
