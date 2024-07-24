/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.util;

/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

public class PathEncoder {
    private final static String HTTP_CLIENT4_UTILS_CLASS = "org.apache.http.client.utils.URLEncodedUtils";
    private final static String HTTP_CLIENT5_UTILS_CLASS = "org.apache.hc.core5.net.URLEncodedUtils";
    private final static MethodHandle FORMAT_SEGMENTS_MH;

    static {
        Class<?> clazz = null;
        try {
<<<<<<< Updated upstream
            // Try Apache HttpClient5 first since this is a default one
=======
            // Try Apache HttpClient5 first since this is the "better" encoder
>>>>>>> Stashed changes
            clazz = Class.forName(HTTP_CLIENT5_UTILS_CLASS);
        } catch (final ClassNotFoundException ex) {
            try {
                // Fallback to Apache HttpClient4
                clazz = Class.forName(HTTP_CLIENT4_UTILS_CLASS);
            } catch (final ClassNotFoundException ex1) {
                clazz = null;
            }
        }

        if (clazz == null) {
            throw new IllegalStateException(
                "Either '" + HTTP_CLIENT5_UTILS_CLASS + "' or '" + HTTP_CLIENT4_UTILS_CLASS + "' is required by not found on classpath"
            );
        }

        try {
            FORMAT_SEGMENTS_MH = MethodHandles.lookup()
                .findStatic(clazz, "formatSegments", MethodType.methodType(String.class, Iterable.class, Charset.class));
        } catch (final NoSuchMethodException | IllegalAccessException ex) {
            throw new IllegalStateException("Unable to find 'formatSegments' method in " + clazz + " class");
        }
    }

    public static String encode(String uri) {
        try {
            return ((String) FORMAT_SEGMENTS_MH.invoke(Collections.singletonList(uri), StandardCharsets.UTF_8)).substring(1);
        } catch (final Throwable ex) {
            throw new RuntimeException("Unable to encode URI: " + uri, ex);
        }
    }
}
