/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PathEncoderTest {

    @Test
    public void testEncode() {
        // Test with a simple string
        String simpleString = "test";
        String encodedSimpleString = PathEncoder.encode(simpleString);
        assertEquals(simpleString, encodedSimpleString);

        // Test with a string that contains special characters
        String specialString = "a/b";
        String encodedSpecialString = PathEncoder.encode(specialString);
        assertEquals("a%2Fb", encodedSpecialString);

        // Test with a string that contains alphanumeric characters
        String alphanumericString = "abc123";
        String encodedAlphanumericString = PathEncoder.encode(alphanumericString);
        assertEquals("abc123", encodedAlphanumericString);

        // Test with a string that contains multiple segments
        String multiSegmentString = "a/b/c/_refresh";
        String encodedMultiSegmentString = PathEncoder.encode(multiSegmentString);
        assertEquals("a%2Fb%2Fc%2F_refresh", encodedMultiSegmentString);

        // Test with a string that contains colon segment
        String colonSegmentString = "a:b:c::2.0";
        String encodedColonSegmentString = PathEncoder.encode(colonSegmentString);
        assertEquals("a%3Ab%3Ac%3A%3A2.0", encodedColonSegmentString);
    }
}
