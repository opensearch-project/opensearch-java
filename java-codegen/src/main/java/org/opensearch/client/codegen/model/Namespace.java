package org.opensearch.client.codegen.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.Pair;
import org.openapi4j.core.model.OAIContext;
import org.openapi4j.parser.model.v3.OpenApi3;
import org.openapi4j.parser.model.v3.Schema;
import org.opensearch.client.codegen.Renderer;
import org.opensearch.client.codegen.TypeMapper;
import org.opensearch.client.codegen.exceptions.RenderException;
import org.opensearch.client.codegen.utils.Schemas;
import org.opensearch.client.codegen.utils.Strings;

public class Namespace extends Shape {
    public static Namespace from(OpenApi3 api) {
        OAIContext openApiCtx = api.getContext();
        Queue<Pair<String, Schema>> referencedSchemas = new ConcurrentLinkedQueue<>();
        Context ctx = new Context(
                new Namespace(),
                openApiCtx,
                new TypeMapper(openApiCtx, (ref, schema) -> referencedSchemas.add(Pair.of(ref, schema)))
        );

        api.getPaths().forEach((httpPath, path) -> path.getOperations().forEach((method, operation) -> {
            Namespace parent = ctx.namespace.child(Schemas.getNamespaceExtension(operation));
            Context opCtx = ctx.withNamespace(parent);

            RequestShape requestShape = RequestShape.from(opCtx, httpPath, path, method, operation);
            parent.operations.put(requestShape.id(), requestShape);
            parent.shapes.add(requestShape);

            Schema responseSchema = Schemas.resolveResponseBodySchema(opCtx.openApiCtx, operation).orElseGet(Schema::new);
            parent.shapes.add(ObjectShape.from(opCtx, requestShape.responseType(), responseSchema));
        }));

        Set<String> seenRefs = new HashSet<>();
        Pair<String, Schema> schemaRef;
        while ((schemaRef = referencedSchemas.poll()) != null) {
            String ref = schemaRef.getKey();
            Schema schema = schemaRef.getValue();

            if (!seenRefs.add(ref)) continue;

            String[] refParts = ref.split("/");
            String name = refParts[refParts.length - 1];

            Namespace parent = ctx.namespace.child(Schemas.getNamespaceExtension(schema));
            Context thisCtx = ctx.withNamespace(parent);

            if (Schemas.isObject(schema)) {
                parent.shapes.add(ObjectShape.from(thisCtx, name, schema));
            } else if (Schemas.isString(schema) && schema.hasEnums()) {
                parent.shapes.add(EnumShape.from(thisCtx, name, schema));
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
        return parent != null
                ? parent.packageName() + "." + packageNamePart()
                : "org.opensearch.client.opensearch";
    }

    private String packageNamePart() {
        return name.replace("_", "").toLowerCase();
    }

    public Namespace child(String name) {
        if (name == null || name.isEmpty()) {
            return this;
        }

        int idx = name.indexOf('.');
        Namespace child = children.computeIfAbsent(
                idx >= 0 ? name.substring(0, idx) : name,
                n -> new Namespace(this, n)
        );
        return idx < 0
                ? child
                : child.child(name.substring(idx + 1));
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

        // Don't generate root client for now otherwise conflicts
        if (parent == null) return;

        new Client(this, false).render(renderer, outputDir);
        new Client(this, true).render(renderer, outputDir);
    }

    private static class Client extends Shape {
        private final boolean async;

        public Client(Namespace parent, boolean async) {
            super(parent, "OpenSearch" + Strings.toPascalCase(parent.name) + (async ? "Async" : "") + "Client");
            this.async = async;
        }

        public String name() {
            return parent.name;
        }

        public Collection<Client> children() {
            return parent
                    .children
                    .values()
                    .stream()
                    .map(n -> new Client(n, async))
                    .collect(Collectors.toList());
        }

        public Collection<RequestShape> operations() {
            return parent.operations.values();
        }

        public boolean async() {
            return this.async;
        }
    }
}
