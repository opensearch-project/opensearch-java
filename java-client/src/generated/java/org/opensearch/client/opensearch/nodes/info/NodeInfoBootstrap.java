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

// typedef: nodes.info.NodeInfoBootstrap

/**
 * The bootstrap configuration settings for the node.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoBootstrap implements PlainJsonSerializable, ToCopyableBuilder<NodeInfoBootstrap.Builder, NodeInfoBootstrap> {

    @Nonnull
    private final String memoryLock;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoBootstrap(Builder builder) {
        this.memoryLock = ApiTypeHelper.requireNonNull(builder.memoryLock, this, "memoryLock");
    }

    public static NodeInfoBootstrap of(Function<NodeInfoBootstrap.Builder, ObjectBuilder<NodeInfoBootstrap>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The memory lock setting for the bootstrap process.
     * <p>
     * API name: {@code memory_lock}
     * </p>
     */
    @Nonnull
    public final String memoryLock() {
        return this.memoryLock;
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
        generator.writeKey("memory_lock");
        generator.write(this.memoryLock);
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
     * Builder for {@link NodeInfoBootstrap}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoBootstrap> {
        private String memoryLock;

        public Builder() {}

        private Builder(NodeInfoBootstrap o) {
            this.memoryLock = o.memoryLock;
        }

        private Builder(Builder o) {
            this.memoryLock = o.memoryLock;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The memory lock setting for the bootstrap process.
         * <p>
         * API name: {@code memory_lock}
         * </p>
         */
        @Nonnull
        public final Builder memoryLock(String value) {
            this.memoryLock = value;
            return this;
        }

        /**
         * Builds a {@link NodeInfoBootstrap}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoBootstrap build() {
            _checkSingleUse();

            return new NodeInfoBootstrap(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoBootstrap}
     */
    public static final JsonpDeserializer<NodeInfoBootstrap> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoBootstrap::setupNodeInfoBootstrapDeserializer
    );

    protected static void setupNodeInfoBootstrapDeserializer(ObjectDeserializer<NodeInfoBootstrap.Builder> op) {
        op.add(Builder::memoryLock, JsonpDeserializer.stringDeserializer(), "memory_lock");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.memoryLock.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoBootstrap other = (NodeInfoBootstrap) o;
        return this.memoryLock.equals(other.memoryLock);
    }
}
