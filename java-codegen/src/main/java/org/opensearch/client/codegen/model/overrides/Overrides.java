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
import org.opensearch.client.codegen.model.OperationGroup;
import org.opensearch.client.codegen.model.Types;
import org.opensearch.client.codegen.openapi.JsonPointer;
import org.opensearch.client.codegen.openapi.OpenApiSchema;
import org.opensearch.client.codegen.utils.builder.ObjectBuilder;
import org.opensearch.client.codegen.utils.builder.ObjectBuilderBase;

public class Overrides {
    private static JsonPointer schema(String namespace, String name) {
        return OpenApiSchema.COMPONENTS_SCHEMAS.append(namespace + OpenApiSchema.NAMESPACE_NAME_SEPARATOR + name);
    }

    public static final Overrides OVERRIDES = builder().withOperations(
        o -> o.with(
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
                .with(schema("_common", "Duration"), so -> so.withMappedType(Types.Client.OpenSearch._Types.Time))
                .with(schema("_common", "DurationLarge"), so -> so.withMappedType(Types.Client.OpenSearch._Types.Time))
                .with(schema("_common", "FieldValue"), so -> so.withMappedType(Types.Client.OpenSearch._Types.FieldValue))
                .with(schema("_common", "StringifiedBoolean"), so -> so.withMappedType(Types.Primitive.Boolean))
                .with(schema("_common", "StringifiedDouble"), so -> so.withMappedType(Types.Primitive.Double))
                .with(schema("_common", "StringifiedInteger"), so -> so.withMappedType(Types.Primitive.Int))
                .with(schema("_common", "StringifiedLong"), so -> so.withMappedType(Types.Primitive.Long))
                .with(schema("_common", "StringifiedEpochTimeUnitMillis"), so -> so.withMappedType(Types.Primitive.Long))

                .with(schema("_common", "DistanceUnit"), so -> so.withShouldGenerate(ShouldGenerate.Always))
                .with(schema("_common", "GeoBounds"), so -> so.withShouldGenerate(ShouldGenerate.Always))
                .with(schema("_common", "GeoDistanceType"), so -> so.withShouldGenerate(ShouldGenerate.Always))
                .with(schema("_common", "GeoShapeRelation"), so -> so.withShouldGenerate(ShouldGenerate.Always))

                .with(schema("_common", "ScriptSort"), so -> so.withShouldGenerate(ShouldGenerate.Always))
                .with(
                    schema("_common", "SortOptions"),
                    so -> so.withMappedType(t -> t.withPackage(Types.Client.OpenSearch._Types.PACKAGE).withName("SortOptions"))
                )

                .with(schema("_common", "GetStats"), so -> so.withProperties(p -> p.with("getTime", po -> po.withName("time"))))

                .with(schema("_common", "EmptyObject"), so -> so.withShouldGenerate(ShouldGenerate.Never))

                .with(schema("_common.aggregations", "Aggregation"), so -> so.withClassName("AggregationBase"))
                .with(
                    schema("_common.aggregations", "AggregationContainer"),
                    so -> so.withClassName("Aggregation").withShouldGenerate(ShouldGenerate.Always)
                )
                .with(
                    schema("_common.aggregations", "AggregationContainer").append("allOf", "0"),
                    so -> so.withProperties(p -> p.with("aggregations", po -> po.withAliases(Set.of("aggs"))))
                )
                .with(
                    schema("_common.aggregations", "BucketsQueryContainer"),
                    so -> so.withMappedType(
                        Types.Client.OpenSearch._Types.Aggregations.Buckets(Types.Client.OpenSearch._Types.QueryDsl.Query)
                    )
                )
                .with(
                    schema("_common.aggregations", "ExtendedBoundsdouble"),
                    so -> so.withMappedType(Types.Client.OpenSearch._Types.Aggregations.ExtendedBounds(Types.Java.Lang.Double))
                )
                .with(
                    schema("_common.aggregations", "ExtendedBoundsFieldDateMath"),
                    so -> so.withMappedType(
                        Types.Client.OpenSearch._Types.Aggregations.ExtendedBounds(
                            Types.Client.OpenSearch._Types.Aggregations.FieldDateMath
                        )
                    )
                )
                .with(schema("_common.aggregations", "InferenceConfigContainer"), so -> so.withClassName("InferenceConfig"))
                .with(schema("_common.aggregations", "PercentageScoreHeuristic"), so -> so.withShouldGenerate(ShouldGenerate.Never))

                // TODO: Remove this once figuring out how best to handle these schemas
//                .with(schema("_common.query_dsl", "DecayFunction"), so -> so.withShouldGenerate(ShouldGenerate.Never))
                .with(
                    schema("_common.query_dsl", "FunctionScoreContainer"),
                    so -> so/*.withShouldGenerate(ShouldGenerate.Never)*/.withClassName("FunctionScore")
                )
//                .with(schema("_common.query_dsl", "GeoBoundingBoxQuery"), so -> so.withShouldGenerate(ShouldGenerate.Never))
//                .with(schema("_common.query_dsl", "GeoDistanceQuery"), so -> so.withShouldGenerate(ShouldGenerate.Never))
//                .with(schema("_common.query_dsl", "GeoPolygonQuery"), so -> so.withShouldGenerate(ShouldGenerate.Never))
//                .with(schema("_common.query_dsl", "GeoShapeQuery"), so -> so.withShouldGenerate(ShouldGenerate.Never))
//                .with(schema("_common.query_dsl", "RangeQuery"), so -> so.withShouldGenerate(ShouldGenerate.Never))
//                .with(schema("_common.query_dsl", "RankFeatureFunctionLinear"), so -> so.withShouldGenerate(ShouldGenerate.Never))
//                .with(schema("_common.query_dsl", "RankFeatureFunctionLogarithm"), so -> so.withShouldGenerate(ShouldGenerate.Never))
//                .with(schema("_common.query_dsl", "RankFeatureFunctionSaturation"), so -> so.withShouldGenerate(ShouldGenerate.Never))
//                .with(schema("_common.query_dsl", "RankFeatureFunctionSigmoid"), so -> so.withShouldGenerate(ShouldGenerate.Never))
                .with(
                    schema("_common.query_dsl", "SpanGapQuery"),
                    so -> so.withMappedType(
                        t -> t.withPackage(Types.Client.OpenSearch._Types.PACKAGE + ".query_dsl").withName("SpanGapQuery")
                    )
                )
//                .with(schema("_common.query_dsl", "TermsQuery"), so -> so.withShouldGenerate(ShouldGenerate.Never))
                .with(schema("_common.query_dsl", "TermsQueryField"), so -> so.withShouldGenerate(ShouldGenerate.Always))
//                .with(schema("_common.query_dsl", "XyShapeQuery"), so -> so.withShouldGenerate(ShouldGenerate.Never))

                .with(schema("_common.query_dsl", "FieldValueFactorModifier"), so -> so.withShouldGenerate(ShouldGenerate.Always))
                .with(schema("_common.query_dsl", "IntervalsContainer"), so -> so.withClassName("Intervals"))

                .with(
                    schema("_common.query_dsl", "QueryBase"),
                    so -> so.withProperties(p -> p.with("_name", po -> po.withName("queryName")))
                )

                .with(schema("_common.query_dsl", "QueryContainer"), so -> so.withClassName("Query"))

                .with(schema("_core.mtermvectors", "Operation"), so -> so.withClassName("MultiTermVectorsOperation"))
                .with(schema("_core.mtermvectors", "TermVectorsResult"), so -> so.withClassName("MultiTermVectorsResult"))

                .with(schema("_core.reindex", "Source"), so -> so.withProperties(p -> p.with("_source", po -> po.withName("sourceFields"))))

                .with(
                    schema("_core.search", "SourceFilter").append("oneOf", "1"),
                    so -> so.withAliasProvider(k -> k.endsWith("cludes") ? Set.of(k.substring(0, k.length() - 1)) : null)
                )

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
