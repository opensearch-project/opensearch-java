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
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.CompletionStats;
import org.opensearch.client.opensearch._types.DocStats;
import org.opensearch.client.opensearch._types.FielddataStats;
import org.opensearch.client.opensearch._types.FlushStats;
import org.opensearch.client.opensearch._types.GetStats;
import org.opensearch.client.opensearch._types.IndexingStats;
import org.opensearch.client.opensearch._types.MergesStats;
import org.opensearch.client.opensearch._types.QueryCacheStats;
import org.opensearch.client.opensearch._types.RecoveryStats;
import org.opensearch.client.opensearch._types.RefreshStats;
import org.opensearch.client.opensearch._types.RequestCacheStats;
import org.opensearch.client.opensearch._types.SearchStats;
import org.opensearch.client.opensearch._types.SegmentsStats;
import org.opensearch.client.opensearch._types.StoreStats;
import org.opensearch.client.opensearch._types.TranslogStats;
import org.opensearch.client.opensearch._types.WarmerStats;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: indices.stats.IndexStatsBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class IndexStatsBase implements PlainJsonSerializable {

    @Nullable
    private final CompletionStats completion;

    @Nullable
    private final DocStats docs;

    @Nullable
    private final FielddataStats fielddata;

    @Nullable
    private final FlushStats flush;

    @Nullable
    private final GetStats get;

    @Nullable
    private final IndexingStats indexing;

    @Nullable
    private final MergesStats merges;

    @Nullable
    private final QueryCacheStats queryCache;

    @Nullable
    private final RecoveryStats recovery;

    @Nullable
    private final RefreshStats refresh;

    @Nullable
    private final RequestCacheStats requestCache;

    @Nullable
    private final SearchStats search;

    @Nullable
    private final SegmentsStats segments;

    @Nullable
    private final StoreStats store;

    @Nullable
    private final TranslogStats translog;

    @Nullable
    private final WarmerStats warmer;

    // ---------------------------------------------------------------------------------------------

    protected IndexStatsBase(AbstractBuilder<?> builder) {
        this.completion = builder.completion;
        this.docs = builder.docs;
        this.fielddata = builder.fielddata;
        this.flush = builder.flush;
        this.get = builder.get;
        this.indexing = builder.indexing;
        this.merges = builder.merges;
        this.queryCache = builder.queryCache;
        this.recovery = builder.recovery;
        this.refresh = builder.refresh;
        this.requestCache = builder.requestCache;
        this.search = builder.search;
        this.segments = builder.segments;
        this.store = builder.store;
        this.translog = builder.translog;
        this.warmer = builder.warmer;
    }

    /**
     * API name: {@code completion}
     */
    @Nullable
    public final CompletionStats completion() {
        return this.completion;
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
     * API name: {@code flush}
     */
    @Nullable
    public final FlushStats flush() {
        return this.flush;
    }

    /**
     * API name: {@code get}
     */
    @Nullable
    public final GetStats get() {
        return this.get;
    }

    /**
     * API name: {@code indexing}
     */
    @Nullable
    public final IndexingStats indexing() {
        return this.indexing;
    }

    /**
     * API name: {@code merges}
     */
    @Nullable
    public final MergesStats merges() {
        return this.merges;
    }

    /**
     * API name: {@code query_cache}
     */
    @Nullable
    public final QueryCacheStats queryCache() {
        return this.queryCache;
    }

    /**
     * API name: {@code recovery}
     */
    @Nullable
    public final RecoveryStats recovery() {
        return this.recovery;
    }

    /**
     * API name: {@code refresh}
     */
    @Nullable
    public final RefreshStats refresh() {
        return this.refresh;
    }

    /**
     * API name: {@code request_cache}
     */
    @Nullable
    public final RequestCacheStats requestCache() {
        return this.requestCache;
    }

    /**
     * API name: {@code search}
     */
    @Nullable
    public final SearchStats search() {
        return this.search;
    }

    /**
     * API name: {@code segments}
     */
    @Nullable
    public final SegmentsStats segments() {
        return this.segments;
    }

    /**
     * API name: {@code store}
     */
    @Nullable
    public final StoreStats store() {
        return this.store;
    }

    /**
     * API name: {@code translog}
     */
    @Nullable
    public final TranslogStats translog() {
        return this.translog;
    }

    /**
     * API name: {@code warmer}
     */
    @Nullable
    public final WarmerStats warmer() {
        return this.warmer;
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
        if (this.completion != null) {
            generator.writeKey("completion");
            this.completion.serialize(generator, mapper);
        }

        if (this.docs != null) {
            generator.writeKey("docs");
            this.docs.serialize(generator, mapper);
        }

        if (this.fielddata != null) {
            generator.writeKey("fielddata");
            this.fielddata.serialize(generator, mapper);
        }

        if (this.flush != null) {
            generator.writeKey("flush");
            this.flush.serialize(generator, mapper);
        }

        if (this.get != null) {
            generator.writeKey("get");
            this.get.serialize(generator, mapper);
        }

        if (this.indexing != null) {
            generator.writeKey("indexing");
            this.indexing.serialize(generator, mapper);
        }

        if (this.merges != null) {
            generator.writeKey("merges");
            this.merges.serialize(generator, mapper);
        }

        if (this.queryCache != null) {
            generator.writeKey("query_cache");
            this.queryCache.serialize(generator, mapper);
        }

        if (this.recovery != null) {
            generator.writeKey("recovery");
            this.recovery.serialize(generator, mapper);
        }

        if (this.refresh != null) {
            generator.writeKey("refresh");
            this.refresh.serialize(generator, mapper);
        }

        if (this.requestCache != null) {
            generator.writeKey("request_cache");
            this.requestCache.serialize(generator, mapper);
        }

        if (this.search != null) {
            generator.writeKey("search");
            this.search.serialize(generator, mapper);
        }

        if (this.segments != null) {
            generator.writeKey("segments");
            this.segments.serialize(generator, mapper);
        }

        if (this.store != null) {
            generator.writeKey("store");
            this.store.serialize(generator, mapper);
        }

        if (this.translog != null) {
            generator.writeKey("translog");
            this.translog.serialize(generator, mapper);
        }

        if (this.warmer != null) {
            generator.writeKey("warmer");
            this.warmer.serialize(generator, mapper);
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        @Nullable
        private CompletionStats completion;
        @Nullable
        private DocStats docs;
        @Nullable
        private FielddataStats fielddata;
        @Nullable
        private FlushStats flush;
        @Nullable
        private GetStats get;
        @Nullable
        private IndexingStats indexing;
        @Nullable
        private MergesStats merges;
        @Nullable
        private QueryCacheStats queryCache;
        @Nullable
        private RecoveryStats recovery;
        @Nullable
        private RefreshStats refresh;
        @Nullable
        private RequestCacheStats requestCache;
        @Nullable
        private SearchStats search;
        @Nullable
        private SegmentsStats segments;
        @Nullable
        private StoreStats store;
        @Nullable
        private TranslogStats translog;
        @Nullable
        private WarmerStats warmer;

        protected AbstractBuilder() {}

        protected AbstractBuilder(IndexStatsBase o) {
            this.completion = o.completion;
            this.docs = o.docs;
            this.fielddata = o.fielddata;
            this.flush = o.flush;
            this.get = o.get;
            this.indexing = o.indexing;
            this.merges = o.merges;
            this.queryCache = o.queryCache;
            this.recovery = o.recovery;
            this.refresh = o.refresh;
            this.requestCache = o.requestCache;
            this.search = o.search;
            this.segments = o.segments;
            this.store = o.store;
            this.translog = o.translog;
            this.warmer = o.warmer;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            this.completion = o.completion;
            this.docs = o.docs;
            this.fielddata = o.fielddata;
            this.flush = o.flush;
            this.get = o.get;
            this.indexing = o.indexing;
            this.merges = o.merges;
            this.queryCache = o.queryCache;
            this.recovery = o.recovery;
            this.refresh = o.refresh;
            this.requestCache = o.requestCache;
            this.search = o.search;
            this.segments = o.segments;
            this.store = o.store;
            this.translog = o.translog;
            this.warmer = o.warmer;
        }

        @Nonnull
        protected abstract BuilderT self();

        /**
         * API name: {@code completion}
         */
        @Nonnull
        public final BuilderT completion(@Nullable CompletionStats value) {
            this.completion = value;
            return self();
        }

        /**
         * API name: {@code completion}
         */
        @Nonnull
        public final BuilderT completion(Function<CompletionStats.Builder, ObjectBuilder<CompletionStats>> fn) {
            return completion(fn.apply(new CompletionStats.Builder()).build());
        }

        /**
         * API name: {@code docs}
         */
        @Nonnull
        public final BuilderT docs(@Nullable DocStats value) {
            this.docs = value;
            return self();
        }

        /**
         * API name: {@code docs}
         */
        @Nonnull
        public final BuilderT docs(Function<DocStats.Builder, ObjectBuilder<DocStats>> fn) {
            return docs(fn.apply(new DocStats.Builder()).build());
        }

        /**
         * API name: {@code fielddata}
         */
        @Nonnull
        public final BuilderT fielddata(@Nullable FielddataStats value) {
            this.fielddata = value;
            return self();
        }

        /**
         * API name: {@code fielddata}
         */
        @Nonnull
        public final BuilderT fielddata(Function<FielddataStats.Builder, ObjectBuilder<FielddataStats>> fn) {
            return fielddata(fn.apply(new FielddataStats.Builder()).build());
        }

        /**
         * API name: {@code flush}
         */
        @Nonnull
        public final BuilderT flush(@Nullable FlushStats value) {
            this.flush = value;
            return self();
        }

        /**
         * API name: {@code flush}
         */
        @Nonnull
        public final BuilderT flush(Function<FlushStats.Builder, ObjectBuilder<FlushStats>> fn) {
            return flush(fn.apply(new FlushStats.Builder()).build());
        }

        /**
         * API name: {@code get}
         */
        @Nonnull
        public final BuilderT get(@Nullable GetStats value) {
            this.get = value;
            return self();
        }

        /**
         * API name: {@code get}
         */
        @Nonnull
        public final BuilderT get(Function<GetStats.Builder, ObjectBuilder<GetStats>> fn) {
            return get(fn.apply(new GetStats.Builder()).build());
        }

        /**
         * API name: {@code indexing}
         */
        @Nonnull
        public final BuilderT indexing(@Nullable IndexingStats value) {
            this.indexing = value;
            return self();
        }

        /**
         * API name: {@code indexing}
         */
        @Nonnull
        public final BuilderT indexing(Function<IndexingStats.Builder, ObjectBuilder<IndexingStats>> fn) {
            return indexing(fn.apply(new IndexingStats.Builder()).build());
        }

        /**
         * API name: {@code merges}
         */
        @Nonnull
        public final BuilderT merges(@Nullable MergesStats value) {
            this.merges = value;
            return self();
        }

        /**
         * API name: {@code merges}
         */
        @Nonnull
        public final BuilderT merges(Function<MergesStats.Builder, ObjectBuilder<MergesStats>> fn) {
            return merges(fn.apply(new MergesStats.Builder()).build());
        }

        /**
         * API name: {@code query_cache}
         */
        @Nonnull
        public final BuilderT queryCache(@Nullable QueryCacheStats value) {
            this.queryCache = value;
            return self();
        }

        /**
         * API name: {@code query_cache}
         */
        @Nonnull
        public final BuilderT queryCache(Function<QueryCacheStats.Builder, ObjectBuilder<QueryCacheStats>> fn) {
            return queryCache(fn.apply(new QueryCacheStats.Builder()).build());
        }

        /**
         * API name: {@code recovery}
         */
        @Nonnull
        public final BuilderT recovery(@Nullable RecoveryStats value) {
            this.recovery = value;
            return self();
        }

        /**
         * API name: {@code recovery}
         */
        @Nonnull
        public final BuilderT recovery(Function<RecoveryStats.Builder, ObjectBuilder<RecoveryStats>> fn) {
            return recovery(fn.apply(new RecoveryStats.Builder()).build());
        }

        /**
         * API name: {@code refresh}
         */
        @Nonnull
        public final BuilderT refresh(@Nullable RefreshStats value) {
            this.refresh = value;
            return self();
        }

        /**
         * API name: {@code refresh}
         */
        @Nonnull
        public final BuilderT refresh(Function<RefreshStats.Builder, ObjectBuilder<RefreshStats>> fn) {
            return refresh(fn.apply(new RefreshStats.Builder()).build());
        }

        /**
         * API name: {@code request_cache}
         */
        @Nonnull
        public final BuilderT requestCache(@Nullable RequestCacheStats value) {
            this.requestCache = value;
            return self();
        }

        /**
         * API name: {@code request_cache}
         */
        @Nonnull
        public final BuilderT requestCache(Function<RequestCacheStats.Builder, ObjectBuilder<RequestCacheStats>> fn) {
            return requestCache(fn.apply(new RequestCacheStats.Builder()).build());
        }

        /**
         * API name: {@code search}
         */
        @Nonnull
        public final BuilderT search(@Nullable SearchStats value) {
            this.search = value;
            return self();
        }

        /**
         * API name: {@code search}
         */
        @Nonnull
        public final BuilderT search(Function<SearchStats.Builder, ObjectBuilder<SearchStats>> fn) {
            return search(fn.apply(new SearchStats.Builder()).build());
        }

        /**
         * API name: {@code segments}
         */
        @Nonnull
        public final BuilderT segments(@Nullable SegmentsStats value) {
            this.segments = value;
            return self();
        }

        /**
         * API name: {@code segments}
         */
        @Nonnull
        public final BuilderT segments(Function<SegmentsStats.Builder, ObjectBuilder<SegmentsStats>> fn) {
            return segments(fn.apply(new SegmentsStats.Builder()).build());
        }

        /**
         * API name: {@code store}
         */
        @Nonnull
        public final BuilderT store(@Nullable StoreStats value) {
            this.store = value;
            return self();
        }

        /**
         * API name: {@code store}
         */
        @Nonnull
        public final BuilderT store(Function<StoreStats.Builder, ObjectBuilder<StoreStats>> fn) {
            return store(fn.apply(new StoreStats.Builder()).build());
        }

        /**
         * API name: {@code translog}
         */
        @Nonnull
        public final BuilderT translog(@Nullable TranslogStats value) {
            this.translog = value;
            return self();
        }

        /**
         * API name: {@code translog}
         */
        @Nonnull
        public final BuilderT translog(Function<TranslogStats.Builder, ObjectBuilder<TranslogStats>> fn) {
            return translog(fn.apply(new TranslogStats.Builder()).build());
        }

        /**
         * API name: {@code warmer}
         */
        @Nonnull
        public final BuilderT warmer(@Nullable WarmerStats value) {
            this.warmer = value;
            return self();
        }

        /**
         * API name: {@code warmer}
         */
        @Nonnull
        public final BuilderT warmer(Function<WarmerStats.Builder, ObjectBuilder<WarmerStats>> fn) {
            return warmer(fn.apply(new WarmerStats.Builder()).build());
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupIndexStatsBaseDeserializer(ObjectDeserializer<BuilderT> op) {
        op.add(AbstractBuilder::completion, CompletionStats._DESERIALIZER, "completion");
        op.add(AbstractBuilder::docs, DocStats._DESERIALIZER, "docs");
        op.add(AbstractBuilder::fielddata, FielddataStats._DESERIALIZER, "fielddata");
        op.add(AbstractBuilder::flush, FlushStats._DESERIALIZER, "flush");
        op.add(AbstractBuilder::get, GetStats._DESERIALIZER, "get");
        op.add(AbstractBuilder::indexing, IndexingStats._DESERIALIZER, "indexing");
        op.add(AbstractBuilder::merges, MergesStats._DESERIALIZER, "merges");
        op.add(AbstractBuilder::queryCache, QueryCacheStats._DESERIALIZER, "query_cache");
        op.add(AbstractBuilder::recovery, RecoveryStats._DESERIALIZER, "recovery");
        op.add(AbstractBuilder::refresh, RefreshStats._DESERIALIZER, "refresh");
        op.add(AbstractBuilder::requestCache, RequestCacheStats._DESERIALIZER, "request_cache");
        op.add(AbstractBuilder::search, SearchStats._DESERIALIZER, "search");
        op.add(AbstractBuilder::segments, SegmentsStats._DESERIALIZER, "segments");
        op.add(AbstractBuilder::store, StoreStats._DESERIALIZER, "store");
        op.add(AbstractBuilder::translog, TranslogStats._DESERIALIZER, "translog");
        op.add(AbstractBuilder::warmer, WarmerStats._DESERIALIZER, "warmer");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.completion);
        result = 31 * result + Objects.hashCode(this.docs);
        result = 31 * result + Objects.hashCode(this.fielddata);
        result = 31 * result + Objects.hashCode(this.flush);
        result = 31 * result + Objects.hashCode(this.get);
        result = 31 * result + Objects.hashCode(this.indexing);
        result = 31 * result + Objects.hashCode(this.merges);
        result = 31 * result + Objects.hashCode(this.queryCache);
        result = 31 * result + Objects.hashCode(this.recovery);
        result = 31 * result + Objects.hashCode(this.refresh);
        result = 31 * result + Objects.hashCode(this.requestCache);
        result = 31 * result + Objects.hashCode(this.search);
        result = 31 * result + Objects.hashCode(this.segments);
        result = 31 * result + Objects.hashCode(this.store);
        result = 31 * result + Objects.hashCode(this.translog);
        result = 31 * result + Objects.hashCode(this.warmer);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexStatsBase other = (IndexStatsBase) o;
        return Objects.equals(this.completion, other.completion)
            && Objects.equals(this.docs, other.docs)
            && Objects.equals(this.fielddata, other.fielddata)
            && Objects.equals(this.flush, other.flush)
            && Objects.equals(this.get, other.get)
            && Objects.equals(this.indexing, other.indexing)
            && Objects.equals(this.merges, other.merges)
            && Objects.equals(this.queryCache, other.queryCache)
            && Objects.equals(this.recovery, other.recovery)
            && Objects.equals(this.refresh, other.refresh)
            && Objects.equals(this.requestCache, other.requestCache)
            && Objects.equals(this.search, other.search)
            && Objects.equals(this.segments, other.segments)
            && Objects.equals(this.store, other.store)
            && Objects.equals(this.translog, other.translog)
            && Objects.equals(this.warmer, other.warmer);
    }
}
