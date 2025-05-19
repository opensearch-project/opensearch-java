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

package org.opensearch.client.opensearch.cat.thread_pool;

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

// typedef: cat.thread_pool.ThreadPoolRecord

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ThreadPoolRecord implements PlainJsonSerializable, ToCopyableBuilder<ThreadPoolRecord.Builder, ThreadPoolRecord> {

    @Nullable
    private final String active;

    @Nullable
    private final String completed;

    @Nullable
    private final String core;

    @Nullable
    private final String ephemeralNodeId;

    @Nullable
    private final String host;

    @Nullable
    private final String ip;

    @Nullable
    private final String keepAlive;

    @Nullable
    private final String largest;

    @Nullable
    private final String max;

    @Nullable
    private final String name;

    @Nullable
    private final String nodeId;

    @Nullable
    private final String nodeName;

    @Nullable
    private final String pid;

    @Nullable
    private final String poolSize;

    @Nullable
    private final String port;

    @Nullable
    private final String queue;

    @Nullable
    private final String queueSize;

    @Nullable
    private final String rejected;

    @Nullable
    private final String size;

    @Nullable
    private final String totalWaitTime;

    @Nullable
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private ThreadPoolRecord(Builder builder) {
        this.active = builder.active;
        this.completed = builder.completed;
        this.core = builder.core;
        this.ephemeralNodeId = builder.ephemeralNodeId;
        this.host = builder.host;
        this.ip = builder.ip;
        this.keepAlive = builder.keepAlive;
        this.largest = builder.largest;
        this.max = builder.max;
        this.name = builder.name;
        this.nodeId = builder.nodeId;
        this.nodeName = builder.nodeName;
        this.pid = builder.pid;
        this.poolSize = builder.poolSize;
        this.port = builder.port;
        this.queue = builder.queue;
        this.queueSize = builder.queueSize;
        this.rejected = builder.rejected;
        this.size = builder.size;
        this.totalWaitTime = builder.totalWaitTime;
        this.type = builder.type;
    }

    public static ThreadPoolRecord of(Function<ThreadPoolRecord.Builder, ObjectBuilder<ThreadPoolRecord>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The number of active threads in the current thread pool.
     * <p>
     * API name: {@code active}
     * </p>
     */
    @Nullable
    public final String active() {
        return this.active;
    }

    /**
     * The number of completed tasks.
     * <p>
     * API name: {@code completed}
     * </p>
     */
    @Nullable
    public final String completed() {
        return this.completed;
    }

    /**
     * The core number of active threads allowed in a scaling thread pool.
     * <p>
     * API name: {@code core}
     * </p>
     */
    @Nullable
    public final String core() {
        return this.core;
    }

    /**
     * The ephemeral node identifier.
     * <p>
     * API name: {@code ephemeral_node_id}
     * </p>
     */
    @Nullable
    public final String ephemeralNodeId() {
        return this.ephemeralNodeId;
    }

    /**
     * The hostname for the current node.
     * <p>
     * API name: {@code host}
     * </p>
     */
    @Nullable
    public final String host() {
        return this.host;
    }

    /**
     * The IP address for the current node.
     * <p>
     * API name: {@code ip}
     * </p>
     */
    @Nullable
    public final String ip() {
        return this.ip;
    }

    /**
     * The thread keep alive time.
     * <p>
     * API name: {@code keep_alive}
     * </p>
     */
    @Nullable
    public final String keepAlive() {
        return this.keepAlive;
    }

    /**
     * The highest number of active threads in the current thread pool.
     * <p>
     * API name: {@code largest}
     * </p>
     */
    @Nullable
    public final String largest() {
        return this.largest;
    }

    /**
     * The maximum number of active threads allowed in a scaling thread pool.
     * <p>
     * API name: {@code max}
     * </p>
     */
    @Nullable
    public final String max() {
        return this.max;
    }

    /**
     * The thread pool name.
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * API name: {@code node_id}
     */
    @Nullable
    public final String nodeId() {
        return this.nodeId;
    }

    /**
     * The node name.
     * <p>
     * API name: {@code node_name}
     * </p>
     */
    @Nullable
    public final String nodeName() {
        return this.nodeName;
    }

    /**
     * The process identifier.
     * <p>
     * API name: {@code pid}
     * </p>
     */
    @Nullable
    public final String pid() {
        return this.pid;
    }

    /**
     * The number of threads in the current thread pool.
     * <p>
     * API name: {@code pool_size}
     * </p>
     */
    @Nullable
    public final String poolSize() {
        return this.poolSize;
    }

    /**
     * The bound transport port for the current node.
     * <p>
     * API name: {@code port}
     * </p>
     */
    @Nullable
    public final String port() {
        return this.port;
    }

    /**
     * The number of tasks currently in queue.
     * <p>
     * API name: {@code queue}
     * </p>
     */
    @Nullable
    public final String queue() {
        return this.queue;
    }

    /**
     * The maximum number of tasks permitted in the queue.
     * <p>
     * API name: {@code queue_size}
     * </p>
     */
    @Nullable
    public final String queueSize() {
        return this.queueSize;
    }

    /**
     * The number of rejected tasks.
     * <p>
     * API name: {@code rejected}
     * </p>
     */
    @Nullable
    public final String rejected() {
        return this.rejected;
    }

    /**
     * The number of active threads allowed in a fixed thread pool.
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final String size() {
        return this.size;
    }

    /**
     * API name: {@code total_wait_time}
     */
    @Nullable
    public final String totalWaitTime() {
        return this.totalWaitTime;
    }

    /**
     * The thread pool type. Returned values include <code>fixed</code>, <code>fixed_auto_queue_size</code>, <code>direct</code>, and
     * <code>scaling</code>.
     * <p>
     * API name: {@code type}
     * </p>
     */
    @Nullable
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
        if (this.active != null) {
            generator.writeKey("active");
            generator.write(this.active);
        }

        if (this.completed != null) {
            generator.writeKey("completed");
            generator.write(this.completed);
        }

        if (this.core != null) {
            generator.writeKey("core");
            generator.write(this.core);
        }

        if (this.ephemeralNodeId != null) {
            generator.writeKey("ephemeral_node_id");
            generator.write(this.ephemeralNodeId);
        }

        if (this.host != null) {
            generator.writeKey("host");
            generator.write(this.host);
        }

        if (this.ip != null) {
            generator.writeKey("ip");
            generator.write(this.ip);
        }

        if (this.keepAlive != null) {
            generator.writeKey("keep_alive");
            generator.write(this.keepAlive);
        }

        if (this.largest != null) {
            generator.writeKey("largest");
            generator.write(this.largest);
        }

        if (this.max != null) {
            generator.writeKey("max");
            generator.write(this.max);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (this.nodeId != null) {
            generator.writeKey("node_id");
            generator.write(this.nodeId);
        }

        if (this.nodeName != null) {
            generator.writeKey("node_name");
            generator.write(this.nodeName);
        }

        if (this.pid != null) {
            generator.writeKey("pid");
            generator.write(this.pid);
        }

        if (this.poolSize != null) {
            generator.writeKey("pool_size");
            generator.write(this.poolSize);
        }

        if (this.port != null) {
            generator.writeKey("port");
            generator.write(this.port);
        }

        if (this.queue != null) {
            generator.writeKey("queue");
            generator.write(this.queue);
        }

        if (this.queueSize != null) {
            generator.writeKey("queue_size");
            generator.write(this.queueSize);
        }

        if (this.rejected != null) {
            generator.writeKey("rejected");
            generator.write(this.rejected);
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        if (this.totalWaitTime != null) {
            generator.writeKey("total_wait_time");
            generator.write(this.totalWaitTime);
        }

        if (this.type != null) {
            generator.writeKey("type");
            generator.write(this.type);
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
     * Builder for {@link ThreadPoolRecord}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ThreadPoolRecord> {
        @Nullable
        private String active;
        @Nullable
        private String completed;
        @Nullable
        private String core;
        @Nullable
        private String ephemeralNodeId;
        @Nullable
        private String host;
        @Nullable
        private String ip;
        @Nullable
        private String keepAlive;
        @Nullable
        private String largest;
        @Nullable
        private String max;
        @Nullable
        private String name;
        @Nullable
        private String nodeId;
        @Nullable
        private String nodeName;
        @Nullable
        private String pid;
        @Nullable
        private String poolSize;
        @Nullable
        private String port;
        @Nullable
        private String queue;
        @Nullable
        private String queueSize;
        @Nullable
        private String rejected;
        @Nullable
        private String size;
        @Nullable
        private String totalWaitTime;
        @Nullable
        private String type;

        public Builder() {}

        private Builder(ThreadPoolRecord o) {
            this.active = o.active;
            this.completed = o.completed;
            this.core = o.core;
            this.ephemeralNodeId = o.ephemeralNodeId;
            this.host = o.host;
            this.ip = o.ip;
            this.keepAlive = o.keepAlive;
            this.largest = o.largest;
            this.max = o.max;
            this.name = o.name;
            this.nodeId = o.nodeId;
            this.nodeName = o.nodeName;
            this.pid = o.pid;
            this.poolSize = o.poolSize;
            this.port = o.port;
            this.queue = o.queue;
            this.queueSize = o.queueSize;
            this.rejected = o.rejected;
            this.size = o.size;
            this.totalWaitTime = o.totalWaitTime;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.active = o.active;
            this.completed = o.completed;
            this.core = o.core;
            this.ephemeralNodeId = o.ephemeralNodeId;
            this.host = o.host;
            this.ip = o.ip;
            this.keepAlive = o.keepAlive;
            this.largest = o.largest;
            this.max = o.max;
            this.name = o.name;
            this.nodeId = o.nodeId;
            this.nodeName = o.nodeName;
            this.pid = o.pid;
            this.poolSize = o.poolSize;
            this.port = o.port;
            this.queue = o.queue;
            this.queueSize = o.queueSize;
            this.rejected = o.rejected;
            this.size = o.size;
            this.totalWaitTime = o.totalWaitTime;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The number of active threads in the current thread pool.
         * <p>
         * API name: {@code active}
         * </p>
         */
        @Nonnull
        public final Builder active(@Nullable String value) {
            this.active = value;
            return this;
        }

        /**
         * The number of completed tasks.
         * <p>
         * API name: {@code completed}
         * </p>
         */
        @Nonnull
        public final Builder completed(@Nullable String value) {
            this.completed = value;
            return this;
        }

        /**
         * The core number of active threads allowed in a scaling thread pool.
         * <p>
         * API name: {@code core}
         * </p>
         */
        @Nonnull
        public final Builder core(@Nullable String value) {
            this.core = value;
            return this;
        }

        /**
         * The ephemeral node identifier.
         * <p>
         * API name: {@code ephemeral_node_id}
         * </p>
         */
        @Nonnull
        public final Builder ephemeralNodeId(@Nullable String value) {
            this.ephemeralNodeId = value;
            return this;
        }

        /**
         * The hostname for the current node.
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
         * The IP address for the current node.
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
         * The thread keep alive time.
         * <p>
         * API name: {@code keep_alive}
         * </p>
         */
        @Nonnull
        public final Builder keepAlive(@Nullable String value) {
            this.keepAlive = value;
            return this;
        }

        /**
         * The highest number of active threads in the current thread pool.
         * <p>
         * API name: {@code largest}
         * </p>
         */
        @Nonnull
        public final Builder largest(@Nullable String value) {
            this.largest = value;
            return this;
        }

        /**
         * The maximum number of active threads allowed in a scaling thread pool.
         * <p>
         * API name: {@code max}
         * </p>
         */
        @Nonnull
        public final Builder max(@Nullable String value) {
            this.max = value;
            return this;
        }

        /**
         * The thread pool name.
         * <p>
         * API name: {@code name}
         * </p>
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * API name: {@code node_id}
         */
        @Nonnull
        public final Builder nodeId(@Nullable String value) {
            this.nodeId = value;
            return this;
        }

        /**
         * The node name.
         * <p>
         * API name: {@code node_name}
         * </p>
         */
        @Nonnull
        public final Builder nodeName(@Nullable String value) {
            this.nodeName = value;
            return this;
        }

        /**
         * The process identifier.
         * <p>
         * API name: {@code pid}
         * </p>
         */
        @Nonnull
        public final Builder pid(@Nullable String value) {
            this.pid = value;
            return this;
        }

        /**
         * The number of threads in the current thread pool.
         * <p>
         * API name: {@code pool_size}
         * </p>
         */
        @Nonnull
        public final Builder poolSize(@Nullable String value) {
            this.poolSize = value;
            return this;
        }

        /**
         * The bound transport port for the current node.
         * <p>
         * API name: {@code port}
         * </p>
         */
        @Nonnull
        public final Builder port(@Nullable String value) {
            this.port = value;
            return this;
        }

        /**
         * The number of tasks currently in queue.
         * <p>
         * API name: {@code queue}
         * </p>
         */
        @Nonnull
        public final Builder queue(@Nullable String value) {
            this.queue = value;
            return this;
        }

        /**
         * The maximum number of tasks permitted in the queue.
         * <p>
         * API name: {@code queue_size}
         * </p>
         */
        @Nonnull
        public final Builder queueSize(@Nullable String value) {
            this.queueSize = value;
            return this;
        }

        /**
         * The number of rejected tasks.
         * <p>
         * API name: {@code rejected}
         * </p>
         */
        @Nonnull
        public final Builder rejected(@Nullable String value) {
            this.rejected = value;
            return this;
        }

        /**
         * The number of active threads allowed in a fixed thread pool.
         * <p>
         * API name: {@code size}
         * </p>
         */
        @Nonnull
        public final Builder size(@Nullable String value) {
            this.size = value;
            return this;
        }

        /**
         * API name: {@code total_wait_time}
         */
        @Nonnull
        public final Builder totalWaitTime(@Nullable String value) {
            this.totalWaitTime = value;
            return this;
        }

        /**
         * The thread pool type. Returned values include <code>fixed</code>, <code>fixed_auto_queue_size</code>, <code>direct</code>, and
         * <code>scaling</code>.
         * <p>
         * API name: {@code type}
         * </p>
         */
        @Nonnull
        public final Builder type(@Nullable String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link ThreadPoolRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ThreadPoolRecord build() {
            _checkSingleUse();

            return new ThreadPoolRecord(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ThreadPoolRecord}
     */
    public static final JsonpDeserializer<ThreadPoolRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ThreadPoolRecord::setupThreadPoolRecordDeserializer
    );

    protected static void setupThreadPoolRecordDeserializer(ObjectDeserializer<ThreadPoolRecord.Builder> op) {
        op.add(Builder::active, JsonpDeserializer.stringDeserializer(), "active");
        op.add(Builder::completed, JsonpDeserializer.stringDeserializer(), "completed");
        op.add(Builder::core, JsonpDeserializer.stringDeserializer(), "core");
        op.add(Builder::ephemeralNodeId, JsonpDeserializer.stringDeserializer(), "ephemeral_node_id");
        op.add(Builder::host, JsonpDeserializer.stringDeserializer(), "host");
        op.add(Builder::ip, JsonpDeserializer.stringDeserializer(), "ip");
        op.add(Builder::keepAlive, JsonpDeserializer.stringDeserializer(), "keep_alive");
        op.add(Builder::largest, JsonpDeserializer.stringDeserializer(), "largest");
        op.add(Builder::max, JsonpDeserializer.stringDeserializer(), "max");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::nodeId, JsonpDeserializer.stringDeserializer(), "node_id");
        op.add(Builder::nodeName, JsonpDeserializer.stringDeserializer(), "node_name");
        op.add(Builder::pid, JsonpDeserializer.stringDeserializer(), "pid");
        op.add(Builder::poolSize, JsonpDeserializer.stringDeserializer(), "pool_size");
        op.add(Builder::port, JsonpDeserializer.stringDeserializer(), "port");
        op.add(Builder::queue, JsonpDeserializer.stringDeserializer(), "queue");
        op.add(Builder::queueSize, JsonpDeserializer.stringDeserializer(), "queue_size");
        op.add(Builder::rejected, JsonpDeserializer.stringDeserializer(), "rejected");
        op.add(Builder::size, JsonpDeserializer.stringDeserializer(), "size");
        op.add(Builder::totalWaitTime, JsonpDeserializer.stringDeserializer(), "total_wait_time");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.active);
        result = 31 * result + Objects.hashCode(this.completed);
        result = 31 * result + Objects.hashCode(this.core);
        result = 31 * result + Objects.hashCode(this.ephemeralNodeId);
        result = 31 * result + Objects.hashCode(this.host);
        result = 31 * result + Objects.hashCode(this.ip);
        result = 31 * result + Objects.hashCode(this.keepAlive);
        result = 31 * result + Objects.hashCode(this.largest);
        result = 31 * result + Objects.hashCode(this.max);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.nodeId);
        result = 31 * result + Objects.hashCode(this.nodeName);
        result = 31 * result + Objects.hashCode(this.pid);
        result = 31 * result + Objects.hashCode(this.poolSize);
        result = 31 * result + Objects.hashCode(this.port);
        result = 31 * result + Objects.hashCode(this.queue);
        result = 31 * result + Objects.hashCode(this.queueSize);
        result = 31 * result + Objects.hashCode(this.rejected);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.totalWaitTime);
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ThreadPoolRecord other = (ThreadPoolRecord) o;
        return Objects.equals(this.active, other.active)
            && Objects.equals(this.completed, other.completed)
            && Objects.equals(this.core, other.core)
            && Objects.equals(this.ephemeralNodeId, other.ephemeralNodeId)
            && Objects.equals(this.host, other.host)
            && Objects.equals(this.ip, other.ip)
            && Objects.equals(this.keepAlive, other.keepAlive)
            && Objects.equals(this.largest, other.largest)
            && Objects.equals(this.max, other.max)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.nodeId, other.nodeId)
            && Objects.equals(this.nodeName, other.nodeName)
            && Objects.equals(this.pid, other.pid)
            && Objects.equals(this.poolSize, other.poolSize)
            && Objects.equals(this.port, other.port)
            && Objects.equals(this.queue, other.queue)
            && Objects.equals(this.queueSize, other.queueSize)
            && Objects.equals(this.rejected, other.rejected)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.totalWaitTime, other.totalWaitTime)
            && Objects.equals(this.type, other.type);
    }
}
