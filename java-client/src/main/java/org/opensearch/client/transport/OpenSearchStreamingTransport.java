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

package org.opensearch.client.transport;

import java.io.IOException;

import javax.annotation.Nullable;

import org.reactivestreams.Publisher;

/**
 * A transport layer that implements OpenSearch streaming specificities.
 *
 */
public interface OpenSearchStreamingTransport extends OpenSearchTransport {
    /**
     * Uses streaming request / response conversation
     * @param <RequestT> streaming request type
     * @param <ResponseT> streaming response type
     * @param <ErrorT> error type
     * @param request streaming request
     * @param endpoint streaming endpoint
     * @param options transport options
     * @return streaming response
     * @throws IOException
     */
    <RequestT extends Publisher<?>, ResponseT extends Publisher<?>, ErrorT> ResponseT stream(
        RequestT request,
        StreamingEndpoint<RequestT, ResponseT, ErrorT> endpoint,
        @Nullable TransportOptions options
    ) throws IOException;
}
