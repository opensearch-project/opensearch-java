/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Stream;
import org.apache.commons.lang3.NotImplementedException;
import org.opensearch.client.codegen.openapi.HttpStatus;
import org.opensearch.client.codegen.openapi.MimeType;
import org.opensearch.client.codegen.openapi.OpenApiApiResponse;
import org.opensearch.client.codegen.openapi.OpenApiMediaType;
import org.opensearch.client.codegen.openapi.OpenApiOperation;
import org.opensearch.client.codegen.openapi.OpenApiParameter;
import org.opensearch.client.codegen.openapi.OpenApiProperty;
import org.opensearch.client.codegen.openapi.OpenApiRequestBody;
import org.opensearch.client.codegen.openapi.OpenApiSchema;
import org.opensearch.client.codegen.openapi.OpenApiSpec;

public class SpecTransformer {
    private final Set<String> operationsToGenerate;
    private final Namespace root = new Namespace();
    private final Set<OpenApiSchema> visitedSchemas = new HashSet<>();
    private final Map<OpenApiSchema, Type> schemaToType = new ConcurrentHashMap<>();

    public SpecTransformer(Set<String> operationsToGenerate) {
        this.operationsToGenerate = operationsToGenerate;
    }

    public Namespace getRoot() {
        return root;
    }

    public void visit(OpenApiSpec spec) {
        var groupedOperations = new HashMap<OperationGroup, List<OpenApiOperation>>();

        spec.getOperations().forEach((operation) -> {
            var group = operation.getXOperationGroup();
            if (!operationsToGenerate.contains(group.toString())) return;
            groupedOperations.computeIfAbsent(group, k -> new ArrayList<>()).add(operation);
        });

        groupedOperations.forEach(this::visit);
    }

    private void visit(OperationGroup group, List<OpenApiOperation> variants) {
        var parent = root.child(group.getNamespace());

        var requestShape = visit(parent, group, variants);
        parent.addOperation(requestShape);

        var responseSchema = variants.get(0)
            .getResponses()
            .flatMap(r -> r.get(HttpStatus.OK))
            .map(OpenApiApiResponse::resolve)
            .flatMap(OpenApiApiResponse::getContent)
            .flatMap(c -> c.get(MimeType.JSON))
            .flatMap(OpenApiMediaType::getSchema)
            .map(OpenApiSchema::resolve)
            .orElse(OpenApiSchema.EMPTY);

        visit(parent, requestShape.getResponseType(), responseSchema);
    }

    private RequestShape visit(Namespace parent, OperationGroup group, List<OpenApiOperation> variants) {
        var seenHttpPaths = new HashSet<String>();
        HashSet<String> requiredPathParams = null;
        var allPathParams = new HashMap<String, Field>();
        var canonicalPaths = new HashMap<Set<String>, HttpPath>();
        var deprecatedPaths = new HashMap<Set<String>, HttpPath>();

        var shape = new RequestShape(parent, group, variants.get(0).getDescription());

        for (var variant : variants) {
            shape.addSupportedHttpMethod(variant.getHttpMethod().name());

            var httpPathStr = variant.getHttpPath();
            if (!seenHttpPaths.add(httpPathStr)) continue;

            variant.getAllApplicableParameters(OpenApiParameter.In.PATH).forEach(parameter -> {
                var paramName = parameter.getName();
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
                if (i >= p1Size) return -1;
                if (i >= p2Size) return 1;
                var cmp = params1.get(i).getName().compareTo(params2.get(i).getName());
                if (cmp != 0) return cmp;
            }

            return 0;
        }).forEachOrdered(shape::addHttpPath);

        for (var entry : allPathParams.entrySet()) {
            entry.getValue().setRequired(requiredPathParams.contains(entry.getKey()));
            shape.addPathParam(entry.getValue());
        }

        variants.stream()
            .flatMap(v -> v.getAllApplicableParameters(OpenApiParameter.In.QUERY))
            .map(this::visit)
            .forEachOrdered(shape::addQueryParam);

        var bodySchema = variants.get(0)
            .getRequestBody()
            .map(OpenApiRequestBody::resolve)
            .flatMap(OpenApiRequestBody::getContent)
            .flatMap(c -> c.get(MimeType.JSON))
            .flatMap(OpenApiMediaType::getSchema)
            .map(OpenApiSchema::resolve)
            .orElse(OpenApiSchema.EMPTY);

        visitInto(bodySchema, shape);

        if (shape.getExtendsType() == null) {
            shape.setExtendsType(Types.Client.OpenSearch._Types.RequestBase);
        }

        return shape;
    }

    private Field visit(OpenApiParameter parameter) {
        return new Field(
            parameter.getName(),
            mapType(parameter.getSchema().orElseThrow()),
            parameter.getRequired(),
            parameter.getDescription()
        );
    }

    private Field visit(OpenApiProperty property) {
        return new Field(property.getName(), mapType(property), property.isRequired(), property.getDescription());
    }

    private void visit(OpenApiSchema schema) {
        visit(root.child(schema.getNamespace()), schema.getName(), schema);
    }

    private void visit(Namespace parent, String name, OpenApiSchema schema) {
        if (!visitedSchemas.add(schema)) return;

        Shape shape;

        if (schema.isArray()) {
            shape = new ArrayShape(parent, name, mapType(schema));
        } else if (schema.isObject() || schema.hasAllOf()) {
            var objShape = new ObjectShape(parent, name);
            visitInto(schema, objShape);
            shape = objShape;
        } else if (schema.isString() && schema.hasEnums()) {
            shape = new EnumShape(parent, name, schema.getEnum().orElseThrow().stream().map(EnumShape.Variant::new).toList());
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

        schema.getProperties().map(this::visit).forEachOrdered(shape::addBodyField);

        var additionalProperties = schema.getAdditionalProperties();
        if (additionalProperties.isPresent()) {
            var valueType = mapType(additionalProperties.get());
            shape.setAdditionalPropertiesField(
                new Field(
                    "metadata",
                    Types.Java.Util.Map(Types.Java.Lang.String, valueType),
                    false,
                    additionalProperties.get().getDescription()
                )
            );
        }
    }

    private Type mapType(OpenApiSchema schema) {
        return mapType(schema, false);
    }

    private Type mapType(OpenApiSchema schema, boolean boxed) {
        Type type = schemaToType.get(schema);
        if (type == null) {
            type = mapTypeInner(schema);
            schemaToType.put(schema, type);
        }
        return boxed ? type.getBoxed() : type;
    }

    private Type mapTypeInner(OpenApiSchema schema) {
        if (schema.has$ref()) {
            schema = schema.resolve();

            if (!schema.shouldKeepRef()) {
                return mapType(schema);
            }

            visit(schema);

            return Type.builder()
                .pkg(Types.Client.OpenSearch.PACKAGE + "." + schema.getNamespace())
                .name(schema.getName())
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
            case TIME:
                return Types.Client.OpenSearch._Types.Time;
        }

        throw new UnsupportedOperationException("Can not get type name for: " + type);
    }

    private Type mapOneOf(List<OpenApiSchema> oneOf) {
        if (oneOf.size() == 2) {
            var first = oneOf.get(0).resolve();
            var second = oneOf.get(1).resolve();

            if (first.isString() && second.isArray()) {
                return mapType(second);
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
        var format = schema.getFormat().orElse(OpenApiSchema.Format.INT32);
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
}
