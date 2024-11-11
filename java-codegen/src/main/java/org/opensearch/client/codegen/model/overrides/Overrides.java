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
        s -> s
            .with(SCHEMAS.append("_common.analysis:TokenFilter"), so -> so.withShouldGenerate(ShouldGenerate.Always))

            // TODO: Remove this to generate property mapping types
            .with(SCHEMAS.append("_common.mapping:Property"), so -> so.withShouldGenerate(ShouldGenerate.Never))
            .with(SCHEMAS.append("_common.mapping:PropertyBase"), so -> so.withShouldGenerate(ShouldGenerate.Never))
            .with(SCHEMAS.append("_common.mapping:KnnVectorProperty"), so -> so.withShouldGenerate(ShouldGenerate.Always))

            // TODO: Remove this to generate query types
            .with(
                SCHEMAS.append("_common.query_dsl:QueryContainer"),
                so -> so.withMappedType(t -> t.withPackage(Types.Client.OpenSearch._Types.PACKAGE + ".query_dsl").withName("Query"))
            )

            // TODO: Remove this to generate index settings types
            .with(SCHEMAS.append("indices._common:IndexSettings"), so -> so.withShouldGenerate(ShouldGenerate.Never))
    ).build();

    @Nonnull
    private final Map<JsonPointer, SchemaOverride> schemas;

    private Overrides(Builder builder) {
        this.schemas = builder.schemas != null ? Collections.unmodifiableMap(builder.schemas) : Collections.emptyMap();
    }

    @Nonnull
    public Map<JsonPointer, SchemaOverride> getSchemas() {
        return schemas;
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
