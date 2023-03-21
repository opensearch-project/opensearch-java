# User Guide

- [User Guide](#user-guide)
  - [Sample data](#sample-data)
    - [IndexData class](#indexdata-class)
  - [Create a client](#create-a-client)
    - [Create a client using `RestClientTransport`](#create-a-client-using-restclienttransport)
    - [Create a client using `ApacheHttpClient5Transport`](#create-a-client-using-apachehttpclient5transport)
  - [Create an index](#create-an-index)
  - [Index data](#index-data)
  - [Search for the documents](#search-for-the-documents)
    - [Get raw JSON results](#get-raw-json-results)
  - [Search documents using a match query](#search-documents-using-a-match-query)
  - [Bulk requests](#bulk-requests)
  - [Aggregations](#aggregations)
  - [Delete the document](#delete-the-document)
  - [Delete the index](#delete-the-index)
  - [Cat API](#cat-api)
    - [Cat Indices](#cat-indices)
    - [Cat Aliases](#cat-aliases)
    - [Cat Nodes](#cat-nodes)
- [Using different transport options](#using-different-transport-options)
  - [Amazon OpenSearch Service](#amazon-opensearch-service)

## Sample data

### IndexData class

```java
static class IndexData {
  private String firstName;
  private String lastName;

  public IndexData(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return String.format("IndexData{first name='%s', last name='%s'}", firstName, lastName);
  }
}
```

## Create a client

There are multiple low level transports which `OpenSearchClient` could be configured with.

### Create a client using `RestClientTransport`

```java
OpenSearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper()); 
OpenSearchClient client = new OpenSearchClient(transport);
```

The `JacksonJsonpMapper` class (2.x versions) only supports Java 7 objects by default. [Java 8 modules](https://github.com/FasterXML/jackson-modules-java8) to support JDK8 classes such as the Date and Time API (JSR-310), `Optional`, and more can be used by including [the additional datatype dependency](https://github.com/FasterXML/jackson-modules-java8#usage) and adding the module.  For example, to include JSR-310 classes:

```java
OpenSearchTransport transport = new RestClientTransport(restClient,
    new JacksonJsonpMapper(new ObjectMapper().registerModule(new JavaTimeModule()))); 
OpenSearchClient client = new OpenSearchClient(transport);
```

Upcoming OpenSearch `3.0.0` release brings HTTP/2 support and as such, the `RestClientTransport` would switch to HTTP/2 if available (for both HTTPS and/or HTTP protocols). The desired protocol could be forced using `RestClientBuilder.HttpClientConfigCallback`.

### Create a client using `ApacheHttpClient5Transport`

```java
final OpenSearchTransport transport = ApacheHttpClient5TransportBuilder
    .builder(hosts)
    .setMapper(new JacksonJsonpMapper())
    .build();
OpenSearchClient client = new OpenSearchClient(transport);
```

Upcoming OpenSearch `3.0.0` release brings HTTP/2 support and as such, the `ApacheHttpClient5Transport` would switch to HTTP/2 if available (for both HTTPS and/or HTTP protocols). The desired protocol could be forced using `ApacheHttpClient5TransportBuilder.HttpClientConfigCallback`, for example:

```java
final OpenSearchTransport transport = ApacheHttpClient5TransportBuilder
    .builder(httpHost)
    .setMapper(new JacksonJsonpMapper())
    .setHttpClientConfigCallback(new ApacheHttpClient5TransportBuilder.HttpClientConfigCallback() {
        @Override
        public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
            return httpClientBuilder.setVersionPolicy(HttpVersionPolicy.FORCE_HTTP_2);
        }
    })
    .build();
OpenSearchClient client = new OpenSearchClient(transport);
```

## Create an index

```java
String index = "sample-index";
CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index(index).build();
client.indices().create(createIndexRequest);
```

## Index data

```java
IndexData indexData = new IndexData("John", "Doe");
IndexRequest<IndexData> indexRequest = new IndexRequest.Builder<IndexData>().index(index).id("1").document(indexData).build();
client.index(indexRequest);

indexData = new IndexData("John", "Joe");
indexRequest = new IndexRequest.Builder<IndexData>().index(index).id("2").document(indexData).build();
client.index(indexRequest);
```

## Search for the documents

```java
SearchResponse<IndexData> searchResponse = client.search(s -> s.index(index), IndexData.class);
for (int i = 0; i < searchResponse.hits().hits().size(); i++) {
  System.out.println(searchResponse.hits().hits().get(i).source());
}
```

### Get raw JSON results

When the target class is not defined or if the response result is a semi-structured data not tied to an object definition, use a raw JSON data representation as the target class. For example, the below snippet uses `ObjectNode` from jackson.

```java
SearchResponse<ObjectNode> searchResponse = client.search(b -> b.index(index), ObjectNode.class);
for (int i = 0; i < searchResponse.hits().hits().size(); i++) {
  System.out.println(searchResponse.hits().hits().get(i).source());
}
```

## Search documents using a match query

```java
SearchRequest searchRequest = new SearchRequest.Builder().query(q -> q.match(m -> m.field("firstName")
                                                                                   .query(FieldValue.of("John"))))
                                                         .build();

SearchResponse<IndexData> searchResponse = client.search(searchRequest, IndexData.class);
for (int i = 0; i < searchResponse.hits().hits().size(); i++) {
  System.out.println(searchResponse.hits().hits().get(i).source());
}
```

## Bulk requests

```java
ArrayList<BulkOperation> ops = new ArrayList<>();
SimplePojo doc1 = new SimplePojo("Document 1", "The text of document 1");
ops.add(new BulkOperation.Builder().index(
        IndexOperation.of(io -> io.index(TEST_INDEX).id("id1").document(doc1))
).build());
SimplePojo doc2 = new SimplePojo("Document 2", "The text of document 2");
ops.add(new BulkOperation.Builder().index(
        IndexOperation.of(io -> io.index(TEST_INDEX).id("id2").document(doc2))
).build());
SimplePojo doc3 = getLongDoc("Long Document 3", 100000);
ops.add(new BulkOperation.Builder().index(
        IndexOperation.of(io -> io.index(TEST_INDEX).id("id3").document(doc3))
).build());

BulkRequest.Builder bulkReq = new BulkRequest.Builder()
        .index(index)
        .operations(ops)
        .refresh(Refresh.WaitFor);
BulkResponse bulkResponse = client.bulk(bulkReq.build());
```

## Aggregations

```java
SearchRequest searchRequest = new SearchRequest.Builder().query(q -> q.match(m -> m.field("firstName")
                                                                                   .query(FieldValue.of("John"))))
                                                         .aggregations("firstNames", new Aggregation.Builder().terms(t -> t.field("firstName.keyword"))
                                                                                                              .build())
                                                         .build();

SearchResponse<IndexData> searchResponse = client.search(searchRequest, IndexData.class);
for (Map.Entry<String, Aggregate> entry : searchResponse.aggregations().entrySet()) {
  System.out.println("Agg - " + entry.getKey());
  entry.getValue().sterms().buckets().array().forEach(b -> System.out.printf("%s : %d%n", b.key(), b.docCount()));
}
```

## Delete the document

The following sample code deletes a document whose ID is 1.

```java
client.delete(d -> d.index(index).id("1"));
```

## Delete the index

```java
DeleteIndexRequest deleteIndexRequest = new DeleteRequest.Builder().index(index).build();
DeleteIndexResponse deleteIndexResponse = client.indices().delete(deleteIndexRequest);
```

## Cat API

### Cat Indices
The following sample code cat indices with required headers and sorted by creation date

```java
IndicesRequest indicesRequest = new IndicesRequest.Builder()
        .headers("index,health,status,pri,rep,doc.count,creation.date,creation.date.string").sort("creation.date").build();
IndicesResponse indicesResponse = javaClient().cat().indices(indicesRequest);
```


### Cat aliases
The following sample code cat aliases with name "test-alias" and sorted by index
```java
AliasesRequest aliasesRequest = new AliasesRequest.Builder().name("test-alias").sort("index").build();
AliasesResponse aliasesResponse = javaClient().cat().aliases(aliasesRequest);
```

### Cat nodes
The following sample code cat nodes sorted by cpu
```java
NodesResponse nodesResponse = javaClient().cat().nodes(r -> r.sort("cpu"));
```

# Using different transport options

## Amazon OpenSearch Service

Requests to [OpenSearch Service and OpenSearch Serverless](https://docs.aws.amazon.com/opensearch-service/index.html) must be signed using the AWS signing protocol. Use `AwsSdk2Transport` to send signed requests.

```java
SdkHttpClient httpClient = ApacheHttpClient.builder().build();

OpenSearchClient client = new OpenSearchClient(
    new AwsSdk2Transport(
        httpClient,
        "search-...us-west-2.es.amazonaws.com", // OpenSearch endpoint, without https://
        "es" // signing service name, use "aoss" for OpenSearch Serverless
        Region.US_WEST_2, // signing service region
        AwsSdk2TransportOptions.builder().build()
    )
);

InfoResponse info = client.info();
System.out.println(info.version().distribution() + ": " + info.version().number());

httpClient.close();
```
