/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Test;
import org.opensearch.Version;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.SortOrder;
import org.opensearch.client.opensearch._types.aggregations.Aggregation;
import org.opensearch.client.opensearch._types.aggregations.CompositeAggregation;
import org.opensearch.client.opensearch._types.aggregations.CompositeAggregationSource;
import org.opensearch.client.opensearch._types.aggregations.CompositeBucket;
import org.opensearch.client.opensearch._types.mapping.Property;
import org.opensearch.client.opensearch._types.query_dsl.MatchQuery;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch._types.query_dsl.QueryBuilders;
import org.opensearch.client.opensearch._types.query_dsl.TermQuery;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.indices.DeleteIndexRequest;
import org.opensearch.client.opensearch.indices.SegmentSortOrder;

public abstract class AbstractSearchRequestIT extends OpenSearchJavaClientTestCase {

    @Test
    public void shouldReturnSearchResults() throws Exception {
        final String index = "search_request";
        createIndex(index);

        final Query query = Query.of(
            q -> q.bool(
                builder -> builder.filter(filter -> filter.term(TermQuery.of(term -> term.field("size").value(FieldValue.of("huge")))))
            )
        );

        final SearchRequest request = SearchRequest.of(
            r -> r.index(index)
                .sort(s -> s.field(f -> f.field("name").order(SortOrder.Asc)))
                .fields(f -> f.field("name"))
                .query(query)
                .source(s -> s.fetch(true))
        );

        final SearchResponse<ShopItem> response = javaClient().search(request, ShopItem.class);
        assertEquals(response.hits().hits().size(), 2);

        assertTrue(
            Arrays.stream(response.hits().hits().get(0).fields().get("name").to(String[].class))
                .collect(Collectors.toList())
                .contains("hummer")
        );
        assertTrue(
            Arrays.stream(response.hits().hits().get(1).fields().get("name").to(String[].class))
                .collect(Collectors.toList())
                .contains("jammer")
        );
    }

    @Test
    public void shouldReturnSearchResultsWithCompositeAgg() throws Exception {
        final String index = "search_request";
        createIndex(index);

        final Query query = Query.of(
            q -> q.bool(
                builder -> builder.filter(filter -> filter.term(TermQuery.of(term -> term.field("size").value(FieldValue.of("huge")))))
            )
        );

        final Map<String, CompositeAggregationSource> comAggrSrcMap = new HashMap<>();
        CompositeAggregationSource compositeAggregationSource1 = new CompositeAggregationSource.Builder().terms(
            termsAggrBuilder -> termsAggrBuilder.field("quantity").missingBucket(false).order(SortOrder.Asc)
        ).build();
        comAggrSrcMap.put("quantity", compositeAggregationSource1);

        CompositeAggregation compAgg = new CompositeAggregation.Builder().sources(comAggrSrcMap).build();

        Aggregation aggregation = new Aggregation.Builder().composite(compAgg).build();

        final SearchRequest request = SearchRequest.of(r -> r.index(index).query(query).aggregations("my_buckets", aggregation));

        final SearchResponse<ShopItem> response = javaClient().search(request, ShopItem.class);
        assertEquals(response.hits().hits().size(), 2);
        for (Map.Entry<String, Aggregation> entry : response.aggregations().entrySet()) {
            CompositeAggregation compositeAggregation = entry.getValue().composite();
            assertEquals(2, compositeAggregation.buckets().size());
            assertEquals(1, Integer.parseInt(compositeAggregation.buckets().get(0).key().get("quantity").toString()));
            assertEquals(1, compositeAggregation.buckets().get(0).docCount());
            assertEquals(2, Integer.parseInt(compositeAggregation.buckets().get(1).key().get("quantity").toString()));
            assertEquals(1, compositeAggregation.buckets().get(1).docCount());
        }
        List<CompositeBucket> buckets = response.aggregations()
            .entrySet()
            .stream()
            .filter(e -> e.getKey().equals("my_buckets"))
            .map(e -> e.getValue().composite().buckets().array())
            .flatMap(List::stream)
            .collect(Collectors.toList());
        assertEquals(2, buckets.size());
        assertEquals(1, Integer.parseInt(buckets.get(0).key().get("quantity").toString()));
        assertEquals(1, buckets.get(0).docCount());
        assertEquals(2, Integer.parseInt(buckets.get(1).key().get("quantity").toString()));
        assertEquals(1, buckets.get(1).docCount());
    }

    @Test
    public void hybridSearchShouldReturnSearchResults() throws Exception {
        assumeTrue("Hybrid search is supported from 2.10.0", getServerVersion().onOrAfter(Version.V_2_10_0));
        final String index = "hybrid_search_request";
        try {
            createIndex(index);
            final Query query = Query.of(
                h -> h.hybrid(
                    q -> q.queries(Arrays.asList(new MatchQuery.Builder().field("size").query(FieldValue.of("huge")).build().toQuery()))
                )
            );

            final SearchRequest request = SearchRequest.of(
                r -> r.index(index)
                    .sort(s -> s.field(f -> f.field("name").order(SortOrder.Asc)))
                    .fields(f -> f.field("name"))
                    .query(query)
                    .source(s -> s.fetch(true))
            );

            final SearchResponse<ShopItem> response = javaClient().search(request, ShopItem.class);
            assertEquals(response.hits().hits().size(), 5);

            assertTrue(
                Arrays.stream(response.hits().hits().get(2).fields().get("name").to(String[].class))
                    .collect(Collectors.toList())
                    .contains("hummer")
            );
            assertTrue(
                Arrays.stream(response.hits().hits().get(3).fields().get("name").to(String[].class))
                    .collect(Collectors.toList())
                    .contains("jammer")
            );
        } finally {
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest.Builder().index(index).build();
            javaClient().indices().delete(deleteIndexRequest);
        }
    }

    @Test
    public void shouldReturnSearchResultsWithoutStoredFields() throws Exception {
        final String index = "search_request";
        createIndex(index);

        final Query query = Query.of(
            q -> q.bool(
                builder -> builder.filter(filter -> filter.term(TermQuery.of(term -> term.field("size").value(FieldValue.of("huge")))))
            )
        );

        final SearchRequest request = SearchRequest.of(
            r -> r.index(index).sort(s -> s.field(f -> f.field("name").order(SortOrder.Asc))).query(query).storedFields("_none_")
        );

        final SearchResponse<ShopItem> response = javaClient().search(request, ShopItem.class);
        assertEquals(response.hits().hits().size(), 2);
        assertNull(response.hits().hits().get(0).id());
        assertNull(response.hits().hits().get(1).id());
    }

    @Test
    public void shouldReturnSearchResultsWithExt() throws Exception {
        final String index = "search_request";
        createIndex(index);

        final SearchRequest request = SearchRequest.of(
            r -> r.index(index)
                .sort(s -> s.field(f -> f.field("name").order(SortOrder.Asc)))
                .query(b -> b.matchAll(QueryBuilders.matchAll().build()))
                .ext(Map.of())
        );

        final SearchResponse<ShopItem> response = javaClient().search(request, ShopItem.class);
        assertEquals(response.hits().hits().size(), 8);
    }

    private void createTestDocuments(String index) throws IOException {
        javaClient().create(_1 -> _1.index(index).id("1").document(createItem("hummer", "huge", "yes", 2)));
        javaClient().create(_1 -> _1.index(index).id("2").document(createItem("jammer", "huge", "yes", 1)));
        javaClient().create(_1 -> _1.index(index).id("3").document(createItem("hammer", "large", "yes", 3)));
        javaClient().create(_1 -> _1.index(index).id("4").document(createItem("drill", "large", "yes", 3)));
        javaClient().create(_1 -> _1.index(index).id("5").document(createItem("jack", "medium", "yes", 2)));
        javaClient().create(_1 -> _1.index(index).id("6").document(createItem("wrench", "medium", "no", 3)));
        javaClient().create(_1 -> _1.index(index).id("7").document(createItem("screws", "small", "no", 1)));
        javaClient().create(_1 -> _1.index(index).id("8").document(createItem("nuts", "small", "no", 2)));
    }

    private void createIndex(String index) throws IOException {
        assertTrue(
            javaClient().indices()
                .create(
                    b -> b.index(index)
                        .mappings(
                            m -> m.properties("name", Property.of(p -> p.keyword(v -> v.docValues(true))))
                                .properties("size", Property.of(p -> p.keyword(v -> v.docValues(true))))
                        )
                        .settings(settings -> settings.sort(s -> s.field("name").order(SegmentSortOrder.Asc)))
                )
                .acknowledged()
        );
        createTestDocuments(index);
        javaClient().indices().refresh();
    }

    private ShopItem createItem(String name, String size, String company, int quantity) {
        return new ShopItem(name, size, company, quantity);
    }

    public static class ShopItem {
        private String name;
        private String size;
        private String company;
        private int quantity;

        public ShopItem() {}

        public ShopItem(String name, String size, String company, int quantity) {
            this.name = name;
            this.size = size;
            this.company = company;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
