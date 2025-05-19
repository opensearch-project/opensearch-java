- [Point-in-Time](#point-in-time)
  - [Point-In-Time API](#point-in-time-api)
    - [Creating a point in time](#creating-a-point-in-time)
    - [List all point in time](#list-all-point-in-time)
    - [Delete point in time](#delete-point-in-time)

# Point-in-Time

[Point in Time (PIT)](https://opensearch.org/docs/latest/search-plugins/point-in-time/) lets you run different queries against a dataset that is fixed in time.

## Point-In-Time API

### Creating a point in time

To create a PIT, first create an index.

```
java
String index = "sample-index";
CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index(index).build();
client.indices().create(createIndexRequest);
```

To create a PIT, the keep_alive query parameter is required; it specifies how long to keep a PIT.

```java
CreatePitRequest createPitRequest = new CreatePitRequest.Builder()
                .targetIndexes(Collections.singletonList(index))
                .keepAlive(new Time.Builder().time("100m").build()).build();

CreatePitResponse createPitResponse = client.createPit(createPitRequest);                
```

### Get all point in time

Returns all PITs in the OpenSearch cluster.

```java
GetAllPitsResponse getAllPitsResponse = client.getAllPits();
```

### Delete point in time

Deletes one, several, or all PITs. PITs are automatically deleted when the keep_alive time period elapses. However, to deallocate resources, you can delete a PIT using the Delete PIT API. The Delete PIT API supports deleting a list of PITs by ID or deleting all PITs at once.

```java
DeletePitRequest deletePitRequest = new DeletePitRequest.Builder()
                .pitId(Collections.singletonList(createPitResponse.pitId())).build();

DeletePitResponse deletePitResponse = client.deletePit(deletePitRequest);
```

You can find a working sample of the above code in [PointInTime.java](../samples/src/main/java/org/opensearch/client/samples/PointInTime.java).