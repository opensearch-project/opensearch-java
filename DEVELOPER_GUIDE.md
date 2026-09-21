- [Developer Guide](#developer-guide)
  - [Getting Started](#getting-started)
    - [Git Clone OpenSearch Repo](#git-clone-opensearch-repo)
    - [Install Prerequisites](#install-prerequisites)
      - [Docker](#docker)
    - [Build](#build)
    - [Run Tests](#run-tests)
      - [Unit Tests](#unit-tests)
      - [Integration Tests](#integration-tests)
      - [AWS Transport Integration Tests](#aws-transport-integration-tests)
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

To run integration tests for the java-client:

```
./gradlew clean integrationTest
```

By default, the integration test task starts a single OpenSearch test container for the test JVM. To test against a specific OpenSearch image version, pass the OpenSearch version:

```
./gradlew clean integrationTest -Dtests.opensearch.version=3.2.0
```

To pass the full official OpenSearch image name, use:

```
./gradlew clean integrationTest -Dtests.opensearch.image=opensearchproject/opensearch:3.2.0
```

To run against an already running cluster, disable the test container and pass the cluster endpoint if it is not `localhost:9200`:

```
./gradlew clean integrationTest -Dtests.opensearch.testcontainers.enabled=false -Dtests.rest.cluster=localhost:9200
```

#### AWS Transport Integration Tests

To run integration tests for the AWS transport client, ensure working AWS credentials in `/.aws/credentials` and specify your OpenSearch domain and region as follows:

```
./gradlew integrationTest --tests "*AwsSdk2*" -Dtests.awsSdk2support.domainHost=search-...us-west-2.es.amazonaws.com -Dtests.awsSdk2support.domainRegion=us-west-2 -Dtests.awsSdk2support.serviceName=es
```

For OpenSearch Serverless, change the signing service name.

```
./gradlew integrationTest --tests "*AwsSdk2*" -Dtests.awsSdk2support.domainHost=....us-west-2.aoss.amazonaws.com -Dtests.awsSdk2support.domainRegion=us-west-2 -Dtests.awsSdk2support.serviceName=aoss
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

Java files in the OpenSearch codebase are formatted with the Eclipse JDT formatter, using the [Spotless Gradle](https://github.com/diffplug/spotless/tree/master/plugin-gradle) plugin. This plugin is configured on a project-by-project basis, via `build.gradle.kts`. So long as at least one project is configured, the formatting check can be run explicitly with:

    ./gradlew spotlessJavaCheck

The code can be formatted with:

    ./gradlew spotlessApply

These tasks can also be run for specific subprojects, e.g.

    ./gradlew :java-client:spotlessJavaCheck
    ./gradlew :samples:spotlessJavaCheck

Please follow these formatting guidelines:

* Java indent is 4 spaces
* Line width is 140 characters
* Lines of code surrounded by `// tag::NAME` and `// end::NAME` comments are included in the documentation and should only be 76 characters wide not counting leading indentation. Such regions of code are not formatted automatically as it is not possible to change the line length rule of the formatter for part of a file. Please format such sections sympathetically with the rest of the code, while keeping lines to maximum length of 76 characters.
* Wildcard imports (`import foo.bar.baz.*`) are forbidden and will cause the build to fail.
* If *absolutely* necessary, you can disable formatting for regions of code with the `// tag::NAME` and `// end::NAME` directives, but note that these are intended for use in documentation, so please make it clear what you have done, and only do this where the benefit clearly outweighs the decrease in consistency.
* Note that JavaDoc and block comments i.e. `/* ... */` are not formatted, but line comments i.e `// ...` are.
* There is an implicit rule that negative boolean expressions should use the form `foo == false` instead of `!foo` for better readability of the code. While this isn't strictly enforced, if might get called out in PR reviews as something to change.

## Generated Code

A large part of the `java-client` API is **generated** from the [OpenSearch OpenAPI specification](https://github.com/opensearch-project/opensearch-api-specification) by the `java-codegen` module. The generated sources live under [`java-client/src/generated/java/`](java-client/src/generated/java/) and are **committed to the repository**, so you only need to regenerate them when the API surface changes (e.g. after pulling a newer spec, adding an operation, or editing a code-generation template).

The published API reference for the client (including the generated types) is available as [JavaDoc](https://www.javadoc.io/doc/org.opensearch.client/opensearch-java/latest/index.html).

### Where the spec comes from

`java-codegen/opensearch-openapi.yaml` is a committed copy of the published spec. The upstream source of truth is the [opensearch-api-specification](https://github.com/opensearch-project/opensearch-api-specification) repository, which publishes a bundled document to:

```
https://api-spec.opensearch.org/opensearch-openapi.yaml
```

To pull the latest published spec into the repo, run:

```
./gradlew :java-codegen:downloadLatestSpec
```

This overwrites `java-codegen/opensearch-openapi.yaml` with the file from that URL. Commit the updated spec together with the regenerated code so the two stay in sync.

### Regenerating the code

Always regenerate through the Gradle `run` task — **do not run `CodeGenerator` by hand**:

```
./gradlew :java-codegen:run
```

This runs `org.opensearch.client.codegen.CodeGenerator` with the arguments wired up in [`java-codegen/build.gradle.kts`](java-codegen/build.gradle.kts):

* `--input` &rarr; the local `java-codegen/opensearch-openapi.yaml`
* `--output` &rarr; `java-client/src/generated/java/` (this directory is wiped and rewritten on each run)
* `--eclipse-config` &rarr; `buildSrc/formatterConfig-generated.xml`

After regenerating, review the diff, then build and test:

```
./gradlew clean build
```

> **Note on the "huge diff" problem:** the generator formats its output with a **dedicated** Eclipse config, [`buildSrc/formatterConfig-generated.xml`](buildSrc/formatterConfig-generated.xml), which is **not** the same as the Spotless config used for hand-written code ([`buildSrc/formatterConfig.xml`](buildSrc/formatterConfig.xml)). The `CodeGenerator` applies the generated config internally as the final step, so running the generator via `./gradlew :java-codegen:run` reproduces exactly what is committed. Invoking `CodeGenerator` directly with the wrong config — or trying to "fix up" the output afterwards with `./gradlew spotlessApply` — reformats JavaDoc and other constructs differently and produces a large, spurious diff. Do not run `spotlessApply` over `java-client/src/generated/java/`.

### Customizing what gets generated

If the raw spec does not produce the desired Java, the generator can be tuned in a few places under `java-codegen/src/main/`:

* **Operation include/exclude list** — the `OPERATION_MATCHER` in [`CodeGenerator.java`](java-codegen/src/main/java/org/opensearch/client/codegen/CodeGenerator.java) excludes operations/namespaces that are not yet supported (e.g. NDJSON APIs) or need review. Enable an operation by removing it from that list.
* **Overrides** — per-schema/operation/property tweaks live in `transformer/overrides/` (see `Overrides.java`).
* **Templates** — the emitted Java is rendered from Mustache templates in `src/main/resources/org/opensearch/client/codegen/templates/`.

## Submitting Changes

See [CONTRIBUTING](CONTRIBUTING.md).
