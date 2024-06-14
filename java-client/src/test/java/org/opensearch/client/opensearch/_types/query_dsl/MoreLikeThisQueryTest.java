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

public class MoreLikeThisQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        MoreLikeThisQuery origin = new MoreLikeThisQuery.Builder().like(new Like.Builder().text("text").build()).build();
        MoreLikeThisQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
