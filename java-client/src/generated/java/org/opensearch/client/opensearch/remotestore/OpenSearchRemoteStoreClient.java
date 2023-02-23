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
import java.util.function.Function;
import javax.annotation.Nullable;

public class OpenSearchRemoteStoreClient
        extends ApiClient<OpenSearchTransport, OpenSearchRemoteStoreClient> {
    public OpenSearchRemoteStoreClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchRemoteStoreClient(
            OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchRemoteStoreClient withTransportOptions(
            @Nullable TransportOptions transportOptions) {
        return new OpenSearchRemoteStoreClient(this.transport, transportOptions);
    }

    public RestoreResponse restore(RestoreRequest request) throws IOException, OpenSearchException {
        JsonEndpoint<RestoreRequest, RestoreResponse, ErrorResponse> endpoint =
                (JsonEndpoint<RestoreRequest, RestoreResponse, ErrorResponse>)
                        RestoreRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    public final RestoreResponse restore(
            Function<RestoreRequest.Builder, ObjectBuilder<RestoreRequest>> fn)
            throws IOException, OpenSearchException {
        return restore(fn.apply(new RestoreRequest.Builder()).build());
    }
}
