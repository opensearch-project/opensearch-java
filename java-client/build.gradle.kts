/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

import com.github.jk1.license.ProjectData
import com.github.jk1.license.render.ReportRenderer
import java.io.FileWriter

buildscript {
    repositories {
        mavenLocal()
        maven(url = "https://aws.oss.sonatype.org/content/repositories/snapshots")
        mavenCentral()
        maven(url = "https://plugins.gradle.org/m2/")
    }
    dependencies {
        "classpath"(group = "org.opensearch.gradle", name = "build-tools", version = "3.0.0-SNAPSHOT")
    }
}

plugins {
    java
    `java-library`
    checkstyle
    `maven-publish`
    id("com.github.jk1.dependency-license-report") version "1.19"
}
apply(plugin = "opensearch.repositories")

checkstyle {
    toolVersion = "10.0"
}

java {
    targetCompatibility = JavaVersion.VERSION_11
    sourceCompatibility = JavaVersion.VERSION_11

    withJavadocJar()
    withSourcesJar()

    registerFeature("awsSdk2Support") {
        usingSourceSet(sourceSets.get("main"))
    }
}

tasks.withType<ProcessResources> {
    expand(
        "version" to version,
        "git_revision" to (if (rootProject.extra.has("gitHashFull")) rootProject.extra["gitHashFull"] else "unknown")
    )
}

tasks.withType<Javadoc>().configureEach{
    options {
        encoding = "UTF-8"
    }
}

tasks.withType<Jar> {
    doFirst {
        if (rootProject.extra.has("gitHashFull")) {
            val jar = this as Jar
            jar.manifest.attributes["X-Git-Revision"] = rootProject.extra["gitHashFull"]
            jar.manifest.attributes["X-Git-Commit-Time"] = rootProject .extra["gitCommitTime"]
        } else {
            throw GradleException("No git information available")
        }
    }

    manifest {
        attributes["Implementation-Title"] = "OpenSearch Java client"
        attributes["Implementation-Vendor"] = "OpenSearch"
        attributes["Implementation-URL"] = "https://github.com/opensearch-project/opensearch-java/"
        attributes["Build-Date"] = rootProject.extra["buildTime"]
    }

    metaInf {
        from("../LICENSE.txt")
        from("../NOTICE.txt")
    }
}

tasks.test {
    systemProperty("tests.security.manager", "false")

    systemProperty("tests.security.manager", "false")
    // Basic auth settings for integration test
    systemProperty("https", System.getProperty("https", "true"))
    systemProperty("user", System.getProperty("user", "admin"))
    systemProperty("password", System.getProperty("password", "admin"))
}

val unitTest = task<Test>("unitTest") {
    filter {
        excludeTestsMatching("org.opensearch.client.opensearch.integTest.*")
    }
}

val integrationTest = task<Test>("integrationTest") {
    filter {
        includeTestsMatching("org.opensearch.client.opensearch.integTest.*")
    }
    systemProperty("tests.security.manager", "false")
    // Basic auth settings for integration test
    systemProperty("https", System.getProperty("https", "true"))
    systemProperty("user", System.getProperty("user", "admin"))
    systemProperty("password", System.getProperty("password", "admin"))
    systemProperty("tests.awsSdk2support.domainHost",
            System.getProperty("tests.awsSdk2support.domainHost", null))
    systemProperty("tests.awsSdk2support.domainRegion",
            System.getProperty("tests.awsSdk2support.domainRegion", "us-east-1"))
}

dependencies {

    val opensearchVersion = "3.0.0-SNAPSHOT"
    val jacksonVersion = "2.14.1"
    val jacksonDatabindVersion = "2.14.1"

    // Apache 2.0
    implementation("org.opensearch.client", "opensearch-rest-client", opensearchVersion)
    testImplementation("org.opensearch.test", "framework", opensearchVersion)

    // Apache 2.0
    // https://search.maven.org/artifact/com.google.code.findbugs/jsr305
    api("com.google.code.findbugs:jsr305:3.0.2")

    // Needed even if using Jackson to have an implementation of the Jsonp object model
    // EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
    // https://github.com/eclipse-ee4j/parsson
    api("org.eclipse.parsson:parsson:1.1.1")

    // EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
    // http://json-b.net/
    implementation("jakarta.json.bind", "jakarta.json.bind-api", "2.0.0")

    // Apache 2.0

    implementation("com.fasterxml.jackson.core", "jackson-core", jacksonVersion)
    implementation("com.fasterxml.jackson.core", "jackson-databind", jacksonDatabindVersion)
    testImplementation("com.fasterxml.jackson.datatype", "jackson-datatype-jakarta-jsonp", jacksonVersion)

    // For AwsSdk2Transport
    "awsSdk2SupportImplementation"("software.amazon.awssdk","sdk-core","[2.15,3.0)")
    "awsSdk2SupportImplementation"("software.amazon.awssdk","auth","[2.15,3.0)")
    testImplementation("software.amazon.awssdk","sdk-core","[2.15,3.0)")
    testImplementation("software.amazon.awssdk","auth","[2.15,3.0)")
    testImplementation("software.amazon.awssdk","aws-crt-client","[2.15,3.0)")
    testImplementation("software.amazon.awssdk","apache-client","[2.15,3.0)")
    testImplementation("software.amazon.awssdk","sts","[2.15,3.0)")
    testImplementation("org.apache.logging.log4j", "log4j-api","[2.17.1,3.0)")
    testImplementation("org.apache.logging.log4j", "log4j-core","[2.17.1,3.0)")
    // EPL-2.0 OR BSD-3-Clause
    // https://eclipse-ee4j.github.io/yasson/
    implementation("org.eclipse", "yasson", "2.0.2")

    // https://github.com/classgraph/classgraph
    testImplementation("io.github.classgraph:classgraph:4.8.154")

    // Eclipse 1.0
    testImplementation("junit", "junit" , "4.13.2") {
        exclude(group = "org.hamcrest")
    }
}

licenseReport {
    renderers = arrayOf(SpdxReporter(File(rootProject.buildDir, "release/dependencies.csv")))
    excludeGroups = arrayOf("org.opensearch.client")
}

class SpdxReporter(val dest: File) : ReportRenderer {
    // License names to their SPDX identifier
    val spdxIds = mapOf(
        "Apache License, Version 2.0" to "Apache-2.0",
        "The Apache Software License, Version 2.0" to "Apache-2.0",
        "BSD Zero Clause License" to "0BSD",
        "Eclipse Public License 2.0" to "EPL-2.0",
        "Eclipse Public License v. 2.0" to "EPL-2.0",
        "GNU General Public License, version 2 with the GNU Classpath Exception" to "GPL-2.0 WITH Classpath-exception-2.0",
        "COMMON DEVELOPMENT AND DISTRIBUTION LICENSE (CDDL) Version 1.0" to "CDDL-1.0"
    )

    private fun quote(str: String) : String {
        return if (str.contains(',') || str.contains("\"")) {
            "\"" + str.replace("\"", "\"\"") + "\""
        } else {
            str
        }
    }

    override fun render(data: ProjectData?) {
        dest.parentFile.mkdirs()
        FileWriter(dest).use { out ->
            out.append("name,url,version,revision,license\n")
            data?.allDependencies?.forEach { dep ->
                val info = com.github.jk1.license.render.LicenseDataCollector.multiModuleLicenseInfo(dep)

                val depVersion = dep.version
                val depName = dep.group + ":" + dep.name
                val depUrl = info.moduleUrls.first()

                val licenseIds = info.licenses.mapNotNull { license ->
                    license.name?.let {
                        checkNotNull(spdxIds[it]) { "No SPDX identifier for $license" }
                    }
                }.toSet()

                // Combine multiple licenses.
                // See https://spdx.github.io/spdx-spec/appendix-IV-SPDX-license-expressions/#composite-license-expressions
                val licenseId = licenseIds.joinToString(" OR ")
                out.append("${quote(depName)},${quote(depUrl)},${quote(depVersion)},,${quote(licenseId)}\n")
            }
        }
    }
}

tasks.withType<Jar> {
    doLast {
        ant.withGroovyBuilder {
            "checksum"("algorithm" to "md5", "file" to archivePath)
            "checksum"("algorithm" to "sha1", "file" to archivePath)
            "checksum"("algorithm" to "sha-256", "file" to archivePath, "fileext" to ".sha256")
            "checksum"("algorithm" to "sha-512", "file" to archivePath, "fileext" to ".sha512")
        }
    }
}

publishing {
    repositories{
        if (version.toString().endsWith("SNAPSHOT")) {
            maven("https://aws.oss.sonatype.org/content/repositories/snapshots/") {
                name = "snapshotRepo"
                credentials(PasswordCredentials::class)
            }
        }
        maven("${rootProject.buildDir}/repository") {
            name = "localRepo"
        }
    }
    publications {
        create<MavenPublication>("publishMaven") {
            from(components["java"])
            pom {
                name.set("OpenSearch Java Client")
                packaging = "jar"
                artifactId = "opensearch-java"
                description.set("High level OpenSearch Java Client.")
                url.set("https://github.com/opensearch-project/opensearch-java/")
                scm {
                    connection.set("scm:git@github.com:opensearch-project/opensearch-java.git")
                    developerConnection.set("scm:git@github.com:opensearch-project/opensearch-java.git")
                    url.set("git@github.com:opensearch-project/opensearch-java.git")
                }
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        name.set("opensearch-project")
                        url.set("https://www.opensearch.org")
                        inceptionYear.set("2021")
                    }
                }
            }
        }
    }
}
