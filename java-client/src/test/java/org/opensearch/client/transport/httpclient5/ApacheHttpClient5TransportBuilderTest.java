package org.opensearch.client.transport.httpclient5;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.hc.client5.http.ConnectTimeoutException;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.util.Timeout;
import org.junit.Test;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.core.SearchRequest;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class ApacheHttpClient5TransportBuilderTest {

    @Test
    public void timeOutTest() {

        int expectTime = 10;
        String expectMessage = expectTime + " MILLISECONDS";

        ApacheHttpClient5Transport apacheHttpClient5Transport = ApacheHttpClient5TransportBuilder.builder(new HttpHost("10.255.255.1", 9200))
            .setConnectionConfigCallback(connectionConfigBuilder -> connectionConfigBuilder
                .setConnectTimeout(Timeout.ofMilliseconds(expectTime)))
            .build();

        OpenSearchClient osClient = new OpenSearchClient(apacheHttpClient5Transport);

        ConnectTimeoutException exception = assertThrows(ConnectTimeoutException.class, () -> osClient.search(SearchRequest.of(sb -> sb.index("index")), JsonNode.class));

        assertTrue("Expected timeout value not found in message", exception.getMessage().contains(expectMessage));
    }
}