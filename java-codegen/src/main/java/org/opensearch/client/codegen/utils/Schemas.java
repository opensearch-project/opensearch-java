/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.opensearch.client.codegen.utils.OpenApiKeywords.REF_LOCAL_COMPONENTS_PREFIX;
import static org.opensearch.client.codegen.utils.OpenApiKeywords.TYPE_ARRAY;
import static org.opensearch.client.codegen.utils.OpenApiKeywords.TYPE_OBJECT;
import static org.opensearch.client.codegen.utils.OpenApiKeywords.TYPE_STRING;

public final class Schemas {
    public static String getType(Schema<?> schema) {
        if (schema == null) return null;
        var xDataType = Extensions.of(schema).dataType();
        if (xDataType != null) return xDataType;
        return schema.getType();
    }

    public static boolean is(Schema<?> schema, String type) {
        return type.equals(getType(schema));
    }

    public static boolean isObject(Schema<?> schema) {
        return is(schema, TYPE_OBJECT);
    }

    public static boolean isString(Schema<?> schema) {
        return is(schema, TYPE_STRING);
    }

    public static boolean isArray(Schema<?> schema) {
        return is(schema, TYPE_ARRAY);
    }

    public static boolean hasEnums(Schema<?> schema) {
        return schema != null && schema.getEnum() != null && !schema.getEnum().isEmpty();
    }

    private static <T> Optional<T> resolve(Map<String, T> components, T item, Function<T, String> get$ref) {
        String $ref;
        while (item != null && ($ref = get$ref.apply(item)) != null) {
            if (!$ref.startsWith(REF_LOCAL_COMPONENTS_PREFIX)) {
                throw new IllegalStateException("Non-relative reference: " + $ref);
            }

            var parts = $ref.split("/");

            item = components.get(parts[parts.length - 1]);

            if (item == null) {
                throw new IllegalStateException("Failed to resolve reference: " + $ref);
            }
        }
        return Optional.ofNullable(item);
    }

    public static Optional<RequestBody> resolve(OpenAPI api, RequestBody body) {
        return resolve(api.getComponents().getRequestBodies(), body, RequestBody::get$ref);
    }

    public static Optional<ApiResponse> resolve(OpenAPI api, ApiResponse body) {
        return resolve(api.getComponents().getResponses(), body, ApiResponse::get$ref);
    }

    public static Optional<Schema<?>> resolve(OpenAPI context, Schema<?> schema) {
        return resolve(context.getComponents().getSchemas(), schema, Schema::get$ref).map(s -> (Schema<?>) s);
    }

    public static Optional<Schema<?>> resolveRequestBodySchema(OpenAPI api, Operation operation) {
        return Schemas.resolve(api, operation.getRequestBody())
                .map(body -> body.getContent().get(MediaType.JSON))
                .flatMap(media -> Schemas.resolve(api, media.getSchema()));
    }

    public static Optional<Schema<?>> resolveResponseBodySchema(OpenAPI api, Operation operation) {
        return Schemas.resolve(api, operation.getResponses().get("200"))
                .map(response -> response.getContent().get(MediaType.JSON))
                .flatMap(media -> Schemas.resolve(api, media.getSchema()));
    }

    public static void forEachProperty(Schema<?> schema, TriConsumer<String, Schema<?>, Boolean> propertyVisitor) {
        var properties = schema.getProperties();

        if (properties == null) return;

        var requiredFields = new HashSet<>(schema.getRequired() != null ? schema.getRequired() : new ArrayList<>(0));

        properties.forEach((name, propertySchema) -> propertyVisitor.accept(name, propertySchema, requiredFields.contains(name)));
    }

    public static Stream<Parameter> getParametersIn(PathItem path, Operation operation, String in) {
        return Stream.of(path.getParameters(), operation.getParameters())
                .flatMap(l -> l != null ? l.stream() : Stream.empty())
                .filter(p -> in.equals(p.getIn()));
    }
}
