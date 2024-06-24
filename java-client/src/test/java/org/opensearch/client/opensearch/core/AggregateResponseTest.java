/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.json.stream.JsonParser;
import java.io.StringReader;
import java.util.Map;
import org.junit.Test;
import org.opensearch.client.opensearch._types.aggregations.Aggregate;
import org.opensearch.client.opensearch._types.aggregations.ParentAggregate;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class AggregateResponseTest extends ModelTestCase {

    @Test
    public void shouldCreateParentAggregate() {
        // given
        final Aggregate aggregate = Aggregate.of((b) -> b.parent((p) -> p.docCount(789L)));

        // when
        final ParentAggregate parentAggregate = aggregate.parent();

        // then
        assertEquals(parentAggregate._aggregateKind(), Aggregate.Kind.Parent);
        assertEquals(parentAggregate.docCount(), 789L);
    }

    @Test
    public void shouldDeserializeParentAggregate() throws JsonProcessingException {
        // given
        final String parentAggreationJson = "{\"took\": 3,\"timed_out\": false,"
            + "\"_shards\": {\"total\": 1,\"successful\": 1,\"skipped\": 0,\"failed\": 0},"
            + "\"hits\": {\"total\": {\"value\": 0,\"relation\": \"eq\"},\"hits\": []},"
            + "\"aggregations\": {\"parent#foo\": {\"doc_count\": 123456}}}";
        final JsonParser parser = mapper.jsonProvider().createParser(new StringReader(parentAggreationJson));

        // when
        final SearchResponse<Object> response = SearchResponse._DESERIALIZER.deserialize(parser, mapper);

        // then
        final Map<String, Aggregate> aggregations = response.aggregations();
        assertFalse(aggregations.isEmpty());
        assertTrue(aggregations.containsKey("foo"));
        assertEquals(aggregations.get("foo").parent()._aggregateKind(), Aggregate.Kind.Parent);
        assertEquals(aggregations.get("foo").parent().docCount(), 123456L);
    }
}
