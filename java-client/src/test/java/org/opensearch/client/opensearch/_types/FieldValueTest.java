/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class FieldValueTest {

    @Test
    public void testEqualsAndHashCode_string() {
        FieldValue a = FieldValue.of("opensearch");
        FieldValue b = FieldValue.of("opensearch");
        FieldValue c = FieldValue.of("different");

        assertEquals(a, b);
        assertNotEquals(a, c);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void testEqualsAndHashCode_long() {
        FieldValue a = FieldValue.of(42L);
        FieldValue b = FieldValue.of(42L);
        FieldValue c = FieldValue.of(99L);

        assertEquals(a, b);
        assertNotEquals(a, c);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void testEqualsAndHashCode_boolean() {
        FieldValue a = FieldValue.of(true);
        FieldValue b = FieldValue.of(true);
        FieldValue c = FieldValue.of(false);

        assertEquals(a, b);
        assertNotEquals(a, c);
    }

    @Test
    public void testEqualsAndHashCode_null() {
        FieldValue a = FieldValue.NULL;
        FieldValue b = FieldValue.NULL;

        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void testNotEquals_differentTypes() {
        // FieldValue.of(1L) vs FieldValue.of(true) — same raw "value" but different kinds
        FieldValue longVal = FieldValue.of(1L);
        FieldValue boolVal = FieldValue.of(true);

        assertNotEquals(longVal, boolVal);
    }

    @Test
    public void testEquals_reflexive() {
        FieldValue a = FieldValue.of("test");
        assertEquals(a, a);
    }

    @Test
    public void testEquals_null() {
        FieldValue a = FieldValue.of("test");
        assertNotEquals(a, null);
    }
}
