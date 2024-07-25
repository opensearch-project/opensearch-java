/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.util;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PercentCodecTest {
    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(
            new Object[][] {
                // <unencoded>, <encoded_unreserved>, <encoded_pathsafe>
                { "test", "test", "test" },
                { "abc123", "abc123", "abc123" },
                { "a/b", "a%2Fb", "a%2Fb" },
                { "a/b/c/_refresh", "a%2Fb%2Fc%2F_refresh", "a%2Fb%2Fc%2F_refresh" },
                { "a:b:c:d:e::1.0", "a%3Ab%3Ac%3Ad%3Ae%3A%3A1.0", "a:b:c:d:e::1.0" },
                { "a,b,c", "a%2Cb%2Cc", "a,b,c" } }
        );
    }

    private final String decoded;
    private final String encodedRFC3986Unreserved;
    private final String encodedRFC3986PathSafe;

    public PercentCodecTest(String decoded, String encodedRFC3986Unreserved, String encodedRFC3986PathSafe) {
        this.decoded = decoded;
        this.encodedRFC3986Unreserved = encodedRFC3986Unreserved;
        this.encodedRFC3986PathSafe = encodedRFC3986PathSafe;
    }

    @Test
    public void test_RFC3986_UNRESERVED_encoding() {
        assertEquals(this.encodedRFC3986Unreserved, PercentCodec.RFC3986_UNRESERVED.encode(this.decoded));
    }

    @Test
    public void test_RFC3986_UNRESERVED_decoding() {
        assertEquals(this.decoded, PercentCodec.RFC3986_UNRESERVED.decode(this.encodedRFC3986Unreserved));
    }

    @Test
    public void test_RFC3986_PATHSAFE_encoding() {
        assertEquals(this.encodedRFC3986PathSafe, PercentCodec.RFC3986_PATHSAFE.encode(this.decoded));
    }

    @Test
    public void test_RFC3986_PATHSAFE_decoding() {
        assertEquals(this.decoded, PercentCodec.RFC3986_PATHSAFE.decode(this.encodedRFC3986PathSafe));
    }
}
