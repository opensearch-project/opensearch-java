package org.opensearch.client.opensearch._types;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;

import org.junit.Test;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;

import jakarta.json.stream.JsonParser;

public class QueryCacheStatsTest {

  @Test
  public void testLongSerailization() {
    QueryCacheStats expected = new QueryCacheStats.Builder().cacheCount(8757938874l)
                                                            .cacheSize(8757938874l)
                                                            .evictions(8757938874l)
                                                            .hitCount(8757938874l)
                                                            .memorySizeInBytes(8757938874l)
                                                            .missCount(8757938874l)
                                                            .totalCount(8757938874l)
                                                            .build();

    String jsonString = "{\"cache_count\": 8757938874, \"cache_size\": 8757938874, \"evictions\":" +
        " 8757938874, \"hit_count\": 8757938874, \"memory_size_in_bytes\": 8757938874, \"miss_count\":" +
        " 8757938874, \"total_count\": 8757938874}";

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
