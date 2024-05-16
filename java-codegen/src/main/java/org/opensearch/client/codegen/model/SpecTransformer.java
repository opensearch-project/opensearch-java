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
import org.opensearch.client.codegen.openapi.HttpStatusCode;
import org.opensearch.client.codegen.openapi.In;
import org.opensearch.client.codegen.openapi.MimeType;
import org.opensearch.client.codegen.openapi.OpenApiMediaType;
import org.opensearch.client.codegen.openapi.OpenApiOperation;
import org.opensearch.client.codegen.openapi.OpenApiParameter;
import org.opensearch.client.codegen.openapi.OpenApiPath;
import org.opensearch.client.codegen.openapi.OpenApiRequestBody;
import org.opensearch.client.codegen.openapi.OpenApiResponse;
import org.opensearch.client.codegen.openapi.OpenApiSchema;
import org.opensearch.client.codegen.openapi.OpenApiSchemaFormat;
import org.opensearch.client.codegen.openapi.OpenApiSpecification;

public class SpecTransformer {
    @Nonnull
    private final OperationGroup.Matcher matcher;
    @Nonnull
    private final Namespace root = new Namespace();
    @Nonnull
    private final Set<OpenApiSchema> visitedSchemas = new HashSet<>();
    @Nonnull
    private final Map<OpenApiSchema, Type> schemaToType = new ConcurrentHashMap<>();

    public SpecTransformer(@Nonnull OperationGroup.Matcher matcher) {
        this.matcher = Objects.requireNonNull(matcher, "matcher must not be null");
    }

    @Nonnull
    public Namespace getRoot() {
        return root;
    }

    public void visit(@Nonnull OpenApiSpecification spec) {
        Objects.requireNonNull(spec, "spec must not be null");

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
    }

    private void visit(@Nonnull OperationGroup group, @Nonnull List<OpenApiOperation> variants) {
        var parent = root.child(group.getNamespace().orElse(null));

        var requestShape = visit(parent, group, variants);
        parent.addOperation(requestShape);

        var responseSchema = variants.stream()
            .map(OpenApiOperation::getResponses)
            .flatMap(Optional::stream)
            .findFirst()
            .flatMap(r -> r.get(HttpStatusCode.OK))
            .map(OpenApiResponse::resolve)
            .flatMap(OpenApiResponse::getContent)
            .flatMap(c -> c.get(MimeType.JSON))
            .flatMap(OpenApiMediaType::getSchema)
            .map(OpenApiSchema::resolve)
            .orElse(OpenApiSchema.ANONYMOUS_OBJECT);

        visit(parent, requestShape.getResponseType(), group + ".Response", responseSchema);
    }

    @Nonnull
    private RequestShape visit(@Nonnull Namespace parent, @Nonnull OperationGroup group, @Nonnull List<OpenApiOperation> variants) {
        var seenHttpPaths = new HashSet<String>();
        HashSet<String> requiredPathParams = null;
        var allPathParams = new HashMap<String, Field>();
        var canonicalPaths = new HashMap<Set<String>, HttpPath>();
        var deprecatedPaths = new HashMap<Set<String>, HttpPath>();

        var description = variants.stream().map(OpenApiOperation::getDescription).flatMap(Optional::stream).findFirst().orElse(null);

        var shape = new RequestShape(parent, group, description);

        for (var variant : variants) {
            shape.addSupportedHttpMethod(variant.getHttpMethod().name());

            var httpPathStr = variant.getHttpPath();
            if (!seenHttpPaths.add(httpPathStr)) {
                continue;
            }

            variant.getAllRelevantParameters(In.PATH).forEach(parameter -> {
                var paramName = parameter.getName().orElseThrow();
                if (!allPathParams.containsKey(paramName)) {
                    allPathParams.put(paramName, visit(parameter));
                }
            });

            var httpPath = HttpPath.from(httpPathStr, variant, allPathParams);

            (httpPath.getDeprecation() == null ? canonicalPaths : deprecatedPaths).put(httpPath.getParamNameSet(), httpPath);

            if (requiredPathParams != null) {
                requiredPathParams.retainAll(httpPath.getParamNameSet());
            } else {
                requiredPathParams = new HashSet<>(httpPath.getParamNameSet());
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

        variants.stream().flatMap(v -> v.getAllRelevantParameters(In.QUERY).stream()).map(this::visit).forEachOrdered(shape::addQueryParam);

        var bodySchema = variants.stream()
            .map(OpenApiOperation::getRequestBody)
            .flatMap(Optional::stream)
            .findFirst()
            .map(OpenApiRequestBody::resolve)
            .flatMap(OpenApiRequestBody::getContent)
            .flatMap(c -> c.get(MimeType.JSON))
            .flatMap(OpenApiMediaType::getSchema)
            .map(OpenApiSchema::resolve)
            .orElse(OpenApiSchema.ANONYMOUS_OBJECT);

        visitInto(bodySchema, shape);

        if (shape.getExtendsType() == null) {
            shape.setExtendsType(Types.Client.OpenSearch._Types.RequestBase);
        }

        return shape;
    }

    private Field visit(OpenApiParameter parameter) {
        return new Field(
            parameter.getName().orElseThrow(),
            mapType(parameter.getSchema().orElseThrow()),
            parameter.getRequired(),
            parameter.getDescription().orElse(null)
        );
    }

    private void visit(OpenApiSchema schema) {
        var namespace = schema.getNamespace().orElseThrow();
        var name = schema.getName().orElseThrow();
        visit(root.child(namespace), name, namespace + "." + name, schema);
    }

    private void visit(Namespace parent, String className, String typedefName, OpenApiSchema schema) {
        if (!visitedSchemas.add(schema)) {
            return;
        }

        Shape shape;

        if (schema.isArray()) {
            shape = new ArrayShape(parent, className, mapType(schema), typedefName);
        } else if (schema.isObject() || schema.hasAllOf() || schema.equals(OpenApiSchema.ANONYMOUS_OBJECT)) {
            var objShape = new ObjectShape(parent, className, typedefName);
            visitInto(schema, objShape);
            shape = objShape;
        } else if (schema.isString() && schema.hasEnums()) {
            shape = new EnumShape(
                parent,
                className,
                schema.getEnums().orElseThrow().stream().map(EnumShape.Variant::new).toList(),
                typedefName
            );
        } else if (schema.hasOneOf()) {
            var taggedUnion = new TaggedUnionShape(parent, className, typedefName);
            schema.getOneOf().orElseThrow().forEach(s -> taggedUnion.addVariant(s.resolve().getName().orElseThrow(), mapType(s)));
            shape = taggedUnion;
        } else {
            throw new NotImplementedException("Unsupported schema: " + schema);
        }

        parent.addShape(shape);
    }

    private void visitInto(OpenApiSchema schema, ObjectShape shape) {
        var allOf = schema.getAllOf();
        if (allOf.isPresent()) {
            shape.setExtendsType(mapType(allOf.get().get(0)));
            schema = allOf.get().get(1);
        }

        final var required = schema.getRequired().orElse(Collections.emptySet());
        schema.getProperties()
            .ifPresent(
                props -> props.forEach(
                    (k, v) -> shape.addBodyField(new Field(k, mapType(v), required.contains(k), v.getDescription().orElse(null)))
                )
            );

        var additionalProperties = schema.getAdditionalProperties();
        if (additionalProperties.isPresent()) {
            var valueType = mapType(additionalProperties.get());
            shape.setAdditionalPropertiesField(
                new Field(
                    "metadata",
                    Types.Java.Util.Map(Types.Java.Lang.String, valueType),
                    false,
                    additionalProperties.get().getDescription().orElse(null)
                )
            );
        }
    }

    private Type mapType(OpenApiSchema schema) {
        return mapType(schema, false);
    }

    private Type mapType(OpenApiSchema schema, boolean boxed) {
        var type = schemaToType.computeIfAbsent(schema, this::mapTypeInner);
        return boxed ? type.getBoxed() : type;
    }

    private Type mapTypeInner(OpenApiSchema schema) {
        if (schema.has$ref()) {
            schema = schema.resolve();

            if (!shouldKeepRef(schema)) {
                return mapType(schema);
            }

            visit(schema);

            return Type.builder()
                .pkg(Types.Client.OpenSearch.PACKAGE + "." + schema.getNamespace())
                .name(schema.getName().orElseThrow())
                .isEnum(schema.hasEnums())
                .build();
        }

        var oneOf = schema.getOneOf();
        if (oneOf.isPresent()) {
            return mapOneOf(oneOf.get());
        }

        var type = schema.getType();

        if (type.isEmpty()) {
            return Types.Client.Json.JsonData;
        }

        switch (type.get()) {
            case OBJECT:
                return mapObject(schema);
            case ARRAY:
                return mapArray(schema);
            case STRING:
                return Types.Java.Lang.String;
            case BOOLEAN:
                return Types.Primitive.Boolean;
            case INTEGER:
            case NUMBER:
                return mapNumber(schema);
        }

        throw new UnsupportedOperationException("Can not get type name for: " + type);
    }

    private Type mapOneOf(List<OpenApiSchema> oneOf) {
        if (oneOf.size() == 2) {
            var first = oneOf.get(0);
            var second = oneOf.get(1);

            if (second.isArray()) {
                var items = second.getItems().orElseThrow();

                if (first.getType().equals(items.getType()) && first.get$ref().equals(items.get$ref())) {
                    return mapType(second);
                }
            }

            if ((first.isString() && (second.isString() || second.isNumber())) || (first.isNumber() && second.isString())) {
                return Types.Java.Lang.String;
            }

            if (first.isBoolean() && second.isString()) {
                return Types.Primitive.Boolean;
            }
        }

        throw new UnsupportedOperationException("Can not get type name for oneOf: " + oneOf);
    }

    private Type mapObject(OpenApiSchema schema) {
        var values = schema.getAdditionalProperties().map(s -> mapType(s, true)).orElse(Types.Client.Json.JsonData);
        return Types.Java.Util.Map(Types.Java.Lang.String, values);
    }

    private Type mapArray(OpenApiSchema schema) {
        var items = schema.getItems().map(i -> mapType(i, true)).orElse(Types.Java.Lang.String);
        return Types.Java.Util.List(items);
    }

    private Type mapNumber(OpenApiSchema schema) {
        var format = schema.getFormat().orElse(OpenApiSchemaFormat.INT32);
        switch (format) {
            case INT32:
                return Types.Primitive.Int;
            case INT64:
                return Types.Primitive.Long;
            case FLOAT:
                return Types.Primitive.Float;
            case DOUBLE:
                return Types.Primitive.Double;
            default:
                throw new UnsupportedOperationException("Can not get type name for integer/number with format: " + format);
        }
    }

    private boolean shouldKeepRef(OpenApiSchema schema) {
        var type = schema.getType();
        if (type.isEmpty()) {
            if (schema.hasOneOf()) {
                return schema.getOneOf().orElseThrow().get(0).resolve().isObject();
            }
            return false;
        }
        switch (type.get()) {
            case OBJECT:
                return true;
            case STRING:
                return schema.hasEnums();
            default:
                return false;
        }
    }
}
