/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.aws;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.http.apache5.Apache5HttpClient;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.utils.SdkAutoCloseable;

public class AwsSdk2TransportApacheDetectionTests {

    @Test
    public void nullReturnsFalse() {
        assertFalse(AwsSdk2Transport.isAwsSdkApacheHttpClient(null));
    }

    @Test
    public void urlConnectionReturnsFalse() {
        try (SdkHttpClient client = UrlConnectionHttpClient.builder().build()) {
            assertFalse(AwsSdk2Transport.isAwsSdkApacheHttpClient(client));
        }
    }

    @Test
    public void apacheV4ReturnsTrue() {
        try (SdkHttpClient client = ApacheHttpClient.builder().build()) {
            assertTrue(AwsSdk2Transport.isAwsSdkApacheHttpClient(client));
        }
    }

    @Test
    public void apacheV5ReturnsTrue() {
        try (SdkHttpClient client = Apache5HttpClient.builder().build()) {
            assertTrue(AwsSdk2Transport.isAwsSdkApacheHttpClient(client));
        }
    }

    @Test
    public void nonHttpClientWithMatchingNameReturnsFalse() {
        SdkAutoCloseable notAnHttpClient = () -> {};
        assertFalse(AwsSdk2Transport.isAwsSdkApacheHttpClient(notAnHttpClient));
    }
}
