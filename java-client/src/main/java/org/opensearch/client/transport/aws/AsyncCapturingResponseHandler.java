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

package org.opensearch.client.transport.aws;

import org.reactivestreams.Publisher;
import software.amazon.awssdk.http.SdkHttpResponse;
import software.amazon.awssdk.http.async.SdkAsyncHttpResponseHandler;

import java.nio.ByteBuffer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

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
