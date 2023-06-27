# User Guide

- [User Guide](#user-guide)
  - [Sample data](#sample-data)
    - [IndexData class](#indexdata-class)
  - [Create a client](#create-a-client)
    - [Create a client using `RestClientTransport`](#create-a-client-using-restclienttransport)
    - [Create a client using `ApacheHttpClient5Transport`](#create-a-client-using-apachehttpclient5transport)
  - [Create an index](#create-an-index) 
    - [Create an index with default settings](#create-an-index-with-default-settings)
    - [Create an index with custom settings and mappings](#create-an-index-with-custom-settings-and-mappings)
  - [Index data](#index-data)
  - [Search for the documents](#search-for-the-documents)
    - [Get raw JSON results](#get-raw-json-results)
  - [Search documents using a match query](#search-documents-using-a-match-query)
  - [Search documents using k-NN](#search-documents-using-k-nn)
    - [Exact k-NN with scoring script](#exact-k-nn-with-scoring-script)
    - [Exact k-NN with painless scripting extension](#exact-k-nn-with-painless-scripting-extension)
  - [Search documents using suggesters](#search-documents-using-suggesters)
    - [App Data class](#app-data-class)
    - [Using completion suggester](#using-completion-suggester)
    - [Using term suggester](#using-term-suggester)
    - [Using phrase suggester](#using-phrase-suggester)
  - [Bulk requests](#bulk-requests)
  - [Aggregations](#aggregations)
  - [Delete the document](#delete-the-document)
  - [Delete the index](#delete-the-index)
  - [Data Stream API](#data-stream-api)
    - [Create a data stream](#create-a-data-stream)
    - [Get data stream](#get-data-stream)
    - [Data stream stats](#data-stream-stats)
    - [Delete data stream and backing indices](#delete-data-stream-and-backing-indices)
  - [Point-In-Time API](#point-in-time-api)
    - [Creating a point in time](#creating-a-point-in-time)
    - [List all point in time](#list-all-point-in-time)
    - [Delete point in time](#delete-point-in-time)
  - [Cat API](#cat-api)
    - [Cat Indices](#cat-indices)
    - [Cat aliases](#cat-aliases)
    - [Cat nodes](#cat-nodes)
    - [Cat point in time segments](#cat-point-in-time-segments)
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

There are multiple low level transports which `OpenSearchClient` could be configured with, the `ApacheHttpClient5Transport` being the default one.

### Create a client using `ApacheHttpClient5Transport`

```java
import org.apache.hc.core5.http.HttpHost;

final HttpHost[] hosts = new HttpHost[] {
    new HttpHost("http", "localhost", 9200)
  };

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

### Create a client using `RestClientTransport` (deprecated)

```java
import org.apache.hc.core5.http.HttpHost;

final HttpHost[] hosts = new HttpHost[] {
    new HttpHost("http", "localhost", 9200)
  };

// Initialize the client with SSL and TLS enabled
final RestClient restClient = RestClient
  .builder(hosts)
  .build();

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

## Create an index

### Create an index with default settings

```java
String index = "sample-index";
CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index(index).build();
client.indices().create(createIndexRequest);
```

### Create an index with custom settings and mappings

```java
String index = "sample-index";
IndexSettings settings = new IndexSettings.Builder()
        .numberOfShards("2")
        .numberOfReplicas("1")
        .build();
TypeMapping mapping = new TypeMapping.Builder()
        .properties("age", new Property.Builder().integer(new IntegerNumberProperty.Builder().build()).build())
        .build();
CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder()
        .index(index)
        .settings(settings)
        .mappings(mapping)
        .build();
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

## Search documents using k-NN

### Exact k-NN with scoring script

1. Create index with custom mapping

```java
String index = "my-knn-index-1";
TypeMapping mapping = new TypeMapping.Builder()
        .properties("my_vector", new Property.Builder()
            .knnVector(new KnnVectorProperty.Builder()
                .dimension(4)
                .build())
            .build())
        .build();
CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder()
        .index(index)
        .mappings(mapping)
        .build();
client.indices().create(createIndexRequest);
```

2. Index documents

```java
JsonObject doc1 = Json.createObjectBuilder()
        .add("my_vector", Json.createArrayBuilder().add(1.5).add(5.5).add(4.5).add(6.4).build())
        .add("price", 10.3)
        .build();
JsonObject doc2 = Json.createObjectBuilder()
        .add("my_vector", Json.createArrayBuilder().add(2.5).add(3.5).add(5.6).add(6.7).build())
        .add("price", 5.5)
        .build();
JsonObject doc3 = Json.createObjectBuilder()
        .add("my_vector", Json.createArrayBuilder().add(4.5).add(5.5).add(6.7).add(3.7).build())
        .add("price", 4.4)
        .build();

ArrayList<BulkOperation> operations = new ArrayList<>();
operations.add(new BulkOperation.Builder().index(
        IndexOperation.of(io -> io.index(index).id("1").document(doc1))
        ).build());
operations.add(new BulkOperation.Builder().index(
        IndexOperation.of(io -> io.index(index).id("2").document(doc2))
        ).build());
operations.add(new BulkOperation.Builder().index(
        IndexOperation.of(io -> io.index(index).id("3").document(doc3))
        ).build());

BulkRequest bulkRequest = new BulkRequest.Builder()
        .index(index)
        .operations(operations)
        .build();
client.bulk(bulkRequest);
```

3. Search documents using k-NN script score (_This implementation utilizes `com.fasterxml.jackson.databind.JsonNode` as the target document class, which is not part of the OpenSearch Java library. However, any document class that matches the searched data can be used instead._)

```java
InlineScript inlineScript = new InlineScript.Builder()
        .source("knn_score")
        .lang("knn")
        .params(Map.of(
                "field", JsonData.of("my_vector"),
                "query_value", JsonData.of(List.of(1.5, 5.5, 4.5, 6.4)),
                "space_type", JsonData.of("cosinesimil")
                ))
        .build();
Query query = new Query.Builder()
        .scriptScore(new ScriptScoreQuery.Builder()
            .query(new Query.Builder()
                .matchAll(new MatchAllQuery.Builder().build())
                .build())
            .script(new Script.Builder()
                .inline(inlineScript)
                .build())
            .build())
        .build();
SearchRequest searchRequest = new SearchRequest.Builder()
        .index(index)
        .query(query)
        .build();
SearchResponse<JsonNode> searchResponse = client.search(searchRequest, JsonNode.class);
```

### Exact k-NN with painless scripting extension

1. Create index with custom mapping

```java
String index = "my-knn-index-1";
TypeMapping mapping = new TypeMapping.Builder()
        .properties("my_vector", new Property.Builder()
            .knnVector(new KnnVectorProperty.Builder()
                .dimension(4)
                .build())
            .build())
        .build();
CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder()
        .index(index)
        .mappings(mapping)
        .build();
client.indices().create(createIndexRequest);
```

2. Index documents

```java
JsonObject doc1 = Json.createObjectBuilder()
        .add("my_vector", Json.createArrayBuilder().add(1.5).add(5.5).add(4.5).add(6.4).build())
        .add("price", 10.3)
        .build();
JsonObject doc2 = Json.createObjectBuilder()
        .add("my_vector", Json.createArrayBuilder().add(2.5).add(3.5).add(5.6).add(6.7).build())
        .add("price", 5.5)
        .build();
JsonObject doc3 = Json.createObjectBuilder()
        .add("my_vector", Json.createArrayBuilder().add(4.5).add(5.5).add(6.7).add(3.7).build())
        .add("price", 4.4)
        .build();

ArrayList<BulkOperation> operations = new ArrayList<>();
operations.add(new BulkOperation.Builder().index(
        IndexOperation.of(io -> io.index(index).id("1").document(doc1))
        ).build());
operations.add(new BulkOperation.Builder().index(
        IndexOperation.of(io -> io.index(index).id("2").document(doc2))
        ).build());
operations.add(new BulkOperation.Builder().index(
        IndexOperation.of(io -> io.index(index).id("3").document(doc3))
        ).build());

BulkRequest bulkRequest = new BulkRequest.Builder()
        .index(index)
        .operations(operations)
        .build();
client.bulk(bulkRequest);
```

3. Search documents using k-NN with painless scripting extension (_This implementation utilizes `com.fasterxml.jackson.databind.JsonNode` as the target document class, which is not part of the OpenSearch Java library. However, any document class that matches the searched data can be used instead._)

```java
InlineScript inlineScript = new InlineScript.Builder()
        .source("1.0 + cosineSimilarity(params.query_value, doc[params.field])")
        .params(Map.of(
            "field", JsonData.of("my_vector"),
            "query_value", JsonData.of(List.of(1.5, 5.5, 4.5, 6.4))
            ))
        .build();
Query query = new Query.Builder()
        .scriptScore(new ScriptScoreQuery.Builder()
            .query(new Query.Builder()
                .matchAll(new MatchAllQuery.Builder().build())
                .build())
            .script(new Script.Builder()
                .inline(inlineScript)
                .build())
            .build())
        .build();
SearchRequest searchRequest = new SearchRequest.Builder()
        .index(index)
        .query(query)
        .build();
SearchResult<JsonNode> searchResult = client.search(searchRequest, JsonNode.class);
```

## Search documents using suggesters

### App Data class

```java
public static class AppData {

    private int intValue;
    private String msg;

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
```

### Using completion suggester

```java
String index = "completion-suggester";

Property intValueProp = new Property.Builder()
                .long_(v -> v)
                .build();
Property msgCompletionProp = new Property.Builder()
                .completion(c -> c)
                .build();
client.indices().create(c -> c
                .index(index)
                .mappings(m -> m
                                .properties("intValue", intValueProp)
                                .properties("msg", msgCompletionProp)));

AppData appData = new AppData();
appData.setIntValue(1337);
appData.setMsg("foo");

client.index(b -> b
                .index(index)
                .id("1")
                .document(appData)
                .refresh(Refresh.True));

appData.setIntValue(1338);
appData.setMsg("foobar");

client.index(b -> b
                .index(index)
                .id("2")
                .document(appData)
                .refresh(Refresh.True));

String suggesterName = "msgSuggester";

CompletionSuggester completionSuggester = FieldSuggesterBuilders.completion()
                .field("msg")
                .size(1)
                .build();
FieldSuggester fieldSuggester = new FieldSuggester.Builder().prefix("foo")
                .completion(completionSuggester)
                .build();
Suggester suggester = new Suggester.Builder()
                .suggesters(Collections.singletonMap(suggesterName, fieldSuggester))
                .build();
SearchRequest searchRequest = new SearchRequest.Builder()
                .index(index)
                .suggest(suggester)
                .build();

SearchResponse<AppData> response = client.search(searchRequest, AppData.class);
```

### Using term suggester

```java
 String index = "term-suggester";
        
// term suggester does not require a special mapping
client.indices().create(c -> c
                .index(index));

AppData appData = new AppData();
appData.setIntValue(1337);
appData.setMsg("foo");

client.index(b -> b
                .index(index)
                .id("1")
                .document(appData)
                .refresh(Refresh.True));

appData.setIntValue(1338);
appData.setMsg("foobar");

client.index(b -> b
                .index(index)
                .id("2")
                .document(appData)
                .refresh(Refresh.True));

String suggesterName = "msgSuggester";

TermSuggester termSuggester = FieldSuggesterBuilders.term()
                .field("msg")
                .size(1)
                .build();
FieldSuggester fieldSuggester = new FieldSuggester.Builder().text("fool")
                .term(termSuggester)
                .build();
Suggester suggester = new Suggester.Builder()
                .suggesters(Collections.singletonMap(suggesterName, fieldSuggester))
                .build();
SearchRequest searchRequest = new SearchRequest.Builder()
                .index(index)
                .suggest(suggester)
                .build();

SearchResponse<AppData> response = client.search(searchRequest, AppData.class);
```

### Using phrase suggester

```java
String index = "test-phrase-suggester";

ShingleTokenFilter shingleTokenFilter = new ShingleTokenFilter.Builder().minShingleSize("2")
                .maxShingleSize("3")
                .build();

Analyzer analyzer = new Analyzer.Builder()
                .custom(new CustomAnalyzer.Builder().tokenizer("standard")
                                .filter(Arrays.asList("lowercase", "shingle")).build())
                .build();

TokenFilter tokenFilter = new TokenFilter.Builder()
                .definition(new TokenFilterDefinition.Builder()
                                .shingle(shingleTokenFilter).build())
                .build();

IndexSettingsAnalysis indexSettingsAnalysis = new IndexSettingsAnalysis.Builder()
                .analyzer("trigram", analyzer)
                .filter("shingle", tokenFilter)
                .build();

IndexSettings settings = new IndexSettings.Builder().analysis(indexSettingsAnalysis).build();

TypeMapping mapping = new TypeMapping.Builder().properties("msg", new Property.Builder()
                .text(new TextProperty.Builder().fields("trigram", new Property.Builder()
                                .text(new TextProperty.Builder().analyzer("trigram").build())
                                .build()).build())
                .build()).build();

client.indices().create(c -> c
                .index(index)
                .settings(settings)
                .mappings(mapping));

AppData appData = new AppData();
appData.setIntValue(1337);
appData.setMsg("Design Patterns");

client.index(b -> b
                .index(index)
                .id("1")
                .document(appData)
                .refresh(Refresh.True));

appData.setIntValue(1338);
appData.setMsg("Software Architecture Patterns Explained");

client.index(b -> b
                .index(index)
                .id("2")
                .document(appData)
                .refresh(Refresh.True));

String suggesterName = "msgSuggester";

PhraseSuggester phraseSuggester = FieldSuggesterBuilders.phrase()
                .field("msg.trigram")
                .build();
FieldSuggester fieldSuggester = new FieldSuggester.Builder().text("design paterns")
                .phrase(phraseSuggester)
                .build();
Suggester suggester = new Suggester.Builder()
                .suggesters(Collections.singletonMap(suggesterName, fieldSuggester))
                .build();
SearchRequest searchRequest = new SearchRequest.Builder()
                .index(index)
                .suggest(suggester)
                .build();

SearchResponse<AppData> response = client.search(searchRequest, AppData.class);
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

## Data Stream API

### Create a data stream 
Before creating a data stream, you need to create an index template which configures a set of indices as a data stream.
A data stream must have a timestamp field. If not specified, OpenSearch uses `@timestamp` as the default timestamp field name. 

The following sample code creates an index template for data stream with a custom timestamp field, and creates a data stream 
which matches the name pattern specified in the index template. 
```java
String dataStreamIndexTemplateName = "sample-data-stream-template";
String timestampFieldName = "my_timestamp_field";
String namePattern = "sample-data-stream-*";
String dataStreamName = "sample-data-stream-1";

// Create an index template which configures data stream
PutIndexTemplateRequest putIndexTemplateRequest = new PutIndexTemplateRequest.Builder()
        .name(dataStreamIndexTemplateName)
        .indexPatterns(namePattern)
        .dataStream(new DataStream.Builder()
                .timestampField(t -> t.name(timestampFieldName))
                .build())
        .build();
PutIndexTemplateResponse putIndexTemplateResponse = javaClient().indices().putIndexTemplate(putIndexTemplateRequest);

// Create a data stream
CreateDataStreamRequest createDataStreamRequest = new CreateDataStreamRequest.Builder().name(dataStreamName).build();
CreateDataStreamResponse createDataStreamResponse = javaClient().indices().createDataStream(createDataStreamRequest);
```

### Get data stream
```java
GetDataStreamRequest getDataStreamRequest = new GetDataStreamRequest.Builder().name(dataStreamName).build();
GetDataStreamResponse getDataStreamResponse = javaClient().indices().getDataStream(getDataStreamRequest);
```

### Data stream stats
```java
DataStreamsStatsRequest dataStreamsStatsRequest = new DataStreamsStatsRequest.Builder().name(dataStreamName).build();
DataStreamsStatsResponse dataStreamsStatsResponse = javaClient().indices().dataStreamsStats(dataStreamsStatsRequest);
```

### Delete data stream and backing indices
```java
DeleteDataStreamRequest deleteDataStreamRequest = new DeleteDataStreamRequest.Builder().name(dataStreamName).build();
DeleteDataStreamResponse deleteDataStreamResponse = javaClient().indices().deleteDataStream(deleteDataStreamRequest);
```

## Point-In-Time API

### Creating a point in time

Creates a PIT. The keep_alive query parameter is required; it specifies how long to keep a PIT.

```java
CreatePitRequest createPitRequest = new CreatePitRequest.Builder()
                .targetIndexes(Collections.singletonList(index))
                .keepAlive(new Time.Builder().time("100m").build()).build();

CreatePitResponse createPitResponse = javaClient()
                .createPit(createPitRequest);                
```

### List all point in time

Returns all PITs in the OpenSearch cluster.

```java
ListAllPitResponse listAllPitResponse = javaClient().listAllPit();
```

### Delete point in time

Deletes one, several, or all PITs. PITs are automatically deleted when the keep_alive time period elapses. However, to deallocate resources, you can delete a PIT using the Delete PIT API. The Delete PIT API supports deleting a list of PITs by ID or deleting all PITs at once.

```java
DeletePitRequest deletePitRequest = new DeletePitRequest.Builder()
                .pitId(Collections.singletonList("pit_id")).build();

DeletePitResponse deletePitResponse = javaClient()
                .deletePit(deletePitRequest);
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

### Cat point in time segments
Similarly to the CAT Segments API, the PIT Segments API provides low-level information about the disk utilization of a PIT by describing its Lucene segments. 
```java
SegmentsResponse pitSegmentsResponse = javaClient().cat()
                .pitSegments(r -> r.headers("index,shard,id,segment,size"));
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
