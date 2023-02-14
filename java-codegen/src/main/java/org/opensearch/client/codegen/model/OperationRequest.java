package org.opensearch.client.codegen.model;

import java.util.*;

public class OperationRequest extends ObjectShape {
    private final String id;
    private final String description;
    private final String httpMethod;
    private final String httpPath;
    private final Map<String, Field> queryParams = new TreeMap<>();
    private final Map<String, Field> fields = new TreeMap<>();

    public OperationRequest(String id, String description, String httpMethod, String httpPath) {
        super(id + "Request");
        this.id = id;
        this.description = description;
        this.httpMethod = httpMethod;
        this.httpPath = httpPath;
    }

    public String description() { return description; }

    public String httpMethod() { return httpMethod; }

    public String httpPath() { return httpPath; }

    public String responseType() { return id + "Response"; }

    public boolean hasRequestBody() { return !bodyFields().isEmpty(); }

    public Collection<Field> queryParams() { return queryParams.values(); }

    @Override
    public Collection<Field> fields() { return fields.values(); }

    @Override
    public void addBodyField(Field field) {
        super.addBodyField(field);
        fields.put(field.wireName, field);
    }

    public void addQueryParam(Field field) {
        queryParams.put(field.wireName, field);
        fields.put(field.wireName, field);
    }
}
