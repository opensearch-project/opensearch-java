/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.codegen.exceptions.RenderException;
import org.opensearch.client.codegen.model.types.ShapeTypeRef;
import org.opensearch.client.codegen.model.types.Type;
import org.opensearch.client.codegen.model.types.TypeParameterDefinition;
import org.opensearch.client.codegen.model.types.TypeParameterDiamond;
import org.opensearch.client.codegen.model.types.TypeParameterRef;
import org.opensearch.client.codegen.model.types.TypeRef;
import org.opensearch.client.codegen.model.types.Types;
import org.opensearch.client.codegen.renderer.ShapeRenderingContext;
import org.opensearch.client.codegen.transformer.overrides.ShouldGenerate;
import org.opensearch.client.codegen.utils.JavaAbstractionLevel;
import org.opensearch.client.codegen.utils.JavaClassKind;
import org.opensearch.client.codegen.utils.Markdown;
import org.opensearch.client.codegen.utils.Strings;

public abstract class Shape {
    private static final Logger LOGGER = LogManager.getLogger();
    private final Set<TypeRef> referencedTypes = new HashSet<>();
    private final Map<ReferenceKind, List<Shape>> incomingReferences = new HashMap<>();
    private final Map<ReferenceKind, List<Shape>> outgoingReferences = new HashMap<>();
    protected final Namespace parent;
    private final String className;
    private final String typedefName;
    private final String description;
    private final ShouldGenerate shouldGenerate;
    private TypeRef extendsType;
    private final List<TypeParameterDefinition> typeParameters = new ArrayList<>();

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

    public JavaAbstractionLevel getAbstractionLevel() {
        var refKinds = incomingReferences.entrySet()
            .stream()
            .filter(e -> !e.getValue().isEmpty())
            .map(Map.Entry::getKey)
            .collect(Collectors.toSet());
        return !refKinds.isEmpty() && refKinds.stream().noneMatch(ReferenceKind::isConcreteUsage)
            ? JavaAbstractionLevel.Abstract
            : JavaAbstractionLevel.Concrete;
    }

    public final boolean isAbstract() {
        return getAbstractionLevel() == JavaAbstractionLevel.Abstract;
    }

    public String getTypedefName() {
        return this.typedefName;
    }

    public String getDescription() {
        return this.description;
    }

    public Collection<TypeRef> getAnnotations() {
        return Collections.emptyList();
    }

    public TypeParameterDiamond getTypeParameters() {
        if (typeParameters.isEmpty()) return null;
        return TypeParameterDiamond.builder().withParams(typeParameters.toArray(new TypeParameterDefinition[0])).build();
    }

    public boolean hasTypeParameters() {
        return !typeParameters.isEmpty();
    }

    public Collection<Field> getTypeParameterSerializerFields() {
        var superTypeParams = Optional.ofNullable(extendsType)
            .flatMap(TypeRef::getTargetShape)
            .map(s -> s.typeParameters)
            .stream()
            .flatMap(List::stream)
            .map(TypeParameterDefinition::getName)
            .collect(Collectors.toSet());
        return typeParameters.stream()
            .filter(t -> !superTypeParams.contains(t.getName()))
            .map(
                t -> Field.builder()
                    .withName(Strings.toCamelCase(t.getName()) + "Serializer")
                    .withType(Types.Client.Json.JsonpSerializer(t.toRef()))
                    .withDescription(
                        "Serializer for {@code "
                            + t.getName()
                            + "}. If not set, an attempt will be made to find a serializer from the JSON context."
                    )
                    .build()
            )
            .collect(Collectors.toList());
    }

    public TypeRef getExtendsType() {
        return extendsType;
    }

    public void setExtendsType(TypeRef extendsType) {
        if (extendsType instanceof ShapeTypeRef) {
            extendsType = ((ShapeTypeRef) extendsType).getSelfType();
        }

        this.extendsType = extendsType;
        tryAddReference(ReferenceKind.Extends, extendsType);
    }

    public TypeRef getExtendsTypeAbstractBuilder() {
        var typeParams = extendsType.getTypeParams();
        if (typeParams == null) typeParams = new TypeRef[0];
        typeParams = Arrays.copyOf(typeParams, typeParams.length + 1);
        typeParams[typeParams.length - 1] = Type.builder().withName(extendedByOtherShape() ? "BuilderT" : "Builder").build();
        return extendsType.getNestedType("AbstractBuilder").withTypeParameters(typeParams);
    }

    public boolean doesExtendType() {
        return extendsType != null;
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

    public Collection<TypeRef> getImplementsTypes() {
        var types = new ArrayList<TypeRef>();

        for (var union : getReferencingDiscriminatedUnions()) {
            types.add(union.getUnion().getVariantInterfaceType());
        }

        return types;
    }

    protected void tryAddReference(ReferenceKind kind, TypeRef to) {
        for (var typeParamRef : to.collectTypeParameterRefs()) {
            if (typeParameters.stream().noneMatch(t -> t.getName().equals(typeParamRef.getName()))) {
                typeParameters.add(TypeParameterDefinition.builder().withName(typeParamRef.getName()).build());
            }
        }

        to.getTargetShape().ifPresent(s -> addReference(kind, s));

        if (to instanceof Type) {
            var t = (Type) to;
            var typeParams = t.getTypeParams();
            if (typeParams != null) {
                for (var typeParam : typeParams) {
                    tryAddReference(ReferenceKind.TypeParameter, typeParam);
                }
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

    public @Nonnull TypeRef getType() {
        return new ShapeTypeRef(this);
    }

    public @Nonnull Type getMaterializedType() {
        var b = Type.builder().withPackage(getPackageName()).withName(className).withTargetShape(this);
        if (!typeParameters.isEmpty()) {
            b.withTypeParameters(typeParameters.stream().map(t -> Types.Client.Json.JsonData).toArray(TypeRef[]::new));
        }
        return b.build();
    }

    public @Nonnull Type getSelfType() {
        var type = getMaterializedType();
        if (typeParameters.isEmpty()) return type;
        return type.withTypeParameters(typeParameters.stream().map(t -> new TypeParameterRef(t.getName())).toArray(TypeRef[]::new));
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
        var renderer = ctx.getTemplateRenderer(b -> b.withFormatter(TypeRef.class, t -> {
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
