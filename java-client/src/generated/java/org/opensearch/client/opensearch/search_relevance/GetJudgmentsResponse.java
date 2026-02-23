/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.search_relevance;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.ExternallyTaggedUnion;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.NamedDeserializer;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.ClusterStatistics;
import org.opensearch.client.opensearch._types.PhaseTook;
import org.opensearch.client.opensearch._types.ShardStatistics;
import org.opensearch.client.opensearch._types.aggregations.Aggregate;
import org.opensearch.client.opensearch.core.search.HitsMetadata;
import org.opensearch.client.opensearch.core.search.ProcessorExecutionDetail;
import org.opensearch.client.opensearch.core.search.Profile;
import org.opensearch.client.opensearch.core.search.Suggest;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_relevance.get_judgments.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetJudgmentsResponse<TDocument>
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetJudgmentsResponse.Builder<TDocument>, GetJudgmentsResponse<TDocument>> {

    @Nonnull
    private final Map<String, Aggregate> aggregations;

    @Nullable
    private final ClusterStatistics clusters;

    @Nonnull
    private final Map<String, JsonData> fields;

    @Nonnull
    private final HitsMetadata<TDocument> hits;

    @Nullable
    private final Integer numReducePhases;

    @Nullable
    private final PhaseTook phaseTook;

    @Nullable
    private final String pitId;

    @Nonnull
    private final List<ProcessorExecutionDetail> processorResults;

    @Nullable
    private final Profile profile;

    @Nullable
    private final String scrollId;

    @Nonnull
    private final ShardStatistics shards;

    @Nonnull
    private final Map<String, List<Suggest<JsonData>>> suggest;

    @Nullable
    private final Boolean terminatedEarly;

    private final boolean timedOut;

    private final long took;

    // ---------------------------------------------------------------------------------------------

    private GetJudgmentsResponse(Builder<TDocument> builder) {
        this.aggregations = ApiTypeHelper.unmodifiable(builder.aggregations);
        this.clusters = builder.clusters;
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.hits = ApiTypeHelper.requireNonNull(builder.hits, this, "hits");
        this.numReducePhases = builder.numReducePhases;
        this.phaseTook = builder.phaseTook;
        this.pitId = builder.pitId;
        this.processorResults = ApiTypeHelper.unmodifiable(builder.processorResults);
        this.profile = builder.profile;
        this.scrollId = builder.scrollId;
        this.shards = ApiTypeHelper.requireNonNull(builder.shards, this, "shards");
        this.suggest = ApiTypeHelper.unmodifiable(builder.suggest);
        this.terminatedEarly = builder.terminatedEarly;
        this.timedOut = ApiTypeHelper.requireNonNull(builder.timedOut, this, "timedOut");
        this.took = ApiTypeHelper.requireNonNull(builder.took, this, "took");
    }

    public static <TDocument> GetJudgmentsResponse<TDocument> of(
        Function<GetJudgmentsResponse.Builder<TDocument>, ObjectBuilder<GetJudgmentsResponse<TDocument>>> fn
    ) {
        return fn.apply(new Builder<>()).build();
    }

    /**
     * API name: {@code aggregations}
     */
    @Nonnull
    public final Map<String, Aggregate> aggregations() {
        return this.aggregations;
    }

    /**
     * API name: {@code _clusters}
     */
    @Nullable
    public final ClusterStatistics clusters() {
        return this.clusters;
    }

    /**
     * API name: {@code fields}
     */
    @Nonnull
    public final Map<String, JsonData> fields() {
        return this.fields;
    }

    /**
     * Required - API name: {@code hits}
     */
    @Nonnull
    public final HitsMetadata<TDocument> hits() {
        return this.hits;
    }

    /**
     * API name: {@code num_reduce_phases}
     */
    @Nullable
    public final Integer numReducePhases() {
        return this.numReducePhases;
    }

    /**
     * API name: {@code phase_took}
     */
    @Nullable
    public final PhaseTook phaseTook() {
        return this.phaseTook;
    }

    /**
     * API name: {@code pit_id}
     */
    @Nullable
    public final String pitId() {
        return this.pitId;
    }

    /**
     * API name: {@code processor_results}
     */
    @Nonnull
    public final List<ProcessorExecutionDetail> processorResults() {
        return this.processorResults;
    }

    /**
     * API name: {@code profile}
     */
    @Nullable
    public final Profile profile() {
        return this.profile;
    }

    /**
     * API name: {@code _scroll_id}
     */
    @Nullable
    public final String scrollId() {
        return this.scrollId;
    }

    /**
     * Required - API name: {@code _shards}
     */
    @Nonnull
    public final ShardStatistics shards() {
        return this.shards;
    }

    /**
     * API name: {@code suggest}
     */
    @Nonnull
    public final Map<String, List<Suggest<JsonData>>> suggest() {
        return this.suggest;
    }

    /**
     * API name: {@code terminated_early}
     */
    @Nullable
    public final Boolean terminatedEarly() {
        return this.terminatedEarly;
    }

    /**
     * Required - API name: {@code timed_out}
     */
    public final boolean timedOut() {
        return this.timedOut;
    }

    /**
     * Required - API name: {@code took}
     */
    public final long took() {
        return this.took;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (ApiTypeHelper.isDefined(this.aggregations)) {
            generator.writeKey("aggregations");
            ExternallyTaggedUnion.serializeTypedKeys(this.aggregations, generator, mapper);
        }

        if (this.clusters != null) {
            generator.writeKey("_clusters");
            this.clusters.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.fields)) {
            generator.writeKey("fields");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.fields.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("hits");
        this.hits.serialize(generator, mapper);

        if (this.numReducePhases != null) {
            generator.writeKey("num_reduce_phases");
            generator.write(this.numReducePhases);
        }

        if (this.phaseTook != null) {
            generator.writeKey("phase_took");
            this.phaseTook.serialize(generator, mapper);
        }

        if (this.pitId != null) {
            generator.writeKey("pit_id");
            generator.write(this.pitId);
        }

        if (ApiTypeHelper.isDefined(this.processorResults)) {
            generator.writeKey("processor_results");
            generator.writeStartArray();
            for (ProcessorExecutionDetail item0 : this.processorResults) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.profile != null) {
            generator.writeKey("profile");
            this.profile.serialize(generator, mapper);
        }

        if (this.scrollId != null) {
            generator.writeKey("_scroll_id");
            generator.write(this.scrollId);
        }

        generator.writeKey("_shards");
        this.shards.serialize(generator, mapper);

        if (ApiTypeHelper.isDefined(this.suggest)) {
            generator.writeKey("suggest");
            ExternallyTaggedUnion.serializeTypedKeysArray(this.suggest, generator, mapper);
        }

        if (this.terminatedEarly != null) {
            generator.writeKey("terminated_early");
            generator.write(this.terminatedEarly);
        }

        generator.writeKey("timed_out");
        generator.write(this.timedOut);

        generator.writeKey("took");
        generator.write(this.took);
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder<TDocument> toBuilder() {
        return new Builder<>(this);
    }

    @Nonnull
    public static <TDocument> Builder builder() {
        return new Builder<>();
    }

    /**
     * Builder for {@link GetJudgmentsResponse}.
     */
    public static class Builder<TDocument> extends ObjectBuilderBase
        implements
            CopyableBuilder<Builder<TDocument>, GetJudgmentsResponse<TDocument>> {
        @Nullable
        private Map<String, Aggregate> aggregations;
        @Nullable
        private ClusterStatistics clusters;
        @Nullable
        private Map<String, JsonData> fields;
        private HitsMetadata<TDocument> hits;
        @Nullable
        private Integer numReducePhases;
        @Nullable
        private PhaseTook phaseTook;
        @Nullable
        private String pitId;
        @Nullable
        private List<ProcessorExecutionDetail> processorResults;
        @Nullable
        private Profile profile;
        @Nullable
        private String scrollId;
        private ShardStatistics shards;
        @Nullable
        private Map<String, List<Suggest<JsonData>>> suggest;
        @Nullable
        private Boolean terminatedEarly;
        private Boolean timedOut;
        private Long took;

        public Builder() {}

        private Builder(GetJudgmentsResponse<TDocument> o) {
            this.aggregations = _mapCopy(o.aggregations);
            this.clusters = o.clusters;
            this.fields = _mapCopy(o.fields);
            this.hits = o.hits;
            this.numReducePhases = o.numReducePhases;
            this.phaseTook = o.phaseTook;
            this.pitId = o.pitId;
            this.processorResults = _listCopy(o.processorResults);
            this.profile = o.profile;
            this.scrollId = o.scrollId;
            this.shards = o.shards;
            this.suggest = _mapCopy(o.suggest);
            this.terminatedEarly = o.terminatedEarly;
            this.timedOut = o.timedOut;
            this.took = o.took;
        }

        private Builder(Builder<TDocument> o) {
            this.aggregations = _mapCopy(o.aggregations);
            this.clusters = o.clusters;
            this.fields = _mapCopy(o.fields);
            this.hits = o.hits;
            this.numReducePhases = o.numReducePhases;
            this.phaseTook = o.phaseTook;
            this.pitId = o.pitId;
            this.processorResults = _listCopy(o.processorResults);
            this.profile = o.profile;
            this.scrollId = o.scrollId;
            this.shards = o.shards;
            this.suggest = _mapCopy(o.suggest);
            this.terminatedEarly = o.terminatedEarly;
            this.timedOut = o.timedOut;
            this.took = o.took;
        }

        @Override
        @Nonnull
        public Builder<TDocument> copy() {
            return new Builder<>(this);
        }

        /**
         * API name: {@code aggregations}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>aggregations</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> aggregations(Map<String, Aggregate> map) {
            this.aggregations = _mapPutAll(this.aggregations, map);
            return this;
        }

        /**
         * API name: {@code aggregations}
         *
         * <p>
         * Adds an entry to <code>aggregations</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> aggregations(String key, Aggregate value) {
            this.aggregations = _mapPut(this.aggregations, key, value);
            return this;
        }

        /**
         * API name: {@code aggregations}
         *
         * <p>
         * Adds a value to <code>aggregations</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> aggregations(String key, Function<Aggregate.Builder, ObjectBuilder<Aggregate>> fn) {
            return aggregations(key, fn.apply(new Aggregate.Builder()).build());
        }

        /**
         * API name: {@code _clusters}
         */
        @Nonnull
        public final Builder<TDocument> clusters(@Nullable ClusterStatistics value) {
            this.clusters = value;
            return this;
        }

        /**
         * API name: {@code _clusters}
         */
        @Nonnull
        public final Builder<TDocument> clusters(Function<ClusterStatistics.Builder, ObjectBuilder<ClusterStatistics>> fn) {
            return clusters(fn.apply(new ClusterStatistics.Builder()).build());
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> fields(Map<String, JsonData> map) {
            this.fields = _mapPutAll(this.fields, map);
            return this;
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds an entry to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> fields(String key, JsonData value) {
            this.fields = _mapPut(this.fields, key, value);
            return this;
        }

        /**
         * Required - API name: {@code hits}
         */
        @Nonnull
        public final Builder<TDocument> hits(HitsMetadata<TDocument> value) {
            this.hits = value;
            return this;
        }

        /**
         * Required - API name: {@code hits}
         */
        @Nonnull
        public final Builder<TDocument> hits(Function<HitsMetadata.Builder<TDocument>, ObjectBuilder<HitsMetadata<TDocument>>> fn) {
            return hits(fn.apply(new HitsMetadata.Builder<TDocument>()).build());
        }

        /**
         * API name: {@code num_reduce_phases}
         */
        @Nonnull
        public final Builder<TDocument> numReducePhases(@Nullable Integer value) {
            this.numReducePhases = value;
            return this;
        }

        /**
         * API name: {@code phase_took}
         */
        @Nonnull
        public final Builder<TDocument> phaseTook(@Nullable PhaseTook value) {
            this.phaseTook = value;
            return this;
        }

        /**
         * API name: {@code phase_took}
         */
        @Nonnull
        public final Builder<TDocument> phaseTook(Function<PhaseTook.Builder, ObjectBuilder<PhaseTook>> fn) {
            return phaseTook(fn.apply(new PhaseTook.Builder()).build());
        }

        /**
         * API name: {@code pit_id}
         */
        @Nonnull
        public final Builder<TDocument> pitId(@Nullable String value) {
            this.pitId = value;
            return this;
        }

        /**
         * API name: {@code processor_results}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>processorResults</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> processorResults(List<ProcessorExecutionDetail> list) {
            this.processorResults = _listAddAll(this.processorResults, list);
            return this;
        }

        /**
         * API name: {@code processor_results}
         *
         * <p>
         * Adds one or more values to <code>processorResults</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> processorResults(ProcessorExecutionDetail value, ProcessorExecutionDetail... values) {
            this.processorResults = _listAdd(this.processorResults, value, values);
            return this;
        }

        /**
         * API name: {@code processor_results}
         *
         * <p>
         * Adds a value to <code>processorResults</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> processorResults(
            Function<ProcessorExecutionDetail.Builder, ObjectBuilder<ProcessorExecutionDetail>> fn
        ) {
            return processorResults(fn.apply(new ProcessorExecutionDetail.Builder()).build());
        }

        /**
         * API name: {@code profile}
         */
        @Nonnull
        public final Builder<TDocument> profile(@Nullable Profile value) {
            this.profile = value;
            return this;
        }

        /**
         * API name: {@code profile}
         */
        @Nonnull
        public final Builder<TDocument> profile(Function<Profile.Builder, ObjectBuilder<Profile>> fn) {
            return profile(fn.apply(new Profile.Builder()).build());
        }

        /**
         * API name: {@code _scroll_id}
         */
        @Nonnull
        public final Builder<TDocument> scrollId(@Nullable String value) {
            this.scrollId = value;
            return this;
        }

        /**
         * Required - API name: {@code _shards}
         */
        @Nonnull
        public final Builder<TDocument> shards(ShardStatistics value) {
            this.shards = value;
            return this;
        }

        /**
         * Required - API name: {@code _shards}
         */
        @Nonnull
        public final Builder<TDocument> shards(Function<ShardStatistics.Builder, ObjectBuilder<ShardStatistics>> fn) {
            return shards(fn.apply(new ShardStatistics.Builder()).build());
        }

        /**
         * API name: {@code suggest}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>suggest</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> suggest(Map<String, List<Suggest<JsonData>>> map) {
            this.suggest = _mapPutAll(this.suggest, map);
            return this;
        }

        /**
         * API name: {@code suggest}
         *
         * <p>
         * Adds an entry to <code>suggest</code>.
         * </p>
         */
        @Nonnull
        public final Builder<TDocument> suggest(String key, List<Suggest<JsonData>> value) {
            this.suggest = _mapPut(this.suggest, key, value);
            return this;
        }

        /**
         * API name: {@code terminated_early}
         */
        @Nonnull
        public final Builder<TDocument> terminatedEarly(@Nullable Boolean value) {
            this.terminatedEarly = value;
            return this;
        }

        /**
         * Required - API name: {@code timed_out}
         */
        @Nonnull
        public final Builder<TDocument> timedOut(boolean value) {
            this.timedOut = value;
            return this;
        }

        /**
         * Required - API name: {@code took}
         */
        @Nonnull
        public final Builder<TDocument> took(long value) {
            this.took = value;
            return this;
        }

        /**
         * Builds a {@link GetJudgmentsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetJudgmentsResponse<TDocument> build() {
            _checkSingleUse();

            return new GetJudgmentsResponse<>(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Create a JSON deserializer for GetJudgmentsResponse.
     */
    public static <TDocument> JsonpDeserializer<GetJudgmentsResponse<TDocument>> createGetJudgmentsResponseDeserializer(
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        return ObjectBuilderDeserializer.createForObject(
            Builder<TDocument>::new,
            op -> GetJudgmentsResponse.setupGetJudgmentsResponseDeserializer(op, tDocumentDeserializer)
        );
    }

    /**
     * Json deserializer for {@link GetJudgmentsResponse} based on named deserializers provided by the calling {@code JsonMapper}.
     */
    public static final JsonpDeserializer<GetJudgmentsResponse<Object>> _DESERIALIZER = createGetJudgmentsResponseDeserializer(
        new NamedDeserializer<>("org.opensearch.client:Deserializer:search_relevance.get_judgments.TDocument")
    );

    protected static <TDocument> void setupGetJudgmentsResponseDeserializer(
        ObjectDeserializer<GetJudgmentsResponse.Builder<TDocument>> op,
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        op.add(Builder::aggregations, Aggregate._TYPED_KEYS_DESERIALIZER, "aggregations");
        op.add(Builder::clusters, ClusterStatistics._DESERIALIZER, "_clusters");
        op.add(Builder::fields, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "fields");
        op.add(Builder::hits, HitsMetadata.createHitsMetadataDeserializer(tDocumentDeserializer), "hits");
        op.add(Builder::numReducePhases, JsonpDeserializer.integerDeserializer(), "num_reduce_phases");
        op.add(Builder::phaseTook, PhaseTook._DESERIALIZER, "phase_took");
        op.add(Builder::pitId, JsonpDeserializer.stringDeserializer(), "pit_id");
        op.add(Builder::processorResults, JsonpDeserializer.arrayDeserializer(ProcessorExecutionDetail._DESERIALIZER), "processor_results");
        op.add(Builder::profile, Profile._DESERIALIZER, "profile");
        op.add(Builder::scrollId, JsonpDeserializer.stringDeserializer(), "_scroll_id");
        op.add(Builder::shards, ShardStatistics._DESERIALIZER, "_shards");
        op.add(
            Builder::suggest,
            ExternallyTaggedUnion.arrayDeserializer(Suggest.createSuggestDeserializer(JsonData._DESERIALIZER)),
            "suggest"
        );
        op.add(Builder::terminatedEarly, JsonpDeserializer.booleanDeserializer(), "terminated_early");
        op.add(Builder::timedOut, JsonpDeserializer.booleanDeserializer(), "timed_out");
        op.add(Builder::took, JsonpDeserializer.longDeserializer(), "took");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.aggregations);
        result = 31 * result + Objects.hashCode(this.clusters);
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + this.hits.hashCode();
        result = 31 * result + Objects.hashCode(this.numReducePhases);
        result = 31 * result + Objects.hashCode(this.phaseTook);
        result = 31 * result + Objects.hashCode(this.pitId);
        result = 31 * result + Objects.hashCode(this.processorResults);
        result = 31 * result + Objects.hashCode(this.profile);
        result = 31 * result + Objects.hashCode(this.scrollId);
        result = 31 * result + this.shards.hashCode();
        result = 31 * result + Objects.hashCode(this.suggest);
        result = 31 * result + Objects.hashCode(this.terminatedEarly);
        result = 31 * result + Boolean.hashCode(this.timedOut);
        result = 31 * result + Long.hashCode(this.took);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetJudgmentsResponse<?> other = (GetJudgmentsResponse<?>) o;
        return Objects.equals(this.aggregations, other.aggregations)
            && Objects.equals(this.clusters, other.clusters)
            && Objects.equals(this.fields, other.fields)
            && this.hits.equals(other.hits)
            && Objects.equals(this.numReducePhases, other.numReducePhases)
            && Objects.equals(this.phaseTook, other.phaseTook)
            && Objects.equals(this.pitId, other.pitId)
            && Objects.equals(this.processorResults, other.processorResults)
            && Objects.equals(this.profile, other.profile)
            && Objects.equals(this.scrollId, other.scrollId)
            && this.shards.equals(other.shards)
            && Objects.equals(this.suggest, other.suggest)
            && Objects.equals(this.terminatedEarly, other.terminatedEarly)
            && this.timedOut == other.timedOut
            && this.took == other.took;
    }
}
