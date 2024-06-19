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

public class AnalyzerDeserializerTest extends ModelTestCase {
    @Test
    public void deserializesTypelessCustomAnalyzer() {
        var json = "{\n"
            + "    \"filter\": [\"kuromoji_baseform\", \"ja_stop\"],\n"
            + "    \"char_filter\": [\"icu_normalizer\"],\n"
            + "    \"tokenizer\": \"kuromoji_tokenizer\"\n"
            + "}";

        var analyzer = fromJson(json, Analyzer._DESERIALIZER);
        assertTrue(analyzer.isCustom());
        assertEquals("kuromoji_tokenizer", analyzer.custom().tokenizer());
        assertEquals("icu_normalizer", analyzer.custom().charFilter().get(0));
        assertEquals("kuromoji_baseform", analyzer.custom().filter().get(0));
        assertEquals("ja_stop", analyzer.custom().filter().get(1));
    }
}
