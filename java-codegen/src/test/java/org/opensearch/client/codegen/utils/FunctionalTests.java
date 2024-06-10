/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class FunctionalTests {
    @Test
    public void ifNonnull_withNullValue_shouldReturnNull() {
        assertNull(Functional.ifNonnull((String) null, Integer::parseInt));
    }

    @Test
    public void ifNonnull_withNonNullValue_shouldReturnMappedValue() {
        var mapped = Functional.ifNonnull("18", Integer::parseInt);
        assertEquals(18, mapped);
    }
}
