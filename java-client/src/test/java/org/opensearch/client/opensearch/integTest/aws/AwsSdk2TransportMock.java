/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.aws;

import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.transport.aws.AwsSdk2Transport;
import org.opensearch.client.transport.aws.AwsSdk2TransportOptions;
import org.opensearch.client.util.OpenSearchRequestBodyBuffer;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.SdkHttpFullRequest;
import software.amazon.awssdk.regions.Region;

import java.io.IOException;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

public class AwsSdk2TransportMock extends AwsSdk2Transport {

    public AwsSdk2TransportMock(
            @Nonnull SdkHttpClient httpClient,
            @Nonnull String host,
            @Nonnull String signingServiceName,
            @Nonnull Region signingRegion,
            @CheckForNull AwsSdk2TransportOptions options) {
        super(httpClient, host, signingServiceName, signingRegion, options);
    }

    @Override
    public <RequestT> OpenSearchRequestBodyBuffer prepareRequestBody(RequestT request,
            Endpoint<RequestT, ?, ?> endpoint, TransportOptions options) throws IOException {
        return super.prepareRequestBody(request, endpoint, options);
    }
    @Override
    public <RequestT> SdkHttpFullRequest prepareRequest(RequestT request, Endpoint<RequestT, ?, ?> endpoint,
            TransportOptions options, OpenSearchRequestBodyBuffer body) {
        return super.prepareRequest(request, endpoint, options, body);
    }
}
