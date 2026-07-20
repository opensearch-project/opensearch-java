/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

plugins {
    java
    `java-library`
    `maven-publish`
    id("opensearch-java.spotless-conventions")
}

repositories {
    mavenLocal()
    maven(url = "https://ci.opensearch.org/ci/dbc/snapshots/maven/")
    mavenCentral()
}

java {
    targetCompatibility = JavaVersion.VERSION_1_8
    sourceCompatibility = JavaVersion.VERSION_1_8

    withJavadocJar()
    withSourcesJar()
}

val opensearchVersion = "3.5.0-SNAPSHOT"
val grpcVersion = "1.68.0"
val protobufVersion = "3.25.5"
val opensearchProtobufVersion = "1.2.0"

dependencies {
    // Depend on java-client core
    api(project(":java-client"))

    // gRPC runtime
    api("io.grpc", "grpc-api", grpcVersion)
    api("io.grpc", "grpc-stub", grpcVersion)
    api("io.grpc", "grpc-protobuf", grpcVersion)
    api("io.grpc", "grpc-netty-shaded", grpcVersion)
    api("com.google.protobuf", "protobuf-java", protobufVersion)

    // OpenSearch Protobufs (compiled protobuf Java classes)
    api("org.opensearch", "protobufs", opensearchProtobufVersion)

    // For AwsSdk2 SigV4 support (optional, compile-only)
    compileOnly("software.amazon.awssdk", "sdk-core", "[2.21,3.0)")
    compileOnly("software.amazon.awssdk", "auth", "[2.21,3.0)")
    compileOnly("software.amazon.awssdk", "http-auth-aws", "[2.21,3.0)")

    // Test dependencies
    testImplementation("io.grpc", "grpc-testing", grpcVersion)
    testImplementation("junit", "junit", "4.13.2")
    testImplementation("org.opensearch.client", "opensearch-rest-client", opensearchVersion)
    testImplementation("software.amazon.awssdk", "sdk-core", "[2.21,3.0)")
    testImplementation("software.amazon.awssdk", "auth", "[2.21,3.0)")
    testImplementation("software.amazon.awssdk", "http-auth-aws", "[2.21,3.0)")
}

tasks.test {
    systemProperty("tests.security.manager", "false")
}

tasks.withType<Jar> {
    manifest {
        attributes["Implementation-Title"] = "OpenSearch Java Client - gRPC Transport"
        attributes["Implementation-Vendor"] = "OpenSearch"
        attributes["Implementation-URL"] = "https://github.com/opensearch-project/opensearch-java/"
    }

    metaInf {
        from("../LICENSE.txt")
        from("../NOTICE.txt")
    }
}

publishing {
    publications {
        create<MavenPublication>("publishMaven") {
            from(components["java"])
            pom {
                name.set("OpenSearch Java Client - gRPC Transport")
                packaging = "jar"
                artifactId = "opensearch-java-grpc"
                description.set("gRPC transport for the OpenSearch Java Client.")
                url.set("https://github.com/opensearch-project/opensearch-java/")
            }
        }
    }
}
