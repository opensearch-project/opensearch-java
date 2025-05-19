/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types;

import static org.junit.Assert.assertEquals;

import jakarta.json.stream.JsonParser;
import java.io.StringReader;
import org.junit.Test;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;

public class QueryCacheStatsTest {

    @Test
    public void testLongSerialization() {
        QueryCacheStats expected = new QueryCacheStats.Builder().cacheCount(2757938871l)
            .cacheSize(1757938872l)
            .evictions(3757938873l)
            .hitCount(4757938874l)
            .memorySizeInBytes(5757938875l)
            .missCount(6757938876l)
            .totalCount(7757938877l)
            .build();

        String jsonString = "{\"cache_count\": 2757938871, \"cache_size\": 1757938872, \"evictions\":"
            + " 3757938873, \"hit_count\": 4757938874, \"memory_size_in_bytes\": 5757938875, \"miss_count\":"
            + " 6757938876, \"total_count\": 7757938877}";

        StringReader reader = new StringReader(jsonString);
        JacksonJsonpMapper mapper = new JacksonJsonpMapper();
        JsonParser parser = mapper.jsonProvider().createParser(reader);
        QueryCacheStats actual = QueryCacheStats._DESERIALIZER.deserialize(parser, mapper);
        assertEquals(expected.hitCount(), actual.hitCount());
        assertEquals(expected.memorySizeInBytes(), actual.memorySizeInBytes());
        assertEquals(expected.missCount(), actual.missCount());
        assertEquals(expected.cacheCount(), actual.cacheCount());
        assertEquals(expected.totalCount(), actual.totalCount());
        assertEquals(expected.cacheSize(), actual.cacheSize());
        assertEquals(expected.evictions(), actual.evictions());
    }
}
