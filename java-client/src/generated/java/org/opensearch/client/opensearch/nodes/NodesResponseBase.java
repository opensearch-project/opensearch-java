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

package org.opensearch.client.opensearch.nodes;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.NodeStatistics;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: nodes.NodesResponseBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class NodesResponseBase implements PlainJsonSerializable {

    @Nullable
    private final NodeStatistics nodeStats;

    // ---------------------------------------------------------------------------------------------

    protected NodesResponseBase(AbstractBuilder<?> builder) {
        this.nodeStats = builder.nodeStats;
    }

    /**
     * Contains statistics about the number of nodes selected by the request's node filters.
     * <p>
     * API name: {@code _nodes}
     * </p>
     */
    @Nullable
    public final NodeStatistics nodeStats() {
        return this.nodeStats;
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
        if (this.nodeStats != null) {
            generator.writeKey("_nodes");
            this.nodeStats.serialize(generator, mapper);
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        @Nullable
        private NodeStatistics nodeStats;

        protected AbstractBuilder() {}

        protected AbstractBuilder(NodesResponseBase o) {
            this.nodeStats = o.nodeStats;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            this.nodeStats = o.nodeStats;
        }

        @Nonnull
        protected abstract BuilderT self();

        /**
         * Contains statistics about the number of nodes selected by the request's node filters.
         * <p>
         * API name: {@code _nodes}
         * </p>
         */
        @Nonnull
        public final BuilderT nodeStats(@Nullable NodeStatistics value) {
            this.nodeStats = value;
            return self();
        }

        /**
         * Contains statistics about the number of nodes selected by the request's node filters.
         * <p>
         * API name: {@code _nodes}
         * </p>
         */
        @Nonnull
        public final BuilderT nodeStats(Function<NodeStatistics.Builder, ObjectBuilder<NodeStatistics>> fn) {
            return nodeStats(fn.apply(new NodeStatistics.Builder()).build());
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupNodesResponseBaseDeserializer(ObjectDeserializer<BuilderT> op) {
        op.add(AbstractBuilder::nodeStats, NodeStatistics._DESERIALIZER, "_nodes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.nodeStats);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodesResponseBase other = (NodesResponseBase) o;
        return Objects.equals(this.nodeStats, other.nodeStats);
    }
}
