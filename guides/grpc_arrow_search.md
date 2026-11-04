- [Arrow Search over gRPC](#arrow-search-over-grpc)
  - [Requirements](#requirements)
  - [Connecting](#connecting)
  - [Searching](#searching)
  - [Requests](#requests)
  - [Memory](#memory)
  - [Errors](#errors)

# Arrow Search over gRPC

`OpenSearchArrowClient` streams the doc values of every document matching a search as [Apache Arrow](https://arrow.apache.org/)
record batches. It calls the gRPC search service's `ServerStreamSearch` method on the existing gRPC port, with the request
header `x-opensearch-format: arrow`, over the same `GrpcTransport` (or `HybridTransport`), TLS and authentication as
unary gRPC search. Batches are decoded straight from gRPC's buffers into Arrow vectors: no JSON, no row objects.

The server sends batches only as fast as the client reads them: a reader that stops reading pauses the search, through
gRPC flow control.

A complete example is in [GrpcArrowSearch](../samples/src/main/java/org/opensearch/client/samples/GrpcArrowSearch.java).

## Requirements

- OpenSearch with `transport-grpc` (or `secure-transport-grpc`) and the `arrow-search` plugin.
- `java-client-grpc`, which brings `arrow-vector` and `arrow-memory-core`.
- On Java 17 and later, Arrow's memory module needs `--add-opens=java.base/java.nio=org.apache.arrow.memory.core,ALL-UNNAMED`.

## Connecting

Any `GrpcTransport` works; for a cluster with the security plugin, enable TLS and pass credentials as for any gRPC call:

```java
GrpcTransport transport = GrpcTransport.builder("localhost", 9400)
    .jsonpMapper(new JacksonJsonpMapper())
    .tls(GrpcTlsConfig.builder().trustCertificatePath("root-ca.pem").build())
    .basicAuth("reader", password)  // or .jwtAuth(tokenSupplier)
    .build();

BufferAllocator allocator = new RootAllocator();
OpenSearchArrowClient arrow = new OpenSearchArrowClient(transport, allocator);
```

Searches are authorized like any search: the caller needs the `indices:data/read/search*` and
`indices:data/read/field_caps` privileges, and document-level security, field-level security and field masking apply.

## Searching

`search` returns an `ArrowSearchResponse`, an Arrow `ArrowReader`: the schema is known when `search` returns, and every
`loadNextBatch()` loads the next batch into the same `VectorSchemaRoot`.

```java
try (ArrowSearchResponse response = arrow.search(s -> s
    .index("logs")
    .query(q -> q.term(t -> t.field("status").value(FieldValue.of(500))))
    .docvalueFields(f -> f.field("host"))
    .docvalueFields(f -> f.field("latency_ms"))
    .docvalueFields(f -> f.field("tags").format("list"))
)) {
    VectorSchemaRoot root = response.getVectorSchemaRoot();
    while (response.loadNextBatch()) {
        BigIntVector latency = (BigIntVector) root.getVector("latency_ms");
        for (int i = 0; i < root.getRowCount(); i++) {
            // ...
        }
    }
    SearchResponse<Void> summary = response.summary();  // took, _shards, timed_out, hits.total
}
```

Closing the response before the last batch cancels the search. `cancel()` does so from another thread.

## Requests

The request is a regular `SearchRequest`:

- `docvalue_fields` is required: field names or patterns, in column order. The format `list` makes a list column holding
  every value of a field; other formats are not supported.
- `query` and `post_filter` take any query; scoring is disabled.
- `size` caps the rows, `terminate_after` the rows per shard; `timeout`, routing, preference and indices options apply as
  in `_search`.

Rows of different shards interleave; no order is promised. Options that need scores, ordering, paging or fetching
(`sort`, `from`, `search_after`, `aggregations`, `highlight`, `scroll`, ...) are rejected. Options the gRPC transport
cannot send fail with `UnsupportedOperationException` before anything is sent, and so do transport options a gRPC call
cannot carry: query parameters, headers whose name or value gRPC metadata cannot hold (for example a token that ends in
a newline), a warnings handler, or per-request AWS credentials. Their other headers are sent as request metadata, as for
unary gRPC calls.

## Memory

Batches live in a child of the allocator passed to the client, and are freed when the next batch loads or the response
closes. Use an allocator with a limit to bound the memory of searches; a batch that does not fit fails the search with
`OutOfMemoryException`. Always close the response.

Before a batch is loaded, its row and value counts are checked against the bytes it holds, so that loading allocates
about as much memory as the batch takes on the wire, not as much as a malformed batch claims. A batch that fails the
check, or that is compressed, fails the search with a `TransportException`.

## Errors

- A request the server rejects throws an `OpenSearchException` from `search`, with the status as in REST (for example 400).
- A failure after batches arrived throws from `loadNextBatch()`. The search is not retried: discard the rows received.
