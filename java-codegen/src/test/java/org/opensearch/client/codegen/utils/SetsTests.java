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

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SetsTests {
    @Test
    public void unmodifiableOpt_withNullSet_shouldReturnEmptyOptional() {
        assertTrue(Sets.unmodifiableOpt(null).isEmpty());
    }

    @Test
    public void unmodifiableOpt_withNonNullSet_shouldReturnUnmodifiableSet() {
        var opt = Sets.unmodifiableOpt(new HashSet<>(List.of("foobar")));
        assertTrue(opt.isPresent());
        var set = opt.get();
        assertEquals(1, set.size());
        assertEquals("foobar", set.iterator().next());
        assertEquals("java.util.Collections$UnmodifiableSet", set.getClass().getName());
        assertThrowsExactly(UnsupportedOperationException.class, () -> set.add("hello world"));
    }
}
