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

package org.opensearch.client.opensearch.cluster.stats;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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

// typedef: cluster.stats.ClusterJvm

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterJvm implements PlainJsonSerializable, ToCopyableBuilder<ClusterJvm.Builder, ClusterJvm> {

    @Nullable
    private final Time maxUptime;

    private final long maxUptimeInMillis;

    @Nonnull
    private final ClusterJvmMemory mem;

    private final long threads;

    @Nonnull
    private final List<ClusterJvmVersion> versions;

    // ---------------------------------------------------------------------------------------------

    private ClusterJvm(Builder builder) {
        this.maxUptime = builder.maxUptime;
        this.maxUptimeInMillis = ApiTypeHelper.requireNonNull(builder.maxUptimeInMillis, this, "maxUptimeInMillis");
        this.mem = ApiTypeHelper.requireNonNull(builder.mem, this, "mem");
        this.threads = ApiTypeHelper.requireNonNull(builder.threads, this, "threads");
        this.versions = ApiTypeHelper.unmodifiable(builder.versions);
    }

    public static ClusterJvm of(Function<ClusterJvm.Builder, ObjectBuilder<ClusterJvm>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code max_uptime}
     */
    @Nullable
    public final Time maxUptime() {
        return this.maxUptime;
    }

    /**
     * Required - API name: {@code max_uptime_in_millis}
     */
    public final long maxUptimeInMillis() {
        return this.maxUptimeInMillis;
    }

    /**
     * Required - API name: {@code mem}
     */
    @Nonnull
    public final ClusterJvmMemory mem() {
        return this.mem;
    }

    /**
     * Required - Number of active threads in use by JVM across all selected nodes.
     * <p>
     * API name: {@code threads}
     * </p>
     */
    public final long threads() {
        return this.threads;
    }

    /**
     * Contains statistics about the JVM versions used by selected nodes.
     * <p>
     * API name: {@code versions}
     * </p>
     */
    @Nonnull
    public final List<ClusterJvmVersion> versions() {
        return this.versions;
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
        if (this.maxUptime != null) {
            generator.writeKey("max_uptime");
            this.maxUptime.serialize(generator, mapper);
        }

        generator.writeKey("max_uptime_in_millis");
        generator.write(this.maxUptimeInMillis);

        generator.writeKey("mem");
        this.mem.serialize(generator, mapper);

        generator.writeKey("threads");
        generator.write(this.threads);

        if (ApiTypeHelper.isDefined(this.versions)) {
            generator.writeKey("versions");
            generator.writeStartArray();
            for (ClusterJvmVersion item0 : this.versions) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link ClusterJvm}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterJvm> {
        @Nullable
        private Time maxUptime;
        private Long maxUptimeInMillis;
        private ClusterJvmMemory mem;
        private Long threads;
        @Nullable
        private List<ClusterJvmVersion> versions;

        public Builder() {}

        private Builder(ClusterJvm o) {
            this.maxUptime = o.maxUptime;
            this.maxUptimeInMillis = o.maxUptimeInMillis;
            this.mem = o.mem;
            this.threads = o.threads;
            this.versions = _listCopy(o.versions);
        }

        private Builder(Builder o) {
            this.maxUptime = o.maxUptime;
            this.maxUptimeInMillis = o.maxUptimeInMillis;
            this.mem = o.mem;
            this.threads = o.threads;
            this.versions = _listCopy(o.versions);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code max_uptime}
         */
        @Nonnull
        public final Builder maxUptime(@Nullable Time value) {
            this.maxUptime = value;
            return this;
        }

        /**
         * API name: {@code max_uptime}
         */
        @Nonnull
        public final Builder maxUptime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return maxUptime(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code max_uptime_in_millis}
         */
        @Nonnull
        public final Builder maxUptimeInMillis(long value) {
            this.maxUptimeInMillis = value;
            return this;
        }

        /**
         * Required - API name: {@code mem}
         */
        @Nonnull
        public final Builder mem(ClusterJvmMemory value) {
            this.mem = value;
            return this;
        }

        /**
         * Required - API name: {@code mem}
         */
        @Nonnull
        public final Builder mem(Function<ClusterJvmMemory.Builder, ObjectBuilder<ClusterJvmMemory>> fn) {
            return mem(fn.apply(new ClusterJvmMemory.Builder()).build());
        }

        /**
         * Required - Number of active threads in use by JVM across all selected nodes.
         * <p>
         * API name: {@code threads}
         * </p>
         */
        @Nonnull
        public final Builder threads(long value) {
            this.threads = value;
            return this;
        }

        /**
         * Contains statistics about the JVM versions used by selected nodes.
         * <p>
         * API name: {@code versions}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>versions</code>.
         * </p>
         */
        @Nonnull
        public final Builder versions(List<ClusterJvmVersion> list) {
            this.versions = _listAddAll(this.versions, list);
            return this;
        }

        /**
         * Contains statistics about the JVM versions used by selected nodes.
         * <p>
         * API name: {@code versions}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>versions</code>.
         * </p>
         */
        @Nonnull
        public final Builder versions(ClusterJvmVersion value, ClusterJvmVersion... values) {
            this.versions = _listAdd(this.versions, value, values);
            return this;
        }

        /**
         * Contains statistics about the JVM versions used by selected nodes.
         * <p>
         * API name: {@code versions}
         * </p>
         *
         * <p>
         * Adds a value to <code>versions</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder versions(Function<ClusterJvmVersion.Builder, ObjectBuilder<ClusterJvmVersion>> fn) {
            return versions(fn.apply(new ClusterJvmVersion.Builder()).build());
        }

        /**
         * Builds a {@link ClusterJvm}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterJvm build() {
            _checkSingleUse();

            return new ClusterJvm(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterJvm}
     */
    public static final JsonpDeserializer<ClusterJvm> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterJvm::setupClusterJvmDeserializer
    );

    protected static void setupClusterJvmDeserializer(ObjectDeserializer<ClusterJvm.Builder> op) {
        op.add(Builder::maxUptime, Time._DESERIALIZER, "max_uptime");
        op.add(Builder::maxUptimeInMillis, JsonpDeserializer.longDeserializer(), "max_uptime_in_millis");
        op.add(Builder::mem, ClusterJvmMemory._DESERIALIZER, "mem");
        op.add(Builder::threads, JsonpDeserializer.longDeserializer(), "threads");
        op.add(Builder::versions, JsonpDeserializer.arrayDeserializer(ClusterJvmVersion._DESERIALIZER), "versions");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.maxUptime);
        result = 31 * result + Long.hashCode(this.maxUptimeInMillis);
        result = 31 * result + this.mem.hashCode();
        result = 31 * result + Long.hashCode(this.threads);
        result = 31 * result + Objects.hashCode(this.versions);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterJvm other = (ClusterJvm) o;
        return Objects.equals(this.maxUptime, other.maxUptime)
            && this.maxUptimeInMillis == other.maxUptimeInMillis
            && this.mem.equals(other.mem)
            && this.threads == other.threads
            && Objects.equals(this.versions, other.versions);
    }
}
