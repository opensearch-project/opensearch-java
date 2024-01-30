/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen;

import com.google.common.collect.Sets;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.Stream;
import org.openapi4j.core.exception.ResolutionException;
import org.openapi4j.core.validation.ValidationException;
import org.openapi4j.parser.OpenApi3Parser;
import org.openapi4j.parser.model.v3.OpenApi3;
import org.opensearch.client.codegen.exceptions.ApiSpecificationParseException;
import org.opensearch.client.codegen.exceptions.RenderException;
import org.opensearch.client.codegen.model.Namespace;

public class Main {
    private static final HashSet<String> OPERATIONS = Sets.newHashSet(
            "cat.segment_replication"
    );

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: Main.class {specFile} {outputDir}");
            System.exit(1);
            return;
        }

        try {
            File specFile = new File(args[0]);
            File outputDir = new File(args[1]);
            System.out.println("Spec File: " + specFile);
            System.out.println("Output Dir: " + outputDir);

            Namespace root = parseSpec(specFile);

            cleanDirectory(outputDir);

            outputDir = new File(outputDir, root.packageName().replace('.', '/'));

            root.render(Renderer.INSTANCE, outputDir);
        } catch (Throwable e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }

    private static Namespace parseSpec(File spec) throws ApiSpecificationParseException {
        try {
            OpenApi3 api = new OpenApi3Parser().parse(spec, true);
            return Namespace.from(api, OPERATIONS);
        } catch (ResolutionException | ValidationException e) {
            throw new ApiSpecificationParseException("Failed to parse schema: " + spec, e);
        }
    }

    private static void cleanDirectory(File dir) throws RenderException {
        try (Stream<Path> walker = Files.walk(dir.toPath())) {
            walker.sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            throw new RenderException("Unable to cleanup output directory: " + dir, e);
        }
    }
}
