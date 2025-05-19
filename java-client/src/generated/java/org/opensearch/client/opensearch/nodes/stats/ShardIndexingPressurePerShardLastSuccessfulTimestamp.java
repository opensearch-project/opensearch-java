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

// typedef: nodes.stats.ShardIndexingPressurePerShardLastSuccessfulTimestamp

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardIndexingPressurePerShardLastSuccessfulTimestamp
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<
            ShardIndexingPressurePerShardLastSuccessfulTimestamp.Builder,
            ShardIndexingPressurePerShardLastSuccessfulTimestamp> {

    private final long coordinatingLastSuccessfulRequestTimestampInMillis;

    private final long primaryLastSuccessfulRequestTimestampInMillis;

    private final long replicaLastSuccessfulRequestTimestampInMillis;

    // ---------------------------------------------------------------------------------------------

    private ShardIndexingPressurePerShardLastSuccessfulTimestamp(Builder builder) {
        this.coordinatingLastSuccessfulRequestTimestampInMillis = ApiTypeHelper.requireNonNull(
            builder.coordinatingLastSuccessfulRequestTimestampInMillis,
            this,
            "coordinatingLastSuccessfulRequestTimestampInMillis"
        );
        this.primaryLastSuccessfulRequestTimestampInMillis = ApiTypeHelper.requireNonNull(
            builder.primaryLastSuccessfulRequestTimestampInMillis,
            this,
            "primaryLastSuccessfulRequestTimestampInMillis"
        );
        this.replicaLastSuccessfulRequestTimestampInMillis = ApiTypeHelper.requireNonNull(
            builder.replicaLastSuccessfulRequestTimestampInMillis,
            this,
            "replicaLastSuccessfulRequestTimestampInMillis"
        );
    }

    public static ShardIndexingPressurePerShardLastSuccessfulTimestamp of(
        Function<
            ShardIndexingPressurePerShardLastSuccessfulTimestamp.Builder,
            ObjectBuilder<ShardIndexingPressurePerShardLastSuccessfulTimestamp>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code coordinating_last_successful_request_timestamp_in_millis}
     */
    public final long coordinatingLastSuccessfulRequestTimestampInMillis() {
        return this.coordinatingLastSuccessfulRequestTimestampInMillis;
    }

    /**
     * Required - API name: {@code primary_last_successful_request_timestamp_in_millis}
     */
    public final long primaryLastSuccessfulRequestTimestampInMillis() {
        return this.primaryLastSuccessfulRequestTimestampInMillis;
    }

    /**
     * Required - API name: {@code replica_last_successful_request_timestamp_in_millis}
     */
    public final long replicaLastSuccessfulRequestTimestampInMillis() {
        return this.replicaLastSuccessfulRequestTimestampInMillis;
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
        generator.writeKey("coordinating_last_successful_request_timestamp_in_millis");
        generator.write(this.coordinatingLastSuccessfulRequestTimestampInMillis);

        generator.writeKey("primary_last_successful_request_timestamp_in_millis");
        generator.write(this.primaryLastSuccessfulRequestTimestampInMillis);

        generator.writeKey("replica_last_successful_request_timestamp_in_millis");
        generator.write(this.replicaLastSuccessfulRequestTimestampInMillis);
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
     * Builder for {@link ShardIndexingPressurePerShardLastSuccessfulTimestamp}.
     */
    public static class Builder extends ObjectBuilderBase
        implements
            CopyableBuilder<Builder, ShardIndexingPressurePerShardLastSuccessfulTimestamp> {
        private Long coordinatingLastSuccessfulRequestTimestampInMillis;
        private Long primaryLastSuccessfulRequestTimestampInMillis;
        private Long replicaLastSuccessfulRequestTimestampInMillis;

        public Builder() {}

        private Builder(ShardIndexingPressurePerShardLastSuccessfulTimestamp o) {
            this.coordinatingLastSuccessfulRequestTimestampInMillis = o.coordinatingLastSuccessfulRequestTimestampInMillis;
            this.primaryLastSuccessfulRequestTimestampInMillis = o.primaryLastSuccessfulRequestTimestampInMillis;
            this.replicaLastSuccessfulRequestTimestampInMillis = o.replicaLastSuccessfulRequestTimestampInMillis;
        }

        private Builder(Builder o) {
            this.coordinatingLastSuccessfulRequestTimestampInMillis = o.coordinatingLastSuccessfulRequestTimestampInMillis;
            this.primaryLastSuccessfulRequestTimestampInMillis = o.primaryLastSuccessfulRequestTimestampInMillis;
            this.replicaLastSuccessfulRequestTimestampInMillis = o.replicaLastSuccessfulRequestTimestampInMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code coordinating_last_successful_request_timestamp_in_millis}
         */
        @Nonnull
        public final Builder coordinatingLastSuccessfulRequestTimestampInMillis(long value) {
            this.coordinatingLastSuccessfulRequestTimestampInMillis = value;
            return this;
        }

        /**
         * Required - API name: {@code primary_last_successful_request_timestamp_in_millis}
         */
        @Nonnull
        public final Builder primaryLastSuccessfulRequestTimestampInMillis(long value) {
            this.primaryLastSuccessfulRequestTimestampInMillis = value;
            return this;
        }

        /**
         * Required - API name: {@code replica_last_successful_request_timestamp_in_millis}
         */
        @Nonnull
        public final Builder replicaLastSuccessfulRequestTimestampInMillis(long value) {
            this.replicaLastSuccessfulRequestTimestampInMillis = value;
            return this;
        }

        /**
         * Builds a {@link ShardIndexingPressurePerShardLastSuccessfulTimestamp}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardIndexingPressurePerShardLastSuccessfulTimestamp build() {
            _checkSingleUse();

            return new ShardIndexingPressurePerShardLastSuccessfulTimestamp(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardIndexingPressurePerShardLastSuccessfulTimestamp}
     */
    public static final JsonpDeserializer<ShardIndexingPressurePerShardLastSuccessfulTimestamp> _DESERIALIZER = ObjectBuilderDeserializer
        .lazy(
            Builder::new,
            ShardIndexingPressurePerShardLastSuccessfulTimestamp::setupShardIndexingPressurePerShardLastSuccessfulTimestampDeserializer
        );

    protected static void setupShardIndexingPressurePerShardLastSuccessfulTimestampDeserializer(
        ObjectDeserializer<ShardIndexingPressurePerShardLastSuccessfulTimestamp.Builder> op
    ) {
        op.add(
            Builder::coordinatingLastSuccessfulRequestTimestampInMillis,
            JsonpDeserializer.longDeserializer(),
            "coordinating_last_successful_request_timestamp_in_millis"
        );
        op.add(
            Builder::primaryLastSuccessfulRequestTimestampInMillis,
            JsonpDeserializer.longDeserializer(),
            "primary_last_successful_request_timestamp_in_millis"
        );
        op.add(
            Builder::replicaLastSuccessfulRequestTimestampInMillis,
            JsonpDeserializer.longDeserializer(),
            "replica_last_successful_request_timestamp_in_millis"
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.coordinatingLastSuccessfulRequestTimestampInMillis);
        result = 31 * result + Long.hashCode(this.primaryLastSuccessfulRequestTimestampInMillis);
        result = 31 * result + Long.hashCode(this.replicaLastSuccessfulRequestTimestampInMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardIndexingPressurePerShardLastSuccessfulTimestamp other = (ShardIndexingPressurePerShardLastSuccessfulTimestamp) o;
        return this.coordinatingLastSuccessfulRequestTimestampInMillis == other.coordinatingLastSuccessfulRequestTimestampInMillis
            && this.primaryLastSuccessfulRequestTimestampInMillis == other.primaryLastSuccessfulRequestTimestampInMillis
            && this.replicaLastSuccessfulRequestTimestampInMillis == other.replicaLastSuccessfulRequestTimestampInMillis;
    }
}
