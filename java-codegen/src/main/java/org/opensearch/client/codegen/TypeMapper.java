/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.function.TriConsumer;
import org.opensearch.client.codegen.model.Type;
import org.opensearch.client.codegen.model.Types;
import org.opensearch.client.codegen.openapi.OpenApiSchema;

public class TypeMapper {
    private final Map<OpenApiSchema, Type> cache = new ConcurrentHashMap<>();
    private final TriConsumer<String, String, OpenApiSchema> referencedSchemaVisitor;

    public TypeMapper(TriConsumer<String, String, OpenApiSchema> referencedSchemaVisitor) {
        this.referencedSchemaVisitor = referencedSchemaVisitor;
    }

    public Type mapType(OpenApiSchema schema) {
        return mapType(schema, false);
    }

    public Type mapType(OpenApiSchema schema, boolean boxed) {
        var type = cache.get(schema);
        if (type == null) {
            type = mapTypeInner(schema);
            cache.put(schema, type);
        }
        return boxed ? type.boxed() : type;
    }

    private Type mapTypeInner(OpenApiSchema schema) {
        if (schema.get$ref() != null) {
            var target = schema.resolve();

            if (!target.shouldKeepRef()) {
                return mapType(target);
            }

            var $ref = schema.get$ref();

            var schemaFile = target.getParent().getLocation().getPath();
            var namespace = schemaFile.substring(schemaFile.lastIndexOf('/') + 1, schemaFile.lastIndexOf('.'));
            var name = $ref.substring($ref.lastIndexOf('/') + 1);

            referencedSchemaVisitor.accept(namespace, name, target);

            return Type.builder().schema(target).pkg(Types.Client.OpenSearch.PACKAGE + "." + namespace).name(name).build();
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
