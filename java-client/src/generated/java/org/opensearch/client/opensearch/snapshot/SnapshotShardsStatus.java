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

// typedef: snapshot.SnapshotShardsStatus

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SnapshotShardsStatus implements PlainJsonSerializable, ToCopyableBuilder<SnapshotShardsStatus.Builder, SnapshotShardsStatus> {

    @Nonnull
    private final ShardsStatsStage stage;

    @Nonnull
    private final ShardsStatsSummary stats;

    // ---------------------------------------------------------------------------------------------

    private SnapshotShardsStatus(Builder builder) {
        this.stage = ApiTypeHelper.requireNonNull(builder.stage, this, "stage");
        this.stats = ApiTypeHelper.requireNonNull(builder.stats, this, "stats");
    }

    public static SnapshotShardsStatus of(Function<SnapshotShardsStatus.Builder, ObjectBuilder<SnapshotShardsStatus>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code stage}
     */
    @Nonnull
    public final ShardsStatsStage stage() {
        return this.stage;
    }

    /**
     * Required - API name: {@code stats}
     */
    @Nonnull
    public final ShardsStatsSummary stats() {
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
        private ShardsStatsStage stage;
        private ShardsStatsSummary stats;

        public Builder() {}

        private Builder(SnapshotShardsStatus o) {
            this.stage = o.stage;
            this.stats = o.stats;
        }

        private Builder(Builder o) {
            this.stage = o.stage;
            this.stats = o.stats;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code stage}
         */
        @Nonnull
        public final Builder stage(ShardsStatsStage value) {
            this.stage = value;
            return this;
        }

        /**
         * Required - API name: {@code stats}
         */
        @Nonnull
        public final Builder stats(ShardsStatsSummary value) {
            this.stats = value;
            return this;
        }

        /**
         * Required - API name: {@code stats}
         */
        @Nonnull
        public final Builder stats(Function<ShardsStatsSummary.Builder, ObjectBuilder<ShardsStatsSummary>> fn) {
            return stats(fn.apply(new ShardsStatsSummary.Builder()).build());
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
        op.add(Builder::stage, ShardsStatsStage._DESERIALIZER, "stage");
        op.add(Builder::stats, ShardsStatsSummary._DESERIALIZER, "stats");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.stage.hashCode();
        result = 31 * result + this.stats.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SnapshotShardsStatus other = (SnapshotShardsStatus) o;
        return this.stage.equals(other.stage) && this.stats.equals(other.stats);
    }
}
