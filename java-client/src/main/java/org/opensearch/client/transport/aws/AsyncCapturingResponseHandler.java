/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.aws;

import java.nio.ByteBuffer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Publisher;
import software.amazon.awssdk.http.SdkHttpResponse;
import software.amazon.awssdk.http.async.SdkAsyncHttpResponseHandler;

/**
 * An implementation of AWS {@link SdkAsyncHttpResponseHandler} that captures the response,
 * and the content as a byte array.
 */
final class AsyncCapturingResponseHandler implements SdkAsyncHttpResponseHandler {
    private final CompletableFuture<SdkHttpResponse> responseFuture;
    private final AsyncCapturingSubscriber bodySubscriber = new AsyncCapturingSubscriber();
    private final AtomicBoolean subscribed = new AtomicBoolean(false);

    AsyncCapturingResponseHandler() {
        responseFuture = new CompletableFuture<>();
    }

    public CompletableFuture<SdkHttpResponse> getHeaderPromise() {
        return responseFuture;
    }

    public CompletableFuture<byte[]> getBodyPromise() {
        return bodySubscriber.getPromise();
    }

    @Override
    public void onHeaders(SdkHttpResponse response) {
        responseFuture.complete(response);
    }

    @Override
    public void onStream(Publisher<ByteBuffer> publisher) {
        if (!subscribed.getAndSet(true)) {
            publisher.subscribe(bodySubscriber);
        }
    }

    @Override
    public void onError(Throwable e) {
        responseFuture.completeExceptionally(e);
    }
}
