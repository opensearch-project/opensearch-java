/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.utils.Markdown;
import org.opensearch.client.codegen.utils.NameSanitizer;
import org.opensearch.client.codegen.utils.Strings;
import org.opensearch.client.codegen.utils.builder.ObjectBuilder;
import org.opensearch.client.codegen.utils.builder.ObjectBuilderBase;
import org.opensearch.client.codegen.utils.builder.SetBuilder;

public class Field {
    @Nullable
    private final String wireName;
    @Nonnull
    private final String name;
    @Nonnull
    private final Type type;
    private final boolean required;
    @Nullable
    private final String description;
    @Nullable
    private final Deprecation deprecation;
    @Nullable
    private final Set<String> aliases;

    private Field(@Nonnull Builder builder) {
        Objects.requireNonNull(builder, "builder must not be null");
        if (builder.wireName != null) {
            this.wireName = Strings.requireNonBlank(builder.wireName, "wireName must not be blank");
            this.name = builder.name != null
                ? Strings.requireNonBlank(builder.name, "name must not be blank")
                : NameSanitizer.fieldName(wireName);
        } else {
            this.wireName = null;
            this.name = NameSanitizer.fieldName(Strings.requireNonBlank(builder.name, "name must not be blank"));
        }
        this.type = Objects.requireNonNull(builder.type, "type must not be null");
        this.required = builder.required;
        this.description = builder.description != null ? Markdown.toJavaDocHtml(builder.description) : null;
        this.deprecation = builder.deprecation;
        this.aliases = builder.aliases;
    }

    @Nullable
    public String getWireName() {
        return wireName;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    @Nonnull
    public Type getType() {
        return required ? type : type.getBoxed();
    }

    public boolean isRequired() {
        return required;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    @Nullable
    public Deprecation getDeprecation() {
        return deprecation;
    }

    @Nonnull
    public Set<String> getAliases() {
        return aliases != null ? Collections.unmodifiableSet(aliases) : Collections.emptySet();
    }

    public boolean needsJavaDocSummary() {
        return required || description != null || wireName != null;
    }

    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends ObjectBuilderBase<Field, Builder> {
        private String wireName;
        private String name;
        private Type type;
        private boolean required;
        private String description;
        private Deprecation deprecation;
        private Set<String> aliases;

        private Builder() {}

        private Builder(Field f) {
            this.wireName = f.wireName;
            this.name = f.name;
            this.type = f.type;
            this.required = f.required;
            this.description = f.description;
            this.deprecation = f.deprecation;
            this.aliases = f.aliases != null ? new HashSet<>(f.aliases) : null;
        }

        @Nonnull
        @Override
        protected Field construct() {
            return new Field(this);
        }

        @Nonnull
        public Builder withWireName(@Nullable String wireName) {
            this.wireName = wireName;
            return this;
        }

        @Nonnull
        public Builder withName(@Nullable String name) {
            this.name = name;
            return this;
        }

        @Nonnull
        public Builder withType(@Nullable Type type) {
            this.type = type;
            return this;
        }

        @Nonnull
        public Builder withRequired(boolean required) {
            this.required = required;
            return this;
        }

        @Nonnull
        public Builder withDescription(@Nullable String description) {
            this.description = description;
            return this;
        }

        @Nonnull
        public Builder withDeprecation(@Nullable Deprecation deprecation) {
            this.deprecation = deprecation;
            return this;
        }

        @Nonnull
        public Builder withAliases(@Nonnull Function<SetBuilder<String>, ObjectBuilder<Set<String>>> fn) {
            this.aliases = Objects.requireNonNull(fn, "fn must not be null").apply(new SetBuilder<>()).build();
            return this;
        }
    }
}
