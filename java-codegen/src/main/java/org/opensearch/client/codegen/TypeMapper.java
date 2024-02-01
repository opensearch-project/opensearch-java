/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen;

import static org.opensearch.client.codegen.utils.OpenApiKeywords.*;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import org.opensearch.client.codegen.model.Type;
import org.opensearch.client.codegen.utils.ComponentSchemaRef;
import org.opensearch.client.codegen.utils.Schemas;

public class TypeMapper {
    private final OpenAPI openApi;
    private final Map<Schema<?>, Type> cache = new ConcurrentHashMap<>();
    private final BiConsumer<String, Schema<?>> referencedSchemaVisitor;

    public TypeMapper(OpenAPI api, BiConsumer<String, Schema<?>> referencedSchemaVisitor) {
        this.openApi = api;
        this.referencedSchemaVisitor = referencedSchemaVisitor;
    }

    public Type mapType(Schema<?> schema) {
        return mapType(schema, false);
    }

    public Type mapType(Schema<?> schema, boolean boxed) {
        var type = cache.get(schema);
        if (type == null) {
            type = mapTypeInner(schema);
            cache.put(schema, type);
        }
        return boxed ? type.boxed() : type;
    }

    private Type mapTypeInner(Schema<?> schema) {
        if (schema.get$ref() != null) {
            var target = Schemas.resolve(openApi, schema).get();

            if (!shouldKeepRef(target)) {
                return mapType(target);
            }

            if (Schemas.isObject(target) && target.getProperties() == null) {
                return new Type(target, "Map", "String", "JsonData");
            }

            var $ref = schema.get$ref();

            referencedSchemaVisitor.accept($ref, target);

            return new Type(target, ComponentSchemaRef.from($ref).name());
        }

        if (schema.getOneOf() != null) {
            var oneOf = schema.getOneOf();
            if (oneOf.size() == 2) {
                var first = oneOf.get(0);
                var second = oneOf.get(1);

                if (first.getType() == null && first.get$ref() != null && Schemas.isArray(second) && first.get$ref().equals(second.getItems().get$ref())) {
                    return mapType(second);
                }
            }

            throw new UnsupportedOperationException("Can not get type name for oneOf: " + schema);
        }

        var type = schema.getType();

        if (type == null) {
            return new Type(schema, "JsonData");
        }

        var format = schema.getFormat();

        switch (type) {
            case TYPE_ARRAY:
                return new Type(schema, "List", mapType(schema.getItems(), true));
            case TYPE_STRING:
                return new Type(schema, "String");
            case TYPE_BOOLEAN:
                return new Type(schema, "boolean");
            case TYPE_INTEGER:
                if (format == null) format = FORMAT_INT32;
                switch (format) {
                    case FORMAT_INT32:
                        return new Type(schema, "int");
                    case FORMAT_INT64:
                        return new Type(schema, "long");
                    default:
                        throw new UnsupportedOperationException("Can not get type name for integer with format: " + format);
                }
            case TYPE_NUMBER:
                switch (format) {
                    case FORMAT_FLOAT:
                        return new Type(schema, "float");
                    case FORMAT_DOUBLE:
                        return new Type(schema, "double");
                    default:
                        throw new UnsupportedOperationException("Can not get type name for number with format: " + format);
                }
        }

        throw new UnsupportedOperationException("Can not get type name for: " + type);
    }

    private boolean shouldKeepRef(Schema<?> schema) {
        if (Schemas.isObject(schema)) {
            return true;
        }

        if (Schemas.isString(schema)) {
            return Schemas.hasEnums(schema);
        }

        return false;
    }
}
