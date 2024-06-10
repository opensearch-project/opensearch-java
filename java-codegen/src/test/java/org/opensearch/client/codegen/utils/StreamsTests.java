/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.HashMap;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class StreamsTests {
    @Test
    public void sortedBy() {
        var stream = Stream.of("a", "b", "c", "d", "e");
        var ordering = new HashMap<String, Integer>() {
            {
                put("c", 1);
                put("e", 2);
                put("a", 3);
                put("d", 4);
                put("b", 5);
            }
        };
        var output = Streams.sortedBy(stream, ordering::get).toArray(String[]::new);
        assertArrayEquals(new String[] { "c", "e", "a", "d", "b" }, output);
    }
}
