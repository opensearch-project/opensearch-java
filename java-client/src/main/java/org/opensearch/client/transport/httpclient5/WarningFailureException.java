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

package org.opensearch.client.transport.httpclient5;

import java.io.IOException;

/**
 * This exception is used to indicate that one or more {@link Response#getWarnings()} exist
 * and is typically used when the {@link ApacheHttpClient5Transport} is set to fail by passing
 * `true` to `strictDeprecationMode`.
 */
// This class extends RuntimeException in order to deal with wrapping that is done in FutureUtils on exception.
// if the exception is not of type OpenSearchException or RuntimeException it will be wrapped in a UncategorizedExecutionException
public final class WarningFailureException extends RuntimeException {
    private final Response response;

    /**
     * Creates a {@link WarningFailureException} instance.
     *
     * @param response the response that contains warnings.
     * @throws IOException if there is a problem building the exception message.
     */
    public WarningFailureException(Response response) throws IOException {
        super(ResponseException.buildMessage(response));
        this.response = response;
    }

    /**
     * Wrap a {@linkplain WarningFailureException} with another one with the current
     * stack trace. This is used during synchronous calls so that the caller
     * ends up in the stack trace of the exception thrown.
     *
     * @param e the exception to be wrapped.
     */
    WarningFailureException(WarningFailureException e) {
        super(e.getMessage(), e);
        this.response = e.getResponse();
    }

    /**
     * Returns the {@link Response} that caused this exception to be thrown.
     */
    public Response getResponse() {
        return response;
    }
}
