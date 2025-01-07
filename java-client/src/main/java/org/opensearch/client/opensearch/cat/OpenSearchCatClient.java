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

package org.opensearch.client.opensearch.cat;

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
 * Client for the cat namespace.
 */
public class OpenSearchCatClient extends OpenSearchCatClientBase<OpenSearchCatClient> {

    public OpenSearchCatClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchCatClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchCatClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchCatClient(this.transport, transportOptions);
    }

    // ----- Endpoint: cat.help

    /**
     * Returns help for the Cat APIs.
     *
     *
     */
    public HelpResponse help() throws IOException, OpenSearchException {
        return this.transport.performRequest(HelpRequest._INSTANCE, HelpRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cat.templates

    /**
     * Returns information about existing templates.
     *
     *
     */

    public TemplatesResponse templates(TemplatesRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<TemplatesRequest, TemplatesResponse, ErrorResponse> endpoint = (JsonEndpoint<
            TemplatesRequest,
            TemplatesResponse,
            ErrorResponse>) TemplatesRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Returns information about existing templates.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link TemplatesRequest}
     *
     */

    public final TemplatesResponse templates(Function<TemplatesRequest.Builder, ObjectBuilder<TemplatesRequest>> fn) throws IOException,
        OpenSearchException {
        return templates(fn.apply(new TemplatesRequest.Builder()).build());
    }

    /**
     * Returns information about existing templates.
     *
     *
     */

    public TemplatesResponse templates() throws IOException, OpenSearchException {
        return this.transport.performRequest(new TemplatesRequest.Builder().build(), TemplatesRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: cat.thread_pool

    /**
     * Returns cluster-wide thread pool statistics per node. By default the active,
     * queue and rejected statistics are returned for all thread pools.
     *
     *
     */

    public ThreadPoolResponse threadPool(ThreadPoolRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ThreadPoolRequest, ThreadPoolResponse, ErrorResponse> endpoint = (JsonEndpoint<
            ThreadPoolRequest,
            ThreadPoolResponse,
            ErrorResponse>) ThreadPoolRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Returns cluster-wide thread pool statistics per node. By default the active,
     * queue and rejected statistics are returned for all thread pools.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link ThreadPoolRequest}
     *
     */

    public final ThreadPoolResponse threadPool(Function<ThreadPoolRequest.Builder, ObjectBuilder<ThreadPoolRequest>> fn) throws IOException,
        OpenSearchException {
        return threadPool(fn.apply(new ThreadPoolRequest.Builder()).build());
    }

    /**
     * Returns cluster-wide thread pool statistics per node. By default the active,
     * queue and rejected statistics are returned for all thread pools.
     *
     *
     */

    public ThreadPoolResponse threadPool() throws IOException, OpenSearchException {
        return this.transport.performRequest(new ThreadPoolRequest.Builder().build(), ThreadPoolRequest._ENDPOINT, this.transportOptions);
    }

}
