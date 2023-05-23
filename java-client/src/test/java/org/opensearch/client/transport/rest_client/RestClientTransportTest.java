package org.opensearch.client.transport.rest_client;

import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.message.RequestLine;
import org.apache.hc.core5.http.message.StatusLine;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.opensearch.client.Request;
import org.opensearch.client.Response;
import org.opensearch.client.RestClient;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.opensearch.cluster.GetClusterSettingsRequest;
import org.opensearch.client.opensearch.cluster.GetClusterSettingsResponse;
import org.opensearch.client.transport.TransportException;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import software.amazon.awssdk.http.SdkHttpMethod;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class RestClientTransportTest {
    private static final String TEST_METHOD = SdkHttpMethod.GET.name();
    private static final String TEST_PATH = "/";

    @Mock
    RestClient restClient;

    @Mock
    JsonpMapper jsonpMapper;

    @Mock
    TransportOptions transportOptions;

    @Mock
    GetClusterSettingsRequest getClusterSettingsRequest;

    @Mock
    SimpleEndpoint<GetClusterSettingsRequest, GetClusterSettingsResponse> endpoint;

    @Mock
    Response response;

    @InjectMocks
    RestClientTransport objectUnderTest;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testForbiddenResponseException() throws IOException, URISyntaxException {
        when(endpoint.method(eq(getClusterSettingsRequest))).thenReturn(TEST_METHOD);
        when(endpoint.requestUrl(eq(getClusterSettingsRequest))).thenReturn(TEST_PATH);
        when(restClient.performRequest(any(Request.class))).thenReturn(response);
        final ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        final StatusLine statusLine = new StatusLine(
                protocolVersion, HttpStatus.SC_FORBIDDEN, "test reason");
        when(response.getStatusLine()).thenReturn(statusLine);
        final RequestLine requestLine = new RequestLine(TEST_METHOD, "", protocolVersion);
        when(response.getRequestLine()).thenReturn(requestLine);
        when(response.getHost()).thenReturn(HttpHost.create("https://localhost:9200"));
        final TransportException transportException = assertThrows(TransportException.class,
                () -> objectUnderTest.performRequest(getClusterSettingsRequest, endpoint, null));
        assertEquals("Forbidden access", transportException.getMessage());
    }

    @Test
    public void testUnauthorizedResponseException() throws IOException, URISyntaxException {
        when(endpoint.method(eq(getClusterSettingsRequest))).thenReturn(TEST_METHOD);
        when(endpoint.requestUrl(eq(getClusterSettingsRequest))).thenReturn(TEST_PATH);
        when(restClient.performRequest(any(Request.class))).thenReturn(response);
        final ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        final StatusLine statusLine = new StatusLine(new ProtocolVersion("HTTP", 1, 1),
                HttpStatus.SC_UNAUTHORIZED, "test reason");
        when(response.getStatusLine()).thenReturn(statusLine);
        final RequestLine requestLine = new RequestLine(TEST_METHOD, "", protocolVersion);
        when(response.getRequestLine()).thenReturn(requestLine);
        when(response.getHost()).thenReturn(HttpHost.create("https://localhost:9200"));
        final TransportException transportException = assertThrows(TransportException.class,
                () -> objectUnderTest.performRequest(getClusterSettingsRequest, endpoint, null));
        assertEquals("Unauthorized access", transportException.getMessage());
    }
}