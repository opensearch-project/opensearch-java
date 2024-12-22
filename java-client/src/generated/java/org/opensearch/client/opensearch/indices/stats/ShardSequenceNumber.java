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

package org.opensearch.client.opensearch.indices.stats;

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

// typedef: indices.stats.ShardSequenceNumber

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardSequenceNumber implements PlainJsonSerializable, ToCopyableBuilder<ShardSequenceNumber.Builder, ShardSequenceNumber> {

    private final long globalCheckpoint;

    private final long localCheckpoint;

    private final long maxSeqNo;

    // ---------------------------------------------------------------------------------------------

    private ShardSequenceNumber(Builder builder) {
        this.globalCheckpoint = ApiTypeHelper.requireNonNull(builder.globalCheckpoint, this, "globalCheckpoint");
        this.localCheckpoint = ApiTypeHelper.requireNonNull(builder.localCheckpoint, this, "localCheckpoint");
        this.maxSeqNo = ApiTypeHelper.requireNonNull(builder.maxSeqNo, this, "maxSeqNo");
    }

    public static ShardSequenceNumber of(Function<ShardSequenceNumber.Builder, ObjectBuilder<ShardSequenceNumber>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code global_checkpoint}
     */
    public final long globalCheckpoint() {
        return this.globalCheckpoint;
    }

    /**
     * Required - API name: {@code local_checkpoint}
     */
    public final long localCheckpoint() {
        return this.localCheckpoint;
    }

    /**
     * Required - API name: {@code max_seq_no}
     */
    public final long maxSeqNo() {
        return this.maxSeqNo;
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
        generator.writeKey("global_checkpoint");
        generator.write(this.globalCheckpoint);

        generator.writeKey("local_checkpoint");
        generator.write(this.localCheckpoint);

        generator.writeKey("max_seq_no");
        generator.write(this.maxSeqNo);
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
     * Builder for {@link ShardSequenceNumber}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardSequenceNumber> {
        private Long globalCheckpoint;
        private Long localCheckpoint;
        private Long maxSeqNo;

        public Builder() {}

        private Builder(ShardSequenceNumber o) {
            this.globalCheckpoint = o.globalCheckpoint;
            this.localCheckpoint = o.localCheckpoint;
            this.maxSeqNo = o.maxSeqNo;
        }

        private Builder(Builder o) {
            this.globalCheckpoint = o.globalCheckpoint;
            this.localCheckpoint = o.localCheckpoint;
            this.maxSeqNo = o.maxSeqNo;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code global_checkpoint}
         */
        @Nonnull
        public final Builder globalCheckpoint(long value) {
            this.globalCheckpoint = value;
            return this;
        }

        /**
         * Required - API name: {@code local_checkpoint}
         */
        @Nonnull
        public final Builder localCheckpoint(long value) {
            this.localCheckpoint = value;
            return this;
        }

        /**
         * Required - API name: {@code max_seq_no}
         */
        @Nonnull
        public final Builder maxSeqNo(long value) {
            this.maxSeqNo = value;
            return this;
        }

        /**
         * Builds a {@link ShardSequenceNumber}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardSequenceNumber build() {
            _checkSingleUse();

            return new ShardSequenceNumber(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardSequenceNumber}
     */
    public static final JsonpDeserializer<ShardSequenceNumber> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardSequenceNumber::setupShardSequenceNumberDeserializer
    );

    protected static void setupShardSequenceNumberDeserializer(ObjectDeserializer<ShardSequenceNumber.Builder> op) {
        op.add(Builder::globalCheckpoint, JsonpDeserializer.longDeserializer(), "global_checkpoint");
        op.add(Builder::localCheckpoint, JsonpDeserializer.longDeserializer(), "local_checkpoint");
        op.add(Builder::maxSeqNo, JsonpDeserializer.longDeserializer(), "max_seq_no");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.globalCheckpoint);
        result = 31 * result + Long.hashCode(this.localCheckpoint);
        result = 31 * result + Long.hashCode(this.maxSeqNo);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardSequenceNumber other = (ShardSequenceNumber) o;
        return this.globalCheckpoint == other.globalCheckpoint
            && this.localCheckpoint == other.localCheckpoint
            && this.maxSeqNo == other.maxSeqNo;
    }
}
