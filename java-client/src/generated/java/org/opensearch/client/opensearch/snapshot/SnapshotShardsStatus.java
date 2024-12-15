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

package org.opensearch.client.opensearch.snapshot;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: snapshot.SnapshotShardsStatus

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SnapshotShardsStatus implements PlainJsonSerializable, ToCopyableBuilder<SnapshotShardsStatus.Builder, SnapshotShardsStatus> {

    @Nullable
    private final String node;

    @Nullable
    private final String reason;

    @Nonnull
    private final SnapshotShardsStatsStage stage;

    @Nonnull
    private final SnapshotShardsStatsSummary stats;

    // ---------------------------------------------------------------------------------------------

    private SnapshotShardsStatus(Builder builder) {
        this.node = builder.node;
        this.reason = builder.reason;
        this.stage = ApiTypeHelper.requireNonNull(builder.stage, this, "stage");
        this.stats = ApiTypeHelper.requireNonNull(builder.stats, this, "stats");
    }

    public static SnapshotShardsStatus of(Function<SnapshotShardsStatus.Builder, ObjectBuilder<SnapshotShardsStatus>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code node}
     */
    @Nullable
    public final String node() {
        return this.node;
    }

    /**
     * API name: {@code reason}
     */
    @Nullable
    public final String reason() {
        return this.reason;
    }

    /**
     * Required - API name: {@code stage}
     */
    @Nonnull
    public final SnapshotShardsStatsStage stage() {
        return this.stage;
    }

    /**
     * Required - API name: {@code stats}
     */
    @Nonnull
    public final SnapshotShardsStatsSummary stats() {
        return this.stats;
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
        if (this.node != null) {
            generator.writeKey("node");
            generator.write(this.node);
        }

        if (this.reason != null) {
            generator.writeKey("reason");
            generator.write(this.reason);
        }

        generator.writeKey("stage");
        this.stage.serialize(generator, mapper);

        generator.writeKey("stats");
        this.stats.serialize(generator, mapper);
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
     * Builder for {@link SnapshotShardsStatus}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SnapshotShardsStatus> {
        @Nullable
        private String node;
        @Nullable
        private String reason;
        private SnapshotShardsStatsStage stage;
        private SnapshotShardsStatsSummary stats;

        public Builder() {}

        private Builder(SnapshotShardsStatus o) {
            this.node = o.node;
            this.reason = o.reason;
            this.stage = o.stage;
            this.stats = o.stats;
        }

        private Builder(Builder o) {
            this.node = o.node;
            this.reason = o.reason;
            this.stage = o.stage;
            this.stats = o.stats;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code node}
         */
        @Nonnull
        public final Builder node(@Nullable String value) {
            this.node = value;
            return this;
        }

        /**
         * API name: {@code reason}
         */
        @Nonnull
        public final Builder reason(@Nullable String value) {
            this.reason = value;
            return this;
        }

        /**
         * Required - API name: {@code stage}
         */
        @Nonnull
        public final Builder stage(SnapshotShardsStatsStage value) {
            this.stage = value;
            return this;
        }

        /**
         * Required - API name: {@code stats}
         */
        @Nonnull
        public final Builder stats(SnapshotShardsStatsSummary value) {
            this.stats = value;
            return this;
        }

        /**
         * Required - API name: {@code stats}
         */
        @Nonnull
        public final Builder stats(Function<SnapshotShardsStatsSummary.Builder, ObjectBuilder<SnapshotShardsStatsSummary>> fn) {
            return stats(fn.apply(new SnapshotShardsStatsSummary.Builder()).build());
        }

        /**
         * Builds a {@link SnapshotShardsStatus}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SnapshotShardsStatus build() {
            _checkSingleUse();

            return new SnapshotShardsStatus(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SnapshotShardsStatus}
     */
    public static final JsonpDeserializer<SnapshotShardsStatus> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SnapshotShardsStatus::setupSnapshotShardsStatusDeserializer
    );

    protected static void setupSnapshotShardsStatusDeserializer(ObjectDeserializer<SnapshotShardsStatus.Builder> op) {
        op.add(Builder::node, JsonpDeserializer.stringDeserializer(), "node");
        op.add(Builder::reason, JsonpDeserializer.stringDeserializer(), "reason");
        op.add(Builder::stage, SnapshotShardsStatsStage._DESERIALIZER, "stage");
        op.add(Builder::stats, SnapshotShardsStatsSummary._DESERIALIZER, "stats");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.node);
        result = 31 * result + Objects.hashCode(this.reason);
        result = 31 * result + this.stage.hashCode();
        result = 31 * result + this.stats.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SnapshotShardsStatus other = (SnapshotShardsStatus) o;
        return Objects.equals(this.node, other.node)
            && Objects.equals(this.reason, other.reason)
            && this.stage.equals(other.stage)
            && this.stats.equals(other.stats);
    }
}
