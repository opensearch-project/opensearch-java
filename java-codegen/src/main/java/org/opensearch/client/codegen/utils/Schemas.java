/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import org.apache.commons.lang3.tuple.Pair;
import org.openapi4j.core.exception.DecodeException;
import org.openapi4j.core.model.OAIContext;
import org.openapi4j.core.model.reference.Reference;
import org.openapi4j.core.model.v3.OAI3SchemaKeywords;
import org.openapi4j.parser.model.AbsRefOpenApiSchema;
import org.openapi4j.parser.model.v3.AbsExtendedOpenApiSchema;
import org.openapi4j.parser.model.v3.AbsExtendedRefOpenApiSchema;
import org.openapi4j.parser.model.v3.Operation;
import org.openapi4j.parser.model.v3.Parameter;
import org.openapi4j.parser.model.v3.Path;
import org.openapi4j.parser.model.v3.RequestBody;
import org.openapi4j.parser.model.v3.Schema;

public final class Schemas {
    public static String getType(Schema schema) {
        return schema != null ? schema.getType() : null;
    }

    public static boolean is(Schema schema, String type) {
        return type.equals(getType(schema));
    }

    public static boolean isObject(Schema schema) {
        return is(schema, OAI3SchemaKeywords.TYPE_OBJECT);
    }

    public static boolean isString(Schema schema) {
        return is(schema, OAI3SchemaKeywords.TYPE_STRING);
    }

    public static boolean hasEnums(Schema schema) {
        return schema != null && schema.hasEnums();
    }

    public static <S extends AbsRefOpenApiSchema<S>> Optional<S> resolve(OAIContext context, S schema, Class<S> clazz) {
        while (schema != null && schema.isRef()) {
            Reference ref = schema.getReference(context);
            try {
                schema = ref.getMappedContent(clazz);
            } catch (DecodeException e) {
                throw new RuntimeException("Failed to decode reference as " + clazz + ": " + ref, e);
            }
        }
        return Optional.ofNullable(schema);
    }

    public static Optional<RequestBody> resolve(OAIContext context, RequestBody body) {
        return resolve(context, body, RequestBody.class);
    }

    public static Optional<Schema> resolve(OAIContext context, Schema schema) {
        return resolve(context, schema, Schema.class);
    }

    public static Optional<Schema> resolveRequestBodySchema(OAIContext context, Operation operation) {
        return Schemas.resolve(context, operation.getRequestBody())
                .map(body -> body.getContentMediaType(MediaType.JSON))
                .flatMap(media -> Schemas.resolve(context, media.getSchema()));
    }

    public static Optional<Schema> resolveResponseBodySchema(OAIContext context, Operation operation) {
        return Optional.ofNullable(operation.getResponse("200"))
                .map(response -> response.getContentMediaType(MediaType.JSON))
                .flatMap(media -> Schemas.resolve(context, media.getSchema()));
    }

    public static void forEachProperty(Schema schema, TriConsumer<String, Schema, Boolean> propertyVisitor) {
        Map<String, Schema> properties = schema.getProperties();

        if (properties == null) return;

        Set<String> requiredFields = new HashSet<>(schema.hasRequiredFields() ? schema.getRequiredFields() : new ArrayList<>(0));

        properties.forEach((name, propertySchema) -> propertyVisitor.accept(name, propertySchema, requiredFields.contains(name)));
    }

    public static Stream<Parameter> getParametersIn(OAIContext context, Path path, Operation operation, String in) {
        return Stream.of(path.getParametersIn(context, in), operation.getParametersIn(context, in))
                .flatMap(List::stream);
    }
}
