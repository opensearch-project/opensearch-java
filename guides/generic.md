- [Generic Client](#generic-client)
  - [Getting the Client](#get-client)
  - [Sending Simple Requests](#request-bodyless)
  - [Sending JSON Requests](#request-json)
  - [Sending JSON using POJOs](#request-pojo)

# Generic Client

There are rare circumstances when the typed OpenSearch client APIs are too constraining and there is a need to communicate with OpenSearch cluster (or individual nodes) over generic HTTP request / response communication. The `OpenSearchGenericClient` could be used in such cases.

## Getting the Client
The following sample code gets the `OpenSearchGenericClient` rom the `OpenSearchClient` instance.

```java
final OpenSearchGenericClient generic = javaClient().generic();
```

## Sending Simple Request
The following sample code sends a simple request that does not require any payload to be provided.

```java
// compare with what the low level client outputs
try (Response response = javaClient().generic().execute(Requests.builder().endpoint("/").method("GET").build())) {
   // ...
}
```

Please notice that the `Response` instance should be closed explicitly in order to free up any allocated resource (like response input streams or buffers). The generic client never interprets status codes and provides the direct access to the response as it was received from the server. This is responsibility of the caller to decide what should happen in case of unsuccessful invocations.

## Sending JSON Requests
The following sample code a simple request with JSON body.

```java
 try (Response response = javaClient().generic()
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

## Sending JSON using POJOs
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

try (Response response = javaClient().generic()
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