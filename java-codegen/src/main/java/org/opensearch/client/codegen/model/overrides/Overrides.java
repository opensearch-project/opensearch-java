/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model.overrides;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.model.Types;
import org.opensearch.client.codegen.openapi.JsonPointer;
import org.opensearch.client.codegen.utils.builder.ObjectBuilder;
import org.opensearch.client.codegen.utils.builder.ObjectBuilderBase;

public class Overrides {
    private static final JsonPointer SCHEMAS = JsonPointer.of("components", "schemas");

    public static final Overrides OVERRIDES = builder().withSchemas(
        s -> s.with(SCHEMAS.append("_common.query_dsl:QueryContainer"), so -> so.withClassName("Query"))
            .with(SCHEMAS.append("indices._common:IndexSettings"), so -> so.withAliasProvider((k) -> {
                switch (k) {
                    case "index":
                    case "indexing":
                    case "mapping":
                    case "search":
                    case "settings":
                    case "top_metrics_max_size":
                        return null;
                    default:
                        return Set.of("index." + k);
                }
            }))
            .with(
                SCHEMAS.append("_common:ShardStatistics"),
                b -> b.withProperties(
                    p -> p.with("failed", pb -> pb.withMappedType(Types.Java.Lang.Number))
                        .with("skipped", pb -> pb.withMappedType(Types.Java.Lang.Number))
                        .with("successful", pb -> pb.withMappedType(Types.Java.Lang.Number))
                        .with("total", pb -> pb.withMappedType(Types.Java.Lang.Number))
                )
            )
    ).build();

    @Nonnull
    private final Map<JsonPointer, SchemaOverride> schemas;

    private Overrides(Builder builder) {
        this.schemas = builder.schemas != null ? Collections.unmodifiableMap(builder.schemas) : Collections.emptyMap();
    }

    @Nonnull
    public Optional<SchemaOverride> getSchema(@Nonnull JsonPointer pointer) {
        return Optional.ofNullable(schemas.get(pointer));
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends ObjectBuilderBase<Overrides, Builder> {
        @Nullable
        private Map<JsonPointer, SchemaOverride> schemas;

        private Builder() {}

        @Nonnull
        @Override
        protected Overrides construct() {
            return new Overrides(this);
        }

        @Nonnull
        public Builder withSchemas(@Nonnull Function<SchemaOverride.MapBuilder, ObjectBuilder<Map<JsonPointer, SchemaOverride>>> fn) {
            this.schemas = Objects.requireNonNull(fn, "fn must not be null").apply(SchemaOverride.mapBuilder()).build();
            return this;
        }
    }
}
