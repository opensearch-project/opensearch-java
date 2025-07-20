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

package org.opensearch.client.opensearch.knn;

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

// typedef: knn.RemoteVectorIndexBuildStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RemoteVectorIndexBuildStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RemoteVectorIndexBuildStats.Builder, RemoteVectorIndexBuildStats> {

    @Nullable
    private final RemoteVectorIndexBuildStatsDetails buildStats;

    @Nullable
    private final RemoteVectorIndexClientStats clientStats;

    @Nullable
    private final RemoteVectorIndexRepositoryStats repositoryStats;

    // ---------------------------------------------------------------------------------------------

    private RemoteVectorIndexBuildStats(Builder builder) {
        this.buildStats = builder.buildStats;
        this.clientStats = builder.clientStats;
        this.repositoryStats = builder.repositoryStats;
    }

    public static RemoteVectorIndexBuildStats of(
        Function<RemoteVectorIndexBuildStats.Builder, ObjectBuilder<RemoteVectorIndexBuildStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code build_stats}
     */
    @Nullable
    public final RemoteVectorIndexBuildStatsDetails buildStats() {
        return this.buildStats;
    }

    /**
     * API name: {@code client_stats}
     */
    @Nullable
    public final RemoteVectorIndexClientStats clientStats() {
        return this.clientStats;
    }

    /**
     * API name: {@code repository_stats}
     */
    @Nullable
    public final RemoteVectorIndexRepositoryStats repositoryStats() {
        return this.repositoryStats;
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
        if (this.buildStats != null) {
            generator.writeKey("build_stats");
            this.buildStats.serialize(generator, mapper);
        }

        if (this.clientStats != null) {
            generator.writeKey("client_stats");
            this.clientStats.serialize(generator, mapper);
        }

        if (this.repositoryStats != null) {
            generator.writeKey("repository_stats");
            this.repositoryStats.serialize(generator, mapper);
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
     * Builder for {@link RemoteVectorIndexBuildStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RemoteVectorIndexBuildStats> {
        @Nullable
        private RemoteVectorIndexBuildStatsDetails buildStats;
        @Nullable
        private RemoteVectorIndexClientStats clientStats;
        @Nullable
        private RemoteVectorIndexRepositoryStats repositoryStats;

        public Builder() {}

        private Builder(RemoteVectorIndexBuildStats o) {
            this.buildStats = o.buildStats;
            this.clientStats = o.clientStats;
            this.repositoryStats = o.repositoryStats;
        }

        private Builder(Builder o) {
            this.buildStats = o.buildStats;
            this.clientStats = o.clientStats;
            this.repositoryStats = o.repositoryStats;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code build_stats}
         */
        @Nonnull
        public final Builder buildStats(@Nullable RemoteVectorIndexBuildStatsDetails value) {
            this.buildStats = value;
            return this;
        }

        /**
         * API name: {@code build_stats}
         */
        @Nonnull
        public final Builder buildStats(
            Function<RemoteVectorIndexBuildStatsDetails.Builder, ObjectBuilder<RemoteVectorIndexBuildStatsDetails>> fn
        ) {
            return buildStats(fn.apply(new RemoteVectorIndexBuildStatsDetails.Builder()).build());
        }

        /**
         * API name: {@code client_stats}
         */
        @Nonnull
        public final Builder clientStats(@Nullable RemoteVectorIndexClientStats value) {
            this.clientStats = value;
            return this;
        }

        /**
         * API name: {@code client_stats}
         */
        @Nonnull
        public final Builder clientStats(Function<RemoteVectorIndexClientStats.Builder, ObjectBuilder<RemoteVectorIndexClientStats>> fn) {
            return clientStats(fn.apply(new RemoteVectorIndexClientStats.Builder()).build());
        }

        /**
         * API name: {@code repository_stats}
         */
        @Nonnull
        public final Builder repositoryStats(@Nullable RemoteVectorIndexRepositoryStats value) {
            this.repositoryStats = value;
            return this;
        }

        /**
         * API name: {@code repository_stats}
         */
        @Nonnull
        public final Builder repositoryStats(
            Function<RemoteVectorIndexRepositoryStats.Builder, ObjectBuilder<RemoteVectorIndexRepositoryStats>> fn
        ) {
            return repositoryStats(fn.apply(new RemoteVectorIndexRepositoryStats.Builder()).build());
        }

        /**
         * Builds a {@link RemoteVectorIndexBuildStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RemoteVectorIndexBuildStats build() {
            _checkSingleUse();

            return new RemoteVectorIndexBuildStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RemoteVectorIndexBuildStats}
     */
    public static final JsonpDeserializer<RemoteVectorIndexBuildStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RemoteVectorIndexBuildStats::setupRemoteVectorIndexBuildStatsDeserializer
    );

    protected static void setupRemoteVectorIndexBuildStatsDeserializer(ObjectDeserializer<RemoteVectorIndexBuildStats.Builder> op) {
        op.add(Builder::buildStats, RemoteVectorIndexBuildStatsDetails._DESERIALIZER, "build_stats");
        op.add(Builder::clientStats, RemoteVectorIndexClientStats._DESERIALIZER, "client_stats");
        op.add(Builder::repositoryStats, RemoteVectorIndexRepositoryStats._DESERIALIZER, "repository_stats");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.buildStats);
        result = 31 * result + Objects.hashCode(this.clientStats);
        result = 31 * result + Objects.hashCode(this.repositoryStats);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RemoteVectorIndexBuildStats other = (RemoteVectorIndexBuildStats) o;
        return Objects.equals(this.buildStats, other.buildStats)
            && Objects.equals(this.clientStats, other.clientStats)
            && Objects.equals(this.repositoryStats, other.repositoryStats);
    }
}
