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

package org.opensearch.client.opensearch.cat.allocation;

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

// typedef: cat.allocation.AllocationRecord

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AllocationRecord implements PlainJsonSerializable, ToCopyableBuilder<AllocationRecord.Builder, AllocationRecord> {

    @Nullable
    private final String diskAvail;

    @Nullable
    private final String diskIndices;

    @Nullable
    private final String diskPercent;

    @Nullable
    private final String diskTotal;

    @Nullable
    private final String diskUsed;

    @Nullable
    private final String host;

    @Nullable
    private final String ip;

    @Nullable
    private final String node;

    @Nullable
    private final String shards;

    // ---------------------------------------------------------------------------------------------

    private AllocationRecord(Builder builder) {
        this.diskAvail = builder.diskAvail;
        this.diskIndices = builder.diskIndices;
        this.diskPercent = builder.diskPercent;
        this.diskTotal = builder.diskTotal;
        this.diskUsed = builder.diskUsed;
        this.host = builder.host;
        this.ip = builder.ip;
        this.node = builder.node;
        this.shards = builder.shards;
    }

    public static AllocationRecord of(Function<AllocationRecord.Builder, ObjectBuilder<AllocationRecord>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Free disk space available to OpenSearch. OpenSearch retrieves this metric from the node's operating system. Disk-based shard
     * allocation uses this metric to assign shards to nodes based on available disk space.
     * <p>
     * API name: {@code disk.avail}
     * </p>
     */
    @Nullable
    public final String diskAvail() {
        return this.diskAvail;
    }

    /**
     * Disk space used by the node's shards. Does not include disk space for the translog or unassigned shards. IMPORTANT: This metric
     * double-counts disk space for hard-linked files, such as those created when shrinking, splitting, or cloning an index.
     * <p>
     * API name: {@code disk.indices}
     * </p>
     */
    @Nullable
    public final String diskIndices() {
        return this.diskIndices;
    }

    /**
     * Total percentage of disk space in use. Calculated as <code>disk.used / disk.total</code>.
     * <p>
     * API name: {@code disk.percent}
     * </p>
     */
    @Nullable
    public final String diskPercent() {
        return this.diskPercent;
    }

    /**
     * Total disk space for the node, including in-use and available space.
     * <p>
     * API name: {@code disk.total}
     * </p>
     */
    @Nullable
    public final String diskTotal() {
        return this.diskTotal;
    }

    /**
     * Total disk space in use. OpenSearch retrieves this metric from the node's operating system (OS). The metric includes disk space for:
     * OpenSearch, including the translog and unassigned shards; the node's operating system; any other applications or files on the node.
     * Unlike <code>disk.indices</code>, this metric does not double-count disk space for hard-linked files.
     * <p>
     * API name: {@code disk.used}
     * </p>
     */
    @Nullable
    public final String diskUsed() {
        return this.diskUsed;
    }

    /**
     * Network host for the node. Set using the <code>network.host</code> setting.
     * <p>
     * API name: {@code host}
     * </p>
     */
    @Nullable
    public final String host() {
        return this.host;
    }

    /**
     * IP address and port for the node.
     * <p>
     * API name: {@code ip}
     * </p>
     */
    @Nullable
    public final String ip() {
        return this.ip;
    }

    /**
     * Name for the node. Set using the <code>node.name</code> setting.
     * <p>
     * API name: {@code node}
     * </p>
     */
    @Nullable
    public final String node() {
        return this.node;
    }

    /**
     * Number of primary and replica shards assigned to the node.
     * <p>
     * API name: {@code shards}
     * </p>
     */
    @Nullable
    public final String shards() {
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
        if (this.diskAvail != null) {
            generator.writeKey("disk.avail");
            generator.write(this.diskAvail);
        }

        if (this.diskIndices != null) {
            generator.writeKey("disk.indices");
            generator.write(this.diskIndices);
        }

        if (this.diskPercent != null) {
            generator.writeKey("disk.percent");
            generator.write(this.diskPercent);
        }

        if (this.diskTotal != null) {
            generator.writeKey("disk.total");
            generator.write(this.diskTotal);
        }

        if (this.diskUsed != null) {
            generator.writeKey("disk.used");
            generator.write(this.diskUsed);
        }

        if (this.host != null) {
            generator.writeKey("host");
            generator.write(this.host);
        }

        if (this.ip != null) {
            generator.writeKey("ip");
            generator.write(this.ip);
        }

        if (this.node != null) {
            generator.writeKey("node");
            generator.write(this.node);
        }

        if (this.shards != null) {
            generator.writeKey("shards");
            generator.write(this.shards);
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
     * Builder for {@link AllocationRecord}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AllocationRecord> {
        @Nullable
        private String diskAvail;
        @Nullable
        private String diskIndices;
        @Nullable
        private String diskPercent;
        @Nullable
        private String diskTotal;
        @Nullable
        private String diskUsed;
        @Nullable
        private String host;
        @Nullable
        private String ip;
        @Nullable
        private String node;
        @Nullable
        private String shards;

        public Builder() {}

        private Builder(AllocationRecord o) {
            this.diskAvail = o.diskAvail;
            this.diskIndices = o.diskIndices;
            this.diskPercent = o.diskPercent;
            this.diskTotal = o.diskTotal;
            this.diskUsed = o.diskUsed;
            this.host = o.host;
            this.ip = o.ip;
            this.node = o.node;
            this.shards = o.shards;
        }

        private Builder(Builder o) {
            this.diskAvail = o.diskAvail;
            this.diskIndices = o.diskIndices;
            this.diskPercent = o.diskPercent;
            this.diskTotal = o.diskTotal;
            this.diskUsed = o.diskUsed;
            this.host = o.host;
            this.ip = o.ip;
            this.node = o.node;
            this.shards = o.shards;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Free disk space available to OpenSearch. OpenSearch retrieves this metric from the node's operating system. Disk-based shard
         * allocation uses this metric to assign shards to nodes based on available disk space.
         * <p>
         * API name: {@code disk.avail}
         * </p>
         */
        @Nonnull
        public final Builder diskAvail(@Nullable String value) {
            this.diskAvail = value;
            return this;
        }

        /**
         * Disk space used by the node's shards. Does not include disk space for the translog or unassigned shards. IMPORTANT: This metric
         * double-counts disk space for hard-linked files, such as those created when shrinking, splitting, or cloning an index.
         * <p>
         * API name: {@code disk.indices}
         * </p>
         */
        @Nonnull
        public final Builder diskIndices(@Nullable String value) {
            this.diskIndices = value;
            return this;
        }

        /**
         * Total percentage of disk space in use. Calculated as <code>disk.used / disk.total</code>.
         * <p>
         * API name: {@code disk.percent}
         * </p>
         */
        @Nonnull
        public final Builder diskPercent(@Nullable String value) {
            this.diskPercent = value;
            return this;
        }

        /**
         * Total disk space for the node, including in-use and available space.
         * <p>
         * API name: {@code disk.total}
         * </p>
         */
        @Nonnull
        public final Builder diskTotal(@Nullable String value) {
            this.diskTotal = value;
            return this;
        }

        /**
         * Total disk space in use. OpenSearch retrieves this metric from the node's operating system (OS). The metric includes disk space
         * for: OpenSearch, including the translog and unassigned shards; the node's operating system; any other applications or files on
         * the node. Unlike <code>disk.indices</code>, this metric does not double-count disk space for hard-linked files.
         * <p>
         * API name: {@code disk.used}
         * </p>
         */
        @Nonnull
        public final Builder diskUsed(@Nullable String value) {
            this.diskUsed = value;
            return this;
        }

        /**
         * Network host for the node. Set using the <code>network.host</code> setting.
         * <p>
         * API name: {@code host}
         * </p>
         */
        @Nonnull
        public final Builder host(@Nullable String value) {
            this.host = value;
            return this;
        }

        /**
         * IP address and port for the node.
         * <p>
         * API name: {@code ip}
         * </p>
         */
        @Nonnull
        public final Builder ip(@Nullable String value) {
            this.ip = value;
            return this;
        }

        /**
         * Name for the node. Set using the <code>node.name</code> setting.
         * <p>
         * API name: {@code node}
         * </p>
         */
        @Nonnull
        public final Builder node(@Nullable String value) {
            this.node = value;
            return this;
        }

        /**
         * Number of primary and replica shards assigned to the node.
         * <p>
         * API name: {@code shards}
         * </p>
         */
        @Nonnull
        public final Builder shards(@Nullable String value) {
            this.shards = value;
            return this;
        }

        /**
         * Builds a {@link AllocationRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AllocationRecord build() {
            _checkSingleUse();

            return new AllocationRecord(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AllocationRecord}
     */
    public static final JsonpDeserializer<AllocationRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AllocationRecord::setupAllocationRecordDeserializer
    );

    protected static void setupAllocationRecordDeserializer(ObjectDeserializer<AllocationRecord.Builder> op) {
        op.add(Builder::diskAvail, JsonpDeserializer.stringDeserializer(), "disk.avail");
        op.add(Builder::diskIndices, JsonpDeserializer.stringDeserializer(), "disk.indices");
        op.add(Builder::diskPercent, JsonpDeserializer.stringDeserializer(), "disk.percent");
        op.add(Builder::diskTotal, JsonpDeserializer.stringDeserializer(), "disk.total");
        op.add(Builder::diskUsed, JsonpDeserializer.stringDeserializer(), "disk.used");
        op.add(Builder::host, JsonpDeserializer.stringDeserializer(), "host");
        op.add(Builder::ip, JsonpDeserializer.stringDeserializer(), "ip");
        op.add(Builder::node, JsonpDeserializer.stringDeserializer(), "node");
        op.add(Builder::shards, JsonpDeserializer.stringDeserializer(), "shards");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.diskAvail);
        result = 31 * result + Objects.hashCode(this.diskIndices);
        result = 31 * result + Objects.hashCode(this.diskPercent);
        result = 31 * result + Objects.hashCode(this.diskTotal);
        result = 31 * result + Objects.hashCode(this.diskUsed);
        result = 31 * result + Objects.hashCode(this.host);
        result = 31 * result + Objects.hashCode(this.ip);
        result = 31 * result + Objects.hashCode(this.node);
        result = 31 * result + Objects.hashCode(this.shards);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AllocationRecord other = (AllocationRecord) o;
        return Objects.equals(this.diskAvail, other.diskAvail)
            && Objects.equals(this.diskIndices, other.diskIndices)
            && Objects.equals(this.diskPercent, other.diskPercent)
            && Objects.equals(this.diskTotal, other.diskTotal)
            && Objects.equals(this.diskUsed, other.diskUsed)
            && Objects.equals(this.host, other.host)
            && Objects.equals(this.ip, other.ip)
            && Objects.equals(this.node, other.node)
            && Objects.equals(this.shards, other.shards);
    }
}
