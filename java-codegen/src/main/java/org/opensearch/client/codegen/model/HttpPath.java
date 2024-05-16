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
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.openapi.OpenApiOperation;
import org.opensearch.client.codegen.utils.Either;

public class HttpPath {
    @Nonnull
    private final List<Part> parts;
    @Nullable
    private final Deprecation deprecation;
    @Nullable
    private final String versionAdded;

    public static HttpPath from(String httpPath, OpenApiOperation operation, Map<String, Field> pathParams) {
        var parts = new ArrayList<Part>();
        var isParameter = false;
        var text = new StringBuilder();

        for (char c : httpPath.toCharArray()) {
            if (c == '{' || c == '}') {
                if (text.length() > 0) {
                    parts.add(Part.from(isParameter, text.toString(), pathParams));
                }
                text.setLength(0);
                isParameter = c == '{';
            } else {
                text.append(c);
            }
        }

        if (text.length() > 0) {
            parts.add(Part.from(isParameter, text.toString(), pathParams));
        }

        return new HttpPath(parts, operation.getDeprecation().orElse(null), operation.getVersionAdded().orElse(null));
    }

    private HttpPath(@Nonnull List<Part> parts, @Nullable Deprecation deprecation, @Nullable String versionAdded) {
        this.parts = Objects.requireNonNull(parts, "parts must not be null");
        this.deprecation = deprecation;
        this.versionAdded = versionAdded;
    }

    public List<Field> getParams() {
        return parts.stream().filter(Part::isParameter).map(Part::getParameter).toList();
    }

    public Set<String> getParamNameSet() {
        return parts.stream().filter(Part::isParameter).map(p -> p.getParameter().getName()).collect(Collectors.toSet());
    }

    public Deprecation getDeprecation() {
        return deprecation;
    }

    public Collection<Part> getParts() {
        return parts;
    }

    public boolean hasParams() {
        return parts.stream().anyMatch(Part::isParameter);
    }

    @Override
    public String toString() {
        return parts.stream().map(Part::toString).collect(Collectors.joining());
    }

    public static class Part {
        private final Either<Field, String> part;

        public static Part from(boolean isParameter, String text, Map<String, Field> pathParams) {
            if (text == null || text.isEmpty()) throw new IllegalStateException("Text cannot be null or empty");
            if (!isParameter) return new Part(Either.right(text));
            var param = pathParams.get(text);
            if (param == null) throw new IllegalStateException("Parameter not found: " + text);
            return new Part(Either.left(param));
        }

        private Part(Either<Field, String> part) {
            this.part = part;
        }

        public boolean isParameter() {
            return part.isLeft();
        }

        public String getContent() {
            return part.getRightOrThrow((p) -> new IllegalStateException("Cannot get content of non-content part"));
        }

        public Field getParameter() {
            return part.getLeftOrThrow((c) -> new IllegalStateException("Cannot get parameter of non-parameter part"));
        }

        @Override
        public String toString() {
            return part.fold(f -> '{' + f.getName() + '}', Function.identity());
        }
    }
}
