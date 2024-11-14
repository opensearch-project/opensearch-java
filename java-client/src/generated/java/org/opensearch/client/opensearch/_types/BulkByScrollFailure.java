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

// typedef: _types.BulkByScrollFailure

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class BulkByScrollFailure implements PlainJsonSerializable, ToCopyableBuilder<BulkByScrollFailure.Builder, BulkByScrollFailure> {

    @Nullable
    private final ErrorCause cause;

    @Nullable
    private final String id;

    @Nullable
    private final String index;

    @Nullable
    private final String node;

    @Nullable
    private final ErrorCause reason;

    @Nullable
    private final Integer shard;

    private final int status;

    // ---------------------------------------------------------------------------------------------

    private BulkByScrollFailure(Builder builder) {
        this.cause = builder.cause;
        this.id = builder.id;
        this.index = builder.index;
        this.node = builder.node;
        this.reason = builder.reason;
        this.shard = builder.shard;
        this.status = ApiTypeHelper.requireNonNull(builder.status, this, "status");
    }

    public static BulkByScrollFailure of(Function<BulkByScrollFailure.Builder, ObjectBuilder<BulkByScrollFailure>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code cause}
     */
    @Nullable
    public final ErrorCause cause() {
        return this.cause;
    }

    /**
     * API name: {@code id}
     */
    @Nullable
    public final String id() {
        return this.id;
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
     * API name: {@code reason}
     */
    @Nullable
    public final ErrorCause reason() {
        return this.reason;
    }

    /**
     * API name: {@code shard}
     */
    @Nullable
    public final Integer shard() {
        return this.shard;
    }

    /**
     * Required - API name: {@code status}
     */
    public final int status() {
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
        if (this.cause != null) {
            generator.writeKey("cause");
            this.cause.serialize(generator, mapper);
        }

        if (this.id != null) {
            generator.writeKey("id");
            generator.write(this.id);
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.node != null) {
            generator.writeKey("node");
            generator.write(this.node);
        }

        if (this.reason != null) {
            generator.writeKey("reason");
            this.reason.serialize(generator, mapper);
        }

        if (this.shard != null) {
            generator.writeKey("shard");
            generator.write(this.shard);
        }

        generator.writeKey("status");
        generator.write(this.status);
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
     * Builder for {@link BulkByScrollFailure}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, BulkByScrollFailure> {
        @Nullable
        private ErrorCause cause;
        @Nullable
        private String id;
        @Nullable
        private String index;
        @Nullable
        private String node;
        @Nullable
        private ErrorCause reason;
        @Nullable
        private Integer shard;
        private Integer status;

        public Builder() {}

        private Builder(BulkByScrollFailure o) {
            this.cause = o.cause;
            this.id = o.id;
            this.index = o.index;
            this.node = o.node;
            this.reason = o.reason;
            this.shard = o.shard;
            this.status = o.status;
        }

        private Builder(Builder o) {
            this.cause = o.cause;
            this.id = o.id;
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
         * API name: {@code cause}
         */
        @Nonnull
        public final Builder cause(@Nullable ErrorCause value) {
            this.cause = value;
            return this;
        }

        /**
         * API name: {@code cause}
         */
        @Nonnull
        public final Builder cause(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
            return cause(fn.apply(new ErrorCause.Builder()).build());
        }

        /**
         * API name: {@code id}
         */
        @Nonnull
        public final Builder id(@Nullable String value) {
            this.id = value;
            return this;
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
         * API name: {@code reason}
         */
        @Nonnull
        public final Builder reason(@Nullable ErrorCause value) {
            this.reason = value;
            return this;
        }

        /**
         * API name: {@code reason}
         */
        @Nonnull
        public final Builder reason(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
            return reason(fn.apply(new ErrorCause.Builder()).build());
        }

        /**
         * API name: {@code shard}
         */
        @Nonnull
        public final Builder shard(@Nullable Integer value) {
            this.shard = value;
            return this;
        }

        /**
         * Required - API name: {@code status}
         */
        @Nonnull
        public final Builder status(int value) {
            this.status = value;
            return this;
        }

        /**
         * Builds a {@link BulkByScrollFailure}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public BulkByScrollFailure build() {
            _checkSingleUse();

            return new BulkByScrollFailure(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link BulkByScrollFailure}
     */
    public static final JsonpDeserializer<BulkByScrollFailure> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        BulkByScrollFailure::setupBulkByScrollFailureDeserializer
    );

    protected static void setupBulkByScrollFailureDeserializer(ObjectDeserializer<BulkByScrollFailure.Builder> op) {
        op.add(Builder::cause, ErrorCause._DESERIALIZER, "cause");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::node, JsonpDeserializer.stringDeserializer(), "node");
        op.add(Builder::reason, ErrorCause._DESERIALIZER, "reason");
        op.add(Builder::shard, JsonpDeserializer.integerDeserializer(), "shard");
        op.add(Builder::status, JsonpDeserializer.integerDeserializer(), "status");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.cause);
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.node);
        result = 31 * result + Objects.hashCode(this.reason);
        result = 31 * result + Objects.hashCode(this.shard);
        result = 31 * result + Integer.hashCode(this.status);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        BulkByScrollFailure other = (BulkByScrollFailure) o;
        return Objects.equals(this.cause, other.cause)
            && Objects.equals(this.id, other.id)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.node, other.node)
            && Objects.equals(this.reason, other.reason)
            && Objects.equals(this.shard, other.shard)
            && this.status == other.status;
    }
}
