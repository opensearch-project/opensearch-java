/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.IOException;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import javax.annotation.CheckForNull;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.opensearch.OpenSearchAsyncClient;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch._types.SortOptions;
import org.opensearch.client.opensearch._types.SortOrder;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.indices.CreateIndexRequest;
import org.opensearch.client.opensearch.indices.IndexState;
import org.opensearch.client.opensearch.indices.OpenSearchIndicesClient;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.transport.aws.AwsSdk2Transport;
import org.opensearch.client.transport.aws.AwsSdk2TransportOptions;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.http.async.SdkAsyncHttpClient;
import software.amazon.awssdk.http.crt.AwsCrtAsyncHttpClient;
import software.amazon.awssdk.regions.Region;

public abstract class AwsSdk2TransportTestCase {
    public static final String TEST_INDEX = "opensearch-java-integtest";

    private static SdkAsyncHttpClient asyncHttpClient;
    private static SdkHttpClient httpClient;

    @Before
    public void checkConfig() {
        String host = getTestClusterHost();
        Assume.assumeTrue("AWS test cluster not configured", host != null && !host.isEmpty());
    }

    protected SdkAsyncHttpClient getAsyncHttpClient() {
        if (asyncHttpClient == null) {
            asyncHttpClient = AwsCrtAsyncHttpClient.create();
        }
        return asyncHttpClient;
    }

    protected SdkHttpClient getHttpClient() {
        if (httpClient == null) {
            httpClient = ApacheHttpClient.create();
        }
        return httpClient;
    }

    protected AwsSdk2TransportOptions.Builder getTransportOptions() {
        return AwsSdk2TransportOptions.builder();
    }

    protected OpenSearchClient getClient(boolean async, @CheckForNull JsonpMapper mapper, @CheckForNull TransportOptions options) {

        AwsSdk2Transport transport;
        if (async) {
            transport = new AwsSdk2Transport(
                getAsyncHttpClient(),
                getTestClusterHost(),
                getTestClusterServiceName(),
                getTestClusterRegion(),
                getTransportOptions().build()
            );
        } else {
            transport = new AwsSdk2Transport(
                getHttpClient(),
                getTestClusterHost(),
                getTestClusterServiceName(),
                getTestClusterRegion(),
                getTransportOptions().build()
            );
        }
        return new OpenSearchClient(transport);
    }

    protected OpenSearchAsyncClient getAsyncClient(
        boolean async,
        @CheckForNull JsonpMapper mapper,
        @CheckForNull TransportOptions options
    ) {

        AwsSdk2Transport transport;
        if (async) {
            transport = new AwsSdk2Transport(
                getAsyncHttpClient(),
                getTestClusterHost(),
                getTestClusterServiceName(),
                getTestClusterRegion(),
                getTransportOptions().build()
            );
        } else {
            transport = new AwsSdk2Transport(
                getHttpClient(),
                getTestClusterHost(),
                getTestClusterServiceName(),
                getTestClusterRegion(),
                getTransportOptions().build()
            );
        }
        return new OpenSearchAsyncClient(transport);
    }

    protected OpenSearchIndicesClient getIndexesClient(
        boolean async,
        @CheckForNull JsonpMapper mapper,
        @CheckForNull TransportOptions options
    ) {

        AwsSdk2Transport transport;
        if (async) {
            transport = new AwsSdk2Transport(
                getAsyncHttpClient(),
                getTestClusterHost(),
                getTestClusterServiceName(),
                getTestClusterRegion(),
                getTransportOptions().build()
            );
        } else {
            transport = new AwsSdk2Transport(
                getHttpClient(),
                getTestClusterHost(),
                getTestClusterServiceName(),
                getTestClusterRegion(),
                getTransportOptions().build()
            );
        }
        return new OpenSearchIndicesClient(transport);
    }

    protected String getTestClusterHost() {
        String cluster = System.getProperty("tests.awsSdk2support.domainHost");
        return cluster;
    }

    protected String getTestClusterServiceName() {
        String cluster = System.getProperty("tests.awsSdk2support.serviceName");
        return cluster;
    }

    protected Region getTestClusterRegion() {
        String region = System.getProperty("tests.awsSdk2support.domainRegion");
        return region != null ? Region.of(region) : Region.US_EAST_1;
    }

    @AfterClass
    public static void cleanupClients() throws IOException {
        if (httpClient != null) {
            try {
                httpClient.close();
                httpClient = null;
            } catch (Throwable e) {
                // Not our problem
            }
        }
        if (asyncHttpClient != null) {
            try {
                asyncHttpClient.close();
                asyncHttpClient = null;
            } catch (Throwable e) {
                // Not our problem
            }
        }
    }

    public SimplePojo getLongDoc(String title, int minSize) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < minSize) {
            int len = sb.length();
            if (len < 1) {
                sb.append("The length of this content is " + len + "...\n");
            } else {
                sb.append("Oh, wait... now it's " + len + "...\n");
            }
        }
        return new SimplePojo(title, sb.toString());
    }

    public void resetTestIndex(boolean async) throws Exception {
        OpenSearchIndicesClient client = getIndexesClient(async, null, null);
        boolean indexExists = false;
        try {
            IndexState indexInfo = client.get(b -> b.index(TEST_INDEX)).get(TEST_INDEX);
            if (indexInfo != null) {
                indexExists = true;
            }
        } catch (OpenSearchException e) {
            if (e.status() != 404) {
                throw e;
            }
        }
        if (indexExists) {
            client.delete(b -> b.index(Collections.singletonList(TEST_INDEX)));
        }
        final CreateIndexRequest.Builder req = new CreateIndexRequest.Builder().index(TEST_INDEX);
        client.create(req.build());
    }

    protected SearchResponse<SimplePojo> query(OpenSearchClient client, String title, String text) throws Exception {
        final Query query = Query.of(qb -> {
            if (title != null) {
                qb.match(mb -> mb.field("title").query(vb -> vb.stringValue(title)));
            }
            if (text != null) {
                qb.match(mb -> mb.field("text").query(vb -> vb.stringValue(text)));
            }
            return qb;
        });
        final SearchRequest.Builder req = new SearchRequest.Builder().allowPartialSearchResults(false)
            .index(Collections.singletonList(TEST_INDEX))
            .size(10)
            .ignoreThrottled(false)
            .sort(
                new SortOptions.Builder().score(o -> o.order(SortOrder.Desc)).build(),
                new SortOptions.Builder().doc(o -> o.order(SortOrder.Desc)).build()
            )
            .query(query);

        return client.search(req.build(), SimplePojo.class);
    }

    protected CompletableFuture<SearchResponse<SimplePojo>> query(OpenSearchAsyncClient client, String title, String text) {
        Query query = Query.of(qb -> {
            if (title != null) {
                qb.match(mb -> mb.field("title").query(vb -> vb.stringValue(title)));
            }
            if (text != null) {
                qb.match(mb -> mb.field("text").query(vb -> vb.stringValue(text)));
            }
            return qb;
        });
        final SearchRequest.Builder req = new SearchRequest.Builder().allowPartialSearchResults(false)
            .index(Collections.singletonList(TEST_INDEX))
            .size(10)
            .ignoreThrottled(false)
            .sort(
                new SortOptions.Builder().score(o -> o.order(SortOrder.Desc)).build(),
                new SortOptions.Builder().doc(o -> o.order(SortOrder.Desc)).build()
            )
            .query(query);

        try {
            return client.search(req.build(), SimplePojo.class);
        } catch (Exception e) {
            final CompletableFuture<SearchResponse<SimplePojo>> failed = new CompletableFuture<>();
            failed.completeExceptionally(e);
            return failed;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SimplePojo {
        final String title;
        final String text;

        public SimplePojo(@JsonProperty("title") String title, @JsonProperty("text") String text) {
            this.title = title;
            this.text = text;
        }

        @Override
        public int hashCode() {
            return Objects.hash(getClass(), title, text);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj.getClass() != getClass()) {
                return false;
            }
            SimplePojo other = (SimplePojo) obj;
            return Objects.equals(title, other.title) && Objects.equals(text, other.text);
        }

        @JsonProperty("title")
        public String getTitle() {
            return title;
        }

        @JsonProperty("text")
        public String getText() {
            return text;
        }
    }
}
