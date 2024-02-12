/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
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
    application
    `maven-publish`
    id("com.github.jk1.dependency-license-report") version "1.19"
    id("org.owasp.dependencycheck") version "9.0.9"
    id("com.diffplug.spotless") version "6.24.0"
}
apply(plugin = "opensearch.repositories")
apply(plugin = "org.owasp.dependencycheck")

val runtimeJavaVersion = (System.getProperty("runtime.java")?.toInt())?.let(JavaVersion::toVersion) ?: JavaVersion.current()
logger.quiet("=======================================")
logger.quiet("  Runtime JDK Version   : $runtimeJavaVersion")
logger.quiet("  Gradle JDK Version    : " + JavaVersion.current())
logger.quiet("=======================================")

java {
    targetCompatibility = JavaVersion.VERSION_11
    sourceCompatibility = JavaVersion.VERSION_11

    withJavadocJar()
    withSourcesJar()

    toolchain {
        languageVersion = JavaLanguageVersion.of(runtimeJavaVersion.majorVersion)
        vendor = JvmVendorSpec.ADOPTIUM
    }
}

application {
    mainClass.set("org.opensearch.client.codegen.Main")
    applicationDefaultJvmArgs = listOf(
        "--add-exports", "jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
        "--add-exports", "jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED",
        "--add-exports", "jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED",
        "--add-exports", "jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
        "--add-exports", "jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED"
    )
}

tasks.named<JavaExec>("run") {
    args = listOf(
        "${projectDir}/OpenSearch.openapi.json",
        "${project(":java-client").projectDir}/src/generated/java/"
    )
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
        attributes["Implementation-Title"] = "OpenSearch Java client code generator"
        attributes["Implementation-Vendor"] = "OpenSearch"
        attributes["Implementation-URL"] = "https://github.com/opensearch-project/opensearch-java/"
        attributes["Build-Date"] = rootProject.extra["buildTime"]
    }

    metaInf {
        from("../LICENSE.txt")
        from("../NOTICE.txt")
    }
}

tasks.build {
    dependsOn("spotlessJavaCheck")
}

dependencies {
    // Apache 2.0
    implementation("io.swagger.parser.v3:swagger-parser:2.1.20")

    // (New) BSD
    implementation("com.samskivert:jmustache:1.16")

    // Apache 2.0
    implementation("org.apache.commons:commons-lang3:3.14.0")
    implementation("org.apache.commons:commons-text:1.10.0")

    // Apache 2.0
    implementation("com.fasterxml.jackson.core:jackson-core:2.14.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.2")

    // Apache 2.0
    implementation("com.google.googlejavaformat:google-java-format:1.15.0")

    // Apache 2.0
    // https://search.maven.org/artifact/com.google.code.findbugs/jsr305
    implementation("com.google.code.findbugs:jsr305:3.0.2")

    // Eclipse 1.0
    testImplementation("junit", "junit" , "4.13.2") {
        exclude(group = "org.hamcrest")
    }
}

licenseReport {
    renderers = arrayOf(SpdxReporter(rootProject.layout.buildDirectory.file("release/codegen-dependencies.csv").get().getAsFile()))
    excludeGroups = arrayOf()
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
            "checksum"("algorithm" to "md5", "file" to archiveFile.get())
            "checksum"("algorithm" to "sha1", "file" to archiveFile.get())
            "checksum"("algorithm" to "sha-256", "file" to archiveFile.get(), "fileext" to ".sha256")
            "checksum"("algorithm" to "sha-512", "file" to archiveFile.get(), "fileext" to ".sha512")
        }
    }
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

publishing {
    repositories{
        if (version.toString().endsWith("SNAPSHOT")) {
            maven("https://aws.oss.sonatype.org/content/repositories/snapshots/") {
                name = "Snapshots"
                credentials {
                    username = System.getenv("SONATYPE_USERNAME")
                    password = System.getenv("SONATYPE_PASSWORD")
                }
            }
        }
        maven("${rootProject.layout.buildDirectory}/repository") {
            name = "localRepo"
        }
    }
    publications {
        create<MavenPublication>("publishMaven") {
            from(components["java"])
            pom {
                name.set("OpenSearch Java Client Code Generator")
                packaging = "jar"
                artifactId = "opensearch-java-codegen"
                description.set("Code generator for the OpenSearch Java Client.")
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
