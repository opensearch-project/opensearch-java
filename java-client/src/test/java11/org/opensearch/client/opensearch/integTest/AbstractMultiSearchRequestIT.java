/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import static org.hamcrest.Matchers.hasKey;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.junit.Test;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.opensearch._types.FieldSort;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.InlineScript;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.opensearch._types.ScriptField;
import org.opensearch.client.opensearch._types.SortOptions;
import org.opensearch.client.opensearch._types.SortOrder;
import org.opensearch.client.opensearch._types.query_dsl.FieldAndFormat;
import org.opensearch.client.opensearch._types.query_dsl.FuzzyQuery;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch._types.query_dsl.TermQuery;
import org.opensearch.client.opensearch.core.MsearchResponse;
import org.opensearch.client.opensearch.core.msearch.MultiSearchResponseItem;
import org.opensearch.client.opensearch.core.msearch.MultisearchBody;
import org.opensearch.client.opensearch.core.msearch.RequestItem;
import org.opensearch.client.opensearch.core.search.Highlight;
import org.opensearch.client.opensearch.core.search.HighlightField;
import org.opensearch.client.opensearch.core.search.Hit;
import org.opensearch.client.opensearch.core.search.SourceConfig;
import org.opensearch.client.util.ObjectBuilder;

public abstract class AbstractMultiSearchRequestIT extends OpenSearchJavaClientTestCase {

    @Test
    public void shouldReturnMultipleSearches() throws Exception {
        String index = "multiple_searches_request";
        createTestDocuments(index);

        RequestItem largeItemsQuery = createMSearchQuery("large");
        RequestItem mediumItemsQuery = createMSearchQuery("medium");
        RequestItem smallItemsQuery = createMSearchQuery("small");

        MsearchResponse<ShopItem> response = sendMSearchRequest(index, List.of(largeItemsQuery, mediumItemsQuery, smallItemsQuery));
        assertEquals(3, response.responses().size());
        assertEquals(2, response.responses().get(0).result().hits().hits().size());
        assertEquals(2, response.responses().get(1).result().hits().hits().size());
        assertEquals(2, response.responses().get(2).result().hits().hits().size());
    }

    @Test
    public void shouldReturnHighlightsInMultipleSearches() throws Exception {
        String index = "multiple_searches_request_with_highlights";
        createTestDocuments(index);

        RequestItem largeItemsQuery = createMSearchQueryWithHighlight("large");
        RequestItem mediumItemsQuery = createMSearchQueryWithHighlight("medium");
        RequestItem smallItemsQuery = createMSearchQueryWithHighlight("small");

        MsearchResponse<ShopItem> response = sendMSearchRequest(index, List.of(largeItemsQuery, mediumItemsQuery, smallItemsQuery));
        assertEquals(3, response.responses().size());
        assertResponseHighlights(response.responses().get(0));
        assertResponseHighlights(response.responses().get(1));
        assertResponseHighlights(response.responses().get(2));
    }

    @Test
    public void shouldReturnMultiSearchesWithSelectedSourceFieldsOnly() throws Exception {
        String index = "multiple_searches_request_with_sources";
        createTestDocuments(index);

        RequestItem largeItemsQuery = createMSearchQueryWithSelectedSourceFields("large");
        RequestItem mediumItemsQuery = createMSearchQueryWithSelectedSourceFields("medium");
        RequestItem smallItemsQuery = createMSearchQueryWithSelectedSourceFields("small");

        MsearchResponse<ShopItem> response = sendMSearchRequest(index, List.of(largeItemsQuery, mediumItemsQuery, smallItemsQuery));
        assertEquals(3, response.responses().size());
        assertResponseSources(response.responses().get(0));
        assertResponseSources(response.responses().get(1));
        assertResponseSources(response.responses().get(2));
    }

    @Test
    public void shouldReturnMultiSearchesSorted() throws Exception {
        String index = "multiple_searches_request_sort";
        createTestDocuments(index);

        RequestItem sortedItemsQuery = createMSearchSortedFuzzyRequest();

        MsearchResponse<ShopItem> response = sendMSearchRequest(index, List.of(sortedItemsQuery));
        assertEquals(1, response.responses().size());
        var hits = response.responses().get(0).result().hits().hits();
        assertEquals(3, hits.size());

        assertEquals("hammer", hits.get(2).source().getName());
    }

    @Test
    public void shouldReturnMultiSearchesTrackingScores() throws Exception {
        String index = "multiple_searches_request_track_scores";
        createTestDocuments(index);

        RequestItem sortedItemsQuery = createMSearchSortedFuzzyRequest();

        MsearchResponse<ShopItem> response = sendMSearchRequest(index, List.of(sortedItemsQuery));
        assertEquals(1, response.responses().size());
        var hits = response.responses().get(0).result().hits().hits();
        assertEquals(3, hits.size());
        assertNull(hits.get(0).score());
        assertNull(hits.get(1).score());
        assertNull(hits.get(2).score());

        RequestItem trackScoreItemsQuery = createMSearchSortedFuzzyRequest(b -> b.trackScores(true));

        MsearchResponse<ShopItem> responseTrackingScore = sendMSearchRequest(index, List.of(trackScoreItemsQuery));
        assertEquals(1, responseTrackingScore.responses().size());
        var hitsTrackingScore = responseTrackingScore.responses().get(0).result().hits().hits();
        assertEquals(3, hitsTrackingScore.size());
        assertNotNull(hitsTrackingScore.get(0).score());
        assertNotNull(hitsTrackingScore.get(1).score());
        assertNotNull(hitsTrackingScore.get(2).score());
    }

    @Test
    public void shouldReturnMultiSearchesAboveMinScore() throws Exception {
        String index = "multiple_searches_request_min_score";
        createTestDocuments(index);

        RequestItem sortedItemsQuery = createMSearchFuzzyRequest();

        MsearchResponse<ShopItem> response = sendMSearchRequest(index, List.of(sortedItemsQuery));
        assertEquals(1, response.responses().size());
        var hits = response.responses().get(0).result().hits().hits();
        assertEquals(3, hits.size());

        double minScore = hits.get(2).score();
        double scoreBetweenFirstAndSecondLowest = (hits.get(1).score() + minScore) / 2;

        RequestItem minScoredItemsQuery = createMSearchFuzzyRequest(b -> b.minScore(scoreBetweenFirstAndSecondLowest));

        MsearchResponse<ShopItem> responseAboveMinScore = sendMSearchRequest(index, List.of(minScoredItemsQuery));
        assertEquals(1, responseAboveMinScore.responses().size());
        assertEquals(2, responseAboveMinScore.responses().get(0).result().hits().hits().size());
    }

    @Test
    public void shouldReturnMultiSearchesApplyingPostFilter() throws Exception {
        String index = "multiple_searches_request_post_filter";
        createTestDocuments(index);

        RequestItem filteredItemsQuery = createMSearchFuzzyRequest(b -> b.postFilter(createItemSizeSearchQuery("large")));

        MsearchResponse<ShopItem> response = sendMSearchRequest(index, List.of(filteredItemsQuery));
        assertEquals(1, response.responses().size());
        assertEquals(1, response.responses().get(0).result().hits().hits().size());
    }

    @Test
    public void shouldReturnMultiSearchesSearchAfter() throws Exception {
        String index = "multiple_searches_request_search_after";
        createTestDocuments(index);

        RequestItem sortedItemsQuery = createMSearchSortedFuzzyRequest();

        MsearchResponse<ShopItem> response = sendMSearchRequest(index, List.of(sortedItemsQuery));
        assertEquals(1, response.responses().size());
        assertEquals(3, response.responses().get(0).result().hits().hits().size());

        List<String> sorts = response.responses().get(0).result().hits().hits().get(1).sort();
        RequestItem sortedAfterItemsQuery = createMSearchSortedFuzzyRequest(b -> b.searchAfter(sorts));

        MsearchResponse<ShopItem> response2 = sendMSearchRequest(index, List.of(sortedAfterItemsQuery));
        assertEquals(1, response2.responses().size());
        assertEquals(1, response2.responses().get(0).result().hits().hits().size());
    }

    @Test
    public void shouldReturnMultiSearchesScriptFields() throws Exception {
        String index = "multiple_searches_request_script_fields";
        createTestDocuments(index);

        RequestItem sortedItemsQuery = createMSearchSortedFuzzyRequest();

        MsearchResponse<ShopItem> response = sendMSearchRequest(index, List.of(sortedItemsQuery));
        assertEquals(1, response.responses().size());
        var hits = response.responses().get(0).result().hits().hits();
        assertEquals(3, hits.size());
        assertNull(hits.get(0).score());
        assertNull(hits.get(1).score());
        assertNull(hits.get(2).score());

        Map<String, ScriptField> scriptFields = new HashMap<>();
        scriptFields.put(
            "quantity",
            new ScriptField.Builder().script(
                Script.of(
                    s -> s.inline(
                        new InlineScript.Builder().lang("painless")
                            .source("doc['quantity'].value + params.inc")
                            .params("inc", JsonData.of(1))
                            .build()
                    )
                )
            ).build()
        );

        RequestItem requestItem = createMSearchQueryWithScriptFields("small", scriptFields);

        MsearchResponse<ShopItem> responseWithScriptFields = sendMSearchRequest(index, List.of(requestItem));
        var hitsWithScriptFields = responseWithScriptFields.responses().get(0).result().hits().hits();
        assertEquals(2, hitsWithScriptFields.size());
        // validating that the quantity for small items is increased by 1
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(hitsWithScriptFields.get(0).fields().get("quantity").toString());
        assertEquals(2, (int) mapper.treeToValue(node.get(0), int.class));

        node = mapper.readTree(hitsWithScriptFields.get(1).fields().get("quantity").toString());
        assertEquals(3, (int) mapper.treeToValue(node.get(0), int.class));
    }

    @Test
    public void shouldReturnMultiSearchesFields() throws Exception {
        String index = "multiple_searches_request_fields";
        createTestDocuments(index);

        RequestItem sortedItemsQuery = createMSearchFuzzyRequest(b -> b.fields(FieldAndFormat.of(f -> f.field("name"))));

        MsearchResponse<ShopItem> response = sendMSearchRequest(index, List.of(sortedItemsQuery));
        assertEquals(1, response.responses().size());
        assertEquals(3, response.responses().get(0).result().hits().hits().size());
        assertThat(response.responses().get(0).result().hits().hits().get(0).fields(), hasKey("name"));
        assertThat(response.responses().get(0).result().hits().hits().get(1).fields(), hasKey("name"));
        assertThat(response.responses().get(0).result().hits().hits().get(2).fields(), hasKey("name"));
    }

    @Test
    public void shouldReturnMultiSearchesStoredFields() throws Exception {
        String index = "multiple_searches_request_stored_fields";
        createTestDocuments(index);

        RequestItem sortedItemsQuery = createMSearchFuzzyRequest(b -> b.storedFields("name"));

        MsearchResponse<ShopItem> response = sendMSearchRequest(index, List.of(sortedItemsQuery));
        assertEquals(1, response.responses().size());
        assertEquals(3, response.responses().get(0).result().hits().hits().size());
    }

    @Test
    public void shouldReturnMultiSearchesIndicesBoost() throws Exception {
        String index = "multiple_searches_request_indices_boost";
        createTestDocuments(index);

        RequestItem sortedItemsQuery = createMSearchFuzzyRequest(b -> b.indicesBoost(Collections.singletonMap(index, 2d)));

        MsearchResponse<ShopItem> response = sendMSearchRequest(index, List.of(sortedItemsQuery));
        assertEquals(1, response.responses().size());
        assertEquals(3, response.responses().get(0).result().hits().hits().size());
    }

    private void assertResponseSources(MultiSearchResponseItem<ShopItem> response) {
        List<Hit<ShopItem>> hitsWithHighlights = response.result().hits().hits();
        assertEquals(2, hitsWithHighlights.size());
        for (Hit<ShopItem> shopItemHit : hitsWithHighlights) {
            assertNotNull(shopItemHit.source());
            assertNotNull(shopItemHit.source().getName());
            assertNotNull(shopItemHit.source().getSize());
            assertNull(shopItemHit.source().getCompany());
        }
    }

    private void assertResponseHighlights(MultiSearchResponseItem<ShopItem> response) {
        List<Hit<ShopItem>> hitsWithHighlights = response.result().hits().hits();
        assertEquals(2, hitsWithHighlights.size());
        assertEquals(1, hitsWithHighlights.get(0).highlight().size());
        assertEquals(1, hitsWithHighlights.get(1).highlight().size());
    }

    private RequestItem createMSearchQuery(String itemSize) {
        return createMSearchQuery(itemSize, null, List.of());
    }

    private RequestItem createMSearchQueryWithScriptFields(String itemSize, Map<String, ScriptField> scriptFields) {
        return RequestItem.of(
            item -> item.header(header -> header).body(body -> body.query(createItemSizeSearchQuery(itemSize)).scriptFields(scriptFields))
        );
    }

    private RequestItem createMSearchQueryWithHighlight(String itemSize) {
        return createMSearchQuery(itemSize, "size", List.of());
    }

    private RequestItem createMSearchQueryWithSelectedSourceFields(String itemSize) {
        return createMSearchQuery(itemSize, null, List.of("name", "size"));
    }

    private RequestItem createMSearchQuery(String itemSize, String fieldName, List<String> sources) {
        return RequestItem.of(
            item -> item.header(header -> header)
                .body(
                    body -> body.query(createItemSizeSearchQuery(itemSize))
                        .highlight(createHighlight(fieldName))
                        .source(createSourcesConfig(sources))
                )
        );
    }

    private RequestItem createMSearchSortedFuzzyRequest() {
        return createMSearchSortedFuzzyRequest(b -> b);
    }

    private RequestItem createMSearchSortedFuzzyRequest(Function<MultisearchBody.Builder, ObjectBuilder<MultisearchBody>> additional) {
        return createMSearchFuzzyRequest(
            b -> additional.apply(b.sort(SortOptions.of(sort -> sort.field(FieldSort.of(f -> f.field("quantity").order(SortOrder.Asc))))))
        );
    }

    private RequestItem createMSearchFuzzyRequest() {
        return createMSearchFuzzyRequest(b -> b);
    }

    private RequestItem createMSearchFuzzyRequest(Function<MultisearchBody.Builder, ObjectBuilder<MultisearchBody>> additional) {
        return RequestItem.of(item -> item.header(header -> header).body(b -> additional.apply(b.query(createNameSearchFuzzyQuery()))));
    }

    private Query createNameSearchFuzzyQuery() {
        return Query.of(filter -> filter.fuzzy(FuzzyQuery.of(term -> term.field("name").value(FieldValue.of("rammer")))));
    }

    private SourceConfig createSourcesConfig(List<String> sources) {
        return sources.isEmpty() ? null : SourceConfig.of(builder -> builder.filter(filter -> filter.includes(sources)));
    }

    private Highlight createHighlight(String fieldName) {
        return fieldName != null
            ? Highlight.of(
                builder -> builder.fields(
                    fieldName,
                    HighlightField.of(field -> field.preTags("<em class=\"highlight\">").postTags("</em>"))
                )
            )
            : null;
    }

    private Query createItemSizeSearchQuery(String itemSize) {
        return Query.of(
            query -> query.bool(
                builder -> builder.filter(filter -> filter.term(TermQuery.of(term -> term.field("size").value(FieldValue.of(itemSize)))))
            )
        );
    }

    private MsearchResponse<ShopItem> sendMSearchRequest(String index, List<RequestItem> searches) throws IOException {
        return javaClient().msearch(builder -> builder.index(List.of(index)).searches(searches), ShopItem.class);
    }

    private void createTestDocuments(String index) throws IOException {
        javaClient().create(_1 -> _1.index(index).id("1").document(createItem("hummer", "huge", "yes", 2)).refresh(Refresh.True));
        javaClient().create(_1 -> _1.index(index).id("2").document(createItem("jammer", "huge", "yes", 1)).refresh(Refresh.True));
        javaClient().create(_1 -> _1.index(index).id("3").document(createItem("hammer", "large", "yes", 3)).refresh(Refresh.True));
        javaClient().create(_1 -> _1.index(index).id("4").document(createItem("drill", "large", "yes", 3)).refresh(Refresh.True));
        javaClient().create(_1 -> _1.index(index).id("5").document(createItem("jack", "medium", "yes", 2)).refresh(Refresh.True));
        javaClient().create(_1 -> _1.index(index).id("6").document(createItem("wrench", "medium", "no", 3)).refresh(Refresh.True));
        javaClient().create(_1 -> _1.index(index).id("7").document(createItem("screws", "small", "no", 1)).refresh(Refresh.True));
        javaClient().create(_1 -> _1.index(index).id("8").document(createItem("nuts", "small", "no", 2)).refresh(Refresh.True));
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
