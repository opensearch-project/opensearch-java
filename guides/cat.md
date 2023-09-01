- [Cat API](#cat-api)
  - [Cat Indices](#cat-indices)
  - [Cat aliases](#cat-aliases)
  - [Cat nodes](#cat-nodes)
  - [Cat point in time segments](#cat-point-in-time-segments)

# Cat API

The CAT API is a human-readable interface that returns plain text instead of traditional JSON.

## Cat Indices
The following sample code cat indices with required headers and sorted by creation date

```java
IndicesRequest indicesRequest = new IndicesRequest.Builder()
        .headers("index,health,status,pri,rep,doc.count,creation.date,creation.date.string").sort("creation.date").build();
IndicesResponse indicesResponse = javaClient().cat().indices(indicesRequest);
```


## Cat aliases
The following sample code cat aliases with name "test-alias" and sorted by index

```java
AliasesRequest aliasesRequest = new AliasesRequest.Builder().name("test-alias").sort("index").build();
AliasesResponse aliasesResponse = javaClient().cat().aliases(aliasesRequest);
```

## Cat nodes
The following sample code cat nodes sorted by cpu

```java
NodesResponse nodesResponse = javaClient().cat().nodes(r -> r.sort("cpu"));
```

## Cat point in time segments
Similarly to the CAT Segments API, the PIT Segments API provides low-level information about the disk utilization of a PIT by describing its Lucene segments. 

```java
SegmentsResponse pitSegmentsResponse = javaClient().cat()
                .pitSegments(r -> r.headers("index,shard,id,segment,size"));
```