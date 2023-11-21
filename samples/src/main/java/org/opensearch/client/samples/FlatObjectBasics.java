package org.opensearch.client.samples;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.mapping.FlatObjectProperty;
import org.opensearch.client.opensearch._types.mapping.Property;
import org.opensearch.client.opensearch.core.IndexRequest;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.indices.CreateIndexRequest;
import org.opensearch.client.samples.util.IssueDocument;

public class FlatObjectBasics {
    private static final Logger LOGGER = LogManager.getLogger(IndexingBasics.class);

    public static void main(String[] args) {
        try {
            var client = SampleClient.create();

            var version = client.info().version();
            LOGGER.info("Server: {}@{}", version.distribution(), version.number());

            final var indexName = "flat_object-sample";

            // Create a new index with an "issue" field with flat_object type
            if (!client.indices().exists(e -> e.index(indexName)).value()) {
                final CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index(indexName)
                    .mappings(m -> m.properties("issue", Property.of(p -> p.flatObject(new FlatObjectProperty.Builder().build()))))
                    .build();
                client.indices().create(createIndexRequest);
            }

            // Index some flat object documents
            final IssueDocument issueDocument = new IssueDocument();
            final IssueDocument.Issue issue = new IssueDocument.Issue();
            issue.setNumber("123456");
            final IssueDocument.Labels labels = new IssueDocument.Labels();
            labels.setBackport(List.of("1.3", "2.0"));
            labels.setVersion("2.1");
            final IssueDocument.Category category = new IssueDocument.Category();
            category.setType("API");
            category.setLevel("enhancement");

            labels.setCategory(category);
            issue.setLabels(labels);

            issueDocument.setIssue(issue);
            final IndexRequest<IssueDocument> indexRequest = new IndexRequest.Builder<IssueDocument>().index(indexName)
                .id("1")
                .document(issueDocument)
                .build();

            client.index(indexRequest);

            // Index second document
            final IssueDocument document2 = new IssueDocument();
            final IssueDocument.Issue issue2 = new IssueDocument.Issue();
            issue2.setNumber("123457");

            IssueDocument.Labels labels2 = new IssueDocument.Labels();
            labels2.setVersion("2.2");

            IssueDocument.Category category2 = new IssueDocument.Category();
            category2.setType("API");
            category2.setLevel("bug");

            labels2.setCategory(category2);
            issue2.setLabels(labels2);

            document2.setIssue(issue2);

            final IndexRequest<IssueDocument> indexRequest2 = new IndexRequest.Builder<IssueDocument>().index(indexName)
                .id("2")
                .document(document2)
                .build();

            client.index(indexRequest2);

            // wait for the document to index - as refresh period is set to 3s
            Thread.sleep(3000);

            // Search for the documents
            // Ref: https://opensearch.org/docs/latest/field-types/supported-field-types/flat-object/
            // Even if you don’t know the field names, you can search for a leaf value in the entire flat object.
            // For example, the following request searches for all issues labeled as bugs
            SearchRequest searchRequest = new SearchRequest.Builder().index(indexName)
                .query(q -> q.match(m -> m.field("issue").query(FieldValue.of("bug"))))
                .build();

            SearchResponse<IssueDocument> searchResponse = client.search(searchRequest, IssueDocument.class);
            for (var hit : searchResponse.hits().hits()) {
                LOGGER.info("Found {} with score {}", hit.source(), hit.score());
            }

            // Alternatively, if you know the subfield name in which to search, provide the field’s path in dot notation
            SearchRequest searchRequest2 = new SearchRequest.Builder().index(indexName)
                .query(q -> q.match(m -> m.field("issue.labels.category.level").query(FieldValue.of("bug"))))
                .build();

            SearchResponse<IssueDocument> searchResponse2 = client.search(searchRequest2, IssueDocument.class);
            for (var hit : searchResponse2.hits().hits()) {
                LOGGER.info("Found {} with score {}", hit.source(), hit.score());
            }

        } catch (Exception e) {
            LOGGER.error("Unexpected exception", e);
        }
    }
}
