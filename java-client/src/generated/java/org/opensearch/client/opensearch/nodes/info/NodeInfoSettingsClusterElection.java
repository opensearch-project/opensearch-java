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

// typedef: nodes.info.NodeInfoSettingsClusterElection

/**
 * The cluster election strategy configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoSettingsClusterElection
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<NodeInfoSettingsClusterElection.Builder, NodeInfoSettingsClusterElection> {

    @Nonnull
    private final String strategy;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoSettingsClusterElection(Builder builder) {
        this.strategy = ApiTypeHelper.requireNonNull(builder.strategy, this, "strategy");
    }

    public static NodeInfoSettingsClusterElection of(
        Function<NodeInfoSettingsClusterElection.Builder, ObjectBuilder<NodeInfoSettingsClusterElection>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code strategy}
     */
    @Nonnull
    public final String strategy() {
        return this.strategy;
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
        generator.writeKey("strategy");
        generator.write(this.strategy);
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
     * Builder for {@link NodeInfoSettingsClusterElection}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoSettingsClusterElection> {
        private String strategy;

        public Builder() {}

        private Builder(NodeInfoSettingsClusterElection o) {
            this.strategy = o.strategy;
        }

        private Builder(Builder o) {
            this.strategy = o.strategy;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code strategy}
         */
        @Nonnull
        public final Builder strategy(String value) {
            this.strategy = value;
            return this;
        }

        /**
         * Builds a {@link NodeInfoSettingsClusterElection}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoSettingsClusterElection build() {
            _checkSingleUse();

            return new NodeInfoSettingsClusterElection(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoSettingsClusterElection}
     */
    public static final JsonpDeserializer<NodeInfoSettingsClusterElection> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoSettingsClusterElection::setupNodeInfoSettingsClusterElectionDeserializer
    );

    protected static void setupNodeInfoSettingsClusterElectionDeserializer(ObjectDeserializer<NodeInfoSettingsClusterElection.Builder> op) {
        op.add(Builder::strategy, JsonpDeserializer.stringDeserializer(), "strategy");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.strategy.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoSettingsClusterElection other = (NodeInfoSettingsClusterElection) o;
        return this.strategy.equals(other.strategy);
    }
}
