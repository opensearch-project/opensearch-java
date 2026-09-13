/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core.search;

import org.junit.Test;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class HitsMetadataTest extends ModelTestCase {
    private final JsonpDeserializer<HitsMetadata<JsonData>> deserializer = HitsMetadata.createHitsMetadataDeserializer(
        JsonData._DESERIALIZER
    );

    @Test
    public void deserializesResponseWithoutHitsArray() {
        // Regression test for #1729: a response with no hits.hits array (empty results or filter_path) must deserialize.
        HitsMetadata<JsonData> hits = fromJson("{\"total\":{\"value\":0,\"relation\":\"eq\"},\"max_score\":null}", deserializer);
        assertNotNull(hits.hits());
        assertTrue(hits.hits().isEmpty());
        assertNotNull(hits.total());
        assertEquals(0L, hits.total().value());
    }

    @Test
    public void deserializesResponseWithHitsArray() {
        HitsMetadata<JsonData> hits = fromJson(
            "{\"total\":{\"value\":1,\"relation\":\"eq\"},\"hits\":[{\"_index\":\"i\",\"_id\":\"1\"}]}",
            deserializer
        );
        assertEquals(1, hits.hits().size());
        assertEquals("i", hits.hits().get(0).index());
    }

    @Test
    public void doesNotSerializeHitsWhenNotSet() {
        // The hits list is no longer required, so an undefined list must be omitted rather than written as an empty array.
        HitsMetadata<JsonData> hits = HitsMetadata.of(h -> h.total(t -> t.value(0).relation(TotalHitsRelation.Eq)));
        assertFalse(toJson(hits).contains("\"hits\""));
    }
}
