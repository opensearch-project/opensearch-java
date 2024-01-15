/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

plugins {
    java
    application
    id("com.diffplug.spotless") version "6.24.0"
}

java {
    targetCompatibility = JavaVersion.VERSION_11
    sourceCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(project(":java-client"))
    implementation("org.apache.logging.log4j", "log4j-api","[2.17.1,3.0)")
    implementation("org.apache.logging.log4j", "log4j-core","[2.17.1,3.0)")
    implementation("org.apache.logging.log4j", "log4j-slf4j2-impl","[2.17.1,3.0)")
    implementation("commons-logging", "commons-logging", "1.2")
    implementation("com.fasterxml.jackson.core", "jackson-databind", "2.15.2")
    implementation("org.apache.httpcomponents.client5", "httpclient5", "5.2.1")
    implementation("org.apache.httpcomponents.core5", "httpcore5", "5.2.2")
}

spotless {
  java {

    target("**/*.java")

    // Use the default importOrder configuration
    importOrder()
    removeUnusedImports()

    eclipse().configFile("../buildSrc/formatterConfig.xml")

    trimTrailingWhitespace()
    endWithNewline()
  }
}

application {
    mainClass.set("org.opensearch.client.samples.Main")
}

tasks.named<JavaExec>("run") {
    systemProperty("samples.mainClass", System.getProperty("samples.mainClass"))
}
