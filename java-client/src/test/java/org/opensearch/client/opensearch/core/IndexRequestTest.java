/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core;

import org.junit.Assert;
import org.junit.Test;

public class IndexRequestTest extends Assert {

    @Test
    public void toBuilder() {
        IndexRequest<MyDoc> origin = new IndexRequest.Builder<MyDoc>().id("id").index("index").document(new MyDoc("1")).build();
        IndexRequest<MyDoc> copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }

    static class MyDoc {
        String key;

        MyDoc(String key) {
            this.key = key;
        }
    }
}
