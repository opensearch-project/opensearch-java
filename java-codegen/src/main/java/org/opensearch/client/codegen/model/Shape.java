/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import org.opensearch.client.codegen.JavaFormatter;
import org.opensearch.client.codegen.Renderer;
import org.opensearch.client.codegen.exceptions.RenderException;

public abstract class Shape {
    protected final Namespace parent;
    private final String className;
    private final Set<Type> referencedTypes = new HashSet<>();

    public Shape(Namespace parent, String className) {
        this.parent = parent;
        this.className = className;
    }

    public Type type() {
        return Type.builder().pkg(packageName()).name(className).build();
    }

    public Namespace parent() {
        return this.parent;
    }

    public String packageName() {
        return parent.packageName();
    }

    public String className() {
        return this.className;
    }

    public void render(File outputDir, JavaFormatter formatter) throws RenderException {
        var renderer = new Renderer(referencedTypes::add, formatter);
        renderer.renderJava(this, new File(outputDir, this.className + ".java"));
    }

    public Set<String> imports() {
        var imports = new TreeSet<String>();
        for (var type : referencedTypes) {
            type.getRequiredImports(imports, packageName());
        }
        return imports;
    }
}
