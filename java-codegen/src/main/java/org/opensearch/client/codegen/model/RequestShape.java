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
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.lang3.tuple.Pair;
import org.opensearch.client.codegen.model.overrides.ShouldGenerate;
import org.opensearch.client.codegen.utils.Streams;
import org.opensearch.client.codegen.utils.Strings;

public class RequestShape extends ObjectShape {
    @Nonnull
    private final OperationGroup operationGroup;
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
    private boolean isBooleanRequest;
    @Nullable
    private Field delegatedBodyField;

    public RequestShape(
        @Nonnull Namespace parent,
        @Nonnull OperationGroup operationGroup,
        @Nullable String description,
        @Nonnull ShouldGenerate shouldGenerate
    ) {
        super(parent, requestClassName(operationGroup), operationGroup.asTypedefPrefix() + ".Request", description, shouldGenerate);
        this.operationGroup = operationGroup;
    }

    @Nonnull
    public OperationGroup getOperationGroup() {
        return operationGroup;
    }

    public String getId() {
        return operationGroup.getName();
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

    public void setIsBooleanRequest() {
        isBooleanRequest = true;
    }

    public boolean isBooleanRequest() {
        return isBooleanRequest;
    }

    public Type getResponseType() {
        return !isBooleanRequest
            ? Type.builder().withPackage(getPackageName()).withName(responseClassName(operationGroup)).build()
            : Types.Client.Transport.Endpoints.BooleanResponse;
    }

    @Override
    public boolean canBeSingleton() {
        return !hasRequestBody() && !hasQueryParams() && hasSinglePath() && !getFirstPath().hasParams();
    }

    @Override
    public Collection<Field> getFieldsToDeserialize() {
        var fields = new TreeMap<>(bodyFields);
        var wireNameSet = bodyFields.values().stream().map(Field::getWireName).collect(Collectors.toSet());
        pathParams.forEach((k, v) -> {
            if (wireNameSet.contains(v.getWireName())) {
                v = v.toBuilder().withWireName(v.getName()).build();
            }
            fields.put(k, v);
        });
        return fields.values();
    }

    @Override
    public boolean hasFieldsToSerialize() {
        return hasRequestBody();
    }

    public boolean hasRequestBody() {
        return hasDelegatedBodyField() || !getBodyFields().isEmpty();
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

    public HttpPath getFirstPath() {
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

    @Override
    public void addBodyField(Field field) {
        super.addBodyField(field);
        addField(field);
    }

    public void setDelegatedBodyField(String name, Type type) {
        this.delegatedBodyField = Field.builder().withName(name).withType(type).withRequired(true).withDescription("Request body.").build();
        addField(this.delegatedBodyField);
    }

    public boolean hasDelegatedBodyField() {
        return delegatedBodyField != null;
    }

    public Field getDelegatedBodyField() {
        return delegatedBodyField;
    }

    private void addField(Field field) {
        fields.put(field.getName(), field);
        tryAddReference(ReferenceKind.Field, field.getType());
    }

    @Override
    public Collection<Field> getFields() {
        return fields.values();
    }

    @Override
    public boolean hasFields() {
        return !fields.isEmpty();
    }

    public boolean hasAnyRequiredFields() {
        return fields.values().stream().anyMatch(Field::isRequired);
    }

    public Type getJsonEndpointType() {
        return Types.Client.Transport.JsonEndpoint(getType(), getResponseType(), Types.Client.OpenSearch._Types.ErrorResponse);
    }

    @Nonnull
    private static String requestClassName(@Nonnull OperationGroup operationGroup) {
        return classBaseName(operationGroup) + "Request";
    }

    @Nonnull
    private static String responseClassName(@Nonnull OperationGroup operationGroup) {
        return classBaseName(operationGroup) + "Response";
    }

    @Nonnull
    private static String classBaseName(@Nonnull OperationGroup operationGroup) {
        Objects.requireNonNull(operationGroup, "operationGroup must not be null");
        switch (operationGroup.toString()) {
            case "indices.create":
                return "CreateIndex";
            case "indices.delete":
                return "DeleteIndex";
            case "indices.get":
                return "GetIndex";
            case "indices.get_settings":
                return "GetIndicesSettings";
            case "indices.put_settings":
                return "PutIndicesSettings";
            case "snapshot.clone":
                return "CloneSnapshot";
            case "snapshot.create":
                return "CreateSnapshot";
            case "snapshot.delete":
                return "DeleteSnapshot";
            case "snapshot.get":
                return "GetSnapshot";
            case "snapshot.status":
                return "SnapshotStatus";
            case "tasks.get":
                return "GetTasks";
            default:
                return Strings.toPascalCase(operationGroup.getName());
        }
    }
}
