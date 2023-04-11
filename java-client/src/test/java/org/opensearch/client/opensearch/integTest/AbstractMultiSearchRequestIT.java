/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import org.junit.Test;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch._types.query_dsl.TermQuery;
import org.opensearch.client.opensearch.core.MsearchResponse;
import org.opensearch.client.opensearch.core.msearch.MultiSearchResponseItem;
import org.opensearch.client.opensearch.core.msearch.RequestItem;
import org.opensearch.client.opensearch.core.search.Highlight;
import org.opensearch.client.opensearch.core.search.HighlightField;
import org.opensearch.client.opensearch.core.search.Hit;
import org.opensearch.client.opensearch.core.search.SourceConfig;

import java.io.IOException;
import java.util.List;

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

	private RequestItem createMSearchQueryWithHighlight(String itemSize) {
		return createMSearchQuery(itemSize, "size", List.of());
	}

	private RequestItem createMSearchQueryWithSelectedSourceFields(String itemSize) {
		return createMSearchQuery(itemSize, null, List.of("name", "size"));
	}

	private RequestItem createMSearchQuery(String itemSize, String fieldName, List<String> sources) {
		return RequestItem.of(item -> item.header(header -> header)
				.body(body -> body.query(createItemSizeSearchQuery(itemSize))
						.highlight(createHighlight(fieldName))
						.source(createSourcesConfig(sources))
				)
		);
	}

	private SourceConfig createSourcesConfig(List<String> sources) {
		return sources.isEmpty() ? null : SourceConfig.of(builder -> builder.filter(filter -> filter.includes(sources)));
	}

	private Highlight createHighlight(String fieldName) {
		return fieldName != null ? Highlight.of(
				builder -> builder.fields(
						fieldName, HighlightField.of(
								field -> field.preTags("<em class=\"highlight\">")
										.postTags("</em>")
						)
				)
		) : null;
	}

	private Query createItemSizeSearchQuery(String itemSize) {
		return Query.of(query -> query.bool(builder -> builder.filter(
				filter -> filter.term(
						TermQuery.of(term -> term.field("size")
								.value(FieldValue.of(itemSize))
						)
				)
		)));
	}

	private MsearchResponse<ShopItem> sendMSearchRequest(String index, List<RequestItem> searches) throws IOException {
		return javaClient().msearch(builder -> builder.index(List.of(index)).searches(searches), ShopItem.class);
	}

	private void createTestDocuments(String index) throws IOException {
		javaClient().create(_1 -> _1.index(index).id("1").document(createItem("hammer", "large", "yes")).refresh(Refresh.True));
		javaClient().create(_1 -> _1.index(index).id("2").document(createItem("drill", "large", "yes")).refresh(Refresh.True));
		javaClient().create(_1 -> _1.index(index).id("3").document(createItem("jack", "medium", "yes")).refresh(Refresh.True));
		javaClient().create(_1 -> _1.index(index).id("4").document(createItem("wrench", "medium", "no")).refresh(Refresh.True));
		javaClient().create(_1 -> _1.index(index).id("5").document(createItem("screws", "small", "no")).refresh(Refresh.True));
		javaClient().create(_1 -> _1.index(index).id("6").document(createItem("nuts", "small", "no")).refresh(Refresh.True));
	}

	private ShopItem createItem(String name, String size, String company) {
		return new ShopItem(name, size, company);
	}

	public static class ShopItem {
		private String name;
		private String size;
		private String company;

		public ShopItem() {
		}

		public ShopItem(String name, String size, String company) {
			this.name = name;
			this.size = size;
			this.company = company;
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
	}
}
