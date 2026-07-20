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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.junit.Test;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jackson3.JacksonJsonpMapper;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportException;
import org.opensearch.client.transport.TransportOptions;

/**
 * Combined tests for GrpcTransport, HybridTransport, GrpcTransport endpoint registry, GrpcTransportOptions.
 */
public class GrpcTransportTest {

    private final JsonpMapper mapper = new JacksonJsonpMapper();

    // ═══ GrpcTransportOptions Tests ═══════════════════════════════════════════════

    @Test
    public void testDefaultOptions() {
        GrpcTransportOptions o = GrpcTransportOptions.defaults();
        assertEquals(10 * 1024 * 1024, o.maxInboundMessageSize());
        assertEquals(0, o.keepAliveTimeMs());
        assertEquals(20_000, o.keepAliveTimeoutMs());
        assertFalse(o.keepAliveWithoutCalls());
        assertEquals(3, o.maxRetries());
        assertEquals(100, o.retryBackoffMs());
    }

    @Test
    public void testCustomOptions() {
        GrpcTransportOptions o = GrpcTransportOptions.builder()
            .maxInboundMessageSize(50 * 1024 * 1024)
            .keepAliveTime(30, TimeUnit.SECONDS)
            .keepAliveTimeout(10, TimeUnit.SECONDS)
            .keepAliveWithoutCalls(true)
            .idleTimeout(5, TimeUnit.MINUTES)
            .maxRetries(5)
            .retryBackoff(200, TimeUnit.MILLISECONDS)
            .build();
        assertEquals(50 * 1024 * 1024, o.maxInboundMessageSize());
        assertEquals(30_000, o.keepAliveTimeMs());
        assertTrue(o.keepAliveWithoutCalls());
        assertEquals(300_000, o.idleTimeoutMs());
        assertEquals(5, o.maxRetries());
    }

    // ═══ GrpcTransport endpoint registry Tests ══════════════════════════════════════════════

    @Test
    public void testBulkSupported() {
        assertTrue(GrpcTransport.isEndpointSupported(BulkRequest._ENDPOINT));
    }

    @Test
    public void testUnsupportedEndpoint() {
        Endpoint<Object, Object, Object> fake = new Endpoint<Object, Object, Object>() {
            @Override
            public String method(Object r) {
                return "GET";
            }

            @Override
            public String requestUrl(Object r) {
                return "/_search";
            }

            @Override
            public boolean hasRequestBody() {
                return true;
            }

            @Override
            public boolean isError(int s) {
                return s >= 400;
            }

            @Override
            public org.opensearch.client.json.JsonpDeserializer<Object> errorDeserializer(int s) {
                return null;
            }
        };
        assertFalse(GrpcTransport.isEndpointSupported(fake));
    }

    // ═══ GrpcTransport Tests ═════════════════════════════════════════════════════

    @Test(expected = IllegalArgumentException.class)
    public void testBuilderRequiresMapper() {
        GrpcTransport.builder("localhost", 9400).build();
    }

    @Test
    public void testBuilderCreatesTransport() {
        GrpcTransport t = GrpcTransport.builder("localhost", 9400).jsonpMapper(mapper).build();
        assertNotNull(t);
        assertNotNull(t.channel());
        assertNotNull(t.grpcOptions());
        try {
            t.close();
        } catch (Exception e) { /* ignore */ }
    }

    @Test
    public void testUnsupportedEndpointThrows() throws Exception {
        GrpcTransport t = GrpcTransport.builder("localhost", 9400).jsonpMapper(mapper).build();
        try {
            Endpoint<Object, Object, Object> fake = new Endpoint<Object, Object, Object>() {
                @Override
                public String method(Object r) {
                    return "GET";
                }

                @Override
                public String requestUrl(Object r) {
                    return "/_cluster/health";
                }

                @Override
                public boolean hasRequestBody() {
                    return false;
                }

                @Override
                public boolean isError(int s) {
                    return s >= 400;
                }

                @Override
                public org.opensearch.client.json.JsonpDeserializer<Object> errorDeserializer(int s) {
                    return null;
                }
            };
            t.performRequest("dummy", fake, null);
            fail("Should throw");
        } catch (UnsupportedOperationException e) { /* expected */ } finally {
            t.close();
        }
    }

    // ═══ HybridTransport Tests ═══════════════════════════════════════════════════

    static class MockRestTransport implements OpenSearchTransport {
        int callCount = 0;
        String lastUrl = null;

        @Override
        @SuppressWarnings("unchecked")
        public <R, S, E> S performRequest(R req, Endpoint<R, S, E> ep, @Nullable TransportOptions o) throws IOException {
            callCount++;
            lastUrl = ep.requestUrl(req);
            if (ep == BulkRequest._ENDPOINT) return (S) new BulkResponse.Builder().took(1)
                .errors(false)
                .items(Collections.emptyList())
                .build();
            return null;
        }

        @Override
        public <R, S, E> CompletableFuture<S> performRequestAsync(R r, Endpoint<R, S, E> e, @Nullable TransportOptions o) {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    return performRequest(r, e, o);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }

        @Override
        public JsonpMapper jsonpMapper() {
            return new JacksonJsonpMapper();
        }

        @Override
        public TransportOptions options() {
            return null;
        }

        @Override
        public void close() {}
    }

    static class FailingGrpcTransport extends GrpcTransport {
        FailingGrpcTransport(JsonpMapper m) {
            super(null, m, GrpcTransportOptions.defaults(), null);
        }

        @Override
        public <R, S, E> S performRequest(R r, Endpoint<R, S, E> ep, @Nullable TransportOptions o) throws IOException {
            throw new TransportException("gRPC connection unavailable: test");
        }

        @Override
        public void close() {}
    }

    @Test
    public void testUnsupportedRoutedToRest() throws IOException {
        MockRestTransport rest = new MockRestTransport();
        HybridTransport h = new HybridTransport(new FailingGrpcTransport(mapper), rest);
        Endpoint<Object, Object, Object> fake = new Endpoint<Object, Object, Object>() {
            @Override
            public String method(Object r) {
                return "POST";
            }

            @Override
            public String requestUrl(Object r) {
                return "/_search";
            }

            @Override
            public boolean hasRequestBody() {
                return true;
            }

            @Override
            public boolean isError(int s) {
                return s >= 400;
            }

            @Override
            public org.opensearch.client.json.JsonpDeserializer<Object> errorDeserializer(int s) {
                return null;
            }
        };
        h.performRequest("x", fake, null);
        assertEquals(1, rest.callCount);
    }

    @Test
    public void testFallbackOnGrpcFailure() throws IOException {
        MockRestTransport rest = new MockRestTransport();
        HybridTransport h = new HybridTransport(new FailingGrpcTransport(mapper), rest, true);
        BulkRequest req = new BulkRequest.Builder().operations(op -> op.delete(d -> d.id("1").index("t"))).build();
        assertNotNull(h.performRequest(req, BulkRequest._ENDPOINT, null));
        assertEquals(1, rest.callCount);
    }

    @Test
    public void testNoFallbackWhenDisabled() throws IOException {
        MockRestTransport rest = new MockRestTransport();
        HybridTransport h = new HybridTransport(new FailingGrpcTransport(mapper), rest, false);
        BulkRequest req = new BulkRequest.Builder().operations(op -> op.delete(d -> d.id("1").index("t"))).build();
        try {
            h.performRequest(req, BulkRequest._ENDPOINT, null);
            fail();
        } catch (TransportException e) {
            assertEquals(0, rest.callCount);
        }
    }
}
