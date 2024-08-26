/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.opensearch.client.codegen.exceptions.RenderException;
import org.opensearch.client.codegen.utils.Lists;
import org.opensearch.client.codegen.utils.Strings;

public class Namespace {
    private final Namespace parent;
    private final String name;
    private final Map<String, Namespace> children = new TreeMap<>();
    private final Map<String, RequestShape> operations = new TreeMap<>();
    private final List<Shape> shapes = new ArrayList<>();

    public Namespace() {
        this(null, "");
    }

    private Namespace(Namespace parent, String name) {
        this.parent = parent;
        this.name = name;
    }

    public void addOperation(RequestShape operation) {
        operations.put(operation.getId(), operation);
        addShape(operation);
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public String getPackageName() {
        return parent != null ? parent.getPackageName() + "." + getName() : "org.opensearch.client.opensearch";
    }

    @Nonnull
    public String getName() {
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

    public void render(ShapeRenderingContext ctx) throws RenderException {
        for (Namespace child : children.values()) {
            child.render(ctx.forSubDir(child.getName()));
        }

        for (Shape shape : shapes) {
            shape.render(ctx);
        }

        var operations = getOperationsForClient();

        if (operations.isEmpty()) return;

        new Client(this, false, operations).render(ctx);
        new Client(this, true, operations).render(ctx);
    }

    private Collection<RequestShape> getOperationsForClient() {
        if ("core".equals(name)) return Collections.emptyList();
        return ("".equals(name) ? child("core") : this).operations.values();
    }

    private String getClientClassName(boolean async, boolean base) {
        return "OpenSearch" + Strings.toPascalCase(name) + (async ? "Async" : "") + "Client" + (base ? "Base" : "");
    }

    private Type getClientType(boolean async, boolean base) {
        var type = Type.builder().pkg(getPackageName()).name(getClientClassName(async, base));
        if (base) {
            type.typeParams(getClientType(async, false));
        }
        return type.build();
    }

    private static class Client extends Shape {
        private final boolean async;
        private final Collection<RequestShape> operations;

        private Client(Namespace parent, boolean async, Collection<RequestShape> operations) {
            super(parent, parent.getClientClassName(async, false), null, "Client for the " + parent.name + " namespace.");
            this.async = async;
            this.operations = operations;
        }

        @Override
        public Type getExtendsType() {
            switch (parent.name) {
                case "":
                    return parent.getClientType(async, true);
                default:
                    return Types.Client.ApiClient(Types.Client.Transport.OpenSearchTransport, getType());
            }
        }

        public String getName() {
            return parent.name;
        }

        public Collection<ClientRef> getChildren() {
            return Lists.filterMap(parent.children.values(), n -> !n.getOperationsForClient().isEmpty(), n -> new ClientRef(n, async));
        }

        public Collection<RequestShape> getOperations() {
            return operations;
        }

        public boolean isAsync() {
            return this.async;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("type", getType()).toString();
        }

        private static class ClientRef {
            private final Type type;
            private final String name;

            public ClientRef(Namespace namespace, boolean async) {
                this.type = namespace.getClientType(async, false);
                this.name = namespace.name;
            }

            public Type getType() {
                return type;
            }

            public String getName() {
                return name;
            }
        }
    }
}
