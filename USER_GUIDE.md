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
  - [Search documents using a match query](#search-documents-using-a-match-query)
  - [Aggregations](#aggregations)
  - [Delete the document](#delete-the-document)
  - [Delete the index](#delete-the-index)
- [Using different transport options](#using-different-transport-options)
  - [Amazon Managed OpenSearch](#amazon-managed-opensearch)

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
Transport transport = new RestClientTransport(restClient, new JacksonJsonpMapper()); 
OpenSearchClient client = new OpenSearchClient(transport);
```

The `JacksonJsonpMapper` class (2.x versions) only supports Java 7 objects by default. [Java 8 modules](https://github.com/FasterXML/jackson-modules-java8) to support JDK8 classes such as the Date and Time API (JSR-310), `Optional`, and more can be used by including [the additional datatype dependency](https://github.com/FasterXML/jackson-modules-java8#usage) and adding the module.  For example, to include JSR-310 classes:

```java
Transport transport = new RestClientTransport(restClient,
    new JacksonJsonpMapper(new ObjectMapper().registerModule(new JavaTimeModule()))); 
OpenSearchClient client = new OpenSearchClient(transport);
```

### Create a client using `ApacheHttpClient5Transport`

```java
final Transport transport = ApacheHttpClient5TransportBuilder
    .builder(hosts)
    .setMapper(new JacksonJsonpMapper())
    .build();
OpenSearchClient client = new OpenSearchClient(transport);
```

The Apache HttpClient 5 based transport has dependences on Apache HttpClient 5 and Apache HttpCore 5 which has to be added to the project explicitly.

```gradle
    implementation("org.apache.httpcomponents.client5", "httpclient5", "5.1.4")
    implementation("org.apache.httpcomponents.core5", "httpcore5", "5.1.5")
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

# Using different transport options

## Amazon Managed OpenSearch

Use `AwsSdk2Transport` to make requests to Amazon Managed OpenSearch.

```java
SdkHttpClient httpClient = ApacheHttpClient.builder().build();

OpenSearchClient client = new OpenSearchClient(
    new AwsSdk2Transport(
        httpClient,
        "search-...us-west-2.es.amazonaws.com", // OpenSearch endpoint, without https://
        "es" // signing service name
        Region.US_WEST_2, // signing service region
        AwsSdk2TransportOptions.builder().build()
    )
);

InfoResponse info = client.info();
System.out.println(info.version().distribution() + ": " + info.version().number());

httpClient.close();
```
