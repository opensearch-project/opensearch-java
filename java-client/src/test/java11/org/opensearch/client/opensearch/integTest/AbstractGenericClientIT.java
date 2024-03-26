/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import static org.hamcrest.CoreMatchers.equalTo;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.Test;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.generic.Bodies;
import org.opensearch.client.opensearch.generic.Requests;
import org.opensearch.client.opensearch.generic.Response;
import org.opensearch.client.opensearch.indices.CreateIndexResponse;

public abstract class AbstractGenericClientIT extends OpenSearchJavaClientTestCase {

    @Test
    public void shouldReturnSearchResults() throws Exception {
        final String index = "search_request";
        createIndex(index);

        try (
            Response response = javaClient().generic()
                .execute(
                    Requests.builder(javaClient()._transport().jsonpMapper())
                        .endpoint("/" + index + "/_search")
                        .method("POST")
                        .json(
                            "{"
                                + "    \"sort\": ["
                                + "        {"
                                + "            \"name\": \"asc\""
                                + "        }"
                                + "    ],"
                                + "    \"fields\": ["
                                + "        \"name\""
                                + "    ],"
                                + "    \"query\": {"
                                + "        \"bool\": {"
                                + "            \"filter\": ["
                                + "                {"
                                + "                    \"term\": {"
                                + "                        \"size\": \"huge\""
                                + "                    }"
                                + "                }"
                                + "            ]"
                                + "        }"
                                + "    },"
                                + "    \"_source\": true\n"
                                + "}"
                        )
                        .build()
                )
        ) {
            assertThat(response.getStatus(), equalTo(200));
            assertThat(response.getBody().isPresent(), equalTo(true));

            final SearchResponse<?> r = Bodies.json(
                response.getBody().get(),
                SearchResponse.createSearchResponseDeserializer(JsonpDeserializer.of(ShopItem.class)),
                javaClient()._transport().jsonpMapper()
            );
            assertEquals(r.hits().hits().size(), 2);

            assertTrue(
                Arrays.stream(r.hits().hits().get(0).fields().get("name").to(String[].class))
                    .collect(Collectors.toList())
                    .contains("hummer")
            );

            assertTrue(
                Arrays.stream(r.hits().hits().get(1).fields().get("name").to(String[].class))
                    .collect(Collectors.toList())
                    .contains("jammer")
            );
        }
    }

    private void createTestDocuments(String index) throws IOException {
        createTestDocument(index, "1", createItem("hummer", "huge", "yes", 2));
        createTestDocument(index, "2", createItem("jammer", "huge", "yes", 1));
        createTestDocument(index, "3", createItem("hammer", "large", "yes", 3));
        createTestDocument(index, "4", createItem("drill", "large", "yes", 3));
        createTestDocument(index, "5", createItem("jack", "medium", "yes", 2));
        createTestDocument(index, "6", createItem("wrench", "medium", "no", 3));
        createTestDocument(index, "7", createItem("screws", "small", "no", 1));
        createTestDocument(index, "8", createItem("nuts", "small", "no", 2));
    }

    private void createTestDocument(String index, String id, ShopItem document) throws IOException {
        try (
            Response response = javaClient().generic()
                .execute(
                    Requests.builder(javaClient()._transport().jsonpMapper())
                        .endpoint("/" + index + "/_doc/" + id)
                        .method("PUT")
                        .json(document)
                        .build()
                )
        ) {
            assertThat(response.getStatus(), equalTo(201));
            assertThat(response.getBody().isPresent(), equalTo(true));
        }
    }

    private void createIndex(String index) throws IOException {
        try (
            Response response = javaClient().generic()
                .execute(
                    Requests.builder(javaClient()._transport().jsonpMapper())
                        .endpoint("/" + index)
                        .method("PUT")
                        .json(
                            "{"
                                + "  \"settings\": {"
                                + "      \"index\": {"
                                + "          \"sort.field\": \"name\","
                                + "          \"sort.order\": \"asc\""
                                + "        }"
                                + "  },"
                                + "  \"mappings\": {"
                                + "    \"properties\": {"
                                + "      \"name\": {"
                                + "          \"type\": \"keyword\","
                                + "          \"doc_values\": true"
                                + "       },"
                                + "      \"size\": {"
                                + "          \"type\": \"keyword\","
                                + "          \"doc_values\": true"
                                + "       }"
                                + "    }"
                                + "  }"
                                + "}"
                        )
                        .build()
                )
        ) {
            assertThat(response.getStatus(), equalTo(200));
            assertThat(response.getBody().isPresent(), equalTo(true));

            final CreateIndexResponse r = Bodies.json(
                response.getBody().get(),
                CreateIndexResponse._DESERIALIZER,
                javaClient()._transport().jsonpMapper()
            );
            assertThat(r.acknowledged(), equalTo(true));
        }

        createTestDocuments(index);
        refreshIndex(index);
    }

    private void refreshIndex(String index) throws IOException {
        try (
            Response response = javaClient().generic()
                .execute(
                    Requests.builder(javaClient()._transport().jsonpMapper()).endpoint("/" + index + "/_refresh").method("POST").build()
                )
        ) {
            assertThat(response.getStatus(), equalTo(200));
            assertThat(response.getBody().isPresent(), equalTo(true));
        }
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
