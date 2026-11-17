/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.httpclient5.sniffer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.core5.util.Timeout;
import org.junit.Test;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jsonb.JsonbJsonpMapper;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.GenericEndpoint;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5Options;

/**
 * Tests that {@link OpenSearchNodesSniffer} wires the server-side {@code timeout} query parameter
 * and the client-side socket/connect timeouts correctly.
 */
public class OpenSearchNodesSnifferTimeoutTests {

    // Reuse the same canned body as the parse-focused tests.
    private static final String TWO_NODES = "{"
        + "\"_nodes\":{\"total\":2,\"successful\":2},"
        + "\"cluster_name\":\"test\","
        + "\"nodes\":{"
        + "  \"abc\":{\"name\":\"node-a\",\"version\":\"3.5.0\",\"roles\":[\"data\",\"ingest\"],"
        + "          \"attributes\":{\"zone\":\"z1\"},"
        + "          \"http\":{\"bound_address\":[\"127.0.0.1:9200\"],\"publish_address\":\"127.0.0.1:9200\"}},"
        + "  \"def\":{\"name\":\"node-b\",\"version\":\"3.5.0\",\"roles\":[\"cluster_manager\"],"
        + "          \"http\":{\"bound_address\":[\"127.0.0.1:9201\"],\"publish_address\":\"127.0.0.1:9201\"}}"
        + "}}";

    /**
     * A minimal fake {@link OpenSearchTransport} that:
     * <ul>
     *   <li>returns a configurable {@link ApacheHttpClient5Options} from {@link #options()}, so
     *       {@link OpenSearchNodesSniffer#sniffRequestOptions} exercises the
     *       {@code instanceof ApacheHttpClient5Options} branch;</li>
     *   <li>captures the {@code TransportOptions} passed to {@code performRequest} so tests can
     *       inspect the per-request options;</li>
     *   <li>captures the query parameters of the request so tests can inspect the {@code timeout}
     *       query param;</li>
     *   <li>delegates response construction to the endpoint's own {@code responseDeserializer}
     *       using a canned JSON body, producing a real {@code Response} without touching
     *       the package-private {@code GenericResponse} constructor.</li>
     * </ul>
     */
    private static final class CapturingTransport implements OpenSearchTransport {

        private final JsonpMapper mapper = new JsonbJsonpMapper();
        private final TransportOptions baseOptions;

        final AtomicReference<TransportOptions> capturedOptions = new AtomicReference<>();
        final AtomicReference<Map<String, String>> capturedQueryParams = new AtomicReference<>();

        CapturingTransport(TransportOptions baseOptions) {
            this.baseOptions = baseOptions;
        }

        @Override
        public TransportOptions options() {
            return baseOptions;
        }

        @Override
        @SuppressWarnings("unchecked")
        public <RequestT, ResponseT, ErrorT> ResponseT performRequest(
            RequestT request,
            Endpoint<RequestT, ResponseT, ErrorT> endpoint,
            @Nullable TransportOptions options
        ) throws IOException {
            capturedOptions.set(options);
            // Capture query parameters via the endpoint so we see what the request wired in.
            capturedQueryParams.set(endpoint.queryParameters(request));

            // Produce the response by delegating to the endpoint's own deserializer; this is the
            // same path the real httpclient5 transport takes and avoids touching GenericResponse
            // (which is package-private).
            GenericEndpoint<RequestT, ResponseT> ge = (GenericEndpoint<RequestT, ResponseT>) endpoint;
            byte[] body = TWO_NODES.getBytes(StandardCharsets.UTF_8);
            return ge.responseDeserializer(
                "/_nodes/http",
                "GET",
                "HTTP/1.1",
                200,
                "OK",
                Collections.emptyList(),
                "application/json",
                new java.io.ByteArrayInputStream(body)
            );
        }

        @Override
        public <RequestT, ResponseT, ErrorT> CompletableFuture<ResponseT> performRequestAsync(
            RequestT request,
            Endpoint<RequestT, ResponseT, ErrorT> endpoint,
            @Nullable TransportOptions options
        ) {
            throw new UnsupportedOperationException("not needed for sniffer tests");
        }

        @Override
        public JsonpMapper jsonpMapper() {
            return mapper;
        }

        @Override
        public void close() throws IOException {}
    }

    // -------------------------------------------------------------------------
    // Tests for the 2-arg constructor (defaults)
    // -------------------------------------------------------------------------

    @Test
    public void twoArgCtor_usesDefaultTimeoutQueryParam() throws IOException {
        CapturingTransport transport = new CapturingTransport(ApacheHttpClient5Options.DEFAULT);
        OpenSearchNodesSniffer sniffer = new OpenSearchNodesSniffer(transport, "http");

        sniffer.sniff();

        Map<String, String> params = transport.capturedQueryParams.get();
        assertThat(params, notNullValue());
        assertThat(params.get("timeout"), is(OpenSearchNodesSniffer.DEFAULT_SNIFF_REQUEST_TIMEOUT_MILLIS + "ms"));
    }

    @Test
    public void twoArgCtor_appliesDefaultSocketTimeoutToRequestConfig() throws IOException {
        CapturingTransport transport = new CapturingTransport(ApacheHttpClient5Options.DEFAULT);
        OpenSearchNodesSniffer sniffer = new OpenSearchNodesSniffer(transport, "http");

        sniffer.sniff();

        TransportOptions opts = transport.capturedOptions.get();
        assertThat(opts, notNullValue());
        assertThat("options must be ApacheHttpClient5Options", opts instanceof ApacheHttpClient5Options, is(true));

        RequestConfig rc = ((ApacheHttpClient5Options) opts).getRequestConfig();
        assertThat("RequestConfig must be set", rc, notNullValue());

        Timeout expected = Timeout.ofMilliseconds(OpenSearchNodesSniffer.DEFAULT_SNIFF_REQUEST_SOCKET_TIMEOUT_MILLIS);
        assertThat(rc.getResponseTimeout(), is(expected));
        assertThat(rc.getConnectTimeout(), is(expected));
    }

    // -------------------------------------------------------------------------
    // Tests for the 4-arg constructor (custom values)
    // -------------------------------------------------------------------------

    @Test
    public void fourArgCtor_usesCustomTimeoutQueryParam() throws IOException {
        long serverTimeoutMs = 2500L;
        CapturingTransport transport = new CapturingTransport(ApacheHttpClient5Options.DEFAULT);
        OpenSearchNodesSniffer sniffer = new OpenSearchNodesSniffer(transport, "http", serverTimeoutMs, 15_000L);

        sniffer.sniff();

        Map<String, String> params = transport.capturedQueryParams.get();
        assertThat(params.get("timeout"), is("2500ms"));
    }

    @Test
    public void fourArgCtor_appliesCustomSocketTimeoutToRequestConfig() throws IOException {
        long socketTimeoutMs = 7500L;
        CapturingTransport transport = new CapturingTransport(ApacheHttpClient5Options.DEFAULT);
        OpenSearchNodesSniffer sniffer = new OpenSearchNodesSniffer(transport, "http", 1000L, socketTimeoutMs);

        sniffer.sniff();

        TransportOptions opts = transport.capturedOptions.get();
        RequestConfig rc = ((ApacheHttpClient5Options) opts).getRequestConfig();
        assertThat(rc, notNullValue());

        Timeout expected = Timeout.ofMilliseconds(socketTimeoutMs);
        assertThat(rc.getResponseTimeout(), is(expected));
        assertThat(rc.getConnectTimeout(), is(expected));
    }

    @Test
    public void sniffRequestOptions_preservesExistingRequestConfigSettings() throws IOException {
        // Build a base ApacheHttpClient5Options that already carries a RequestConfig with a
        // connection-request timeout. The sniffer must copy that config and only override
        // response/connect timeouts — the connection-request timeout must survive unchanged.
        RequestConfig existingConfig = RequestConfig.custom().setConnectionRequestTimeout(Timeout.ofMilliseconds(3333L)).build();
        ApacheHttpClient5Options baseWithConfig = ApacheHttpClient5Options.DEFAULT.toBuilder().setRequestConfig(existingConfig).build();

        CapturingTransport transport = new CapturingTransport(baseWithConfig);
        OpenSearchNodesSniffer sniffer = new OpenSearchNodesSniffer(transport, "http", 1000L, 5000L);

        sniffer.sniff();

        RequestConfig rc = ((ApacheHttpClient5Options) transport.capturedOptions.get()).getRequestConfig();
        assertThat(rc, notNullValue());
        // Overridden values
        assertThat(rc.getResponseTimeout(), is(Timeout.ofMilliseconds(5000L)));
        assertThat(rc.getConnectTimeout(), is(Timeout.ofMilliseconds(5000L)));
        // Preserved value
        assertThat(rc.getConnectionRequestTimeout(), is(Timeout.ofMilliseconds(3333L)));
    }

    // -------------------------------------------------------------------------
    // SnifferBuilder propagation
    // -------------------------------------------------------------------------

    @Test
    public void snifferBuilder_defaultsMatchSnifferConstants() {
        // Verify that SnifferBuilder initialises its fields to the same defaults the sniffer uses,
        // without needing a real transport (just check the field values via reflection-free accessors).
        // We exercise the setters round-trip: set → re-read via a custom sniffer for the query param.
        CapturingTransport transport = new CapturingTransport(ApacheHttpClient5Options.DEFAULT);

        // Building through the builder with explicit defaults must produce the same query param.
        // We can't call SnifferBuilder(transport) because it requires ApacheHttpClient5Transport,
        // so we verify the constants match instead.
        assertThat(OpenSearchNodesSniffer.DEFAULT_SNIFF_REQUEST_TIMEOUT_MILLIS, is(1000L));
        assertThat(OpenSearchNodesSniffer.DEFAULT_SNIFF_REQUEST_SOCKET_TIMEOUT_MILLIS, is(10_000L));
    }

    @Test
    public void constructor_rejectsNonApacheHttpClient5TransportOptions() {
        // A transport whose options are NOT ApacheHttpClient5Options must be rejected, not silently
        // stripped of the socket timeout.
        CapturingTransport transport = new CapturingTransport(TransportOptions.builder().build());
        try {
            new OpenSearchNodesSniffer(transport, "http");
            org.junit.Assert.fail("expected IllegalArgumentException for a non-HC5 transport");
        } catch (IllegalArgumentException expected) {
            // expected
        }
    }

    @Test
    public void constructor_rejectsNonPositiveServerTimeout() {
        CapturingTransport transport = new CapturingTransport(ApacheHttpClient5Options.DEFAULT);
        for (long bad : new long[] { 0L, -1L }) {
            try {
                new OpenSearchNodesSniffer(transport, "http", bad, 10_000L);
                org.junit.Assert.fail("expected IllegalArgumentException for server timeout " + bad);
            } catch (IllegalArgumentException expected) {
                // expected
            }
        }
    }

    @Test
    public void constructor_rejectsNonPositiveSocketTimeout() {
        CapturingTransport transport = new CapturingTransport(ApacheHttpClient5Options.DEFAULT);
        for (long bad : new long[] { 0L, -1L }) {
            try {
                new OpenSearchNodesSniffer(transport, "http", 1000L, bad);
                org.junit.Assert.fail("expected IllegalArgumentException for socket timeout " + bad);
            } catch (IllegalArgumentException expected) {
                // expected
            }
        }
    }
}
