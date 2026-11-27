/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.httpclient5;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertArrayEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
import org.apache.hc.core5.http.message.RequestLine;
import org.junit.Test;

public class ResponseExceptionTest {

    @Test
    public void testStatus() throws IOException {
        final ResponseException response = this.buildResponseException(HttpStatus.SC_BAD_REQUEST);
        assertThat(response.status(), equalTo(HttpStatus.SC_BAD_REQUEST));
    }

    // Scenario: the error body is in a binary format (e.g. CBOR or SMILE, requested through the Accept header).
    // Expected: the message describes the body instead of decoding its bytes as text, and the body stays readable.
    @Test
    public void testBinaryBodyIsNotRenderedAsText() throws IOException {
        final byte[] body = new byte[] { (byte) 0xbf, (byte) 0xff, (byte) 0xfe, 0x00, (byte) 0x80 };
        final String[] types = { "application/cbor", "application/smile", "application/octet-stream", "Application/CBOR; charset=UTF-8" };

        for (final String contentType : types) {
            final HttpEntity entity = new ByteArrayEntity(body, ContentType.parse(contentType));

            final ResponseException exception = new ResponseException(this.buildTestResponse(HttpStatus.SC_BAD_REQUEST, entity));

            assertThat(contentType, exception.getMessage(), containsString("binary"));
            assertThat(contentType, exception.getMessage(), containsString("5 bytes"));
            assertThat(contentType, exception.getMessage(), not(containsString("\uFFFD")));
            assertArrayEquals(contentType, body, EntityUtils.toByteArray(exception.getResponse().getEntity()));
        }
    }

    // Scenario: the error body is JSON. Expected: the body is still appended to the message.
    @Test
    public void testJsonBodyIsIncludedInMessage() throws IOException {
        final String json = "{\"error\":{\"type\":\"parsing_exception\"},\"status\":400}";
        final HttpEntity entity = new ByteArrayEntity(json.getBytes(StandardCharsets.UTF_8), ContentType.APPLICATION_JSON);

        final ResponseException exception = new ResponseException(this.buildTestResponse(HttpStatus.SC_BAD_REQUEST, entity));

        assertThat(exception.getMessage(), endsWith("\n" + json));
    }

    // Scenario: the error body has no content type. Expected: the body is still appended to the message, as before.
    @Test
    public void testBodyWithoutContentTypeIsIncludedInMessage() throws IOException {
        final HttpEntity entity = new ByteArrayEntity("no content type".getBytes(StandardCharsets.UTF_8), null);

        final ResponseException exception = new ResponseException(this.buildTestResponse(HttpStatus.SC_BAD_REQUEST, entity));

        assertThat(exception.getMessage(), endsWith("\nno content type"));
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

    private Response buildTestResponse(final int statusCode, final HttpEntity entity) {
        final BasicClassicHttpResponse response = new BasicClassicHttpResponse(statusCode);
        response.setEntity(entity);
        return new Response(new RequestLine("GET", "/", HttpVersion.HTTP_1_1), new HttpHost("localhost"), response);
    }

}
