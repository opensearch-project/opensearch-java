/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/**
 * Tests for JwtAuthInterceptor.
 */
public class JwtAuthInterceptorTest {

    @Test
    public void testStaticToken() {
        assertEquals("my-token", new JwtAuthInterceptor(() -> "my-token").getTokenSupplier().get());
    }

    @Test
    public void testSupplierCalledEachTime() {
        AtomicInteger c = new AtomicInteger(0);
        JwtAuthInterceptor i = new JwtAuthInterceptor(() -> "t-" + c.incrementAndGet());
        assertEquals("t-1", i.getTokenSupplier().get());
        assertEquals("t-2", i.getTokenSupplier().get());
        assertEquals("t-3", i.getTokenSupplier().get());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullSupplierThrows() {
        new JwtAuthInterceptor(null);
    }

    @Test
    public void testBuilderWithJwt() {
        GrpcTransport t = GrpcTransport.builder("localhost", 9400)
            .jsonpMapper(new org.opensearch.client.json.jackson.JacksonJsonpMapper())
            .jwtAuth(() -> "token")
            .build();
        assertNotNull(t);
        try {
            t.close();
        } catch (Exception e) { /* */ }
    }

    @Test
    public void testBuilderWithTlsAndJwt() {
        GrpcTransport t = GrpcTransport.builder("localhost", 9400)
            .jsonpMapper(new org.opensearch.client.json.jackson.JacksonJsonpMapper())
            .tlsInsecure()
            .jwtAuth(() -> "token")
            .build();
        assertNotNull(t);
        try {
            t.close();
        } catch (Exception e) { /* */ }
    }
}
