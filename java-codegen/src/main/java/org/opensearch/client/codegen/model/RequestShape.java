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
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.openapi4j.parser.model.v3.Operation;
import org.openapi4j.parser.model.v3.Path;
import org.opensearch.client.codegen.utils.Schemas;
import org.opensearch.client.codegen.utils.Strings;

public class RequestShape extends ObjectShape {
    public static RequestShape from(Context ctx, String httpPath, Path path, String method, Operation operation) {
        List<Field> bodyFields = Schemas.resolveRequestBodySchema(ctx.openApiCtx, operation)
                .map(schema -> Field.allFrom(ctx, schema))
                .orElseGet(ArrayList::new);

        List<Field> queryParams = Field.allFrom(ctx, path, operation, "query");
        List<Field> pathParams = Field.allFrom(ctx, path, operation, "path");

        return new RequestShape(
                ctx.namespace,
                Schemas.getOperationNameExtension(operation),
                operation.getDescription(),
                method,
                httpPath,
                bodyFields,
                queryParams,
                pathParams
        );
    }

    private final String id;
    private final String description;
    private final String httpMethod;
    private final Map<String, Field> queryParams = new TreeMap<>();
    private final Map<String, Field> pathParams = new TreeMap<>();
    private final Map<String, Field> fields = new TreeMap<>();
    private final Collection<HttpPathPart> httpPathParts;

    private RequestShape(
            Namespace parent,
            String id,
            String description,
            String httpMethod,
            String httpPath,
            Collection<Field> bodyFields,
            Collection<Field> queryParams,
            Collection<Field> pathParams) {
        super(parent, requestClassName(id), bodyFields);
        this.id = id;
        this.description = description;
        this.httpMethod = httpMethod;
        queryParams.forEach(f -> this.queryParams.put(f.name(), f));
        pathParams.forEach(f -> this.pathParams.put(f.name(), f));
        this.fields.putAll(this.bodyFields);
        this.fields.putAll(this.queryParams);
        this.fields.putAll(this.pathParams);
        this.httpPathParts = HttpPathPart.partsFrom(httpPath, this.pathParams);
    }

    public String id() {
        return id;
    }

    public String description() {
        return description;
    }

    public String httpMethod() {
        return httpMethod;
    }

    public Collection<HttpPathPart> httpPathParts() {
        return Collections.unmodifiableCollection(httpPathParts);
    }

    public String responseType() {
        return responseClassName(id);
    }

    public boolean hasRequestBody() {
        return !bodyFields().isEmpty();
    }

    public Collection<Field> queryParams() {
        return queryParams.values();
    }

    public Collection<Field> pathParams() {
        return pathParams.values();
    }

    @Override
    public Collection<Field> fields() {
        return fields.values();
    }

    public static String requestClassName(String id) {
        return Strings.toPascalCase(id) + "Request";
    }

    public static String responseClassName(String id) {
        return Strings.toPascalCase(id) + "Response";
    }
}
