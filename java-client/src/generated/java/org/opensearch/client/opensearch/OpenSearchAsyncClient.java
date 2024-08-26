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
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch.core.InfoRequest;
import org.opensearch.client.opensearch.core.InfoResponse;
import org.opensearch.client.opensearch.dangling_indices.OpenSearchDanglingIndicesAsyncClient;
import org.opensearch.client.opensearch.ml.OpenSearchMlAsyncClient;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;

/**
 * Client for the namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenSearchAsyncClient extends OpenSearchAsyncClientBase<OpenSearchAsyncClient> {
    public OpenSearchAsyncClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchAsyncClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchAsyncClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchAsyncClient(this.transport, transportOptions);
    }

    // ----- Child clients

    public OpenSearchDanglingIndicesAsyncClient danglingIndices() {
        return new OpenSearchDanglingIndicesAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchMlAsyncClient ml() {
        return new OpenSearchMlAsyncClient(this.transport, this.transportOptions);
    }

    // ----- Endpoint: info

    /**
     * Returns basic information about the cluster.
     */
    public CompletableFuture<InfoResponse> info() throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(InfoRequest._INSTANCE, InfoRequest._ENDPOINT, this.transportOptions);
    }
}
