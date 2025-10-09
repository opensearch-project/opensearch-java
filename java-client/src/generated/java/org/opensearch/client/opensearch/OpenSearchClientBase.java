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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch.cat.OpenSearchCatClient;
import org.opensearch.client.opensearch.cluster.OpenSearchClusterClient;
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
import org.opensearch.client.opensearch.dangling_indices.OpenSearchDanglingIndicesClient;
import org.opensearch.client.opensearch.geospatial.OpenSearchGeospatialClient;
import org.opensearch.client.opensearch.indices.OpenSearchIndicesClient;
import org.opensearch.client.opensearch.ingest.OpenSearchIngestClient;
import org.opensearch.client.opensearch.ingestion.OpenSearchIngestionClient;
import org.opensearch.client.opensearch.ism.OpenSearchIsmClient;
import org.opensearch.client.opensearch.knn.OpenSearchKnnClient;
import org.opensearch.client.opensearch.ltr.OpenSearchLtrClient;
import org.opensearch.client.opensearch.ml.OpenSearchMlClient;
import org.opensearch.client.opensearch.nodes.OpenSearchNodesClient;
import org.opensearch.client.opensearch.search_pipeline.OpenSearchSearchPipelineClient;
import org.opensearch.client.opensearch.search_relevance.OpenSearchSearchRelevanceClient;
import org.opensearch.client.opensearch.security.OpenSearchSecurityClient;
import org.opensearch.client.opensearch.snapshot.OpenSearchSnapshotClient;
import org.opensearch.client.opensearch.tasks.OpenSearchTasksClient;
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
public abstract class OpenSearchClientBase<Self extends OpenSearchClientBase<Self>> extends ApiClient<OpenSearchTransport, Self> {
    public OpenSearchClientBase(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    // ----- Child clients

    public OpenSearchCatClient cat() {
        return new OpenSearchCatClient(this.transport, this.transportOptions);
    }

    public OpenSearchClusterClient cluster() {
        return new OpenSearchClusterClient(this.transport, this.transportOptions);
    }

    public OpenSearchDanglingIndicesClient danglingIndices() {
        return new OpenSearchDanglingIndicesClient(this.transport, this.transportOptions);
    }

    public OpenSearchGeospatialClient geospatial() {
        return new OpenSearchGeospatialClient(this.transport, this.transportOptions);
    }

    public OpenSearchIndicesClient indices() {
        return new OpenSearchIndicesClient(this.transport, this.transportOptions);
    }

    public OpenSearchIngestClient ingest() {
        return new OpenSearchIngestClient(this.transport, this.transportOptions);
    }

    public OpenSearchIngestionClient ingestion() {
        return new OpenSearchIngestionClient(this.transport, this.transportOptions);
    }

    public OpenSearchIsmClient ism() {
        return new OpenSearchIsmClient(this.transport, this.transportOptions);
    }

    public OpenSearchKnnClient knn() {
        return new OpenSearchKnnClient(this.transport, this.transportOptions);
    }

    public OpenSearchLtrClient ltr() {
        return new OpenSearchLtrClient(this.transport, this.transportOptions);
    }

    public OpenSearchMlClient ml() {
        return new OpenSearchMlClient(this.transport, this.transportOptions);
    }

    public OpenSearchNodesClient nodes() {
        return new OpenSearchNodesClient(this.transport, this.transportOptions);
    }

    public OpenSearchSearchPipelineClient searchPipeline() {
        return new OpenSearchSearchPipelineClient(this.transport, this.transportOptions);
    }

    public OpenSearchSearchRelevanceClient searchRelevance() {
        return new OpenSearchSearchRelevanceClient(this.transport, this.transportOptions);
    }

    public OpenSearchSecurityClient security() {
        return new OpenSearchSecurityClient(this.transport, this.transportOptions);
    }

    public OpenSearchSnapshotClient snapshot() {
        return new OpenSearchSnapshotClient(this.transport, this.transportOptions);
    }

    public OpenSearchTasksClient tasks() {
        return new OpenSearchTasksClient(this.transport, this.transportOptions);
    }

    // ----- Endpoint: clear_scroll

    /**
     * Explicitly clears the search context for a scroll.
     */
    public ClearScrollResponse clearScroll(ClearScrollRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ClearScrollRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Explicitly clears the search context for a scroll.
     *
     * @param fn a function that initializes a builder to create the {@link ClearScrollRequest}
     */
    public final ClearScrollResponse clearScroll(Function<ClearScrollRequest.Builder, ObjectBuilder<ClearScrollRequest>> fn)
        throws IOException, OpenSearchException {
        return clearScroll(fn.apply(new ClearScrollRequest.Builder()).build());
    }

    /**
     * Explicitly clears the search context for a scroll.
     */
    public final ClearScrollResponse clearScroll() throws IOException, OpenSearchException {
        return clearScroll(new ClearScrollRequest.Builder().build());
    }

    // ----- Endpoint: count

    /**
     * Returns number of documents matching a query.
     */
    public CountResponse count(CountRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CountRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns number of documents matching a query.
     *
     * @param fn a function that initializes a builder to create the {@link CountRequest}
     */
    public final CountResponse count(Function<CountRequest.Builder, ObjectBuilder<CountRequest>> fn) throws IOException,
        OpenSearchException {
        return count(fn.apply(new CountRequest.Builder()).build());
    }

    /**
     * Returns number of documents matching a query.
     */
    public final CountResponse count() throws IOException, OpenSearchException {
        return count(new CountRequest.Builder().build());
    }

    // ----- Endpoint: create_pit

    /**
     * Creates point in time context.
     */
    public CreatePitResponse createPit(CreatePitRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreatePitRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates point in time context.
     *
     * @param fn a function that initializes a builder to create the {@link CreatePitRequest}
     */
    public final CreatePitResponse createPit(Function<CreatePitRequest.Builder, ObjectBuilder<CreatePitRequest>> fn) throws IOException,
        OpenSearchException {
        return createPit(fn.apply(new CreatePitRequest.Builder()).build());
    }

    // ----- Endpoint: delete

    /**
     * Removes a document from the index.
     */
    public DeleteResponse delete(DeleteRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Removes a document from the index.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteRequest}
     */
    public final DeleteResponse delete(Function<DeleteRequest.Builder, ObjectBuilder<DeleteRequest>> fn) throws IOException,
        OpenSearchException {
        return delete(fn.apply(new DeleteRequest.Builder()).build());
    }

    // ----- Endpoint: delete_all_pits

    /**
     * Deletes all active point in time searches.
     */
    public DeleteAllPitsResponse deleteAllPits(DeleteAllPitsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteAllPitsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes all active point in time searches.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteAllPitsRequest}
     */
    public final DeleteAllPitsResponse deleteAllPits(Function<DeleteAllPitsRequest.Builder, ObjectBuilder<DeleteAllPitsRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteAllPits(fn.apply(new DeleteAllPitsRequest.Builder()).build());
    }

    /**
     * Deletes all active point in time searches.
     */
    public final DeleteAllPitsResponse deleteAllPits() throws IOException, OpenSearchException {
        return deleteAllPits(new DeleteAllPitsRequest.Builder().build());
    }

    // ----- Endpoint: delete_by_query

    /**
     * Deletes documents matching the provided query.
     */
    public DeleteByQueryResponse deleteByQuery(DeleteByQueryRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteByQueryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes documents matching the provided query.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteByQueryRequest}
     */
    public final DeleteByQueryResponse deleteByQuery(Function<DeleteByQueryRequest.Builder, ObjectBuilder<DeleteByQueryRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteByQuery(fn.apply(new DeleteByQueryRequest.Builder()).build());
    }

    // ----- Endpoint: delete_by_query_rethrottle

    /**
     * Changes the number of requests per second for a particular Delete By Query operation.
     */
    public DeleteByQueryRethrottleResponse deleteByQueryRethrottle(DeleteByQueryRethrottleRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, DeleteByQueryRethrottleRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Changes the number of requests per second for a particular Delete By Query operation.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteByQueryRethrottleRequest}
     */
    public final DeleteByQueryRethrottleResponse deleteByQueryRethrottle(
        Function<DeleteByQueryRethrottleRequest.Builder, ObjectBuilder<DeleteByQueryRethrottleRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteByQueryRethrottle(fn.apply(new DeleteByQueryRethrottleRequest.Builder()).build());
    }

    // ----- Endpoint: delete_pit

    /**
     * Deletes one or more point in time searches based on the IDs passed.
     */
    public DeletePitResponse deletePit(DeletePitRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeletePitRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes one or more point in time searches based on the IDs passed.
     *
     * @param fn a function that initializes a builder to create the {@link DeletePitRequest}
     */
    public final DeletePitResponse deletePit(Function<DeletePitRequest.Builder, ObjectBuilder<DeletePitRequest>> fn) throws IOException,
        OpenSearchException {
        return deletePit(fn.apply(new DeletePitRequest.Builder()).build());
    }

    // ----- Endpoint: delete_script

    /**
     * Deletes a script.
     */
    public DeleteScriptResponse deleteScript(DeleteScriptRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteScriptRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a script.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteScriptRequest}
     */
    public final DeleteScriptResponse deleteScript(Function<DeleteScriptRequest.Builder, ObjectBuilder<DeleteScriptRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteScript(fn.apply(new DeleteScriptRequest.Builder()).build());
    }

    // ----- Endpoint: exists

    /**
     * Returns information about whether a document exists in an index.
     */
    public BooleanResponse exists(ExistsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ExistsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about whether a document exists in an index.
     *
     * @param fn a function that initializes a builder to create the {@link ExistsRequest}
     */
    public final BooleanResponse exists(Function<ExistsRequest.Builder, ObjectBuilder<ExistsRequest>> fn) throws IOException,
        OpenSearchException {
        return exists(fn.apply(new ExistsRequest.Builder()).build());
    }

    // ----- Endpoint: exists_source

    /**
     * Returns information about whether a document source exists in an index.
     */
    public BooleanResponse existsSource(ExistsSourceRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ExistsSourceRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about whether a document source exists in an index.
     *
     * @param fn a function that initializes a builder to create the {@link ExistsSourceRequest}
     */
    public final BooleanResponse existsSource(Function<ExistsSourceRequest.Builder, ObjectBuilder<ExistsSourceRequest>> fn)
        throws IOException, OpenSearchException {
        return existsSource(fn.apply(new ExistsSourceRequest.Builder()).build());
    }

    // ----- Endpoint: field_caps

    /**
     * Returns the information about the capabilities of fields among multiple indexes.
     */
    public FieldCapsResponse fieldCaps(FieldCapsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, FieldCapsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns the information about the capabilities of fields among multiple indexes.
     *
     * @param fn a function that initializes a builder to create the {@link FieldCapsRequest}
     */
    public final FieldCapsResponse fieldCaps(Function<FieldCapsRequest.Builder, ObjectBuilder<FieldCapsRequest>> fn) throws IOException,
        OpenSearchException {
        return fieldCaps(fn.apply(new FieldCapsRequest.Builder()).build());
    }

    /**
     * Returns the information about the capabilities of fields among multiple indexes.
     */
    public final FieldCapsResponse fieldCaps() throws IOException, OpenSearchException {
        return fieldCaps(new FieldCapsRequest.Builder().build());
    }

    // ----- Endpoint: get_all_pits

    /**
     * Lists all active point in time searches.
     */
    public GetAllPitsResponse getAllPits(GetAllPitsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetAllPitsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Lists all active point in time searches.
     *
     * @param fn a function that initializes a builder to create the {@link GetAllPitsRequest}
     */
    public final GetAllPitsResponse getAllPits(Function<GetAllPitsRequest.Builder, ObjectBuilder<GetAllPitsRequest>> fn) throws IOException,
        OpenSearchException {
        return getAllPits(fn.apply(new GetAllPitsRequest.Builder()).build());
    }

    /**
     * Lists all active point in time searches.
     */
    public final GetAllPitsResponse getAllPits() throws IOException, OpenSearchException {
        return getAllPits(new GetAllPitsRequest.Builder().build());
    }

    // ----- Endpoint: get_script

    /**
     * Returns a script.
     */
    public GetScriptResponse getScript(GetScriptRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetScriptRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns a script.
     *
     * @param fn a function that initializes a builder to create the {@link GetScriptRequest}
     */
    public final GetScriptResponse getScript(Function<GetScriptRequest.Builder, ObjectBuilder<GetScriptRequest>> fn) throws IOException,
        OpenSearchException {
        return getScript(fn.apply(new GetScriptRequest.Builder()).build());
    }

    // ----- Endpoint: get_script_context

    /**
     * Returns all script contexts.
     */
    public GetScriptContextResponse getScriptContext(GetScriptContextRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetScriptContextRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns all script contexts.
     *
     * @param fn a function that initializes a builder to create the {@link GetScriptContextRequest}
     */
    public final GetScriptContextResponse getScriptContext(
        Function<GetScriptContextRequest.Builder, ObjectBuilder<GetScriptContextRequest>> fn
    ) throws IOException, OpenSearchException {
        return getScriptContext(fn.apply(new GetScriptContextRequest.Builder()).build());
    }

    /**
     * Returns all script contexts.
     */
    public final GetScriptContextResponse getScriptContext() throws IOException, OpenSearchException {
        return getScriptContext(new GetScriptContextRequest.Builder().build());
    }

    // ----- Endpoint: get_script_languages

    /**
     * Returns available script types, languages and contexts.
     */
    public GetScriptLanguagesResponse getScriptLanguages(GetScriptLanguagesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetScriptLanguagesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns available script types, languages and contexts.
     *
     * @param fn a function that initializes a builder to create the {@link GetScriptLanguagesRequest}
     */
    public final GetScriptLanguagesResponse getScriptLanguages(
        Function<GetScriptLanguagesRequest.Builder, ObjectBuilder<GetScriptLanguagesRequest>> fn
    ) throws IOException, OpenSearchException {
        return getScriptLanguages(fn.apply(new GetScriptLanguagesRequest.Builder()).build());
    }

    /**
     * Returns available script types, languages and contexts.
     */
    public final GetScriptLanguagesResponse getScriptLanguages() throws IOException, OpenSearchException {
        return getScriptLanguages(new GetScriptLanguagesRequest.Builder().build());
    }

    // ----- Endpoint: info

    /**
     * Returns basic information about the cluster.
     */
    public InfoResponse info(InfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, InfoRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns basic information about the cluster.
     *
     * @param fn a function that initializes a builder to create the {@link InfoRequest}
     */
    public final InfoResponse info(Function<InfoRequest.Builder, ObjectBuilder<InfoRequest>> fn) throws IOException, OpenSearchException {
        return info(fn.apply(new InfoRequest.Builder()).build());
    }

    /**
     * Returns basic information about the cluster.
     */
    public final InfoResponse info() throws IOException, OpenSearchException {
        return info(new InfoRequest.Builder().build());
    }

    // ----- Endpoint: mtermvectors

    /**
     * Returns multiple termvectors in one request.
     */
    public MtermvectorsResponse mtermvectors(MtermvectorsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, MtermvectorsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns multiple termvectors in one request.
     *
     * @param fn a function that initializes a builder to create the {@link MtermvectorsRequest}
     */
    public final MtermvectorsResponse mtermvectors(Function<MtermvectorsRequest.Builder, ObjectBuilder<MtermvectorsRequest>> fn)
        throws IOException, OpenSearchException {
        return mtermvectors(fn.apply(new MtermvectorsRequest.Builder()).build());
    }

    /**
     * Returns multiple termvectors in one request.
     */
    public final MtermvectorsResponse mtermvectors() throws IOException, OpenSearchException {
        return mtermvectors(new MtermvectorsRequest.Builder().build());
    }

    // ----- Endpoint: ping

    /**
     * Returns whether the cluster is running.
     */
    public BooleanResponse ping(PingRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PingRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns whether the cluster is running.
     *
     * @param fn a function that initializes a builder to create the {@link PingRequest}
     */
    public final BooleanResponse ping(Function<PingRequest.Builder, ObjectBuilder<PingRequest>> fn) throws IOException,
        OpenSearchException {
        return ping(fn.apply(new PingRequest.Builder()).build());
    }

    /**
     * Returns whether the cluster is running.
     */
    public final BooleanResponse ping() throws IOException, OpenSearchException {
        return ping(new PingRequest.Builder().build());
    }

    // ----- Endpoint: put_script

    /**
     * Creates or updates a script.
     */
    public PutScriptResponse putScript(PutScriptRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PutScriptRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or updates a script.
     *
     * @param fn a function that initializes a builder to create the {@link PutScriptRequest}
     */
    public final PutScriptResponse putScript(Function<PutScriptRequest.Builder, ObjectBuilder<PutScriptRequest>> fn) throws IOException,
        OpenSearchException {
        return putScript(fn.apply(new PutScriptRequest.Builder()).build());
    }

    // ----- Endpoint: rank_eval

    /**
     * Allows to evaluate the quality of ranked search results over a set of typical search queries.
     */
    public RankEvalResponse rankEval(RankEvalRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, RankEvalRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Allows to evaluate the quality of ranked search results over a set of typical search queries.
     *
     * @param fn a function that initializes a builder to create the {@link RankEvalRequest}
     */
    public final RankEvalResponse rankEval(Function<RankEvalRequest.Builder, ObjectBuilder<RankEvalRequest>> fn) throws IOException,
        OpenSearchException {
        return rankEval(fn.apply(new RankEvalRequest.Builder()).build());
    }

    // ----- Endpoint: reindex

    /**
     * Allows to copy documents from one index to another, optionally filtering the source documents by a query, changing the destination
     * index settings, or fetching the documents from a remote cluster.
     */
    public ReindexResponse reindex(ReindexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ReindexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Allows to copy documents from one index to another, optionally filtering the source documents by a query, changing the destination
     * index settings, or fetching the documents from a remote cluster.
     *
     * @param fn a function that initializes a builder to create the {@link ReindexRequest}
     */
    public final ReindexResponse reindex(Function<ReindexRequest.Builder, ObjectBuilder<ReindexRequest>> fn) throws IOException,
        OpenSearchException {
        return reindex(fn.apply(new ReindexRequest.Builder()).build());
    }

    // ----- Endpoint: reindex_rethrottle

    /**
     * Changes the number of requests per second for a particular reindex operation.
     */
    public ReindexRethrottleResponse reindexRethrottle(ReindexRethrottleRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ReindexRethrottleRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Changes the number of requests per second for a particular reindex operation.
     *
     * @param fn a function that initializes a builder to create the {@link ReindexRethrottleRequest}
     */
    public final ReindexRethrottleResponse reindexRethrottle(
        Function<ReindexRethrottleRequest.Builder, ObjectBuilder<ReindexRethrottleRequest>> fn
    ) throws IOException, OpenSearchException {
        return reindexRethrottle(fn.apply(new ReindexRethrottleRequest.Builder()).build());
    }

    // ----- Endpoint: render_search_template

    /**
     * Allows to use the Mustache language to pre-render a search definition.
     */
    public RenderSearchTemplateResponse renderSearchTemplate(RenderSearchTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, RenderSearchTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Allows to use the Mustache language to pre-render a search definition.
     *
     * @param fn a function that initializes a builder to create the {@link RenderSearchTemplateRequest}
     */
    public final RenderSearchTemplateResponse renderSearchTemplate(
        Function<RenderSearchTemplateRequest.Builder, ObjectBuilder<RenderSearchTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return renderSearchTemplate(fn.apply(new RenderSearchTemplateRequest.Builder()).build());
    }

    /**
     * Allows to use the Mustache language to pre-render a search definition.
     */
    public final RenderSearchTemplateResponse renderSearchTemplate() throws IOException, OpenSearchException {
        return renderSearchTemplate(new RenderSearchTemplateRequest.Builder().build());
    }

    // ----- Endpoint: scripts_painless_execute

    /**
     * Allows an arbitrary script to be executed and a result to be returned.
     */
    public <TResult> ScriptsPainlessExecuteResponse<TResult> scriptsPainlessExecute(
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

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Allows an arbitrary script to be executed and a result to be returned.
     *
     * @param fn a function that initializes a builder to create the {@link ScriptsPainlessExecuteRequest}
     */
    public final <TResult> ScriptsPainlessExecuteResponse<TResult> scriptsPainlessExecute(
        Function<ScriptsPainlessExecuteRequest.Builder, ObjectBuilder<ScriptsPainlessExecuteRequest>> fn,
        Class<TResult> tResultClass
    ) throws IOException, OpenSearchException {
        return scriptsPainlessExecute(fn.apply(new ScriptsPainlessExecuteRequest.Builder()).build(), tResultClass);
    }

    // ----- Endpoint: search_shards

    /**
     * Returns information about the indexes and shards that a search request would be executed against.
     */
    public SearchShardsResponse searchShards(SearchShardsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, SearchShardsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about the indexes and shards that a search request would be executed against.
     *
     * @param fn a function that initializes a builder to create the {@link SearchShardsRequest}
     */
    public final SearchShardsResponse searchShards(Function<SearchShardsRequest.Builder, ObjectBuilder<SearchShardsRequest>> fn)
        throws IOException, OpenSearchException {
        return searchShards(fn.apply(new SearchShardsRequest.Builder()).build());
    }

    /**
     * Returns information about the indexes and shards that a search request would be executed against.
     */
    public final SearchShardsResponse searchShards() throws IOException, OpenSearchException {
        return searchShards(new SearchShardsRequest.Builder().build());
    }

    // ----- Endpoint: update_by_query

    /**
     * Performs an update on every document in the index without changing the source, for example to pick up a mapping change.
     */
    public UpdateByQueryResponse updateByQuery(UpdateByQueryRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, UpdateByQueryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Performs an update on every document in the index without changing the source, for example to pick up a mapping change.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateByQueryRequest}
     */
    public final UpdateByQueryResponse updateByQuery(Function<UpdateByQueryRequest.Builder, ObjectBuilder<UpdateByQueryRequest>> fn)
        throws IOException, OpenSearchException {
        return updateByQuery(fn.apply(new UpdateByQueryRequest.Builder()).build());
    }

    // ----- Endpoint: update_by_query_rethrottle

    /**
     * Changes the number of requests per second for a particular Update By Query operation.
     */
    public UpdateByQueryRethrottleResponse updateByQueryRethrottle(UpdateByQueryRethrottleRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, UpdateByQueryRethrottleRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Changes the number of requests per second for a particular Update By Query operation.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateByQueryRethrottleRequest}
     */
    public final UpdateByQueryRethrottleResponse updateByQueryRethrottle(
        Function<UpdateByQueryRethrottleRequest.Builder, ObjectBuilder<UpdateByQueryRethrottleRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateByQueryRethrottle(fn.apply(new UpdateByQueryRethrottleRequest.Builder()).build());
    }
}
