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
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.codegen.exceptions.RenderException;
import org.opensearch.client.codegen.model.overrides.ShouldGenerate;
import org.opensearch.client.codegen.utils.JavaClassKind;
import org.opensearch.client.codegen.utils.Markdown;

public abstract class Shape {
    private static final Logger LOGGER = LogManager.getLogger();
    private final Set<Type> referencedTypes = new HashSet<>();
    private final Map<ReferenceKind, List<Shape>> incomingReferences = new HashMap<>();
    private final Map<ReferenceKind, List<Shape>> outgoingReferences = new HashMap<>();
    protected final Namespace parent;
    private final String className;
    private final String typedefName;
    private final String description;
    private final ShouldGenerate shouldGenerate;
    private Type extendsType;

    public Shape(Namespace parent, String className, String typedefName, String description, ShouldGenerate shouldGenerate) {
        this.parent = parent;
        this.className = className;
        this.typedefName = typedefName;
        this.description = description != null ? Markdown.toJavaDocHtml(description) : null;
        this.shouldGenerate = shouldGenerate;
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

    public Collection<ReferencingDiscriminatedUnion> getReferencingDiscriminatedUnions() {
        var unions = getIncomingReference(ReferenceKind.UnionVariant).stream()
            .map(s -> (TaggedUnionShape) s)
            .distinct()
            .filter(TaggedUnionShape::isDiscriminated)
            .sorted(Comparator.comparing(Shape::getClassName))
            .map(u -> {
                var discriminatorValue = u.getVariants()
                    .stream()
                    .filter(v -> v.getType().equals(getType()))
                    .map(TaggedUnionShape.Variant::getName)
                    .max(Comparator.naturalOrder())
                    .orElseThrow();

                return new ReferencingDiscriminatedUnion(u, discriminatorValue);
            })
            .collect(Collectors.toList());

        // Temporary hack until SortOptions is properly generated
        if (parent.getName().equals("_types") && className.equals("ScriptSort")) {
            unions.add(
                new ReferencingDiscriminatedUnion(new TaggedUnionShape(parent, "SortOptions", null, null, ShouldGenerate.Never), "script")
            );
        }

        return unions;
    }

    public Collection<Type> getImplementsTypes() {
        var types = new ArrayList<Type>();

        for (var union : getReferencingDiscriminatedUnions()) {
            types.add(union.getUnion().getVariantInterfaceType());
        }

        return types;
    }

    protected void tryAddReference(ReferenceKind kind, Type to) {
        if (to == null) return;
        to.getTargetShape().ifPresent(s -> addReference(kind, s));
        var typeParams = to.getTypeParams();
        if (typeParams != null) {
            for (var typeParam : typeParams) {
                tryAddReference(ReferenceKind.TypeParameter, typeParam);
            }
        }
    }

    private void addReference(ReferenceKind kind, Shape to) {
        outgoingReferences.computeIfAbsent(kind, k -> new ArrayList<>()).add(to);
        to.incomingReferences.computeIfAbsent(kind, k -> new ArrayList<>()).add(this);
    }

    protected Collection<Shape> getIncomingReference(ReferenceKind kind) {
        var refs = incomingReferences.get(kind);
        return refs != null ? Collections.unmodifiableList(refs) : Collections.emptyList();
    }

    public @Nonnull Type getType() {
        return Type.builder().withPackage(getPackageName()).withName(className).withTargetShape(this).build();
    }

    public Namespace getParent() {
        return this.parent;
    }

    private boolean shouldGenerate(Set<Shape> visited) {
        switch (shouldGenerate) {
            case Always:
                return true;
            case Never:
                return false;
            case IfNeeded:
                if (visited.contains(this)) {
                    return false;
                }
                visited.add(this);
                return incomingReferences.values().stream().flatMap(List::stream).anyMatch(s -> s.shouldGenerate(visited));
            default:
                throw new IllegalStateException("Unknown ShouldGenerate: " + shouldGenerate);
        }
    }

    public boolean shouldGenerate() {
        return shouldGenerate(new HashSet<>());
    }

    public void render(ShapeRenderingContext ctx) throws RenderException {
        var outFile = ctx.getOutputFile(className + ".java");
        if (!shouldGenerate()) {
            LOGGER.info("Skipping: {}", outFile);
            return;
        }
        LOGGER.info("Rendering: {}", outFile);
        var renderer = ctx.getTemplateRenderer(b -> b.withFormatter(Type.class, t -> {
            referencedTypes.add(t);
            return t.toString();
        }));
        renderer.renderJava(this, outFile);
    }

    public String getTemplateName() {
        return getClass().getSimpleName();
    }

    public Set<String> getImports() {
        var imports = new TreeSet<String>();
        for (var type : referencedTypes) {
            type.getRequiredImports(imports, getPackageName());
        }
        return imports;
    }

    public boolean needsLegacyLicense() {
        var parentName = parent.getName();
        if ("analysis".equals(parentName) && (className.startsWith("Cjk") || className.startsWith("Smartcn"))) {
            return false;
        }
        if (className.startsWith("Xy")) {
            return false;
        }
        return !"ml".equals(parentName);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("className", className)
            .append("parent", parent)
            .append("extendsType", extendsType)
            .toString();
    }

    public static class ReferencingDiscriminatedUnion {
        private final TaggedUnionShape union;
        private final String discriminatorValue;

        public ReferencingDiscriminatedUnion(TaggedUnionShape union, String discriminatorValue) {
            this.union = union;
            this.discriminatorValue = discriminatorValue;
        }

        public TaggedUnionShape getUnion() {
            return union;
        }

        @Nullable
        public String getDiscriminatingField() {
            return union.getDiscriminatingField();
        }

        public String getDiscriminatorValue() {
            return discriminatorValue;
        }
    }
}
