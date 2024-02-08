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

// ----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
// ----------------------------------------------------

package org.opensearch.client.opensearch.nodes;

import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.JsonEndpoint;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.util.ObjectBuilder;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import javax.annotation.Nullable;

public class OpenSearchNodesAsyncClient
        extends ApiClient<OpenSearchTransport, OpenSearchNodesAsyncClient> {
    public OpenSearchNodesAsyncClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchNodesAsyncClient(
            OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchNodesAsyncClient withTransportOptions(
            @Nullable TransportOptions transportOptions) {
        return new OpenSearchNodesAsyncClient(this.transport, transportOptions);
    }

    public CompletableFuture<UsageResponse> usage(UsageRequest request)
            throws IOException, OpenSearchException {
        JsonEndpoint<UsageRequest, UsageResponse, ErrorResponse> endpoint =
                (JsonEndpoint<UsageRequest, UsageResponse, ErrorResponse>) UsageRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    public final CompletableFuture<UsageResponse> usage(
            Function<UsageRequest.Builder, ObjectBuilder<UsageRequest>> fn)
            throws IOException, OpenSearchException {
        return usage(fn.apply(new UsageRequest.Builder()).build());
    }
}
