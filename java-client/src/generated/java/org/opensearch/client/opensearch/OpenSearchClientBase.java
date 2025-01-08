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
import org.opensearch.client.opensearch.core.DeletePitRequest;
import org.opensearch.client.opensearch.core.DeletePitResponse;
import org.opensearch.client.opensearch.core.DeleteRequest;
import org.opensearch.client.opensearch.core.DeleteResponse;
import org.opensearch.client.opensearch.core.InfoRequest;
import org.opensearch.client.opensearch.core.InfoResponse;
import org.opensearch.client.opensearch.dangling_indices.OpenSearchDanglingIndicesClient;
import org.opensearch.client.opensearch.indices.OpenSearchIndicesClient;
import org.opensearch.client.opensearch.ingest.OpenSearchIngestClient;
import org.opensearch.client.opensearch.ml.OpenSearchMlClient;
import org.opensearch.client.opensearch.nodes.OpenSearchNodesClient;
import org.opensearch.client.opensearch.snapshot.OpenSearchSnapshotClient;
import org.opensearch.client.opensearch.tasks.OpenSearchTasksClient;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
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

    public OpenSearchIndicesClient indices() {
        return new OpenSearchIndicesClient(this.transport, this.transportOptions);
    }

    public OpenSearchIngestClient ingest() {
        return new OpenSearchIngestClient(this.transport, this.transportOptions);
    }

    public OpenSearchMlClient ml() {
        return new OpenSearchMlClient(this.transport, this.transportOptions);
    }

    public OpenSearchNodesClient nodes() {
        return new OpenSearchNodesClient(this.transport, this.transportOptions);
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
}
