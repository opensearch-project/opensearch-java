/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.media.Schema;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.Pair;
import org.opensearch.client.codegen.Renderer;
import org.opensearch.client.codegen.TypeMapper;
import org.opensearch.client.codegen.exceptions.RenderException;
import org.opensearch.client.codegen.utils.ComponentSchemaRef;
import org.opensearch.client.codegen.utils.Extensions;
import org.opensearch.client.codegen.utils.Quartet;
import org.opensearch.client.codegen.utils.Schemas;
import org.opensearch.client.codegen.utils.Strings;

public class Namespace extends Shape {
    public static Namespace from(OpenAPI api, HashSet<String> operationsToGenerate) {
        var referencedSchemas = new ConcurrentLinkedQueue<Pair<String, Schema<?>>>();
        var ctx = new Context(new Namespace(), api, new TypeMapper(api, (ref, schema) -> referencedSchemas.add(Pair.of(ref, schema))));

        var groupedOperations = new HashMap<OperationGroup, List<Quartet<String, PathItem, PathItem.HttpMethod, Operation>>>();

        api.getPaths().forEach((httpPath, pathItem) -> pathItem.readOperationsMap().forEach((httpMethod, operation) -> {
            var group = Extensions.of(operation).operationGroup();
            if (!operationsToGenerate.contains(group.toString())) return;
            groupedOperations.computeIfAbsent(group, k -> new ArrayList<>()).add(Quartet.of(httpPath, pathItem, httpMethod, operation));
        }));

        groupedOperations.forEach((group, variants) -> {
            var parent = ctx.namespace.child(group.namespace());
            var opCtx = ctx.withNamespace(parent);

            var requestShape = RequestShape.from(opCtx, group, variants);
            parent.operations.put(requestShape.id(), requestShape);
            parent.shapes.add(requestShape);

            var responseSchema = Schemas.resolveResponseBodySchema(opCtx.openApi, variants.get(0).fourth()).orElseGet(Schema::new);
            var responseShape = Schemas.isArray(responseSchema)
                    ? ArrayShape.from(opCtx, requestShape.responseType(), responseSchema)
                    : ObjectShape.from(opCtx, requestShape.responseType(), responseSchema);
            parent.shapes.add(responseShape);
        });

        var seenRefs = new HashSet<>();
        Pair<String, Schema<?>> schemaRef;
        while ((schemaRef = referencedSchemas.poll()) != null) {
            var $ref = schemaRef.getKey();
            var schema = schemaRef.getValue();

            if (!seenRefs.add($ref)) continue;

            var refParts = ComponentSchemaRef.from($ref);

            Namespace parent = ctx.namespace.child(refParts.namespace());
            Context thisCtx = ctx.withNamespace(parent);

            if (Schemas.isObject(schema)) {
                parent.shapes.add(ObjectShape.from(thisCtx, refParts.name(), schema));
            } else if (Schemas.isString(schema) && Schemas.hasEnums(schema)) {
                parent.shapes.add(EnumShape.from(thisCtx, refParts.name(), schema));
            }
        }

        return ctx.namespace;
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
        Namespace child = children.computeIfAbsent(idx >= 0 ? name.substring(0, idx) : name, n -> new Namespace(this, n));
        return idx < 0 ? child : child.child(name.substring(idx + 1));
    }

    @Override
    public void render(Renderer renderer, File outputDir) throws RenderException {
        outputDir.mkdirs();

        for (Namespace child : children.values()) {
            child.render(renderer, new File(outputDir, child.packageNamePart()));
        }

        for (Shape shape : shapes) {
            shape.render(renderer, outputDir);
        }

        if (operations.isEmpty()) return;

        new Client(this, false).render(renderer, outputDir);
        new Client(this, true).render(renderer, outputDir);
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
            return parent.children.values().stream().map(n -> new Client(n, async)).collect(Collectors.toList());
        }

        public Collection<RequestShape> operations() {
            return parent.operations.values();
        }

        public boolean async() {
            return this.async;
        }
    }
}
