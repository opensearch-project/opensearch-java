/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class MapsTests {
    @Test
    public void unmodifiableOpt_withNullMap_shouldReturnEmptyOptional() {
        assertTrue(Maps.unmodifiableOpt(null).isEmpty());
    }

    @Test
    public void unmodifiableOpt_withNonNullMap_shouldReturnUnmodifiableMap() {
        var opt = Maps.unmodifiableOpt(new HashMap<String, String>() {
            {
                put("foo", "bar");
            }
        });
        assertTrue(opt.isPresent());
        var map = opt.get();
        assertEquals(1, map.size());
        assertEquals("bar", map.get("foo"));
        assertEquals("java.util.Collections$UnmodifiableMap", map.getClass().getName());
        assertThrowsExactly(UnsupportedOperationException.class, () -> map.put("hello", "world"));
    }

    @Test
    public void transform_shouldTransformIntoNewMap() {
        var input = new HashMap<>() {
            {
                put("foo", "bar");
                put("hello", "world");
            }
        };

        var output = Maps.transform(input, (k, v) -> v, (k, v) -> k + "-" + v);

        assertEquals(Map.of("foo", "bar", "hello", "world"), input);
        assertEquals(Map.of("bar", "foo-bar", "world", "hello-world"), output);
    }
}
