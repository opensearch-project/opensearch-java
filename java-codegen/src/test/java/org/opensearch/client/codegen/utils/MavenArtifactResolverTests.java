/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;

public class MavenArtifactResolverTests {
    @Test
    public void resolves() throws IOException {
        // https://repo.maven.apache.org/maven2/com/google/code/findbugs/jsr305/3.0.2/
        final var group = "com.google.code.findbugs";
        final var name = "jsr305";
        final var version = "3.0.2";
        final var md5Sum = "dd83accb899363c32b07d7a1b2e4ce40";
        final var fileSize = 19936;

        final var coordinates = group + ":" + name + ":" + version;
        final var fileSubPath = Stream.concat(Arrays.stream(group.split("\\.")), Stream.of(name, version, name + "-" + version + ".jar"))
            .collect(Collectors.joining(File.separator));

        var files = MavenArtifactResolver.createDefault().resolve(false, Collections.singleton(coordinates));
        assertEquals(1, files.size());

        var file = files.iterator().next();

        assertTrue(file.getAbsolutePath().endsWith(fileSubPath));
        assertTrue(file.exists());
        assertEquals(fileSize, file.length());

        try (var is = new FileInputStream(file)) {
            assertEquals(md5Sum, DigestUtils.md5Hex(is));
        }
    }
}
