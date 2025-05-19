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

allprojects {
    group = "org.opensearch.client"

    // Release manager provides a $VERSION. If not present, it's a local or CI snapshot build.
    version = System.getenv("VERSION") ?: System.getProperty("version") + "-SNAPSHOT"

    repositories {
        mavenLocal()
        maven(url = "https://aws.oss.sonatype.org/content/repositories/snapshots")
        mavenCentral()
        gradlePluginPortal()
    }
}

// Find git information.
// The ".git" directory may not exist when resolving dependencies in the Docker image build
if (File(rootProject.rootDir, ".git").exists()) {
    val grgit = org.ajoberstar.grgit.Grgit.open(mapOf("currentDir" to rootProject.rootDir))
    rootProject.extra["gitHashFull"] = grgit.head().id
    rootProject.extra["gitCommitTime"] = grgit.head().dateTime.withZoneSameLocal(java.time.ZoneOffset.UTC)
    grgit.close()
}

rootProject.extra["buildTime"] = java.time.Instant.now().atZone(java.time.ZoneOffset.UTC)

tasks.register<Task>(name = "resolveDependencies") {
    group = "Build Setup"
    description = "Resolves and prefetches dependencies"
    doLast {
        rootProject.allprojects.forEach {
            it.buildscript.configurations.filter(Configuration::isCanBeResolved).forEach { it.resolve() }
            it.configurations.filter(Configuration::isCanBeResolved).forEach { it.resolve() }
        }
    }
}
