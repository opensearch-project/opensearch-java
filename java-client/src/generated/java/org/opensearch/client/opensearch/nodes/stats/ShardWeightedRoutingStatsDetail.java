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

// typedef: nodes.stats.ShardWeightedRoutingStatsDetail

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardWeightedRoutingStatsDetail
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardWeightedRoutingStatsDetail.Builder, ShardWeightedRoutingStatsDetail> {

    @Nullable
    private final Integer failOpenCount;

    // ---------------------------------------------------------------------------------------------

    private ShardWeightedRoutingStatsDetail(Builder builder) {
        this.failOpenCount = builder.failOpenCount;
    }

    public static ShardWeightedRoutingStatsDetail of(
        Function<ShardWeightedRoutingStatsDetail.Builder, ObjectBuilder<ShardWeightedRoutingStatsDetail>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code fail_open_count}
     */
    @Nullable
    public final Integer failOpenCount() {
        return this.failOpenCount;
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
        if (this.failOpenCount != null) {
            generator.writeKey("fail_open_count");
            generator.write(this.failOpenCount);
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
     * Builder for {@link ShardWeightedRoutingStatsDetail}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardWeightedRoutingStatsDetail> {
        @Nullable
        private Integer failOpenCount;

        public Builder() {}

        private Builder(ShardWeightedRoutingStatsDetail o) {
            this.failOpenCount = o.failOpenCount;
        }

        private Builder(Builder o) {
            this.failOpenCount = o.failOpenCount;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code fail_open_count}
         */
        @Nonnull
        public final Builder failOpenCount(@Nullable Integer value) {
            this.failOpenCount = value;
            return this;
        }

        /**
         * Builds a {@link ShardWeightedRoutingStatsDetail}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardWeightedRoutingStatsDetail build() {
            _checkSingleUse();

            return new ShardWeightedRoutingStatsDetail(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardWeightedRoutingStatsDetail}
     */
    public static final JsonpDeserializer<ShardWeightedRoutingStatsDetail> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardWeightedRoutingStatsDetail::setupShardWeightedRoutingStatsDetailDeserializer
    );

    protected static void setupShardWeightedRoutingStatsDetailDeserializer(ObjectDeserializer<ShardWeightedRoutingStatsDetail.Builder> op) {
        op.add(Builder::failOpenCount, JsonpDeserializer.integerDeserializer(), "fail_open_count");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.failOpenCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardWeightedRoutingStatsDetail other = (ShardWeightedRoutingStatsDetail) o;
        return Objects.equals(this.failOpenCount, other.failOpenCount);
    }
}
