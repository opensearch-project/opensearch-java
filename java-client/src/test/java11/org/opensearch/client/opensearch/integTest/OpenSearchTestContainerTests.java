/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OpenSearchTestContainerTests {

    @Test
    public void initialAdminPasswordIsNotRequiredForOlderVersions() {
        assertFalse(OpenSearchTestContainer.requiresInitialAdminPassword("1"));
        assertFalse(OpenSearchTestContainer.requiresInitialAdminPassword("1.x"));
        assertFalse(OpenSearchTestContainer.requiresInitialAdminPassword("1.3.20"));
        assertFalse(OpenSearchTestContainer.requiresInitialAdminPassword("2.11.0"));
    }

    @Test
    public void initialAdminPasswordIsRequiredForNewerVersions() {
        assertTrue(OpenSearchTestContainer.requiresInitialAdminPassword("2.12.0"));
        assertTrue(OpenSearchTestContainer.requiresInitialAdminPassword("3.2.0"));
    }

    @Test
    public void initialAdminPasswordIsRequiredForMissingOrRollingVersions() {
        assertTrue(OpenSearchTestContainer.requiresInitialAdminPassword(null));
        assertTrue(OpenSearchTestContainer.requiresInitialAdminPassword("2"));
        assertTrue(OpenSearchTestContainer.requiresInitialAdminPassword("latest"));
    }

    @Test
    public void initialAdminPasswordIsRequiredForUnknownVersions() {
        assertTrue(OpenSearchTestContainer.requiresInitialAdminPassword("2.x"));
        assertTrue(OpenSearchTestContainer.requiresInitialAdminPassword("2.foo"));
        assertTrue(OpenSearchTestContainer.requiresInitialAdminPassword("custom"));
    }

    @Test
    public void customImageTagsUseConfiguredVersionForPasswordCompatibility() {
        assertEquals("2.11.0", OpenSearchTestContainer.passwordCompatibilityVersion("2.11.0", "registry.example.com/opensearch:custom"));
        assertEquals("2.12.0", OpenSearchTestContainer.passwordCompatibilityVersion("2.11.0", "registry.example.com/opensearch:2.12.0"));
    }
}
