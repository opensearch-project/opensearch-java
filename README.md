[![Code style and license headers](https://github.com/opensearch-project/opensearch-java/actions/workflows/checkstyle.yml/badge.svg?branch=main)](https://github.com/opensearch-project/opensearch-java/actions/workflows/checkstyle.yml)
[![Build](https://github.com/opensearch-project/opensearch-java/actions/workflows/build.yml/badge.svg?branch=main)](https://github.com/opensearch-project/opensearch-java/actions/workflows/build.yml)
[![Chat](https://img.shields.io/badge/chat-on%20forums-blue)](https://discuss.opendistrocommunity.dev/c/clients/)
![PRs welcome!](https://img.shields.io/badge/PRs-welcome!-success)

![OpenSearch logo](OpenSearch.svg)

OpenSearch Java Client

- [Welcome!](#welcome)
- [Project Resources](#project-resources)
- [Code of Conduct](#code-of-conduct)
- [License](#license)
- [Copyright](#copyright)

## Welcome!

**opensearch-java** is [a community-driven, open source fork](https://aws.amazon.com/blogs/opensource/introducing-opensearch/) of elasticsearch-java licensed under the [Apache v2.0 License](LICENSE.txt). 
For more information, see [opensearch.org](https://opensearch.org/).
This client is meant to replace the existing [OpenSearch Java High Level REST Client](https://opensearch.org/docs/latest/clients/java-rest-high-level/).


**Note: This project is in beta stage and is for testing and feedback purposes only.**
## Project Resources

* [Project Website](https://opensearch.org/)
* [Downloads](https://opensearch.org/downloads.html).
* [Documentation](https://opensearch.org/docs/)
* Need help? Try [Forums](https://discuss.opendistrocommunity.dev/)
* [Project Principles](https://opensearch.org/#principles)
* [Contributing to OpenSearch](CONTRIBUTING.md)
* [Maintainer Responsibilities](MAINTAINERS.md)
* [Release Management](RELEASING.md)
* [Admin Responsibilities](ADMINS.md)
* [Security](SECURITY.md)

## Setup

1. Set `JAVA_HOME` to point to a JDK >= 11
2. Checkout and build the [opensearch-java](https://github.com/opensearch-project/opensearch-java) project.
```shell
git clone https://github.com/opensearch-project/opensearch-java.git
cd opensearch-java
./gradlew build
```
3. Launch Intellij IDEA, choose Import Project, and select the `settings.gradle.kts` file in the root of this project.

## Example

```java
try (RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200)).build()) {
    String index = "test-index";

    // Create Client
    Transport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
    OpenSearchClient client = new OpenSearchClient(transport);

    // Create Index
    CreateRequest createIndexRequest = new CreateRequest.Builder().index(index).build();
    CreateResponse createIndexResponse = client.indices().create(createIndexRequest);
    assert createIndexResponse.acknowledged();

    // Index Document
    IndexData indexData = new IndexData("foo", "bar");
    IndexRequest<IndexData> indexRequest = new IndexRequest.Builder<IndexData>().index(index).id("1").value(indexData).build();
    IndexResponse indexResponse = client.index(indexRequest);
    assert Objects.equals(indexResponse.id(), "1");

    // Search Documents
    SearchResponse<IndexData> searchResponse = client.search(s -> s.index(index), IndexData.class);
    assert !searchResponse.hits().hits().isEmpty();
    searchResponse.hits().hits().stream().map(Hit::source).forEach(System.out::println);

    // Delete Index
    DeleteRequest deleteRequest = new DeleteRequest.Builder().index(index).build();
    DeleteResponse deleteResponse = client.indices().delete(deleteRequest);
    assert deleteResponse.acknowledged();
}
```

## Code of Conduct

This project has adopted the [Amazon Open Source Code of Conduct](CODE_OF_CONDUCT.md). For more information see the [Code of Conduct FAQ](https://aws.github.io/code-of-conduct-faq), or contact [opensource-codeofconduct@amazon.com](mailto:opensource-codeofconduct@amazon.com) with any additional questions or comments.

## License

This project is licensed under the [Apache v2.0 License](LICENSE.txt).

## Copyright

Copyright 2020-2021 Amazon.com, Inc. or its affiliates. All Rights Reserved.
