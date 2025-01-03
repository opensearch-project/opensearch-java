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

// typedef: nodes.info.NodeInfoOSCPU

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoOSCPU implements PlainJsonSerializable, ToCopyableBuilder<NodeInfoOSCPU.Builder, NodeInfoOSCPU> {

    @Nonnull
    private final String cacheSize;

    private final long cacheSizeInBytes;

    private final int coresPerSocket;

    private final int mhz;

    @Nonnull
    private final String model;

    private final int totalCores;

    private final int totalSockets;

    @Nonnull
    private final String vendor;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoOSCPU(Builder builder) {
        this.cacheSize = ApiTypeHelper.requireNonNull(builder.cacheSize, this, "cacheSize");
        this.cacheSizeInBytes = ApiTypeHelper.requireNonNull(builder.cacheSizeInBytes, this, "cacheSizeInBytes");
        this.coresPerSocket = ApiTypeHelper.requireNonNull(builder.coresPerSocket, this, "coresPerSocket");
        this.mhz = ApiTypeHelper.requireNonNull(builder.mhz, this, "mhz");
        this.model = ApiTypeHelper.requireNonNull(builder.model, this, "model");
        this.totalCores = ApiTypeHelper.requireNonNull(builder.totalCores, this, "totalCores");
        this.totalSockets = ApiTypeHelper.requireNonNull(builder.totalSockets, this, "totalSockets");
        this.vendor = ApiTypeHelper.requireNonNull(builder.vendor, this, "vendor");
    }

    public static NodeInfoOSCPU of(Function<NodeInfoOSCPU.Builder, ObjectBuilder<NodeInfoOSCPU>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code cache_size}
     */
    @Nonnull
    public final String cacheSize() {
        return this.cacheSize;
    }

    /**
     * Required - API name: {@code cache_size_in_bytes}
     */
    public final long cacheSizeInBytes() {
        return this.cacheSizeInBytes;
    }

    /**
     * Required - API name: {@code cores_per_socket}
     */
    public final int coresPerSocket() {
        return this.coresPerSocket;
    }

    /**
     * Required - API name: {@code mhz}
     */
    public final int mhz() {
        return this.mhz;
    }

    /**
     * Required - API name: {@code model}
     */
    @Nonnull
    public final String model() {
        return this.model;
    }

    /**
     * Required - API name: {@code total_cores}
     */
    public final int totalCores() {
        return this.totalCores;
    }

    /**
     * Required - API name: {@code total_sockets}
     */
    public final int totalSockets() {
        return this.totalSockets;
    }

    /**
     * Required - API name: {@code vendor}
     */
    @Nonnull
    public final String vendor() {
        return this.vendor;
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
        generator.writeKey("cache_size");
        generator.write(this.cacheSize);

        generator.writeKey("cache_size_in_bytes");
        generator.write(this.cacheSizeInBytes);

        generator.writeKey("cores_per_socket");
        generator.write(this.coresPerSocket);

        generator.writeKey("mhz");
        generator.write(this.mhz);

        generator.writeKey("model");
        generator.write(this.model);

        generator.writeKey("total_cores");
        generator.write(this.totalCores);

        generator.writeKey("total_sockets");
        generator.write(this.totalSockets);

        generator.writeKey("vendor");
        generator.write(this.vendor);
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
     * Builder for {@link NodeInfoOSCPU}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoOSCPU> {
        private String cacheSize;
        private Long cacheSizeInBytes;
        private Integer coresPerSocket;
        private Integer mhz;
        private String model;
        private Integer totalCores;
        private Integer totalSockets;
        private String vendor;

        public Builder() {}

        private Builder(NodeInfoOSCPU o) {
            this.cacheSize = o.cacheSize;
            this.cacheSizeInBytes = o.cacheSizeInBytes;
            this.coresPerSocket = o.coresPerSocket;
            this.mhz = o.mhz;
            this.model = o.model;
            this.totalCores = o.totalCores;
            this.totalSockets = o.totalSockets;
            this.vendor = o.vendor;
        }

        private Builder(Builder o) {
            this.cacheSize = o.cacheSize;
            this.cacheSizeInBytes = o.cacheSizeInBytes;
            this.coresPerSocket = o.coresPerSocket;
            this.mhz = o.mhz;
            this.model = o.model;
            this.totalCores = o.totalCores;
            this.totalSockets = o.totalSockets;
            this.vendor = o.vendor;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code cache_size}
         */
        @Nonnull
        public final Builder cacheSize(String value) {
            this.cacheSize = value;
            return this;
        }

        /**
         * Required - API name: {@code cache_size_in_bytes}
         */
        @Nonnull
        public final Builder cacheSizeInBytes(long value) {
            this.cacheSizeInBytes = value;
            return this;
        }

        /**
         * Required - API name: {@code cores_per_socket}
         */
        @Nonnull
        public final Builder coresPerSocket(int value) {
            this.coresPerSocket = value;
            return this;
        }

        /**
         * Required - API name: {@code mhz}
         */
        @Nonnull
        public final Builder mhz(int value) {
            this.mhz = value;
            return this;
        }

        /**
         * Required - API name: {@code model}
         */
        @Nonnull
        public final Builder model(String value) {
            this.model = value;
            return this;
        }

        /**
         * Required - API name: {@code total_cores}
         */
        @Nonnull
        public final Builder totalCores(int value) {
            this.totalCores = value;
            return this;
        }

        /**
         * Required - API name: {@code total_sockets}
         */
        @Nonnull
        public final Builder totalSockets(int value) {
            this.totalSockets = value;
            return this;
        }

        /**
         * Required - API name: {@code vendor}
         */
        @Nonnull
        public final Builder vendor(String value) {
            this.vendor = value;
            return this;
        }

        /**
         * Builds a {@link NodeInfoOSCPU}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoOSCPU build() {
            _checkSingleUse();

            return new NodeInfoOSCPU(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoOSCPU}
     */
    public static final JsonpDeserializer<NodeInfoOSCPU> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoOSCPU::setupNodeInfoOSCPUDeserializer
    );

    protected static void setupNodeInfoOSCPUDeserializer(ObjectDeserializer<NodeInfoOSCPU.Builder> op) {
        op.add(Builder::cacheSize, JsonpDeserializer.stringDeserializer(), "cache_size");
        op.add(Builder::cacheSizeInBytes, JsonpDeserializer.longDeserializer(), "cache_size_in_bytes");
        op.add(Builder::coresPerSocket, JsonpDeserializer.integerDeserializer(), "cores_per_socket");
        op.add(Builder::mhz, JsonpDeserializer.integerDeserializer(), "mhz");
        op.add(Builder::model, JsonpDeserializer.stringDeserializer(), "model");
        op.add(Builder::totalCores, JsonpDeserializer.integerDeserializer(), "total_cores");
        op.add(Builder::totalSockets, JsonpDeserializer.integerDeserializer(), "total_sockets");
        op.add(Builder::vendor, JsonpDeserializer.stringDeserializer(), "vendor");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.cacheSize.hashCode();
        result = 31 * result + Long.hashCode(this.cacheSizeInBytes);
        result = 31 * result + Integer.hashCode(this.coresPerSocket);
        result = 31 * result + Integer.hashCode(this.mhz);
        result = 31 * result + this.model.hashCode();
        result = 31 * result + Integer.hashCode(this.totalCores);
        result = 31 * result + Integer.hashCode(this.totalSockets);
        result = 31 * result + this.vendor.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoOSCPU other = (NodeInfoOSCPU) o;
        return this.cacheSize.equals(other.cacheSize)
            && this.cacheSizeInBytes == other.cacheSizeInBytes
            && this.coresPerSocket == other.coresPerSocket
            && this.mhz == other.mhz
            && this.model.equals(other.model)
            && this.totalCores == other.totalCores
            && this.totalSockets == other.totalSockets
            && this.vendor.equals(other.vendor);
    }
}
