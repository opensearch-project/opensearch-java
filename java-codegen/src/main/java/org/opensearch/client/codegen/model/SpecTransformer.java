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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.codegen.model.overrides.Overrides;
import org.opensearch.client.codegen.model.overrides.PathParameterOverride;
import org.opensearch.client.codegen.model.overrides.PropertyOverride;
import org.opensearch.client.codegen.model.overrides.SchemaOverride;
import org.opensearch.client.codegen.model.overrides.ShouldGenerate;
import org.opensearch.client.codegen.openapi.In;
import org.opensearch.client.codegen.openapi.JsonPointer;
import org.opensearch.client.codegen.openapi.MimeType;
import org.opensearch.client.codegen.openapi.OpenApiMediaType;
import org.opensearch.client.codegen.openapi.OpenApiOperation;
import org.opensearch.client.codegen.openapi.OpenApiParameter;
import org.opensearch.client.codegen.openapi.OpenApiPath;
import org.opensearch.client.codegen.openapi.OpenApiRefElement;
import org.opensearch.client.codegen.openapi.OpenApiRequestBody;
import org.opensearch.client.codegen.openapi.OpenApiResponse;
import org.opensearch.client.codegen.openapi.OpenApiSchema;
import org.opensearch.client.codegen.openapi.OpenApiSchemaFormat;
import org.opensearch.client.codegen.openapi.OpenApiSchemaType;
import org.opensearch.client.codegen.openapi.OpenApiSpecification;
import org.opensearch.client.codegen.utils.Maps;
import org.opensearch.client.codegen.utils.NameSanitizer;
import org.opensearch.client.codegen.utils.Versions;
import org.opensearch.client.codegen.utils.matcher.Matcher;

public class SpecTransformer {
    private static final Logger LOGGER = LogManager.getLogger();
    @Nonnull
    private final Matcher<OperationGroup> matcher;
    @Nonnull
    private final Overrides overrides;
    @Nonnull
    private final Namespace root = new Namespace();
    @Nonnull
    private final Map<OpenApiSchema, Shape> visitedSchemas = new ConcurrentHashMap<>();
    @Nonnull
    private final Map<OpenApiSchema, Type> schemaToType = new ConcurrentHashMap<>();

    public SpecTransformer(@Nonnull Matcher<OperationGroup> matcher, @Nonnull Overrides overrides) {
        this.matcher = Objects.requireNonNull(matcher, "matcher must not be null");
        this.overrides = Objects.requireNonNull(overrides, "overrides must not be null");
    }

    @Nonnull
    public Namespace getRoot() {
        return root;
    }

    public void visit(@Nonnull OpenApiSpecification spec) {
        Objects.requireNonNull(spec, "spec must not be null");

        LOGGER.info("Visiting Specification: {}", spec);

        var groupedOperations = new HashMap<OperationGroup, List<OpenApiOperation>>();

        spec.getPaths()
            .stream()
            .map(Map::values)
            .flatMap(Collection::stream)
            .map(OpenApiPath::getOperations)
            .flatMap(Optional::stream)
            .map(Map::values)
            .flatMap(Collection::stream)
            .filter(o -> o.getDeprecation().map(d -> d.getVersion().isGreaterThan(Versions.V1_0_0)).orElse(true))
            .forEach(operation -> {
                var group = operation.getOperationGroup();
                if (!matcher.matches(group)) {
                    return;
                }
                groupedOperations.computeIfAbsent(group, k -> new ArrayList<>()).add(operation);
            });

        groupedOperations.forEach(this::visit);

        overrides.getSchemas().forEach((pointer, schemaOverride) -> {
            if (!pointer.isDirectChildOf(OpenApiSchema.COMPONENTS_SCHEMAS) || schemaOverride.getMappedType().isPresent()) {
                return;
            }
            visit(spec.getElement(pointer, OpenApiSchema.class));
        });
    }

    private void visit(@Nonnull OperationGroup group, @Nonnull List<OpenApiOperation> variants) {
        LOGGER.info("Visiting Operation Group: {} [{} variants]", group, variants.size());

        var parent = root.child(group.getNamespace().orElse("core"));

        var requestShape = visit(parent, group, variants);
        parent.addOperation(requestShape);

        var responseSchema = variants.stream()
            .map(OpenApiOperation::getResponses)
            .flatMap(Optional::stream)
            .findFirst()
            .flatMap(r -> r.entries().filter(e -> e.getKey().isSuccessful()).map(Map.Entry::getValue).findFirst())
            .map(OpenApiResponse::resolve)
            .flatMap(OpenApiResponse::getContent)
            .flatMap(c -> c.get(MimeType.Json))
            .flatMap(OpenApiMediaType::getSchema)
            .map(s -> {
                if (s.get$ref()
                    .map(OpenApiRefElement.RelativeRef::getPointer)
                    .flatMap(JsonPointer::getLastKey)
                    .map(k -> k.endsWith("Base"))
                    .orElse(false)) {
                    return OpenApiSchema.builder().withPointer(s.getPointer()).withAllOf(s, OpenApiSchema.ANONYMOUS_OBJECT).build();
                }
                return s.resolve();
            });

        if (responseSchema.isEmpty() && !requestShape.hasRequestBody()) {
            requestShape.setIsBooleanRequest();
            return;
        }

        visit(
            parent,
            requestShape.getResponseType().getName(),
            group + ".Response",
            responseSchema.orElse(OpenApiSchema.ANONYMOUS_OBJECT),
            ShouldGenerate.Always,
            true
        );
    }

    @Nonnull
    private RequestShape visit(@Nonnull Namespace parent, @Nonnull OperationGroup group, @Nonnull List<OpenApiOperation> variants) {
        var overrides = this.overrides.getOperation(group);
        var seenHttpPaths = new HashSet<String>();
        HashSet<String> requiredPathParams = null;
        var allPathParams = new HashMap<String, Field>();
        var canonicalPaths = new HashMap<Set<String>, HttpPath>();
        var deprecatedPaths = new HashMap<Set<String>, HttpPath>();

        var description = variants.stream().map(OpenApiOperation::getDescription).flatMap(Optional::stream).findFirst().orElse(null);

        var shape = new RequestShape(parent, group, description, ShouldGenerate.Always);

        var pathCombos = new ArrayList<Triple<String, OpenApiOperation, List<PathParam>>>();

        for (var variant : variants) {
            shape.addSupportedHttpMethod(variant.getHttpMethod().toString().toUpperCase());

            var httpPathStr = variant.getHttpPath();
            if (!seenHttpPaths.add(httpPathStr)) {
                continue;
            }

            getOverloadedPathVariants(httpPathStr, variant, pathCombos);
        }

        for (var combo : pathCombos) {
            var httpPathStr = combo.getLeft();
            var operation = combo.getMiddle();
            var pathParams = combo.getRight();

            pathParams.forEach(parameter -> {
                if (!allPathParams.containsKey(parameter.name)) {
                    var paramOverrides = overrides.flatMap(o -> o.getPathParameter(parameter.name));
                    var paramBuilder = visit(parameter).toBuilder();
                    paramOverrides.flatMap(PathParameterOverride::getName).ifPresent(paramBuilder::withName);
                    allPathParams.put(parameter.name, paramBuilder.build());
                }
            });

            var httpPath = HttpPath.from(httpPathStr, operation, allPathParams);

            (httpPath.getDeprecation() == null ? canonicalPaths : deprecatedPaths).put(httpPath.getParamWireNameSet(), httpPath);

            if (requiredPathParams != null) {
                requiredPathParams.retainAll(httpPath.getParamWireNameSet());
            } else {
                requiredPathParams = new HashSet<>(httpPath.getParamWireNameSet());
            }
        }

        Stream.of(
            canonicalPaths.values().stream(),
            deprecatedPaths.entrySet().stream().filter(p -> !canonicalPaths.containsKey(p.getKey())).map(Map.Entry::getValue)
        ).flatMap(Function.identity()).sorted((p1, p2) -> {
            var params1 = p1.getParams();
            var p1Size = params1.size();
            var params2 = p2.getParams();
            var p2Size = params2.size();
            var len = Math.max(p1Size, p2Size);

            for (int i = 0; i < len; i++) {
                if (i >= p1Size) {
                    return -1;
                }
                if (i >= p2Size) {
                    return 1;
                }
                var cmp = params1.get(i).getName().compareTo(params2.get(i).getName());
                if (cmp != 0) {
                    return cmp;
                }
            }

            return 0;
        }).forEachOrdered(shape::addHttpPath);

        for (var entry : allPathParams.entrySet()) {
            shape.addPathParam(entry.getValue().toBuilder().withRequired(requiredPathParams.contains(entry.getKey())).build());
        }

        variants.stream()
            .map(OpenApiOperation::getRequestBody)
            .flatMap(Optional::stream)
            .findFirst()
            .map(OpenApiRequestBody::resolve)
            .flatMap(OpenApiRequestBody::getContent)
            .flatMap(c -> c.get(MimeType.Json))
            .flatMap(OpenApiMediaType::getSchema)
            .ifPresent(s -> {
                if (s.has$ref() && s.hasTitle()) {
                    var name = s.getTitle().orElseThrow();
                    shape.setDelegatedBodyField(name, mapType(s));
                } else {
                    visitInto(s.resolve(), shape);
                }
            });

        var seenQueryParams = new HashSet<String>();

        var isCatNs = group.getNamespace().orElse("").equals("cat");

        variants.stream()
            .flatMap(v -> v.getAllRelevantParameters(In.Query).stream())
            .filter(p -> seenQueryParams.add(p.getName().orElseThrow()) && !p.isGlobal() && (!isCatNs || !p.isGlobalCatParameter()))
            .map(this::visit)
            .forEachOrdered(shape::addQueryParam);

        if (shape.getExtendsType() == null) {
            shape.setExtendsType(isCatNs ? Types.Client.OpenSearch.Cat.CatRequestBase : Types.Client.OpenSearch._Types.RequestBase);
        }

        return shape;
    }

    private static void getOverloadedPathVariants(
        String originalHttpPath,
        OpenApiOperation operation,
        List<Triple<String, OpenApiOperation, List<PathParam>>> variants
    ) {
        getOverloadedPathVariants(
            originalHttpPath,
            operation.getAllRelevantParameters(In.Path),
            0,
            new ArrayList<>(),
            (httpPath, pathParams) -> variants.add(Triple.of(httpPath, operation, pathParams))
        );
    }

    private static void getOverloadedPathVariants(
        String httpPath,
        List<OpenApiParameter> pathParams,
        int i,
        List<PathParam> combo,
        BiConsumer<String, List<PathParam>> callback
    ) {
        if (i == pathParams.size()) {
            callback.accept(httpPath, combo);
            return;
        }

        var originalParameter = pathParams.get(i);
        var originalName = originalParameter.getName().orElseThrow();
        var overloads = !originalParameter.isOverloaded()
            ? Stream.of(Pair.of(httpPath, new PathParam(originalParameter)))
            : originalParameter.getSchema().flatMap(OpenApiSchema::getAnyOf).orElseThrow().stream().map(o -> {
                var overloadedName = o.getTitle().orElseThrow();
                return Pair.of(
                    httpPath.replace("{" + originalName + "}", "{" + overloadedName + "}"),
                    new PathParam(overloadedName, o, originalParameter)
                );
            });

        overloads.forEach(o -> getOverloadedPathVariants(o.getKey(), pathParams, i + 1, new ArrayList<>(combo) {
            {
                add(o.getValue());
            }
        }, callback));
    }

    private static class PathParam {
        private final String name;
        private final OpenApiSchema schema;
        private final String description;
        private final Deprecation deprecation;

        public PathParam(String name, OpenApiSchema schema, OpenApiParameter original) {
            this.name = name;
            this.schema = schema;
            this.description = original.getResolvedDescription().orElse(null);
            this.deprecation = original.getDeprecation().orElse(null);
        }

        public PathParam(OpenApiParameter parameter) {
            this.name = parameter.getName().orElseThrow();
            this.schema = parameter.getSchema().orElseThrow();
            this.description = parameter.getResolvedDescription().orElse(null);
            this.deprecation = parameter.getDeprecation().orElse(null);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("name", name).append("schema", schema).append("description", description).toString();
        }
    }

    private Field visit(PathParam parameter) {
        LOGGER.info("Visiting Parameter: {}", parameter);
        return Field.builder()
            .withWireName(parameter.name)
            .withType(mapType(parameter.schema))
            .withDescription(parameter.description)
            .withDeprecation(parameter.deprecation)
            .build();
    }

    private Field visit(OpenApiParameter parameter) {
        LOGGER.info("Visiting Parameter: {}", parameter);
        return Field.builder()
            .withWireName(parameter.getName().orElseThrow())
            .withType(mapType(parameter.getSchema().orElseThrow()))
            .withRequired(parameter.getRequired())
            .withDescription(parameter.getResolvedDescription().orElse(null))
            .withDeprecation(parameter.getDeprecation().orElse(null))
            .build();
    }

    private Shape visit(OpenApiSchema schema) {
        var namespace = schema.getNamespace().orElseThrow();
        var name = schema.getName().orElseThrow();
        var schemaOverrides = overrides.getSchema(schema.getPointer());
        var className = schemaOverrides.flatMap(SchemaOverride::getClassName).orElse(name);
        var shouldGenerate = schemaOverrides.map(SchemaOverride::shouldGenerate).orElse(ShouldGenerate.IfNeeded);
        return visit(root.child(namespace), className, namespace + "." + name, schema, shouldGenerate);
    }

    private Shape visit(Namespace parent, String className, String typedefName, OpenApiSchema schema, ShouldGenerate shouldGenerate) {
        return visit(parent, className, typedefName, schema, shouldGenerate, false);
    }

    private Shape visit(
        Namespace parent,
        String className,
        String typedefName,
        final OpenApiSchema schema,
        ShouldGenerate shouldGenerate,
        final boolean uncached
    ) {
        Shape shape;

        if (!uncached && (shape = visitedSchemas.get(schema)) != null) {
            return shape;
        }

        Consumer<Shape> cache = s -> {
            if (!uncached) {
                visitedSchemas.putIfAbsent(schema, s);
            }
        };

        LOGGER.info("Visiting Schema: {}", schema);

        var description = schema.getResolvedDescription().orElse(null);

        var isTaggedUnion = isTaggedUnion(schema);
        var isShortcutPropertyObject = isShortcutPropertyObject(schema);

        if (schema.isArray()) {
            shape = new ArrayShape(parent, className, mapType(schema), typedefName, description, shouldGenerate);
            cache.accept(shape);
        } else if (isEnum(schema)) {
            var enumShape = new EnumShape(parent, className, typedefName, description, shouldGenerate);
            shape = enumShape;
            cache.accept(shape);

            visitInto(schema, enumShape);
        } else if (isTaggedUnion) {
            var taggedUnion = new TaggedUnionShape(parent, className, typedefName, description, shouldGenerate);
            shape = taggedUnion;
            cache.accept(shape);

            var unionSchema = schema;
            while (unionSchema.hasAllOf()) {
                var allOf = unionSchema.getAllOf().orElseThrow();
                var first = allOf.get(0);
                var second = allOf.get(1);

                if (first.has$ref()) {
                    shape.setExtendsType(mapType(first));
                    unionSchema = second;
                } else if (isTaggedUnion(first)) {
                    unionSchema = first;
                    visitInto(second, taggedUnion);
                } else if (isTaggedUnion(second)) {
                    unionSchema = second;
                    visitInto(first, taggedUnion);
                } else {
                    throw new IllegalStateException("allOf is not a tagged union: " + unionSchema.getPointer());
                }
            }

            String discriminatingField;
            var discriminator = unionSchema.getDiscriminator().orElse(null);

            if (discriminator != null) {
                discriminatingField = discriminator.getPropertyName().orElse(null);
                taggedUnion.setDiscriminatingField(discriminatingField);
                taggedUnion.setDefaultVariant(discriminator.getDefaultValue().orElse(null));
            } else {
                discriminatingField = null;
            }

            var oneOrAnyOf = unionSchema.getOneOf().or(unionSchema::getAnyOf).orElse(null);
            if (!isExternallyTaggedUnion(unionSchema)) {
                oneOrAnyOf.forEach(s -> {
                    String name;
                    if (discriminatingField != null) {
                        var props = new HashMap<String, OpenApiSchema>();
                        collectObjectProperties(s, props, new ArrayList<>());
                        name = Maps.tryGet(props, discriminatingField)
                            .flatMap(OpenApiSchema::getEnums)
                            .flatMap(enums -> enums.stream().findFirst())
                            .orElseThrow(
                                () -> new IllegalStateException(
                                    "oneOf variant ["
                                        + s.getPointer()
                                        + "] is missing the `"
                                        + discriminatingField
                                        + "` property as a single value enum"
                                )
                            );
                    } else {
                        name = s.getTitle()
                            .orElseThrow(
                                () -> new IllegalStateException("oneOf variant [" + s.getPointer() + "] is missing a `title` tag")
                            );
                    }
                    taggedUnion.addVariant(name, mapType(s));
                });
            } else {
                if (unionSchema.isObject()) {
                    taggedUnion.setExternallyDiscriminated(
                        unionSchema.getMinProperties().orElse(0) == 1
                            ? TaggedUnionShape.ExternallyDiscriminated.REQUIRED
                            : TaggedUnionShape.ExternallyDiscriminated.OPTIONAL
                    );
                    unionSchema.getProperties().ifPresent(props -> props.forEach((k, v) -> taggedUnion.addVariant(k, mapType(v))));
                } else {
                    taggedUnion.setExternallyDiscriminated(TaggedUnionShape.ExternallyDiscriminated.REQUIRED);
                    oneOrAnyOf.forEach(s -> {
                        var prop = s.getProperties().flatMap(m -> m.entrySet().stream().findFirst()).orElseThrow();

                        taggedUnion.addVariant(prop.getKey(), mapType(prop.getValue()));
                    });
                }
            }
        } else if (isShortcutPropertyObject || schema.determineSingleType().orElse(null) == OpenApiSchemaType.Object) {
            if (schema.getProperties().isEmpty()
                && schema.getAdditionalProperties().isPresent()
                && schema.getMaxProperties().orElse(Integer.MAX_VALUE) > 1) {
                shape = new DictionaryResponseShape(
                    parent,
                    className,
                    typedefName,
                    description,
                    Types.Java.Lang.String,
                    mapType(schema.getAdditionalProperties().orElseThrow()),
                    shouldGenerate
                );
                cache.accept(shape);
            } else {
                var objShape = new ObjectShape(parent, className, typedefName, description, shouldGenerate);
                shape = objShape;
                cache.accept(shape);

                var objSchema = schema;
                if (isShortcutPropertyObject) {
                    var oneOf = schema.getOneOf().orElseThrow();
                    var shortcutProperty = oneOf.get(0).getTitle().orElseThrow();
                    objShape.setShortcutProperty(shortcutProperty);
                    objSchema = oneOf.get(1);
                }

                visitInto(objSchema, objShape);
            }
        } else {
            shape = new DelegatedShape(parent, className, typedefName, description, shouldGenerate, mapType(schema));
            cache.accept(shape);
        }

        parent.addShape(shape);

        return shape;
    }

    private void visitInto(OpenApiSchema schema, ObjectShapeBase shape) {
        var allOf = schema.getAllOf();
        if (allOf.isPresent()) {
            if (allOf.get().size() == 2) {
                var baseSchema = allOf.get().get(0);
                shape.setExtendsType(mapType(baseSchema));
                schema = allOf.get().get(1);
            } else if (allOf.get().size() == 1) {
                schema = allOf.get().get(0);
            }
        }

        var superShape = shape.extendsOtherShape() ? (ObjectShapeBase) shape.getExtendsType().getTargetShape().orElseThrow() : null;

        final var properties = new HashMap<String, OpenApiSchema>();
        final var additionalProperties = new ArrayList<Triple<OpenApiSchema, OpenApiSchema, Boolean>>();
        final var required = collectObjectProperties(schema, properties, additionalProperties);

        final var overrides = this.overrides.getSchema(schema.getPointer());

        properties.forEach((k, v) -> {
            if (superShape != null && superShape.hasBodyFieldWithWireName(k)) {
                return;
            }

            var propOverrides = overrides.map(so -> so.getProperty(k));

            var type = propOverrides.flatMap(PropertyOverride::getMappedType).orElseGet(() -> mapType(v));

            var field = Field.builder()
                .withWireName(k)
                .withName(propOverrides.flatMap(PropertyOverride::getName).orElse(null))
                .withType(type)
                .withRequired(required.contains(k))
                .withDescription(v.getDescription().orElse(null))
                .whenPresent(propOverrides.flatMap(PropertyOverride::getAliases), (b, aliases) -> b.withAliases(a -> a.with(aliases)))
                .build();

            shape.addBodyField(field);
        });

        if (!additionalProperties.isEmpty()) {
            var singleton = additionalProperties.stream().allMatch(Triple::getRight);
            var keySchema = additionalProperties.size() == 1
                ? additionalProperties.get(0).getLeft()
                : OpenApiSchema.builder()
                    .withPointer(schema.getPointer().append("propertyNames"))
                    .withOneOf(additionalProperties.stream().map(Triple::getLeft).collect(Collectors.toList()))
                    .build();
            var resolvedKeySchema = keySchema.resolve();
            var keyName = keySchema.getTitle().or(resolvedKeySchema::getName).orElse("key");

            var valueSchema = additionalProperties.size() == 1
                ? additionalProperties.get(0).getMiddle()
                : OpenApiSchema.builder()
                    .withPointer(schema.getPointer().append("additionalProperties"))
                    .withOneOf(additionalProperties.stream().map(Triple::getMiddle).collect(Collectors.toList()))
                    .build();

            shape.setAdditionalProperties(
                new ObjectShapeBase.AdditionalProperties(
                    keyName,
                    mapType(keySchema),
                    keySchema.getResolvedDescription().orElse(null),
                    valueSchema.getTitle().orElse("metadata"),
                    mapType(valueSchema),
                    valueSchema.getResolvedDescription().orElse(null),
                    singleton
                )
            );
        }
    }

    private Set<String> collectObjectProperties(
        OpenApiSchema schema,
        Map<String, OpenApiSchema> properties,
        List<Triple<OpenApiSchema, OpenApiSchema, Boolean>> additionalProperties
    ) {
        if (schema.has$ref()) {
            return collectObjectProperties(schema.resolve(), properties, additionalProperties);
        }

        if (schema.hasAllOf()) {
            var required = new HashSet<String>();
            for (var component : schema.getAllOf().orElseThrow()) {
                required.addAll(collectObjectProperties(component, properties, additionalProperties));
            }
            return required;
        }

        if (schema.hasAnyOf() || schema.hasOneOf()) {
            Set<String> required = null;
            for (var component : schema.getAnyOf().or(schema::getOneOf).orElseThrow()) {
                var componentRequired = collectObjectProperties(component, properties, additionalProperties);
                if (required == null) {
                    required = new HashSet<>(componentRequired);
                } else {
                    required.retainAll(componentRequired);
                }
            }
            return required;
        }

        var schemaOverrides = overrides.getSchema(schema.getPointer()).orElse(null);

        schema.getProperties().ifPresent(props -> props.forEach((propName, propSchema) -> {
            var resolvedPropSchema = propSchema.resolve();
            var isRemoved = propSchema.getVersionRemoved()
                .or(resolvedPropSchema::getVersionRemoved)
                .map(ver -> ver.isLowerThanOrEqualTo(Versions.V2_0_0))
                .orElse(false);

            if (isRemoved || schemaOverrides != null && schemaOverrides.getProperty(propName).shouldIgnore()) {
                return;
            }

            var existing = properties.get(propName);
            if (existing != null) {
                var existingType = mapType(existing);
                var newType = mapType(propSchema);
                if (!existingType.equals(newType)) {
                    propSchema = OpenApiSchema.ANONYMOUS_UNTYPED;
                }
            }

            properties.put(propName, propSchema);
        }));

        var required = schema.getRequired().orElseGet(Collections::emptySet);

        schema.getAdditionalProperties().ifPresent(propertySchema -> {
            var nameSchema = schema.getPropertyNames().orElse(OpenApiSchema.ANONYMOUS_STRING);
            var singleton = schema.getMinProperties().orElse(0) - required.size() == 1;
            additionalProperties.add(Triple.of(nameSchema, propertySchema, singleton));
        });

        return required;
    }

    private void visitInto(OpenApiSchema schema, EnumShape shape) {
        var title = schema.getTitle();
        var isDeprecated = schema.getVersionDeprecated().isPresent();

        if (schema.hasOneOf()) {
            schema.getOneOf().orElseThrow().forEach(s -> visitInto(s, shape));
        } else if (schema.hasEnums()) {
            var enums = schema.getEnums().orElseThrow();
            var description = title.isPresent() || enums.stream().map(String::toLowerCase).distinct().count() == 1
                ? schema.getResolvedDescription().orElse(null)
                : null;
            enums.forEach(v -> shape.addVariant(title.orElse(v), v, description, isDeprecated));
        } else if (schema.hasConst()) {
            var value = (String) schema.getConst().orElseThrow();
            shape.addVariant(title.orElse(value), value, schema.getResolvedDescription().orElse(null), isDeprecated);
        } else if (schema.isBoolean()) {
            var description = schema.getResolvedDescription().orElse(null);
            shape.addVariant(title.orElse("true"), "true", description, isDeprecated);
            shape.addVariant(title.orElse("false"), "false", description, isDeprecated);
        }
    }

    private Type mapType(OpenApiSchema schema) {
        return mapType(schema, false);
    }

    private Type mapType(OpenApiSchema schema, boolean boxed) {
        var type = schemaToType.get(schema);
        if (type == null) {
            type = mapTypeInner(schema);
            schemaToType.put(schema, type);
        }
        return boxed ? type.getBoxed() : type;
    }

    private Type mapTypeInner(OpenApiSchema schema) {
        if (schema.has$ref()) {
            schema = schema.resolve();

            var overriddenMappedType = overrides.getSchema(schema.getPointer()).flatMap(SchemaOverride::getMappedType);

            if (overriddenMappedType.isPresent()) {
                return overriddenMappedType.get();
            }

            if (!shouldKeepRef(schema)) {
                return mapType(schema);
            }

            var shape = visit(schema);

            return shape.getType();
        }

        if (isSingleKeyMap(schema)) {
            var value = schema.getAdditionalProperties().orElseThrow();
            if (value.has$ref()) {
                var keySchema = schema.getPropertyNames().orElse(OpenApiSchema.ANONYMOUS_STRING);
                var resolvedKeySchema = keySchema.resolve();
                var fieldName = resolvedKeySchema.getName().or(resolvedKeySchema::getTitle).map(NameSanitizer::fieldName).orElse("key");
                var type = mapType(value);
                var shape = type.getTargetShape().orElse(null);
                if (shape instanceof ObjectShapeBase) {
                    ((ObjectShapeBase) shape).setSingleKeyMap(fieldName, mapType(keySchema));
                    return type;
                }
            }
        }

        var oneOf = schema.getOneOf();
        if (oneOf.isPresent()) {
            return mapOneOf(oneOf.get());
        }

        var anyOf = schema.getAnyOf();
        if (anyOf.isPresent()) {
            return mapAnyOf(anyOf.get());
        }

        var allOf = schema.getAllOf();
        if (allOf.isPresent()) {
            return mapAllOf(allOf.get());
        }

        var types = schema.getTypes()
            .map(ts -> ts.stream().filter(t -> t != OpenApiSchemaType.Null).collect(Collectors.toSet()))
            .orElse(null);

        if (types == null || types.isEmpty()) {
            return Types.Client.Json.JsonData;
        }

        if (types.size() == 2 && types.contains(OpenApiSchemaType.String) && types.contains(OpenApiSchemaType.Number)) {
            return Types.Java.Lang.String;
        }

        if (types.size() > 1) {
            return Types.Client.Json.JsonData;
        }

        switch (types.iterator().next()) {
            case Object:
                return mapObject(schema);
            case Array:
                return mapArray(schema);
            case String:
                return Types.Java.Lang.String;
            case Boolean:
                return Types.Primitive.Boolean;
            case Integer:
                return mapInteger(schema);
            case Number:
                return mapNumber(schema);
        }

        throw new UnsupportedOperationException("Can not get type name for: " + types);
    }

    private Type mapOneOf(List<OpenApiSchema> oneOf) {
        if (isOneOfSingleAndArray(oneOf)) {
            return mapType(oneOf.stream().filter(OpenApiSchema::isArray).findFirst().orElseThrow());
        }

        var types = OpenApiSchema.determineTypes(oneOf);
        types.remove(OpenApiSchemaType.Null);

        if (types.size() == 1) {
            switch (types.iterator().next()) {
                case String:
                    return Types.Java.Lang.String;
                case Boolean:
                    return Types.Primitive.Boolean;
                case Integer:
                case Number:
                    return Types.Java.Lang.Number;
            }
        }

        if (types.size() == 2
            && types.contains(OpenApiSchemaType.String)
            && (types.contains(OpenApiSchemaType.Boolean)
                || types.contains(OpenApiSchemaType.Integer)
                || types.contains(OpenApiSchemaType.Number))) {
            return Types.Java.Lang.String;
        }

        return Types.Client.Json.JsonData;
    }

    private Type mapAnyOf(List<OpenApiSchema> anyOf) {
        var types = OpenApiSchema.determineTypes(anyOf);
        types.remove(OpenApiSchemaType.Null);

        if (types.size() == 1 && types.contains(OpenApiSchemaType.String)) {
            return Types.Java.Lang.String;
        }

        return Types.Client.Json.JsonData;
    }

    private Type mapAllOf(List<OpenApiSchema> allOf) {
        if (allOf.size() == 1) {
            return mapType(allOf.get(0));
        }

        throw new UnsupportedOperationException("Can not get type name for allOf: " + allOf);
    }

    private Type mapObject(OpenApiSchema schema) {
        var values = schema.getAdditionalProperties().map(s -> mapType(s, true)).orElse(Types.Client.Json.JsonData);
        return Types.Java.Util.Map(Types.Java.Lang.String, values);
    }

    private Type mapArray(OpenApiSchema schema) {
        var items = schema.getItems().map(i -> mapType(i, true)).orElse(Types.Client.Json.JsonData);
        return Types.Java.Util.List(items);
    }

    private Type mapInteger(OpenApiSchema schema) {
        var format = schema.getFormat().orElse(OpenApiSchemaFormat.Int32);
        switch (format) {
            case Int32:
                return Types.Primitive.Int;
            case Int64:
                return Types.Primitive.Long;
            default:
                throw new UnsupportedOperationException(
                    "Can not get type name for integer [" + schema.getPointer() + "] with format: " + format
                );
        }
    }

    private Type mapNumber(OpenApiSchema schema) {
        var format = schema.getFormat().orElse(null);
        if (format == null) {
            return Types.Java.Lang.Number;
        }
        switch (format) {
            case Float:
                return Types.Primitive.Float;
            case Double:
                return Types.Primitive.Double;
            default:
                throw new UnsupportedOperationException(
                    "Can not get type name for number [" + schema.getPointer() + "] with format: " + format
                );
        }
    }

    private boolean shouldKeepRef(OpenApiSchema schema) {
        if (schema.isArray() || schema.isBoolean() || schema.isInteger() || schema.isNumber()) {
            return false;
        }
        if (isEnum(schema)) {
            return true;
        }
        if (schema.isString()) {
            return false;
        }
        if (schema.isObject()
            && schema.getProperties().map(Map::isEmpty).orElse(true)
            && schema.getAdditionalProperties().map(s -> s.getTitle().isEmpty()).orElse(false)) {
            return false;
        }
        if (isTaggedUnion(schema)) {
            return true;
        }
        if (isShortcutPropertyObject(schema)) {
            return true;
        }
        return schema.determineSingleType().orElse(null) == OpenApiSchemaType.Object;
    }

    private static boolean isOneOfSingleAndArray(List<OpenApiSchema> oneOf) {
        if (oneOf.size() != 2) {
            return false;
        }
        var first = oneOf.get(0);
        var second = oneOf.get(1);

        OpenApiSchema array;
        OpenApiSchema single;

        if (first.isArray()) {
            array = first;
            single = second;
        } else if (second.isArray()) {
            array = second;
            single = first;
        } else {
            return false;
        }

        var items = array.getItems().orElseThrow();
        return single.getTypes().equals(items.getTypes()) && single.get$ref().equals(items.get$ref());
    }

    private static boolean isEnum(OpenApiSchema schema) {
        if (schema.isString()) {
            return schema.hasEnums() || schema.hasConst();
        }
        if (schema.getOneOf().isPresent()) {
            var enumCount = 0;
            var booleanCount = 0;
            var totalCount = 0;
            for (var s : schema.getOneOf().orElseThrow()) {
                if (s.isBoolean()) {
                    booleanCount++;
                } else if (isEnum(s)) {
                    enumCount++;
                }
                totalCount++;
            }
            return enumCount == totalCount || (booleanCount == 1 && enumCount == totalCount - 1);
        }
        return false;
    }

    private static boolean isSingleKeyMap(OpenApiSchema schema) {
        if (schema.isObject() && schema.getProperties().isEmpty() && schema.getAdditionalProperties().isPresent()) {
            var minProperties = schema.getMinProperties().orElse(0);
            var maxProperties = schema.getMaxProperties().orElse(Integer.MAX_VALUE);
            return minProperties == 1 && maxProperties == 1;
        }
        return false;
    }

    private boolean isShortcutPropertyObject(OpenApiSchema schema) {
        var oneOf = schema.getOneOf().orElse(null);

        if (oneOf == null || oneOf.size() != 2) {
            return false;
        }

        var first = oneOf.get(0);
        var second = oneOf.get(1);

        if (!first.hasTitle() || second.hasTitle()) {
            return false;
        }

        var secondType = second.determineSingleType().orElse(null);
        if (secondType != OpenApiSchemaType.Object) {
            return false;
        }

        var properties = new HashMap<String, OpenApiSchema>();
        collectObjectProperties(second, properties, new ArrayList<>());

        return properties.containsKey(first.getTitle().orElseThrow());
    }

    private static boolean isTaggedUnion(OpenApiSchema schema) {
        if (schema.hasOneOf()) {
            if (schema.getDiscriminator().isPresent()) {
                return true;
            }
            var oneOf = schema.getOneOf().orElseThrow();
            return isTaggedUnion(oneOf) || isExternallyTaggedUnion(oneOf);
        }
        if (schema.hasAnyOf()) {
            return isTaggedUnion(schema.getAnyOf().orElseThrow());
        }
        if (schema.hasAllOf()) {
            var allOf = schema.getAllOf().orElseThrow();

            if (allOf.size() != 2) {
                return false;
            }

            var first = allOf.get(0);
            var second = allOf.get(1);

            if (first.has$ref() && isTaggedUnion(second)) {
                return true;
            }

            return isTaggedUnion(first) && second.isObject() || first.isObject() && isTaggedUnion(second);
        }

        return isExternallyTaggedUnion(schema);
    }

    private static boolean isTaggedUnion(List<OpenApiSchema> oneOfAnyOf) {
        return oneOfAnyOf.stream().allMatch(OpenApiSchema::hasTitle);
    }

    private static boolean isExternallyTaggedUnion(OpenApiSchema schema) {
        if (schema.hasOneOf()) {
            return isExternallyTaggedUnion(schema.getOneOf().orElseThrow());
        }
        if (schema.isObject() && schema.getProperties().isPresent()) {
            var maxProperties = schema.getMaxProperties().orElse(Integer.MAX_VALUE);
            return maxProperties == 1;
        }
        return false;
    }

    private static boolean isExternallyTaggedUnion(List<OpenApiSchema> oneOf) {
        return oneOf.stream().allMatch(SpecTransformer::isExternallyTaggedUnionVariant);
    }

    private static boolean isExternallyTaggedUnionVariant(OpenApiSchema schema) {
        return schema.isObject()
            && schema.getProperties().map(Map::size).orElse(0) == 1
            && schema.getRequired().map(Set::size).orElse(0) == 1;
    }
}
