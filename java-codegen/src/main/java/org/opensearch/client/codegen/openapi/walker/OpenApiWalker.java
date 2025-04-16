/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi.walker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.opensearch.client.codegen.openapi.OpenApiComponents;
import org.opensearch.client.codegen.openapi.OpenApiContent;
import org.opensearch.client.codegen.openapi.OpenApiDiscriminator;
import org.opensearch.client.codegen.openapi.OpenApiMediaType;
import org.opensearch.client.codegen.openapi.OpenApiOperation;
import org.opensearch.client.codegen.openapi.OpenApiParameter;
import org.opensearch.client.codegen.openapi.OpenApiPath;
import org.opensearch.client.codegen.openapi.OpenApiRequestBody;
import org.opensearch.client.codegen.openapi.OpenApiResponse;
import org.opensearch.client.codegen.openapi.OpenApiResponses;
import org.opensearch.client.codegen.openapi.OpenApiSchema;
import org.opensearch.client.codegen.openapi.OpenApiSpecification;

public final class OpenApiWalker {
    private final Set<Object> visiting = new HashSet<>();
    private final Map<Object, Object> visited = new HashMap<>();

    public OpenApiSpecification walkSpecification(OpenApiSpecification specification, OpenApiVisitor visitor) {
        return safeWalk(specification, visitor::visitSpecificationStart, visitor::visitSpecificationEnd, s -> {
            ifPresentMap(s::getPaths, s::setPaths, visitor, this::walkPath);
            ifPresent(s::getComponents, s::setComponents, visitor, this::walkComponents);
        });
    }

    public OpenApiPath walkPath(OpenApiPath path, OpenApiVisitor visitor) {
        return safeWalk(path, visitor::visitPathStart, visitor::visitPathEnd, p -> {
            ifPresentMap(p::getOperations, p::setOperations, visitor, this::walkOperation);
            ifPresentList(p::getParameters, p::setParameters, visitor, this::walkParameter);
        });
    }

    public OpenApiComponents walkComponents(OpenApiComponents components, OpenApiVisitor visitor) {
        return safeWalk(components, visitor::visitComponentsStart, visitor::visitComponentsEnd, c -> {
            ifPresentMap(c::getSchemas, c::setSchemas, visitor, this::walkSchema);
            ifPresentMap(c::getParameters, c::setParameters, visitor, this::walkParameter);
            ifPresentMap(c::getResponses, c::setResponses, visitor, this::walkResponse);
            ifPresentMap(c::getRequestBodies, c::setRequestBodies, visitor, this::walkRequestBody);
        });
    }

    public OpenApiOperation walkOperation(OpenApiOperation operation, OpenApiVisitor visitor) {
        return safeWalk(operation, visitor::visitOperationStart, visitor::visitOperationEnd, o -> {
            ifPresentList(o::getParameters, o::setParameters, visitor, this::walkParameter);
            ifPresent(o::getRequestBody, o::setRequestBody, visitor, this::walkRequestBody);
            ifPresent(o::getResponses, o::setResponses, visitor, this::walkResponses);
        });
    }

    public OpenApiParameter walkParameter(OpenApiParameter parameter, OpenApiVisitor visitor) {
        return safeWalk(parameter, visitor::visitParameterStart, visitor::visitParameterEnd, p -> {
            ifPresent(p::getSchema, p::setSchema, visitor, this::walkSchema);
        });
    }

    public OpenApiSchema walkSchema(OpenApiSchema schema, OpenApiVisitor visitor) {
        return safeWalk(schema, visitor::visitSchemaStart, visitor::visitSchemaEnd, s -> {
            ifPresentList(s::getAllOf, s::setAllOf, visitor, this::walkSchema);
            ifPresentList(s::getAnyOf, s::setAnyOf, visitor, this::walkSchema);
            ifPresentList(s::getOneOf, s::setOneOf, visitor, this::walkSchema);
            ifPresent(s::getItems, s::setItems, visitor, this::walkSchema);
            ifPresent(s::getPropertyNames, s::setPropertyNames, visitor, this::walkSchema);
            ifPresent(s::getAdditionalProperties, s::setAdditionalProperties, visitor, this::walkSchema);
            ifPresentMap(s::getProperties, s::setProperties, visitor, this::walkSchema);
            ifPresent(s::getDiscriminator, s::setDiscriminator, visitor, this::walkDiscriminator);
            ifPresent(s::get$extends, s::set$extends, visitor, this::walkSchema);
        });
    }

    public OpenApiDiscriminator walkDiscriminator(OpenApiDiscriminator discriminator, OpenApiVisitor visitor) {
        return safeWalk(discriminator, visitor::visitDiscriminatorStart, visitor::visitDiscriminatorEnd, d -> {});
    }

    public OpenApiResponse walkResponse(OpenApiResponse response, OpenApiVisitor visitor) {
        return safeWalk(response, visitor::visitResponseStart, visitor::visitResponseEnd, r -> {
            ifPresent(r::getContent, r::setContent, visitor, this::walkContent);
        });
    }

    public OpenApiRequestBody walkRequestBody(OpenApiRequestBody requestBody, OpenApiVisitor visitor) {
        return safeWalk(requestBody, visitor::visitRequestBodyStart, visitor::visitRequestBodyEnd, r -> {
            ifPresent(r::getContent, r::setContent, visitor, this::walkContent);
        });
    }

    public OpenApiResponses walkResponses(OpenApiResponses responses, OpenApiVisitor visitor) {
        return safeWalk(responses, visitor::visitResponsesStart, visitor::visitResponsesEnd, r -> {
            ifPresentMap(r::getValues, r::setValues, visitor, this::walkResponse);
        });
    }

    public OpenApiContent walkContent(OpenApiContent content, OpenApiVisitor visitor) {
        return safeWalk(content, visitor::visitContentStart, visitor::visitContentEnd, c -> {
            ifPresentMap(c::getValues, c::setValues, visitor, this::walkMediaType);
        });
    }

    public OpenApiMediaType walkMediaType(OpenApiMediaType mediaType, OpenApiVisitor visitor) {
        return safeWalk(mediaType, visitor::visitMediaTypeStart, visitor::visitMediaTypeEnd, m -> {
            ifPresent(m::getSchema, m::setSchema, visitor, this::walkSchema);
        });
    }

    private <T> void ifPresent(
        Supplier<Optional<T>> getter,
        Consumer<T> setter,
        OpenApiVisitor visitor,
        BiFunction<T, OpenApiVisitor, T> walker
    ) {
        getter.get().ifPresent(value -> setter.accept(walker.apply(value, visitor)));
    }

    private <V> void ifPresentList(
        Supplier<Optional<List<V>>> getter,
        Consumer<List<V>> setter,
        OpenApiVisitor visitor,
        BiFunction<V, OpenApiVisitor, V> walker
    ) {
        ifPresent(getter, setter, visitor, (l, v) -> walkList(l, v, walker));
    }

    private <K, V> void ifPresentMap(
        Supplier<Optional<Map<K, V>>> getter,
        Consumer<Map<K, V>> setter,
        OpenApiVisitor visitor,
        BiFunction<V, OpenApiVisitor, V> walker
    ) {
        ifPresent(getter, setter, visitor, (m, v) -> walkMap(m, v, walker));
    }

    private <V> List<V> walkList(List<V> list, OpenApiVisitor visitor, BiFunction<V, OpenApiVisitor, V> walker) {
        var res = list;

        var i = 0;
        for (var value : list) {
            var walked = walker.apply(value, visitor);

            if (walked != value) {
                if (res == list) {
                    res = new ArrayList<>(list);
                }

                res.set(i, walked);
            }

            i += 1;
        }

        return res;
    }

    private <K, V> Map<K, V> walkMap(Map<K, V> map, OpenApiVisitor visitor, BiFunction<V, OpenApiVisitor, V> walker) {
        var res = map;

        for (var e : map.entrySet()) {
            var v = walker.apply(e.getValue(), visitor);

            if (v == e.getValue()) continue;

            if (res == map) {
                res = new HashMap<>(map);
            }

            res.put(e.getKey(), v);
        }

        return res;
    }

    private <T> T safeWalk(T value, Function<T, T> visitStart, Function<T, T> visitEnd, Consumer<T> walker) {
        if (value == null) {
            return null;
        }

        if (visiting.contains(value)) {
            return value;
        }

        if (visited.containsKey(value)) {
            // noinspection unchecked
            return (T) visited.get(value);
        }

        visiting.add(value);

        var newValue = value;
        var res = visitStart.apply(value);
        if (res != null) {
            newValue = res;
        }

        walker.accept(newValue);

        res = visitEnd.apply(newValue);
        if (res != null) {
            newValue = res;
        }

        visited.put(value, newValue);
        visiting.remove(value);

        return newValue;
    }
}
