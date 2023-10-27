package org.opensearch.client.samples.util;

import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch._types.mapping.IntegerNumberProperty;
import org.opensearch.client.opensearch._types.mapping.Property;
import org.opensearch.client.opensearch._types.mapping.TypeMapping;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.indices.CreateIndexRequest;
import org.opensearch.client.opensearch.indices.IndexSettings;

public class CommonUtil {
    private static final Logger LOGGER = LogManager.getLogger(CommonUtil.class);

    public static void createIndex(OpenSearchClient client, String indexName) throws IOException {
        if (!client.indices().exists(r -> r.index(indexName)).value()) {
            LOGGER.info("Creating index {}", indexName);
            IndexSettings settings = new IndexSettings.Builder().numberOfShards("2").numberOfReplicas("1").build();
            TypeMapping mapping = new TypeMapping.Builder().properties(
                "age",
                new Property.Builder().integer(new IntegerNumberProperty.Builder().build()).build()
            ).build();
            CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index(indexName)
                .settings(settings)
                .mappings(mapping)
                .build();
            client.indices().create(createIndexRequest);
        }
    }

    public static SearchResponse<IndexData> search(OpenSearchClient client, String indexName, String field, String value)
        throws IOException {
        Query query = Query.of(qb -> qb.match(mb -> mb.field(field).query(fv -> fv.stringValue(value))));
        final SearchRequest.Builder searchReq = new SearchRequest.Builder().allowPartialSearchResults(false)
            .index(List.of(indexName))
            .size(10)
            .ignoreThrottled(false)
            .query(query);
        return client.search(searchReq.build(), IndexData.class);
    }
}
