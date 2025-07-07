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

package org.opensearch.client.opensearch.ingestion;

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

// typedef: ingestion.ShardIngestionState

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardIngestionState implements PlainJsonSerializable, ToCopyableBuilder<ShardIngestionState.Builder, ShardIngestionState> {

    @Nullable
    private final String batchStartPointer;

    @Nullable
    private final ErrorPolicy errorPolicy;

    @Nullable
    private final Boolean pollerPaused;

    @Nullable
    private final PollerState pollerState;

    @Nullable
    private final Integer shard;

    @Nullable
    private final Boolean writeBlockEnabled;

    // ---------------------------------------------------------------------------------------------

    private ShardIngestionState(Builder builder) {
        this.batchStartPointer = builder.batchStartPointer;
        this.errorPolicy = builder.errorPolicy;
        this.pollerPaused = builder.pollerPaused;
        this.pollerState = builder.pollerState;
        this.shard = builder.shard;
        this.writeBlockEnabled = builder.writeBlockEnabled;
    }

    public static ShardIngestionState of(Function<ShardIngestionState.Builder, ObjectBuilder<ShardIngestionState>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Indicates the shard pointer from where the poller will resume during shard recovery.
     * <p>
     * API name: {@code batch_start_pointer}
     * </p>
     */
    @Nullable
    public final String batchStartPointer() {
        return this.batchStartPointer;
    }

    /**
     * Indicates the policy used to handle failed messages.
     * <p>
     * API name: {@code error_policy}
     * </p>
     */
    @Nullable
    public final ErrorPolicy errorPolicy() {
        return this.errorPolicy;
    }

    /**
     * Indicates if the poller has been paused.
     * <p>
     * API name: {@code poller_paused}
     * </p>
     */
    @Nullable
    public final Boolean pollerPaused() {
        return this.pollerPaused;
    }

    /**
     * Indicates the current state of the poller.
     * <p>
     * API name: {@code poller_state}
     * </p>
     */
    @Nullable
    public final PollerState pollerState() {
        return this.pollerState;
    }

    /**
     * The shard number.
     * <p>
     * API name: {@code shard}
     * </p>
     */
    @Nullable
    public final Integer shard() {
        return this.shard;
    }

    /**
     * Indicates if a write block has been created.
     * <p>
     * API name: {@code write_block_enabled}
     * </p>
     */
    @Nullable
    public final Boolean writeBlockEnabled() {
        return this.writeBlockEnabled;
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
        if (this.batchStartPointer != null) {
            generator.writeKey("batch_start_pointer");
            generator.write(this.batchStartPointer);
        }

        if (this.errorPolicy != null) {
            generator.writeKey("error_policy");
            this.errorPolicy.serialize(generator, mapper);
        }

        if (this.pollerPaused != null) {
            generator.writeKey("poller_paused");
            generator.write(this.pollerPaused);
        }

        if (this.pollerState != null) {
            generator.writeKey("poller_state");
            this.pollerState.serialize(generator, mapper);
        }

        if (this.shard != null) {
            generator.writeKey("shard");
            generator.write(this.shard);
        }

        if (this.writeBlockEnabled != null) {
            generator.writeKey("write_block_enabled");
            generator.write(this.writeBlockEnabled);
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
     * Builder for {@link ShardIngestionState}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardIngestionState> {
        @Nullable
        private String batchStartPointer;
        @Nullable
        private ErrorPolicy errorPolicy;
        @Nullable
        private Boolean pollerPaused;
        @Nullable
        private PollerState pollerState;
        @Nullable
        private Integer shard;
        @Nullable
        private Boolean writeBlockEnabled;

        public Builder() {}

        private Builder(ShardIngestionState o) {
            this.batchStartPointer = o.batchStartPointer;
            this.errorPolicy = o.errorPolicy;
            this.pollerPaused = o.pollerPaused;
            this.pollerState = o.pollerState;
            this.shard = o.shard;
            this.writeBlockEnabled = o.writeBlockEnabled;
        }

        private Builder(Builder o) {
            this.batchStartPointer = o.batchStartPointer;
            this.errorPolicy = o.errorPolicy;
            this.pollerPaused = o.pollerPaused;
            this.pollerState = o.pollerState;
            this.shard = o.shard;
            this.writeBlockEnabled = o.writeBlockEnabled;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Indicates the shard pointer from where the poller will resume during shard recovery.
         * <p>
         * API name: {@code batch_start_pointer}
         * </p>
         */
        @Nonnull
        public final Builder batchStartPointer(@Nullable String value) {
            this.batchStartPointer = value;
            return this;
        }

        /**
         * Indicates the policy used to handle failed messages.
         * <p>
         * API name: {@code error_policy}
         * </p>
         */
        @Nonnull
        public final Builder errorPolicy(@Nullable ErrorPolicy value) {
            this.errorPolicy = value;
            return this;
        }

        /**
         * Indicates if the poller has been paused.
         * <p>
         * API name: {@code poller_paused}
         * </p>
         */
        @Nonnull
        public final Builder pollerPaused(@Nullable Boolean value) {
            this.pollerPaused = value;
            return this;
        }

        /**
         * Indicates the current state of the poller.
         * <p>
         * API name: {@code poller_state}
         * </p>
         */
        @Nonnull
        public final Builder pollerState(@Nullable PollerState value) {
            this.pollerState = value;
            return this;
        }

        /**
         * The shard number.
         * <p>
         * API name: {@code shard}
         * </p>
         */
        @Nonnull
        public final Builder shard(@Nullable Integer value) {
            this.shard = value;
            return this;
        }

        /**
         * Indicates if a write block has been created.
         * <p>
         * API name: {@code write_block_enabled}
         * </p>
         */
        @Nonnull
        public final Builder writeBlockEnabled(@Nullable Boolean value) {
            this.writeBlockEnabled = value;
            return this;
        }

        /**
         * Builds a {@link ShardIngestionState}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardIngestionState build() {
            _checkSingleUse();

            return new ShardIngestionState(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardIngestionState}
     */
    public static final JsonpDeserializer<ShardIngestionState> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardIngestionState::setupShardIngestionStateDeserializer
    );

    protected static void setupShardIngestionStateDeserializer(ObjectDeserializer<ShardIngestionState.Builder> op) {
        op.add(Builder::batchStartPointer, JsonpDeserializer.stringDeserializer(), "batch_start_pointer");
        op.add(Builder::errorPolicy, ErrorPolicy._DESERIALIZER, "error_policy");
        op.add(Builder::pollerPaused, JsonpDeserializer.booleanDeserializer(), "poller_paused");
        op.add(Builder::pollerState, PollerState._DESERIALIZER, "poller_state");
        op.add(Builder::shard, JsonpDeserializer.integerDeserializer(), "shard");
        op.add(Builder::writeBlockEnabled, JsonpDeserializer.booleanDeserializer(), "write_block_enabled");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.batchStartPointer);
        result = 31 * result + Objects.hashCode(this.errorPolicy);
        result = 31 * result + Objects.hashCode(this.pollerPaused);
        result = 31 * result + Objects.hashCode(this.pollerState);
        result = 31 * result + Objects.hashCode(this.shard);
        result = 31 * result + Objects.hashCode(this.writeBlockEnabled);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardIngestionState other = (ShardIngestionState) o;
        return Objects.equals(this.batchStartPointer, other.batchStartPointer)
            && Objects.equals(this.errorPolicy, other.errorPolicy)
            && Objects.equals(this.pollerPaused, other.pollerPaused)
            && Objects.equals(this.pollerState, other.pollerState)
            && Objects.equals(this.shard, other.shard)
            && Objects.equals(this.writeBlockEnabled, other.writeBlockEnabled);
    }
}
