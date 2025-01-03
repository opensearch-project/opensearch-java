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

package org.opensearch.client.opensearch.nodes.stats;

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

// typedef: nodes.stats.Transport

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Transport implements PlainJsonSerializable, ToCopyableBuilder<Transport.Builder, Transport> {

    @Nullable
    private final Long rxCount;

    @Nullable
    private final String rxSize;

    @Nullable
    private final Long rxSizeInBytes;

    @Nullable
    private final Long serverOpen;

    @Nullable
    private final Long totalOutboundConnections;

    @Nullable
    private final Long txCount;

    @Nullable
    private final String txSize;

    @Nullable
    private final Long txSizeInBytes;

    // ---------------------------------------------------------------------------------------------

    private Transport(Builder builder) {
        this.rxCount = builder.rxCount;
        this.rxSize = builder.rxSize;
        this.rxSizeInBytes = builder.rxSizeInBytes;
        this.serverOpen = builder.serverOpen;
        this.totalOutboundConnections = builder.totalOutboundConnections;
        this.txCount = builder.txCount;
        this.txSize = builder.txSize;
        this.txSizeInBytes = builder.txSizeInBytes;
    }

    public static Transport of(Function<Transport.Builder, ObjectBuilder<Transport>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Total number of RX (receive) packets received by the node during internal cluster communication.
     * <p>
     * API name: {@code rx_count}
     * </p>
     */
    @Nullable
    public final Long rxCount() {
        return this.rxCount;
    }

    /**
     * Size of RX packets received by the node during internal cluster communication.
     * <p>
     * API name: {@code rx_size}
     * </p>
     */
    @Nullable
    public final String rxSize() {
        return this.rxSize;
    }

    /**
     * Size, in bytes, of RX packets received by the node during internal cluster communication.
     * <p>
     * API name: {@code rx_size_in_bytes}
     * </p>
     */
    @Nullable
    public final Long rxSizeInBytes() {
        return this.rxSizeInBytes;
    }

    /**
     * Current number of inbound TCP connections used for internal communication between nodes.
     * <p>
     * API name: {@code server_open}
     * </p>
     */
    @Nullable
    public final Long serverOpen() {
        return this.serverOpen;
    }

    /**
     * The cumulative number of outbound transport connections that this node has opened since it started. Each transport connection may
     * comprise multiple TCP connections but is only counted once in this statistic. Transport connections are typically long-lived so this
     * statistic should remain constant in a stable cluster.
     * <p>
     * API name: {@code total_outbound_connections}
     * </p>
     */
    @Nullable
    public final Long totalOutboundConnections() {
        return this.totalOutboundConnections;
    }

    /**
     * Total number of TX (transmit) packets sent by the node during internal cluster communication.
     * <p>
     * API name: {@code tx_count}
     * </p>
     */
    @Nullable
    public final Long txCount() {
        return this.txCount;
    }

    /**
     * Size of TX packets sent by the node during internal cluster communication.
     * <p>
     * API name: {@code tx_size}
     * </p>
     */
    @Nullable
    public final String txSize() {
        return this.txSize;
    }

    /**
     * Size, in bytes, of TX packets sent by the node during internal cluster communication.
     * <p>
     * API name: {@code tx_size_in_bytes}
     * </p>
     */
    @Nullable
    public final Long txSizeInBytes() {
        return this.txSizeInBytes;
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
        if (this.rxCount != null) {
            generator.writeKey("rx_count");
            generator.write(this.rxCount);
        }

        if (this.rxSize != null) {
            generator.writeKey("rx_size");
            generator.write(this.rxSize);
        }

        if (this.rxSizeInBytes != null) {
            generator.writeKey("rx_size_in_bytes");
            generator.write(this.rxSizeInBytes);
        }

        if (this.serverOpen != null) {
            generator.writeKey("server_open");
            generator.write(this.serverOpen);
        }

        if (this.totalOutboundConnections != null) {
            generator.writeKey("total_outbound_connections");
            generator.write(this.totalOutboundConnections);
        }

        if (this.txCount != null) {
            generator.writeKey("tx_count");
            generator.write(this.txCount);
        }

        if (this.txSize != null) {
            generator.writeKey("tx_size");
            generator.write(this.txSize);
        }

        if (this.txSizeInBytes != null) {
            generator.writeKey("tx_size_in_bytes");
            generator.write(this.txSizeInBytes);
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
     * Builder for {@link Transport}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Transport> {
        @Nullable
        private Long rxCount;
        @Nullable
        private String rxSize;
        @Nullable
        private Long rxSizeInBytes;
        @Nullable
        private Long serverOpen;
        @Nullable
        private Long totalOutboundConnections;
        @Nullable
        private Long txCount;
        @Nullable
        private String txSize;
        @Nullable
        private Long txSizeInBytes;

        public Builder() {}

        private Builder(Transport o) {
            this.rxCount = o.rxCount;
            this.rxSize = o.rxSize;
            this.rxSizeInBytes = o.rxSizeInBytes;
            this.serverOpen = o.serverOpen;
            this.totalOutboundConnections = o.totalOutboundConnections;
            this.txCount = o.txCount;
            this.txSize = o.txSize;
            this.txSizeInBytes = o.txSizeInBytes;
        }

        private Builder(Builder o) {
            this.rxCount = o.rxCount;
            this.rxSize = o.rxSize;
            this.rxSizeInBytes = o.rxSizeInBytes;
            this.serverOpen = o.serverOpen;
            this.totalOutboundConnections = o.totalOutboundConnections;
            this.txCount = o.txCount;
            this.txSize = o.txSize;
            this.txSizeInBytes = o.txSizeInBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Total number of RX (receive) packets received by the node during internal cluster communication.
         * <p>
         * API name: {@code rx_count}
         * </p>
         */
        @Nonnull
        public final Builder rxCount(@Nullable Long value) {
            this.rxCount = value;
            return this;
        }

        /**
         * Size of RX packets received by the node during internal cluster communication.
         * <p>
         * API name: {@code rx_size}
         * </p>
         */
        @Nonnull
        public final Builder rxSize(@Nullable String value) {
            this.rxSize = value;
            return this;
        }

        /**
         * Size, in bytes, of RX packets received by the node during internal cluster communication.
         * <p>
         * API name: {@code rx_size_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder rxSizeInBytes(@Nullable Long value) {
            this.rxSizeInBytes = value;
            return this;
        }

        /**
         * Current number of inbound TCP connections used for internal communication between nodes.
         * <p>
         * API name: {@code server_open}
         * </p>
         */
        @Nonnull
        public final Builder serverOpen(@Nullable Long value) {
            this.serverOpen = value;
            return this;
        }

        /**
         * The cumulative number of outbound transport connections that this node has opened since it started. Each transport connection may
         * comprise multiple TCP connections but is only counted once in this statistic. Transport connections are typically long-lived so
         * this statistic should remain constant in a stable cluster.
         * <p>
         * API name: {@code total_outbound_connections}
         * </p>
         */
        @Nonnull
        public final Builder totalOutboundConnections(@Nullable Long value) {
            this.totalOutboundConnections = value;
            return this;
        }

        /**
         * Total number of TX (transmit) packets sent by the node during internal cluster communication.
         * <p>
         * API name: {@code tx_count}
         * </p>
         */
        @Nonnull
        public final Builder txCount(@Nullable Long value) {
            this.txCount = value;
            return this;
        }

        /**
         * Size of TX packets sent by the node during internal cluster communication.
         * <p>
         * API name: {@code tx_size}
         * </p>
         */
        @Nonnull
        public final Builder txSize(@Nullable String value) {
            this.txSize = value;
            return this;
        }

        /**
         * Size, in bytes, of TX packets sent by the node during internal cluster communication.
         * <p>
         * API name: {@code tx_size_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder txSizeInBytes(@Nullable Long value) {
            this.txSizeInBytes = value;
            return this;
        }

        /**
         * Builds a {@link Transport}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Transport build() {
            _checkSingleUse();

            return new Transport(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Transport}
     */
    public static final JsonpDeserializer<Transport> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Transport::setupTransportDeserializer
    );

    protected static void setupTransportDeserializer(ObjectDeserializer<Transport.Builder> op) {
        op.add(Builder::rxCount, JsonpDeserializer.longDeserializer(), "rx_count");
        op.add(Builder::rxSize, JsonpDeserializer.stringDeserializer(), "rx_size");
        op.add(Builder::rxSizeInBytes, JsonpDeserializer.longDeserializer(), "rx_size_in_bytes");
        op.add(Builder::serverOpen, JsonpDeserializer.longDeserializer(), "server_open");
        op.add(Builder::totalOutboundConnections, JsonpDeserializer.longDeserializer(), "total_outbound_connections");
        op.add(Builder::txCount, JsonpDeserializer.longDeserializer(), "tx_count");
        op.add(Builder::txSize, JsonpDeserializer.stringDeserializer(), "tx_size");
        op.add(Builder::txSizeInBytes, JsonpDeserializer.longDeserializer(), "tx_size_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.rxCount);
        result = 31 * result + Objects.hashCode(this.rxSize);
        result = 31 * result + Objects.hashCode(this.rxSizeInBytes);
        result = 31 * result + Objects.hashCode(this.serverOpen);
        result = 31 * result + Objects.hashCode(this.totalOutboundConnections);
        result = 31 * result + Objects.hashCode(this.txCount);
        result = 31 * result + Objects.hashCode(this.txSize);
        result = 31 * result + Objects.hashCode(this.txSizeInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Transport other = (Transport) o;
        return Objects.equals(this.rxCount, other.rxCount)
            && Objects.equals(this.rxSize, other.rxSize)
            && Objects.equals(this.rxSizeInBytes, other.rxSizeInBytes)
            && Objects.equals(this.serverOpen, other.serverOpen)
            && Objects.equals(this.totalOutboundConnections, other.totalOutboundConnections)
            && Objects.equals(this.txCount, other.txCount)
            && Objects.equals(this.txSize, other.txSize)
            && Objects.equals(this.txSizeInBytes, other.txSizeInBytes);
    }
}
