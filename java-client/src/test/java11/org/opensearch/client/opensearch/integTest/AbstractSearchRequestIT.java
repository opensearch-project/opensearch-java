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
import java.util.stream.Collectors;
import org.junit.Test;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.SortOrder;
import org.opensearch.client.opensearch._types.mapping.Property;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch._types.query_dsl.TermQuery;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.indices.SegmentSortOrder;

public abstract class AbstractSearchRequestIT extends OpenSearchJavaClientTestCase {

    @Test
    public void shouldReturnSearchResults() throws Exception {
        final String index = "search_request";
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
    public void shouldReturnSearchResultsWithoutStoredFields() throws Exception {
        final String index = "search_request";
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
