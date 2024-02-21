- [Search](#search)
  - [Setup](#setup)
  - [Search API](#search-api)
    - [Basic Search](#basic-search)
      - [Get raw JSON results](#get-raw-json-results)
    - [Search documents using a match query](#search-documents-using-a-match-query)
    - [Search documents using suggesters](#search-documents-using-suggesters)
      - [Using completion suggester](#using-completion-suggester)
      - [Using term suggester](#using-term-suggester)
      - [Using phrase suggester](#using-phrase-suggester)
    - [Aggregations](#aggregations)

# Search

OpenSearch provides a powerful search API that allows you to search for documents in an index. The search API supports a number of parameters that allow you to customize the search operation. In this guide, we will explore the search API and its parameters.

## Setup

To get started, first create a client, create an index and index some documents:

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

String index = "sample-index";
CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index(index).build();
client.indices().create(createIndexRequest);

IndexData indexData = new IndexData("Document 1", "Text for document 1");
IndexRequest<IndexData> indexRequest = new IndexRequest.Builder<IndexData>().index(index).id("1").document(indexData).build();
client.index(indexRequest);

indexData = new IndexData("Document 2", "Text for document 2");
indexRequest = new IndexRequest.Builder<IndexData>().index(index).id("2").document(indexData).build();
client.index(indexRequest);
```

[IndexData](../samples/src/main/java/org/opensearch/client/samples/util/IndexData.java) refers to sample data class.

## Search API

### Basic Search

```java
SearchResponse<IndexData> searchResponse = client.search(s -> s.index(index), IndexData.class);
for (int i = 0; i < searchResponse.hits().hits().size(); i++) {
  System.out.println(searchResponse.hits().hits().get(i).source());
}
```

#### Get raw JSON results

When the target class is not defined or if the response result is a semi-structured data not tied to an object definition, use a raw JSON data representation as the target class. For example, the below snippet uses `ObjectNode` from jackson.

```java
SearchResponse<ObjectNode> searchResponse = client.search(b -> b.index(index), ObjectNode.class);
for (int i = 0; i < searchResponse.hits().hits().size(); i++) {
  System.out.println(searchResponse.hits().hits().get(i).source());
}
```

### Search documents using a match query

```java
SearchRequest searchRequest = new SearchRequest.Builder().query(q -> q.match(m -> m.field("text")
                                                                                   .query(FieldValue.of("Text for document 2"))))
                                                         .build();

SearchResponse<IndexData> searchResponse = client.search(searchRequest, IndexData.class);
for (int i = 0; i < searchResponse.hits().hits().size(); i++) {
  System.out.println(searchResponse.hits().hits().get(i).source());
}
```

### Search documents using a hybrid query
```java
Query searchQuery = Query.of(
        h -> h.hybrid(
                q -> q.queries(Arrays.asList(
                                       new MatchQuery.Builder().field("text").query(FieldValue.of("Text for document 2")).build().toQuery(),
                                       new TermQuery.Builder().field("passage_text").value(FieldValue.of("Foo bar")).build().toQuery(),
                                       new NeuralQuery.Builder().field("passage_embedding").queryText("Hi world").modelId("bQ1J8ooBpBj3wT4HVUsb").k(100).build().toQuery()
                               )
                              )
                )
        );
SearchRequest searchRequest = new SearchRequest.Builder().query(searchQuery).build();
SearchResponse<IndexData> searchResponse = client.search(searchRequest, IndexData.class);
for (var hit : searchResponse.hits().hits()) {
        LOGGER.info("Found {} with score {}", hit.source(), hit.score());
}
```

### Search documents using suggesters

[AppData](../samples/src/main/java/org/opensearch/client/samples/util/AppData.java) refers to the sample data class used in the below samples.

#### Using completion suggester

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

#### Using term suggester

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

#### Using phrase suggester

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

### Aggregations

```java
SearchRequest searchRequest = new SearchRequest.Builder().query(q -> q.match(m -> m.field("title")
                                                                                   .query(FieldValue.of("Document 1"))))
                                                         .aggregations("titles", new Aggregation.Builder().terms(t -> t.field("title.keyword"))
                                                                                                              .build())
                                                         .build();

SearchResponse<IndexData> searchResponse = client.search(searchRequest, IndexData.class);
for (Map.Entry<String, Aggregate> entry : searchResponse.aggregations().entrySet()) {
  System.out.println("Agg - " + entry.getKey());
  entry.getValue().sterms().buckets().array().forEach(b -> System.out.printf("%s : %d%n", b.key(), b.docCount()));
}
```

You can find a working sample of the above code in [Search.java](../samples/src/main/java/org/opensearch/client/samples/Search.java).