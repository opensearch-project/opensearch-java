- [Bulk](#bulk)
  - [Bulk Indexing](#bulk-indexing)
  - [Bulk requests](#bulk-requests)

# Bulk

The [Bulk API](https://opensearch.org/docs/latest/api-reference/document-apis/bulk/) lets you add, update, or delete multiple documents in a single request.

## Bulk Indexing

The `BulkIngester` is a helper class that simplifies bulk indexing by automatically buffering operations and flushing them to OpenSearch based on configurable thresholds. It provides:

- Automatic flushing based on number of operations, total size in bytes, or time interval
- Backpressure control to prevent overwhelming the cluster
- Automatic retries with configurable backoff policies for failed operations
- Thread-safe concurrent operation

```java
String indexName = "sample-index";

// Create a BulkIngester with custom settings
BulkIngester<Void> ingester = BulkIngester.of(b -> b
    .client(client)
    .maxOperations(1000)           // Flush every 1000 operations
    .flushInterval(5, TimeUnit.SECONDS)  // Or every 5 seconds
    .maxConcurrentRequests(2)       // Allow 2 concurrent bulk requests
);

// Add operations - they are automatically buffered and flushed
IndexData doc1 = new IndexData("Document 1", "The text of document 1");
ingester.add(op -> op.index(i -> i.index(indexName).id("id1").document(doc1)));

IndexData doc2 = new IndexData("Document 2", "The text of document 2");
ingester.add(op -> op.index(i -> i.index(indexName).id("id2").document(doc2)));

IndexData doc3 = new IndexData("Document 3", "The text of document 3");
ingester.add(op -> op.index(i -> i.index(indexName).id("id3").document(doc3)));

// Close the ingester - this flushes any remaining buffered operations
ingester.close();
```

[IndexData](../samples/src/main/java/org/opensearch/client/samples/util/IndexData.java) refers to sample data class.

You can find a working sample of the above code in [BulkIngesterBasics.java](../samples/src/main/java/org/opensearch/client/samples/BulkIngesterBasics.java).


## Bulk requests

```java
String indexName = "sample-index";
CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index(index).build();
client.indices().create(createIndexRequest);

ArrayList<BulkOperation> ops = new ArrayList<>();
IndexData doc1 = new IndexData("Document 1", "The text of document 1");
ops.add(new BulkOperation.Builder().index(
        IndexOperation.of(io -> io.index(indexName).id("id1").document(doc1))
).build());
IndexData doc2 = new IndexData("Document 2", "The text of document 2");
ops.add(new BulkOperation.Builder().index(
        IndexOperation.of(io -> io.index(indexName).id("id2").document(doc2))
).build());
IndexData doc3 = new IndexData("Document 3", "The text of document 3");
ops.add(new BulkOperation.Builder().index(
        IndexOperation.of(io -> io.index(indexName).id("id3").document(doc3))
).build());

BulkRequest.Builder bulkReq = new BulkRequest.Builder()
        .index(indexName)
        .operations(ops)
        .refresh(Refresh.WaitFor);
BulkResponse bulkResponse = client.bulk(bulkReq.build());
```

[IndexData](../samples/src/main/java/org/opensearch/client/samples/util/IndexData.java) refers to sample data class.

You can find a working sample of the above code in [Bulk.java](../samples/src/main/java/org/opensearch/client/samples/Bulk.java).