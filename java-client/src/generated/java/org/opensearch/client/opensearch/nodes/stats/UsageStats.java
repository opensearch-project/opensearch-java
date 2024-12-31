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

// typedef: nodes.stats.UsageStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class UsageStats implements PlainJsonSerializable, ToCopyableBuilder<UsageStats.Builder, UsageStats> {

    @Nullable
    private final TransportUsageStats transport;

    // ---------------------------------------------------------------------------------------------

    private UsageStats(Builder builder) {
        this.transport = builder.transport;
    }

    public static UsageStats of(Function<UsageStats.Builder, ObjectBuilder<UsageStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code transport}
     */
    @Nullable
    public final TransportUsageStats transport() {
        return this.transport;
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
        if (this.transport != null) {
            generator.writeKey("transport");
            this.transport.serialize(generator, mapper);
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
     * Builder for {@link UsageStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, UsageStats> {
        @Nullable
        private TransportUsageStats transport;

        public Builder() {}

        private Builder(UsageStats o) {
            this.transport = o.transport;
        }

        private Builder(Builder o) {
            this.transport = o.transport;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code transport}
         */
        @Nonnull
        public final Builder transport(@Nullable TransportUsageStats value) {
            this.transport = value;
            return this;
        }

        /**
         * API name: {@code transport}
         */
        @Nonnull
        public final Builder transport(Function<TransportUsageStats.Builder, ObjectBuilder<TransportUsageStats>> fn) {
            return transport(fn.apply(new TransportUsageStats.Builder()).build());
        }

        /**
         * Builds a {@link UsageStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UsageStats build() {
            _checkSingleUse();

            return new UsageStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UsageStats}
     */
    public static final JsonpDeserializer<UsageStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UsageStats::setupUsageStatsDeserializer
    );

    protected static void setupUsageStatsDeserializer(ObjectDeserializer<UsageStats.Builder> op) {
        op.add(Builder::transport, TransportUsageStats._DESERIALIZER, "transport");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.transport);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UsageStats other = (UsageStats) o;
        return Objects.equals(this.transport, other.transport);
    }
}
