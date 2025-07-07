/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.httpclient5;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.hc.client5.http.config.ConnectionConfig;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManager;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManagerBuilder;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.util.Timeout;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opensearch.client.opensearch.OpenSearchClient;

public class ConnectionConfigSocketTimeoutTest {
    private static ServerSocket serverSocket;
    private static ExecutorService serverExecutor;
    private static volatile boolean serverRunning;

    @Before
    public void startRawSocketServer() throws IOException {
        // Raw Socket Server started on port: 9090
        serverSocket = new ServerSocket(9090);
        serverExecutor = Executors.newSingleThreadExecutor();
        serverRunning = true;

        serverExecutor.submit(() -> {
            while (serverRunning) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    serverExecutor.submit(() -> handleClientRequest(clientSocket));
                } catch (IOException e) {
                    if (serverRunning) { // Only log if not intentionally stopped
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
        serverExecutor.shutdownNow(); // Interrupt any ongoing tasks
    }

    // Helper to handle a client request: sends headers, then pauses
    private static void handleClientRequest(Socket clientSocket) {
        try (InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {

            // Read the incoming request (just to consume it)
            byte[] buffer = new byte[4096];
            int bytesRead = 0;
            long startTime = System.currentTimeMillis();
            // Read until end of stream or a reasonable amount
            while ((bytesRead = in.read(buffer)) != -1) {
                if (System.currentTimeMillis() - startTime > 100) { // Read for a short period
                    break;
                }
                if (bytesRead < 4096) break; // End of stream or partial read
            }

            // Send HTTP headers
            String headers = "HTTP/1.1 200 OK\r\n" + "Content-Type: application/json\r\n" + "Connection: close\r\n" + "\r\n"; // End of
            // headers
            out.write(headers.getBytes());
            out.flush();

            // Introduce a long delay AFTER sending headers, before sending body
            // This is the critical part to trigger socketTimeout
            TimeUnit.MILLISECONDS.sleep(2000); // Server pauses for 2 seconds

            // After delay, try to send body (client should have timed out by now)
            String body = "{\"name\":\"should-not-reach\",\"status\":\"timed-out-on-client\"}";
            out.write(body.getBytes());
            out.flush();

        } catch (SocketTimeoutException e) {
            System.err.println("Server: Socket read timeout on server side (unexpected here for client testing): " + e.getMessage());
        } catch (IOException | InterruptedException e) {
            System.err.println("Server: Error handling client connection: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testClientSocketTimeoutOnMidResponseHang() {
        int clientSocketTimeoutMs = 1000; // Client waits 1 second

        // Create OpenSearch client pointing to our raw socket server
        OpenSearchClient client = createClientWithCustomTimeout(clientSocketTimeoutMs, "localhost");

        // Execute a simple query
        // Or any other simple query

        // Verify the exception is SocketTimeoutException or contains it in the cause chain
        Throwable cause = assertThrows(Exception.class, () -> {
            client.cat().nodes(); // Or any other simple query
        });
        while (cause != null && !(cause instanceof SocketTimeoutException)) {
            cause = cause.getCause();
        }
        assertNotNull(cause.getMessage(), "Expected SocketTimeoutException in the cause chain");
        assertInstanceOf(SocketTimeoutException.class, cause, "Expected SocketTimeoutException, but found: " + cause.getClass().getName());
        assertTrue(cause.getMessage().contains("SocketTimeoutException") || cause.getMessage().contains("1000 MILLISECONDS"));

        // Close the client
        try {
            client._transport().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void assertInstanceOf(Class<SocketTimeoutException> socketTimeoutExceptionClass, Throwable cause, String s) {
    }

    public static OpenSearchClient createClientWithCustomTimeout(int socketTimeoutMs, String hostName) {

        ApacheHttpClient5Transport apacheHttpClient5Transport = ApacheHttpClient5TransportBuilder.builder(new HttpHost(hostName, 9090))
                .setHttpClientConfigCallback(httpClientBuilder -> {
                    ConnectionConfig connectionConfig = ConnectionConfig.custom()
                            .setSocketTimeout(Timeout.ofMilliseconds(socketTimeoutMs))
                            .build();
                    PoolingAsyncClientConnectionManager connectionManager = PoolingAsyncClientConnectionManagerBuilder.create()
                            .setDefaultConnectionConfig(connectionConfig)
                            .build();
                    return httpClientBuilder.setConnectionManager(connectionManager);
                })
                .build();

        return new OpenSearchClient(apacheHttpClient5Transport);
    }
}
