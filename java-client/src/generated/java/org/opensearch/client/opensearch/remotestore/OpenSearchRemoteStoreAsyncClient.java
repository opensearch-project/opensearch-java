/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.remotestore;

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

public class OpenSearchRemoteStoreAsyncClient
        extends ApiClient<OpenSearchTransport, OpenSearchRemoteStoreAsyncClient> {
    public OpenSearchRemoteStoreAsyncClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchRemoteStoreAsyncClient(
            OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchRemoteStoreAsyncClient withTransportOptions(
            @Nullable TransportOptions transportOptions) {
        return new OpenSearchRemoteStoreAsyncClient(this.transport, transportOptions);
    }

    public CompletableFuture<PostRemoteStoreRestoreResponse> postRemoteStoreRestore(
            PostRemoteStoreRestoreRequest request) throws IOException, OpenSearchException {
        JsonEndpoint<PostRemoteStoreRestoreRequest, PostRemoteStoreRestoreResponse, ErrorResponse>
                endpoint =
                        (JsonEndpoint<
                                        PostRemoteStoreRestoreRequest,
                                        PostRemoteStoreRestoreResponse,
                                        ErrorResponse>)
                                PostRemoteStoreRestoreRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    public final CompletableFuture<PostRemoteStoreRestoreResponse> postRemoteStoreRestore(
            Function<
                            PostRemoteStoreRestoreRequest.Builder,
                            ObjectBuilder<PostRemoteStoreRestoreRequest>>
                    fn)
            throws IOException, OpenSearchException {
        return postRemoteStoreRestore(
                fn.apply(new PostRemoteStoreRestoreRequest.Builder()).build());
    }
}
