/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.aws;

import java.io.IOException;
import org.apache.hc.core5.http.HttpHost;
import org.opensearch.client.opensearch.integTest.OpenSearchTransportSupport;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.aws.AwsSdk2Transport;
import org.opensearch.client.transport.aws.AwsSdk2TransportOptions;
import org.opensearch.common.settings.Settings;
import software.amazon.awssdk.http.async.SdkAsyncHttpClient;
import software.amazon.awssdk.http.crt.AwsCrtAsyncHttpClient;
import software.amazon.awssdk.regions.Region;

interface AwsSdk2AsyncTransportSupport extends OpenSearchTransportSupport {
    @Override
    default OpenSearchTransport buildTransport(Settings settings, HttpHost[] hosts) throws IOException {
        return new AwsSdk2Transport(
            getAsyncHttpClient(),
            getTestClusterHost(),
            getTestClusterServiceName(),
            getTestClusterRegion(),
            getTransportOptions().build()
        );
    }

    private String getTestClusterHost() {
        return System.getProperty("tests.awsSdk2support.domainHost");
    }

    private String getTestClusterServiceName() {
        return System.getProperty("tests.awsSdk2support.serviceName");
    }

    private Region getTestClusterRegion() {
        String region = System.getProperty("tests.awsSdk2support.domainRegion");
        return region != null ? Region.of(region) : Region.US_EAST_1;
    }

    private AwsSdk2TransportOptions.Builder getTransportOptions() {
        return AwsSdk2TransportOptions.builder();
    }

    private SdkAsyncHttpClient getAsyncHttpClient() {
        return AwsCrtAsyncHttpClient.create();
    }
}
