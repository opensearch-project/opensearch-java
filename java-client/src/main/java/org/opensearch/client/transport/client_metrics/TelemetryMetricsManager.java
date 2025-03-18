/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.client_metrics;

import static org.opensearch.client.transport.client_metrics.ExecutionMetricContext.DEFAULT_EMPTY_STATUS_CODE;
import static org.opensearch.client.transport.client_metrics.MetricName.ACTIVE_NODES;
import static org.opensearch.client.transport.client_metrics.MetricName.INACTIVE_NODES;
import static org.opensearch.client.transport.client_metrics.MetricName.NETWORK_REQUEST;
import static org.opensearch.client.transport.client_metrics.MetricName.REQUEST;
import static org.opensearch.client.transport.client_metrics.MetricName.REQUEST_PAYLOAD_SIZE;
import static org.opensearch.client.transport.client_metrics.MetricName.RESPONSE_PAYLOAD_SIZE;

import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import java.time.Duration;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TelemetryMetricsManager {
    private static final Log logger = LogFactory.getLog(TelemetryMetricsManager.class);
    private static final String EXCEPTION_PREFIX = "ClientError-";
    private static final AtomicInteger CLIENT_ID_GENERATOR = new AtomicInteger(0);
    private static final CompositeMeterRegistry mainRegistry = new CompositeMeterRegistry();

    private TelemetryMetricsManager() {
        throw new IllegalStateException("Cannot instantiate a utility class");
    }

    public static int generateClientID() {
        return CLIENT_ID_GENERATOR.getAndIncrement();
    }

    /**
     * Add the provided registry to the main composite registry
     * @param registry a {@link MeterRegistry}
     */
    public static synchronized void addRegistry(MeterRegistry registry) {
        if (registry == null) {
            throw new IllegalArgumentException("Cannot add a null registry");
        }
        mainRegistry.add(registry);
    }

    /**
     * Remove the provided registry from the main composite registry. If the main registry has no
     * child registries, it is cleared.
     * @param registry a {@link MeterRegistry}
     */
    public static synchronized void removeRegistry(MeterRegistry registry) {
        if (registry == null) {
            throw new IllegalArgumentException("Cannot remove a null registry");
        }
        mainRegistry.remove(registry);
        if (mainRegistry.getRegistries().isEmpty()) {
            mainRegistry.clear();
        }
    }

    /**
     * Record information for request-related metrics.
     *
     * @param requestName  name of the executed request
     * @param meterOptions options for configuring its meter
     * @param context      a {@link RequestMetricContext} object about the execution
     * @param metricGroups {@link MetricGroup} groups to record
     */
    public static void recordRequestMetrics(
        String requestName,
        MeterOptions meterOptions,
        RequestMetricContext context,
        Set<MetricGroup> metricGroups
    ) {
        if (requestName == null) {
            throw new IllegalArgumentException("Request name cannot be null");
        }
        if (context == null) {
            throw new IllegalArgumentException("Metric context cannot be null");
        }
        if (meterOptions == null) {
            throw new IllegalArgumentException("Meter options cannot be null");
        }
        if (metricGroups == null) {
            metricGroups = MetricGroup.REQUIRED_GROUPS;
        }

        Set<MetricTag> excludedTags = Optional.ofNullable(meterOptions.getExcludedTagNames()).orElse(EnumSet.noneOf(MetricTag.class));
        recordOverallRequestMetric(meterOptions, context, getRequestTags(requestName, context), excludedTags);
        if (metricGroups.contains(MetricGroup.NETWORK_DETAILS)) {
            Tags payloadSizeTags = Tags.of(MetricTag.REQUEST.toString(), requestName).and(meterOptions.getCommonTags());
            for (NetworkRequestMetricContext networkRequestMetricContext : context.getNetworkRequestContexts()) {
                recordNetworkRequestMetric(
                    meterOptions,
                    networkRequestMetricContext,
                    getRequestTags(requestName, networkRequestMetricContext),
                    excludedTags
                );
                recordPayloadSizes(networkRequestMetricContext, payloadSizeTags);
            }
        }
    }

    public static void initializeNodeGauges(
        MeterOptions meterOptions,
        Supplier<Number> activeNodeUpdater,
        Supplier<Number> inactiveNodeUpdater
    ) {
        if (meterOptions == null) {
            throw new IllegalArgumentException("Meter options cannot be null");
        }
        if (activeNodeUpdater == null) {
            throw new IllegalArgumentException("activeNodeUpdater cannot be null");
        }
        if (inactiveNodeUpdater == null) {
            throw new IllegalArgumentException("inactiveNodeUpdater cannot be null");
        }
        Tags tags = Tags.empty().and(meterOptions.getCommonTags());
        Gauge.builder(ACTIVE_NODES.toString(), activeNodeUpdater)
            .description("Number of active nodes to serve traffic")
            .tags(tags)
            .baseUnit("nodes")
            .register(mainRegistry);
        Gauge.builder(INACTIVE_NODES.toString(), inactiveNodeUpdater)
            .description("Number of inactive nodes that cannot serve traffic")
            .tags(tags)
            .baseUnit("nodes")
            .register(mainRegistry);
    }

    protected static void recordPayloadSizes(NetworkRequestMetricContext context, Tags tags) {
        if (tags == null) {
            tags = Tags.empty();
        }
        if (context == null) {
            throw new IllegalArgumentException("Metric context cannot be null");
        }

        long requestPayloadSize = context.getRequestPayloadSize();
        long responsePayloadSize = context.getResponsePayloadSize();
        if (requestPayloadSize > -1) {
            DistributionSummary.builder(REQUEST_PAYLOAD_SIZE.toString())
                .tags(tags)
                .description("Request payload size")
                .baseUnit("bytes")
                .register(mainRegistry)
                .record(requestPayloadSize);
        }
        if (responsePayloadSize > -1) {
            DistributionSummary.builder(RESPONSE_PAYLOAD_SIZE.toString())
                .tags(tags)
                .description("Response payload size")
                .baseUnit("bytes")
                .register(mainRegistry)
                .record(responsePayloadSize);
        }
    }

    private static void recordNetworkRequestMetric(
        MeterOptions meterOptions,
        NetworkRequestMetricContext context,
        Tags requestTags,
        Set<MetricTag> excludedTags
    ) {
        if (context.getRequestExecutionTime() != null) {
            Tags networkRequestTags = excludedTags.contains(MetricTag.HOST)
                ? requestTags
                : requestTags.and(Tag.of(MetricTag.HOST.toString(), context.getHostName()));
            Timer.builder(NETWORK_REQUEST.toString())
                .description("Apache HttpClient request latency")
                .publishPercentiles(meterOptions.getPercentiles())
                .tags(networkRequestTags.and(meterOptions.getCommonTags()))
                .maximumExpectedValue(Duration.ofSeconds(30))
                .register(mainRegistry)
                .record(context.getRequestExecutionTime());
        } else if (logger.isDebugEnabled()) {
            logger.debug("Missing execution duration. Skipping " + NETWORK_REQUEST);
        }
    }

    private static void recordOverallRequestMetric(
        MeterOptions meterOptions,
        RequestMetricContext context,
        Tags requiredRequestTags,
        Set<MetricTag> excludedTags
    ) {
        if (context.getRequestExecutionTime() != null) {
            Tags requestMeterTags = excludedTags.contains(MetricTag.HOST_CONTACTED)
                ? requiredRequestTags
                : requiredRequestTags.and(Tag.of(MetricTag.HOST_CONTACTED.toString(), context.getContactedHosts()));
            Timer.builder(REQUEST.toString())
                .description("End-to-end request execution latency")
                .publishPercentiles(meterOptions.getPercentiles())
                .tags(requestMeterTags.and(meterOptions.getCommonTags()))
                .maximumExpectedValue(Duration.ofSeconds(30))
                .register(mainRegistry)
                .record(context.getRequestExecutionTime());
        } else if (logger.isDebugEnabled()) {
            logger.debug("Missing execution duration. Skipping " + REQUEST);
        }
    }

    /**
     * Compose required {@link Tags} for metrics {@link MetricName#REQUEST} and {@link MetricName#NETWORK_REQUEST}
     * based on the provided information.
     *
     * <p>
     *     Required tags: {@link MetricTag#REQUEST}, {@link MetricTag#STATUS_CODE_OR_EXCEPTION}
     * </p>
     *
     * @param requestName name of the executed request
     * @param context a {@link RequestMetricContext} object about the execution
     * @return {@link Tags}
     */
    private static Tags getRequestTags(String requestName, ExecutionMetricContext context) {
        List<Tag> tagList = new ArrayList<>();
        tagList.add(Tag.of(MetricTag.REQUEST.toString(), requestName == null ? "" : requestName));
        tagList.add(Tag.of(MetricTag.STATUS_CODE_OR_EXCEPTION.toString(), extractStatusCodeOrException(context)));
        return Tags.of(tagList);
    }

    private static String extractStatusCodeOrException(ExecutionMetricContext context) {
        if (context != null) {
            if (context.getStatusCode() != DEFAULT_EMPTY_STATUS_CODE) {
                return String.valueOf(context.getStatusCode());
            } else if (context.getThrowable() != null) {
                Throwable error = context.getThrowable();
                if (error.getCause() != null) {
                    return EXCEPTION_PREFIX + error.getCause().getClass().getSimpleName();
                }
                return EXCEPTION_PREFIX + error.getClass().getSimpleName();
            }
        }
        return "UNKNOWN";
    }
}
