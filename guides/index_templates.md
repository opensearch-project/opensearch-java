- [Index templates](#index-templates)
    - [Setup](#setup)


# Index templates

Index templates let you initialize new indexes with predefined mappings and settings.
For example, if you continuously index log data, you can define an index template so that all of these indexes have
the same number of shards and replicas.

## Setup

To get started, first create a client, create an index template. In this example, an index template is created,
composed of two component templates:

- `index-settings` which specifies index settings such as shard configuration and slowlog settings
- `index-mappings` which specifies the field mappings

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

final var indexSettingsComponentTemplate = "index-settings";
PutComponentTemplateRequest putComponentTemplateRequest = PutComponentTemplateRequest.of(
    c -> c.name(indexSettingsComponentTemplate)
        .settings(
            s -> s.numberOfShards("2")
                .numberOfReplicas("1")
                .indexing(
                    i -> i.slowlog(
                        sl -> sl.level("info")
                            .reformat(true)
                            .threshold(th -> th.index(ith -> ith.warn(Time.of(t -> t.time("2s")))))
                    )
                )
                .search(
                    se -> se.slowlog(sl -> sl.level("info").threshold(th -> th.query(q -> q.warn(Time.of(t -> t.time("2s"))))))
                )
        )
);
client.cluster().putComponentTemplate(putComponentTemplateRequest);

final var indexMappingsComponentTemplate = "index-mappings";
putComponentTemplateRequest = PutComponentTemplateRequest.of(
    c -> c.name(indexMappingsComponentTemplate).mappings(m -> m.properties("age", p -> p.integer(i -> i)))
);
client.cluster().putComponentTemplate(putComponentTemplateRequest);

final var indexTemplateName = "my-index-template";
PutIndexTemplateRequest putIndexTemplateRequest = PutIndexTemplateRequest.of(
    it -> it.name(indexTemplateName)
        .indexPatterns("my-index-*")
        .composedOf(List.of(indexSettingsComponentTemplate, indexMappingsComponentTemplate))
);

client.indices().putIndexTemplate(putIndexTemplateRequest);
```

## Usage

Create an index with a name that matches the index template's `indexPatterns`

```java
String indexName = "my-index-1";
client.indices().create(CreateIndexRequest.of(c -> c.index(indexName)));
```

The index will be created with the index settings and mappings defined by the `my-index-template` index template.

You can find a working sample of the above code in [IndexTemplates.java](../samples/src/main/java/org/opensearch/client/samples/IndexTemplates.java).