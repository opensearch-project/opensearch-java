# Index Lifecycle
This guide covers OpenSearch Java Client API actions for Index Lifecycle. You'll learn how to create, read, update, and delete indices in your OpenSearch cluster. We will also leverage index templates to create default settings and mappings for indices of certain patterns.

## Setup

In this guide, we will need an OpenSearch cluster with more than one node. Let's use the sample [docker-compose.yml](https://opensearch.org/samples/docker-compose.yml) to start a cluster with two nodes. The cluster's API will be available at `localhost:9200` with basic authentication enabled with default username and password of `admin:admin`.

To start the cluster, run the following command:

```bash
cd /path/to/docker-compose.yml
docker-compose up -d
```

## IndexData Class
We will be using IndexData class which is a simple java class that stores data and methods

```java
  static class IndexData {
    private String firstName;
    private String lastName;

    public IndexData() {
    }

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

## Index Api Actions

### Create a client using RestClientTransport

Let's create a client instance to access this cluster:

This code example uses basic credentials that come with the default OpenSearch configuration.If you’re using the Java client with your own OpenSearch cluster, be sure to change the code so that it uses your own credentials.

```java
final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
    credentialsProvider.setCredentials(AuthScope.ANY,
      new UsernamePasswordCredentials("admin", "admin"));

    //Initialize the client with SSL and TLS enabled
    RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200, "https")).
      setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
        @Override
        public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
        return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
        }
      }).build();
    Transport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
    OpenSearchClient client = new OpenSearchClient(transport);
```



### Creating the index
You can create an index with default settings using the following code:

```java
  String index = "demo-index";
  CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index(index).build();
  client.indices().create(createIndexRequest);
```



### Updating settings for the index
 You can update an index's settings by using the client.indices.putSettings()

```java
  IndexSettings indexSettings = new IndexSettings.Builder().autoExpandReplicas("0-all").build();
  IndexSettings settingsBody = new IndexSettings.Builder().settings(indexSettings).build();
  PutIndicesSettingsRequest putSettingsRequest = new PutIndicesSettingsRequest.Builder().index(index).settings(settingsBody).build();
  client.indices().putSettings(putSettingsRequest);
```



### Indexing some data 
You can index into OpenSearch cluster by using client.index()

```java
  IndexData indexData = new IndexData("Bruce", "Banner");
  IndexRequest<IndexData> indexRequest = new IndexRequest.Builder<IndexData>().index(index).id("1").document(indexData).build();
  client.index(indexRequest);
```



### Searching document
let's search for the index we have just created with client.search()

```java
  SearchResponse<IndexData> searchResponse = client.search(s -> s.index(index), IndexData.class);
  for (int i = 0; i< searchResponse.hits().hits().size(); i++) {
      System.out.println(searchResponse.hits().hits().get(i).source());
  }
```



### Delete the document
let's delete the document with client.delete()

```java
  client.delete(b -> b.index(index).id("1"));
```



### Deleting the index

```java
  DeleteIndexRequest deleteRequest = new DeleteIndexRequest.Builder().index(index).build();
  DeleteIndexResponse deleteResponse = client.indices().delete(deleteRequest);
```




## Cleanup
All resources created in this guide are automatically deleted when the cluster is stopped. You can stop the cluster by running the following command:

```bash
docker-compose down
```