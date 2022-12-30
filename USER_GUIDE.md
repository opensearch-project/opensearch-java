# User Guide

- [User Guide](#user-guide)
  - [Sample data](#sample-data)
  - [Create a client](#create-a-client)
  - [Create an index](#create-an-index)
  - [Index data](#index-data)
  - [Search for the document](#search-for-the-documents)
  - [Search documents using a match query](#search-documents-using-a-match-query)
  - [Aggregations](#aggregations)
  - [Delete the document](#delete-the-document)
  - [Delete the index](#delete-the-index)
  - [Aggregations](#aggregations)

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

```java
import org.opensearch.client.opensearch.OpenSearchClient;

Transport transport = new RestClientTransport(restClient, new JacksonJsonpMapper()); 
OpenSearchClient client = new OpenSearchClient(transport);
```

The `JacksonJsonpMapper` class (2.x versions) only supports Java 7 objects by default. [Java 8 modules](https://github.com/FasterXML/jackson-modules-java8) to support JDK8 classes such as the Date and Time API (JSR-310), `Optional`, and more can be used by including [the additional datatype dependency](https://github.com/FasterXML/jackson-modules-java8#usage) and adding the module.  For example, to include JSR-310 classes:

```java
Transport transport = new RestClientTransport(restClient,
    new JacksonJsonpMapper(new ObjectMapper().registerModule(new JavaTimeModule()))); 
OpenSearchClient client = new OpenSearchClient(transport);
```

### Ignore certificate check when running OpenSearch as docker container with self-signed certificate

When running OpenSearch via [docker](https://opensearch.org/docs/latest/opensearch/install/docker/), container uses
a self-signed certificate can trigger `javax.net.ssl.SSLHandshakeException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target`.
If you don't want to import the generated cert, you can ignore the certificate validation in the client.

```java
public RestClient createLocalRestClient() {
    String endpoint = "https://localhost:9200";
    CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
    credentialsProvider.setCredentials(AuthScope.ANY,
            new UsernamePasswordCredentials("admin", "admin"));
    return RestClient.builder(HttpHost.create(endpoint))
            .setHttpClientConfigCallback((c) -> {
                // Disable cert verification
                // https://stackoverflow.com/questions/2703161/how-to-ignore-ssl-certificate-errors-in-apache-httpclient-4-0
                // because default uses a demo cert from https://github.com/opensearch-project/security/blob/207cfcc379ffd4127e32b9fdfdd75ea394b48d0e/tools/install_demo_configuration.sh#L201
                try {
                    c.setSSLContext(new SSLContextBuilder().loadTrustMaterial(null, TrustAllStrategy.INSTANCE).build())
                            .setSSLHostnameVerifier(new NoopHostnameVerifier());
                } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException e) {
                    throw new RuntimeException(e);
                }
                return c.setDefaultCredentialsProvider(credentialsProvider);
            }).build();
}
```

## Create an index

```java
String index = "sample-index";
CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index(index).build();
client.indices().create(createIndexRequest);
```

### Create an index with mapping

```java
import org.opensearch.client.opensearch._types.mapping.Property;

Property TYPE_TEXT = Property.of(p -> p.text(t -> t));

client.indices().create(b -> {
    Map<String, Property> properties = new HashMap<>();
    properties.put("firstName", TYPE_TEXT);
    properties.put("lastName", TYPE_TEXT);
    b.index("sample-index")
        .mappings(tb -> tb.properties(properties));
    return b;
});
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
