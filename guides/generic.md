- [Generic Client](#generic-client)
  - [Getting the Client](#get-client)
  - [Sending Simple Requests](#request-bodyless)
  - [Sending JSON Requests](#request-json)
  - [Sending JSON Requests using POJOs](#request-pojo)
  - [Sending Requests using structured JSON](#request-structured)

# Generic Client

There are rare circumstances when the typed OpenSearch client APIs are too constraining and there is a need to communicate with OpenSearch cluster (or individual nodes) over generic HTTP request / response communication. Use `OpenSearchGenericClient` in such cases.

## Getting the Client
The following sample code gets the `OpenSearchGenericClient` from the `OpenSearchClient` instance.

```java
final OpenSearchGenericClient generic = javaClient().generic(ClientOptions.DEFAULT);
```

The generic client with default options (`ClientOptions.DEFAULT`) returns the responses as those were received from the server. The generic client could be instructed to raise an `OpenSearchClientException` exception instead if the HTTP status code is not indicating the successful response, for example:

```java
final OpenSearchGenericClient generic = javaClient().generic(ClientOptions.throwOnHttpErrors());
```

## Sending Simple Request
The following sample code sends a simple request that does not require any payload to be provided (typically, `GET` requests).

```java
// compare with what the low level client outputs
try (Response response = javaClient().generic(ClientOptions.DEFAULT).execute(Requests.builder().endpoint("/").method("GET").build())) {
   // ...
}
```

Please notice that the `Response` instance should be closed explicitly in order to free up any allocated resource (like response input streams or buffers), the [`try-with-resource`](https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html) pattern is encouraged.

```java
try (Response response = javaClient().generic(ClientOptions.DEFAULT).execute(...)) {
   // ...
}
```

The generic client never interprets status codes and provides the direct access to the response as it was received from the server. This is responsibility of the caller to decide what should happen in case of unsuccessful invocations.

```java
// compare with what the low level client outputs
try (Response response = javaClient().generic(ClientOptions.DEFAULT).execute(...)) {
   if (response.getStatus() != 200) {
      // Request was not successful
   }
}
```

## Sending JSON Requests
The following sample code a simple request with JSON body.

```java
 try (Response response = javaClient().generic(ClientOptions.DEFAULT)
        .execute(
            Requests.builder()
                .endpoint("/" + index + "/_search")
                .method("POST")
                .json("{"
                    + "    \"query\": {"
                    + "        \"match_all\": {}"
                    + "    }"
                    + "}"
                )
                .build())) {
   // Retrieve the response body as a simple string
   final String body = response.getBody().map(Body::getAsString).orElse("");
   // ...
}
```

## Sending JSON Requests using POJOs
Besides providing the ability to deal with raw request and response payloads (bodies), the `OpenSearchGenericClient` could be used mixed with existing OpenSearch typed requests and responses (POJOs), like the following sample code demonstrates.


```java
final JsonpMapper jsonpMapper = javaClient()._transport().jsonpMapper();

final CreateIndexRequest request = CreateIndexRequest.of(
  b -> b.index(index)
    .mappings(
        m -> m.properties("name", Property.of(p -> p.keyword(v -> v.docValues(true))))
            .properties("size", Property.of(p -> p.keyword(v -> v.docValues(true))))
    )
    .settings(settings -> settings.sort(s -> s.field("name").order(SegmentSortOrder.Asc)))
);

try (Response response = javaClient().generic(ClientOptions.DEFAULT)
      .execute(
          Requests.builder()
            .endpoint("/" + index).method("PUT")
            .json(request, jsonpMapper).build())) {
  // Retrieve the response body as a POJO
  final CreateIndexResponse r = response.getBody()
      .map(b -> Bodies.json(b, CreateIndexResponse._DESERIALIZER, jsonpMapper))
      .orElse(null);
  // ...
}
```

## Sending Requests using structured JSON
Dealing with strings or POJOs could be daunting sometimes, using structured JSON APIs is a middle ground of both approaches, as per following sample code that uses (`jakarta.json.Json`)[https://jakarta.ee/specifications/jsonp].

```java
try (Response response = javaClient().generic(ClientOptions.DEFAULT)
      .execute(
        Requests.builder()
          .endpoint("/" + index)
          .method("PUT")
          .json(Json.createObjectBuilder()
              .add("settings", Json.createObjectBuilder()
                .add("index", Json.createObjectBuilder()
                  .add("sort.field", "name"))
                  .add("sort.order", "asc")
              )
              .add("mappings",Json.createObjectBuilder()
                .add("properties", Json.createObjectBuilder()
                  .add("name", Json.createObjectBuilder()
                    .add("type", "keyword"))
                    .add("doc_values", true)
                  .add("size", Json.createObjectBuilder()
                    .add("type", "keyword"))
                    .add("doc_values", true))
              )
          )
          .build())) {
  // ...
}
```