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

// typedef: nodes.info.NodeInfoMemory

/**
 * Provides memory information for the node.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoMemory implements PlainJsonSerializable, ToCopyableBuilder<NodeInfoMemory.Builder, NodeInfoMemory> {

    @Nonnull
    private final String total;

    private final long totalInBytes;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoMemory(Builder builder) {
        this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total");
        this.totalInBytes = ApiTypeHelper.requireNonNull(builder.totalInBytes, this, "totalInBytes");
    }

    public static NodeInfoMemory of(Function<NodeInfoMemory.Builder, ObjectBuilder<NodeInfoMemory>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code total}
     */
    @Nonnull
    public final String total() {
        return this.total;
    }

    /**
     * Required - API name: {@code total_in_bytes}
     */
    public final long totalInBytes() {
        return this.totalInBytes;
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
        generator.writeKey("total");
        generator.write(this.total);

        generator.writeKey("total_in_bytes");
        generator.write(this.totalInBytes);
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
     * Builder for {@link NodeInfoMemory}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoMemory> {
        private String total;
        private Long totalInBytes;

        public Builder() {}

        private Builder(NodeInfoMemory o) {
            this.total = o.total;
            this.totalInBytes = o.totalInBytes;
        }

        private Builder(Builder o) {
            this.total = o.total;
            this.totalInBytes = o.totalInBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code total}
         */
        @Nonnull
        public final Builder total(String value) {
            this.total = value;
            return this;
        }

        /**
         * Required - API name: {@code total_in_bytes}
         */
        @Nonnull
        public final Builder totalInBytes(long value) {
            this.totalInBytes = value;
            return this;
        }

        /**
         * Builds a {@link NodeInfoMemory}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoMemory build() {
            _checkSingleUse();

            return new NodeInfoMemory(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoMemory}
     */
    public static final JsonpDeserializer<NodeInfoMemory> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoMemory::setupNodeInfoMemoryDeserializer
    );

    protected static void setupNodeInfoMemoryDeserializer(ObjectDeserializer<NodeInfoMemory.Builder> op) {
        op.add(Builder::total, JsonpDeserializer.stringDeserializer(), "total");
        op.add(Builder::totalInBytes, JsonpDeserializer.longDeserializer(), "total_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.total.hashCode();
        result = 31 * result + Long.hashCode(this.totalInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoMemory other = (NodeInfoMemory) o;
        return this.total.equals(other.total) && this.totalInBytes == other.totalInBytes;
    }
}
