/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import com.carrotsearch.randomizedtesting.ThreadFilter;

public final class TestcontainersThreadFilter implements ThreadFilter {
    @Override
    public boolean reject(Thread thread) {
        String name = thread.getName();
        // Testcontainers owns these helper threads and Ryuk cleans them up after the JVM exits.
        return "testcontainers-ryuk".equals(name) || name.startsWith("testcontainers-pull-watchdog-") || name.startsWith("ducttape-");
    }
}
