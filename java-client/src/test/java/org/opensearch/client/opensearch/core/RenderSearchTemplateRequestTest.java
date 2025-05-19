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

public class RenderSearchTemplateRequestTest extends Assert {

    @Test
    public void toBuilder() {
        RenderSearchTemplateRequest origin = new RenderSearchTemplateRequest.Builder().id("id").build();
        RenderSearchTemplateRequest copied = origin.toBuilder().build();

        assertEquals(copied.id(), origin.id());
    }
}
