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

package org.opensearch.client.opensearch.ingest;

import java.io.IOException;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.transport.JsonEndpoint;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.util.ObjectBuilder;

/**
 * Client for the ingest namespace.
 */
public class OpenSearchIngestClient extends OpenSearchIngestClientBase<OpenSearchIngestClient> {

    public OpenSearchIngestClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchIngestClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchIngestClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchIngestClient(this.transport, transportOptions);
    }

    // ----- Endpoint: ingest.simulate

    /**
     * Allows to simulate a pipeline with example documents.
     *
     *
     */

    public SimulateResponse simulate(SimulateRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<SimulateRequest, SimulateResponse, ErrorResponse> endpoint = (JsonEndpoint<
            SimulateRequest,
            SimulateResponse,
            ErrorResponse>) SimulateRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Allows to simulate a pipeline with example documents.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link SimulateRequest}
     *
     */

    public final SimulateResponse simulate(Function<SimulateRequest.Builder, ObjectBuilder<SimulateRequest>> fn) throws IOException,
        OpenSearchException {
        return simulate(fn.apply(new SimulateRequest.Builder()).build());
    }

    /**
     * Allows to simulate a pipeline with example documents.
     *
     *
     */

    public SimulateResponse simulate() throws IOException, OpenSearchException {
        return this.transport.performRequest(new SimulateRequest.Builder().build(), SimulateRequest._ENDPOINT, this.transportOptions);
    }

}
