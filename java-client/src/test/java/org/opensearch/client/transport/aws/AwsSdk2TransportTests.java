/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.aws;

import static org.apache.hc.core5.http.ContentType.APPLICATION_JSON;
import static org.apache.hc.core5.http.HttpHeaders.CONTENT_LENGTH;
import static org.apache.hc.core5.http.HttpHeaders.CONTENT_TYPE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.http.impl.bootstrap.HttpServer;
import org.apache.hc.core5.http.impl.bootstrap.ServerBootstrap;
import org.apache.hc.core5.http.impl.routing.RequestRouter;
import org.apache.hc.core5.http.io.HttpRequestHandler;
import org.apache.hc.core5.http.io.entity.BasicHttpEntity;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.util.encoders.Hex;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.generic.Requests;
import org.opensearch.client.transport.TransportException;
import org.opensearch.client.transport.util.FunnellingHttpsProxy;
import org.opensearch.client.transport.util.SelfSignedCertificateAuthority;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.SdkHttpConfigurationOption;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.http.async.SdkAsyncHttpClient;
import software.amazon.awssdk.http.crt.AwsCrtAsyncHttpClient;
import software.amazon.awssdk.http.crt.AwsCrtHttpClient;
import software.amazon.awssdk.http.nio.netty.NettyNioAsyncHttpClient;
import software.amazon.awssdk.http.nio.netty.ProxyConfiguration;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.utils.AttributeMap;

@RunWith(Parameterized.class)
public class AwsSdk2TransportTests {
    public enum SdkHttpClientType {
        APACHE,
        AWS_CRT,
        AWS_CRT_ASYNC,
        NETTY_NIO_ASYNC,
        URL_CONNECTION
    }

    private static final String[] TEST_SERVICE_NAMES = { "aoss", "es", "arbitrary" };
    private static final Region TEST_REGION = Region.AP_SOUTHEAST_2;
    private static final String TEST_INDEX = "sample-index1";
    private static final String EMPTY_SHA256 = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";
    private static SSLContext SSL_CONTEXT;
    private static TrustManager[] CLIENT_TRUST_MANAGERS;

    private final ConcurrentLinkedQueue<ReceivedRequest> receivedRequests = new ConcurrentLinkedQueue<>();
    private final SdkHttpClientType sdkHttpClientType;
    private final String serviceName;
    private final String serviceHostName;
    private HttpServer server;
    private FunnellingHttpsProxy proxy;

    public AwsSdk2TransportTests(SdkHttpClientType sdkHttpClientType, String serviceName) {
        this.sdkHttpClientType = sdkHttpClientType;
        this.serviceName = serviceName;
        this.serviceHostName = getTestServiceHostName(serviceName);
    }

    @Parameterized.Parameters(name = "sdkHttpClientType: {0}, serviceName: {1}")
    public static Collection<?> getParameters() {
        return Arrays.stream(SdkHttpClientType.values())
            .flatMap(
                sdkHttpClientType -> Arrays.stream(TEST_SERVICE_NAMES).map(serviceName -> new Object[] { sdkHttpClientType, serviceName })
            )
            .collect(Collectors.toList());
    }

    private static String getTestServiceHostName(String serviceName) {
        return "aaabbbcccddd111222333." + TEST_REGION.toString() + "." + serviceName + ".amazonaws.com";
    }

    @BeforeClass
    public static void setupClass() throws Exception {
        final SelfSignedCertificateAuthority ca = new SelfSignedCertificateAuthority();

        GeneralName[] subjectAlternateNames = Arrays.stream(TEST_SERVICE_NAMES)
            .map(AwsSdk2TransportTests::getTestServiceHostName)
            .map(hostname -> new GeneralName(GeneralName.dNSName, hostname))
            .toArray(GeneralName[]::new);

        SelfSignedCertificateAuthority.GeneratedCertificate hostCert = ca.generateCertificate(
            new X500Name("DC=localhost, O=localhost, OU=localhost, CN=localhost"),
            subjectAlternateNames
        );

        final char[] keystorePassword = "password".toCharArray();
        KeyStore keyMaterial = KeyStore.getInstance("JKS");
        keyMaterial.load(null, keystorePassword);
        keyMaterial.setKeyEntry("localhost", hostCert.getPrivateKey(), keystorePassword, hostCert.getCertificateChain());

        SSL_CONTEXT = SSLContextBuilder.create()
            .loadKeyMaterial(keyMaterial, keystorePassword, (aliases, sslParameters) -> "localhost")
            .build();

        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(null, keystorePassword);
        trustStore.setCertificateEntry("localhost", ca.getCertificate());

        TrustManagerFactory clientTrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        clientTrustManagerFactory.init(trustStore);
        CLIENT_TRUST_MANAGERS = clientTrustManagerFactory.getTrustManagers();
    }

    @Before
    public void setup() throws Exception {
        server = ServerBootstrap.bootstrap()
            .setRequestRouter(
                RequestRouter.<HttpRequestHandler>builder()
                    .addRoute(RequestRouter.LOCAL_AUTHORITY, "/", hardcodedJsonHandler("{}"))
                    .addRoute(
                        RequestRouter.LOCAL_AUTHORITY,
                        "/" + TEST_INDEX,
                        hardcodedJsonHandler("{\"acknowledged\": true,\"shards_acknowledged\": true,\"index\": \"" + TEST_INDEX + "\"}")
                    )
                    .addRoute(
                        RequestRouter.LOCAL_AUTHORITY,
                        "/" + TEST_INDEX + "/_refresh",
                        hardcodedJsonHandler("{\"_shards\":{\"failed\":0,\"successful\":1,\"total\":1}}")
                    )
                    .addRoute(
                        RequestRouter.LOCAL_AUTHORITY,
                        "/_search/scroll",
                        hardcodedJsonHandler("{\"succeeded\": true,\"num_freed\": 1}")
                    )
                    .addRoute(
                        RequestRouter.LOCAL_AUTHORITY,
                        "/_search/point_in_time",
                        hardcodedJsonHandler("{\"pits\": [{\"pit_id\": \"pit1\", \"successful\": true}]}")
                    )
                    .resolveAuthority(RequestRouter.LOCAL_AUTHORITY_RESOLVER)
                    .build()
            )
            .setSslContext(SSL_CONTEXT)
            .setListenerPort(0)
            .create();
        server.start();
        proxy = new FunnellingHttpsProxy(server.getLocalPort());
    }

    private static class ReceivedRequest {
        private final ClassicHttpRequest request;
        private final byte[] body;

        public ReceivedRequest(ClassicHttpRequest request) throws IOException {
            this.request = request;
            HttpEntity entity = request.getEntity();
            if (entity != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                entity.writeTo(baos);
                body = baos.toByteArray();
            } else {
                body = new byte[0];
            }
        }

        public String getMethod() {
            return request.getMethod();
        }

        public String getRequestUri() {
            return request.getRequestUri();
        }

        public String getHeader(String name) throws ProtocolException {
            return Optional.ofNullable(request.getHeader(name)).map(Header::getValue).orElse(null);
        }
    }

    private HttpRequestHandler hardcodedJsonHandler(String json) {
        byte[] jsonBytes = json.getBytes(StandardCharsets.UTF_8);
        return (request, response, context) -> {
            receivedRequests.add(new ReceivedRequest(request));
            response.setCode(200);
            response.setEntity(new BasicHttpEntity(new ByteArrayInputStream(jsonBytes), jsonBytes.length, APPLICATION_JSON));
        };
    }

    @After
    public void teardown() {
        server.close(CloseMode.IMMEDIATE);
        server = null;
        proxy.close();
        proxy = null;
        receivedRequests.clear();
    }

    private OpenSearchClient getTestClient() throws URISyntaxException {
        AwsSdk2TransportOptions options = AwsSdk2TransportOptions.builder()
            .setCredentials(() -> AwsBasicCredentials.builder().accessKeyId("test-access-key").secretAccessKey("test-secret-key").build())
            .setSigningClock(Clock.fixed(Instant.ofEpochSecond(1673626117), ZoneId.of("UTC"))) // 2023-01-13 16:08:37 +0000
            .setResponseCompression(false)
            .build();

        AttributeMap sdkHttpClientConfig;

        if (sdkHttpClientType == SdkHttpClientType.AWS_CRT || sdkHttpClientType == SdkHttpClientType.AWS_CRT_ASYNC) {
            // AWS CRT does not support custom trust managers to verify the cert
            sdkHttpClientConfig = AttributeMap.builder().put(SdkHttpConfigurationOption.TRUST_ALL_CERTIFICATES, true).build();
        } else {
            sdkHttpClientConfig = AttributeMap.builder()
                .put(SdkHttpConfigurationOption.TLS_TRUST_MANAGERS_PROVIDER, () -> CLIENT_TRUST_MANAGERS)
                .build();
        }

        URI proxyEndpoint = new URI("http://localhost:" + proxy.getPort());

        SdkHttpClient sdkHttpClient = null;
        SdkAsyncHttpClient sdkAsyncHttpClient = null;
        switch (sdkHttpClientType) {
            case APACHE:
                software.amazon.awssdk.http.apache.ProxyConfiguration proxyConfig = software.amazon.awssdk.http.apache.ProxyConfiguration
                    .builder()
                    .endpoint(proxyEndpoint)
                    .build();
                sdkHttpClient = ApacheHttpClient.builder().proxyConfiguration(proxyConfig).buildWithDefaults(sdkHttpClientConfig);
                break;
            case AWS_CRT:
                sdkHttpClient = AwsCrtHttpClient.builder()
                    .proxyConfiguration(p -> p.scheme("http").host("localhost").port(proxy.getPort()))
                    .buildWithDefaults(sdkHttpClientConfig);
                break;
            case AWS_CRT_ASYNC:
                sdkAsyncHttpClient = AwsCrtAsyncHttpClient.builder()
                    .proxyConfiguration(p -> p.scheme("http").host("localhost").port(proxy.getPort()))
                    .buildWithDefaults(sdkHttpClientConfig);
                break;
            case NETTY_NIO_ASYNC:
                ProxyConfiguration nettyProxyConfig = software.amazon.awssdk.http.nio.netty.ProxyConfiguration.builder()
                    .scheme("http")
                    .host("localhost")
                    .port(proxy.getPort())
                    .build();
                sdkAsyncHttpClient = NettyNioAsyncHttpClient.builder()
                    .proxyConfiguration(nettyProxyConfig)
                    .buildWithDefaults(sdkHttpClientConfig);
                break;
            case URL_CONNECTION:
                sdkHttpClient = UrlConnectionHttpClient.builder()
                    .proxyConfiguration(p -> p.endpoint(proxyEndpoint))
                    .buildWithDefaults(sdkHttpClientConfig);
                break;
            default:
                throw new IllegalArgumentException("Unknown SdkHttpClientType: " + sdkHttpClientType);
        }

        AwsSdk2Transport transport;
        if (sdkAsyncHttpClient != null) {
            transport = new AwsSdk2Transport(sdkAsyncHttpClient, serviceHostName, serviceName, TEST_REGION, options);
        } else {
            transport = new AwsSdk2Transport(sdkHttpClient, serviceHostName, serviceName, TEST_REGION, options);
        }
        return new OpenSearchClient(transport);
    }

    @Test
    public void testSigV4PutIndex() throws Exception {
        assertSigV4Request(
            c -> c.indices()
                .create(
                    b -> b.index("sample-index1")
                        .aliases("sample-alias1", a -> a)
                        .mappings(m -> m.properties("age", p -> p.integer(i -> i)))
                        .settings(s -> s.index(i -> i.numberOfReplicas(1).numberOfShards(2)))
                ),
            "PUT",
            "/" + TEST_INDEX,
            152,
            "d74f84822e2dfce88bcfd16e5092a42989396019c82fde62fa0e9ac4e34d9350",
            selectExpectedSignature(
                "cee95989c4e6007d840ae598ccc0bccef238826dba068a84951041c8484aa704",
                "7ad70d59f92bd59fbe1a977ee014f15a3f793488b4869f62aa64375a5755850b",
                "bb6c080d9ff3f6f29ae86936afc465a2c519b3cc3bf73e8cba2bc4c54d4701ad"
            )
        );
    }

    @Test
    public void testSigV4ClearScroll() throws Exception {
        assertSigV4Request(
            OpenSearchClient::clearScroll,
            "DELETE",
            "/_search/scroll",
            2,
            "44136fa355b3678a1146ad16f7e8649e94fb4fc21fe77e8310c060f61caaff8a",
            selectExpectedSignature(
                "8c5d3d990f038e1d980a7d1b1611fa55f9b9b29a018a89ec84a6b9286e0e782d",
                "f423dc8dce53a90d9f8e0701a8a721e54119b97201366438796d74ca0265f08d",
                "63dd431cb3d4e2ba9e0aaf183975b1d19528de23bd68ee0c4269000008545922"
            )
        );
    }

    @Test
    public void testSigV4DeletePit() throws Exception {
        // noinspection ArraysAsListWithZeroOrOneArgument
        assertSigV4Request(
            c -> c.deletePit(d -> d.pitId(Arrays.asList("pit1"))),
            "DELETE",
            "/_search/point_in_time",
            19,
            "daaa6af55a9cfe622f46de69ebc3b4df84703f320b839346b7fb4cf94bdbd766",
            selectExpectedSignature(
                "82cb4f441ca313047542597cd54bdb3139ce111e269fe3bade5d59a1b2cd00a0",
                "6abef10fb828cfc62683f38fbaa93894885308b0516bbe7b5485ae99e16b51bb",
                "59697fbb5f10b197a1abea0264e7380d34db3c99b428bfa3781c0b665242f420"
            )
        );
    }

    @Test
    public void testSigV4Refresh() throws Exception {
        assertSigV4Request(
            c -> c.indices().refresh(s -> s.index(TEST_INDEX).ignoreUnavailable(true)),
            "POST",
            "/" + TEST_INDEX + "/_refresh?ignore_unavailable=true",
            0,
            EMPTY_SHA256,
            selectExpectedSignature(
                "6955ebe7d39f5e885c544dc9945a20ba2bc293200abe7ffce43d8288a0e0a606",
                "aab646c6a8be1fe42b25469c057bf07c99445fff5a9cf889b5768054b4fe8f00",
                "5b28f6020340454f6c9a0ef7ed056095f54f4083d066e80b42af2a2ff77aea80"
            )
        );
    }

    @Test
    public void testHeadWithBody() throws Exception {
        assertSigV4Request(
            c -> c.generic().execute(Requests.builder().method("HEAD").endpoint("/").json("{}").build()),
            "HEAD",
            "/",
            2,
            "44136fa355b3678a1146ad16f7e8649e94fb4fc21fe77e8310c060f61caaff8a",
            selectExpectedSignature(
                "547492a6aab72cdb687697ea291c35ae350e9fc0b7f96d1906efaeafa3e2b3c7",
                "4e94a0a1048e252d3f46bda799886d726e4972286fa79ee80c2d7e5529c86948",
                "6a4c0801c89b6cbc8f786a68bf51f18589ef77bdd5c01eb49a227fa19391a333"
            )
        );
    }

    @Test
    public void testOptionsWithBody() throws Exception {
        assertSigV4Request(
            c -> c.generic().execute(Requests.builder().method("OPTIONS").endpoint("/").json("{}").build()),
            "OPTIONS",
            "/",
            2,
            "44136fa355b3678a1146ad16f7e8649e94fb4fc21fe77e8310c060f61caaff8a",
            selectExpectedSignature(
                "087c8fd96bc338d0dd680610967dd3c2d3f265a40158c1db4bfed83afaaf5246",
                "e01b953a36d725d3e54565277a3aea6014961ce14c1c47b5930f6d75bc47f43b",
                "2c3b08c49f0e45906f99cef144b3ba780c5c0d38cb9e2bcc75d34087172a254f"
            )
        );
    }

    private void assertSigV4Request(
        OpenSearchClientAction request,
        String method,
        String requestUri,
        int contentLength,
        String contentSha256,
        String expectedSignature
    ) throws Exception {
        OpenSearchClient client = getTestClient();

        if (sdkHttpClientType != SdkHttpClientType.APACHE
            || contentLength == 0
            || "PATCH".equals(method)
            || "POST".equals(method)
            || "PUT".equals(method)) {
            request.invoke(client);
        } else {
            // AWS Apache Http Client only supports content on PATCH, POST & PUT requests.
            // See:
            // https://github.com/aws/aws-sdk-java-v2/blob/master/http-clients/apache-client/src/main/java/software/amazon/awssdk/http/apache/internal/impl/ApacheHttpRequestFactory.java#L118-L137
            assertThrows(
                "AWS SDK's ApacheHttpClient does not support request bodies for HTTP method `"
                    + method
                    + "`. Please use a different SdkHttpClient implementation.",
                TransportException.class,
                () -> request.invoke(client)
            );
            return;
        }

        assertEquals(1, receivedRequests.size());
        ReceivedRequest req = receivedRequests.poll();
        assertNotNull(req);

        assertEquals(method, req.getMethod());
        assertEquals(requestUri, req.getRequestUri());

        assertEquals(contentLength, req.body.length);
        assertEquals(contentSha256, sha256Hex(req.body));

        String signedHeaders = "host;x-amz-content-sha256;x-amz-date";

        if (contentLength > 0) {
            assertEquals(APPLICATION_JSON.getMimeType(), req.getHeader(CONTENT_TYPE));
            signedHeaders = "content-type;" + signedHeaders;
        }

        String expectedContentLength = String.valueOf(contentLength);
        if (contentLength == 0
            && (sdkHttpClientType == SdkHttpClientType.AWS_CRT
                || sdkHttpClientType == SdkHttpClientType.NETTY_NIO_ASYNC
                || sdkHttpClientType == SdkHttpClientType.URL_CONNECTION)) {
            // AWS CRT, Netty NIO and URLConnection clients do not set content-length for empty bodies
            expectedContentLength = null;
        }

        String contentLengthHdr = req.getHeader(CONTENT_LENGTH);
        assertEquals(expectedContentLength, contentLengthHdr);

        assertEquals(serviceHostName, req.getHeader("Host"));
        assertEquals("20230113T160837Z", req.getHeader("x-amz-date"));
        assertEquals(contentSha256, req.getHeader("x-amz-content-sha256"));
        assertEquals(
            "AWS4-HMAC-SHA256 Credential=test-access-key/20230113/ap-southeast-2/"
                + serviceName
                + "/aws4_request, SignedHeaders="
                + signedHeaders
                + ", Signature="
                + expectedSignature,
            req.getHeader("Authorization")
        );
    }

    private String selectExpectedSignature(String aossSig, String esSig, String arbitrarySig) {
        switch (serviceName) {
            case "aoss":
                return aossSig;
            case "es":
                return esSig;
            case "arbitrary":
                return arbitrarySig;
            default:
                throw new IllegalArgumentException("Unknown service name: " + serviceName);
        }
    }

    private static String sha256Hex(byte[] data) throws NoSuchAlgorithmException {
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(data, 0, data.length);
        byte[] hash = digest.digest();
        return Hex.toHexString(hash);
    }

    @FunctionalInterface
    private interface OpenSearchClientAction {
        void invoke(OpenSearchClient client) throws Exception;
    }
}
