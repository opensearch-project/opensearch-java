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

val unitTest = tasks.register<Test>("unitTest") {
    filter {
        excludeTestsMatching("org.opensearch.client.opensearch.integTest.*")
    }
    systemProperty("tests.security.manager", "false")
}

val integrationTest = tasks.register<Test>("integrationTest") {
    filter {
        includeTestsMatching("org.opensearch.client.opensearch.integTest.*")
    }
    systemProperty("tests.security.manager", "false")
    systemProperty("https", System.getProperty("https", "false"))
    systemProperty("user", System.getProperty("user", "admin"))
    systemProperty("password", System.getProperty("password", "admin"))
    systemProperty("tests.opensearch.testcontainers.enabled",
        System.getProperty("tests.opensearch.testcontainers.enabled", "true"))
    systemProperty("tests.opensearch.version",
        System.getProperty("tests.opensearch.version", opensearchVersion))
}

// Integration tests require Java 21+ and live in src/test/java11
val runtimeJavaVersion = (System.getProperty("runtime.java")?.toInt())?.let(JavaVersion::toVersion) ?: JavaVersion.current()
if (runtimeJavaVersion >= JavaVersion.VERSION_21) {
    val java21: SourceSet = sourceSets.create("java21") {
        java {
            compileClasspath += sourceSets.main.get().output + sourceSets.test.get().output
            runtimeClasspath += sourceSets.main.get().output + sourceSets.test.get().output
            srcDir("src/test/java11")
        }
    }

    configurations[java21.implementationConfigurationName].extendsFrom(configurations.testImplementation.get())
    configurations[java21.runtimeOnlyConfigurationName].extendsFrom(configurations.testRuntimeOnly.get())

    dependencies {
        "java21Implementation"("org.opensearch.test", "framework", opensearchVersion) {
            exclude(group = "org.hamcrest")
        }
        "java21Implementation"("org.opensearch:opensearch-testcontainers:4.1.0")
        "java21Implementation"("org.testcontainers:testcontainers:2.0.5")
    }

    tasks.named<JavaCompile>("compileJava21Java") {
        targetCompatibility = JavaVersion.VERSION_21.toString()
        sourceCompatibility = JavaVersion.VERSION_21.toString()
    }

    tasks.named<JavaCompile>("compileTestJava") {
        targetCompatibility = JavaVersion.VERSION_21.toString()
        sourceCompatibility = JavaVersion.VERSION_21.toString()
    }

    integrationTest.configure {
        testClassesDirs += java21.output.classesDirs
        classpath = sourceSets["java21"].runtimeClasspath
    }
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
