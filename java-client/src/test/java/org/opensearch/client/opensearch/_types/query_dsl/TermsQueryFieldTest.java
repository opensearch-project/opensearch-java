/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.query_dsl;

import java.util.Collections;
import org.junit.Test;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class TermsQueryFieldTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        TermsQueryField origin = new TermsQueryField.Builder().value(Collections.singletonList(FieldValue.of("1"))).build();
        TermsQueryField copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
