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

import org.reactivestreams.Subscriber;
import software.amazon.awssdk.core.async.AsyncRequestBody;
import software.amazon.awssdk.http.async.SdkHttpContentPublisher;

import javax.annotation.CheckForNull;
import java.nio.ByteBuffer;
import java.util.Optional;

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
