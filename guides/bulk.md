- [Bulk](#bulk)
  - [Bulk Indexing](#bulk-indexing)
  - [Bulk requests](#bulk-requests)

# Bulk

The [Bulk API](https://opensearch.org/docs/latest/api-reference/document-apis/bulk/) lets you add, update, or delete multiple documents in a single request.

## Bulk Indexing

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