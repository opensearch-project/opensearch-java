/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import io.swagger.v3.oas.models.Operation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.opensearch.client.codegen.NameSanitizer;
import org.opensearch.client.codegen.utils.Either;
import org.opensearch.client.codegen.utils.Extensions;

public class HttpPath {
    private final List<Part> parts;
    private final Deprecation deprecation;
    private final String versionAdded;

    public static HttpPath from(String httpPath, Operation operation, Map<String, Field> pathParams) {
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

        var extensions = Extensions.of(operation);

        return new HttpPath(parts, extensions.deprecation(), extensions.versionAdded());
    }

    private HttpPath(List<Part> parts, Deprecation deprecation, String versionAdded) {
        this.parts = parts;
        this.deprecation = deprecation;
        this.versionAdded = versionAdded;
    }

    public List<Field> params() {
        return parts.stream()
                .filter(Part::isParameter)
                .map(Part::parameter)
                .collect(Collectors.toList());
    }

    public Set<String> paramNameSet() {
        return parts.stream()
                .filter(Part::isParameter)
                .map(p -> p.parameter().name())
                .collect(Collectors.toSet());
    }

    public Deprecation deprecation() {
        return deprecation;
    }

    public HttpPath withRenamedParam(String from, String to, Map<String, Field> allParams) {
        var newParts = parts.stream().map(p -> {
            if (p.isParameter() && p.parameter().name().equals(from)) {
                return Part.from(true, to, allParams);
            }
            return p;
        }).collect(Collectors.toList());
        return new HttpPath(newParts, deprecation, versionAdded);
    }

    public Collection<Part> parts() {
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
}