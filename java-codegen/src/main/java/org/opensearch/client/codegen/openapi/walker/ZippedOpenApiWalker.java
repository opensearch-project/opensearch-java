/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi.walker;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.util.TriConsumer;
import org.opensearch.client.codegen.openapi.OpenApiSchema;

public final class ZippedOpenApiWalker {
    private final Set<Object> visited = new HashSet<>();

    public ZippedOpenApiWalker() {}

    public void walkSchema(@Nullable OpenApiSchema left, @Nullable OpenApiSchema right, ZippedOpenApiVisitor visitor) {
        safeWalk(left, right, visitor::visitSchemaStart, visitor::visitSchemaEnd, (l, r) -> {
            ifPresentList(l, r, OpenApiSchema::getAllOf, visitor, this::walkSchema);
            ifPresentList(l, r, OpenApiSchema::getAnyOf, visitor, this::walkSchema);
            ifPresentList(l, r, OpenApiSchema::getOneOf, visitor, this::walkSchema);
            ifPresent(l, r, OpenApiSchema::getItems, visitor, this::walkSchema);
            ifPresent(l, r, OpenApiSchema::getPropertyNames, visitor, this::walkSchema);
            ifPresent(l, r, OpenApiSchema::getAdditionalProperties, visitor, this::walkSchema);
            ifPresentMap(l, r, OpenApiSchema::getProperties, visitor, this::walkSchema);
            // ifPresent(s::getDiscriminator, s::setDiscriminator, visitor, this::walkDiscriminator);
            ifPresent(l, r, OpenApiSchema::get$extends, visitor, this::walkSchema);
        });
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private <T, U> void ifPresent(
        @Nonnull Optional<T> leftOpt,
        @Nonnull Optional<T> rightOpt,
        @Nonnull Function<T, Optional<U>> getter,
        @Nonnull ZippedOpenApiVisitor visitor,
        @Nonnull TriConsumer<U, U, ZippedOpenApiVisitor> walker
    ) {
        walker.accept(leftOpt.flatMap(getter).orElse(null), rightOpt.flatMap(getter).orElse(null), visitor);
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private <T, V> void ifPresentList(
        @Nonnull Optional<T> leftOpt,
        @Nonnull Optional<T> rightOpt,
        @Nonnull Function<T, Optional<List<V>>> getter,
        @Nonnull ZippedOpenApiVisitor visitor,
        @Nonnull TriConsumer<V, V, ZippedOpenApiVisitor> walker
    ) {
        ifPresent(leftOpt, rightOpt, getter, visitor, (l, r, v) -> walkList(l, r, v, walker));
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private <T, K, V> void ifPresentMap(
        @Nonnull Optional<T> leftOpt,
        @Nonnull Optional<T> rightOpt,
        @Nonnull Function<T, Optional<Map<K, V>>> getter,
        @Nonnull ZippedOpenApiVisitor visitor,
        @Nonnull TriConsumer<V, V, ZippedOpenApiVisitor> walker
    ) {
        ifPresent(leftOpt, rightOpt, getter, visitor, (l, r, v) -> walkMap(l, r, v, walker));
    }

    private <V> void walkList(
        @Nullable List<V> left,
        @Nullable List<V> right,
        @Nonnull ZippedOpenApiVisitor visitor,
        @Nonnull TriConsumer<V, V, ZippedOpenApiVisitor> walker
    ) {
        var lSize = left != null ? left.size() : 0;
        var rSize = right != null ? right.size() : 0;
        var size = Math.max(lSize, rSize);

        for (int i = 0; i < size; i++) {
            walker.accept(i < lSize ? left.get(i) : null, i < rSize ? right.get(i) : null, visitor);
        }
    }

    private <K, V> void walkMap(
        @Nullable Map<K, V> left,
        @Nullable Map<K, V> right,
        @Nonnull ZippedOpenApiVisitor visitor,
        @Nonnull TriConsumer<V, V, ZippedOpenApiVisitor> walker
    ) {
        var allKeys = new HashSet<K>();
        if (left != null) allKeys.addAll(left.keySet());
        if (right != null) allKeys.addAll(right.keySet());

        for (var k : allKeys) {
            walker.accept(left != null ? left.get(k) : null, right != null ? right.get(k) : null, visitor);
        }
    }

    private <T> void safeWalk(
        T left,
        T right,
        BiConsumer<T, T> visitStart,
        BiConsumer<T, T> visitEnd,
        BiConsumer<Optional<T>, Optional<T>> walker
    ) {
        if (left == null && right == null) {
            return;
        }

        if (!visited.add(Pair.of(left, right))) {
            return;
        }

        visitStart.accept(left, right);

        walker.accept(Optional.ofNullable(left), Optional.ofNullable(right));

        visitEnd.accept(left, right);
    }
}
