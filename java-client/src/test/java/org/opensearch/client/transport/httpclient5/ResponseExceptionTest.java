package org.opensearch.client.transport.httpclient5;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
import org.apache.hc.core5.http.message.RequestLine;
import org.junit.Test;

public class ResponseExceptionTest {

    @Test
    public void testStatus() throws IOException {
        final var response = this.buildResponseException(HttpStatus.SC_BAD_REQUEST);
        assertThat(response.status(), equalTo(HttpStatus.SC_BAD_REQUEST));
    }

    private ResponseException buildResponseException(final int statusCode) throws IOException {
        return new ResponseException(this.buildTestResponse(statusCode));
    }

    private Response buildTestResponse(final int statusCode) {
        return new Response(
            new RequestLine("GET", "/", HttpVersion.HTTP_1_1),
            new HttpHost("localhost"),
            new BasicClassicHttpResponse(statusCode)
        );
    }

}
