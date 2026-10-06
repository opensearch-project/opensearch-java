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

// typedef: nodes.stats.ShardSearchPipelineSystemGeneratedFactories

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardSearchPipelineSystemGeneratedFactories
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardSearchPipelineSystemGeneratedFactories.Builder, ShardSearchPipelineSystemGeneratedFactories> {

    @Nonnull
    private final List<ShardSearchPipelineFactoryStats> requestProcessorFactories;

    @Nonnull
    private final List<ShardSearchPipelineFactoryStats> responseProcessorFactories;

    // ---------------------------------------------------------------------------------------------

    private ShardSearchPipelineSystemGeneratedFactories(Builder builder) {
        this.requestProcessorFactories = ApiTypeHelper.unmodifiable(builder.requestProcessorFactories);
        this.responseProcessorFactories = ApiTypeHelper.unmodifiable(builder.responseProcessorFactories);
    }

    public static ShardSearchPipelineSystemGeneratedFactories of(
        Function<ShardSearchPipelineSystemGeneratedFactories.Builder, ObjectBuilder<ShardSearchPipelineSystemGeneratedFactories>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code request_processor_factories}
     */
    @Nonnull
    public final List<ShardSearchPipelineFactoryStats> requestProcessorFactories() {
        return this.requestProcessorFactories;
    }

    /**
     * API name: {@code response_processor_factories}
     */
    @Nonnull
    public final List<ShardSearchPipelineFactoryStats> responseProcessorFactories() {
        return this.responseProcessorFactories;
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
        if (ApiTypeHelper.isDefined(this.requestProcessorFactories)) {
            generator.writeKey("request_processor_factories");
            generator.writeStartArray();
            for (ShardSearchPipelineFactoryStats item0 : this.requestProcessorFactories) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.responseProcessorFactories)) {
            generator.writeKey("response_processor_factories");
            generator.writeStartArray();
            for (ShardSearchPipelineFactoryStats item0 : this.responseProcessorFactories) {
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
     * Builder for {@link ShardSearchPipelineSystemGeneratedFactories}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardSearchPipelineSystemGeneratedFactories> {
        @Nullable
        private List<ShardSearchPipelineFactoryStats> requestProcessorFactories;
        @Nullable
        private List<ShardSearchPipelineFactoryStats> responseProcessorFactories;

        public Builder() {}

        private Builder(ShardSearchPipelineSystemGeneratedFactories o) {
            this.requestProcessorFactories = _listCopy(o.requestProcessorFactories);
            this.responseProcessorFactories = _listCopy(o.responseProcessorFactories);
        }

        private Builder(Builder o) {
            this.requestProcessorFactories = _listCopy(o.requestProcessorFactories);
            this.responseProcessorFactories = _listCopy(o.responseProcessorFactories);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code request_processor_factories}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>requestProcessorFactories</code>.
         * </p>
         */
        @Nonnull
        public final Builder requestProcessorFactories(List<ShardSearchPipelineFactoryStats> list) {
            this.requestProcessorFactories = _listAddAll(this.requestProcessorFactories, list);
            return this;
        }

        /**
         * API name: {@code request_processor_factories}
         *
         * <p>
         * Adds one or more values to <code>requestProcessorFactories</code>.
         * </p>
         */
        @Nonnull
        public final Builder requestProcessorFactories(ShardSearchPipelineFactoryStats value, ShardSearchPipelineFactoryStats... values) {
            this.requestProcessorFactories = _listAdd(this.requestProcessorFactories, value, values);
            return this;
        }

        /**
         * API name: {@code request_processor_factories}
         *
         * <p>
         * Adds a value to <code>requestProcessorFactories</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder requestProcessorFactories(
            Function<ShardSearchPipelineFactoryStats.Builder, ObjectBuilder<ShardSearchPipelineFactoryStats>> fn
        ) {
            return requestProcessorFactories(fn.apply(new ShardSearchPipelineFactoryStats.Builder()).build());
        }

        /**
         * API name: {@code response_processor_factories}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>responseProcessorFactories</code>.
         * </p>
         */
        @Nonnull
        public final Builder responseProcessorFactories(List<ShardSearchPipelineFactoryStats> list) {
            this.responseProcessorFactories = _listAddAll(this.responseProcessorFactories, list);
            return this;
        }

        /**
         * API name: {@code response_processor_factories}
         *
         * <p>
         * Adds one or more values to <code>responseProcessorFactories</code>.
         * </p>
         */
        @Nonnull
        public final Builder responseProcessorFactories(ShardSearchPipelineFactoryStats value, ShardSearchPipelineFactoryStats... values) {
            this.responseProcessorFactories = _listAdd(this.responseProcessorFactories, value, values);
            return this;
        }

        /**
         * API name: {@code response_processor_factories}
         *
         * <p>
         * Adds a value to <code>responseProcessorFactories</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder responseProcessorFactories(
            Function<ShardSearchPipelineFactoryStats.Builder, ObjectBuilder<ShardSearchPipelineFactoryStats>> fn
        ) {
            return responseProcessorFactories(fn.apply(new ShardSearchPipelineFactoryStats.Builder()).build());
        }

        /**
         * Builds a {@link ShardSearchPipelineSystemGeneratedFactories}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardSearchPipelineSystemGeneratedFactories build() {
            _checkSingleUse();

            return new ShardSearchPipelineSystemGeneratedFactories(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardSearchPipelineSystemGeneratedFactories}
     */
    public static final JsonpDeserializer<ShardSearchPipelineSystemGeneratedFactories> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardSearchPipelineSystemGeneratedFactories::setupShardSearchPipelineSystemGeneratedFactoriesDeserializer
    );

    protected static void setupShardSearchPipelineSystemGeneratedFactoriesDeserializer(
        ObjectDeserializer<ShardSearchPipelineSystemGeneratedFactories.Builder> op
    ) {
        op.add(
            Builder::requestProcessorFactories,
            JsonpDeserializer.arrayDeserializer(ShardSearchPipelineFactoryStats._DESERIALIZER),
            "request_processor_factories"
        );
        op.add(
            Builder::responseProcessorFactories,
            JsonpDeserializer.arrayDeserializer(ShardSearchPipelineFactoryStats._DESERIALIZER),
            "response_processor_factories"
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.requestProcessorFactories);
        result = 31 * result + Objects.hashCode(this.responseProcessorFactories);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardSearchPipelineSystemGeneratedFactories other = (ShardSearchPipelineSystemGeneratedFactories) o;
        return Objects.equals(this.requestProcessorFactories, other.requestProcessorFactories)
            && Objects.equals(this.responseProcessorFactories, other.responseProcessorFactories);
    }
}
