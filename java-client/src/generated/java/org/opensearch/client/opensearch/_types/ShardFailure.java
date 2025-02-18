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

package org.opensearch.client.opensearch._types;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.ShardFailure

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardFailure implements PlainJsonSerializable, ToCopyableBuilder<ShardFailure.Builder, ShardFailure> {

    @Nullable
    private final String index;

    @Nullable
    private final String node;

    @Nonnull
    private final ErrorCause reason;

    private final int shard;

    @Nullable
    private final String status;

    // ---------------------------------------------------------------------------------------------

    private ShardFailure(Builder builder) {
        this.index = builder.index;
        this.node = builder.node;
        this.reason = ApiTypeHelper.requireNonNull(builder.reason, this, "reason");
        this.shard = ApiTypeHelper.requireNonNull(builder.shard, this, "shard");
        this.status = builder.status;
    }

    public static ShardFailure of(Function<ShardFailure.Builder, ObjectBuilder<ShardFailure>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * API name: {@code node}
     */
    @Nullable
    public final String node() {
        return this.node;
    }

    /**
     * Required - API name: {@code reason}
     */
    @Nonnull
    public final ErrorCause reason() {
        return this.reason;
    }

    /**
     * Required - API name: {@code shard}
     */
    public final int shard() {
        return this.shard;
    }

    /**
     * API name: {@code status}
     */
    @Nullable
    public final String status() {
        return this.status;
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
        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.node != null) {
            generator.writeKey("node");
            generator.write(this.node);
        }

        generator.writeKey("reason");
        this.reason.serialize(generator, mapper);

        generator.writeKey("shard");
        generator.write(this.shard);

        if (this.status != null) {
            generator.writeKey("status");
            generator.write(this.status);
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
     * Builder for {@link ShardFailure}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardFailure> {
        @Nullable
        private String index;
        @Nullable
        private String node;
        private ErrorCause reason;
        private Integer shard;
        @Nullable
        private String status;

        public Builder() {}

        private Builder(ShardFailure o) {
            this.index = o.index;
            this.node = o.node;
            this.reason = o.reason;
            this.shard = o.shard;
            this.status = o.status;
        }

        private Builder(Builder o) {
            this.index = o.index;
            this.node = o.node;
            this.reason = o.reason;
            this.shard = o.shard;
            this.status = o.status;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(@Nullable String value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code node}
         */
        @Nonnull
        public final Builder node(@Nullable String value) {
            this.node = value;
            return this;
        }

        /**
         * Required - API name: {@code reason}
         */
        @Nonnull
        public final Builder reason(ErrorCause value) {
            this.reason = value;
            return this;
        }

        /**
         * Required - API name: {@code reason}
         */
        @Nonnull
        public final Builder reason(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
            return reason(fn.apply(new ErrorCause.Builder()).build());
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
         * API name: {@code status}
         */
        @Nonnull
        public final Builder status(@Nullable String value) {
            this.status = value;
            return this;
        }

        /**
         * Builds a {@link ShardFailure}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardFailure build() {
            _checkSingleUse();

            return new ShardFailure(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardFailure}
     */
    public static final JsonpDeserializer<ShardFailure> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardFailure::setupShardFailureDeserializer
    );

    protected static void setupShardFailureDeserializer(ObjectDeserializer<ShardFailure.Builder> op) {
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::node, JsonpDeserializer.stringDeserializer(), "node");
        op.add(Builder::reason, ErrorCause._DESERIALIZER, "reason");
        op.add(Builder::shard, JsonpDeserializer.integerDeserializer(), "shard");
        op.add(Builder::status, JsonpDeserializer.stringDeserializer(), "status");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.node);
        result = 31 * result + this.reason.hashCode();
        result = 31 * result + Integer.hashCode(this.shard);
        result = 31 * result + Objects.hashCode(this.status);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardFailure other = (ShardFailure) o;
        return Objects.equals(this.index, other.index)
            && Objects.equals(this.node, other.node)
            && this.reason.equals(other.reason)
            && this.shard == other.shard
            && Objects.equals(this.status, other.status);
    }
}
