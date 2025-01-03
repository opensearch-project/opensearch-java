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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.info.NodeThreadPoolInfo

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeThreadPoolInfo implements PlainJsonSerializable, ToCopyableBuilder<NodeThreadPoolInfo.Builder, NodeThreadPoolInfo> {

    @Nullable
    private final Integer core;

    @Nullable
    private final Time keepAlive;

    @Nullable
    private final Integer max;

    private final int queueSize;

    @Nullable
    private final Integer size;

    @Nonnull
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private NodeThreadPoolInfo(Builder builder) {
        this.core = builder.core;
        this.keepAlive = builder.keepAlive;
        this.max = builder.max;
        this.queueSize = ApiTypeHelper.requireNonNull(builder.queueSize, this, "queueSize");
        this.size = builder.size;
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static NodeThreadPoolInfo of(Function<NodeThreadPoolInfo.Builder, ObjectBuilder<NodeThreadPoolInfo>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code core}
     */
    @Nullable
    public final Integer core() {
        return this.core;
    }

    /**
     * API name: {@code keep_alive}
     */
    @Nullable
    public final Time keepAlive() {
        return this.keepAlive;
    }

    /**
     * API name: {@code max}
     */
    @Nullable
    public final Integer max() {
        return this.max;
    }

    /**
     * Required - API name: {@code queue_size}
     */
    public final int queueSize() {
        return this.queueSize;
    }

    /**
     * API name: {@code size}
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final String type() {
        return this.type;
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
        if (this.core != null) {
            generator.writeKey("core");
            generator.write(this.core);
        }

        if (this.keepAlive != null) {
            generator.writeKey("keep_alive");
            this.keepAlive.serialize(generator, mapper);
        }

        if (this.max != null) {
            generator.writeKey("max");
            generator.write(this.max);
        }

        generator.writeKey("queue_size");
        generator.write(this.queueSize);

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        generator.writeKey("type");
        generator.write(this.type);
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
     * Builder for {@link NodeThreadPoolInfo}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeThreadPoolInfo> {
        @Nullable
        private Integer core;
        @Nullable
        private Time keepAlive;
        @Nullable
        private Integer max;
        private Integer queueSize;
        @Nullable
        private Integer size;
        private String type;

        public Builder() {}

        private Builder(NodeThreadPoolInfo o) {
            this.core = o.core;
            this.keepAlive = o.keepAlive;
            this.max = o.max;
            this.queueSize = o.queueSize;
            this.size = o.size;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.core = o.core;
            this.keepAlive = o.keepAlive;
            this.max = o.max;
            this.queueSize = o.queueSize;
            this.size = o.size;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code core}
         */
        @Nonnull
        public final Builder core(@Nullable Integer value) {
            this.core = value;
            return this;
        }

        /**
         * API name: {@code keep_alive}
         */
        @Nonnull
        public final Builder keepAlive(@Nullable Time value) {
            this.keepAlive = value;
            return this;
        }

        /**
         * API name: {@code keep_alive}
         */
        @Nonnull
        public final Builder keepAlive(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return keepAlive(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code max}
         */
        @Nonnull
        public final Builder max(@Nullable Integer value) {
            this.max = value;
            return this;
        }

        /**
         * Required - API name: {@code queue_size}
         */
        @Nonnull
        public final Builder queueSize(int value) {
            this.queueSize = value;
            return this;
        }

        /**
         * API name: {@code size}
         */
        @Nonnull
        public final Builder size(@Nullable Integer value) {
            this.size = value;
            return this;
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link NodeThreadPoolInfo}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeThreadPoolInfo build() {
            _checkSingleUse();

            return new NodeThreadPoolInfo(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeThreadPoolInfo}
     */
    public static final JsonpDeserializer<NodeThreadPoolInfo> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeThreadPoolInfo::setupNodeThreadPoolInfoDeserializer
    );

    protected static void setupNodeThreadPoolInfoDeserializer(ObjectDeserializer<NodeThreadPoolInfo.Builder> op) {
        op.add(Builder::core, JsonpDeserializer.integerDeserializer(), "core");
        op.add(Builder::keepAlive, Time._DESERIALIZER, "keep_alive");
        op.add(Builder::max, JsonpDeserializer.integerDeserializer(), "max");
        op.add(Builder::queueSize, JsonpDeserializer.integerDeserializer(), "queue_size");
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.core);
        result = 31 * result + Objects.hashCode(this.keepAlive);
        result = 31 * result + Objects.hashCode(this.max);
        result = 31 * result + Integer.hashCode(this.queueSize);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeThreadPoolInfo other = (NodeThreadPoolInfo) o;
        return Objects.equals(this.core, other.core)
            && Objects.equals(this.keepAlive, other.keepAlive)
            && Objects.equals(this.max, other.max)
            && this.queueSize == other.queueSize
            && Objects.equals(this.size, other.size)
            && this.type.equals(other.type);
    }
}
