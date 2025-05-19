- [OpenSearch Java Client User Guide](#opensearch-java-client-user-guide)
  - [Setup](#setup)
  - [Basic Features](#basic-features)
    - [Creating a client](#creating-a-client)
      - [Using `ApacheHttpClient5Transport`](#using-apachehttpclient5transport)
      - [Using `RestClientTransport` (deprecated)](#using-restclienttransport-deprecated)
    - [Creating an index](#creating-an-index)
      - [With default settings](#with-default-settings)
      - [With custom settings and mappings](#with-custom-settings-and-mappings)
      - [With FlatObject mappings](#with-flat-object-mappings)
    - [Indexing data](#indexing-data)
    - [Searching for a document](#searching-for-a-document)
    - [Deleting a document](#deleting-a-document)
  - [Deleting an index](#deleting-an-index)
  - [Advanced Features](#advanced-features)
  - [Plugins](#plugins)

# OpenSearch Java Client User Guide

## Setup

To start using the OpenSearch Java client, you need to provide a transport. The default `ApacheHttpClient5TransportBuilder` transport comes with the Java client. To use the OpenSearch Java client with the default transport, add it to your `pom.xml` file as a dependency:

```
<dependency>
  <groupId>org.opensearch.client</groupId>
  <artifactId>opensearch-java</artifactId>
  <version>2.6.0</version>
</dependency>
```

If you’re using Gradle, add the following dependencies to your project:

```
dependencies {
  implementation 'org.opensearch.client:opensearch-java:2.6.0'
}
```

## Basic Features

In the example below, we create a client, create an index with default and non-default settings, insert a document into the index, search for the document, delete the document, and finally delete the index.

You can find working versions of the code below that can be run with a local instance of OpenSearch in [samples](./samples/).

### Creating a client

There are multiple low level transports which `OpenSearchClient` could be configured with, the `ApacheHttpClient5Transport` being the default one.

#### Using `ApacheHttpClient5Transport`

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

See [SampleClient.java](./samples/src/main/java/org/opensearch/client/samples/SampleClient.java) for a working sample.

#### Using `RestClientTransport` (deprecated)

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

### Creating an index

#### With default settings

```java
String index = "sample-index";
CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index(index).build();
client.indices().create(createIndexRequest);
```

#### With custom settings and mappings

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
#### With flat object mappings
OpenSearch supports FlatObject mappings from version 2.7.0 without additional parameters.

```java
final CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index(indexName)
                    .mappings(m -> m.properties("issue", Property.of(p -> p.flatObject(new FlatObjectProperty.Builder().build()))))
                    .build();
client.indices().create(createIndexRequest);
```

You can find a working sample of the above code in [FlatObjectBasics.java](./samples/src/main/java/org/opensearch/client/samples/FlatObjectBasics.java).


### Indexing data

[IndexData](./samples/src/main/java/org/opensearch/client/samples/util/IndexData.java) refers to sample data class.

```java
IndexData indexData = new IndexData("Document 1", "Text for document 1");
IndexRequest<IndexData> indexRequest = new IndexRequest.Builder<IndexData>().index(index).id("1").document(indexData).build();
client.index(indexRequest);

indexData = new IndexData("Document 2", "Text for document 2");
indexRequest = new IndexRequest.Builder<IndexData>().index(index).id("2").document(indexData).build();
client.index(indexRequest);
```

### Searching for a document

```java
SearchResponse<IndexData> searchResponse = client.search(s -> s.index(index), IndexData.class);
for (int i = 0; i < searchResponse.hits().hits().size(); i++) {
  System.out.println(searchResponse.hits().hits().get(i).source());
}
```

### Deleting a document

The following sample code deletes a document whose ID is 1.

```java
client.delete(d -> d.index(index).id("1"));
```

## Deleting an index

```java
DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest.Builder().index(index).build();
DeleteIndexResponse deleteIndexResponse = client.indices().delete(deleteIndexRequest);
```

You can find a working sample of the above code in [IndexingBasics.java](./samples/src/main/java/org/opensearch/client/samples/IndexingBasics.java).

## Advanced Features

- [Authentication (IAM, SigV4)](./guides/auth.md)
- [Bulk Indexing](./guides/bulk.md)
- [Cat APIs](./guides/cat.md)
- [Data Stream APIs](./guides/data_stream.md)
- [Point-in-Time APIs](./guides/point_in_time.md)
- [Search](./guides/search.md)
- [Generic Client](./guides/generic.md)
- [Json](./guides/json.md)

## Plugins

- [k-NN](guides/plugins/knn.md)