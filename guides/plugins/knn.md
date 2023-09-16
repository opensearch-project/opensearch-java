- [k-NN Plugin](#k-nn-plugin)
    - [Basic Approximate k-NN](#basic-approximate-k-nn)
        - [Create an Index](#create-an-index)
        - [Index Vectors](#index-vectors)
        - [Search for Nearest Neighbors](#search-for-nearest-neighbors)
    - [Approximate k-NN with a Boolean Filter](#approximate-k-nn-with-a-boolean-filter)
    - [Approximate k-NN with an Efficient Filter](#approximate-k-nn-with-an-efficient-filter)
    - [Exact k-NN with a scoring script](#exact-k-nn-with-a-scoring-script)
    - [Exact k-NN with the Painless scripting extensions](#exact-k-nn-with-the-painless-scripting-extensions)

# k-NN Plugin

Short for k-nearest neighbors, the k-NN plugin enables users to search for the k-nearest neighbors to a query point across an index of vectors. See the [plugin's documentation](https://opensearch.org/docs/latest/search-plugins/knn/index/) for more information.

## Basic Approximate k-NN

In the following example we create a 5-dimensional k-NN index with random data. You can find a synchronous version of this working sample in [samples/src/main/java/org/opensearch/client/samples/knn/KnnBasics.java](../../samples/src/main/java/org/opensearch/client/samples/knn/KnnBasics.java).

```bash
$ ./gradlew :samples:run -Dsamples.mainClass=knn.KnnBasics

[Main] INFO  - Running main class: org.opensearch.client.samples.knn.KnnBasics
[KnnBasics] INFO  - Server: opensearch@2.7.0
[KnnBasics] INFO  - Creating index my-index
[KnnBasics] INFO  - Indexing 10 vectors
[KnnBasics] INFO  - Waiting for indexing to finish
[KnnBasics] INFO  - Searching for vector [0.67, 0.67, 0.37, 0.0, 0.72]
[KnnBasics] INFO  - Found {values=[0.32, 0.96, 0.41, 0.04, 0.9]} with score 0.8050233
[KnnBasics] INFO  - Found {values=[0.04, 0.58, 0.13, 0.27, 0.37]} with score 0.6031363
[KnnBasics] INFO  - Found {values=[0.96, 0.88, 0.8, 0.41, 0.18]} with score 0.5640794
[KnnBasics] INFO  - Deleting index my-index
```

### Create an Index

```java
final var indexName = "my-index";
final var dimensions = 5;

client.indices().create(r -> r
        .index(indexName)
        .settings(s -> s.knn(true))
        .mappings(m -> m
                .properties("values", p -> p
                        .knnVector(k -> k.dimension(dimensions)))));
```

### Index Vectors

Given the following document class definition:

```java
public static class Doc {
    private float[] values;

    public Doc() {}

    public Doc(float[] values) {
        this.values = values;
    }

    public static Doc rand(int dimensions) {
        var values = new float[dimensions];
        for (var i = 0; i < dimensions; ++i) {
            values[i] = Math.round(Math.random() * 100.0) / 100.0f;
        }
        return new Doc(values);
    }

    // Getters/Setters & toString elided
}
```

Create 10 random vectors and insert them using the bulk API:

```java
final var nVectors = 10;
var bulkRequest = new BulkRequest.Builder();
for (var i = 0; i < nVectors; ++i) {
    var id = Integer.toString(i);
    var doc = Doc.rand(dimensions);
    bulkRequest.operations(b -> b
            .index(o -> o
                    .index(indexName)
                    .id(id)
                    .document(doc)));
}

client.bulk(bulkRequest.build());

client.indices().refresh(i -> i.index(indexName));
```

### Search for Nearest Neighbors

Create a random vector of the same size and search for its nearest neighbors.

```java
final var searchVector = new float[dimensions];
for (var i = 0; i < dimensions; ++i) {
    searchVector[i] = Math.round(Math.random() * 100.0) / 100.0f;
}

var searchResponse = client.search(s -> s
        .index(indexName)
        .query(q -> q
                .knn(k -> k
                        .field("values")
                        .vector(searchVector)
                        .k(3))),
        Doc.class);

for (var hit : searchResponse.hits().hits()) {
    System.out.println(hit.source());
}
```

## Approximate k-NN with a Boolean Filter

In the [KnnBooleanFilter.java sample](../../samples/src/main/java/org/opensearch/client/samples/knn/KnnBooleanFilter.java) we create a 5-dimensional k-NN index with random data and a `metadata` field that contains a book genre (e.g. `fiction`). The search query is a k-NN search filtered by genre. The filter clause is outside the k-NN query clause and is applied after the k-NN search.

```java
var searchResponse = client.search(s -> s
        .index(indexName)
        .query(q -> q
                .bool(b -> b
                        .filter(f -> f
                                .bool(b2 -> b2
                                        .must(m -> m
                                                .term(t -> t
                                                        .field("metadata.genre")
                                                        .value(v -> v.stringValue(searchGenre))))))
                        .must(m -> m
                                .knn(k -> k
                                        .field("values")
                                        .vector(searchVector)
                                        .k(5))))),
        Doc.class);
```

```bash
$ ./gradlew :samples:run -Dsamples.mainClass=knn.KnnBooleanFilter

[Main] INFO  - Running main class: org.opensearch.client.samples.knn.KnnBooleanFilter
[KnnBooleanFilter] INFO  - Server: opensearch@2.7.0
[KnnBooleanFilter] INFO  - Creating index my-index
[KnnBooleanFilter] INFO  - Indexing 3000 vectors
[KnnBooleanFilter] INFO  - Waiting for indexing to finish
[KnnBooleanFilter] INFO  - Searching for vector [0.18, 0.71, 0.44, 0.03, 0.42] with the 'drama' genre
[KnnBooleanFilter] INFO  - Found {values=[0.21, 0.58, 0.55, 0.09, 0.45], metadata={genre=drama}} with score 0.966744
[KnnBooleanFilter] INFO  - Deleting index my-index
```

## Approximate k-NN with an Efficient Filter

In the [KnnEfficientFilter.java sample](../../samples/src/main/java/org/opensearch/client/samples/knn/KnnEfficientFilter.java) we implement the example in [the k-NN documentation](https://opensearch.org/docs/latest/search-plugins/knn/filter-search-knn/), which creates an index that uses the Lucene engine and HNSW as the method in the mapping, containing hotel location and parking data, then search for the top three hotels near the location with the coordinates `[5, 4]` that are rated between 8 and 10, inclusive, and provide parking.

```java
var searchResponse = client.search(s -> s
        .index(indexName)
        .size(3)
        .query(q -> q
                .knn(k -> k
                        .field("location")
                        .vector(searchLocation)
                        .k(3)
                        .filter(Query.of(f -> f
                                .bool(b -> b
                                        .must(m -> m
                                                .range(r -> r
                                                        .field("rating")
                                                        .gte(JsonData.of(searchRatingMin))
                                                        .lte(JsonData.of(searchRatingMax))))
                                        .must(m -> m
                                                .term(t -> t
                                                        .field("parking")
                                                        .value(FieldValue.of(searchParking))))))))),
        Hotel.class);
```

```bash
$ ./gradlew :samples:run -Dsamples.mainClass=knn.KnnEfficientFilter

[Main] INFO  - Running main class: org.opensearch.client.samples.knn.KnnEfficientFilter
[KnnEfficientFilter] INFO  - Server: opensearch@2.7.0
[KnnEfficientFilter] INFO  - Creating index hotels-index
[KnnEfficientFilter] INFO  - Indexing hotel {location=[5.2, 4.0], parking=true, rating=5} with id 1
[KnnEfficientFilter] INFO  - Indexing hotel {location=[5.2, 3.9], parking=false, rating=4} with id 2
[KnnEfficientFilter] INFO  - Indexing hotel {location=[4.9, 3.4], parking=true, rating=9} with id 3
[KnnEfficientFilter] INFO  - Indexing hotel {location=[4.2, 4.6], parking=false, rating=6} with id 4
[KnnEfficientFilter] INFO  - Indexing hotel {location=[3.3, 4.5], parking=true, rating=8} with id 5
[KnnEfficientFilter] INFO  - Indexing hotel {location=[6.4, 3.4], parking=true, rating=9} with id 6
[KnnEfficientFilter] INFO  - Indexing hotel {location=[4.2, 6.2], parking=true, rating=5} with id 7
[KnnEfficientFilter] INFO  - Indexing hotel {location=[2.4, 4.0], parking=true, rating=8} with id 8
[KnnEfficientFilter] INFO  - Indexing hotel {location=[1.4, 3.2], parking=false, rating=5} with id 9
[KnnEfficientFilter] INFO  - Indexing hotel {location=[7.0, 9.9], parking=true, rating=9} with id 10
[KnnEfficientFilter] INFO  - Indexing hotel {location=[3.0, 2.3], parking=false, rating=6} with id 11
[KnnEfficientFilter] INFO  - Indexing hotel {location=[5.0, 1.0], parking=true, rating=3} with id 12
[KnnEfficientFilter] INFO  - Indexing 12 documents
[KnnEfficientFilter] INFO  - Waiting for indexing to finish
[KnnEfficientFilter] INFO  - Searching for hotel near [5.0, 4.0] with rating >=8,<=10 and parking=true
[KnnEfficientFilter] INFO  - Found {location=[4.9, 3.4], parking=true, rating=9} with score 0.72992706
[KnnEfficientFilter] INFO  - Found {location=[6.4, 3.4], parking=true, rating=9} with score 0.3012048
[KnnEfficientFilter] INFO  - Found {location=[3.3, 4.5], parking=true, rating=8} with score 0.24154587
[KnnEfficientFilter] INFO  - Deleting index hotels-index
```

## Exact k-NN with a scoring script

In the [KnnScriptScore.java sample](../../samples/src/main/java/org/opensearch/client/samples/knn/KnnScriptScore.java) we create a 5-dimensional k-NN index with random data. The search query uses the [k-NN scoring script](https://opensearch.org/docs/latest/search-plugins/knn/knn-score-script/) to calculate exact nearest neighbors.

```java
var searchResponse = client.search(s -> s
        .index(indexName)
        .query(q -> q
                .scriptScore(ss -> ss
                        .query(qq -> qq.matchAll(m -> m))
                        .script(sss -> sss
                                .inline(i -> i
                                        .source("knn_score")
                                        .lang("knn")
                                        .params("field", JsonData.of("values"))
                                        .params("query_value", JsonData.of(searchVector))
                                        .params("space_type", JsonData.of("cosinesimil")))))),
        Doc.class);
```

```bash
$ ./gradlew :samples:run -Dsamples.mainClass=knn.KnnScriptScore 

[Main] INFO  - Running main class: org.opensearch.client.samples.knn.KnnScriptScore
[KnnScriptScore] INFO  - Server: opensearch@2.7.0
[KnnScriptScore] INFO  - Creating index my-index
[KnnScriptScore] INFO  - Indexing 10 vectors
[KnnScriptScore] INFO  - Waiting for indexing to finish
[KnnScriptScore] INFO  - Searching for vector [0.94, 0.1, 0.39, 0.63, 0.42]
[KnnScriptScore] INFO  - Found {values=[0.66, 0.23, 0.15, 0.44, 0.13]} with score 1.9564294
[KnnScriptScore] INFO  - Found {values=[0.94, 0.05, 0.86, 0.68, 0.05]} with score 1.90958
[KnnScriptScore] INFO  - Found {values=[0.88, 0.72, 0.29, 0.48, 0.56]} with score 1.8788767
[KnnScriptScore] INFO  - Found {values=[0.97, 0.99, 0.66, 0.61, 0.91]} with score 1.847905
[KnnScriptScore] INFO  - Found {values=[0.18, 0.29, 0.43, 0.63, 0.25]} with score 1.7819176
[KnnScriptScore] INFO  - Found {values=[0.35, 0.2, 0.62, 0.4, 0.96]} with score 1.7673628
[KnnScriptScore] INFO  - Found {values=[0.34, 0.59, 0.05, 0.47, 0.54]} with score 1.7316635
[KnnScriptScore] INFO  - Found {values=[0.55, 0.98, 0.07, 0.57, 0.06]} with score 1.6385877
[KnnScriptScore] INFO  - Found {values=[0.03, 0.72, 0.89, 0.83, 0.46]} with score 1.6147845
[KnnScriptScore] INFO  - Found {values=[0.17, 0.81, 0.09, 0.21, 0.3]} with score 1.4616101
[KnnScriptScore] INFO  - Deleting index my-index
```

## Exact k-NN with the Painless scripting extensions

In the [KnnPainlessScript.java sample](../../samples/src/main/java/org/opensearch/client/samples/knn/KnnPainlessScript.java) we create a 5-dimensional k-NN index with random data. The search query uses the [k-NN Painless extensions](https://opensearch.org/docs/latest/search-plugins/knn/painless-functions/) to calculate exact nearest neighbors.

```java
var searchResponse = client.search(s -> s
        .index(indexName)
        .query(q -> q
                .scriptScore(ss -> ss
                        .query(qq -> qq.matchAll(m -> m))
                        .script(sss -> sss
                                .inline(i -> i
                                        .source("1.0 + cosineSimilarity(params.query_value, doc[params.field])")
                                        .params("field", JsonData.of("values"))
                                        .params("query_value", JsonData.of(searchVector)))))),
        Doc.class);
```

```bash
$ ./gradlew :samples:run -Dsamples.mainClass=knn.KnnPainlessScript

[Main] INFO  - Running main class: org.opensearch.client.samples.knn.KnnPainlessScript
[KnnPainlessScript] INFO  - Server: opensearch@2.7.0
[KnnPainlessScript] INFO  - Creating index my-index
[KnnPainlessScript] INFO  - Indexing 10 vectors
[KnnPainlessScript] INFO  - Waiting for indexing to finish
[KnnPainlessScript] INFO  - Searching for vector [0.57, 0.86, 0.37, 0.07, 0.38]
[KnnPainlessScript] INFO  - Found {values=[1.0, 0.6, 0.66, 0.03, 0.18]} with score 1.8911908
[KnnPainlessScript] INFO  - Found {values=[0.4, 0.39, 0.63, 0.09, 0.39]} with score 1.8776901
[KnnPainlessScript] INFO  - Found {values=[0.32, 0.98, 0.7, 0.7, 0.77]} with score 1.8616674
[KnnPainlessScript] INFO  - Found {values=[0.93, 0.35, 0.27, 0.45, 0.81]} with score 1.789043
[KnnPainlessScript] INFO  - Found {values=[0.81, 0.36, 0.87, 0.78, 0.56]} with score 1.7457235
[KnnPainlessScript] INFO  - Found {values=[0.55, 0.19, 0.61, 0.42, 0.4]} with score 1.743325
[KnnPainlessScript] INFO  - Found {values=[0.12, 0.54, 0.09, 0.83, 0.28]} with score 1.6045148
[KnnPainlessScript] INFO  - Found {values=[0.0, 0.04, 0.63, 0.07, 0.9]} with score 1.479921
[KnnPainlessScript] INFO  - Found {values=[0.41, 0.05, 0.52, 1.0, 0.18]} with score 1.4306322
[KnnPainlessScript] INFO  - Found {values=[0.22, 0.1, 0.59, 0.89, 0.15]} with score 1.4274814
[KnnPainlessScript] INFO  - Deleting index my-index
```