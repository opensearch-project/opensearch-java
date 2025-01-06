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

// typedef: nodes.stats.CgroupMemoryStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CgroupMemoryStats implements PlainJsonSerializable, ToCopyableBuilder<CgroupMemoryStats.Builder, CgroupMemoryStats> {

    @Nullable
    private final String controlGroup;

    @Nullable
    private final String limitInBytes;

    @Nullable
    private final String usageInBytes;

    // ---------------------------------------------------------------------------------------------

    private CgroupMemoryStats(Builder builder) {
        this.controlGroup = builder.controlGroup;
        this.limitInBytes = builder.limitInBytes;
        this.usageInBytes = builder.usageInBytes;
    }

    public static CgroupMemoryStats of(Function<CgroupMemoryStats.Builder, ObjectBuilder<CgroupMemoryStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The <code>memory</code> control group to which the OpenSearch process belongs.
     * <p>
     * API name: {@code control_group}
     * </p>
     */
    @Nullable
    public final String controlGroup() {
        return this.controlGroup;
    }

    /**
     * The maximum amount of user memory (including file cache) allowed for all tasks in the same cgroup as the OpenSearch process. This
     * value can be too big to store in a <code>long</code>, so is returned as a string so that the value returned can exactly match what
     * the underlying operating system interface returns. Any value that is too large to parse into a <code>long</code> almost certainly
     * means no limit has been set for the cgroup.
     * <p>
     * API name: {@code limit_in_bytes}
     * </p>
     */
    @Nullable
    public final String limitInBytes() {
        return this.limitInBytes;
    }

    /**
     * The total current memory usage by processes in the cgroup, in bytes, by all tasks in the same cgroup as the OpenSearch process. This
     * value is stored as a string for consistency with <code>limit_in_bytes</code>.
     * <p>
     * API name: {@code usage_in_bytes}
     * </p>
     */
    @Nullable
    public final String usageInBytes() {
        return this.usageInBytes;
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
        if (this.controlGroup != null) {
            generator.writeKey("control_group");
            generator.write(this.controlGroup);
        }

        if (this.limitInBytes != null) {
            generator.writeKey("limit_in_bytes");
            generator.write(this.limitInBytes);
        }

        if (this.usageInBytes != null) {
            generator.writeKey("usage_in_bytes");
            generator.write(this.usageInBytes);
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
     * Builder for {@link CgroupMemoryStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CgroupMemoryStats> {
        @Nullable
        private String controlGroup;
        @Nullable
        private String limitInBytes;
        @Nullable
        private String usageInBytes;

        public Builder() {}

        private Builder(CgroupMemoryStats o) {
            this.controlGroup = o.controlGroup;
            this.limitInBytes = o.limitInBytes;
            this.usageInBytes = o.usageInBytes;
        }

        private Builder(Builder o) {
            this.controlGroup = o.controlGroup;
            this.limitInBytes = o.limitInBytes;
            this.usageInBytes = o.usageInBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The <code>memory</code> control group to which the OpenSearch process belongs.
         * <p>
         * API name: {@code control_group}
         * </p>
         */
        @Nonnull
        public final Builder controlGroup(@Nullable String value) {
            this.controlGroup = value;
            return this;
        }

        /**
         * The maximum amount of user memory (including file cache) allowed for all tasks in the same cgroup as the OpenSearch process. This
         * value can be too big to store in a <code>long</code>, so is returned as a string so that the value returned can exactly match
         * what the underlying operating system interface returns. Any value that is too large to parse into a <code>long</code> almost
         * certainly means no limit has been set for the cgroup.
         * <p>
         * API name: {@code limit_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder limitInBytes(@Nullable String value) {
            this.limitInBytes = value;
            return this;
        }

        /**
         * The total current memory usage by processes in the cgroup, in bytes, by all tasks in the same cgroup as the OpenSearch process.
         * This value is stored as a string for consistency with <code>limit_in_bytes</code>.
         * <p>
         * API name: {@code usage_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder usageInBytes(@Nullable String value) {
            this.usageInBytes = value;
            return this;
        }

        /**
         * Builds a {@link CgroupMemoryStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CgroupMemoryStats build() {
            _checkSingleUse();

            return new CgroupMemoryStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CgroupMemoryStats}
     */
    public static final JsonpDeserializer<CgroupMemoryStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CgroupMemoryStats::setupCgroupMemoryStatsDeserializer
    );

    protected static void setupCgroupMemoryStatsDeserializer(ObjectDeserializer<CgroupMemoryStats.Builder> op) {
        op.add(Builder::controlGroup, JsonpDeserializer.stringDeserializer(), "control_group");
        op.add(Builder::limitInBytes, JsonpDeserializer.stringDeserializer(), "limit_in_bytes");
        op.add(Builder::usageInBytes, JsonpDeserializer.stringDeserializer(), "usage_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.controlGroup);
        result = 31 * result + Objects.hashCode(this.limitInBytes);
        result = 31 * result + Objects.hashCode(this.usageInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CgroupMemoryStats other = (CgroupMemoryStats) o;
        return Objects.equals(this.controlGroup, other.controlGroup)
            && Objects.equals(this.limitInBytes, other.limitInBytes)
            && Objects.equals(this.usageInBytes, other.usageInBytes);
    }
}
