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

package org.opensearch.client.opensearch.nodes.info;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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

// typedef: nodes.info.NodeInfoIngest

/**
 * The ingest pipeline configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoIngest implements PlainJsonSerializable, ToCopyableBuilder<NodeInfoIngest.Builder, NodeInfoIngest> {

    @Nonnull
    private final List<NodeInfoIngestProcessor> processors;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoIngest(Builder builder) {
        this.processors = ApiTypeHelper.unmodifiableRequired(builder.processors, this, "processors");
    }

    public static NodeInfoIngest of(Function<NodeInfoIngest.Builder, ObjectBuilder<NodeInfoIngest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The list of configured ingest processors.
     * <p>
     * API name: {@code processors}
     * </p>
     */
    @Nonnull
    public final List<NodeInfoIngestProcessor> processors() {
        return this.processors;
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
        generator.writeKey("processors");
        generator.writeStartArray();
        for (NodeInfoIngestProcessor item0 : this.processors) {
            item0.serialize(generator, mapper);
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
     * Builder for {@link NodeInfoIngest}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoIngest> {
        private List<NodeInfoIngestProcessor> processors;

        public Builder() {}

        private Builder(NodeInfoIngest o) {
            this.processors = _listCopy(o.processors);
        }

        private Builder(Builder o) {
            this.processors = _listCopy(o.processors);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The list of configured ingest processors.
         * <p>
         * API name: {@code processors}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>processors</code>.
         * </p>
         */
        @Nonnull
        public final Builder processors(List<NodeInfoIngestProcessor> list) {
            this.processors = _listAddAll(this.processors, list);
            return this;
        }

        /**
         * Required - The list of configured ingest processors.
         * <p>
         * API name: {@code processors}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>processors</code>.
         * </p>
         */
        @Nonnull
        public final Builder processors(NodeInfoIngestProcessor value, NodeInfoIngestProcessor... values) {
            this.processors = _listAdd(this.processors, value, values);
            return this;
        }

        /**
         * Required - The list of configured ingest processors.
         * <p>
         * API name: {@code processors}
         * </p>
         *
         * <p>
         * Adds a value to <code>processors</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder processors(Function<NodeInfoIngestProcessor.Builder, ObjectBuilder<NodeInfoIngestProcessor>> fn) {
            return processors(fn.apply(new NodeInfoIngestProcessor.Builder()).build());
        }

        /**
         * Builds a {@link NodeInfoIngest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoIngest build() {
            _checkSingleUse();

            return new NodeInfoIngest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoIngest}
     */
    public static final JsonpDeserializer<NodeInfoIngest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoIngest::setupNodeInfoIngestDeserializer
    );

    protected static void setupNodeInfoIngestDeserializer(ObjectDeserializer<NodeInfoIngest.Builder> op) {
        op.add(Builder::processors, JsonpDeserializer.arrayDeserializer(NodeInfoIngestProcessor._DESERIALIZER), "processors");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.processors.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoIngest other = (NodeInfoIngest) o;
        return this.processors.equals(other.processors);
    }
}
