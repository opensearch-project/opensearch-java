/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Test;

/**
 * Combined tests for GrpcChannelFactory, GrpcChannelHealthMonitor, GrpcTlsConfig.
 */
public class GrpcChannelTest {

    private ManagedChannel channel;

    @After
    public void tearDown() {
        if (channel != null) channel.shutdownNow();
    }

    // ═══ GrpcTlsConfig Tests ═════════════════════════════════════════════════════

    @Test
    public void testTlsDefaults() {
        GrpcTlsConfig c = GrpcTlsConfig.builder().build();
        assertTrue(c.isEnabled());
        assertFalse(c.isInsecure());
        assertNull(c.trustCertificatePath());
        assertEquals("JKS", c.trustStoreType());
    }

    @Test
    public void testTlsInsecure() {
        assertTrue(GrpcTlsConfig.insecure().isInsecure());
    }

    @Test
    public void testTlsTrustCert() {
        assertEquals("/ca.pem", GrpcTlsConfig.builder().trustCertificatePath("/ca.pem").build().trustCertificatePath());
    }

    @Test
    public void testTlsTrustStore() {
        GrpcTlsConfig c = GrpcTlsConfig.builder().trustStorePath("/ts.jks").trustStorePassword("pass").trustStoreType("PKCS12").build();
        assertEquals("/ts.jks", c.trustStorePath());
        assertEquals("pass", c.trustStorePassword());
        assertEquals("PKCS12", c.trustStoreType());
    }

    @Test
    public void testTlsClientCert() {
        GrpcTlsConfig c = GrpcTlsConfig.builder().clientCertificatePath("/c.pem").clientKeyPath("/k.pem").clientKeyPassword("kp").build();
        assertEquals("/c.pem", c.clientCertificatePath());
        assertEquals("/k.pem", c.clientKeyPath());
        assertEquals("kp", c.clientKeyPassword());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTlsClientCertWithoutKey() {
        GrpcTlsConfig.builder().clientCertificatePath("/c.pem").build();
    }

    @Test
    public void testTlsDisabled() {
        assertFalse(GrpcTlsConfig.builder().enabled(false).build().isEnabled());
    }

    @Test
    public void testTlsHostnameOverride() {
        assertEquals("host.com", GrpcTlsConfig.builder().hostnameOverride("host.com").build().hostnameOverride());
    }

    // ═══ GrpcChannelFactory Tests ════════════════════════════════════════════════

    @Test
    public void testCreatePlaintext() {
        channel = GrpcChannelFactory.createPlaintextChannel("localhost", 9400, GrpcTransportOptions.defaults(), Collections.emptyList());
        assertNotNull(channel);
    }

    @Test
    public void testCreatePlaintextWithInterceptor() {
        channel = GrpcChannelFactory.createPlaintextChannel(
            "localhost",
            9400,
            GrpcTransportOptions.defaults(),
            Collections.singletonList(new BasicAuthInterceptor("a", "b"))
        );
        assertNotNull(channel);
    }

    @Test
    public void testCreateTlsInsecure() throws IOException {
        channel = GrpcChannelFactory.createTlsChannel(
            "localhost",
            9400,
            GrpcTlsConfig.insecure(),
            GrpcTransportOptions.defaults(),
            Collections.emptyList()
        );
        assertNotNull(channel);
    }

    @Test
    public void testCreateChannelNullTls() throws IOException {
        channel = GrpcChannelFactory.createChannel("localhost", 9400, null, GrpcTransportOptions.defaults(), Collections.emptyList());
        assertNotNull(channel);
    }

    @Test
    public void testBuilderWithTlsAndBasicAuth() {
        GrpcTransport t = GrpcTransport.builder("localhost", 9400)
            .jsonpMapper(new org.opensearch.client.json.jackson3.JacksonJsonpMapper())
            .tlsInsecure()
            .basicAuth("a", "b")
            .build();
        assertNotNull(t);
        try {
            t.close();
        } catch (Exception e) { /* */ }
    }

    // ═══ GrpcChannelHealthMonitor Tests ══════════════════════════════════════════

    @Test
    public void testInitialStateIdle() {
        channel = ManagedChannelBuilder.forAddress("localhost", 9400).usePlaintext().build();
        GrpcChannelHealthMonitor m = new GrpcChannelHealthMonitor(channel);
        assertEquals(ConnectivityState.IDLE, m.getState());
    }

    @Test
    public void testIsHealthyWhenIdle() {
        channel = ManagedChannelBuilder.forAddress("localhost", 9400).usePlaintext().build();
        assertTrue(new GrpcChannelHealthMonitor(channel).isHealthy());
    }

    @Test
    public void testIsNotReadyWhenIdle() {
        channel = ManagedChannelBuilder.forAddress("localhost", 9400).usePlaintext().build();
        assertFalse(new GrpcChannelHealthMonitor(channel).isReady());
    }

    @Test
    public void testIsShutdownAfterClose() {
        channel = ManagedChannelBuilder.forAddress("localhost", 9400).usePlaintext().build();
        channel.shutdownNow();
        assertTrue(new GrpcChannelHealthMonitor(channel).isShutdown());
    }

    @Test
    public void testWaitForReadyTimesOut() throws InterruptedException {
        channel = ManagedChannelBuilder.forAddress("localhost", 9400).usePlaintext().build();
        assertFalse(new GrpcChannelHealthMonitor(channel).waitForReady(500, TimeUnit.MILLISECONDS));
    }

    @Test
    public void testConnectIfIdle() {
        channel = ManagedChannelBuilder.forAddress("localhost", 9400).usePlaintext().build();
        GrpcChannelHealthMonitor m = new GrpcChannelHealthMonitor(channel);
        m.connectIfIdle();
        ConnectivityState s = m.getState(true);
        assertTrue(s == ConnectivityState.CONNECTING || s == ConnectivityState.TRANSIENT_FAILURE || s == ConnectivityState.READY);
    }

    @Test
    public void testMonitoringLifecycle() {
        channel = ManagedChannelBuilder.forAddress("localhost", 9400).usePlaintext().build();
        GrpcChannelHealthMonitor m = new GrpcChannelHealthMonitor(channel);
        m.startMonitoring();
        m.startMonitoring(); // idempotent
        m.stopMonitoring();
        assertNotNull(m.getState());
    }
}
