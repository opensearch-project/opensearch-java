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
import java.util.Map;
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

// typedef: nodes.stats.Jvm

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Jvm implements PlainJsonSerializable, ToCopyableBuilder<Jvm.Builder, Jvm> {

    @Nonnull
    private final Map<String, NodeBufferPool> bufferPools;

    @Nullable
    private final JvmClasses classes;

    @Nullable
    private final GarbageCollector gc;

    @Nullable
    private final JvmMemoryStats mem;

    @Nullable
    private final JvmThreads threads;

    @Nullable
    private final Long timestamp;

    @Nullable
    private final Time uptime;

    @Nullable
    private final Long uptimeInMillis;

    // ---------------------------------------------------------------------------------------------

    private Jvm(Builder builder) {
        this.bufferPools = ApiTypeHelper.unmodifiable(builder.bufferPools);
        this.classes = builder.classes;
        this.gc = builder.gc;
        this.mem = builder.mem;
        this.threads = builder.threads;
        this.timestamp = builder.timestamp;
        this.uptime = builder.uptime;
        this.uptimeInMillis = builder.uptimeInMillis;
    }

    public static Jvm of(Function<Jvm.Builder, ObjectBuilder<Jvm>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Contains statistics about JVM buffer pools for the node.
     * <p>
     * API name: {@code buffer_pools}
     * </p>
     */
    @Nonnull
    public final Map<String, NodeBufferPool> bufferPools() {
        return this.bufferPools;
    }

    /**
     * API name: {@code classes}
     */
    @Nullable
    public final JvmClasses classes() {
        return this.classes;
    }

    /**
     * API name: {@code gc}
     */
    @Nullable
    public final GarbageCollector gc() {
        return this.gc;
    }

    /**
     * API name: {@code mem}
     */
    @Nullable
    public final JvmMemoryStats mem() {
        return this.mem;
    }

    /**
     * API name: {@code threads}
     */
    @Nullable
    public final JvmThreads threads() {
        return this.threads;
    }

    /**
     * Last time JVM statistics were refreshed.
     * <p>
     * API name: {@code timestamp}
     * </p>
     */
    @Nullable
    public final Long timestamp() {
        return this.timestamp;
    }

    /**
     * Human-readable JVM uptime. Only returned if the <code>human</code> query parameter is <code>true</code>.
     * <p>
     * API name: {@code uptime}
     * </p>
     */
    @Nullable
    public final Time uptime() {
        return this.uptime;
    }

    /**
     * JVM uptime in milliseconds.
     * <p>
     * API name: {@code uptime_in_millis}
     * </p>
     */
    @Nullable
    public final Long uptimeInMillis() {
        return this.uptimeInMillis;
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
        if (ApiTypeHelper.isDefined(this.bufferPools)) {
            generator.writeKey("buffer_pools");
            generator.writeStartObject();
            for (Map.Entry<String, NodeBufferPool> item0 : this.bufferPools.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.classes != null) {
            generator.writeKey("classes");
            this.classes.serialize(generator, mapper);
        }

        if (this.gc != null) {
            generator.writeKey("gc");
            this.gc.serialize(generator, mapper);
        }

        if (this.mem != null) {
            generator.writeKey("mem");
            this.mem.serialize(generator, mapper);
        }

        if (this.threads != null) {
            generator.writeKey("threads");
            this.threads.serialize(generator, mapper);
        }

        if (this.timestamp != null) {
            generator.writeKey("timestamp");
            generator.write(this.timestamp);
        }

        if (this.uptime != null) {
            generator.writeKey("uptime");
            this.uptime.serialize(generator, mapper);
        }

        if (this.uptimeInMillis != null) {
            generator.writeKey("uptime_in_millis");
            generator.write(this.uptimeInMillis);
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
     * Builder for {@link Jvm}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Jvm> {
        @Nullable
        private Map<String, NodeBufferPool> bufferPools;
        @Nullable
        private JvmClasses classes;
        @Nullable
        private GarbageCollector gc;
        @Nullable
        private JvmMemoryStats mem;
        @Nullable
        private JvmThreads threads;
        @Nullable
        private Long timestamp;
        @Nullable
        private Time uptime;
        @Nullable
        private Long uptimeInMillis;

        public Builder() {}

        private Builder(Jvm o) {
            this.bufferPools = _mapCopy(o.bufferPools);
            this.classes = o.classes;
            this.gc = o.gc;
            this.mem = o.mem;
            this.threads = o.threads;
            this.timestamp = o.timestamp;
            this.uptime = o.uptime;
            this.uptimeInMillis = o.uptimeInMillis;
        }

        private Builder(Builder o) {
            this.bufferPools = _mapCopy(o.bufferPools);
            this.classes = o.classes;
            this.gc = o.gc;
            this.mem = o.mem;
            this.threads = o.threads;
            this.timestamp = o.timestamp;
            this.uptime = o.uptime;
            this.uptimeInMillis = o.uptimeInMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Contains statistics about JVM buffer pools for the node.
         * <p>
         * API name: {@code buffer_pools}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>bufferPools</code>.
         * </p>
         */
        @Nonnull
        public final Builder bufferPools(Map<String, NodeBufferPool> map) {
            this.bufferPools = _mapPutAll(this.bufferPools, map);
            return this;
        }

        /**
         * Contains statistics about JVM buffer pools for the node.
         * <p>
         * API name: {@code buffer_pools}
         * </p>
         *
         * <p>
         * Adds an entry to <code>bufferPools</code>.
         * </p>
         */
        @Nonnull
        public final Builder bufferPools(String key, NodeBufferPool value) {
            this.bufferPools = _mapPut(this.bufferPools, key, value);
            return this;
        }

        /**
         * Contains statistics about JVM buffer pools for the node.
         * <p>
         * API name: {@code buffer_pools}
         * </p>
         *
         * <p>
         * Adds a value to <code>bufferPools</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder bufferPools(String key, Function<NodeBufferPool.Builder, ObjectBuilder<NodeBufferPool>> fn) {
            return bufferPools(key, fn.apply(new NodeBufferPool.Builder()).build());
        }

        /**
         * API name: {@code classes}
         */
        @Nonnull
        public final Builder classes(@Nullable JvmClasses value) {
            this.classes = value;
            return this;
        }

        /**
         * API name: {@code classes}
         */
        @Nonnull
        public final Builder classes(Function<JvmClasses.Builder, ObjectBuilder<JvmClasses>> fn) {
            return classes(fn.apply(new JvmClasses.Builder()).build());
        }

        /**
         * API name: {@code gc}
         */
        @Nonnull
        public final Builder gc(@Nullable GarbageCollector value) {
            this.gc = value;
            return this;
        }

        /**
         * API name: {@code gc}
         */
        @Nonnull
        public final Builder gc(Function<GarbageCollector.Builder, ObjectBuilder<GarbageCollector>> fn) {
            return gc(fn.apply(new GarbageCollector.Builder()).build());
        }

        /**
         * API name: {@code mem}
         */
        @Nonnull
        public final Builder mem(@Nullable JvmMemoryStats value) {
            this.mem = value;
            return this;
        }

        /**
         * API name: {@code mem}
         */
        @Nonnull
        public final Builder mem(Function<JvmMemoryStats.Builder, ObjectBuilder<JvmMemoryStats>> fn) {
            return mem(fn.apply(new JvmMemoryStats.Builder()).build());
        }

        /**
         * API name: {@code threads}
         */
        @Nonnull
        public final Builder threads(@Nullable JvmThreads value) {
            this.threads = value;
            return this;
        }

        /**
         * API name: {@code threads}
         */
        @Nonnull
        public final Builder threads(Function<JvmThreads.Builder, ObjectBuilder<JvmThreads>> fn) {
            return threads(fn.apply(new JvmThreads.Builder()).build());
        }

        /**
         * Last time JVM statistics were refreshed.
         * <p>
         * API name: {@code timestamp}
         * </p>
         */
        @Nonnull
        public final Builder timestamp(@Nullable Long value) {
            this.timestamp = value;
            return this;
        }

        /**
         * Human-readable JVM uptime. Only returned if the <code>human</code> query parameter is <code>true</code>.
         * <p>
         * API name: {@code uptime}
         * </p>
         */
        @Nonnull
        public final Builder uptime(@Nullable Time value) {
            this.uptime = value;
            return this;
        }

        /**
         * Human-readable JVM uptime. Only returned if the <code>human</code> query parameter is <code>true</code>.
         * <p>
         * API name: {@code uptime}
         * </p>
         */
        @Nonnull
        public final Builder uptime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return uptime(fn.apply(new Time.Builder()).build());
        }

        /**
         * JVM uptime in milliseconds.
         * <p>
         * API name: {@code uptime_in_millis}
         * </p>
         */
        @Nonnull
        public final Builder uptimeInMillis(@Nullable Long value) {
            this.uptimeInMillis = value;
            return this;
        }

        /**
         * Builds a {@link Jvm}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Jvm build() {
            _checkSingleUse();

            return new Jvm(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Jvm}
     */
    public static final JsonpDeserializer<Jvm> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new, Jvm::setupJvmDeserializer);

    protected static void setupJvmDeserializer(ObjectDeserializer<Jvm.Builder> op) {
        op.add(Builder::bufferPools, JsonpDeserializer.stringMapDeserializer(NodeBufferPool._DESERIALIZER), "buffer_pools");
        op.add(Builder::classes, JvmClasses._DESERIALIZER, "classes");
        op.add(Builder::gc, GarbageCollector._DESERIALIZER, "gc");
        op.add(Builder::mem, JvmMemoryStats._DESERIALIZER, "mem");
        op.add(Builder::threads, JvmThreads._DESERIALIZER, "threads");
        op.add(Builder::timestamp, JsonpDeserializer.longDeserializer(), "timestamp");
        op.add(Builder::uptime, Time._DESERIALIZER, "uptime");
        op.add(Builder::uptimeInMillis, JsonpDeserializer.longDeserializer(), "uptime_in_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.bufferPools);
        result = 31 * result + Objects.hashCode(this.classes);
        result = 31 * result + Objects.hashCode(this.gc);
        result = 31 * result + Objects.hashCode(this.mem);
        result = 31 * result + Objects.hashCode(this.threads);
        result = 31 * result + Objects.hashCode(this.timestamp);
        result = 31 * result + Objects.hashCode(this.uptime);
        result = 31 * result + Objects.hashCode(this.uptimeInMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Jvm other = (Jvm) o;
        return Objects.equals(this.bufferPools, other.bufferPools)
            && Objects.equals(this.classes, other.classes)
            && Objects.equals(this.gc, other.gc)
            && Objects.equals(this.mem, other.mem)
            && Objects.equals(this.threads, other.threads)
            && Objects.equals(this.timestamp, other.timestamp)
            && Objects.equals(this.uptime, other.uptime)
            && Objects.equals(this.uptimeInMillis, other.uptimeInMillis);
    }
}
