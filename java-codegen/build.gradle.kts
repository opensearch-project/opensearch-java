plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "org.opensearch.client"
version = "2.1.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val smithyVersion = "1.26.1"
    val junitVersion = "5.8.2"

    implementation("org.jetbrains:annotations:24.0.0")

    implementation("software.amazon.smithy:smithy-codegen-core:$smithyVersion")
    implementation("software.amazon.smithy:smithy-waiters:$smithyVersion")
    implementation("software.amazon.smithy:smithy-rules-engine:$smithyVersion")
    implementation("software.amazon.smithy:smithy-aws-traits:$smithyVersion")
    implementation("software.amazon.smithy:smithy-protocol-test-traits:$smithyVersion")

    // Test dependencies
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}