/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import java.time.Duration;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.HttpWaitStrategy;
import org.testcontainers.utility.DockerImageName;

final class OpenSearchTestContainer {
    static final String ENABLED_PROPERTY = "tests.opensearch.testcontainers.enabled";
    static final String VERSION_PROPERTY = "tests.opensearch.version";
    static final String IMAGE_PROPERTY = "tests.opensearch.image";
    static final String CLUSTER_PROPERTY = "tests.rest.cluster";
    static final String HTTPS_PROPERTY = "https";
    static final String USER_PROPERTY = "user";
    static final String PASSWORD_PROPERTY = "password";

    private static final String DEFAULT_IMAGE = "opensearchproject/opensearch";
    private static final String ADMIN_USER = "admin";
    private static final String DEFAULT_ADMIN_PASSWORD = "admin";
    // OpenSearch 2.12+ rejects the old admin/admin demo password during container startup.
    private static final String DEFAULT_INITIAL_ADMIN_PASSWORD = "OSClient-Test-2026-Password!";
    private static final int HTTP_PORT = 9200;

    private static GenericContainer<?> container;
    private static String password;

    private OpenSearchTestContainer() {}

    static synchronized void startIfNeeded() {
        if (hasText(System.getProperty(CLUSTER_PROPERTY)) || !testcontainersEnabled()) {
            return;
        }

        if (container == null) {
            String version = System.getProperty(VERSION_PROPERTY);
            String imageName = resolveImageName(version);
            String passwordCompatibilityVersion = passwordCompatibilityVersion(version, imageName);
            password = passwordFor(passwordCompatibilityVersion);
            GenericContainer<?> openSearch = createContainer(imageName, passwordCompatibilityVersion, password);
            openSearch.start();
            container = openSearch;
        }

        System.setProperty(CLUSTER_PROPERTY, container.getHost() + ":" + container.getMappedPort(HTTP_PORT));
        System.setProperty(HTTPS_PROPERTY, "true");
        System.setProperty(USER_PROPERTY, ADMIN_USER);
        System.setProperty(PASSWORD_PROPERTY, password);
    }

    private static GenericContainer<?> createContainer(String imageName, String passwordCompatibilityVersion, String adminPassword) {
        GenericContainer<?> openSearch = new GenericContainer<>(DockerImageName.parse(imageName)).withExposedPorts(HTTP_PORT)
            .withEnv("discovery.type", "single-node")
            .withEnv("bootstrap.memory_lock", "true")
            .withEnv("cluster.routing.allocation.disk.threshold_enabled", "false")
            .waitingFor(
                new HttpWaitStrategy().forPort(HTTP_PORT)
                    .usingTls()
                    .allowInsecure()
                    .withBasicCredentials(ADMIN_USER, adminPassword)
                    .forStatusCode(200)
                    .withReadTimeout(Duration.ofSeconds(10))
                    .withStartupTimeout(Duration.ofMinutes(5))
            );

        if (requiresInitialAdminPassword(passwordCompatibilityVersion)) {
            openSearch.withEnv("OPENSEARCH_INITIAL_ADMIN_PASSWORD", adminPassword);
        }

        return openSearch;
    }

    private static String resolveImageName(String version) {
        String image = System.getProperty(IMAGE_PROPERTY);
        if (hasText(image)) {
            return image;
        }
        if (!hasText(version)) {
            throw new IllegalStateException("Missing " + VERSION_PROPERTY + " for OpenSearch Testcontainers image");
        }
        return DEFAULT_IMAGE + ":" + version;
    }

    private static String passwordFor(String version) {
        String configuredPassword = System.getProperty(PASSWORD_PROPERTY);
        if (requiresInitialAdminPassword(version)) {
            if (!hasText(configuredPassword) || DEFAULT_ADMIN_PASSWORD.equals(configuredPassword)) {
                return DEFAULT_INITIAL_ADMIN_PASSWORD;
            }
            return configuredPassword;
        }
        return hasText(configuredPassword) ? configuredPassword : DEFAULT_ADMIN_PASSWORD;
    }

    private static boolean requiresInitialAdminPassword(String version) {
        if (!hasText(version) || "latest".equalsIgnoreCase(version)) {
            return true;
        }

        String[] components = version.split("[-+]", 2)[0].split("\\.");
        Integer major = parseInt(components, 0);
        if (major == null) {
            return true;
        }
        if (major == 2 && components.length == 1) {
            return true;
        }

        int minor = parseInt(components, 1, 0);
        return major > 2 || major == 2 && minor >= 12;
    }

    private static Integer parseInt(String[] components, int index) {
        if (index >= components.length) {
            return null;
        }
        try {
            return Integer.parseInt(components[index]);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static int parseInt(String[] components, int index, int defaultValue) {
        Integer value = parseInt(components, index);
        return value == null ? defaultValue : value;
    }

    private static String passwordCompatibilityVersion(String version, String imageName) {
        String imageTag = imageTag(imageName);
        if (hasText(imageTag)) {
            return imageTag;
        }
        return version;
    }

    private static String imageTag(String imageName) {
        int lastSlash = imageName.lastIndexOf('/');
        int lastColon = imageName.lastIndexOf(':');
        if (lastColon > lastSlash && lastColon < imageName.length() - 1) {
            return imageName.substring(lastColon + 1);
        }
        return null;
    }

    private static boolean testcontainersEnabled() {
        return Boolean.parseBoolean(System.getProperty(ENABLED_PROPERTY, "true"));
    }

    private static boolean hasText(String value) {
        return value != null && !value.isBlank();
    }
}
