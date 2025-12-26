/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.transformer.overrides;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.codegen.model.OperationGroup;
import org.opensearch.client.codegen.model.types.Type;
import org.opensearch.client.codegen.model.types.Types;
import org.opensearch.client.codegen.openapi.In;
import org.opensearch.client.codegen.openapi.JsonPointer;
import org.opensearch.client.codegen.openapi.OpenApiSchema;
import org.opensearch.client.codegen.utils.builder.ObjectBuilder;
import org.opensearch.client.codegen.utils.builder.ObjectBuilderBase;

public class Overrides {
    private static JsonPointer requestBodySchema(String operation) {
        return JsonPointer.of("components", "requestBodies", operation, "content", "application/json", "schema");
    }

    private static JsonPointer parameterSchema(OperationGroup operation, In in, String name) {
        return JsonPointer.of(
            "components",
            "parameters",
            operation.toString() + OpenApiSchema.NAMESPACE_NAME_SEPARATOR + in.toString() + "." + name,
            "schema"
        );
    }

    private static JsonPointer schema(String namespace, String name) {
        return OpenApiSchema.COMPONENTS_SCHEMAS.append(namespace + OpenApiSchema.NAMESPACE_NAME_SEPARATOR + name);
    }

    public static final Overrides OVERRIDES = builder().withOperations(
        o -> o.with(
            OperationGroup.from("scroll"),
            oo -> oo.withQueryParameters(qp -> qp.with("rest_total_hits_as_int", po -> po.withIgnore(true)))
        )
            .with(
                OperationGroup.from("search"),
                oo -> oo.withQueryParameters(
                    qp -> qp.with("rest_total_hits_as_int", po -> po.withIgnore(true))
                        .with("_source_excludes", po -> po.withIgnore(true))
                        .with("_source_includes", po -> po.withIgnore(true))
                        .with("suggest_field", po -> po.withIgnore(true))
                        .with("suggest_mode", po -> po.withIgnore(true))
                        .with("suggest_size", po -> po.withIgnore(true))
                        .with("suggest_text", po -> po.withIgnore(true))
                        .with("search_pipeline", po -> po.withName("pipeline"))
                )
            )
            .with(
                OperationGroup.from("search_template"),
                oo -> oo.withQueryParameters(
                    qp -> qp.with("rest_total_hits_as_int", po -> po.withIgnore(true))
                        .with("search_pipeline", po -> po.withName("pipeline"))
                )
            )
            .with(
                OperationGroup.from("snapshot.create_repository"),
                oo -> oo.withPathParameters(pp -> pp.with("repository", po -> po.withName("name")))
            )
            .with(
                OperationGroup.from("snapshot.delete_repository"),
                oo -> oo.withPathParameters(pp -> pp.with("repository", po -> po.withName("name")))
            )
            .with(
                OperationGroup.from("snapshot.get_repository"),
                oo -> oo.withPathParameters(pp -> pp.with("repository", po -> po.withName("name")))
            )
    )
        .withSchemas(
            s -> s.with(schema("_common", "ByteUnit"), so -> so.withClassName("Bytes"))
                .with(schema("_common", "DateTime"), so -> so.withMappedType(Types.Java.Lang.String))
                .with(schema("_common", "Duration"), so -> so.withMappedType(Types.Client.OpenSearch._Types.Time))
                .with(schema("_common", "DurationLarge"), so -> so.withMappedType(Types.Client.OpenSearch._Types.Time))
                .with(schema("_common", "FieldValue"), so -> so.withMappedType(Types.Client.OpenSearch._Types.FieldValue))
                .with(schema("_common", "Fuzziness"), so -> so.withMappedType(Types.Java.Lang.String))
                .with(schema("_common", "MinimumShouldMatch"), so -> so.withMappedType(Types.Java.Lang.String))
                .with(schema("_common", "StringifiedBoolean"), so -> so.withMappedType(Types.Primitive.Boolean))
                .with(schema("_common", "StringifiedDouble"), so -> so.withMappedType(Types.Primitive.Double))
                .with(schema("_common", "StringifiedEpochTimeUnitMillis"), so -> so.withMappedType(Types.Primitive.Long))
                .with(schema("_common", "StringifiedEpochTimeUnitSeconds"), so -> so.withMappedType(Types.Primitive.Long))
                .with(schema("_common", "StringifiedInteger"), so -> so.withMappedType(Types.Primitive.Int))
                .with(schema("_common", "StringifiedLong"), so -> so.withMappedType(Types.Primitive.Long))
                .with(schema("_common", "StringifiedVersionNumber"), so -> so.withMappedType(Types.Primitive.Long))
                .with(schema("_common", "Void"), so -> so.withMappedType(Types.Primitive.Void))

                .with(schema("_common", "ScriptSort"), so -> so.withShouldGenerate(ShouldGenerate.Always))
                .with(
                    schema("_common", "SortOptions"),
                    so -> so.withMappedType(t -> t.withPackage(Types.Client.OpenSearch._Types.PACKAGE).withName("SortOptions"))
                )
                .with(
                    schema("_common", "SortCombinations"),
                    so -> so.withMappedType(t -> t.withPackage(Types.Client.OpenSearch._Types.PACKAGE).withName("SortOptions"))
                )

                .with(
                    schema("_common", "GetStats"),
                    so -> so.withProperties(
                        p -> p.with("getTime", po -> po.withIgnore(true)).with("time", po -> po.withAliases(Set.of("getTime")))
                    )
                )
                .with(schema("_common", "PhaseTook"), so -> so.withShouldGenerate(ShouldGenerate.Always))
                .with(
                    schema("_common", "FieldSort"),
                    so -> so.withMappedType(t -> t.withPackage(Types.Client.OpenSearch._Types.PACKAGE).withName("FieldSort"))
                )

                .with(schema("_common.aggregations", "Aggregate"), so -> so.withShouldGenerate(ShouldGenerate.Always))
                .with(schema("_common.aggregations", "Aggregation"), so -> so.withClassName("AggregationBase"))
                .with(
                    schema("_common.aggregations", "AggregationContainer"),
                    so -> so.withClassName("Aggregation").withShouldGenerate(ShouldGenerate.Always)
                )
                .with(
                    schema("_common.aggregations", "AggregationContainer").append("allOf", "0"),
                    so -> so.withProperties(
                        p -> p.with("aggregations", po -> po.withAliases(Set.of("aggs"))).with("aggs", po -> po.withIgnore(true))
                    )
                )

                .with(schema("_common.query_dsl", "FunctionScoreContainer"), so -> so.withClassName("FunctionScore"))

                .with(schema("_common.query_dsl", "IntervalsContainer"), so -> so.withClassName("Intervals"))

                .with(
                    schema("_common.query_dsl", "QueryBase"),
                    so -> so.withProperties(p -> p.with("_name", po -> po.withName("queryName")))
                )

                .with(schema("_common.query_dsl", "QueryContainer"), so -> so.withClassName("Query"))
                .with(
                    schema("_common.query_dsl", "RangeQuery").append("allOf", "1"),
                    so -> so.withProperties(
                        p -> p.with("from", po -> po.withMappedType(Types.Client.Json.JsonData))
                            .with("to", po -> po.withMappedType(Types.Client.Json.JsonData))
                    )
                )

                .with(schema("_core.mtermvectors", "Operation"), so -> so.withClassName("MultiTermVectorsOperation"))
                .with(schema("_core.mtermvectors", "TermVectorsResult"), so -> so.withClassName("MultiTermVectorsResult"))

                .with(schema("_core.reindex", "Source"), so -> so.withProperties(p -> p.with("_source", po -> po.withName("sourceFields"))))

                .with(
                    schema("_core.search", "SourceFilter").append("oneOf", "1"),
                    so -> so.withAliasProvider(k -> k.endsWith("cludes") ? Set.of(k.substring(0, k.length() - 1)) : null)
                )

                .with(schema("_core.search", "PhraseSuggestOption"), so -> so.withShouldGenerate(ShouldGenerate.Always))
                .with(schema("_core.search", "Profile"), so -> so.withShouldGenerate(ShouldGenerate.Always))
                .with(schema("_core.search", "NestedIdentity"), so -> so.withShouldGenerate(ShouldGenerate.Always))
                .with(schema("_core.search", "Rescore"), so -> so.withShouldGenerate(ShouldGenerate.Always))
                .with(schema("_core.search", "SearchResult"), so -> so.withShouldGenerate(ShouldGenerate.Never))
                .with(schema("_core.search", "Suggest"), so -> so.withShouldGenerate(ShouldGenerate.Never))
                .with(schema("_core.search", "Suggester"), so -> so.withShouldGenerate(ShouldGenerate.Always))
                .with(schema("_core.search", "TermSuggestOption"), so -> so.withShouldGenerate(ShouldGenerate.Always))
                .with(
                    schema("_core.search", "HitsMetadata"),
                    so -> so.withProperties(
                        p -> p.with(
                            "total",
                            po -> po.withMappedType(
                                Type.builder().withPackage(Types.Client.OpenSearch.PACKAGE + ".core.search").withName("TotalHits").build()
                            )
                        )
                    )
                )
                .with(schema("_core.search", "TotalHits"), so -> so.withShouldGenerate(ShouldGenerate.Always))
                .with(schema("_core.search", "TrackHits"), so -> so.withShouldGenerate(ShouldGenerate.Always))

                .with(schema("cluster.health", "Level"), so -> so.withClassName("ClusterHealthLevel"))
                .with(schema("cluster.reroute", "Metric"), so -> so.withClassName("ClusterRerouteMetric"))
                .with(schema("cluster.state", "Metric"), so -> so.withClassName("ClusterStateMetric"))

                .with(schema("indices._common", "IndexSettings"), so -> so.withAliasProvider(k -> {
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

                .with(schema("indices.stats", "Metric"), so -> so.withClassName("IndicesStatsMetric"))

                .with(schema("ingest._common", "ProcessorContainer"), so -> so.withClassName("Processor"))

                .with(
                    schema("nodes._common", "NodesResponseBase"),
                    so -> so.withProperties(p -> p.with("_nodes", po -> po.withName("nodeStats")))
                )
                .with(schema("nodes.info", "Metric"), so -> so.withClassName("NodesInfoMetric"))
                .with(schema("nodes.stats", "IndexMetric"), so -> so.withClassName("NodesStatsIndexMetric"))
                .with(schema("nodes.stats", "Metric"), so -> so.withClassName("NodesStatsMetric"))
                .with(schema("nodes.usage", "Metric"), so -> so.withClassName("NodesUsageMetric"))

                .with(requestBodySchema("scroll"), so -> so.withProperties(p -> p.with("scroll_id", po -> po.withRequired(true))))
                .with(
                    requestBodySchema("search"),
                    so -> so.withProperties(
                        p -> p.with("aggregations", po -> po.withAliases(Set.of("aggs"))).with("aggs", po -> po.withIgnore(true))
                    )
                )

                // For backwards compatibility in ML namespace, keep these as plain strings instead of enums
                .with(schema("ml._common", "AgentType"), so -> so.withMappedType(Types.Java.Lang.String))
                .with(schema("ml._common", "ByteOrder"), so -> so.withMappedType(Types.Java.Lang.String))
                .with(schema("ml._common", "ColumnType"), so -> so.withMappedType(Types.Java.Lang.String))
                .with(schema("ml._common", "ConnectorProtocol"), so -> so.withMappedType(Types.Java.Lang.String))
                .with(schema("ml._common", "GuardrailsType"), so -> so.withMappedType(Types.Java.Lang.String))
                .with(schema("ml._common", "ModelGroupAccessMode"), so -> so.withMappedType(Types.Java.Lang.String))
                .with(schema("ml._common", "ModelState"), so -> so.withMappedType(Types.Java.Lang.String))
                .with(schema("ml._common", "MlIndexStatus"), so -> so.withMappedType(Types.Java.Lang.String))
                .with(schema("ml._common", "MlResultDataType"), so -> so.withMappedType(Types.Java.Lang.String))
                .with(schema("ml._common", "MlStatName"), so -> so.withMappedType(Types.Java.Lang.String))
                .with(schema("ml._common", "MlTaskType"), so -> so.withMappedType(Types.Java.Lang.String))
                .with(schema("ml._common", "RateLimiterUnit"), so -> so.withMappedType(Types.Java.Lang.String))
                .with(schema("ml._common", "TaskState"), so -> so.withMappedType(Types.Java.Lang.String))
                .with(schema("ml._common", "ToolName"), so -> so.withMappedType(Types.Java.Lang.String))
                .with(
                    parameterSchema(OperationGroup.from("ml.get_stats"), In.Path, "stat"),
                    so -> so.withMappedType(Types.Java.Lang.String)
                )
        )
        .build();

    @Nonnull
    private final Map<OperationGroup, OperationOverride> operations;
    @Nonnull
    private final Map<JsonPointer, SchemaOverride> schemas;

    private Overrides(Builder builder) {
        this.operations = builder.operations != null ? Collections.unmodifiableMap(builder.operations) : Collections.emptyMap();
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
    public Optional<OperationOverride> getOperation(@Nonnull OperationGroup group) {
        return Optional.ofNullable(operations.get(group));
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends ObjectBuilderBase<Overrides, Builder> {
        @Nullable
        private Map<OperationGroup, OperationOverride> operations;
        @Nullable
        private Map<JsonPointer, SchemaOverride> schemas;

        private Builder() {}

        @Nonnull
        @Override
        protected Overrides construct() {
            return new Overrides(this);
        }

        @Nonnull
        public Builder withOperations(
            @Nonnull Function<OperationOverride.MapBuilder, ObjectBuilder<Map<OperationGroup, OperationOverride>>> fn
        ) {
            this.operations = Objects.requireNonNull(fn, "fn must not be null").apply(OperationOverride.mapBuilder()).build();
            return this;
        }

        @Nonnull
        public Builder withSchemas(@Nonnull Function<SchemaOverride.MapBuilder, ObjectBuilder<Map<JsonPointer, SchemaOverride>>> fn) {
            this.schemas = Objects.requireNonNull(fn, "fn must not be null").apply(SchemaOverride.mapBuilder()).build();
            return this;
        }
    }
}
