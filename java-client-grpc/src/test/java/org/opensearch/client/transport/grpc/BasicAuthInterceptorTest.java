/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.junit.Test;

/**
 * Tests for BasicAuthInterceptor.
 */
public class BasicAuthInterceptorTest {

    @Test
    public void testHeaderStartsWithBasic() {
        assertTrue(new BasicAuthInterceptor("admin", "admin").getAuthHeaderValue().startsWith("Basic "));
    }

    @Test
    public void testBase64Encoding() {
        String val = new BasicAuthInterceptor("admin", "secret").getAuthHeaderValue();
        String decoded = new String(Base64.getDecoder().decode(val.substring(6)), StandardCharsets.UTF_8);
        assertEquals("admin:secret", decoded);
    }

    @Test
    public void testSpecialChars() {
        String val = new BasicAuthInterceptor("user@domain.com", "p@ss:w0rd!").getAuthHeaderValue();
        String decoded = new String(Base64.getDecoder().decode(val.substring(6)), StandardCharsets.UTF_8);
        assertEquals("user@domain.com:p@ss:w0rd!", decoded);
    }

    @Test
    public void testEmptyPassword() {
        String val = new BasicAuthInterceptor("admin", "").getAuthHeaderValue();
        String decoded = new String(Base64.getDecoder().decode(val.substring(6)), StandardCharsets.UTF_8);
        assertEquals("admin:", decoded);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullUsername() {
        new BasicAuthInterceptor(null, "x");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullPassword() {
        new BasicAuthInterceptor("x", null);
    }

    @Test
    public void testDifferentCredentialsDifferentHeaders() {
        String h1 = new BasicAuthInterceptor("a", "a").getAuthHeaderValue();
        String h2 = new BasicAuthInterceptor("b", "b").getAuthHeaderValue();
        assertTrue(!h1.equals(h2));
    }
}
