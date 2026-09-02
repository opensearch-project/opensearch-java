/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.opensearch.client.transport.sniffer;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpHost;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5Transport;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5TransportBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Example demonstrating how to use the OpenSearch sniffer implementation.
 */
public class SnifferExample {

    public static void main(String[] args) throws IOException {
        // Example 1: Basic sniffer setup
        basicSnifferExample();

        // Example 2: Custom configuration
        customConfigurationExample();

        // Example 3: Integration with OpenSearch client
        clientIntegrationExample();
    }

    /**
     * Basic example showing minimal sniffer setup.
     */
    private static void basicSnifferExample() throws IOException {
        // Create HTTP client
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // Define initial hosts
        List<HttpHost> hosts = Arrays.asList(
            new HttpHost("localhost", 9200),
            new HttpHost("localhost", 9201)
        );

        // Create sniffer with callback
        Sniffer sniffer = new SnifferBuilder(httpClient, nodes -> {
            System.out.println("Discovered " + nodes.size() + " nodes:");
            for (Node node : nodes) {
                System.out.println("  " + node);
            }
        })
        .setHosts(hosts)
        .build();

        // Start sniffing
        sniffer.start();

        // Let it run for a while
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Clean up
        sniffer.close();
        httpClient.close();
    }

    /**
     * Example with custom configuration options.
     */
    private static void customConfigurationExample() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        List<HttpHost> hosts = Arrays.asList(
            new HttpHost("https", "localhost", 9200),
            new HttpHost("https", "localhost", 9201)
        );

        Sniffer sniffer = new SnifferBuilder(httpClient, nodes -> {
            System.out.println("Updated node list with " + nodes.size() + " nodes");
        })
        .setHosts(hosts)
        .setScheme("https")
        .setSniffIntervalMillis(TimeUnit.MINUTES.toMillis(2)) // Sniff every 2 minutes
        .setSniffAfterFailureDelayMillis(TimeUnit.SECONDS.toMillis(30)) // Retry after 30 seconds on failure
        .build();

        sniffer.start();

        // Simulate a failure and trigger immediate sniffing
        sniffer.sniffOnFailure();

        sniffer.close();
        httpClient.close();
    }

    /**
     * Example showing integration with OpenSearch client.
     * Note: This is a simplified example - real integration would require
     * extending the transport to support dynamic node updates.
     */
    private static void clientIntegrationExample() throws IOException {
        // Create the transport using the static builder factory method
        ApacheHttpClient5TransportBuilder transportBuilder = ApacheHttpClient5TransportBuilder.builder(
            new HttpHost("localhost", 9200),
            new HttpHost("localhost", 9201)
        );

        ApacheHttpClient5Transport transport = transportBuilder.build();

        // Create sniffer
        CloseableHttpClient httpClient = HttpClients.createDefault();
        Sniffer sniffer = new SnifferBuilder(httpClient, nodes -> {
            System.out.println("Cluster topology changed - " + nodes.size() + " nodes available");
            // Here you could update the transport's node list
            // This would require extending the transport to support dynamic node updates
        })
        .setHosts(Arrays.asList(new HttpHost("localhost", 9200)))
        .build();

        // Create OpenSearch client
        OpenSearchClient client = new OpenSearchClient(transport);

        // Start node discovery
        sniffer.start();

        try {
            // Use the client for operations
            // Note: Using explicit type instead of 'var' for Java 8 compatibility
            org.opensearch.client.opensearch.core.InfoResponse info = client.info();
            System.out.println("Connected to: " + info.version().number());

            // The sniffer will automatically discover new nodes in the background

        } finally {
            // Clean up
            sniffer.close();
            client._transport().close();
            httpClient.close();
        }
    }
}
