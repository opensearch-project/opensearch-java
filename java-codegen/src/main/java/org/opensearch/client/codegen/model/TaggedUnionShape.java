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
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.opensearch.client.codegen.exceptions.RenderException;
import org.opensearch.client.codegen.model.types.Type;
import org.opensearch.client.codegen.model.types.TypeRef;
import org.opensearch.client.codegen.model.types.Types;
import org.opensearch.client.codegen.renderer.ShapeRenderingContext;
import org.opensearch.client.codegen.transformer.overrides.ShouldGenerate;
import org.opensearch.client.codegen.utils.JavaClassKind;
import org.opensearch.client.codegen.utils.Lists;
import org.opensearch.client.codegen.utils.Strings;

public class TaggedUnionShape extends ObjectShapeBase {
    private final Map<String, Variant> variants = new TreeMap<>();
    @Nullable
    private String discriminatingField;
    private String defaultVariant;
    private ExternallyDiscriminated externallyDiscriminated;

    public TaggedUnionShape(Namespace parent, String className, String typedefName, String description, ShouldGenerate shouldGenerate) {
        super(parent, className, typedefName, description, shouldGenerate);
    }

    public void addVariant(String name, TypeRef type) {
        variants.put(name, new Variant(name, type.getBoxed()));
        tryAddReference(ReferenceKind.UnionVariant, type);
    }

    public Collection<Variant> getVariants() {
        return variants.values();
    }

    public Collection<Variant> getNonShapeVariants() {
        return Lists.filter(getVariants(), v -> !v.getType().isInsidePackage("org.opensearch"));
    }

    public void setDefaultVariant(String name) {
        this.defaultVariant = name;
    }

    public Variant getDefaultVariant() {
        return variants.get(this.defaultVariant != null ? this.defaultVariant : "custom");
    }

    @Override
    public Collection<TypeRef> getAnnotations() {
        return !usesTypedKeys() && !hasTypeParameters() ? List.of(Types.Client.Json.JsonpDeserializable) : List.of();
    }

    @Override
    public Collection<TypeRef> getImplementsTypes() {
        var types = new ArrayList<TypeRef>();
        types.add(Types.Client.Util.TaggedUnion(getMaterializedType().getNestedType("Kind"), getVariantBaseType()));
        types.addAll(super.getImplementsTypes());
        types.add(Types.Client.Json.PlainJsonSerializable);
        return types;
    }

    public boolean isDiscriminated() {
        return isInternallyDiscriminated() || isExternallyDiscriminated();
    }

    public boolean isInternallyDiscriminated() {
        return discriminatingField != null;
    }

    public void setDiscriminatingField(@Nullable String field) {
        this.discriminatingField = field;
    }

    @Nullable
    public String getDiscriminatingField() {
        return discriminatingField;
    }

    public boolean isExternallyDiscriminated() {
        return externallyDiscriminated != null;
    }

    public boolean isOptionalExternallyDiscriminated() {
        return externallyDiscriminated == ExternallyDiscriminated.OPTIONAL;
    }

    public boolean usesTypedKeys() {
        return externallyDiscriminated == ExternallyDiscriminated.TYPED_KEYS;
    }

    public void setExternallyDiscriminated(ExternallyDiscriminated externallyDiscriminated) {
        this.externallyDiscriminated = externallyDiscriminated;
    }

    public Type getVariantBaseType() {
        return isDiscriminated() && getVariants().stream().map(Variant::getType).allMatch(t -> t.getTargetShape().isPresent())
            ? getVariantInterfaceType()
            : Types.Java.Lang.Object;
    }

    public Type getVariantInterfaceType() {
        return Type.builder().withPackage(getPackageName()).withName(getClassName() + "Variant").build();
    }

    public boolean canStringify() {
        return !isDiscriminated() && getVariants().stream().allMatch(v -> v.getType().canQueryParamify());
    }

    public boolean hasAmbiguities() {
        if (isDiscriminated()) {
            return false;
        }

        return countStringOrEnumVariants() > 1;
    }

    private long countStringOrEnumVariants() {
        return getVariants().stream().filter(v -> {
            var t = v.getType();
            if (t.isString() || t.isEnum()) {
                return true;
            }
            return t.getTargetShape()
                .filter(shape -> shape instanceof TaggedUnionShape && ((TaggedUnionShape) shape).countStringOrEnumVariants() > 0)
                .isPresent();
        }).count();
    }

    public Collection<BuilderSetter> getContainerBuilderSetters() {
        var builderT = Type.builder().withName("ContainerBuilder").build();
        return getFields(true, false, true).stream().map(f -> new BuilderSetter(builderT, "Builder.this", f)).collect(Collectors.toList());
    }

    public boolean needsContainerBuilder() {
        return hasFields(true, false, true);
    }

    @Override
    public boolean hasFields() {
        return true;
    }

    @Override
    public Collection<Field> getHashableFields() {
        var fields = new ArrayList<Field>();
        fields.add(Field.builder().withName("_kind", true).withType(getMaterializedType().getNestedType("Kind")).build());
        fields.add(Field.builder().withName("_value", true).withType(getVariantBaseType()).build());
        fields.addAll(super.getHashableFields());
        return fields;
    }

    @Override
    public void render(ShapeRenderingContext ctx) throws RenderException {
        if (!shouldGenerate()) {
            return;
        }
        super.render(ctx);
        var buildableVariants = Lists.filter(getVariants(), v -> v.getType().hasBuilder());
        if (!buildableVariants.isEmpty()) {
            new Builders(this, buildableVariants, ShouldGenerate.Always).render(ctx);
        }
        if (isDiscriminated()) {
            new VariantInterface(this, ShouldGenerate.Always).render(ctx);
        }
    }

    public static class Variant {
        private final String name;
        private final TypeRef type;

        protected Variant(String name, TypeRef type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public TypeRef getType() {
            return type;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("name", name).append("type", type).toString();
        }
    }

    public static class Builders extends Shape {
        private static String buildDescription(TaggedUnionShape union) {
            var desc = "Builders for {@link " + union.getClassName() + "} variants.";
            var nonShapeVariants = union.getNonShapeVariants();
            if (!nonShapeVariants.isEmpty()) {
                desc += "\n\nVariants ";
                desc += Strings.join(nonShapeVariants, ", ", v -> "`" + v.getName() + "`");
                desc += " are not available here as they don't have a dedicated class. Use {@link "
                    + union.getClassName()
                    + "}'s builder for these.";
            }
            return desc;
        }

        private final TaggedUnionShape union;
        private final Collection<Variant> variants;

        private Builders(TaggedUnionShape union, Collection<Variant> variants, ShouldGenerate shouldGenerate) {
            super(union.getParent(), union.getClassName() + "Builders", null, buildDescription(union), shouldGenerate);
            this.union = union;
            this.variants = variants;
        }

        public TaggedUnionShape getUnion() {
            return union;
        }

        public Collection<Variant> getVariants() {
            return variants;
        }

        @Override
        public String getTemplateName() {
            return "TaggedUnionShape/Builders";
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("union", union).append("variants", variants).toString();
        }
    }

    public static class VariantInterface extends Shape {
        private final String unionClassName;
        private final boolean includeToUnionMethod;

        private VariantInterface(TaggedUnionShape union, ShouldGenerate shouldGenerate) {
            super(
                union.getParent(),
                union.getClassName() + "Variant",
                null,
                "Base interface for {@link " + union.getClassName() + "} variants.",
                shouldGenerate
            );
            unionClassName = union.getClassName();
            if (union.isInternallyDiscriminated()) {
                setExtendsType(Types.Client.Json.JsonpSerializable);
            }
            includeToUnionMethod = !union.hasAnyRequiredFields() && !union.extendsOtherShape();
        }

        @Override
        public JavaClassKind getClassKind() {
            return JavaClassKind.Interface;
        }

        public String getUnionClassName() {
            return unionClassName;
        }

        public boolean includeToUnionMethod() {
            return includeToUnionMethod;
        }

        @Override
        public String getTemplateName() {
            return "TaggedUnionShape/VariantInterface";
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("unionClassName", unionClassName).toString();
        }
    }

    public enum ExternallyDiscriminated {
        OPTIONAL,
        REQUIRED,
        TYPED_KEYS
    }
}
