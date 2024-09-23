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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.codegen.exceptions.RenderException;
import org.opensearch.client.codegen.utils.JavaClassKind;

public abstract class Shape {
    private static final Logger LOGGER = LogManager.getLogger();
    private final Set<Type> referencedTypes = new HashSet<>();
    private final Map<ReferenceKind, List<Shape>> incomingReferences = new HashMap<>();
    private final Map<ReferenceKind, List<Shape>> outgoingReferences = new HashMap<>();
    protected final Namespace parent;
    private final String className;
    private final String typedefName;
    private final String description;
    private Type extendsType;

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
        var refKinds = incomingReferences.entrySet()
            .stream()
            .filter(e -> !e.getValue().isEmpty())
            .map(Map.Entry::getKey)
            .collect(Collectors.toSet());
        return !refKinds.isEmpty() && refKinds.stream().noneMatch(ReferenceKind::isConcreteUsage);
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

    public TypeParameterDiamond getTypeParameters() {
        return null;
    }

    public Type getExtendsType() {
        return extendsType;
    }

    public void setExtendsType(Type extendsType) {
        this.extendsType = extendsType;
        tryAddReference(ReferenceKind.Extends, extendsType);
    }

    public boolean extendsOtherShape() {
        return extendsType != null && extendsType.getTargetShape().isPresent();
    }

    public boolean extendedByOtherShape() {
        return !incomingReferences.getOrDefault(ReferenceKind.Extends, Collections.emptyList()).isEmpty();
    }

    public Collection<Type> getImplementsTypes() {
        return Collections.emptyList();
    }

    protected void tryAddReference(ReferenceKind kind, Type to) {
        if (to == null) return;
        to.getTargetShape().ifPresent(s -> addReference(kind, s));
    }

    private void addReference(ReferenceKind kind, Shape to) {
        outgoingReferences.computeIfAbsent(kind, k -> new ArrayList<>()).add(to);
        to.incomingReferences.computeIfAbsent(kind, k -> new ArrayList<>()).add(this);
    }

    public @Nonnull Type getType() {
        return Type.builder().withPackage(getPackageName()).withName(className).withTargetShape(this).build();
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

    public boolean needsLegacyLicense() {
        return !"ml".equals(parent.getName());
    }
}
