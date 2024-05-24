/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.util;

import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;

public class PathEncoder {
    private static final BitSet GEN_DELIMITERS = new BitSet(256);
    private static final BitSet SUB_DELIMITERS = new BitSet(256);
    private static final BitSet UNRESERVED_CHARACTERS = new BitSet(256);
    private static final BitSet URIC_CHARACTERS = new BitSet(256);

    // Initialize the character sets used for encoding
    static {
        initializeBitSets();
    }

    /**
     * Initializes the character sets for URL encoding.
     */
    private static void initializeBitSets() {
        int[] genDelims = { 58, 47, 63, 35, 91, 93, 64 };
        int[] subDelims = { 33, 36, 38, 39, 40, 41, 42, 43, 44, 59, 61 };
        int[] unreservedChars = { 45, 46, 95, 126 };

        for (int delim : genDelims) {
            GEN_DELIMITERS.set(delim);
        }

        for (int delim : subDelims) {
            SUB_DELIMITERS.set(delim);
        }

        UNRESERVED_CHARACTERS.set(97, 123); // a-z
        UNRESERVED_CHARACTERS.set(65, 91);  // A-Z
        UNRESERVED_CHARACTERS.set(48, 58);  // 0-9

        for (int ch : unreservedChars) {
            UNRESERVED_CHARACTERS.set(ch);
        }

        URIC_CHARACTERS.or(SUB_DELIMITERS);
        URIC_CHARACTERS.or(UNRESERVED_CHARACTERS);
    }

    /**
     * Encodes the given string as a URL path.
     *
     * @param src the string to encode
     * @return the encoded URL path
     */
    public static String encode(String src) {
        StringBuilder buf = new StringBuilder();
        encodePathSegment(buf, src);
        return buf.toString();
    }

    /**
     * Encodes a single segment of the path.
     *
     * @param buf     the StringBuilder to append the encoded segment to
     * @param segment the path segment to encode
     */
    private static void encodePathSegment(StringBuilder buf, String segment) {
        if (segment != null) {
            byte[] bytes = StandardCharsets.UTF_8.encode(CharBuffer.wrap(segment)).array();
            encodeBytes(buf, bytes);
        }
    }

    /**
     * Encodes the given byte array and appends the result to the StringBuilder.
     *
     * @param buf   the StringBuilder to append the encoded bytes to
     * @param bytes the byte array to encode
     */
    private static void encodeBytes(StringBuilder buf, byte[] bytes) {
        for (byte b : bytes) {
            int c = b & 0xFF;
            if (UNRESERVED_CHARACTERS.get(c)) {
                buf.append((char) c);
            } else {
                buf.append('%');
                buf.append(Character.toUpperCase(Character.forDigit(c >> 4 & 0xF, 16)));
                buf.append(Character.toUpperCase(Character.forDigit(c & 0xF, 16)));
            }
        }
    }
}
