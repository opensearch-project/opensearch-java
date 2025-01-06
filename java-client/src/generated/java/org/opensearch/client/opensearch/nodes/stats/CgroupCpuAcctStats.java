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

// typedef: nodes.stats.CgroupCpuAcctStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CgroupCpuAcctStats implements PlainJsonSerializable, ToCopyableBuilder<CgroupCpuAcctStats.Builder, CgroupCpuAcctStats> {

    @Nullable
    private final String controlGroup;

    @Nullable
    private final Long usageNanos;

    // ---------------------------------------------------------------------------------------------

    private CgroupCpuAcctStats(Builder builder) {
        this.controlGroup = builder.controlGroup;
        this.usageNanos = builder.usageNanos;
    }

    public static CgroupCpuAcctStats of(Function<CgroupCpuAcctStats.Builder, ObjectBuilder<CgroupCpuAcctStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The <code>cpuacct</code> control group to which the OpenSearch process belongs.
     * <p>
     * API name: {@code control_group}
     * </p>
     */
    @Nullable
    public final String controlGroup() {
        return this.controlGroup;
    }

    /**
     * API name: {@code usage_nanos}
     */
    @Nullable
    public final Long usageNanos() {
        return this.usageNanos;
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

        if (this.usageNanos != null) {
            generator.writeKey("usage_nanos");
            generator.write(this.usageNanos);
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
     * Builder for {@link CgroupCpuAcctStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CgroupCpuAcctStats> {
        @Nullable
        private String controlGroup;
        @Nullable
        private Long usageNanos;

        public Builder() {}

        private Builder(CgroupCpuAcctStats o) {
            this.controlGroup = o.controlGroup;
            this.usageNanos = o.usageNanos;
        }

        private Builder(Builder o) {
            this.controlGroup = o.controlGroup;
            this.usageNanos = o.usageNanos;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The <code>cpuacct</code> control group to which the OpenSearch process belongs.
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
         * API name: {@code usage_nanos}
         */
        @Nonnull
        public final Builder usageNanos(@Nullable Long value) {
            this.usageNanos = value;
            return this;
        }

        /**
         * Builds a {@link CgroupCpuAcctStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CgroupCpuAcctStats build() {
            _checkSingleUse();

            return new CgroupCpuAcctStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CgroupCpuAcctStats}
     */
    public static final JsonpDeserializer<CgroupCpuAcctStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CgroupCpuAcctStats::setupCgroupCpuAcctStatsDeserializer
    );

    protected static void setupCgroupCpuAcctStatsDeserializer(ObjectDeserializer<CgroupCpuAcctStats.Builder> op) {
        op.add(Builder::controlGroup, JsonpDeserializer.stringDeserializer(), "control_group");
        op.add(Builder::usageNanos, JsonpDeserializer.longDeserializer(), "usage_nanos");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.controlGroup);
        result = 31 * result + Objects.hashCode(this.usageNanos);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CgroupCpuAcctStats other = (CgroupCpuAcctStats) o;
        return Objects.equals(this.controlGroup, other.controlGroup) && Objects.equals(this.usageNanos, other.usageNanos);
    }
}
