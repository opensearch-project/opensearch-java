/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

package org.opensearch.client.opensearch.model;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.Test;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapperAttributes;
import org.opensearch.client.opensearch._types.aggregations.Aggregate;
import org.opensearch.client.opensearch._types.aggregations.AvgAggregate;
import org.opensearch.client.opensearch._types.aggregations.StringTermsAggregate;
import org.opensearch.client.opensearch._types.aggregations.StringTermsBucket;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.core.search.TotalHitsRelation;
import org.opensearch.client.util.ListBuilder;
import org.opensearch.client.util.MapBuilder;

public class TypedKeysTest extends ModelTestCase {

    @Test
    public void testMapProperty() {

        SearchResponse<Void> resp = new SearchResponse.Builder<Void>().aggregations("foo", _2 -> _2.avg(_3 -> _3.value(3.14)))
            // Required properties on a SearchResponse
            .took(1)
            .shards(_1 -> _1.successful(1).failed(0).total(1))
            .hits(_1 -> _1.total(_2 -> _2.value(0).relation(TotalHitsRelation.Eq)).hits(Collections.emptyList()))
            .timedOut(false)
            .build();

        String json = "{\"took\":1,\"timed_out\":false,\"_shards\":{\"failed\":0,\"successful\":1,\"total\":1},"
            + "\"hits\":{\"hits\":[],\"total\":{\"relation\":\"eq\",\"value\":0}},\"aggregations\":{\"avg#foo\":{\"value\":3.14}}}";

        assertEquals(json, toJson(resp));

        resp = fromJson(json, SearchResponse.createSearchResponseDeserializer(JsonpDeserializer.voidDeserializer()));

        assertEquals(1, resp.took());
        assertEquals(3.14, resp.aggregations().get("foo").avg().value(), 0.001);

    }

    @Test
    public void testAdditionalProperties() {

        Aggregate avg1 = AvgAggregate.of(_1 -> _1.value(1.0)).toAggregate();
        Aggregate avg2 = AvgAggregate.of(_1 -> _1.value(2.0)).toAggregate();

        Aggregate aggregate = StringTermsAggregate.of(
            _0 -> _0.sumOtherDocCount(1L)
                .buckets(
                    b -> b.array(
                        ListBuilder.of(StringTermsBucket.Builder::new)
                            .add(_1 -> _1.key("key_1").docCount(1).aggregations(MapBuilder.of("bar", avg1)))
                            .add(_1 -> _1.key("key_2").docCount(2).aggregations(MapBuilder.of("bar", avg2)))
                            .build()
                    )
                )
        ).toAggregate();

        SearchResponse<Void> resp = new SearchResponse.Builder<Void>().aggregations("foo", aggregate)
            // Required properties on a SearchResponse
            .took(1)
            .shards(_1 -> _1.successful(1).failed(0).total(1))
            .hits(_1 -> _1.total(_2 -> _2.value(0).relation(TotalHitsRelation.Eq)).hits(Collections.emptyList()))
            .timedOut(false)
            .build();

        String json = "{\"took\":1,\"timed_out\":false,\"_shards\":{\"failed\":0,\"successful\":1,\"total\":1},"
            + "\"hits\":{\"hits\":[],\"total\":{\"relation\":\"eq\",\"value\":0}},"
            + "\"aggregations\":{\"sterms#foo\":{\"buckets\":["
            + "{\"avg#bar\":{\"value\":1.0},\"doc_count\":1,\"key\":\"key_1\"},"
            + "{\"avg#bar\":{\"value\":2.0},\"doc_count\":2,\"key\":\"key_2\"}"
            + "],\"sum_other_doc_count\":1}}}";

        assertEquals(json, toJson(resp));
        resp = fromJson(json, SearchResponse.createSearchResponseDeserializer(JsonpDeserializer.voidDeserializer()));

        StringTermsAggregate foo = resp.aggregations().get("foo").sterms();
        assertEquals((Long) 1L, foo.sumOtherDocCount());
        assertEquals(1, foo.buckets().array().get(0).docCount());
        assertEquals("key_1", foo.buckets().array().get(0).key());
        assertEquals(1.0, foo.buckets().array().get(0).aggregations().get("bar").avg().value(), 0.01);
        assertEquals("key_2", foo.buckets().array().get(1).key());
        assertEquals(2.0, foo.buckets().array().get(1).aggregations().get("bar").avg().value(), 0.01);
    }

    @Test
    public void testDisablingSerializeTypedKeys() {
        SearchResponse<ObjectNode> resp = new SearchResponse.Builder<ObjectNode>().aggregations(
            "aggKey",
            v -> v.lterms(lv -> lv.buckets(b -> b.array(new ArrayList<>())).sumOtherDocCount(0L))
        ).took(0).timedOut(false).shards(s -> s.failed(0).successful(1).total(1)).hits(h -> h.hits(new ArrayList<>())).build();

        String json =
            "{\"took\":0,\"timed_out\":false,\"_shards\":{\"failed\":0,\"successful\":1,\"total\":1},\"hits\":{\"hits\":[]},\"aggregations\":{\"aggKey\":{\"buckets\":[],\"sum_other_doc_count\":0}}}";

        assertEquals(json, toJson(resp, mapper.withAttribute(JsonpMapperAttributes.SERIALIZE_TYPED_KEYS, false)));
    }
}
