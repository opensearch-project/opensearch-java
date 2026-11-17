/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.samples

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.opensearch.client.opensearch._types.Refresh
import org.opensearch.client.opensearch._types.mapping.IntegerNumberProperty
import org.opensearch.client.opensearch._types.mapping.Property
import org.opensearch.client.opensearch._types.mapping.TypeMapping
import org.opensearch.client.opensearch._types.query_dsl.Query
import org.opensearch.client.opensearch.core.BulkRequest
import org.opensearch.client.opensearch.core.SearchRequest
import org.opensearch.client.opensearch.core.bulk.BulkOperation
import org.opensearch.client.opensearch.core.bulk.IndexOperation
import org.opensearch.client.opensearch.indices.CreateIndexRequest
import org.opensearch.client.opensearch.indices.DeleteIndexRequest
import org.opensearch.client.opensearch.indices.IndexSettings
import org.opensearch.client.samples.util.IndexData

/**
 * Run with: `./gradlew :samples:samples-kotlin:run -Dsamples.mainClass=Bulk`
 */
object Bulk {
    private val LOGGER: Logger = LogManager.getLogger(Bulk::class.java)

    @JvmStatic
    fun main(args: Array<String>) {
        try {
            val client = SampleClient.create()

            val version = client.info().version()
            LOGGER.info("Server: {}@{}", version.distribution(), version.number())

            val indexName = "my-index"

            if (!client.indices().exists { r -> r.index(indexName) }.value()) {
                LOGGER.info("Creating index {}", indexName)
                val settings = IndexSettings.Builder().numberOfShards(2).numberOfReplicas(1).build()
                val mapping = TypeMapping.Builder().properties(
                    "age",
                    Property.Builder().integer(IntegerNumberProperty.Builder().build()).build()
                ).build()
                val createIndexRequest = CreateIndexRequest.Builder().index(indexName)
                    .settings(settings)
                    .mappings(mapping)
                    .build()
                client.indices().create(createIndexRequest)
            }

            LOGGER.info("Bulk indexing documents")
            val ops = ArrayList<BulkOperation>()
            val doc1 = IndexData("Document 1", "The text of document 1")
            ops.add(BulkOperation.Builder().index(IndexOperation.of { io -> io.index(indexName).id("id1").document(doc1) }).build())
            val doc2 = IndexData("Document 2", "The text of document 2")
            ops.add(BulkOperation.Builder().index(IndexOperation.of { io -> io.index(indexName).id("id2").document(doc2) }).build())
            val doc3 = IndexData("Document 3", "The text of document 3")
            ops.add(BulkOperation.Builder().index(IndexOperation.of { io -> io.index(indexName).id("id3").document(doc3) }).build())

            val bulkReq = BulkRequest.Builder().index(indexName).operations(ops).refresh(Refresh.WaitFor)
            var bulkResponse = client.bulk(bulkReq.build())
            LOGGER.info("Bulk response items: {}", bulkResponse.items().size)

            val query = Query.of { qb -> qb.match { mb -> mb.field("title").query { fv -> fv.stringValue("Document") } } }
            val searchReq = SearchRequest.Builder().allowPartialSearchResults(false)
                .index(listOf(indexName))
                .size(10)
                .source { sc -> sc.fetch(false) }
                .ignoreThrottled(false)
                .query(query)

            val searchResponse = client.search(searchReq.build(), IndexData::class.java)
            LOGGER.info("Found {} documents", searchResponse.hits().hits().size)

            LOGGER.info("Bulk update document")
            doc1.text = "Updated Document"
            val request = BulkRequest.Builder().operations { o -> o.update { u -> u.index(indexName).id("id1").document(doc1) } }
                .refresh(Refresh.WaitFor)
                .build()
            bulkResponse = client.bulk(request)
            LOGGER.info("Bulk update response items: {}", bulkResponse.items().size)

            LOGGER.info("Deleting index {}", indexName)
            val deleteIndexRequest = DeleteIndexRequest.Builder().index(indexName).build()
            client.indices().delete(deleteIndexRequest)
        } catch (e: Exception) {
            LOGGER.error("Unexpected exception", e)
        }
    }
}
