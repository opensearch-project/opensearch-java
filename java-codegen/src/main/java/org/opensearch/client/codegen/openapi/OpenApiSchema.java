/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import static org.opensearch.client.codegen.utils.Functional.ifNonnull;

import io.swagger.v3.oas.models.media.Schema;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.utils.Lists;
import org.opensearch.client.codegen.utils.Maps;
import org.opensearch.client.codegen.utils.Sets;

public class OpenApiSchema extends OpenApiRefElement<OpenApiSchema> {
    private static final JsonPointer ANONYMOUS = JsonPointer.of("<anonymous>");

    public static final OpenApiSchema ANONYMOUS_OBJECT = builder().withPointer(ANONYMOUS.append("object"))
        .withTypes(OpenApiSchemaType.Object)
        .build();

    @Nullable
    private final String name;
    @Nullable
    private final String namespace;
    @Nullable
    private final String description;
    @Nullable
    private final Set<OpenApiSchemaType> types;
    @Nullable
    private final OpenApiSchemaFormat format;
    @Nullable
    private final List<OpenApiSchema> allOf;
    @Nullable
    private final List<OpenApiSchema> oneOf;
    @Nullable
    private final List<String> enums;
    @Nullable
    private final OpenApiSchema items;
    @Nullable
    private final OpenApiSchema additionalProperties;
    @Nullable
    private final Map<String, OpenApiSchema> properties;
    @Nullable
    private final Set<String> required;
    @Nullable
    private final String title;
    @Nullable
    private final String pattern;

    private OpenApiSchema(@Nonnull Builder builder) {
        super(builder.parent, Objects.requireNonNull(builder.pointer, "pointer must not be null"), builder.$ref, OpenApiSchema.class);
        name = builder.name;
        namespace = builder.namespace;
        description = builder.description;
        types = builder.types;
        format = builder.format;
        allOf = builder.allOf;
        oneOf = builder.oneOf;
        enums = builder.enums;
        items = builder.items;
        additionalProperties = builder.additionalProperties;
        properties = builder.properties;
        required = builder.required;
        title = builder.title;
        pattern = builder.pattern;
    }

    protected OpenApiSchema(@Nullable OpenApiElement<?> parent, @Nonnull JsonPointer pointer, @Nonnull Schema<?> schema) {
        super(parent, pointer, schema.get$ref(), OpenApiSchema.class);

        if (pointer.isDirectChildOf(JsonPointer.of("components", "schemas"))) {
            var key = pointer.getLastKey().orElseThrow();
            var colonIdx = key.indexOf(':');
            if (colonIdx >= 0) {
                namespace = key.substring(0, colonIdx).replaceAll("\\._common", "").replaceAll("^_common", "_types");
                name = key.substring(colonIdx + 1);
            } else {
                namespace = null;
                name = key;
            }
        } else {
            name = null;
            namespace = null;
        }

        description = schema.getDescription();

        types = Optional.ofNullable(schema.getTypes())
            .flatMap(types -> !types.isEmpty() ? Optional.of(types) : Optional.empty())
            .or(() -> Optional.ofNullable(schema.getType()).map(Set::of))
            .map(types -> types.stream().map(OpenApiSchemaType::from).collect(Collectors.toSet()))
            .orElse(null);

        format = ifNonnull(schema.getFormat(), OpenApiSchemaFormat::from);

        allOf = children("allOf", schema.getAllOf(), OpenApiSchema::new);
        oneOf = children("oneOf", schema.getOneOf(), OpenApiSchema::new);

        enums = ifNonnull(schema.getEnum(), e -> Lists.map(e, String::valueOf));

        items = child("items", schema.getItems(), OpenApiSchema::new);

        additionalProperties = child("additionalProperties", (Schema<?>) schema.getAdditionalProperties(), OpenApiSchema::new);

        properties = children("properties", schema.getProperties(), OpenApiSchema::new);
        required = ifNonnull(schema.getRequired(), HashSet::new);

        title = schema.getTitle();

        pattern = schema.getPattern();
    }

    @Nonnull
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    @Nonnull
    public Optional<String> getNamespace() {
        return Optional.ofNullable(namespace);
    }

    @Nonnull
    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    @Nonnull
    public Optional<Set<OpenApiSchemaType>> getTypes() {
        return Sets.unmodifiableOpt(types);
    }

    @Nonnull
    public Optional<OpenApiSchemaFormat> getFormat() {
        return Optional.ofNullable(format);
    }

    public boolean is(@Nonnull OpenApiSchemaType type) {
        Objects.requireNonNull(type, "type must not be null");
        return types != null && types.contains(type);
    }

    public boolean isArray() {
        return is(OpenApiSchemaType.Array);
    }

    public boolean isBoolean() {
        return is(OpenApiSchemaType.Boolean);
    }

    public boolean isNumber() {
        return is(OpenApiSchemaType.Number);
    }

    public boolean isObject() {
        return is(OpenApiSchemaType.Object);
    }

    public boolean isString() {
        return is(OpenApiSchemaType.String);
    }

    public boolean hasAllOf() {
        return allOf != null && !allOf.isEmpty();
    }

    @Nonnull
    public Optional<List<OpenApiSchema>> getAllOf() {
        return Lists.unmodifiableOpt(allOf);
    }

    public boolean hasOneOf() {
        return oneOf != null && !oneOf.isEmpty();
    }

    @Nonnull
    public Optional<List<OpenApiSchema>> getOneOf() {
        return Lists.unmodifiableOpt(oneOf);
    }

    public boolean hasEnums() {
        return enums != null && !enums.isEmpty();
    }

    @Nonnull
    public Optional<List<String>> getEnums() {
        return Lists.unmodifiableOpt(enums);
    }

    @Nonnull
    public Optional<OpenApiSchema> getItems() {
        return Optional.ofNullable(items);
    }

    @Nonnull
    public Optional<OpenApiSchema> getAdditionalProperties() {
        return Optional.ofNullable(additionalProperties);
    }

    @Nonnull
    public Optional<Map<String, OpenApiSchema>> getProperties() {
        return Maps.unmodifiableOpt(properties);
    }

    @Nonnull
    public Optional<Set<String>> getRequired() {
        return Sets.unmodifiableOpt(required);
    }

    @Nonnull
    public Optional<String> getTitle() {
        return Optional.ofNullable(title);
    }

    @Nonnull
    public Optional<String> getPattern() {
        return Optional.ofNullable(pattern);
    }

    @Nonnull
    public Set<OpenApiSchemaType> determineTypes() {
        if (types != null) {
            return Set.copyOf(types);
        } else if (has$ref()) {
            return resolve().determineTypes();
        } else if (allOf != null) {
            var types = allOf.stream().map(OpenApiSchema::determineTypes).flatMap(Set::stream).collect(Collectors.toSet());
            if (types.size() > 1) {
                var typeString = types.stream().map(OpenApiSchemaType::toString).collect(Collectors.joining(", "));
                throw new IllegalStateException("allOf schema must have a uniform type [" + getPointer() + "]: " + typeString);
            }
            return types;
        } else if (oneOf != null) {
            return oneOf.stream().map(OpenApiSchema::determineTypes).flatMap(Set::stream).collect(Collectors.toSet());
        }

        throw new IllegalStateException("Cannot determine type for schema: " + getPointer());
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        @Nullable
        private OpenApiElement<?> parent;
        @Nullable
        private JsonPointer pointer;
        @Nullable
        private String $ref;
        @Nullable
        private String name;
        @Nullable
        private String namespace;
        @Nullable
        private String description;
        @Nullable
        private Set<OpenApiSchemaType> types;
        @Nullable
        private OpenApiSchemaFormat format;
        @Nullable
        private List<OpenApiSchema> allOf;
        @Nullable
        private List<OpenApiSchema> oneOf;
        @Nullable
        private List<String> enums;
        @Nullable
        private OpenApiSchema items;
        @Nullable
        private OpenApiSchema additionalProperties;
        @Nullable
        private Map<String, OpenApiSchema> properties;
        @Nullable
        private Set<String> required;
        @Nullable
        private String title;
        @Nullable
        private String pattern;

        @Nonnull
        public Builder withPointer(@Nonnull JsonPointer pointer) {
            this.pointer = Objects.requireNonNull(pointer, "pointer must not be null");
            return this;
        }

        @Nonnull
        public Builder withTypes(OpenApiSchemaType... types) {
            return withTypes(Set.of(types));
        }

        @Nonnull
        public Builder withTypes(@Nullable Set<OpenApiSchemaType> types) {
            this.types = types;
            return this;
        }

        @Nonnull
        public Builder withAllOf(OpenApiSchema... allOf) {
            return withAllOf(List.of(allOf));
        }

        @Nonnull
        public Builder withAllOf(@Nullable List<OpenApiSchema> allOf) {
            this.allOf = allOf;
            return this;
        }

        @Nonnull
        public OpenApiSchema build() {
            return new OpenApiSchema(this);
        }
    }
}
