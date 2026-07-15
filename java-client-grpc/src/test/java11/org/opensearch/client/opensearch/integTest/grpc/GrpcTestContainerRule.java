/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.grpc;

import java.net.URI;
import org.junit.rules.ExternalResource;
import org.opensearch.testcontainers.OpenSearchContainer;
import org.opensearch.testcontainers.OpenSearchDockerImage;

/**
 * Starts an OpenSearch test container with gRPC transport enabled.
 * <p>
 * Configures the container with:
 * <ul>
 *   <li>gRPC transport enabled on port 9400</li>
 *   <li>Security disabled (plaintext gRPC for testing)</li>
 *   <li>Port 9400 exposed for gRPC connections</li>
 * </ul>
 * <p>
 * Sets system properties so tests can discover the cluster:
 * <ul>
 *   <li>{@code tests.rest.cluster} — host:port for REST (9200)</li>
 *   <li>{@code tests.grpc.cluster} — host:port for gRPC (9400)</li>
 *   <li>{@code https} — false (security disabled)</li>
 * </ul>
 */
final class GrpcTestContainerRule extends ExternalResource {
    private static final String ENABLED_PROPERTY = "tests.opensearch.testcontainers.enabled";
    private static final String VERSION_PROPERTY = "tests.opensearch.version";
    private static final String IMAGE_PROPERTY = "tests.opensearch.image";
    private static final String CLUSTER_PROPERTY = "tests.rest.cluster";
    private static final String GRPC_CLUSTER_PROPERTY = "tests.grpc.cluster";
    private static final String HTTPS_PROPERTY = "https";

    static final int GRPC_PORT = 9400;

    private static OpenSearchContainer<?> container;

    @Override
    protected void before() {
        startIfNeeded();
    }

    private static void startIfNeeded() {
        if (hasText(System.getProperty(CLUSTER_PROPERTY)) || !testcontainersEnabled()) {
            return;
        }

        if (container == null) {
            OpenSearchContainer<?> openSearch = createContainer();
            openSearch.start();
            container = openSearch;
        }

        // REST endpoint
        URI httpHostAddress = URI.create(container.getHttpHostAddress());
        System.setProperty(CLUSTER_PROPERTY, httpHostAddress.getHost() + ":" + httpHostAddress.getPort());
        System.setProperty(HTTPS_PROPERTY, "false");

        // gRPC endpoint — get the mapped port for 9400
        String grpcHost = container.getHost();
        Integer grpcMappedPort = container.getMappedPort(GRPC_PORT);
        System.setProperty(GRPC_CLUSTER_PROPERTY, grpcHost + ":" + grpcMappedPort);
    }

    private static OpenSearchContainer<?> createContainer() {
        String image = System.getProperty(IMAGE_PROPERTY);
        OpenSearchContainer<?> openSearch = hasText(image)
            ? new OpenSearchContainer<>(image)
            : new OpenSearchContainer<>(OpenSearchDockerImage.ofVersion(requiredVersion()));

        // Disable security for plaintext gRPC testing
        openSearch.withEnv("plugins.security.disabled", "true");

        // Enable gRPC transport
        openSearch.withEnv("aux.transport.types", "transport-grpc");
        openSearch.withEnv("aux.transport.transport-grpc.port", String.valueOf(GRPC_PORT));

        // Expose both REST and gRPC ports
        openSearch.withExposedPorts(9200, GRPC_PORT);

        // Disable disk watermarks for CI
        openSearch.withEnv("cluster.routing.allocation.disk.threshold_enabled", "false");

        return openSearch;
    }

    private static String requiredVersion() {
        String version = System.getProperty(VERSION_PROPERTY);
        if (!hasText(version)) {
            throw new IllegalStateException("Missing " + VERSION_PROPERTY + " for OpenSearch Testcontainers image");
        }
        return version;
    }

    private static boolean testcontainersEnabled() {
        return Boolean.parseBoolean(System.getProperty(ENABLED_PROPERTY, "true"));
    }

    private static boolean hasText(String value) {
        return value != null && !value.isBlank();
    }
}
