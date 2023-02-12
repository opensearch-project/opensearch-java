package org.opensearch.client.codegen.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperationRequest {
    public String operationId;
    public String description;
    public String httpMethod;
    public String httpPath;
    private Map<String, Field> bodyFields = new TreeMap<>();
    private Map<String, Field> queryParams = new TreeMap<>();
    private Map<String, Field> fields = new TreeMap<>();

    public String className() {
        return operationId + "Request";
    }

    public String responseType() { return operationId + "Response"; }

    public boolean hasRequestBody() { return !bodyFields.isEmpty(); }

    public Collection<Field> bodyFields() { return bodyFields.values(); }
    public Collection<Field> queryParams() { return queryParams.values(); }
    public Collection<Field> fields() { return fields.values(); }

    public void addBodyField(Field field) {
        bodyFields.put(field.wireName, field);
        fields.put(field.wireName, field);
    }

    public void addQueryParam(Field field) {
        queryParams.put(field.wireName, field);
        fields.put(field.wireName, field);
    }
}
