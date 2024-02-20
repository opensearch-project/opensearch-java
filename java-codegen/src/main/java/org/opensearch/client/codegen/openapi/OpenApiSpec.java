/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;
import org.apache.commons.lang3.tuple.Pair;
import org.opensearch.client.codegen.exceptions.ApiSpecificationParseException;

public class OpenApiSpec {
    private static final ParseOptions PARSE_OPTIONS = new ParseOptions();
    private static final OpenAPIV3Parser PARSER = new OpenAPIV3Parser();
    private static final Map<URI, OpenApiSpec> SPECS = new HashMap<>();

    public static OpenApiSpec parse(URI location) {
        if (SPECS.containsKey(location)) {
            return SPECS.get(location);
        }
        System.out.println("Parsing spec: " + location);
        var result = PARSER.readLocation(location.toString(), null, PARSE_OPTIONS);
        var openApi = result.getOpenAPI();
        if (openApi == null) {
            throw new ApiSpecificationParseException("Unable to parse spec: " + location, result.getMessages());
        }
        var spec = new OpenApiSpec(location, openApi);
        SPECS.put(location, spec);
        return spec;
    }

    private final URI location;
    private final OpenAPI api;

    private OpenApiSpec(URI location, OpenAPI api) {
        this.location = location;
        this.api = api;
    }

    protected <T> Pair<OpenApiSpec, T> resolve(Function<OpenAPI, Map<String, T>> componentsGetter, T item, Function<T, String> get$ref) {
        var spec = this;
        String $ref;
        while (item != null && ($ref = get$ref.apply(item)) != null) {
            var fragmentIdx = $ref.indexOf('#');

            if (fragmentIdx > 0) {
                spec = parse(spec.location.resolve($ref.substring(0, fragmentIdx)));
            }

            var parts = $ref.substring(fragmentIdx + 1).split("/");
            var componentName = parts[parts.length - 1].replaceAll("~1", "/").replaceAll("~0", "~");

            item = componentsGetter.apply(spec.api).get(componentName);

            if (item == null) {
                throw new IllegalStateException("Failed to resolve reference: " + $ref);
            }
        }
        return Pair.of(spec, item);
    }

    public URI getLocation() {
        return location;
    }

    public Stream<OpenApiOperation> getOperations() {
        return api.getPaths()
                .entrySet()
                .stream()
                .map(e -> new OpenApiPath(this, e.getKey(), e.getValue()).resolve())
                .flatMap(OpenApiPath::getOperations);
    }
}
