/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import java.io.IOException;
import java.util.Map;
import org.junit.Test;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch._types.mapping.Property;
import org.opensearch.client.opensearch.core.PutScriptRequest;
import org.opensearch.client.opensearch.core.SearchTemplateResponse;

public abstract class AbstractSearchTemplateRequestIT extends OpenSearchJavaClientTestCase {

    private static final String TEST_SEARCH_TEMPLATE = "search-template-integration-test";

    @Test
    public void testTemplateSearchResults() throws Exception {
        var index = "test-search-template-search";
        createDocuments(index);

        var searchResponse = sendTemplateRequest(index, "NoDocuments", false, false);
        assertEquals(0, searchResponse.hits().hits().size());
        assertEquals(0, searchResponse.suggest().size());
        assertEquals(0, searchResponse.aggregations().size());

        searchResponse = sendTemplateRequest(index, "Document", false, false);
        assertEquals(4, searchResponse.hits().hits().size());
        assertEquals(0, searchResponse.suggest().size());
        assertEquals(0, searchResponse.aggregations().size());

        searchResponse = sendTemplateRequest(index, "1", false, false);
        assertEquals(1, searchResponse.hits().hits().size());
        assertEquals(1, searchResponse.hits().hits().get(0).source().getValue().intValue());
        assertEquals(0, searchResponse.suggest().size());
        assertEquals(0, searchResponse.aggregations().size());
    }

    @Test
    public void testTemplateSearchSuggest() throws Exception {
        var index = "test-search-template-suggs";
        createDocuments(index);

        var searchResponse = sendTemplateRequest(index, "Document", true, false);
        assertEquals(4, searchResponse.hits().hits().size());
        assertEquals(1, searchResponse.suggest().size());
        assertEquals(0, searchResponse.aggregations().size());

        // intentional typo
        searchResponse = sendTemplateRequest(index, "Docuent", true, false);
        assertEquals(0, searchResponse.hits().hits().size());
        assertEquals(1, searchResponse.suggest().size());
        var options = searchResponse.suggest().get("test-suggest").get(0).term().options();
        assertEquals(1, options.size());
        assertEquals("document", options.get(0).text());
        assertEquals(0, searchResponse.aggregations().size());

    }

    @Test
    public void testTemplateSearchAggregations() throws Exception {
        var index = "test-search-template-aggs";
        createDocuments(index);

        var searchResponse = sendTemplateRequest(index, "NoDocuments", false, true);
        assertEquals(0, searchResponse.hits().hits().size());
        assertEquals(0, searchResponse.suggest().size());
        assertEquals(1, searchResponse.aggregations().size());

        searchResponse = sendTemplateRequest(index, "Document", false, true);
        assertEquals(4, searchResponse.hits().hits().size());
        assertEquals(0, searchResponse.suggest().size());
        assertEquals(1, searchResponse.aggregations().size());
        var buckets = searchResponse.aggregations().get("test-aggs").sterms().buckets().array();
        assertEquals(2, buckets.size());
        assertEquals(2, buckets.get(0).docCount());
        assertEquals(2, buckets.get(1).docCount());

    }

    @Test
    public void testMultiSearchTemplate() throws Exception {
        var index = "test-msearch-template";
        createDocuments(index);

        var searchResponse = javaClient().msearchTemplate(
            request -> request.searchTemplates(
                r -> r.header(h -> h.index(index))
                    .body(
                        t -> t.id(TEST_SEARCH_TEMPLATE)
                            .params("title", JsonData.of("Document"))
                            .params("suggs", JsonData.of(false))
                            .params("aggs", JsonData.of(false))
                    )
            ),
            SimpleDoc.class
        );

        assertEquals(1, searchResponse.responses().size());
        var response = searchResponse.responses().get(0);
        assertTrue(response.isResult());
        assertNull(response.result().status());
        assertEquals(4, response.result().hits().hits().size());
    }

    private SearchTemplateResponse<SimpleDoc> sendTemplateRequest(String index, String title, boolean suggs, boolean aggs)
        throws IOException {
        return javaClient().searchTemplate(
            request -> request.index(index)
                .id(TEST_SEARCH_TEMPLATE)
                .params(Map.of("title", JsonData.of(title), "suggs", JsonData.of(suggs), "aggs", JsonData.of(aggs))),
            SimpleDoc.class
        );
    }

    private void createDocuments(String index) throws IOException {
        createIndex(index);
        javaClient().create(
            _1 -> _1.index(index).id("1").document(createDoc("Document 1", "The text of document 1", 1)).refresh(Refresh.True)
        );
        javaClient().create(
            _1 -> _1.index(index).id("2").document(createDoc("Document 2", "The text of document 2", 1)).refresh(Refresh.True)
        );
        javaClient().create(
            _1 -> _1.index(index).id("3").document(createDoc("Document 3", "The text of document 3", 2)).refresh(Refresh.True)
        );
        javaClient().create(
            _1 -> _1.index(index).id("4").document(createDoc("Document 4", "The text of document 4", 2)).refresh(Refresh.True)
        );
    }

    private void createIndex(String index) throws IOException {
        Property titleProp = new Property.Builder().text(v -> v).build();
        Property textProp = new Property.Builder().text(v -> v).build();
        Property valueProp = new Property.Builder().keyword(v -> v).build();
        javaClient().indices()
            .create(
                c -> c.index(index)
                    .mappings(m -> m.properties("title", titleProp).properties("text", textProp).properties("value", valueProp))
            );
        createSearchTemplate();
    }

    /*
     * """{
    	  "query": {
    	    "match": {
    	      "title": "{{title}}"
    	    }
    	  }
    	  {{#suggs}}
    	  ,"suggest" : {
    	    "test-suggest" : {
    	      "text" : "{{title}}",
    	      "term" : {
    	        "field" : "title"
    	      }
    	    }
    	  }
    	  {{/suggs}}
    	  {{#aggs}}
    	  ,"aggs": {
    	    "test-aggs": {
    	      "terms": {
    	        "field": "value"
    	      }
    	    }
    	  }
    	  {{/aggs}}
    	}"""
     */
    private void createSearchTemplate() throws IOException {
        var templateReq = new PutScriptRequest.Builder().id(TEST_SEARCH_TEMPLATE)
            .script(
                s -> s.lang("mustache")
                    .source(
                        "{ \"query\": { \"match\": { \"title\": \"{{title}}\" } } "
                            + "{{#suggs}},\"suggest\" : { \"test-suggest\" : { \"text\" : "
                            + "\"{{title}}\", \"term\" : { \"field\" : \"title\" } } } {{/suggs}}"
                            + "{{#aggs}} ,\"aggs\": {\"test-aggs\": { \"terms\": "
                            + "{ \"field\": \"value\" } } }{{/aggs}} }"
                    )
            );
        javaClient().putScript(templateReq.build());
    }

    private SimpleDoc createDoc(String title, String text, Integer value) {
        return new SimpleDoc(title, text, value);
    }

    public static class SimpleDoc {
        private String title;
        private String text;
        private Integer value;

        public SimpleDoc() {}

        public SimpleDoc(String title, String text, Integer value) {
            this.title = title;
            this.text = text;
            this.value = value;
        }

        public String getTitle() {
            return title;
        }

        public String getText() {
            return text;
        }

        public Integer getValue() {
            return value;
        }
    }

}
