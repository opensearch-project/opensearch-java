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

package org.opensearch.client.opensearch.snapshot;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.util.ObjectBuilder;

/**
 * Client for the snapshot namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class OpenSearchSnapshotAsyncClientBase<Self extends OpenSearchSnapshotAsyncClientBase<Self>> extends ApiClient<
    OpenSearchTransport,
    Self> {
    public OpenSearchSnapshotAsyncClientBase(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    // ----- Endpoint: snapshot.cleanup_repository

    /**
     * Removes stale data from repository.
     */
    public CompletableFuture<CleanupRepositoryResponse> cleanupRepository(CleanupRepositoryRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, CleanupRepositoryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Removes stale data from repository.
     *
     * @param fn a function that initializes a builder to create the {@link CleanupRepositoryRequest}
     */
    public final CompletableFuture<CleanupRepositoryResponse> cleanupRepository(
        Function<CleanupRepositoryRequest.Builder, ObjectBuilder<CleanupRepositoryRequest>> fn
    ) throws IOException, OpenSearchException {
        return cleanupRepository(fn.apply(new CleanupRepositoryRequest.Builder()).build());
    }

    // ----- Endpoint: snapshot.clone

    /**
     * Clones indices from one snapshot into another snapshot in the same repository.
     */
    public CompletableFuture<CloneSnapshotResponse> clone(CloneSnapshotRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, CloneSnapshotRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Clones indices from one snapshot into another snapshot in the same repository.
     *
     * @param fn a function that initializes a builder to create the {@link CloneSnapshotRequest}
     */
    public final CompletableFuture<CloneSnapshotResponse> clone(
        Function<CloneSnapshotRequest.Builder, ObjectBuilder<CloneSnapshotRequest>> fn
    ) throws IOException, OpenSearchException {
        return clone(fn.apply(new CloneSnapshotRequest.Builder()).build());
    }

    // ----- Endpoint: snapshot.verify_repository

    /**
     * Verifies a repository.
     */
    public CompletableFuture<VerifyRepositoryResponse> verifyRepository(VerifyRepositoryRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, VerifyRepositoryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Verifies a repository.
     *
     * @param fn a function that initializes a builder to create the {@link VerifyRepositoryRequest}
     */
    public final CompletableFuture<VerifyRepositoryResponse> verifyRepository(
        Function<VerifyRepositoryRequest.Builder, ObjectBuilder<VerifyRepositoryRequest>> fn
    ) throws IOException, OpenSearchException {
        return verifyRepository(fn.apply(new VerifyRepositoryRequest.Builder()).build());
    }
}
