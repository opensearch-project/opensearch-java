- [Compatibility with OpenSearch](#compatibility-with-opensearch)
- [Compatibility with JDK](#compatibility-with-jdk)
- [Upgrading](#upgrading)

## Compatibility with OpenSearch

The below matrix shows the compatibility of the [`opensearch-java-client`](https://search.maven.org/artifact/org.opensearch.client/opensearch-java) with versions of [`OpenSearch`](https://opensearch.org/downloads.html#opensearch).

| Client Version | OpenSearch Version |
|----------------|--------------------|
| 1.0.0          | 1.x                |
| 2.x.0          | 1.x-2.x            |
| 3.x.0          | 1.x-3.x            |

## Compatibility with JDK

The below matrix shows the compatibility of the [`opensearch-java-client`](https://search.maven.org/artifact/org.opensearch.client/opensearch-java) with JDK versions.

| Client Version | JDK                |
|----------------|--------------------|
| 1.0.0          | 8                  |
| 2.x.0          | 8 / 11 / 17 / 21   |
| 3.x.0          | 8 / 11 / 17 / 21   |

## Upgrading

Major versions of OpenSearch introduce breaking changes that require careful upgrades of the client. While `opensearch-java-client` 2.0.0 works against the latest OpenSearch 1.x, certain deprecated features removed in OpenSearch 2.0 have also been removed from the client. Please refer to the [OpenSearch documentation](https://opensearch.org/docs/latest/clients/index/) for more information.