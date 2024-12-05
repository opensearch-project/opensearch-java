/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.model.overrides.ShouldGenerate;
import org.opensearch.client.codegen.utils.JavaClassKind;
import org.opensearch.client.codegen.utils.Markdown;
import org.opensearch.client.codegen.utils.Strings;

public class EnumShape extends Shape {
    private final TreeMap<String, Variant> variants = new TreeMap<>();

    public EnumShape(Namespace parent, String className, String typedefName, String description, ShouldGenerate shouldGenerate) {
        super(parent, className, typedefName, description, shouldGenerate);
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

    public void addVariant(String name, String value, String description, boolean deprecated) {
        name = name.toLowerCase();
        var variant = variants.get(name);
        if (variant == null) {
            variant = new Variant(name, value, description, deprecated);
            variants.put(name, variant);
        } else {
            variant.addAlias(value);
            variant.setDeprecated(variant.isDeprecated() || deprecated);
            if (description != null) {
                variant.setDescription(description);
            }
        }
    }

    public Collection<Variant> getVariants() {
        return variants.values();
    }

    public boolean anyHasAliases() {
        return variants.values().stream().anyMatch(v -> !v.getAliases().isEmpty());
    }

    public static class Variant {
        private final String name;
        private final String wireName;
        private final Set<String> aliases = new LinkedHashSet<>();
        private boolean deprecated;
        private String description;

        public Variant(String name, String wireName, String description, boolean deprecated) {
            this.name = name;
            this.wireName = wireName;
            setDescription(description);
            this.deprecated = deprecated;
        }

        public String getWireName() {
            return wireName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(@Nullable String description) {
            this.description = description != null ? Markdown.toJavaDocHtml(description) : null;
        }

        public Set<String> getAliases() {
            return aliases;
        }

        public void addAlias(String alias) {
            aliases.add(alias);
        }

        public String getName() {
            return Strings.toPascalCase(name);
        }

        public boolean isDeprecated() {
            return deprecated;
        }

        public void setDeprecated(boolean deprecated) {
            this.deprecated = deprecated;
        }
    }
}
