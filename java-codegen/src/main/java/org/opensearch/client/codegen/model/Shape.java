/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.io.File;
import org.opensearch.client.codegen.Renderer;
import org.opensearch.client.codegen.exceptions.RenderException;

public abstract class Shape {
    protected final Namespace parent;
    private final String className;

    public Shape(Namespace parent, String className) {
        this.parent = parent;
        this.className = className;
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

    public void render(Renderer renderer, File outputDir) throws RenderException {
        renderer.render(this, new File(outputDir, this.className + ".java"));
    }
}
