![OpenSearch logo](OpenSearch.svg)

OpenSearch Java Client

- [Welcome!](#welcome)
- [Project Resources](#project-resources)
- [Code of Conduct](#code-of-conduct)
- [License](#license)
- [Copyright](#copyright)

## Welcome!

**opensearch-java** is [a community-driven, open source fork](https://aws.amazon.com/blogs/opensource/introducing-opensearch/) of elasticsearch-java licensed under the [Apache v2.0 License](LICENSE.txt). For more information, see [opensearch.org](https://opensearch.org/).

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
2. Checkout and build [OpenSearch](https://github.com/opensearch-project/OpenSearch) project. Example:
```shell
git clone https://github.com/opensearch-project/OpenSearch.git
cd OpenSearch
git checkout 1.0.0
./gradlew publishToMavenLocal
```
3. Once the above command successfully publishes the artifacts to your local repo, the next step is to checkout and build the [opensearch-java](https://github.com/opensearch-project/opensearch-java) project.
```shell
git clone https://github.com/opensearch-project/opensearch-java.git
cd opensearch-java
./gradlew build
```
4. Launch Intellij IDEA, choose Import Project, and select the `settings.gradle.kts` file in the root of this project.

## Code of Conduct

This project has adopted the [Amazon Open Source Code of Conduct](CODE_OF_CONDUCT.md). For more information see the [Code of Conduct FAQ](https://aws.github.io/code-of-conduct-faq), or contact [opensource-codeofconduct@amazon.com](mailto:opensource-codeofconduct@amazon.com) with any additional questions or comments.

## License

This project is licensed under the [Apache v2.0 License](LICENSE.txt).

## Copyright

Copyright 2020-2021 Amazon.com, Inc. or its affiliates. All Rights Reserved.
