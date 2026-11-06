/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import io.grpc.KnownLength;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;

/**
 * Combined tests for GrpcSigV4Interceptor and GrpcSigV4Config.
 */
public class GrpcSigV4Test {

    private static final String HOST = "my-domain.us-east-1.es.amazonaws.com";
    private static final String AK = "AKIAIOSFODNN7EXAMPLE";
    private static final String SK = "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY";
    private static final String TOKEN = "FwoGZXIvYXdzEBYaDHqa0AP";

    private GrpcSigV4Interceptor interceptor(boolean withToken) {
        StaticCredentialsProvider provider = withToken
            ? StaticCredentialsProvider.create(AwsSessionCredentials.create(AK, SK, TOKEN))
            : StaticCredentialsProvider.create(AwsBasicCredentials.create(AK, SK));
        return new GrpcSigV4Interceptor(
            GrpcSigV4Config.builder().region(Region.US_EAST_1).service("es").credentialsProvider(provider).build(),
            HOST
        );
    }

    private String header(Map<String, List<String>> h, String... keys) {
        for (String k : keys)
            if (h.containsKey(k)) {
                List<String> v = h.get(k);
                return v != null && !v.isEmpty() ? v.get(0) : null;
            }
        return null;
    }

    // ═══ GrpcSigV4Config Tests ═══════════════════════════════════════════════════

    @Test
    public void testConfigDefaults() {
        GrpcSigV4Config c = GrpcSigV4Config.builder().region(Region.US_EAST_1).build();
        assertEquals("es", c.service());
        assertNotNull(c.credentialsProvider());
    }

    @Test
    public void testConfigAoss() {
        assertEquals("aoss", GrpcSigV4Config.builder().region(Region.US_WEST_2).service("aoss").build().service());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConfigNoRegion() {
        GrpcSigV4Config.builder().build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConfigEmptyService() {
        GrpcSigV4Config.builder().region(Region.US_EAST_1).service("").build();
    }

    // ═══ GrpcSigV4Interceptor — Header Presence Tests ════════════════════════════

    @Test
    public void testAuthorizationPresent() {
        assertNotNull(
            header(
                interceptor(false).signRequest("opensearch.DocumentService/Bulk", GrpcSigV4Interceptor.UNSIGNED_PAYLOAD),
                "Authorization",
                "authorization"
            )
        );
    }

    @Test
    public void testAmzDatePresent() {
        assertNotNull(
            header(
                interceptor(false).signRequest("opensearch.DocumentService/Bulk", GrpcSigV4Interceptor.UNSIGNED_PAYLOAD),
                "X-Amz-Date",
                "x-amz-date"
            )
        );
    }

    @Test
    public void testContentSha256Present() {
        assertNotNull(
            header(
                interceptor(false).signRequest("opensearch.DocumentService/Bulk", GrpcSigV4Interceptor.UNSIGNED_PAYLOAD),
                "x-amz-content-sha256",
                "X-Amz-Content-Sha256"
            )
        );
    }

    @Test
    public void testSessionTokenPresent() {
        assertNotNull(
            header(
                interceptor(true).signRequest("opensearch.DocumentService/Bulk", GrpcSigV4Interceptor.UNSIGNED_PAYLOAD),
                "X-Amz-Security-Token",
                "x-amz-security-token"
            )
        );
    }

    @Test
    public void testNoSessionTokenWithBasicCreds() {
        java.util.Map<String, java.util.List<String>> h = interceptor(false).signRequest(
            "opensearch.DocumentService/Bulk",
            GrpcSigV4Interceptor.UNSIGNED_PAYLOAD
        );
        assertFalse(h.containsKey("X-Amz-Security-Token") || h.containsKey("x-amz-security-token"));
    }

    @Test
    public void testHostPresent() {
        assertEquals(
            HOST,
            header(interceptor(false).signRequest("opensearch.DocumentService/Bulk", GrpcSigV4Interceptor.UNSIGNED_PAYLOAD), "host", "Host")
        );
    }

    // ═══ Authorization Format Tests ══════════════════════════════════════════════

    @Test
    public void testAuthStartsWithAWS4() {
        assertTrue(
            header(
                interceptor(false).signRequest("opensearch.DocumentService/Bulk", GrpcSigV4Interceptor.UNSIGNED_PAYLOAD),
                "Authorization",
                "authorization"
            ).startsWith("AWS4-HMAC-SHA256")
        );
    }

    @Test
    public void testAuthContainsRegion() {
        assertTrue(
            header(
                interceptor(false).signRequest("opensearch.DocumentService/Bulk", GrpcSigV4Interceptor.UNSIGNED_PAYLOAD),
                "Authorization",
                "authorization"
            ).contains("us-east-1")
        );
    }

    @Test
    public void testAuthContainsService() {
        assertTrue(
            header(
                interceptor(false).signRequest("opensearch.DocumentService/Bulk", GrpcSigV4Interceptor.UNSIGNED_PAYLOAD),
                "Authorization",
                "authorization"
            ).contains("/es/")
        );
    }

    @Test
    public void testAuthContainsCredential() {
        assertTrue(
            header(
                interceptor(false).signRequest("opensearch.DocumentService/Bulk", GrpcSigV4Interceptor.UNSIGNED_PAYLOAD),
                "Authorization",
                "authorization"
            ).contains("Credential=" + AK)
        );
    }

    @Test
    public void testAuthContainsSignedHeaders() {
        assertTrue(
            header(
                interceptor(false).signRequest("opensearch.DocumentService/Bulk", GrpcSigV4Interceptor.UNSIGNED_PAYLOAD),
                "Authorization",
                "authorization"
            ).contains("SignedHeaders=")
        );
    }

    @Test
    public void testAuthHas64CharSignature() {
        String auth = header(
            interceptor(false).signRequest("opensearch.DocumentService/Bulk", GrpcSigV4Interceptor.UNSIGNED_PAYLOAD),
            "Authorization",
            "authorization"
        );
        String sig = auth.substring(auth.indexOf("Signature=") + 10);
        assertTrue(sig.matches("[0-9a-f]{64}"));
    }

    @Test
    public void testAmzDateFormat() {
        String d = header(
            interceptor(false).signRequest("opensearch.DocumentService/Bulk", GrpcSigV4Interceptor.UNSIGNED_PAYLOAD),
            "X-Amz-Date",
            "x-amz-date"
        );
        assertTrue(d.matches("\\d{8}T\\d{6}Z"));
    }

    // ═══ Signing Behavior Tests ══════════════════════════════════════════════════

    @Test
    public void testDifferentPathsDifferentSignatures() {
        String s1 = header(
            interceptor(false).signRequest("opensearch.DocumentService/Bulk", GrpcSigV4Interceptor.UNSIGNED_PAYLOAD),
            "Authorization",
            "authorization"
        );
        String s2 = header(
            interceptor(false).signRequest("opensearch.SearchService/Search", GrpcSigV4Interceptor.UNSIGNED_PAYLOAD),
            "Authorization",
            "authorization"
        );
        assertFalse(s1.substring(s1.indexOf("Signature=")).equals(s2.substring(s2.indexOf("Signature="))));
    }

    @Test
    public void testAossServiceName() {
        StaticCredentialsProvider provider = StaticCredentialsProvider.create(AwsBasicCredentials.create(AK, SK));
        GrpcSigV4Interceptor i = new GrpcSigV4Interceptor(
            GrpcSigV4Config.builder().region(Region.US_WEST_2).service("aoss").credentialsProvider(provider).build(),
            HOST
        );
        String auth = header(
            i.signRequest("opensearch.DocumentService/Bulk", GrpcSigV4Interceptor.UNSIGNED_PAYLOAD),
            "Authorization",
            "authorization"
        );
        assertTrue(auth.contains("/aoss/"));
        assertTrue(auth.contains("us-west-2"));
    }

    // ═══ Payload Hash Tests ══════════════════════════════════════════════════════

    @Test
    public void testComputeHashEmpty() {
        assertEquals(
            "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
            GrpcSigV4Interceptor.computePayloadHash(new byte[0])
        );
    }

    @Test
    public void testComputeHashNull() {
        assertEquals("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855", GrpcSigV4Interceptor.computePayloadHash(null));
    }

    @Test
    public void testComputeHashData() {
        assertEquals(
            "b94d27b9934d3e08a52e52d7da7dabfac484efe37a5380ee9088f7ace2efcde9",
            GrpcSigV4Interceptor.computePayloadHash("hello world".getBytes())
        );
    }

    @Test
    public void testComputeHashDeterministic() {
        assertEquals(GrpcSigV4Interceptor.computePayloadHash("x".getBytes()), GrpcSigV4Interceptor.computePayloadHash("x".getBytes()));
    }

    @Test
    public void testUnsignedPayloadConstant() {
        assertEquals("UNSIGNED-PAYLOAD", GrpcSigV4Interceptor.UNSIGNED_PAYLOAD);
    }

    // ═══ Validation Tests ════════════════════════════════════════════════════════

    @Test(expected = IllegalArgumentException.class)
    public void testNullConfig() {
        new GrpcSigV4Interceptor(null, HOST);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullHost() {
        new GrpcSigV4Interceptor(
            GrpcSigV4Config.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("x", "y")))
                .build(),
            null
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyHost() {
        new GrpcSigV4Interceptor(
            GrpcSigV4Config.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("x", "y")))
                .build(),
            ""
        );
    }

    @Test(expected = IllegalStateException.class)
    public void testBuilderRequiresTls() {
        AwsGrpcTransport.awsBuilder("localhost", 9400)
            .jsonpMapper(new org.opensearch.client.json.jackson3.JacksonJsonpMapper())
            .sigV4(
                GrpcSigV4Config.builder()
                    .region(Region.US_EAST_1)
                    .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("x", "y")))
                    .build()
            )
            .build();
    }

    @Test
    public void testBuilderWithTlsAndSigV4() {
        GrpcTransport t = AwsGrpcTransport.awsBuilder(HOST, 9400)
            .jsonpMapper(new org.opensearch.client.json.jackson3.JacksonJsonpMapper())
            .tls(GrpcTlsConfig.insecure())
            .sigV4(
                GrpcSigV4Config.builder()
                    .region(Region.US_EAST_1)
                    .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("x", "y")))
                    .build()
            )
            .build();
        assertNotNull(t);
        try {
            t.close();
        } catch (Exception e) { /* */ }
    }

    // ═══ Request body ════════════════════════════════════════════════════════════

    /**
     * A stream of known length that records the requested length of each read into an array. It stands in for the
     * stream of a protobuf message, which copies the whole message aside when read in parts.
     */
    private static final class KnownLengthStream extends InputStream implements KnownLength {
        private final byte[] content;
        private final int announced;
        private int position;
        final List<Integer> reads = new ArrayList<>();

        KnownLengthStream(byte[] content, int announced) {
            this.content = content;
            this.announced = announced;
        }

        @Override
        public int available() {
            return Math.max(0, announced - position);
        }

        @Override
        public int read() {
            return position < content.length ? content[position++] & 0xff : -1;
        }

        @Override
        public int read(byte[] b, int off, int len) {
            reads.add(len);
            if (position >= content.length) {
                return -1;
            }
            int n = Math.min(len, content.length - position);
            System.arraycopy(content, position, b, off, n);
            position += n;
            return n;
        }
    }

    private static byte[] content(int length) {
        byte[] content = new byte[length];
        for (int i = 0; i < length; i++) {
            content[i] = (byte) i;
        }
        return content;
    }

    @Test
    public void testRequestBodyOfKnownLengthIsReadAtOnce() throws IOException {
        byte[] content = content(100_000);
        KnownLengthStream in = new KnownLengthStream(content, content.length);
        assertArrayEquals(content, GrpcSigV4Interceptor.readBody(in));
        assertEquals("the whole body is read into one array", Integer.valueOf(content.length), in.reads.get(0));
    }

    @Test
    public void testRequestBodyOfAnotherLengthThanAnnouncedIsReadWhole() throws IOException {
        byte[] content = content(10);
        assertArrayEquals(content, GrpcSigV4Interceptor.readBody(new KnownLengthStream(content, 4)));
        assertArrayEquals(Arrays.copyOf(content, 6), GrpcSigV4Interceptor.readBody(new KnownLengthStream(Arrays.copyOf(content, 6), 10)));
    }
}
