/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import org.opensearch.testcontainers.OpenSearchContainer;

final class OpenSearchTestContainer {
    static final String ENABLED_PROPERTY = "tests.opensearch.testcontainers.enabled";
    static final String VERSION_PROPERTY = "tests.opensearch.version";
    static final String IMAGE_PROPERTY = "tests.opensearch.image";
    static final String CLUSTER_PROPERTY = "tests.rest.cluster";
    static final String HTTPS_PROPERTY = "https";
    static final String USER_PROPERTY = "user";
    static final String PASSWORD_PROPERTY = "password";

    private static final String DEFAULT_IMAGE = "opensearchproject/opensearch";
    private static final String DEFAULT_ADMIN_PASSWORD = "admin";
    private static final int HTTP_PORT = 9200;

    private static OpenSearchContainer<?> container;

    private OpenSearchTestContainer() {}

    static synchronized void startIfNeeded() {
        if (hasText(System.getProperty(CLUSTER_PROPERTY)) || !testcontainersEnabled()) {
            return;
        }

        if (container == null) {
            String version = System.getProperty(VERSION_PROPERTY);
            String imageName = resolveImageName(version, System.getProperty(IMAGE_PROPERTY));
            OpenSearchContainer<?> openSearch = createContainer(imageName);
            openSearch.start();
            container = openSearch;
        }

        System.setProperty(CLUSTER_PROPERTY, container.getHost() + ":" + container.getMappedPort(HTTP_PORT));
        System.setProperty(HTTPS_PROPERTY, Boolean.toString(container.isSecurityEnabled()));
        System.setProperty(USER_PROPERTY, container.getUsername());
        System.setProperty(PASSWORD_PROPERTY, container.getPassword());
    }

    private static OpenSearchContainer<?> createContainer(String imageName) {
        OpenSearchContainer<?> openSearch = new OpenSearchContainer<>(imageName).withSecurityEnabled()
            .withEnv("bootstrap.memory_lock", "true")
            .withEnv("cluster.routing.allocation.disk.threshold_enabled", "false");

        String configuredPassword = System.getProperty(PASSWORD_PROPERTY);
        if (hasText(configuredPassword) && !DEFAULT_ADMIN_PASSWORD.equals(configuredPassword)) {
            openSearch.withEnv("OPENSEARCH_INITIAL_ADMIN_PASSWORD", configuredPassword);
        }

        return openSearch;
    }

    static String resolveImageName(String version, String image) {
        if (hasText(image)) {
            return image;
        }
        if (!hasText(version)) {
            throw new IllegalStateException("Missing " + VERSION_PROPERTY + " for OpenSearch Testcontainers image");
        }
        return DEFAULT_IMAGE + ":" + version;
    }

    private static boolean testcontainersEnabled() {
        return Boolean.parseBoolean(System.getProperty(ENABLED_PROPERTY, "true"));
    }

    private static boolean hasText(String value) {
        return value != null && !value.isBlank();
    }
}
