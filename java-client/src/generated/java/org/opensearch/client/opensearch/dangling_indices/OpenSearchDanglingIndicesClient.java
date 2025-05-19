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

package org.opensearch.client.opensearch.dangling_indices;

import java.io.IOException;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.util.ObjectBuilder;

/**
 * Client for the dangling_indices namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenSearchDanglingIndicesClient extends ApiClient<OpenSearchTransport, OpenSearchDanglingIndicesClient> {
    public OpenSearchDanglingIndicesClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchDanglingIndicesClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchDanglingIndicesClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchDanglingIndicesClient(this.transport, transportOptions);
    }

    // ----- Endpoint: dangling_indices.delete_dangling_index

    /**
     * Deletes the specified dangling index.
     */
    public DeleteDanglingIndexResponse deleteDanglingIndex(DeleteDanglingIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteDanglingIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes the specified dangling index.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteDanglingIndexRequest}
     */
    public final DeleteDanglingIndexResponse deleteDanglingIndex(
        Function<DeleteDanglingIndexRequest.Builder, ObjectBuilder<DeleteDanglingIndexRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteDanglingIndex(fn.apply(new DeleteDanglingIndexRequest.Builder()).build());
    }

    // ----- Endpoint: dangling_indices.import_dangling_index

    /**
     * Imports the specified dangling index.
     */
    public ImportDanglingIndexResponse importDanglingIndex(ImportDanglingIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ImportDanglingIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Imports the specified dangling index.
     *
     * @param fn a function that initializes a builder to create the {@link ImportDanglingIndexRequest}
     */
    public final ImportDanglingIndexResponse importDanglingIndex(
        Function<ImportDanglingIndexRequest.Builder, ObjectBuilder<ImportDanglingIndexRequest>> fn
    ) throws IOException, OpenSearchException {
        return importDanglingIndex(fn.apply(new ImportDanglingIndexRequest.Builder()).build());
    }

    // ----- Endpoint: dangling_indices.list_dangling_indices

    /**
     * Returns all dangling indexes.
     */
    public ListDanglingIndicesResponse listDanglingIndices(ListDanglingIndicesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ListDanglingIndicesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns all dangling indexes.
     *
     * @param fn a function that initializes a builder to create the {@link ListDanglingIndicesRequest}
     */
    public final ListDanglingIndicesResponse listDanglingIndices(
        Function<ListDanglingIndicesRequest.Builder, ObjectBuilder<ListDanglingIndicesRequest>> fn
    ) throws IOException, OpenSearchException {
        return listDanglingIndices(fn.apply(new ListDanglingIndicesRequest.Builder()).build());
    }

    /**
     * Returns all dangling indexes.
     */
    public final ListDanglingIndicesResponse listDanglingIndices() throws IOException, OpenSearchException {
        return listDanglingIndices(new ListDanglingIndicesRequest.Builder().build());
    }
}
