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

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListsTests {
    @Test
    public void unmodifiableOpt_withNullList_shouldReturnEmptyOptional() {
        assertTrue(Lists.unmodifiableOpt(null).isEmpty());
    }

    @Test
    public void unmodifiableOpt_withNonNullList_shouldReturnUnmodifiableList() {
        var opt = Lists.unmodifiableOpt(new ArrayList<String>() {
            {
                add("foobar");
            }
        });
        assertTrue(opt.isPresent());
        var list = opt.get();
        assertEquals(1, list.size());
        assertEquals("foobar", list.get(0));
        assertEquals("java.util.Collections$UnmodifiableRandomAccessList", list.getClass().getName());
        assertThrowsExactly(UnsupportedOperationException.class, () -> list.add("hello world"));
    }

    @Test
    public void map_shouldMapIntoNewList() {
        var input = new ArrayList<>() {
            {
                add("foobar");
                add("hello world");
            }
        };

        var output = Lists.map(input, (i, v) -> i + "-" + v);

        assertEquals(List.of("foobar", "hello world"), input);
        assertEquals(List.of("0-foobar", "1-hello world"), output);
    }
}
