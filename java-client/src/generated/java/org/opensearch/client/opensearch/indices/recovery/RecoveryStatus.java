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

package org.opensearch.client.opensearch.indices.recovery;

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

// typedef: indices.recovery.RecoveryStatus

/**
 * The status of recovery operations.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RecoveryStatus implements PlainJsonSerializable, ToCopyableBuilder<RecoveryStatus.Builder, RecoveryStatus> {

    @Nonnull
    private final List<ShardRecovery> shards;

    // ---------------------------------------------------------------------------------------------

    private RecoveryStatus(Builder builder) {
        this.shards = ApiTypeHelper.unmodifiableRequired(builder.shards, this, "shards");
    }

    public static RecoveryStatus of(Function<RecoveryStatus.Builder, ObjectBuilder<RecoveryStatus>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The list of shard recovery statuses.
     * <p>
     * API name: {@code shards}
     * </p>
     */
    @Nonnull
    public final List<ShardRecovery> shards() {
        return this.shards;
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
        generator.writeKey("shards");
        generator.writeStartArray();
        for (ShardRecovery item0 : this.shards) {
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
     * Builder for {@link RecoveryStatus}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RecoveryStatus> {
        private List<ShardRecovery> shards;

        public Builder() {}

        private Builder(RecoveryStatus o) {
            this.shards = _listCopy(o.shards);
        }

        private Builder(Builder o) {
            this.shards = _listCopy(o.shards);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The list of shard recovery statuses.
         * <p>
         * API name: {@code shards}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(List<ShardRecovery> list) {
            this.shards = _listAddAll(this.shards, list);
            return this;
        }

        /**
         * Required - The list of shard recovery statuses.
         * <p>
         * API name: {@code shards}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(ShardRecovery value, ShardRecovery... values) {
            this.shards = _listAdd(this.shards, value, values);
            return this;
        }

        /**
         * Required - The list of shard recovery statuses.
         * <p>
         * API name: {@code shards}
         * </p>
         *
         * <p>
         * Adds a value to <code>shards</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder shards(Function<ShardRecovery.Builder, ObjectBuilder<ShardRecovery>> fn) {
            return shards(fn.apply(new ShardRecovery.Builder()).build());
        }

        /**
         * Builds a {@link RecoveryStatus}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RecoveryStatus build() {
            _checkSingleUse();

            return new RecoveryStatus(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RecoveryStatus}
     */
    public static final JsonpDeserializer<RecoveryStatus> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RecoveryStatus::setupRecoveryStatusDeserializer
    );

    protected static void setupRecoveryStatusDeserializer(ObjectDeserializer<RecoveryStatus.Builder> op) {
        op.add(Builder::shards, JsonpDeserializer.arrayDeserializer(ShardRecovery._DESERIALIZER), "shards");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.shards.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RecoveryStatus other = (RecoveryStatus) o;
        return this.shards.equals(other.shards);
    }
}
