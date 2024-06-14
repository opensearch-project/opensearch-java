/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class FieldLookupTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        FieldLookup origin = new FieldLookup.Builder().id("id").build();
        FieldLookup copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
