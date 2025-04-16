/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi.rewriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.codegen.openapi.OpenApiSchema;
import org.opensearch.client.codegen.openapi.walker.OpenApiVisitorBase;
import org.opensearch.client.codegen.openapi.walker.OpenApiWalker;
import org.opensearch.client.codegen.transformer.overrides.Overrides;
import org.opensearch.client.codegen.utils.Versions;

public final class ObjectFlatteningVisitor extends OpenApiVisitorBase {
    private static final Logger LOGGER = LogManager.getLogger(ObjectFlatteningVisitor.class);
    @Nonnull
    private final Overrides overrides;
    @Nonnull
    private final OpenApiWalker walker;

    public ObjectFlatteningVisitor(@Nonnull Overrides overrides, @Nonnull OpenApiWalker walker) {
        this.overrides = Objects.requireNonNull(overrides, "overrides cannot be null");
        this.walker = Objects.requireNonNull(walker, "walker cannot be null");
    }

    @Nullable
    @Override
    public OpenApiSchema visitSchemaEnd(@Nonnull OpenApiSchema schema) {
        if (schema.has$ref() || !schema.isObject() || schema.isTaggedUnion()) {
            return null;
        }

        Properties properties = calculate(schema, false);

        schema.setProperties(properties.getProperties());
        schema.setPropertyNames(properties.getPropertyNames().orElse(null));
        schema.setAdditionalProperties(properties.getAdditionalProperties().orElse(null));
        schema.setRequired(properties.getRequired());

        if (properties.isAdditionalPropertiesSingleton()) {
            schema.setMinProperties(properties.getRequired().size() + 1);
        }

        schema.setAllOf(null);
        schema.setAnyOf(null);
        schema.setOneOf(null);

        return schema;
    }

    private Properties calculate(OpenApiSchema schema, boolean flatten$extends) {
        LOGGER.trace("Calculating properties for schema: {}", schema.getPointer());

        schema = schema.has$ref() ? walker.walkSchema(schema.resolve(), this) : schema;

        if (schema.hasAllOf()) {
            return calculateCombinator(schema.getAllOf().orElseThrow(), OpenApiSchema.Builder::withAllOf, Set::addAll, Boolean::logicalOr);
        } else if (schema.hasAnyOf()) {
            return calculateCombinator(
                schema.getAnyOf().orElseThrow(),
                OpenApiSchema.Builder::withAnyOf,
                Set::retainAll,
                Boolean::logicalAnd
            );
        } else if (schema.hasOneOf()) {
            return calculateCombinator(
                schema.getOneOf().orElseThrow(),
                OpenApiSchema.Builder::withOneOf,
                Set::retainAll,
                Boolean::logicalAnd
            );
        } else if (schema.has$extends() && flatten$extends) {
            return calculateCombinatorProperties(
                List.of(calculate(schema.get$extends().orElseThrow(), true), calculateSimple(schema)),
                OpenApiSchema.Builder::withAllOf,
                Set::addAll,
                Boolean::logicalOr
            );
        } else {
            return calculateSimple(schema);
        }
    }

    private Properties calculateCombinator(
        List<OpenApiSchema> components,
        BiFunction<OpenApiSchema.Builder, List<OpenApiSchema>, OpenApiSchema.Builder> schemaCombinator,
        BiConsumer<Set<String>, Set<String>> requiredCombinator,
        BiFunction<Boolean, Boolean, Boolean> additionalPropertiesSingletonCombinator
    ) {
        return calculateCombinatorProperties(
            components.stream().map(s -> calculate(s, true)).collect(Collectors.toList()),
            schemaCombinator,
            requiredCombinator,
            additionalPropertiesSingletonCombinator
        );
    }

    private Properties calculateCombinatorProperties(
        List<Properties> components,
        BiFunction<OpenApiSchema.Builder, List<OpenApiSchema>, OpenApiSchema.Builder> schemaCombinator,
        BiConsumer<Set<String>, Set<String>> requiredCombinator,
        BiFunction<Boolean, Boolean, Boolean> additionalPropertiesSingletonCombinator
    ) {
        var properties = new HashMap<String, List<OpenApiSchema>>();
        Set<String> required = null;
        var propertyNamesSchemas = new ArrayList<OpenApiSchema>();
        var additionalPropertiesSchemas = new ArrayList<OpenApiSchema>();
        Boolean additionalPropertiesSingleton = null;

        for (var component : components) {
            for (var property : component.getProperties().entrySet()) {
                properties.computeIfAbsent(property.getKey(), k -> new ArrayList<>()).add(property.getValue());
            }

            var componentRequired = component.getRequired();

            if (required == null) {
                required = new HashSet<>(componentRequired);
            } else {
                requiredCombinator.accept(required, componentRequired);
            }

            component.getPropertyNames().ifPresent(propertyNamesSchemas::add);

            var additionalProperties = component.getAdditionalProperties().orElse(null);

            if (additionalProperties != null) {
                additionalPropertiesSchemas.add(additionalProperties);

                if (additionalPropertiesSingleton == null) {
                    additionalPropertiesSingleton = component.isAdditionalPropertiesSingleton();
                } else {
                    additionalPropertiesSingleton = additionalPropertiesSingletonCombinator.apply(
                        additionalPropertiesSingleton,
                        component.isAdditionalPropertiesSingleton()
                    );
                }
            }
        }

        Function<List<OpenApiSchema>, OpenApiSchema> combinator = (s) -> {
            if (s.size() == 1) {
                return s.get(0);
            }
            return schemaCombinator.apply(OpenApiSchema.builder(), s).build();
        };

        var combinedProperties = properties.entrySet()
            .stream()
            .collect(Collectors.toMap(Map.Entry::getKey, e -> combinator.apply(e.getValue())));

        OpenApiSchema combinedPropertyNamesSchema = null;
        if (!propertyNamesSchemas.isEmpty()) {
            combinedPropertyNamesSchema = combinator.apply(propertyNamesSchemas);
        }

        OpenApiSchema combinedAdditionalPropertiesSchema = null;
        if (!additionalPropertiesSchemas.isEmpty()) {
            combinedAdditionalPropertiesSchema = combinator.apply(additionalPropertiesSchemas);
        }

        if (required == null) {
            required = Collections.emptySet();
        }

        return new Properties(
            combinedProperties,
            combinedPropertyNamesSchema,
            combinedAdditionalPropertiesSchema,
            additionalPropertiesSingleton,
            required
        );
    }

    private Properties calculateSimple(OpenApiSchema schema) {
        var properties = schema.getProperties()
            .map(Map::entrySet)
            .stream()
            .flatMap(Set::stream)
            .filter(e -> !shouldIgnoreProperty(schema, e.getKey(), e.getValue()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        var required = schema.getRequired().orElse(Collections.emptySet());

        OpenApiSchema propertyNames = schema.getPropertyNames().orElse(null);
        OpenApiSchema additionalProperties = schema.getAdditionalProperties().orElse(null);
        boolean additionalPropertiesSingleton = schema.isAdditionalPropertiesSingleton();

        return new Properties(properties, propertyNames, additionalProperties, additionalPropertiesSingleton, required);
    }

    private boolean shouldIgnoreProperty(OpenApiSchema schema, String propertyKey, OpenApiSchema propertySchema) {
        if (propertySchema.getResolvedVersionRemoved().map(v -> v.isLowerThanOrEqualTo(Versions.V2_0_0)).orElse(false)) {
            return true;
        }

        if (overrides.getSchema(schema.getPointer()).map(s -> s.getProperty(propertyKey).shouldIgnore()).orElse(false)) {
            return true;
        }

        return false;
    }

    private static class Properties {
        @Nonnull
        private final Map<String, OpenApiSchema> properties;
        @Nullable
        private final OpenApiSchema propertyNames;
        @Nullable
        private final OpenApiSchema additionalProperties;
        private final Boolean additionalPropertiesSingleton;
        @Nonnull
        private final Set<String> required;

        public Properties(
            @Nonnull Map<String, OpenApiSchema> properties,
            @Nullable OpenApiSchema propertyNames,
            @Nullable OpenApiSchema additionalProperties,
            @Nullable Boolean additionalPropertiesSingleton,
            @Nonnull Set<String> required
        ) {
            this.properties = Objects.requireNonNull(properties, "properties cannot be null");
            this.propertyNames = propertyNames;
            this.additionalProperties = additionalProperties;
            this.additionalPropertiesSingleton = additionalPropertiesSingleton;
            this.required = Objects.requireNonNull(required, "required cannot be null");
        }

        @Nonnull
        public Map<String, OpenApiSchema> getProperties() {
            return Collections.unmodifiableMap(properties);
        }

        @Nonnull
        public Optional<OpenApiSchema> getPropertyNames() {
            return Optional.ofNullable(propertyNames);
        }

        @Nonnull
        public Optional<OpenApiSchema> getAdditionalProperties() {
            return Optional.ofNullable(additionalProperties);
        }

        public boolean isAdditionalPropertiesSingleton() {
            return additionalPropertiesSingleton != null && additionalPropertiesSingleton;
        }

        @Nonnull
        public Set<String> getRequired() {
            return Collections.unmodifiableSet(required);
        }
    }
}
