package org.opensearch.client.transport.client_metrics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import java.io.IOException;
import java.net.http.HttpConnectTimeoutException;
import java.time.Duration;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opensearch.client.transport.TransportException;

public class TelemetryMetricsManagerTest {
    private MeterRegistry stubRegistry;

    @Before
    public void setUp() {
        stubRegistry = new SimpleMeterRegistry();
        TelemetryMetricsManager.addRegistry(stubRegistry);
    }

    @After
    public void cleanUp() {
        TelemetryMetricsManager.removeRegistry(stubRegistry);
    }

    @Test
    public void testRecordingRequestMetric() {
        String requestName = "testRequest";
        RequestMetricContext context = new RequestMetricContext();
        Duration totalExecLatency = Duration.ofMillis(100);
        Duration errorLatency = Duration.ofMillis(1);
        MeterOptions meterOptions = new MeterOptions(new double[] { 0.80, 0.85 }, Tags.of("CommonTag", "CommonTagValue"), null);
        context.setRequestExecutionTime(totalExecLatency);
        context.setStatusCode(200);
        context.addNetworkRequestContext(
                new NetworkRequestMetricContext("localhost", new HttpConnectTimeoutException("error"), -1, errorLatency)
        );
        context.addNetworkRequestContext(new NetworkRequestMetricContext("localhost2", null, 200, totalExecLatency.minus(errorLatency)));

        TelemetryMetricsManager.recordRequestMetrics(requestName, meterOptions, context, MetricGroup.ALL);

        // Verify REQUEST meter
        Optional<Meter> meter = findMeter(stubRegistry, MetricName.REQUEST.toString(), Tags.of(MetricTag.REQUEST.toString(), requestName));
        assertFalse(meter.isEmpty());
        Timer requestMeter = (Timer) meter.get();
        assertEquals(requestName, requestMeter.getId().getTag(MetricTag.REQUEST.toString()));
        assertEquals("200", requestMeter.getId().getTag(MetricTag.STATUS_CODE_OR_EXCEPTION.toString()));
        assertEquals("localhost,localhost2", requestMeter.getId().getTag(MetricTag.HOST_CONTACTED.toString()));
        assertEquals("CommonTagValue", requestMeter.getId().getTag("CommonTag"));
        assertEquals(totalExecLatency.toMillis(), requestMeter.totalTime(TimeUnit.MILLISECONDS), 0);
        assertEquals(1, requestMeter.count());

        // Verify NETWORK_REQUEST meter
        List<Meter> meters = findMeters(
                stubRegistry,
                MetricName.NETWORK_REQUEST.toString(),
                Tags.of(MetricTag.REQUEST.toString(), requestName)
        );
        Set<String> hosts = new HashSet<>(Arrays.asList("localhost", "localhost2"));
        assertEquals(2, meters.size());
        for (Meter networkRequestMeter : meters) {
            assertEquals(requestName, networkRequestMeter.getId().getTag(MetricTag.REQUEST.toString()));
            assertEquals("CommonTagValue", networkRequestMeter.getId().getTag("CommonTag"));
            assertEquals(1, ((Timer) networkRequestMeter).count());

            String host = networkRequestMeter.getId().getTag(MetricTag.HOST.toString());
            assertNotNull(host);
            hosts.remove(host);
            String status = networkRequestMeter.getId().getTag(MetricTag.STATUS_CODE_OR_EXCEPTION.toString());
            if (host.equals("localhost")) {
                assertEquals("ClientError-HttpConnectTimeoutException", status);
                assertEquals(errorLatency.toMillis(), ((Timer) networkRequestMeter).totalTime(TimeUnit.MILLISECONDS), 0);
            } else {
                assertEquals("200", status);
                assertEquals(
                        totalExecLatency.minus(errorLatency).toMillis(),
                        ((Timer) networkRequestMeter).totalTime(TimeUnit.MILLISECONDS),
                        0
                );
            }
        }
        assertTrue("There are unaccounted hosts", hosts.isEmpty());
    }

    @Test
    public void testRecordingRequestMetricWithExceptionNoStatus() {
        String requestName = "testRequest";
        RequestMetricContext context = new RequestMetricContext();
        MeterOptions meterOptions = new MeterOptions(new double[] { 0.80, 0.85 }, Tags.of("CommonTag", "CommonTagValue"), null);
        context.setRequestExecutionTime(Duration.ofMillis(50));
        context.setThrowable(new IOException("IO Errors"));
        context.addNetworkRequestContext(
                new NetworkRequestMetricContext("localhost", new IOException("IO Errors"), -1, Duration.ofMillis(1))
        );

        TelemetryMetricsManager.recordRequestMetrics(requestName, meterOptions, context, MetricGroup.ALL);

        // Verify REQUEST meter
        Optional<Meter> meter = findMeter(stubRegistry, MetricName.REQUEST.toString(), Tags.of(MetricTag.REQUEST.toString(), requestName));
        assertFalse(meter.isEmpty());
        Timer requestMeter = (Timer) meter.get();
        assertEquals(requestName, requestMeter.getId().getTag(MetricTag.REQUEST.toString()));
        assertEquals("ClientError-IOException", requestMeter.getId().getTag(MetricTag.STATUS_CODE_OR_EXCEPTION.toString()));
        assertEquals("localhost", requestMeter.getId().getTag(MetricTag.HOST_CONTACTED.toString()));
        assertEquals("CommonTagValue", requestMeter.getId().getTag("CommonTag"));

        // Verify NETWORK_REQUEST meter
        meter = findMeter(stubRegistry, MetricName.NETWORK_REQUEST.toString(), Tags.of(MetricTag.REQUEST.toString(), requestName));
        assertFalse(meter.isEmpty());
        Timer networkRequestMeter = (Timer) meter.get();
        assertEquals("localhost", networkRequestMeter.getId().getTag(MetricTag.HOST.toString()));
        assertEquals(requestName, networkRequestMeter.getId().getTag(MetricTag.REQUEST.toString()));
        assertEquals("ClientError-IOException", networkRequestMeter.getId().getTag(MetricTag.STATUS_CODE_OR_EXCEPTION.toString()));
        assertEquals("CommonTagValue", networkRequestMeter.getId().getTag("CommonTag"));
    }

    @Test
    public void testRecordingRequestMetricWithBothStatusAndException() {
        String requestName = "testRequest";
        RequestMetricContext context = new RequestMetricContext();
        MeterOptions meterOptions = new MeterOptions(new double[] { 0.80, 0.85 }, Tags.of("CommonTag", "CommonTagValue"), null);
        context.setRequestExecutionTime(Duration.ofMillis(150));
        context.setStatusCode(409);
        context.setThrowable(new TransportException("Error"));
        context.addNetworkRequestContext(
                new NetworkRequestMetricContext("localhost", new TransportException("Error"), 409, Duration.ofMillis(1))
        );

        TelemetryMetricsManager.recordRequestMetrics(requestName, meterOptions, context, MetricGroup.ALL);

        // Verify REQUEST meter
        Optional<Meter> meter = findMeter(stubRegistry, MetricName.REQUEST.toString(), Tags.of(MetricTag.REQUEST.toString(), requestName));
        assertFalse(meter.isEmpty());
        Timer testMeter = (Timer) meter.get();
        assertEquals(requestName, testMeter.getId().getTag(MetricTag.REQUEST.toString()));
        assertEquals("409", testMeter.getId().getTag(MetricTag.STATUS_CODE_OR_EXCEPTION.toString()));
        assertEquals("localhost", testMeter.getId().getTag(MetricTag.HOST_CONTACTED.toString()));
        assertEquals("CommonTagValue", testMeter.getId().getTag("CommonTag"));

        // Verify NETWORK_REQUEST meter
        meter = findMeter(stubRegistry, MetricName.NETWORK_REQUEST.toString(), Tags.of(MetricTag.REQUEST.toString(), requestName));
        assertFalse(meter.isEmpty());
        Timer networkRequestMeter = (Timer) meter.get();
        assertEquals("localhost", networkRequestMeter.getId().getTag(MetricTag.HOST.toString()));
        assertEquals(requestName, networkRequestMeter.getId().getTag(MetricTag.REQUEST.toString()));
        assertEquals("409", networkRequestMeter.getId().getTag(MetricTag.STATUS_CODE_OR_EXCEPTION.toString()));
        assertEquals("CommonTagValue", networkRequestMeter.getId().getTag("CommonTag"));
    }

    @Test
    public void testRecordingRequestMetricWithTagExclusion() {
        String requestName = "testRequest";
        RequestMetricContext context = new RequestMetricContext();
        MeterOptions meterOptions = new MeterOptions(
                new double[] { 0.80, 0.85 },
                Tags.of("CommonTag", "CommonTagValue"),
                EnumSet.of(MetricTag.HOST_CONTACTED, MetricTag.HOST)
        );
        context.setRequestExecutionTime(Duration.ofMillis(150));
        context.setStatusCode(409);
        context.setThrowable(new TransportException("Error"));
        context.addNetworkRequestContext(new NetworkRequestMetricContext("localhost", null, 409, Duration.ofMillis(1)));
        context.addNetworkRequestContext(new NetworkRequestMetricContext("localhost1", null, 409, Duration.ofMillis(1)));
        context.addNetworkRequestContext(
                new NetworkRequestMetricContext("localhost2", new TransportException("Error"), 409, Duration.ofMillis(1))
        );

        TelemetryMetricsManager.recordRequestMetrics(requestName, meterOptions, context, MetricGroup.ALL);

        // Verify REQUEST meter
        Optional<Meter> meter = findMeter(stubRegistry, MetricName.REQUEST.toString(), Tags.of(MetricTag.REQUEST.toString(), requestName));
        assertFalse(meter.isEmpty());
        Timer testMeter = (Timer) meter.get();
        assertEquals(requestName, testMeter.getId().getTag(MetricTag.REQUEST.toString()));
        assertEquals("409", testMeter.getId().getTag(MetricTag.STATUS_CODE_OR_EXCEPTION.toString()));
        assertNull(testMeter.getId().getTag(MetricTag.HOST_CONTACTED.toString()));
        assertEquals("CommonTagValue", testMeter.getId().getTag("CommonTag"));

        // Verify NETWORK_REQUEST meter
        List<Meter> meters = findMeters(stubRegistry, MetricName.NETWORK_REQUEST.toString(), Tags.of("CommonTag", "CommonTagValue"));
        assertEquals(1, meters.size());
        Timer networkRequestMeter = (Timer) meters.get(0);
        assertEquals(requestName, networkRequestMeter.getId().getTag(MetricTag.REQUEST.toString()));
        assertEquals("CommonTagValue", networkRequestMeter.getId().getTag("CommonTag"));
        assertEquals("409", networkRequestMeter.getId().getTag(MetricTag.STATUS_CODE_OR_EXCEPTION.toString()));
        assertNull(networkRequestMeter.getId().getTag(MetricTag.HOST.toString()));
    }

    @Test
    public void testNoPayLoadSize() {
        NetworkRequestMetricContext context = new NetworkRequestMetricContext("temp", null, 0, Duration.ZERO);
        TelemetryMetricsManager.recordPayloadSizes(context, Tags.empty());
        assertTrue(findMeter(stubRegistry, MetricName.REQUEST_PAYLOAD_SIZE.toString(), Tags.empty()).isEmpty());
        assertTrue(findMeter(stubRegistry, MetricName.RESPONSE_PAYLOAD_SIZE.toString(), Tags.empty()).isEmpty());
    }

    @Test
    public void testMultipleNetworkContextsWithServerResponses() {
        String requestName = "testRequest";
        MeterOptions meterOptions = new MeterOptions(new double[] { 0.80, 0.85 }, Tags.of("CommonTag", "CommonTagValue"), null);

        NetworkRequestMetricContext networkRequestMetricContextFail = new NetworkRequestMetricContext(
                "host1",
                null,
                500,
                Duration.ofMillis(10)
        );
        networkRequestMetricContextFail.setRequestPayloadSize(500);

        NetworkRequestMetricContext networkRequestMetricContextSuccess = new NetworkRequestMetricContext(
                "host1",
                null,
                200,
                Duration.ofMillis(20)
        );
        networkRequestMetricContextSuccess.setRequestPayloadSize(500);
        networkRequestMetricContextSuccess.setResponsePayloadSize(200);

        RequestMetricContext requestMetricContext = new RequestMetricContext();
        requestMetricContext.addNetworkRequestContext(networkRequestMetricContextFail);
        requestMetricContext.addNetworkRequestContext(networkRequestMetricContextSuccess);
        requestMetricContext.setRequestExecutionTime(Duration.ofMillis(30));

        TelemetryMetricsManager.recordRequestMetrics(requestName, meterOptions, requestMetricContext, MetricGroup.ALL);

        DistributionSummary requestPayloadMeter = (DistributionSummary) findMeter(
                stubRegistry,
                MetricName.REQUEST_PAYLOAD_SIZE.toString(),
                Tags.empty()
        ).get();
        assertEquals(2, requestPayloadMeter.count());
        DistributionSummary responsePayloadMeter = (DistributionSummary) findMeter(
                stubRegistry,
                MetricName.RESPONSE_PAYLOAD_SIZE.toString(),
                Tags.empty()
        ).get();
        assertEquals(1, responsePayloadMeter.count());
    }

    private List<Meter> findMeters(MeterRegistry registry, String meterName, Tags tags) {
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

    private Optional<Meter> findMeter(MeterRegistry registry, String meterName, Tags tags) {
        return findMeters(registry, meterName, tags).stream().findFirst();
    }
}