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

package org.opensearch.client.opensearch.cluster.reroute;

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

// typedef: cluster.reroute.CommandMoveAction

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CommandMoveAction implements PlainJsonSerializable, ToCopyableBuilder<CommandMoveAction.Builder, CommandMoveAction> {

    @Nonnull
    private final String fromNode;

    @Nonnull
    private final String index;

    private final int shard;

    @Nonnull
    private final String toNode;

    // ---------------------------------------------------------------------------------------------

    private CommandMoveAction(Builder builder) {
        this.fromNode = ApiTypeHelper.requireNonNull(builder.fromNode, this, "fromNode");
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.shard = ApiTypeHelper.requireNonNull(builder.shard, this, "shard");
        this.toNode = ApiTypeHelper.requireNonNull(builder.toNode, this, "toNode");
    }

    public static CommandMoveAction of(Function<CommandMoveAction.Builder, ObjectBuilder<CommandMoveAction>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The node to move the shard from
     * <p>
     * API name: {@code from_node}
     * </p>
     */
    @Nonnull
    public final String fromNode() {
        return this.fromNode;
    }

    /**
     * Required - API name: {@code index}
     */
    @Nonnull
    public final String index() {
        return this.index;
    }

    /**
     * Required - API name: {@code shard}
     */
    public final int shard() {
        return this.shard;
    }

    /**
     * Required - The node to move the shard to
     * <p>
     * API name: {@code to_node}
     * </p>
     */
    @Nonnull
    public final String toNode() {
        return this.toNode;
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
        generator.writeKey("from_node");
        generator.write(this.fromNode);

        generator.writeKey("index");
        generator.write(this.index);

        generator.writeKey("shard");
        generator.write(this.shard);

        generator.writeKey("to_node");
        generator.write(this.toNode);
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
     * Builder for {@link CommandMoveAction}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CommandMoveAction> {
        private String fromNode;
        private String index;
        private Integer shard;
        private String toNode;

        public Builder() {}

        private Builder(CommandMoveAction o) {
            this.fromNode = o.fromNode;
            this.index = o.index;
            this.shard = o.shard;
            this.toNode = o.toNode;
        }

        private Builder(Builder o) {
            this.fromNode = o.fromNode;
            this.index = o.index;
            this.shard = o.shard;
            this.toNode = o.toNode;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The node to move the shard from
         * <p>
         * API name: {@code from_node}
         * </p>
         */
        @Nonnull
        public final Builder fromNode(String value) {
            this.fromNode = value;
            return this;
        }

        /**
         * Required - API name: {@code index}
         */
        @Nonnull
        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        /**
         * Required - API name: {@code shard}
         */
        @Nonnull
        public final Builder shard(int value) {
            this.shard = value;
            return this;
        }

        /**
         * Required - The node to move the shard to
         * <p>
         * API name: {@code to_node}
         * </p>
         */
        @Nonnull
        public final Builder toNode(String value) {
            this.toNode = value;
            return this;
        }

        /**
         * Builds a {@link CommandMoveAction}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CommandMoveAction build() {
            _checkSingleUse();

            return new CommandMoveAction(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CommandMoveAction}
     */
    public static final JsonpDeserializer<CommandMoveAction> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CommandMoveAction::setupCommandMoveActionDeserializer
    );

    protected static void setupCommandMoveActionDeserializer(ObjectDeserializer<CommandMoveAction.Builder> op) {
        op.add(Builder::fromNode, JsonpDeserializer.stringDeserializer(), "from_node");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::shard, JsonpDeserializer.integerDeserializer(), "shard");
        op.add(Builder::toNode, JsonpDeserializer.stringDeserializer(), "to_node");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.fromNode.hashCode();
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Integer.hashCode(this.shard);
        result = 31 * result + this.toNode.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CommandMoveAction other = (CommandMoveAction) o;
        return this.fromNode.equals(other.fromNode)
            && this.index.equals(other.index)
            && this.shard == other.shard
            && this.toNode.equals(other.toNode);
    }
}
