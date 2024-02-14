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

// ----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
// ----------------------------------------------------

package org.opensearch.client.opensearch.nodes;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch._types.NodeStatistics;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

@JsonpDeserializable
public class NodesResponseBase implements JsonpSerializable {

    @Nullable private final NodeStatistics nodes;

    // ---------------------------------------------------------------------------------------------

    private NodesResponseBase(Builder builder) {
        this.nodes = builder.nodes;
    }

    public static NodesResponseBase of(
            Function<NodesResponseBase.Builder, ObjectBuilder<NodesResponseBase>> fn) {
        return fn.apply(new Builder()).build();
    }

    /** API name: {@code _nodes} */
    @Nullable
    public final NodeStatistics nodes() {
        return this.nodes;
    }

    /** Serialize this object to JSON. */
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.nodes != null) {
            generator.writeKey("_nodes");
            this.nodes.serialize(generator, mapper);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /** Builder for {@link NodesResponseBase}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<NodesResponseBase> {
        @Nullable private NodeStatistics nodes;

        /** API name: {@code _nodes} */
        public final Builder nodes(@Nullable NodeStatistics value) {
            this.nodes = value;
            return this;
        }

        /** API name: {@code _nodes} */
        public final Builder nodes(
                Function<NodeStatistics.Builder, ObjectBuilder<NodeStatistics>> fn) {
            return this.nodes(fn.apply(new NodeStatistics.Builder()).build());
        }

        /**
         * Builds a {@link NodesResponseBase}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public NodesResponseBase build() {
            _checkSingleUse();

            return new NodesResponseBase(this);
        }
    }
    // ---------------------------------------------------------------------------------------------

    /** Json deserializer for {@link NodesResponseBase} */
    public static final JsonpDeserializer<NodesResponseBase> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new, NodesResponseBase::setupNodesResponseBaseDeserializer);

    protected static void setupNodesResponseBaseDeserializer(
            ObjectDeserializer<NodesResponseBase.Builder> op) {
        op.add(Builder::nodes, NodeStatistics._DESERIALIZER, "_nodes");
    }
}
