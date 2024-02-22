/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.opensearch.client.codegen.JavaFormatter;
import org.opensearch.client.codegen.TypeMapper;
import org.opensearch.client.codegen.exceptions.RenderException;
import org.opensearch.client.codegen.openapi.HttpStatus;
import org.opensearch.client.codegen.openapi.MimeType;
import org.opensearch.client.codegen.openapi.OpenApiApiResponse;
import org.opensearch.client.codegen.openapi.OpenApiMediaType;
import org.opensearch.client.codegen.openapi.OpenApiOperation;
import org.opensearch.client.codegen.openapi.OpenApiSchema;
import org.opensearch.client.codegen.openapi.OpenApiSpec;
import org.opensearch.client.codegen.utils.Strings;

public class Namespace extends Shape {
    public static Namespace from(OpenApiSpec api, HashSet<String> operationsToGenerate) {
        var referencedSchemas = new ConcurrentLinkedQueue<OpenApiSchema>();
        var ctx = new Context(new Namespace(), new TypeMapper(referencedSchemas::add));

        var groupedOperations = new HashMap<OperationGroup, List<OpenApiOperation>>();

        api.getOperations().forEach((operation) -> {
            var group = operation.getXOperationGroup();
            if (!operationsToGenerate.contains(group.toString())) return;
            groupedOperations.computeIfAbsent(group, k -> new ArrayList<>()).add(operation);
        });

        groupedOperations.forEach((group, variants) -> {
            var parent = ctx.getNamespace().child(group.namespace());
            var opCtx = ctx.withNamespace(parent);

            var requestShape = RequestShape.from(opCtx, group, variants);
            parent.operations.put(requestShape.id(), requestShape);
            parent.shapes.add(requestShape);

            var responseSchema = variants.get(0)
                .getResponses()
                .flatMap(r -> r.get(HttpStatus.OK))
                .map(OpenApiApiResponse::resolve)
                .flatMap(OpenApiApiResponse::getContent)
                .flatMap(c -> c.get(MimeType.JSON))
                .flatMap(OpenApiMediaType::getSchema)
                .map(OpenApiSchema::resolve)
                .orElse(OpenApiSchema.EMPTY);

            var responseShape = responseSchema.isArray()
                ? ArrayShape.from(opCtx, requestShape.responseType(), responseSchema)
                : ObjectShape.from(opCtx, requestShape.responseType(), responseSchema);
            parent.shapes.add(responseShape);
        });

        var seenSchemas = new HashSet<>();
        OpenApiSchema schema;
        while ((schema = referencedSchemas.poll()) != null) {
            if (!seenSchemas.add(schema)) continue;

            Namespace parent = ctx.getNamespace().child(schema.getNamespace());
            Context thisCtx = ctx.withNamespace(parent);

            if (schema.isObject()) {
                parent.shapes.add(ObjectShape.from(thisCtx, schema.getName(), schema));
            } else if (schema.isString() && schema.hasEnums()) {
                parent.shapes.add(EnumShape.from(thisCtx, schema.getName(), schema));
            }
        }

        return ctx.getNamespace();
    }

    private final String name;
    private final Map<String, Namespace> children = new TreeMap<>();
    private final Map<String, RequestShape> operations = new TreeMap<>();
    private final List<Shape> shapes = new ArrayList<>();

    private Namespace() {
        this(null, "");
    }

    private Namespace(Namespace parent, String name) {
        super(parent, null);
        this.name = name;
    }

    @Override
    public String packageName() {
        return parent != null ? parent.packageName() + "." + packageNamePart() : "org.opensearch.client.opensearch";
    }

    private String packageNamePart() {
        return name;
    }

    public Namespace child(String name) {
        if (name == null || name.isEmpty()) {
            return this;
        }

        int idx = name.indexOf('.');
        var childName = idx >= 0 ? name.substring(0, idx) : name;
        var grandChildName = idx >= 0 ? name.substring(idx + 1) : null;

        // if ("_common".equals(childName) && this.parent != null) return child(grandChildName);

        Namespace child = children.computeIfAbsent(childName, n -> new Namespace(this, n));
        return grandChildName == null ? child : child.child(grandChildName);
    }

    @Override
    public void render(File outputDir, JavaFormatter formatter) throws RenderException {
        outputDir.mkdirs();

        for (Namespace child : children.values()) {
            child.render(new File(outputDir, child.packageNamePart()), formatter);
        }

        for (Shape shape : shapes) {
            shape.render(outputDir, formatter);
        }

        if (operations.isEmpty()) return;

        new Client(this, false).render(outputDir, formatter);
        new Client(this, true).render(outputDir, formatter);
    }

    private static class Client extends Shape {
        private final boolean async;

        private Client(Namespace parent, boolean async) {
            super(parent, "OpenSearch" + Strings.toPascalCase(parent.name) + (async ? "Async" : "") + "Client");
            this.async = async;
        }

        public String name() {
            return parent.name;
        }

        public Collection<Client> children() {
            return parent.children.values().stream().filter(n -> !n.operations.isEmpty()).map(n -> new Client(n, async)).toList();
        }

        public Collection<RequestShape> operations() {
            return parent.operations.values();
        }

        public boolean async() {
            return this.async;
        }
    }
}
