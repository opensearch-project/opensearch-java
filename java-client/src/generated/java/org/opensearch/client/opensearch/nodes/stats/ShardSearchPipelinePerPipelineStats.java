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
import java.util.List;
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

// typedef: nodes.stats.ShardSearchPipelinePerPipelineStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardSearchPipelinePerPipelineStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardSearchPipelinePerPipelineStats.Builder, ShardSearchPipelinePerPipelineStats> {

    @Nullable
    private final ShardSearchPipelineOperationStats request;

    @Nonnull
    private final List<ShardSearchPipelinePerPipelineProcessorStats> requestProcessors;

    @Nullable
    private final ShardSearchPipelineOperationStats response;

    @Nonnull
    private final List<ShardSearchPipelinePerPipelineProcessorStats> responseProcessors;

    // ---------------------------------------------------------------------------------------------

    private ShardSearchPipelinePerPipelineStats(Builder builder) {
        this.request = builder.request;
        this.requestProcessors = ApiTypeHelper.unmodifiable(builder.requestProcessors);
        this.response = builder.response;
        this.responseProcessors = ApiTypeHelper.unmodifiable(builder.responseProcessors);
    }

    public static ShardSearchPipelinePerPipelineStats of(
        Function<ShardSearchPipelinePerPipelineStats.Builder, ObjectBuilder<ShardSearchPipelinePerPipelineStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code request}
     */
    @Nullable
    public final ShardSearchPipelineOperationStats request() {
        return this.request;
    }

    /**
     * API name: {@code request_processors}
     */
    @Nonnull
    public final List<ShardSearchPipelinePerPipelineProcessorStats> requestProcessors() {
        return this.requestProcessors;
    }

    /**
     * API name: {@code response}
     */
    @Nullable
    public final ShardSearchPipelineOperationStats response() {
        return this.response;
    }

    /**
     * API name: {@code response_processors}
     */
    @Nonnull
    public final List<ShardSearchPipelinePerPipelineProcessorStats> responseProcessors() {
        return this.responseProcessors;
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
        if (this.request != null) {
            generator.writeKey("request");
            this.request.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.requestProcessors)) {
            generator.writeKey("request_processors");
            generator.writeStartArray();
            for (ShardSearchPipelinePerPipelineProcessorStats item0 : this.requestProcessors) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.response != null) {
            generator.writeKey("response");
            this.response.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.responseProcessors)) {
            generator.writeKey("response_processors");
            generator.writeStartArray();
            for (ShardSearchPipelinePerPipelineProcessorStats item0 : this.responseProcessors) {
                item0.serialize(generator, mapper);
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
     * Builder for {@link ShardSearchPipelinePerPipelineStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardSearchPipelinePerPipelineStats> {
        @Nullable
        private ShardSearchPipelineOperationStats request;
        @Nullable
        private List<ShardSearchPipelinePerPipelineProcessorStats> requestProcessors;
        @Nullable
        private ShardSearchPipelineOperationStats response;
        @Nullable
        private List<ShardSearchPipelinePerPipelineProcessorStats> responseProcessors;

        public Builder() {}

        private Builder(ShardSearchPipelinePerPipelineStats o) {
            this.request = o.request;
            this.requestProcessors = _listCopy(o.requestProcessors);
            this.response = o.response;
            this.responseProcessors = _listCopy(o.responseProcessors);
        }

        private Builder(Builder o) {
            this.request = o.request;
            this.requestProcessors = _listCopy(o.requestProcessors);
            this.response = o.response;
            this.responseProcessors = _listCopy(o.responseProcessors);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code request}
         */
        @Nonnull
        public final Builder request(@Nullable ShardSearchPipelineOperationStats value) {
            this.request = value;
            return this;
        }

        /**
         * API name: {@code request}
         */
        @Nonnull
        public final Builder request(
            Function<ShardSearchPipelineOperationStats.Builder, ObjectBuilder<ShardSearchPipelineOperationStats>> fn
        ) {
            return request(fn.apply(new ShardSearchPipelineOperationStats.Builder()).build());
        }

        /**
         * API name: {@code request_processors}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>requestProcessors</code>.
         * </p>
         */
        @Nonnull
        public final Builder requestProcessors(List<ShardSearchPipelinePerPipelineProcessorStats> list) {
            this.requestProcessors = _listAddAll(this.requestProcessors, list);
            return this;
        }

        /**
         * API name: {@code request_processors}
         *
         * <p>
         * Adds one or more values to <code>requestProcessors</code>.
         * </p>
         */
        @Nonnull
        public final Builder requestProcessors(
            ShardSearchPipelinePerPipelineProcessorStats value,
            ShardSearchPipelinePerPipelineProcessorStats... values
        ) {
            this.requestProcessors = _listAdd(this.requestProcessors, value, values);
            return this;
        }

        /**
         * API name: {@code request_processors}
         *
         * <p>
         * Adds a value to <code>requestProcessors</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder requestProcessors(
            Function<ShardSearchPipelinePerPipelineProcessorStats.Builder, ObjectBuilder<ShardSearchPipelinePerPipelineProcessorStats>> fn
        ) {
            return requestProcessors(fn.apply(new ShardSearchPipelinePerPipelineProcessorStats.Builder()).build());
        }

        /**
         * API name: {@code response}
         */
        @Nonnull
        public final Builder response(@Nullable ShardSearchPipelineOperationStats value) {
            this.response = value;
            return this;
        }

        /**
         * API name: {@code response}
         */
        @Nonnull
        public final Builder response(
            Function<ShardSearchPipelineOperationStats.Builder, ObjectBuilder<ShardSearchPipelineOperationStats>> fn
        ) {
            return response(fn.apply(new ShardSearchPipelineOperationStats.Builder()).build());
        }

        /**
         * API name: {@code response_processors}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>responseProcessors</code>.
         * </p>
         */
        @Nonnull
        public final Builder responseProcessors(List<ShardSearchPipelinePerPipelineProcessorStats> list) {
            this.responseProcessors = _listAddAll(this.responseProcessors, list);
            return this;
        }

        /**
         * API name: {@code response_processors}
         *
         * <p>
         * Adds one or more values to <code>responseProcessors</code>.
         * </p>
         */
        @Nonnull
        public final Builder responseProcessors(
            ShardSearchPipelinePerPipelineProcessorStats value,
            ShardSearchPipelinePerPipelineProcessorStats... values
        ) {
            this.responseProcessors = _listAdd(this.responseProcessors, value, values);
            return this;
        }

        /**
         * API name: {@code response_processors}
         *
         * <p>
         * Adds a value to <code>responseProcessors</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder responseProcessors(
            Function<ShardSearchPipelinePerPipelineProcessorStats.Builder, ObjectBuilder<ShardSearchPipelinePerPipelineProcessorStats>> fn
        ) {
            return responseProcessors(fn.apply(new ShardSearchPipelinePerPipelineProcessorStats.Builder()).build());
        }

        /**
         * Builds a {@link ShardSearchPipelinePerPipelineStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardSearchPipelinePerPipelineStats build() {
            _checkSingleUse();

            return new ShardSearchPipelinePerPipelineStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardSearchPipelinePerPipelineStats}
     */
    public static final JsonpDeserializer<ShardSearchPipelinePerPipelineStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardSearchPipelinePerPipelineStats::setupShardSearchPipelinePerPipelineStatsDeserializer
    );

    protected static void setupShardSearchPipelinePerPipelineStatsDeserializer(
        ObjectDeserializer<ShardSearchPipelinePerPipelineStats.Builder> op
    ) {
        op.add(Builder::request, ShardSearchPipelineOperationStats._DESERIALIZER, "request");
        op.add(
            Builder::requestProcessors,
            JsonpDeserializer.arrayDeserializer(ShardSearchPipelinePerPipelineProcessorStats._DESERIALIZER),
            "request_processors"
        );
        op.add(Builder::response, ShardSearchPipelineOperationStats._DESERIALIZER, "response");
        op.add(
            Builder::responseProcessors,
            JsonpDeserializer.arrayDeserializer(ShardSearchPipelinePerPipelineProcessorStats._DESERIALIZER),
            "response_processors"
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.request);
        result = 31 * result + Objects.hashCode(this.requestProcessors);
        result = 31 * result + Objects.hashCode(this.response);
        result = 31 * result + Objects.hashCode(this.responseProcessors);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardSearchPipelinePerPipelineStats other = (ShardSearchPipelinePerPipelineStats) o;
        return Objects.equals(this.request, other.request)
            && Objects.equals(this.requestProcessors, other.requestProcessors)
            && Objects.equals(this.response, other.response)
            && Objects.equals(this.responseProcessors, other.responseProcessors);
    }
}
