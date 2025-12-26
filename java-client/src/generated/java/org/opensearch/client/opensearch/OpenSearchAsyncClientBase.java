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

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch.cat.OpenSearchCatAsyncClient;
import org.opensearch.client.opensearch.cluster.OpenSearchClusterAsyncClient;
import org.opensearch.client.opensearch.core.ClearScrollRequest;
import org.opensearch.client.opensearch.core.ClearScrollResponse;
import org.opensearch.client.opensearch.core.CountRequest;
import org.opensearch.client.opensearch.core.CountResponse;
import org.opensearch.client.opensearch.core.CreatePitRequest;
import org.opensearch.client.opensearch.core.CreatePitResponse;
import org.opensearch.client.opensearch.core.DeleteAllPitsRequest;
import org.opensearch.client.opensearch.core.DeleteAllPitsResponse;
import org.opensearch.client.opensearch.core.DeleteByQueryRequest;
import org.opensearch.client.opensearch.core.DeleteByQueryResponse;
import org.opensearch.client.opensearch.core.DeleteByQueryRethrottleRequest;
import org.opensearch.client.opensearch.core.DeleteByQueryRethrottleResponse;
import org.opensearch.client.opensearch.core.DeletePitRequest;
import org.opensearch.client.opensearch.core.DeletePitResponse;
import org.opensearch.client.opensearch.core.DeleteRequest;
import org.opensearch.client.opensearch.core.DeleteResponse;
import org.opensearch.client.opensearch.core.DeleteScriptRequest;
import org.opensearch.client.opensearch.core.DeleteScriptResponse;
import org.opensearch.client.opensearch.core.ExistsRequest;
import org.opensearch.client.opensearch.core.ExistsSourceRequest;
import org.opensearch.client.opensearch.core.FieldCapsRequest;
import org.opensearch.client.opensearch.core.FieldCapsResponse;
import org.opensearch.client.opensearch.core.GetAllPitsRequest;
import org.opensearch.client.opensearch.core.GetAllPitsResponse;
import org.opensearch.client.opensearch.core.GetScriptContextRequest;
import org.opensearch.client.opensearch.core.GetScriptContextResponse;
import org.opensearch.client.opensearch.core.GetScriptLanguagesRequest;
import org.opensearch.client.opensearch.core.GetScriptLanguagesResponse;
import org.opensearch.client.opensearch.core.GetScriptRequest;
import org.opensearch.client.opensearch.core.GetScriptResponse;
import org.opensearch.client.opensearch.core.InfoRequest;
import org.opensearch.client.opensearch.core.InfoResponse;
import org.opensearch.client.opensearch.core.MtermvectorsRequest;
import org.opensearch.client.opensearch.core.MtermvectorsResponse;
import org.opensearch.client.opensearch.core.PingRequest;
import org.opensearch.client.opensearch.core.PutScriptRequest;
import org.opensearch.client.opensearch.core.PutScriptResponse;
import org.opensearch.client.opensearch.core.RankEvalRequest;
import org.opensearch.client.opensearch.core.RankEvalResponse;
import org.opensearch.client.opensearch.core.ReindexRequest;
import org.opensearch.client.opensearch.core.ReindexResponse;
import org.opensearch.client.opensearch.core.ReindexRethrottleRequest;
import org.opensearch.client.opensearch.core.ReindexRethrottleResponse;
import org.opensearch.client.opensearch.core.RenderSearchTemplateRequest;
import org.opensearch.client.opensearch.core.RenderSearchTemplateResponse;
import org.opensearch.client.opensearch.core.ScriptsPainlessExecuteRequest;
import org.opensearch.client.opensearch.core.ScriptsPainlessExecuteResponse;
import org.opensearch.client.opensearch.core.SearchShardsRequest;
import org.opensearch.client.opensearch.core.SearchShardsResponse;
import org.opensearch.client.opensearch.core.UpdateByQueryRequest;
import org.opensearch.client.opensearch.core.UpdateByQueryResponse;
import org.opensearch.client.opensearch.core.UpdateByQueryRethrottleRequest;
import org.opensearch.client.opensearch.core.UpdateByQueryRethrottleResponse;
import org.opensearch.client.opensearch.dangling_indices.OpenSearchDanglingIndicesAsyncClient;
import org.opensearch.client.opensearch.geospatial.OpenSearchGeospatialAsyncClient;
import org.opensearch.client.opensearch.indices.OpenSearchIndicesAsyncClient;
import org.opensearch.client.opensearch.ingest.OpenSearchIngestAsyncClient;
import org.opensearch.client.opensearch.ingestion.OpenSearchIngestionAsyncClient;
import org.opensearch.client.opensearch.ism.OpenSearchIsmAsyncClient;
import org.opensearch.client.opensearch.knn.OpenSearchKnnAsyncClient;
import org.opensearch.client.opensearch.ltr.OpenSearchLtrAsyncClient;
import org.opensearch.client.opensearch.ml.OpenSearchMlAsyncClient;
import org.opensearch.client.opensearch.nodes.OpenSearchNodesAsyncClient;
import org.opensearch.client.opensearch.search_pipeline.OpenSearchSearchPipelineAsyncClient;
import org.opensearch.client.opensearch.search_relevance.OpenSearchSearchRelevanceAsyncClient;
import org.opensearch.client.opensearch.security.OpenSearchSecurityAsyncClient;
import org.opensearch.client.opensearch.snapshot.OpenSearchSnapshotAsyncClient;
import org.opensearch.client.opensearch.tasks.OpenSearchTasksAsyncClient;
import org.opensearch.client.opensearch.ubi.OpenSearchUbiAsyncClient;
import org.opensearch.client.transport.JsonEndpoint;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.transport.endpoints.BooleanResponse;
import org.opensearch.client.transport.endpoints.EndpointWithResponseMapperAttr;
import org.opensearch.client.util.ObjectBuilder;

/**
 * Client for the namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class OpenSearchAsyncClientBase<Self extends OpenSearchAsyncClientBase<Self>> extends ApiClient<OpenSearchTransport, Self> {
    public OpenSearchAsyncClientBase(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    // ----- Child clients

    public OpenSearchCatAsyncClient cat() {
        return new OpenSearchCatAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchClusterAsyncClient cluster() {
        return new OpenSearchClusterAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchDanglingIndicesAsyncClient danglingIndices() {
        return new OpenSearchDanglingIndicesAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchGeospatialAsyncClient geospatial() {
        return new OpenSearchGeospatialAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchIndicesAsyncClient indices() {
        return new OpenSearchIndicesAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchIngestAsyncClient ingest() {
        return new OpenSearchIngestAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchIngestionAsyncClient ingestion() {
        return new OpenSearchIngestionAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchIsmAsyncClient ism() {
        return new OpenSearchIsmAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchKnnAsyncClient knn() {
        return new OpenSearchKnnAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchLtrAsyncClient ltr() {
        return new OpenSearchLtrAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchMlAsyncClient ml() {
        return new OpenSearchMlAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchNodesAsyncClient nodes() {
        return new OpenSearchNodesAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchSearchPipelineAsyncClient searchPipeline() {
        return new OpenSearchSearchPipelineAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchSearchRelevanceAsyncClient searchRelevance() {
        return new OpenSearchSearchRelevanceAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchSecurityAsyncClient security() {
        return new OpenSearchSecurityAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchSnapshotAsyncClient snapshot() {
        return new OpenSearchSnapshotAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchTasksAsyncClient tasks() {
        return new OpenSearchTasksAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchUbiAsyncClient ubi() {
        return new OpenSearchUbiAsyncClient(this.transport, this.transportOptions);
    }

    // ----- Endpoint: clear_scroll

    /**
     * Explicitly clears the search context for a scroll.
     */
    public CompletableFuture<ClearScrollResponse> clearScroll(ClearScrollRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ClearScrollRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Explicitly clears the search context for a scroll.
     *
     * @param fn a function that initializes a builder to create the {@link ClearScrollRequest}
     */
    public final CompletableFuture<ClearScrollResponse> clearScroll(
        Function<ClearScrollRequest.Builder, ObjectBuilder<ClearScrollRequest>> fn
    ) throws IOException, OpenSearchException {
        return clearScroll(fn.apply(new ClearScrollRequest.Builder()).build());
    }

    /**
     * Explicitly clears the search context for a scroll.
     */
    public final CompletableFuture<ClearScrollResponse> clearScroll() throws IOException, OpenSearchException {
        return clearScroll(new ClearScrollRequest.Builder().build());
    }

    // ----- Endpoint: count

    /**
     * Returns number of documents matching a query.
     */
    public CompletableFuture<CountResponse> count(CountRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, CountRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns number of documents matching a query.
     *
     * @param fn a function that initializes a builder to create the {@link CountRequest}
     */
    public final CompletableFuture<CountResponse> count(Function<CountRequest.Builder, ObjectBuilder<CountRequest>> fn) throws IOException,
        OpenSearchException {
        return count(fn.apply(new CountRequest.Builder()).build());
    }

    /**
     * Returns number of documents matching a query.
     */
    public final CompletableFuture<CountResponse> count() throws IOException, OpenSearchException {
        return count(new CountRequest.Builder().build());
    }

    // ----- Endpoint: create_pit

    /**
     * Creates point in time context.
     */
    public CompletableFuture<CreatePitResponse> createPit(CreatePitRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, CreatePitRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates point in time context.
     *
     * @param fn a function that initializes a builder to create the {@link CreatePitRequest}
     */
    public final CompletableFuture<CreatePitResponse> createPit(Function<CreatePitRequest.Builder, ObjectBuilder<CreatePitRequest>> fn)
        throws IOException, OpenSearchException {
        return createPit(fn.apply(new CreatePitRequest.Builder()).build());
    }

    // ----- Endpoint: delete

    /**
     * Removes a document from the index.
     */
    public CompletableFuture<DeleteResponse> delete(DeleteRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Removes a document from the index.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteRequest}
     */
    public final CompletableFuture<DeleteResponse> delete(Function<DeleteRequest.Builder, ObjectBuilder<DeleteRequest>> fn)
        throws IOException, OpenSearchException {
        return delete(fn.apply(new DeleteRequest.Builder()).build());
    }

    // ----- Endpoint: delete_all_pits

    /**
     * Deletes all active point in time searches.
     */
    public CompletableFuture<DeleteAllPitsResponse> deleteAllPits(DeleteAllPitsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteAllPitsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes all active point in time searches.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteAllPitsRequest}
     */
    public final CompletableFuture<DeleteAllPitsResponse> deleteAllPits(
        Function<DeleteAllPitsRequest.Builder, ObjectBuilder<DeleteAllPitsRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteAllPits(fn.apply(new DeleteAllPitsRequest.Builder()).build());
    }

    /**
     * Deletes all active point in time searches.
     */
    public final CompletableFuture<DeleteAllPitsResponse> deleteAllPits() throws IOException, OpenSearchException {
        return deleteAllPits(new DeleteAllPitsRequest.Builder().build());
    }

    // ----- Endpoint: delete_by_query

    /**
     * Deletes documents matching the provided query.
     */
    public CompletableFuture<DeleteByQueryResponse> deleteByQuery(DeleteByQueryRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteByQueryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes documents matching the provided query.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteByQueryRequest}
     */
    public final CompletableFuture<DeleteByQueryResponse> deleteByQuery(
        Function<DeleteByQueryRequest.Builder, ObjectBuilder<DeleteByQueryRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteByQuery(fn.apply(new DeleteByQueryRequest.Builder()).build());
    }

    // ----- Endpoint: delete_by_query_rethrottle

    /**
     * Changes the number of requests per second for a particular Delete By Query operation.
     */
    public CompletableFuture<DeleteByQueryRethrottleResponse> deleteByQueryRethrottle(DeleteByQueryRethrottleRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteByQueryRethrottleRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Changes the number of requests per second for a particular Delete By Query operation.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteByQueryRethrottleRequest}
     */
    public final CompletableFuture<DeleteByQueryRethrottleResponse> deleteByQueryRethrottle(
        Function<DeleteByQueryRethrottleRequest.Builder, ObjectBuilder<DeleteByQueryRethrottleRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteByQueryRethrottle(fn.apply(new DeleteByQueryRethrottleRequest.Builder()).build());
    }

    // ----- Endpoint: delete_pit

    /**
     * Deletes one or more point in time searches based on the IDs passed.
     */
    public CompletableFuture<DeletePitResponse> deletePit(DeletePitRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeletePitRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes one or more point in time searches based on the IDs passed.
     *
     * @param fn a function that initializes a builder to create the {@link DeletePitRequest}
     */
    public final CompletableFuture<DeletePitResponse> deletePit(Function<DeletePitRequest.Builder, ObjectBuilder<DeletePitRequest>> fn)
        throws IOException, OpenSearchException {
        return deletePit(fn.apply(new DeletePitRequest.Builder()).build());
    }

    // ----- Endpoint: delete_script

    /**
     * Deletes a script.
     */
    public CompletableFuture<DeleteScriptResponse> deleteScript(DeleteScriptRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteScriptRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a script.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteScriptRequest}
     */
    public final CompletableFuture<DeleteScriptResponse> deleteScript(
        Function<DeleteScriptRequest.Builder, ObjectBuilder<DeleteScriptRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteScript(fn.apply(new DeleteScriptRequest.Builder()).build());
    }

    // ----- Endpoint: exists

    /**
     * Returns information about whether a document exists in an index.
     */
    public CompletableFuture<BooleanResponse> exists(ExistsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ExistsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about whether a document exists in an index.
     *
     * @param fn a function that initializes a builder to create the {@link ExistsRequest}
     */
    public final CompletableFuture<BooleanResponse> exists(Function<ExistsRequest.Builder, ObjectBuilder<ExistsRequest>> fn)
        throws IOException, OpenSearchException {
        return exists(fn.apply(new ExistsRequest.Builder()).build());
    }

    // ----- Endpoint: exists_source

    /**
     * Returns information about whether a document source exists in an index.
     */
    public CompletableFuture<BooleanResponse> existsSource(ExistsSourceRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ExistsSourceRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about whether a document source exists in an index.
     *
     * @param fn a function that initializes a builder to create the {@link ExistsSourceRequest}
     */
    public final CompletableFuture<BooleanResponse> existsSource(
        Function<ExistsSourceRequest.Builder, ObjectBuilder<ExistsSourceRequest>> fn
    ) throws IOException, OpenSearchException {
        return existsSource(fn.apply(new ExistsSourceRequest.Builder()).build());
    }

    // ----- Endpoint: field_caps

    /**
     * Returns the information about the capabilities of fields among multiple indexes.
     */
    public CompletableFuture<FieldCapsResponse> fieldCaps(FieldCapsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, FieldCapsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns the information about the capabilities of fields among multiple indexes.
     *
     * @param fn a function that initializes a builder to create the {@link FieldCapsRequest}
     */
    public final CompletableFuture<FieldCapsResponse> fieldCaps(Function<FieldCapsRequest.Builder, ObjectBuilder<FieldCapsRequest>> fn)
        throws IOException, OpenSearchException {
        return fieldCaps(fn.apply(new FieldCapsRequest.Builder()).build());
    }

    /**
     * Returns the information about the capabilities of fields among multiple indexes.
     */
    public final CompletableFuture<FieldCapsResponse> fieldCaps() throws IOException, OpenSearchException {
        return fieldCaps(new FieldCapsRequest.Builder().build());
    }

    // ----- Endpoint: get_all_pits

    /**
     * Lists all active point in time searches.
     */
    public CompletableFuture<GetAllPitsResponse> getAllPits(GetAllPitsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetAllPitsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Lists all active point in time searches.
     *
     * @param fn a function that initializes a builder to create the {@link GetAllPitsRequest}
     */
    public final CompletableFuture<GetAllPitsResponse> getAllPits(Function<GetAllPitsRequest.Builder, ObjectBuilder<GetAllPitsRequest>> fn)
        throws IOException, OpenSearchException {
        return getAllPits(fn.apply(new GetAllPitsRequest.Builder()).build());
    }

    /**
     * Lists all active point in time searches.
     */
    public final CompletableFuture<GetAllPitsResponse> getAllPits() throws IOException, OpenSearchException {
        return getAllPits(new GetAllPitsRequest.Builder().build());
    }

    // ----- Endpoint: get_script

    /**
     * Returns a script.
     */
    public CompletableFuture<GetScriptResponse> getScript(GetScriptRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetScriptRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns a script.
     *
     * @param fn a function that initializes a builder to create the {@link GetScriptRequest}
     */
    public final CompletableFuture<GetScriptResponse> getScript(Function<GetScriptRequest.Builder, ObjectBuilder<GetScriptRequest>> fn)
        throws IOException, OpenSearchException {
        return getScript(fn.apply(new GetScriptRequest.Builder()).build());
    }

    // ----- Endpoint: get_script_context

    /**
     * Returns all script contexts.
     */
    public CompletableFuture<GetScriptContextResponse> getScriptContext(GetScriptContextRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetScriptContextRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns all script contexts.
     *
     * @param fn a function that initializes a builder to create the {@link GetScriptContextRequest}
     */
    public final CompletableFuture<GetScriptContextResponse> getScriptContext(
        Function<GetScriptContextRequest.Builder, ObjectBuilder<GetScriptContextRequest>> fn
    ) throws IOException, OpenSearchException {
        return getScriptContext(fn.apply(new GetScriptContextRequest.Builder()).build());
    }

    /**
     * Returns all script contexts.
     */
    public final CompletableFuture<GetScriptContextResponse> getScriptContext() throws IOException, OpenSearchException {
        return getScriptContext(new GetScriptContextRequest.Builder().build());
    }

    // ----- Endpoint: get_script_languages

    /**
     * Returns available script types, languages and contexts.
     */
    public CompletableFuture<GetScriptLanguagesResponse> getScriptLanguages(GetScriptLanguagesRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetScriptLanguagesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns available script types, languages and contexts.
     *
     * @param fn a function that initializes a builder to create the {@link GetScriptLanguagesRequest}
     */
    public final CompletableFuture<GetScriptLanguagesResponse> getScriptLanguages(
        Function<GetScriptLanguagesRequest.Builder, ObjectBuilder<GetScriptLanguagesRequest>> fn
    ) throws IOException, OpenSearchException {
        return getScriptLanguages(fn.apply(new GetScriptLanguagesRequest.Builder()).build());
    }

    /**
     * Returns available script types, languages and contexts.
     */
    public final CompletableFuture<GetScriptLanguagesResponse> getScriptLanguages() throws IOException, OpenSearchException {
        return getScriptLanguages(new GetScriptLanguagesRequest.Builder().build());
    }

    // ----- Endpoint: info

    /**
     * Returns basic information about the cluster.
     */
    public CompletableFuture<InfoResponse> info(InfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, InfoRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns basic information about the cluster.
     *
     * @param fn a function that initializes a builder to create the {@link InfoRequest}
     */
    public final CompletableFuture<InfoResponse> info(Function<InfoRequest.Builder, ObjectBuilder<InfoRequest>> fn) throws IOException,
        OpenSearchException {
        return info(fn.apply(new InfoRequest.Builder()).build());
    }

    /**
     * Returns basic information about the cluster.
     */
    public final CompletableFuture<InfoResponse> info() throws IOException, OpenSearchException {
        return info(new InfoRequest.Builder().build());
    }

    // ----- Endpoint: mtermvectors

    /**
     * Returns multiple termvectors in one request.
     */
    public CompletableFuture<MtermvectorsResponse> mtermvectors(MtermvectorsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, MtermvectorsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns multiple termvectors in one request.
     *
     * @param fn a function that initializes a builder to create the {@link MtermvectorsRequest}
     */
    public final CompletableFuture<MtermvectorsResponse> mtermvectors(
        Function<MtermvectorsRequest.Builder, ObjectBuilder<MtermvectorsRequest>> fn
    ) throws IOException, OpenSearchException {
        return mtermvectors(fn.apply(new MtermvectorsRequest.Builder()).build());
    }

    /**
     * Returns multiple termvectors in one request.
     */
    public final CompletableFuture<MtermvectorsResponse> mtermvectors() throws IOException, OpenSearchException {
        return mtermvectors(new MtermvectorsRequest.Builder().build());
    }

    // ----- Endpoint: ping

    /**
     * Returns whether the cluster is running.
     */
    public CompletableFuture<BooleanResponse> ping(PingRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PingRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns whether the cluster is running.
     *
     * @param fn a function that initializes a builder to create the {@link PingRequest}
     */
    public final CompletableFuture<BooleanResponse> ping(Function<PingRequest.Builder, ObjectBuilder<PingRequest>> fn) throws IOException,
        OpenSearchException {
        return ping(fn.apply(new PingRequest.Builder()).build());
    }

    /**
     * Returns whether the cluster is running.
     */
    public final CompletableFuture<BooleanResponse> ping() throws IOException, OpenSearchException {
        return ping(new PingRequest.Builder().build());
    }

    // ----- Endpoint: put_script

    /**
     * Creates or updates a script.
     */
    public CompletableFuture<PutScriptResponse> putScript(PutScriptRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PutScriptRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or updates a script.
     *
     * @param fn a function that initializes a builder to create the {@link PutScriptRequest}
     */
    public final CompletableFuture<PutScriptResponse> putScript(Function<PutScriptRequest.Builder, ObjectBuilder<PutScriptRequest>> fn)
        throws IOException, OpenSearchException {
        return putScript(fn.apply(new PutScriptRequest.Builder()).build());
    }

    // ----- Endpoint: rank_eval

    /**
     * Allows to evaluate the quality of ranked search results over a set of typical search queries.
     */
    public CompletableFuture<RankEvalResponse> rankEval(RankEvalRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, RankEvalRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Allows to evaluate the quality of ranked search results over a set of typical search queries.
     *
     * @param fn a function that initializes a builder to create the {@link RankEvalRequest}
     */
    public final CompletableFuture<RankEvalResponse> rankEval(Function<RankEvalRequest.Builder, ObjectBuilder<RankEvalRequest>> fn)
        throws IOException, OpenSearchException {
        return rankEval(fn.apply(new RankEvalRequest.Builder()).build());
    }

    // ----- Endpoint: reindex

    /**
     * Allows to copy documents from one index to another, optionally filtering the source documents by a query, changing the destination
     * index settings, or fetching the documents from a remote cluster.
     */
    public CompletableFuture<ReindexResponse> reindex(ReindexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ReindexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Allows to copy documents from one index to another, optionally filtering the source documents by a query, changing the destination
     * index settings, or fetching the documents from a remote cluster.
     *
     * @param fn a function that initializes a builder to create the {@link ReindexRequest}
     */
    public final CompletableFuture<ReindexResponse> reindex(Function<ReindexRequest.Builder, ObjectBuilder<ReindexRequest>> fn)
        throws IOException, OpenSearchException {
        return reindex(fn.apply(new ReindexRequest.Builder()).build());
    }

    // ----- Endpoint: reindex_rethrottle

    /**
     * Changes the number of requests per second for a particular reindex operation.
     */
    public CompletableFuture<ReindexRethrottleResponse> reindexRethrottle(ReindexRethrottleRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, ReindexRethrottleRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Changes the number of requests per second for a particular reindex operation.
     *
     * @param fn a function that initializes a builder to create the {@link ReindexRethrottleRequest}
     */
    public final CompletableFuture<ReindexRethrottleResponse> reindexRethrottle(
        Function<ReindexRethrottleRequest.Builder, ObjectBuilder<ReindexRethrottleRequest>> fn
    ) throws IOException, OpenSearchException {
        return reindexRethrottle(fn.apply(new ReindexRethrottleRequest.Builder()).build());
    }

    // ----- Endpoint: render_search_template

    /**
     * Allows to use the Mustache language to pre-render a search definition.
     */
    public CompletableFuture<RenderSearchTemplateResponse> renderSearchTemplate(RenderSearchTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, RenderSearchTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Allows to use the Mustache language to pre-render a search definition.
     *
     * @param fn a function that initializes a builder to create the {@link RenderSearchTemplateRequest}
     */
    public final CompletableFuture<RenderSearchTemplateResponse> renderSearchTemplate(
        Function<RenderSearchTemplateRequest.Builder, ObjectBuilder<RenderSearchTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return renderSearchTemplate(fn.apply(new RenderSearchTemplateRequest.Builder()).build());
    }

    /**
     * Allows to use the Mustache language to pre-render a search definition.
     */
    public final CompletableFuture<RenderSearchTemplateResponse> renderSearchTemplate() throws IOException, OpenSearchException {
        return renderSearchTemplate(new RenderSearchTemplateRequest.Builder().build());
    }

    // ----- Endpoint: scripts_painless_execute

    /**
     * Allows an arbitrary script to be executed and a result to be returned.
     */
    public <TResult> CompletableFuture<ScriptsPainlessExecuteResponse<TResult>> scriptsPainlessExecute(
        ScriptsPainlessExecuteRequest request,
        Class<TResult> tResultClass
    ) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ScriptsPainlessExecuteRequest, ScriptsPainlessExecuteResponse<TResult>, ErrorResponse> endpoint = (JsonEndpoint<
            ScriptsPainlessExecuteRequest,
            ScriptsPainlessExecuteResponse<TResult>,
            ErrorResponse>) ScriptsPainlessExecuteRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "org.opensearch.client:Deserializer:_global.scripts_painless_execute.TResult",
            getDeserializer(tResultClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Allows an arbitrary script to be executed and a result to be returned.
     *
     * @param fn a function that initializes a builder to create the {@link ScriptsPainlessExecuteRequest}
     */
    public final <TResult> CompletableFuture<ScriptsPainlessExecuteResponse<TResult>> scriptsPainlessExecute(
        Function<ScriptsPainlessExecuteRequest.Builder, ObjectBuilder<ScriptsPainlessExecuteRequest>> fn,
        Class<TResult> tResultClass
    ) throws IOException, OpenSearchException {
        return scriptsPainlessExecute(fn.apply(new ScriptsPainlessExecuteRequest.Builder()).build(), tResultClass);
    }

    // ----- Endpoint: search_shards

    /**
     * Returns information about the indexes and shards that a search request would be executed against.
     */
    public CompletableFuture<SearchShardsResponse> searchShards(SearchShardsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, SearchShardsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about the indexes and shards that a search request would be executed against.
     *
     * @param fn a function that initializes a builder to create the {@link SearchShardsRequest}
     */
    public final CompletableFuture<SearchShardsResponse> searchShards(
        Function<SearchShardsRequest.Builder, ObjectBuilder<SearchShardsRequest>> fn
    ) throws IOException, OpenSearchException {
        return searchShards(fn.apply(new SearchShardsRequest.Builder()).build());
    }

    /**
     * Returns information about the indexes and shards that a search request would be executed against.
     */
    public final CompletableFuture<SearchShardsResponse> searchShards() throws IOException, OpenSearchException {
        return searchShards(new SearchShardsRequest.Builder().build());
    }

    // ----- Endpoint: update_by_query

    /**
     * Performs an update on every document in the index without changing the source, for example to pick up a mapping change.
     */
    public CompletableFuture<UpdateByQueryResponse> updateByQuery(UpdateByQueryRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, UpdateByQueryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Performs an update on every document in the index without changing the source, for example to pick up a mapping change.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateByQueryRequest}
     */
    public final CompletableFuture<UpdateByQueryResponse> updateByQuery(
        Function<UpdateByQueryRequest.Builder, ObjectBuilder<UpdateByQueryRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateByQuery(fn.apply(new UpdateByQueryRequest.Builder()).build());
    }

    // ----- Endpoint: update_by_query_rethrottle

    /**
     * Changes the number of requests per second for a particular Update By Query operation.
     */
    public CompletableFuture<UpdateByQueryRethrottleResponse> updateByQueryRethrottle(UpdateByQueryRethrottleRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, UpdateByQueryRethrottleRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Changes the number of requests per second for a particular Update By Query operation.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateByQueryRethrottleRequest}
     */
    public final CompletableFuture<UpdateByQueryRethrottleResponse> updateByQueryRethrottle(
        Function<UpdateByQueryRethrottleRequest.Builder, ObjectBuilder<UpdateByQueryRethrottleRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateByQueryRethrottle(fn.apply(new UpdateByQueryRethrottleRequest.Builder()).build());
    }
}
