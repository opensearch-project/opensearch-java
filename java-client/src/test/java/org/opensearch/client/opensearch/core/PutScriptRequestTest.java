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
import org.opensearch.client.opensearch._types.StoredScript;

public class PutScriptRequestTest extends Assert {

    @Test
    public void toBuilder() {
        PutScriptRequest origin = new PutScriptRequest.Builder().id("id")
            .script(StoredScript.of(a -> a.lang(l -> l.custom("lang")).source("source")))
            .build();
        PutScriptRequest copied = origin.toBuilder().build();

        assertEquals(copied.id(), origin.id());
    }
}
