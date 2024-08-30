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
import org.opensearch.client.codegen.utils.Lists;

public class TaggedUnionShape extends ObjectShape {
    private final List<Variant> variants = new ArrayList<>();

    public TaggedUnionShape(Namespace parent, String className, String typedefName, String description) {
        super(parent, className, typedefName, description);
    }

    public void addVariant(String name, Type type) {
        variants.add(new Variant(name, type.getBoxed()));
    }

    public Collection<Variant> getVariants() {
        return variants;
    }

    public Collection<Variant> getPrimitiveVariants() {
        return Lists.filter(variants, v -> v.getType().isPrimitive());
    }

    @Override
    public Collection<Type> getAnnotations() {
        return List.of(Types.Client.Json.JsonpDeserializable);
    }

    @Override
    public Collection<Type> getImplementsTypes() {
        return List.of(
            Types.Client.Util.TaggedUnion(getType().getNestedType("Kind"), Types.Java.Lang.Object),
            Types.Client.Json.JsonpSerializable
        );
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
    }
}
