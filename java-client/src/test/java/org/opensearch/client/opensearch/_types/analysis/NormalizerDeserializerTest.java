/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.analysis;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class NormalizerDeserializerTest extends ModelTestCase {

    @Test
    public void deserializesTypelessCustomAnalyzer() {
        String json = "{\n" + "          \"filter\": \"lowercase\"\n" + "      }";

        Normalizer normalizer = fromJson(json, Normalizer._DESERIALIZER);
        assertTrue(normalizer.isCustom());
        assertEquals("lowercase", normalizer.custom().filter().get(0));
    }
}
