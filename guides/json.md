- [Working With JSON](#working-with-json)
  - [Serialization](#serialization)
    - [Using toJsonString](#using-tojsonstring)
    - [Manual Serialization](#manual-serialization)
  - [Deserialization](#deserialization)
    - [Using withJson](#using-withjson)
    - [Using static _DESERIALIZER](#using-static-_deserializer)
 

# Working With JSON

OpenSearch Java client seamlessly integrates with JSON, providing serialization and deserialization capability.

## Serialization

For demonstration let's consider an instance of `SearchRequest`.

```java

SearchRequest searchRequest = SearchRequest.of(
        request -> request.index("index1", "index2")
                .aggregations(Collections.emptyMap())
                .terminateAfter(5L)
                .query(q -> q.match(t -> t.field("name").query(FieldValue.of("OpenSearch"))))
);
```
### Using toJsonString
For classes implementing `PlainJsonSerializable`, which extends `JsonpSerializable`, a default `toJsonString` method is provided.
This implementation uses `jakarta.json.spi.JsonProvider` SPI to discover the available JSON provider instance 
from the classpath and to create a new mapper. The `JsonpUtils` utility class streamlines this serialization process.
The following code example demonstrates how to use the `toJsonString` method to serialize objects:

```java
String requestString = searchRequest.toJsonString();
```


### Manual Serialization
For classes implementing the `JsonpSerializable` interface, a serialize method is provided, which takes a mapper and a generator 
as arguments and returns the JSON string representation of the instance.

The following sample code demonstrates how to serialize an instance of a Java class:

```java
private String toJson(JsonpSerializable object) {
  try (StringWriter writer = new StringWriter()) {
    JsonbJsonpMapper mapper = new JsonbJsonpMapper();
    try (JsonGenerator generator = mapper.jsonProvider().createGenerator(writer)) {
      serialize(generator, mapper);
    }
    return writer.toString();
  } catch (IOException ex) {
    throw new UncheckedIOException(ex);
  }
}
```

### Disabling Typed Keys Serialization
By default, the JSON serialization of the OpenSearch Java client uses typed keys for certain types, notably Aggregations.
This is done for the benefit of unambiguous deserialization, but may result in JSON output that is incompatible with use-cases expecting OpenSearch's default untyped keys.
You may disable this behavior by setting the `JsonpMapperAttributes.SERIALIZE_TYPED_KEYS` attribute to `false` on a JsonpMapper instance.
For example, the following code demonstrates how to serialize a SearchResponse without typed keys:
```java
private String withoutTypedKeys(OpenSearchClient client, SearchResponse response) {
    JsonpMapper mapper = client._transport().jsonpMapper().withAttribute(JsonpMapperAttributes.SERIALIZE_TYPED_KEYS, false);
    StringWriter writer = new StringWriter();
    try (JsonGenerator generator = mapper.jsonProvider().createGenerator(writer)) {
        response.serialize(generator, mapper);
    }
    return writer.toString();
}
```

## Deserialization

For demonstration let's consider an IndexTemplateMapping JSON String.

```java

String stringTemplate =
        "{\"mappings\":{\"properties\":{\"age\":{\"type\":\"integer\"}}},\"settings\":{\"number_of_shards\":\"2\",\"number_of_replicas\":\"1\"}}";
```
### Using withJson
For classes, Builders of which implements `PlainDeserializable` interface, a default `withJson` method is provided.
The withJson method returns the Builder enabling you to chain Builder methods for additional configuration.
This implementation uses `jakarta.json.spi.JsonProvider` SPI to discover the available JSON provider instance
from the classpath and to create a new mapper. The `JsonpUtils` utility class streamlines this deserialization process.
The following code example demonstrates how to use the `withJson` method to deserialize objects:

```java
InputStream inputStream = new ByteArrayInputStream(stringTemplate.getBytes(StandardCharsets.UTF_8));
IndexTemplateMapping indexTemplateMapping = new IndexTemplateMapping.Builder().withJson(inputStream).build();
```


### Using static _DESERIALIZER
For classes annotated with `@JsonpDeserializable`, a static field _DESERIALIZER is provided,
which takes a mapper and a parser as arguments and returns the instance of the json value passed in the parser.
Notice that this way you cannot further customize the instance, the state of which will solely depend on the json value parsed.

The following sample code demonstrates how to serialize an instance of a Java class:

```java
private IndexTemplateMapping getInstance(String templateJsonString) {
  InputStream inputStream = new ByteArrayInputStream(templateJsonString.getBytes(StandardCharsets.UTF_8));
  JsonbJsonpMapper mapper = new JsonbJsonpMapper();
  try (JsonParser parser = mapper.jsonProvider().createParser(inputStream)) {
    IndexTemplateMapping indexTemplateMapping = new IndexTemplateMapping._DESERIALIZER.deserialize(parser, mapper);
    return indexTemplateMapping;
  }
}
```