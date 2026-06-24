- [Document Lifecycle](#document-lifecycle)
  - [Setup](#setup)
  - [Create a document with an ID](#create-a-document-with-an-id)
  - [Handle duplicate creates](#handle-duplicate-creates)
  - [Index or replace a document](#index-or-replace-a-document)
  - [Create a document with an auto-generated ID](#create-a-document-with-an-auto-generated-id)
  - [Get a document](#get-a-document)
  - [Filter source fields](#filter-source-fields)
  - [Get multiple documents](#get-multiple-documents)
  - [Check whether a document exists](#check-whether-a-document-exists)
  - [Update a document](#update-a-document)
  - [Update a document with a script](#update-a-document-with-a-script)
  - [Update documents by query](#update-documents-by-query)
  - [Reindex documents](#reindex-documents)
  - [Delete a document](#delete-a-document)
  - [Delete documents by query](#delete-documents-by-query)
  - [Clean up](#clean-up)

# Document Lifecycle

This guide covers common document lifecycle operations with the OpenSearch Java client: creating, indexing, retrieving, updating, reindexing, and deleting documents.

You can find a working version of the code in [DocumentLifecycle.java](../samples/src/main/java/org/opensearch/client/samples/DocumentLifecycle.java).

## Setup

Create a client and the indexes used by the examples below.

```java
OpenSearchClient client = SampleClient.create();
String index = "movies-document-lifecycle";
String reindexedIndex = "movies-document-lifecycle-reindexed";

client.indices().create(c -> c.index(index));
```

The examples use this `Movie` document class.

```java
public static class Movie {
    private String title;
    private Integer year;

    public Movie() {}

    public Movie(String title, Integer year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
```

## Create a document with an ID

Use the create API when the document must not already exist. OpenSearch returns an error if another document already has the same ID.

```java
Movie movie = new Movie("Beauty and the Beast", 1991);

CreateResponse response = client.create(
    c -> c.index(index)
        .id("1")
        .document(movie)
        .refresh(Refresh.WaitFor)
);
```

## Handle duplicate creates

A second create request with the same ID returns a `409` conflict. Keep expected errors inside a `try/catch` block so the sample can keep running. Depending on the transport and error conversion path, the conflict may be raised as a transport `ResponseException` or as an `OpenSearchException`.

```java
try {
    client.create(c -> c.index(index).id("1").document(new Movie("Beauty and the Beast", 1991)));
} catch (ResponseException e) {
    if (e.status() != 409) {
        throw e;
    }
} catch (OpenSearchException e) {
    if (e.status() != 409) {
        throw e;
    }
}
```

## Index or replace a document

Use the index API when you want to create or replace a document. If the ID already exists, OpenSearch replaces the stored document.

```java
IndexResponse response = client.index(
    i -> i.index(index)
        .id("1")
        .document(new Movie("Beauty and the Beast: Special Edition", 2002))
        .refresh(Refresh.WaitFor)
);
```

## Create a document with an auto-generated ID

If you do not provide an ID, OpenSearch generates one and returns it in the index response.

```java
IndexResponse response = client.index(
    i -> i.index(index)
        .document(new Movie("The Lion King", 1994))
        .refresh(Refresh.WaitFor)
);

String generatedId = response.id();
```

## Get a document

Use the get API to retrieve a document by index and ID.

```java
GetResponse<Movie> response = client.get(g -> g.index(index).id("1"), Movie.class);

if (response.found()) {
    Movie movie = response.source();
}
```

## Filter source fields

Use source includes or excludes to control which fields OpenSearch returns in `_source`.

```java
GetResponse<Movie> titleOnly = client.get(
    g -> g.index(index)
        .id("1")
        .sourceIncludes("title"),
    Movie.class
);

GetResponse<Movie> withoutYear = client.get(
    g -> g.index(index)
        .id("1")
        .sourceExcludes("year"),
    Movie.class
);
```

## Get multiple documents

Use the multi get API to retrieve several documents in one request.

```java
MgetResponse<Movie> response = client.mget(
    m -> m.index(index).ids("1", generatedId),
    Movie.class
);

for (MultiGetResponseItem<Movie> item : response.docs()) {
    if (item.isResult() && item.result().found()) {
        Movie movie = item.result().source();
    }
}
```

## Check whether a document exists

Use the exists API when you only need to know whether a document is present.

```java
boolean exists = client.exists(e -> e.index(index).id("1")).value();
```

## Update a document

Use the update API with a partial document to change selected fields.

```java
UpdateRequest<Movie, Map<String, Object>> request =
    new UpdateRequest.Builder<Movie, Map<String, Object>>()
        .index(index)
        .id("1")
        .doc(Map.of("year", (Object) 1995))
        .refresh(Refresh.WaitFor)
        .build();

UpdateResponse<Movie> response = client.update(request, Movie.class);
```

## Update a document with a script

Use an inline script when the update should be computed from the current document state.

```java
UpdateRequest<Movie, Object> request = new UpdateRequest.Builder<Movie, Object>()
    .index(index)
    .id("1")
    .script(s -> s.inline(i -> i.source("ctx._source.year += 5")))
    .refresh(Refresh.WaitFor)
    .build();

UpdateResponse<Movie> response = client.update(request, Movie.class);
```

## Update documents by query

Use update by query to update every document that matches a query.

```java
client.index(
    i -> i.index(index)
        .id("future")
        .document(new Movie("Future Movie", 2025))
        .refresh(Refresh.WaitFor)
);

Query newerThan2023 = Query.of(
    q -> q.range(r -> r.field("year").gt(JsonData.of(2023)))
);

UpdateByQueryResponse response = client.updateByQuery(
    u -> u.index(index)
        .query(newerThan2023)
        .script(s -> s.inline(i -> i.source("ctx._source.year -= 1")))
        .refresh(Refresh.True)
);
```

## Reindex documents

Use reindex to copy documents from one index to another.

```java
ReindexResponse response = client.reindex(
    r -> r.source(s -> s.index(index))
        .dest(d -> d.index(reindexedIndex))
        .refresh(Refresh.True)
        .waitForCompletion(true)
);
```

## Delete a document

Use the delete API to remove one document by ID.

```java
DeleteResponse response = client.delete(
    d -> d.index(index)
        .id("1")
        .refresh(Refresh.WaitFor)
);
```

## Delete documents by query

Use delete by query to remove every document that matches a query.

```java
DeleteByQueryResponse response = client.deleteByQuery(
    d -> d.index(index)
        .query(newerThan2023)
        .refresh(Refresh.True)
);
```

## Clean up

Delete the sample indexes when you are done.

```java
client.indices().delete(d -> d.index(reindexedIndex));
client.indices().delete(d -> d.index(index));
```
