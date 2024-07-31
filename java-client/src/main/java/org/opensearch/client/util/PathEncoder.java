/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.util;

import java.util.Optional;

public class PathEncoder {
    private enum Encoding {
        RFC3986_PATH(PercentCodec.RFC3986_PATH),
        HTTP_CLIENT_V4_EQUIV(PercentCodec.RFC3986_PATH),

        RFC3986_UNRESERVED(PercentCodec.RFC3986_UNRESERVED),
        HTTP_CLIENT_V5_EQUIV(PercentCodec.RFC3986_UNRESERVED);

        private final PercentCodec percentCodec;

        Encoding(PercentCodec percentCodec) {
            this.percentCodec = percentCodec;
        }

        static Optional<Encoding> get(String name) {
            try {
                return Optional.of(Encoding.valueOf(name.toUpperCase()));
            } catch (Exception ignored) {
                return Optional.empty();
            }
        }
    }
    private static final String ENCODING_PROPERTY = "org.opensearch.path.encoding";
    private static final Encoding ENCODING_DEFAULT = Encoding.HTTP_CLIENT_V5_EQUIV;

    private static final Encoding ENCODING = Optional.ofNullable(System.getProperty(ENCODING_PROPERTY))
            .flatMap(Encoding::get)
            .orElse(ENCODING_DEFAULT);

    public static String encode(String pathSegment) {
        return ENCODING.percentCodec.encode(pathSegment);
    }

    public static void encode(StringBuilder dest, CharSequence pathSegment) {
        ENCODING.percentCodec.encode(dest, pathSegment);
    }
}
