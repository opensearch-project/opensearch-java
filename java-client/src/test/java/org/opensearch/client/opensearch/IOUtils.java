/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch;

import java.io.Closeable;
import java.io.IOException;

public final class IOUtils {
    public static void closeQueitly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException | RuntimeException e) {
            // Do nothing
        }
    }
}
