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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import org.opensearch.client.codegen.NameSanitizer;
import org.opensearch.client.codegen.utils.Either;

public class HttpPathPart {
    public static Collection<HttpPathPart> partsFrom(String httpPath, Map<String, Field> pathParams) {
        List<HttpPathPart> parts = new ArrayList<>();
        boolean isParameter = false;
        StringBuilder content = new StringBuilder();

        for (char c : httpPath.toCharArray()) {
            if (c == '{' || c == '}') {
                if (content.length() > 0) {
                    parts.add(from(isParameter, content.toString(), pathParams));
                }
                content = new StringBuilder();
                isParameter = c == '{';
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
                ? new HttpPathPart(pathParams.get(NameSanitizer.wireNameToField(content)))
                : new HttpPathPart(content);
    }

    private final Either<Field, String> part;

    private HttpPathPart(Field parameter) {
        Objects.requireNonNull(parameter, "Parameter cannot be null");
        part = Either.left(parameter);
    }

    private HttpPathPart(String content) {
        Objects.requireNonNull(content, "Content cannot be null");
        part = Either.right(content);
    }

    public boolean isParameter() {
        return part.isLeft();
    }

    public String content() {
        return part.getRightOrThrow((p) -> new IllegalStateException("Cannot get content of non-content part"));
    }

    public Field parameter() {
        return part.getLeftOrThrow((c) -> new IllegalStateException("Cannot get parameter of non-parameter part"));
    }

    @Override
    public String toString() {
        return part.fold(f -> '{' + f.name() + '}', Function.identity());
    }
}
