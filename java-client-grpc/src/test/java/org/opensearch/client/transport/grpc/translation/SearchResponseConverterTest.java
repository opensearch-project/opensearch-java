/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc.translation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.protobuf.ByteString;
import jakarta.json.JsonNumber;
import jakarta.json.JsonString;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jackson3.JacksonJsonpMapper;
import org.opensearch.client.opensearch._types.ShardSearchFailure;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.core.search.Hit;
import org.opensearch.protobufs.ErrorCause;
import org.opensearch.protobufs.HitMatchedQueries;
import org.opensearch.protobufs.HitsMetadata;
import org.opensearch.protobufs.HitsMetadataHitsInner;
import org.opensearch.protobufs.ObjectMap;
import org.opensearch.protobufs.ShardFailure;
import org.opensearch.protobufs.ShardStatistics;
import org.opensearch.protobufs.StringArray;

/** Search responses over gRPC carry what the same response over REST does. */
public class SearchResponseConverterTest {

    private final JsonpMapper mapper = new JacksonJsonpMapper();

    @Test
    public void testHitFieldsAndMatchedQueries() {
        HitsMetadataHitsInner hit = hit().setFields(
            ObjectMap.newBuilder()
                .putFields("@timestamp", list(ObjectMap.Value.newBuilder().setInt64(1700000000000L).build()))
                .putFields("price", list(ObjectMap.Value.newBuilder().setFloat(0.1f).build()))
                .putFields("tags", list(string("a"), string("b")))
                .putFields(
                    "geo",
                    list(
                        ObjectMap.Value.newBuilder()
                            .setObjectMap(
                                ObjectMap.newBuilder()
                                    .putFields("lat", ObjectMap.Value.newBuilder().setDouble(52.5).build())
                                    .putFields("known", ObjectMap.Value.newBuilder().setBool(true).build())
                            )
                            .build()
                    )
                )
        ).setMatchedQueries2(HitMatchedQueries.newBuilder().setNames(StringArray.newBuilder().addStringArray("q1"))).build();

        Hit<Object> converted = convert(hit);
        Map<String, JsonData> fields = converted.fields();
        assertEquals("[1700000000000]", fields.get("@timestamp").toJson().toString());
        // The float as JSON has it, not the decimal of its double
        assertEquals("[0.1]", fields.get("price").toJson().toString());
        assertEquals(List.of("a", "b"), fields.get("tags").toJson().asJsonArray().getValuesAs(JsonString::getString));
        assertEquals(52.5, fields.get("geo").toJson().asJsonArray().getJsonObject(0).getJsonNumber("lat").doubleValue(), 0);
        assertTrue(fields.get("geo").toJson().asJsonArray().getJsonObject(0).getBoolean("known"));
        assertEquals(List.of("q1"), converted.matchedQueries().names());
    }

    @Test
    public void testMatchedQueriesWithScores() {
        HitsMetadataHitsInner hit = hit().setMatchedQueries2(
            HitMatchedQueries.newBuilder().setScores(org.opensearch.protobufs.DoubleMap.newBuilder().putDoubleMap("q1", 1.5))
        ).build();
        assertEquals(Map.of("q1", 1.5), convert(hit).matchedQueries().scores());
    }

    @Test
    public void testMetadataFields() {
        HitsMetadataHitsInner hit = hit().setMetaFields(
            ObjectMap.newBuilder()
                .putFields("_routing", list(string("tenant-7")))
                .putFields("_ignored", list(string("title"), string("body")))
                .putFields("_size", list(ObjectMap.Value.newBuilder().setInt32(42).build()))
        ).build();
        Hit<Object> converted = convert(hit);
        assertEquals("tenant-7", converted.routing());
        assertEquals(List.of("title", "body"), converted.ignored());
        assertEquals(42, ((JsonNumber) converted.metaFields().get("_size").toJson()).intValue());
    }

    @Test
    public void testIgnoredSentTwiceIsListedOnce() {
        HitsMetadataHitsInner hit = hit().addXIgnored("title")
            .setMetaFields(ObjectMap.newBuilder().putFields("_ignored", list(string("title"))))
            .build();
        assertEquals(List.of("title"), convert(hit).ignored());
    }

    @Test
    public void testShardStatisticsAndClusters() {
        org.opensearch.protobufs.SearchResponse response = org.opensearch.protobufs.SearchResponse.newBuilder()
            .setXShards(
                ShardStatistics.newBuilder()
                    .setTotal(5)
                    .setSuccessful(3)
                    .setSkipped(1)
                    .setFailed(1)
                    .addFailures(
                        ShardFailure.newBuilder()
                            .setIndex("logs-2")
                            .setNode("n1")
                            .setShard(2)
                            .setReason(ErrorCause.newBuilder().setType("query_shard_exception").setReason("failed to create query"))
                    )
            )
            .setXClusters(org.opensearch.protobufs.ClusterStatistics.newBuilder().setTotal(2).setSuccessful(1).setSkipped(1))
            .build();
        SearchResponse<Object> converted = SearchResponseConverter.fromProto(response, mapper, Object.class);
        assertEquals(Integer.valueOf(1), converted.shards().skipped());
        assertEquals(1, converted.shards().failures().size());
        ShardSearchFailure failure = converted.shards().failures().get(0);
        assertEquals("logs-2", failure.index());
        assertEquals("n1", failure.node());
        assertEquals(2, failure.shard());
        assertEquals("query_shard_exception", failure.reason().type());
        assertEquals("failed to create query", failure.reason().reason());
        assertEquals(2, converted.clusters().total());
        assertEquals(1, converted.clusters().skipped());
    }

    @Test
    public void testSourceDeserializesWithTheDeserializerOfTheDocumentClass() {
        // A class with its own deserializer, which reads the document from the next event, as for a REST hit
        JsonpMapper withDocumentClass = mapper.withAttribute(
            SearchResponseConverter.DOCUMENT_DESERIALIZER,
            org.opensearch.client.opensearch._types.ErrorCause._DESERIALIZER
        );
        HitsMetadataHitsInner hit = hit().setXSource(ByteString.copyFrom("{\"type\":\"t\",\"reason\":\"r\"}", StandardCharsets.UTF_8))
            .build();
        org.opensearch.client.opensearch._types.ErrorCause source = SearchResponseConverter.fromProto(
            org.opensearch.protobufs.SearchResponse.newBuilder().setHits(HitsMetadata.newBuilder().addHits(hit)).build(),
            withDocumentClass,
            org.opensearch.client.opensearch._types.ErrorCause.class
        ).hits().hits().get(0).source();
        assertEquals("t", source.type());
        assertEquals("r", source.reason());
        assertNull(convert(hit().build()).source());
    }

    private Hit<Object> convert(HitsMetadataHitsInner hit) {
        return SearchResponseConverter.fromProto(
            org.opensearch.protobufs.SearchResponse.newBuilder().setHits(HitsMetadata.newBuilder().addHits(hit)).build(),
            mapper,
            Object.class
        ).hits().hits().get(0);
    }

    private static HitsMetadataHitsInner.Builder hit() {
        return HitsMetadataHitsInner.newBuilder().setXIndex("logs").setXId("1");
    }

    private static ObjectMap.Value string(String value) {
        return ObjectMap.Value.newBuilder().setString(value).build();
    }

    private static ObjectMap.Value list(ObjectMap.Value... values) {
        return ObjectMap.Value.newBuilder().setListValue(ObjectMap.ListValue.newBuilder().addAllValue(List.of(values))).build();
    }
}
