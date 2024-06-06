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
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.JavaFormatter;
import org.opensearch.client.codegen.exceptions.RenderException;
import org.opensearch.client.codegen.utils.Lists;
import org.opensearch.client.codegen.utils.Strings;

public class Namespace extends Shape {
    private final String name;
    private final Map<String, Namespace> children = new TreeMap<>();
    private final Map<String, RequestShape> operations = new TreeMap<>();
    private final List<Shape> shapes = new ArrayList<>();

    public Namespace() {
        this(null, "");
    }

    private Namespace(Namespace parent, String name) {
        super(parent, null, null);
        this.name = name;
    }

    public void addOperation(RequestShape operation) {
        operations.put(operation.getId(), operation);
        addShape(operation);
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public String getPackageName() {
        return parent != null ? parent.getPackageName() + "." + getPackageNamePart() : "org.opensearch.client.opensearch";
    }

    private String getPackageNamePart() {
        return name;
    }

    @Nonnull
    public Namespace child(@Nullable String name) {
        if (name == null || name.isEmpty()) {
            return this;
        }

        int idx = name.indexOf('.');
        var childName = idx >= 0 ? name.substring(0, idx) : name;
        var grandChildName = idx >= 0 ? name.substring(idx + 1) : null;

        Namespace child = children.computeIfAbsent(childName, n -> new Namespace(this, n));
        return grandChildName == null ? child : child.child(grandChildName);
    }

    @Override
    public void render(File outputDir, JavaFormatter formatter) throws RenderException {
        outputDir.mkdirs();

        for (Namespace child : children.values()) {
            child.render(new File(outputDir, child.getPackageNamePart()), formatter);
        }

        for (Shape shape : shapes) {
            shape.render(outputDir, formatter);
        }

        if (operations.isEmpty()) return;

        // TODO: Render clients when won't be partial and conflict with non-generated code
        // new Client(this, false).render(outputDir, formatter);
        // new Client(this, true).render(outputDir, formatter);
    }

    private static class Client extends Shape {
        private final boolean async;

        private Client(Namespace parent, boolean async) {
            super(parent, "OpenSearch" + Strings.toPascalCase(parent.name) + (async ? "Async" : "") + "Client", null);
            this.async = async;
        }

        public String getName() {
            return parent.name;
        }

        public Collection<Client> getChildren() {
            return Lists.filterMap(parent.children.values(), n -> !n.operations.isEmpty(), n -> new Client(n, async));
        }

        public Collection<RequestShape> getOperations() {
            return parent.operations.values();
        }

        public boolean isAsync() {
            return this.async;
        }
    }
}
