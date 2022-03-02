- [Developer Guide](#developer-guide)
  - [Getting Started](#getting-started)
    - [Git Clone OpenSearch Repo](#git-clone-opensearch-repo)
    - [Install Prerequisites](#install-prerequisites)
      - [Docker](#docker)
    - [Build](#build)
    - [Run Tests](#run-tests)
      - [Unit Tests](#unit-tests)
      - [Integration Tests](#integration-tests)
    - [Using the Java Client](#using-the-java-client)
  - [Use an Editor](#use-an-editor)
    - [IntelliJ IDEA](#intellij-idea)
    - [Visual Studio Code](#visual-studio-code)
  - [Java Language Formatting Guidelines](#java-language-formatting-guidelines)
  - [Submitting Changes](#submitting-changes)

# Developer Guide

So you want to contribute code to the OpenSearch Java client? Excellent! We're glad you're here. Here's what you need to do.

## Getting Started

### Git Clone OpenSearch Repo

Fork [opensearch-project/opensearch-java](https://github.com/opensearch-project/opensearch-java) and clone locally, e.g. `git clone https://github.com/[your username]/opensearch-java.git`.

### Install Prerequisites

To run the full suite of tests, download and install [JDK 14](https://jdk.java.net/archive/). Any JDK >= 11 works.

#### Docker

Download and install [Docker](https://docs.docker.com/install/), required for running integration tests for the repo.

### Build

To build the java-client, start an OpenSearch cluster using docker:

```
docker build -t opensearch-search:test -f .ci/opensearch/Dockerfile --build-arg "SECURE_INTEGRATION=true" .
docker run -p 9200:9200 -p 9600:9600 -d -e "discovery.type=single-node" opensearch-search:test
```

To build the java-client:

```
./gradlew clean build -x test
```

### Run Tests

#### Unit Tests

To run unit tests for the java-client:

```
./gradlew clean unitTest
```

#### Integration Tests

To run integration tests for the java-client, start an OpenSearch cluster using docker:

```
docker build -t opensearch-search:test -f .ci/opensearch/Dockerfile --build-arg "SECURE_INTEGRATION=true" .
docker run -p 9200:9200 -p 9600:9600 -d -e "discovery.type=single-node" opensearch-search:test
```

Run integration tests after starting OpenSearch cluster:

```
./gradlew clean integrationTest
```

### Using the Java Client

An example for using the java client in an application:

```java
try (RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200)).build()) {
        String index = "test-index";

        // Create Client
        OpenSearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
        OpenSearchClient client = new OpenSearchClient(transport);

        // Create Index
        CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index(index).build();
        CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest);
        assert createIndexResponse.shardsAcknowledged();

        // Index Document
        AppData appData = new AppData(1337, "foo");

        IndexRequest<AppData> indexRequest = new IndexRequest.Builder<AppData>().index("index").id("1").document(appData).build();
        IndexResponse indexResponse = client.index(indexRequest);
        assertEquals(Result.Created, indexResponse.result());

        // Search Documents
        SearchResponse<AppData> search = client.search(b -> b.index(index), AppData.class);
        assertEquals(1, search.hits().total().value());

        // Delete Index
        DeleteIndexRequest deleteRequest = new DeleteIndexRequest.Builder().index(index).build();
        DeleteIndexResponse deleteResponse = client.indices().delete(deleteRequest);
        assert deleteResponse.shardsAcknowledged();
        }
```

## Use an Editor

### IntelliJ IDEA

When importing into IntelliJ you will need to define an appropriate JDK. The convention is that **this SDK should be named "11"**, and the project import will detect it automatically. For more details on defining an SDK in IntelliJ please refer to [this documentation](https://www.jetbrains.com/help/idea/sdk.html#define-sdk). Note that SDK definitions are global, so you can add the JDK from any project, or after project import. Importing with a missing JDK will still work, IntelliJ will report a problem and will refuse to build until resolved.

You can import the opensearch-java project into IntelliJ IDEA as follows:

1. Select **File > Open**
2. In the subsequent dialog navigate to the root `build.gradle.kts` file
3. In the subsequent dialog select **Open as Project**

### Visual Studio Code

Follow links in the [Java Tutorial](https://code.visualstudio.com/docs/java/java-tutorial) to install the coding pack and extensions for Java, Gradle tasks, etc. Open the source code directory.

## Java Language Formatting Guidelines

Java files in the opensearch-java codebase are formatted with the [checkstyle plugin](https://docs.gradle.org/current/userguide/checkstyle_plugin.html). This plugin is configured using [checkstyle.xml](config/checkstyle/checkstyle.xml). To run the formatting checks:

```
./gradlew checkstyleMain checkstyleTest
```

## Submitting Changes

See [CONTRIBUTING](CONTRIBUTING.md).
