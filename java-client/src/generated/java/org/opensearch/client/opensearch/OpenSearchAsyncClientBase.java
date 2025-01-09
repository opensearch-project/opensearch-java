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
import org.opensearch.client.opensearch.core.PutScriptRequest;
import org.opensearch.client.opensearch.core.PutScriptResponse;
import org.opensearch.client.opensearch.core.ReindexRequest;
import org.opensearch.client.opensearch.core.ReindexResponse;
import org.opensearch.client.opensearch.core.ReindexRethrottleRequest;
import org.opensearch.client.opensearch.core.ReindexRethrottleResponse;
import org.opensearch.client.opensearch.core.UpdateByQueryRequest;
import org.opensearch.client.opensearch.core.UpdateByQueryResponse;
import org.opensearch.client.opensearch.core.UpdateByQueryRethrottleRequest;
import org.opensearch.client.opensearch.core.UpdateByQueryRethrottleResponse;
import org.opensearch.client.opensearch.dangling_indices.OpenSearchDanglingIndicesAsyncClient;
import org.opensearch.client.opensearch.indices.OpenSearchIndicesAsyncClient;
import org.opensearch.client.opensearch.ingest.OpenSearchIngestAsyncClient;
import org.opensearch.client.opensearch.ml.OpenSearchMlAsyncClient;
import org.opensearch.client.opensearch.nodes.OpenSearchNodesAsyncClient;
import org.opensearch.client.opensearch.snapshot.OpenSearchSnapshotAsyncClient;
import org.opensearch.client.opensearch.tasks.OpenSearchTasksAsyncClient;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
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

    public OpenSearchIndicesAsyncClient indices() {
        return new OpenSearchIndicesAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchIngestAsyncClient ingest() {
        return new OpenSearchIngestAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchMlAsyncClient ml() {
        return new OpenSearchMlAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchNodesAsyncClient nodes() {
        return new OpenSearchNodesAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchSnapshotAsyncClient snapshot() {
        return new OpenSearchSnapshotAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchTasksAsyncClient tasks() {
        return new OpenSearchTasksAsyncClient(this.transport, this.transportOptions);
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
