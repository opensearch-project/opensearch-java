/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import org.opensearch.client.codegen.utils.JavaClassKind;
import org.opensearch.client.codegen.utils.Strings;

public class EnumShape extends Shape {
    private final TreeMap<String, Variant> variants = new TreeMap<>();

    public EnumShape(Namespace parent, String className, String typedefName, String description) {
        super(parent, className, typedefName, description);
    }

    @Override
    public JavaClassKind getClassKind() {
        return JavaClassKind.Enum;
    }

    @Override
    public Collection<Type> getAnnotations() {
        return List.of(Types.Client.Json.JsonpDeserializable);
    }

    @Override
    public Collection<Type> getImplementsTypes() {
        return List.of(Types.Client.Json.JsonEnum);
    }

    public void addVariant(String value, boolean deprecated) {
        var variant = variants.get(value.toLowerCase());
        if (variant == null) {
            variant = new Variant(value, deprecated);
            variants.put(value.toLowerCase(), variant);
        } else {
            variant.addAlias(value);
            variant.setDeprecated(variant.isDeprecated() || deprecated);
        }
    }

    public Collection<Variant> getVariants() {
        return variants.values();
    }

    public boolean anyHasAliases() {
        return variants.values().stream().anyMatch(v -> !v.getAliases().isEmpty());
    }

    public static class Variant {
        private final String wireName;
        private final Set<String> aliases = new HashSet<>();
        private boolean deprecated;

        public Variant(String wireName, boolean deprecated) {
            this.wireName = wireName;
            this.deprecated = deprecated;
        }

        public String getWireName() {
            return wireName;
        }

        public Set<String> getAliases() {
            return aliases;
        }

        public void addAlias(String alias) {
            aliases.add(alias);
        }

        public String getName() {
            return Strings.toPascalCase(wireName);
        }

        public boolean isDeprecated() {
            return deprecated;
        }

        public void setDeprecated(boolean deprecated) {
            this.deprecated = deprecated;
        }
    }
}
