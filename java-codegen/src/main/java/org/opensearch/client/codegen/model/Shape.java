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
    private final String typedefName;

    public Shape(Namespace parent, String className, String typedefName) {
        this.parent = parent;
        this.className = className;
        this.typedefName = typedefName;
    }

    public Type getType() {
        return Type.builder().pkg(getPackageName()).name(className).build();
    }

    public Namespace getParent() {
        return this.parent;
    }

    public String getPackageName() {
        return parent.getPackageName();
    }

    public String getClassName() {
        return this.className;
    }

    public String getTypedefName() {
        return this.typedefName;
    }

    public void render(File outputDir, JavaFormatter formatter) throws RenderException {
        var renderer = new Renderer(referencedTypes::add, formatter);
        renderer.renderJava(this, new File(outputDir, this.className + ".java"));
    }

    public Set<String> getImports() {
        var imports = new TreeSet<String>();
        for (var type : referencedTypes) {
            type.getRequiredImports(imports, getPackageName());
        }
        return imports;
    }
}
