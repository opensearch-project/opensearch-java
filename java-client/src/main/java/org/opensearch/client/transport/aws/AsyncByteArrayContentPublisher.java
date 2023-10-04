/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.aws;

import java.nio.ByteBuffer;
import java.util.Optional;
import javax.annotation.CheckForNull;
import org.reactivestreams.Subscriber;
import software.amazon.awssdk.core.async.AsyncRequestBody;
import software.amazon.awssdk.http.async.SdkHttpContentPublisher;

/**
 * An implementation of AWS {@SdkHttpContentPublisher} that transfers a pre-existing
 * byte array
 */
class AsyncByteArrayContentPublisher implements SdkHttpContentPublisher {
    private final AsyncRequestBody delegate;

    AsyncByteArrayContentPublisher(@CheckForNull byte[] data) {
        if (data == null) {
            delegate = AsyncRequestBody.empty();
        } else {
            delegate = AsyncRequestBody.fromBytes(data);
        }
    }

    @Override
    public Optional<Long> contentLength() {
        return delegate.contentLength();
    }

    @Override
    public void subscribe(Subscriber<? super ByteBuffer> s) {
        delegate.subscribe(s);
    }
}
