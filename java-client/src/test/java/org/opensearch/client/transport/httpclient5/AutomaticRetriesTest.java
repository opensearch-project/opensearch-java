/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.httpclient5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.hc.client5.http.impl.DefaultHttpRequestRetryStrategy;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.util.TimeValue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.generic.Requests;
import org.opensearch.client.opensearch.generic.Response;

/**
 * Tests that automatic retries can be enabled through
 * {@link ApacheHttpClient5TransportBuilder#setAutomaticRetriesDisabled}, and that requests are
 * not retried by default.
 */
public class AutomaticRetriesTest {
    private ServerSocket serverSocket;
    private ExecutorService serverExecutor;
    private volatile boolean serverRunning;
    private final AtomicInteger requestCount = new AtomicInteger();

    @Before
    public void startRawSocketServer() throws IOException {
        serverSocket = new ServerSocket(0);
        serverExecutor = Executors.newCachedThreadPool();
        serverRunning = true;

        serverExecutor.submit(() -> {
            while (serverRunning) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    serverExecutor.submit(() -> handleClientRequest(clientSocket));
                } catch (IOException e) {
                    if (serverRunning) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @After
    public void stopRawSocketServer() throws IOException {
        serverRunning = false;
        if (serverSocket != null && !serverSocket.isClosed()) {
            serverSocket.close();
        }
        serverExecutor.shutdownNow();
    }

    private void handleClientRequest(Socket clientSocket) {
        try (InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {
            readRequestHead(in);

            String response;
            if (requestCount.incrementAndGet() == 1) {
                response = "HTTP/1.1 503 Service Unavailable\r\n" + "Content-Length: 0\r\n" + "Connection: close\r\n" + "\r\n";
            } else {
                String body = "{\"acknowledged\":true}";
                response = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: application/json\r\n"
                    + "Content-Length: "
                    + body.length()
                    + "\r\n"
                    + "Connection: close\r\n"
                    + "\r\n"
                    + body;
            }
            out.write(response.getBytes(StandardCharsets.UTF_8));
            out.flush();
        } catch (IOException e) {
            System.err.println("Server: Error handling client connection: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Reads the request line and headers, up to the terminating blank line
    private static void readRequestHead(InputStream in) throws IOException {
        int c;
        int newLines = 0;
        while (newLines < 2 && (c = in.read()) != -1) {
            if (c == '\n') {
                newLines++;
            } else if (c != '\r') {
                newLines = 0;
            }
        }
    }

    @Test
    public void testDefaultRetryStrategyRetriesFailedRequest() throws IOException {
        OpenSearchClient client = createClient(builder().setAutomaticRetriesDisabled(false));

        Response response = client.generic().execute(Requests.builder().method("GET").endpoint("/").build());

        assertEquals(200, response.getStatus());
        assertEquals(2, requestCount.get());
    }

    @Test
    public void testCustomRetryStrategySetThroughCallback() throws IOException {
        OpenSearchClient client = createClient(
            builder().setAutomaticRetriesDisabled(false)
                .setHttpClientConfigCallback(
                    httpClientBuilder -> httpClientBuilder.setRetryStrategy(
                        new DefaultHttpRequestRetryStrategy(3, TimeValue.ofMilliseconds(50))
                    )
                )
        );

        Response response = client.generic().execute(Requests.builder().method("GET").endpoint("/").build());

        assertEquals(200, response.getStatus());
        assertEquals(2, requestCount.get());
    }

    @Test
    public void testNoRetriesByDefault() {
        OpenSearchClient client = createClient(builder());

        assertThrows(ResponseException.class, () -> client.generic().execute(Requests.builder().method("GET").endpoint("/").build()));

        assertEquals(1, requestCount.get());
    }

    private ApacheHttpClient5TransportBuilder builder() {
        return ApacheHttpClient5TransportBuilder.builder(new HttpHost("http", "localhost", serverSocket.getLocalPort()));
    }

    private static OpenSearchClient createClient(ApacheHttpClient5TransportBuilder builder) {
        return new OpenSearchClient(builder.build());
    }
}
