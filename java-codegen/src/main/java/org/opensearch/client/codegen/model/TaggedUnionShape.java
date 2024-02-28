/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.ArrayList;
import java.util.List;

public class TaggedUnionShape extends ObjectShape {
    private final List<Variant> variants = new ArrayList<>();

    public TaggedUnionShape(Namespace parent, String className, String typedefName) {
        super(parent, className, typedefName);
    }

    public void addVariant(String name, Type type) {
        variants.add(new Variant(name, type));
    }

    public List<Variant> getVariants() {
        return variants;
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
