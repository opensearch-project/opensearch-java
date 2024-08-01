/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.codegen.exceptions.RenderException;
import org.opensearch.client.codegen.utils.JavaClassKind;

public abstract class Shape {
    private static final Logger LOGGER = LogManager.getLogger();
    protected final Namespace parent;
    private final String className;
    private final Set<Type> referencedTypes = new HashSet<>();
    private final String typedefName;
    private final String description;

    public Shape(Namespace parent, String className, String typedefName, String description) {
        this.parent = parent;
        this.className = className;
        this.typedefName = typedefName;
        this.description = description;
    }

    public String getPackageName() {
        return parent.getPackageName();
    }

    public String getClassName() {
        return this.className;
    }

    public JavaClassKind getClassKind() {
        return JavaClassKind.Class;
    }

    public boolean isAbstract() {
        return this.className.endsWith("Base");
    }

    public String getTypedefName() {
        return this.typedefName;
    }

    public String getDescription() {
        return this.description;
    }

    public Collection<Type> getAnnotations() {
        return Collections.emptyList();
    }

    public Type getExtendsType() {
        return null;
    }

    public Collection<Type> getImplementsTypes() {
        return Collections.emptyList();
    }

    public Type getType() {
        return Type.builder().pkg(getPackageName()).name(className).build();
    }

    public Namespace getParent() {
        return this.parent;
    }

    public void render(ShapeRenderingContext ctx) throws RenderException {
        var outFile = ctx.getOutputFile(className + ".java");
        LOGGER.info("Rendering: {}", outFile);
        var renderer = ctx.getTemplateRenderer(b -> b.withFormatter(Type.class, t -> {
            referencedTypes.add(t);
            return t.toString();
        }));
        renderer.renderJava(this, outFile);
    }

    public Set<String> getImports() {
        var imports = new TreeSet<String>();
        for (var type : referencedTypes) {
            type.getRequiredImports(imports, getPackageName());
        }
        return imports;
    }
}
