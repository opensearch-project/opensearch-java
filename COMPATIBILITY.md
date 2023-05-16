- [Compatibility with OpenSearch](#compatibility-with-opensearch)
- [Upgrading](#upgrading)

## Compatibility with OpenSearch

The below matrix shows the compatibility of the [`opensearch-java-client`](https://search.maven.org/artifact/org.opensearch.client/opensearch-java) with versions of [`OpenSearch`](https://opensearch.org/downloads.html#opensearch).

| Client Version | OpenSearch Version |
|----------------|--------------------|
| 1.0.0          | 1.0.0-1.3.9        |
| 2.0.0          | 1.3.9-2.0.1        |
| 2.1.0          | 1.3.9-2.3.0        |
| 2.2.0          | 1.3.9-2.5.0        |
| 2.3.0          | 1.3.9-2.7.0        |
| 2.4.0          | 1.3.9-2.7.0        |

## Upgrading

Major versions of OpenSearch introduce breaking changes that require careful upgrades of the client. While `opensearch-java-client` 2.0.0 works against the latest OpenSearch 1.x, certain deprecated features removed in OpenSearch 2.0 have also been removed from the client. Please refer to the [OpenSearch documentation](https://opensearch.org/docs/latest/clients/index/) for more information.