/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import static org.hamcrest.CoreMatchers.equalTo;

import jakarta.json.Json;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.Test;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.opensearch._types.mapping.Property;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.generic.Bodies;
import org.opensearch.client.opensearch.generic.Requests;
import org.opensearch.client.opensearch.generic.Response;
import org.opensearch.client.opensearch.indices.CreateIndexRequest;
import org.opensearch.client.opensearch.indices.CreateIndexResponse;
import org.opensearch.client.opensearch.indices.SegmentSortOrder;

public abstract class AbstractGenericClientIT extends OpenSearchJavaClientTestCase {

    @Test
    public void shouldReturnSearchResults() throws Exception {
        final String index = "search_request";
        createIndex(index);

        try (
            Response response = javaClient().generic()
                .execute(
                    Requests.builder()
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
                    Requests.builder()
                        .endpoint("/" + index + "/_doc/" + id)
                        .method("PUT")
                        .json(document, javaClient()._transport().jsonpMapper())
                        .build()
                )
        ) {
            assertThat(response.getStatus(), equalTo(201));
            assertThat(response.getBody().isPresent(), equalTo(true));
        }
    }

    private void createIndex(String index) throws IOException {
        if (randomBoolean()) {
            createIndexUntyped(index);
        } else {
            createIndexTyped(index);
        }
    }

    private void createIndexUntyped(String index) throws IOException {
        final JsonpMapper jsonpMapper = javaClient()._transport().jsonpMapper();

        try (
            Response response = javaClient().generic()
                .execute(
                    Requests.builder()
                        .endpoint("/" + index)
                        .method("PUT")
                        .json(
                            Json.createObjectBuilder()
                                .add(
                                    "settings",
                                    Json.createObjectBuilder()
                                        .add("index", Json.createObjectBuilder().add("sort.field", "name"))
                                        .add("sort.order", "asc")
                                )
                                .add(
                                    "mappings",
                                    Json.createObjectBuilder()
                                        .add(
                                            "properties",
                                            Json.createObjectBuilder()
                                                .add("name", Json.createObjectBuilder().add("type", "keyword"))
                                                .add("doc_values", true)

                                                .add("size", Json.createObjectBuilder().add("type", "keyword"))
                                                .add("doc_values", true)
                                        )
                                )
                        )
                        .build()
                )
        ) {
            assertThat(response.getStatus(), equalTo(200));
            assertThat(response.getBody().isPresent(), equalTo(true));

            final CreateIndexResponse r = response.getBody()
                .map(b -> Bodies.json(b, CreateIndexResponse._DESERIALIZER, jsonpMapper))
                .orElse(null);
            assertThat(r.acknowledged(), equalTo(true));
        }

        createTestDocuments(index);
        refreshIndex(index);
    }

    private void createIndexTyped(String index) throws IOException {
        final JsonpMapper jsonpMapper = javaClient()._transport().jsonpMapper();

        final CreateIndexRequest request = CreateIndexRequest.of(
            b -> b.index(index)
                .mappings(
                    m -> m.properties("name", Property.of(p -> p.keyword(v -> v.docValues(true))))
                        .properties("size", Property.of(p -> p.keyword(v -> v.docValues(true))))
                )
                .settings(settings -> settings.sort(s -> s.field("name").order(SegmentSortOrder.Asc)))
        );

        try (
            Response response = javaClient().generic()
                .execute(Requests.builder().endpoint("/" + index).method("PUT").json(request, jsonpMapper).build())
        ) {
            assertThat(response.getStatus(), equalTo(200));
            assertThat(response.getBody().isPresent(), equalTo(true));

            final CreateIndexResponse r = Bodies.json(response.getBody().get(), CreateIndexResponse._DESERIALIZER, jsonpMapper);
            assertThat(r.acknowledged(), equalTo(true));
        }

        createTestDocuments(index);
        refreshIndex(index);
    }

    private void refreshIndex(String index) throws IOException {
        try (
            Response response = javaClient().generic()
                .execute(Requests.builder().endpoint("/" + index + "/_refresh").method("POST").build())
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
