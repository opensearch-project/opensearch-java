/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

// ----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
// ----------------------------------------------------

package org.opensearch.client.opensearch.cat;

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

public class OpenSearchCatAsyncClient
        extends ApiClient<OpenSearchTransport, OpenSearchCatAsyncClient> {
    public OpenSearchCatAsyncClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchCatAsyncClient(
            OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchCatAsyncClient withTransportOptions(
            @Nullable TransportOptions transportOptions) {
        return new OpenSearchCatAsyncClient(this.transport, transportOptions);
    }

    public CompletableFuture<SegmentReplicationResponse> segmentReplication(
            SegmentReplicationRequest request) throws IOException, OpenSearchException {
        JsonEndpoint<SegmentReplicationRequest, SegmentReplicationResponse, ErrorResponse>
                endpoint =
                        (JsonEndpoint<
                                        SegmentReplicationRequest,
                                        SegmentReplicationResponse,
                                        ErrorResponse>)
                                SegmentReplicationRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    public final CompletableFuture<SegmentReplicationResponse> segmentReplication(
            Function<SegmentReplicationRequest.Builder, ObjectBuilder<SegmentReplicationRequest>>
                    fn)
            throws IOException, OpenSearchException {
        return segmentReplication(fn.apply(new SegmentReplicationRequest.Builder()).build());
    }
}
