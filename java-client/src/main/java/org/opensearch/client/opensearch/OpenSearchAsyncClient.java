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

package org.opensearch.client.opensearch;

import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch._types.OpensearchException;
import org.opensearch.client.opensearch.cat.OpensearchCatAsyncClient;
import org.opensearch.client.opensearch.cluster.OpensearchClusterAsyncClient;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.ClearScrollRequest;
import org.opensearch.client.opensearch.core.ClearScrollResponse;
import org.opensearch.client.opensearch.core.ClosePointInTimeRequest;
import org.opensearch.client.opensearch.core.ClosePointInTimeResponse;
import org.opensearch.client.opensearch.core.CountRequest;
import org.opensearch.client.opensearch.core.CountResponse;
import org.opensearch.client.opensearch.core.CreateRequest;
import org.opensearch.client.opensearch.core.CreateResponse;
import org.opensearch.client.opensearch.core.DeleteByQueryRequest;
import org.opensearch.client.opensearch.core.DeleteByQueryResponse;
import org.opensearch.client.opensearch.core.DeleteByQueryRethrottleRequest;
import org.opensearch.client.opensearch.core.DeleteByQueryRethrottleResponse;
import org.opensearch.client.opensearch.core.DeleteRequest;
import org.opensearch.client.opensearch.core.DeleteResponse;
import org.opensearch.client.opensearch.core.DeleteScriptRequest;
import org.opensearch.client.opensearch.core.DeleteScriptResponse;
import org.opensearch.client.opensearch.core.ExistsRequest;
import org.opensearch.client.opensearch.core.ExistsSourceRequest;
import org.opensearch.client.opensearch.core.ExplainRequest;
import org.opensearch.client.opensearch.core.ExplainResponse;
import org.opensearch.client.opensearch.core.FieldCapsRequest;
import org.opensearch.client.opensearch.core.FieldCapsResponse;
import org.opensearch.client.opensearch.core.GetRequest;
import org.opensearch.client.opensearch.core.GetResponse;
import org.opensearch.client.opensearch.core.GetScriptContextRequest;
import org.opensearch.client.opensearch.core.GetScriptContextResponse;
import org.opensearch.client.opensearch.core.GetScriptLanguagesRequest;
import org.opensearch.client.opensearch.core.GetScriptLanguagesResponse;
import org.opensearch.client.opensearch.core.GetScriptRequest;
import org.opensearch.client.opensearch.core.GetScriptResponse;
import org.opensearch.client.opensearch.core.GetSourceRequest;
import org.opensearch.client.opensearch.core.GetSourceResponse;
import org.opensearch.client.opensearch.core.IndexRequest;
import org.opensearch.client.opensearch.core.IndexResponse;
import org.opensearch.client.opensearch.core.InfoRequest;
import org.opensearch.client.opensearch.core.InfoResponse;
import org.opensearch.client.opensearch.core.KnnSearchRequest;
import org.opensearch.client.opensearch.core.KnnSearchResponse;
import org.opensearch.client.opensearch.core.MgetRequest;
import org.opensearch.client.opensearch.core.MgetResponse;
import org.opensearch.client.opensearch.core.MsearchRequest;
import org.opensearch.client.opensearch.core.MsearchResponse;
import org.opensearch.client.opensearch.core.MsearchTemplateRequest;
import org.opensearch.client.opensearch.core.MsearchTemplateResponse;
import org.opensearch.client.opensearch.core.MtermvectorsRequest;
import org.opensearch.client.opensearch.core.MtermvectorsResponse;
import org.opensearch.client.opensearch.core.OpenPointInTimeRequest;
import org.opensearch.client.opensearch.core.OpenPointInTimeResponse;
import org.opensearch.client.opensearch.core.PingRequest;
import org.opensearch.client.opensearch.core.PutScriptRequest;
import org.opensearch.client.opensearch.core.PutScriptResponse;
import org.opensearch.client.opensearch.core.RankEvalRequest;
import org.opensearch.client.opensearch.core.RankEvalResponse;
import org.opensearch.client.opensearch.core.ReindexRequest;
import org.opensearch.client.opensearch.core.ReindexResponse;
import org.opensearch.client.opensearch.core.ReindexRethrottleRequest;
import org.opensearch.client.opensearch.core.ReindexRethrottleResponse;
import org.opensearch.client.opensearch.core.ScriptsPainlessExecuteRequest;
import org.opensearch.client.opensearch.core.ScriptsPainlessExecuteResponse;
import org.opensearch.client.opensearch.core.SearchMvtRequest;
import org.opensearch.client.opensearch.core.SearchMvtResponse;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.core.SearchShardsRequest;
import org.opensearch.client.opensearch.core.SearchShardsResponse;
import org.opensearch.client.opensearch.core.SearchTemplateRequest;
import org.opensearch.client.opensearch.core.SearchTemplateResponse;
import org.opensearch.client.opensearch.core.TermsEnumRequest;
import org.opensearch.client.opensearch.core.TermsEnumResponse;
import org.opensearch.client.opensearch.core.TermvectorsRequest;
import org.opensearch.client.opensearch.core.TermvectorsResponse;
import org.opensearch.client.opensearch.core.UpdateByQueryRequest;
import org.opensearch.client.opensearch.core.UpdateByQueryResponse;
import org.opensearch.client.opensearch.core.UpdateByQueryRethrottleRequest;
import org.opensearch.client.opensearch.core.UpdateByQueryRethrottleResponse;
import org.opensearch.client.opensearch.core.UpdateRequest;
import org.opensearch.client.opensearch.core.UpdateResponse;
import org.opensearch.client.opensearch.dangling_indices.OpensearchDanglingIndicesAsyncClient;
import org.opensearch.client.opensearch.features.OpensearchFeaturesAsyncClient;
import org.opensearch.client.opensearch.indices.OpensearchIndicesAsyncClient;
import org.opensearch.client.opensearch.ingest.OpensearchIngestAsyncClient;
import org.opensearch.client.opensearch.nodes.OpensearchNodesAsyncClient;
import org.opensearch.client.opensearch.shutdown.OpensearchShutdownAsyncClient;
import org.opensearch.client.opensearch.snapshot.OpensearchSnapshotAsyncClient;
import org.opensearch.client.opensearch.tasks.OpensearchTasksAsyncClient;
import org.opensearch.client.transport.BooleanResponse;
import org.opensearch.client.transport.Transport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.util.ObjectBuilder;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import javax.annotation.Nullable;

/**
 * Client for the namespace.
 */
public class OpenSearchAsyncClient extends ApiClient<OpenSearchAsyncClient> {

    public OpenSearchAsyncClient(Transport transport) {
        super(transport, null);
    }

    public OpenSearchAsyncClient(Transport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchAsyncClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchAsyncClient(this.transport, transportOptions);
    }

    // ----- Child clients

    public OpensearchCatAsyncClient cat() {
        return new OpensearchCatAsyncClient(this.transport, this.transportOptions);
    }

    public OpensearchClusterAsyncClient cluster() {
        return new OpensearchClusterAsyncClient(this.transport, this.transportOptions);
    }

    public OpensearchDanglingIndicesAsyncClient danglingIndices() {
        return new OpensearchDanglingIndicesAsyncClient(this.transport, this.transportOptions);
    }

    public OpensearchFeaturesAsyncClient features() {
        return new OpensearchFeaturesAsyncClient(this.transport, this.transportOptions);
    }

    public OpensearchIndicesAsyncClient indices() {
        return new OpensearchIndicesAsyncClient(this.transport, this.transportOptions);
    }

    public OpensearchIngestAsyncClient ingest() {
        return new OpensearchIngestAsyncClient(this.transport, this.transportOptions);
    }

    public OpensearchNodesAsyncClient nodes() {
        return new OpensearchNodesAsyncClient(this.transport, this.transportOptions);
    }

    public OpensearchShutdownAsyncClient shutdown() {
        return new OpensearchShutdownAsyncClient(this.transport, this.transportOptions);
    }

    public OpensearchSnapshotAsyncClient snapshot() {
        return new OpensearchSnapshotAsyncClient(this.transport, this.transportOptions);
    }

    public OpensearchTasksAsyncClient tasks() {
        return new OpensearchTasksAsyncClient(this.transport, this.transportOptions);
    }

    // ----- Endpoint: bulk

    /**
     * Allows to perform multiple index/update/delete operations in a single
     * request.
     *
     * 
     */

    public CompletableFuture<BulkResponse> bulk(BulkRequest request) throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, BulkRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Allows to perform multiple index/update/delete operations in a single
     * request.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link BulkRequest}
     * 
     */

    public final CompletableFuture<BulkResponse> bulk(Function<BulkRequest.Builder, ObjectBuilder<BulkRequest>> fn)
            throws IOException, OpensearchException {
        return bulk(fn.apply(new BulkRequest.Builder()).build());
    }

    /**
     * Allows to perform multiple index/update/delete operations in a single
     * request.
     *
     * 
     */

    public CompletableFuture<BulkResponse> bulk() throws IOException, OpensearchException {
        return this.transport.performRequestAsync(new BulkRequest.Builder().build(), BulkRequest.ENDPOINT,
                this.transportOptions);
    }

    // ----- Endpoint: clear_scroll

    /**
     * Explicitly clears the search context for a scroll.
     *
     * 
     */

    public CompletableFuture<ClearScrollResponse> clearScroll(ClearScrollRequest request)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, ClearScrollRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Explicitly clears the search context for a scroll.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link ClearScrollRequest}
     * 
     */

    public final CompletableFuture<ClearScrollResponse> clearScroll(
            Function<ClearScrollRequest.Builder, ObjectBuilder<ClearScrollRequest>> fn)
            throws IOException, OpensearchException {
        return clearScroll(fn.apply(new ClearScrollRequest.Builder()).build());
    }

    /**
     * Explicitly clears the search context for a scroll.
     *
     * 
     */

    public CompletableFuture<ClearScrollResponse> clearScroll() throws IOException, OpensearchException {
        return this.transport.performRequestAsync(new ClearScrollRequest.Builder().build(), ClearScrollRequest.ENDPOINT,
                this.transportOptions);
    }

    // ----- Endpoint: close_point_in_time

    /**
     * Close a point in time
     *
     * 
     */

    public CompletableFuture<ClosePointInTimeResponse> closePointInTime(ClosePointInTimeRequest request)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, ClosePointInTimeRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Close a point in time
     *
     * @param fn a function that initializes a builder to create the
     *           {@link ClosePointInTimeRequest}
     * 
     */

    public final CompletableFuture<ClosePointInTimeResponse> closePointInTime(
            Function<ClosePointInTimeRequest.Builder, ObjectBuilder<ClosePointInTimeRequest>> fn)
            throws IOException, OpensearchException {
        return closePointInTime(fn.apply(new ClosePointInTimeRequest.Builder()).build());
    }

    // ----- Endpoint: count

    /**
     * Returns number of documents matching a query.
     *
     * 
     */

    public CompletableFuture<CountResponse> count(CountRequest request) throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, CountRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Returns number of documents matching a query.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link CountRequest}
     * 
     */

    public final CompletableFuture<CountResponse> count(Function<CountRequest.Builder, ObjectBuilder<CountRequest>> fn)
            throws IOException, OpensearchException {
        return count(fn.apply(new CountRequest.Builder()).build());
    }

    /**
     * Returns number of documents matching a query.
     *
     * 
     */

    public CompletableFuture<CountResponse> count() throws IOException, OpensearchException {
        return this.transport.performRequestAsync(new CountRequest.Builder().build(), CountRequest.ENDPOINT,
                this.transportOptions);
    }

    // ----- Endpoint: create

    /**
     * Creates a new document in the index.
     * <p>
     * Returns a 409 response when a document with a same ID already exists in the
     * index.
     *
     * 
     */

    public <TDocument> CompletableFuture<CreateResponse> create(CreateRequest<TDocument> request)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, CreateRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Creates a new document in the index.
     * <p>
     * Returns a 409 response when a document with a same ID already exists in the
     * index.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link CreateRequest}
     * 
     */

    public final <TDocument> CompletableFuture<CreateResponse> create(
            Function<CreateRequest.Builder<TDocument>, ObjectBuilder<CreateRequest<TDocument>>> fn)
            throws IOException, OpensearchException {
        return create(fn.apply(new CreateRequest.Builder<TDocument>()).build());
    }

    // ----- Endpoint: delete

    /**
     * Removes a document from the index.
     *
     * 
     */

    public CompletableFuture<DeleteResponse> delete(DeleteRequest request) throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, DeleteRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Removes a document from the index.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link DeleteRequest}
     * 
     */

    public final CompletableFuture<DeleteResponse> delete(
            Function<DeleteRequest.Builder, ObjectBuilder<DeleteRequest>> fn)
            throws IOException, OpensearchException {
        return delete(fn.apply(new DeleteRequest.Builder()).build());
    }

    // ----- Endpoint: delete_by_query

    /**
     * Deletes documents matching the provided query.
     *
     * 
     */

    public CompletableFuture<DeleteByQueryResponse> deleteByQuery(DeleteByQueryRequest request)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, DeleteByQueryRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes documents matching the provided query.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link DeleteByQueryRequest}
     * 
     */

    public final CompletableFuture<DeleteByQueryResponse> deleteByQuery(
            Function<DeleteByQueryRequest.Builder, ObjectBuilder<DeleteByQueryRequest>> fn)
            throws IOException, OpensearchException {
        return deleteByQuery(fn.apply(new DeleteByQueryRequest.Builder()).build());
    }

    // ----- Endpoint: delete_by_query_rethrottle

    /**
     * Changes the number of requests per second for a particular Delete By Query
     * operation.
     *
     * 
     */

    public CompletableFuture<DeleteByQueryRethrottleResponse> deleteByQueryRethrottle(
            DeleteByQueryRethrottleRequest request) throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, DeleteByQueryRethrottleRequest.ENDPOINT,
                this.transportOptions);
    }

    /**
     * Changes the number of requests per second for a particular Delete By Query
     * operation.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link DeleteByQueryRethrottleRequest}
     * 
     */

    public final CompletableFuture<DeleteByQueryRethrottleResponse> deleteByQueryRethrottle(
            Function<DeleteByQueryRethrottleRequest.Builder, ObjectBuilder<DeleteByQueryRethrottleRequest>> fn)
            throws IOException, OpensearchException {
        return deleteByQueryRethrottle(fn.apply(new DeleteByQueryRethrottleRequest.Builder()).build());
    }

    // ----- Endpoint: delete_script

    /**
     * Deletes a script.
     *
     * 
     */

    public CompletableFuture<DeleteScriptResponse> deleteScript(DeleteScriptRequest request)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, DeleteScriptRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a script.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link DeleteScriptRequest}
     * 
     */

    public final CompletableFuture<DeleteScriptResponse> deleteScript(
            Function<DeleteScriptRequest.Builder, ObjectBuilder<DeleteScriptRequest>> fn)
            throws IOException, OpensearchException {
        return deleteScript(fn.apply(new DeleteScriptRequest.Builder()).build());
    }

    // ----- Endpoint: exists

    /**
     * Returns information about whether a document exists in an index.
     *
     * 
     */

    public CompletableFuture<BooleanResponse> exists(ExistsRequest request) throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, ExistsRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about whether a document exists in an index.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link ExistsRequest}
     * 
     */

    public final CompletableFuture<BooleanResponse> exists(
            Function<ExistsRequest.Builder, ObjectBuilder<ExistsRequest>> fn)
            throws IOException, OpensearchException {
        return exists(fn.apply(new ExistsRequest.Builder()).build());
    }

    // ----- Endpoint: exists_source

    /**
     * Returns information about whether a document source exists in an index.
     *
     * 
     */

    public CompletableFuture<BooleanResponse> existsSource(ExistsSourceRequest request)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, ExistsSourceRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about whether a document source exists in an index.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link ExistsSourceRequest}
     * 
     */

    public final CompletableFuture<BooleanResponse> existsSource(
            Function<ExistsSourceRequest.Builder, ObjectBuilder<ExistsSourceRequest>> fn)
            throws IOException, OpensearchException {
        return existsSource(fn.apply(new ExistsSourceRequest.Builder()).build());
    }

    // ----- Endpoint: explain

    /**
     * Returns information about why a specific matches (or doesn't match) a query.
     *
     * 
     */

    public <TDocument> CompletableFuture<ExplainResponse<TDocument>> explain(ExplainRequest request,
                                                                             Class<TDocument> tDocumentClass) throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request,
                ExplainRequest.createExplainEndpoint(getDeserializer(tDocumentClass)), this.transportOptions);
    }

    /**
     * Returns information about why a specific matches (or doesn't match) a query.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link ExplainRequest}
     * 
     */

    public final <TDocument> CompletableFuture<ExplainResponse<TDocument>> explain(
            Function<ExplainRequest.Builder, ObjectBuilder<ExplainRequest>> fn, Class<TDocument> tDocumentClass)
            throws IOException, OpensearchException {
        return explain(fn.apply(new ExplainRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: field_caps

    /**
     * Returns the information about the capabilities of fields among multiple
     * indices.
     *
     * 
     */

    public CompletableFuture<FieldCapsResponse> fieldCaps(FieldCapsRequest request)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, FieldCapsRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Returns the information about the capabilities of fields among multiple
     * indices.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link FieldCapsRequest}
     * 
     */

    public final CompletableFuture<FieldCapsResponse> fieldCaps(
            Function<FieldCapsRequest.Builder, ObjectBuilder<FieldCapsRequest>> fn)
            throws IOException, OpensearchException {
        return fieldCaps(fn.apply(new FieldCapsRequest.Builder()).build());
    }

    /**
     * Returns the information about the capabilities of fields among multiple
     * indices.
     *
     * 
     */

    public CompletableFuture<FieldCapsResponse> fieldCaps() throws IOException, OpensearchException {
        return this.transport.performRequestAsync(new FieldCapsRequest.Builder().build(), FieldCapsRequest.ENDPOINT,
                this.transportOptions);
    }

    // ----- Endpoint: get

    /**
     * Returns a document.
     *
     * 
     */

    public <TDocument> CompletableFuture<GetResponse<TDocument>> get(GetRequest request,
                                                                     Class<TDocument> tDocumentClass) throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request,
                GetRequest.createGetEndpoint(getDeserializer(tDocumentClass)), this.transportOptions);
    }

    /**
     * Returns a document.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link GetRequest}
     * 
     */

    public final <TDocument> CompletableFuture<GetResponse<TDocument>> get(
            Function<GetRequest.Builder, ObjectBuilder<GetRequest>> fn, Class<TDocument> tDocumentClass)
            throws IOException, OpensearchException {
        return get(fn.apply(new GetRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: get_script

    /**
     * Returns a script.
     *
     * 
     */

    public CompletableFuture<GetScriptResponse> getScript(GetScriptRequest request)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, GetScriptRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Returns a script.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link GetScriptRequest}
     * 
     */

    public final CompletableFuture<GetScriptResponse> getScript(
            Function<GetScriptRequest.Builder, ObjectBuilder<GetScriptRequest>> fn)
            throws IOException, OpensearchException {
        return getScript(fn.apply(new GetScriptRequest.Builder()).build());
    }

    // ----- Endpoint: get_script_context

    /**
     * Returns all script contexts.
     *
     * 
     */
    public CompletableFuture<GetScriptContextResponse> getScriptContext() throws IOException, OpensearchException {
        return this.transport.performRequestAsync(GetScriptContextRequest._INSTANCE, GetScriptContextRequest.ENDPOINT,
                this.transportOptions);
    }

    // ----- Endpoint: get_script_languages

    /**
     * Returns available script types, languages and contexts
     *
     * 
     */
    public CompletableFuture<GetScriptLanguagesResponse> getScriptLanguages()
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(GetScriptLanguagesRequest._INSTANCE,
                GetScriptLanguagesRequest.ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: get_source

    /**
     * Returns the source of a document.
     *
     * 
     */

    public <TDocument> CompletableFuture<GetSourceResponse<TDocument>> getSource(GetSourceRequest request,
                                                                                 Class<TDocument> tDocumentClass) throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request,
                GetSourceRequest.createGetSourceEndpoint(getDeserializer(tDocumentClass)), this.transportOptions);
    }

    /**
     * Returns the source of a document.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link GetSourceRequest}
     * 
     */

    public final <TDocument> CompletableFuture<GetSourceResponse<TDocument>> getSource(
            Function<GetSourceRequest.Builder, ObjectBuilder<GetSourceRequest>> fn, Class<TDocument> tDocumentClass)
            throws IOException, OpensearchException {
        return getSource(fn.apply(new GetSourceRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: index

    /**
     * Creates or updates a document in an index.
     *
     * 
     */

    public <TDocument> CompletableFuture<IndexResponse> index(IndexRequest<TDocument> request)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, IndexRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or updates a document in an index.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link IndexRequest}
     * 
     */

    public final <TDocument> CompletableFuture<IndexResponse> index(
            Function<IndexRequest.Builder<TDocument>, ObjectBuilder<IndexRequest<TDocument>>> fn)
            throws IOException, OpensearchException {
        return index(fn.apply(new IndexRequest.Builder<TDocument>()).build());
    }

    // ----- Endpoint: info

    /**
     * Returns basic information about the cluster.
     *
     * 
     */
    public CompletableFuture<InfoResponse> info() throws IOException, OpensearchException {
        return this.transport.performRequestAsync(InfoRequest._INSTANCE, InfoRequest.ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: knn_search

    /**
     * Performs a kNN search.
     *
     * 
     */

    public <TDocument> CompletableFuture<KnnSearchResponse<TDocument>> knnSearch(KnnSearchRequest request,
                                                                                 Class<TDocument> tDocumentClass) throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request,
                KnnSearchRequest.createKnnSearchEndpoint(getDeserializer(tDocumentClass)), this.transportOptions);
    }

    /**
     * Performs a kNN search.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link KnnSearchRequest}
     * 
     */

    public final <TDocument> CompletableFuture<KnnSearchResponse<TDocument>> knnSearch(
            Function<KnnSearchRequest.Builder, ObjectBuilder<KnnSearchRequest>> fn, Class<TDocument> tDocumentClass)
            throws IOException, OpensearchException {
        return knnSearch(fn.apply(new KnnSearchRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: mget

    /**
     * Allows to get multiple documents in one request.
     *
     * 
     */

    public <TDocument> CompletableFuture<MgetResponse<TDocument>> mget(MgetRequest request,
                                                                       Class<TDocument> tDocumentClass) throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request,
                MgetRequest.createMgetEndpoint(getDeserializer(tDocumentClass)), this.transportOptions);
    }

    /**
     * Allows to get multiple documents in one request.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link MgetRequest}
     * 
     */

    public final <TDocument> CompletableFuture<MgetResponse<TDocument>> mget(
            Function<MgetRequest.Builder, ObjectBuilder<MgetRequest>> fn, Class<TDocument> tDocumentClass)
            throws IOException, OpensearchException {
        return mget(fn.apply(new MgetRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: msearch

    /**
     * Allows to execute several search operations in one request.
     *
     * 
     */

    public <TDocument> CompletableFuture<MsearchResponse<TDocument>> msearch(MsearchRequest request,
                                                                             Class<TDocument> tDocumentClass) throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request,
                MsearchRequest.createMsearchEndpoint(getDeserializer(tDocumentClass)), this.transportOptions);
    }

    /**
     * Allows to execute several search operations in one request.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link MsearchRequest}
     * 
     */

    public final <TDocument> CompletableFuture<MsearchResponse<TDocument>> msearch(
            Function<MsearchRequest.Builder, ObjectBuilder<MsearchRequest>> fn, Class<TDocument> tDocumentClass)
            throws IOException, OpensearchException {
        return msearch(fn.apply(new MsearchRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: msearch_template

    /**
     * Allows to execute several search template operations in one request.
     *
     * 
     */

    public <TDocument> CompletableFuture<MsearchTemplateResponse<TDocument>> msearchTemplate(
            MsearchTemplateRequest request, Class<TDocument> tDocumentClass)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request,
                MsearchTemplateRequest.createMsearchTemplateEndpoint(getDeserializer(tDocumentClass)),
                this.transportOptions);
    }

    /**
     * Allows to execute several search template operations in one request.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link MsearchTemplateRequest}
     * 
     */

    public final <TDocument> CompletableFuture<MsearchTemplateResponse<TDocument>> msearchTemplate(
            Function<MsearchTemplateRequest.Builder, ObjectBuilder<MsearchTemplateRequest>> fn,
            Class<TDocument> tDocumentClass) throws IOException, OpensearchException {
        return msearchTemplate(fn.apply(new MsearchTemplateRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: mtermvectors

    /**
     * Returns multiple termvectors in one request.
     *
     * 
     */

    public CompletableFuture<MtermvectorsResponse> mtermvectors(MtermvectorsRequest request)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, MtermvectorsRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Returns multiple termvectors in one request.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link MtermvectorsRequest}
     * 
     */

    public final CompletableFuture<MtermvectorsResponse> mtermvectors(
            Function<MtermvectorsRequest.Builder, ObjectBuilder<MtermvectorsRequest>> fn)
            throws IOException, OpensearchException {
        return mtermvectors(fn.apply(new MtermvectorsRequest.Builder()).build());
    }

    /**
     * Returns multiple termvectors in one request.
     *
     * 
     */

    public CompletableFuture<MtermvectorsResponse> mtermvectors() throws IOException, OpensearchException {
        return this.transport.performRequestAsync(new MtermvectorsRequest.Builder().build(),
                MtermvectorsRequest.ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: open_point_in_time

    /**
     * Open a point in time that can be used in subsequent searches
     *
     * 
     */

    public CompletableFuture<OpenPointInTimeResponse> openPointInTime(OpenPointInTimeRequest request)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, OpenPointInTimeRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Open a point in time that can be used in subsequent searches
     *
     * @param fn a function that initializes a builder to create the
     *           {@link OpenPointInTimeRequest}
     * 
     */

    public final CompletableFuture<OpenPointInTimeResponse> openPointInTime(
            Function<OpenPointInTimeRequest.Builder, ObjectBuilder<OpenPointInTimeRequest>> fn)
            throws IOException, OpensearchException {
        return openPointInTime(fn.apply(new OpenPointInTimeRequest.Builder()).build());
    }

    // ----- Endpoint: ping

    /**
     * Returns whether the cluster is running.
     *
     * 
     */
    public CompletableFuture<BooleanResponse> ping() throws IOException, OpensearchException {
        return this.transport.performRequestAsync(PingRequest._INSTANCE, PingRequest.ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: put_script

    /**
     * Creates or updates a script.
     *
     * 
     */

    public CompletableFuture<PutScriptResponse> putScript(PutScriptRequest request)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, PutScriptRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or updates a script.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link PutScriptRequest}
     * 
     */

    public final CompletableFuture<PutScriptResponse> putScript(
            Function<PutScriptRequest.Builder, ObjectBuilder<PutScriptRequest>> fn)
            throws IOException, OpensearchException {
        return putScript(fn.apply(new PutScriptRequest.Builder()).build());
    }

    // ----- Endpoint: rank_eval

    /**
     * Allows to evaluate the quality of ranked search results over a set of typical
     * search queries
     *
     * 
     */

    public CompletableFuture<RankEvalResponse> rankEval(RankEvalRequest request)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, RankEvalRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Allows to evaluate the quality of ranked search results over a set of typical
     * search queries
     *
     * @param fn a function that initializes a builder to create the
     *           {@link RankEvalRequest}
     * 
     */

    public final CompletableFuture<RankEvalResponse> rankEval(
            Function<RankEvalRequest.Builder, ObjectBuilder<RankEvalRequest>> fn)
            throws IOException, OpensearchException {
        return rankEval(fn.apply(new RankEvalRequest.Builder()).build());
    }

    // ----- Endpoint: reindex

    /**
     * Allows to copy documents from one index to another, optionally filtering the
     * source documents by a query, changing the destination index settings, or
     * fetching the documents from a remote cluster.
     *
     * 
     */

    public CompletableFuture<ReindexResponse> reindex(ReindexRequest request)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, ReindexRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Allows to copy documents from one index to another, optionally filtering the
     * source documents by a query, changing the destination index settings, or
     * fetching the documents from a remote cluster.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link ReindexRequest}
     * 
     */

    public final CompletableFuture<ReindexResponse> reindex(
            Function<ReindexRequest.Builder, ObjectBuilder<ReindexRequest>> fn)
            throws IOException, OpensearchException {
        return reindex(fn.apply(new ReindexRequest.Builder()).build());
    }

    /**
     * Allows to copy documents from one index to another, optionally filtering the
     * source documents by a query, changing the destination index settings, or
     * fetching the documents from a remote cluster.
     *
     * 
     */

    public CompletableFuture<ReindexResponse> reindex() throws IOException, OpensearchException {
        return this.transport.performRequestAsync(new ReindexRequest.Builder().build(), ReindexRequest.ENDPOINT,
                this.transportOptions);
    }

    // ----- Endpoint: reindex_rethrottle

    /**
     * Changes the number of requests per second for a particular Reindex operation.
     *
     * 
     */

    public CompletableFuture<ReindexRethrottleResponse> reindexRethrottle(ReindexRethrottleRequest request)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, ReindexRethrottleRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Changes the number of requests per second for a particular Reindex operation.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link ReindexRethrottleRequest}
     * 
     */

    public final CompletableFuture<ReindexRethrottleResponse> reindexRethrottle(
            Function<ReindexRethrottleRequest.Builder, ObjectBuilder<ReindexRethrottleRequest>> fn)
            throws IOException, OpensearchException {
        return reindexRethrottle(fn.apply(new ReindexRethrottleRequest.Builder()).build());
    }

    // ----- Endpoint: scripts_painless_execute

    /**
     * Allows an arbitrary script to be executed and a result to be returned
     *
     * 
     */

    public <TResult> CompletableFuture<ScriptsPainlessExecuteResponse<TResult>> scriptsPainlessExecute(
            ScriptsPainlessExecuteRequest request, Class<TResult> tResultClass)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request,
                ScriptsPainlessExecuteRequest.createScriptsPainlessExecuteEndpoint(getDeserializer(tResultClass)),
                this.transportOptions);
    }

    /**
     * Allows an arbitrary script to be executed and a result to be returned
     *
     * @param fn a function that initializes a builder to create the
     *           {@link ScriptsPainlessExecuteRequest}
     * 
     */

    public final <TResult> CompletableFuture<ScriptsPainlessExecuteResponse<TResult>> scriptsPainlessExecute(
            Function<ScriptsPainlessExecuteRequest.Builder, ObjectBuilder<ScriptsPainlessExecuteRequest>> fn,
            Class<TResult> tResultClass) throws IOException, OpensearchException {
        return scriptsPainlessExecute(fn.apply(new ScriptsPainlessExecuteRequest.Builder()).build(), tResultClass);
    }

    // ----- Endpoint: search

    /**
     * Returns results matching a query.
     *
     * 
     */

    public <TDocument> CompletableFuture<SearchResponse<TDocument>> search(SearchRequest request,
                                                                           Class<TDocument> tDocumentClass) throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request,
                SearchRequest.createSearchEndpoint(getDeserializer(tDocumentClass)), this.transportOptions);
    }

    /**
     * Returns results matching a query.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link SearchRequest}
     * 
     */

    public final <TDocument> CompletableFuture<SearchResponse<TDocument>> search(
            Function<SearchRequest.Builder, ObjectBuilder<SearchRequest>> fn, Class<TDocument> tDocumentClass)
            throws IOException, OpensearchException {
        return search(fn.apply(new SearchRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: search_mvt

    /**
     * Searches a vector tile for geospatial values. Returns results as a binary
     * Mapbox vector tile.
     *
     * 
     */

    public CompletableFuture<SearchMvtResponse> searchMvt(SearchMvtRequest request)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, SearchMvtRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Searches a vector tile for geospatial values. Returns results as a binary
     * Mapbox vector tile.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link SearchMvtRequest}
     * 
     */

    public final CompletableFuture<SearchMvtResponse> searchMvt(
            Function<SearchMvtRequest.Builder, ObjectBuilder<SearchMvtRequest>> fn)
            throws IOException, OpensearchException {
        return searchMvt(fn.apply(new SearchMvtRequest.Builder()).build());
    }

    // ----- Endpoint: search_shards

    /**
     * Returns information about the indices and shards that a search request would
     * be executed against.
     *
     * 
     */

    public CompletableFuture<SearchShardsResponse> searchShards(SearchShardsRequest request)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, SearchShardsRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about the indices and shards that a search request would
     * be executed against.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link SearchShardsRequest}
     * 
     */

    public final CompletableFuture<SearchShardsResponse> searchShards(
            Function<SearchShardsRequest.Builder, ObjectBuilder<SearchShardsRequest>> fn)
            throws IOException, OpensearchException {
        return searchShards(fn.apply(new SearchShardsRequest.Builder()).build());
    }

    /**
     * Returns information about the indices and shards that a search request would
     * be executed against.
     *
     * 
     */

    public CompletableFuture<SearchShardsResponse> searchShards() throws IOException, OpensearchException {
        return this.transport.performRequestAsync(new SearchShardsRequest.Builder().build(),
                SearchShardsRequest.ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: search_template

    /**
     * Allows to use the Mustache language to pre-render a search definition.
     *
     * 
     */

    public <TDocument> CompletableFuture<SearchTemplateResponse<TDocument>> searchTemplate(
            SearchTemplateRequest request, Class<TDocument> tDocumentClass) throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request,
                SearchTemplateRequest.createSearchTemplateEndpoint(getDeserializer(tDocumentClass)),
                this.transportOptions);
    }

    /**
     * Allows to use the Mustache language to pre-render a search definition.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link SearchTemplateRequest}
     * 
     */

    public final <TDocument> CompletableFuture<SearchTemplateResponse<TDocument>> searchTemplate(
            Function<SearchTemplateRequest.Builder, ObjectBuilder<SearchTemplateRequest>> fn,
            Class<TDocument> tDocumentClass) throws IOException, OpensearchException {
        return searchTemplate(fn.apply(new SearchTemplateRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: terms_enum

    /**
     * The terms enum API can be used to discover terms in the index that begin with
     * the provided string. It is designed for low-latency look-ups used in
     * auto-complete scenarios.
     *
     * 
     */

    public CompletableFuture<TermsEnumResponse> termsEnum(TermsEnumRequest request)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, TermsEnumRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * The terms enum API can be used to discover terms in the index that begin with
     * the provided string. It is designed for low-latency look-ups used in
     * auto-complete scenarios.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link TermsEnumRequest}
     * 
     */

    public final CompletableFuture<TermsEnumResponse> termsEnum(
            Function<TermsEnumRequest.Builder, ObjectBuilder<TermsEnumRequest>> fn)
            throws IOException, OpensearchException {
        return termsEnum(fn.apply(new TermsEnumRequest.Builder()).build());
    }

    // ----- Endpoint: termvectors

    /**
     * Returns information and statistics about terms in the fields of a particular
     * document.
     *
     * 
     */

    public <TDocument> CompletableFuture<TermvectorsResponse> termvectors(TermvectorsRequest<TDocument> request)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, TermvectorsRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information and statistics about terms in the fields of a particular
     * document.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link TermvectorsRequest}
     * 
     */

    public final <TDocument> CompletableFuture<TermvectorsResponse> termvectors(
            Function<TermvectorsRequest.Builder<TDocument>, ObjectBuilder<TermvectorsRequest<TDocument>>> fn)
            throws IOException, OpensearchException {
        return termvectors(fn.apply(new TermvectorsRequest.Builder<TDocument>()).build());
    }

    // ----- Endpoint: update

    /**
     * Updates a document with a script or partial document.
     *
     * 
     */

    public <TDocument, TPartialDocument> CompletableFuture<UpdateResponse<TDocument>> update(
            UpdateRequest<TDocument, TPartialDocument> request, Class<TDocument> tDocumentClass)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request,
                UpdateRequest.createUpdateEndpoint(getDeserializer(tDocumentClass)), this.transportOptions);
    }

    /**
     * Updates a document with a script or partial document.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link UpdateRequest}
     * 
     */

    public final <TDocument, TPartialDocument> CompletableFuture<UpdateResponse<TDocument>> update(
            Function<UpdateRequest.Builder<TDocument, TPartialDocument>, ObjectBuilder<UpdateRequest<TDocument, TPartialDocument>>> fn,
            Class<TDocument> tDocumentClass) throws IOException, OpensearchException {
        return update(fn.apply(new UpdateRequest.Builder<TDocument, TPartialDocument>()).build(), tDocumentClass);
    }

    // ----- Endpoint: update_by_query

    /**
     * Performs an update on every document in the index without changing the
     * source, for example to pick up a mapping change.
     *
     * 
     */

    public CompletableFuture<UpdateByQueryResponse> updateByQuery(UpdateByQueryRequest request)
            throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, UpdateByQueryRequest.ENDPOINT, this.transportOptions);
    }

    /**
     * Performs an update on every document in the index without changing the
     * source, for example to pick up a mapping change.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link UpdateByQueryRequest}
     * 
     */

    public final CompletableFuture<UpdateByQueryResponse> updateByQuery(
            Function<UpdateByQueryRequest.Builder, ObjectBuilder<UpdateByQueryRequest>> fn)
            throws IOException, OpensearchException {
        return updateByQuery(fn.apply(new UpdateByQueryRequest.Builder()).build());
    }

    // ----- Endpoint: update_by_query_rethrottle

    /**
     * Changes the number of requests per second for a particular Update By Query
     * operation.
     *
     * 
     */

    public CompletableFuture<UpdateByQueryRethrottleResponse> updateByQueryRethrottle(
            UpdateByQueryRethrottleRequest request) throws IOException, OpensearchException {
        return this.transport.performRequestAsync(request, UpdateByQueryRethrottleRequest.ENDPOINT,
                this.transportOptions);
    }

    /**
     * Changes the number of requests per second for a particular Update By Query
     * operation.
     *
     * @param fn a function that initializes a builder to create the
     *           {@link UpdateByQueryRethrottleRequest}
     * 
     */

    public final CompletableFuture<UpdateByQueryRethrottleResponse> updateByQueryRethrottle(
            Function<UpdateByQueryRethrottleRequest.Builder, ObjectBuilder<UpdateByQueryRethrottleRequest>> fn)
            throws IOException, OpensearchException {
        return updateByQueryRethrottle(fn.apply(new UpdateByQueryRethrottleRequest.Builder()).build());
    }

}
