- [Working With JSON](#working-with-json)
  - [Serialization](#serialization)
    - [Using toJsonString](#using-tojsonstring)
    - [Manual Serialization](#manual-serialization)
 

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