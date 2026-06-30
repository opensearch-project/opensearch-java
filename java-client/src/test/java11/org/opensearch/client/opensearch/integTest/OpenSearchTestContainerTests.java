/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OpenSearchTestContainerTests {

    @Test
    public void defaultImageUsesOfficialOpenSearchImage() {
        assertEquals("opensearchproject/opensearch:3.2.0", OpenSearchTestContainer.resolveImageName("3.2.0", null));
    }

    @Test
    public void configuredImageTakesPrecedenceOverVersion() {
        assertEquals(
            "opensearchproject/opensearch:2.19.2",
            OpenSearchTestContainer.resolveImageName("3.2.0", "opensearchproject/opensearch:2.19.2")
        );
    }

    @Test
    public void missingVersionWithoutCustomImageFailsFast() {
        try {
            OpenSearchTestContainer.resolveImageName(null, null);
        } catch (IllegalStateException e) {
            assertEquals("Missing tests.opensearch.version for OpenSearch Testcontainers image", e.getMessage());
            return;
        }

        throw new AssertionError("Expected missing OpenSearch version to fail");
    }
}
