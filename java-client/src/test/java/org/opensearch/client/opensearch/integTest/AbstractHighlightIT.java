/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.Test;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.core.search.Highlight;
import org.opensearch.client.opensearch.core.search.Hit;
import org.opensearch.client.util.ObjectBuilder;

public abstract class AbstractHighlightIT extends OpenSearchJavaClientTestCase {

    @Test
    public void testDefaultHighlight() throws Exception {
        String index = "queries_highlight";
        createTestDocuments(index);

        List<Map<String, List<String>>> highlights = highlightQuery("spread", h -> h.fields("content", b -> b));

        assertEquals(2, highlights.size());
        for (Map<String, List<String>> hit : highlights) {
            assertEquals(1, hit.size());
            assertEquals(1, hit.get("content").size());
            assertTrue(hit.get("content").get(0).contains("<em>spread</em>"));
        }
    }

    @Test
    public void testMultiFieldHighlight() throws Exception {
        String index = "queries_highlight";
        createTestDocuments(index);

        List<Map<String, List<String>>> highlights = highlightQuery(
            "real decades",
            h -> h.fields("title", b -> b).fields("content", b -> b)
        );

        assertEquals(3, highlights.size());
        for (Map<String, List<String>> hit : highlights) {
            assertEquals(2, hit.size());
            assertEquals(1, hit.get("title").size());
            assertTrue(hit.get("title").get(0).contains("<em>Real</em>"));
            assertEquals(1, hit.get("content").size());
            assertTrue(hit.get("content").get(0).contains("<em>decades</em>"));
        }
    }

    @Test
    public void testDifferentMarkersHighlight() throws Exception {
        String index = "queries_highlight";
        createTestDocuments(index);

        List<Map<String, List<String>>> highlights = highlightQuery(
            "spread",
            h -> h.preTags("<b>").postTags("</b>").fields("content", b -> b)
        );

        assertEquals(2, highlights.size());
        for (Map<String, List<String>> hit : highlights) {
            assertEquals(1, hit.size());
            assertEquals(1, hit.get("content").size());
            assertTrue(hit.get("content").get(0).contains("<b>spread</b>"));
        }
    }

    @Test
    public void testAnalyzerOffset() throws Exception {

        String[] versionNumber = javaClient().info().version().number().split("\\.");
        int major = Integer.parseInt(versionNumber[0]);
        int minor = Integer.parseInt(versionNumber[1]);

        // The max_analyzer_offset setting was introduced in OpenSearch 2.2.0
        // before that, the max_analyzer_offset thrown an unknown field exception
        // For more details, see:
        // https://github.com/opensearch-project/OpenSearch/pull/4031
        // https://github.com/opensearch-project/OpenSearch/pull/3893
        if (major >= 2 && minor >= 2) {
            String index = "queries_highlight";
            createTestDocuments(index);
            List<Map<String, List<String>>> highlights = highlightQuery("real", h -> h.maxAnalyzerOffset("5").fields("title", b -> b));

            assertEquals(3, highlights.size());
            assertEquals(0, highlights.get(0).size());
            assertEquals(1, highlights.get(1).size());
            assertEquals(1, highlights.get(2).size());

            assertTrue(highlights.get(1).get("title").get(0).contains("<em>Real</em>"));
            assertTrue(highlights.get(2).get("title").get(0).contains("<em>Real</em>"));
        }
    }

    private List<Map<String, List<String>>> highlightQuery(String query, Function<Highlight.Builder, ObjectBuilder<Highlight>> fn)
        throws IOException {
        SearchResponse<Article> response = javaClient().search(
            s -> s.index("*,-.*") // exclude system indices
                .query(q -> q.simpleQueryString(sqs -> sqs.fields("title", "content", "author").query(query)))
                .highlight(fn),
            Article.class
        );
        return response.hits().hits().stream().map(Hit::highlight).collect(Collectors.toList());
    }

    private void createTestDocuments(String index) throws IOException {
        javaClient().create(
            _1 -> _1.index(index)
                .id("1")
                .document(createArticle("Superheroes are Real", "Meet these man avoid the fire spread during last decades.", "John Doe"))
                .refresh(Refresh.True)
        );
        javaClient().create(
            _1 -> _1.index(index)
                .id("2")
                .document(
                    createArticle(
                        "Real Slow Ideas",
                        "Why some innovations spread quick while others take decades to catch hold.",
                        "John Foo"
                    )
                )
                .refresh(Refresh.True)
        );
        javaClient().create(
            _1 -> _1.index(index)
                .id("3")
                .document(createArticle("Real Two Degrees", "How the world failed on climate change during the decades.", "Anne Doe"))
                .refresh(Refresh.True)
        );
    }

    private Article createArticle(String title, String content, String author) {
        return new Article(title, content, author);
    }

    public static class Article {
        public String title;
        public String content;
        public String author;

        public Article() {}

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(final String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(final String content) {
            this.content = content;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(final String author) {
            this.author = author;
        }
    }

}
