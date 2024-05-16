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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.lang3.tuple.Pair;
import org.opensearch.client.codegen.utils.Streams;
import org.opensearch.client.codegen.utils.Strings;

public class RequestShape extends ObjectShape {
    @Nonnull
    private final OperationGroup operationGroup;
    @Nullable
    private final String description;
    @Nonnull
    private final Set<String> httpMethods = new HashSet<>();
    @Nonnull
    private final List<HttpPath> httpPaths = new ArrayList<>();
    @Nonnull
    private final Map<String, Field> queryParams = new TreeMap<>();
    @Nonnull
    private final Map<String, Field> pathParams = new TreeMap<>();
    @Nonnull
    private final Map<String, Field> fields = new TreeMap<>();

    public RequestShape(@Nonnull Namespace parent, @Nonnull OperationGroup operationGroup, @Nullable String description) {
        super(parent, requestClassName(operationGroup), operationGroup + ".Request");
        this.operationGroup = operationGroup;
        this.description = description;
    }

    @Nonnull
    public OperationGroup getOperationGroup() {
        return operationGroup;
    }

    public String getId() {
        return operationGroup.getName();
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public String getHttpMethod() {
        return Streams.sortedBy(httpMethods.stream(), m -> {
            switch (m) {
                case "PUT":
                case "DELETE":
                case "PATCH":
                case "HEAD":
                    return 0;
                case "POST":
                    return 1;
                case "GET":
                    return 2;
                default:
                    return 99;
            }
        }).findFirst().orElseThrow();
    }

    public void addSupportedHttpMethod(String method) {
        httpMethods.add(method);
    }

    public String getResponseType() {
        return responseClassName(operationGroup);
    }

    public boolean hasRequestBody() {
        return !getBodyFields().isEmpty();
    }

    public void addQueryParam(Field field) {
        queryParams.put(field.getName(), field);
        addField(field);
    }

    public Collection<Field> getQueryParams() {
        return queryParams.values();
    }

    public boolean hasQueryParams() {
        return !queryParams.isEmpty();
    }

    public void addHttpPath(HttpPath httpPath) {
        httpPaths.add(httpPath);
    }

    public Collection<HttpPath> getHttpPaths() {
        return httpPaths;
    }

    public HttpPath getFirstHttpPath() {
        return httpPaths.get(0);
    }

    public boolean hasSinglePath() {
        return httpPaths.size() == 1;
    }

    public void addPathParam(Field field) {
        pathParams.put(field.getName(), field);
        addField(field);
    }

    public Collection<Pair<String, Integer>> getIndexedPathParams() {
        var indexed = new ArrayList<Pair<String, Integer>>();
        var i = 0;
        for (var param : pathParams.values()) {
            indexed.add(Pair.of(param.getName(), i++));
        }
        return indexed;
    }

    public Collection<Field> getPathParams() {
        return pathParams.values();
    }

    private void addField(Field field) {
        fields.put(field.getName(), field);
    }

    @Override
    public Collection<Field> getFields() {
        return fields.values();
    }

    public boolean hasAnyRequiredFields() {
        return fields.values().stream().anyMatch(Field::isRequired);
    }

    @Nonnull
    public static String requestClassName(@Nonnull OperationGroup operationGroup) {
        Objects.requireNonNull(operationGroup, "operationGroup must not be null");
        return Strings.toPascalCase(operationGroup.getName()) + "Request";
    }

    @Nonnull
    public static String responseClassName(@Nonnull OperationGroup operationGroup) {
        Objects.requireNonNull(operationGroup, "operationGroup must not be null");
        return Strings.toPascalCase(operationGroup.getName()) + "Response";
    }
}
