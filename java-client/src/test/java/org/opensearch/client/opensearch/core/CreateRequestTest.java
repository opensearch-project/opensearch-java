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

public class CreateRequestTest extends Assert {

    @Test
    public void toBuilder() {
        CreateRequest<MyDoc> origin = new CreateRequest.Builder<MyDoc>().id("id").document(new MyDoc("1")).index("index").build();
        CreateRequest<MyDoc> copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }

    static class MyDoc {
        String key;

        MyDoc(String key) {
            this.key = key;
        }
    }
}
