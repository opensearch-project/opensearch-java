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

// typedef: indices.stats.ShardLease

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardLease implements PlainJsonSerializable, ToCopyableBuilder<ShardLease.Builder, ShardLease> {

    @Nonnull
    private final String id;

    private final long retainingSeqNo;

    @Nonnull
    private final String source;

    private final long timestamp;

    // ---------------------------------------------------------------------------------------------

    private ShardLease(Builder builder) {
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.retainingSeqNo = ApiTypeHelper.requireNonNull(builder.retainingSeqNo, this, "retainingSeqNo");
        this.source = ApiTypeHelper.requireNonNull(builder.source, this, "source");
        this.timestamp = ApiTypeHelper.requireNonNull(builder.timestamp, this, "timestamp");
    }

    public static ShardLease of(Function<ShardLease.Builder, ObjectBuilder<ShardLease>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code id}
     */
    @Nonnull
    public final String id() {
        return this.id;
    }

    /**
     * Required - API name: {@code retaining_seq_no}
     */
    public final long retainingSeqNo() {
        return this.retainingSeqNo;
    }

    /**
     * Required - API name: {@code source}
     */
    @Nonnull
    public final String source() {
        return this.source;
    }

    /**
     * Required - API name: {@code timestamp}
     */
    public final long timestamp() {
        return this.timestamp;
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
        generator.writeKey("id");
        generator.write(this.id);

        generator.writeKey("retaining_seq_no");
        generator.write(this.retainingSeqNo);

        generator.writeKey("source");
        generator.write(this.source);

        generator.writeKey("timestamp");
        generator.write(this.timestamp);
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
     * Builder for {@link ShardLease}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardLease> {
        private String id;
        private Long retainingSeqNo;
        private String source;
        private Long timestamp;

        public Builder() {}

        private Builder(ShardLease o) {
            this.id = o.id;
            this.retainingSeqNo = o.retainingSeqNo;
            this.source = o.source;
            this.timestamp = o.timestamp;
        }

        private Builder(Builder o) {
            this.id = o.id;
            this.retainingSeqNo = o.retainingSeqNo;
            this.source = o.source;
            this.timestamp = o.timestamp;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code id}
         */
        @Nonnull
        public final Builder id(String value) {
            this.id = value;
            return this;
        }

        /**
         * Required - API name: {@code retaining_seq_no}
         */
        @Nonnull
        public final Builder retainingSeqNo(long value) {
            this.retainingSeqNo = value;
            return this;
        }

        /**
         * Required - API name: {@code source}
         */
        @Nonnull
        public final Builder source(String value) {
            this.source = value;
            return this;
        }

        /**
         * Required - API name: {@code timestamp}
         */
        @Nonnull
        public final Builder timestamp(long value) {
            this.timestamp = value;
            return this;
        }

        /**
         * Builds a {@link ShardLease}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardLease build() {
            _checkSingleUse();

            return new ShardLease(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardLease}
     */
    public static final JsonpDeserializer<ShardLease> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardLease::setupShardLeaseDeserializer
    );

    protected static void setupShardLeaseDeserializer(ObjectDeserializer<ShardLease.Builder> op) {
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::retainingSeqNo, JsonpDeserializer.longDeserializer(), "retaining_seq_no");
        op.add(Builder::source, JsonpDeserializer.stringDeserializer(), "source");
        op.add(Builder::timestamp, JsonpDeserializer.longDeserializer(), "timestamp");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.id.hashCode();
        result = 31 * result + Long.hashCode(this.retainingSeqNo);
        result = 31 * result + this.source.hashCode();
        result = 31 * result + Long.hashCode(this.timestamp);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardLease other = (ShardLease) o;
        return this.id.equals(other.id)
            && this.retainingSeqNo == other.retainingSeqNo
            && this.source.equals(other.source)
            && this.timestamp == other.timestamp;
    }
}
