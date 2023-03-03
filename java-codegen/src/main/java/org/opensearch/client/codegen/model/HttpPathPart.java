package org.opensearch.client.codegen.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class HttpPathPart {
    public static Collection<HttpPathPart> partsFrom(String httpPath, Map<String, Field> pathParams) {
        List<HttpPathPart> parts = new ArrayList<>();
        boolean isParameter = false;
        StringBuilder content = new StringBuilder();
        for (char c : httpPath.toCharArray()) {
            if (c == '{') {
                if (content.length() > 0) {
                    parts.add(from(isParameter, content.toString(), pathParams));
                }
                content = new StringBuilder();
                isParameter = true;
            } else if (c == '}') {
                if (content.length() > 0) {
                    parts.add(from(isParameter, content.toString(), pathParams));
                }
                content = new StringBuilder();
                isParameter = false;
            } else {
                content.append(c);
            }
        }
        if (content.length() > 0) {
            parts.add(from(isParameter, content.toString(), pathParams));
        }

        return parts;
    }

    private static HttpPathPart from(boolean isParameter, String content, Map<String, Field> pathParams) {
        return isParameter
                ? new HttpPathPart(pathParams.get(content))
                : new HttpPathPart(content);
    }

    private final Field parameter;
    private final String content;

    private HttpPathPart(Field parameter) {
        this.parameter = parameter;
        this.content = null;
    }

    private HttpPathPart(String content) {
        this.parameter = null;
        this.content = content;
    }

    public boolean isParameter() {
        return parameter != null;
    }

    public String content() {
        return content;
    }

    public Field parameter() {
        return parameter;
    }
}
