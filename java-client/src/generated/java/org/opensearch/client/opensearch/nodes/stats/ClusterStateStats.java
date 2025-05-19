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

// typedef: nodes.stats.ClusterStateStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterStateStats implements PlainJsonSerializable, ToCopyableBuilder<ClusterStateStats.Builder, ClusterStateStats> {

    @Nullable
    private final ClusterStateOverallStats overall;

    // ---------------------------------------------------------------------------------------------

    private ClusterStateStats(Builder builder) {
        this.overall = builder.overall;
    }

    public static ClusterStateStats of(Function<ClusterStateStats.Builder, ObjectBuilder<ClusterStateStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code overall}
     */
    @Nullable
    public final ClusterStateOverallStats overall() {
        return this.overall;
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
        if (this.overall != null) {
            generator.writeKey("overall");
            this.overall.serialize(generator, mapper);
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
     * Builder for {@link ClusterStateStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterStateStats> {
        @Nullable
        private ClusterStateOverallStats overall;

        public Builder() {}

        private Builder(ClusterStateStats o) {
            this.overall = o.overall;
        }

        private Builder(Builder o) {
            this.overall = o.overall;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code overall}
         */
        @Nonnull
        public final Builder overall(@Nullable ClusterStateOverallStats value) {
            this.overall = value;
            return this;
        }

        /**
         * API name: {@code overall}
         */
        @Nonnull
        public final Builder overall(Function<ClusterStateOverallStats.Builder, ObjectBuilder<ClusterStateOverallStats>> fn) {
            return overall(fn.apply(new ClusterStateOverallStats.Builder()).build());
        }

        /**
         * Builds a {@link ClusterStateStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterStateStats build() {
            _checkSingleUse();

            return new ClusterStateStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterStateStats}
     */
    public static final JsonpDeserializer<ClusterStateStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterStateStats::setupClusterStateStatsDeserializer
    );

    protected static void setupClusterStateStatsDeserializer(ObjectDeserializer<ClusterStateStats.Builder> op) {
        op.add(Builder::overall, ClusterStateOverallStats._DESERIALIZER, "overall");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.overall);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterStateStats other = (ClusterStateStats) o;
        return Objects.equals(this.overall, other.overall);
    }
}
