/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.opensearch.client.codegen.exceptions.RenderException;
import org.opensearch.client.codegen.utils.JavaClassKind;
import org.opensearch.client.codegen.utils.Lists;
import org.opensearch.client.codegen.utils.Strings;

public class TaggedUnionShape extends Shape {
    private final Map<String, Variant> variants = new TreeMap<>();
    private final String discriminatingField;

    public TaggedUnionShape(Namespace parent, String className, String typedefName, String description, String discriminatingField) {
        super(parent, className, typedefName, description);
        this.discriminatingField = discriminatingField;
    }

    public void addVariant(String name, Type type) {
        variants.put(name, new Variant(name, type.getBoxed()));
        tryAddReference(ReferenceKind.UnionVariant, type);
    }

    public Collection<Variant> getVariants() {
        return variants.values();
    }

    public Collection<Variant> getNonShapeVariants() {
        return Lists.filter(getVariants(), v -> !v.getType().isInsidePackage("org.opensearch"));
    }

    public Variant getDefaultVariant() {
        return variants.get("custom");
    }

    @Override
    public Collection<Type> getAnnotations() {
        return List.of(Types.Client.Json.JsonpDeserializable);
    }

    @Override
    public Collection<Type> getImplementsTypes() {
        return List.of(
            Types.Client.Util.TaggedUnion(getType().getNestedType("Kind"), getVariantBaseType()),
            Types.Client.Json.PlainJsonSerializable
        );
    }

    public boolean isDiscriminated() {
        return discriminatingField != null;
    }

    public String getDiscriminatingField() {
        return discriminatingField;
    }

    public Type getVariantBaseType() {
        return isDiscriminated()
            ? Type.builder().withPackage(getPackageName()).withName(getClassName() + "Variant").build()
            : Types.Java.Lang.Object;
    }

    public boolean canStringify() {
        return !isDiscriminated() && getVariants().stream().allMatch(v -> {
            var t = v.getType();
            return t.isPotentiallyBoxedPrimitive() || t.isString() || t.isEnum();
        });
    }

    public boolean hasAmbiguities() {
        if (isDiscriminated()) {
            return false;
        }

        return getVariants().stream().filter(v -> {
            var t = v.getType();
            return t.isString() || t.isEnum();
        }).count() > 1;
    }

    @Override
    public void render(ShapeRenderingContext ctx) throws RenderException {
        super.render(ctx);
        var buildableVariants = Lists.filter(getVariants(), v -> v.getType().hasBuilder());
        if (!buildableVariants.isEmpty()) {
            new Builders(this, buildableVariants).render(ctx);
        }
        if (isDiscriminated()) {
            new VariantInterface(this).render(ctx);
        }
    }

    public static class Variant {
        private final String name;
        private final Type type;

        protected Variant(String name, Type type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public Type getType() {
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

        private final String unionClassName;
        private final Collection<Variant> variants;

        private Builders(TaggedUnionShape union, Collection<Variant> variants) {
            super(union.getParent(), union.getClassName() + "Builders", null, buildDescription(union));
            this.variants = variants;
            unionClassName = union.getClassName();
        }

        public String getUnionClassName() {
            return unionClassName;
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
            return new ToStringBuilder(this).append("unionClassName", unionClassName).append("variants", variants).toString();
        }
    }

    public static class VariantInterface extends Shape {
        private final String unionClassName;

        private VariantInterface(TaggedUnionShape union) {
            super(
                union.getParent(),
                union.getClassName() + "Variant",
                null,
                "Base interface for {@link " + union.getClassName() + "} variants."
            );
            unionClassName = union.getClassName();
            setExtendsType(Types.Client.Json.JsonpSerializable);
        }

        @Override
        public JavaClassKind getClassKind() {
            return JavaClassKind.Interface;
        }

        public String getUnionClassName() {
            return unionClassName;
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
}
