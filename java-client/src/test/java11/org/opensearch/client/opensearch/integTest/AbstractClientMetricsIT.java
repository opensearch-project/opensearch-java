/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import static org.awaitility.Awaitility.await;

import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.Timer;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.hc.client5.http.HttpHostConnectException;
import org.apache.http.HttpHost;
import org.opensearch.client.opensearch.OpenSearchAsyncClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch.cluster.HealthRequest;
import org.opensearch.client.opensearch.cluster.HealthResponse;
import org.opensearch.client.opensearch.core.CreateRequest;
import org.opensearch.client.opensearch.core.IndexRequest;
import org.opensearch.client.opensearch.core.IndexResponse;
import org.opensearch.client.opensearch.core.UpdateRequest;
import org.opensearch.client.opensearch.core.UpdateResponse;
import org.opensearch.client.opensearch.integTest.AbstractCrudIT.AppData;
import org.opensearch.client.transport.client_metrics.MetricGroup;
import org.opensearch.client.transport.client_metrics.MetricName;
import org.opensearch.client.transport.client_metrics.MetricTag;
import org.opensearch.client.transport.client_metrics.TelemetryMetricsManager;
import org.opensearch.client.transport.httpclient5.ResponseException;
import org.opensearch.common.settings.Settings;

public abstract class AbstractClientMetricsIT extends OpenSearchJavaClientTestCase {
    private static final HttpHost[] BAD_HOSTS = new HttpHost[] { new HttpHost("localhost", 9201), new HttpHost("localhost", 9202) };
    private static final List<String> ALL_GROUPS = MetricGroup.ALL.stream().map(Enum::toString).collect(Collectors.toList());
    private static final Settings ALL_METRIC_GROUP_SETTING = Settings.builder().putList(METRICS_GROUPS, ALL_GROUPS).build();

    public void testDefaultMetricGroup() throws IOException {
        TelemetryMetricsManager.addRegistry(getStubRegistry());
        Future<HealthResponse> clusterHealthFuture = getCustomAsyncClient(getDefaultHosts(), restClientSettingsWithMetrics(Settings.EMPTY))
                .cluster()
                .health();
        await().atMost(2, TimeUnit.SECONDS).until(clusterHealthFuture::isDone);
        assertEquals(
                1,
                findMeter(
                        getStubRegistry(),
                        MetricName.REQUEST.toString(),
                        Tags.of(MetricTag.REQUEST.toString(), HealthRequest.class.getSimpleName())
                ).size()
        );
        assertEquals(1, findMeter(getStubRegistry(), MetricName.ACTIVE_NODES.toString(), Tags.empty()).size());
        assertEquals(1, findMeter(getStubRegistry(), MetricName.INACTIVE_NODES.toString(), Tags.empty()).size());
    }

    public void testAllMetricGroups() throws IOException {
        TelemetryMetricsManager.addRegistry(getStubRegistry());
        String index = "index_metrics";
        String id = UUID.randomUUID().toString();
        AppData appData = new AppData();
        appData.setMsg("testMetrics");
        Future<IndexResponse> indexFuture = getCustomAsyncClient(getDefaultHosts(), restClientSettingsWithMetrics(ALL_METRIC_GROUP_SETTING))
                .index(b -> b.index(index).id(id).document(appData).refresh(Refresh.True));
        await().atMost(2, TimeUnit.SECONDS).until(indexFuture::isDone);

        assertEquals(
                1,
                findMeter(
                        getStubRegistry(),
                        MetricName.REQUEST.toString(),
                        Tags.of(MetricTag.REQUEST.toString(), IndexRequest.class.getSimpleName())
                ).size()
        );
        assertEquals(1, findMeter(getStubRegistry(), MetricName.ACTIVE_NODES.toString(), Tags.empty()).size());
        assertEquals(1, findMeter(getStubRegistry(), MetricName.INACTIVE_NODES.toString(), Tags.empty()).size());
        assertEquals(
                1,
                findMeter(
                        getStubRegistry(),
                        MetricName.NETWORK_REQUEST.toString(),
                        Tags.of(MetricTag.REQUEST.toString(), IndexRequest.class.getSimpleName())
                ).size()
        );
        assertEquals(
                1,
                findMeter(
                        getStubRegistry(),
                        MetricName.RESPONSE_PAYLOAD_SIZE.toString(),
                        Tags.of(MetricTag.REQUEST.toString(), IndexRequest.class.getSimpleName())
                ).size()
        );
        assertEquals(
                1,
                findMeter(
                        getStubRegistry(),
                        MetricName.REQUEST_PAYLOAD_SIZE.toString(),
                        Tags.of(MetricTag.REQUEST.toString(), IndexRequest.class.getSimpleName())
                ).size()
        );
    }

    public void testRequestMetricResponse() throws IOException {
        TelemetryMetricsManager.addRegistry(getStubRegistry());
        Future<HealthResponse> clusterHealthFuture = getCustomAsyncClient(
                getDefaultHosts(),
                restClientSettingsWithMetrics(ALL_METRIC_GROUP_SETTING)
        ).cluster().health();
        await().atMost(2, TimeUnit.SECONDS).until(clusterHealthFuture::isDone);
        List<Meter> meter = findMeter(
                getStubRegistry(),
                MetricName.REQUEST.toString(),
                Tags.of(MetricTag.REQUEST.toString(), HealthRequest.class.getSimpleName())
        );
        assertEquals(1, meter.size());
        Meter clusterHealthMeter = meter.get(0);

        meter = findMeter(
                getStubRegistry(),
                MetricName.NETWORK_REQUEST.toString(),
                Tags.of(MetricTag.REQUEST.toString(), HealthRequest.class.getSimpleName())
        );
        assertEquals(1, meter.size());
        Meter clusterHealthNetworkMeter = meter.get(0);

        for (Meter requestMeter : Arrays.asList(clusterHealthMeter, clusterHealthNetworkMeter)) {
            String statusCodeTag = requestMeter.getId().getTag(MetricTag.STATUS_CODE_OR_EXCEPTION.toString());
            assertEquals(1, ((Timer) requestMeter).count());
            assertEquals("200", statusCodeTag);
        }

        String[] hostsContacted = clusterHealthMeter.getId().getTag(MetricTag.HOST_CONTACTED.toString()).split(",");
        assertArrayEquals(new String[] { getTestRestCluster() }, hostsContacted);
        String hostContacted = clusterHealthNetworkMeter.getId().getTag(MetricTag.HOST.toString());
        assertEquals(getTestRestCluster(), hostContacted);
    }

    public void testRequestMetricResponseExceptionThrown() throws IOException, ExecutionException, InterruptedException {
        TelemetryMetricsManager.addRegistry(getStubRegistry());
        String index = "index_metrics";
        OpenSearchAsyncClient client = getCustomAsyncClient(getDefaultHosts(), restClientSettingsWithMetrics(ALL_METRIC_GROUP_SETTING));
        // Force 409
        String id = UUID.randomUUID().toString();
        AppData appData = new AppData();
        appData.setMsg("testRequestMetricResponseException");
        client.index(b -> b.index(index).id(id).document(appData).refresh(Refresh.True)).get();
        try {
            CreateRequest<AppData> duplicateCreateRequest = new CreateRequest.Builder<AppData>().index(index)
                    .id(id)
                    .document(appData)
                    .build();
            client.create(duplicateCreateRequest).get();
            fail("Should have failed due to version conflict");
        } catch (ExecutionException e) {
            if (e.getCause() instanceof ResponseException) {
                assertTrue(e.getMessage().contains("version conflict"));
            } else {
                fail("Unrecognized cause: " + e.getCause());
            }
        }
        // Check metrics
        List<Meter> meter = findMeter(
                getStubRegistry(),
                MetricName.REQUEST.toString(),
                Tags.of(MetricTag.REQUEST.toString(), CreateRequest.class.getSimpleName())
        );
        assertEquals(1, meter.size());
        Timer createMeter = (Timer) meter.get(0);

        meter = findMeter(
                getStubRegistry(),
                MetricName.NETWORK_REQUEST.toString(),
                Tags.of(MetricTag.REQUEST.toString(), CreateRequest.class.getSimpleName())
        );
        assertEquals(1, meter.size());
        Timer createNetworkMeter = (Timer) meter.get(0);

        for (Timer requestMeter : Arrays.asList(createMeter, createNetworkMeter)) {
            String statusCodeTag = requestMeter.getId().getTag(MetricTag.STATUS_CODE_OR_EXCEPTION.toString());
            assertEquals("409", statusCodeTag);
            assertEquals(1, requestMeter.count());
        }

        String[] hostsContacted = createMeter.getId().getTag(MetricTag.HOST_CONTACTED.toString()).split(",");
        assertArrayEquals(new String[] { getTestRestCluster() }, hostsContacted);

        String hostContacted = createNetworkMeter.getId().getTag(MetricTag.HOST.toString());
        assertEquals(getTestRestCluster(), hostContacted);
    }

    public void testRequestMetricResponseExceptionHandled() throws IOException, InterruptedException {
        TelemetryMetricsManager.addRegistry(getStubRegistry());
        String malformedIndexName = "index_Metrics";
        // Force 400 for SimpleEndpoint
        String id = UUID.randomUUID().toString();
        AppData appData = new AppData();
        appData.setMsg("testRequestMetricResponseExceptionHandled");
        try {
            getCustomAsyncClient(getDefaultHosts(), restClientSettingsWithMetrics(ALL_METRIC_GROUP_SETTING)).index(
                    b -> b.index(malformedIndexName).id(id).document(appData).refresh(Refresh.True)
            ).get();
            fail("Should have failed due to invalid index name");
        } catch (ExecutionException e) {
            if (e.getCause() instanceof OpenSearchException) {
                assertTrue(e.getMessage().contains("invalid_index_name_exception"));
            } else {
                fail("Unrecognized cause: " + e.getCause());
            }
        }
        // Check metrics
        List<Meter> meter = findMeter(
                getStubRegistry(),
                MetricName.REQUEST.toString(),
                Tags.of(MetricTag.REQUEST.toString(), IndexRequest.class.getSimpleName())
        );
        assertEquals(1, meter.size());
        Timer indexMeter = (Timer) meter.get(0);

        meter = findMeter(
                getStubRegistry(),
                MetricName.NETWORK_REQUEST.toString(),
                Tags.of(MetricTag.REQUEST.toString(), IndexRequest.class.getSimpleName())
        );
        assertEquals(1, meter.size());
        Timer indexNetworkMeter = (Timer) meter.get(0);

        for (Timer requestMeter : Arrays.asList(indexMeter, indexNetworkMeter)) {
            String statusCodeTag = requestMeter.getId().getTag(MetricTag.STATUS_CODE_OR_EXCEPTION.toString());
            assertEquals("400", statusCodeTag);
            assertEquals(1, requestMeter.count());
        }

        String[] hostsContacted = indexMeter.getId().getTag(MetricTag.HOST_CONTACTED.toString()).split(",");
        assertArrayEquals(new String[] { getTestRestCluster() }, hostsContacted);

        String hostContacted = indexNetworkMeter.getId().getTag(MetricTag.HOST.toString());
        assertEquals(getTestRestCluster(), hostContacted);
    }

    public void testRequestMetricExceptionThrown() throws IOException, InterruptedException {
        TelemetryMetricsManager.addRegistry(getStubRegistry());
        String indexName = "index_metrics";
        // Force HttpHostConnectException
        String id = UUID.randomUUID().toString();
        AppData appData = new AppData();
        appData.setMsg("testRequestMetricClientExceptionThrown");

        try {
            getCustomAsyncClient(BAD_HOSTS, restClientSettingsWithMetrics(ALL_METRIC_GROUP_SETTING)).index(
                    b -> b.index(indexName).id(id).document(appData).refresh(Refresh.True)
            ).get();
            fail("Should have failed due to bad host");
        } catch (ExecutionException e) {
            System.out.println("Caught " + e.getMessage());
            if (!(e.getCause() instanceof HttpHostConnectException)) {
                fail("Recognized cause: " + e.getCause());
            }
        }
        // Check metric
        List<Meter> meter = findMeter(
                getStubRegistry(),
                MetricName.REQUEST.toString(),
                Tags.of(MetricTag.REQUEST.toString(), IndexRequest.class.getSimpleName())
        );
        assertEquals(1, meter.size());
        Timer indexMeter = (Timer) meter.get(0);

        meter = findMeter(
                getStubRegistry(),
                MetricName.NETWORK_REQUEST.toString(),
                Tags.of(MetricTag.REQUEST.toString(), IndexRequest.class.getSimpleName())
        );
        assertEquals(2, meter.size());

        for (Timer requestMeter : Arrays.asList(indexMeter, (Timer) meter.get(0), (Timer) meter.get(1))) {
            String statusCodeTag = requestMeter.getId().getTag(MetricTag.STATUS_CODE_OR_EXCEPTION.toString());
            assertEquals("ClientError-HttpHostConnectException", statusCodeTag);
            assertEquals(1, requestMeter.count());
        }

        String[] hostsContacted = indexMeter.getId().getTag(MetricTag.HOST_CONTACTED.toString()).split(",");
        String[] expectedHosts = new String[] { "localhost:9201", "localhost:9202" };
        assertArrayEquals(expectedHosts, hostsContacted);

        List<String> networkContactedHosts = new ArrayList<>(List.of(expectedHosts));
        networkContactedHosts.remove(meter.get(0).getId().getTag(MetricTag.HOST.toString()));
        networkContactedHosts.remove(meter.get(1).getId().getTag(MetricTag.HOST.toString()));
        assertTrue(networkContactedHosts.isEmpty());
    }

    public void testNodeGauges() throws InterruptedException, IOException {
        TelemetryMetricsManager.addRegistry(getStubRegistry());
        String clientID = "badHostClient";
        OpenSearchAsyncClient client = getCustomAsyncClient(
                BAD_HOSTS,
                restClientSettingsWithMetrics(Settings.builder().put(CUSTOM_CLIENT_ID, clientID).put(ALL_METRIC_GROUP_SETTING).build())
        );
        // Verify active nodes
        List<Meter> activeNodeMeter = findMeter(
                getStubRegistry(),
                MetricName.ACTIVE_NODES.toString(),
                Tags.of(MetricTag.CLIENT_ID.toString(), clientID)
        );
        assertEquals(1, activeNodeMeter.size());
        assertEquals(2, ((Gauge) activeNodeMeter.get(0)).value(), 0);
        // Verify inactive nodes
        List<Meter> inactiveNodeMeter = findMeter(
                getStubRegistry(),
                MetricName.INACTIVE_NODES.toString(),
                Tags.of(MetricTag.CLIENT_ID.toString(), clientID)
        );
        assertEquals(1, inactiveNodeMeter.size());
        assertEquals(0, ((Gauge) inactiveNodeMeter.get(0)).value(), 0);

        // Force HttpHostConnectException
        String indexName = "index_metrics";
        String id = UUID.randomUUID().toString();
        AppData appData = new AppData();
        appData.setMsg("testRequestMetricClientExceptionThrown");
        try {
            client.index(b -> b.index(indexName).id(id).document(appData).refresh(Refresh.True)).get();
            fail("Should have failed due to bad host");
        } catch (ExecutionException | IOException e) {
            System.out.println("Caught " + e.getMessage());
            if (!(e.getCause() instanceof HttpHostConnectException)) {
                fail("Recognized cause: " + e.getCause());
            }
        }

        // Verify active nodes
        activeNodeMeter = findMeter(
                getStubRegistry(),
                MetricName.ACTIVE_NODES.toString(),
                Tags.of(MetricTag.CLIENT_ID.toString(), clientID)
        );
        assertEquals(1, activeNodeMeter.size());
        assertEquals(0, ((Gauge) activeNodeMeter.get(0)).value(), 0);
        // Verify inactive nodes
        inactiveNodeMeter = findMeter(
                getStubRegistry(),
                MetricName.INACTIVE_NODES.toString(),
                Tags.of(MetricTag.CLIENT_ID.toString(), clientID)
        );
        assertEquals(1, inactiveNodeMeter.size());
        assertEquals(2, ((Gauge) inactiveNodeMeter.get(0)).value(), 0);
    }

    public void testPayloadSize() throws IOException {
        TelemetryMetricsManager.addRegistry(getStubRegistry());
        String clientID = "compressingClient";
        OpenSearchAsyncClient client = getCustomAsyncClient(
                Stream.concat(Arrays.stream(BAD_HOSTS), Arrays.stream(getDefaultHosts())).toArray(HttpHost[]::new),
                restClientSettingsWithMetrics(Settings.builder().put(CUSTOM_CLIENT_ID, clientID).put(ALL_METRIC_GROUP_SETTING).build())
        );
        String index = "index_metrics";
        String id = UUID.randomUUID().toString();

        // Index
        AppData appData = new AppData();
        appData.setMsg(generatePayload(500));
        Future<IndexResponse> indexFuture = client.index(b -> b.index(index).id(id).document(appData).refresh(Refresh.True));
        await().atMost(Duration.ofSeconds(2)).until(indexFuture::isDone);
        DistributionSummary indexRequestPayload = (DistributionSummary) findMeter(
                getStubRegistry(),
                MetricName.REQUEST_PAYLOAD_SIZE.toString(),
                Tags.of(MetricTag.CLIENT_ID.toString(), clientID, MetricTag.REQUEST.toString(), IndexRequest.class.getSimpleName())
        ).get(0);
        assertTrue(500 <= indexRequestPayload.max() && indexRequestPayload.max() <= 600);
        assertEquals(1, indexRequestPayload.count());
        DistributionSummary indexResponsePayload = (DistributionSummary) findMeter(
                getStubRegistry(),
                MetricName.RESPONSE_PAYLOAD_SIZE.toString(),
                Tags.of(MetricTag.CLIENT_ID.toString(), clientID, MetricTag.REQUEST.toString(), IndexRequest.class.getSimpleName())
        ).get(0);
        assertEquals(1, indexResponsePayload.count());

        // Update
        appData.setMsg(generatePayload(5 * 1024));
        CompletableFuture<UpdateResponse<AppData>> updateFuture = client.update(b -> b.doc(appData).index(index).id(id), AppData.class);
        await().atMost(Duration.ofSeconds(2)).until(updateFuture::isDone);
        DistributionSummary updateRequestPayload = (DistributionSummary) findMeter(
                getStubRegistry(),
                MetricName.REQUEST_PAYLOAD_SIZE.toString(),
                Tags.of(MetricTag.CLIENT_ID.toString(), clientID, MetricTag.REQUEST.toString(), UpdateRequest.class.getSimpleName())
        ).get(0);
        assertTrue(5 * 1024 <= updateRequestPayload.max() && updateRequestPayload.max() <= (5 * 1024 + 100));
        assertEquals(1, updateRequestPayload.count());
        DistributionSummary updateResponsePayload = (DistributionSummary) findMeter(
                getStubRegistry(),
                MetricName.RESPONSE_PAYLOAD_SIZE.toString(),
                Tags.of(MetricTag.CLIENT_ID.toString(), clientID, MetricTag.REQUEST.toString(), UpdateRequest.class.getSimpleName())
        ).get(0);
        assertTrue(updateResponsePayload.max() > 0);
        assertEquals(1, updateResponsePayload.count());
    }

    public void testNoRequestPayloadSizeCompressionEnabled() throws IOException {
        TelemetryMetricsManager.addRegistry(getStubRegistry());
        String clientID = "compressingClient";
        OpenSearchAsyncClient client = getCustomAsyncClient(
                getDefaultHosts(),
                restClientSettingsWithMetrics(
                        Settings.builder().put(CUSTOM_CLIENT_ID, clientID).put(ALL_METRIC_GROUP_SETTING).put(COMPRESSION_ENABLED, true).build()
                )
        );
        String index = "index_metrics";
        String id = UUID.randomUUID().toString();
        AppData appData = new AppData();
        appData.setMsg(generatePayload(5 * 1024));
        Future<IndexResponse> indexFuture = client.index(b -> b.index(index).id(id).document(appData).refresh(Refresh.True));
        await().atMost(Duration.ofSeconds(2)).until(indexFuture::isDone);
        assertTrue(
                findMeter(
                        getStubRegistry(),
                        MetricName.REQUEST_PAYLOAD_SIZE.toString(),
                        Tags.of(MetricTag.CLIENT_ID.toString(), clientID, MetricTag.REQUEST.toString(), IndexRequest.class.getSimpleName())
                ).isEmpty()
        );
    }

    private List<Meter> findMeter(MeterRegistry registry, String meterName, Tags tags) {
        return registry.getMeters().stream().filter(meter -> {
            if (meter.getId().getName().equals(meterName)) {
                if (tags != null && !tags.equals(Tags.empty())) {
                    for (Tag tag : tags) {
                        String tagValue = meter.getId().getTag(tag.getKey());
                        if (tagValue == null || !tagValue.equalsIgnoreCase(tag.getValue())) {
                            return false;
                        }
                    }
                }
                return true;
            }
            return false;
        }).collect(Collectors.toList());
    }

    private String generatePayload(int numBytes) {
        if (numBytes < 0) {
            throw new IllegalArgumentException("Negative payload size");
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numBytes; i++) {
            builder.append("o");
        }
        return builder.toString();
    }
}