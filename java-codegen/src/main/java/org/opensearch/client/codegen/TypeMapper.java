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
import org.opensearch.client.codegen.model.Types;
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
            var target = Schemas.resolve(openApi, schema).orElseThrow();

            if (!shouldKeepRef(target)) {
                return mapType(target);
            }

            var $ref = schema.get$ref();

            referencedSchemaVisitor.accept($ref, target);

            var ref = ComponentSchemaRef.from($ref);
            var pkg = Types.Client.OpenSearch.PACKAGE;
            if (ref.namespace() != null && !ref.namespace().isEmpty()) {
                pkg += "." + ref.namespace();
            }

            return Type.builder()
                    .schema(target)
                    .pkg(pkg)
                    .name(ref.name())
                    .build();
        }

        if (schema.getOneOf() != null) {
            var oneOf = schema.getOneOf();
            if (oneOf.size() == 2) {
                var first = Schemas.resolve(openApi, oneOf.get(0)).orElseThrow();
                var second = Schemas.resolve(openApi, oneOf.get(1)).orElseThrow();

                if (Schemas.isString(first) && Schemas.isArray(second)) {
                    return mapType(second);
                }
            }

            throw new UnsupportedOperationException("Can not get type name for oneOf: " + schema);
        }

        var type = Schemas.getType(schema);

        if (type == null) {
            return Types.Client.Json.JsonData;
        }

        var format = schema.getFormat();

        switch (type) {
            case TYPE_OBJECT:
                var additionalProperties = schema.getAdditionalProperties();
                if (additionalProperties instanceof Schema<?>) {
                    return Types.Java.Util.Map(Types.Java.Lang.String, mapType((Schema<?>) additionalProperties, true));
                }
                return Types.Java.Util.Map(Types.Java.Lang.String, Types.Client.Json.JsonData);
            case TYPE_ARRAY:
                if (schema.getItems() == null) return Types.Java.Util.List(Types.Java.Lang.String);
                return Types.Java.Util.List(mapType(schema.getItems(), true));
            case TYPE_STRING:
                return Types.Java.Lang.String;
            case TYPE_BOOLEAN:
                return Types.Primitive.Boolean;
            case TYPE_INTEGER:
            case TYPE_NUMBER:
                if (format == null) format = FORMAT_INT32;
                switch (format) {
                    case FORMAT_INT32:
                        return Types.Primitive.Int;
                    case FORMAT_INT64:
                        return Types.Primitive.Long;
                    case FORMAT_FLOAT:
                        return Types.Primitive.Float;
                    case FORMAT_DOUBLE:
                        return Types.Primitive.Double;
                    default:
                        throw new UnsupportedOperationException("Can not get type name for integer/number with format: " + format);
                }
            case TYPE_TIME:
                return Types.Client.OpenSearch._Types.Time;
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
