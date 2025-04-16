/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.transformer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
        return mapType(schema, false);
    }

    public TypeRef mapType(OpenApiSchema schema, boolean boxed) {
        return (boxed ? mapTypeBoxedMemo : mapTypeMemo).get(schema);
    }

    private final Memoizer<OpenApiSchema, TypeRef> mapTypeMemo = new Memoizer<>(this::mapTypeInner);
    private final Memoizer<OpenApiSchema, TypeRef> mapTypeBoxedMemo = new Memoizer<>(s -> mapTypeMemo.get(s).getBoxed());

    private TypeRef mapTypeInner(OpenApiSchema schema) {
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

    private TypeRef mapOneOf(List<OpenApiSchema> oneOf) {
        oneOf = oneOf.stream().filter(s -> !s.isNull()).collect(Collectors.toList());

        if (oneOf.size() == 1) {
            return mapType(oneOf.get(0));
        } else if (isOneOfSingleAndArray(oneOf)) {
            return mapType(oneOf.stream().filter(OpenApiSchema::isArray).findFirst().orElseThrow());
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

    private TypeRef mapInstantiatedGeneric(OpenApiSchema schema) {
        var $extends = schema.get$extends().orElseThrow();
        var type = mapType($extends);
        var shape = type.getTargetShape().orElseThrow();
        var typeParameterDefs = shape.getTypeParameters().getTypeParameterDefinitions();
        var typeParameters = new HashMap<String, TypeRef>();

        while ($extends != null) {
            $extends = $extends.resolve();

            new ZippedOpenApiWalker().walkSchema($extends, schema, new ZippedOpenApiVisitorBase() {
                @Override
                public void visitSchemaEnd(@Nullable OpenApiSchema left, @Nullable OpenApiSchema right) {
                    if (left == null || right == null || !left.isGenericTypeParameter()) {
                        return;
                    }
                    typeParameters.put(getTypeParamName(left.resolve()), mapType(right));
                }
            });

            $extends = $extends.get$extends().orElse(null);
        }

        return shape.getMaterializedType()
            .withTypeParameters(
                Arrays.stream(typeParameterDefs)
                    .map(TypeParameterDefinition::getName)
                    .map(n -> typeParameters.getOrDefault(n, Types.Client.Json.JsonData))
                    .map(TypeRef::getBoxed)
                    .toArray(TypeRef[]::new)
            );
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
