/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen;

import com.google.common.collect.Sets;
import io.swagger.parser.OpenAPIParser;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.Stream;
import org.opensearch.client.codegen.exceptions.ApiSpecificationParseException;
import org.opensearch.client.codegen.exceptions.RenderException;
import org.opensearch.client.codegen.model.Namespace;

public class Main {
    private static final HashSet<String> OPERATIONS = Sets.newHashSet("cat.segment_replication");

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: Main.class {specFile} {outputDir}");
            System.exit(1);
            return;
        }

        try {
            var specFile = new File(args[0]);
            var outputDir = new File(args[1]);
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
        var result = new OpenAPIParser().readLocation(spec.toURI().toString(), null, null);

        if (result.getOpenAPI() == null) {
            throw new ApiSpecificationParseException("Unable to parse spec: " + spec, result.getMessages());
        }

        return Namespace.from(result.getOpenAPI(), OPERATIONS);
    }

    private static void cleanDirectory(File dir) throws RenderException {
        try (Stream<Path> walker = Files.walk(dir.toPath())) {
            walker.sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
        } catch (IOException e) {
            throw new RenderException("Unable to cleanup output directory: " + dir, e);
        }
    }
}
