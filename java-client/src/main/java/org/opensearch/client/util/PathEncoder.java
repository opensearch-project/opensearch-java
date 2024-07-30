/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.util;

public class PathEncoder {
    /**
     * Percent encoding codec that matches Apache HTTP Client 4's path segment encoding.
     */
    @Deprecated
    public static final PercentCodec APACHE_HTTP_CLIENT_4_EQUIV_CODEC = PercentCodec.RFC3986_PATHSAFE;
    /**
     * Percent encoding codec that matches Apache HTTP Client 5's path segment encoding.
     */
    public static final PercentCodec APACHE_HTTP_CLIENT_5_EQUIV_CODEC = PercentCodec.RFC3986_UNRESERVED;

    public static final PercentCodec DEFAULT_CODEC = APACHE_HTTP_CLIENT_5_EQUIV_CODEC;

    private static PercentCodec codec;

    public static PercentCodec getCodec() {
        if (codec == null) {
            codec = DEFAULT_CODEC;
        }
        return codec;
    }

    public static void setCodec(PercentCodec codec) {
        PathEncoder.codec = codec;
    }

    public static String encode(String pathSegment) {
        return getCodec().encode(pathSegment);
    }

    public static void encode(StringBuilder dest, CharSequence pathSegment) {
        getCodec().encode(dest, pathSegment);
    }
}
