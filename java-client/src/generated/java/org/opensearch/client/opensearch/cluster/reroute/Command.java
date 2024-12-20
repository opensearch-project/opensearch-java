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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.reroute.Command

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Command implements PlainJsonSerializable, ToCopyableBuilder<Command.Builder, Command> {

    @Nullable
    private final CommandAllocatePrimaryAction allocateEmptyPrimary;

    @Nullable
    private final CommandAllocateReplicaAction allocateReplica;

    @Nullable
    private final CommandAllocatePrimaryAction allocateStalePrimary;

    @Nullable
    private final CommandCancelAction cancel;

    @Nullable
    private final CommandMoveAction move;

    // ---------------------------------------------------------------------------------------------

    private Command(Builder builder) {
        this.allocateEmptyPrimary = builder.allocateEmptyPrimary;
        this.allocateReplica = builder.allocateReplica;
        this.allocateStalePrimary = builder.allocateStalePrimary;
        this.cancel = builder.cancel;
        this.move = builder.move;
    }

    public static Command of(Function<Command.Builder, ObjectBuilder<Command>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Allocate an empty primary shard to a node. Accepts the index and shard for index name and shard number, and node to allocate the
     * shard to. Using this command leads to a complete loss of all data that was indexed into this shard, if it was previously started. If
     * a node which has a copy of the data rejoins the cluster later on, that data will be deleted. To ensure that these implications are
     * well-understood, this command requires the flag accept_data_loss to be explicitly set to true.
     * <p>
     * API name: {@code allocate_empty_primary}
     * </p>
     */
    @Nullable
    public final CommandAllocatePrimaryAction allocateEmptyPrimary() {
        return this.allocateEmptyPrimary;
    }

    /**
     * Allocate an unassigned replica shard to a node. Accepts index and shard for index name and shard number, and node to allocate the
     * shard to. Takes allocation deciders into account.
     * <p>
     * API name: {@code allocate_replica}
     * </p>
     */
    @Nullable
    public final CommandAllocateReplicaAction allocateReplica() {
        return this.allocateReplica;
    }

    /**
     * Allocate a primary shard to a node that holds a stale copy. Accepts the index and shard for index name and shard number, and node to
     * allocate the shard to. Using this command may lead to data loss for the provided shard id. If a node which has the good copy of the
     * data rejoins the cluster later on, that data will be deleted or overwritten with the data of the stale copy that was forcefully
     * allocated with this command. To ensure that these implications are well-understood, this command requires the flag accept_data_loss
     * to be explicitly set to true.
     * <p>
     * API name: {@code allocate_stale_primary}
     * </p>
     */
    @Nullable
    public final CommandAllocatePrimaryAction allocateStalePrimary() {
        return this.allocateStalePrimary;
    }

    /**
     * Cancel allocation of a shard (or recovery). Accepts index and shard for index name and shard number, and node for the node to cancel
     * the shard allocation on. This can be used to force resynchronization of existing replicas from the primary shard by cancelling them
     * and allowing them to be reinitialized through the standard recovery process. By default only replica shard allocations can be
     * cancelled. If it is necessary to cancel the allocation of a primary shard then the allow_primary flag must also be included in the
     * request.
     * <p>
     * API name: {@code cancel}
     * </p>
     */
    @Nullable
    public final CommandCancelAction cancel() {
        return this.cancel;
    }

    /**
     * Move a started shard from one node to another node. Accepts index and shard for index name and shard number, from_node for the node
     * to move the shard from, and to_node for the node to move the shard to.
     * <p>
     * API name: {@code move}
     * </p>
     */
    @Nullable
    public final CommandMoveAction move() {
        return this.move;
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
        if (this.allocateEmptyPrimary != null) {
            generator.writeKey("allocate_empty_primary");
            this.allocateEmptyPrimary.serialize(generator, mapper);
        }

        if (this.allocateReplica != null) {
            generator.writeKey("allocate_replica");
            this.allocateReplica.serialize(generator, mapper);
        }

        if (this.allocateStalePrimary != null) {
            generator.writeKey("allocate_stale_primary");
            this.allocateStalePrimary.serialize(generator, mapper);
        }

        if (this.cancel != null) {
            generator.writeKey("cancel");
            this.cancel.serialize(generator, mapper);
        }

        if (this.move != null) {
            generator.writeKey("move");
            this.move.serialize(generator, mapper);
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
     * Builder for {@link Command}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Command> {
        @Nullable
        private CommandAllocatePrimaryAction allocateEmptyPrimary;
        @Nullable
        private CommandAllocateReplicaAction allocateReplica;
        @Nullable
        private CommandAllocatePrimaryAction allocateStalePrimary;
        @Nullable
        private CommandCancelAction cancel;
        @Nullable
        private CommandMoveAction move;

        public Builder() {}

        private Builder(Command o) {
            this.allocateEmptyPrimary = o.allocateEmptyPrimary;
            this.allocateReplica = o.allocateReplica;
            this.allocateStalePrimary = o.allocateStalePrimary;
            this.cancel = o.cancel;
            this.move = o.move;
        }

        private Builder(Builder o) {
            this.allocateEmptyPrimary = o.allocateEmptyPrimary;
            this.allocateReplica = o.allocateReplica;
            this.allocateStalePrimary = o.allocateStalePrimary;
            this.cancel = o.cancel;
            this.move = o.move;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Allocate an empty primary shard to a node. Accepts the index and shard for index name and shard number, and node to allocate the
         * shard to. Using this command leads to a complete loss of all data that was indexed into this shard, if it was previously started.
         * If a node which has a copy of the data rejoins the cluster later on, that data will be deleted. To ensure that these implications
         * are well-understood, this command requires the flag accept_data_loss to be explicitly set to true.
         * <p>
         * API name: {@code allocate_empty_primary}
         * </p>
         */
        @Nonnull
        public final Builder allocateEmptyPrimary(@Nullable CommandAllocatePrimaryAction value) {
            this.allocateEmptyPrimary = value;
            return this;
        }

        /**
         * Allocate an empty primary shard to a node. Accepts the index and shard for index name and shard number, and node to allocate the
         * shard to. Using this command leads to a complete loss of all data that was indexed into this shard, if it was previously started.
         * If a node which has a copy of the data rejoins the cluster later on, that data will be deleted. To ensure that these implications
         * are well-understood, this command requires the flag accept_data_loss to be explicitly set to true.
         * <p>
         * API name: {@code allocate_empty_primary}
         * </p>
         */
        @Nonnull
        public final Builder allocateEmptyPrimary(
            Function<CommandAllocatePrimaryAction.Builder, ObjectBuilder<CommandAllocatePrimaryAction>> fn
        ) {
            return allocateEmptyPrimary(fn.apply(new CommandAllocatePrimaryAction.Builder()).build());
        }

        /**
         * Allocate an unassigned replica shard to a node. Accepts index and shard for index name and shard number, and node to allocate the
         * shard to. Takes allocation deciders into account.
         * <p>
         * API name: {@code allocate_replica}
         * </p>
         */
        @Nonnull
        public final Builder allocateReplica(@Nullable CommandAllocateReplicaAction value) {
            this.allocateReplica = value;
            return this;
        }

        /**
         * Allocate an unassigned replica shard to a node. Accepts index and shard for index name and shard number, and node to allocate the
         * shard to. Takes allocation deciders into account.
         * <p>
         * API name: {@code allocate_replica}
         * </p>
         */
        @Nonnull
        public final Builder allocateReplica(
            Function<CommandAllocateReplicaAction.Builder, ObjectBuilder<CommandAllocateReplicaAction>> fn
        ) {
            return allocateReplica(fn.apply(new CommandAllocateReplicaAction.Builder()).build());
        }

        /**
         * Allocate a primary shard to a node that holds a stale copy. Accepts the index and shard for index name and shard number, and node
         * to allocate the shard to. Using this command may lead to data loss for the provided shard id. If a node which has the good copy
         * of the data rejoins the cluster later on, that data will be deleted or overwritten with the data of the stale copy that was
         * forcefully allocated with this command. To ensure that these implications are well-understood, this command requires the flag
         * accept_data_loss to be explicitly set to true.
         * <p>
         * API name: {@code allocate_stale_primary}
         * </p>
         */
        @Nonnull
        public final Builder allocateStalePrimary(@Nullable CommandAllocatePrimaryAction value) {
            this.allocateStalePrimary = value;
            return this;
        }

        /**
         * Allocate a primary shard to a node that holds a stale copy. Accepts the index and shard for index name and shard number, and node
         * to allocate the shard to. Using this command may lead to data loss for the provided shard id. If a node which has the good copy
         * of the data rejoins the cluster later on, that data will be deleted or overwritten with the data of the stale copy that was
         * forcefully allocated with this command. To ensure that these implications are well-understood, this command requires the flag
         * accept_data_loss to be explicitly set to true.
         * <p>
         * API name: {@code allocate_stale_primary}
         * </p>
         */
        @Nonnull
        public final Builder allocateStalePrimary(
            Function<CommandAllocatePrimaryAction.Builder, ObjectBuilder<CommandAllocatePrimaryAction>> fn
        ) {
            return allocateStalePrimary(fn.apply(new CommandAllocatePrimaryAction.Builder()).build());
        }

        /**
         * Cancel allocation of a shard (or recovery). Accepts index and shard for index name and shard number, and node for the node to
         * cancel the shard allocation on. This can be used to force resynchronization of existing replicas from the primary shard by
         * cancelling them and allowing them to be reinitialized through the standard recovery process. By default only replica shard
         * allocations can be cancelled. If it is necessary to cancel the allocation of a primary shard then the allow_primary flag must
         * also be included in the request.
         * <p>
         * API name: {@code cancel}
         * </p>
         */
        @Nonnull
        public final Builder cancel(@Nullable CommandCancelAction value) {
            this.cancel = value;
            return this;
        }

        /**
         * Cancel allocation of a shard (or recovery). Accepts index and shard for index name and shard number, and node for the node to
         * cancel the shard allocation on. This can be used to force resynchronization of existing replicas from the primary shard by
         * cancelling them and allowing them to be reinitialized through the standard recovery process. By default only replica shard
         * allocations can be cancelled. If it is necessary to cancel the allocation of a primary shard then the allow_primary flag must
         * also be included in the request.
         * <p>
         * API name: {@code cancel}
         * </p>
         */
        @Nonnull
        public final Builder cancel(Function<CommandCancelAction.Builder, ObjectBuilder<CommandCancelAction>> fn) {
            return cancel(fn.apply(new CommandCancelAction.Builder()).build());
        }

        /**
         * Move a started shard from one node to another node. Accepts index and shard for index name and shard number, from_node for the
         * node to move the shard from, and to_node for the node to move the shard to.
         * <p>
         * API name: {@code move}
         * </p>
         */
        @Nonnull
        public final Builder move(@Nullable CommandMoveAction value) {
            this.move = value;
            return this;
        }

        /**
         * Move a started shard from one node to another node. Accepts index and shard for index name and shard number, from_node for the
         * node to move the shard from, and to_node for the node to move the shard to.
         * <p>
         * API name: {@code move}
         * </p>
         */
        @Nonnull
        public final Builder move(Function<CommandMoveAction.Builder, ObjectBuilder<CommandMoveAction>> fn) {
            return move(fn.apply(new CommandMoveAction.Builder()).build());
        }

        /**
         * Builds a {@link Command}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Command build() {
            _checkSingleUse();

            return new Command(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Command}
     */
    public static final JsonpDeserializer<Command> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Command::setupCommandDeserializer
    );

    protected static void setupCommandDeserializer(ObjectDeserializer<Command.Builder> op) {
        op.add(Builder::allocateEmptyPrimary, CommandAllocatePrimaryAction._DESERIALIZER, "allocate_empty_primary");
        op.add(Builder::allocateReplica, CommandAllocateReplicaAction._DESERIALIZER, "allocate_replica");
        op.add(Builder::allocateStalePrimary, CommandAllocatePrimaryAction._DESERIALIZER, "allocate_stale_primary");
        op.add(Builder::cancel, CommandCancelAction._DESERIALIZER, "cancel");
        op.add(Builder::move, CommandMoveAction._DESERIALIZER, "move");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allocateEmptyPrimary);
        result = 31 * result + Objects.hashCode(this.allocateReplica);
        result = 31 * result + Objects.hashCode(this.allocateStalePrimary);
        result = 31 * result + Objects.hashCode(this.cancel);
        result = 31 * result + Objects.hashCode(this.move);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Command other = (Command) o;
        return Objects.equals(this.allocateEmptyPrimary, other.allocateEmptyPrimary)
            && Objects.equals(this.allocateReplica, other.allocateReplica)
            && Objects.equals(this.allocateStalePrimary, other.allocateStalePrimary)
            && Objects.equals(this.cancel, other.cancel)
            && Objects.equals(this.move, other.move);
    }
}
