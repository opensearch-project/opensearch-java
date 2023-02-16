/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen;

import org.opensearch.client.codegen.exceptions.ApiSpecificationParseException;
import org.opensearch.client.codegen.exceptions.RenderException;
import org.opensearch.client.codegen.model.Client;
import org.opensearch.client.codegen.model.EnumShape;
import org.opensearch.client.codegen.model.ObjectShape;
import org.opensearch.client.codegen.model.RequestShape;
import org.opensearch.client.codegen.model.Shape;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Generator {
    private final ApiSpecification apiSpecification;
    private final Renderer renderer;
    private final File outputDir;

    public Generator(File schemaFile, File outputDir) throws ApiSpecificationParseException {
        apiSpecification = ApiSpecification.parse(schemaFile);
        renderer = new Renderer();
        this.outputDir = outputDir;
    }

    public void generate() throws RenderException {
        try (Stream<Path> walker = Files.walk(outputDir.toPath())) {
            walker.sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            throw new RenderException("Unable to cleanup output directory: " + outputDir, e);
        }

        Map<String, Client> namespaceClients = new HashMap<>();

        for (RequestShape requestShape : apiSpecification.getRequestShapes()) {
            renderShape(requestShape);

            namespaceClients.computeIfAbsent(requestShape.namespace(), Client::new)
                    .addOperation(requestShape.id());
        }

        for (ObjectShape objectShape : apiSpecification.getObjectShapes()) {
            renderShape(objectShape);
        }

        for (EnumShape enumShape : apiSpecification.getEnumShapes()) {
            renderShape(enumShape);
        }

        for (Client client : namespaceClients.values()) {
            renderShape(client);
            renderShape(client.async(true));
        }
    }

    private <S extends Shape> void renderShape(S shape) throws RenderException {
        File packageDir = new File(outputDir, shape.packageName().replace('.', '/'));
        packageDir.mkdirs();
        File outputFile = new File(packageDir, shape.className() + ".java");
        renderer.render(shape, outputFile);
    }
}
