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
import java.util.function.Function;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.codegen.model.overrides.Overrides;
import org.opensearch.client.codegen.model.overrides.PropertyOverride;
import org.opensearch.client.codegen.model.overrides.SchemaOverride;
import org.opensearch.client.codegen.model.overrides.ShouldGenerate;
import org.opensearch.client.codegen.openapi.HttpStatusCode;
import org.opensearch.client.codegen.openapi.In;
import org.opensearch.client.codegen.openapi.JsonPointer;
import org.opensearch.client.codegen.openapi.MimeType;
import org.opensearch.client.codegen.openapi.OpenApiDiscriminator;
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
import org.opensearch.client.codegen.utils.Versions;

public class SpecTransformer {
    private static final Logger LOGGER = LogManager.getLogger();
    @Nonnull
    private final OperationGroupMatcher matcher;
    @Nonnull
    private final Overrides overrides;
    @Nonnull
    private final Namespace root = new Namespace();
    @Nonnull
    private final Map<OpenApiSchema, Shape> visitedSchemas = new ConcurrentHashMap<>();
    @Nonnull
    private final Map<OpenApiSchema, Type> schemaToType = new ConcurrentHashMap<>();

    public SpecTransformer(@Nonnull OperationGroupMatcher matcher, @Nonnull Overrides overrides) {
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
            .forEach(operation -> {
                var group = operation.getOperationGroup();
                if (!matcher.matches(group)) {
                    return;
                }
                groupedOperations.computeIfAbsent(group, k -> new ArrayList<>()).add(operation);
            });

        groupedOperations.forEach(this::visit);

        overrides.getSchemas().forEach((pointer, schemaOverride) -> {
            if (schemaOverride.shouldGenerate() != ShouldGenerate.Always) {
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
            .flatMap(r -> r.get(HttpStatusCode.Ok))
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

        visit(parent, requestShape.getResponseType().getName(), group + ".Response", responseSchema.orElse(OpenApiSchema.ANONYMOUS_OBJECT), ShouldGenerate.Always);
    }

    @Nonnull
    private RequestShape visit(@Nonnull Namespace parent, @Nonnull OperationGroup group, @Nonnull List<OpenApiOperation> variants) {
        var seenHttpPaths = new HashSet<String>();
        HashSet<String> requiredPathParams = null;
        var allPathParams = new HashMap<String, Field>();
        var canonicalPaths = new HashMap<Set<String>, HttpPath>();
        var deprecatedPaths = new HashMap<Set<String>, HttpPath>();

        var description = variants.stream().map(OpenApiOperation::getDescription).flatMap(Optional::stream).findFirst().orElse(null);

        var shape = new RequestShape(parent, group, description, ShouldGenerate.Always);

        for (var variant : variants) {
            shape.addSupportedHttpMethod(variant.getHttpMethod().toString().toUpperCase());

            var httpPathStr = variant.getHttpPath();
            if (!seenHttpPaths.add(httpPathStr)) {
                continue;
            }

            variant.getAllRelevantParameters(In.Path).forEach(parameter -> {
                var paramName = parameter.getName().orElseThrow();
                if (!allPathParams.containsKey(paramName)) {
                    allPathParams.put(paramName, visit(parameter));
                }
            });

            var httpPath = HttpPath.from(httpPathStr, variant, allPathParams);

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
            entry.getValue().setRequired(requiredPathParams.contains(entry.getKey()));
            shape.addPathParam(entry.getValue());
        }

        variants.stream()
            .flatMap(v -> v.getAllRelevantParameters(In.Query).stream())
            .filter(p -> !p.isGlobal())
            .map(this::visit)
            .forEachOrdered(shape::addQueryParam);

        variants.stream()
            .map(OpenApiOperation::getRequestBody)
            .flatMap(Optional::stream)
            .findFirst()
            .map(OpenApiRequestBody::resolve)
            .flatMap(OpenApiRequestBody::getContent)
            .flatMap(c -> c.get(MimeType.Json))
            .flatMap(OpenApiMediaType::getSchema)
            .map(OpenApiSchema::resolve)
            .ifPresent(s -> visitInto(s, shape));

        if (shape.getExtendsType() == null) {
            shape.setExtendsType(Types.Client.OpenSearch._Types.RequestBase);
        }

        return shape;
    }

    private Field visit(OpenApiParameter parameter) {
        LOGGER.info("Visiting Parameter: {}", parameter);
        return new Field(
            parameter.getName().orElseThrow(),
            mapType(parameter.getSchema().orElseThrow()),
            parameter.getRequired(),
            parameter.getDescription().orElse(null),
            parameter.getDeprecation().orElse(null)
        );
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
        Shape shape = visitedSchemas.get(schema);

        if (shape != null) {
            return shape;
        }

        LOGGER.info("Visiting Schema: {}", schema);

        var description = schema.getDescription().orElse(null);

        var isTaggedUnion = isTaggedUnion(schema);
        var isShortcutPropertyObject = isShortcutPropertyObject(schema);

        if (schema.isArray()) {
            shape = new ArrayShape(parent, className, mapType(schema), typedefName, description, shouldGenerate);
            visitedSchemas.putIfAbsent(schema, shape);
        } else if (isEnum(schema)) {
            var enumShape = new EnumShape(parent, className, typedefName, description, shouldGenerate);
            shape = enumShape;
            visitedSchemas.putIfAbsent(schema, shape);

            visitInto(schema, enumShape);
        } else if (isTaggedUnion) {
            var discriminatingField = schema.getDiscriminator().flatMap(OpenApiDiscriminator::getPropertyName).orElse(null);
            var taggedUnion = new TaggedUnionShape(parent, className, typedefName, description, discriminatingField, shouldGenerate);
            shape = taggedUnion;
            visitedSchemas.putIfAbsent(schema, shape);

            schema.getOneOf().or(schema::getAnyOf).orElseThrow().forEach(s -> {
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
                        .orElseThrow(() -> new IllegalStateException("oneOf variant [" + s.getPointer() + "] is missing a `title` tag"));
                }
                taggedUnion.addVariant(name, mapType(s));
            });
        } else if (isShortcutPropertyObject || schema.determineSingleType().orElse(null) == OpenApiSchemaType.Object) {
            if (schema.getProperties().isEmpty() && schema.getAdditionalProperties().isPresent()) {
                shape = new DictionaryResponseShape(
                    parent,
                    className,
                    typedefName,
                    description,
                    Types.Java.Lang.String,
                    mapType(schema.getAdditionalProperties().orElseThrow()),
                    shouldGenerate
                );
                visitedSchemas.putIfAbsent(schema, shape);
            } else {
                var objShape = new ObjectShape(parent, className, typedefName, description, shouldGenerate);
                shape = objShape;
                visitedSchemas.putIfAbsent(schema, shape);

                if (isShortcutPropertyObject) {
                    var oneOf = schema.getOneOf().orElseThrow();
                    var shortcutProperty = oneOf.get(0).getTitle().orElseThrow();
                    objShape.setShortcutProperty(shortcutProperty);
                    schema = oneOf.get(1);
                }

                visitInto(schema, objShape);
            }
        } else {
            throw new NotImplementedException("Unsupported schema: " + schema);
        }

        parent.addShape(shape);

        return shape;
    }

    private void visitInto(OpenApiSchema schema, ObjectShape shape) {
        var allOf = schema.getAllOf();
        if (allOf.isPresent()) {
            var baseSchema = allOf.get().get(0);
            shape.setExtendsType(mapType(baseSchema));
            schema = allOf.get().get(1);
        }

        final var properties = new HashMap<String, OpenApiSchema>();
        final var additionalProperties = new ArrayList<OpenApiSchema>();
        final var required = collectObjectProperties(schema, properties, additionalProperties);

        final var overrides = this.overrides.getSchema(schema.getPointer());

        properties.forEach((k, v) -> {
            var propOverrides = overrides.map(so -> so.getProperty(k));

            var type = propOverrides.flatMap(PropertyOverride::getMappedType).orElseGet(() -> mapType(v));

            var field = new Field(k, type, required.contains(k), v.getDescription().orElse(null), null);

            propOverrides.flatMap(PropertyOverride::getAliases).ifPresent(aliases -> aliases.forEach(field::addAlias));

            shape.addBodyField(field);
        });

        if (!additionalProperties.isEmpty()) {
            var valueSchema = additionalProperties.size() == 1 ? additionalProperties.get(0) : OpenApiSchema.ANONYMOUS_UNTYPED;
            shape.setAdditionalPropertiesField(
                new Field(
                    valueSchema.getTitle().orElse("metadata"),
                    Types.Java.Util.Map(Types.Java.Lang.String, mapType(valueSchema)),
                    false,
                    valueSchema.getDescription().orElse(null),
                    null,
                    true
                )
            );
        }
    }

    private static Set<String> collectObjectProperties(
        OpenApiSchema schema,
        Map<String, OpenApiSchema> properties,
        List<OpenApiSchema> additionalProperties
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

        schema.getProperties().ifPresent(props -> props.forEach((propName, propSchema) -> {
            var resolvedPropSchema = propSchema.resolve();
            var isRemoved = propSchema.getVersionRemoved()
                .or(resolvedPropSchema::getVersionRemoved)
                .map(ver -> ver.isLowerThanOrEqualTo(Versions.V2_0_0))
                .orElse(false);

            if (isRemoved) {
                return;
            }

            var existing = properties.get(propName);
            if (existing != null) {
                var existingType = existing.determineSingleType().orElse(null);
                var newType = propSchema.determineSingleType().orElse(null);
                if (existingType != null
                    && (existingType == OpenApiSchemaType.Object || existingType == OpenApiSchemaType.Array || existingType != newType)) {
                    propSchema = OpenApiSchema.ANONYMOUS_UNTYPED;
                }
            }

            properties.put(propName, propSchema);
        }));

        schema.getAdditionalProperties().ifPresent(additionalProperties::add);

        return schema.getRequired().orElseGet(Collections::emptySet);
    }

    private void visitInto(OpenApiSchema schema, EnumShape shape) {
        var isDeprecated = schema.getVersionDeprecated().isPresent();

        if (schema.hasOneOf()) {
            schema.getOneOf().orElseThrow().forEach(s -> visitInto(s, shape));
        } else if (schema.hasEnums()) {
            var enums = schema.getEnums().orElseThrow();
            var description = enums.size() == 1 ? schema.getDescription().orElse(null) : null;
            enums.forEach(v -> shape.addVariant(v, description, isDeprecated));
        } else if (schema.hasConst()) {
            var value = (String) schema.getConst().orElseThrow();
            shape.addVariant(value, schema.getDescription().orElse(null), isDeprecated);
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
        if (schema.getPointer().isDirectChildOf(JsonPointer.of("components", "schemas"))) {
            var type = mapTypeComponentsSchemas(schema);
            if (type != null) {
                return type;
            }
        }

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

        var oneOf = schema.getOneOf();
        if (oneOf.isPresent()) {
            return mapOneOf(oneOf.get());
        }

        var allOf = schema.getAllOf();
        if (allOf.isPresent()) {
            return mapAllOf(allOf.get());
        }

        var types = schema.getTypes().orElse(null);

        if (types == null || types.size() != 1) {
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

    private Type mapTypeComponentsSchemas(OpenApiSchema schema) {
        var key = schema.getPointer().getLastKey().orElseThrow();
        switch (key) {
            case "_common:Duration":
                return Types.Client.OpenSearch._Types.Time;
            case "_common:Stringifiedinteger":
                return Types.Primitive.Int;
            case "_common:Stringifiedboolean":
                return Types.Primitive.Boolean;
            case "_common:StringifiedEpochTimeUnitMillis":
                return Types.Primitive.Long;
            default:
                return null;
        }
    }

    private Type mapOneOf(List<OpenApiSchema> oneOf) {
        if (isOneOfSingleAndArray(oneOf)) {
            return mapType(oneOf.get(1));
        }

        var types = OpenApiSchema.determineTypes(oneOf);

        if (types.size() == 2
            && types.contains(OpenApiSchemaType.String)
            && (types.contains(OpenApiSchemaType.Boolean)
                || types.contains(OpenApiSchemaType.Integer)
                || types.contains(OpenApiSchemaType.Number))) {
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
        var items = schema.getItems().map(i -> mapType(i, true)).orElse(Types.Java.Lang.String);
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
        var second = oneOf.get(1);
        if (!second.isArray()) {
            return false;
        }
        var first = oneOf.get(0);
        var items = second.getItems().orElseThrow();
        return first.getTypes().equals(items.getTypes()) && first.get$ref().equals(items.get$ref());
    }

    private static boolean isEnum(OpenApiSchema schema) {
        if (schema.isString()) {
            return schema.hasEnums() || schema.hasConst();
        }
        if (schema.getOneOf().isPresent()) {
            return schema.getOneOf().get().stream().allMatch(SpecTransformer::isEnum);
        }
        return false;
    }

    private static boolean isShortcutPropertyObject(OpenApiSchema schema) {
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
            return isTaggedUnion(schema.getOneOf().orElseThrow());
        }
        if (schema.hasAnyOf()) {
            return isTaggedUnion(schema.getAnyOf().orElseThrow());
        }
        return false;
    }

    private static boolean isTaggedUnion(List<OpenApiSchema> oneOfAnyOf) {
        return oneOfAnyOf.stream().allMatch(OpenApiSchema::hasTitle);
    }
}
