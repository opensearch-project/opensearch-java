package org.opensearch.client.codegen.model;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class RequestShape extends ObjectShape {
    private final String id;
    private final String description;
    private final String httpMethod;
    private final String httpPath;
    private final Map<String, Field> queryParams = new TreeMap<>();
    private final Map<String, Field> pathParams = new TreeMap<>();
    private final Map<String, Field> fields = new TreeMap<>();

    public RequestShape(String id, String description, String httpMethod, String httpPath) {
        super(id + "Request");
        this.id = id;
        this.description = description;
        this.httpMethod = httpMethod;
        this.httpPath = httpPath;
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

    public String httpPath() {
        return '"' + httpPath.replace("{", "\" + request.").replace("}", " + \"") + '"';
    }

    public String responseType() {
        return id + "Response";
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

    @Override
    public void addBodyField(Field field) {
        super.addBodyField(field);
        fields.put(field.name(), field);
    }

    public void addQueryParam(Field field) {
        queryParams.put(field.name(), field);
        fields.put(field.name(), field);
    }

    public void addPathParam(Field field) {
        pathParams.put(field.name(), field);
        fields.put(field.name(), field);
    }
}
