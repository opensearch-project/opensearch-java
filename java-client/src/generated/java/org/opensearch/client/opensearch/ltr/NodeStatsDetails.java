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

package org.opensearch.client.opensearch.ltr;

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

// typedef: ltr.NodeStatsDetails

/**
 * Cache statistics for a node.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeStatsDetails implements PlainJsonSerializable, ToCopyableBuilder<NodeStatsDetails.Builder, NodeStatsDetails> {

    @Nullable
    private final CacheItemStats features;

    @Nullable
    private final CacheItemStats featuresets;

    @Nullable
    private final CacheItemStats models;

    @Nullable
    private final CacheItemStats total;

    // ---------------------------------------------------------------------------------------------

    private NodeStatsDetails(Builder builder) {
        this.features = builder.features;
        this.featuresets = builder.featuresets;
        this.models = builder.models;
        this.total = builder.total;
    }

    public static NodeStatsDetails of(Function<NodeStatsDetails.Builder, ObjectBuilder<NodeStatsDetails>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code features}
     */
    @Nullable
    public final CacheItemStats features() {
        return this.features;
    }

    /**
     * API name: {@code featuresets}
     */
    @Nullable
    public final CacheItemStats featuresets() {
        return this.featuresets;
    }

    /**
     * API name: {@code models}
     */
    @Nullable
    public final CacheItemStats models() {
        return this.models;
    }

    /**
     * API name: {@code total}
     */
    @Nullable
    public final CacheItemStats total() {
        return this.total;
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
        if (this.features != null) {
            generator.writeKey("features");
            this.features.serialize(generator, mapper);
        }

        if (this.featuresets != null) {
            generator.writeKey("featuresets");
            this.featuresets.serialize(generator, mapper);
        }

        if (this.models != null) {
            generator.writeKey("models");
            this.models.serialize(generator, mapper);
        }

        if (this.total != null) {
            generator.writeKey("total");
            this.total.serialize(generator, mapper);
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
     * Builder for {@link NodeStatsDetails}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeStatsDetails> {
        @Nullable
        private CacheItemStats features;
        @Nullable
        private CacheItemStats featuresets;
        @Nullable
        private CacheItemStats models;
        @Nullable
        private CacheItemStats total;

        public Builder() {}

        private Builder(NodeStatsDetails o) {
            this.features = o.features;
            this.featuresets = o.featuresets;
            this.models = o.models;
            this.total = o.total;
        }

        private Builder(Builder o) {
            this.features = o.features;
            this.featuresets = o.featuresets;
            this.models = o.models;
            this.total = o.total;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code features}
         */
        @Nonnull
        public final Builder features(@Nullable CacheItemStats value) {
            this.features = value;
            return this;
        }

        /**
         * API name: {@code features}
         */
        @Nonnull
        public final Builder features(Function<CacheItemStats.Builder, ObjectBuilder<CacheItemStats>> fn) {
            return features(fn.apply(new CacheItemStats.Builder()).build());
        }

        /**
         * API name: {@code featuresets}
         */
        @Nonnull
        public final Builder featuresets(@Nullable CacheItemStats value) {
            this.featuresets = value;
            return this;
        }

        /**
         * API name: {@code featuresets}
         */
        @Nonnull
        public final Builder featuresets(Function<CacheItemStats.Builder, ObjectBuilder<CacheItemStats>> fn) {
            return featuresets(fn.apply(new CacheItemStats.Builder()).build());
        }

        /**
         * API name: {@code models}
         */
        @Nonnull
        public final Builder models(@Nullable CacheItemStats value) {
            this.models = value;
            return this;
        }

        /**
         * API name: {@code models}
         */
        @Nonnull
        public final Builder models(Function<CacheItemStats.Builder, ObjectBuilder<CacheItemStats>> fn) {
            return models(fn.apply(new CacheItemStats.Builder()).build());
        }

        /**
         * API name: {@code total}
         */
        @Nonnull
        public final Builder total(@Nullable CacheItemStats value) {
            this.total = value;
            return this;
        }

        /**
         * API name: {@code total}
         */
        @Nonnull
        public final Builder total(Function<CacheItemStats.Builder, ObjectBuilder<CacheItemStats>> fn) {
            return total(fn.apply(new CacheItemStats.Builder()).build());
        }

        /**
         * Builds a {@link NodeStatsDetails}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeStatsDetails build() {
            _checkSingleUse();

            return new NodeStatsDetails(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeStatsDetails}
     */
    public static final JsonpDeserializer<NodeStatsDetails> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeStatsDetails::setupNodeStatsDetailsDeserializer
    );

    protected static void setupNodeStatsDetailsDeserializer(ObjectDeserializer<NodeStatsDetails.Builder> op) {
        op.add(Builder::features, CacheItemStats._DESERIALIZER, "features");
        op.add(Builder::featuresets, CacheItemStats._DESERIALIZER, "featuresets");
        op.add(Builder::models, CacheItemStats._DESERIALIZER, "models");
        op.add(Builder::total, CacheItemStats._DESERIALIZER, "total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.features);
        result = 31 * result + Objects.hashCode(this.featuresets);
        result = 31 * result + Objects.hashCode(this.models);
        result = 31 * result + Objects.hashCode(this.total);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeStatsDetails other = (NodeStatsDetails) o;
        return Objects.equals(this.features, other.features)
            && Objects.equals(this.featuresets, other.featuresets)
            && Objects.equals(this.models, other.models)
            && Objects.equals(this.total, other.total);
    }
}
