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

package org.opensearch.client.documentation;

import org.opensearch.client.opensearch.OpenSearchAsyncClient;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch._types.NodeStatistics;
import org.opensearch.client.opensearch._types.SortOrder;
import org.opensearch.client.opensearch._types.aggregations.Aggregation;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.indices.Alias;
import org.opensearch.client.opensearch.indices.CreateIndexRequest;
import org.opensearch.client.opensearch.indices.CreateIndexResponse;
import org.opensearch.client.transport.ElasticsearchTransport;
import org.opensearch.client.transport.TransportException;
import org.opensearch.client.util.ApiTypeHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ApiConventionsTest extends Assert {

    private static class SomeApplicationData {}

    private ElasticsearchTransport transport = new FailingTransport();
    Logger logger = LogManager.getLogManager().getLogger(ApiConventionsTest.class.getName());

    @Test(expected = TransportException.class)
    public void blockingAndAsync() throws Exception {

        //tag::blocking-and-async
        // Synchronous blocking client
        OpenSearchClient client = new OpenSearchClient(transport);

        if (client.exists(b -> b.index("products").id("foo")).value()) {
            logger.info("product exists");
        }

        // Asynchronous non-blocking client
        OpenSearchAsyncClient asyncClient =
            new OpenSearchAsyncClient(transport);

        asyncClient
            .exists(b -> b.index("products").id("foo"))
            .thenAccept(response -> {
                if (response.value()) {
                    logger.info("product exists");
                }
            });
        //end::blocking-and-async

    }

    @Test(expected = TransportException.class)
    public void builders() throws Exception {
        OpenSearchClient client = new OpenSearchClient(transport);

        //tag::builders
        CreateIndexResponse createResponse = client.indices().create(
            new CreateIndexRequest.Builder()
                .index("my-index")
                .aliases("foo",
                    new Alias.Builder().isWriteIndex(true).build()
                )
                .build()
        );
        //end::builders
    }

    @Test(expected = TransportException.class)
    public void builderLambdas() throws Exception {
        OpenSearchClient client = new OpenSearchClient(transport);

        //tag::builder-lambdas
        CreateIndexResponse createResponse = client.indices()
            .create(createIndexBuilder -> createIndexBuilder
                .index("my-index")
                .aliases("foo", aliasBuilder -> aliasBuilder
                    .isWriteIndex(true)
                )
            );
        //end::builder-lambdas
    }

    @Test(expected = TransportException.class)
    public void builderLambdasShort() throws Exception {
        OpenSearchClient client = new OpenSearchClient(transport);

        //tag::builder-lambdas-short
        CreateIndexResponse createResponse = client.indices()
            .create(c -> c
                .index("my-index")
                .aliases("foo", a -> a
                    .isWriteIndex(true)
                )
            );
        //end::builder-lambdas-short
    }

    @Test(expected = TransportException.class)
    public void builderIntervals() throws Exception {
        OpenSearchClient client = new OpenSearchClient(transport);

        //tag::builder-intervals
        SearchResponse<SomeApplicationData> results = client
            .search(_0 -> _0
                .query(_1 -> _1
                    .intervals(_2 -> _2
                        .field("my_text")
                        .allOf(_3 -> _3
                            .ordered(true)
                            .intervals(_4 -> _4
                                .match(_5 -> _5
                                    .query("my favorite food")
                                    .maxGaps(0)
                                    .ordered(true)
                                )
                            )
                            .intervals(_4 -> _4
                                .anyOf(_5 -> _5
                                    .intervals(_6 -> _6
                                        .match(_7 -> _7
                                            .query("hot water")
                                        )
                                    )
                                    .intervals(_6 -> _6
                                        .match(_7 -> _7
                                            .query("cold porridge")
                                        )
                                    )
                                )
                            )
                        )
                    )
                ),
            SomeApplicationData.class // <1>
        );
        //end::builder-intervals
    }

    @Test
    public void variantCreation() {
        //tag::variant-creation
        Query query = new Query.Builder()
            .term(t -> t                          // <1>
                .field("name")                    // <2>
                .value(v -> v.stringValue("foo"))
            )
            .build();                             // <3>
        //end::variant-creation

        //tag::variant-navigation
        assertEquals("foo", query.term().value().stringValue());
        //end::variant-navigation

        //tag::variant-kind
        if (query.isTerm()) { // <1>
            doSomething(query.term());
        }

        switch(query._kind()) { // <2>
            case Term:
                doSomething(query.term());
                break;
            case Intervals:
                doSomething(query.intervals());
                break;
            default:
                doSomething(query._kind(), query._get()); // <3>
        }
        //end::variant-kind
    }

    @Test
    public void collections() {
        //tag::collections-list
        // Prepare a list of index names
        List<String> names = Arrays.asList("idx-a", "idx-b", "idx-c");

        // Prepare cardinality aggregations for fields "foo" and "bar"
        Map<String, Aggregation> cardinalities = new HashMap<>();
        cardinalities.put("foo-count", Aggregation.of(a -> a.cardinality(c -> c.field("foo"))));
        cardinalities.put("bar-count", Aggregation.of(a -> a.cardinality(c -> c.field("bar"))));

        // Prepare an aggregation that computes the average of the "size" field
        final Aggregation avgSize = Aggregation.of(a -> a.avg(v -> v.field("size")));

        SearchRequest search = SearchRequest.of(r -> r
            // Index list:
            // - add all elements of a list
            .index(names)
            // - add a single element
            .index("idx-d")
            // - add a vararg list of elements
            .index("idx-e", "idx-f", "idx-g")

            // Sort order list: add elements defined by builder lambdas
            .sort(s -> s.field(f -> f.field("foo").order(SortOrder.Asc)))
            .sort(s -> s.field(f -> f.field("bar").order(SortOrder.Desc)))

            // Aggregation map:
            // - add all entries of an existing map
            .aggregations(cardinalities)
            // - add a key/value entry
            .aggregations("avg-size", avgSize)
            // - add a key/value defined by a builder lambda
            .aggregations("price-histogram",
                a -> a.histogram(h -> h.field("price")))
        );
        //end::collections-list

    }

    @Test
    public void optionalCollections() {
        //tag::optional-collections
        NodeStatistics stats = NodeStatistics.of(b -> b
            .total(1)
            .failed(0)
            .successful(1)
        );

        // The `failures` list was not provided.
        // - it's not null
        assertNotNull(stats.failures());
        // - it's empty
        assertEquals(0, stats.failures().size());
        // - and if needed we can know it was actually not defined
        assertFalse(ApiTypeHelper.isDefined(stats.failures()));
        //end::optional-collections
    }

    private void doSomething(Object... o) {

    }
}
