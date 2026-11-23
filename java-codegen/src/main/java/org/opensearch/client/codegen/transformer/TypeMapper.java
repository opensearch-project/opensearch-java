/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.transformer;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.model.ObjectShapeBase;
import org.opensearch.client.codegen.model.types.Type;
import org.opensearch.client.codegen.model.types.TypeParameterDefinition;
import org.opensearch.client.codegen.model.types.TypeParameterRef;
import org.opensearch.client.codegen.model.types.TypeRef;
import org.opensearch.client.codegen.model.types.Types;
import org.opensearch.client.codegen.openapi.OpenApiSchema;
import org.opensearch.client.codegen.openapi.OpenApiSchemaFormat;
import org.opensearch.client.codegen.openapi.OpenApiSchemaType;
import org.opensearch.client.codegen.openapi.walker.ZippedOpenApiVisitorBase;
import org.opensearch.client.codegen.openapi.walker.ZippedOpenApiWalker;
import org.opensearch.client.codegen.transformer.overrides.Overrides;
import org.opensearch.client.codegen.transformer.overrides.SchemaOverride;
import org.opensearch.client.codegen.utils.Memoizer;
import org.opensearch.client.codegen.utils.NameSanitizer;

public class TypeMapper {
    @Nonnull
    private final SpecTransformer specTransformer;
    @Nonnull
    private final Overrides overrides;

    public TypeMapper(@Nonnull SpecTransformer specTransformer, @Nonnull Overrides overrides) {
        this.specTransformer = Objects.requireNonNull(specTransformer, "specTransformer cannot be null");
        this.overrides = Objects.requireNonNull(overrides, "overrides cannot be null");
    }

    public TypeRef mapType(OpenApiSchema schema) {
        return mapType(schema, false, schema.allowsNull());
    }

    public TypeRef mapType(OpenApiSchema schema, boolean boxed, boolean nullable) {
        return (boxed ? mapTypeBoxedMemo : mapTypeMemo).get(schema, nullable);
    }

    private final Memoizer<OpenApiSchema, TypeRef> mapTypeMemo = new Memoizer<>(this::mapTypeInner);
    private final Memoizer<OpenApiSchema, TypeRef> mapTypeBoxedMemo = new Memoizer<>(
        (s, nullable) -> mapTypeMemo.get(s, nullable).getBoxed()
    );

    private TypeRef mapTypeInner(OpenApiSchema schema, boolean nullable) {
        if (schema.has$ref()) {
            schema = schema.resolve();

            var overriddenMappedType = overrides.getSchema(schema.getPointer()).flatMap(SchemaOverride::getMappedType);

            if (overriddenMappedType.isPresent()) {
                return overriddenMappedType.get();
            }

            if (!shouldKeepRef(schema)) {
                return mapType(schema);
            }

            var shape = specTransformer.visit(schema);

            return shape.getType();
        }

        if (schema.isGenericTypeParameter()) {
            return new TypeParameterRef(getTypeParamName(schema));
        }

        if (isSingleKeyMap(schema)) {
            var value = schema.getAdditionalProperties().orElseThrow();
            if (value.has$ref()) {
                var keySchema = schema.getPropertyNames().orElseGet(OpenApiSchema::string);
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

        if (schema.isInstantiatedGeneric()) {
            return mapInstantiatedGeneric(schema);
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
                return mapObject(schema, nullable);
            case Array:
                return mapArray(schema, nullable);
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

    private TypeRef mapOneOf(List<OpenApiSchema> oneOf) {
        final boolean nullable = oneOf.stream().anyMatch(OpenApiSchema::isNull);
        oneOf = oneOf.stream().filter(s -> !s.isNull()).collect(Collectors.toList());

        if (oneOf.size() == 1) {
            return mapType(oneOf.get(0));
        } else if (isOneOfSingleAndArray(oneOf)) {
            final OpenApiSchema type = oneOf.stream().filter(OpenApiSchema::isArray).findFirst().orElseThrow();
            return mapType(type, false, nullable);
        }

        var types = oneOf.stream().flatMap(s -> s.getTypes().orElseThrow().stream()).collect(Collectors.toSet());

        if (types.size() == 1) {
            var formats = oneOf.stream().map(s -> s.getFormat().orElse(null)).collect(Collectors.toSet());
            switch (types.iterator().next()) {
                case String:
                    return Types.Java.Lang.String;
                case Boolean:
                    return Types.Primitive.Boolean;
                case Integer:
                    return Types.Primitive.Int;
                case Number:
                    var formatCount = formats.size();
                    if (formatCount == 1 && formats.contains(OpenApiSchemaFormat.Float)) {
                        return Types.Primitive.Float;
                    } else if (formats.contains(OpenApiSchemaFormat.Double)
                        && (formatCount == 1 || (formatCount == 2 && formats.contains(OpenApiSchemaFormat.Float)))) {
                            return Types.Primitive.Double;
                        } else {
                            return Types.Java.Lang.Number;
                        }
            }
        }

        if (types.size() == 2) {
            if (types.contains(OpenApiSchemaType.Integer) && types.contains(OpenApiSchemaType.Number)) {
                return Types.Java.Lang.Number;
            }
        }

        return Types.Client.Json.JsonData;
    }

    private Type mapAnyOf(List<OpenApiSchema> anyOf) {
        var types = anyOf.stream().flatMap(s -> s.getTypes().orElseThrow().stream()).collect(Collectors.toSet());
        types.remove(OpenApiSchemaType.Null);

        if (types.size() == 1) {
            var formats = anyOf.stream().map(s -> s.getFormat().orElse(null)).collect(Collectors.toSet());
            switch (types.iterator().next()) {
                case String:
                    return Types.Java.Lang.String;
                case Boolean:
                    return Types.Primitive.Boolean;
                case Integer:
                    return Types.Primitive.Int;
                case Number:
                    var formatCount = formats.size();
                    if (formatCount == 1 && formats.contains(OpenApiSchemaFormat.Float)) {
                        return Types.Primitive.Float;
                    } else if (formats.contains(OpenApiSchemaFormat.Double)
                        && (formatCount == 1 || (formatCount == 2 && formats.contains(OpenApiSchemaFormat.Float)))) {
                            return Types.Primitive.Double;
                        } else {
                            return Types.Java.Lang.Number;
                        }
            }
        }

        if (types.size() == 2) {
            if (types.contains(OpenApiSchemaType.Integer) && types.contains(OpenApiSchemaType.Number)) {
                return Types.Java.Lang.Number;
            }
        }

        return Types.Client.Json.JsonData;
    }

    private TypeRef mapAllOf(List<OpenApiSchema> allOf) {
        if (allOf.size() == 1) {
            return mapType(allOf.get(0));
        }

        if (allOf.size() > 1) {
            // Later allOf members specialize earlier ones, so the last member is the most specific type,
            // e.g. a generic `Buckets` narrowed to a concrete bucket type in each multi-bucket aggregate.
            return mapType(allOf.get(allOf.size() - 1));
        }

        throw new UnsupportedOperationException("Can not get type name for allOf: " + allOf);
    }

    private Type mapObject(OpenApiSchema schema, boolean nullable) {
        var values = schema.getAdditionalProperties().map(s -> mapType(s, true, nullable)).orElse(Types.Client.Json.JsonData);
        return Types.Java.Util.Map(Types.Java.Lang.String, values, nullable);
    }

    private Type mapArray(OpenApiSchema schema, boolean nullable) {
        var items = schema.getItems().map(i -> mapType(i, true, nullable)).orElse(Types.Client.Json.JsonData);
        return Types.Java.Util.List(items, nullable);
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

    private TypeRef mapInstantiatedGeneric(OpenApiSchema schema) {
        var $extends = schema.get$extends().orElseThrow();
        var type = mapType($extends);
        var shape = type.getTargetShape().orElseThrow();
        // The generic shape's type parameters are collected as its fields are added. When it is instantiated while it is
        // still being visited (a cycle: Hit -> inner_hits -> HitsMetadata -> Hit<TDocument>), none are known yet, and the
        // parameters found by zipping the generic schema with this instantiation are used instead.
        var shapeTypeParameters = shape.getTypeParameters();
        var typeParameters = new LinkedHashMap<String, TypeRef>();

        while ($extends != null) {
            $extends = $extends.resolve();

            new ZippedOpenApiWalker().walkSchema($extends, schema, new ZippedOpenApiVisitorBase() {
                @Override
                public void visitSchemaEnd(@Nullable OpenApiSchema left, @Nullable OpenApiSchema right) {
                    if (left == null || right == null) {
                        return;
                    }
                    if (left.isGenericTypeParameter()) {
                        typeParameters.put(getTypeParamName(left.resolve()), mapType(right));
                        return;
                    }
                    // A generic union narrowed to one of its branches: the generic declares e.g. `Buckets<TBucket>` as
                    // `oneOf: [map of TBucket, array of TBucket]` while the instantiation declares only `array of X`.
                    // The zipped walk never pairs TBucket with X, so bind it from the branch whose container kind matches.
                    var leftOneOf = left.getOneOf();
                    if (leftOneOf.isEmpty() || right.hasOneOf()) {
                        return;
                    }
                    for (var branch : leftOneOf.get()) {
                        var resolvedBranch = branch.resolve();
                        bindIfTypeParameter(resolvedBranch.getItems(), right.getItems());
                        bindIfTypeParameter(resolvedBranch.getAdditionalProperties(), right.getAdditionalProperties());
                    }
                }

                private void bindIfTypeParameter(Optional<OpenApiSchema> leftChild, Optional<OpenApiSchema> rightChild) {
                    if (leftChild.isEmpty() || rightChild.isEmpty()) {
                        return;
                    }
                    var resolvedLeft = leftChild.get().resolve();
                    if (resolvedLeft.isGenericTypeParameter()) {
                        typeParameters.put(getTypeParamName(resolvedLeft), mapType(rightChild.get()));
                    }
                }
            });

            $extends = $extends.get$extends().orElse(null);
        }

        var typeParameterNames = shapeTypeParameters != null
            ? Arrays.stream(shapeTypeParameters.getTypeParameterDefinitions()).map(TypeParameterDefinition::getName)
            : genericParameterNames(schema.get$extends().orElseThrow()).stream();
        return shape.getMaterializedType()
            .withTypeParameters(
                typeParameterNames.map(n -> typeParameters.getOrDefault(n, Types.Client.Json.JsonData))
                    .map(TypeRef::getBoxed)
                    .toArray(TypeRef[]::new)
            );
    }

    // The generic type parameters a generic schema (and the schemas it extends) declares, in the order they appear.
    private static Set<String> genericParameterNames(OpenApiSchema generic) {
        var names = new LinkedHashSet<String>();
        for (var schema = generic; schema != null; schema = schema.resolve().get$extends().orElse(null)) {
            var resolved = schema.resolve();
            new ZippedOpenApiWalker().walkSchema(resolved, resolved, new ZippedOpenApiVisitorBase() {
                @Override
                public void visitSchemaEnd(@Nullable OpenApiSchema left, @Nullable OpenApiSchema right) {
                    if (left != null && left.isGenericTypeParameter()) names.add(getTypeParamName(left.resolve()));
                }
            });
        }
        return names;
    }

    private boolean shouldKeepRef(OpenApiSchema schema) {
        if (schema.isEnum()) {
            return true;
        }
        if (schema.isObject()
            && schema.getProperties().map(Map::isEmpty).orElse(true)
            && schema.getAdditionalProperties().map(s -> s.getTitle().isEmpty()).orElse(false)) {
            return false;
        }
        if (schema.isInstantiatedGeneric()) {
            return false;
        }
        if (schema.isTaggedUnion()) {
            return true;
        }
        if (schema.isShortcutPropertyObject()) {
            return true;
        }
        return schema.isObject();
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

    private static boolean isSingleKeyMap(OpenApiSchema schema) {
        return schema.isObject()
            && !schema.hasProperties()
            && schema.hasAdditionalProperties()
            && schema.getMinProperties().orElse(0) == 1
            && schema.getMaxProperties().orElse(Integer.MAX_VALUE) == 1;
    }

    private static String getTypeParamName(OpenApiSchema schema) {
        var parts = schema.getName().orElseThrow().split("\\.");
        return parts[parts.length - 1];
    }
}
