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

package org.opensearch.client.opensearch._types;

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

// typedef: _types.SegmentReplicationStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SegmentReplicationStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<SegmentReplicationStats.Builder, SegmentReplicationStats> {

    private final long maxBytesBehind;

    private final long maxReplicationLag;

    private final long totalBytesBehind;

    // ---------------------------------------------------------------------------------------------

    private SegmentReplicationStats(Builder builder) {
        this.maxBytesBehind = ApiTypeHelper.requireNonNull(builder.maxBytesBehind, this, "maxBytesBehind");
        this.maxReplicationLag = ApiTypeHelper.requireNonNull(builder.maxReplicationLag, this, "maxReplicationLag");
        this.totalBytesBehind = ApiTypeHelper.requireNonNull(builder.totalBytesBehind, this, "totalBytesBehind");
    }

    public static SegmentReplicationStats of(Function<SegmentReplicationStats.Builder, ObjectBuilder<SegmentReplicationStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code max_bytes_behind}
     */
    public final long maxBytesBehind() {
        return this.maxBytesBehind;
    }

    /**
     * Required - API name: {@code max_replication_lag}
     */
    public final long maxReplicationLag() {
        return this.maxReplicationLag;
    }

    /**
     * Required - API name: {@code total_bytes_behind}
     */
    public final long totalBytesBehind() {
        return this.totalBytesBehind;
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
        generator.writeKey("max_bytes_behind");
        generator.write(this.maxBytesBehind);

        generator.writeKey("max_replication_lag");
        generator.write(this.maxReplicationLag);

        generator.writeKey("total_bytes_behind");
        generator.write(this.totalBytesBehind);
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
     * Builder for {@link SegmentReplicationStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SegmentReplicationStats> {
        private Long maxBytesBehind;
        private Long maxReplicationLag;
        private Long totalBytesBehind;

        public Builder() {}

        private Builder(SegmentReplicationStats o) {
            this.maxBytesBehind = o.maxBytesBehind;
            this.maxReplicationLag = o.maxReplicationLag;
            this.totalBytesBehind = o.totalBytesBehind;
        }

        private Builder(Builder o) {
            this.maxBytesBehind = o.maxBytesBehind;
            this.maxReplicationLag = o.maxReplicationLag;
            this.totalBytesBehind = o.totalBytesBehind;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code max_bytes_behind}
         */
        @Nonnull
        public final Builder maxBytesBehind(long value) {
            this.maxBytesBehind = value;
            return this;
        }

        /**
         * Required - API name: {@code max_replication_lag}
         */
        @Nonnull
        public final Builder maxReplicationLag(long value) {
            this.maxReplicationLag = value;
            return this;
        }

        /**
         * Required - API name: {@code total_bytes_behind}
         */
        @Nonnull
        public final Builder totalBytesBehind(long value) {
            this.totalBytesBehind = value;
            return this;
        }

        /**
         * Builds a {@link SegmentReplicationStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SegmentReplicationStats build() {
            _checkSingleUse();

            return new SegmentReplicationStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SegmentReplicationStats}
     */
    public static final JsonpDeserializer<SegmentReplicationStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SegmentReplicationStats::setupSegmentReplicationStatsDeserializer
    );

    protected static void setupSegmentReplicationStatsDeserializer(ObjectDeserializer<SegmentReplicationStats.Builder> op) {
        op.add(Builder::maxBytesBehind, JsonpDeserializer.longDeserializer(), "max_bytes_behind");
        op.add(Builder::maxReplicationLag, JsonpDeserializer.longDeserializer(), "max_replication_lag");
        op.add(Builder::totalBytesBehind, JsonpDeserializer.longDeserializer(), "total_bytes_behind");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.maxBytesBehind);
        result = 31 * result + Long.hashCode(this.maxReplicationLag);
        result = 31 * result + Long.hashCode(this.totalBytesBehind);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SegmentReplicationStats other = (SegmentReplicationStats) o;
        return this.maxBytesBehind == other.maxBytesBehind
            && this.maxReplicationLag == other.maxReplicationLag
            && this.totalBytesBehind == other.totalBytesBehind;
    }
}
