/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport;

import java.nio.ByteBuffer;
import java.util.function.Function;

import org.opensearch.client.json.JsonpDeserializer;
import org.reactivestreams.Publisher;

/**
 * An endpoint with a streamable JSON response body.
 */
public interface StreamingEndpoint<RequestT extends Publisher<?>, ResponseT extends Publisher<?>, ErrorT>
    extends
        Endpoint<RequestT, ResponseT, ErrorT> {

    /**
     * The entity parser for the response body element
     */
    JsonpDeserializer<?> elementDeserializer();

    /**
     * Constructs the {@link ResponseT} instance
     * @param elements elements stream
     * @param elementDeserializer element deserializer
     * @return the {@link ResponseT} instance
     */
    ResponseT responseDeserializer(final Publisher<ByteBuffer> elements, Function<ByteBuffer, ?> elementDeserializer);
}
