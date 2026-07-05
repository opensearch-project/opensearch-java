/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import java.net.URI;
import org.junit.rules.ExternalResource;
import org.opensearch.testcontainers.OpenSearchContainer;
import org.opensearch.testcontainers.OpenSearchDockerImage;

/**
 * Starts one OpenSearch test container for the whole test JVM and points the integration tests at
 * it through system properties. The container is shared by every test class, so it is left running
 * after each class; Testcontainers' Ryuk reaper removes it once the JVM exits.
 */
final class OpenSearchTestContainerRule extends ExternalResource {
    static final String ENABLED_PROPERTY = "tests.opensearch.testcontainers.enabled";
    static final String VERSION_PROPERTY = "tests.opensearch.version";
    static final String IMAGE_PROPERTY = "tests.opensearch.image";
    static final String CLUSTER_PROPERTY = "tests.rest.cluster";
    static final String HTTPS_PROPERTY = "https";
    static final String USER_PROPERTY = "user";
    static final String PASSWORD_PROPERTY = "password";

    private static final String DEFAULT_ADMIN_PASSWORD = "admin";

    private static OpenSearchContainer<?> container;

    @Override
    protected void before() {
        startIfNeeded();
    }

    static synchronized void startIfNeeded() {
        if (hasText(System.getProperty(CLUSTER_PROPERTY)) || !testcontainersEnabled()) {
            return;
        }

        if (container == null) {
            OpenSearchContainer<?> openSearch = createContainer();
            openSearch.start();
            container = openSearch;
        }

        // getHttpHostAddress() is scheme-prefixed, but tests.rest.cluster expects host:port.
        URI httpHostAddress = URI.create(container.getHttpHostAddress());
        System.setProperty(CLUSTER_PROPERTY, httpHostAddress.getHost() + ":" + httpHostAddress.getPort());
        System.setProperty(HTTPS_PROPERTY, Boolean.toString(container.isSecurityEnabled()));
        System.setProperty(USER_PROPERTY, container.getUsername());
        System.setProperty(PASSWORD_PROPERTY, container.getPassword());
    }

    private static OpenSearchContainer<?> createContainer() {
        String image = System.getProperty(IMAGE_PROPERTY);
        OpenSearchContainer<?> openSearch = hasText(image)
            ? new OpenSearchContainer<>(image)
            : new OpenSearchContainer<>(OpenSearchDockerImage.ofVersion(requiredVersion()));

        // Disk watermarks must stay disabled; constrained disks otherwise trip index_create_block_exception.
        openSearch.withSecurityEnabled().withEnv("cluster.routing.allocation.disk.threshold_enabled", "false");

        // The container has no password setter; OPENSEARCH_INITIAL_ADMIN_PASSWORD is its supported
        // input and getPassword() reflects it. Only forward a non-default override: when the env is
        // unset, the container substitutes its own strong default on images >= 2.12.
        String configuredPassword = System.getProperty(PASSWORD_PROPERTY);
        if (hasText(configuredPassword) && !DEFAULT_ADMIN_PASSWORD.equals(configuredPassword)) {
            openSearch.withEnv("OPENSEARCH_INITIAL_ADMIN_PASSWORD", configuredPassword);
        }

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
