/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import org.opensearch.client.codegen.utils.Strings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RequestShape extends ObjectShape {
    public static String requestClassName(String id) {
        return Strings.toPascalCase(id) + "Request";
    }

    public static String responseClassName(String id) {
        return Strings.toPascalCase(id) + "Response";
    }

    private final String id;
    private final String description;
    private final String httpMethod;
    private final String httpPath;
    private final Map<String, Field> queryParams = new TreeMap<>();
    private final Map<String, Field> pathParams = new TreeMap<>();
    private final Map<String, Field> fields = new TreeMap<>();

    public RequestShape(String namespace, String id, String description, String httpMethod, String httpPath) {
        super(namespace, requestClassName(id));
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

    public Collection<HttpPathPart> httpPathParts() {
        List<HttpPathPart> parts = new ArrayList<>();
        boolean isParameter = false;
        StringBuilder content = new StringBuilder();
        for (char c : httpPath.toCharArray()) {
            if (c == '{') {
                if (content.length() > 0) {
                    parts.add(new HttpPathPart(isParameter, content.toString()));
                }
                content = new StringBuilder();
                isParameter = true;
            } else if (c == '}') {
                if (content.length() > 0) {
                    parts.add(new HttpPathPart(isParameter, content.toString()));
                }
                content = new StringBuilder();
                isParameter = false;
            } else {
                content.append(c);
            }
        }
        if (content.length() > 0) {
            parts.add(new HttpPathPart(isParameter, content.toString()));
        }

        return parts;
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

    public class HttpPathPart {
        public final boolean isParameter;
        public final String content;

        public HttpPathPart(boolean isParameter, String content) {
            this.isParameter = isParameter;
            this.content = content;
        }

        public Field parameter() {
            return isParameter ? pathParams.get(content) : null;
        }
    }
}
