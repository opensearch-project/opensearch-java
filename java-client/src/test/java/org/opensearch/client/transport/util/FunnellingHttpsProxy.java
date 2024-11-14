/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.util;

import static org.apache.hc.core5.http.HttpStatus.SC_METHOD_NOT_ALLOWED;
import static org.apache.hc.core5.http.HttpStatus.SC_OK;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import org.apache.hc.core5.http.impl.EnglishReasonPhraseCatalog;

public class FunnellingHttpsProxy implements Closeable {
    private static final int SO_TIMEOUT = 10000;

    @Nonnull
    private final ServerSocket serverSocket;
    @Nonnull
    private final InetSocketAddress boundAddress;
    private final int redirectToPort;
    @Nonnull
    private final List<Thread> connectionHandlers;
    @Nonnull
    private final List<Socket> sockets;
    private final Thread acceptThread;
    private volatile boolean running;

    public FunnellingHttpsProxy(int redirectToPort) throws Exception {
        serverSocket = new ServerSocket(0);
        boundAddress = (InetSocketAddress) serverSocket.getLocalSocketAddress();
        this.redirectToPort = redirectToPort;
        connectionHandlers = new ArrayList<>();
        sockets = new ArrayList<>();
        running = true;
        acceptThread = new Thread(this::acceptConnections);
        acceptThread.start();
    }

    public int getPort() {
        return boundAddress.getPort();
    }

    @Override
    public void close() {
        if (!running) {
            return;
        }
        running = false;
        closeQuietly(serverSocket);
        try {
            acceptThread.join();
        } catch (InterruptedException ignored) {}
        for (Socket socket : sockets) {
            closeQuietly(socket);
        }
        for (Thread handler : connectionHandlers) {
            try {
                handler.join();
            } catch (InterruptedException ignored) {}
        }
    }

    private void acceptConnections() {
        while (running) {
            try {
                Socket socket = serverSocket.accept();
                sockets.add(socket);
                socket.setSoTimeout(SO_TIMEOUT);
                Thread handler = new Thread(handleConnection(socket));
                connectionHandlers.add(handler);
                handler.start();
            } catch (Exception ignored) {}
        }
    }

    private Runnable handleConnection(Socket clientSocket) {
        return () -> {
            InputStream clientInput = null;
            OutputStream clientOutput = null;
            Socket serverSocket = null;
            InputStream serverInput = null;
            OutputStream serverOutput = null;

            try {
                clientInput = clientSocket.getInputStream();
                clientOutput = clientSocket.getOutputStream();

                String httpRequest = readHttpMessage(clientInput);

                if (!httpRequest.startsWith("CONNECT ")) {
                    writeHttpStatus(clientOutput, SC_METHOD_NOT_ALLOWED);
                    return;
                }

                serverSocket = new Socket("localhost", redirectToPort);
                serverSocket.setSoTimeout(SO_TIMEOUT);
                serverInput = serverSocket.getInputStream();
                serverOutput = serverSocket.getOutputStream();

                writeHttpStatus(clientOutput, SC_OK);

                Thread serverToClient = new Thread(pipeline(serverInput, clientOutput));
                serverToClient.start();

                pipeline(clientInput, serverOutput).run();

                serverToClient.join();
            } catch (IOException | InterruptedException ignored) {} finally {
                closeQuietly(clientInput, clientOutput, clientSocket, serverInput, serverOutput, serverSocket);
            }
        };
    }

    private Runnable pipeline(InputStream input, OutputStream output) {
        return () -> {
            byte[] buffer = new byte[4096];
            try {
                int n;
                while (running && -1 != (n = input.read(buffer))) {
                    output.write(buffer, 0, n);
                    if (input.available() < 1) {
                        output.flush();
                    }
                }
            } catch (IOException ignored) {}
        };
    }

    private static String readHttpMessage(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        StringBuilder message = new StringBuilder();
        while (true) {
            String line = reader.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }
            message.append(line).append("\r\n");
        }
        return message.toString();
    }

    private static void writeHttpStatus(OutputStream output, int status) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
        writer.write("HTTP/1.1 " + status + " " + EnglishReasonPhraseCatalog.INSTANCE.getReason(status, null) + "\r\n");
        writer.write("\r\n");
        writer.flush();
    }

    private static void closeQuietly(Closeable... closeables) {
        if (closeables == null) return;
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException ignored) {}
            }
        }
    }
}
