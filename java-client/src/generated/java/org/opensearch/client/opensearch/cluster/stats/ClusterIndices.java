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

package org.opensearch.client.opensearch.cluster.stats;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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
import org.opensearch.client.opensearch._types.CompletionStats;
import org.opensearch.client.opensearch._types.DocStats;
import org.opensearch.client.opensearch._types.FielddataStats;
import org.opensearch.client.opensearch._types.QueryCacheStats;
import org.opensearch.client.opensearch._types.SegmentsStats;
import org.opensearch.client.opensearch._types.StoreStats;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.stats.ClusterIndices

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterIndices implements PlainJsonSerializable, ToCopyableBuilder<ClusterIndices.Builder, ClusterIndices> {

    @Nullable
    private final CharFilterTypes analysis;

    @Nullable
    private final CompletionStats completion;

    @Nullable
    private final Long count;

    @Nullable
    private final DocStats docs;

    @Nullable
    private final FielddataStats fielddata;

    @Nullable
    private final FieldTypesMappings mappings;

    @Nullable
    private final QueryCacheStats queryCache;

    @Nullable
    private final SegmentsStats segments;

    @Nullable
    private final ClusterIndicesShards shards;

    @Nullable
    private final StoreStats store;

    @Nonnull
    private final List<IndicesVersions> versions;

    // ---------------------------------------------------------------------------------------------

    private ClusterIndices(Builder builder) {
        this.analysis = builder.analysis;
        this.completion = builder.completion;
        this.count = builder.count;
        this.docs = builder.docs;
        this.fielddata = builder.fielddata;
        this.mappings = builder.mappings;
        this.queryCache = builder.queryCache;
        this.segments = builder.segments;
        this.shards = builder.shards;
        this.store = builder.store;
        this.versions = ApiTypeHelper.unmodifiable(builder.versions);
    }

    public static ClusterIndices of(Function<ClusterIndices.Builder, ObjectBuilder<ClusterIndices>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code analysis}
     */
    @Nullable
    public final CharFilterTypes analysis() {
        return this.analysis;
    }

    /**
     * API name: {@code completion}
     */
    @Nullable
    public final CompletionStats completion() {
        return this.completion;
    }

    /**
     * Total number of indexes with shards assigned to selected nodes.
     * <p>
     * API name: {@code count}
     * </p>
     */
    @Nullable
    public final Long count() {
        return this.count;
    }

    /**
     * API name: {@code docs}
     */
    @Nullable
    public final DocStats docs() {
        return this.docs;
    }

    /**
     * API name: {@code fielddata}
     */
    @Nullable
    public final FielddataStats fielddata() {
        return this.fielddata;
    }

    /**
     * API name: {@code mappings}
     */
    @Nullable
    public final FieldTypesMappings mappings() {
        return this.mappings;
    }

    /**
     * API name: {@code query_cache}
     */
    @Nullable
    public final QueryCacheStats queryCache() {
        return this.queryCache;
    }

    /**
     * API name: {@code segments}
     */
    @Nullable
    public final SegmentsStats segments() {
        return this.segments;
    }

    /**
     * API name: {@code shards}
     */
    @Nullable
    public final ClusterIndicesShards shards() {
        return this.shards;
    }

    /**
     * API name: {@code store}
     */
    @Nullable
    public final StoreStats store() {
        return this.store;
    }

    /**
     * Contains statistics about analyzers and analyzer components used in selected nodes.
     * <p>
     * API name: {@code versions}
     * </p>
     */
    @Nonnull
    public final List<IndicesVersions> versions() {
        return this.versions;
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
        if (this.analysis != null) {
            generator.writeKey("analysis");
            this.analysis.serialize(generator, mapper);
        }

        if (this.completion != null) {
            generator.writeKey("completion");
            this.completion.serialize(generator, mapper);
        }

        if (this.count != null) {
            generator.writeKey("count");
            generator.write(this.count);
        }

        if (this.docs != null) {
            generator.writeKey("docs");
            this.docs.serialize(generator, mapper);
        }

        if (this.fielddata != null) {
            generator.writeKey("fielddata");
            this.fielddata.serialize(generator, mapper);
        }

        if (this.mappings != null) {
            generator.writeKey("mappings");
            this.mappings.serialize(generator, mapper);
        }

        if (this.queryCache != null) {
            generator.writeKey("query_cache");
            this.queryCache.serialize(generator, mapper);
        }

        if (this.segments != null) {
            generator.writeKey("segments");
            this.segments.serialize(generator, mapper);
        }

        if (this.shards != null) {
            generator.writeKey("shards");
            this.shards.serialize(generator, mapper);
        }

        if (this.store != null) {
            generator.writeKey("store");
            this.store.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.versions)) {
            generator.writeKey("versions");
            generator.writeStartArray();
            for (IndicesVersions item0 : this.versions) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link ClusterIndices}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterIndices> {
        @Nullable
        private CharFilterTypes analysis;
        @Nullable
        private CompletionStats completion;
        @Nullable
        private Long count;
        @Nullable
        private DocStats docs;
        @Nullable
        private FielddataStats fielddata;
        @Nullable
        private FieldTypesMappings mappings;
        @Nullable
        private QueryCacheStats queryCache;
        @Nullable
        private SegmentsStats segments;
        @Nullable
        private ClusterIndicesShards shards;
        @Nullable
        private StoreStats store;
        @Nullable
        private List<IndicesVersions> versions;

        public Builder() {}

        private Builder(ClusterIndices o) {
            this.analysis = o.analysis;
            this.completion = o.completion;
            this.count = o.count;
            this.docs = o.docs;
            this.fielddata = o.fielddata;
            this.mappings = o.mappings;
            this.queryCache = o.queryCache;
            this.segments = o.segments;
            this.shards = o.shards;
            this.store = o.store;
            this.versions = _listCopy(o.versions);
        }

        private Builder(Builder o) {
            this.analysis = o.analysis;
            this.completion = o.completion;
            this.count = o.count;
            this.docs = o.docs;
            this.fielddata = o.fielddata;
            this.mappings = o.mappings;
            this.queryCache = o.queryCache;
            this.segments = o.segments;
            this.shards = o.shards;
            this.store = o.store;
            this.versions = _listCopy(o.versions);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code analysis}
         */
        @Nonnull
        public final Builder analysis(@Nullable CharFilterTypes value) {
            this.analysis = value;
            return this;
        }

        /**
         * API name: {@code analysis}
         */
        @Nonnull
        public final Builder analysis(Function<CharFilterTypes.Builder, ObjectBuilder<CharFilterTypes>> fn) {
            return analysis(fn.apply(new CharFilterTypes.Builder()).build());
        }

        /**
         * API name: {@code completion}
         */
        @Nonnull
        public final Builder completion(@Nullable CompletionStats value) {
            this.completion = value;
            return this;
        }

        /**
         * API name: {@code completion}
         */
        @Nonnull
        public final Builder completion(Function<CompletionStats.Builder, ObjectBuilder<CompletionStats>> fn) {
            return completion(fn.apply(new CompletionStats.Builder()).build());
        }

        /**
         * Total number of indexes with shards assigned to selected nodes.
         * <p>
         * API name: {@code count}
         * </p>
         */
        @Nonnull
        public final Builder count(@Nullable Long value) {
            this.count = value;
            return this;
        }

        /**
         * API name: {@code docs}
         */
        @Nonnull
        public final Builder docs(@Nullable DocStats value) {
            this.docs = value;
            return this;
        }

        /**
         * API name: {@code docs}
         */
        @Nonnull
        public final Builder docs(Function<DocStats.Builder, ObjectBuilder<DocStats>> fn) {
            return docs(fn.apply(new DocStats.Builder()).build());
        }

        /**
         * API name: {@code fielddata}
         */
        @Nonnull
        public final Builder fielddata(@Nullable FielddataStats value) {
            this.fielddata = value;
            return this;
        }

        /**
         * API name: {@code fielddata}
         */
        @Nonnull
        public final Builder fielddata(Function<FielddataStats.Builder, ObjectBuilder<FielddataStats>> fn) {
            return fielddata(fn.apply(new FielddataStats.Builder()).build());
        }

        /**
         * API name: {@code mappings}
         */
        @Nonnull
        public final Builder mappings(@Nullable FieldTypesMappings value) {
            this.mappings = value;
            return this;
        }

        /**
         * API name: {@code mappings}
         */
        @Nonnull
        public final Builder mappings(Function<FieldTypesMappings.Builder, ObjectBuilder<FieldTypesMappings>> fn) {
            return mappings(fn.apply(new FieldTypesMappings.Builder()).build());
        }

        /**
         * API name: {@code query_cache}
         */
        @Nonnull
        public final Builder queryCache(@Nullable QueryCacheStats value) {
            this.queryCache = value;
            return this;
        }

        /**
         * API name: {@code query_cache}
         */
        @Nonnull
        public final Builder queryCache(Function<QueryCacheStats.Builder, ObjectBuilder<QueryCacheStats>> fn) {
            return queryCache(fn.apply(new QueryCacheStats.Builder()).build());
        }

        /**
         * API name: {@code segments}
         */
        @Nonnull
        public final Builder segments(@Nullable SegmentsStats value) {
            this.segments = value;
            return this;
        }

        /**
         * API name: {@code segments}
         */
        @Nonnull
        public final Builder segments(Function<SegmentsStats.Builder, ObjectBuilder<SegmentsStats>> fn) {
            return segments(fn.apply(new SegmentsStats.Builder()).build());
        }

        /**
         * API name: {@code shards}
         */
        @Nonnull
        public final Builder shards(@Nullable ClusterIndicesShards value) {
            this.shards = value;
            return this;
        }

        /**
         * API name: {@code shards}
         */
        @Nonnull
        public final Builder shards(Function<ClusterIndicesShards.Builder, ObjectBuilder<ClusterIndicesShards>> fn) {
            return shards(fn.apply(new ClusterIndicesShards.Builder()).build());
        }

        /**
         * API name: {@code store}
         */
        @Nonnull
        public final Builder store(@Nullable StoreStats value) {
            this.store = value;
            return this;
        }

        /**
         * API name: {@code store}
         */
        @Nonnull
        public final Builder store(Function<StoreStats.Builder, ObjectBuilder<StoreStats>> fn) {
            return store(fn.apply(new StoreStats.Builder()).build());
        }

        /**
         * Contains statistics about analyzers and analyzer components used in selected nodes.
         * <p>
         * API name: {@code versions}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>versions</code>.
         * </p>
         */
        @Nonnull
        public final Builder versions(List<IndicesVersions> list) {
            this.versions = _listAddAll(this.versions, list);
            return this;
        }

        /**
         * Contains statistics about analyzers and analyzer components used in selected nodes.
         * <p>
         * API name: {@code versions}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>versions</code>.
         * </p>
         */
        @Nonnull
        public final Builder versions(IndicesVersions value, IndicesVersions... values) {
            this.versions = _listAdd(this.versions, value, values);
            return this;
        }

        /**
         * Contains statistics about analyzers and analyzer components used in selected nodes.
         * <p>
         * API name: {@code versions}
         * </p>
         *
         * <p>
         * Adds a value to <code>versions</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder versions(Function<IndicesVersions.Builder, ObjectBuilder<IndicesVersions>> fn) {
            return versions(fn.apply(new IndicesVersions.Builder()).build());
        }

        /**
         * Builds a {@link ClusterIndices}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterIndices build() {
            _checkSingleUse();

            return new ClusterIndices(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterIndices}
     */
    public static final JsonpDeserializer<ClusterIndices> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterIndices::setupClusterIndicesDeserializer
    );

    protected static void setupClusterIndicesDeserializer(ObjectDeserializer<ClusterIndices.Builder> op) {
        op.add(Builder::analysis, CharFilterTypes._DESERIALIZER, "analysis");
        op.add(Builder::completion, CompletionStats._DESERIALIZER, "completion");
        op.add(Builder::count, JsonpDeserializer.longDeserializer(), "count");
        op.add(Builder::docs, DocStats._DESERIALIZER, "docs");
        op.add(Builder::fielddata, FielddataStats._DESERIALIZER, "fielddata");
        op.add(Builder::mappings, FieldTypesMappings._DESERIALIZER, "mappings");
        op.add(Builder::queryCache, QueryCacheStats._DESERIALIZER, "query_cache");
        op.add(Builder::segments, SegmentsStats._DESERIALIZER, "segments");
        op.add(Builder::shards, ClusterIndicesShards._DESERIALIZER, "shards");
        op.add(Builder::store, StoreStats._DESERIALIZER, "store");
        op.add(Builder::versions, JsonpDeserializer.arrayDeserializer(IndicesVersions._DESERIALIZER), "versions");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.analysis);
        result = 31 * result + Objects.hashCode(this.completion);
        result = 31 * result + Objects.hashCode(this.count);
        result = 31 * result + Objects.hashCode(this.docs);
        result = 31 * result + Objects.hashCode(this.fielddata);
        result = 31 * result + Objects.hashCode(this.mappings);
        result = 31 * result + Objects.hashCode(this.queryCache);
        result = 31 * result + Objects.hashCode(this.segments);
        result = 31 * result + Objects.hashCode(this.shards);
        result = 31 * result + Objects.hashCode(this.store);
        result = 31 * result + Objects.hashCode(this.versions);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterIndices other = (ClusterIndices) o;
        return Objects.equals(this.analysis, other.analysis)
            && Objects.equals(this.completion, other.completion)
            && Objects.equals(this.count, other.count)
            && Objects.equals(this.docs, other.docs)
            && Objects.equals(this.fielddata, other.fielddata)
            && Objects.equals(this.mappings, other.mappings)
            && Objects.equals(this.queryCache, other.queryCache)
            && Objects.equals(this.segments, other.segments)
            && Objects.equals(this.shards, other.shards)
            && Objects.equals(this.store, other.store)
            && Objects.equals(this.versions, other.versions);
    }
}
