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
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.utils.Clone;
import org.opensearch.client.codegen.utils.Lists;
import org.opensearch.client.codegen.utils.Maps;
import org.opensearch.client.codegen.utils.Sets;
import org.opensearch.client.codegen.utils.Strings;
import org.opensearch.client.codegen.utils.Versions;
import org.opensearch.client.codegen.utils.builder.ListBuilder;
import org.opensearch.client.codegen.utils.builder.ObjectBuilder;
import org.opensearch.client.codegen.utils.builder.ObjectListBuilderBase;
import org.opensearch.client.codegen.utils.builder.ObjectMapBuilderBase;
import org.opensearch.client.codegen.utils.builder.SetBuilder;
import org.opensearch.client.codegen.utils.builder.ToBuilder;
import org.semver4j.Semver;

public class OpenApiSchema extends OpenApiRefElement<OpenApiSchema> implements ToBuilder<OpenApiSchema.Builder> {
    public static final String NAMESPACE_NAME_SEPARATOR = "___";
    public static final JsonPointer COMPONENTS_SCHEMAS = JsonPointer.of("components", "schemas");

    public static OpenApiSchema untyped() {
        return builder().build();
    }

    public static OpenApiSchema emptyObject() {
        return builder().withTypes(t -> t.with(OpenApiSchemaType.Object)).build();
    }

    public static OpenApiSchema string() {
        return builder().withTypes(t -> t.with(OpenApiSchemaType.String)).build();
    }

    @Nullable
    private String name;
    @Nullable
    private String namespace;
    @Nullable
    private String description;
    @Nullable
    private Set<OpenApiSchemaType> types;
    @Nullable
    private final OpenApiSchemaFormat format;
    @Nullable
    private List<OpenApiSchema> allOf;
    @Nullable
    private List<OpenApiSchema> anyOf;
    @Nullable
    private List<OpenApiSchema> oneOf;
    @Nullable
    private final List<String> enums;
    @Nullable
    private OpenApiSchema items;
    @Nullable
    private OpenApiSchema propertyNames;
    @Nullable
    private OpenApiSchema additionalProperties;
    @Nullable
    private Map<String, OpenApiSchema> properties;
    @Nullable
    private Integer minProperties;
    @Nullable
    private final Integer maxProperties;
    @Nullable
    private Set<String> required;
    @Nullable
    private final String title;
    @Nullable
    private final String pattern;
    @Nullable
    private OpenApiDiscriminator discriminator;
    @Nullable
    private final Object constValue;
    @Nullable
    private final Semver versionRemoved;
    @Nullable
    private final Semver versionDeprecated;
    @Nullable
    private final Boolean supportsTypedKeys;
    @Nullable
    private Boolean isGenericTypeParameter;
    @Nullable
    private OpenApiSchema $extends;
    private boolean isGeneric;
    private boolean isInstantiatedGeneric;

    private OpenApiSchema(@Nonnull Builder builder) {
        super(builder, OpenApiSchema.class);
        name = builder.name;
        namespace = builder.namespace;
        description = builder.description;
        types = builder.types;
        format = builder.format;
        setAllOf(builder.allOf);
        setAnyOf(builder.anyOf);
        setOneOf(builder.oneOf);
        enums = builder.enums;
        setItems(builder.items);
        setPropertyNames(builder.propertyNames);
        setAdditionalProperties(builder.additionalProperties);
        setProperties(builder.properties);
        minProperties = builder.minProperties;
        maxProperties = builder.maxProperties;
        required = builder.required;
        title = builder.title;
        pattern = builder.pattern;
        setDiscriminator(builder.discriminator);
        constValue = builder.constValue;
        versionRemoved = builder.versionRemoved;
        versionDeprecated = builder.versionDeprecated;
        supportsTypedKeys = builder.supportsTypedKeys;
        isGenericTypeParameter = builder.isGenericTypeParameter;
        set$extends(builder.$extends);
    }

    OpenApiSchema(@Nonnull Schema<?> schema) {
        super(schema.get$ref(), OpenApiSchema.class);
        description = schema.getDescription();

        types = Optional.ofNullable(schema.getTypes())
            .flatMap(types -> !types.isEmpty() ? Optional.of(types) : Optional.empty())
            .or(() -> Optional.ofNullable(schema.getType()).map(Set::of))
            .map(types -> types.stream().map(OpenApiSchemaType::from).collect(Collectors.toSet()))
            .orElse(null);

        format = ifNonnull(schema.getFormat(), OpenApiSchemaFormat::from);

        setAllOf(children(schema.getAllOf(), OpenApiSchema::new));
        setAnyOf(children(schema.getAnyOf(), OpenApiSchema::new));
        setOneOf(children(schema.getOneOf(), OpenApiSchema::new));

        enums = ifNonnull(schema.getEnum(), e -> Lists.map(e, String::valueOf));

        setItems(ifNonnull(schema.getItems(), OpenApiSchema::new));

        setPropertyNames(ifNonnull(schema.getPropertyNames(), OpenApiSchema::new));

        setAdditionalProperties(ifNonnull((Schema<?>) schema.getAdditionalProperties(), OpenApiSchema::new));

        setProperties(children(schema.getProperties(), OpenApiSchema::new));

        minProperties = schema.getMinProperties();
        maxProperties = schema.getMaxProperties();

        required = ifNonnull(schema.getRequired(), HashSet::new);

        title = schema.getTitle();

        pattern = schema.getPattern();

        setDiscriminator(ifNonnull(schema.getDiscriminator(), OpenApiDiscriminator::new));

        constValue = schema.getConst();

        var extensions = schema.getExtensions();

        versionRemoved = Maps.tryGet(extensions, "x-version-removed").map(v -> Versions.coerce((String) v)).orElse(null);
        versionDeprecated = Maps.tryGet(extensions, "x-version-deprecated").map(v -> Versions.coerce((String) v)).orElse(null);

        supportsTypedKeys = Maps.tryGet(extensions, "x-supports-typed-keys").map(Boolean.class::cast).orElse(null);
        isGenericTypeParameter = Maps.tryGet(extensions, "x-is-generic-type-parameter").map(Boolean.class::cast).orElse(null);
    }

    @Override
    void initialize(@Nullable OpenApiElement<?> parent, @Nonnull JsonPointer pointer) {
        super.initialize(parent, pointer);

        if (pointer.isDirectChildOf(COMPONENTS_SCHEMAS)) {
            var key = pointer.getLastKey().orElseThrow();
            var separatorIndex = key.indexOf(NAMESPACE_NAME_SEPARATOR);
            if (separatorIndex >= 0) {
                namespace = key.substring(0, separatorIndex)
                    .replaceAll("\\._common", "")
                    .replaceAll("^_common", "_types")
                    .replaceAll("^_core", "core");
                name = key.substring(separatorIndex + NAMESPACE_NAME_SEPARATOR.length());
            } else {
                namespace = null;
                name = key;
            }
        } else {
            namespace = null;
            name = null;
        }

        initializeChildren("allOf", allOf);
        initializeChildren("anyOf", anyOf);
        initializeChildren("oneOf", oneOf);
        initializeChild("items", items);
        initializeChild("propertyNames", propertyNames);
        initializeChild("additionalProperties", additionalProperties);
        initializeChildren("properties", properties);
        initializeChild("discriminator", discriminator);
        initializeChild("$extends", $extends);
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

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    @Nonnull
    public Optional<String> getResolvedDescription() {
        return getResolved(s -> s.description);
    }

    private <T> Optional<T> getResolved(Function<OpenApiSchema, T> getter) {
        var value = getter.apply(this);
        if (value != null) {
            return Optional.of(value);
        }
        if (has$ref()) {
            return resolve().getResolved(getter);
        }
        return Optional.empty();
    }

    @Nonnull
    public Optional<Set<OpenApiSchemaType>> getTypes() {
        return Sets.unmodifiableOpt(types);
    }

    public void setTypes(@Nullable Set<OpenApiSchemaType> types) {
        this.types = types;
    }

    @Nonnull
    public Optional<OpenApiSchemaType> getSingleType() {
        return getTypes().flatMap(types -> types.size() == 1 ? Optional.of(types.iterator().next()) : Optional.empty());
    }

    @Nonnull
    public Optional<OpenApiSchemaFormat> getFormat() {
        return Optional.ofNullable(format);
    }

    public boolean is(@Nonnull OpenApiSchemaType type) {
        Objects.requireNonNull(type, "type must not be null");
        return getSingleType().map(type::equals).orElse(false);
    }

    public boolean isArray() {
        return is(OpenApiSchemaType.Array);
    }

    public boolean isBoolean() {
        return is(OpenApiSchemaType.Boolean);
    }

    public boolean isInteger() {
        return is(OpenApiSchemaType.Integer);
    }

    public boolean isNull() {
        return is(OpenApiSchemaType.Null);
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

    public void setAllOf(@Nullable List<OpenApiSchema> allOf) {
        this.allOf = allOf;
        initializeChildren("allOf", allOf);
    }

    public boolean hasAnyOf() {
        return anyOf != null && !anyOf.isEmpty();
    }

    @Nonnull
    public Optional<List<OpenApiSchema>> getAnyOf() {
        return Lists.unmodifiableOpt(anyOf);
    }

    public void setAnyOf(@Nullable List<OpenApiSchema> anyOf) {
        this.anyOf = anyOf;
        initializeChildren("anyOf", anyOf);
    }

    public boolean hasOneOf() {
        return oneOf != null && !oneOf.isEmpty();
    }

    @Nonnull
    public Optional<List<OpenApiSchema>> getOneOf() {
        return Lists.unmodifiableOpt(oneOf);
    }

    public void setOneOf(@Nullable List<OpenApiSchema> oneOf) {
        this.oneOf = oneOf;
        initializeChildren("oneOf", oneOf);
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

    public void setItems(@Nullable OpenApiSchema items) {
        this.items = items;
        initializeChild("items", items);
    }

    @Nonnull
    public Optional<OpenApiSchema> getPropertyNames() {
        return Optional.ofNullable(propertyNames);
    }

    public boolean hasPropertyNames() {
        return propertyNames != null;
    }

    public void setPropertyNames(@Nullable OpenApiSchema propertyNames) {
        this.propertyNames = propertyNames;
        initializeChild("propertyNames", propertyNames);
    }

    @Nonnull
    public Optional<OpenApiSchema> getAdditionalProperties() {
        return Optional.ofNullable(additionalProperties);
    }

    public void setAdditionalProperties(@Nullable OpenApiSchema additionalProperties) {
        this.additionalProperties = additionalProperties;
        initializeChild("additionalProperties", additionalProperties);
    }

    public boolean hasAdditionalProperties() {
        return additionalProperties != null;
    }

    public boolean isAdditionalPropertiesSingleton() {
        if (!hasAdditionalProperties()) {
            return false;
        }
        var minProperties = getMinProperties().orElse(0);
        var requiredCount = getRequired().map(Set::size).orElse(0);
        return minProperties - requiredCount == 1;
    }

    @Nonnull
    public Optional<Map<String, OpenApiSchema>> getProperties() {
        return Maps.unmodifiableOpt(properties);
    }

    public boolean hasProperties() {
        return properties != null && !properties.isEmpty();
    }

    public void setProperties(@Nullable Map<String, OpenApiSchema> properties) {
        this.properties = properties;
        initializeChildren("properties", properties);
    }

    @Nonnull
    public OptionalInt getMinProperties() {
        return minProperties != null ? OptionalInt.of(minProperties) : OptionalInt.empty();
    }

    public void setMinProperties(@Nullable Integer minProperties) {
        this.minProperties = minProperties;
    }

    @Nonnull
    public OptionalInt getMaxProperties() {
        return maxProperties != null ? OptionalInt.of(maxProperties) : OptionalInt.empty();
    }

    @Nonnull
    public Optional<Set<String>> getRequired() {
        return Sets.unmodifiableOpt(required);
    }

    public void setRequired(@Nullable Set<String> required) {
        this.required = required;
    }

    public boolean hasTitle() {
        return !Strings.isNullOrBlank(title);
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
    public Optional<OpenApiDiscriminator> getDiscriminator() {
        return Optional.ofNullable(discriminator);
    }

    public void setDiscriminator(@Nullable OpenApiDiscriminator discriminator) {
        this.discriminator = discriminator;
        initializeChild("discriminator", discriminator);
    }

    public boolean hasConst() {
        return constValue != null;
    }

    @Nonnull
    public Optional<Object> getConst() {
        return Optional.ofNullable(constValue);
    }

    @Nonnull
    public Optional<Semver> getVersionRemoved() {
        return Optional.ofNullable(versionRemoved);
    }

    @Nonnull
    public Optional<Semver> getResolvedVersionRemoved() {
        return getResolved(s -> s.versionRemoved);
    }

    @Nonnull
    public Optional<Semver> getVersionDeprecated() {
        return Optional.ofNullable(versionDeprecated);
    }

    public boolean supportsTypedKeys() {
        return supportsTypedKeys != null && supportsTypedKeys;
    }

    public boolean isGenericTypeParameter() {
        return isGenericTypeParameter != null && isGenericTypeParameter;
    }

    public void setIsGenericTypeParameter(@Nullable Boolean value) {
        isGenericTypeParameter = value;
    }

    private Boolean isTaggedUnion;

    public boolean isTaggedUnion() {
        if (isTaggedUnion == null) {
            isTaggedUnion = isTaggedUnionInner();
        }
        return isTaggedUnion;
    }

    private boolean isTaggedUnionInner() {
        if (oneOf != null) {
            if (discriminator != null) {
                return true;
            }
            return isTaggedUnion(oneOf) || isExternallyTaggedUnion(oneOf);
        }
        if (anyOf != null) {
            return isTaggedUnion(anyOf);
        }
        if (allOf != null) {
            if (allOf.size() != 2) {
                return false;
            }

            var first = allOf.get(0);
            var second = allOf.get(1);

            if (first.has$ref() && second.isTaggedUnion()) {
                return true;
            }

            return first.isTaggedUnion() && second.isObject() || first.isObject() && second.isTaggedUnion();
        }

        return isExternallyTaggedUnion();
    }

    private static boolean isTaggedUnion(List<OpenApiSchema> oneOfAnyOf) {
        return oneOfAnyOf.stream().allMatch(OpenApiSchema::hasTitle);
    }

    private Boolean isExternallyTaggedUnion;

    public boolean isExternallyTaggedUnion() {
        if (isExternallyTaggedUnion == null) {
            isExternallyTaggedUnion = isExternallyTaggedUnionInner();
        }
        return isExternallyTaggedUnion;
    }

    private boolean isExternallyTaggedUnionInner() {
        if (supportsTypedKeys()) {
            return true;
        }
        if (oneOf != null) {
            return isExternallyTaggedUnion(oneOf);
        }
        if (isObject() && getProperties().isPresent()) {
            return maxProperties != null && maxProperties == 1;
        }
        return false;
    }

    private static boolean isExternallyTaggedUnion(List<OpenApiSchema> oneOf) {
        return oneOf.stream().allMatch(OpenApiSchema::isExternallyTaggedUnionVariant);
    }

    private Boolean isExternallyTaggedUnionVariant;

    public boolean isExternallyTaggedUnionVariant() {
        if (isExternallyTaggedUnionVariant == null) {
            isExternallyTaggedUnionVariant = isExternallyTaggedUnionVariantInner();
        }
        return isExternallyTaggedUnionVariant;
    }

    private boolean isExternallyTaggedUnionVariantInner() {
        return getProperties().map(Map::size).orElse(0) == 1 && getRequired().map(Set::size).orElse(0) == 1;
    }

    private Boolean isShortcutPropertyObject;

    public boolean isShortcutPropertyObject() {
        if (isShortcutPropertyObject == null) {
            isShortcutPropertyObject = isShortcutPropertyObjectInner();
        }
        return isShortcutPropertyObject;
    }

    private boolean isShortcutPropertyObjectInner() {
        if (oneOf == null || oneOf.size() != 2) {
            return false;
        }

        var first = oneOf.get(0);
        var second = oneOf.get(1);

        if (!first.hasTitle() || second.hasTitle()) {
            return false;
        }

        var secondType = second.getSingleType().orElse(null);
        if (secondType != OpenApiSchemaType.Object) {
            return false;
        }

        return second.getProperties().map(p -> p.containsKey(first.getTitle().orElseThrow())).orElse(false);
    }

    private Boolean isEnum;

    public boolean isEnum() {
        if (isEnum == null) {
            isEnum = isEnumInner();
        }
        return isEnum;
    }

    private boolean isEnumInner() {
        if (oneOf != null) {
            var enumCount = 0;
            var booleanCount = 0;
            var totalCount = 0;
            for (var s : oneOf) {
                if (s.isNull()) continue;

                if (s.isBoolean()) {
                    booleanCount++;
                } else if (s.isEnum()) {
                    enumCount++;
                }

                totalCount++;
            }
            return enumCount == totalCount || (booleanCount == 1 && enumCount == totalCount - 1);
        }
        return isString() && (hasEnums() || hasConst());
    }

    public boolean isGeneric() {
        return isGeneric;
    }

    public void setIsGeneric(boolean isGeneric) {
        this.isGeneric = isGeneric;
    }

    public boolean isInstantiatedGeneric() {
        return this.isInstantiatedGeneric;
    }

    public void setIsInstantiatedGeneric(boolean isInstantiatedGeneric) {
        this.isInstantiatedGeneric = isInstantiatedGeneric;
    }

    @Nonnull
    public Optional<OpenApiSchema> get$extends() {
        return Optional.ofNullable($extends);
    }

    public boolean has$extends() {
        return $extends != null;
    }

    public void set$extends(@Nullable OpenApiSchema $extends) {
        this.$extends = $extends;
        initializeChild("$extends", $extends);
    }

    @Override
    public @Nonnull OpenApiSchema clone() {
        return toBuilder().build();
    }

    @Override
    public @Nonnull Builder toBuilder() {
        return super.toBuilder(builder()).withName(name)
            .withNamespace(namespace)
            .withDescription(description)
            .withTypes(types)
            .withFormat(format)
            .withAllOf((List<OpenApiSchema>) ifNonnull(allOf, Clone::clone))
            .withAnyOf((List<OpenApiSchema>) ifNonnull(anyOf, Clone::clone))
            .withOneOf((List<OpenApiSchema>) ifNonnull(oneOf, Clone::clone))
            .withEnums(enums)
            .withItems((OpenApiSchema) ifNonnull(items, Clone::clone))
            .withPropertyNames((OpenApiSchema) ifNonnull(propertyNames, Clone::clone))
            .withAdditionalProperties((OpenApiSchema) ifNonnull(additionalProperties, Clone::clone))
            .withProperties((Map<String, OpenApiSchema>) ifNonnull(properties, Clone::clone))
            .withMinProperties(minProperties)
            .withMaxProperties(maxProperties)
            .withRequired(required)
            .withTitle(title)
            .withPattern(pattern)
            .withDiscriminator((OpenApiDiscriminator) ifNonnull(discriminator, Clone::clone))
            .withConstValue(constValue)
            .withVersionRemoved(versionRemoved)
            .withVersionDeprecated(versionDeprecated)
            .withSupportsTypedKeys(supportsTypedKeys)
            .withIsGenericTypeParameter(isGenericTypeParameter);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends OpenApiRefElement.AbstractBuilder<OpenApiSchema, Builder> {
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
        private List<OpenApiSchema> anyOf;
        @Nullable
        private List<OpenApiSchema> oneOf;
        @Nullable
        private List<String> enums;
        @Nullable
        private OpenApiSchema items;
        @Nullable
        private OpenApiSchema propertyNames;
        @Nullable
        private OpenApiSchema additionalProperties;
        @Nullable
        private Map<String, OpenApiSchema> properties;
        @Nullable
        private Integer minProperties;
        @Nullable
        private Integer maxProperties;
        @Nullable
        private Set<String> required;
        @Nullable
        private String title;
        @Nullable
        private String pattern;
        @Nullable
        private OpenApiDiscriminator discriminator;
        @Nullable
        private Object constValue;
        @Nullable
        private Semver versionRemoved;
        @Nullable
        private Semver versionDeprecated;
        @Nullable
        private Boolean supportsTypedKeys;
        @Nullable
        private Boolean isGenericTypeParameter;
        @Nullable
        private OpenApiSchema $extends;

        private Builder() {}

        @Nonnull
        @Override
        protected OpenApiSchema construct() {
            return new OpenApiSchema(this);
        }

        @Nonnull
        public Builder withName(@Nullable String name) {
            this.name = name;
            return this;
        }

        @Nonnull
        public Builder withNamespace(@Nullable String namespace) {
            this.namespace = namespace;
            return this;
        }

        @Nonnull
        public Builder withDescription(@Nullable String description) {
            this.description = description;
            return this;
        }

        @Nonnull
        public Builder withTypes(@Nullable Set<OpenApiSchemaType> types) {
            this.types = types;
            return this;
        }

        @Nonnull
        public Builder withTypes(@Nonnull Function<SetBuilder<OpenApiSchemaType>, ObjectBuilder<Set<OpenApiSchemaType>>> fn) {
            return withTypes(Objects.requireNonNull(fn, "fn must not be null").apply(new SetBuilder<>()).build());
        }

        @Nonnull
        public Builder withFormat(@Nullable OpenApiSchemaFormat format) {
            this.format = format;
            return this;
        }

        @Nonnull
        public Builder withAllOf(@Nullable List<OpenApiSchema> allOf) {
            this.allOf = allOf;
            return this;
        }

        @Nonnull
        public Builder withAllOf(@Nonnull Function<SchemaListBuilder, ObjectBuilder<List<OpenApiSchema>>> fn) {
            return withAllOf(Objects.requireNonNull(fn, "fn must not be null").apply(listBuilder()).build());
        }

        @Nonnull
        public Builder withAnyOf(@Nullable List<OpenApiSchema> anyOf) {
            this.anyOf = anyOf;
            return this;
        }

        @Nonnull
        public Builder withAnyOf(@Nonnull Function<SchemaListBuilder, ObjectBuilder<List<OpenApiSchema>>> fn) {
            return withAnyOf(Objects.requireNonNull(fn, "fn must not be null").apply(listBuilder()).build());
        }

        @Nonnull
        public Builder withOneOf(@Nullable List<OpenApiSchema> oneOf) {
            this.oneOf = oneOf;
            return this;
        }

        @Nonnull
        public Builder withOneOf(@Nonnull Function<SchemaListBuilder, ObjectBuilder<List<OpenApiSchema>>> fn) {
            return withOneOf(Objects.requireNonNull(fn, "fn must not be null").apply(listBuilder()).build());
        }

        @Nonnull
        public Builder withEnums(@Nullable List<String> enums) {
            this.enums = enums;
            return this;
        }

        @Nonnull
        public Builder withEnums(@Nonnull Function<ListBuilder<String>, ObjectBuilder<List<String>>> fn) {
            return withEnums(Objects.requireNonNull(fn, "fn must not be null").apply(new ListBuilder<>()).build());
        }

        @Nonnull
        public Builder withItems(@Nullable OpenApiSchema items) {
            this.items = items;
            return this;
        }

        @Nonnull
        public Builder withItems(@Nonnull Function<OpenApiSchema.Builder, ObjectBuilder<OpenApiSchema>> fn) {
            return withItems(Objects.requireNonNull(fn, "fn must not be null").apply(builder()).build());
        }

        @Nonnull
        public Builder withPropertyNames(@Nullable OpenApiSchema propertyNames) {
            this.propertyNames = propertyNames;
            return this;
        }

        @Nonnull
        public Builder withPropertyNames(@Nonnull Function<OpenApiSchema.Builder, ObjectBuilder<OpenApiSchema>> fn) {
            return withPropertyNames(Objects.requireNonNull(fn, "fn must not be null").apply(builder()).build());
        }

        @Nonnull
        public Builder withAdditionalProperties(@Nullable OpenApiSchema additionalProperties) {
            this.additionalProperties = additionalProperties;
            return this;
        }

        @Nonnull
        public Builder withAdditionalProperties(@Nonnull Function<OpenApiSchema.Builder, ObjectBuilder<OpenApiSchema>> fn) {
            return withAdditionalProperties(Objects.requireNonNull(fn, "fn must not be null").apply(builder()).build());
        }

        @Nonnull
        public Builder withProperties(@Nullable Map<String, OpenApiSchema> properties) {
            this.properties = properties;
            return this;
        }

        @Nonnull
        public Builder withProperties(@Nonnull Function<MapBuilder, ObjectBuilder<Map<String, OpenApiSchema>>> fn) {
            return withProperties(Objects.requireNonNull(fn, "fn must not be null").apply(mapBuilder()).build());
        }

        @Nonnull
        public Builder withMinProperties(@Nullable Integer minProperties) {
            this.minProperties = minProperties;
            return this;
        }

        @Nonnull
        public Builder withMaxProperties(@Nullable Integer maxProperties) {
            this.maxProperties = maxProperties;
            return this;
        }

        @Nonnull
        public Builder withRequired(@Nullable Set<String> required) {
            this.required = required;
            return this;
        }

        @Nonnull
        public Builder withRequired(@Nonnull Function<SetBuilder<String>, ObjectBuilder<Set<String>>> fn) {
            return withRequired(Objects.requireNonNull(fn, "fn must not be null").apply(new SetBuilder<>()).build());
        }

        @Nonnull
        public Builder withTitle(@Nullable String title) {
            this.title = title;
            return this;
        }

        @Nonnull
        public Builder withPattern(@Nullable String pattern) {
            this.pattern = pattern;
            return this;
        }

        @Nonnull
        public Builder withDiscriminator(@Nullable OpenApiDiscriminator discriminator) {
            this.discriminator = discriminator;
            return this;
        }

        @Nonnull
        public Builder withDiscriminator(@Nonnull Function<OpenApiDiscriminator.Builder, ObjectBuilder<OpenApiDiscriminator>> fn) {
            return withDiscriminator(Objects.requireNonNull(fn, "fn must not be null").apply(OpenApiDiscriminator.builder()).build());
        }

        @Nonnull
        public Builder withConstValue(@Nullable Object constValue) {
            this.constValue = constValue;
            return this;
        }

        @Nonnull
        public Builder withVersionRemoved(@Nullable Semver versionRemoved) {
            this.versionRemoved = versionRemoved;
            return this;
        }

        @Nonnull
        public Builder withVersionDeprecated(@Nullable Semver versionDeprecated) {
            this.versionDeprecated = versionDeprecated;
            return this;
        }

        @Nonnull
        public Builder withSupportsTypedKeys(@Nullable Boolean supportsTypedKeys) {
            this.supportsTypedKeys = supportsTypedKeys;
            return this;
        }

        @Nonnull
        public Builder withIsGenericTypeParameter(@Nullable Boolean isGenericTypeParameter) {
            this.isGenericTypeParameter = isGenericTypeParameter;
            return this;
        }

        @Nonnull
        public Builder with$extends(@Nullable OpenApiSchema $extends) {
            this.$extends = $extends;
            return this;
        }

        @Nonnull
        public Builder with$extends(@Nonnull Function<OpenApiSchema.Builder, ObjectBuilder<OpenApiSchema>> fn) {
            return with$extends(Objects.requireNonNull(fn, "fn must not be null").apply(builder()).build());
        }
    }

    public static @Nonnull SchemaListBuilder listBuilder() {
        return new SchemaListBuilder();
    }

    public static final class SchemaListBuilder extends ObjectListBuilderBase<OpenApiSchema, Builder, SchemaListBuilder> {
        private SchemaListBuilder() {}

        @Nonnull
        @Override
        protected Builder valueBuilder() {
            return builder();
        }
    }

    public static @Nonnull MapBuilder mapBuilder() {
        return new MapBuilder();
    }

    public static final class MapBuilder extends ObjectMapBuilderBase<String, OpenApiSchema, Builder, MapBuilder> {
        private MapBuilder() {}

        @Nonnull
        @Override
        protected Builder valueBuilder() {
            return builder();
        }
    }
}
